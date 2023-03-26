package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;

public class InventoryEvents implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBrew(BrewEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCraftItem(CraftItemEvent event) {
        PerWorldUtils.fireEvent(event, event.getWhoClicked().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFurnaceBurn(FurnaceBurnEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFurnaceExtract(FurnaceExtractEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFurnaceSmelt(FurnaceSmeltEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onClick(InventoryClickEvent event) {
        PerWorldUtils.fireEvent(event, event.getWhoClicked().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onClose(InventoryCloseEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCreative(InventoryCreativeEvent event) {
        PerWorldUtils.fireEvent(event, event.getWhoClicked().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDrag(InventoryDragEvent event) {
        PerWorldUtils.fireEvent(event, event.getWhoClicked().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEvent(InventoryEvent event) {
        PerWorldUtils.fireEvent(event, event.getView().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onInteract(InventoryInteractEvent event) {
        PerWorldUtils.fireEvent(event, event.getWhoClicked().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onOpen(InventoryOpenEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPickupItem(InventoryPickupItemEvent event) {
        PerWorldUtils.fireEvent(event, event.getItem().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrepareItemCraft(PrepareItemCraftEvent event) {
        PerWorldUtils.fireEvent(event, event.getView().getPlayer().getWorld());
    }
}
