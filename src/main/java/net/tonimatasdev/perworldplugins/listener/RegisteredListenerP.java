package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.util.RegisteredListenerUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.RegisteredListener;

import java.util.logging.Level;

public final class RegisteredListenerP extends RegisteredListener {
    public RegisteredListenerP(RegisteredListener delegate) {
        super(delegate.getListener(), RegisteredListenerUtils.getExecutorFromRegisteredListener(delegate).orElseThrow(IllegalArgumentException::new), delegate.getPriority(), delegate.getPlugin(), delegate.isIgnoringCancelled());
    }

    public void callEvent(Event event) {
        if (RegisteredListenerUtils.checkEnabled(PerWorldPlugins.getPlugin(), super.getPlugin(), event)) {
            try {
                super.callEvent(event);
            } catch (Throwable e) {
                Bukkit.getServer().getLogger().log(Level.SEVERE, "[PerWorldPlugins] Could not pass event " + event.getEventName() + " to " + getPlugin().getDescription().getFullName(), e);
            }
        }
    }
}
