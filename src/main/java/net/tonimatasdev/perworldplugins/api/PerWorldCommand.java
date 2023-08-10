package net.tonimatasdev.perworldplugins.api;

import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class PerWorldCommand {
    private final Plugin plugin;
    private List<String> disabledWorlds;

    public PerWorldCommand(Plugin plugin) {
        this.plugin = plugin;
        this.disabledWorlds = new ArrayList<>();
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public List<String> getDisabledWorlds() {
        return disabledWorlds;
    }

    public void setDisabledWorlds(List<String> disabledWorlds) {
        this.disabledWorlds = disabledWorlds;
    }
}
