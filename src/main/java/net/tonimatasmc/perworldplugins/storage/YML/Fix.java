package net.tonimatasmc.perworldplugins.storage.YML;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Fix {
    private static FileConfiguration fix = null;
    private static File fixFile = null;

    public static FileConfiguration getFix() {
        if (fix == null) {
            registerFix();
        }

        return fix;
    }

    public static void reloadFix() {
        if (fix == null) {
            fixFile = new File(PerWorldPlugins.getPlugin().getDataFolder(), "fix.yml");
        }

        fix = YamlConfiguration.loadConfiguration(fixFile);
        Reader defConfigStream = new InputStreamReader(Objects.requireNonNull(PerWorldPlugins.getPlugin().getResource("fix.yml")), StandardCharsets.UTF_8);

        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        fix.setDefaults(defConfig);
    }

    public static void saveFix() {
        try {
            fix.save(fixFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public static void registerFix() {
        fixFile = new File(PerWorldPlugins.getPlugin().getDataFolder(), "fix.yml");

        if (!fixFile.exists()) {
            getFix().options().copyDefaults(true);
            saveFix();
        }
    }
}
