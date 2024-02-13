package net.tonimatasdev.perworldplugins.api;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TimedRegisteredListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class PerWorldTimedRegisteredListener extends TimedRegisteredListener {
    private List<String> disabledWorlds;

    public PerWorldTimedRegisteredListener(Listener listener, EventExecutor executor, EventPriority priority, Plugin plugin, boolean ignoreCancelled) {
        super(listener, executor, priority, plugin, ignoreCancelled);
        this.disabledWorlds = new ArrayList<>();
    }

    @SuppressWarnings("NullableProblems")
    public void callEvent(Event event) {
        // If X-Events get player and detect if blocked so that it is not run.
        if (PerWorldUtils.checkEvent(event, this.disabledWorlds)) return;

        try {
            // Execute the event if it is not blocked.
            super.callEvent(event);
        } catch (Throwable ex) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not pass event " + event.getEventName() + " to " + getPlugin().getName() + " v" + getPlugin().getDescription().getVersion(), ex);
        }
    }

    public void setDisabledWorlds() {
        this.disabledWorlds = PerWorldUtils.getDisabledWorlds(getPlugin());
    }
}
