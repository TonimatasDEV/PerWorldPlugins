package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.block.FluidLevelChangeEvent;
import org.bukkit.event.entity.EntityPlaceEvent;
import org.bukkit.event.entity.EntityTransformEvent;

public class v1132 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(BlockDropItemEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(FluidLevelChangeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EntityPlaceEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EntityTransformEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDropItem(BlockDropItemEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFluidLevelChange(FluidLevelChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlace(EntityPlaceEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTransform(EntityTransformEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }
}
