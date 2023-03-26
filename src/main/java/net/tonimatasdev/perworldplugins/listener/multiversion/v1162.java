package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ArrowBodyCountChangeEvent;
import org.bukkit.event.entity.EntitySpellCastEvent;

public class v1162 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(EntitySpellCastEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onArrowBodyCountChange(ArrowBodyCountChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSpellCast(EntitySpellCastEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }
}
