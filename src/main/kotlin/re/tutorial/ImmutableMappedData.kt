package re.tutorial

import org.spongepowered.api.block.BlockType
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableMappedData

/**
 * @author karayuu
 */
class ImmutableMappedData(val map: MutableMap<BlockType, Int>) :
        AbstractImmutableMappedData<BlockType, Int, ImmutableMappedData, MappedData>(map, Keys.mappedData) {
    override fun getContentVersion(): Int = 1

    override fun asMutable(): MappedData = MappedData(map)
}