package net.tonimatasdev.perworldplugins.injector.listener;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import java.util.Collections;
import java.util.Objects;

public class EnablePluginConfigCreator implements Listener {

    @EventHandler
    public void onEnablePlugin(PluginEnableEvent event) {
        if (!Objects.requireNonNull(PerWorldPlugins.getPlugin().getConfig().getConfigurationSection("plugins")).contains(event.getPlugin().getName())) {
            if (!event.getPlugin().getName().equalsIgnoreCase(PerWorldPlugins.getPlugin().getName())) {
                PerWorldPlugins.getPlugin().getConfig().set("plugins." + event.getPlugin().getName(), Collections.singletonList("Example"));
                PerWorldPlugins.getPlugin().saveConfig();
                PerWorldPlugins.getPlugin().reloadConfig();
            }
        }
    }
}
