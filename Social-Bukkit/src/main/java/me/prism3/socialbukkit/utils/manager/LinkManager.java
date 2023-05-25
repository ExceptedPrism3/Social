package me.prism3.socialbukkit.utils.manager;

import me.prism3.socialbukkit.Main;
import me.prism3.socialbukkit.utils.Links;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.MemorySection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The LinkManager class is responsible for managing links in the plugin.
 * It retrieves link data from the plugin's configuration and creates LinkManager objects for each entry.
 */
public class LinkManager {

    private final Main main = Main.getInstance();
    private final List<Links> links = new ArrayList<>();

    /**
     * Initializes the LinkManager by retrieving link data from the plugin's configuration and creating LinkManager objects.
     */
    public LinkManager() { this.initializeLinks(); }

    /**
     * Retrieves link data from the plugin's configuration and creates LinkManager objects.
     */
    private void initializeLinks() {

        // Get the "Links" section from the configuration
        final ConfigurationSection linksSection = this.main.getConfig().getConfigurationSection("Links");

        // No "Links" section found, return
        if (linksSection == null)
            return;

        // Map to store the link configurations
        final Map<String, Map<String, Object>> linksConfig = new HashMap<>();

        // Iterate through the keys in the "Links" section
        for (String key : linksSection.getKeys(false)) {
            Object value = linksSection.get(key);

            // If the value is a map, store it as a link configuration
            if (value instanceof Map)
                linksConfig.put(key, (Map<String, Object>) value);

            // If the value is a MemorySection, retrieve its values and store them as a link configuration
            else if (value instanceof MemorySection) {
                MemorySection memorySection = (MemorySection) value;
                Map<String, Object> sectionValues = memorySection.getValues(false);
                linksConfig.put(key, sectionValues);
            }
        }

        // Create LinkManager objects for each link configuration and add them to the links list
        for (Map.Entry<String, Map<String, Object>> entry : linksConfig.entrySet()) {

            String header = entry.getKey();
            Map<String, Object> linkData = entry.getValue();
            Links link = this.createLink(header, linkData);

            this.links.add(link);
        }
    }

    /**
     * Creates a LinkManager object based on the provided link data.
     *
     * @param header   The header of the link.
     * @param linkData The data of the link.
     * @return The created LinkManager object.
     */
    private Links createLink(final String header, final Map<String, Object> linkData) {

        final boolean isDisabled = linkData.get("Disabled") instanceof Boolean && (boolean) linkData.get("Disabled");
        final String headLink = linkData.get("Head") != null ? (String) linkData.get("Head") : "";
        final String displayName = linkData.get("Display-Name") != null ? (String) linkData.get("Display-Name") : " ";
        final String url = linkData.get("Link") != null ? (String) linkData.get("Link") : " ";
        final int slot = linkData.get("Slot") instanceof Integer ? (int) linkData.get("Slot") : 0;

        return new Links(header, isDisabled, headLink, displayName, url, slot);
    }

    /**
     * Retrieves the list of links.
     *
     * @return The list of links.
     */
    public List<Links> getLinks() { return this.links; }
}
