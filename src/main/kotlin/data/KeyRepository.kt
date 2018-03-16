package data

import com.google.common.reflect.TypeToken
import org.spongepowered.api.block.BlockType
import org.spongepowered.api.block.BlockTypes
import org.spongepowered.api.data.DataQuery
import org.spongepowered.api.data.key.Key
import org.spongepowered.api.data.value.mutable.MapValue
import org.spongepowered.api.data.value.mutable.Value
import org.spongepowered.api.util.TypeTokens

/**
 * Created by karayuu on 2018/03/09
 */
object KeyRepository {
    val placeAmount: Key<Value<Int>> = Key.builder()
            .type(TypeTokens.INTEGER_VALUE_TOKEN)
            .id(StudySponge.ID)
            .name("PlaceAmount")
            .query(DataQuery.of("PlaceAmount"))
            .build()

    /*
    val allBlockPlaceAmount: Key<MapValue<BlockType, Int>> = Key.builder()
            .type(object : TypeToken<MapValue<BlockType, Int>>() {})
            .id(StudySponge.ID)
            .name("AllBlockPlaceAmount")
            .query(DataQuery.of("AllBlockPlaceAmount"))
            .build()
    */

    /*
    val MINED_BLOCKS: Key<MapValue<BlockType, Int>> = Key.builder()
            .type(object : TypeToken<MapValue<BlockType, Int>>() {})
            .id(StudySponge.ID)
            .name("MinedMap")
            .query(DataQuery.of("MinedMap"))
            .build()
    */
}
