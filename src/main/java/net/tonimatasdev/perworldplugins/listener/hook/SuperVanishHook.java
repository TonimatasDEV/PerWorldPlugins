package net.tonimatasdev.perworldplugins.listener.hook;

import de.myzelyam.api.vanish.*;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class SuperVanishHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerHide(PlayerHideEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerShow(PlayerShowEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerVanishStateChange(PlayerVanishStateChangeEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPostPlayerHide(PostPlayerHideEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPostPlayerShow(PostPlayerShowEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
