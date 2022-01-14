package me.prism3.socialbungee.Commands;

import me.prism3.socialbungee.Main;
import me.prism3.socialbungee.Utils.ConfigManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class OnYoutube extends Command {

    public OnYoutube(){

        super("youtube");

    }

    @Override
    public void execute(CommandSender sender, String[] strings) {

        ConfigManager config = Main.getConfig();

        if (config.getBoolean("Social.Website")) {

            sender.sendMessage(new TextComponent(config.getString("Links.Youtube")));

        } else {

            sender.sendMessage(new TextComponent(config.getString("Messages.Not-Available")));

        }
    }
}
