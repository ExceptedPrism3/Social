package me.prism3.socialbukkit.utils;

import me.prism3.socialbukkit.Main;
import me.prism3.socialbukkit.commands.*;

public class Data {

    private static final Main main = Main.getInstance();

    public static final String PLUGIN_PREFIX_KEY = "Messages.Prefix";
    public static final String MESSAGE_AVAILABLE_KEY = "Messages.Available";
    public static final String MESSAGE_NOT_AVAILABLE_KEY = "Messages.Not-Available";
    public static final String MESSAGE_NO_PERMISSION_KEY = "Messages.No-Permission";
    public static final String MESSAGE_INVALID_SYNTAX_KEY = "Messages.Invalid-Syntax";
    public static final String MESSAGE_RELOAD_KEY = "Messages.Reload-Message";
    public static final String SOCIAL_TITLE_KEY = "Social.Title";
    public static final String WEBSITE_LINK_KEY = "Website.Link";
    public static final String YOUTUBE_LINK_KEY = "Youtube.Link";
    public static final String FACEBOOK_LINK_KEY = "Facebook.Link";
    public static final String TWITCH_LINK_KEY = "Twitch.Link";
    public static final String DISCORD_LINK_KEY = "Discord.Link";
    public static final String INSTAGRAM_LINK_KEY = "Instagram.Link";
    public static final String STORE_LINK_KEY = "Store.Link";
    public static final String FEATURE_DISABLED_KEY = "Messages.Feature-Disabled";
    public static final String PLUGIN_VERSION_KEY = "plugin.version";
    public static final String RESOURCE_ID_KEY = "resourceID";
    public static final String MENU_SIZE_KEY = "Social.Size";
    public static final String IS_WEBSITE_KEY = "Website.Disabled";
    public static final String IS_YOUTUBE_KEY = "Youtube.Disabled";
    public static final String IS_FACEBOOK_KEY = "Facebook.Disabled";
    public static final String IS_TWITCH_KEY = "Twitch.Disabled";
    public static final String IS_DISCORD_KEY = "Discord.Disabled";
    public static final String IS_INSTAGRAM_KEY = "Instagram.Disabled";
    public static final String IS_STORE_KEY = "Store.Disabled";
    public static final String IS_MENU_KEY = "Social.Disable-Menu";
    public static final String SOCIAL_USE_KEY = "social.use";
    public static final String SOCIAL_RELOAD_KEY = "social.reload";
    public static final String WEBSITE_SKIN_KEY = "Website.Skin";
    public static final String YOUTUBE_SKIN_KEY = "Youtube.Skin";
    public static final String FACEBOOK_SKIN_KEY = "Facebook.Skin";
    public static final String TWITCH_SKIN_KEY = "Twitch.Skin";
    public static final String DISCORD_SKIN_KEY = "Discord.Skin";
    public static final String INSTAGRAM_SKIN_KEY = "Instagram.Skin";
    public static final String STORE_SKIN_KEY = "Store.Skin";

    private Data() {}

    public static String pluginPrefix;
    public static String messageAvailable;
    public static String messageNotAvailable;
    public static String messageNoPermission;
    public static String messageInvalidSyntax;
    public static String messageReload;
    public static String socialTitle;
    public static String websiteLink;
    public static String youtubeLink;
    public static String facebookLink;
    public static String twitchLink;
    public static String discordLink;
    public static String instagramLink;
    public static String storeLink;
    public static String featureDisabled;
    public static String pluginVersion;

    public static int resourceID;
    public static int menuSize;

    public static boolean isWebsite;
    public static boolean isYoutube;
    public static boolean isFacebook;
    public static boolean isTwitch;
    public static boolean isDiscord;
    public static boolean isInstagram;
    public static boolean isStore;
    public static boolean isMenu;

    public static String socialUse;
    public static String socialReload;

    public static String websiteSkin;
    public static String youtubeSkin;
    public static String facebookSkin;
    public static String twitchSkin;
    public static String discordSkin;
    public static String instagramSkin;
    public static String storeSkin;

