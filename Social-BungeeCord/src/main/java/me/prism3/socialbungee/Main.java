package me.prism3.socialbungee;

import me.prism3.socialbungee.utils.ConfigManager;
import me.prism3.socialbungee.utils.Data;
import me.prism3.socialbungee.utils.Metrics;
import me.prism3.socialbungee.utils.UpdateChecker;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;

public final class Main extends Plugin {

    private static Main instance;

    private ConfigManager config;

    @Override
    public void onEnable() {

        instance = this;

        this.config = new ConfigManager();
        this.config.init();

        this.initializeData(new Data());

        // bStats
        new Metrics(this, 11779);

        // Update Checker
        new UpdateChecker(this, 93562).getLatestVersion(version -> {

            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {

                this.getLogger().info(ChatColor.GREEN + "Plugin is up to date!");

            } else {

                this.getLogger().info(ChatColor.GOLD + "Plugin has a new Update! Current version " + ChatColor.RED + version + ChatColor.GOLD + " and the newest " + ChatColor.GREEN + this.getDescription().getVersion());

            }
        });

        this.getLogger().info("Has been loaded!");
    }

    @Override
    public void onDisable() { this.getLogger().info("Has been unloaded!"); }

    public void initializeData(Data data) {

        data.initializeStrings();
        data.initializeListOfStrings();
        data.initializeBooleans();
        data.initializePermissionStrings();
        data.commandInitializer();

    }

    public static Main getInstance() {
        return instance;
    }

    public ConfigManager getConfig() {
        return this.config;
    }
}
