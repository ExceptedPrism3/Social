package me.prism3.socialbungee.Utils;

import me.prism3.socialbungee.Main;
import net.md_5.bungee.api.ProxyServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateChecker {

    private final Main plugin;
    private final int resourceId;

    public UpdateChecker(Main plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void getLatestVersion(Consumer<String> consumer) {

        ProxyServer.getInstance().getScheduler().runAsync(plugin, () -> {

            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {

                if (scanner.hasNext()) {

                    consumer.accept(scanner.next());

                }
            } catch (IOException exception) {

                plugin.getLogger().severe("Cannot look for updates: " + exception.getMessage());

            }
        });
    }
}