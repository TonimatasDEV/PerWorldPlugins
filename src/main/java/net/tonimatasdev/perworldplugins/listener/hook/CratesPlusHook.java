package net.tonimatasdev.perworldplugins.listener.hook;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import plus.crates.Events.CrateOpenEvent;
import plus.crates.Events.CratePreviewEvent;
import plus.crates.Events.PlayerInputEvent;

public class CratesPlusHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onOpen(CrateOpenEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPreview(CratePreviewEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerInput(PlayerInputEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
