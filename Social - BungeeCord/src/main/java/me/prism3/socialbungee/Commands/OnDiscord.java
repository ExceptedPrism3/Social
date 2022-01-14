package me.prism3.socialbungee.Commands;

import me.prism3.socialbungee.Main;
import me.prism3.socialbungee.Utils.ConfigManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class OnDiscord extends Command {

    public OnDiscord() {

        super("discord");
    }


    @Override
    public void execute(CommandSender sender, String[] Strings) {

        ConfigManager config = Main.getConfig();

        if (config.getBoolean("Social.Discord")) {

            sender.sendMessage(new TextComponent(config.getString("Links.Discord")));

        } else {

            sender.sendMessage(new TextComponent(config.getString("Messages.Not-Available")));

        }
    }
}
