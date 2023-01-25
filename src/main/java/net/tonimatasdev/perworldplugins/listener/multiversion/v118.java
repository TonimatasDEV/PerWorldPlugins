package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageAbortEvent;
import org.bukkit.event.player.PlayerHideEntityEvent;
import org.bukkit.event.player.PlayerShowEntityEvent;

@SuppressWarnings("deprecation")
public class v118 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(PlayerHideEntityEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(BlockDamageAbortEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerShowEntityEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onHideEntity(PlayerHideEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDamageAbort(BlockDamageAbortEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onShowEntity(PlayerShowEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
