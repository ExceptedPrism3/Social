package me.prism3.socialvelocity.Utils;

import com.google.common.io.ByteStreams;
import me.prism3.socialvelocity.Main;
import me.prism3.socialvelocity.Utils.Config.Configuration;
import me.prism3.socialvelocity.Utils.Config.ConfigurationProvider;
import me.prism3.socialvelocity.Utils.Config.StringUtils;
import me.prism3.socialvelocity.Utils.Config.YamlConfiguration;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConfigManager {

    private File file;
    private Configuration configuration;
    private final File dataFolder = Main.getInstance().getFolder().toFile();

    public ConfigManager() {

        this.file = new File(this.dataFolder, "config - Velocity.yml");

        try {

            if (!this.file.exists()) {

                if (!this.dataFolder.exists()) { this.dataFolder.mkdir(); }

                this.file.createNewFile();

                try (final InputStream is = ConfigManager.class.getResourceAsStream("/config - Velocity.yml");
                     final OutputStream os = new FileOutputStream(this.file)) {
                    assert is != null;
                    ByteStreams.copy(is, os);
                }
            } this.configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(this.file);
        }  catch (IOException e) { e.printStackTrace(); }
    }

    public boolean getBoolean(final String path) {

        return this.configuration.get(path) != null && this.configuration.getBoolean(path);

    }

    public String getString(final String path) {

        if (this.configuration.get(path) != null) {

            return StringUtils.translateAlternateColorCodes('&', this.configuration.getString(path));

        } return "String at path: " + path + " not found!";
    }

    public List<String> getStringList(final String path) {

        if (this.configuration.get(path) != null) {

            final ArrayList<String> strings = new ArrayList<>();

            for (final String string : this.configuration.getStringList(path)) {

                strings.add(StringUtils.translateAlternateColorCodes('&', string));

            } return strings;
        } return Collections.singletonList("String List at path: " + path + " not found!");
    }

    public void reload(){ load(); }

    private void load() {

        this.file = new File(this.dataFolder, "config - Velocity.yml");

        try {

            this.configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(this.file);
        }

        catch (IOException e) { e.printStackTrace(); }
    }
}
