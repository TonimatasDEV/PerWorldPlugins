package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class PerWorldUtils {
    public static boolean check(World world, Plugin plugin) {
        List<String> worldList = PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + plugin.getName());
        boolean isInPlugin = false;

        for (String var : worldList) {
            if (var.contains(":")) {
                isInPlugin = GroupsYML.get().getStringList(var.replaceAll("g:", "")).contains(world.getName());
            }
        }

        if (!isInPlugin) {
            isInPlugin = worldList.contains(world.getName());
        }

        if (PerWorldPlugins.getInstance().getConfig().getBoolean("blacklist")) {
            isInPlugin = !isInPlugin;
        }

        if (plugin.getName().equalsIgnoreCase("PerWorldPlugins")) {
            isInPlugin = true;
        }

        return !isInPlugin;
    }
}
