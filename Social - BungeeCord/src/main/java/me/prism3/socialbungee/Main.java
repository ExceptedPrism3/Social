package me.prism3.socialbungee;

import me.prism3.socialbungee.Commands.*;
import me.prism3.socialbungee.Utils.ConfigManager;
import me.prism3.socialbungee.Utils.Metrics;
import me.prism3.socialbungee.Utils.UpdateChecker;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;

public final class Main extends Plugin {

    private static Main instance;

    private static ConfigManager config;

    @Override
    public void onEnable() {

        instance = this;

        config = new ConfigManager();
        config.init();

        getProxy().getPluginManager().registerCommand(this, new OnSocial());
        getProxy().getPluginManager().registerCommand(this, new OnDiscord());
        getProxy().getPluginManager().registerCommand(this, new OnFacebook());
        getProxy().getPluginManager().registerCommand(this, new OnWebsite());
        getProxy().getPluginManager().registerCommand(this, new OnYoutube());
        getProxy().getPluginManager().registerCommand(this, new OnTwitch());
        getProxy().getPluginManager().registerCommand(this, new OnInstagram());
        getProxy().getPluginManager().registerCommand(this, new OnStore());

        //bstats

        new Metrics(this, 11779);

        //Update Checker

        new UpdateChecker(this, 93562).getLatestVersion(version -> {

            if(this.getDescription().getVersion().equalsIgnoreCase(version)) {

                getLogger().info(ChatColor.GREEN + "Plugin is up to date!");

            } else {

                getLogger().info(ChatColor.GOLD + "Plugin has a new Update! Current version " + ChatColor.RED + version + ChatColor.GOLD + " and the newest " + ChatColor.GREEN + this.getDescription().getVersion());

            }
        });

        getLogger().info("Has been loaded!");
    }

    @Override
    public void onDisable() {

        getLogger().info("Has been unloaded!");

    }

    public static Main getInstance() {
        return instance;
    }

    public static ConfigManager getConfig() {
        return config;
    }
}
