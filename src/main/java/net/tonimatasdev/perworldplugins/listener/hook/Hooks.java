package net.tonimatasdev.perworldplugins.listener.hook;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;

public class Hooks {
    public static void register() {
        check("WorldGuard");
        check("nLogin");
        check("Skywars");
        check("MythicMobs");
        check("ItemJoin");
        check("ActionHealth");
        check("SuperVanish");
        check("EconomyShopGUI");
        check("OpeNLogin");
        check("TreeAssist");
        check("GroupManager");
        check("Jobs");
        check("CratesPlus");
        check("VeinMiner");
        check("PlaceholderAPI");
        check("LibsDisguises");
        check("ExcellentCrates");
        check("RedProtect");
        check("AdvancedBan");
        check("CoreProtect");
        check("DecentHolograms");
        check("AuctionHouse");
        check("ServersNPC");
        check("Shopkeepers");
        check("LoginSecurity");
        check("MoneyHunters");
        check("GadgetsMenu");
        check("WorldEditSelectionVisualizer");
        check("Essentials");
        check("AureliumSkills");
        check("IridiumSkyblock");
        check("SkinsRestorer");
        check("Multiverse-Core");
        check("GSit");
        check("VotingPlugin");
        check("CommandPanels");
        check("MoneyFromMobs");
        check("AdvancedPortals");
        check("ArvinLib");
        check("ConditionalEvents");
        check("Prison");
        //check("BedWars");
    }

    @SuppressWarnings("DataFlowIssue")
    private static void check(String pluginName) {
        if (Bukkit.getPluginManager().isPluginEnabled(pluginName)) {
            Bukkit.getPluginManager().registerEvents(getHook(pluginName), PerWorldPlugins.getInstance());
            Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + pluginName + " hook is enabled.");
        }
    }

    private static Listener getHook(String pluginName) {
        switch (pluginName) {
            case "WorldGuard": return new WorldGuardHook();
            case "nLogin": return new nLoginHook();
            case "Skywars": return new SkyWarsHook();
            case "MythicMobs": return new MythicMobsHook();
            case "ItemJoin": return new ItemJoinHook();
            case "ActionHealth": return new ActionHealthHook();
            case "SuperVanish": return new SuperVanishHook();
            case "EconomyShopGUI": return new EconomyShopGUIHook();
            case "OpeNLogin": return new OpeNLoginHook();
            case "TreeAssist": return new TreeAssistHook();
            case "GroupManager": return new GroupManagerHook();
            case "Jobs": return new JobsHook();
            case "CratesPlus": return new CratesPlusHook();
            case "VeinMiner": return new VeinMinerHook();
            case "PlaceholderAPI": return new PlaceholdersAPIHook();
            case "LibsDisguises": return new LibsDisguisesHook();
            case "ExcellentCrates": return new ExcellentCratesHook();
            case "RedProtect": return new RedProtectHook();
            case "AdvancedBan": return new AdvancedBanHook();
            case "CoreProtect": return new CoreProtectHook();
            case "DecentHolograms": return new DecentHologramsHook();
            case "AuctionHouse": return new AuctionHouseHook();
            case "ServersNPC": return new znpcsHook();
            case "Shopkeepers": return new ShopkeepersHook();
            case "LoginSecurity": return new LoginSecurityHook();
            case "MoneyHunters": return new MoneyHuntersHook();
            case "GadgetsMenu": return new GadgetsMenuHook();
            case "WorldEditSelectionVisualizer": return new WorldEditSelectionVisualizerHook();
            case "Essentials": return new EssentialsHook();
            case "AureliumSkills": return new AureliumSkillsHook();
            case "IridiumSkyblock": return new IridiumSkyblockHook();
            case "SkinsRestorer": return new SkinsRestorerHook();
            case "Multiverse-Core": return new MultiverseCoreHook();
            case "GSit": return new GSitHook();
            case "VotingPlugin": return new VotingPluginHook();
            case "CommandPanels": return new CommandPanelsHook();
            case "MoneyFromMobs": return new MoneyFromMobsHook();
            case "AdvancedPortals": return new AdvancedPortalsHook();
            case "ArvinLib": return new ArvinLibHook();
            case "ConditionalEvents": return new ConditionalEventsHook();
            case "Prison": return new PrisonHook();
            //case "BedWars": return new BedWarsHook();
            default: return null;
        }
    }
}
