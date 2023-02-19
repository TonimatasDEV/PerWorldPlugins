package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatPreviewEvent;

@SuppressWarnings("deprecation")
public class v1191 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(AsyncPlayerChatPreviewEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAsyncPlayerChatPreview(AsyncPlayerChatPreviewEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
