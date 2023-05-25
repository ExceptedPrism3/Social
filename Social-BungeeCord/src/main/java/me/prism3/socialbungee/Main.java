package me.prism3.socialbungee;

import me.prism3.socialbungee.utils.manager.ConfigManager;
import me.prism3.socialbungee.utils.Data;
import me.prism3.socialbungee.utils.Log;
import me.prism3.socialbungee.utils.UpdateChecker;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;
import org.bstats.bungeecord.Metrics;


public final class Main extends Plugin {

    private static Main instance;

    private ConfigManager config;

    @Override
    public void onEnable() {

        instance = this;

        Log.setup(this.getLogger());

        this.config = new ConfigManager();
        this.config.init();

        Data.initialize();

        // bStats
        new Metrics(this, 11779);

        // Update Checker
        new UpdateChecker(this, 93562).getLatestVersion(version -> {

            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {

                Log.info(ChatColor.GREEN + "Plugin is up to date!");

            } else {

                Log.info(ChatColor.GOLD + "Plugin has a new Update! Current version " + ChatColor.RED + version + ChatColor.GOLD + " and the newest " + ChatColor.GREEN + this.getDescription().getVersion());

            }
        });

        Log.info("Plugin loaded!");
    }

    @Override
    public void onDisable() { Log.info("Plugin unloaded!"); }

    public static Main getInstance() {
        return instance;
    }

    public ConfigManager getConfig() {
        return this.config;
    }
}
