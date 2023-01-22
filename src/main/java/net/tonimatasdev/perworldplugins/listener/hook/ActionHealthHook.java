package net.tonimatasdev.perworldplugins.listener.hook;

import com.zeshanaslam.actionhealth.api.HealthSendEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.codemc.worldguardwrapper.event.WrappedDamageEntityEvent;
import org.codemc.worldguardwrapper.event.WrappedDisallowedPVPEvent;
import org.codemc.worldguardwrapper.event.WrappedUseBlockEvent;
import org.codemc.worldguardwrapper.event.WrappedUseEntityEvent;

public class ActionHealthHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onApplyPropertyToItem(HealthSendEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onApplyPropertyToItem(WrappedDamageEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onApplyPropertyToItem(WrappedDisallowedPVPEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getAttacker().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onApplyPropertyToItem(WrappedUseBlockEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onApplyPropertyToItem(WrappedUseEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
