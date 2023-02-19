package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class MultiVersion {
    private static final String[] versionString = Bukkit.getBukkitVersion().split("-")[0].split("\\.");
    private static final int version = getVersion();

    public static void register() {
        if (version >= 190) {
            Bukkit.getServer().getPluginManager().registerEvents(new v190(), PerWorldPlugins.getInstance());
            v190.addHandlerList();
            loadedMessage("1.9");
        }

        if (version >= 194) {
            Bukkit.getServer().getPluginManager().registerEvents(new v194(), PerWorldPlugins.getInstance());
            v194.addHandlerList();
            loadedMessage("1.9.4");
        }

        if (version >= 1100) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1100(), PerWorldPlugins.getInstance());
            v1100.addHandlerList();
            loadedMessage("1.10");
        }

        if (version >= 1102) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1102(), PerWorldPlugins.getInstance());
            v1102.addHandlerList();
            loadedMessage("1.10.2");
        }

        if (version >= 1110) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1110(), PerWorldPlugins.getInstance());
            v1110.addHandlerList();
            loadedMessage("1.11");
        }

        if (version >= 1120) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1120(), PerWorldPlugins.getInstance());
            v1120.addHandlerList();
            loadedMessage("1.12");
        }

        if (version >= 1122) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1122(), PerWorldPlugins.getInstance());
            v1122.addHandlerList();
            loadedMessage("1.12.2");
        }

        if (version >= 1130) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1130(), PerWorldPlugins.getInstance());
            v1130.addHandlerList();
            loadedMessage("1.13");
        }

        if (version >= 1131) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1131(), PerWorldPlugins.getInstance());
            v1131.addHandlerList();
            loadedMessage("1.13.1");
        }

        if (version >= 1132) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1132(), PerWorldPlugins.getInstance());
            v1132.addHandlerList();
            loadedMessage("1.13.2");
        }

        if (version >= 1140) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1140(), PerWorldPlugins.getInstance());
            v1140.addHandlerList();
            loadedMessage("1.14");
        }

        if (version >= 1144) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1144(), PerWorldPlugins.getInstance());
            v1144.addHandlerList();
            loadedMessage("1.14.4");
        }

        if (version >= 1151) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1151(), PerWorldPlugins.getInstance());
            v1151.addHandlerList();
            loadedMessage("1.15.1");
        }

        if (version >= 1152) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1152(), PerWorldPlugins.getInstance());
            v1152.addHandlerList();
            loadedMessage("1.15.2");
        }

        if (version >= 1161) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1161(), PerWorldPlugins.getInstance());
            v1161.addHandlerList();
            loadedMessage("1.16.1");
        }

        if (version >= 1162) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1162(), PerWorldPlugins.getInstance());
            v1162.addHandlerList();
            loadedMessage("1.16.2");
        }

        if (version >= 1163) {
            v1163.addHandlerList();
            loadedMessage("1.16.3");
        }

        if (version >= 1165) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1165(), PerWorldPlugins.getInstance());
            v1165.addHandlerList();
            loadedMessage("1.16.5");
        }

        if (version >= 1170) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1170(), PerWorldPlugins.getInstance());
            v1170.addHandlerList();
            loadedMessage("1.17");
        }

        if (version >= 1171) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1171(), PerWorldPlugins.getInstance());
            v1171.addHandlerList();
            loadedMessage("1.17.1");
        }

        if (version >= 1181) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1181(), PerWorldPlugins.getInstance());
            v1181.addHandlerList();
            loadedMessage("1.18.1");
        }

        if (version >= 1191) {
            Bukkit.getServer().getPluginManager().registerEvents(new v1191(), PerWorldPlugins.getInstance());
            v1191.addHandlerList();
            loadedMessage("1.19.1");
        }
    }

    private static void loadedMessage(String version) {
        Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Loaded " + version + " events.");
    }

    private static int getVersion() {
        if (versionString[2] != null) {
            return Integer.parseInt(versionString[0] + versionString[1] + versionString[2]);
        } else {
            return Integer.parseInt(versionString[0] + versionString[1] + 0);
        }
    }
}
