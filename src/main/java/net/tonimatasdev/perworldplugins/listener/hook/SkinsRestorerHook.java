package net.tonimatasdev.perworldplugins.listener.hook;

import net.skinsrestorer.api.bukkit.events.SkinApplyBukkitEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class SkinsRestorerHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSkinApplyBukkit(SkinApplyBukkitEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWho().getWorld());
    }

}
