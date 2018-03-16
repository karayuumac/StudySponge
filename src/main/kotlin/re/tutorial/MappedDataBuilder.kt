package re.tutorial

import org.spongepowered.api.block.BlockType
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.DataView
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder
import org.spongepowered.api.data.persistence.AbstractDataBuilder
import java.util.*

/**
 * @author karayuu
 */
object MappedDataBuilder :
        AbstractDataBuilder<MappedData>(MappedData::class.java, 1),
        DataManipulatorBuilder<MappedData, ImmutableMappedData> {
    override fun createFrom(dataHolder: DataHolder?): Optional<MappedData> {
        if (dataHolder == null) return Optional.empty()
        return create().fill(dataHolder)
    }

    override fun create(): MappedData = MappedData()

    override fun buildContent(container: DataView?): Optional<MappedData> {
        if (container == null) return Optional.empty()

        val map = container.getMap(Keys.mappedData.query).get()

        val newMap = mutableMapOf<BlockType, Int>()

        map.forEach { t, s ->
            if (t is BlockType && s is Int) {
                newMap[t] = s
            }
        }

        return Optional.of(MappedData(newMap))
    }
}