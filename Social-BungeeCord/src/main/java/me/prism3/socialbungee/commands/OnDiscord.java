package me.prism3.socialbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import static me.prism3.socialbungee.utils.Data.*;

public class OnDiscord extends Command {

    public OnDiscord() { super("discord"); }

    @Override
    public void execute(CommandSender sender, String[] Strings) {

        if (isDiscord) {

            sender.sendMessage(new TextComponent(discordLink));

        } else sender.sendMessage(new TextComponent(messageNotAvailable));
    }
}
