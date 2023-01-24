package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityAirChangeEvent;
import org.bukkit.event.entity.EntityBreedEvent;

public class v110 implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAirChange(EntityAirChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBreed(EntityBreedEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }
}
