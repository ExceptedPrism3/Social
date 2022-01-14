package me.prism3.socialbungee.Commands;

import me.prism3.socialbungee.Main;
import me.prism3.socialbungee.Utils.ConfigManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.List;

public class OnSocial extends Command {

    public OnSocial(){

        super("social");

    }

    @Override
    public void execute(CommandSender sender, String[] args){

        ConfigManager config = Main.getConfig();
        Main main = Main.getInstance();

        if (sender.hasPermission("socialproxy.reload")) {

            if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("help"))) {

                if (sender instanceof ProxiedPlayer) {

                    List<String> lines = config.getStringList("Messages.Social-Help");
                    StringBuilder SM = new StringBuilder();
                    for (String line : lines) SM.append(line).append('\n');

                    sender.sendMessage(new TextComponent(SM.toString()));

                } else {

                    main.getLogger().info("Thank you for using the Social Plugin!");

                }

            } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {

                config.init();
                sender.sendMessage(new TextComponent(config.getString("Messages.Reload")));

            } else {

                sender.sendMessage(new TextComponent(config.getString("Messages.Invalid-Syntax")));

            }
        } else {

            sender.sendMessage(new TextComponent(config.getString("Messages.No-Permission")));

        }
    }
}
