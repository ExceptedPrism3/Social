package me.prism3.socialvelocity.commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import me.prism3.socialvelocity.utils.Data;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;

import static me.prism3.socialvelocity.utils.Data.*;


/**
 * The OnSocial class is responsible for handling the "/social" command.
 */
public class OnSocial implements SimpleCommand {

    /**
     * Executes the "/social" command.
     *
     * @param invocation the command invocation
     */
    @Override
    public void execute(final Invocation invocation) {

        final CommandSource sender = invocation.source();
        final String[] args = invocation.arguments();

        if (args.length > 0 && !args[0].equalsIgnoreCase("Reload")) {

            // Invalid syntax
            this.sendMessage(sender, invalidSyntax, invalidSyntaxColor);
        } else if (args.length == 1 && args[0].equalsIgnoreCase("Reload")) {

            // Reload command
            // Check if the sender has the required permission
            if (sender.hasPermission(socialProxyReloadPermission)) {

                // Reload the plugin data
                Data.initialize();
                this.sendMessage(sender, messageReload, messageReloadColor);
            } else {

                // No permission to reload
                this.sendMessage(sender, messageNoPermission, messageNoPermissionColor);
            }
        } else if (args.length > 1 && args[0].equalsIgnoreCase("Reload")) {

            // Invalid syntax for reload command
            this.sendMessage(sender, invalidSyntax, invalidSyntaxColor);
        } else {

            // Default message
            final String version = "1.3";

            final Component message = Component.text()
                    .content("Thank you for using the Social plugin. Version: ")
                    .append(Component.text(version).color(NamedTextColor.GREEN))
                    .build();

            sender.sendMessage(Identity.nil(), message);
        }
    }

    /**
     * Sends a message to the command sender.
     *
     * @param sender  the command sender
     * @param message the message to send
     */
    private void sendMessage(final CommandSource sender, final String message, final String hexColor) {

        final Component messageComponent = Component.text(message).color(TextColor.fromHexString(hexColor));
        final Component pluginPrefixColored = Component.text(pluginPrefix).color(TextColor.fromHexString(pluginPrefixColor));

        final Component finalMessage = Component.join(Component.empty(), pluginPrefixColored, messageComponent);

        sender.sendMessage(Identity.nil(), finalMessage);
    }
}
