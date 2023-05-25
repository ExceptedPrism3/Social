package me.prism3.socialbungee.utils.manager;

import me.prism3.socialbungee.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;


public class ConfigManager {

    private Configuration config = null;

    public void init() {

        this.saveDefaultConfig();

        try {

            this.config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(this.getFile());

        } catch (final IOException e) { e.printStackTrace(); }
    }

    public String getString(final String key, final String defaultValue) {
        final String str = this.config.getString(key);
        return str != null ? ChatColor.translateAlternateColorCodes('&', str) : defaultValue;
    }

    public boolean getBoolean(final String key) { return this.config.getBoolean(key); }

    public List<String> getStringList(final String key) {

        final List<String> list = this.config.getStringList(key);

        return list.stream()
                .map(str -> ChatColor.translateAlternateColorCodes('&', str))
                .collect(Collectors.toList());
    }

    public File getFile() { return new File(Main.getInstance().getDataFolder(), "config - Bungee.yml"); }

    public Configuration getConfiguration() { return this.config; }

    private void saveDefaultConfig() {

        Main.getInstance().getDataFolder().mkdirs();

        final File configFile = this.getFile();

        if (!configFile.exists()) {

            try (final InputStream is = Main.getInstance().getResourceAsStream("config - Bungee.yml");
                 final OutputStream os = Files.newOutputStream(configFile.toPath())) {

                final byte[] buffer = new byte[is.available()];

                is.read(buffer);
                os.write(buffer);

            } catch (final IOException e) { e.printStackTrace(); }
        }
    }
}
