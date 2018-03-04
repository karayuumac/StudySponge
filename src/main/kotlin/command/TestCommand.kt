package command

import org.spongepowered.api.command.CommandResult
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.command.args.CommandContext
import org.spongepowered.api.command.spec.CommandSpec
import org.spongepowered.api.text.Text

/**
 * @author karayuu
 */
class TestCommand : AbstractCommand() {
    override fun getAlias(): List<String> {
        return listOf("test", "t")
    }
    override fun getCommandSpec(): CommandSpec {
        return CommandSpec.builder()
                .description(Text.of("テスト用ですぞい。AbstractCommandで作成。"))
                .executor(this)
                .build()
    }

    override fun execute(src: CommandSource?, args: CommandContext?): CommandResult {
        src?.sendMessage(Text.of("AbstractCommandで作成できましたね！！"))
        return CommandResult.success()
    }
}