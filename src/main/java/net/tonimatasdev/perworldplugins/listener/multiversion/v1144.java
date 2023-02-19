package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidFinishEvent;
import org.bukkit.event.raid.RaidSpawnWaveEvent;
import org.bukkit.event.raid.RaidStopEvent;
import org.bukkit.event.raid.RaidTriggerEvent;

public class v1144 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(RaidFinishEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(RaidSpawnWaveEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(RaidStopEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(RaidTriggerEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFinish(RaidFinishEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSpawnWave(RaidSpawnWaveEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onStop(RaidStopEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTrigger(RaidTriggerEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }
}
