package net.tonimatasdev.perworldplugins.listener.hook;

import fr.mrmicky.worldeditselectionvisualizer.event.ClipboardChangeEvent;
import fr.mrmicky.worldeditselectionvisualizer.event.SelectionChangeEvent;
import fr.mrmicky.worldeditselectionvisualizer.event.VisualizationToggleEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class WorldEditSelectionVisualizerHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onClipboardChange(ClipboardChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSelectionChange(SelectionChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVisualizationToggle(VisualizationToggleEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
