package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.inventory.BrewingStandFuelEvent;

public class v111 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(EntityResurrectEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(BrewingStandFuelEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onResurrect(EntityResurrectEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBrew(BrewingStandFuelEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }
}
