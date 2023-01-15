package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

public class ChunkEvents implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onLoad(ChunkLoadEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onPopulate(ChunkPopulateEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onUnload(ChunkUnloadEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }
}
