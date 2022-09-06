package net.tonimatasdev.perworldplugins;

import net.tonimatasdev.perworldplugins.manager.RegisterManager;
import net.tonimatasdev.perworldplugins.manager.UnregisterManager;
import net.tonimatasdev.perworldplugins.injector.ListenerInjector;
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

