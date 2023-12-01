package net.tonimatasdev.perworldplugins.api;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public abstract class PerWorldCommand extends Command implements PluginIdentifiableCommand {
    protected Plugin plugin;
    protected List<String> disabledWorlds;

    public PerWorldCommand(Command command, Plugin plugin) {
        // Add all command information.
        super(command.getName(), command.getDescription(), command.getUsage(), command.getAliases());

        // Add plugin and disabled worlds.
        this.plugin = command instanceof PluginCommand ? ((PluginCommand) command).getPlugin() : plugin;
        this.disabledWorlds = new ArrayList<>();
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public List<String> getDisabledWorlds() {
        return disabledWorlds;
    }

    public void setDisabledWorlds() {
        this.disabledWorlds = PerWorldUtils.getDisabledWorlds(plugin);
    }

    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("NullableProblems")
    public static PerWorldCommand get(Command command, Plugin plugin) {
        // Create PerWorldCommand.
        return new PerWorldCommand(command, plugin) {
            // Use the normal command execute.
            @Override
            public boolean execute(CommandSender sender, String commandLabel, String[] args) {
                return command.execute(sender, commandLabel, args);
            }

            @Override
            public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
                return command.tabComplete(sender, alias, args);
            }

            @Override
            public List<String> tabComplete(CommandSender sender, String alias, String[] args, Location location) throws IllegalArgumentException {
                return command.tabComplete(sender, alias, args, location);
            }

            @Override
            public boolean testPermission(CommandSender target) {
                return command.testPermission(target);
            }

            @Override
            public boolean testPermissionSilent(CommandSender target) {
                return command.testPermissionSilent(target);
            }
        };
    }
}
