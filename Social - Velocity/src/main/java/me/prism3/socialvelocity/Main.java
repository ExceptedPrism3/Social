package me.prism3.socialvelocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import me.prism3.socialvelocity.Commands.*;
import me.prism3.socialvelocity.Utils.Bstats;
import me.prism3.socialvelocity.Utils.ConfigManager;
import org.bstats.velocity.Metrics;
import org.slf4j.Logger;

import java.nio.file.Path;

@Plugin(
        id = "social-velocity",
        name = "Social Velocity",
        version = "1.2.1",
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
    public void onEnable(ProxyInitializeEvent event){

        instance = this;

        config = new ConfigManager();

        new ConfigManager();

        // bstats
        metricsFactory.make(this, Bstats.pluginID);

        server.getCommandManager().register("social", new OnSocial());
        server.getCommandManager().register("discord", new OnDiscord());
        server.getCommandManager().register("facebook", new OnFacebook(), "fb");
        server.getCommandManager().register("instagram", new OnInstagram());
        server.getCommandManager().register("store", new OnStore());
        server.getCommandManager().register("twitch", new OnTwitch());
        server.getCommandManager().register("website", new OnWebsite());
        server.getCommandManager().register("youtube", new OnYoutube(), "yt");

        logger.info("Plugin loaded");

    }

    @Subscribe
    public void onDisable(ProxyShutdownEvent event){

        logger.info("Plugin unloaded");
    }

    public static Main getInstance() { return instance; }

    public Logger getLogger(){ return logger; }

    public Path getFolder() { return folder; }

    public ConfigManager getConfig() { return config; }
}
