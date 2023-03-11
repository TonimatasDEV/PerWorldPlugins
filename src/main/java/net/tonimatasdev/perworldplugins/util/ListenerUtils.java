package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.object.PWPRegisteredListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

import java.util.*;

public class ListenerUtils {
    private static final Map<HandlerList, PWPRegisteredListener[]> map = new HashMap<>();

    public static void addListeners(Plugin plugin) {
        long time = System.currentTimeMillis();

        if (plugin.getName().equalsIgnoreCase("PerWorldPLugins")) return;

        HandlerListUtil.minecraftHandlerLists.forEach((handlerList -> {
            ArrayList<PWPRegisteredListener> arrayList = new ArrayList<>();

            for (RegisteredListener registeredListener : handlerList.getRegisteredListeners()) {
                if (registeredListener.getPlugin() != plugin) {
                    continue;
                }

                arrayList.add(new PWPRegisteredListener(registeredListener.getPlugin(), handlerList, registeredListener, registeredListener.getPriority()));
            }

            map.put(handlerList, arrayList.toArray(new PWPRegisteredListener[0]));
        }));

        long ms = System.currentTimeMillis() - time;
        Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Unregistered all Listeners of " + plugin.getName() + " correctly. (" + ms  + "ms)");
    }

    public static void perWorldPlugins(Event event, World world) {
        PWPRegisteredListener[] pwpRegisteredListeners = map.get(event.getHandlers());

        if (pwpRegisteredListeners == null) {
            return;
        }

        for (PWPRegisteredListener pwpRegisteredListener : pwpRegisteredListeners) {
            pwpRegisteredListener.execute(event, world);
        }
    }
}
