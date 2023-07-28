package net.tonimatasdev.perworldplugins.manager;

import net.tonimatasdev.perworldplugins.api.PerWorldRegisteredListener;
import net.tonimatasdev.perworldplugins.api.PerWorldTimedRegisteredListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.TimedRegisteredListener;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ListenerManager {
    public static void convert(Plugin plugin) {
        // Get all RegisteredListeners of the plugin and convert 1 per 1.
        for (RegisteredListener registeredListener : HandlerList.getRegisteredListeners(plugin)) {
            if (registeredListener instanceof PerWorldRegisteredListener)
                continue; // If RegisteredListener is already converted it passes.

            // Get all HandlerList for get RegisteredListener HandlerList.
            for (HandlerList handlerList : HandlerList.getHandlerLists()) {
                if (!Arrays.asList(handlerList.getRegisteredListeners()).contains(registeredListener))
                    continue; // See if the RegisteredListener is in this HandlerList or not.

                // Unregister RegisteredListener.
                handlerList.unregister(registeredListener);

                if (registeredListener instanceof TimedRegisteredListener) {
                    try {
                        // Get executor.
                        Field executorField = RegisteredListener.class.getDeclaredField("executor");
                        executorField.setAccessible(true);

                        // RegisteredListener to PerWorldRegisteredListener.
                        handlerList.register(new PerWorldTimedRegisteredListener(registeredListener.getListener(), (EventExecutor) executorField.get(registeredListener), registeredListener.getPriority(), registeredListener.getPlugin(), registeredListener.isIgnoringCancelled()));
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        // Get executor.
                        Field executorField = RegisteredListener.class.getDeclaredField("executor");
                        executorField.setAccessible(true);

                        // RegisteredListener to PerWorldRegisteredListener.
                        handlerList.register(new PerWorldRegisteredListener(registeredListener.getListener(), (EventExecutor) executorField.get(registeredListener), registeredListener.getPriority(), registeredListener.getPlugin(), registeredListener.isIgnoringCancelled()));
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}