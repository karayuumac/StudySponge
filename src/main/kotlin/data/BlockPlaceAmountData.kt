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

    operator fun plus(amount: Int): BlockPlaceAmountData {
        println("呼び出し。引数[amount = $amount]")
        return BlockPlaceAmountData(super.getValue() + amount).also { println("返り値[$it]") }
    }

    override fun from(container: DataContainer): Optional<BlockPlaceAmountData> {
        println("呼び出し。引数[container = $container]")
        return container.getObject(KeyRepository.placeAmount.query, Int::class.java).map { setValue(it) }.also { println("返り値[$it]") }
    }

    override fun copy(): BlockPlaceAmountData {
        println("呼び出し。")
        return BlockPlaceAmountData(amount).also { println("返り値[$it]") }
    }

    override fun getContentVersion(): Int {
        println("呼び出し。")
        return BlockPlaceAmountDataBuilder.contentVersion.also { println("返り値[$it]") }
    }

    override fun fill(dataHolder: DataHolder, overlap: MergeFunction): Optional<BlockPlaceAmountData> {
        println("呼び出し。引数[dataHolder = $dataHolder], [overlap = $overlap]")
        val merged = overlap.merge(this, dataHolder.get(BlockPlaceAmountData::class.java).orElse(null)).also { println("merged = $it") }

        return setValue(merged.value).let { Optional.of(it) }.also { println("返り値[$it]") }
    }

    override fun asImmutable(): ImmutableBlockPlaceAmountData {
        println("呼び出し。")
        return ImmutableBlockPlaceAmountData(amount).also { println("返り値[$it]") }
    }

    override fun getValueGetter(): Value<*> {
        println("呼び出し。")
        return Sponge.getRegistry().valueFactory.createValue(KeyRepository.placeAmount, amount).also { println("返り値[$it]") }
    }

    override fun toContainer(): DataContainer {
        println("呼び出し。")
        return super.toContainer().set(KeyRepository.placeAmount, amount).also { println("返り値[$it]") }
    }

    override fun toString(): String = "amount = ${this.amount}"
}
