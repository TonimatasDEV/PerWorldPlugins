package net.tonimatasdev.perworldplugins.listener.hook;

import com.nisovin.shopkeepers.api.events.*;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ShopkeepersHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerCreatePlayerShopkeeper(PlayerCreatePlayerShopkeeperEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerCreateShopkeeper(PlayerCreateShopkeeperEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerDeleteShopkeeper(PlayerDeleteShopkeeperEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerInactive(PlayerInactiveEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerOpenUI(PlayerOpenUIEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerShopkeeperHire(PlayerShopkeeperHireEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onShopkeeperAdded(ShopkeeperAddedEvent event) {
        ListenerUtils.perWorldPlugins(event, Bukkit.getWorld(event.getShopkeeper().getWorldName()));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onShopkeeperEdited(ShopkeeperEditedEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onShopkeeperOpenUI(ShopkeeperOpenUIEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onShopkeeperRemove(ShopkeeperRemoveEvent event) {
        ListenerUtils.perWorldPlugins(event, Bukkit.getWorld(event.getShopkeeper().getWorldName()));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onShopkeeperTrade(ShopkeeperTradeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
