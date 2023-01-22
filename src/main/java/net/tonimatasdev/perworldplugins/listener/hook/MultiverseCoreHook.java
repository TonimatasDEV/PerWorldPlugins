package net.tonimatasdev.perworldplugins.listener.hook;

import com.onarandombox.MultiverseCore.event.*;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class MultiverseCoreHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onConfigReload(MVConfigReloadEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDebugMode(MVDebugModeEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerTouchedPortal(MVPlayerTouchedPortalEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onRespawn(MVRespawnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTeleport(MVTeleportEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVersion(MVVersionEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onWorldDelete(MVWorldDeleteEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
