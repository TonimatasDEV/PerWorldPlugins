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

public class Command implements CommandExecutor, TabCompleter {

    @Override
    @SuppressWarnings("NullableProblems")
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("perworldplugins") && args.length == 1) {
            if (args[0].equalsIgnoreCase("version")) {
                if (hasPermission(sender, "perworldplugins.version")) {
                    sender.sendMessage(getPrefix(ChatColor.DARK_GREEN) + "The plugin version is: " + PerWorldPlugins.getInstance().getDescription().getVersion());
                }
            }

            if (args[0].equalsIgnoreCase("reload")) {
                if (hasPermission(sender, "perworldplugins.reload")) {
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

    private boolean hasPermission(CommandSender sender, String permission) {
        if (sender.hasPermission(permission)) {
            return true;
        } else {
            sender.sendMessage(getPrefix(ChatColor.DARK_RED) + "You don't have permissions for execute this command");
            return false;
        }
    }

    private String getPrefix(ChatColor chatColor) {
        return ChatColor.WHITE + "[" + chatColor + "+" + ChatColor.WHITE + "] PerWorldPlugins: " + ChatColor.WHITE;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command cmd, String alias, String[] args) {
        assert cmd != null;

        if (cmd.getName().equalsIgnoreCase("perworldplugins")) {
            List<String> argList = new ArrayList<>();

            if (Objects.requireNonNull(args).length == 1) {
                argList.add("version");
                argList.add("reload");
                return argList.stream().filter(a -> a.startsWith(args[0])).collect(Collectors.toList());
            }
        }

        return null;
    }
}
