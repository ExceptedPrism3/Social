package me.prism3.socialbungee.utils.manager;

import me.prism3.socialbungee.Main;
import me.prism3.socialbungee.utils.Links;
import me.prism3.socialbungee.utils.Log;
import net.md_5.bungee.config.Configuration;

import java.util.ArrayList;
import java.util.List;


/**
 * The LinkManager class is responsible for managing links in the plugin.
 * It retrieves link data from the plugin's configuration and creates Links objects for each entry.
 */
public class LinkManager {

    private final Main main;
    private final List<Links> links;

    /**
     * Initializes the LinkManager by retrieving link data from the plugin's configuration and creating Links objects.
     */
    public LinkManager(Main main) {
        this.main = main;
        this.links = new ArrayList<>();
        this.initializeLinks();
    }

    /**
     * Retrieves link data from the plugin's configuration and creates Links objects.
     */
    private void initializeLinks() {

        final Configuration config = this.main.getConfig().getConfiguration();

        final Configuration linksSection = config.getSection("Links");

        if (linksSection == null) {
            Log.severe("No 'Links' section found in the plugin configuration.");
            return;
        }

        for (String key : linksSection.getKeys()) {

            Object linkData = linksSection.get(key);

            if (linkData instanceof String) {
                String link = (String) linkData;
                Links linkEntry = new Links(key, link);
                links.add(linkEntry);
            }
        }
    }


    /**
     * Retrieves the list of links.
     *
     * @return The list of links.
     */
    public List<Links> getLinks() {
        return links;
    }
}
