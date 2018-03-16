/*
package re.data.minedBlockData.impl

import org.spongepowered.api.data.DataView
import org.spongepowered.api.data.persistence.AbstractDataBuilder
import re.data.minedBlockData.MinedBlock
import java.util.*

/**
 * @author karayuu
 */
class MinedBlockBuilder() : AbstractDataBuilder<MinedBlock>(MinedBlock::class.java, CONTENT_VERSION) {
    override fun buildContent(container: DataView?): Optional<MinedBlock> {
        if (container == null) return Optional.empty()

        if (!container.contains(MinedBlock.BLCOK_MINED_QUERY)) return Optional.empty()

        return Optional.of(container.getObject(MinedBlock.BLCOK_MINED_QUERY, MinedBlock::class.java)).get()
    }

    companion object {
        const val CONTENT_VERSION = 2
    }

}*/