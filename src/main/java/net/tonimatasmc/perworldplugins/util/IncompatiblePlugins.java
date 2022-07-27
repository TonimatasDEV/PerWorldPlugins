package net.tonimatasmc.perworldplugins.util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


//Some plugins don't add their commands to plugin.yml and this class detects that the plugin has a command in text.
public class IncompatiblePlugins {
    public static Plugin getIncompatiblePluginWithCommand(String command) {
        if (Objects.requireNonNull(getList(0)).contains(command)) {
            if (Bukkit.getPluginManager().getPlugin("BetterTeams").isEnabled()) {
                return Bukkit.getPluginManager().getPlugin("BetterTeams");
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private static List<String> getList(int index) {
        switch (index) {
            case 0:
                return Arrays.asList("team", "teama");
            //case 1:
            //    return Arrays.asList("tr", "trsetup");
            default:
                return null;

        }
    }
}
