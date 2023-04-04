package net.tonimatasdev.perworldplugins.util.listener;

import org.bukkit.Bukkit;
import org.bukkit.Warning;
import org.bukkit.Warning.WarningState;
import org.bukkit.event.*;
import org.bukkit.plugin.AuthorNagException;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;

public class ListenerConvert {
    public static void convert(Plugin plugin) {
        List<Listener> listeners = new ArrayList<>();

        for (RegisteredListener registeredListener : HandlerList.getRegisteredListeners(plugin)) {
            if (listeners.contains(registeredListener.getListener())) continue;

            listeners.add(registeredListener.getListener());
            HandlerList.unregisterAll(registeredListener.getListener());
        }

        for (Listener listener : listeners) {
            Listener listener1 = createRegisteredListeners(listener, plugin);

            if (listener1 == null) continue;
            Bukkit.getPluginManager().registerEvents(listener1, plugin);
        }
    }

    private static Listener createRegisteredListeners(Listener listener, Plugin plugin) {
        List<RegisteredListener> registeredListeners = new ArrayList<>();
        Set<Method> methods = new HashSet<>(Arrays.asList(listener.getClass().getDeclaredMethods()));

        for (Method method : methods) {
            EventHandler eventHandler = method.getAnnotation(EventHandler.class);
            if (eventHandler == null) {
                continue;
            }

            Class<?> checkClass = method.getParameterTypes()[0];
            if (!Event.class.isAssignableFrom(checkClass)) {
                plugin.getLogger().severe(plugin.getDescription().getFullName() + " attempted to register an invalid EventHandler method signature \"" + method.toGenericString() + "\" in " + listener.getClass());
                continue;
            }

            Class<? extends Event> eventClass = checkClass.asSubclass(Event.class);
            method.setAccessible(true);

            for (Class<?> clazz = eventClass; Event.class.isAssignableFrom(clazz); clazz = clazz.getSuperclass()) {
                if (clazz.getAnnotation(Deprecated.class) != null) {
                    Warning warning = clazz.getAnnotation(Warning.class);
                    WarningState warningState = Bukkit.getServer().getWarningState();

                    if (!warningState.printFor(warning)) {
                        break;
                    }

                    plugin.getLogger().log(Level.WARNING, String.format("\"%s\" has registered a listener for %s on method \"%s\", but the event is Deprecated." + " \"%s\"; please notify the authors %s.", plugin.getDescription().getFullName(), clazz.getName(), method.toGenericString(), (warning != null && warning.reason().length() != 0) ? warning.reason() : "Server performance will be affected", Arrays.toString(plugin.getDescription().getAuthors().toArray())), warningState == WarningState.ON ? new AuthorNagException(null) : null);
                    break;
                }
            }

            EventExecutor executor = (listener1, event) -> {
                try {
                    if (!eventClass.isAssignableFrom(event.getClass())) {
                        return;
                    }
                    method.invoke(listener1, event);
                } catch (InvocationTargetException ex) {
                    throw new EventException(ex.getCause());
                } catch (Throwable t) {
                    throw new EventException(t);
                }
            };
            registeredListeners.add(new PerWorldRegisteredListener(listener, executor, eventHandler.priority(), plugin, eventHandler.ignoreCancelled()));
        }

        if (registeredListeners.isEmpty()) {
            return null;
        } else {
            return registeredListeners.get(0).getListener();
        }
    }
}