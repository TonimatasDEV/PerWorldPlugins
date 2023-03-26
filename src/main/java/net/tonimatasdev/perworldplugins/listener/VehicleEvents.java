package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.*;

public class VehicleEvents implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBlockCollision(VehicleBlockCollisionEvent event) {
        PerWorldUtils.fireEvent(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCreate(VehicleCreateEvent event) {
        PerWorldUtils.fireEvent(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDamage(VehicleDamageEvent event) {
        PerWorldUtils.fireEvent(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDestroy(VehicleDestroyEvent event) {
        PerWorldUtils.fireEvent(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEnter(VehicleEnterEvent event) {
        PerWorldUtils.fireEvent(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEntityCollision(VehicleEntityCollisionEvent event) {
        PerWorldUtils.fireEvent(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onExit(VehicleExitEvent event) {
        PerWorldUtils.fireEvent(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMove(VehicleMoveEvent event) {
        PerWorldUtils.fireEvent(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVehicleUpdate(VehicleUpdateEvent event) {
        PerWorldUtils.fireEvent(event, event.getVehicle().getWorld());
    }
}
