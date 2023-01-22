package net.tonimatasdev.perworldplugins.listener.hook;


import me.phoenix.manhuntplus.api.HuntEndEvent;
import me.phoenix.manhuntplus.api.HuntStartEvent;
import me.phoenix.manhuntplus.api.TeamRandomizeEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ManhuntPlusHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onHuntEnd(HuntEndEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onHuntStart(HuntStartEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTeamRandomize(TeamRandomizeEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
