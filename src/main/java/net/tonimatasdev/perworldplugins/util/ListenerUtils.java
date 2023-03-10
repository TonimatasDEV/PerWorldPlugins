package net.tonimatasdev.perworldplugins.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.RegisteredListener;

import java.util.*;

public class ListenerUtils {
    private static final Map<HandlerList, RegisteredListener[]> map = new HashMap<>();
    public static final List<String> plugins = Arrays.asList("PerWorldPlugins", "BedWars1058");

    public static void addListeners() {
        HandlerListUtil.minecraftHandlerLists.forEach((handlerList -> {
            ArrayList<RegisteredListener> arrayList = new ArrayList<>();

            Arrays.stream(handlerList.getRegisteredListeners())
                    .filter(registeredListener -> !plugins.contains(registeredListener.getPlugin().getName()))
                    .forEach(registeredListener -> {
                        arrayList.add(registeredListener);
                        handlerList.unregister(registeredListener);
                    });

            map.put(handlerList, arrayList.toArray(new RegisteredListener[0]));
        }));

        Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Unregistered all Listeners correctly.");
    }

    public static void perWorldPlugins(Event event, World world) {
        PerWorldUtils.isInPlugin(event, world, map.get(event.getHandlers()));
    }
}
