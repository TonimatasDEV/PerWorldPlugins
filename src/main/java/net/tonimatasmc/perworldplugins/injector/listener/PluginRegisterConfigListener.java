package net.tonimatasmc.perworldplugins.injector.listener;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import java.util.Collections;

public class PluginRegisterConfigListener implements Listener {
    @EventHandler
    public static void onPluginEnable(PluginEnableEvent event) {
        if (!event.getPlugin().getName().equalsIgnoreCase(PerWorldPlugins.getPlugin().getName()) && !event.getPlugin().getName().equalsIgnoreCase("LuckPerms")) {
            if (PerWorldPlugins.getPlugin().getConfig().getConfigurationSection("plugins." + event.getPlugin().getName()) == null) {
                PerWorldPlugins.getPlugin().getConfig().set("plugins." + event.getPlugin().getName(), Collections.singletonList("Example"));
                PerWorldPlugins.getPlugin().reloadConfig();
                PerWorldPlugins.getPlugin().saveConfig();
            }
        }
    }
}