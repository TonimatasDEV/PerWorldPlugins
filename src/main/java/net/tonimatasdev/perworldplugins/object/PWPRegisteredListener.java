package net.tonimatasdev.perworldplugins.object;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

public class PWPRegisteredListener {
    private final Plugin plugin;
    private final HandlerList handlerList;
    private final RegisteredListener registeredListener;
    private final EventPriority eventPriority;

    public PWPRegisteredListener(Plugin plugin, HandlerList handlerList, RegisteredListener registeredListener, EventPriority eventPriority) {
        this.plugin = plugin;
        this.handlerList = handlerList;
        this.registeredListener = registeredListener;
        this.eventPriority = eventPriority;

        handlerList.unregister(registeredListener);
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public HandlerList getHandlerList() {
        return handlerList;
    }

    public RegisteredListener getRegisteredListener() {
        return registeredListener;
    }

    public EventPriority getEventPriority() {
        return eventPriority;
    }

    public void execute(Event event, World world) {
        if (PerWorldUtils.isInBlackList(world, plugin)) {
            try {
                registeredListener.callEvent(event);
            } catch (EventException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
