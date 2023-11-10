package net.tonimatasdev.perworldplugins.api;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public abstract class PerWorldCommand extends Command {
    protected Plugin plugin;
    protected List<String> disabledWorlds;

    public PerWorldCommand(Command command, Plugin plugin) {
        // Add all command information.
        super(command.getName());
        setAliases(command.getAliases());
        setDescription(command.getDescription());
        setLabel(command.getLabel());
        setName(command.getName());
        setPermission(command.getPermission());
        setPermissionMessage(command.getPermissionMessage());
        setUsage(command.getUsage());

        // Add plugin and disabled worlds.
        this.plugin = plugin;
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
        };
    }
}
