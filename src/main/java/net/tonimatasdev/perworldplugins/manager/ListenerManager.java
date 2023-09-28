package net.tonimatasdev.perworldplugins.manager;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.api.PerWorldRegisteredListener;
import net.tonimatasdev.perworldplugins.api.PerWorldTimedRegisteredListener;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.TimedRegisteredListener;

import java.lang.reflect.Field;

public class ListenerManager {
    public static void convert() {
        // Get all RegisteredListeners of the plugin and convert 1 per 1.
        for (HandlerList handlerList : HandlerList.getHandlerLists()) {
            for (RegisteredListener registeredListener : handlerList.getRegisteredListeners()) {
                if (registeredListener.getPlugin().equals(PerWorldPlugins.getInstance())) continue;
                if (registeredListener instanceof PerWorldRegisteredListener || registeredListener instanceof PerWorldTimedRegisteredListener) continue;

                handlerList.unregister(registeredListener);

                try {
                    // Get executor.
                    Field executorField = RegisteredListener.class.getDeclaredField("executor");
                    executorField.setAccessible(true);

                    if (registeredListener instanceof TimedRegisteredListener) {
                        // RegisteredListener to PerWorldTimedRegisteredListener.
                        handlerList.register(new PerWorldTimedRegisteredListener(registeredListener.getListener(), (EventExecutor) executorField.get(registeredListener), registeredListener.getPriority(), registeredListener.getPlugin(), registeredListener.isIgnoringCancelled()));
                    } else {
                        // RegisteredListener to PerWorldRegisteredListener.
                        handlerList.register(new PerWorldRegisteredListener(registeredListener.getListener(), (EventExecutor) executorField.get(registeredListener), registeredListener.getPriority(), registeredListener.getPlugin(), registeredListener.isIgnoringCancelled()));
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    PerWorldPlugins.getInstance().getLogger().severe("Problems on get RegisteredListener executor.");
                }
            }
        }

        setWorldsToEvents();
    }

    public static void setWorldsToEvents() {
        Plugin perWorldPlugins = PerWorldPlugins.getInstance();

        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            if (plugin.equals(perWorldPlugins)) continue;

            for (RegisteredListener registeredListener : HandlerList.getRegisteredListeners(plugin)) {
                if (registeredListener instanceof PerWorldRegisteredListener) {
                    ((PerWorldRegisteredListener) registeredListener).setDisabledWorlds();
                } else if (registeredListener instanceof PerWorldTimedRegisteredListener){
                    ((PerWorldTimedRegisteredListener) registeredListener).setDisabledWorlds();
                }
            }
        }
    }
}