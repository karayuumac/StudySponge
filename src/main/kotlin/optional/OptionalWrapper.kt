package optional

import java.util.*

/**
 * @author karayuu
 */
class OptionalWrapper<T: Any> (private val optional: Optional<T>) {
    private lateinit var defaultValue : T

    fun getOptional() : Optional<T> = optional

    fun getValue() = optional.let {
        if (it.isPresent) {
            it.get()
        } else {
            defaultValue
        }
    }

    fun default(value: T) : OptionalWrapper<T> {
        this.defaultValue = value
        return this
    }
}