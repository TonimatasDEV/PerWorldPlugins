package net.tonimatasdev.perworldplugins.listener.hook;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;

public class Hooks {
    public static void register() {
        check("WorldGuard");
        check("nLogin");
        check("Skywars");
        check("MythicMobs");
        //check("BedWars");
    }

    private static void check(String pluginName) {
        if (Bukkit.getPluginManager().isPluginEnabled(pluginName)) {
            Bukkit.getPluginManager().registerEvents(getHook(pluginName), PerWorldPlugins.getInstance());
            Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + pluginName + " hook is enabled.");
        }
    }

    private static Listener getHook(String pluginName) {
        switch (pluginName) {
            case "WorldGuard": return new WorldGuardHook();
            case "nLogin": return new nLoginHook();
            case "Skywars": return new SkyWarsHook();
            case "MythicMobs": return new MythicMobsHook();
            //case "BedWars": return new BedWarsHook();
            default: return null;
        }
    }
}
