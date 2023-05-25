package me.prism3.socialbukkit.events;

import me.prism3.socialbukkit.utils.Links;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;
import java.util.Map;

import static me.prism3.socialbukkit.utils.Data.*;


/**
 * ClickEvent class is responsible for checking the player inventory clicking and prevents any plugin item from bugging out.
 */
public class ClickEvent implements Listener {

    private final Map<String, Links> socialIconCache = new HashMap<>();

    /**
     * InventoryClickEvent event responsible for checking the clicks.
     *
     * @param event InventoryClickEvent
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onClick(final InventoryClickEvent event) {

        if (event.getClickedInventory() == null) return;

        final String inventoryTitle = event.getView().getTitle();
        final String userSetInventoryTitle = ChatColor.translateAlternateColorCodes('&', socialTitle);

        if (inventoryTitle.equals(userSetInventoryTitle)) {

            event.setCancelled(true);

            final Player player = (Player) event.getWhoClicked();

            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) return;

            final String displayName = event.getCurrentItem().getItemMeta().getDisplayName();

            Links socialIcon = socialIconCache.get(displayName);

            if (socialIcon == null) {
                for (Links icon : getLinks()) {
                    String translatedName = ChatColor.translateAlternateColorCodes('&', icon.getDisplayName());
                    socialIconCache.put(translatedName, icon);
                    if (displayName.equals(translatedName)) {
                        socialIcon = icon;
                        break;
                    }
                }
            }

            if (socialIcon != null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', socialIcon.getUrl()));
                player.closeInventory();
            } else if (displayName.equals(ChatColor.RED + "" + ChatColor.BOLD + "Close")) {
                player.closeInventory();
            }
        }
    }
}
