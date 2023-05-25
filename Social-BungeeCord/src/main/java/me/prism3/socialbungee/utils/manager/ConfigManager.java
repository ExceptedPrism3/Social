package me.prism3.socialbungee.utils.manager;

import me.prism3.socialbungee.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


/**
 * The ConfigManager class is responsible for managing the configuration file of the plugin.
 * It provides methods to initialize, retrieve values, and access the plugin's configuration.
 */
public class ConfigManager {

    private Configuration config = null;

    /**
     * Initializes the ConfigManager by saving the default configuration file and loading the configuration.
     */
    public void init() {

        this.saveDefaultConfig();

        try {

            final File configFile = this.getFile();
            this.config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);

        } catch (final IOException e) { e.printStackTrace(); }
    }

    /**
     * Retrieves a string value from the configuration based on the provided key.
     * If the value is not found, the defaultValue is returned.
     *
     * @param key          The key to retrieve the string value.
     * @param defaultValue The default value to return if the key is not found.
     * @return The retrieved string value, or the defaultValue if the key is not found.
     */
    public String getString(final String key, final String defaultValue) {

        final String str = this.config.getString(key);

        return str != null ? ChatColor.translateAlternateColorCodes('&', str) : defaultValue;
    }

    /**
     * Retrieves the plugin's configuration.
     *
     * @return The plugin's configuration.
     */
    public Configuration getConfiguration() { return this.config; }

    /**
     * Retrieves the file object representing the configuration file.
     *
     * @return The file object representing the configuration file.
     */
    private File getFile() { return new File(Main.getInstance().getDataFolder(), "config - Bungee.yml"); }

    /**
     * Saves the default configuration file if it does not exist.
     */
    private void saveDefaultConfig() {

        Main.getInstance().getDataFolder().mkdirs();

        final File configFile = this.getFile();

        if (!configFile.exists()) {

            try (final InputStream is = Main.getInstance().getResourceAsStream("config - Bungee.yml")) {

                Files.copy(is, configFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            } catch (final IOException e) { e.printStackTrace(); }
        }
    }
}
