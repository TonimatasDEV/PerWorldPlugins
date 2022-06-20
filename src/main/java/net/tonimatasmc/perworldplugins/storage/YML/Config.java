package net.tonimatasmc.perworldplugins.storage.YML;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;

import java.io.File;

public class Config {
    public static void registerConfig() {
        File config = new File(PerWorldPlugins.getPlugin().getDataFolder(), "config.yml");

        if (!config.exists()) {
            PerWorldPlugins.getPlugin().getConfig().options().copyDefaults(true);
            PerWorldPlugins.getPlugin().saveConfig();
        }
    }
}
