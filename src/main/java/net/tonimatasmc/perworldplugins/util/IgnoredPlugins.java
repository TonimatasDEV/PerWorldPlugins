package net.tonimatasmc.perworldplugins.util;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;

public class IgnoredPlugins {
    public static boolean useListener(org.bukkit.plugin.RegisteredListener listener) {
        return (!listener.getPlugin().getName().equalsIgnoreCase(PerWorldPlugins.getPlugin().getName()) &&
                !listener.getPlugin().getName().equalsIgnoreCase("LuckPerms") &&
                !listener.getPlugin().getName().equalsIgnoreCase("Geyser-Spigot") &&
                !listener.getPlugin().getName().equalsIgnoreCase("SkinRestorer") &&
                !listener.getPlugin().getName().equalsIgnoreCase("ViaVersion") &&
                !listener.getPlugin().getName().equalsIgnoreCase("ViaBackwards") &&
                !listener.getPlugin().getName().equalsIgnoreCase("PlaceholderAPI") &&
                !listener.getPlugin().getName().equalsIgnoreCase("floodgate") &&
                !listener.getPlugin().getName().equalsIgnoreCase("DriveBackupV2") &&
                !listener.getPlugin().getName().equalsIgnoreCase("FartherViewDistance") &&
                !listener.getPlugin().getName().equalsIgnoreCase("ProtocolLib"));
    }

    public static boolean usePluginEvent(PluginEnableEvent event) {
        return (!event.getPlugin().getName().equalsIgnoreCase(PerWorldPlugins.getPlugin().getName()) &&
                !event.getPlugin().getName().equalsIgnoreCase("LuckPerms") &&
                !event.getPlugin().getName().equalsIgnoreCase("Geyser-Spigot") &&
                !event.getPlugin().getName().equalsIgnoreCase("SkinRestorer") &&
                !event.getPlugin().getName().equalsIgnoreCase("ViaVersion") &&
                !event.getPlugin().getName().equalsIgnoreCase("ViaBackwards") &&
                !event.getPlugin().getName().equalsIgnoreCase("PlaceholderAPI") &&
                !event.getPlugin().getName().equalsIgnoreCase("floodgate") &&
                !event.getPlugin().getName().equalsIgnoreCase("DriveBackupV2") &&
                !event.getPlugin().getName().equalsIgnoreCase("FartherViewDistance") &&
                !event.getPlugin().getName().equalsIgnoreCase("ProtocolLib"));
    }

    public static boolean usePluginEvent(PluginDisableEvent event) {
        return (!event.getPlugin().getName().equalsIgnoreCase(PerWorldPlugins.getPlugin().getName()) &&
                !event.getPlugin().getName().equalsIgnoreCase("LuckPerms") &&
                !event.getPlugin().getName().equalsIgnoreCase("Geyser-Spigot") &&
                !event.getPlugin().getName().equalsIgnoreCase("SkinRestorer") &&
                !event.getPlugin().getName().equalsIgnoreCase("ViaVersion") &&
                !event.getPlugin().getName().equalsIgnoreCase("ViaBackwards") &&
                !event.getPlugin().getName().equalsIgnoreCase("PlaceholderAPI") &&
                !event.getPlugin().getName().equalsIgnoreCase("floodgate") &&
                !event.getPlugin().getName().equalsIgnoreCase("DriveBackupV2") &&
                !event.getPlugin().getName().equalsIgnoreCase("FartherViewDistance") &&
                !event.getPlugin().getName().equalsIgnoreCase("ProtocolLib"));
    }
}
