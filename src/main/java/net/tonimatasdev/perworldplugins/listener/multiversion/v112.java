package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerItemMendEvent;
import org.bukkit.event.player.PlayerLocaleChangeEvent;
import org.bukkit.event.server.BroadcastMessageEvent;

public class v112 implements Listener {
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

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBroadcastMessage(BroadcastMessageEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
