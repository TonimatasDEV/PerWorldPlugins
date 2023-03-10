package net.tonimatasdev.perworldplugins.command;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command implements CommandExecutor {

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("perworldplugins") && args.length == 1) {
            if (args[0].equalsIgnoreCase("version")) {
                if (sender.hasPermission("perworldplugins.version")) {
                    sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "+" + ChatColor.WHITE + "] PerWorldPlugins: " + ChatColor.WHITE + "The plugin version is: " + PerWorldPlugins.getInstance().getDescription().getVersion());
                } else {
                    sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "-" + ChatColor.WHITE + "] PerWorldPlugins: " + ChatColor.WHITE + "You don't have permissions for execute this command");
                }
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("perworldplugins.reload")) {
                    PerWorldPlugins.getInstance().reloadConfig();
                    PerWorldPlugins.getInstance().saveConfig();
                    GroupsYML.reload();
                    GroupsYML.save();
                    sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "+" + ChatColor.WHITE + "] PerWorldPlugins: " + ChatColor.WHITE + "The plugin has been reloaded.");
                } else {
                    sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "-" + ChatColor.WHITE + "] PerWorldPlugins: " + ChatColor.WHITE + "You don't have permissions for execute this command");
                }
            } else {
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "-" + ChatColor.WHITE + "] PerWorldPlugins: " + ChatColor.WHITE + "Please use: /perworldplugins reload | version");
            }
        }
        return true;
    }
}
