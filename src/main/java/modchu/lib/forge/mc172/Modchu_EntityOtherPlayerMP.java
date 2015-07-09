package modchu.lib.forge.mc172;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

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

import com.mojang.authlib.GameProfile;

public class Modchu_EntityOtherPlayerMP extends EntityOtherPlayerMP implements Modchu_IEntityOtherPlayerMP {
	public Modchu_IEntityOtherPlayerMPMaster master;

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super((World)map.get("Object"), (GameProfile)map.get("Object1"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityOtherPlayerMP init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityOtherPlayerMPMaster ? (Modchu_IEntityOtherPlayerMPMaster) instance : null;
		if (master != null); else Modchu_Debug.lDebug("Modchu_EntityOtherPlayerMP init master == null !!");
	}

	@Override
	protected void resetHeight() {
		if (master != null) master.resetHeight();
		else super.resetHeight();
	}

	public void superResetHeight() {
		super.resetHeight();
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float p_70097_2_) {
		return master != null ? master.attackEntityFrom(damageSource, p_70097_2_) : super.attackEntityFrom(damageSource, p_70097_2_);
	}

	public boolean superAttackEntityFrom(Object damageSource, float p_70097_2_) {
		return super.attackEntityFrom((DamageSource) damageSource, p_70097_2_);
	}

	@Override
	public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
		if (master != null) master.setPositionAndRotation2(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);
		else super.setPositionAndRotation2(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);
	}

