package net.tonimatasdev.perworldplugins.listener.hook;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import su.nightexpress.excellentcrates.api.event.CrateEvent;
import su.nightexpress.excellentcrates.api.event.CrateOpenEvent;

public class ExcellentCratesHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCrate(CrateEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCrateOpen(CrateOpenEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
