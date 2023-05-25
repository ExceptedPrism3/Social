package me.prism3.socialbukkit.utils;

import me.prism3.socialbukkit.Main;
import me.prism3.socialbukkit.events.ClickEvent;
import me.prism3.socialbukkit.utils.manager.CommandManager;
import me.prism3.socialbukkit.commands.OnSocial;
import me.prism3.socialbukkit.commands.SubOnes;
import me.prism3.socialbukkit.utils.manager.LinkManager;

import java.util.List;


/**
 * The Data class is responsible for initializing various configuration settings, permissions, commands, and events for the plugin.
 * This class stores static fields that can be accessed by other classes throughout the plugin.
 */
public class Data {

    private static final Main main = Main.getInstance();

    private static List<Links> links;

    public static final String PLUGIN_PREFIX_KEY = "Messages.Prefix";
    public static final String MESSAGE_AVAILABLE_KEY = "Messages.Available";
    public static final String MESSAGE_NOT_AVAILABLE_KEY = "Messages.Not-Available";
    public static final String MESSAGE_NO_PERMISSION_KEY = "Messages.No-Permission";
    public static final String MESSAGE_INVALID_SYNTAX_KEY = "Messages.Invalid-Syntax";
    public static final String MESSAGE_RELOAD_KEY = "Messages.Reload-Message";
    public static final String SOCIAL_TITLE_KEY = "Social.Title";
    public static final String FEATURE_DISABLED_KEY = "Messages.Feature-Disabled";
    public static final String MENU_SIZE_KEY = "Social.Size";
    public static final String IS_MENU_KEY = "Social.Disable-Menu";

    private Data() {}

    public static String pluginPrefix;
    public static String messageAvailable;
    public static String messageNotAvailable;
    public static String messageNoPermission;
    public static String messageInvalidSyntax;
    public static String messageReload;
    public static String socialTitle;
    public static String featureDisabled;
    public static String pluginVersion;

    public static int resourceID;
    public static int menuSize;

    public static boolean isMenu;

    public static String socialUsePermission;
    public static String socialReloadPermission;

    public static void initialize() {

        initializeStrings();
        initializeIntegers();
        initializeBooleans();
        initializePermissionStrings();

        final LinkManager linkManager = new LinkManager();
        links = linkManager.getLinks();

        initializeCommands();
        initializeEvents();
    }

    private static void initializeStrings() {

        pluginPrefix = getConfigStringSection(PLUGIN_PREFIX_KEY);
        messageAvailable = getConfigStringSection(MESSAGE_AVAILABLE_KEY).replace("%prefix%", pluginPrefix);
        messageNotAvailable = getConfigStringSection(MESSAGE_NOT_AVAILABLE_KEY).replace("%prefix%", pluginPrefix);
        messageNoPermission = getConfigStringSection(MESSAGE_NO_PERMISSION_KEY).replace("%prefix%", pluginPrefix);
        messageInvalidSyntax = getConfigStringSection(MESSAGE_INVALID_SYNTAX_KEY).replace("%prefix%", pluginPrefix);
        messageReload = getConfigStringSection(MESSAGE_RELOAD_KEY).replace("%prefix%", pluginPrefix);
        socialTitle = getConfigStringSection(SOCIAL_TITLE_KEY).replace("%prefix%", pluginPrefix);
        featureDisabled = getConfigStringSection(FEATURE_DISABLED_KEY).replace("%prefix%", pluginPrefix);
        pluginVersion = main.getDescription().getVersion();
    }

    private static void initializeIntegers() {

        resourceID = 93562;
        menuSize = main.getConfig().getInt(MENU_SIZE_KEY);
    }

    private static void initializeBooleans() {

        isMenu = main.getConfig().getBoolean(IS_MENU_KEY, false);
    }

    private static void initializePermissionStrings() {

        socialUsePermission = "social.use";
        socialReloadPermission = "social.reload";
    }

    private static void initializeCommands() {

        main.getCommand("social").setExecutor(new OnSocial());

        for (Links link : links) {
            String commandName = link.getHeader().toLowerCase();
            CommandManager.registerCommand(commandName, new SubOnes(link));
        }
    }

    private static void initializeEvents() { main.getServer().getPluginManager().registerEvents(new ClickEvent(), main); }

    public static List<Links> getLinks() { return links; }

    private static String getConfigStringSection(final String key) { return main.getConfig().getString(key, ""); }
}
