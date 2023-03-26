package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.TimeSkipEvent;

public class v1151 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(TimeSkipEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTimeSkip(TimeSkipEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }
}
