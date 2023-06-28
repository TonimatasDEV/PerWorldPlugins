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
        boolean isIgnored = false;

        // Check if any group contains the world
        getWorldsOfGroup(worldList);

        // If plugin contains the world set isInPlugin to false.
        isInPlugin = !worldList.contains(world.getName());

        // Detects if the plugin is ignored.
        if (worldList.contains(":ignore")) isIgnored = true;

        // If PerWorldPlugins is in blacklist mode, it inverts isInPlugin boolean.
        if ( PerWorldPlugins.getInstance().getConfig().getBoolean("blacklist")) {
            isInPlugin = !isInPlugin; // Invert isInPlugin if blacklist mode is enabled
        }

        // If the plugin equals PerWorldPlugins or is ignored, sets isInPlugin to false.
        if (plugin.getName().equalsIgnoreCase("PerWorldPlugins") || isIgnored) isInPlugin = false;

        return isInPlugin;
    }

    // Remove the group from the list and put it worlds to the list.
    private static List<String> getWorldsOfGroup(List<String> worldList) {
        for (String var : worldList) {
            // Detects if the string starts with "g:".
            if (var.startsWith("g:")) {
                String group = var.substring(2); // Remove the "g:" prefix.
                worldList.remove(var); // Remove the group from the list.

                // Add worlds.
                worldList.addAll(getWorldsOfGroup(GroupsYML.get().getStringList(group)));
            }
        }

        return worldList;
    }
}
