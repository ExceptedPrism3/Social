package me.prism3.socialbukkit;

import de.jeff_media.updatechecker.UpdateChecker;
import me.prism3.socialbukkit.Events.ClickEvent;
import me.prism3.socialbukkit.Utils.Data;
import me.prism3.socialbukkit.Utils.Metrics;
import me.prism3.socialbukkit.onCommands.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static me.prism3.socialbukkit.Utils.Data.resourceID;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();

        this.initializeData(new Data());

        this.getServer().getPluginManager().registerEvents(new ClickEvent(), this);

        Objects.requireNonNull(this.getCommand("social")).setExecutor(new onSocial());
        Objects.requireNonNull(this.getCommand("website")).setExecutor(new onWebsite());
        Objects.requireNonNull(this.getCommand("youtube")).setExecutor(new onYoutube());
        Objects.requireNonNull(this.getCommand("facebook")).setExecutor(new onFacebook());
        Objects.requireNonNull(this.getCommand("twitch")).setExecutor(new onTwitch());
        Objects.requireNonNull(this.getCommand("discord")).setExecutor(new onDiscord());
        Objects.requireNonNull(this.getCommand("instagram")).setExecutor(new onInstagram());
        Objects.requireNonNull(this.getCommand("store")).setExecutor(new onStore());

        // bStats
        new Metrics(this, 11779);

        // Update Checker
        UpdateChecker.init(this, resourceID)
                .checkEveryXHours(2)
                .setChangelogLink(resourceID)
                .setNotifyOpsOnJoin(true)
                .checkNow();

        this.getLogger().info("Plugin loaded!");

    }

    @Override
    public void onDisable() {

        this.getLogger().info("Plugin unloaded!");

    }

    public static Main getInstance() {
        return instance;
    }

    private void initializeData(Data data){

        data.initializeStrings();
        data.initializeIntegers();
        data.initializeBooleans();
        data.initializePermissionStrings();
        data.initializeHeadSkins();

    }
}
