package listener

import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.block.InteractBlockEvent
import org.spongepowered.api.event.cause.EventContextKeys
import org.spongepowered.api.item.ItemTypes
import org.spongepowered.api.text.Text

/**
 * Created by karayuu on 2018/03/12
 */
class PlayerBlockClickListener {
    @Listener
    fun onPlayerClickBlock(event: InteractBlockEvent.Primary.MainHand) {
        val player = event.cause.mapNotNull { it as? Player }.firstOrNull() ?: return

        val usedItem = event.context.get(EventContextKeys.USED_ITEM).let {
            if (it.isPresent) {
            it.get()
            } else {
                return
            }
        }

        player.sendMessage(Text.of("クリックしたアイテム:${usedItem.type}"))
        if (usedItem.type == ItemTypes.STICK) {
            player.sendMessage(Text.of("貴方は棒でブロックを左クリックしましたね。(Primary)"))
            player.sendMessage(Text.of("クリックしたブロックは[${event.targetBlock.state.type.name}]ですね。"))
        }
    }
}
