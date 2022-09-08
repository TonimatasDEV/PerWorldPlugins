package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
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
                !listener.getPlugin().getName().equalsIgnoreCase("BuycraftX") &&
                !listener.getPlugin().getName().equalsIgnoreCase("NotQuests") &&
                !listener.getPlugin().getName().equalsIgnoreCase("LearMOTD") &&
                !listener.getPlugin().getName().equalsIgnoreCase("MOTD") &&
                !listener.getPlugin().getName().equalsIgnoreCase("Maintenance") &&
                !listener.getPlugin().getName().equalsIgnoreCase("PlayerParticles") &&
                !listener.getPlugin().getName().equalsIgnoreCase("SpeedBridge") &&
                !listener.getPlugin().getName().equalsIgnoreCase("AuctionHouse") &&
                !listener.getPlugin().getName().equalsIgnoreCase("Coins") &&
                !listener.getPlugin().getName().equalsIgnoreCase("EssentialsGeoIP") &&
                !listener.getPlugin().getName().equalsIgnoreCase("ExploitFixer") &&
                !listener.getPlugin().getName().equalsIgnoreCase("HamsterAPI") &&
                !listener.getPlugin().getName().equalsIgnoreCase("PermissionsEx") &&
                !listener.getPlugin().getName().equalsIgnoreCase("Jobs") &&
                !listener.getPlugin().getName().equalsIgnoreCase("ChatManager") &&
                !listener.getPlugin().getName().equalsIgnoreCase("antiRedstoneClock") &&
                !listener.getPlugin().getName().equalsIgnoreCase("ProtectionStones") &&
                !listener.getPlugin().getName().equalsIgnoreCase("Towny") &&
                !listener.getPlugin().getName().equalsIgnoreCase("EliteMobs") &&
                !listener.getPlugin().getName().equalsIgnoreCase("UltraHost") &&
                !listener.getPlugin().getName().equalsIgnoreCase("BeautyQuests") &&
                !listener.getPlugin().getName().equalsIgnoreCase("NPCAuctions") &&
                !listener.getPlugin().getName().equalsIgnoreCase("HungerGames") &&
                !listener.getPlugin().getName().equalsIgnoreCase("SurvivalGames") &&
                !listener.getPlugin().getName().equalsIgnoreCase("Factions"));
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
                !event.getPlugin().getName().equalsIgnoreCase("BuycraftX") &&
                !event.getPlugin().getName().equalsIgnoreCase("NotQuests") &&
                !event.getPlugin().getName().equalsIgnoreCase("LearMOTD") &&
                !event.getPlugin().getName().equalsIgnoreCase("MOTD") &&
                !event.getPlugin().getName().equalsIgnoreCase("Maintenance") &&
                !event.getPlugin().getName().equalsIgnoreCase("PlayerParticles") &&
                !event.getPlugin().getName().equalsIgnoreCase("SpeedBridge") &&
                !event.getPlugin().getName().equalsIgnoreCase("AuctionHouse") &&
                !event.getPlugin().getName().equalsIgnoreCase("Coins") &&
                !event.getPlugin().getName().equalsIgnoreCase("EssentialsGeoIP") &&
                !event.getPlugin().getName().equalsIgnoreCase("ExploitFixer") &&
                !event.getPlugin().getName().equalsIgnoreCase("HamsterAPI") &&
                !event.getPlugin().getName().equalsIgnoreCase("PermissionsEx") &&
                !event.getPlugin().getName().equalsIgnoreCase("Jobs") &&
                !event.getPlugin().getName().equalsIgnoreCase("ChatManager") &&
                !event.getPlugin().getName().equalsIgnoreCase("antiRedstoneClock") &&
                !event.getPlugin().getName().equalsIgnoreCase("ProtectionStones") &&
                !event.getPlugin().getName().equalsIgnoreCase("Towny") &&
                !event.getPlugin().getName().equalsIgnoreCase("EliteMobs") &&
                !event.getPlugin().getName().equalsIgnoreCase("UltraHost") &&
                !event.getPlugin().getName().equalsIgnoreCase("BeautyQuests") &&
                !event.getPlugin().getName().equalsIgnoreCase("NPCAuctions") &&
                !event.getPlugin().getName().equalsIgnoreCase("HungerGames") &&
                !event.getPlugin().getName().equalsIgnoreCase("SurvivalGames") &&
                !event.getPlugin().getName().equalsIgnoreCase("Factions"));
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
                !event.getPlugin().getName().equalsIgnoreCase("BuycraftX") &&
                !event.getPlugin().getName().equalsIgnoreCase("NotQuests") &&
                !event.getPlugin().getName().equalsIgnoreCase("LearMOTD") &&
                !event.getPlugin().getName().equalsIgnoreCase("MOTD") &&
                !event.getPlugin().getName().equalsIgnoreCase("Maintenance") &&
                !event.getPlugin().getName().equalsIgnoreCase("PlayerParticles") &&
                !event.getPlugin().getName().equalsIgnoreCase("SpeedBridge") &&
                !event.getPlugin().getName().equalsIgnoreCase("AuctionHouse") &&
                !event.getPlugin().getName().equalsIgnoreCase("Coins") &&
                !event.getPlugin().getName().equalsIgnoreCase("EssentialsGeoIP") &&
                !event.getPlugin().getName().equalsIgnoreCase("ExploitFixer") &&
                !event.getPlugin().getName().equalsIgnoreCase("HamsterAPI") &&
                !event.getPlugin().getName().equalsIgnoreCase("PermissionsEx") &&
                !event.getPlugin().getName().equalsIgnoreCase("Jobs") &&
                !event.getPlugin().getName().equalsIgnoreCase("ChatManager") &&
                !event.getPlugin().getName().equalsIgnoreCase("antiRedstoneClock") &&
                !event.getPlugin().getName().equalsIgnoreCase("ProtectionStones") &&
                !event.getPlugin().getName().equalsIgnoreCase("Towny") &&
                !event.getPlugin().getName().equalsIgnoreCase("EliteMobs") &&
                !event.getPlugin().getName().equalsIgnoreCase("UltraHost") &&
                !event.getPlugin().getName().equalsIgnoreCase("BeautyQuests") &&
                !event.getPlugin().getName().equalsIgnoreCase("NPCAuctions") &&
                !event.getPlugin().getName().equalsIgnoreCase("HungerGames") &&
                !event.getPlugin().getName().equalsIgnoreCase("SurvivalGames") &&
                !event.getPlugin().getName().equalsIgnoreCase("Factions"));
    }
}
