package me.prism3.socialbukkit;

import de.jeff_media.updatechecker.UpdateChecker;
import me.prism3.socialbukkit.utils.Data;
import me.prism3.socialbukkit.utils.Log;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import static me.prism3.socialbukkit.utils.Data.resourceID;


public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        this.saveDefaultConfig();

        Log.setup(this.getLogger());

        Data.initialize();

        // bStats
        new Metrics(this, 11779);

        // Update Checker
        UpdateChecker.init(this, resourceID)
                .checkEveryXHours(2)
                .setChangelogLink(resourceID)
                .setNotifyOpsOnJoin(true)
                .checkNow();

        Log.info("Plugin loaded!");
    }

    @Override
    public void onDisable() { Log.info("Plugin unloaded!"); }

    public static Main getInstance() {
        return instance;
    }
}
