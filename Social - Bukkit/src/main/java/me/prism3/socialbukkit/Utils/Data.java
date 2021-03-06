package me.prism3.socialbukkit.Utils;

import me.prism3.socialbukkit.Main;

import java.util.Objects;

public class Data {

    private final Main main = Main.getInstance();

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

    public void initializeStrings(){

        messageAvailable = Objects.requireNonNull(main.getConfig().getString("Messages.Available")).replaceAll("&", "§");
        messageNotAvailable = Objects.requireNonNull(main.getConfig().getString("Messages.Not-Available")).replaceAll("&", "§");
        messageNoPermission = Objects.requireNonNull(main.getConfig().getString("Messages.No-Permission")).replaceAll("&", "§");
        messageInvalidSyntax = Objects.requireNonNull(main.getConfig().getString("Messages.Invalid-Syntax")).replaceAll("&", "§");
        messageReload = Objects.requireNonNull(main.getConfig().getString("Messages.Reload-Message")).replaceAll("&", "§");
        socialTitle = Objects.requireNonNull(main.getConfig().getString("Social.Title")).replaceAll("&", "§");
        websiteLink = Objects.requireNonNull(main.getConfig().getString("Website.Link")).replaceAll("&", "§");
        youtubeLink = Objects.requireNonNull(main.getConfig().getString("Youtube.Link")).replaceAll("&", "§");
        facebookLink = Objects.requireNonNull(main.getConfig().getString("Facebook.Link")).replaceAll("&", "§");
        twitchLink = Objects.requireNonNull(main.getConfig().getString("Twitch.Link")).replaceAll("&", "§");
        discordLink = Objects.requireNonNull(main.getConfig().getString("Discord.Link")).replaceAll("&", "§");
        instagramLink = Objects.requireNonNull(main.getConfig().getString("Instagram.Link")).replaceAll("&", "§");
        storeLink = Objects.requireNonNull(main.getConfig().getString("Store.Link")).replaceAll("&", "§");
        featureDisabled = Objects.requireNonNull(main.getConfig().getString("Messages.Feature-Disabled")).replaceAll("&", "§");

    }

    public void initializeIntegers(){

        resourceID = 93562;
        menuSize = main.getConfig().getInt("Social.Size");

    }

    public void initializeBooleans(){

        isWebsite = main.getConfig().getBoolean("Website.Disabled");
        isYoutube = main.getConfig().getBoolean("Youtube.Disabled");
        isFacebook = main.getConfig().getBoolean("Facebook.Disabled");
        isTwitch = main.getConfig().getBoolean("Twitch.Disabled");
        isDiscord = main.getConfig().getBoolean("Discord.Disabled");
        isInstagram = main.getConfig().getBoolean("Instagram.Disabled");
        isStore = main.getConfig().getBoolean("Store.Disabled");
        isMenu = main.getConfig().getBoolean("Social.Disable-Menu");

    }

    public void initializePermissionStrings(){

        socialUse = "social.use";
        socialReload = "social.reload";

    }

    // Skins base64 from minecraft-heads.com
    public void initializeHeadSkins(){

        websiteSkin = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmQ5ZjE4YzlkODVmOTJmNzJmODY0ZDY3YzEzNjdlOWE0NWRjMTBmMzcxNTQ5YzQ2YTRkNGRkOWU0ZjEzZmY0In19fQ==";
        youtubeSkin = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmI3Njg4ZGE0NjU4NmI4NTlhMWNkZTQwY2FlMWNkYmMxNWFiZTM1NjE1YzRiYzUyOTZmYWQwOTM5NDEwNWQwIn19fQ==";
        facebookSkin = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGViNDYxMjY5MDQ0NjNmMDdlY2ZjOTcyYWFhMzczNzNhMjIzNTliNWJhMjcxODIxYjY4OWNkNTM2N2Y3NTc2MiJ9fX0==";
        twitchSkin = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmYxOGZhNDNkNGQ5Mzc4OTQ4YjU2Yjg1YjUzMTk3OTA3NDExOWMxMjUyMzJlNzE1Y2U0YmQ1Mjc4MGFjNGQ3NiJ9fX0==";
        discordSkin = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19==";
        instagramSkin = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBlYzgyODQxOTkwOWU3YzJmYWZiYjNmNzU4NzNkNzk2ZTkwYmZjYjEyODhhNWNiYmQwMTYxNDYwMjdmMTc4OCJ9fX0==";
        storeSkin = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2UzZGViNTdlYWEyZjRkNDAzYWQ1NzI4M2NlOGI0MTgwNWVlNWI2ZGU5MTJlZTJiNGVhNzM2YTlkMWY0NjVhNyJ9fX0==";
    }
}
