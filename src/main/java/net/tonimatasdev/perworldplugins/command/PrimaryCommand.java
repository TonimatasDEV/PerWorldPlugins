package net.tonimatasdev.perworldplugins.command;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PrimaryCommand implements CommandExecutor, TabCompleter {

    @Override
    @SuppressWarnings("NullableProblems")
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        // If the command is PerWorldPlugins and has 1 argument, it executes.
        if (command.getName().equalsIgnoreCase("perworldplugins") && args.length == 1) {
            if (args[0].equalsIgnoreCase("version")) { // Detects if the argument is equal to "version".

                // Detects if the sender has the permission "perworldplugins.version".
                if (hasPermission(sender, "perworldplugins.version")) {
                    sender.sendMessage(getPrefix(ChatColor.DARK_GREEN) + "The plugin version is: " + PerWorldPlugins.getInstance().getDescription().getVersion());
                }
            }

            // Detects if the argument is equal to "reload".
            if (args[0].equalsIgnoreCase("reload")) {

                // Detects if the sender has the permission "perworldplugins.reload".
                if (hasPermission(sender, "perworldplugins.reload")) {
                    // Reload all config files.
                    PerWorldPlugins.getInstance().reloadConfig();
                    PerWorldPlugins.getInstance().saveConfig();
                    GroupsYML.reload();
                    GroupsYML.save();
                    sender.sendMessage(getPrefix(ChatColor.DARK_GREEN) + "The plugin has been reloaded.");
                }
            } else {
                sender.sendMessage(getPrefix(ChatColor.DARK_RED) + "Please use: /perworldplugins reload | version");
            }
        }
        return true;
    }

    // Method to detect if the player has permissions or not with a message in false case.
    private boolean hasPermission(CommandSender sender, String permission) {
        if (sender.hasPermission(permission)) {
            return true;
        } else {
            sender.sendMessage(getPrefix(ChatColor.DARK_RED) + "You don't have permissions for execute this command");
            return false;
        }
    }

    // Method to get the prefix with the colors.
    private String getPrefix(ChatColor chatColor) {
        return ChatColor.WHITE + "[" + chatColor + "+" + ChatColor.WHITE + "] PerWorldPlugins: " + ChatColor.WHITE;
    }

    // Command tab completer.
    @Override
    @SuppressWarnings("NullableProblems")
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command cmd, String alias, String[] args) {
        // If the command is null.
        if (cmd == null) return null;

        // If the command name is "perworldplugins"
        if (cmd.getName().equalsIgnoreCase("perworldplugins")) {
            // Create a list for arguments
            List<String> argList = new ArrayList<>();

            // If argument is 1.
            if (Objects.requireNonNull(args).length == 1) {
                // Add the possible arguments.
                argList.add("version");
                argList.add("reload");
                return argList.stream().filter(a -> a.startsWith(args[0])).collect(Collectors.toList());
            }
        }

        return null;
    }
}
