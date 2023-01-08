package net.tonimatasdev.perworldplugins.manager;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;

public class UnregisterManager {
    public static void unregister() {
        PerWorldPlugins.getPlugin().reloadConfig();
        PerWorldPlugins.getPlugin().saveConfig();
    }
}
