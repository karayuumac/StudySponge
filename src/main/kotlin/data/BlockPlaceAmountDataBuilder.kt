package data

import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.DataView
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder
import org.spongepowered.api.data.persistence.AbstractDataBuilder
import org.spongepowered.api.data.persistence.DataContentUpdater
import java.util.*

/**
 * Created by karayuu on 2018/03/09
 */

private const val CONTENT_VERSION = 1

object BlockPlaceAmountDataBuilder :
        AbstractDataBuilder<BlockPlaceAmountData>(BlockPlaceAmountData::class.java, CONTENT_VERSION),
        DataManipulatorBuilder<BlockPlaceAmountData, ImmutableBlockPlaceAmountData> {

    override fun buildContent(container: DataView): Optional<BlockPlaceAmountData> = container
            .getInt(KeyRepository.placeAmount.query)
            .map { BlockPlaceAmountData(it) }

    override fun createFrom(dataHolder: DataHolder): Optional<BlockPlaceAmountData> = create().fill(dataHolder)

    override fun create(): BlockPlaceAmountData = BlockPlaceAmountData()

    object ContentUpdater : DataContentUpdater {
        override fun getInputVersion(): Int = CONTENT_VERSION

        override fun update(content: DataView): DataView = content.set(KeyRepository.placeAmount, 0)

        override fun getOutputVersion(): Int = CONTENT_VERSION
    }

    const val contentVersion = CONTENT_VERSION
}
