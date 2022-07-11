package net.tonimatasmc.perworldplugins.listener;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.util.RegisteredListenerUtils;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.plugin.RegisteredListener;

public final class TimedRegisteredListener extends org.bukkit.plugin.TimedRegisteredListener implements Listener {
    private final org.bukkit.plugin.TimedRegisteredListener delegate;

    public TimedRegisteredListener(org.bukkit.plugin.TimedRegisteredListener delegate) {
        super(delegate.getListener(), RegisteredListenerUtils.getExecutorFromRegisteredListener(delegate).orElseThrow(IllegalArgumentException::new), delegate.getPriority(), delegate.getPlugin(), delegate.isIgnoringCancelled());
        this.delegate = delegate;
    }

    @SuppressWarnings("NullableProblems")
    public void callEvent(Event event) throws EventException {
        if (RegisteredListenerUtils.checkEnabled(PerWorldPlugins.getPlugin(), this, event)) {
            this.delegate.callEvent(event);
        }

    }

    public RegisteredListener getDelegate() {
        return this.delegate;
    }
}
