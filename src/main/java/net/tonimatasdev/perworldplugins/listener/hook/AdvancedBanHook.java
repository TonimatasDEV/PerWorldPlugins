package net.tonimatasdev.perworldplugins.listener.hook;

import me.leoko.advancedban.bukkit.event.PunishmentEvent;
import me.leoko.advancedban.bukkit.event.RevokePunishmentEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AdvancedBanHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPunishment(PunishmentEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onRevokePunishment(RevokePunishmentEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
