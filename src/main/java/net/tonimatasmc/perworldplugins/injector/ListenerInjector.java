package net.tonimatasmc.perworldplugins.injector;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.listener.Listener;
import net.tonimatasmc.perworldplugins.listener.RegisteredListener;
import net.tonimatasmc.perworldplugins.listener.TimedRegisteredListener;
import net.tonimatasmc.perworldplugins.util.IgnoredPlugins;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings("ForLoopReplaceableByForEach")
public final class ListenerInjector extends BukkitRunnable implements org.bukkit.event.Listener {
    private final Map<Plugin, Set<Class<? extends Event>>> events;
    private boolean loaded = true;

    public ListenerInjector() {
        this.events = (new MapMaker()).weakKeys().makeMap();
    }

    public void registerEvent(Plugin plugin, Class<? extends Event> event) {
        this.events.computeIfAbsent(plugin, (p) -> Collections.newSetFromMap((new MapMaker()).weakKeys().makeMap())).add(event);
    }

    public void run() {
        if (this.loaded) {
            HandlerList.getHandlerLists().forEach((handlerList) -> {
                org.bukkit.plugin.RegisteredListener[] var2 = handlerList.getRegisteredListeners();

                int var3 = var2.length;

                for (int var4 = 0; var4 < var3; ++var4) {
                    org.bukkit.plugin.RegisteredListener listener = var2[var4];

                    if (IgnoredPlugins.useListener(listener) && !(listener instanceof Listener)) {
                        handlerList.unregister(listener);

                        try {
                            handlerList.register(listener instanceof org.bukkit.plugin.TimedRegisteredListener ? new TimedRegisteredListener((org.bukkit.plugin.TimedRegisteredListener) listener) : new RegisteredListener(listener));
                        } catch (Exception var7) {
                            handlerList.register(listener);
                            PerWorldPlugins.getPlugin().getLogger().severe(() -> "Failed to inject handler into " + listener.getPlugin() + ".");
                        }
                    }
                }

            });
        }
    }

    public void load() {
        Bukkit.getPluginManager().registerEvents(this, PerWorldPlugins.getPlugin());
        super.runTaskTimer(PerWorldPlugins.getPlugin(), 0L, 6000L);
    }

    @SuppressWarnings("unused")
    public Optional<ImmutableSet<Class<? extends Event>>> getEventsForPlugin(Plugin plugin) {
        Set<Class<? extends Event>> tmpEvents = this.events.get(plugin);
        return tmpEvents == null ? Optional.empty() : Optional.of(ImmutableSet.copyOf(tmpEvents));
    }

    public void unload() {
        this.loaded = false;
        HandlerList.getHandlerLists().forEach((handlerList) -> {
            org.bukkit.plugin.RegisteredListener[] var2 = handlerList.getRegisteredListeners();
            int var3 = var2.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                org.bukkit.plugin.RegisteredListener listener = var2[var4];
                if (listener instanceof Listener) {
                    handlerList.unregister(listener);

                    try {
                        handlerList.register(((Listener) listener).getDelegate());
                    } catch (Exception var7) {
                        PerWorldPlugins.getPlugin().getLogger().severe("Failed to detach PerWorldPlugins from listener pipeline.");
                    }
                }
            }

        });
    }

    @EventHandler
    public void onEnable(PluginEnableEvent event) {
        if (IgnoredPlugins.usePluginEvent(event)) {
            this.run();
        }

    }

    @EventHandler
    public void onDisable(PluginDisableEvent event) {
        if (IgnoredPlugins.usePluginEvent(event)) {
            this.run();
        }

    }
}

