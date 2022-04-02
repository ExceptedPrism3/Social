package me.prism3.socialvelocity.Commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;

import static me.prism3.socialvelocity.Utils.Data.*;

public class OnYoutube implements SimpleCommand {

    @Override
    public void execute(Invocation invocation) {

        final CommandSource sender = invocation.source();

        if (isYoutube) {

            sender.sendMessage(Identity.nil(), Component.text(youtubeLink));

        } else sender.sendMessage(Identity.nil(), Component.text(messageNotAvailable));
    }
}
