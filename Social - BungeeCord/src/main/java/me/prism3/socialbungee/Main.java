package me.prism3.socialbungee;

import me.prism3.socialbungee.Commands.*;
import me.prism3.socialbungee.Utils.ConfigManager;
import me.prism3.socialbungee.Utils.Data;
import me.prism3.socialbungee.Utils.Metrics;
import me.prism3.socialbungee.Utils.UpdateChecker;
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

        this.getProxy().getPluginManager().registerCommand(this, new OnSocial());
        this.getProxy().getPluginManager().registerCommand(this, new OnDiscord());
        this.getProxy().getPluginManager().registerCommand(this, new OnFacebook());
        this.getProxy().getPluginManager().registerCommand(this, new OnWebsite());
        this.getProxy().getPluginManager().registerCommand(this, new OnYoutube());
        this.getProxy().getPluginManager().registerCommand(this, new OnTwitch());
        this.getProxy().getPluginManager().registerCommand(this, new OnInstagram());
        this.getProxy().getPluginManager().registerCommand(this, new OnStore());

        // bStats

        new Metrics(this, 11779);

        // Update Checker

        new UpdateChecker(this, 93562).getLatestVersion(version -> {

            if(this.getDescription().getVersion().equalsIgnoreCase(version)) {

                this.getLogger().info(ChatColor.GREEN + "Plugin is up to date!");

            } else {

                this.getLogger().info(ChatColor.GOLD + "Plugin has a new Update! Current version " + ChatColor.RED + version + ChatColor.GOLD + " and the newest " + ChatColor.GREEN + this.getDescription().getVersion());

            }
        });

        this.getLogger().info("Has been loaded!");
    }

    @Override
    public void onDisable() {

        this.getLogger().info("Has been unloaded!");

    }

    public static Main getInstance() {
        return instance;
    }

    public ConfigManager getConfig() {
        return this.config;
    }

    private void initializeData(Data data){

        data.initializeStrings();
        data.initializeListOfStrings();
        data.initializeBooleans();
        data.initializePermissionStrings();

    }
}
