package listener

import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.block.ChangeBlockEvent
import org.spongepowered.api.text.Text

/**
 * @author karayuu
 */
class PlayerBlockBreakListener {
    @Listener
    fun onPlayerBlockBreak(event: ChangeBlockEvent.Break) {
        val player = event.cause.last(Player::class.java).get()

        player.sendMessage(Text.of("ブロック破壊イベント発生"))
        player.sendMessage(Text.of("${event.transactions}"))
    }
}