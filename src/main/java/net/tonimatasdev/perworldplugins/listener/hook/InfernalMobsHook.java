package net.tonimatasdev.perworldplugins.listener.hook;

import io.hotmail.com.jacob_vejvoda.infernal_mobs.InfernalSpawnEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class InfernalMobsHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onReload(InfernalSpawnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }
}
