/*
package re.data.minedBlockData.impl

import com.google.common.base.Preconditions
import com.google.common.collect.ImmutableMap
import data.KeyRepository
import org.spongepowered.api.Sponge
import org.spongepowered.api.block.BlockType
import org.spongepowered.api.data.DataContainer
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.manipulator.mutable.common.AbstractData
import org.spongepowered.api.data.merge.MergeFunction
import org.spongepowered.api.data.value.mutable.MapValue
import re.data.minedBlockData.ImmutableMinedBlockData
import re.data.minedBlockData.MinedBlockData
import java.util.*

class MinedBlockDataImpl(var minedMap: MutableMap<BlockType, Int>) : AbstractData<MinedBlockData, ImmutableMinedBlockData>(),
        MinedBlockData {

    constructor(): this(mutableMapOf())

    override fun asImmutable(): ImmutableMinedBlockData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun from(container: DataContainer?): Optional<MinedBlockData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun copy(): MinedBlockData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContentVersion(): Int = MinedBlockBuilder.CONTENT_VERSION

    override fun fill(dataHolder: DataHolder?, overlap: MergeFunction?): Optional<MinedBlockData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getMap() : Map<BlockType, Int> = minedMap
    private fun setMap(map: Map<BlockType, Int>) {
        Preconditions.checkNotNull(map)
        this.minedMap = map
    }

    override fun registerGettersAndSetters() {
        registerKeyValue(KeyRepository.MINED_BLOCKS, this::minedMap)

        registerFieldGetter(KeyRepository.MINED_BLOCKS, this::getMap)

        registerFieldSetter(KeyRepository.MINED_BLOCKS, this::setMap)
    }

    override fun minedMap(): MapValue<BlockType, Int> {
        return Sponge.getRegistry().valueFactory.createMapValue(KeyRepository.MINED_BLOCKS, this.minedMap, ImmutableMap.of())
    }

}*/
