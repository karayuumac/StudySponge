/*
package re

import com.google.common.collect.Maps
import data.KeyRepository
import org.spongepowered.api.block.BlockType
import org.spongepowered.api.data.DataContainer
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableMappedData
import org.spongepowered.api.data.manipulator.mutable.common.AbstractMappedData
import org.spongepowered.api.data.merge.MergeFunction
import java.util.*

/**
 * @author karayuu
 */

class AllBlockPlaceAmount(val amountMap: MutableMap<BlockType, Int>) :
        AbstractMappedData<BlockType, Int, AllBlockPlaceAmount, AllBlockPlaceAmount.Immutable>(
                amountMap, KeyRepository.allBlockPlaceAmount
        ) {
    constructor(): this(getSaveBlockInitMap())

    override fun from(container: DataContainer): Optional<AllBlockPlaceAmount> {
        if (!container.contains(KeyRepository.allBlockPlaceAmount)) {
            return Optional.empty()
        }

        val blocks = container.getView(KeyRepository.allBlockPlaceAmount.query).get()
        for (query in blocks.getKeys(false)) {
            blocks.getSerializable(query, Map::class.java)
        }
    }

    override fun copy(): AllBlockPlaceAmount {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun putAll(map: MutableMap<out BlockType, out Int>): AllBlockPlaceAmount {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContentVersion(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fill(dataHolder: DataHolder, overlap: MergeFunction?): Optional<AllBlockPlaceAmount> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(key: BlockType): Optional<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun asImmutable(): Immutable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMapKeys(): MutableSet<BlockType> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun put(key: BlockType, value: Int): AllBlockPlaceAmount {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(key: BlockType): AllBlockPlaceAmount {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class Immutable(private val amountMap: Map<BlockType, Int>) :
            AbstractImmutableMappedData<BlockType, Int, AllBlockPlaceAmount.Immutable, AllBlockPlaceAmount>(
                    amountMap, KeyRepository.allBlockPlaceAmount) {
        override fun getContentVersion(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun asMutable(): AllBlockPlaceAmount {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}
*/