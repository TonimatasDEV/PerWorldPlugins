package net.tonimatasdev.perworldplugins.manager;

import net.tonimatasdev.perworldplugins.api.PerWorldRegisteredListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ListenerManager {
    public static void convert(Plugin plugin) {
        for (RegisteredListener registeredListener : HandlerList.getRegisteredListeners(plugin)) {
            if (registeredListener instanceof PerWorldRegisteredListener) continue;

            for (HandlerList handlerList : HandlerList.getHandlerLists()) {
                if (!Arrays.asList(handlerList.getRegisteredListeners()).contains(registeredListener)) continue;

                handlerList.unregister(registeredListener);

                try {
                    Field executorField = RegisteredListener.class.getDeclaredField("executor");
                    executorField.setAccessible(true);
                    handlerList.register(new PerWorldRegisteredListener(registeredListener.getListener(), (EventExecutor) executorField.get(registeredListener), registeredListener.getPriority(), registeredListener.getPlugin(), registeredListener.isIgnoringCancelled()));
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}