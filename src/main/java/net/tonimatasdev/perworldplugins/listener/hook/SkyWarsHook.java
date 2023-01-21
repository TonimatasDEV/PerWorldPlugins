package net.tonimatasdev.perworldplugins.listener.hook;

import com.walrusone.skywarsreloaded.events.*;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class SkyWarsHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDeath(SkyWarsDeathEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onJoin(SkyWarsJoinEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onKill(SkyWarsKillEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getKilled().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLeave(SkyWarsLeaveEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMatchStateChange(SkyWarsMatchStateChangeEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onReload(SkyWarsReloadEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSelectKit(SkyWarsSelectKitEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSelectTeam(SkyWarsSelectTeamEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVote(SkyWarsVoteEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onWin(SkyWarsWinEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
