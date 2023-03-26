package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockReceiveGameEvent;
import org.bukkit.event.world.GenericGameEvent;

public class v1170 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(BlockReceiveGameEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(GenericGameEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onReceiveGame(BlockReceiveGameEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGenericGame(GenericGameEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }
}
