package me.prism3.socialbungee.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import static me.prism3.socialbungee.Utils.Data.*;

public class OnYoutube extends Command {

    public OnYoutube(){
        super("youtube");
    }

    @Override
    public void execute(CommandSender sender, String[] strings) {

        if (isYoutube) {

            sender.sendMessage(new TextComponent(youtubeLink));

        } else sender.sendMessage(new TextComponent(messageNotAvailable));
    }
}
