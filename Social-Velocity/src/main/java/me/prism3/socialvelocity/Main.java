package me.prism3.socialvelocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import me.prism3.socialvelocity.utils.ConfigManager;
import me.prism3.socialvelocity.utils.Data;
import org.bstats.velocity.Metrics;
import org.slf4j.Logger;

import java.nio.file.Path;

import static me.prism3.socialvelocity.utils.Data.bStats;

@Plugin(
        id = "social-velocity",
        name = "Social Velocity",
        version = "1.2.2",
        description = "Social media corners for your Server.",
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
    @DataDirectory
    private Path folder;

    @Inject
    public Main(ProxyServer server, Logger logger, Metrics.Factory metricsFactory) {

        this.server = server;
        this.logger = logger;
        this.metricsFactory = metricsFactory;

    }

    @Subscribe
    public void onEnable(final ProxyInitializeEvent event) {

        instance = this;

        this.config = new ConfigManager();

        new ConfigManager();

        this.initializeData(new Data());

        // bStats
        this.metricsFactory.make(this, bStats);

        this.logger.info("Plugin loaded");

    }

    @Subscribe
    public void onDisable(final ProxyShutdownEvent event) {
        this.logger.info("Plugin unloaded");
    }

    public void initializeData(Data data) {

        data.initializeStrings();
        data.initializeIntegers();
        data.initializeListOfStrings();
        data.initializeBooleans();
        data.initializePermissionStrings();
        data.commandInitializer();

    }

    public static Main getInstance() { return instance; }

    public Logger getLogger() { return this.logger; }

    public Path getFolder() { return this.folder; }

    public ConfigManager getConfig() { return this.config; }

    public ProxyServer getServer() { return this.server; }
}
