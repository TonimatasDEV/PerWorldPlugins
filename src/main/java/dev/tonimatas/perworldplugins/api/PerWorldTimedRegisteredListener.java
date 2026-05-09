package dev.tonimatas.perworldplugins.api;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import dev.tonimatas.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TimedRegisteredListener;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PerWorldTimedRegisteredListener extends TimedRegisteredListener {
    private List<String> disabledWorlds;

    public PerWorldTimedRegisteredListener(Listener listener, EventExecutor executor, EventPriority priority, Plugin plugin, boolean ignoreCancelled) {
        super(listener, executor, priority, plugin, ignoreCancelled);
        this.disabledWorlds = new ArrayList<>();
    }

    @SuppressWarnings({"UnstableApiUsage"})
    public void callEvent(@NonNull Event event) {
        if (PerWorldUtils.checkEvent(event, this.disabledWorlds)) return;

        try {
            super.callEvent(event);
        } catch (Throwable ex) {
            PerWorldPlugins.LOGGER.warn("Could not pass event {} to {} v{}", event.getEventName(), getPlugin().getName(), getPlugin().getPluginMeta().getVersion(), ex);
        }
    }

    public void setDisabledWorlds() {
        this.disabledWorlds = PerWorldUtils.getDisabledWorlds(getPlugin().getName());
    }
}
