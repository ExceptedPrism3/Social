package me.prism3.socialvelocity.utils.manager;

import com.velocitypowered.api.command.Command;
import com.velocitypowered.api.proxy.ProxyServer;
import me.prism3.socialvelocity.Main;


/**
 * The CommandManager class is responsible for managing custom commands in the plugin.
 * It provides a method to register a custom command with the Velocity server's command manager.
 */
public final class CommandManager {

    private static final ProxyServer proxyServer = Main.getInstance().getServer();

    private CommandManager() {}

    /**
     * Registers a custom command with the given name and executor.
     *
     * @param commandName the name of the command
     * @param command     the command instance
     */
    public static void registerCommand(final String commandName, final Command command) {
        proxyServer.getCommandManager().register(commandName, command);
    }
}
