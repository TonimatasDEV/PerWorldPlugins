package net.tonimatasdev.perworldplugins.listener.hook;

import me.arvin.lib.event.PlayerFeedAnimalEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ArvinLibHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onWarp(PlayerFeedAnimalEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
