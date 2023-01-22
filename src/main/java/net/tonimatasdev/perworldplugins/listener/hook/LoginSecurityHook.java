package net.tonimatasdev.perworldplugins.listener.hook;

import com.lenis0012.bukkit.loginsecurity.events.AuthActionEvent;
import com.lenis0012.bukkit.loginsecurity.events.AuthModeChangedEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class LoginSecurityHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAuthAction(AuthActionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAuthModeChanged(AuthModeChangedEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getSession().getPlayer().getWorld());
    }
}
