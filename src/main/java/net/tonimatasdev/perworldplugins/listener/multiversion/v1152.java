package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import org.bukkit.event.world.LootGenerateEvent;

public class v1152 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(EntityEnterBlockEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(LootGenerateEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEnterBlock(EntityEnterBlockEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLootGenerate(LootGenerateEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }
}
