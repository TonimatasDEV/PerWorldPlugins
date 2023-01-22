package net.tonimatasdev.perworldplugins.listener.hook;

import io.github.znetworkw.znpcservers.npc.event.NPCInteractEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class znpcsHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChangeRegionFlag(NPCInteractEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
