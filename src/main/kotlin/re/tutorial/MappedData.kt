package re.tutorial

import org.spongepowered.api.block.BlockType
import org.spongepowered.api.data.DataContainer
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.manipulator.mutable.common.AbstractMappedData
import org.spongepowered.api.data.merge.MergeFunction
import java.util.*

/**
 * @author karayuu
 */
class MappedData(val map: MutableMap<BlockType, Int>) :
        AbstractMappedData<BlockType, Int, MappedData, ImmutableMappedData>(map, Keys.mappedData) {
    constructor(): this(mutableMapOf())

    override fun from(container: DataContainer?): Optional<MappedData> {

        if (container == null) return Optional.empty()
        if (!container.contains(Keys.mappedData)) return Optional.empty()

        val containerMap = container.getMap(Keys.mappedData.query).get()

        val newMap = mutableMapOf<BlockType, Int>()

        containerMap.forEach { t, s ->
            if (t is BlockType && s is Int) {
                newMap[t] = s
            }
        }

        return Optional.of(setValue(newMap))
    }

    override fun copy(): MappedData = MappedData(value)

    override fun putAll(map: MutableMap<out BlockType, out Int>?): MappedData {
        if (map == null) return MappedData(value)

        return MappedData(value.apply { toMutableMap().putAll(map) })
    }

    override fun getContentVersion(): Int = 1

    override fun fill(dataHolder: DataHolder?, overlap: MergeFunction?): Optional<MappedData> {
        if (overlap == null || dataHolder == null) return Optional.empty()

        val merged = overlap.merge(this, dataHolder.get(MappedData::class.java).orElse(null))
        value = merged.map

        return Optional.of(this)
    }

    override fun get(key: BlockType?): Optional<Int> {
        if (key == null) return Optional.empty()
        val value = map[key] ?: return Optional.empty()

        return Optional.of(value)
    }

    override fun asImmutable(): ImmutableMappedData = ImmutableMappedData(map)

    override fun getMapKeys(): MutableSet<BlockType> = map.keys

    override fun put(key: BlockType?, value: Int?): MappedData {
        if (key == null || value == null) return this
        map[key] = value

        return this
    }

    override fun remove(key: BlockType?): MappedData {
        if (key == null) return this
        map.remove(key)

        return this
    }
}