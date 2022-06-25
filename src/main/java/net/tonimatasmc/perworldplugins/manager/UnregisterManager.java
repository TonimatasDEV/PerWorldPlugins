package net.tonimatasmc.perworldplugins.manager;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;

public class UnregisterManager {
    public static void unregister() {
        PerWorldPlugins.getPlugin().reloadConfig();
        PerWorldPlugins.getPlugin().saveConfig();
    }
}
