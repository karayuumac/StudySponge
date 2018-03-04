package command.commands

import command.AbstractCommand
import org.spongepowered.api.command.CommandResult
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.command.args.CommandContext
import org.spongepowered.api.command.args.GenericArguments
import org.spongepowered.api.command.spec.CommandSpec
import org.spongepowered.api.text.Text

/**
 * @author karayuu
 */
class FlagTestCommand : AbstractCommand() {
    override fun getAlias(): List<String> {
        return listOf("testforflag")
    }

    override fun getCommandSpec(): CommandSpec {
        return CommandSpec.builder()
                .arguments(GenericArguments.flags().flag("hi")
                        .buildWith(GenericArguments.bool(Text.of("isDebugMode"))))
                .executor(this)
                .build()
    }

    override fun execute(src: CommandSource?, args: CommandContext?): CommandResult {
        if (args?.hasAny("isDebugMode") == true) {
            src?.sendMessage(Text.of("-hiフラグisDebugModeを" +
                    "${args.getOne<Boolean>("isDebugMode")}に変更しました"))
        }
        return CommandResult.success()
    }
}