package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(CauldronLevelChangeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(AreaEffectCloudApplyEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EnderDragonChangePhaseEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EntityToggleGlideEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(LingeringPotionSplashEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(VillagerAcquireTradeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(VillagerReplenishTradeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PrepareAnvilEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerChangedMainHandEvent.getHandlerList());
        //HandlerListUtil.minecraftHandlerLists.add(PlayerPickupArrowEvent.getHandlerList()); Not have HandlerList
        HandlerListUtil.minecraftHandlerLists.add(PlayerSwapHandItemsEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(TabCompleteEvent.getHandlerList());

    }

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
        CommandSender sender = event.getSender();

        if (sender instanceof Player) {
            ListenerUtils.perWorldPlugins(event, ((Player) sender).getWorld());
        }
    }
}
