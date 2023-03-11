package net.tonimatasdev.perworldplugins.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.RegisteredListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListenerUtils {
    private static final Map<HandlerList, RegisteredListener[]> map = new HashMap<>();

    public static void addListeners() {
        long time = System.currentTimeMillis();

        HandlerListUtil.minecraftHandlerLists.forEach((handlerList -> {
            ArrayList<RegisteredListener> arrayList = new ArrayList<>();

            for (RegisteredListener registeredListener : handlerList.getRegisteredListeners()) {
                if (registeredListener.getPlugin().getName().equalsIgnoreCase("PerWorldPlugins")) continue;
                arrayList.add(registeredListener);
                handlerList.unregister(registeredListener);
            }

            map.put(handlerList, arrayList.toArray(new RegisteredListener[0]));
        }));

        long currentTime = System.currentTimeMillis() - time;
        Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Unregistered all Listeners correctly. (" + currentTime + ")");
    }

    public static void perWorldPlugins(Event event, World world) {
        RegisteredListener[] registeredListeners = map.get(event.getHandlers());

        if (registeredListeners == null) {
            return;
        }

        for (RegisteredListener registeredListener : registeredListeners) {
            if (PerWorldUtils.isInBlackList(world, registeredListener.getPlugin())) {
                try {
                    registeredListener.callEvent(event);
                } catch (EventException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
