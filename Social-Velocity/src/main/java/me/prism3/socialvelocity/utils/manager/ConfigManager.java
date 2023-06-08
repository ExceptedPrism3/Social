package me.prism3.socialvelocity.utils.manager;

import com.google.common.io.ByteStreams;

import java.io.*;
import java.nio.file.Files;

import static me.prism3.socialvelocity.utils.Data.getConfigValue;


/**
 * The ConfigManager class handles the creation and retrieval of the plugin's configuration file.
 * It provides methods to create the configuration file if it doesn't exist and retrieve values from the configuration.
 */
public class ConfigManager {

    private final File configFile;

    /**
     * Constructs a new ConfigManager instance.
     * Initializes the configFile field by creating the configuration file if it doesn't exist.
     */
    public ConfigManager() { this.configFile = this.createConfigFile(); }

    /**
     * Creates the configuration file if it doesn't exist and returns the File object representing the configuration file.
     *
     * @return the File object representing the configuration file
     */
    private File createConfigFile() {

        final File dataFolder = new File("plugins/Social-Velocity");

        if (!dataFolder.exists())
            dataFolder.mkdirs();

        final File configFile = new File(dataFolder, "config - Velocity.yml");

        if (!configFile.exists()) {

            try (final InputStream inputStream = ConfigManager.class.getResourceAsStream("/config - Velocity.yml");
                 final OutputStream outputStream = Files.newOutputStream(configFile.toPath())) {

                if (inputStream != null)
                    ByteStreams.copy(inputStream, outputStream);

            } catch (final IOException e) { e.printStackTrace(); }
        }

        return configFile;
    }

    public File getConfigFile() { return configFile; }

    /**
     * Retrieves the value associated with the specified path in the configuration file.
     * If the path is not found, returns the specified defaultValue.
     *
     * @param path         the path to the value in the configuration file
     * @param defaultValue the default value to return if the path is not found
     * @return the value associated with the path or the defaultValue if the path is not found
     */
    public String getString(final String path, final String defaultValue) {

        if (path == null)
            return defaultValue;

        final String formattedPath = path.replace('-', '_'); // Replace hyphens with underscores

        final String value = getConfigValue(formattedPath);

        if (value != null)
            return value.replace("%prefix%", defaultValue);

        return defaultValue;
    }
}
