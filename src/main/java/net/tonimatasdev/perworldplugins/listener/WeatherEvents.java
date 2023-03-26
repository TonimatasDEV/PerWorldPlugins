package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherEvents implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLightningStrike(LightningStrikeEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onThunderChange(ThunderChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onWeatherChange(WeatherChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getWorld());
    }
}
