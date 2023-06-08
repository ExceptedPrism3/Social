package me.prism3.socialvelocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import me.prism3.socialvelocity.utils.Data;
import me.prism3.socialvelocity.utils.Log;
import me.prism3.socialvelocity.utils.manager.ConfigManager;
import org.bstats.velocity.Metrics;

import java.util.logging.Logger;


@Plugin(
        id = "social-velocity",
        name = "Social Velocity",
        version = "1.3",
        description = "Social media corners for your server.",
        url = "prism3.me",
        authors = {"Prism3"}
)
public class Main {

    private final ProxyServer server;
    private final Logger logger;
    private final Metrics.Factory metricsFactory;

    private static Main instance;
    private ConfigManager config;

    @Inject
    public Main(final ProxyServer server, final Logger logger, final Metrics.Factory metricsFactory) {

        this.server = server;
        this.logger = logger;
        this.metricsFactory = metricsFactory;
    }

    @Subscribe
    public void onEnable(final ProxyInitializeEvent event) {

        instance = this;

        Log.setup(this.logger);

        this.config = new ConfigManager();

        Data.initialize();

        // bStats
        this.metricsFactory.make(this, 11779);

        Log.info("Plugin loaded");
    }

    @Subscribe
    public void onDisable(final ProxyShutdownEvent event) { Log.info("Plugin unloaded"); }

    public static Main getInstance() { return instance; }

    public ConfigManager getConfig() { return this.config; }

    public ProxyServer getServer() { return this.server; }
}
