package me.prism3.socialvelocity.commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;

import static me.prism3.socialvelocity.utils.Data.*;

public class OnFacebook implements SimpleCommand {

    @Override
    public void execute(Invocation invocation) {

        final CommandSource sender = invocation.source();

        if (isFacebook) {

            sender.sendMessage(Identity.nil(), Component.text(facebookLink));

        } else sender.sendMessage(Identity.nil(), Component.text(messageNotAvailable));
    }
}
