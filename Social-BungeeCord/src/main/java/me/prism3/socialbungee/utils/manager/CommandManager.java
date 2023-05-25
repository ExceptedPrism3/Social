package me.prism3.socialbungee.utils.manager;

import me.prism3.socialbungee.Main;
import me.prism3.socialbungee.utils.Log;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.PluginManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * CommandManager is a utility class for registering custom commands in BungeeCord.
 * It provides methods to register commands and retrieve the PluginManager.
 */
public final class CommandManager {

    private static final Main main = Main.getInstance();

    /**
     * Registers a custom command with the given name and executor.
     *
     * @param commandName the name of the command
     * @param command     the command instance
     */
    public static void registerCommand(final String commandName, final Command command) {

        PluginManager pluginManager = getPluginManager();
        pluginManager.registerCommand(main, command);
    }

    /**
     * Creates a custom command with the given name and executor class.
     *
     * @param commandName     the name of the command
     * @param commandClass    the command class
     * @return the created Command instance
     */
    private static Command createCommand(final String commandName, final Class<? extends Command> commandClass) {

        Constructor<? extends Command> constructor;

        try {

            constructor = commandClass.getConstructor(String.class);
            constructor.setAccessible(true);

            return constructor.newInstance(commandName);
        } catch (final NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {

            Log.severe("Failed to create command: " + commandName, e);

            return null;
        }
    }

    /**
     * Retrieves the PluginManager instance.
     *
     * @return the PluginManager instance
     */
    private static PluginManager getPluginManager() { return main.getProxy().getPluginManager(); }
}
