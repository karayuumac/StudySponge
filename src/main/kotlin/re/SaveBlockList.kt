/*
package re

import org.spongepowered.api.block.BlockType
import org.spongepowered.api.block.BlockTypes

/**
 * @author karayuu
 */
enum class SaveBlockList(val type: BlockType, val weight: Int) {
    STONE(BlockTypes.STONE, 1),
    ;


}

fun getSaveBlockInitMap() : MutableMap<BlockType, Int> {
    val map = mutableMapOf<BlockType, Int>()

    for (saveBlock in SaveBlockList.values()) {
        map[saveBlock.type] = 0
    }

    return map
}
*/