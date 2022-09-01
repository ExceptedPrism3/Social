package me.prism3.socialbukkit.commands;

import me.prism3.socialbukkit.Main;
import me.prism3.socialbukkit.utils.Data;
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

import static me.prism3.socialbukkit.utils.Data.*;
import static me.prism3.socialbukkit.utils.HeadSkins.*;

public class OnSocial implements CommandExecutor {

    private final Main main = Main.getInstance();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 0 && !args[0].equalsIgnoreCase("Reload")) {

            sender.sendMessage(messageInvalidSyntax);
            return false;

        }

        else if (args.length == 1 && args[0].equalsIgnoreCase("Reload")) {

            if (sender.hasPermission(socialReload)) {

                this.main.reloadConfig();
                this.main.initializeData(new Data());
                sender.sendMessage(messageReload);

            } else sender.sendMessage(messageNoPermission);

        } else if (args.length > 1 && args[0].equalsIgnoreCase("Reload")) {

            sender.sendMessage(messageInvalidSyntax);

        } else if (!isMenu) {

            if (sender instanceof Player && sender.hasPermission(socialUse)) {

                final Player player = (Player) sender;

                final Inventory gui = Bukkit.createInventory(player, menuSize, socialTitle);

                // Icons Declaration
                final ItemStack website = WebsiteSkin();
                final ItemStack youtube = YoutubeSkin();
                final ItemStack facebook = FacebookSkin();
                final ItemStack twitch = TwitchSkin();
                final ItemStack discord = DiscordSkin();
                final ItemStack instagram = InstagramSkin();
                final ItemStack store = StoreSkin();
                final ItemStack close = new ItemStack(Material.BARRIER);

                // Website Icon
                final ItemMeta websiteMeta = website.getItemMeta();
                assert websiteMeta != null;
                websiteMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Website");
                final ArrayList<String> websiteLore = new ArrayList<>();

                if (!isWebsite) {

                    websiteLore.add(ChatColor.RED + messageAvailable);

                } else {

                    websiteLore.add(ChatColor.RED + messageNotAvailable);

                }

                websiteMeta.setLore(websiteLore);
                website.setItemMeta(websiteMeta);

                // Youtube Icon
                final ItemMeta youtubeMeta = youtube.getItemMeta();
                assert youtubeMeta != null;
                youtubeMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Youtube");
                final ArrayList<String> youtubeLore = new ArrayList<>();

                if (!isYoutube) {

                    youtubeLore.add(ChatColor.RED + messageAvailable);

                } else {

                    youtubeLore.add(ChatColor.RED + messageNotAvailable);

                }

                youtubeMeta.setLore(youtubeLore);
                youtube.setItemMeta(youtubeMeta);

                // Facebook Icon
                final ItemMeta facebookMeta = facebook.getItemMeta();
                assert facebookMeta != null;
                facebookMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Facebook");
                final ArrayList<String> facebookLore = new ArrayList<>();

                if (!isFacebook) {

                    facebookLore.add(ChatColor.RED + messageAvailable);

                } else {

                    facebookLore.add(ChatColor.RED + messageNotAvailable);

                }

                facebookMeta.setLore(facebookLore);
                facebook.setItemMeta(facebookMeta);

                // Twitch Icon
                final ItemMeta twitchMeta = twitch.getItemMeta();
                assert twitchMeta != null;
                twitchMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Twitch");
                final ArrayList<String> twitchLore = new ArrayList<>();

                if (!isTwitch) {

                    twitchLore.add(ChatColor.RED + messageAvailable);

                } else {

                    twitchLore.add(ChatColor.RED + messageNotAvailable);

                }

                twitchMeta.setLore(twitchLore);
                twitch.setItemMeta(twitchMeta);

                // Discord Icon
                final ItemMeta discordMeta = discord.getItemMeta();
                assert discordMeta != null;
                discordMeta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Discord");
                final ArrayList<String> discordLore = new ArrayList<>();

                if (!isDiscord) {

                    discordLore.add(ChatColor.RED + messageAvailable);

                } else {

                    discordLore.add(ChatColor.RED + messageNotAvailable);

                }

                discordMeta.setLore(discordLore);
                discord.setItemMeta(discordMeta);

                // Instagram Icon
                final ItemMeta instagramMeta = instagram.getItemMeta();
                assert instagramMeta != null;
                instagramMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Instagram");
                final ArrayList<String> instagramLore = new ArrayList<>();

                if (!isInstagram) {

                    instagramLore.add(ChatColor.RED + messageAvailable);

                } else {

                    instagramLore.add(ChatColor.RED + messageNotAvailable);

                }

                instagramMeta.setLore(instagramLore);
                instagram.setItemMeta(instagramMeta);

                // Store Icon
                final ItemMeta storeMeta = store.getItemMeta();
                assert storeMeta != null;
                storeMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Store");
                final ArrayList<String> storeLore = new ArrayList<>();

                if (!isStore) {

                    storeLore.add(ChatColor.RED + messageAvailable);

                } else {

                    storeLore.add(ChatColor.RED + messageNotAvailable);

                }

                storeMeta.setLore(storeLore);
                store.setItemMeta(storeMeta);

                // Close Icon
                final ItemMeta closeMeta = close.getItemMeta();
                assert closeMeta != null;
                closeMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close");
                final ArrayList<String> closeLore = new ArrayList<>();
                closeLore.add(ChatColor.GOLD + "Close the Menu.");
                closeMeta.setLore(closeLore);
                close.setItemMeta(closeMeta);

                // Setting the Icons
                gui.setItem(this.main.getConfig().getInt("Website.Slot"), website);

                gui.setItem(this.main.getConfig().getInt("Youtube.Slot"), youtube);

                gui.setItem(this.main.getConfig().getInt("Facebook.Slot"), facebook);

                gui.setItem(this.main.getConfig().getInt("Twitch.Slot"), twitch);

                gui.setItem(this.main.getConfig().getInt("Discord.Slot"), discord);

                gui.setItem(this.main.getConfig().getInt("Instagram.Slot"), instagram);

                gui.setItem(this.main.getConfig().getInt("Store.Slot"), store);

                gui.setItem(this.main.getConfig().getInt("Social.Size") - 5, close);

                player.openInventory(gui);

            } else this.main.getLogger().severe("Thank you for using the Social plugin. Version: " + ChatColor.GOLD + this.main.getDescription().getVersion());

        } else {

            sender.sendMessage(featureDisabled);
            return false;
        }
        return true;
    }
}
