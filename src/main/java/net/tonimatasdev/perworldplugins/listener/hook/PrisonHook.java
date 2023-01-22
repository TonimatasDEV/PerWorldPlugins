package net.tonimatasdev.perworldplugins.listener.hook;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import tech.mcprison.prison.spigot.api.ExplosiveBlockBreakEvent;
import tech.mcprison.prison.spigot.api.PrisonMinesBlockBreakEvent;

public class PrisonHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerHide(ExplosiveBlockBreakEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerHide(PrisonMinesBlockBreakEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
