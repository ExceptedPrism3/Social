package me.prism3.socialbungee.utils.manager;

import me.prism3.socialbungee.Main;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.PluginManager;


/**
 * CommandManager is a utility class for registering custom commands in BungeeCord.
 * It provides methods to register commands and retrieve the PluginManager.
 */
public final class CommandManager {

    private static final Main main = Main.getInstance();

    /**
     * Registers a custom command with the given name and executor.
     *
     * @param command     the command instance
     */
    public static void registerCommand(final Command command) {

        final PluginManager pluginManager = getPluginManager();
        pluginManager.registerCommand(main, command);
    }

    /**
     * Retrieves the PluginManager instance.
     *
     * @return the PluginManager instance
     */
    private static PluginManager getPluginManager() { return main.getProxy().getPluginManager(); }
}
