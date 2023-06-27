package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class PerWorldUtils {
    public static boolean check(World world, Plugin plugin) {
        // Get the world list of the plugin.
        List<String> worldList = PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + plugin.getName());
        boolean isInPlugin;

        // If plugin contains the world set isInPlugin to false.
        isInPlugin = !worldList.contains(world.getName());

        // Get if this world list contains a group and if it does, forward if it contains the world.
        for (String var : worldList) {
            if (var.contains(":")) {
                isInPlugin = !GroupsYML.get().getStringList(var.replaceAll("g:", "")).contains(world.getName());
            }
        }

        // If PerWorldPlugins is in blacklist mode, it inverts isInPlugin boolean.
        if (PerWorldPlugins.getInstance().getConfig().getBoolean("blacklist")) isInPlugin = !isInPlugin;

        // If the plugin equals PerWorldPlugins set isInPlugin to false.
        if (plugin.getName().equalsIgnoreCase("PerWorldPlugins")) isInPlugin = false;

        return isInPlugin;
    }
}
