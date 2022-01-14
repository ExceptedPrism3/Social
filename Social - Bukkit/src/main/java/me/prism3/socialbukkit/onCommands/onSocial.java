package me.prism3.socialbukkit.onCommands;

import me.prism3.socialbukkit.Main;
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
import java.util.Objects;

import static me.prism3.socialbukkit.Utils.HeadSkins.*;

public class onSocial implements CommandExecutor {

    private final Main main = Main.getInstance();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 0 && !args[0].equalsIgnoreCase("Reload")) {

            sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Invalid-Syntax")).replaceAll("&", "§"));

            return false;
        }

        else if (args.length == 1 && args[0].equalsIgnoreCase("Reload")) {

            if (sender.hasPermission("social.reload")) {

                main.reloadConfig();
                sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Reload-Message")).replaceAll("&", "§"));

            } else {

                sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.No-Permission")).replaceAll("&", "§"));

            }

        } else if (args.length > 1 && args[0].equalsIgnoreCase("Reload")) {

            sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Invalid-Syntax")).replaceAll("&", "§"));


        } else if (!main.getConfig().getBoolean("Social.Disable-Menu")){

            if (sender instanceof Player && sender.hasPermission("social.use")) {

                Player player = (Player) sender;

                Inventory GUI = Bukkit.createInventory(player, main.getConfig().getInt("Social.Size"), Objects.requireNonNull(main.getConfig().getString("Social.Title")).replaceAll("&", "§"));

                //Declaring the Icons
                ItemStack Website = WebsiteSkin();
                ItemStack Youtube = YoutubeSkin();
                ItemStack Facebook = FacebookSkin();
                ItemStack Twitch = TwitchSkin();
                ItemStack Discord = DiscordSkin();
                ItemStack Instagram = InstagramSkin();
                ItemStack Store = StoreSkin();
                ItemStack Close = new ItemStack(Material.BARRIER);


                //Website Icon
                ItemMeta WebsiteMeta = Website.getItemMeta();
                assert WebsiteMeta != null;
                WebsiteMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Website");
                ArrayList<String> WebsiteLore = new ArrayList<>();
                if (!main.getConfig().getBoolean("Website.Disabled")) {

                    WebsiteLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Available")).replaceAll("&", "§"));
                    WebsiteMeta.setLore(WebsiteLore);
                    Website.setItemMeta(WebsiteMeta);

                } else if (main.getConfig().getBoolean("Website.Disabled")) {

                    WebsiteLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                    WebsiteMeta.setLore(WebsiteLore);
                    Website.setItemMeta(WebsiteMeta);

                }

                //Youtube Icon
                ItemMeta YoutubeMeta = Youtube.getItemMeta();
                assert YoutubeMeta != null;
                YoutubeMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Youtube");
                ArrayList<String> YoutubeLore = new ArrayList<>();
                if (!main.getConfig().getBoolean("Youtube.Disabled")) {

                    YoutubeLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Available")).replaceAll("&", "§"));
                    YoutubeMeta.setLore(YoutubeLore);
                    Youtube.setItemMeta(YoutubeMeta);

                } else if (main.getConfig().getBoolean("Youtube.Disabled")) {

                    YoutubeLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                    YoutubeMeta.setLore(YoutubeLore);
                    Youtube.setItemMeta(YoutubeMeta);

                }

                //Facebook Icon
                ItemMeta FacebookMeta = Facebook.getItemMeta();
                assert FacebookMeta != null;
                FacebookMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Facebook");
                ArrayList<String> FacebookLore = new ArrayList<>();
                if (!main.getConfig().getBoolean("Facebook.Disabled")) {

                    FacebookLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Available")).replaceAll("&", "§"));
                    FacebookMeta.setLore(FacebookLore);
                    Facebook.setItemMeta(FacebookMeta);

                } else if (main.getConfig().getBoolean("Facebook.Disabled")) {

                    FacebookLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                    FacebookMeta.setLore(FacebookLore);
                    Facebook.setItemMeta(FacebookMeta);

                }

                //Twitch Icon
                ItemMeta TwitchMeta = Twitch.getItemMeta();
                assert TwitchMeta != null;
                TwitchMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Twitch");
                ArrayList<String> TwitchLore = new ArrayList<>();
                if (!main.getConfig().getBoolean("Twitch.Disabled")) {

                    TwitchLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Available")).replaceAll("&", "§"));
                    TwitchMeta.setLore(TwitchLore);
                    Twitch.setItemMeta(TwitchMeta);

                } else if (main.getConfig().getBoolean("Twitch.Disabled")) {

                    TwitchLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                    TwitchMeta.setLore(TwitchLore);
                    Twitch.setItemMeta(TwitchMeta);

                }

                //Discord Icon
                ItemMeta DiscordMeta = Discord.getItemMeta();
                assert DiscordMeta != null;
                DiscordMeta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Discord");
                ArrayList<String> DiscordLore = new ArrayList<>();
                if (!main.getConfig().getBoolean("Discord.Disabled")) {

                    DiscordLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Available")).replaceAll("&", "§"));
                    DiscordMeta.setLore(DiscordLore);
                    Discord.setItemMeta(DiscordMeta);

                } else if (main.getConfig().getBoolean("Discord.Disabled")) {

                    DiscordLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                    DiscordMeta.setLore(DiscordLore);
                    Discord.setItemMeta(DiscordMeta);

                }

                //Instagram Icon
                ItemMeta InstagramMeta = Instagram.getItemMeta();
                assert InstagramMeta != null;
                InstagramMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Instagram");
                ArrayList<String> InstagramLore = new ArrayList<>();
                if (!main.getConfig().getBoolean("Instagram.Disabled")) {

                    InstagramLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Available")).replaceAll("&", "§"));
                    InstagramMeta.setLore(InstagramLore);
                    Instagram.setItemMeta(InstagramMeta);

                } else if (main.getConfig().getBoolean("Instagram.Disabled")) {

                    InstagramLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                    InstagramMeta.setLore(InstagramLore);
                    Instagram.setItemMeta(InstagramMeta);

                }


                //Store Icon
                ItemMeta StoreMeta = Store.getItemMeta();
                assert StoreMeta != null;
                StoreMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Store");
                ArrayList<String> StoreLore = new ArrayList<>();
                if (!main.getConfig().getBoolean("Store.Disabled")) {

                    StoreLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Available")).replaceAll("&", "§"));
                    StoreMeta.setLore(StoreLore);
                    Store.setItemMeta(StoreMeta);

                } else if (main.getConfig().getBoolean("Store.Disabled")) {

                    StoreLore.add(ChatColor.RED + Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));
                    StoreMeta.setLore(StoreLore);
                    Store.setItemMeta(StoreMeta);

                }

                //Close Icon

                ItemMeta CloseMeta = Close.getItemMeta();
                assert CloseMeta != null;
                CloseMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close");
                ArrayList<String> CloseLore = new ArrayList<>();
                CloseLore.add(ChatColor.GOLD + "Close the Menu.");
                CloseMeta.setLore(CloseLore);
                Close.setItemMeta(CloseMeta);


                //Setting the Icons
                GUI.setItem(main.getConfig().getInt("Website.Slot"), Website);

                GUI.setItem(main.getConfig().getInt("Youtube.Slot"), Youtube);

                GUI.setItem(main.getConfig().getInt("Facebook.Slot"), Facebook);

                GUI.setItem(main.getConfig().getInt("Twitch.Slot"), Twitch);

                GUI.setItem(main.getConfig().getInt("Discord.Slot"), Discord);

                GUI.setItem(main.getConfig().getInt("Instagram.Slot"), Instagram);

                GUI.setItem(main.getConfig().getInt("Store.Slot"), Store);

                GUI.setItem(main.getConfig().getInt("Social.Size") - 5, Close);

                player.openInventory(GUI);
            } else {

                main.getLogger().severe("This command can only be executed in-game!");

            }

        }else if (main.getConfig().getBoolean("Social.Disable-Menu")){

            sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Feature-Disabled")).replaceAll("&", "§"));

            return false;
        }
        return true;
    }
}
