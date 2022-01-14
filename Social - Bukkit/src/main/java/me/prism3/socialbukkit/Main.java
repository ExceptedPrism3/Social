package me.prism3.socialbukkit;

import de.jeff_media.updatechecker.UpdateChecker;
import me.prism3.socialbukkit.Events.ClickEvent;
import me.prism3.socialbukkit.Utils.Metrics;
import me.prism3.socialbukkit.onCommands.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new ClickEvent(), this);

        Objects.requireNonNull(getCommand("social")).setExecutor(new onSocial());
        Objects.requireNonNull(getCommand("website")).setExecutor(new onWebsite());
        Objects.requireNonNull(getCommand("youtube")).setExecutor(new onYoutube());
        Objects.requireNonNull(getCommand("facebook")).setExecutor(new onFacebook());
        Objects.requireNonNull(getCommand("twitch")).setExecutor(new onTwitch());
        Objects.requireNonNull(getCommand("discord")).setExecutor(new onDiscord());
        Objects.requireNonNull(getCommand("instagram")).setExecutor(new onInstagram());
        Objects.requireNonNull(getCommand("store")).setExecutor(new onStore());

        //bstats
        new Metrics(this, 11779);

        //Update Checker
        int resource_ID = 93562;
        UpdateChecker.init(this, resource_ID)
                .checkEveryXHours(2)
                .setChangelogLink(resource_ID)
                .setNotifyOpsOnJoin(true)
                .checkNow();

        getLogger().info("Plugin loaded!");

    }

    @Override
    public void onDisable() {

        getLogger().info("Plugin unloaded!");

    }

    public static Main getInstance() {
        return instance;
    }
}
