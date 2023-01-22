package net.tonimatasdev.perworldplugins.listener.hook;

import eu.decentsoftware.holograms.event.DecentHologramsEvent;
import eu.decentsoftware.holograms.event.DecentHologramsReloadEvent;
import eu.decentsoftware.holograms.event.HologramClickEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class DecentHologramsHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPreLog(DecentHologramsEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPreLog(DecentHologramsReloadEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPreLog(HologramClickEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
