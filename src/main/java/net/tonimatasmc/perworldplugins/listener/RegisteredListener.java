package net.tonimatasmc.perworldplugins.listener;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.util.RegisteredListenerUtils;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;

public final class RegisteredListener extends org.bukkit.plugin.RegisteredListener implements Listener {
    private final org.bukkit.plugin.RegisteredListener delegate;

    public RegisteredListener(org.bukkit.plugin.RegisteredListener delegate) {
        super(delegate.getListener(), RegisteredListenerUtils.getExecutorFromRegisteredListener(delegate).orElseThrow(IllegalArgumentException::new), delegate.getPriority(), delegate.getPlugin(), delegate.isIgnoringCancelled());
        this.delegate = delegate;
    }

    @SuppressWarnings("NullableProblems")
    public void callEvent(Event event) throws EventException {
        if (RegisteredListenerUtils.checkEnabled(PerWorldPlugins.getPlugin(), this, event)) {
            this.delegate.callEvent(event);
        }

    }

    public org.bukkit.plugin.RegisteredListener getDelegate() {
        return this.delegate;
    }
}
