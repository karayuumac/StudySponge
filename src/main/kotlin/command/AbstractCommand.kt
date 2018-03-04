package command

import org.spongepowered.api.command.CommandResult
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.command.args.CommandContext
import org.spongepowered.api.command.spec.CommandExecutor
import org.spongepowered.api.command.spec.CommandSpec

/**
 * @author karayuu
 */

/**
 * Commandを抽象化したクラス。
 */
abstract class AbstractCommand : CommandExecutor {
    /**
     * コマンドを実行するためのAlias(/の後の文字列)を取得します。
     */
    abstract fun getAlias(): List<String>

    /**
     * コマンドの仕様を決定する[CommandSpec]を取得します。
     */
    abstract fun getCommandSpec() : CommandSpec

    /**
     * コマンドの動作を取得します。
     */
    abstract override fun execute(src: CommandSource?, args: CommandContext?): CommandResult
}