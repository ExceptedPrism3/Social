package me.prism3.socialbungee.commands;

import me.prism3.socialbungee.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

import static me.prism3.socialbungee.utils.Data.*;

public class OnSocial extends Command {
    
    private final Main main = Main.getInstance();

    public OnSocial() {
        super("social");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (sender.hasPermission(socialProxyReload)) {

            if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("help"))) {

                final StringBuilder sm = new StringBuilder();
                for (String line : helpMessages) sm.append(line).append('\n');

                sender.sendMessage(new TextComponent(sm.toString()));

            } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {

                this.main.getConfig().init();
                sender.sendMessage(new TextComponent(messageReload));

            } else sender.sendMessage(new TextComponent(invalidSyntax));
        } else sender.sendMessage(new TextComponent(messageNoPermission));
    }
}
