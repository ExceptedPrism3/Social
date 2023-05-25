package me.prism3.socialbukkit.commands;

import me.prism3.socialbukkit.Main;
import me.prism3.socialbukkit.utils.Data;
import me.prism3.socialbukkit.utils.HeadSkins;
import me.prism3.socialbukkit.utils.Links;
import me.prism3.socialbukkit.utils.Log;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static me.prism3.socialbukkit.utils.Data.*;


/**
 * OnSocial is a command executor for the "/social" command.
 * It handles various subcommands and actions related to the social menu.
 */
public class OnSocial implements CommandExecutor {

    private final Main main = Main.getInstance();
    private final Map<String, ItemStack> headSkinsCache = new HashMap<>();

    /**
     * Executes the "/social" command.
     *
     * @param sender  the CommandSender executing the command
     * @param command the CommandManager instance
     * @param label   the command label
     * @param args    the command arguments
     * @return true if the command was executed successfully, false otherwise
     */
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {

        if (args.length > 0 && !args[0].equalsIgnoreCase("Reload")) {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', messageInvalidSyntax)); // Send a message indicating invalid syntax

            return false;

        } else if (args.length == 1 && args[0].equalsIgnoreCase("Reload")) {

            if (sender.hasPermission(socialReloadPermission)) { // Check if the sender has the required permission

                this.main.reloadConfig(); // Reload the plugin's configuration
                Data.initialize(); // Re-initialize the data

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', messageReload)); // Send a message indicating successful reload
                return true;
            } else {

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', messageNoPermission)); // Send a message indicating no permission
                return false;
            }

        } else if (args.length > 1 && args[0].equalsIgnoreCase("Reload")) {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', messageInvalidSyntax)); // Send a message indicating invalid syntax
            return false;
        }

        if (sender instanceof Player) {

            if (!isMenu) {

                final Player player = (Player) sender;

                if (!player.hasPermission(socialUsePermission)) {

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messageNoPermission));
                    return false;
                }

                final Inventory gui = Bukkit.createInventory(player, menuSize, ChatColor.translateAlternateColorCodes('&', socialTitle)); // Create a new inventory GUI

                for (Links socialIcon : getLinks()) {

                    final String header = socialIcon.getHeader();

                    ItemStack itemStack = headSkinsCache.get(header);

                    if (itemStack == null) {
                        itemStack = HeadSkins.getHeadSkins().get(header);

                        if (itemStack != null) {
                            headSkinsCache.put(header, itemStack);
                        }
                    }

                    if (itemStack == null)
                        continue;

                    final ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', socialIcon.getDisplayName())); // Set the display name of the item

                    final ArrayList<String> itemStackLore = new ArrayList<>();

                    if (!socialIcon.isDisabled()) {

                        itemStackLore.add(ChatColor.translateAlternateColorCodes('&', messageAvailable)); // Add lore indicating the socialIcon is available
                    } else {

                        itemStackLore.add(ChatColor.translateAlternateColorCodes('&', messageNotAvailable)); // Add lore indicating the socialIcon is not available
                    }

                    itemMeta.setLore(itemStackLore);
                    itemStack.setItemMeta(itemMeta);

                    gui.setItem(socialIcon.getSlot(), itemStack); // Set the item in the GUI at the corresponding slot
                }

                final ItemStack close = new ItemStack(Material.BARRIER);

                final ItemMeta closeMeta = close.getItemMeta();
                closeMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close"); // Set the display name of the close item

                final ArrayList<String> closeLore = new ArrayList<>();
                closeLore.add(ChatColor.GOLD + "Close the Menu."); // Add lore explaining the functionality of the close item

                closeMeta.setLore(closeLore);
                close.setItemMeta(closeMeta);

                gui.setItem(this.main.getConfig().getInt("Social.Size") - 5, close); // Set the close item in the GUI

                player.openInventory(gui); // Open the GUI for the player

                return true;

            } else {

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', featureDisabled)); // Send a message indicating the feature is disabled
                return false;
            }

        } else {

            Log.info("Thank you for using the Social plugin. Version: " + ChatColor.GOLD + pluginVersion); // Log a message indicating plugin usage
        }

        return true; // Return true to indicate the command was executed successfully
    }
}
