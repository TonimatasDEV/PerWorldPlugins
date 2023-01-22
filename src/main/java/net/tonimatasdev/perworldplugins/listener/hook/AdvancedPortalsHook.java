package net.tonimatasdev.perworldplugins.listener.hook;

import com.sekwah.advancedportals.bukkit.api.events.WarpEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AdvancedPortalsHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onWarp(WarpEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
