package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

import java.util.HashMap;
import java.util.Map;

public class ListenerUtils {
    private static final Map<HandlerList, RegisteredListener[]> map = new HashMap<>();

    public static void addListeners() {
        HandlerList.getHandlerLists().forEach((handlerList -> map.put(handlerList, handlerList.getRegisteredListeners())));

        for (Plugin plugin : Bukkit.getServer().getPluginManager().getPlugins()) {
            if (!plugin.getName().equals("PerWorldPlugins") || !plugin.getName().equals("Geyser-Spigot") || !plugin.getName().equals("floodgate")) {
                HandlerList.unregisterAll(plugin);
            }
        }
    }

    public static void perWorldPlugins(Event event, World world) {
        for (RegisteredListener registeredListener : map.get(event.getHandlers())) {
            Plugin plugin = registeredListener.getPlugin();

            if (!plugin.getName().equals("PerWorldPlugins")) {
                if (PerWorldPlugins.getInstance().getConfig().getBoolean("blacklist")) {
                    if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + plugin.getName()).contains(world.getName())) {
                        event.getHandlers().unregister(registeredListener);
                    } else {
                        event.getHandlers().unregister(registeredListener);
                        event.getHandlers().register(registeredListener);
                    }
                } else {
                    if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + plugin.getName()).contains(world.getName())) {
                        event.getHandlers().unregister(registeredListener);
                        event.getHandlers().register(registeredListener);
                    } else {
                        event.getHandlers().unregister(registeredListener);
                    }
                }
            }
        }
    }
}
