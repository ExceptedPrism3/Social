package me.prism3.socialbukkit.onCommands;

import me.prism3.socialbukkit.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class onWebsite implements CommandExecutor {

    private final Main main = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender.hasPermission("social.use")) {

            if (!main.getConfig().getBoolean("Website.Disabled")) {

                sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Website.Link")).replaceAll("&", "§"));

            } else {

                sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§"));

            }

        } else {

            sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("Messages.No-Permission")).replaceAll("&", "§"));

        }
        return true;
    }
}
