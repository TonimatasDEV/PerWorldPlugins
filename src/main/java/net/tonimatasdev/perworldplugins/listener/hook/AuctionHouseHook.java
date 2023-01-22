package net.tonimatasdev.perworldplugins.listener.hook;

import com.spawnchunk.auctionhouse.events.*;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AuctionHouseHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItem(AuctionItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getSeller().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDropUnclaimed(DropUnclaimedEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onListingCleanup(ListingCleanupEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onListItem(ListItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getSeller().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMenuClick(MenuClickEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMenuClose(MenuCloseEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrePurchaseItem(PrePurchaseItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBuyer().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPurchaseItem(PurchaseItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBuyer().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onServerTick(ServerTickEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
