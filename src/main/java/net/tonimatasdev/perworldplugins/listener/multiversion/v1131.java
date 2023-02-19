package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import org.bukkit.event.block.MoistureChangeEvent;
import org.bukkit.event.entity.BatToggleSleepEvent;
import org.bukkit.event.player.PlayerRecipeDiscoverEvent;

public class v1131 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(MoistureChangeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(BatToggleSleepEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerRecipeDiscoverEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDispenseArmor(BlockDispenseArmorEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMoistureChange(MoistureChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBatToggleSleep(BatToggleSleepEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onRecipeDiscover(PlayerRecipeDiscoverEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
