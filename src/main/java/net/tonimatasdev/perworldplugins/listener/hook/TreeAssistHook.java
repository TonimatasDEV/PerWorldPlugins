package net.tonimatasdev.perworldplugins.listener.hook;

import net.slipcor.treeassist.events.*;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class TreeAssistHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLeafDecay(TALeafDecay event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSaplingBreak(TASaplingBreakEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSaplingPlace(TASaplingPlaceEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTreeBlockBroker(TATreeBlockBrokenEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTreeBroken(TATreeBrokenEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }


}
