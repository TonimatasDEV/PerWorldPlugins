package net.tonimatasdev.perworldplugins.listener.hook;

import me.rockyhawk.commandpanels.api.PanelClosedEvent;
import me.rockyhawk.commandpanels.api.PanelCommandEvent;
import me.rockyhawk.commandpanels.api.PanelOpenedEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class CommandPanelsHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPanelClosed(PanelClosedEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPanelCommand(PanelCommandEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPanelCommand(PanelOpenedEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
