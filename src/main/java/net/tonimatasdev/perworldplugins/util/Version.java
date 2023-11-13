package net.tonimatasdev.perworldplugins.util;

import org.bukkit.Bukkit;

public class Version {
    private static final String[] versionString = Bukkit.getBukkitVersion().split("-")[0].split("\\.");

    public static int getVersion() {
        // Create new StringBuilder.
        StringBuilder version = new StringBuilder();

        // Append all versions.
        for (String number : versionString) {
            version.append(number);
        }

        if (versionString.length == 2) version.append(0);

        // Return version int (Example: 188 - 1.8.8)
        return Integer.parseInt(version.toString());
    }
}
