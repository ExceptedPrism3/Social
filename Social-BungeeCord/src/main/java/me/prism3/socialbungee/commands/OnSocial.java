package me.prism3.socialbungee.commands;

import me.prism3.socialbungee.Main;
import me.prism3.socialbungee.utils.Data;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import static me.prism3.socialbungee.utils.Data.*;

public class OnSocial extends Command {
    
    private final Main main = Main.getInstance();

    public OnSocial() {
        super("social");
    }

    @Override
    public void execute(final CommandSender sender, final String[] args) {

        if (args.length > 0 && !args[0].equalsIgnoreCase("Reload")) {

            sender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', invalidSyntax))); // Send a message indicating invalid syntax

        } else if (args.length == 1 && args[0].equalsIgnoreCase("Reload")) {

            // Check if the sender has the required permission
            if (sender.hasPermission(socialReloadPermission)) {

                this.main.getConfig().init();
                Data.initialize();
                sender.sendMessage(new TextComponent(messageReload));

            } else {

                sender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', messageNoPermission))); // Send a message indicating no permission
            }

        } else if (args.length > 1 && args[0].equalsIgnoreCase("Reload")) {

            sender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', invalidSyntax))); // Send a message indicating invalid syntax

        } else {

            sender.sendMessage(new TextComponent("Thank you for using the Social plugin. Version: " + ChatColor.GOLD + pluginVersion)); // Log a message indicating plugin usage

        }
    }
}
