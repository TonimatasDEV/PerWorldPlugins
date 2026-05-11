package dev.tonimatas.perworldplugins.util;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import dev.tonimatas.perworldplugins.config.GroupsYML;
import org.bukkit.Bukkit;
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
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PerWorldUtils {
    public static List<String> getDisabledWorlds(String pluginName) {
        pluginName = pluginName.toLowerCase(Locale.ENGLISH);
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
            List<String> serverWorlds = new ArrayList<>(Bukkit.getWorlds().stream().map(World::getName).toList());
            serverWorlds.removeAll(withGroupWorlds);
            return serverWorlds;
        }
    }

    public static List<String> getAllWorldWithCondition(Predicate<String> function) {
        return Bukkit.getWorlds().stream().map(World::getName).filter(function).collect(Collectors.toList());
    }

    public static boolean checkEvent(Event event, List<String> disabledWorlds) {
        return switch (event) {
            case PlayerEvent playerEvent -> disabledWorlds.contains(playerEvent.getPlayer().getWorld().getName());
            case EntityEvent entityEvent -> disabledWorlds.contains(entityEvent.getEntity().getWorld().getName());
            case BlockEvent blockEvent -> disabledWorlds.contains(blockEvent.getBlock().getWorld().getName());
            case WorldEvent worldEvent -> disabledWorlds.contains(worldEvent.getWorld().getName());
            case HangingEvent hangingEvent -> disabledWorlds.contains(hangingEvent.getEntity().getWorld().getName());
            case InventoryEvent inventoryEvent ->
                    disabledWorlds.contains(inventoryEvent.getView().getPlayer().getWorld().getName());
            case VehicleEvent vehicleEvent -> disabledWorlds.contains(vehicleEvent.getVehicle().getWorld().getName());
            case WeatherEvent weatherEvent -> disabledWorlds.contains(weatherEvent.getWorld().getName());
            case null, default -> false;
        };
    }

    public static void generateConfig() {
        for (Plugin plugin : Bukkit.getServer().getPluginManager().getPlugins()) {
            if (plugin.equals(PerWorldPlugins.getInstance())) continue;
            String pluginName = plugin.getName().toLowerCase(Locale.ENGLISH);

            if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + pluginName).isEmpty()) {
                PerWorldPlugins.getInstance().getConfig().set("plugins." + pluginName, Collections.singletonList(":ignore"));
            }
        }

        PerWorldPlugins.getInstance().saveConfig();
        PerWorldPlugins.getInstance().reloadConfig();
    }
}
