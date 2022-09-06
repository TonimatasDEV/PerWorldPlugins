package net.tonimatasdev.perworldplugins.util;

import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.hanging.HangingEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.vehicle.VehicleEvent;
import org.bukkit.event.weather.WeatherEvent;
import org.bukkit.event.world.WorldEvent;

public final class WorldUtil {
    private WorldUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static World getWorldFromEvent(Event event) {
        World world;
        if (event instanceof BlockEvent) {
            world = ((BlockEvent) event).getBlock().getWorld();
        } else if (event instanceof PlayerEvent) {
            world = ((PlayerEvent) event).getPlayer().getWorld();
        } else if (event instanceof InventoryEvent) {
            world = ((InventoryEvent) event).getView().getPlayer().getWorld();
        } else if (event instanceof EntityEvent) {
            world = ((EntityEvent) event).getEntity().getWorld();
        } else if (event instanceof HangingEvent) {
            world = ((HangingEvent) event).getEntity().getWorld();
        } else if (event instanceof VehicleEvent) {
            world = ((VehicleEvent) event).getVehicle().getWorld();
        } else if (event instanceof WeatherEvent) {
            world = ((WeatherEvent) event).getWorld();
        } else if (event instanceof WorldEvent) {
            world = ((WorldEvent) event).getWorld();
        } else {
            world = null;
        }
        return world;
    }
}
