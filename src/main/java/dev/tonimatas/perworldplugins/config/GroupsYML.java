package dev.tonimatas.perworldplugins.config;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class GroupsYML {
    private static FileConfiguration list = null;
    private static File listFile = null;

    public static FileConfiguration get() {
        if (list == null) reload();
        return list;
    }

    public static void reload() {
        if (list == null) listFile = new File(PerWorldPlugins.getInstance().getDataFolder(), "groups.yml");

        list = YamlConfiguration.loadConfiguration(listFile);
        Reader defConfigStream = new InputStreamReader(Objects.requireNonNull(PerWorldPlugins.getInstance().getResource("groups.yml")), StandardCharsets.UTF_8);
        list.setDefaults(YamlConfiguration.loadConfiguration(defConfigStream));
    }

    public static void save() {
        try {
            list.save(listFile);
        } catch (IOException ignore) {
        }
    }

    public static void register() {
        listFile = new File(PerWorldPlugins.getInstance().getDataFolder(), "groups.yml");

        if (!listFile.exists()) {
            get().options().copyDefaults(true);
            save();
        }
    }
}
