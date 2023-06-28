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
        boolean IgnoredPlugin;

        IgnoredPlugin = false;
        // If plugin contains the world set isInPlugin to false.
        isInPlugin = !worldList.contains(world.getName());

        // Check if any group contains the world
        for (String var : worldList) {
            if (var.equals("!ignore")) { // Use "!ignore" as the entry for ignoring worlds
                isInPlugin = false; // Enable plugin because it gets ignored
                IgnoredPlugin = true; // Mark plugin as ignored
                break;
            }

            if (var.startsWith("g:")) {
                String groupName = var.substring(2); // Remove the "g:" prefix
                List<String> groupWorlds = GroupsYML.get().getStringList(groupName);
                if (groupWorlds.contains(world.getName())) {
                    isInPlugin = false; // Disable plugin if the world is in any group
                    break; // No need to continue checking other groups
                }
            }
        }

        // If PerWorldPlugins is in blacklist mode, it inverts isInPlugin boolean.
        // check if plugin is ignored
        if (!IgnoredPlugin && PerWorldPlugins.getInstance().getConfig().getBoolean("blacklist")) {
            isInPlugin = !isInPlugin; // Invert isInPlugin if blacklist mode is enabled
        }

        // If the plugin equals PerWorldPlugins set isInPlugin to false.
        if (plugin.getName().equalsIgnoreCase("PerWorldPlugins")) isInPlugin = false;

        return isInPlugin;
    }
}