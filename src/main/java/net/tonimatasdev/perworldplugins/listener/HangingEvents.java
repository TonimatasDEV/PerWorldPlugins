package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;

public class HangingEvents implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBreakByEntity(HangingBreakByEntityEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBreak(HangingBreakEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlace(HangingPlaceEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }
}
