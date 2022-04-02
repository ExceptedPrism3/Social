package me.prism3.socialbungee.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import static me.prism3.socialbungee.Utils.Data.*;

public class OnTwitch extends Command {

    public OnTwitch(){
        super("twitch");
    }

    @Override
    public void execute(CommandSender sender, String[] strings) {

        if (isTwitch) {

            sender.sendMessage(new TextComponent(twitchLink));

        } else sender.sendMessage(new TextComponent(messageNotAvailable));
    }
}
