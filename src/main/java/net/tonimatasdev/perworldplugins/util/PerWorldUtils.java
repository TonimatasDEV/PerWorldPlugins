package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

import java.util.Arrays;
import java.util.List;

public class PerWorldUtils {
    public static boolean check(World world, Plugin plugin) {
        List<String> worldList = PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + plugin.getName());
        boolean isInPlugin = false;

        for (String var : worldList) {
            if (var.contains(":")) {
                isInPlugin = GroupsYML.get().getStringList(var.replaceAll("g:", "")).contains(world.getName());
            }
        }

        if (!isInPlugin) {
            isInPlugin = worldList.contains(world.getName());
        }

        if (PerWorldPlugins.getInstance().getConfig().getBoolean("blacklist")) {
            isInPlugin = !isInPlugin;
        }

        if (plugin.getName().equalsIgnoreCase("PerWorldPlugins")) {
            isInPlugin = true;
        }

        return isInPlugin;
    }

    public static void fireEvent(Event event, World world) {
        List<RegisteredListener> listeners = PerWorldPlugins.getMap().get(event.getHandlers());
        List<RegisteredListener> perWorldPluginsEvents = Arrays.asList(event.getHandlers().getRegisteredListeners());

        if (listeners == null) return;

        for (RegisteredListener perWorldPluginsEvent : perWorldPluginsEvents) {
            event.getHandlers().unregister(perWorldPluginsEvent);
        }

        for (RegisteredListener listener : listeners) {
            if (PerWorldUtils.check(world, listener.getPlugin())) {
                event.getHandlers().register(listener);
            }
        }

        PerWorldPlugins.getInstance().getServer().getPluginManager().callEvent(event);
        listeners.forEach((registeredListener -> event.getHandlers().unregister(registeredListener)));
        event.getHandlers().registerAll(perWorldPluginsEvents);
    }
}
