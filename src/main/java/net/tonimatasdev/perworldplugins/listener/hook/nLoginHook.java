package net.tonimatasdev.perworldplugins.listener.hook;

import com.nickuc.login.api.event.internal.bukkit.BukkitEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class nLoginHook implements Listener {
    @EventHandler
    public static void onBreakBlock(BukkitEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
