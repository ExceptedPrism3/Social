package me.prism3.socialbukkit.utils.manager;

import me.prism3.socialbukkit.Main;
import me.prism3.socialbukkit.utils.Log;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


/**
 * Command is a utility class for registering custom commands in Bukkit.
 * It provides methods to register commands and retrieve the CommandMap.
 */
public final class CommandManager {

    private static final Main main = Main.getInstance();

    /**
     * Registers a custom command with the given name and executor.
     *
     * @param commandName the name of the command
     * @param executor    the executor for the command
     */
    public static void registerCommand(String commandName, CommandExecutor executor) {

        final PluginCommand command = getCommand(commandName);

        if (command != null) {

            command.setExecutor(executor);

            getCommandMap().register(main.getDescription().getName(), command);
        }
    }

    /**
     * Retrieves a PluginCommand with the given name.
     *
     * @param name the name of the command
     * @return the PluginCommand with the given name, or null if not found
     */
    private static PluginCommand getCommand(String name) {

        PluginCommand command = null;

        try {
            final Constructor<PluginCommand> constructor = PluginCommand.class.getDeclaredConstructor(String.class, Plugin.class);
            constructor.setAccessible(true);
            command = constructor.newInstance(name, main);

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {

            Log.severe("Failed to create PluginCommand: " + name +"\n" +
                    "If the issue persists contact the Author", e);
        }

        return command;
    }

    /**
     * Retrieves the CommandMap instance.
     *
     * @return the CommandMap instance
     */
    private static CommandMap getCommandMap() {

        CommandMap commandMap = null;

        try {
            final Field commandMapField = SimplePluginManager.class.getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            commandMap = (CommandMap) commandMapField.get(Bukkit.getPluginManager());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            Log.severe("Failed to access commandMap\n" +
                    "If the issue persists contact the Author", e);
        }

        return commandMap;
    }
}
