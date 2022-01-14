package me.prism3.socialbungee.Commands;

import me.prism3.socialbungee.Main;
import me.prism3.socialbungee.Utils.ConfigManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class OnStore extends Command {

    public OnStore(){

        super("store");

    }

    public void execute(CommandSender sender, String[] strings) {

        ConfigManager config = Main.getConfig();

        if (config.getBoolean("Social.Store")) {

            sender.sendMessage(new TextComponent(config.getString("Links.Store")));

        } else {

            sender.sendMessage(new TextComponent(config.getString("Messages.Not-Available")));

        }
    }
}
