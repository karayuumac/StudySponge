import org.slf4j.Logger
import org.spongepowered.api.plugin.Plugin
import javax.inject.Inject

/**
 * Created by karayuu on 2018/03/04
 */

@Plugin(
        id = "studysponge",
        name = "StudySponge",
        version = "1.0.0"
)
class StudySponge {
    @Inject
    private lateinit var logger: Logger
}
