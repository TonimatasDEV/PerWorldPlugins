package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.*;

public class VehicleEvents implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onBlockCollision(VehicleBlockCollisionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onCollision(VehicleCollisionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onCreate(VehicleCreateEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onDamage(VehicleDamageEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onDestroy(VehicleDestroyEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onEnter(VehicleEnterEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onEntityCollision(VehicleEntityCollisionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onExit(VehicleExitEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onMove(VehicleMoveEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVehicle().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onUpdate(VehicleUpdateEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVehicle().getWorld());
    }
}