    public void initializeStrings() {

        pluginPrefix = main.getConfig().getString("Messages.Prefix").replace("&", "§");
        messageAvailable = main.getConfig().getString("Messages.Available").replace("&", "§").replace("%prefix%", pluginPrefix);
        messageNotAvailable = main.getConfig().getString("Messages.Not-Available").replace("&", "§").replace("%prefix%", pluginPrefix);
        messageNoPermission = main.getConfig().getString("Messages.No-Permission").replace("&", "§").replace("%prefix%", pluginPrefix);
        messageInvalidSyntax = main.getConfig().getString("Messages.Invalid-Syntax").replace("&", "§").replace("%prefix%", pluginPrefix);
        messageReload = main.getConfig().getString("Messages.Reload-Message").replace("&", "§").replace("%prefix%", pluginPrefix);
        socialTitle = main.getConfig().getString("Social.Title").replace("&", "§").replace("%prefix%", pluginPrefix);
        websiteLink = main.getConfig().getString("Website.Link").replace("&", "§").replace("%prefix%", pluginPrefix);
        youtubeLink = main.getConfig().getString("Youtube.Link").replace("&", "§").replace("%prefix%", pluginPrefix);
        facebookLink = main.getConfig().getString("Facebook.Link").replace("&", "§").replace("%prefix%", pluginPrefix);
        twitchLink = main.getConfig().getString("Twitch.Link").replace("&", "§").replace("%prefix%", pluginPrefix);
        discordLink = main.getConfig().getString("Discord.Link").replace("&", "§").replace("%prefix%", pluginPrefix);
        instagramLink = main.getConfig().getString("Instagram.Link").replace("&", "§").replace("%prefix%", pluginPrefix);
        storeLink = main.getConfig().getString("Store.Link").replace("&", "§").replace("%prefix%", pluginPrefix);
        featureDisabled = main.getConfig().getString("Messages.Feature-Disabled").replace("&", "§").replace("%prefix%", pluginPrefix);
        pluginVersion = main.getDescription().getVersion();
    }

    public void initializeIntegers() {

        resourceID = 93562;
        menuSize = main.getConfig().getInt("Social.Size");
    }

    public void initializeBooleans() {

        isWebsite = main.getConfig().getBoolean("Website.Disabled");
        isYoutube = main.getConfig().getBoolean("Youtube.Disabled");
        isFacebook = main.getConfig().getBoolean("Facebook.Disabled");
        isTwitch = main.getConfig().getBoolean("Twitch.Disabled");
        isDiscord = main.getConfig().getBoolean("Discord.Disabled");
        isInstagram = main.getConfig().getBoolean("Instagram.Disabled");
        isStore = main.getConfig().getBoolean("Store.Disabled");
        isMenu = main.getConfig().getBoolean("Social.Disable-Menu");
    }

    public void initializePermissionStrings() {

        socialUse = "social.use";
        socialReload = "social.reload";
    }

    public void commandInitializer() {

        if (!main.getConfig().getBoolean("Social.Disable-Menu"))
            main.getCommand("social").setExecutor(new OnSocial());

        if (!main.getConfig().getBoolean("Website.Disabled"))
            main.getCommand("website").setExecutor(new OnWebsite());

        if (!main.getConfig().getBoolean("Youtube.Disabled"))
            main.getCommand("youtube").setExecutor(new OnYoutube());

        if (!main.getConfig().getBoolean("Facebook.Disabled"))
            main.getCommand("facebook").setExecutor(new OnFacebook());

        if (!main.getConfig().getBoolean("Twitch.Disabled"))
            main.getCommand("twitch").setExecutor(new OnTwitch());

        if (!main.getConfig().getBoolean("Discord.Disabled"))
            main.getCommand("discord").setExecutor(new OnDiscord());

        if (!main.getConfig().getBoolean("Instagram.Disabled"))
            main.getCommand("instagram").setExecutor(new OnInstagram());

        if (!main.getConfig().getBoolean("Store.Disabled"))
            main.getCommand("store").setExecutor(new OnStore());
    }

    private static String getConfigSection(final String key) { return main.getConfig().getString(key, ""); }
}
