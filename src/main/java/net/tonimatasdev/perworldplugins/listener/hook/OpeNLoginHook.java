package net.tonimatasdev.perworldplugins.listener.hook;

import com.nickuc.openlogin.bukkit.api.events.AsyncAuthenticateEvent;
import com.nickuc.openlogin.bukkit.api.events.AsyncLoginEvent;
import com.nickuc.openlogin.bukkit.api.events.AsyncRegisterEvent;
import com.nickuc.openlogin.bukkit.api.events.OpenLoginEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class OpeNLoginHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onOpnLogin(OpenLoginEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAsyncAuthenticate(AsyncAuthenticateEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAsyncLogin(AsyncLoginEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAsyncRegister(AsyncRegisterEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
