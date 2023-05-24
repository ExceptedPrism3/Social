package me.prism3.socialbukkit.utils;

import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.inventory.ItemStack;

import static me.prism3.socialbukkit.utils.Data.*;

public class HeadSkins {

    private HeadSkins() {}

    public static ItemStack WebsiteSkin() {
        return SkullCreator.itemFromBase64(websiteSkin);
    }

    public static ItemStack YoutubeSkin() {
        return SkullCreator.itemFromBase64(youtubeSkin);
    }

    public static ItemStack FacebookSkin() { return SkullCreator.itemFromBase64(facebookSkin); }

    public static ItemStack TwitchSkin() { return SkullCreator.itemFromBase64(twitchSkin); }

    public static ItemStack DiscordSkin() { return SkullCreator.itemFromBase64(discordSkin); }

    public static ItemStack InstagramSkin() { return SkullCreator.itemFromBase64(instagramSkin); }

    public static ItemStack StoreSkin() { return SkullCreator.itemFromBase64(storeSkin); }
}
