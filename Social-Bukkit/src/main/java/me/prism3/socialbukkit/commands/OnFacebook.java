package me.prism3.socialbukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.prism3.socialbukkit.utils.Data.*;

public class OnFacebook implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender.hasPermission(socialUse)) {

            if (!isFacebook) {

                sender.sendMessage(facebookLink);

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
