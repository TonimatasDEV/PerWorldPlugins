package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.inventory.SmithItemEvent;
import org.bukkit.event.player.PlayerBucketEntityEvent;
import org.bukkit.event.player.PlayerBucketFishEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;

public class v116 implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onArrowBodyCountChange(ArrowBodyCountChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onStriderTemperatureChange(StriderTemperatureChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEnterLoveMode(EntityEnterLoveModeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onExhaustion(EntityExhaustionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSpellCast(EntitySpellCastEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPiglinBarter(PiglinBarterEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrepareSmithing(PrepareSmithingEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getView().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSmithItem(SmithItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getView().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBucketEntity(PlayerBucketEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBucketFish(PlayerBucketFishEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onHarvestBlock(PlayerHarvestBlockEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
