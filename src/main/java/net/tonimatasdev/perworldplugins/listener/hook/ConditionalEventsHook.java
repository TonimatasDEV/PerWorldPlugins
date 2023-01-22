package net.tonimatasdev.perworldplugins.listener.hook;

import ce.ajneb97.api.ConditionalEventsEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ConditionalEventsHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPanelClosed(ConditionalEventsEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
