package net.tonimatasdev.perworldplugins.manager;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.api.PerWorldRegisteredListener;
import net.tonimatasdev.perworldplugins.api.PerWorldTimedRegisteredListener;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.TimedRegisteredListener;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ListenerManager {
    public static void convert() {
        // Get all RegisteredListeners of the plugin and convert 1 per 1.
        for (HandlerList handlerList : HandlerList.getHandlerLists()) {
            for (RegisteredListener registeredListener : handlerList.getRegisteredListeners()) {
                if (registeredListener.getPlugin().equals(PerWorldPlugins.getInstance())) continue;
                if (registeredListener instanceof PerWorldRegisteredListener || registeredListener instanceof PerWorldTimedRegisteredListener) continue;

                handlerList.unregister(registeredListener);

                if (registeredListener instanceof TimedRegisteredListener) {
                    try {
                        // Get executor.
                        Field executorField = RegisteredListener.class.getDeclaredField("executor");
                        executorField.setAccessible(true);

                        // RegisteredListener to PerWorldRegisteredListener.
                        handlerList.register(new PerWorldTimedRegisteredListener(registeredListener.getListener(), (EventExecutor) executorField.get(registeredListener), registeredListener.getPriority(), registeredListener.getPlugin(), registeredListener.isIgnoringCancelled(), new ArrayList<>()));
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        // Get executor.
                        Field executorField = RegisteredListener.class.getDeclaredField("executor");
                        executorField.setAccessible(true);

                        // RegisteredListener to PerWorldRegisteredListener.
                        handlerList.register(new PerWorldRegisteredListener(registeredListener.getListener(), (EventExecutor) executorField.get(registeredListener), registeredListener.getPriority(), registeredListener.getPlugin(), registeredListener.isIgnoringCancelled(), new ArrayList<>()));
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        setWorldsToEvents();
    }

    public static void setWorldsToEvents() {
        Plugin perWorldPlugins = PerWorldPlugins.getInstance();

        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            if (plugin.equals(perWorldPlugins)) continue;

            List<String> worlds = new ArrayList<>(PerWorldUtils.getDisabledWorlds(plugin));

            for (RegisteredListener registeredListener : HandlerList.getRegisteredListeners(plugin)) {
                if (registeredListener instanceof PerWorldRegisteredListener) {
                    ((PerWorldRegisteredListener) registeredListener).setDisabledWorlds(worlds);
                } else if (registeredListener instanceof PerWorldTimedRegisteredListener){
                    ((PerWorldTimedRegisteredListener) registeredListener).setDisabledWorlds(worlds);
                }
            }
        }
    }
}