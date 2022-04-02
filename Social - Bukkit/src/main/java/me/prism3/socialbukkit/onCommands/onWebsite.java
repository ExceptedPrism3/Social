package me.prism3.socialbukkit.onCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.prism3.socialbukkit.Utils.Data.*;

public class onWebsite implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender.hasPermission(socialUse)) {

            if (!isWebsite) {

                sender.sendMessage(websiteLink);

            } else {

                sender.sendMessage(messageNotAvailable);
                return false;

            }

        } else {

            sender.sendMessage(messageNoPermission);
            return false;

        }
        return true;
    }
}
