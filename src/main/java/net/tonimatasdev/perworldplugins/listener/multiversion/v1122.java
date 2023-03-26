package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemMendEvent;

public class v1122 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(PlayerItemMendEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItemMend(PlayerItemMendEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }
}
