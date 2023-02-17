package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
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
            map.put(handlerList, handlerList.getRegisteredListeners());

            for (RegisteredListener registeredListener : handlerList.getRegisteredListeners()) {
                if (!plugins.contains(registeredListener.getPlugin().getName())) {
                    handlerList.unregister(registeredListener);
                }
            }
        }));

        Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Unregistered all Listeners correctly.");
    }

    public static void perWorldPlugins(Event event, World world) {
        RegisteredListener[] registeredListeners = map.get(event.getHandlers());

        if (registeredListeners != null) {
            for (RegisteredListener registeredListener : registeredListeners) {
                Plugin plugin = registeredListener.getPlugin();

                if (!plugins.contains(plugin.getName())) {
                    if (PerWorldPlugins.getInstance().getConfig().getBoolean("blacklist")) {
                        if (!PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + plugin.getName()).contains(world.getName())) {
                            try {
                                registeredListener.callEvent(event);
                            } catch (EventException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + plugin.getName()).contains(world.getName())) {
                            try {
                                registeredListener.callEvent(event);
                            } catch (EventException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }

                }
            }
        }
    }
}
