package re.tutorial

import com.google.common.reflect.TypeToken
import org.spongepowered.api.block.BlockType
import org.spongepowered.api.data.DataQuery
import org.spongepowered.api.data.key.Key
import org.spongepowered.api.data.value.mutable.MapValue

/**
 * @author karayuu
 */
object Keys {
    val mappedData : Key<MapValue<BlockType, Int>> = Key.builder()
            .type(object : TypeToken<MapValue<BlockType, Int>>() {})
            .id(StudySponge.ID)
            .name("MappedData")
            .query(DataQuery.of("MappedData"))
            .build()
}