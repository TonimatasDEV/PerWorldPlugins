package net.tonimatasmc.perworldplugins.storage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TabulatorCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
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
