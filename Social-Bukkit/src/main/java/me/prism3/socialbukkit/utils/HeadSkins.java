package me.prism3.socialbukkit.utils;

import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

import static me.prism3.socialbukkit.utils.Data.getLinks;


/**
 * HeadSkins is a utility class for obtaining head skins as ItemStacks.
 * It uses the SkullCreator library to create ItemStacks from base64-encoded head links.
 */
public final class HeadSkins {

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private HeadSkins() {}

    /**
     * Retrieves a map of head skins as ItemStacks.
     *
     * @return a map containing head skins as ItemStacks, with the header as the key
     */
    public static Map<String, ItemStack> getHeadSkins() {

        final Map<String, ItemStack> headSkins = new HashMap<>();

        for (Links link : getLinks()) {

            String headLink = link.getHeadLink();

            if (!headLink.isEmpty()) {

                ItemStack skullItem = SkullCreator.itemFromBase64(headLink); // Create an ItemStack from the base64-encoded head link

                headSkins.put(link.getHeader(), skullItem); // Add the ItemStack to the map with the header as the key
            }
        }

        return headSkins;
    }
}
