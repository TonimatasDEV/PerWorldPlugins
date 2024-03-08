package net.tonimatasdev.perworldplugins.command;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import net.tonimatasdev.perworldplugins.manager.ListenerManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("NullableProblems")
public class PrimaryCommand extends Command {
    public PrimaryCommand() {
        super("perworldplugins", "Primary command of PerWorldPlugins", "/perworldplugins", Collections.singletonList("pwp"));
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        // If the command is PerWorldPlugins and has 1 argument, it executes.
        if (commandLabel.equalsIgnoreCase("perworldplugins") && args.length == 1) {
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
                    GroupsYML.reload();
                    ListenerManager.setWorldsToEvents();
                    sender.sendMessage(getPrefix(ChatColor.DARK_GREEN) + "The plugin has been reloaded.");
                }
            }
        } else {
            sender.sendMessage(getPrefix(ChatColor.DARK_RED) + "Please use: /perworldplugins reload | version");
        }
        return true;
    }

    // Method to detect if the player has permissions or not with a message in false case.
    private boolean hasPermission(CommandSender sender, String permission) {
        // Check if the sender has permissions.
        if (sender.hasPermission(permission)) {
            return true;
        } else {
            // Send a message if sender not has permissions.
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
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        // If the command name is "perworldplugins".
        if (alias.equalsIgnoreCase("perworldplugins")) {
            // Create a list for arguments.
            List<String> argList = new ArrayList<>();

            // If argument is 1.
            if (Objects.requireNonNull(args).length == 1) {
                // Add the possible arguments.
                argList.add("version");
                argList.add("reload");
                return argList;
            }
        }

        // Return an empty list if nothing works.
        return Collections.emptyList();
    }

}
