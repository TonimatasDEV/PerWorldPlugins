package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.listener.HangingEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class MultiVersion {
    private static final String[] versionString = Bukkit.getBukkitVersion().split("-")[0].split("\\.");
    private static final int version = Integer.parseInt(versionString[0] + versionString[1]);

    public static void register() {
        if (version > 19) {
            Bukkit.getServer().getPluginManager().registerEvents(new v19(), PerWorldPlugins.getInstance());
            loadedMessage("1.9");
        }

        if (version > 110) {
            Bukkit.getServer().getPluginManager().registerEvents(new v110(), PerWorldPlugins.getInstance());
            loadedMessage("1.10");
        }

        if (version > 111) {
            Bukkit.getServer().getPluginManager().registerEvents(new v111(), PerWorldPlugins.getInstance());
            loadedMessage("1.11");
        }

        if (version > 112) {
            Bukkit.getServer().getPluginManager().registerEvents(new v112(), PerWorldPlugins.getInstance());
            loadedMessage("1.12");
        }

        if (version > 113) {
            Bukkit.getServer().getPluginManager().registerEvents(new v113(), PerWorldPlugins.getInstance());
            loadedMessage("1.13");
        }

        if (version > 114) {
            Bukkit.getServer().getPluginManager().registerEvents(new v114(), PerWorldPlugins.getInstance());
            loadedMessage("1.14");
        }

        if (version > 115) {
            Bukkit.getServer().getPluginManager().registerEvents(new v115(), PerWorldPlugins.getInstance());
            loadedMessage("1.15");
        }

        if (version > 116) {
            Bukkit.getServer().getPluginManager().registerEvents(new v116(), PerWorldPlugins.getInstance());
            loadedMessage("1.16");
        }

        if (version > 117) {
            Bukkit.getServer().getPluginManager().registerEvents(new v117(), PerWorldPlugins.getInstance());
            loadedMessage("1.17");
        }

        if (version > 118) {
            Bukkit.getServer().getPluginManager().registerEvents(new v118(), PerWorldPlugins.getInstance());
            loadedMessage("1.18");
        }

        if (version > 119) {
            Bukkit.getServer().getPluginManager().registerEvents(new v119(), PerWorldPlugins.getInstance());
            loadedMessage("1.19");
        }
    }

    private static void loadedMessage(String version) {
        Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Loaded " + version + " events.");
    }
}
