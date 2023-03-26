package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.*;

public class WorldEvents implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChunkLoad(ChunkLoadEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChunkPopulate(ChunkPopulateEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChunkUnload(ChunkUnloadEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPortalCreate(PortalCreateEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSpawnChange(SpawnChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onStructureGlow(StructureGrowEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onInit(WorldInitEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLoad(WorldLoadEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSave(WorldSaveEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUnload(WorldUnloadEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }
}
