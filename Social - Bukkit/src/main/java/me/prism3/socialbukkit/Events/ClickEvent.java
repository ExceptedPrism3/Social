package me.prism3.socialbukkit.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

import static me.prism3.socialbukkit.Utils.Data.*;

public class ClickEvent implements Listener {

    @EventHandler
    public void onClick(final InventoryClickEvent e){

        if (e.getClickedInventory() == null) return;

        if (e.getView().getTitle().equalsIgnoreCase(socialTitle)) {

            e.setCancelled(true);

            final Player player = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null || !e.getCurrentItem().hasItemMeta()) return;

            final String displayName = Objects.requireNonNull(Objects.requireNonNull(e.getCurrentItem()).getItemMeta()).getDisplayName();

            if (displayName.equals(ChatColor.WHITE + "" + ChatColor.BOLD + "Website")){

                if (!isWebsite) {

                    player.sendMessage(websiteLink);

                }else {

                    player.sendMessage(messageNotAvailable);
                }
                player.closeInventory();

            }

            if (displayName.equals(ChatColor.RED + "" + ChatColor.BOLD + "Youtube")) {

                if (!isYoutube) {

                    player.sendMessage(youtubeLink);

                }else {

                    player.sendMessage(messageNotAvailable);
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.BLUE + "" + ChatColor.BOLD + "Facebook")) {

                if (!isFacebook) {

                    player.sendMessage(facebookLink);

                }else {

                    player.sendMessage(messageNotAvailable);
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Twitch")) {

                if (!isTwitch) {

                    player.sendMessage(twitchLink);

                }else {

                    player.sendMessage(messageNotAvailable);
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Discord")) {

                if (!isDiscord) {

                    player.sendMessage(discordLink);

                }else {

                    player.sendMessage(messageNotAvailable);
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Instagram")) {

                if (!isInstagram) {

                    player.sendMessage(instagramLink);

                }else {

                    player.sendMessage(messageNotAvailable);
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Store")) {

                if (!isStore) {

                    player.sendMessage(storeLink);

                }else {

                    player.sendMessage(messageNotAvailable);
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.RED + "" + ChatColor.BOLD + "Close")) {

                player.closeInventory();

            }
        }
    }
}
