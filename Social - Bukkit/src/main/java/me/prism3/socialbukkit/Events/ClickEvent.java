package me.prism3.socialbukkit.Events;

import me.prism3.socialbukkit.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class ClickEvent implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void onClick(InventoryClickEvent e){

        if (e.getClickedInventory() == null) return;

        if (e.getView().getTitle().equalsIgnoreCase(Objects.requireNonNull(main.getConfig().getString("Social.Title")).replaceAll("&", "§"))) {

            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null || !e.getCurrentItem().hasItemMeta()) return;

            String displayName = Objects.requireNonNull(Objects.requireNonNull(e.getCurrentItem()).getItemMeta()).getDisplayName();

            if (displayName.equals(ChatColor.WHITE + "" + ChatColor.BOLD + "Website")){

                if (!main.getConfig().getBoolean("Website.Disabled")) {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Website.Link")).replaceAll("&", "§"));

                }else {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                }
                player.closeInventory();

            }

            if (displayName.equals(ChatColor.RED + "" + ChatColor.BOLD + "Youtube")) {

                if (!main.getConfig().getBoolean("Youtube.Disabled")) {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Youtube.Link")).replaceAll("&", "§"));

                }else {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.BLUE + "" + ChatColor.BOLD + "Facebook")) {

                if (!main.getConfig().getBoolean("Facebook.Disabled")) {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Facebook.Link")).replaceAll("&", "§"));

                }else {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Twitch")) {

                if (!main.getConfig().getBoolean("Twitch.Disabled")) {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Twitch.Link")).replaceAll("&", "§"));

                }else {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Discord")) {

                if (!main.getConfig().getBoolean("Discord.Disabled")) {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Discord.Link")).replaceAll("&", "§"));

                }else {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Instagram")) {

                if (!main.getConfig().getBoolean("Instagram.Disabled")) {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Instagram.Link")).replaceAll("&", "§"));

                }else {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Store")) {

                if (!main.getConfig().getBoolean("Store.Disabled")) {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Store.Link")).replaceAll("&", "§"));

                }else {

                    player.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                }
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.RED + "" + ChatColor.BOLD + "Close")) {

                player.closeInventory();

            }
        }
    }
}
