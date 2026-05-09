package dev.tonimatas.perworldplugins.command;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import dev.tonimatas.perworldplugins.config.GroupsYML;
import dev.tonimatas.perworldplugins.manager.ListenerManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
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

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("version")) {

                if (hasPermission(sender, "perworldplugins.version")) {
                    sender.sendMessage(generateMessage(true, "The plugin version is: " + PerWorldPlugins.getInstance().getPluginMeta().getVersion()));
                }
            }

            if (args[0].equalsIgnoreCase("reload")) {
                if (hasPermission(sender, "perworldplugins.reload")) {
                    PerWorldPlugins.getInstance().reloadConfig();
                    GroupsYML.reload();
                    ListenerManager.setWorldsToEvents();
                    sender.sendMessage(generateMessage(true, "The plugin has been reloaded."));
                }
            }
        } else {
            sender.sendMessage(generateMessage(false, "Please use: /perworldplugins reload | version"));
        }

        return true;
    }

    private boolean hasPermission(CommandSender sender, String permission) {
        if (sender.hasPermission(permission)) {
            return true;
        } else {
            sender.sendMessage(generateMessage(false, "You don't have permissions for execute this command"));
            return false;
        }
    }

    private Component generateMessage(boolean fine, String message) {
        return Component.text("[", NamedTextColor.DARK_GRAY)
                .append(Component.text("+", fine ? NamedTextColor.DARK_GREEN : NamedTextColor.DARK_RED))
                .append(Component.text("]", NamedTextColor.DARK_GRAY))
                .append(Component.text("PerWorldPlugins: ", NamedTextColor.GRAY))
                .append(Component.text(message, NamedTextColor.WHITE));
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
