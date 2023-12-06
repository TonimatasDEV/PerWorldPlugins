package net.tonimatasdev.perworldplugins.util;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerWorldUtils {
    public static List<String> getDisabledWorlds(Plugin plugin) {
        List<String> worldList = PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + plugin.getName());

        if (worldList.contains(":ignore") || worldList.isEmpty()) return new ArrayList<>();

        List<String> withGroupWorlds = new ArrayList<>(worldList);
        // Check if any group contains the world
        for (String var : worldList) {
            // Detects if the string starts with "g:".
            if (var.startsWith("g:")) {
                String group = var.substring(2); // Remove the "g:" prefix.
                withGroupWorlds.remove(var); // Remove the group from the list.


                // Add all worlds to groupWorlds
                withGroupWorlds.addAll(GroupsYML.get().getStringList(group));
            }
        }

        if (PerWorldPlugins.getInstance().getConfig().getBoolean("blacklist")) {
            return withGroupWorlds;
        } else {
            List<String> serverWorlds = new ArrayList<>();
            try {
                serverWorlds.addAll(Bukkit.getWorlds().stream().map(World::getName).collect(Collectors.toList()));
            } catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error on get blocked worlds of: " + plugin.getName());
            }
            serverWorlds.removeAll(withGroupWorlds);
            return serverWorlds;
        }
    }
}
