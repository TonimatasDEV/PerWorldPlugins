package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
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
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFluidLevelChange(FluidLevelChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlace(EntityPlaceEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTransform(EntityTransformEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }
}
