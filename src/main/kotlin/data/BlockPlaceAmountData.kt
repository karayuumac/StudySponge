package data

import org.spongepowered.api.Sponge
import org.spongepowered.api.data.DataContainer
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.manipulator.mutable.common.AbstractSingleData
import org.spongepowered.api.data.merge.MergeFunction
import org.spongepowered.api.data.value.mutable.Value
import java.util.*

/**
 * Created by karayuu on 2018/03/08
 * Developer of Gigantic☆Seichi Server
 * Support at dev-basic or dev-extreme channel of Discord
 */
class BlockPlaceAmountData(val amount: Int) :
    AbstractSingleData<Int, BlockPlaceAmountData, ImmutableBlockPlaceAmountData>(amount, KeyRepository.placeAmount) {

    constructor(): this(0)

    operator fun plus(amount: Int): BlockPlaceAmountData = BlockPlaceAmountData(super.getValue() + amount)

    override fun from(container: DataContainer): Optional<BlockPlaceAmountData> =
            container.getObject(KeyRepository.placeAmount.query, Int::class.java).map { setValue(it) }

    override fun copy(): BlockPlaceAmountData = BlockPlaceAmountData(amount)

    override fun getContentVersion(): Int = BlockPlaceAmountDataBuilder.contentVersion

    override fun fill(dataHolder: DataHolder, overlap: MergeFunction): Optional<BlockPlaceAmountData> {
        val merged = overlap.merge(this, dataHolder.get(BlockPlaceAmountData::class.java).orElse(null))

        return setValue(merged.value).let { Optional.of(it) }
    }

    override fun asImmutable(): ImmutableBlockPlaceAmountData = ImmutableBlockPlaceAmountData(amount)

    override fun getValueGetter(): Value<*> = Sponge.getRegistry().valueFactory.
            createValue(KeyRepository.placeAmount, amount)

    override fun toContainer(): DataContainer = super.toContainer().set(KeyRepository.placeAmount, amount)
}
