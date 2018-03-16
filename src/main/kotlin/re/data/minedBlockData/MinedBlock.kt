/*
package re.data.minedBlockData

import org.spongepowered.api.block.BlockType
import org.spongepowered.api.data.DataContainer
import org.spongepowered.api.data.DataQuery
import org.spongepowered.api.data.DataSerializable
import org.spongepowered.api.data.Queries
import re.data.minedBlockData.impl.MinedBlockBuilder

/**
 * @author karayuu
 */
class MinedBlock(val minedMap: Map<BlockType, Int>) : DataSerializable {
    companion object {
        val BLCOK_MINED_QUERY = DataQuery.of("MinedMap")
    }

    override fun toContainer(): DataContainer {
        return DataContainer.createNew()
                .set(BLCOK_MINED_QUERY, this.minedMap)
                .set(Queries.CONTENT_VERSION, MinedBlockBuilder.CONTENT_VERSION)
    }

    override fun getContentVersion(): Int = MinedBlockBuilder.CONTENT_VERSION
}*/