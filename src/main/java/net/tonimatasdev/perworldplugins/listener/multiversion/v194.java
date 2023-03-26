package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.server.TabCompleteEvent;

public class v194 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(PlayerChangedMainHandEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(TabCompleteEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChangedMainHand(PlayerChangedMainHandEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTabComplete(TabCompleteEvent event) {
        CommandSender sender = event.getSender();

        if (sender instanceof Player) {
            PerWorldUtils.fireEvent(event, ((Player) sender).getWorld());
        }
    }
}
