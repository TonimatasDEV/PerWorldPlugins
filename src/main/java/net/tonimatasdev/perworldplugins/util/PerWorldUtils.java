package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerWorldUtils {
    public static List<String> getDisabledWorlds(Plugin plugin) {
        List<String> worldList = PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + plugin.getName());

        if (worldList.contains(":ignore") || worldList.isEmpty()) return new ArrayList<>();

        List<String> withGroupWorlds = new ArrayList<>(worldList);
        // Check if any group contains the world
        for (String var : worldList) {
            // Detects if the string starts with "g:".
            if (var.startsWith("g:")) {
                String group = var.substring(2); // Remove the "g:" prefix.
                withGroupWorlds.remove(var); // Remove the group from the list.


                // Add all worlds to groupWorlds
                withGroupWorlds.addAll(GroupsYML.get().getStringList(group));
            }
        }

        if (PerWorldPlugins.getInstance().getConfig().getBoolean("blacklist")) {
            return withGroupWorlds;
        } else {
            List<String> serverWorlds = new ArrayList<>();
            try {
                serverWorlds.addAll(Bukkit.getWorlds().stream().map(World::getName).collect(Collectors.toList()));
            } catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error on get blocked worlds of: " + plugin.getName());
            }
            serverWorlds.removeAll(withGroupWorlds);
            return serverWorlds;
        }
    }
    
    public static boolean checkEvent(Event event, List<String> disabledWorlds) {
        // Get world for every type of Event
        if (event instanceof PlayerEvent) {
            return disabledWorlds.contains(((PlayerEvent) event).getPlayer().getWorld().getName());
        } else if (event instanceof EntityEvent) {
            return disabledWorlds.contains(((EntityEvent) event).getEntity().getWorld().getName());
        } else if (event instanceof BlockEvent) {
            return disabledWorlds.contains(((BlockEvent) event).getBlock().getWorld().getName());
        } else if (event instanceof WorldEvent) {
            return disabledWorlds.contains(((WorldEvent) event).getWorld().getName());
        } else if (event instanceof HangingEvent) {
            return disabledWorlds.contains(((HangingEvent) event).getEntity().getWorld().getName());
        } else if (event instanceof InventoryEvent) {
            return disabledWorlds.contains(((InventoryEvent) event).getView().getPlayer().getWorld().getName());
        } else if (event instanceof VehicleEvent) {
            return disabledWorlds.contains(((VehicleEvent) event).getVehicle().getWorld().getName());
        } else if (event instanceof WeatherEvent) {
            return disabledWorlds.contains(((WeatherEvent) event).getWorld().getName());
        } else {
            return false;
        }
    }
}
