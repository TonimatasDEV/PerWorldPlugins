package net.tonimatasdev.perworldplugins.listener.hook;

import me.libraryaddict.disguise.events.DisguiseEvent;
import me.libraryaddict.disguise.events.DisguiseInteractEvent;
import me.libraryaddict.disguise.events.UndisguiseEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class LibsDisguisesHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDisguise(DisguiseEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getDisguised().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDisguiseInteract(DisguiseInteractEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUndisguise(UndisguiseEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getDisguised().getWorld());
    }

}
