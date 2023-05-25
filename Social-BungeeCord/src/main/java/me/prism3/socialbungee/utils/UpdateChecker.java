package me.prism3.socialbungee.utils;

import me.prism3.socialbungee.Main;
import net.md_5.bungee.api.ProxyServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;


/**
 * UpdateChecker is a utility class for checking the latest version of a plugin from SpigotMC.
 */
public class UpdateChecker {

    private final Main plugin;
    private final int resourceId;

    /**
     * Constructs an UpdateChecker instance.
     *
     * @param plugin     the plugin instance
     * @param resourceId the resource ID of the plugin on SpigotMC
     */
    public UpdateChecker(final Main plugin, final int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    /**
     * Gets the latest version of the plugin from SpigotMC.
     *
     * @param consumer the consumer that accepts the latest version string
     */
    public void getLatestVersion(final Consumer<String> consumer) {

        ProxyServer.getInstance().getScheduler().runAsync(this.plugin, () -> {

            try {

                final URL updateUrl = this.createUpdateUrl();

                try (final InputStream inputStream = updateUrl.openStream();
                     final Scanner scanner = new Scanner(inputStream)) {

                    if (scanner.hasNext())
                        consumer.accept(scanner.next());
                }

            } catch (final MalformedURLException e) {
                Log.severe("Invalid update URL: " + e.getMessage());
            } catch (final IOException e) {
                Log.severe("Cannot connect to update server: " + e.getMessage());
            }
        });
    }

    /**
     * Creates the URL for checking the update from SpigotMC.
     *
     * @return the update URL
     * @throws MalformedURLException if the update URL is invalid
     */
    private URL createUpdateUrl() throws MalformedURLException {
        return new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId);
    }
}
