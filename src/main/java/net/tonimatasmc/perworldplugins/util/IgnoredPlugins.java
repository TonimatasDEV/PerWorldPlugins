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
                !listener.getPlugin().getName().equalsIgnoreCase("ProtocolLib") &&
                !listener.getPlugin().getName().equalsIgnoreCase("WorldGuard") &&
                !listener.getPlugin().getName().equalsIgnoreCase("Citizens") &&
                !listener.getPlugin().getName().equalsIgnoreCase("ExcellentCrates") &&
                !listener.getPlugin().getName().equalsIgnoreCase("EssentialsDiscord") &&
                !listener.getPlugin().getName().equalsIgnoreCase("SquidGame") &&
                !listener.getPlugin().getName().equalsIgnoreCase("BuildBattle") &&
                !listener.getPlugin().getName().equalsIgnoreCase("SuperbVote") &&
                !listener.getPlugin().getName().equalsIgnoreCase("VotingPlugin") &&
                !listener.getPlugin().getName().equalsIgnoreCase("CommandPanels") &&
                !listener.getPlugin().getName().equalsIgnoreCase("sleep-most") &&
                !listener.getPlugin().getName().equalsIgnoreCase("BuycraftX"));
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
                !event.getPlugin().getName().equalsIgnoreCase("ProtocolLib") &&
                !event.getPlugin().getName().equalsIgnoreCase("WorldGuard") &&
                !event.getPlugin().getName().equalsIgnoreCase("Citizens") &&
                !event.getPlugin().getName().equalsIgnoreCase("ExcellentCrates") &&
                !event.getPlugin().getName().equalsIgnoreCase("EssentialsDiscord") &&
                !event.getPlugin().getName().equalsIgnoreCase("SquidGame") &&
                !event.getPlugin().getName().equalsIgnoreCase("BuildBattle") &&
                !event.getPlugin().getName().equalsIgnoreCase("SuperbVote") &&
                !event.getPlugin().getName().equalsIgnoreCase("VotingPlugin") &&
                !event.getPlugin().getName().equalsIgnoreCase("CommandPanels") &&
                !event.getPlugin().getName().equalsIgnoreCase("sleep-most") &&
                !event.getPlugin().getName().equalsIgnoreCase("BuycraftX"));

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
                !event.getPlugin().getName().equalsIgnoreCase("ProtocolLib") &&
                !event.getPlugin().getName().equalsIgnoreCase("WorldGuard") &&
                !event.getPlugin().getName().equalsIgnoreCase("Citizens") &&
                !event.getPlugin().getName().equalsIgnoreCase("ExcellentCrates") &&
                !event.getPlugin().getName().equalsIgnoreCase("EssentialsDiscord") &&
                !event.getPlugin().getName().equalsIgnoreCase("SquidGame") &&
                !event.getPlugin().getName().equalsIgnoreCase("BuildBattle") &&
                !event.getPlugin().getName().equalsIgnoreCase("SuperbVote") &&
                !event.getPlugin().getName().equalsIgnoreCase("VotingPlugin") &&
                !event.getPlugin().getName().equalsIgnoreCase("CommandPanels") &&
                !event.getPlugin().getName().equalsIgnoreCase("sleep-most") &&
                !event.getPlugin().getName().equalsIgnoreCase("BuycraftX"));
    }
}
