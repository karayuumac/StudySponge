package data

import org.spongepowered.api.Sponge
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableSingleData
import org.spongepowered.api.data.value.immutable.ImmutableValue

/**
 * Created by karayuu on 2018/03/08
 * Developer of Gigantic☆Seichi Server
 * Support at dev-basic or dev-extreme channel of Discord
 */
class ImmutableBlockPlaceAmountData(private val amount: Int) :
        AbstractImmutableSingleData<Int, ImmutableBlockPlaceAmountData, BlockPlaceAmountData>(amount, KeyRepository.placeAmount) {

    operator fun plus(amount: Int) = ImmutableBlockPlaceAmountData(getValue() + amount)

    override fun getContentVersion(): Int = BlockPlaceAmountDataBuilder.contentVersion

    override fun asMutable(): BlockPlaceAmountData = BlockPlaceAmountData(amount)

    private val cachedValueGetter = Sponge.getRegistry().valueFactory
            .createValue(KeyRepository.placeAmount, amount).asImmutable()

    override fun getValueGetter(): ImmutableValue<*> = cachedValueGetter
}
