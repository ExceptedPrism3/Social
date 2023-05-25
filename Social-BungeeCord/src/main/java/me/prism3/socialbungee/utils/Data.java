package me.prism3.socialbungee.utils;

import me.prism3.socialbungee.Main;
import me.prism3.socialbungee.commands.OnSocial;
import me.prism3.socialbungee.commands.SubOnes;
import me.prism3.socialbungee.utils.manager.CommandManager;
import me.prism3.socialbungee.utils.manager.LinkManager;

import java.util.List;

public class Data {

    private static final Main main = Main.getInstance();

    private static final String PREFIX_KEY = "Messages.Prefix";
    private static final String MESSAGE_NOT_AVAILABLE_KEY = "Messages.Not-Available";
    private static final String MESSAGE_RELOAD_KEY = "Messages.Reload";
    private static final String MESSAGE_NO_PERMISSION_KEY = "Messages.No-Permission";
    private static final String MESSAGE_INVALID_SYNTAX_KEY = "Messages.Invalid-Syntax";

    private static List<Links> links;

    public static String pluginPrefix;
    public static String messageNotAvailable;
    public static String messageReload;
    public static String messageNoPermission;
    public static String invalidSyntax;
    public static String pluginVersion;

    public static String socialUsePermission;
    public static String socialReloadPermission;

    private Data() {}

    public static void initialize() {

        initializeStrings();
        initializePermission();

        final LinkManager linkManager = new LinkManager(main);
        links = linkManager.getLinks();

        commandInitializer();
    }

    private static void initializeStrings() {

        pluginPrefix = getConfigSection(PREFIX_KEY);
        messageNotAvailable = getConfigSection(MESSAGE_NOT_AVAILABLE_KEY).replaceAll("&", "§");
        messageReload = getConfigSection(MESSAGE_RELOAD_KEY).replaceAll("&", "§");
        messageNoPermission = getConfigSection(MESSAGE_NO_PERMISSION_KEY).replaceAll("&", "§");
        invalidSyntax = getConfigSection(MESSAGE_INVALID_SYNTAX_KEY).replaceAll("&", "§");
        pluginVersion = main.getDescription().getVersion();
    }

    private static void initializePermission() {

        socialUsePermission = "socialproxy.use";
        socialReloadPermission = "socialproxy.reload";
    }

    private static void commandInitializer() {

        main.getProxy().getPluginManager().registerCommand(main, new OnSocial());

        for (Links link : links) {
            String commandName = link.getHeader().toLowerCase();
            CommandManager.registerCommand(commandName, new SubOnes(link));
        }
    }

    private static String getConfigSection(final String key) { return main.getConfig().getString(key, ""); }
}
