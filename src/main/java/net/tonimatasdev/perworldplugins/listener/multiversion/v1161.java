package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityEnterLoveModeEvent;
import org.bukkit.event.entity.StriderTemperatureChangeEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;

public class v1161 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(StriderTemperatureChangeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EntityEnterLoveModeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PrepareSmithingEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerHarvestBlockEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onStriderTemperatureChange(StriderTemperatureChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEnterLoveMode(EntityEnterLoveModeEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrepareSmithing(PrepareSmithingEvent event) {
        PerWorldUtils.fireEvent(event, event.getView().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onHarvestBlock(PlayerHarvestBlockEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }
}
