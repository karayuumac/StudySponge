package config

import ninja.leaping.configurate.commented.CommentedConfigurationNode
import ninja.leaping.configurate.loader.ConfigurationLoader
import java.io.File

/**
 * Created by karayuu on 2018/04/08
 */
object GameConfigManager {
    private lateinit var configFile: File
    private lateinit var configLoader: ConfigurationLoader<CommentedConfigurationNode>

    fun setUp(configFile: File,configLoader: ConfigurationLoader<CommentedConfigurationNode>): GameConfigManager {
        this.configFile = configFile
        this.configLoader = configLoader

        return this
    }
}
