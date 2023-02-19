package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExhaustionEvent;
import org.bukkit.event.entity.PiglinBarterEvent;
import org.bukkit.event.inventory.SmithItemEvent;
import org.bukkit.event.player.PlayerBucketEntityEvent;
import org.bukkit.event.player.PlayerBucketFishEvent;

public class v1165 implements Listener {

    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(EntityExhaustionEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PiglinBarterEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerBucketEntityEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onExhaustion(EntityExhaustionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPiglinBarter(PiglinBarterEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSmithItem(SmithItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getView().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBucketEntity(PlayerBucketEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBucketFish(PlayerBucketFishEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
