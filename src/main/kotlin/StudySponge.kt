import com.google.inject.Inject
import command.AbstractCommand
import command.commands.FlagTestCommand
import command.commands.TestCommand
import config.GameConfigManager
import data.BlockPlaceAmountData
import data.BlockPlaceAmountDataBuilder
import data.ImmutableBlockPlaceAmountData
import listener.PlayerBlockBreakListener
import listener.PlayerBlockClickListener
import ninja.leaping.configurate.commented.CommentedConfigurationNode
import ninja.leaping.configurate.loader.ConfigurationLoader
import org.slf4j.Logger
import org.spongepowered.api.Sponge
import org.spongepowered.api.config.DefaultConfig
import org.spongepowered.api.data.DataRegistration
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.Order
import org.spongepowered.api.event.block.ChangeBlockEvent
import org.spongepowered.api.event.cause.EventContextKeys
import org.spongepowered.api.event.game.state.*
import org.spongepowered.api.plugin.Plugin
import org.spongepowered.api.plugin.PluginContainer
import re.tutorial.ImmutableMappedData
import re.tutorial.MappedData
import re.tutorial.MappedDataBuilder
import java.io.IOException
import java.nio.file.Path

/**
 * Created by karayuu on 2018/03/04
 */

@Plugin(
        id = StudySponge.ID,
        name = "StudySponge",
        version = "1.0.0"
)
class StudySponge {

    @Inject
    @DefaultConfig(sharedRoot = false)
    private lateinit var defaultConfig: Path

    @Inject
    @DefaultConfig(sharedRoot = false)
    private lateinit var loader: ConfigurationLoader<CommentedConfigurationNode>

    @Inject
    @DefaultConfig(sharedRoot = false)
    private lateinit var configDir: Path

    private lateinit var config: CommentedConfigurationNode

    /** logger */
    @Inject
    private lateinit var logger: Logger

    @Inject
    lateinit var container: PluginContainer

    companion object {
        /** ゲームの設定 */
        lateinit var gameConf: GameConfig

        lateinit var logger: Logger

        const val ID = "studysponge"
    }

    @Listener
    fun onPreInitialization(event: GamePreInitializationEvent) {
        StudySponge.logger = logger

        try {
            config = loader.load()

            if (!defaultConfig.toFile().exists()) {
                config.getNode("test").value = true
                logger.info("defaultConfigは[$defaultConfig]でNode:[test]に[${config.getNode("test")}]をセットしました。")
                loader.save(config)
            }
        } catch (e: IOException) {
            logger.info("Unable to load default config.")
            logger.info("Show the stacktrace below.")
            e.stackTrace
        }

        val conf = GameConfigManager.setUp()
    }

    @Listener
    fun onInitialization(event: GameInitializationEvent) {
        //ここでlistenerの登録
        Sponge.getEventManager().registerListeners(this, PlayerBlockBreakListener())
        Sponge.getEventManager().registerListeners(this, PlayerBlockClickListener())

        //DataManager
        val dataManager = Sponge.getDataManager()

        dataManager.registerContentUpdater(BlockPlaceAmountData::class.java, BlockPlaceAmountDataBuilder.ContentUpdater)

        DataRegistration.builder()
                .dataClass(/* 普通のDataクラス */BlockPlaceAmountData::class.java)
                .immutableClass(/* ImmutableDataクラス */ImmutableBlockPlaceAmountData::class.java)
                .builder(/* DataBuilder */BlockPlaceAmountDataBuilder)
                .manipulatorId(/* id。形式は({manipulator-id|)を標準とする。 */"{place-amount|")
                .dataName("Place")
                .buildAndRegister(container)

        DataRegistration.builder()
                .dataClass(MappedData::class.java)
                .immutableClass(ImmutableMappedData::class.java)
                .builder(MappedDataBuilder)
                .manipulatorId("{mapped-data|")
                .dataName("AllBlockPlace")
                .buildAndRegister(container)
    }

    @Listener(order = Order.POST)
    fun onBlockPlace(event: ChangeBlockEvent.Place) {
        val causePlayer = event.cause.mapNotNull { it as? Player }.firstOrNull() ?: return

        val placeBlockAmount = event.transactions
                .filter { it.isValid }
                .size

        causePlayer.getOrCreate(BlockPlaceAmountData::class.java)
                .map { it + placeBlockAmount }
                .ifPresent {
                    causePlayer.offer(it)
                    println(it.amount)
                }
    }

    @Listener(order = Order.POST)
    fun playerBlockPlaceLogger(event: ChangeBlockEvent.Place) {
        val causePlayer = event.cause.mapNotNull { it as? Player }.firstOrNull() ?: return

        val placedBlockType = event.context.get(EventContextKeys.USED_ITEM).let {
            if (it.isPresent) it.get() else return
        }.type

        val placeAmount = event.transactions
                .filter { it.isValid }
                .size

        val data = causePlayer.getOrCreate(MappedData::class.java).get()
        data.map[placedBlockType.block.get()] = placeAmount
        causePlayer.offer(data)

        logger.info("ブロックタイプ[$placedBlockType],量[${causePlayer.getOrCreate(MappedData::class.java).get().get(placedBlockType.block.get())}]")
    }

    @Listener
    fun onServerStart(event: GameStartedServerEvent) {
        registerCommand(
                TestCommand(),
                FlagTestCommand()
        )

        gameConf = GameConfig
    }

    /**
     * Commandを登録する関数
     */
    private fun registerCommand(vararg commands: AbstractCommand) {
        commands.forEach { that ->
            Sponge.getCommandManager().register(this, that.getCommandSpec(), that.getAlias())
        }
    }
}
/*
class StudySponge {
    @Inject
    private lateinit var logger: Logger

    @Listener
    fun onConstruction(event: GameConstructionEvent) {
        logger.info("(Construction)logger = $logger")
    }

    @Listener
    fun onPreInitialization(event: GamePreInitializationEvent) {
        logger.info("(PreInitialization)logger = $logger")
    }

    @Listener
    fun onInitialization(event: GameInitializationEvent) {
        logger.info("(Initialization)logger = $logger")
    }

    @Listener
    fun onPostInitialization(event: GamePostInitializationEvent) {
        logger.info("(PostInitialization)logger = $logger")
    }

    @Listener
    fun onLoadComplete(event: GameLoadCompleteEvent) {
        logger.info("(LoadComplete)logger = $logger")
    }
}
*/
