package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.util.RegisteredListenerUtils;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.plugin.RegisteredListener;

public final class TimedRegisteredListener extends org.bukkit.plugin.TimedRegisteredListener implements Listener {
    private final org.bukkit.plugin.TimedRegisteredListener delegate;

    public TimedRegisteredListener(org.bukkit.plugin.TimedRegisteredListener delegate) {
        super(delegate.getListener(), RegisteredListenerUtils.getExecutorFromRegisteredListener(delegate).orElseThrow(IllegalArgumentException::new), delegate.getPriority(), delegate.getPlugin(), delegate.isIgnoringCancelled());
        this.delegate = delegate;
    }

    public void callEvent(Event event) throws EventException {
        if (RegisteredListenerUtils.checkEnabled(PerWorldPlugins.getPlugin(), this, event)) {
            this.delegate.callEvent(event);
        }

    }

    public RegisteredListener getDelegate() {
        return this.delegate;
    }
}
