package net.tonimatasdev.perworldplugins.manager;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.storage.YML.Fixer;

public class UnregisterManager {
    public static void unregister() {
        PerWorldPlugins.getPlugin().reloadConfig();
        PerWorldPlugins.getPlugin().saveConfig();
        Fixer.reloadFix();
        Fixer.saveFix();
    }
}
