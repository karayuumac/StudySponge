/*
package re.data.minedBlockData.impl

import com.google.common.collect.ImmutableMap
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.DataView
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder
import org.spongepowered.api.data.persistence.AbstractDataBuilder
import re.data.minedBlockData.ImmutableMinedBlockData
import re.data.minedBlockData.MinedBlock
import re.data.minedBlockData.MinedBlockData
import java.util.*

import data.KeyRepository
import org.spongepowered.api.block.BlockType
import org.spongepowered.api.data.persistence.DataContentUpdater

/**
 * @author karayuu
 */
class MinedBlockDataBuilder : AbstractDataBuilder<MinedBlockData>(MinedBlockData::class.java, CONTENT_VERSION),
        DataManipulatorBuilder<MinedBlockData, ImmutableMinedBlockData> {
    override fun buildContent(container: DataView?): Optional<MinedBlockData> {
        if (container == null) return Optional.empty()

        if (!container.contains(MinedBlock.BLCOK_MINED_QUERY)) return Optional.empty()

        val data = MinedBlockDataImpl()

        container.getView(KeyRepository.MINED_BLOCKS.query)
                .get().getKeys(false).forEach { query ->
                    val putData = container.getSerializable(query, MinedBlock::class.java).get()
                    data.minedMap = putData.minedMap.toMutableMap()
                }
        return Optional.of(data)
    }

    override fun createFrom(dataHolder: DataHolder): Optional<MinedBlockData> = create().from(dataHolder)

    override fun create(): MinedBlockData = MinedBlockDataImpl()

    companion object {
        const val CONTENT_VERSION = 2
    }

    class MinedBlockUpdater : DataContentUpdater {
        override fun getInputVersion(): Int = 1

        override fun update(content: DataView): DataView {
            content.set(KeyRepository.MINED_BLOCKS, ImmutableMap.of())

            return content
        }

        override fun getOutputVersion(): Int = 2

    }
}*/