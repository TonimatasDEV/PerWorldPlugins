package net.tonimatasdev.perworldplugins.util.listener;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.hanging.HangingEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.vehicle.VehicleEvent;
import org.bukkit.event.weather.WeatherEvent;
import org.bukkit.event.world.WorldEvent;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

import java.util.logging.Level;

public class PerWorldRegisteredListener extends RegisteredListener {
    public PerWorldRegisteredListener(Listener listener, EventExecutor executor, EventPriority priority, Plugin plugin, boolean ignoreCancelled) {
        super(listener, executor, priority, plugin, ignoreCancelled);
    }

    public void callEvent(Event event) {
        if (event instanceof BlockEvent) {
            if (PerWorldUtils.check(((BlockEvent) event).getBlock().getWorld(), getPlugin())) return;
        }

        if (event instanceof EntityEvent) {
            if (PerWorldUtils.check(((EntityEvent) event).getEntity().getWorld(), getPlugin())) return;
        }

        if (event instanceof HangingEvent) {
            if (PerWorldUtils.check(((HangingEvent) event).getEntity().getWorld(), getPlugin())) return;
        }

        if (event instanceof InventoryEvent) {
            if (PerWorldUtils.check(((InventoryEvent) event).getView().getPlayer().getWorld(), getPlugin())) return;
        }

        if (event instanceof PlayerEvent) {
            if (PerWorldUtils.check(((PlayerEvent) event).getPlayer().getWorld(), getPlugin())) return;
        }

        if (event instanceof VehicleEvent) {
            if (PerWorldUtils.check(((VehicleEvent) event).getVehicle().getWorld(), getPlugin())) return;
        }

        if (event instanceof WeatherEvent) {
            if (PerWorldUtils.check(((WeatherEvent) event).getWorld(), getPlugin())) return;
        }

        if (event instanceof WorldEvent) {
            if (PerWorldUtils.check(((WorldEvent) event).getWorld(), getPlugin())) return;
        }

        try {
            super.callEvent(event);
        } catch (Throwable ex) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not pass event " + event.getEventName() + " to " + getPlugin().getName() + " v" + getPlugin().getDescription().getVersion(), ex);
        }
    }
}
