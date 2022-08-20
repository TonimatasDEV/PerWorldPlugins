package net.tonimatasmc.perworldplugins.manager;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.storage.YML.Fixer;

public class UnregisterManager {
    public static void unregister() {
        PerWorldPlugins.getPlugin().reloadConfig();
        PerWorldPlugins.getPlugin().saveConfig();
        Fixer.reloadFix();
        Fixer.saveFix();
    }
}
