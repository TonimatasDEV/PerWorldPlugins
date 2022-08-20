package net.tonimatasmc.perworldplugins.manager;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.storage.YML.Fix;

public class UnregisterManager {
    public static void unregister() {
        PerWorldPlugins.getPlugin().reloadConfig();
        PerWorldPlugins.getPlugin().saveConfig();
        Fix.reloadFix();
        Fix.saveFix();
    }
}
