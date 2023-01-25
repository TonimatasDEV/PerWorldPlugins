package net.tonimatasdev.perworldplugins.event;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import java.util.Collections;

public class PluginEnableListener implements Listener {
    @EventHandler
    public static void onPluginEnable(PluginEnableEvent event) {
        if (!event.getPlugin().getName().equals("PerWorldPlugins")) {
            if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + event.getPlugin().getName()).isEmpty()) {
                PerWorldPlugins.getInstance().getConfig().set("plugins." + event.getPlugin().getName(), Collections.singletonList("Example"));
                PerWorldPlugins.getInstance().saveConfig();
                PerWorldPlugins.getInstance().reloadConfig();
            }
        }
    }
}
