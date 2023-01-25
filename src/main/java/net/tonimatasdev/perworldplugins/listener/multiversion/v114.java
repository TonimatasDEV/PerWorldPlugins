package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.TradeSelectEvent;
import org.bukkit.event.player.PlayerTakeLecternBookEvent;
import org.bukkit.event.raid.RaidFinishEvent;
import org.bukkit.event.raid.RaidSpawnWaveEvent;
import org.bukkit.event.raid.RaidStopEvent;
import org.bukkit.event.raid.RaidTriggerEvent;

public class v114 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(RaidFinishEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(RaidSpawnWaveEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(RaidStopEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(RaidTriggerEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(TradeSelectEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerTakeLecternBookEvent.getHandlerList());
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

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTradeSelect(TradeSelectEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getView().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTakeLecternBook(PlayerTakeLecternBookEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
