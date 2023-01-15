package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherEvents implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onLightningStrike(LightningStrikeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onThunderChange(ThunderChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onWeatherChange(WeatherChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }
}
