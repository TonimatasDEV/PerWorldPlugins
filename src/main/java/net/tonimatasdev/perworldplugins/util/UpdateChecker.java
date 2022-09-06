package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {

    public static void check() {
        try {
            HttpURLConnection con = (HttpURLConnection) (new URL("https://api.spigotmc.org/legacy/update.php?resource=96161")).openConnection();

            int timed_out = 1250;

            con.setConnectTimeout(timed_out);
            con.setReadTimeout(timed_out);

            String latestversion = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();

            if (latestversion.length() <= 7 && !PerWorldPlugins.getPlugin().getDescription().getVersion().equalsIgnoreCase(latestversion)) {
                Bukkit.getConsoleSender().sendMessage(PerWorldPlugins.getPlugin().getName() + ChatColor.RED + " There is a new version available. " + ChatColor.YELLOW + "(" + ChatColor.GRAY + latestversion + ChatColor.YELLOW + ")");
                Bukkit.getConsoleSender().sendMessage(PerWorldPlugins.getPlugin().getName() + ChatColor.RED + " You can download it at: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/perworldcommands.97003/");
            }
        } catch (Exception var3) {
            Bukkit.getConsoleSender().sendMessage(PerWorldPlugins.getPlugin().getName() + ChatColor.RED + " Error while checking update.");
        }
    }
}
