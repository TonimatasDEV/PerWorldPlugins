package dev.tonimatas.perworldplugins.util;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

@SuppressWarnings("UnstableApiUsage")
public class UpdateChecker {
    private static final int TIMEOUT = 1250;

    public static void check() {
        try {
            HttpURLConnection connection = (HttpURLConnection) (new URI("https://api.spigotmc.org/legacy/update.php?resource=96161").toURL()).openConnection();

            connection.setConnectTimeout(TIMEOUT);
            connection.setReadTimeout(TIMEOUT);

            String latestVersion = (new BufferedReader(new InputStreamReader(connection.getInputStream()))).readLine();

            int latestVersionNumbers = Integer.parseInt(latestVersion.replaceAll("\\.", ""));
            int pluginVersion = Integer.parseInt(PerWorldPlugins.getInstance().getPluginMeta().getVersion().replaceAll("\\.", ""));

            if (latestVersionNumbers > pluginVersion) {
                PerWorldPlugins.LOGGER.info(Component.text("There is a new version available:", NamedTextColor.RED), Component.text(latestVersion, NamedTextColor.DARK_RED));
                PerWorldPlugins.LOGGER.info(Component.text("You can download it at: https://modrinth.com/plugin/perworldplugins", NamedTextColor.YELLOW));
            }
        } catch (Exception var3) {
            PerWorldPlugins.LOGGER.info(Component.text("Error while checking update.", NamedTextColor.RED));
        }
    }
}
