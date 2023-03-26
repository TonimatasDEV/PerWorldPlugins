package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerLocaleChangeEvent;

public class v1120 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(EntityPickupItemEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerAdvancementDoneEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerLocaleChangeEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPickupItem(EntityPickupItemEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAdvancementDone(PlayerAdvancementDoneEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLocaleChange(PlayerLocaleChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }
}
