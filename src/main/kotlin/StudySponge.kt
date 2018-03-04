import command.AbstractCommand
import command.commands.FlagTestCommand
import command.commands.TestCommand
import org.slf4j.Logger
import org.spongepowered.api.Sponge
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GameStartedServerEvent
import org.spongepowered.api.plugin.Plugin
import javax.inject.Inject

/**
 * Created by karayuu on 2018/03/04
 */

@Plugin(
        id = "studysponge",
        name = "StudySponge",
        version = "1.0.0"
)
class StudySponge {
    @Inject
    private lateinit var logger: Logger

    companion object {
        /** ゲームの設定 */
        lateinit var gameConf: GameConfig
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
