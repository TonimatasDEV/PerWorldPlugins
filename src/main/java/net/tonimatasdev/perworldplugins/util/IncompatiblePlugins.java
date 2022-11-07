package net.tonimatasdev.perworldplugins.util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.Collections;
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
        } else if (Objects.requireNonNull(getList(1)).contains(command)) {
            if (Bukkit.getPluginManager().getPlugin("ExcellentCrates").isEnabled()) {
                return Bukkit.getPluginManager().getPlugin("ExcellentCrates");
            } else {
                return null;
            }
        } else if (Objects.requireNonNull(getList(2)).contains(command)) {
            if (Bukkit.getPluginManager().getPlugin("NextEngine").isEnabled()) {
                return Bukkit.getPluginManager().getPlugin("NextEngine");
            } else {
                return null;
            }
        } else if (Objects.requireNonNull(getList(3)).contains(command)) {
            if (Bukkit.getPluginManager().getPlugin("MoneyHunters").isEnabled()) {
                return Bukkit.getPluginManager().getPlugin("MoneyHunters");
            } else {
                return null;
            }
        } else if (Objects.requireNonNull(getList(4)).contains(command)) {
            if (Bukkit.getPluginManager().getPlugin("Origins-Bukkit").isEnabled()) {
                return Bukkit.getPluginManager().getPlugin("Origins-Bukkit");
            } else {
                return null;
            }
        } else if (Objects.requireNonNull(getList(5)).contains(command)) {
            if (Bukkit.getPluginManager().getPlugin("EconomyShopGUI").isEnabled()) {
                return Bukkit.getPluginManager().getPlugin("EconomyShopGUI");
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private static List<String> getList(int index) {
        return switch (index) {
            case 0 -> Arrays.asList("team", "teama");
            case 1 -> Arrays.asList("excellentcrates", "ecrates");
            case 2 -> Collections.singletonList("nexengine");
            case 3 -> Arrays.asList("moneyhunters", "mh");
            case 4 -> Arrays.asList("origin", "power");
            case 5 -> Collections.singletonList("shop");
            default -> null;
        };
    }
}
