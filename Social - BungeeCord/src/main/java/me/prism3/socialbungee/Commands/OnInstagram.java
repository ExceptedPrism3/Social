package me.prism3.socialbungee.Commands;

import me.prism3.socialbungee.Main;
import me.prism3.socialbungee.Utils.ConfigManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class OnInstagram extends Command{

    public OnInstagram() {

        super("instagram");

    }

    @Override
    public void execute(CommandSender sender, String[] strings) {

        ConfigManager config = Main.getConfig();

        if (config.getBoolean("Social.Instagram")) {

            sender.sendMessage(new TextComponent(config.getString("Links.Instagram")));

        } else {

            sender.sendMessage(new TextComponent(config.getString("Messages.Not-Available")));

        }
    }
}
