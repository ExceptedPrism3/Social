package me.prism3.socialbungee.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import static me.prism3.socialbungee.Utils.Data.*;

public class OnWebsite extends Command {

    public OnWebsite(){
        super("website");
    }

    @Override
    public void execute(CommandSender sender, String[] strings) {

        if (isWebsite) {

            sender.sendMessage(new TextComponent(websiteLink));

        } else sender.sendMessage(new TextComponent(messageNotAvailable));
    }
}
