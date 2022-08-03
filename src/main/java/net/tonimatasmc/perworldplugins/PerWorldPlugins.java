package net.tonimatasmc.perworldplugins;

import net.tonimatasmc.perworldplugins.injector.ListenerInjector;
import net.tonimatasmc.perworldplugins.manager.RegisterManager;
import net.tonimatasmc.perworldplugins.manager.UnregisterManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PerWorldPlugins extends JavaPlugin {
    private static PerWorldPlugins plugin;
    private static ListenerInjector injector;

    public static PerWorldPlugins getPlugin() {
        return plugin;
    }

    public static ListenerInjector getInjector() {
        return injector;
    }

    public void onEnable() {
        plugin = this;
        injector = new ListenerInjector();
        RegisterManager.register();
    }

    public void onDisable() {
        UnregisterManager.unregister();

        if (injector != null) {
            injector.unload();
        }
    }
}

