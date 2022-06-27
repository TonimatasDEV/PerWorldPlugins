package net.tonimatasmc.perworldplugins.util;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.listener.Listener;
import org.bukkit.event.server.PluginEnableEvent;

public class IgnoredPlugins {
    public static boolean useListener(Listener listener) {
        return !(listener.getDelegate().getPlugin().getName().equalsIgnoreCase("LuckPerms") ||
                listener.getDelegate().getPlugin().getName().equalsIgnoreCase("Geyser-Spigot") ||
                listener.getDelegate().getPlugin().getName().equalsIgnoreCase("SkinRestorer") ||
                listener.getDelegate().getPlugin().getName().equalsIgnoreCase("ViaVersion") ||
                listener.getDelegate().getPlugin().getName().equalsIgnoreCase("ViaBackwards") ||
                listener.getDelegate().getPlugin().getName().equalsIgnoreCase("PlaceholderAPI") ||
                listener.getDelegate().getPlugin().getName().equalsIgnoreCase("floodgate") ||
                listener.getDelegate().getPlugin().getName().equalsIgnoreCase("DriveBackupV2") ||
                listener.getDelegate().getPlugin().getName().equalsIgnoreCase("FartherViewDistance") ||
                listener.getDelegate().getPlugin().getName().equalsIgnoreCase("ProtocolLib"));
    }

    public static boolean useEvent(PluginEnableEvent event) {
        return !(event.getPlugin().getName().equalsIgnoreCase(PerWorldPlugins.getPlugin().getName()) ||
                event.getPlugin().getName().equalsIgnoreCase("LuckPerms") ||
                event.getPlugin().getName().equalsIgnoreCase("Geyser-Spigot") ||
                event.getPlugin().getName().equalsIgnoreCase("SkinRestorer") ||
                event.getPlugin().getName().equalsIgnoreCase("ViaVersion") ||
                event.getPlugin().getName().equalsIgnoreCase("ViaBackwards") ||
                event.getPlugin().getName().equalsIgnoreCase("PlaceholderAPI") ||
                event.getPlugin().getName().equalsIgnoreCase("floodgate") ||
                event.getPlugin().getName().equalsIgnoreCase("DriveBackupV2") ||
                event.getPlugin().getName().equalsIgnoreCase("FartherViewDistance") ||
                event.getPlugin().getName().equalsIgnoreCase("ProtocolLib"));
    }
}
