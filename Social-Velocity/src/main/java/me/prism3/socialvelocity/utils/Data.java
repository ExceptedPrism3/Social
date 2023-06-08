package me.prism3.socialvelocity.utils;

import me.prism3.socialvelocity.Main;
import me.prism3.socialvelocity.commands.OnSocial;
import me.prism3.socialvelocity.commands.SubOnes;
import me.prism3.socialvelocity.utils.manager.CommandManager;
import me.prism3.socialvelocity.utils.manager.LinkManager;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * The Data class is responsible for initializing various configuration settings, permissions, commands, and events for the plugin.
 * This class stores static fields that can be accessed by other classes throughout the plugin.
 */
public class Data {

    private static final Main main = Main.getInstance();

    private static final String PREFIX_KEY = "Messages.Prefix";
    private static final String MESSAGE_RELOAD_KEY = "Messages.Reload";
    private static final String MESSAGE_NO_PERMISSION_KEY = "Messages.No-Permission";
    private static final String MESSAGE_INVALID_SYNTAX_KEY = "Messages.Invalid-Syntax";

    // Color Side
    private static final String COLOR_PREFIX_KEY = "Colors.Prefix";
    private static final String COLOR_MESSAGE_RELOAD_KEY = "Colors.Reload";
    private static final String COLOR_NO_PERMISSION_KEY = "Colors.No-Permission";
    private static final String COLOR_INVALID_SYNTAX_KEY = "Colors.Invalid-Syntax";

    private static List<Links> links;

    public static String pluginPrefix;
    public static String messageReload;
    public static String messageNoPermission;
    public static String invalidSyntax;
    public static String pluginPrefixColor;
    public static String messageReloadColor;
    public static String messageNoPermissionColor;
    public static String invalidSyntaxColor;

    public static String socialProxyUsePermission;
    public static String socialProxyReloadPermission;

    private Data() {}

    /**
     * Initializes the Data class by initializing strings, permissions, and commands.
     */
    public static void initialize() {

        initializeStrings();
        initializePermissionStrings();

        final LinkManager linkManager = new LinkManager();
        links = linkManager.getLinks();

        initializeCommands();
    }

    private static void initializeStrings() {

        pluginPrefix = getConfigValue(PREFIX_KEY);
        messageReload = getConfigValue(MESSAGE_RELOAD_KEY);
        messageNoPermission = getConfigValue(MESSAGE_NO_PERMISSION_KEY);
        invalidSyntax = getConfigValue(MESSAGE_INVALID_SYNTAX_KEY);

        // Color side
        pluginPrefixColor = getHexStringConf(COLOR_PREFIX_KEY);
        messageReloadColor = getHexStringConf(COLOR_MESSAGE_RELOAD_KEY);
        messageNoPermissionColor = getHexStringConf(COLOR_NO_PERMISSION_KEY);
        invalidSyntaxColor = getHexStringConf(COLOR_INVALID_SYNTAX_KEY);
    }

    private static void initializePermissionStrings() {

        socialProxyUsePermission = "socialproxy.use";
        socialProxyReloadPermission = "socialproxy.reload";
    }

    private static void initializeCommands() {

        main.getServer().getCommandManager().register("social", new OnSocial());

        for (Links link : links)
            CommandManager.registerCommand(link.getHeader(), new SubOnes(link));
    }

    /**
     * Retrieves the hex color string value associated with the given key.
     *
     * @param key          the key to retrieve the value for
     * @return the hex color value from the configuration, or white string if not found
     */
    private static String getHexStringConf(final String key) { return main.getConfig().getString(key, "#FFFFFF"); }

    public static String getConfigValue(final String path) {

        try (final FileReader fileReader = new FileReader(main.getConfig().getConfigFile())) {

            final Yaml yaml = new Yaml();
            final Map<String, Object> config = yaml.load(fileReader);

            // Traverse the nested keys to retrieve the value
            final String[] keys = path.split("\\.");
            Object value = config;

            for (String key : keys) {

                if (value instanceof Map) {
                    value = ((Map<?, ?>) value).get(key);
                } else {
                    value = null;
                    break;
                }
            }

            if (value != null)
                return value.toString();

        } catch (final IOException e) { e.printStackTrace(); }

        return ""; // Return the defaultValue if the value is not found or an error occurs
    }
}
