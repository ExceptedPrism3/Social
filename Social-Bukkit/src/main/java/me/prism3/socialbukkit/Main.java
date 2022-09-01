package me.prism3.socialbukkit;

import de.jeff_media.updatechecker.UpdateChecker;
import me.prism3.socialbukkit.events.ClickEvent;
import me.prism3.socialbukkit.utils.Data;
import me.prism3.socialbukkit.utils.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import static me.prism3.socialbukkit.utils.Data.resourceID;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        this.saveDefaultConfig();

        this.initializeData(new Data());

        this.getServer().getPluginManager().registerEvents(new ClickEvent(), this);

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
    public void onDisable() { this.getLogger().info("Plugin unloaded!"); }

    private void initializeData(Data data) {

        data.initializeStrings();
        data.initializeIntegers();
        data.initializeBooleans();
        data.initializePermissionStrings();
        data.initializeHeadSkins();
        data.commandInitializer();

    }

    public static Main getInstance() {
        return instance;
    }
}
