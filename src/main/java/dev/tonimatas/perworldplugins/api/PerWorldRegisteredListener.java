package dev.tonimatas.perworldplugins.api;

import dev.tonimatas.perworldplugins.util.PerWorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class PerWorldRegisteredListener extends RegisteredListener {
    private List<String> disabledWorlds;

    public PerWorldRegisteredListener(Listener listener, EventExecutor executor, EventPriority priority, Plugin plugin, boolean ignoreCancelled) {
        super(listener, executor, priority, plugin, ignoreCancelled);
        this.disabledWorlds = new ArrayList<>();
    }

    @SuppressWarnings("NullableProblems")
    public void callEvent(Event event) {
        if (PerWorldUtils.checkEvent(event, this.disabledWorlds)) return;

        try {
            super.callEvent(event);
        } catch (Throwable ex) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not pass event " + event.getEventName() + " to " + getPlugin().getName() + " v" + getPlugin().getDescription().getVersion(), ex);
        }
    }

    public void setDisabledWorlds() {
        this.disabledWorlds = PerWorldUtils.getDisabledWorlds(getPlugin());
    }
}
