package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

public class EnchantEvents implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEnchantItem(EnchantItemEvent event) {
        PerWorldUtils.fireEvent(event, event.getEnchanter().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrepareItemEnchant(PrepareItemEnchantEvent event) {
        PerWorldUtils.fireEvent(event, event.getEnchanter().getWorld());
    }
}
