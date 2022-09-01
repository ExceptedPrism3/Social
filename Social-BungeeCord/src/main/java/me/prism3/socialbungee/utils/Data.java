package me.prism3.socialbungee.utils;

import me.prism3.socialbungee.Main;
import me.prism3.socialbungee.commands.*;

import java.util.List;

public class Data {

    private final Main main = Main.getInstance();

    public static String messageNotAvailable;
    public static String messageReload;
    public static String messageNoPermission;
    public static String invalidSyntax;
    public static String discordLink;
    public static String facebookLink;
    public static String instagramLink;
    public static String storeLink;
    public static String twitchLink;
    public static String websiteLink;
    public static String youtubeLink;

    public static boolean isDiscord;
    public static boolean isFacebook;
    public static boolean isInstagram;
    public static boolean isStore;
    public static boolean isTwitch;
    public static boolean isWebsite;
    public static boolean isYoutube;

    public static List<String> helpMessages;

    public static String socialProxyReload;

    public void initializeStrings() {

        messageNotAvailable = main.getConfig().getString("Messages.Not-Available").replaceAll("&", "§");
        messageReload = main.getConfig().getString("Messages.Reload").replaceAll("&", "§");
        messageNoPermission = main.getConfig().getString("Messages.No-Permission");
        invalidSyntax = main.getConfig().getString("Messages.Invalid-Syntax");
        discordLink = main.getConfig().getString("Links.Discord").replaceAll("&", "§");
        facebookLink = main.getConfig().getString("Links.Facebook").replaceAll("&", "§");
        instagramLink = main.getConfig().getString("Links.Instagram").replaceAll("&", "§");
        storeLink = main.getConfig().getString("Links.Store").replaceAll("&", "§");
        twitchLink = main.getConfig().getString("Links.Twitch").replaceAll("&", "§");
        websiteLink = main.getConfig().getString("Links.Website").replaceAll("&", "§");
        youtubeLink = main.getConfig().getString("Links.Youtube").replaceAll("&", "§");

    }

    public void initializeBooleans() {

        isDiscord = main.getConfig().getBoolean("Social.Discord");
        isFacebook = main.getConfig().getBoolean("Social.Facebook");
        isInstagram = main.getConfig().getBoolean("Social.Instagram");
        isStore = main.getConfig().getBoolean("Social.Store");
        isTwitch = main.getConfig().getBoolean("Social.Twitch");
        isWebsite = main.getConfig().getBoolean("Social.Website");
        isYoutube = main.getConfig().getBoolean("Social.Youtube");

    }

    public void initializeListOfStrings() {

        helpMessages = main.getConfig().getStringList("Messages.Social-Help");

    }

    public void initializePermissionStrings() {

        socialProxyReload = "socialproxy.reload";

    }

    public void commandInitializer() {

        this.main.getProxy().getPluginManager().registerCommand(this.main, new OnSocial());

        if (this.main.getConfig().getBoolean("Social.Website"))
            this.main.getProxy().getPluginManager().registerCommand(this.main, new OnWebsite());

        if (this.main.getConfig().getBoolean("Social.Youtube"))
            this.main.getProxy().getPluginManager().registerCommand(this.main, new OnYoutube());

        if (this.main.getConfig().getBoolean("Social.Facebook"))
            this.main.getProxy().getPluginManager().registerCommand(this.main, new OnFacebook());

        if (this.main.getConfig().getBoolean("Social.Twitch"))
            this.main.getProxy().getPluginManager().registerCommand(this.main, new OnTwitch());

        if (this.main.getConfig().getBoolean("Social.Discord"))
            this.main.getProxy().getPluginManager().registerCommand(this.main, new OnDiscord());

        if (this.main.getConfig().getBoolean("Social.Instagram"))
            this.main.getProxy().getPluginManager().registerCommand(this.main, new OnInstagram());

        if (this.main.getConfig().getBoolean("Social.Store"))
            this.main.getProxy().getPluginManager().registerCommand(this.main, new OnStore());
    }
}
