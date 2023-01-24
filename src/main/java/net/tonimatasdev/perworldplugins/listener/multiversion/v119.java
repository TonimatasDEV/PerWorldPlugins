package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatPreviewEvent;

public class v119 implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAsyncPlayerChatPreview(AsyncPlayerChatPreviewEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
