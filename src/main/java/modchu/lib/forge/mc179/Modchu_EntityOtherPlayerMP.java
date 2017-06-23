package modchu.lib.forge.mc179;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityOtherPlayerMP;
import modchu.lib.Modchu_IEntityOtherPlayerMPMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Modchu_EntityOtherPlayerMP extends modchu.lib.forge.mc172_179.Modchu_EntityOtherPlayerMP implements Modchu_IEntityOtherPlayerMP {

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean func_152123_o() {
		return master != null ? master.hasSkin() : super.func_152123_o();
	}

	@Override
	public boolean func_152122_n() {
		return master != null ? master.hasPlayerInfo() : super.func_152122_n();
	}

	@Override
	public void func_152111_bt() {
		if (master != null) master.sendEnterCombat();
		else super.func_152111_bt();
	}

	@Override
	public void func_152112_bu() {
		if (master != null) master.sendEndCombat();
		else super.func_152112_bu();
	}

	@Override
	public void superSendEnterCombat() {
		super.func_152111_bt();
	}

	@Override
	public void superSendEndCombat() {
		super.func_152112_bu();
	}

	@Override
	public boolean superFunc_152122_n() {
		return super.func_152122_n();
	}

	@Override
	public boolean superFunc_152123_o() {
		return super.func_152123_o();
	}

	@Override
	public void func_152121_a(Type type, ResourceLocation resourceLocation) {
		if (master != null) master.func_152121_a(type, resourceLocation);
		else super.func_152121_a(type, resourceLocation);
	}

	@Override
	public Object superFunc_181014_aG() {
		return superGetLastPortalVec();
	}

	@Override
	public void superSetAngles(float yaw, float pitch) {
		super.setAngles(yaw, pitch);
	}

	@Override
	public void superAddChatMessage(Object iTextComponent) {
		super.addChatMessage((IChatComponent) iTextComponent);
	}

	@Override
	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public void superFunc_181013_g(float p_181013_1_) {
	}

	@Override
	public Object superFunc_181012_aH() {
		return superGetTeleportDirection();
	}

	@Override
	public String superGetCachedUniqueIdString() {
		return null;
	}

	@Override
	public Map superGetActivePotionMap() {
		return null;
	}

	@Override
	public void superBlockUsingShield(Object entityLivingBase) {
	}

	@Override
	public Object superGetLastDamageSource() {
		return null;
	}

	@Override
	public boolean superHasItemInSlot(Object entityEquipmentSlot) {
		return false;
	}

	@Override
	public float superGetWaterSlowDown() {
		return 0.0F;
	}

	@Override
	public boolean superAttackable() {
		return false;
	}

	@Override
	public void superSetPartying(Object blockPos, boolean p_191987_2_) {
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object enumHand) {
		return false;
	}

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object enumHand) {
		return null;
	}

	@Override
	public void superFunc_191955_a(Object iBlockState) {
	}

	@Override
	public float superFunc_191954_d(float p_191954_1_) {
		return 0.0F;
	}

	@Override
	public boolean superFunc_191957_ae() {
		return false;
	}

	@Override
	public boolean superHasNoGravity() {
		return false;
	}

	@Override
	public void superSetNoGravity(boolean noGravity) {
	}

	@Override
	public boolean superFunc_191953_am() {
		return false;
	}

	@Override
	public Object superGetPitchYaw() {
		return null;
	}

	@Override
	public Object superGetForward() {
		return null;
	}

	@Override
	public boolean superGetIsInvulnerable() {
		return false;
	}

	@Override
	public boolean superCanTrample(Object world, Object block, Object blockPos, float fallDistance) {
		return false;
	}

	@Override
	public int superGetFireImmuneTicks() {
		return -1;
	}

	@Override
	public void superDestroyVanishingCursedItems() {
	}

	@Override
	public void superOpenEditStructure(Object tileEntityStructure) {
	}

	@Override
	public void superDisableShield(boolean p_190777_1_) {
	}

	@Override
	public void superUnlockRecipes(List p_192021_1_) {
	}

	@Override
	public void superUnlockRecipes(Object[] resourceLocation) {
	}

	@Override
	public void superFunc_192022_b(List p_192022_1_) {
	}

	@Override
	public boolean superAddItemStackToInventory(Object itemStack) {
		return false;
	}

	@Override
	public boolean superAddShoulderEntity(Object nBTTagCompound) {
		return false;
	}

	@Override
	public void superSpawnShoulderEntities() {
	}

	@Override
	public Object superGetLeftShoulderEntity() {
		return null;
	}

	@Override
	public void superSetLeftShoulderEntity(Object nBTTagCompound) {
	}

	@Override
	public Object superGetRightShoulderEntity() {
		return null;
	}

	@Override
	public void superSetRightShoulderEntity(Object nBTTagCompound) {
	}

	@Override
	public boolean superCanUseCommandBlock() {
		return false;
	}

	@Override
	public boolean superHasSpawnDimension() {
		return false;
	}

	@Override
	public int superGetSpawnDimension() {
		return -1;
	}

	@Override
	public void superSetSpawnDimension(Object integer) {
	}

}
