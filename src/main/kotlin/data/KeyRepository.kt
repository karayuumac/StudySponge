package data

import org.spongepowered.api.data.DataQuery
import org.spongepowered.api.data.key.Key
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
}
