package dev.tonimatas.perworldplugins.util;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

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
                Bukkit.getConsoleSender().sendMessage(PerWorldPlugins.getInstance().getName() + ChatColor.RED + " There is a new version available. " + ChatColor.YELLOW + "(" + ChatColor.GRAY + latestVersion + ChatColor.YELLOW + ")");
                Bukkit.getConsoleSender().sendMessage(PerWorldPlugins.getInstance().getName() + ChatColor.RED + " You can download it at: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/perworldplugins.96161/");
            }
        } catch (Exception var3) {
            Bukkit.getConsoleSender().sendMessage(PerWorldPlugins.getInstance().getName() + ChatColor.RED + " Error while checking update.");
        }
    }
}
