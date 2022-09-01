package me.prism3.socialbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import static me.prism3.socialbungee.utils.Data.*;

public class OnInstagram extends Command {

    public OnInstagram() {
        super("instagram");
    }

    @Override
    public void execute(CommandSender sender, String[] strings) {

        if (isInstagram) {

            sender.sendMessage(new TextComponent(instagramLink));

        } else sender.sendMessage(new TextComponent(messageNotAvailable));
    }
}
