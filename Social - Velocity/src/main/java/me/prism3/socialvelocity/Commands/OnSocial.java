package me.prism3.socialvelocity.Commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import me.prism3.socialvelocity.Main;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;

import java.util.List;

public class OnSocial implements SimpleCommand {

    @Override
    public void execute(Invocation invocation) {

        Main main = Main.getInstance();
        CommandSource sender = invocation.source();
        String[] args = invocation.arguments();

        if (sender.hasPermission("socialproxy.reload")) {

            if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("help"))) {

                if (sender instanceof Player) {

                    List<String> lines = main.getConfig().getStringList("Messages.Social-Help");

                    StringBuilder SM = new StringBuilder();

                    for (String line : lines)
                        SM.append(line).append('\n');

                    sender.sendMessage(Identity.nil(), Component.text(SM.toString()));

                } else {

                   main.getLogger().info("Thank you for using the Social Plugin!");
                }

            } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {

                main.getConfig().reload();
                sender.sendMessage(Identity.nil(), Component.text(main.getConfig().getString("Messages.Reload")));

            } else {

                sender.sendMessage(Identity.nil(), Component.text(main.getConfig().getString("Messages.Invalid-Syntax")));

            }
        } else {

            sender.sendMessage(Identity.nil(), Component.text(main.getConfig().getString("Messages.No-Permission")));

        }
    }
}
