package me.prism3.socialvelocity.utils.manager;

import me.prism3.socialvelocity.utils.Links;
import me.prism3.socialvelocity.utils.Log;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.yaml.YAMLConfigurationLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * The LinkManager class is responsible for loading and managing the links from the configuration file.
 * It reads the links from the configuration file and provides methods to retrieve the loaded links.
 */
public class LinkManager {

    private final List<Links> links;

    /**
     * Constructs a new LinkManager instance.
     * Initializes the list of links and loads the links from the configuration file.
     */
    public LinkManager() {
        this.links = new ArrayList<>();
        this.initializeLinks();
    }

    /**
     * Initializes the links by loading them from the configuration file.
     */
    private void initializeLinks() {

        final ConfigurationLoader<?> configurationLoader = YAMLConfigurationLoader.builder()
                .setFile(new File("plugins/Social-Velocity/config - Velocity.yml"))
                .build();

        final ConfigurationNode rootNode;

        try {

            rootNode = configurationLoader.load();

        } catch (final IOException e) {
            Log.severe("Failed to load the configuration: " + e.getMessage());
            return;
        }

        final ConfigurationNode linksSection = rootNode.getNode("Links");

        if (linksSection.isVirtual()) {
            Log.severe("No 'Links' section found in the configuration, aborting...");
            return;
        }

        for (ConfigurationNode linkNode : linksSection.getChildrenMap().values()) {

            if (linkNode.getKey() == null)
                continue;

            String key = linkNode.getKey().toString();
            String link = linkNode.getNode("Link").getString();
            String hexColor = linkNode.getNode("Color").getString();

            link = link != null ? link : " ";
            hexColor = hexColor != null ? hexColor : "#FFFFFF";

            Links linkEntry = new Links(key, link, hexColor);
            this.links.add(linkEntry);
        }
    }

    /**
     * Returns the list of loaded links.
     *
     * @return the list of links
     */
    public List<Links> getLinks() { return this.links; }
}