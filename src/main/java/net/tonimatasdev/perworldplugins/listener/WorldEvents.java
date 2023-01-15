package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.*;

public class WorldEvents implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onPortalCreate(PortalCreateEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onSpawnChange(SpawnChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onStructureGlow(StructureGrowEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onSave(WorldSaveEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onUnload(WorldUnloadEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }
}
