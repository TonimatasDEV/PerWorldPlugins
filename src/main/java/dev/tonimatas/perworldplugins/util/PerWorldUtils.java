package dev.tonimatas.perworldplugins.util;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import dev.tonimatas.perworldplugins.config.GroupsYML;
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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PerWorldUtils {
    public static List<String> getDisabledWorlds(String pluginName) {
        List<String> worldList = PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + pluginName);

        if (worldList.contains(":ignore") || worldList.isEmpty()) return new ArrayList<>();

        List<String> withGroupWorlds = new ArrayList<>(worldList);

        for (String var : worldList) {
            if (var.startsWith("g:")) {
                String group = var.substring(2);
                withGroupWorlds.remove(var);
                withGroupWorlds.addAll(GroupsYML.get().getStringList(group));
            }

            if (var.endsWith("*")) {
                String worldExpression = var.replace("*", "");

                withGroupWorlds.addAll(getAllWorldWithCondition(name -> name.startsWith(worldExpression)));
            }

            if (var.startsWith("*")) {
                String worldExpression = var.replace("*", "");

                withGroupWorlds.addAll(getAllWorldWithCondition(name -> name.endsWith(worldExpression)));
            }
        }

        if (PerWorldPlugins.getInstance().getConfig().getBoolean("blacklist")) {
            return withGroupWorlds;
        } else {
            List<String> serverWorlds = new ArrayList<>();

            try {
                serverWorlds.addAll(Bukkit.getWorlds().stream().map(World::getName).collect(Collectors.toList()));
            } catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error on get blocked worlds of: " + pluginName);
            }

            serverWorlds.removeAll(withGroupWorlds);
            return serverWorlds;
        }
    }

    public static List<String> getAllWorldWithCondition(Predicate<String> function) {
        return Bukkit.getWorlds().stream().map(World::getName).filter(function).collect(Collectors.toList());
    }

    public static boolean checkEvent(Event event, List<String> disabledWorlds) {
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
