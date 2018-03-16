/*
package re.data.minedBlockData.impl

import com.google.common.reflect.TypeToken
import org.spongepowered.api.data.DataContainer
import org.spongepowered.api.data.DataView
import org.spongepowered.api.data.persistence.DataTranslator
import re.data.minedBlockData.MinedBlock

/**
 * @author karayuu
 */
class MinedTranslator : DataTranslator<MinedBlock> {
    const val CONTENT_VERSION = 2

    override fun getName(): String = "Mined Translator"

    override fun getId(): String = "${StudySponge.ID}:mined_translator"

    override fun getToken(): TypeToken<MinedBlock> = TypeToken.of(MinedBlock::class.java)

    override fun translate(view: DataView?): MinedBlock {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun translate(obj: MinedBlock?): DataContainer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}*/