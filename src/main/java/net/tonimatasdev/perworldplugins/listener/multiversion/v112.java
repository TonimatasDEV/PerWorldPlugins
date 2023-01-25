package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerItemMendEvent;
import org.bukkit.event.player.PlayerLocaleChangeEvent;

public class v112 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(EntityPickupItemEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerAdvancementDoneEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerItemMendEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerLocaleChangeEvent.getHandlerList());
        //HandlerListUtil.minecraftHandlerLists.add(BroadcastMessageEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPickupItem(EntityPickupItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAdvancementDone(PlayerAdvancementDoneEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItemMend(PlayerItemMendEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLocaleChange(PlayerLocaleChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    //@EventHandler(priority = EventPriority.MONITOR)
    //public static void onBroadcastMessage(BroadcastMessageEvent event) {
    //    ListenerUtils.noWorldEvents(event);
    //}
}
