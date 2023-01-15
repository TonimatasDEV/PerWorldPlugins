package net.tonimatasdev.perworldplugins.storage.YML;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;

import java.io.File;

public class Config {
    public static void registerConfig() {
        File config = new File(PerWorldPlugins.getInstance().getDataFolder(), "config.yml");

        if (!config.exists()) {
            PerWorldPlugins.getInstance().getConfig().options().copyDefaults(true);
            PerWorldPlugins.getInstance().saveConfig();
        }
    }
}
