package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceStartSmeltEvent;
import org.bukkit.event.world.EntitiesLoadEvent;
import org.bukkit.event.world.EntitiesUnloadEvent;

public class v1171 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(FurnaceStartSmeltEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EntitiesLoadEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EntitiesUnloadEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFurnaceStartSmelt(FurnaceStartSmeltEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
}

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEntitiesLoad(EntitiesLoadEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEntitiesUnload(EntitiesUnloadEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }
}
