package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

public class v1100 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(EntityBreedEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBreed(EntityBreedEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }
}
