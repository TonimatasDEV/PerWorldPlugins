package net.tonimatasdev.perworldplugins.listener.hook;

import me.RockinChaos.itemjoin.handlers.events.InventoryCloseEvent;
import me.RockinChaos.itemjoin.handlers.events.PlayerAutoCraftEvent;
import me.RockinChaos.itemjoin.handlers.events.PlayerPickItemEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ItemJoinHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onInventoryClose(InventoryCloseEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerAutoCraft(PlayerAutoCraftEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerPickItem(PlayerPickItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
