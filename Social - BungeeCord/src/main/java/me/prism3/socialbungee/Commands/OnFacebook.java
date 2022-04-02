package me.prism3.socialbungee.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import static me.prism3.socialbungee.Utils.Data.*;

public class OnFacebook extends Command {

    public OnFacebook(){
        super("facebook");
    }

    @Override
    public void execute(CommandSender sender, String[] strings) {

        if (isFacebook) {

            sender.sendMessage(new TextComponent(facebookLink));

        } else sender.sendMessage(new TextComponent(messageNotAvailable));
    }
}
