package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

import java.util.*;

public class ListenerUtils {
    private static final Map<HandlerList, RegisteredListener[]> map = new HashMap<>();
    private static final List<String> plugins = Arrays.asList("PerWorldPlugins", "BedWars1058");

    public static void addListeners() {
        HandlerListUtil.minecraftHandlerLists.forEach((handlerList -> {
            ArrayList<RegisteredListener> arrayList = new ArrayList<>();

            Arrays.stream(handlerList.getRegisteredListeners())
                    .filter(registeredListener -> !plugins.contains(registeredListener.getPlugin().getName()))
                    .forEach(registeredListener -> {
                        arrayList.add(registeredListener);
                        handlerList.unregister(registeredListener);
                    });

            map.put(handlerList, arrayList.toArray(new RegisteredListener[arrayList.size()]));
        }));

        Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Unregistered all Listeners correctly.");
    }

    public static void perWorldPlugins(Event event, World world) {
        Configuration config = PerWorldPlugins.getInstance().getConfig();

        RegisteredListener[] registeredListeners = map.get(event.getHandlers());
        if (registeredListeners == null) {
            return;
        }

        for (RegisteredListener registeredListener : registeredListeners) {
            Plugin plugin = registeredListener.getPlugin();
            String pluginName = plugin.getName();

            if (plugins.contains(pluginName)) {
                continue;
            }

            boolean shouldCall;
            List<String> worldList = config.getStringList("plugins." + pluginName);

            if (config.getBoolean("blacklist")) {
                shouldCall = !worldList.contains(world.getName());
            } else {
                shouldCall = worldList.contains(world.getName());
            }

            if (shouldCall) {
                try {
                    registeredListener.callEvent(event);
                } catch (EventException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
