package me.prism3.socialbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import static me.prism3.socialbungee.utils.Data.*;

public class OnStore extends Command {

    public OnStore() {
        super("store");
    }

    public void execute(CommandSender sender, String[] strings) {

        if (isStore) {

            sender.sendMessage(new TextComponent(storeLink));

        } else sender.sendMessage(new TextComponent(messageNotAvailable));
    }
}
