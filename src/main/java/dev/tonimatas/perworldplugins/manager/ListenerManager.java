package dev.tonimatas.perworldplugins.manager;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import dev.tonimatas.perworldplugins.api.PerWorldRegisteredListener;
import dev.tonimatas.perworldplugins.api.PerWorldTimedRegisteredListener;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.TimedRegisteredListener;

import java.lang.reflect.Field;

public class ListenerManager {
    public static void convert() {
        for (HandlerList handlerList : HandlerList.getHandlerLists()) {
            for (RegisteredListener registeredListener : handlerList.getRegisteredListeners()) {
                if (registeredListener.getPlugin().equals(PerWorldPlugins.getInstance())) continue;
                if (registeredListener instanceof PerWorldRegisteredListener || registeredListener instanceof PerWorldTimedRegisteredListener) continue;

                handlerList.unregister(registeredListener);

                try {
                    Field executorField = RegisteredListener.class.getDeclaredField("executor");
                    executorField.setAccessible(true);

                    boolean handled = false;

                    try {
                        if (registeredListener instanceof TimedRegisteredListener) {
                            handlerList.register(new PerWorldTimedRegisteredListener(registeredListener.getListener(), (EventExecutor) executorField.get(registeredListener), registeredListener.getPriority(), registeredListener.getPlugin(), registeredListener.isIgnoringCancelled()));
                            handled = true;
                        }
                    } catch (Exception ignore) {
                    }

                    if (!handled) {
                        handlerList.register(new PerWorldRegisteredListener(registeredListener.getListener(), (EventExecutor) executorField.get(registeredListener), registeredListener.getPriority(), registeredListener.getPlugin(), registeredListener.isIgnoringCancelled()));
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    PerWorldPlugins.getInstance().getLogger().severe("Problems on get RegisteredListener executor for " + registeredListener.getPlugin().getName() +  " plugin.");
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
                boolean handled = false;

                try {
                    if (registeredListener instanceof PerWorldRegisteredListener) {
                        ((PerWorldRegisteredListener) registeredListener).setDisabledWorlds();
                        handled = true;
                    }
                } catch (Exception ignore) {
                }

                if (!handled && registeredListener instanceof PerWorldTimedRegisteredListener){
                    ((PerWorldTimedRegisteredListener) registeredListener).setDisabledWorlds();
                }
            }
        }
    }
}