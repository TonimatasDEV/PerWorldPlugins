package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BrewingStartEvent;
import org.bukkit.event.block.CampfireStartEvent;
import org.bukkit.event.block.InventoryBlockStartEvent;
import org.bukkit.event.inventory.HopperInventorySearchEvent;
import org.bukkit.event.inventory.PrepareGrindstoneEvent;
import org.bukkit.event.inventory.PrepareInventoryResultEvent;
import org.bukkit.event.world.AsyncStructureSpawnEvent;

@SuppressWarnings("deprecation")
public class v1193 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(PrepareInventoryResultEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(BrewingStartEvent.getHandlerList());

        HandlerListUtil.minecraftHandlerLists.add(CampfireStartEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(InventoryBlockStartEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(AsyncStructureSpawnEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PrepareGrindstoneEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(HopperInventorySearchEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAsyncPlayerChatPreview(PrepareInventoryResultEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getView().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAsyncPlayerChatPreview(BrewingStartEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }
}
