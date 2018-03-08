package command

import org.spongepowered.api.command.spec.CommandExecutor
import org.spongepowered.api.command.spec.CommandSpec

/**
 * @author karayuu
 */
interface ExcutableCommandImpl : CommandExecutor {
    fun getAlias() : List<String>

    fun getCommandSpec() : CommandSpec
}