package net.tonimatasdev.perworldplugins.listener.hook;

import at.pcgamingfreaks.Minepacks.Bukkit.API.Events.BackpackDropOnDeathEvent;
import at.pcgamingfreaks.Minepacks.Bukkit.API.Events.InventoryClearEvent;
import at.pcgamingfreaks.Minepacks.Bukkit.API.Events.InventoryClearedEvent;
import io.hotmail.com.jacob_vejvoda.infernal_mobs.InfernalSpawnEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class MinepacksHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBackpackDropOnDeath(BackpackDropOnDeathEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getOwner().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onInventoryCleared(InventoryClearedEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onInventoryClear(InventoryClearEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
