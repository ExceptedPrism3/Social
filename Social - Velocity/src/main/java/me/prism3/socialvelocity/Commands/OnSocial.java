package me.prism3.socialvelocity.Commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import me.prism3.socialvelocity.Main;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;

import static me.prism3.socialvelocity.Utils.Data.*;

public class OnSocial implements SimpleCommand {

    private final Main main = Main.getInstance();

    @Override
    public void execute(Invocation invocation) {

        final CommandSource sender = invocation.source();
        final String[] args = invocation.arguments();

        if (sender.hasPermission(socialProxyReload)) {

            if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("help"))) {

                if (sender instanceof Player) {

                    final StringBuilder SM = new StringBuilder();

                    for (String line : helpMessages) SM.append(line).append('\n');

                    sender.sendMessage(Identity.nil(), Component.text(SM.toString()));

                } else this.main.getLogger().info("Thank you for using the Social Plugin!");
            } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {

                this.main.getConfig().reload();
                sender.sendMessage(Identity.nil(), Component.text(messageReload));

            } else sender.sendMessage(Identity.nil(), Component.text(invalidSyntax));
        } else sender.sendMessage(Identity.nil(), Component.text(messageNoPermission));
    }
}
