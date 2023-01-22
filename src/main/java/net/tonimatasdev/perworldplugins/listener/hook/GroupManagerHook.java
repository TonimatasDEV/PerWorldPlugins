package net.tonimatasdev.perworldplugins.listener.hook;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.anjocaido.groupmanager.events.GMGroupEvent;
import org.anjocaido.groupmanager.events.GMSystemEvent;
import org.anjocaido.groupmanager.events.GMUserEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class GroupManagerHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGroup(GMGroupEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSystem(GMSystemEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUser(GMUserEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
