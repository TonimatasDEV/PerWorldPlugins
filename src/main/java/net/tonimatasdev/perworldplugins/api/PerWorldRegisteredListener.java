package net.tonimatasdev.perworldplugins.api;

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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class PerWorldRegisteredListener extends RegisteredListener {
    private List<String> disabledWorlds;

    public PerWorldRegisteredListener(Listener listener, EventExecutor executor, EventPriority priority, Plugin plugin, boolean ignoreCancelled) {
        super(listener, executor, priority, plugin, ignoreCancelled);
        this.disabledWorlds = new ArrayList<>();
    }

    @SuppressWarnings("NullableProblems")
    public void callEvent(Event event) {
        // If X-Events get player and detect if blocked so that it is not run.
        if (event instanceof BlockEvent) {
            if (disabledWorlds.contains(((BlockEvent) event).getBlock().getWorld().getName())) return;
        }

        if (event instanceof EntityEvent) {
            if (disabledWorlds.contains(((EntityEvent) event).getEntity().getWorld().getName())) return;
        }

        if (event instanceof HangingEvent) {
            if (disabledWorlds.contains(((HangingEvent) event).getEntity().getWorld().getName())) return;
        }

        if (event instanceof InventoryEvent) {
            if (disabledWorlds.contains(((InventoryEvent) event).getView().getPlayer().getWorld().getName())) return;
        }

        if (event instanceof PlayerEvent) {
            if (disabledWorlds.contains(((PlayerEvent) event).getPlayer().getWorld().getName())) return;
        }

        if (event instanceof VehicleEvent) {
            if (disabledWorlds.contains(((VehicleEvent) event).getVehicle().getWorld().getName())) return;
        }

        if (event instanceof WeatherEvent) {
            if (disabledWorlds.contains(((WeatherEvent) event).getWorld().getName())) return;
        }

        if (event instanceof WorldEvent) {
            if (disabledWorlds.contains(((WorldEvent) event).getWorld().getName())) return;
        }

        try {
            // Execute the event if it is not blocked.
            super.callEvent(event);
        } catch (Throwable ex) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not pass event " + event.getEventName() + " to " + getPlugin().getName() + " v" + getPlugin().getDescription().getVersion(), ex);
        }
    }

    public void setDisabledWorlds(List<String> disabledWorlds) {
        this.disabledWorlds = disabledWorlds;
    }
}
