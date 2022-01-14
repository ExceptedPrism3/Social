package me.prism3.socialvelocity.Commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import me.prism3.socialvelocity.Main;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;

public class OnStore implements SimpleCommand {

    @Override
    public void execute(Invocation invocation) {

        Main main = Main.getInstance();
        CommandSource sender = invocation.source();

        if (main.getConfig().getBoolean("Social.Store")) {

            sender.sendMessage(Identity.nil(), Component.text(main.getConfig().getString("Links.Store")));

        } else {

            sender.sendMessage(Identity.nil(), Component.text(main.getConfig().getString("Messages.Not-Available")));

        }
    }
}
