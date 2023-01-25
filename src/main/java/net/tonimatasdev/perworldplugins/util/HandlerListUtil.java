package net.tonimatasdev.perworldplugins.util;

import org.bukkit.event.HandlerList;
import org.bukkit.event.block.*;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.event.vehicle.*;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
public class HandlerListUtil {
    public static List<HandlerList> minecraftHandlerLists = new ArrayList<>();

    public static void register() {
        minecraftHandlerLists.addAll(Arrays.asList(
                // Block HandlerLists
                BlockBreakEvent.getHandlerList(),
                BlockBurnEvent.getHandlerList(),
                BlockCanBuildEvent.getHandlerList(),
                BlockDamageEvent.getHandlerList(),
                BlockDispenseEvent.getHandlerList(),
                BlockExpEvent.getHandlerList(),
                BlockExplodeEvent.getHandlerList(),
                BlockFadeEvent.getHandlerList(),
                BlockFormEvent.getHandlerList(),
                BlockFromToEvent.getHandlerList(),
                BlockGrowEvent.getHandlerList(),
                BlockIgniteEvent.getHandlerList(),
                BlockMultiPlaceEvent.getHandlerList(),
                BlockPhysicsEvent.getHandlerList(),
                BlockPistonExtendEvent.getHandlerList(),
                BlockPistonRetractEvent.getHandlerList(),
                BlockPlaceEvent.getHandlerList(),
                BlockRedstoneEvent.getHandlerList(),
                BlockSpreadEvent.getHandlerList(),
                EntityBlockFormEvent.getHandlerList(),
                LeavesDecayEvent.getHandlerList(),
                NotePlayEvent.getHandlerList(),
                SignChangeEvent.getHandlerList(),

                // Enchants HandlerLists
                EnchantItemEvent.getHandlerList(),
                PrepareItemEnchantEvent.getHandlerList(),

                // Entity HandlerLists
                CreatureSpawnEvent.getHandlerList(),
                CreeperPowerEvent.getHandlerList(),
                EntityBreakDoorEvent.getHandlerList(),
                EntityChangeBlockEvent.getHandlerList(),
                EntityCombustByBlockEvent.getHandlerList(),
                EntityCombustByEntityEvent.getHandlerList(),
                EntityCombustEvent.getHandlerList(),
                EntityCreatePortalEvent.getHandlerList(),
                EntityDamageByBlockEvent.getHandlerList(),
                EntityDamageByEntityEvent.getHandlerList(),
                EntityDamageEvent.getHandlerList(),
                EntityDeathEvent.getHandlerList(),
                EntityExplodeEvent.getHandlerList(),
                EntityInteractEvent.getHandlerList(),
                EntityPortalEnterEvent.getHandlerList(),
                EntityPortalEvent.getHandlerList(),
                EntityPortalExitEvent.getHandlerList(),
                EntityRegainHealthEvent.getHandlerList(),
                EntityShootBowEvent.getHandlerList(),
                EntitySpawnEvent.getHandlerList(),
                EntityTameEvent.getHandlerList(),
                EntityTargetEvent.getHandlerList(),
                EntityTargetLivingEntityEvent.getHandlerList(),
                EntityTeleportEvent.getHandlerList(),
                EntityUnleashEvent.getHandlerList(),
                ExpBottleEvent.getHandlerList(),
                ExplosionPrimeEvent.getHandlerList(),
                FireworkExplodeEvent.getHandlerList(),
                FoodLevelChangeEvent.getHandlerList(),
                HorseJumpEvent.getHandlerList(),
                ItemDespawnEvent.getHandlerList(),
                ItemMergeEvent.getHandlerList(),
                ItemSpawnEvent.getHandlerList(),
                PigZapEvent.getHandlerList(),
                PlayerDeathEvent.getHandlerList(),
                PlayerLeashEntityEvent.getHandlerList(),
                PotionSplashEvent.getHandlerList(),
                ProjectileHitEvent.getHandlerList(),
                ProjectileLaunchEvent.getHandlerList(),
                SheepDyeWoolEvent.getHandlerList(),
                SheepRegrowWoolEvent.getHandlerList(),
                SlimeSplitEvent.getHandlerList(),
                SpawnerSpawnEvent.getHandlerList(),

                // Hanging HandlerLists
                HangingBreakByEntityEvent.getHandlerList(),
                HangingBreakEvent.getHandlerList(),
                HangingPlaceEvent.getHandlerList(),

                // Inventory HandlerLists
                BrewEvent.getHandlerList(),
                CraftItemEvent.getHandlerList(),
                FurnaceBurnEvent.getHandlerList(),
                FurnaceExtractEvent.getHandlerList(),
                FurnaceSmeltEvent.getHandlerList(),
                InventoryClickEvent.getHandlerList(),
                InventoryCloseEvent.getHandlerList(),
                InventoryCreativeEvent.getHandlerList(),
                InventoryDragEvent.getHandlerList(),
                InventoryEvent.getHandlerList(),
                InventoryInteractEvent.getHandlerList(),
                //InventoryMoveItemEvent.getHandlerList(),
                InventoryOpenEvent.getHandlerList(),
                InventoryPickupItemEvent.getHandlerList(),
                PrepareItemCraftEvent.getHandlerList(),

                // Player HandlerLists
                AsyncPlayerChatEvent.getHandlerList(),
                //AsyncPlayerPreLoginEvent.getHandlerList(),
                PlayerAnimationEvent.getHandlerList(),
                PlayerArmorStandManipulateEvent.getHandlerList(),
                PlayerBedEnterEvent.getHandlerList(),
                PlayerBedLeaveEvent.getHandlerList(),
                PlayerBucketEmptyEvent.getHandlerList(),
                PlayerBucketFillEvent.getHandlerList(),
                PlayerChangedWorldEvent.getHandlerList(),
                PlayerChannelEvent.getHandlerList(),
                PlayerChatEvent.getHandlerList(),
                PlayerChatTabCompleteEvent.getHandlerList(),
                PlayerCommandPreprocessEvent.getHandlerList(),
                PlayerDropItemEvent.getHandlerList(),
                PlayerEditBookEvent.getHandlerList(),
                PlayerEggThrowEvent.getHandlerList(),
                PlayerExpChangeEvent.getHandlerList(),
                PlayerFishEvent.getHandlerList(),
                PlayerGameModeChangeEvent.getHandlerList(),
                PlayerInteractAtEntityEvent.getHandlerList(),
                PlayerInteractEntityEvent.getHandlerList(),
                PlayerInteractEvent.getHandlerList(),
                PlayerItemBreakEvent.getHandlerList(),
                PlayerItemConsumeEvent.getHandlerList(),
                PlayerItemDamageEvent.getHandlerList(),
                PlayerItemHeldEvent.getHandlerList(),
                PlayerJoinEvent.getHandlerList(),
                PlayerKickEvent.getHandlerList(),
                PlayerLevelChangeEvent.getHandlerList(),
                PlayerLoginEvent.getHandlerList(),
                PlayerMoveEvent.getHandlerList(),
                PlayerPickupItemEvent.getHandlerList(),
                PlayerPortalEvent.getHandlerList(),
                //PlayerPreLoginEvent.getHandlerList(),
                PlayerQuitEvent.getHandlerList(),
                PlayerRegisterChannelEvent.getHandlerList(),
                PlayerResourcePackStatusEvent.getHandlerList(),
                PlayerRespawnEvent.getHandlerList(),
                PlayerShearEntityEvent.getHandlerList(),
                PlayerStatisticIncrementEvent.getHandlerList(),
                PlayerTeleportEvent.getHandlerList(),
                PlayerToggleFlightEvent.getHandlerList(),
                PlayerToggleSneakEvent.getHandlerList(),
                PlayerToggleSprintEvent.getHandlerList(),
                PlayerUnleashEntityEvent.getHandlerList(),
                PlayerUnregisterChannelEvent.getHandlerList(),
                PlayerVelocityEvent.getHandlerList(),

                // Vehicle HandlerLists
                VehicleBlockCollisionEvent.getHandlerList(),
                VehicleCreateEvent.getHandlerList(),
                VehicleDamageEvent.getHandlerList(),
                VehicleDestroyEvent.getHandlerList(),
                VehicleEnterEvent.getHandlerList(),
                VehicleEntityCollisionEvent.getHandlerList(),
                VehicleExitEvent.getHandlerList(),
                VehicleMoveEvent.getHandlerList(),
                VehicleUpdateEvent.getHandlerList(),

                // Weather HandlerLists
                LightningStrikeEvent.getHandlerList(),
                ThunderChangeEvent.getHandlerList(),
                WeatherChangeEvent.getHandlerList(),

                // World HandlerLists
                ChunkLoadEvent.getHandlerList(),
                ChunkPopulateEvent.getHandlerList(),
                ChunkUnloadEvent.getHandlerList(),
                PortalCreateEvent.getHandlerList(),
                SpawnChangeEvent.getHandlerList(),
                StructureGrowEvent.getHandlerList(),
                WorldInitEvent.getHandlerList(),
                WorldLoadEvent.getHandlerList(),
                WorldSaveEvent.getHandlerList(),
                WorldUnloadEvent.getHandlerList()
        ));
    }
}
