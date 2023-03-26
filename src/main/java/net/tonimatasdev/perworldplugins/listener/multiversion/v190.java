package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class v190 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(CauldronLevelChangeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(AreaEffectCloudApplyEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EnderDragonChangePhaseEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EntityToggleGlideEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(LingeringPotionSplashEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(VillagerAcquireTradeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(VillagerReplenishTradeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PrepareAnvilEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerSwapHandItemsEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCauldronLevelChange(CauldronLevelChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAreaEffectCloudApply(AreaEffectCloudApplyEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEnderDragonChangePhase(EnderDragonChangePhaseEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onToggleGlide(EntityToggleGlideEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLingeringPotionSplash(LingeringPotionSplashEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVillagerAcquireTrade(VillagerAcquireTradeEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVillagerReplenishTrade(VillagerReplenishTradeEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrepareAnvil(PrepareAnvilEvent event) {
        PerWorldUtils.fireEvent(event, event.getView().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPickupItem(PlayerPickupArrowEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSwapHandItems(PlayerSwapHandItemsEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }
}
