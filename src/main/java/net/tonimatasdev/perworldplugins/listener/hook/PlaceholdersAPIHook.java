package net.tonimatasdev.perworldplugins.listener.hook;

import me.clip.placeholderapi.events.ExpansionRegisterEvent;
import me.clip.placeholderapi.events.ExpansionUnregisterEvent;
import me.clip.placeholderapi.events.ExpansionsLoadedEvent;
import me.clip.placeholderapi.events.PlaceholderHookUnloadEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class PlaceholdersAPIHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerHide(ExpansionRegisterEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerHide(ExpansionsLoadedEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerHide(ExpansionUnregisterEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerHide(PlaceholderHookUnloadEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
