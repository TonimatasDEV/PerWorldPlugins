package dev.tonimatas.perworldplugins.command;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import dev.tonimatas.perworldplugins.config.GroupsYML;
import dev.tonimatas.perworldplugins.manager.ListenerManager;
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
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("version")) {

                if (hasPermission(sender, "perworldplugins.version")) {
                    sender.sendMessage(getPrefix(ChatColor.DARK_GREEN) + "The plugin version is: " + PerWorldPlugins.getInstance().getDescription().getVersion());
                }
            }

            if (args[0].equalsIgnoreCase("reload")) {

                if (hasPermission(sender, "perworldplugins.reload")) {
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
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        if (alias.equalsIgnoreCase("perworldplugins")) {
            List<String> argList = new ArrayList<>();

            if (Objects.requireNonNull(args).length == 1) {
                argList.add("version");
                argList.add("reload");
                return argList;
            }
        }

        return Collections.emptyList();
    }

}
