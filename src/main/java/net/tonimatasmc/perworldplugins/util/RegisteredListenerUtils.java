package net.tonimatasmc.perworldplugins.util;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.listener.Listener;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.bukkit.event.Event;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.RegisteredListener;

import java.lang.reflect.Field;
import java.util.Optional;

public final class RegisteredListenerUtils {
    private static final Field EXECUTOR_FIELD = FieldUtils.getField(RegisteredListener.class, "executor", true);

    public static Optional<EventExecutor> getExecutorFromRegisteredListener(RegisteredListener listener) {
        try {
            return Optional.of((EventExecutor) EXECUTOR_FIELD.get(listener));
        } catch (IllegalAccessException var2) {
            var2.printStackTrace();
            return Optional.empty();
        }
    }

    public static boolean checkEnabled(PerWorldPlugins parent, Listener listener, Event event) {
        if (!parent.isEnabled()) {
            return true;
        } else {
            if (WorldUtil.getWorldFromEvent(event) != null) {
                PerWorldPlugins.getInjector().registerEvent(listener.getDelegate().getPlugin(), event.getClass());
                return !(PerWorldPlugins.getPlugin().getConfig().getStringList("plugins." + listener.getDelegate().getPlugin().getName()).contains(WorldUtil.getWorldFromEvent(event).getName()));
            } else {
                return false;
            }
        }
    }

    private RegisteredListenerUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