	public void superSetPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
		super.setPositionAndRotation2(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);
	}

	@Override
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	public void superOnUpdate() {
		super.onUpdate();
	}

	@Override
	public float getShadowSize() {
		return master != null ? master.getShadowSize() : super.getShadowSize();
	}

	public float superGetShadowSize() {
		return super.getShadowSize();
	}

	@Override
	public void onLivingUpdate() {
		if (master != null) master.onLivingUpdate();
		else super.onLivingUpdate();
	}

	public void superOnLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	public void setCurrentItemOrArmor(int p_70062_1_, ItemStack itemStack) {
		if (master != null) master.setCurrentItemOrArmor(p_70062_1_, itemStack);
		else super.setCurrentItemOrArmor(p_70062_1_, itemStack);
	}

	public void superSetCurrentItemOrArmor(int p_70062_1_, Object itemStack) {
		super.setCurrentItemOrArmor(p_70062_1_, (ItemStack) itemStack);
	}

	@Override
	public float getDefaultEyeHeight() {
		return master != null ? master.getDefaultEyeHeight() : super.getDefaultEyeHeight();
	}

	public float superGetDefaultEyeHeight() {
		return super.getDefaultEyeHeight();
	}

	@Override
	public void addChatMessage(IChatComponent iChatComponent) {
		if (master != null) master.addChatMessage(iChatComponent);
		else super.addChatMessage(iChatComponent);
	}

	public void superAddChatMessage(Object iChatComponent) {
		super.addChatMessage((IChatComponent) iChatComponent);
	}

	@Override
	public boolean canCommandSenderUseCommand(int p_70003_1_, String p_70003_2_) {
		return master != null ? master.canCommandSenderUseCommand(p_70003_1_, p_70003_2_) : super.canCommandSenderUseCommand(p_70003_1_, p_70003_2_);
	}

	public boolean superCanCommandSenderUseCommand(int p_70003_1_, String p_70003_2_) {
		return super.canCommandSenderUseCommand(p_70003_1_, p_70003_2_);
	}

	@Override
	public ChunkCoordinates getPlayerCoordinates() {
		return (ChunkCoordinates) (master != null ? master.getPlayerCoordinates() : super.getPlayerCoordinates());
	}

	public ChunkCoordinates superGetPlayerCoordinates() {
		return super.getPlayerCoordinates();
	}

	@Override
	public ResourceLocation getLocationSkin() {
		return (ResourceLocation) (master != null ? master.getLocationSkin() : super.getLocationSkin());
	}

	public ResourceLocation superGetLocationSkin() {
		return super.getLocationSkin();
	}

	@Override
	public ResourceLocation getLocationCape() {
		return (ResourceLocation) (master != null ? master.getLocationCape() : super.getLocationCape());
	}

	public ResourceLocation superGetLocationCape() {
		return super.getLocationCape();
	}

	@Override
	protected void applyEntityAttributes() {
		if (master != null) master.applyEntityAttributes();
		else super.applyEntityAttributes();
	}

	public void superApplyEntityAttributes() {
		super.applyEntityAttributes();
	}

	@Override
	protected void entityInit() {
		if (master != null) master.entityInit();
		else super.entityInit();
	}

	public void superEntityInit() {
		super.entityInit();
	}

	@Override
	public ItemStack getItemInUse() {
		return (ItemStack) (master != null ? master.getItemInUse() : super.getItemInUse());
	}

	public ItemStack superGetItemInUse() {
		return super.getItemInUse();
	}

	@Override
	public int getItemInUseCount() {
		return master != null ? master.getItemInUseCount() : super.getItemInUseCount();
	}

	public int superGetItemInUseCount() {
		return super.getItemInUseCount();
	}

	@Override
	public boolean isUsingItem() {
		return master != null ? master.isUsingItem() : super.isUsingItem();
	}

	public boolean superIsUsingItem() {
		return super.isUsingItem();
	}

	@Override
	public int getItemInUseDuration() {
		return master != null ? master.getItemInUseDuration() : super.getItemInUseDuration();
	}

	public int superGetItemInUseDuration() {
		return super.getItemInUseDuration();
	}

	@Override
	public void stopUsingItem() {
		if (master != null) master.stopUsingItem();
		else super.stopUsingItem();
	}

	public void superStopUsingItem() {
		super.stopUsingItem();
	}

	@Override
	public void clearItemInUse() {
		if (master != null) master.clearItemInUse();
		else super.clearItemInUse();
	}

	public void superClearItemInUse() {
		super.clearItemInUse();
	}

	@Override
	public boolean isBlocking() {
		return master != null ? master.isBlocking() : super.isBlocking();
	}

	public boolean superIsBlocking() {
		return super.isBlocking();
	}

	@Override
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}

	public int superGetMaxInPortalTime() {
		return super.getMaxInPortalTime();
	}

	@Override
	protected String getSwimSound() {
		return master != null ? master.getSwimSound() : super.getSwimSound();
	}

	public String superGetSwimSound() {
		return super.getSwimSound();
	}

	@Override
	protected String getSplashSound() {
		return master != null ? master.getSplashSound() : super.getSplashSound();
	}

	public String superGetSplashSound() {
		return super.getSplashSound();
	}

	@Override
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}

	public int superGetPortalCooldown() {
		return super.getPortalCooldown();
	}

	@Override
	public void playSound(String p_85030_1_, float p_85030_2_, float p_85030_3_) {
		if (master != null) master.playSound(p_85030_1_, p_85030_2_, p_85030_3_);
		else super.playSound(p_85030_1_, p_85030_2_, p_85030_3_);
	}

	public void superPlaySound(String p_85030_1_, float p_85030_2_, float p_85030_3_) {
		super.playSound(p_85030_1_, p_85030_2_, p_85030_3_);
	}

	@Override
	protected void updateItemUse(ItemStack itemStack, int p_71010_2_) {
		if (master != null) master.updateItemUse(itemStack, p_71010_2_);
		else super.updateItemUse(itemStack, p_71010_2_);
	}

	public void superUpdateItemUse(Object itemStack, int p_71010_2_) {
		super.updateItemUse((ItemStack) itemStack, p_71010_2_);
	}

	@Override
	protected void onItemUseFinish() {
		if (master != null) master.onItemUseFinish();
		else super.onItemUseFinish();
	}

	public void superOnItemUseFinish() {
		super.onItemUseFinish();
	}

	@Override
	public void handleHealthUpdate(byte p_70103_1_) {
		if (master != null) master.handleHealthUpdate(p_70103_1_);
		else super.handleHealthUpdate(p_70103_1_);
	}

	public void superHandleHealthUpdate(byte p_70103_1_) {
		super.handleHealthUpdate(p_70103_1_);
	}

	@Override
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}

	public boolean superIsMovementBlocked() {
		return super.isMovementBlocked();
	}

	@Override
	public void closeScreen() {
		if (master != null) master.closeScreen();
		else super.closeScreen();
	}

	public void superCloseScreen() {
		super.closeScreen();
	}

	@Override
	public void mountEntity(Entity entity) {
		if (master != null) master.mountEntity(entity);
		else super.mountEntity(entity);
	}

	public void superMountEntity(Object entity) {
		super.mountEntity((Entity) entity);
	}

	@Override
	public void updateRidden() {
		if (master != null) master.updateRidden();
		else super.updateRidden();
	}

	public void superUpdateRidden() {
		super.updateRidden();
	}

	@Override
	public void preparePlayerToSpawn() {
		if (master != null) master.preparePlayerToSpawn();
		else super.preparePlayerToSpawn();
	}

	public void superPreparePlayerToSpawn() {
		super.preparePlayerToSpawn();
	}

	@Override
	protected void updateEntityActionState() {
		if (master != null) master.updateEntityActionState();
		else super.updateEntityActionState();
	}

	public void superUpdateEntityActionState() {
		super.updateEntityActionState();
	}

	@Override
	public int getScore() {
		return master != null ? master.getScore() : super.getScore();
	}

	public int superGetScore() {
		return super.getScore();
	}

	@Override
	public void setScore(int p_85040_1_) {
		if (master != null) master.setScore(p_85040_1_);
		else super.setScore(p_85040_1_);
	}

	public void superSetScore(int p_85040_1_) {
		super.setScore(p_85040_1_);
	}

	@Override
	public void addScore(int p_85039_1_) {
		if (master != null) master.addScore(p_85039_1_);
		else super.addScore(p_85039_1_);
	}

	public void superAddScore(int p_85039_1_) {
		super.addScore(p_85039_1_);
	}

	@Override
	public void onDeath(DamageSource damageSource) {
		if (master != null) master.onDeath(damageSource);
		else super.onDeath(damageSource);
	}

	public void superOnDeath(Object damageSource) {
		super.onDeath((DamageSource) damageSource);
	}

	@Override
	protected String getHurtSound() {
		return master != null ? master.getHurtSound() : super.getHurtSound();
	}

	public String superGetHurtSound() {
		return super.getHurtSound();
	}

	@Override
	protected String getDeathSound() {
		return master != null ? master.getDeathSound() : super.getDeathSound();
	}

	public String superGetDeathSound() {
		return super.getDeathSound();
	}

	@Override
	public void addToPlayerScore(Entity entity, int p_70084_2_) {
		if (master != null) master.addToPlayerScore(entity, p_70084_2_);
		else super.addToPlayerScore(entity, p_70084_2_);
	}

	public void superAddToPlayerScore(Object entity, int p_70084_2_) {
		super.addToPlayerScore((Entity) entity, p_70084_2_);
	}

	@Override
	public EntityItem dropOneItem(boolean p_71040_1_) {
		return (EntityItem) (master != null ? master.dropOneItem(p_71040_1_) : super.dropOneItem(p_71040_1_));
	}

	public EntityItem superDropOneItem(boolean p_71040_1_) {
		return super.dropOneItem(p_71040_1_);
	}

	@Override
	public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean p_71019_2_) {
		return (EntityItem) (master != null ? master.dropPlayerItemWithRandomChoice(itemStack, p_71019_2_) : super.dropPlayerItemWithRandomChoice(itemStack, p_71019_2_));
	}

	public EntityItem superDropPlayerItemWithRandomChoice(Object itemStack, boolean p_71019_2_) {
		return super.dropPlayerItemWithRandomChoice((ItemStack) itemStack, p_71019_2_);
	}

	@Override
	public EntityItem func_146097_a(ItemStack itemStack, boolean p_146097_2_, boolean p_146097_3_) {
		return (EntityItem) (master != null ? master.func_146097_a(itemStack, p_146097_2_, p_146097_3_) : super.func_146097_a(itemStack, p_146097_2_, p_146097_3_));
	}

	public EntityItem superFunc_146097_a(Object itemStack, boolean p_146097_2_, boolean p_146097_3_) {
		return super.func_146097_a((ItemStack) itemStack, p_146097_2_, p_146097_3_);
	}

	@Override
	public void joinEntityItemWithWorld(EntityItem entityItem) {
		if (master != null) master.joinEntityItemWithWorld(entityItem);
		else super.joinEntityItemWithWorld(entityItem);
	}

	public void superJoinEntityItemWithWorld(Object entityItem) {
		super.joinEntityItemWithWorld((EntityItem) entityItem);
	}

	@Override
	public float getCurrentPlayerStrVsBlock(Block block, boolean p_146096_2_) {
		return master != null ? master.getCurrentPlayerStrVsBlock(block, p_146096_2_) : super.getCurrentPlayerStrVsBlock(block, p_146096_2_);
	}

	public float superGetCurrentPlayerStrVsBlock(Object block, boolean p_146096_2_) {
		return super.getCurrentPlayerStrVsBlock((Block) block, p_146096_2_);
	}

	@Override
	public float getBreakSpeed(Block block, boolean p_146096_2_, int meta) {
		return master != null ? master.getBreakSpeed(block, p_146096_2_, meta) : super.getBreakSpeed(block, p_146096_2_, meta);
	}

	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta) {
		return super.getBreakSpeed((Block) block, p_146096_2_, meta);
	}

	@Override
	public float getBreakSpeed(Block block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return master != null ? master.getBreakSpeed(block, p_146096_2_, meta, x, y, z) : super.getBreakSpeed(block, p_146096_2_, meta, x, y, z);
	}

	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return super.getBreakSpeed((Block) block, p_146096_2_, meta, x, y, z);
	}

	@Override
	public boolean canHarvestBlock(Block block) {
		return master != null ? master.canHarvestBlock(block) : super.canHarvestBlock(block);
	}

	public boolean superCanHarvestBlock(Object block) {
		return super.canHarvestBlock((Block) block);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}

	public void superReadEntityFromNBT(Object nBTTagCompound) {
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeEntityToNBT(nBTTagCompound);
		else super.writeEntityToNBT(nBTTagCompound);
	}

	public void superWriteEntityToNBT(Object nBTTagCompound) {
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void displayGUIChest(IInventory iInventory) {
		if (master != null) master.displayGUIChest(iInventory);
		else super.displayGUIChest(iInventory);
	}

	public void superDisplayGUIChest(Object iInventory) {
		super.displayGUIChest((IInventory) iInventory);
	}

	@Override
	public void func_146093_a(TileEntityHopper tileEntityHopper) {
		if (master != null) master.func_146093_a(tileEntityHopper);
		else super.func_146093_a(tileEntityHopper);
	}

	public void superFunc_146093_a(Object tileEntityHopper) {
		super.func_146093_a((TileEntityHopper) tileEntityHopper);
	}

	@Override
	public void displayGUIHopperMinecart(EntityMinecartHopper entityMinecartHopper) {
		if (master != null) master.displayGUIHopperMinecart(entityMinecartHopper);
		else super.displayGUIHopperMinecart(entityMinecartHopper);
	}

	public void superDisplayGUIHopperMinecart(Object entityMinecartHopper) {
		super.displayGUIHopperMinecart((EntityMinecartHopper) entityMinecartHopper);
	}

	@Override
	public void displayGUIHorse(EntityHorse entityHorse, IInventory iInventory) {
		if (master != null) master.displayGUIHorse(entityHorse, iInventory);
		else super.displayGUIHorse(entityHorse, iInventory);
	}

	public void superDisplayGUIHorse(Object entityHorse, Object iInventory) {
		super.displayGUIHorse((EntityHorse) entityHorse, (IInventory) iInventory);
	}

	@Override
	public void displayGUIEnchantment(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {
		if (master != null) master.displayGUIEnchantment(p_71002_1_, p_71002_2_, p_71002_3_, p_71002_4_);
		else super.displayGUIEnchantment(p_71002_1_, p_71002_2_, p_71002_3_, p_71002_4_);
	}

	public void superDisplayGUIEnchantment(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {
		super.displayGUIEnchantment(p_71002_1_, p_71002_2_, p_71002_3_, p_71002_4_);
	}

	@Override
	public void displayGUIAnvil(int p_82244_1_, int p_82244_2_, int p_82244_3_) {
		if (master != null) master.displayGUIAnvil(p_82244_1_, p_82244_2_, p_82244_3_);
		else super.displayGUIAnvil(p_82244_1_, p_82244_2_, p_82244_3_);
	}

	public void superDisplayGUIAnvil(int p_82244_1_, int p_82244_2_, int p_82244_3_) {
		super.displayGUIAnvil(p_82244_1_, p_82244_2_, p_82244_3_);
	}

	@Override
	public void displayGUIWorkbench(int p_71058_1_, int p_71058_2_, int p_71058_3_) {
		if (master != null) master.displayGUIWorkbench(p_71058_1_, p_71058_2_, p_71058_3_);
		else super.displayGUIWorkbench(p_71058_1_, p_71058_2_, p_71058_3_);
	}

	public void superDisplayGUIWorkbench(int p_71058_1_, int p_71058_2_, int p_71058_3_) {
		super.displayGUIWorkbench(p_71058_1_, p_71058_2_, p_71058_3_);
	}

	@Override
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}

	public float superGetEyeHeight() {
		return super.getEyeHeight();
	}

	@Override
	public boolean canAttackPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.canAttackPlayer(entityPlayer) : super.canAttackPlayer(entityPlayer);
	}

	public boolean superCanAttackPlayer(Object entityPlayer) {
		return super.canAttackPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	protected void damageArmor(float p_70675_1_) {
		if (master != null) master.damageArmor(p_70675_1_);
		else super.damageArmor(p_70675_1_);
	}

	public void superDamageArmor(float p_70675_1_) {
		super.damageArmor(p_70675_1_);
	}

	@Override
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}

	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}

	@Override
	public float getArmorVisibility() {
		return master != null ? master.getArmorVisibility() : super.getArmorVisibility();
	}

	public float superGetArmorVisibility() {
		return super.getArmorVisibility();
	}

	@Override
	protected void damageEntity(DamageSource damageSource, float p_70665_2_) {
		if (master != null) master.damageEntity(damageSource, p_70665_2_);
		else super.damageEntity(damageSource, p_70665_2_);
	}

	public void superDamageEntity(Object damageSource, float p_70665_2_) {
		super.damageEntity((DamageSource) damageSource, p_70665_2_);
	}

	@Override
	public void func_146101_a(TileEntityFurnace tileEntityFurnace) {
		if (master != null) master.func_146101_a(tileEntityFurnace);
		else super.func_146101_a(tileEntityFurnace);
	}

	public void superFunc_146101_a(Object tileEntityFurnace) {
		super.func_146101_a((TileEntityFurnace) tileEntityFurnace);
	}

	@Override
	public void func_146102_a(TileEntityDispenser tileEntityDispenser) {
		if (master != null) master.func_146102_a(tileEntityDispenser);
		else super.func_146102_a(tileEntityDispenser);
	}

	public void superFunc_146102_a(Object tileEntityDispenser) {
		super.func_146102_a((TileEntityDispenser) tileEntityDispenser);
	}

	@Override
	public void func_146100_a(TileEntity tileEntity) {
		if (master != null) master.func_146100_a(tileEntity);
		else super.func_146100_a(tileEntity);
	}

	public void superFunc_146100_a(Object tileEntity) {
		super.func_146100_a((TileEntity) tileEntity);
	}

	@Override
	public void func_146095_a(CommandBlockLogic commandBlockLogic) {
		if (master != null) master.func_146095_a(commandBlockLogic);
		else super.func_146095_a(commandBlockLogic);
	}

	public void superFunc_146095_a(Object commandBlockLogic) {
		super.func_146095_a((CommandBlockLogic) commandBlockLogic);
	}

	@Override
	public void func_146098_a(TileEntityBrewingStand tileEntityBrewingStand) {
		if (master != null) master.func_146098_a(tileEntityBrewingStand);
		else super.func_146098_a(tileEntityBrewingStand);
	}

	public void superFunc_146098_a(Object tileEntityBrewingStand) {
		super.func_146098_a((TileEntityBrewingStand) tileEntityBrewingStand);
	}

	@Override
	public void func_146104_a(TileEntityBeacon tileEntityBeacon) {
		if (master != null) master.func_146104_a(tileEntityBeacon);
		else super.func_146104_a(tileEntityBeacon);
	}

	public void superFunc_146104_a(Object tileEntityBeacon) {
		super.func_146104_a((TileEntityBeacon) tileEntityBeacon);
	}

	@Override
	public void displayGUIMerchant(IMerchant iMerchant, String p_71030_2_) {
		if (master != null) master.displayGUIMerchant(iMerchant, p_71030_2_);
		else super.displayGUIMerchant(iMerchant, p_71030_2_);
	}

	public void superDisplayGUIMerchant(Object iMerchant, String p_71030_2_) {
		super.displayGUIMerchant((IMerchant) iMerchant, p_71030_2_);
	}

	@Override
	public void displayGUIBook(ItemStack itemStack) {
		if (master != null) master.displayGUIBook(itemStack);
		else super.displayGUIBook(itemStack);
	}

	public void superDisplayGUIBook(Object itemStack) {
		super.displayGUIBook((ItemStack) itemStack);
	}

	@Override
	public boolean interactWith(Entity entity) {
		return master != null ? master.interactWith(entity) : super.interactWith(entity);
	}

	public boolean superInteractWith(Object entity) {
		return super.interactWith((Entity) entity);
	}

	@Override
	public ItemStack getCurrentEquippedItem() {
		return (ItemStack) (master != null ? master.getCurrentEquippedItem() : super.getCurrentEquippedItem());
	}

	public ItemStack superGetCurrentEquippedItem() {
		return super.getCurrentEquippedItem();
	}

	@Override
	public void destroyCurrentEquippedItem() {
		if (master != null) master.destroyCurrentEquippedItem();
		else super.destroyCurrentEquippedItem();
	}

	public void superDestroyCurrentEquippedItem() {
		super.destroyCurrentEquippedItem();
	}

	@Override
	public double getYOffset() {
		return master != null ? master.getYOffset() : super.getYOffset();
	}

	public double superGetYOffset() {
		return super.getYOffset();
	}

	@Override
	public void attackTargetEntityWithCurrentItem(Entity entity) {
		if (master != null) master.attackTargetEntityWithCurrentItem(entity);
		else super.attackTargetEntityWithCurrentItem(entity);
	}

	public void superAttackTargetEntityWithCurrentItem(Object entity) {
		super.attackTargetEntityWithCurrentItem((Entity) entity);
	}

	@Override
	public void onCriticalHit(Entity entity) {
		if (master != null) master.onCriticalHit(entity);
		else super.onCriticalHit(entity);
	}

	public void superOnCriticalHit(Object entity) {
		super.onCriticalHit((Entity) entity);
	}

	@Override
	public void onEnchantmentCritical(Entity entity) {
		if (master != null) master.onEnchantmentCritical(entity);
		else super.onEnchantmentCritical(entity);
	}

	public void superOnEnchantmentCritical(Object entity) {
		super.onEnchantmentCritical((Entity) entity);
	}

	@Override
	public void respawnPlayer() {
		if (master != null) master.respawnPlayer();
		else super.respawnPlayer();
	}

	public void superRespawnPlayer() {
		super.respawnPlayer();
	}

	@Override
	public void setDead() {
		if (master != null) master.setDead();
		else super.setDead();
	}

	public void superSetDead() {
		super.setDead();
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return master != null ? master.isEntityInsideOpaqueBlock() : super.isEntityInsideOpaqueBlock();
	}

	public boolean superIsEntityInsideOpaqueBlock() {
		return super.isEntityInsideOpaqueBlock();
	}

	@Override
	public GameProfile getGameProfile() {
		return (GameProfile) (master != null ? master.getGameProfile() : super.getGameProfile());
	}

	public GameProfile superGetGameProfile() {
		return super.getGameProfile();
	}

	@Override
	public EnumStatus sleepInBedAt(int p_71018_1_, int p_71018_2_, int p_71018_3_) {
		return (EnumStatus) (master != null ? master.sleepInBedAt(p_71018_1_, p_71018_2_, p_71018_3_) : super.sleepInBedAt(p_71018_1_, p_71018_2_, p_71018_3_));
	}

	public EnumStatus superSleepInBedAt(int p_71018_1_, int p_71018_2_, int p_71018_3_) {
		return super.sleepInBedAt(p_71018_1_, p_71018_2_, p_71018_3_);
	}

	@Override
	public void wakeUpPlayer(boolean p_70999_1_, boolean p_70999_2_, boolean p_70999_3_) {
		if (master != null) master.wakeUpPlayer(p_70999_1_, p_70999_2_, p_70999_3_);
		else super.wakeUpPlayer(p_70999_1_, p_70999_2_, p_70999_3_);
	}

	public void superWakeUpPlayer(boolean p_70999_1_, boolean p_70999_2_, boolean p_70999_3_) {
		super.wakeUpPlayer(p_70999_1_, p_70999_2_, p_70999_3_);
	}

	@Override
	public float getBedOrientationInDegrees() {
		return master != null ? master.getBedOrientationInDegrees() : super.getBedOrientationInDegrees();
	}

	public float superGetBedOrientationInDegrees() {
		return super.getBedOrientationInDegrees();
	}

	@Override
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}

	public boolean superIsPlayerSleeping() {
		return super.isPlayerSleeping();
	}

	@Override
	public boolean isPlayerFullyAsleep() {
		return master != null ? master.isPlayerFullyAsleep() : super.isPlayerFullyAsleep();
	}

	public boolean superIsPlayerFullyAsleep() {
		return super.isPlayerFullyAsleep();
	}

	@Override
	public int getSleepTimer() {
		return master != null ? master.getSleepTimer() : super.getSleepTimer();
	}

	public int superGetSleepTimer() {
		return super.getSleepTimer();
	}

	@Override
	protected boolean getHideCape(int p_82241_1_) {
		return master != null ? master.getHideCape(p_82241_1_) : super.getHideCape(p_82241_1_);
	}

	public boolean superGetHideCape(int p_82241_1_) {
		return super.getHideCape(p_82241_1_);
	}

	@Override
	protected void setHideCape(int p_82239_1_, boolean p_82239_2_) {
		if (master != null) master.setHideCape(p_82239_1_, p_82239_2_);
		else super.setHideCape(p_82239_1_, p_82239_2_);
	}

	public void superSetHideCape(int p_82239_1_, boolean p_82239_2_) {
		super.setHideCape(p_82239_1_, p_82239_2_);
	}

	@Override
	public void addChatComponentMessage(IChatComponent iChatComponent) {
		if (master != null) master.addChatComponentMessage(iChatComponent);
		else super.addChatComponentMessage(iChatComponent);
	}

	public void superAddChatComponentMessage(Object iChatComponent) {
		super.addChatComponentMessage((IChatComponent) iChatComponent);
	}

	@Override
	public ChunkCoordinates getBedLocation() {
		return (ChunkCoordinates) (master != null ? master.getBedLocation() : super.getBedLocation());
	}

	public ChunkCoordinates superGetBedLocation() {
		return super.getBedLocation();
	}

	@Override
	public boolean isSpawnForced() {
		return master != null ? master.isSpawnForced() : super.isSpawnForced();
	}

	public boolean superIsSpawnForced() {
		return super.isSpawnForced();
	}

	@Override
	public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean p_71063_2_) {
		if (master != null) master.setSpawnChunk(chunkCoordinates, p_71063_2_);
		else super.setSpawnChunk(chunkCoordinates, p_71063_2_);
	}

	public void superSetSpawnChunk(Object chunkCoordinates, boolean p_71063_2_) {
		super.setSpawnChunk((ChunkCoordinates) chunkCoordinates, p_71063_2_);
	}

	@Override
	public void triggerAchievement(StatBase statBase) {
		if (master != null) master.triggerAchievement(statBase);
		else super.triggerAchievement(statBase);
	}

	public void superTriggerAchievement(Object statBase) {
		super.triggerAchievement((StatBase) statBase);
	}

	@Override
	public void addStat(StatBase statBase, int p_71064_2_) {
		if (master != null) master.addStat(statBase, p_71064_2_);
		else super.addStat(statBase, p_71064_2_);
	}

	public void superAddStat(Object statBase, int p_71064_2_) {
		super.addStat((StatBase) statBase, p_71064_2_);
	}

	@Override
	public void jump() {
		if (master != null) master.jump();
		else super.jump();
	}

	public void superJump() {
		super.jump();
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
		if (master != null) master.moveEntityWithHeading(p_70612_1_, p_70612_2_);
		else super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
	}

	public void superMoveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
		super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
	}

	@Override
	public float getAIMoveSpeed() {
		return master != null ? master.getAIMoveSpeed() : super.getAIMoveSpeed();
	}

	public float superGetAIMoveSpeed() {
		return super.getAIMoveSpeed();
	}

	@Override
	public void addMovementStat(double p_71000_1_, double p_71000_3_, double p_71000_5_) {
		if (master != null) master.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
		else super.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
	}

	public void superAddMovementStat(double p_71000_1_, double p_71000_3_, double p_71000_5_) {
		super.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
	}

	@Override
	protected void fall(float p_70069_1_) {
		if (master != null) master.fall(p_70069_1_);
		else super.fall(p_70069_1_);
	}

	public void superFall(float p_70069_1_) {
		super.fall(p_70069_1_);
	}

	@Override
	protected String func_146067_o(int p_146067_1_) {
		return master != null ? master.func_146067_o(p_146067_1_) : super.func_146067_o(p_146067_1_);
	}

	public String superFunc_146067_o(int p_146067_1_) {
		return super.func_146067_o(p_146067_1_);
	}

	@Override
	public void onKillEntity(EntityLivingBase entityLivingBase) {
		if (master != null) master.onKillEntity(entityLivingBase);
		else super.onKillEntity(entityLivingBase);
	}

	public void superOnKillEntity(Object entityLivingBase) {
		super.onKillEntity((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void setInWeb() {
		if (master != null) master.setInWeb();
		else super.setInWeb();
	}

	public void superSetInWeb() {
		super.setInWeb();
	}

	@Override
	public IIcon getItemIcon(ItemStack itemStack, int p_70620_2_) {
		return (IIcon) (master != null ? master.getItemIcon(itemStack, p_70620_2_) : super.getItemIcon(itemStack, p_70620_2_));
	}

	public IIcon superGetItemIcon(Object itemStack, int p_70620_2_) {
		return super.getItemIcon((ItemStack) itemStack, p_70620_2_);
	}

	@Override
	public ItemStack getCurrentArmor(int p_82169_1_) {
		return (ItemStack) (master != null ? master.getCurrentArmor(p_82169_1_) : super.getCurrentArmor(p_82169_1_));
	}

	public ItemStack superGetCurrentArmor(int p_82169_1_) {
		return super.getCurrentArmor(p_82169_1_);
	}

	@Override
	public void addExperience(int p_71023_1_) {
		if (master != null) master.addExperience(p_71023_1_);
		else super.addExperience(p_71023_1_);
	}

	public void superAddExperience(int p_71023_1_) {
		super.addExperience(p_71023_1_);
	}

	@Override
	public void addExperienceLevel(int p_82242_1_) {
		if (master != null) master.addExperienceLevel(p_82242_1_);
		else super.addExperienceLevel(p_82242_1_);
	}

	public void superAddExperienceLevel(int p_82242_1_) {
		super.addExperienceLevel(p_82242_1_);
	}

	@Override
	public int xpBarCap() {
		return master != null ? master.xpBarCap() : super.xpBarCap();
	}

	public int superXpBarCap() {
		return super.xpBarCap();
	}

	@Override
	public void addExhaustion(float p_71020_1_) {
		if (master != null) master.addExhaustion(p_71020_1_);
		else super.addExhaustion(p_71020_1_);
	}

	public void superAddExhaustion(float p_71020_1_) {
		super.addExhaustion(p_71020_1_);
	}

	@Override
	public FoodStats getFoodStats() {
		return (FoodStats) (master != null ? master.getFoodStats() : super.getFoodStats());
	}

	public FoodStats superGetFoodStats() {
		return super.getFoodStats();
	}

	@Override
	public boolean canEat(boolean p_71043_1_) {
		return master != null ? master.canEat(p_71043_1_) : super.canEat(p_71043_1_);
	}

	public boolean superCanEat(boolean p_71043_1_) {
		return super.canEat(p_71043_1_);
	}

	@Override
	public boolean shouldHeal() {
		return master != null ? master.shouldHeal() : super.shouldHeal();
	}

	public boolean superShouldHeal() {
		return super.shouldHeal();
	}

	@Override
	public void setItemInUse(ItemStack itemStack, int p_71008_2_) {
		if (master != null) master.setItemInUse(itemStack, p_71008_2_);
		else super.setItemInUse(itemStack, p_71008_2_);
	}

	public void superSetItemInUse(Object itemStack, int p_71008_2_) {
		super.setItemInUse((ItemStack) itemStack, p_71008_2_);
	}

	@Override
	public boolean isCurrentToolAdventureModeExempt(int p_82246_1_, int p_82246_2_, int p_82246_3_) {
		return master != null ? master.isCurrentToolAdventureModeExempt(p_82246_1_, p_82246_2_, p_82246_3_) : super.isCurrentToolAdventureModeExempt(p_82246_1_, p_82246_2_, p_82246_3_);
	}

	public boolean superIsCurrentToolAdventureModeExempt(int p_82246_1_, int p_82246_2_, int p_82246_3_) {
		return super.isCurrentToolAdventureModeExempt(p_82246_1_, p_82246_2_, p_82246_3_);
	}

	@Override
	public boolean canPlayerEdit(int p_82247_1_, int p_82247_2_, int p_82247_3_, int p_82247_4_, ItemStack itemStack) {
		return master != null ? master.canPlayerEdit(p_82247_1_, p_82247_2_, p_82247_3_, p_82247_4_, itemStack) : super.canPlayerEdit(p_82247_1_, p_82247_2_, p_82247_3_, p_82247_4_, itemStack);
	}

	public boolean superCanPlayerEdit(int p_82247_1_, int p_82247_2_, int p_82247_3_, int p_82247_4_, Object itemStack) {
		return super.canPlayerEdit(p_82247_1_, p_82247_2_, p_82247_3_, p_82247_4_, (ItemStack) itemStack);
	}

	@Override
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return master != null ? master.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}

	public int superGetExperiencePoints(Object entityPlayer) {
		return super.getExperiencePoints((EntityPlayer) entityPlayer);
	}

	@Override
	protected boolean isPlayer() {
		return master != null ? master.isPlayer() : super.isPlayer();
	}

	public boolean superIsPlayer() {
		return super.isPlayer();
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}

	public boolean superGetAlwaysRenderNameTagForRender() {
		return super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public void clonePlayer(EntityPlayer entityPlayer, boolean p_71049_2_) {
		if (master != null) master.clonePlayer(entityPlayer, p_71049_2_);
		else super.clonePlayer(entityPlayer, p_71049_2_);
	}

	public void superClonePlayer(Object entityPlayer, boolean p_71049_2_) {
		super.clonePlayer((EntityPlayer) entityPlayer, p_71049_2_);
	}

	@Override
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}

	public boolean superCanTriggerWalking() {
		return super.canTriggerWalking();
	}

	@Override
	public void sendPlayerAbilities() {
		if (master != null) master.sendPlayerAbilities();
		else super.sendPlayerAbilities();
	}

	public void superSendPlayerAbilities() {
		super.sendPlayerAbilities();
	}

	@Override
	public void setGameType(GameType gameType) {
		if (master != null) master.setGameType(gameType);
		else super.setGameType(gameType);
	}

	public void superSetGameType(Object gameType) {
		super.setGameType((GameType) gameType);
	}

	@Override
	public String getCommandSenderName() {
		return master != null ? master.getCommandSenderName() : super.getCommandSenderName();
	}

	public String superGetCommandSenderName() {
		return super.getCommandSenderName();
	}

	@Override
	public World getEntityWorld() {
		return (World) (master != null ? master.getEntityWorld() : super.getEntityWorld());
	}

	public World superGetEntityWorld() {
		return super.getEntityWorld();
	}

	@Override
	public InventoryEnderChest getInventoryEnderChest() {
		return (InventoryEnderChest) (master != null ? master.getInventoryEnderChest() : super.getInventoryEnderChest());
	}

	public InventoryEnderChest superGetInventoryEnderChest() {
		return super.getInventoryEnderChest();
	}

	@Override
	public ItemStack getEquipmentInSlot(int p_71124_1_) {
		return (ItemStack) (master != null ? master.getEquipmentInSlot(p_71124_1_) : super.getEquipmentInSlot(p_71124_1_));
	}

	public ItemStack superGetEquipmentInSlot(int p_71124_1_) {
		return super.getEquipmentInSlot(p_71124_1_);
	}

	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}

	public ItemStack superGetHeldItem() {
		return super.getHeldItem();
	}

	@Override
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}

	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public ItemStack[] getLastActiveItems() {
		return (ItemStack[]) (master != null ? master.getLastActiveItems() : super.getLastActiveItems());
	}

	public ItemStack[] superGetLastActiveItems() {
		return super.getLastActiveItems();
	}

	@Override
	public boolean getHideCape() {
		return master != null ? master.getHideCape() : super.getHideCape();
	}

	public boolean superGetHideCape() {
		return super.getHideCape();
	}

	@Override
	public boolean isPushedByWater() {
		return master != null ? master.isPushedByWater() : super.isPushedByWater();
	}

	public boolean superIsPushedByWater() {
		return super.isPushedByWater();
	}

	@Override
	public Scoreboard getWorldScoreboard() {
		return (Scoreboard) (master != null ? master.getWorldScoreboard() : super.getWorldScoreboard());
	}

	public Scoreboard superGetWorldScoreboard() {
		return super.getWorldScoreboard();
	}

	@Override
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}

	public Team superGetTeam() {
		return super.getTeam();
	}

	@Override
	public IChatComponent func_145748_c_() {
		return (IChatComponent) (master != null ? master.func_145748_c_() : super.func_145748_c_());
	}

	public IChatComponent superFunc_145748_c_() {
		return super.func_145748_c_();
	}

	@Override
	public void setAbsorptionAmount(float p_110149_1_) {
		if (master != null) master.setAbsorptionAmount(p_110149_1_);
		else super.setAbsorptionAmount(p_110149_1_);
	}

	public void superSetAbsorptionAmount(float p_110149_1_) {
		super.setAbsorptionAmount(p_110149_1_);
	}

	@Override
	public float getAbsorptionAmount() {
		return master != null ? master.getAbsorptionAmount() : super.getAbsorptionAmount();
	}

	public float superGetAbsorptionAmount() {
		return super.getAbsorptionAmount();
	}

	@Override
	public void openGui(Object mod, int modGuiId, World world, int x, int y, int z) {
		if (master != null) master.openGui(mod, modGuiId, world, x, y, z);
		else super.openGui(mod, modGuiId, world, x, y, z);
	}

	public void superOpenGui(Object mod, int modGuiId, Object world, int x, int y, int z) {
		super.openGui(mod, modGuiId, (World) world, x, y, z);
	}

	@Override
	public Vec3 getPosition(float par1) {
		return (Vec3) (master != null ? master.getPosition(par1) : super.getPosition(par1));
	}

	public Vec3 superGetPosition(float par1) {
		return super.getPosition(par1);
	}

	@Override
	public ChunkCoordinates getBedLocation(int dimension) {
		return (ChunkCoordinates) (master != null ? master.getBedLocation(dimension) : super.getBedLocation(dimension));
	}

	public ChunkCoordinates superGetBedLocation(int dimension) {
		return super.getBedLocation(dimension);
	}

	@Override
	public boolean isSpawnForced(int dimension) {
		return master != null ? master.isSpawnForced(dimension) : super.isSpawnForced(dimension);
	}

	public boolean superIsSpawnForced(int dimension) {
		return super.isSpawnForced(dimension);
	}

	@Override
	public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean forced, int dimension) {
		if (master != null) master.setSpawnChunk(chunkCoordinates, forced, dimension);
		else super.setSpawnChunk(chunkCoordinates, forced, dimension);
	}

	public void superSetSpawnChunk(Object chunkCoordinates, boolean forced, int dimension) {
		super.setSpawnChunk((ChunkCoordinates) chunkCoordinates, forced, dimension);
	}

	@Override
	public String getDisplayName() {
		return (String) (master != null ? master.getDisplayName() : super.getDisplayName());
	}

	public String superGetDisplayName() {
		return super.getDisplayName();
	}

	@Override
	public void refreshDisplayName() {
		if (master != null) master.refreshDisplayName();
		else super.refreshDisplayName();
	}

	public void superRefreshDisplayName() {
		super.refreshDisplayName();
	}

	@Override
	protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
		if (master != null) master.updateFallState(p_70064_1_, p_70064_3_);
		else super.updateFallState(p_70064_1_, p_70064_3_);
	}

	public void superUpdateFallState(double p_70064_1_, boolean p_70064_3_) {
		super.updateFallState(p_70064_1_, p_70064_3_);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}

	public boolean superCanBreatheUnderwater() {
		return super.canBreatheUnderwater();
	}

	@Override
	public void onEntityUpdate() {
		if (master != null) master.onEntityUpdate();
		else super.onEntityUpdate();
	}

	public void superOnEntityUpdate() {
		super.onEntityUpdate();
	}

	@Override
	public boolean isChild() {
		return master != null ? master.isChild() : super.isChild();
	}

	public boolean superIsChild() {
		return super.isChild();
	}

	@Override
	protected void onDeathUpdate() {
		if (master != null) master.onDeathUpdate();
		else super.onDeathUpdate();
	}

	public void superOnDeathUpdate() {
		super.onDeathUpdate();
	}

	@Override
	protected boolean func_146066_aG() {
		return master != null ? master.func_146066_aG() : super.func_146066_aG();
	}

	public boolean superFunc_146066_aG() {
		return super.func_146066_aG();
	}

	@Override
	protected int decreaseAirSupply(int p_70682_1_) {
		return master != null ? master.decreaseAirSupply(p_70682_1_) : super.decreaseAirSupply(p_70682_1_);
	}

	public int superDecreaseAirSupply(int p_70682_1_) {
		return super.decreaseAirSupply(p_70682_1_);
	}

	@Override
	public Random getRNG() {
		return master != null ? master.getRNG() : super.getRNG();
	}

	public Random superGetRNG() {
		return super.getRNG();
	}

	@Override
	public EntityLivingBase getAITarget() {
		return (EntityLivingBase) (master != null ? master.getAITarget() : super.getAITarget());
	}

	public EntityLivingBase superGetAITarget() {
		return super.getAITarget();
	}

	@Override
	public int func_142015_aE() {
		return master != null ? master.func_142015_aE() : super.func_142015_aE();
	}

	public int superFunc_142015_aE() {
		return super.func_142015_aE();
	}

	@Override
	public void setRevengeTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setRevengeTarget(entityLivingBase);
		else super.setRevengeTarget(entityLivingBase);
	}

	public void superSetRevengeTarget(Object entityLivingBase) {
		super.setRevengeTarget((EntityLivingBase) entityLivingBase);
	}

	@Override
	public EntityLivingBase getLastAttacker() {
		return (EntityLivingBase) (master != null ? master.getLastAttacker() : super.getLastAttacker());
	}

	public EntityLivingBase superGetLastAttacker() {
		return super.getLastAttacker();
	}

	@Override
	public int getLastAttackerTime() {
		return master != null ? master.getLastAttackerTime() : super.getLastAttackerTime();
	}

	public int superGetLastAttackerTime() {
		return super.getLastAttackerTime();
	}

	@Override
	public void setLastAttacker(Entity entity) {
		if (master != null) master.setLastAttacker(entity);
		else super.setLastAttacker(entity);
	}

	public void superSetLastAttacker(Object entity) {
		super.setLastAttacker((Entity) entity);
	}

	@Override
	public int getAge() {
		return master != null ? master.getAge() : super.getAge();
	}

	public int superGetAge() {
		return super.getAge();
	}

	@Override
	protected void updatePotionEffects() {
		if (master != null) master.updatePotionEffects();
		else super.updatePotionEffects();
	}

	public void superUpdatePotionEffects() {
		super.updatePotionEffects();
	}

	@Override
	public void clearActivePotions() {
		if (master != null) master.clearActivePotions();
		else super.clearActivePotions();
	}

	public void superClearActivePotions() {
		super.clearActivePotions();
	}

	@Override
	public Collection getActivePotionEffects() {
		return (Collection) (master != null ? master.getActivePotionEffects() : super.getActivePotionEffects());
	}

	public Collection superGetActivePotionEffects() {
		return super.getActivePotionEffects();
	}

	@Override
	public boolean isPotionActive(int p_82165_1_) {
		return master != null ? master.isPotionActive(p_82165_1_) : super.isPotionActive(p_82165_1_);
	}

	public boolean superIsPotionActive(int p_82165_1_) {
		return super.isPotionActive(p_82165_1_);
	}

	@Override
	public boolean isPotionActive(Potion potion) {
		return master != null ? master.isPotionActive(potion) : super.isPotionActive(potion);
	}

	public boolean superIsPotionActive(Object potion) {
		return super.isPotionActive((Potion) potion);
	}

	@Override
	public PotionEffect getActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.getActivePotionEffect(potion) : super.getActivePotionEffect(potion));
	}

	public PotionEffect superGetActivePotionEffect(Object potion) {
		return super.getActivePotionEffect((Potion) potion);
	}

	@Override
	public void addPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.addPotionEffect(potionEffect);
		else super.addPotionEffect(potionEffect);
	}

	public void superAddPotionEffect(Object potionEffect) {
		super.addPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public boolean isPotionApplicable(PotionEffect potionEffect) {
		return master != null ? master.isPotionApplicable(potionEffect) : super.isPotionApplicable(potionEffect);
	}

	public boolean superIsPotionApplicable(Object potionEffect) {
		return super.isPotionApplicable((PotionEffect) potionEffect);
	}

	@Override
	public boolean isEntityUndead() {
		return master != null ? master.isEntityUndead() : super.isEntityUndead();
	}

	public boolean superIsEntityUndead() {
		return super.isEntityUndead();
	}

	@Override
	public void removePotionEffectClient(int p_70618_1_) {
		if (master != null) master.removePotionEffectClient(p_70618_1_);
		else super.removePotionEffectClient(p_70618_1_);
	}

	public void superRemovePotionEffectClient(int p_70618_1_) {
		super.removePotionEffectClient(p_70618_1_);
	}

	@Override
	public void removePotionEffect(int p_82170_1_) {
		if (master != null) master.removePotionEffect(p_82170_1_);
		else super.removePotionEffect(p_82170_1_);
	}

	public void superRemovePotionEffect(int p_82170_1_) {
		super.removePotionEffect(p_82170_1_);
	}

	@Override
	protected void onNewPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onNewPotionEffect(potionEffect);
		else super.onNewPotionEffect(potionEffect);
	}

	public void superOnNewPotionEffect(Object potionEffect) {
		super.onNewPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	protected void onChangedPotionEffect(PotionEffect potionEffect, boolean p_70695_2_) {
		if (master != null) master.onChangedPotionEffect(potionEffect, p_70695_2_);
		else super.onChangedPotionEffect(potionEffect, p_70695_2_);
	}

	public void superOnChangedPotionEffect(Object potionEffect, boolean p_70695_2_) {
		super.onChangedPotionEffect((PotionEffect) potionEffect, p_70695_2_);
	}

	@Override
	protected void onFinishedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onFinishedPotionEffect(potionEffect);
		else super.onFinishedPotionEffect(potionEffect);
	}

	public void superOnFinishedPotionEffect(Object potionEffect) {
		super.onFinishedPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public void heal(float p_70691_1_) {
		if (master != null) master.heal(p_70691_1_);
		else super.heal(p_70691_1_);
	}

	public void superHeal(float p_70691_1_) {
		super.heal(p_70691_1_);
	}

	@Override
	public void setHealth(float p_70606_1_) {
		if (master != null) master.setHealth(p_70606_1_);
		else super.setHealth(p_70606_1_);
	}

	public void superSetHealth(float p_70606_1_) {
		super.setHealth(p_70606_1_);
	}

	@Override
	public void renderBrokenItemStack(ItemStack itemStack) {
		if (master != null) master.renderBrokenItemStack(itemStack);
		else super.renderBrokenItemStack(itemStack);
	}

	public void superRenderBrokenItemStack(Object itemStack) {
		super.renderBrokenItemStack((ItemStack) itemStack);
	}

	@Override
	protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {
		if (master != null) master.dropEquipment(p_82160_1_, p_82160_2_);
		else super.dropEquipment(p_82160_1_, p_82160_2_);
	}

	public void superDropEquipment(boolean p_82160_1_, int p_82160_2_) {
		super.dropEquipment(p_82160_1_, p_82160_2_);
	}

	@Override
	public void knockBack(Entity entity, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
		if (master != null) master.knockBack(entity, p_70653_2_, p_70653_3_, p_70653_5_);
		else super.knockBack(entity, p_70653_2_, p_70653_3_, p_70653_5_);
	}

	public void superKnockBack(Object entity, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
		super.knockBack((Entity) entity, p_70653_2_, p_70653_3_, p_70653_5_);
	}

	@Override
	protected void dropRareDrop(int p_70600_1_) {
		if (master != null) master.dropRareDrop(p_70600_1_);
		else super.dropRareDrop(p_70600_1_);
	}

	public void superDropRareDrop(int p_70600_1_) {
		super.dropRareDrop(p_70600_1_);
	}

	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		if (master != null) master.dropFewItems(p_70628_1_, p_70628_2_);
		else super.dropFewItems(p_70628_1_, p_70628_2_);
	}

	public void superDropFewItems(boolean p_70628_1_, int p_70628_2_) {
		super.dropFewItems(p_70628_1_, p_70628_2_);
	}

	@Override
	public boolean isOnLadder() {
		return master != null ? master.isOnLadder() : super.isOnLadder();
	}

	public boolean superIsOnLadder() {
		return super.isOnLadder();
	}

	@Override
	public boolean isEntityAlive() {
		return master != null ? master.isEntityAlive() : super.isEntityAlive();
	}

	public boolean superIsEntityAlive() {
		return super.isEntityAlive();
	}

	@Override
	public void performHurtAnimation() {
		if (master != null) master.performHurtAnimation();
		else super.performHurtAnimation();
	}

	public void superPerformHurtAnimation() {
		super.performHurtAnimation();
	}

	@Override
	protected float applyArmorCalculations(DamageSource damageSource, float p_70655_2_) {
		return master != null ? master.applyArmorCalculations(damageSource, p_70655_2_) : super.applyArmorCalculations(damageSource, p_70655_2_);
	}

	public float superApplyArmorCalculations(Object damageSource, float p_70655_2_) {
		return super.applyArmorCalculations((DamageSource) damageSource, p_70655_2_);
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float p_70672_2_) {
		return master != null ? master.applyPotionDamageCalculations(damageSource, p_70672_2_) : super.applyPotionDamageCalculations(damageSource, p_70672_2_);
	}

	public float superApplyPotionDamageCalculations(Object damageSource, float p_70672_2_) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, p_70672_2_);
	}

	@Override
	public CombatTracker func_110142_aN() {
		return (CombatTracker) (master != null ? master.func_110142_aN() : super.func_110142_aN());
	}

	public CombatTracker superFunc_110142_aN() {
		return super.func_110142_aN();
	}

	@Override
	public EntityLivingBase func_94060_bK() {
		return (EntityLivingBase) (master != null ? master.func_94060_bK() : super.func_94060_bK());
	}

	public EntityLivingBase superFunc_94060_bK() {
		return super.func_94060_bK();
	}

	@Override
	public void swingItem() {
		if (master != null) master.swingItem();
		else super.swingItem();
	}

	public void superSwingItem() {
		super.swingItem();
	}

	@Override
	protected void kill() {
		if (master != null) master.kill();
		else super.kill();
	}

	public void superKill() {
		super.kill();
	}

	@Override
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}

	public void superUpdateArmSwingProgress() {
		super.updateArmSwingProgress();
	}

	@Override
	public IAttributeInstance getEntityAttribute(IAttribute iAttribute) {
		return (IAttributeInstance) (master != null ? master.getEntityAttribute(iAttribute) : super.getEntityAttribute(iAttribute));
	}

	public IAttributeInstance superGetEntityAttribute(Object iAttribute) {
		return super.getEntityAttribute((IAttribute) iAttribute);
	}

	@Override
	public BaseAttributeMap getAttributeMap() {
		return (BaseAttributeMap) (master != null ? master.getAttributeMap() : super.getAttributeMap());
	}

	public BaseAttributeMap superGetAttributeMap() {
		return super.getAttributeMap();
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return (EnumCreatureAttribute) (master != null ? master.getCreatureAttribute() : super.getCreatureAttribute());
	}

	public EnumCreatureAttribute superGetCreatureAttribute() {
		return super.getCreatureAttribute();
	}

	@Override
	public void setSprinting(boolean p_70031_1_) {
		if (master != null) master.setSprinting(p_70031_1_);
		else super.setSprinting(p_70031_1_);
	}

	public void superSetSprinting(boolean p_70031_1_) {
		super.setSprinting(p_70031_1_);
	}

	@Override
	protected float getSoundVolume() {
		return master != null ? master.getSoundVolume() : super.getSoundVolume();
	}

	public float superGetSoundVolume() {
		return super.getSoundVolume();
	}

	@Override
	protected float getSoundPitch() {
		return master != null ? master.getSoundPitch() : super.getSoundPitch();
	}

	public float superGetSoundPitch() {
		return super.getSoundPitch();
	}

	@Override
	public void setPositionAndUpdate(double p_70634_1_, double p_70634_3_, double p_70634_5_) {
		if (master != null) master.setPositionAndUpdate(p_70634_1_, p_70634_3_, p_70634_5_);
		else super.setPositionAndUpdate(p_70634_1_, p_70634_3_, p_70634_5_);
	}

	public void superSetPositionAndUpdate(double p_70634_1_, double p_70634_3_, double p_70634_5_) {
		super.setPositionAndUpdate(p_70634_1_, p_70634_3_, p_70634_5_);
	}

	@Override
	public void dismountEntity(Entity entity) {
		if (master != null) master.dismountEntity(entity);
		else super.dismountEntity(entity);
	}

	public void superDismountEntity(Object entity) {
		super.dismountEntity((Entity) entity);
	}

	@Override
	protected boolean isAIEnabled() {
		return master != null ? master.isAIEnabled() : super.isAIEnabled();
	}

	public boolean superIsAIEnabled() {
		return super.isAIEnabled();
	}

	@Override
	public void setAIMoveSpeed(float p_70659_1_) {
		if (master != null) master.setAIMoveSpeed(p_70659_1_);
		else super.setAIMoveSpeed(p_70659_1_);
	}

	public void superSetAIMoveSpeed(float p_70659_1_) {
		super.setAIMoveSpeed(p_70659_1_);
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return master != null ? master.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}

	public boolean superAttackEntityAsMob(Object entity) {
		return super.attackEntityAsMob((Entity) entity);
	}

	@Override
	protected float func_110146_f(float p_110146_1_, float p_110146_2_) {
		return master != null ? master.func_110146_f(p_110146_1_, p_110146_2_) : super.func_110146_f(p_110146_1_, p_110146_2_);
	}

	public float superFunc_110146_f(float p_110146_1_, float p_110146_2_) {
		return super.func_110146_f(p_110146_1_, p_110146_2_);
	}

	@Override
	protected void updateAITasks() {
		if (master != null) master.updateAITasks();
		else super.updateAITasks();
	}

	public void superUpdateAITasks() {
		super.updateAITasks();
	}

	@Override
	protected void collideWithNearbyEntities() {
		if (master != null) master.collideWithNearbyEntities();
		else super.collideWithNearbyEntities();
	}

	public void superCollideWithNearbyEntities() {
		super.collideWithNearbyEntities();
	}

	@Override
	protected void collideWithEntity(Entity entity) {
		if (master != null) master.collideWithEntity(entity);
		else super.collideWithEntity(entity);
	}

	public void superCollideWithEntity(Object entity) {
		super.collideWithEntity((Entity) entity);
	}

	@Override
	protected void updateAITick() {
		if (master != null) master.updateAITick();
		else super.updateAITick();
	}

	public void superUpdateAITick() {
		super.updateAITick();
	}

	@Override
	public void setJumping(boolean p_70637_1_) {
		if (master != null) master.setJumping(p_70637_1_);
		else super.setJumping(p_70637_1_);
	}

	public void superSetJumping(boolean p_70637_1_) {
		super.setJumping(p_70637_1_);
	}

	@Override
	public void onItemPickup(Entity entity, int p_71001_2_) {
		if (master != null) master.onItemPickup(entity, p_71001_2_);
		else super.onItemPickup(entity, p_71001_2_);
	}

	public void superOnItemPickup(Object entity, int p_71001_2_) {
		super.onItemPickup((Entity) entity, p_71001_2_);
	}

	@Override
	public boolean canEntityBeSeen(Entity entity) {
		return master != null ? master.canEntityBeSeen(entity) : super.canEntityBeSeen(entity);
	}

	public boolean superCanEntityBeSeen(Object entity) {
		return super.canEntityBeSeen((Entity) entity);
	}

	@Override
	public Vec3 getLookVec() {
		return (Vec3) (master != null ? master.getLookVec() : super.getLookVec());
	}

	public Vec3 superGetLookVec() {
		return super.getLookVec();
	}

	@Override
	public Vec3 getLook(float p_70676_1_) {
		return (Vec3) (master != null ? master.getLook(p_70676_1_) : super.getLook(p_70676_1_));
	}

	public Vec3 superGetLook(float p_70676_1_) {
		return super.getLook(p_70676_1_);
	}

	@Override
	public float getSwingProgress(float p_70678_1_) {
		return master != null ? master.getSwingProgress(p_70678_1_) : super.getSwingProgress(p_70678_1_);
	}

	public float superGetSwingProgress(float p_70678_1_) {
		return super.getSwingProgress(p_70678_1_);
	}

	@Override
	public MovingObjectPosition rayTrace(double p_70614_1_, float p_70614_3_) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(p_70614_1_, p_70614_3_) : super.rayTrace(p_70614_1_, p_70614_3_));
	}

	public MovingObjectPosition superRayTrace(double p_70614_1_, float p_70614_3_) {
		return super.rayTrace(p_70614_1_, p_70614_3_);
	}

	@Override
	public boolean isClientWorld() {
		return master != null ? master.isClientWorld() : super.isClientWorld();
	}

	public boolean superIsClientWorld() {
		return super.isClientWorld();
	}

	@Override
	public boolean canBeCollidedWith() {
		return master != null ? master.canBeCollidedWith() : super.canBeCollidedWith();
	}

	public boolean superCanBeCollidedWith() {
		return super.canBeCollidedWith();
	}

	@Override
	public boolean canBePushed() {
		return master != null ? master.canBePushed() : super.canBePushed();
	}

	public boolean superCanBePushed() {
		return super.canBePushed();
	}

	@Override
	protected void setBeenAttacked() {
		if (master != null) master.setBeenAttacked();
		else super.setBeenAttacked();
	}

	public void superSetBeenAttacked() {
		super.setBeenAttacked();
	}

	@Override
	public float getRotationYawHead() {
		return master != null ? master.getRotationYawHead() : super.getRotationYawHead();
	}

	public float superGetRotationYawHead() {
		return super.getRotationYawHead();
	}

	@Override
	public void setRotationYawHead(float p_70034_1_) {
		if (master != null) master.setRotationYawHead(p_70034_1_);
		else super.setRotationYawHead(p_70034_1_);
	}

	public void superSetRotationYawHead(float p_70034_1_) {
		super.setRotationYawHead(p_70034_1_);
	}

	@Override
	public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOnSameTeam(entityLivingBase) : super.isOnSameTeam(entityLivingBase);
	}

	public boolean superIsOnSameTeam(Object entityLivingBase) {
		return super.isOnSameTeam((EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean isOnTeam(Team team) {
		return master != null ? master.isOnTeam(team) : super.isOnTeam(team);
	}

	public boolean superIsOnTeam(Object team) {
		return super.isOnTeam((Team) team);
	}

	@Override
	public void curePotionEffects(ItemStack itemStack) {
		if (master != null) master.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}

	public void superCurePotionEffects(Object itemStack) {
		super.curePotionEffects((ItemStack) itemStack);
	}

	@Override
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return master != null ? master.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}

	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}

	@Override
	public int getEntityId() {
		return master != null ? master.getEntityId() : super.getEntityId();
	}

	public int superGetEntityId() {
		return super.getEntityId();
	}

	@Override
	public void setEntityId(int p_145769_1_) {
		if (master != null) master.setEntityId(p_145769_1_);
		else super.setEntityId(p_145769_1_);
	}

	public void superSetEntityId(int p_145769_1_) {
		super.setEntityId(p_145769_1_);
	}

	@Override
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataWatcher() : super.getDataWatcher());
	}

	public DataWatcher superGetDataWatcher() {
		return super.getDataWatcher();
	}

	@Override
	public boolean equals(Object p_equals_1_) {
		return master != null ? master.equals(p_equals_1_) : super.equals(p_equals_1_);
	}

	public boolean superEquals(Object p_equals_1_) {
		return super.equals(p_equals_1_);
	}

	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}

	public int superHashCode() {
		return super.hashCode();
	}

	@Override
	protected void setSize(float p_70105_1_, float p_70105_2_) {
		if (master != null) master.setSize(p_70105_1_, p_70105_2_);
		else super.setSize(p_70105_1_, p_70105_2_);
	}

	public void superSetSize(float p_70105_1_, float p_70105_2_) {
		super.setSize(p_70105_1_, p_70105_2_);
	}

	@Override
	protected void setRotation(float p_70101_1_, float p_70101_2_) {
		if (master != null) master.setRotation(p_70101_1_, p_70101_2_);
		else super.setRotation(p_70101_1_, p_70101_2_);
	}

	public void superSetRotation(float p_70101_1_, float p_70101_2_) {
		super.setRotation(p_70101_1_, p_70101_2_);
	}

	@Override
	public void setPosition(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
		if (master != null) master.setPosition(p_70107_1_, p_70107_3_, p_70107_5_);
		else super.setPosition(p_70107_1_, p_70107_3_, p_70107_5_);
	}

	public void superSetPosition(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
		super.setPosition(p_70107_1_, p_70107_3_, p_70107_5_);
	}

	@Override
	public void setAngles(float p_70082_1_, float p_70082_2_) {
		if (master != null) master.setAngles(p_70082_1_, p_70082_2_);
		else super.setAngles(p_70082_1_, p_70082_2_);
	}

	public void superSetAngles(float p_70082_1_, float p_70082_2_) {
		super.setAngles(p_70082_1_, p_70082_2_);
	}

	@Override
	protected void setOnFireFromLava() {
		if (master != null) master.setOnFireFromLava();
		else super.setOnFireFromLava();
	}

	public void superSetOnFireFromLava() {
		super.setOnFireFromLava();
	}

	@Override
	public void setFire(int p_70015_1_) {
		if (master != null) master.setFire(p_70015_1_);
		else super.setFire(p_70015_1_);
	}

	public void superSetFire(int p_70015_1_) {
		super.setFire(p_70015_1_);
	}

	@Override
	public void extinguish() {
		if (master != null) master.extinguish();
		else super.extinguish();
	}

	public void superExtinguish() {
		super.extinguish();
	}

	@Override
	public boolean isOffsetPositionInLiquid(double p_70038_1_, double p_70038_3_, double p_70038_5_) {
		return master != null ? master.isOffsetPositionInLiquid(p_70038_1_, p_70038_3_, p_70038_5_) : super.isOffsetPositionInLiquid(p_70038_1_, p_70038_3_, p_70038_5_);
	}

	public boolean superIsOffsetPositionInLiquid(double p_70038_1_, double p_70038_3_, double p_70038_5_) {
		return super.isOffsetPositionInLiquid(p_70038_1_, p_70038_3_, p_70038_5_);
	}

	@Override
	public void moveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		if (master != null) master.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);
		else super.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);
	}

	public void superMoveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		super.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	protected void func_145775_I() {
		if (master != null) master.func_145775_I();
		else super.func_145775_I();
	}

	public void superFunc_145775_I() {
		super.func_145775_I();
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block block) {
		if (master != null) master.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, block);
		else super.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, block);
	}

	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
		super.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, (Block) block);
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getBoundingBox() : super.getBoundingBox());
	}

	public AxisAlignedBB superGetBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	protected void dealFireDamage(int p_70081_1_) {
		if (master != null) master.dealFireDamage(p_70081_1_);
		else super.dealFireDamage(p_70081_1_);
	}

	public void superDealFireDamage(int p_70081_1_) {
		super.dealFireDamage(p_70081_1_);
	}

	@Override
	public boolean isWet() {
		return master != null ? master.isWet() : super.isWet();
	}

	public boolean superIsWet() {
		return super.isWet();
	}

	@Override
	public boolean isInWater() {
		return master != null ? master.isInWater() : super.isInWater();
	}

	public boolean superIsInWater() {
		return super.isInWater();
	}

	@Override
	public boolean handleWaterMovement() {
		return master != null ? master.handleWaterMovement() : super.handleWaterMovement();
	}

	public boolean superHandleWaterMovement() {
		return super.handleWaterMovement();
	}

	@Override
	public boolean isInsideOfMaterial(Material material) {
		return master != null ? master.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}

	public boolean superIsInsideOfMaterial(Object material) {
		return super.isInsideOfMaterial((Material) material);
	}

	@Override
	public boolean handleLavaMovement() {
		return master != null ? master.handleLavaMovement() : super.handleLavaMovement();
	}

	public boolean superHandleLavaMovement() {
		return super.handleLavaMovement();
	}

	@Override
	public void moveFlying(float p_70060_1_, float p_70060_2_, float p_70060_3_) {
		if (master != null) master.moveFlying(p_70060_1_, p_70060_2_, p_70060_3_);
		else super.moveFlying(p_70060_1_, p_70060_2_, p_70060_3_);
	}

	public void superMoveFlying(float p_70060_1_, float p_70060_2_, float p_70060_3_) {
		super.moveFlying(p_70060_1_, p_70060_2_, p_70060_3_);
	}

	@Override
	public int getBrightnessForRender(float p_70070_1_) {
		return master != null ? master.getBrightnessForRender(p_70070_1_) : super.getBrightnessForRender(p_70070_1_);
	}

	public int superGetBrightnessForRender(float p_70070_1_) {
		return super.getBrightnessForRender(p_70070_1_);
	}

	@Override
	public float getBrightness(float p_70013_1_) {
		return master != null ? master.getBrightness(p_70013_1_) : super.getBrightness(p_70013_1_);
	}

	public float superGetBrightness(float p_70013_1_) {
		return super.getBrightness(p_70013_1_);
	}

	@Override
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}

	public void superSetWorld(Object world) {
		super.setWorld((World) world);
	}

	@Override
	public void setPositionAndRotation(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, float p_70080_8_) {
		if (master != null) master.setPositionAndRotation(p_70080_1_, p_70080_3_, p_70080_5_, p_70080_7_, p_70080_8_);
		else super.setPositionAndRotation(p_70080_1_, p_70080_3_, p_70080_5_, p_70080_7_, p_70080_8_);
	}

	public void superSetPositionAndRotation(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, float p_70080_8_) {
		super.setPositionAndRotation(p_70080_1_, p_70080_3_, p_70080_5_, p_70080_7_, p_70080_8_);
	}

	@Override
	public void setLocationAndAngles(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
		if (master != null) master.setLocationAndAngles(p_70012_1_, p_70012_3_, p_70012_5_, p_70012_7_, p_70012_8_);
		else super.setLocationAndAngles(p_70012_1_, p_70012_3_, p_70012_5_, p_70012_7_, p_70012_8_);
	}

	public void superSetLocationAndAngles(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
		super.setLocationAndAngles(p_70012_1_, p_70012_3_, p_70012_5_, p_70012_7_, p_70012_8_);
	}

	@Override
	public float getDistanceToEntity(Entity entity) {
		return master != null ? master.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}

	public float superGetDistanceToEntity(Object entity) {
		return super.getDistanceToEntity((Entity) entity);
	}

	@Override
	public double getDistanceSq(double p_70092_1_, double p_70092_3_, double p_70092_5_) {
		return master != null ? master.getDistanceSq(p_70092_1_, p_70092_3_, p_70092_5_) : super.getDistanceSq(p_70092_1_, p_70092_3_, p_70092_5_);
	}

	public double superGetDistanceSq(double p_70092_1_, double p_70092_3_, double p_70092_5_) {
		return super.getDistanceSq(p_70092_1_, p_70092_3_, p_70092_5_);
	}

	@Override
	public double getDistance(double p_70011_1_, double p_70011_3_, double p_70011_5_) {
		return master != null ? master.getDistance(p_70011_1_, p_70011_3_, p_70011_5_) : super.getDistance(p_70011_1_, p_70011_3_, p_70011_5_);
	}

	public double superGetDistance(double p_70011_1_, double p_70011_3_, double p_70011_5_) {
		return super.getDistance(p_70011_1_, p_70011_3_, p_70011_5_);
	}

	@Override
	public double getDistanceSqToEntity(Entity entity) {
		return master != null ? master.getDistanceSqToEntity(entity) : super.getDistanceSqToEntity(entity);
	}

	public double superGetDistanceSqToEntity(Object entity) {
		return super.getDistanceSqToEntity((Entity) entity);
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
		if (master != null) master.onCollideWithPlayer(entityPlayer);
		else super.onCollideWithPlayer(entityPlayer);
	}

	public void superOnCollideWithPlayer(Object entityPlayer) {
		super.onCollideWithPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		if (master != null) master.applyEntityCollision(entity);
		else super.applyEntityCollision(entity);
	}

	public void superApplyEntityCollision(Object entity) {
		super.applyEntityCollision((Entity) entity);
	}

	@Override
	public void addVelocity(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
		if (master != null) master.addVelocity(p_70024_1_, p_70024_3_, p_70024_5_);
		else super.addVelocity(p_70024_1_, p_70024_3_, p_70024_5_);
	}

	public void superAddVelocity(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
		super.addVelocity(p_70024_1_, p_70024_3_, p_70024_5_);
	}

	@Override
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return master != null ? master.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_) : super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	@Override
	public boolean isInRangeToRenderDist(double p_70112_1_) {
		return master != null ? master.isInRangeToRenderDist(p_70112_1_) : super.isInRangeToRenderDist(p_70112_1_);
	}

	public boolean superIsInRangeToRenderDist(double p_70112_1_) {
		return super.isInRangeToRenderDist(p_70112_1_);
	}

	@Override
	public boolean writeMountToNBT(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeMountToNBT(nBTTagCompound) : super.writeMountToNBT(nBTTagCompound);
	}

	public boolean superWriteMountToNBT(Object nBTTagCompound) {
		return super.writeMountToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTOptional(nBTTagCompound) : super.writeToNBTOptional(nBTTagCompound);
	}

	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return super.writeToNBTOptional((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}

	public void superWriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}

	public void superReadFromNBT(Object nBTTagCompound) {
		super.readFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected boolean shouldSetPosAfterLoading() {
		return master != null ? master.shouldSetPosAfterLoading() : super.shouldSetPosAfterLoading();
	}

	public boolean superShouldSetPosAfterLoading() {
		return super.shouldSetPosAfterLoading();
	}

	@Override
	public void onChunkLoad() {
		if (master != null) master.onChunkLoad();
		else super.onChunkLoad();
	}

	public void superOnChunkLoad() {
		super.onChunkLoad();
	}

	@Override
	protected NBTTagList newDoubleNBTList(double... p_70087_1_) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(p_70087_1_) : super.newDoubleNBTList(p_70087_1_));
	}

	public NBTTagList superNewDoubleNBTList(double... p_70087_1_) {
		return super.newDoubleNBTList(p_70087_1_);
	}

	@Override
	protected NBTTagList newFloatNBTList(float... p_70049_1_) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(p_70049_1_) : super.newFloatNBTList(p_70049_1_));
	}

	public NBTTagList superNewFloatNBTList(float... p_70049_1_) {
		return super.newFloatNBTList(p_70049_1_);
	}

	@Override
	public EntityItem dropItem(Item item, int p_145779_2_) {
		return (EntityItem) (master != null ? master.dropItem(item, p_145779_2_) : super.dropItem(item, p_145779_2_));
	}

	public EntityItem superDropItem(Object item, int p_145779_2_) {
		return super.dropItem((Item) item, p_145779_2_);
	}

	@Override
	public EntityItem func_145778_a(Item item, int p_145778_2_, float p_145778_3_) {
		return (EntityItem) (master != null ? master.func_145778_a(item, p_145778_2_, p_145778_3_) : super.func_145778_a(item, p_145778_2_, p_145778_3_));
	}

	public EntityItem superFunc_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return super.func_145778_a((Item) item, p_145778_2_, p_145778_3_);
	}

	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float p_70099_2_) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, p_70099_2_) : super.entityDropItem(itemStack, p_70099_2_));
	}

	public EntityItem superEntityDropItem(Object itemStack, float p_70099_2_) {
		return super.entityDropItem((ItemStack) itemStack, p_70099_2_);
	}

	@Override
	public boolean interactFirst(EntityPlayer entityPlayer) {
		return master != null ? master.interactFirst(entityPlayer) : super.interactFirst(entityPlayer);
	}

	public boolean superInteractFirst(Object entityPlayer) {
		return super.interactFirst((EntityPlayer) entityPlayer);
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBox(entity) : super.getCollisionBox(entity));
	}

	public AxisAlignedBB superGetCollisionBox(Object entity) {
		return super.getCollisionBox((Entity) entity);
	}

	@Override
	public void updateRiderPosition() {
		if (master != null) master.updateRiderPosition();
		else super.updateRiderPosition();
	}

	public void superUpdateRiderPosition() {
		super.updateRiderPosition();
	}

	@Override
	public double getMountedYOffset() {
		return master != null ? master.getMountedYOffset() : super.getMountedYOffset();
	}

	public double superGetMountedYOffset() {
		return super.getMountedYOffset();
	}

	@Override
	public float getCollisionBorderSize() {
		return master != null ? master.getCollisionBorderSize() : super.getCollisionBorderSize();
	}

	public float superGetCollisionBorderSize() {
		return super.getCollisionBorderSize();
	}

	@Override
	public void setInPortal() {
		if (master != null) master.setInPortal();
		else super.setInPortal();
	}

	public void superSetInPortal() {
		super.setInPortal();
	}

	@Override
	public void setVelocity(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
		if (master != null) master.setVelocity(p_70016_1_, p_70016_3_, p_70016_5_);
		else super.setVelocity(p_70016_1_, p_70016_3_, p_70016_5_);
	}

	public void superSetVelocity(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
		super.setVelocity(p_70016_1_, p_70016_3_, p_70016_5_);
	}

	@Override
	public boolean isBurning() {
		return master != null ? master.isBurning() : super.isBurning();
	}

	public boolean superIsBurning() {
		return super.isBurning();
	}

	@Override
	public boolean isRiding() {
		return master != null ? master.isRiding() : super.isRiding();
	}

	public boolean superIsRiding() {
		return super.isRiding();
	}

	@Override
	public boolean isSneaking() {
		return master != null ? master.isSneaking() : super.isSneaking();
	}

	public boolean superIsSneaking() {
		return super.isSneaking();
	}

	@Override
	public void setSneaking(boolean p_70095_1_) {
		if (master != null) master.setSneaking(p_70095_1_);
		else super.setSneaking(p_70095_1_);
	}

	public void superSetSneaking(boolean p_70095_1_) {
		super.setSneaking(p_70095_1_);
	}

	@Override
	public boolean isSprinting() {
		return master != null ? master.isSprinting() : super.isSprinting();
	}

	public boolean superIsSprinting() {
		return super.isSprinting();
	}

	@Override
	public boolean isInvisible() {
		return master != null ? master.isInvisible() : super.isInvisible();
	}

	public boolean superIsInvisible() {
		return super.isInvisible();
	}

	@Override
	public void setInvisible(boolean p_82142_1_) {
		if (master != null) master.setInvisible(p_82142_1_);
		else super.setInvisible(p_82142_1_);
	}

	public void superSetInvisible(boolean p_82142_1_) {
		super.setInvisible(p_82142_1_);
	}

	@Override
	public boolean isEating() {
		return master != null ? master.isEating() : super.isEating();
	}

	public boolean superIsEating() {
		return super.isEating();
	}

	@Override
	public void setEating(boolean p_70019_1_) {
		if (master != null) master.setEating(p_70019_1_);
		else super.setEating(p_70019_1_);
	}

	public void superSetEating(boolean p_70019_1_) {
		super.setEating(p_70019_1_);
	}

	@Override
	protected boolean getFlag(int p_70083_1_) {
		return master != null ? master.getFlag(p_70083_1_) : super.getFlag(p_70083_1_);
	}

	public boolean superGetFlag(int p_70083_1_) {
		return super.getFlag(p_70083_1_);
	}

	@Override
	protected void setFlag(int p_70052_1_, boolean p_70052_2_) {
		if (master != null) master.setFlag(p_70052_1_, p_70052_2_);
		else super.setFlag(p_70052_1_, p_70052_2_);
	}

	public void superSetFlag(int p_70052_1_, boolean p_70052_2_) {
		super.setFlag(p_70052_1_, p_70052_2_);
	}

	@Override
	public int getAir() {
		return master != null ? master.getAir() : super.getAir();
	}

	public int superGetAir() {
		return super.getAir();
	}

	@Override
	public void setAir(int p_70050_1_) {
		if (master != null) master.setAir(p_70050_1_);
		else super.setAir(p_70050_1_);
	}

	public void superSetAir(int p_70050_1_) {
		super.setAir(p_70050_1_);
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		if (master != null) master.onStruckByLightning(entityLightningBolt);
		else super.onStruckByLightning(entityLightningBolt);
	}

	public void superOnStruckByLightning(Object entityLightningBolt) {
		super.onStruckByLightning((EntityLightningBolt) entityLightningBolt);
	}

	@Override
	protected boolean func_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return master != null ? master.func_145771_j(p_145771_1_, p_145771_3_, p_145771_5_) : super.func_145771_j(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	public boolean superFunc_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return super.func_145771_j(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	@Override
	public Entity[] getParts() {
		return (Entity[]) (master != null ? master.getParts() : super.getParts());
	}

	public Entity[] superGetParts() {
		return super.getParts();
	}

	@Override
	public boolean isEntityEqual(Entity entity) {
		return master != null ? master.isEntityEqual(entity) : super.isEntityEqual(entity);
	}

	public boolean superIsEntityEqual(Object entity) {
		return super.isEntityEqual((Entity) entity);
	}

	@Override
	public boolean canAttackWithItem() {
		return master != null ? master.canAttackWithItem() : super.canAttackWithItem();
	}

	public boolean superCanAttackWithItem() {
		return super.canAttackWithItem();
	}

	@Override
	public boolean hitByEntity(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.hitByEntity(entity);
	}

	public boolean superHitByEntity(Object entity) {
		return super.hitByEntity((Entity) entity);
	}

	@Override
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}

	public String superToString() {
		return super.toString();
	}

	@Override
	public boolean isEntityInvulnerable() {
		return master != null ? master.isEntityInvulnerable() : super.isEntityInvulnerable();
	}

	public boolean superIsEntityInvulnerable() {
		return super.isEntityInvulnerable();
	}

	@Override
	public void copyLocationAndAnglesFrom(Entity entity) {
		if (master != null) master.copyLocationAndAnglesFrom(entity);
		else super.copyLocationAndAnglesFrom(entity);
	}

	public void superCopyLocationAndAnglesFrom(Object entity) {
		super.copyLocationAndAnglesFrom((Entity) entity);
	}

	@Override
	public void copyDataFrom(Entity entity, boolean p_82141_2_) {
		if (master != null) master.copyDataFrom(entity, p_82141_2_);
		else super.copyDataFrom(entity, p_82141_2_);
	}

	public void superCopyDataFrom(Object entity, boolean p_82141_2_) {
		super.copyDataFrom((Entity) entity, p_82141_2_);
	}

	@Override
	public void travelToDimension(int p_71027_1_) {
		if (master != null) master.travelToDimension(p_71027_1_);
		else super.travelToDimension(p_71027_1_);
	}

	public void superTravelToDimension(int p_71027_1_) {
		super.travelToDimension(p_71027_1_);
	}

	@Override
	public float func_145772_a(Explosion explosion, World world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block block) {
		return master != null ? master.func_145772_a(explosion, world, p_145772_3_, p_145772_4_, p_145772_5_, block) : super.func_145772_a(explosion, world, p_145772_3_, p_145772_4_, p_145772_5_, block);
	}

	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return super.func_145772_a((Explosion) explosion, (World) world, p_145772_3_, p_145772_4_, p_145772_5_, (Block) block);
	}

	@Override
	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return master != null ? master.func_145774_a(explosion, world, p_145774_3_, p_145774_4_, p_145774_5_, block, p_145774_7_) : super.func_145774_a(explosion, world, p_145774_3_, p_145774_4_, p_145774_5_, block, p_145774_7_);
	}

	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return super.func_145774_a((Explosion) explosion, (World) world, p_145774_3_, p_145774_4_, p_145774_5_, (Block) block, p_145774_7_);
	}

	@Override
	public int getMaxSafePointTries() {
		return master != null ? master.getMaxSafePointTries() : super.getMaxSafePointTries();
	}

	public int superGetMaxSafePointTries() {
		return super.getMaxSafePointTries();
	}

	@Override
	public int getTeleportDirection() {
		return master != null ? master.getTeleportDirection() : super.getTeleportDirection();
	}

	public int superGetTeleportDirection() {
		return super.getTeleportDirection();
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return master != null ? master.doesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}

	public boolean superDoesEntityNotTriggerPressurePlate() {
		return super.doesEntityNotTriggerPressurePlate();
	}

	@Override
	public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
		if (master != null) master.addEntityCrashInfo(crashReportCategory);
		else super.addEntityCrashInfo(crashReportCategory);
	}

	public void superAddEntityCrashInfo(Object crashReportCategory) {
		super.addEntityCrashInfo((CrashReportCategory) crashReportCategory);
	}

	@Override
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}

	public boolean superCanRenderOnFire() {
		return super.canRenderOnFire();
	}

	@Override
	public UUID getUniqueID() {
		return master != null ? master.getUniqueID() : super.getUniqueID();
	}

	public UUID superGetUniqueID() {
		return super.getUniqueID();
	}

	@Override
	public void func_145781_i(int p_145781_1_) {
		if (master != null) master.func_145781_i(p_145781_1_);
		else super.func_145781_i(p_145781_1_);
	}

	public void superFunc_145781_i(int p_145781_1_) {
		super.func_145781_i(p_145781_1_);
	}

	@Override
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (master != null ? master.getEntityData() : super.getEntityData());
	}

	public NBTTagCompound superGetEntityData() {
		return super.getEntityData();
	}

	@Override
	public boolean shouldRiderSit() {
		return master != null ? master.shouldRiderSit() : super.shouldRiderSit();
	}

	public boolean superShouldRiderSit() {
		return super.shouldRiderSit();
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return (ItemStack) (master != null ? master.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}

	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return super.getPickedResult((MovingObjectPosition) movingObjectPosition);
	}

	@Override
	public UUID getPersistentID() {
		return master != null ? master.getPersistentID() : super.getPersistentID();
	}

	public UUID superGetPersistentID() {
		return super.getPersistentID();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}

	public boolean superShouldRenderInPass(int pass) {
		return super.shouldRenderInPass(pass);
	}

	@Override
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return master != null ? master.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}

	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}

	@Override
	public String registerExtendedProperties(String identifier, IExtendedEntityProperties iExtendedEntityProperties) {
		return master != null ? master.registerExtendedProperties(identifier, iExtendedEntityProperties) : super.registerExtendedProperties(identifier, iExtendedEntityProperties);
	}

	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return super.registerExtendedProperties(identifier, (IExtendedEntityProperties) iExtendedEntityProperties);
	}

	@Override
	public IExtendedEntityProperties getExtendedProperties(String identifier) {
		return (IExtendedEntityProperties) (master != null ? master.getExtendedProperties(identifier) : super.getExtendedProperties(identifier));
	}

	public IExtendedEntityProperties superGetExtendedProperties(String identifier) {
		return super.getExtendedProperties(identifier);
	}

	@Override
	public boolean canRiderInteract() {
		return master != null ? master.canRiderInteract() : super.canRiderInteract();
	}

	public boolean superCanRiderInteract() {
		return super.canRiderInteract();
	}

	@Override
	public boolean shouldDismountInWater(Entity entity) {
		return master != null ? master.shouldDismountInWater(entity) : super.shouldDismountInWater(entity);
	}

	public boolean superShouldDismountInWater(Object entity) {
		return super.shouldDismountInWater((Entity) entity);
	}

	@Override
	public void superFunc_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public Object superGetPosition() {
		return super.getPosition(1.0F);
	}

	@Override
	public boolean superIsSpectator() {
		return false;
	}

	@Override
	public boolean superHasPlayerInfo() {
		return false;
	}

	@Override
	public Object superGetPlayerInfo() {
		return null;
	}

	@Override
	public boolean superHasSkin() {
		return false;
	}

	@Override
	public String superGetSkinType() {
		return null;
	}

	@Override
	public float superGetFovModifier() {
		return 0.0F;
	}

	@Override
	public Object superDropItem(Object itemStack, boolean dropAround, boolean traceItem) {
		return null;
	}

	@Override
	public float superGetToolDigEfficiency(Object block) {
		return 0.0F;
	}

	@Override
	public float superGetBreakSpeed(Object iBlockState, Object blockPos) {
		return 0.0F;
	}

	@Override
	public void superOpenEditSign(Object tileEntitySign) {
	}

	@Override
	public void superOpenEditCommandBlock(Object commandBlockLogic) {
	}

	@Override
	public void superDisplayVillagerTradeGui(Object iMerchant) {
	}

	@Override
	public void superDisplayGui(Object iInteractionObject) {
	}

	@Override
	public boolean superIsUser() {
		return super.isPlayer();
	}

	@Override
	public Object superTrySleep(Object blockPos) {
		return null;
	}

	@Override
	public void superSetSpawnPoint(Object blockPos, boolean forced) {
	}

	@Override
	public void superFunc_175145_a(Object statBase) {
	}

	@Override
	public void superFall(float distance, float damageMultiplier) {
		super.fall(distance);
	}

	@Override
	public String superGetFallSoundString(int damageValue) {
		return null;
	}

	@Override
	public int superGetXPSeed() {
		return -1;
	}

	@Override
	public void superRemoveExperienceLevel(int levels) {
	}

	@Override
	public boolean superIsAllowEdit() {
		return false;
	}

	@Override
	public boolean superCanPlayerEdit(Object blockPos, Object enumFacing, Object itemStack) {
		return false;
	}

	@Override
	public String superGetName() {
		return super.getDisplayName();
	}

	@Override
	public Object[] superGetInventory() {
		return null;
	}

	@Override
	public boolean superCanOpen(Object lockCode) {
		return false;
	}

	@Override
	public boolean superFunc_175148_a(Object enumPlayerModelParts) {
		return false;
	}

	@Override
	public boolean superSendCommandFeedback() {
		return false;
	}

	@Override
	public boolean superReplaceItemInInventory(int p_174820_1_, Object itemStack) {
		return false;
	}

	@Override
	public boolean superHasReducedDebug() {
		return false;
	}

	@Override
	public void superSetReducedDebug(boolean reducedDebug) {
	}

	@Override
	public String superGetDisplayNameString() {
		return super.getDisplayName();
	}

	@Override
	public void superOnKillCommand() {
	}

	@Override
	public void superFunc_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}

	@Override
	public int superGetRevengeTimer() {
		return -1;
	}

	@Override
	public void superFunc_175135_B() {
	}

	@Override
	public void superFunc_175133_bi() {
	}

	@Override
	public void superAddRandomArmor() {
	}

	@Override
	public Object superGetCombatTracker() {
		return null;
	}

	@Override
	public float superFunc_175134_bD() {
		return 0.0F;
	}

	@Override
	public void superFunc_180466_bG() {
	}

	@Override
	public boolean superIsServerWorld() {
		return !super.isClientWorld();
	}

	@Override
	public void superFunc_175136_bO() {
	}

	@Override
	public void superDoBlockCollisions() {
	}

	@Override
	public void superPlayStepSound(Object blockPos, Object block) {
	}

	@Override
	public boolean superIsSilent() {
		return false;
	}

	@Override
	public void superSetSilent(boolean isSilent) {
	}

	@Override
	public void superSpawnRunningParticles() {
	}

	@Override
	public void superCreateRunningParticles() {
	}

	@Override
	public boolean superIsInLava() {
		return false;
	}

	@Override
	public void superMoveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_) {
	}

	@Override
	public double superGetDistanceSq(Object blockPos) {
		return 0.0D;
	}

	@Override
	public double superGetDistanceSqToCenter(Object blockPos) {
		return 0.0D;
	}

	@Override
	public Object superGetPositionEyes(float p_174824_1_) {
		return null;
	}

	@Override
	public Object superDropItemWithOffset(Object item, int size, float p_145778_3_) {
		return null;
	}

	@Override
	public boolean superPushOutOfBlocks(double x, double y, double z) {
		return super.func_145771_j(x, y, z);
	}

	@Override
	public boolean superIsEntityInvulnerable(Object damageSource) {
		return super.isEntityInvulnerable();
	}

	@Override
	public void superCopyDataFromOld(Object entity) {
	}

	@Override
	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return 0.0F;
	}

	@Override
	public boolean superFunc_174816_a(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return false;
	}

	@Override
	public int superGetMaxFallHeight() {
		return -1;
	}

	@Override
	public void superSetCustomNameTag(String p_96094_1_) {
	}

	@Override
	public String superGetCustomNameTag() {
		return null;
	}

	@Override
	public boolean superHasCustomName() {
		return false;
	}

	@Override
	public void superSetAlwaysRenderNameTag(boolean p_174805_1_) {
	}

	@Override
	public boolean superGetAlwaysRenderNameTag() {
		return false;
	}

	@Override
	public Object superGetHorizontalFacing() {
		return null;
	}

	@Override
	public Object superFunc_174823_aP() {
		return null;
	}

	@Override
	public boolean superFunc_174827_a(Object entityPlayerMP) {
		return false;
	}

	@Override
	public Object superGetEntityBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	public void superSetEntityBoundingBox(Object axisAlignedBB) {
	}

	@Override
	public boolean superIsOutsideBorder() {
		return false;
	}

	@Override
	public void superSetOutsideBorder(boolean p_174821_1_) {
	}

	@Override
	public Object superGetPositionVector() {
		return null;
	}

	@Override
	public Object superGetCommandSenderEntity() {
		return null;
	}

	@Override
	public void superSetCommandStat(Object type, int amount) {
	}

	@Override
	public Object superFunc_174807_aT() {
		return null;
	}

	@Override
	public void superFunc_174817_o(Object entity) {
	}

	@Override
	public Object superFunc_174819_aU() {
		return null;
	}

	@Override
	public void superFunc_174834_g(Object nBTTagCompound) {
	}

	@Override
	public boolean superFunc_174825_a(Object entityPlayer, Object vec3) {
		return false;
	}

	@Override
	public boolean superFunc_180427_aV() {
		return false;
	}

	@Override
	public void superFunc_174815_a(Object entityLivingBase, Object entity) {
	}
	// 179~
	@Override
	public void superFunc_152121_a(Object type, Object resourceLocation) {
	}

	@Override
	public boolean superFunc_152122_n() {
		return false;
	}

	@Override
	public boolean superFunc_152123_o() {
		return false;
	}

	@Override
	public void superFunc_152111_bt() {
	}

	@Override
	public void superFunc_152112_bu() {
	}
	// ~152
	@Override
	public void superUpdateCloak() {
	}

	@Override
	public void superSendChatToPlayer(String par1Str) {
	}

	@Override
	public int superGetMaxHealth() {
		return (int) getMaxHealth();
	}

	@Override
	public boolean superFunc_96122_a(Object entityPlayer) {
		return false;
	}

	@Override
	public void superAlertWolves(Object entityLiving, boolean par2) {
	}

	@Override
	public void superDamageArmor(int par1) {
		super.damageArmor(par1);
	}

	@Override
	public float superFunc_82243_bO() {
		return 0.0F;
	}

	@Override
	public boolean superFunc_71066_bF() {
		return false;
	}

	@Override
	public void superFunc_82162_bC() {
	}

	@Override
	public boolean superCanCurrentToolHarvestBlock(int par1, int par2, int par3) {
		return false;
	}

	@Override
	public boolean superFunc_94062_bN() {
		return false;
	}

	@Override
	public boolean superFunc_94059_bO() {
		return false;
	}

	@Override
	public boolean superCanPickUpLoot() {
		return false;
	}

	@Override
	public Object superGetTranslator() {
		return null;
	}

	@Override
	public String superTranslateString(String par1Str, Object... par2ArrayOfObj) {
		return null;
	}

	@Override
	public boolean superFunc_98034_c(Object entityPlayer) {
		return false;
	}

	@Override
	public boolean superFunc_96092_aw() {
		return false;
	}

	@Override
	public int superFunc_96121_ay() {
		return -1;
	}

	@Override
	public Object superGetLookHelper() {
		return null;
	}

	@Override
	public Object superGetMoveHelper() {
		return null;
	}

	@Override
	public Object superGetJumpHelper() {
		return null;
	}

	@Override
	public Object superGetNavigator() {
		return null;
	}

	@Override
	public Object superGetEntitySenses() {
		return null;
	}

	@Override
	public Object superGetAttackTarget() {
		return null;
	}

	@Override
	public void superSetAttackTarget(Object entityLiving) {
	}

	@Override
	public boolean superCanAttackClass(Class par1Class) {
		return false;
	}

	@Override
	public void superEatGrassBonus() {
	}

	@Override
	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return false;
	}

	@Override
	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return false;
	}

	@Override
	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
	}

	@Override
	public Object superGetHomePosition() {
		return null;
	}

	@Override
	public float superGetMaximumHomeDistance() {
		return 0;
	}

	@Override
	public void superDetachHome() {
	}

	@Override
	public boolean superHasHome() {
		return false;
	}

	@Override
	public String superGetTexture() {
		return null;
	}

	@Override
	public int superGetTalkInterval() {
		return -1;
	}

	@Override
	public void superPlayLivingSound() {
	}

	@Override
	public void superSpawnExplosionParticle() {
	}

	@Override
	public int superGetHealthInt() {
		return (int) super.getHealth();
	}

	@Override
	public String superGetLivingSound() {
		return null;
	}

	@Override
	public int superGetDropItemId() {
		return 0;
	}

	@Override
	public void superSetMoveForward(float par1) {
	}

	@Override
	public void superFunc_85033_bc() {
	}

	@Override
	public boolean superCanDespawn() {
		return false;
	}

	@Override
	public void superDespawnEntity() {
	}

	@Override
	public int superGetVerticalFaceSpeed() {
		return 0;
	}

	@Override
	public void superFaceEntity(Object entity, float par2, float par3) {
	}

	@Override
	public boolean superGetCanSpawnHere() {
		return false;
	}

	@Override
	public float superGetRenderSizeModifier() {
		return 0;
	}

	@Override
	public int superGetMaxSpawnedInChunk() {
		return 0;
	}

	@Override
	public float superGetSpeedModifier() {
		return 0;
	}

	@Override
	public int superFunc_82143_as() {
		return 0;
	}

	@Override
	public void superInitCreature() {
	}

	@Override
	public boolean superCanBeSteered() {
		return false;
	}

	@Override
	public void superFunc_94058_c(String par1Str) {
	}

	@Override
	public String superFunc_94057_bL() {
		return null;
	}

	@Override
	public boolean superFunc_94056_bM() {
		return false;
	}

	@Override
	public void superFunc_94061_f(boolean par1) {
	}

	@Override
	public void superFunc_96120_a(int par1, float par2) {
	}

	@Override
	public void superSetCanPickUpLoot(boolean par1) {
	}

	@Override
	public boolean superFunc_104002_bU() {
		return false;
	}

	@Override
	public boolean superAddNotRiddenEntityID(Object nBTTagCompound) {
		return false;
	}

	@Override
	public boolean superAddEntityID(Object nBTTagCompound) {
		return false;
	}

	@Override
	public boolean superInteract(Object entityPlayer) {
		return false;
	}

	@Override
	public void superUnmountEntity(Object entity) {
		superMountEntity(entity);
	}

	@Override
	public boolean superFunc_85031_j(Object entity) {
		return false;
	}

	@Override
	public void superFunc_82149_j(Object entity) {
	}

	@Override
	public float superFunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	@Override
	public boolean superFunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

	@Override
	public void superFunc_85029_a(Object crashReportCategory) {
	}
	// ~164
	@Override
	public void superSendChatToPlayer(Object chatMessageComponent) {
	}

	@Override
	public void superSetupCustomSkin() {
	}

	@Override
	public Object superGetTextureSkin() {
		return null;
	}

	@Override
	public Object superGetTextureCape() {
		return null;
	}

	@Override
	public Object superDropPlayerItem(Object itemStack) {
		return null;
	}

	@Override
	public float superGetCurrentPlayerStrVsBlock(Object block, boolean par2, int meta) {
		return 0.0F;
	}

	@Override
	public void superDisplayGUIHopper(Object tileEntityHopper) {
	}

	@Override
	public void superDisplayGUIFurnace(Object tileEntityFurnace) {
	}

	@Override
	public void superDisplayGUIDispenser(Object tileEntityDispenser) {
	}

	@Override
	public void superDisplayGUIEditSign(Object tileEntity) {
	}

	@Override
	public void superDisplayGUIBrewingStand(Object tileEntityBrewingStand) {
	}

	@Override
	public void superDisplayGUIBeacon(Object tileEntityBeacon) {
	}

	@Override
	public void superAddChatMessage(String par1Str) {

	}

	@Override
	public String superGetEntityName() {
		return null;
	}

	@Override
	public Object superGetCurrentItemOrArmor(int par1) {
		return null;
	}

	@Override
	public String superGetTranslatedEntityName() {
		return null;
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, int par4) {
	}

	@Override
	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return false;
	}

	@Override
	public Object superDropItem(int par1, int par2) {
		return null;
	}

	@Override
	public Object superDropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}

	@Override
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

}
