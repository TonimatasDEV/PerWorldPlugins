package net.tonimatasdev.perworldplugins.listener.hook;

import net.coreprotect.event.CoreProtectPreLogEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class CoreProtectHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPreLog(CoreProtectPreLogEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
