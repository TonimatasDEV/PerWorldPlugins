package net.tonimatasdev.perworldplugins.listener.hook;

import com.gamingmesh.jobs.api.*;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class JobsHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBase(BaseEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAreaSelection(JobsAreaSelectionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChunkChange(JobsChunkChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onExpGain(JobsExpGainEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onJoin(JobsJoinEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLeave(JobsLeaveEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLevelUp(JobsLevelUpEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPayment(JobsPaymentEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrePayment(JobsPrePaymentEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onScheduleStart(JobsScheduleStartEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onScheduleStop(JobsScheduleStopEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

}
