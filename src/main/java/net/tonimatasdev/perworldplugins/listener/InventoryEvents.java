package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;

public class InventoryEvents implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBrew(BrewEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCraftItem(CraftItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWhoClicked().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFurnaceBurn(FurnaceBurnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFurnaceExtract(FurnaceExtractEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFurnaceSmelt(FurnaceSmeltEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onClick(InventoryClickEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWhoClicked().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onClose(InventoryCloseEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCreative(InventoryCreativeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWhoClicked().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDrag(InventoryDragEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWhoClicked().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEvent(InventoryEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getView().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onInteract(InventoryInteractEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWhoClicked().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onOpen(InventoryOpenEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPickupItem(InventoryPickupItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getItem().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrepareItemCraft(PrepareItemCraftEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getView().getPlayer().getWorld());
    }
}
