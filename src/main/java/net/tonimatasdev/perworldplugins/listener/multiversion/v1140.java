package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCookEvent;
import org.bukkit.event.block.BlockShearEntityEvent;
import org.bukkit.event.entity.EntityPoseChangeEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.event.inventory.TradeSelectEvent;
import org.bukkit.event.player.PlayerTakeLecternBookEvent;

public class v1140 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(BlockCookEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(TradeSelectEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerTakeLecternBookEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(VillagerCareerChangeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(BlockShearEntityEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EntityPoseChangeEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCook(BlockCookEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTradeSelect(TradeSelectEvent event) {
        PerWorldUtils.fireEvent(event, event.getView().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTakeLecternBook(PlayerTakeLecternBookEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }


    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVillagerCareerChange(VillagerCareerChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onShearEntity(BlockShearEntityEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPoseChange(EntityPoseChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }
}
