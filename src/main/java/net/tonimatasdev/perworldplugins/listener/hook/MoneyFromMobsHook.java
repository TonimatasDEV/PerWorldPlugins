package net.tonimatasdev.perworldplugins.listener.hook;

import me.chocolf.moneyfrommobs.api.event.AttemptToDropMoneyEvent;
import me.chocolf.moneyfrommobs.api.event.DropMoneyEvent;
import me.chocolf.moneyfrommobs.api.event.GiveMoneyEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class MoneyFromMobsHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItem(AttemptToDropMoneyEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getKiller().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItem(DropMoneyEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getKiller().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItem(GiveMoneyEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
