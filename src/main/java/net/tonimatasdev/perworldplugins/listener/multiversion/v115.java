package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.event.world.TimeSkipEvent;

public class v115 implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEnterBlock(EntityEnterBlockEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLootGenerate(LootGenerateEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTimeSkip(TimeSkipEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }
}
