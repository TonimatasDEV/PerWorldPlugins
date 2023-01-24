package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.server.TabCompleteEvent;

public class v19 implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCauldronLevelChange(CauldronLevelChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAreaEffectCloudApply(AreaEffectCloudApplyEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEnderDragonChangePhase(EnderDragonChangePhaseEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onToggleGlide(EntityToggleGlideEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLingeringPotionSplash(LingeringPotionSplashEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVillagerAcquireTrade(VillagerAcquireTradeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVillagerReplenishTrade(VillagerReplenishTradeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrepareAnvil(PrepareAnvilEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getView().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChangedMainHand(PlayerChangedMainHandEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPickupItem(PlayerPickupArrowEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSwapHandItems(PlayerSwapHandItemsEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTabComplete(TabCompleteEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
