package me.prism3.socialvelocity.commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import me.prism3.socialvelocity.utils.Links;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

import static me.prism3.socialvelocity.utils.Data.*;


/**
 * SubOnes is a command executor for the social command.
 * It sends a message containing a link to the provided URL.
 */
public class SubOnes implements SimpleCommand {

    private final Links link;

    /**
     * Constructs a new SubOnes command executor.
     *
     * @param link the Links object containing the URL
     */
    public SubOnes(final Links link) { this.link = link; }

    /**
     * Executes the social command and sends a message containing the URL.
     *
     * @param invocation the command invocation context
     */
    @Override
    public void execute(final Invocation invocation) {

        final CommandSource sender = invocation.source();

        if (sender.hasPermission(socialProxyUsePermission)) { // Check if the sender has the required permission

            final Component messageComponent = Component.text(this.link.getUrl())
                    .color(TextColor.fromHexString(this.link.getHexColor()));

            sender.sendMessage(Identity.nil(), messageComponent); // Send the URL message

        } else {

            final Component noPermissionComponent = Component.text(messageNoPermission)
                    .color(TextColor.fromHexString(messageNoPermissionColor));

            sender.sendMessage(Identity.nil(), noPermissionComponent); // Send a message indicating no permission
        }
    }
}
