package me.prism3.socialbungee.commands;

import me.prism3.socialbungee.utils.Links;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import static me.prism3.socialbungee.utils.Data.*;


/**
 * SubOnes is a command executor for the social command.
 * It sends a message containing a link to the provided URL.
 */
public class SubOnes extends Command {

    private final Links link;

    /**
     * Constructs a new SubOnes command executor.
     *
     * @param link the Links object containing the URL
     */
    public SubOnes(final Links link) {
        super(link.getHeader());
        this.link = link;
    }

    /**
     * Executes the links command.
     *
     * @param sender  the CommandSender executing the command
     * @param args    the command arguments
     */
    @Override
    public void execute(final CommandSender sender, final String[] args) {

        if (sender.hasPermission(socialUsePermission)) { // Check if the sender has the required permission

            sender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', this.link.getUrl()))); // Send the URL message

        } else {

            sender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', messageNoPermission))); // Send a message indicating no permission
        }
    }
}
