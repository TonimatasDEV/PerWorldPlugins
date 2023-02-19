package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import org.bukkit.event.entity.ArrowBodyCountChangeEvent;

public class v1163 {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(ArrowBodyCountChangeEvent.getHandlerList());
    }
}
