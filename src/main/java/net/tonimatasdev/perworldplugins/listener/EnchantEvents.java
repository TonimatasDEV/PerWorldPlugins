package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

public class EnchantEvents implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEnchantItem(EnchantItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEnchanter().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrepareItemEnchant(PrepareItemEnchantEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEnchanter().getWorld());
    }
}
