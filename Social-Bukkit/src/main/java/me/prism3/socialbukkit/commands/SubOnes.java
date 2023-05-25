package me.prism3.socialbukkit.commands;

import me.prism3.socialbukkit.utils.Links;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.prism3.socialbukkit.utils.Data.*;


/**
 * SubOnes is a command executor for the social command.
 * It sends a message containing a link to the provided URL.
 */
public class SubOnes implements CommandExecutor {

    private final Links link;

    /**
     * Constructs a new SubOnes command executor.
     *
     * @param link the Links object containing the URL
     */
    public SubOnes(final Links link) { this.link = link; }

    /**
     * Executes the links command.
     *
     * @param sender  the CommandSender executing the command
     * @param command the CommandManager instance
     * @param label   the command label
     * @param args    the command arguments
     * @return true if the command was executed successfully, false otherwise
     */
    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {

        if (sender.hasPermission(socialUsePermission)) { // Check if the sender has the required permission

            if (!link.isDisabled()) { // Check if the link is not disabled

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', link.getUrl())); // Send the URL message
            } else {

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', messageNotAvailable)); // Send a message indicating the link is not available
            }
        } else {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', messageNoPermission)); // Send a message indicating no permission
        }

        return true; // Return true to indicate the command was executed successfully
    }
}
