package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.listener.hook.Hooks;
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
    private static final List<String> ignored = Arrays.asList("PerWorldPlugins", "BedWars", "SBA", "ModelEngine");

    public static void addListeners() {
        HandlerList.getHandlerLists().forEach((handlerList -> map.put(handlerList, handlerList.getRegisteredListeners())));

        for (Plugin plugin : Bukkit.getServer().getPluginManager().getPlugins()) {
            if (!ignored.contains(plugin.getName())) {
                HandlerList.unregisterAll(plugin);

                PerWorldPlugins.getInstance().getConfig().set("plugins." + plugin.getName(), Collections.singletonList("Example"));
                PerWorldPlugins.getInstance().saveConfig();
                PerWorldPlugins.getInstance().reloadConfig();
            }
        }

        Hooks.register();

        Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Unregistered all Listeners correctly.");
    }

    public static void perWorldPlugins(Event event, World world) {
        RegisteredListener[] registeredListeners = map.get(event.getHandlers());

        if (registeredListeners != null) {
            for (RegisteredListener registeredListener : registeredListeners) {
                Plugin plugin = registeredListener.getPlugin();

                if (!ignored.contains(plugin.getName())) {
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

    public static void noWorldEvents(Event event) {
        RegisteredListener[] registeredListeners = map.get(event.getHandlers());

        if (registeredListeners != null) {
            for (RegisteredListener registeredListener : registeredListeners) {
                if (!ignored.contains(registeredListener.getPlugin().getName())) {
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
