package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

import java.util.List;

public class PerWorldUtils {
    public static void isInPlugin(Event event, World world, RegisteredListener[] registeredListeners) {

        if (registeredListeners == null) {
            return;
        }

        for (RegisteredListener registeredListener : registeredListeners) {
            Plugin plugin = registeredListener.getPlugin();

            if (ListenerUtils.plugins.contains(plugin.getName())) {
                continue;
            }

            if (isInBlackList(world, plugin)) {
                executeListener(event, registeredListener);
            }
        }
    }

    public static boolean isInGroup(World world, String group) {
        List<String> worldList = GroupsYML.get().getStringList(group);

        if (worldList.isEmpty()) {
            return false;
        }

        return worldList.contains(world.getName());
    }

    public static void executeListener(Event event, RegisteredListener registeredListener) {


            try {
                registeredListener.callEvent(event);
            } catch (EventException e) {
                throw new RuntimeException(e);
            }

    }

    public static boolean isInBlackList(World world, Plugin plugin) {
        List<String> worldList = PerWorldPlugins.getInstance().getConfig().getStringList(plugin.getName());
        boolean isInPlugin = false;

        for (String var : worldList) {
            if (var.contains(":")) {
                isInPlugin = isInGroup(world, var.replaceAll("g:", ""));
            }
        }

        if (!isInPlugin) {
            isInPlugin = worldList.contains(world.getName());
        }

        if (PerWorldPlugins.getInstance().getConfig().getBoolean("blacklist")) {
            isInPlugin = !isInPlugin;
        }

        return isInPlugin;
    }
}
