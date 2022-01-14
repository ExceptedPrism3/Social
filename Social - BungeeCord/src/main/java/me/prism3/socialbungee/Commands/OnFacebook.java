package me.prism3.socialbungee.Commands;

import me.prism3.socialbungee.Main;
import me.prism3.socialbungee.Utils.ConfigManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class OnFacebook extends Command {

    public OnFacebook(){

        super("facebook");

    }

    @Override
    public void execute(CommandSender sender, String[] strings) {

        ConfigManager config = Main.getConfig();

        if (config.getBoolean("Social.Facebook")) {

            sender.sendMessage(new TextComponent(config.getString("Links.Facebook")));

        } else {

            sender.sendMessage(new TextComponent(config.getString("Messages.Not-Available")));

        }
    }
}
