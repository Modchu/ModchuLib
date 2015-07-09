package modchu.lib.forge.mc179;import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityPlayerSP;
import modchu.lib.Modchu_IEntityPlayerSPMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.ThreadDownloadImageData;
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
import net.minecraft.entity.player.InventoryPlayer;
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
import net.minecraft.stats.StatFileWriter;
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
import net.minecraft.util.Session;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.common.IExtendedEntityProperties;public class Modchu_EntityPlayerSP extends EntityClientPlayerMP implements Modchu_IEntityPlayerSP {
	public Modchu_IEntityPlayerSPMaster master;
	public boolean initFlag;	public Modchu_EntityPlayerSP(HashMap<String, Object> map) {
		super((Minecraft)map.get("Object"), (World)map.get("Object1"), (Session)map.get("Object2"), (NetHandlerPlayClient)map.get("Object3"), (StatFileWriter)map.get("Object4"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityPlayerSP init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityPlayerSPMaster ? (Modchu_IEntityPlayerSPMaster) instance : null;
		if (master != null); else Modchu_Debug.lDebug("Modchu_EntityPlayerSP init master == null !!");
	}	public void init() {
		if (master != null) master.init();
	}	@Override
	public void wakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {
		super.wakeUpPlayer(flag, flag1, flag2);
		if (master != null) master.wakeUpPlayer(flag, flag1, flag2);
	}	@Override
	public void preparePlayerToSpawn() {
		super.preparePlayerToSpawn();
		if (master != null) master.preparePlayerToSpawn();
	}	public void setPositionCorrection(double par1, double par3, double par5) {
		if (master != null) master.setPositionCorrection(par1, par3, par5);
	}	@Override
	public void onLivingUpdate() {
		if (master != null) master.onLivingUpdate();
		super.onLivingUpdate();
	}	@Override
	public void moveEntityWithHeading(float f, float f1) {
		if (master != null) master.moveEntityWithHeading(f, f1);
		super.moveEntityWithHeading(f, f1);
	}	@Override
	public String getHurtSound() {
		if (master != null) return master.getHurtSound();
		return super.getHurtSound();
	}	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		if (master != null) return (EnumCreatureAttribute) master.getCreatureAttribute();
		return super.getCreatureAttribute();
	}	public EnumCreatureAttribute supergetCreatureAttribute() {
		return super.getCreatureAttribute();
	}	@Override
	protected void setSize(float f, float f1) {
		if (master != null) master.setSize(f, f1);
	}	public void supersetSize(float f, float f1) {
		super.setSize(f, f1);
	}	@Override
	public double getMountedYOffset() {
		if (master != null) return master.getMountedYOffset();
		return super.getMountedYOffset();
	}	@Override
	protected void resetHeight() {
		if (master != null) master.resetHeight();
	}	@Override
	public double getYOffset() {
		if (master != null) return master.getYOffset();
		return super.getYOffset();
	}	@Override
	public boolean func_145771_j(double d, double d1, double d2) {
		if (master != null) return master.pushOutOfBlocks(d, d1, d2);
		return super.func_145771_j(d, d1, d2);
	}	public boolean superpushOutOfBlocks(double d, double d1, double d2) {
		return super.func_145771_j(d, d1, d2);
	}	@Override
	public boolean isEntityInsideOpaqueBlock() {
		if (master != null) return master.isEntityInsideOpaqueBlock();
		return super.isEntityInsideOpaqueBlock();
	}	public void copyPlayer(EntityPlayer entityplayer) {
		if (master != null) master.copyPlayer(entityplayer);
	}	public void superonDeath(DamageSource par1DamageSource) {
		super.onDeath(par1DamageSource);
	}
/*
	public float getMaxHealth() {
		return master != null ? master.getMaxHealth() : super.getMaxHealth();
	}
*/
	public void supercopyPlayer(EntityPlayer entityplayer) {
		//super.copyPlayer(entityplayer);
	}	public void copyInventory(InventoryPlayer inventoryplayer) {
		if (master != null) master.copyInventory(inventoryplayer);
	}	@Override
	public void publicResetHeight() {
		if (master != null) master.resetHeight();
	}	@Override
	public void publicSetSize(float f, float f1) {
		if (master != null) master.setSize(f, f1);
	}	@Override
	public void updateRidden() {
		if (master != null) master.updateRidden();
	}	@Override
	public void superupdateRidden() {
		super.updateRidden();
	}	public boolean attackEntityFrom(Entity var1, DamageSource par1DamageSource, int par2) {
		return master != null ? master.attackEntityFrom(var1, par1DamageSource, par2) : false;
	}	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		return master != null ? master.attackEntityFrom(par1DamageSource, par2) : false;
	}	public boolean superattackEntityFrom(DamageSource par1DamageSource, int par2) {
		return super.attackEntityFrom(par1DamageSource, par2);
	}	@Override
	public void onDeath(DamageSource par1DamageSource) {
		if (master != null) master.onDeath(par1DamageSource);
	}	@Override
	public void superonDeath(Object par1DamageSource) {
		super.onDeath((DamageSource) par1DamageSource);
	}	@Override
	public void setHealth(float f) {
		if (master != null) master.setHealth((int) f);
	}	@Override
	public void sendMotionUpdates() {
		if (master != null) master.sendMotionUpdates();
	}	@Override
	public void supersendMotionUpdates() {
		super.sendMotionUpdates();
	}/*
	public float getMaxHealth() {
		return master != null ? master.getMaxHealth() : super.getMaxHealth();
	}
*/
	public float getEntityHealth() {
		return master != null ? master.getHealth() : super.getHealth();
	}	public void setEntityHealth(float f) {
		if (master != null) master.setHealth(f);
	}	@Override
	public Object supercopyPlayer(Object entityplayer) {
		return null;
	}	@Override
	public boolean superattackEntityFrom(Object damageSource, int par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
	}	@Override
	public void superwakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {
		super.wakeUpPlayer(flag, flag1, flag2);
	}	@Override
	public void superpreparePlayerToSpawn() {
		super.preparePlayerToSpawn();
	}	@Override
	public void supersetPositionCorrection(double par1, double par3, double par5) {
	}	@Override
	public void superonLivingUpdate() {
		super.onLivingUpdate();
	}	@Override
	public void supermoveEntityWithHeading(float f, float f1) {
		super.moveEntityWithHeading(f, f1);
	}	@Override
	public String supergetHurtSound() {
		return super.getHurtSound();
	}	@Override
	public double supergetMountedYOffset() {
		return super.getMountedYOffset();
	}	@Override
	public void superresetHeight() {
		super.resetHeight();
	}	@Override
	public double supergetYOffset() {
		return super.getYOffset();
	}	@Override
	public boolean superisEntityInsideOpaqueBlock() {
		return super.isEntityInsideOpaqueBlock();
	}	@Override
	public Object supercopyInventory(Object inventoryplayer) {
		return null;
	}	@Override
	public boolean superattackEntityFrom(Object entity, Object damageSource, int i) {
		return super.attackEntityFrom((DamageSource) damageSource, i);
	}	@Override
	public float supergetMaxHealth() {
		return super.getMaxHealth();
	}	@Override
	public int supergetMaxHealthInt() {
		return (int) super.getMaxHealth();
	}	@Override
	public float supergetHealth() {
		return super.getHealth();
	}	@Override
	public int supergetHealthInt() {
		return (int) super.getHealth();
	}	@Override
	public void supersetHealth(float f) {
		super.setHealth(f);
	}	@Override
	public void supersetHealthInt(int i) {
		super.setHealth(i);
	}	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float par2) {
		return master != null ? master.attackEntityFrom(damageSource, par2) : super.attackEntityFrom(damageSource, par2);
	}	public boolean superAttackEntityFrom(Object damageSource, float par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
	}	@Override
	public void heal(float par1) {
		if (master != null) master.heal(par1);
		else super.heal(par1);
	}	public void superHeal(float par1) {
		super.heal(par1);
	}	@Override
	public void mountEntity(Entity entity) {
		if (master != null) master.mountEntity(entity);
		else super.mountEntity(entity);
	}	public void superMountEntity(Object entity) {
		super.mountEntity((Entity) entity);
	}	@Override
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}	public void superOnUpdate() {
		super.onUpdate();
	}	@Override
	public EntityItem dropOneItem(boolean par1) {
		return (EntityItem) (master != null ? master.dropOneItem(par1) : super.dropOneItem(par1));
	}	public EntityItem superDropOneItem(boolean par1) {
		return super.dropOneItem(par1);
	}	@Override
	public void joinEntityItemWithWorld(EntityItem entityItem) {
		if (master != null) master.joinEntityItemWithWorld(entityItem);
		else super.joinEntityItemWithWorld(entityItem);
	}	public void superJoinEntityItemWithWorld(Object entityItem) {
		super.joinEntityItemWithWorld((EntityItem) entityItem);
	}	@Override
	public void sendChatMessage(String par1Str) {
		if (master != null) master.sendChatMessage(par1Str);
		else super.sendChatMessage(par1Str);
	}	public void superSendChatMessage(String par1Str) {
		super.sendChatMessage(par1Str);
	}	@Override
	public void swingItem() {
		if (master != null) master.swingItem();
		else super.swingItem();
	}	public void superSwingItem() {
		super.swingItem();
	}	@Override
	public void respawnPlayer() {
		if (master != null) master.respawnPlayer();
		else super.respawnPlayer();
	}	public void superRespawnPlayer() {
		super.respawnPlayer();
	}	@Override
	protected void damageEntity(DamageSource damageSource, float par2) {
		if (master != null) master.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
	}	public void superDamageEntity(Object damageSource, float par2) {
		super.damageEntity((DamageSource) damageSource, par2);
	}	@Override
	public void closeScreen() {
		if (master != null) master.closeScreen();
		else super.closeScreen();
	}	public void superCloseScreen() {
		super.closeScreen();
	}	@Override
	public void setPlayerSPHealth(float par1) {
		if (master != null) master.setPlayerSPHealth(par1);
		else super.setPlayerSPHealth(par1);
	}	public void superSetPlayerSPHealth(float par1) {
		super.setPlayerSPHealth(par1);
	}	@Override
	public void addStat(StatBase statBase, int par2) {
		if (master != null) master.addStat(statBase, par2);
		else super.addStat(statBase, par2);
	}	public void superAddStat(Object statBase, int par2) {
		super.addStat((StatBase) statBase, par2);
	}	@Override
	public void sendPlayerAbilities() {
		if (master != null) master.sendPlayerAbilities();
		else super.sendPlayerAbilities();
	}	public void superSendPlayerAbilities() {
		super.sendPlayerAbilities();
	}	@Override
	protected void func_110318_g() {
		if (master != null) master.func_110318_g();
		else super.func_110318_g();
	}	public void superFunc_110318_g() {
		super.func_110318_g();
	}	@Override
	public void func_110322_i() {
		if (master != null) master.func_110322_i();
		else super.func_110322_i();
	}	public void superFunc_110322_i() {
		super.func_110322_i();
	}	@Override
	public void func_142020_c(String par1Str) {
		if (master != null) master.func_142020_c(par1Str);
		else super.func_142020_c(par1Str);
	}	public void superFunc_142020_c(String par1Str) {
		super.func_142020_c(par1Str);
	}	@Override
	public String func_142021_k() {
		return master != null ? master.func_142021_k() : super.func_142021_k();
	}	public String superFunc_142021_k() {
		return super.func_142021_k();
	}	@Override
	public void updateEntityActionState() {
		if (master != null) master.updateEntityActionState();
		else super.updateEntityActionState();
	}	public void superUpdateEntityActionState() {
		super.updateEntityActionState();
	}	@Override
	public float getFOVMultiplier() {
		return master != null ? master.getFOVMultiplier() : super.getFOVMultiplier();
	}	public float superGetFOVMultiplier() {
		return super.getFOVMultiplier();
	}	@Override
	public void displayGUIBook(ItemStack itemStack) {
		if (master != null) master.displayGUIBook(itemStack);
		else super.displayGUIBook(itemStack);
	}	public void superDisplayGUIBook(Object itemStack) {
		super.displayGUIBook((ItemStack) itemStack);
	}	@Override
	public void displayGUIChest(IInventory iInventory) {
		if (master != null) master.displayGUIChest(iInventory);
		else super.displayGUIChest(iInventory);
	}	public void superDisplayGUIChest(Object iInventory) {
		super.displayGUIChest((IInventory) iInventory);
	}	@Override
	public void displayGUIHopperMinecart(EntityMinecartHopper entityMinecartHopper) {
		if (master != null) master.displayGUIHopperMinecart(entityMinecartHopper);
		else super.displayGUIHopperMinecart(entityMinecartHopper);
	}	public void superDisplayGUIHopperMinecart(Object entityMinecartHopper) {
		super.displayGUIHopperMinecart((EntityMinecartHopper) entityMinecartHopper);
	}	@Override
	public void displayGUIHorse(EntityHorse entityHorse, IInventory iInventory) {
		if (master != null) master.displayGUIHorse(entityHorse, iInventory);
		else super.displayGUIHorse(entityHorse, iInventory);
	}	public void superDisplayGUIHorse(Object entityHorse, Object iInventory) {
		super.displayGUIHorse((EntityHorse) entityHorse, (IInventory) iInventory);
	}	@Override
	public void displayGUIWorkbench(int par1, int par2, int par3) {
		if (master != null) master.displayGUIWorkbench(par1, par2, par3);
		else super.displayGUIWorkbench(par1, par2, par3);
	}	public void superDisplayGUIWorkbench(int par1, int par2, int par3) {
		super.displayGUIWorkbench(par1, par2, par3);
	}	@Override
	public void displayGUIEnchantment(int par1, int par2, int par3, String par4Str) {
		if (master != null) master.displayGUIEnchantment(par1, par2, par3, par4Str);
		else super.displayGUIEnchantment(par1, par2, par3, par4Str);
	}	public void superDisplayGUIEnchantment(int par1, int par2, int par3, String par4Str) {
		super.displayGUIEnchantment(par1, par2, par3, par4Str);
	}	@Override
	public void displayGUIAnvil(int par1, int par2, int par3) {
		if (master != null) master.displayGUIAnvil(par1, par2, par3);
		else super.displayGUIAnvil(par1, par2, par3);
	}	public void superDisplayGUIAnvil(int par1, int par2, int par3) {
		super.displayGUIAnvil(par1, par2, par3);
	}	@Override
	public void displayGUIMerchant(IMerchant iMerchant, String par2Str) {
		if (master != null) master.displayGUIMerchant(iMerchant, par2Str);
		else super.displayGUIMerchant(iMerchant, par2Str);
	}	public void superDisplayGUIMerchant(Object iMerchant, String par2Str) {
		super.displayGUIMerchant((IMerchant) iMerchant, par2Str);
	}	@Override
	public void onCriticalHit(Entity entity) {
		if (master != null) master.onCriticalHit(entity);
		else super.onCriticalHit(entity);
	}	public void superOnCriticalHit(Object entity) {
		super.onCriticalHit((Entity) entity);
	}	@Override
	public void onEnchantmentCritical(Entity entity) {
		if (master != null) master.onEnchantmentCritical(entity);
		else super.onEnchantmentCritical(entity);
	}	public void superOnEnchantmentCritical(Object entity) {
		super.onEnchantmentCritical((Entity) entity);
	}	@Override
	public void onItemPickup(Entity entity, int par2) {
		if (master != null) master.onItemPickup(entity, par2);
		else super.onItemPickup(entity, par2);
	}	public void superOnItemPickup(Object entity, int par2) {
		super.onItemPickup((Entity) entity, par2);
	}	@Override
	public boolean isSneaking() {
		return master != null ? master.isSneaking() : super.isSneaking();
	}	public boolean superIsSneaking() {
		return super.isSneaking();
	}	@Override
	public void setSprinting(boolean par1) {
		if (master != null) master.setSprinting(par1);
		else super.setSprinting(par1);
	}	public void superSetSprinting(boolean par1) {
		super.setSprinting(par1);
	}	@Override
	public void setXPStats(float par1, int par2, int par3) {
		if (master != null) master.setXPStats(par1, par2, par3);
		else super.setXPStats(par1, par2, par3);
	}	public void superSetXPStats(float par1, int par2, int par3) {
		super.setXPStats(par1, par2, par3);
	}	@Override
	public boolean canCommandSenderUseCommand(int par1, String par2Str) {
		return master != null ? master.canCommandSenderUseCommand(par1, par2Str) : super.canCommandSenderUseCommand(par1, par2Str);
	}	public boolean superCanCommandSenderUseCommand(int par1, String par2Str) {
		return super.canCommandSenderUseCommand(par1, par2Str);
	}	@Override
	public ChunkCoordinates getPlayerCoordinates() {
		return (ChunkCoordinates) (master != null ? master.getPlayerCoordinates() : super.getPlayerCoordinates());
	}	public ChunkCoordinates superGetPlayerCoordinates() {
		return super.getPlayerCoordinates();
	}	@Override
	public void playSound(String par1Str, float par2, float par3) {
		if (master != null) master.playSound(par1Str, par2, par3);
		else super.playSound(par1Str, par2, par3);
	}	public void superPlaySound(String par1Str, float par2, float par3) {
		super.playSound(par1Str, par2, par3);
	}	@Override
	public boolean isClientWorld() {
		return master != null ? master.isClientWorld() : super.isClientWorld();
	}	public boolean superIsClientWorld() {
		return super.isClientWorld();
	}	@Override
	public boolean isRidingHorse() {
		return master != null ? master.isRidingHorse() : super.isRidingHorse();
	}	public boolean superIsRidingHorse() {
		return super.isRidingHorse();
	}	@Override
	public float getHorseJumpPower() {
		return master != null ? master.getHorseJumpPower() : super.getHorseJumpPower();
	}	public float superGetHorseJumpPower() {
		return super.getHorseJumpPower();
	}	@Override
	public ResourceLocation getLocationSkin() {
		return (ResourceLocation) (master != null ? master.getLocationSkin() : super.getLocationSkin());
	}	public ResourceLocation superGetLocationSkin() {
		return super.getLocationSkin();
	}	@Override
	public ResourceLocation getLocationCape() {
		return (ResourceLocation) (master != null ? master.getLocationCape() : super.getLocationCape());
	}	public ResourceLocation superGetLocationCape() {
		return super.getLocationCape();
	}	@Override
	protected void applyEntityAttributes() {
		if (master != null) master.applyEntityAttributes();
		else super.applyEntityAttributes();
	}	public void superApplyEntityAttributes() {
		super.applyEntityAttributes();
	}	@Override
	protected void entityInit() {
		if (master != null) master.entityInit();
		else super.entityInit();
	}	public void superEntityInit() {
		super.entityInit();
	}	@Override
	public ItemStack getItemInUse() {
		return (ItemStack) (master != null ? master.getItemInUse() : super.getItemInUse());
	}	public ItemStack superGetItemInUse() {
		return super.getItemInUse();
	}	@Override
	public int getItemInUseCount() {
		return master != null ? master.getItemInUseCount() : super.getItemInUseCount();
	}	public int superGetItemInUseCount() {
		return super.getItemInUseCount();
	}	@Override
	public boolean isUsingItem() {
		return master != null ? master.isUsingItem() : super.isUsingItem();
	}	public boolean superIsUsingItem() {
		return super.isUsingItem();
	}	@Override
	public int getItemInUseDuration() {
		return master != null ? master.getItemInUseDuration() : super.getItemInUseDuration();
	}	public int superGetItemInUseDuration() {
		return super.getItemInUseDuration();
	}	@Override
	public void stopUsingItem() {
		if (master != null) master.stopUsingItem();
		else super.stopUsingItem();
	}	public void superStopUsingItem() {
		super.stopUsingItem();
	}	@Override
	public void clearItemInUse() {
		if (master != null) master.clearItemInUse();
		else super.clearItemInUse();
	}	public void superClearItemInUse() {
		super.clearItemInUse();
	}	@Override
	public boolean isBlocking() {
		return master != null ? master.isBlocking() : super.isBlocking();
	}	public boolean superIsBlocking() {
		return super.isBlocking();
	}	@Override
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}	public int superGetMaxInPortalTime() {
		return super.getMaxInPortalTime();
	}	@Override
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}	public int superGetPortalCooldown() {
		return super.getPortalCooldown();
	}	@Override
	protected void updateItemUse(ItemStack itemStack, int par2) {
		if (master != null) master.updateItemUse(itemStack, par2);
		else super.updateItemUse(itemStack, par2);
	}	public void superUpdateItemUse(Object itemStack, int par2) {
		super.updateItemUse((ItemStack) itemStack, par2);
	}	@Override
	protected void onItemUseFinish() {
		if (master != null) master.onItemUseFinish();
		else super.onItemUseFinish();
	}	public void superOnItemUseFinish() {
		super.onItemUseFinish();
	}	@Override
	public void handleHealthUpdate(byte par1) {
		if (master != null) master.handleHealthUpdate(par1);
		else super.handleHealthUpdate(par1);
	}	public void superHandleHealthUpdate(byte par1) {
		super.handleHealthUpdate(par1);
	}	@Override
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}	public boolean superIsMovementBlocked() {
		return super.isMovementBlocked();
	}	@Override
	public int getScore() {
		return master != null ? master.getScore() : super.getScore();
	}	public int superGetScore() {
		return super.getScore();
	}	@Override
	public void setScore(int par1) {
		if (master != null) master.setScore(par1);
		else super.setScore(par1);
	}	public void superSetScore(int par1) {
		super.setScore(par1);
	}	@Override
	public void addScore(int par1) {
		if (master != null) master.addScore(par1);
		else super.addScore(par1);
	}	public void superAddScore(int par1) {
		super.addScore(par1);
	}	@Override
	protected String getDeathSound() {
		return master != null ? master.getDeathSound() : super.getDeathSound();
	}	public String superGetDeathSound() {
		return super.getDeathSound();
	}	@Override
	public void addToPlayerScore(Entity entity, int par2) {
		if (master != null) master.addToPlayerScore(entity, par2);
		else super.addToPlayerScore(entity, par2);
	}	public void superAddToPlayerScore(Object entity, int par2) {
		super.addToPlayerScore((Entity) entity, par2);
	}	@Override
	public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean par2) {
		return (EntityItem) (master != null ? master.dropPlayerItemWithRandomChoice(itemStack, par2) : super.dropPlayerItemWithRandomChoice(itemStack, par2));
	}	public EntityItem superDropPlayerItemWithRandomChoice(Object itemStack, boolean par2) {
		return super.dropPlayerItemWithRandomChoice((ItemStack) itemStack, par2);
	}	@Override
	public float getCurrentPlayerStrVsBlock(Block block, boolean p_146096_2_) {
		return master != null ? master.getCurrentPlayerStrVsBlock(block, p_146096_2_) : super.getCurrentPlayerStrVsBlock(block, p_146096_2_);
	}	public float superGetCurrentPlayerStrVsBlock(Object block, boolean p_146096_2_) {
		return super.getCurrentPlayerStrVsBlock((Block) block, p_146096_2_);
	}	@Override
	public boolean canHarvestBlock(Block block) {
		return master != null ? master.canHarvestBlock(block) : super.canHarvestBlock(block);
	}	public boolean superCanHarvestBlock(Object block) {
		return super.canHarvestBlock((Block) block);
	}	@Override
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}	public void superReadEntityFromNBT(Object nBTTagCompound) {
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}	@Override
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeEntityToNBT(nBTTagCompound);
		else super.writeEntityToNBT(nBTTagCompound);
	}	public void superWriteEntityToNBT(Object nBTTagCompound) {
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
	}	@Override
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}	public float superGetEyeHeight() {
		return super.getEyeHeight();
	}	@Override
	public boolean canAttackPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.canAttackPlayer(entityPlayer) : super.canAttackPlayer(entityPlayer);
	}	public boolean superCanAttackPlayer(Object entityPlayer) {
		return super.canAttackPlayer((EntityPlayer) entityPlayer);
	}	@Override
	protected void damageArmor(float par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}	public void superDamageArmor(float par1) {
		super.damageArmor(par1);
	}	@Override
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}	@Override
	public float getArmorVisibility() {
		return master != null ? master.getArmorVisibility() : super.getArmorVisibility();
	}	public float superGetArmorVisibility() {
		return super.getArmorVisibility();
	}	@Override
	public boolean interactWith(Entity entity) {
		return master != null ? master.interactWith(entity) : super.interactWith(entity);
	}	public boolean superInteractWith(Object entity) {
		return super.interactWith((Entity) entity);
	}	@Override
	public ItemStack getCurrentEquippedItem() {
		return (ItemStack) (master != null ? master.getCurrentEquippedItem() : super.getCurrentEquippedItem());
	}	public ItemStack superGetCurrentEquippedItem() {
		return super.getCurrentEquippedItem();
	}	@Override
	public void destroyCurrentEquippedItem() {
		if (master != null) master.destroyCurrentEquippedItem();
		else super.destroyCurrentEquippedItem();
	}	public void superDestroyCurrentEquippedItem() {
		super.destroyCurrentEquippedItem();
	}	@Override
	public void attackTargetEntityWithCurrentItem(Entity entity) {
		if (master != null) master.attackTargetEntityWithCurrentItem(entity);
		else super.attackTargetEntityWithCurrentItem(entity);
	}	public void superAttackTargetEntityWithCurrentItem(Object entity) {
		super.attackTargetEntityWithCurrentItem((Entity) entity);
	}	@Override
	public void setDead() {
		if (master != null) master.setDead();
		else super.setDead();
	}	public void superSetDead() {
		super.setDead();
	}	@Override
	public EnumStatus sleepInBedAt(int par1, int par2, int par3) {
		return (EnumStatus) (master != null ? master.sleepInBedAt(par1, par2, par3) : super.sleepInBedAt(par1, par2, par3));
	}	public EnumStatus superSleepInBedAt(int par1, int par2, int par3) {
		return super.sleepInBedAt(par1, par2, par3);
	}	@Override
	public float getBedOrientationInDegrees() {
		return master != null ? master.getBedOrientationInDegrees() : super.getBedOrientationInDegrees();
	}	public float superGetBedOrientationInDegrees() {
		return super.getBedOrientationInDegrees();
	}	@Override
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}	public boolean superIsPlayerSleeping() {
		return super.isPlayerSleeping();
	}	@Override
	public boolean isPlayerFullyAsleep() {
		return master != null ? master.isPlayerFullyAsleep() : super.isPlayerFullyAsleep();
	}	public boolean superIsPlayerFullyAsleep() {
		return super.isPlayerFullyAsleep();
	}	@Override
	public int getSleepTimer() {
		return master != null ? master.getSleepTimer() : super.getSleepTimer();
	}	public int superGetSleepTimer() {
		return super.getSleepTimer();
	}	@Override
	protected boolean getHideCape(int par1) {
		return master != null ? master.getHideCape(par1) : super.getHideCape(par1);
	}	public boolean superGetHideCape(int par1) {
		return super.getHideCape(par1);
	}	@Override
	protected void setHideCape(int par1, boolean par2) {
		if (master != null) master.setHideCape(par1, par2);
		else super.setHideCape(par1, par2);
	}	public void superSetHideCape(int par1, boolean par2) {
		super.setHideCape(par1, par2);
	}	@Override
	public ChunkCoordinates getBedLocation() {
		return (ChunkCoordinates) (master != null ? master.getBedLocation() : super.getBedLocation());
	}	public ChunkCoordinates superGetBedLocation() {
		return super.getBedLocation();
	}	@Override
	public boolean isSpawnForced() {
		return master != null ? master.isSpawnForced() : super.isSpawnForced();
	}	public boolean superIsSpawnForced() {
		return super.isSpawnForced();
	}	@Override
	public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean par2) {
		if (master != null) master.setSpawnChunk(chunkCoordinates, par2);
		else super.setSpawnChunk(chunkCoordinates, par2);
	}	public void superSetSpawnChunk(Object chunkCoordinates, boolean par2) {
		super.setSpawnChunk((ChunkCoordinates) chunkCoordinates, par2);
	}	@Override
	public void triggerAchievement(StatBase statBase) {
		if (master != null) master.triggerAchievement(statBase);
		else super.triggerAchievement(statBase);
	}	public void superTriggerAchievement(Object statBase) {
		super.triggerAchievement((StatBase) statBase);
	}	@Override
	public void jump() {
		if (master != null) master.jump();
		else super.jump();
	}	public void superJump() {
		super.jump();
	}	@Override
	public float getAIMoveSpeed() {
		return master != null ? master.getAIMoveSpeed() : super.getAIMoveSpeed();
	}	public float superGetAIMoveSpeed() {
		return super.getAIMoveSpeed();
	}	@Override
	public void addMovementStat(double par1, double par3, double par5) {
		if (master != null) master.addMovementStat(par1, par3, par5);
		else super.addMovementStat(par1, par3, par5);
	}	public void superAddMovementStat(double par1, double par3, double par5) {
		super.addMovementStat(par1, par3, par5);
	}	@Override
	protected void fall(float par1) {
		if (master != null) master.fall(par1);
		else super.fall(par1);
	}	public void superFall(float par1) {
		super.fall(par1);
	}	@Override
	public void onKillEntity(EntityLivingBase entityLivingBase) {
		if (master != null) master.onKillEntity(entityLivingBase);
		else super.onKillEntity(entityLivingBase);
	}	public void superOnKillEntity(Object entityLivingBase) {
		super.onKillEntity((EntityLivingBase) entityLivingBase);
	}	@Override
	public void setInWeb() {
		if (master != null) master.setInWeb();
		else super.setInWeb();
	}	public void superSetInWeb() {
		super.setInWeb();
	}	@Override
	public IIcon getItemIcon(ItemStack itemStack, int par2) {
		return (IIcon) (master != null ? master.getItemIcon(itemStack, par2) : super.getItemIcon(itemStack, par2));
	}	public IIcon superGetItemIcon(Object itemStack, int par2) {
		return super.getItemIcon((ItemStack) itemStack, par2);
	}	@Override
	public ItemStack getCurrentArmor(int par1) {
		return (ItemStack) (master != null ? master.getCurrentArmor(par1) : super.getCurrentArmor(par1));
	}	public ItemStack superGetCurrentArmor(int par1) {
		return super.getCurrentArmor(par1);
	}	@Override
	public void addExperience(int par1) {
		if (master != null) master.addExperience(par1);
		else super.addExperience(par1);
	}	public void superAddExperience(int par1) {
		super.addExperience(par1);
	}	@Override
	public void addExperienceLevel(int par1) {
		if (master != null) master.addExperienceLevel(par1);
		else super.addExperienceLevel(par1);
	}	public void superAddExperienceLevel(int par1) {
		super.addExperienceLevel(par1);
	}	@Override
	public int xpBarCap() {
		return master != null ? master.xpBarCap() : super.xpBarCap();
	}	public int superXpBarCap() {
		return super.xpBarCap();
	}	@Override
	public void addExhaustion(float par1) {
		if (master != null) master.addExhaustion(par1);
		else super.addExhaustion(par1);
	}	public void superAddExhaustion(float par1) {
		super.addExhaustion(par1);
	}	@Override
	public FoodStats getFoodStats() {
		return (FoodStats) (master != null ? master.getFoodStats() : super.getFoodStats());
	}	public FoodStats superGetFoodStats() {
		return super.getFoodStats();
	}	@Override
	public boolean canEat(boolean par1) {
		return master != null ? master.canEat(par1) : super.canEat(par1);
	}	public boolean superCanEat(boolean par1) {
		return super.canEat(par1);
	}	@Override
	public boolean shouldHeal() {
		return master != null ? master.shouldHeal() : super.shouldHeal();
	}	public boolean superShouldHeal() {
		return super.shouldHeal();
	}	@Override
	public void setItemInUse(ItemStack itemStack, int par2) {
		if (master != null) master.setItemInUse(itemStack, par2);
		else super.setItemInUse(itemStack, par2);
	}	public void superSetItemInUse(Object itemStack, int par2) {
		super.setItemInUse((ItemStack) itemStack, par2);
	}	@Override
	public boolean isCurrentToolAdventureModeExempt(int par1, int par2, int par3) {
		return master != null ? master.isCurrentToolAdventureModeExempt(par1, par2, par3) : super.isCurrentToolAdventureModeExempt(par1, par2, par3);
	}	public boolean superIsCurrentToolAdventureModeExempt(int par1, int par2, int par3) {
		return super.isCurrentToolAdventureModeExempt(par1, par2, par3);
	}	@Override
	public boolean canPlayerEdit(int par1, int par2, int par3, int par4, ItemStack itemStack) {
		return master != null ? master.canPlayerEdit(par1, par2, par3, par4, itemStack) : super.canPlayerEdit(par1, par2, par3, par4, itemStack);
	}	public boolean superCanPlayerEdit(int par1, int par2, int par3, int par4, Object itemStack) {
		return super.canPlayerEdit(par1, par2, par3, par4, (ItemStack) itemStack);
	}	@Override
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return master != null ? master.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}	public int superGetExperiencePoints(Object entityPlayer) {
		return super.getExperiencePoints((EntityPlayer) entityPlayer);
	}	@Override
	protected boolean isPlayer() {
		return master != null ? master.isPlayer() : super.isPlayer();
	}	public boolean superIsPlayer() {
		return super.isPlayer();
	}	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}	public boolean superGetAlwaysRenderNameTagForRender() {
		return super.getAlwaysRenderNameTagForRender();
	}	@Override
	public void clonePlayer(EntityPlayer entityPlayer, boolean par2) {
		if (master != null) master.clonePlayer(entityPlayer, par2);
		else super.clonePlayer(entityPlayer, par2);
	}	public void superClonePlayer(Object entityPlayer, boolean par2) {
		super.clonePlayer((EntityPlayer) entityPlayer, par2);
	}	@Override
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}	public boolean superCanTriggerWalking() {
		return super.canTriggerWalking();
	}	@Override
	public void setGameType(GameType gameType) {
		if (master != null) master.setGameType(gameType);
		else super.setGameType(gameType);
	}	public void superSetGameType(Object gameType) {
		super.setGameType((GameType) gameType);
	}	@Override
	public String getCommandSenderName() {
		return master != null ? master.getCommandSenderName() : super.getCommandSenderName();
	}	public String superGetCommandSenderName() {
		return super.getCommandSenderName();
	}	@Override
	public World getEntityWorld() {
		return (World) (master != null ? master.getEntityWorld() : super.getEntityWorld());
	}	public World superGetEntityWorld() {
		return super.getEntityWorld();
	}	@Override
	public InventoryEnderChest getInventoryEnderChest() {
		return (InventoryEnderChest) (master != null ? master.getInventoryEnderChest() : super.getInventoryEnderChest());
	}	public InventoryEnderChest superGetInventoryEnderChest() {
		return super.getInventoryEnderChest();
	}	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}	public ItemStack superGetHeldItem() {
		return super.getHeldItem();
	}	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack itemStack) {
		if (master != null) master.setCurrentItemOrArmor(par1, itemStack);
		else super.setCurrentItemOrArmor(par1, itemStack);
	}	public void superSetCurrentItemOrArmor(int par1, Object itemStack) {
		super.setCurrentItemOrArmor(par1, (ItemStack) itemStack);
	}	@Override
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
	}	@Override
	public ItemStack[] getLastActiveItems() {
		return (ItemStack[]) (master != null ? master.getLastActiveItems() : super.getLastActiveItems());
	}	public ItemStack[] superGetLastActiveItems() {
		return super.getLastActiveItems();
	}	@Override
	public boolean getHideCape() {
		return master != null ? master.getHideCape() : super.getHideCape();
	}	public boolean superGetHideCape() {
		return super.getHideCape();
	}	@Override
	public boolean isPushedByWater() {
		return master != null ? master.isPushedByWater() : super.isPushedByWater();
	}	public boolean superIsPushedByWater() {
		return super.isPushedByWater();
	}	@Override
	public Scoreboard getWorldScoreboard() {
		return (Scoreboard) (master != null ? master.getWorldScoreboard() : super.getWorldScoreboard());
	}	public Scoreboard superGetWorldScoreboard() {
		return super.getWorldScoreboard();
	}	@Override
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}	public Team superGetTeam() {
		return super.getTeam();
	}	@Override
	public void setAbsorptionAmount(float par1) {
		if (master != null) master.setAbsorptionAmount(par1);
		else super.setAbsorptionAmount(par1);
	}	public void superSetAbsorptionAmount(float par1) {
		super.setAbsorptionAmount(par1);
	}	@Override
	public float getAbsorptionAmount() {
		return master != null ? master.getAbsorptionAmount() : super.getAbsorptionAmount();
	}	public float superGetAbsorptionAmount() {
		return super.getAbsorptionAmount();
	}	@Override
	public void openGui(Object mod, int modGuiId, World world, int x, int y, int z) {
		if (master != null) master.openGui(mod, modGuiId, world, x, y, z);
		else super.openGui(mod, modGuiId, world, x, y, z);
	}	public void superOpenGui(Object mod, int modGuiId, Object world, int x, int y, int z) {
		super.openGui(mod, modGuiId, (World) world, x, y, z);
	}	@Override
	public Vec3 getPosition(float par1) {
		return (Vec3) (master != null ? master.getPosition(par1) : super.getPosition(par1));
	}	public Vec3 superGetPosition(float par1) {
		return super.getPosition(par1);
	}	@Override
	public ChunkCoordinates getBedLocation(int dimension) {
		return (ChunkCoordinates) (master != null ? master.getBedLocation(dimension) : super.getBedLocation(dimension));
	}	public ChunkCoordinates superGetBedLocation(int dimension) {
		return super.getBedLocation(dimension);
	}	@Override
	public boolean isSpawnForced(int dimension) {
		return master != null ? master.isSpawnForced(dimension) : super.isSpawnForced(dimension);
	}	public boolean superIsSpawnForced(int dimension) {
		return super.isSpawnForced(dimension);
	}	@Override
	public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean forced, int dimension) {
		if (master != null) master.setSpawnChunk(chunkCoordinates, forced, dimension);
		else super.setSpawnChunk(chunkCoordinates, forced, dimension);
	}	public void superSetSpawnChunk(Object chunkCoordinates, boolean forced, int dimension) {
		super.setSpawnChunk((ChunkCoordinates) chunkCoordinates, forced, dimension);
	}	@Override
	public float getDefaultEyeHeight() {
		return master != null ? master.getDefaultEyeHeight() : super.getDefaultEyeHeight();
	}	public float superGetDefaultEyeHeight() {
		return super.getDefaultEyeHeight();
	}	@Override
	public String getDisplayName() {
		return (String) (master != null ? master.getDisplayName() : super.getDisplayName());
	}	public String superGetDisplayName() {
		return super.getDisplayName();
	}	@Override
	public void refreshDisplayName() {
		if (master != null) master.refreshDisplayName();
		else super.refreshDisplayName();
	}	public void superRefreshDisplayName() {
		super.refreshDisplayName();
	}	@Override
	protected void updateFallState(double par1, boolean par3) {
		if (master != null) master.updateFallState(par1, par3);
		else super.updateFallState(par1, par3);
	}	public void superUpdateFallState(double par1, boolean par3) {
		super.updateFallState(par1, par3);
	}	@Override
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}	public boolean superCanBreatheUnderwater() {
		return super.canBreatheUnderwater();
	}	@Override
	public void onEntityUpdate() {
		if (master != null) master.onEntityUpdate();
		else super.onEntityUpdate();
	}	public void superOnEntityUpdate() {
		super.onEntityUpdate();
	}	@Override
	public boolean isChild() {
		return master != null ? master.isChild() : super.isChild();
	}	public boolean superIsChild() {
		return super.isChild();
	}	@Override
	protected void onDeathUpdate() {
		if (master != null) master.onDeathUpdate();
		else super.onDeathUpdate();
	}	public void superOnDeathUpdate() {
		super.onDeathUpdate();
	}	@Override
	protected int decreaseAirSupply(int par1) {
		return master != null ? master.decreaseAirSupply(par1) : super.decreaseAirSupply(par1);
	}	public int superDecreaseAirSupply(int par1) {
		return super.decreaseAirSupply(par1);
	}	@Override
	public Random getRNG() {
		return master != null ? master.getRNG() : super.getRNG();
	}	public Random superGetRNG() {
		return super.getRNG();
	}	@Override
	public EntityLivingBase getAITarget() {
		return (EntityLivingBase) (master != null ? master.getAITarget() : super.getAITarget());
	}	public EntityLivingBase superGetAITarget() {
		return super.getAITarget();
	}	@Override
	public int func_142015_aE() {
		return master != null ? master.func_142015_aE() : super.func_142015_aE();
	}	public int superFunc_142015_aE() {
		return super.func_142015_aE();
	}	@Override
	public void setRevengeTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setRevengeTarget(entityLivingBase);
		else super.setRevengeTarget(entityLivingBase);
	}	public void superSetRevengeTarget(Object entityLivingBase) {
		super.setRevengeTarget((EntityLivingBase) entityLivingBase);
	}	@Override
	public EntityLivingBase getLastAttacker() {
		return (EntityLivingBase) (master != null ? master.getLastAttacker() : super.getLastAttacker());
	}	public EntityLivingBase superGetLastAttacker() {
		return super.getLastAttacker();
	}	@Override
	public int getLastAttackerTime() {
		return master != null ? master.getLastAttackerTime() : super.getLastAttackerTime();
	}	public int superGetLastAttackerTime() {
		return super.getLastAttackerTime();
	}	@Override
	public void setLastAttacker(Entity entity) {
		if (master != null) master.setLastAttacker(entity);
		else super.setLastAttacker(entity);
	}	public void superSetLastAttacker(Object entity) {
		super.setLastAttacker((Entity) entity);
	}	@Override
	public int getAge() {
		return master != null ? master.getAge() : super.getAge();
	}	public int superGetAge() {
		return super.getAge();
	}	@Override
	protected void updatePotionEffects() {
		if (master != null) master.updatePotionEffects();
		else super.updatePotionEffects();
	}	public void superUpdatePotionEffects() {
		super.updatePotionEffects();
	}	@Override
	public void clearActivePotions() {
		if (master != null) master.clearActivePotions();
		else super.clearActivePotions();
	}	public void superClearActivePotions() {
		super.clearActivePotions();
	}	@Override
	public Collection getActivePotionEffects() {
		return (Collection) (master != null ? master.getActivePotionEffects() : super.getActivePotionEffects());
	}	public Collection superGetActivePotionEffects() {
		return super.getActivePotionEffects();
	}	@Override
	public boolean isPotionActive(int par1) {
		return master != null ? master.isPotionActive(par1) : super.isPotionActive(par1);
	}	public boolean superIsPotionActive(int par1) {
		return super.isPotionActive(par1);
	}	@Override
	public boolean isPotionActive(Potion potion) {
		return master != null ? master.isPotionActive(potion) : super.isPotionActive(potion);
	}	public boolean superIsPotionActive(Object potion) {
		return super.isPotionActive((Potion) potion);
	}	@Override
	public PotionEffect getActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.getActivePotionEffect(potion) : super.getActivePotionEffect(potion));
	}	public PotionEffect superGetActivePotionEffect(Object potion) {
		return super.getActivePotionEffect((Potion) potion);
	}	@Override
	public void addPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.addPotionEffect(potionEffect);
		else super.addPotionEffect(potionEffect);
	}	public void superAddPotionEffect(Object potionEffect) {
		super.addPotionEffect((PotionEffect) potionEffect);
	}	@Override
	public boolean isPotionApplicable(PotionEffect potionEffect) {
		return master != null ? master.isPotionApplicable(potionEffect) : super.isPotionApplicable(potionEffect);
	}	public boolean superIsPotionApplicable(Object potionEffect) {
		return super.isPotionApplicable((PotionEffect) potionEffect);
	}	@Override
	public boolean isEntityUndead() {
		return master != null ? master.isEntityUndead() : super.isEntityUndead();
	}	public boolean superIsEntityUndead() {
		return super.isEntityUndead();
	}	@Override
	public void removePotionEffectClient(int par1) {
		if (master != null) master.removePotionEffectClient(par1);
		else super.removePotionEffectClient(par1);
	}	public void superRemovePotionEffectClient(int par1) {
		super.removePotionEffectClient(par1);
	}	@Override
	public void removePotionEffect(int par1) {
		if (master != null) master.removePotionEffect(par1);
		else super.removePotionEffect(par1);
	}	public void superRemovePotionEffect(int par1) {
		super.removePotionEffect(par1);
	}	@Override
	protected void onNewPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onNewPotionEffect(potionEffect);
		else super.onNewPotionEffect(potionEffect);
	}	public void superOnNewPotionEffect(Object potionEffect) {
		super.onNewPotionEffect((PotionEffect) potionEffect);
	}	@Override
	protected void onChangedPotionEffect(PotionEffect potionEffect, boolean par2) {
		if (master != null) master.onChangedPotionEffect(potionEffect, par2);
		else super.onChangedPotionEffect(potionEffect, par2);
	}	public void superOnChangedPotionEffect(Object potionEffect, boolean par2) {
		super.onChangedPotionEffect((PotionEffect) potionEffect, par2);
	}	@Override
	protected void onFinishedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onFinishedPotionEffect(potionEffect);
		else super.onFinishedPotionEffect(potionEffect);
	}	public void superOnFinishedPotionEffect(Object potionEffect) {
		super.onFinishedPotionEffect((PotionEffect) potionEffect);
	}	@Override
	public void renderBrokenItemStack(ItemStack itemStack) {
		if (master != null) master.renderBrokenItemStack(itemStack);
		else super.renderBrokenItemStack(itemStack);
	}	public void superRenderBrokenItemStack(Object itemStack) {
		super.renderBrokenItemStack((ItemStack) itemStack);
	}	@Override
	protected void dropEquipment(boolean par1, int par2) {
		if (master != null) master.dropEquipment(par1, par2);
		else super.dropEquipment(par1, par2);
	}	public void superDropEquipment(boolean par1, int par2) {
		super.dropEquipment(par1, par2);
	}	@Override
	public void knockBack(Entity entity, float par2, double par3, double par5) {
		if (master != null) master.knockBack(entity, par2, par3, par5);
		else super.knockBack(entity, par2, par3, par5);
	}	public void superKnockBack(Object entity, float par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
	}	@Override
	protected void dropRareDrop(int par1) {
		if (master != null) master.dropRareDrop(par1);
		else super.dropRareDrop(par1);
	}	public void superDropRareDrop(int par1) {
		super.dropRareDrop(par1);
	}	@Override
	protected void dropFewItems(boolean par1, int par2) {
		if (master != null) master.dropFewItems(par1, par2);
		else super.dropFewItems(par1, par2);
	}	public void superDropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
	}	@Override
	public boolean isOnLadder() {
		return master != null ? master.isOnLadder() : super.isOnLadder();
	}	public boolean superIsOnLadder() {
		return super.isOnLadder();
	}	@Override
	public boolean isEntityAlive() {
		return master != null ? master.isEntityAlive() : super.isEntityAlive();
	}	public boolean superIsEntityAlive() {
		return super.isEntityAlive();
	}	@Override
	public void performHurtAnimation() {
		if (master != null) master.performHurtAnimation();
		else super.performHurtAnimation();
	}	public void superPerformHurtAnimation() {
		super.performHurtAnimation();
	}	@Override
	protected float applyArmorCalculations(DamageSource damageSource, float par2) {
		return master != null ? master.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2);
	}	public float superApplyArmorCalculations(Object damageSource, float par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float par2) {
		return master != null ? master.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2);
	}	public float superApplyPotionDamageCalculations(Object damageSource, float par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}	@Override
	public CombatTracker func_110142_aN() {
		return (CombatTracker) (master != null ? master.func_110142_aN() : super.func_110142_aN());
	}	public CombatTracker superFunc_110142_aN() {
		return super.func_110142_aN();
	}	@Override
	public EntityLivingBase func_94060_bK() {
		return (EntityLivingBase) (master != null ? master.func_94060_bK() : super.func_94060_bK());
	}	public EntityLivingBase superFunc_94060_bK() {
		return super.func_94060_bK();
	}	@Override
	protected void kill() {
		if (master != null) master.kill();
		else super.kill();
	}	public void superKill() {
		super.kill();
	}	@Override
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}	public void superUpdateArmSwingProgress() {
		super.updateArmSwingProgress();
	}	@Override
	public IAttributeInstance getEntityAttribute(IAttribute iAttribute) {
		return (IAttributeInstance) (master != null ? master.getEntityAttribute(iAttribute) : super.getEntityAttribute(iAttribute));
	}	public IAttributeInstance superGetEntityAttribute(Object iAttribute) {
		return super.getEntityAttribute((IAttribute) iAttribute);
	}	@Override
	public BaseAttributeMap getAttributeMap() {
		return (BaseAttributeMap) (master != null ? master.getAttributeMap() : super.getAttributeMap());
	}	public BaseAttributeMap superGetAttributeMap() {
		return super.getAttributeMap();
	}	@Override
	protected float getSoundVolume() {
		return master != null ? master.getSoundVolume() : super.getSoundVolume();
	}	public float superGetSoundVolume() {
		return super.getSoundVolume();
	}	@Override
	protected float getSoundPitch() {
		return master != null ? master.getSoundPitch() : super.getSoundPitch();
	}	public float superGetSoundPitch() {
		return super.getSoundPitch();
	}	@Override
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		if (master != null) master.setPositionAndUpdate(par1, par3, par5);
		else super.setPositionAndUpdate(par1, par3, par5);
	}	public void superSetPositionAndUpdate(double par1, double par3, double par5) {
		super.setPositionAndUpdate(par1, par3, par5);
	}	@Override
	public void dismountEntity(Entity entity) {
		if (master != null) master.dismountEntity(entity);
		else super.dismountEntity(entity);
	}	public void superDismountEntity(Object entity) {
		super.dismountEntity((Entity) entity);
	}	@Override
	protected boolean isAIEnabled() {
		return master != null ? master.isAIEnabled() : super.isAIEnabled();
	}	public boolean superIsAIEnabled() {
		return super.isAIEnabled();
	}	@Override
	public void setAIMoveSpeed(float par1) {
		if (master != null) master.setAIMoveSpeed(par1);
		else super.setAIMoveSpeed(par1);
	}	public void superSetAIMoveSpeed(float par1) {
		super.setAIMoveSpeed(par1);
	}	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return master != null ? master.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}	public boolean superAttackEntityAsMob(Object entity) {
		return super.attackEntityAsMob((Entity) entity);
	}	@Override
	protected float func_110146_f(float par1, float par2) {
		return master != null ? master.func_110146_f(par1, par2) : super.func_110146_f(par1, par2);
	}	public float superFunc_110146_f(float par1, float par2) {
		return super.func_110146_f(par1, par2);
	}	@Override
	protected void updateAITasks() {
		if (master != null) master.updateAITasks();
		else super.updateAITasks();
	}	public void superUpdateAITasks() {
		super.updateAITasks();
	}	@Override
	protected void collideWithNearbyEntities() {
		if (master != null) master.collideWithNearbyEntities();
		else super.collideWithNearbyEntities();
	}	public void superCollideWithNearbyEntities() {
		super.collideWithNearbyEntities();
	}	@Override
	protected void collideWithEntity(Entity entity) {
		if (master != null) master.collideWithEntity(entity);
		else super.collideWithEntity(entity);
	}	public void superCollideWithEntity(Object entity) {
		super.collideWithEntity((Entity) entity);
	}	@Override
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		if (master != null) master.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
		else super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}	public void superSetPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}	@Override
	protected void updateAITick() {
		if (master != null) master.updateAITick();
		else super.updateAITick();
	}	public void superUpdateAITick() {
		super.updateAITick();
	}	@Override
	public void setJumping(boolean par1) {
		if (master != null) master.setJumping(par1);
		else super.setJumping(par1);
	}	public void superSetJumping(boolean par1) {
		super.setJumping(par1);
	}	@Override
	public boolean canEntityBeSeen(Entity entity) {
		return master != null ? master.canEntityBeSeen(entity) : super.canEntityBeSeen(entity);
	}	public boolean superCanEntityBeSeen(Object entity) {
		return super.canEntityBeSeen((Entity) entity);
	}	@Override
	public Vec3 getLookVec() {
		return (Vec3) (master != null ? master.getLookVec() : super.getLookVec());
	}	public Vec3 superGetLookVec() {
		return super.getLookVec();
	}	@Override
	public Vec3 getLook(float par1) {
		return (Vec3) (master != null ? master.getLook(par1) : super.getLook(par1));
	}	public Vec3 superGetLook(float par1) {
		return super.getLook(par1);
	}	@Override
	public float getSwingProgress(float par1) {
		return master != null ? master.getSwingProgress(par1) : super.getSwingProgress(par1);
	}	public float superGetSwingProgress(float par1) {
		return super.getSwingProgress(par1);
	}	@Override
	public MovingObjectPosition rayTrace(double par1, float par3) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(par1, par3) : super.rayTrace(par1, par3));
	}	public MovingObjectPosition superRayTrace(double par1, float par3) {
		return super.rayTrace(par1, par3);
	}	@Override
	public boolean canBeCollidedWith() {
		return master != null ? master.canBeCollidedWith() : super.canBeCollidedWith();
	}	public boolean superCanBeCollidedWith() {
		return super.canBeCollidedWith();
	}	@Override
	public boolean canBePushed() {
		return master != null ? master.canBePushed() : super.canBePushed();
	}	public boolean superCanBePushed() {
		return super.canBePushed();
	}	@Override
	protected void setBeenAttacked() {
		if (master != null) master.setBeenAttacked();
		else super.setBeenAttacked();
	}	public void superSetBeenAttacked() {
		super.setBeenAttacked();
	}	@Override
	public float getRotationYawHead() {
		return master != null ? master.getRotationYawHead() : super.getRotationYawHead();
	}	public float superGetRotationYawHead() {
		return super.getRotationYawHead();
	}	@Override
	public void setRotationYawHead(float par1) {
		if (master != null) master.setRotationYawHead(par1);
		else super.setRotationYawHead(par1);
	}	public void superSetRotationYawHead(float par1) {
		super.setRotationYawHead(par1);
	}	@Override
	public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOnSameTeam(entityLivingBase) : super.isOnSameTeam(entityLivingBase);
	}	public boolean superIsOnSameTeam(Object entityLivingBase) {
		return super.isOnSameTeam((EntityLivingBase) entityLivingBase);
	}	@Override
	public boolean isOnTeam(Team team) {
		return master != null ? master.isOnTeam(team) : super.isOnTeam(team);
	}	public boolean superIsOnTeam(Object team) {
		return super.isOnTeam((Team) team);
	}	@Override
	public void curePotionEffects(ItemStack itemStack) {
		if (master != null) master.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}	public void superCurePotionEffects(Object itemStack) {
		super.curePotionEffects((ItemStack) itemStack);
	}	@Override
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return master != null ? master.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}	@Override
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataWatcher() : super.getDataWatcher());
	}	public DataWatcher superGetDataWatcher() {
		return super.getDataWatcher();
	}/*	@Override
	public boolean equals(Object par1Obj) {
		return master != null ? master.equals(par1Obj) : super.equals(par1Obj);
	}	public boolean superEquals(Object par1Obj) {
		return super.equals(par1Obj);
	}	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}	public int superHashCode() {
		return super.hashCode();
	}*/	@Override
	protected void setRotation(float par1, float par2) {
		if (master != null) master.setRotation(par1, par2);
		else super.setRotation(par1, par2);
	}	public void superSetRotation(float par1, float par2) {
		super.setRotation(par1, par2);
	}	@Override
	public void setPosition(double par1, double par3, double par5) {
		if (master != null) master.setPosition(par1, par3, par5);
		else super.setPosition(par1, par3, par5);
	}	public void superSetPosition(double par1, double par3, double par5) {
		super.setPosition(par1, par3, par5);
	}	@Override
	public void setAngles(float par1, float par2) {
		if (master != null) master.setAngles(par1, par2);
		else super.setAngles(par1, par2);
	}	public void superSetAngles(float par1, float par2) {
		super.setAngles(par1, par2);
	}	@Override
	protected void setOnFireFromLava() {
		if (master != null) master.setOnFireFromLava();
		else super.setOnFireFromLava();
	}	public void superSetOnFireFromLava() {
		super.setOnFireFromLava();
	}	@Override
	public void setFire(int par1) {
		if (master != null) master.setFire(par1);
		else super.setFire(par1);
	}	public void superSetFire(int par1) {
		super.setFire(par1);
	}	@Override
	public void extinguish() {
		if (master != null) master.extinguish();
		else super.extinguish();
	}	public void superExtinguish() {
		super.extinguish();
	}	@Override
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return master != null ? master.isOffsetPositionInLiquid(par1, par3, par5) : super.isOffsetPositionInLiquid(par1, par3, par5);
	}	public boolean superIsOffsetPositionInLiquid(double par1, double par3, double par5) {
		return super.isOffsetPositionInLiquid(par1, par3, par5);
	}	@Override
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.moveEntity(par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}	public void superMoveEntity(double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
	}	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getBoundingBox() : super.getBoundingBox());
	}	public AxisAlignedBB superGetBoundingBox() {
		return super.getBoundingBox();
	}	@Override
	protected void dealFireDamage(int par1) {
		if (master != null) master.dealFireDamage(par1);
		else super.dealFireDamage(par1);
	}	public void superDealFireDamage(int par1) {
		super.dealFireDamage(par1);
	}	@Override
	public boolean isWet() {
		return master != null ? master.isWet() : super.isWet();
	}	public boolean superIsWet() {
		return super.isWet();
	}	@Override
	public boolean isInWater() {
		return master != null ? master.isInWater() : super.isInWater();
	}	public boolean superIsInWater() {
		return super.isInWater();
	}	@Override
	public boolean handleWaterMovement() {
		return master != null ? master.handleWaterMovement() : super.handleWaterMovement();
	}	public boolean superHandleWaterMovement() {
		return super.handleWaterMovement();
	}	@Override
	public boolean isInsideOfMaterial(Material material) {
		return master != null ? master.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}	public boolean superIsInsideOfMaterial(Object material) {
		return super.isInsideOfMaterial((Material) material);
	}	@Override
	public boolean handleLavaMovement() {
		return master != null ? master.handleLavaMovement() : super.handleLavaMovement();
	}	public boolean superHandleLavaMovement() {
		return super.handleLavaMovement();
	}	@Override
	public void moveFlying(float par1, float par2, float par3) {
		if (master != null) master.moveFlying(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}	public void superMoveFlying(float par1, float par2, float par3) {
		super.moveFlying(par1, par2, par3);
	}	@Override
	public int getBrightnessForRender(float par1) {
		return master != null ? master.getBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}	public int superGetBrightnessForRender(float par1) {
		return super.getBrightnessForRender(par1);
	}	@Override
	public float getBrightness(float par1) {
		return master != null ? master.getBrightness(par1) : super.getBrightness(par1);
	}	public float superGetBrightness(float par1) {
		return super.getBrightness(par1);
	}	@Override
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}	public void superSetWorld(Object world) {
		super.setWorld((World) world);
	}	@Override
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setPositionAndRotation(par1, par3, par5, par7, par8);
		else super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}	public void superSetPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}	@Override
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setLocationAndAngles(par1, par3, par5, par7, par8);
		else super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}	public void superSetLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}	@Override
	public float getDistanceToEntity(Entity entity) {
		return master != null ? master.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}	public float superGetDistanceToEntity(Object entity) {
		return super.getDistanceToEntity((Entity) entity);
	}	@Override
	public double getDistanceSq(double par1, double par3, double par5) {
		return master != null ? master.getDistanceSq(par1, par3, par5) : super.getDistanceSq(par1, par3, par5);
	}	public double superGetDistanceSq(double par1, double par3, double par5) {
		return super.getDistanceSq(par1, par3, par5);
	}	@Override
	public double getDistance(double par1, double par3, double par5) {
		return master != null ? master.getDistance(par1, par3, par5) : super.getDistance(par1, par3, par5);
	}	public double superGetDistance(double par1, double par3, double par5) {
		return super.getDistance(par1, par3, par5);
	}	@Override
	public double getDistanceSqToEntity(Entity entity) {
		return master != null ? master.getDistanceSqToEntity(entity) : super.getDistanceSqToEntity(entity);
	}	public double superGetDistanceSqToEntity(Object entity) {
		return super.getDistanceSqToEntity((Entity) entity);
	}	@Override
	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
		if (master != null) master.onCollideWithPlayer(entityPlayer);
		else super.onCollideWithPlayer(entityPlayer);
	}	public void superOnCollideWithPlayer(Object entityPlayer) {
		super.onCollideWithPlayer((EntityPlayer) entityPlayer);
	}	@Override
	public void applyEntityCollision(Entity entity) {
		if (master != null) master.applyEntityCollision(entity);
		else super.applyEntityCollision(entity);
	}	public void superApplyEntityCollision(Object entity) {
		super.applyEntityCollision((Entity) entity);
	}	@Override
	public void addVelocity(double par1, double par3, double par5) {
		if (master != null) master.addVelocity(par1, par3, par5);
		else super.addVelocity(par1, par3, par5);
	}	public void superAddVelocity(double par1, double par3, double par5) {
		super.addVelocity(par1, par3, par5);
	}	@Override
	public boolean isInRangeToRenderDist(double par1) {
		return master != null ? master.isInRangeToRenderDist(par1) : super.isInRangeToRenderDist(par1);
	}	public boolean superIsInRangeToRenderDist(double par1) {
		return super.isInRangeToRenderDist(par1);
	}	@Override
	public boolean writeMountToNBT(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeMountToNBT(nBTTagCompound) : super.writeMountToNBT(nBTTagCompound);
	}	public boolean superWriteMountToNBT(Object nBTTagCompound) {
		return super.writeMountToNBT((NBTTagCompound) nBTTagCompound);
	}	@Override
	public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTOptional(nBTTagCompound) : super.writeToNBTOptional(nBTTagCompound);
	}	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return super.writeToNBTOptional((NBTTagCompound) nBTTagCompound);
	}	@Override
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}	public void superWriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
	}	@Override
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}	public void superReadFromNBT(Object nBTTagCompound) {
		super.readFromNBT((NBTTagCompound) nBTTagCompound);
	}	@Override
	protected boolean shouldSetPosAfterLoading() {
		return master != null ? master.shouldSetPosAfterLoading() : super.shouldSetPosAfterLoading();
	}	public boolean superShouldSetPosAfterLoading() {
		return super.shouldSetPosAfterLoading();
	}	@Override
	public void onChunkLoad() {
		if (master != null) master.onChunkLoad();
		else super.onChunkLoad();
	}	public void superOnChunkLoad() {
		super.onChunkLoad();
	}	@Override
	protected NBTTagList newDoubleNBTList(double... par1ArrayOfDouble) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(par1ArrayOfDouble) : super.newDoubleNBTList(par1ArrayOfDouble));
	}	public NBTTagList superNewDoubleNBTList(double... par1ArrayOfDouble) {
		return super.newDoubleNBTList(par1ArrayOfDouble);
	}	@Override
	protected NBTTagList newFloatNBTList(float... par1ArrayOfFloat) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(par1ArrayOfFloat) : super.newFloatNBTList(par1ArrayOfFloat));
	}	public NBTTagList superNewFloatNBTList(float... par1ArrayOfFloat) {
		return super.newFloatNBTList(par1ArrayOfFloat);
	}	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float par2) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, par2) : super.entityDropItem(itemStack, par2));
	}	public EntityItem superEntityDropItem(Object itemStack, float par2) {
		return super.entityDropItem((ItemStack) itemStack, par2);
	}	@Override
	public float getShadowSize() {
		return master != null ? master.getShadowSize() : super.getShadowSize();
	}	public float superGetShadowSize() {
		return super.getShadowSize();
	}	@Override
	public boolean interactFirst(EntityPlayer entityPlayer) {
		return master != null ? master.interactFirst(entityPlayer) : super.interactFirst(entityPlayer);
	}	public boolean superInteractFirst(Object entityPlayer) {
		return super.interactFirst((EntityPlayer) entityPlayer);
	}	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBox(entity) : super.getCollisionBox(entity));
	}	public AxisAlignedBB superGetCollisionBox(Object entity) {
		return super.getCollisionBox((Entity) entity);
	}	@Override
	public void updateRiderPosition() {
		if (master != null) master.updateRiderPosition();
		else super.updateRiderPosition();
	}	public void superUpdateRiderPosition() {
		super.updateRiderPosition();
	}	@Override
	public float getCollisionBorderSize() {
		return master != null ? master.getCollisionBorderSize() : super.getCollisionBorderSize();
	}	public float superGetCollisionBorderSize() {
		return super.getCollisionBorderSize();
	}	@Override
	public void setInPortal() {
		if (master != null) master.setInPortal();
		else super.setInPortal();
	}	public void superSetInPortal() {
		super.setInPortal();
	}	@Override
	public void setVelocity(double par1, double par3, double par5) {
		if (master != null) master.setVelocity(par1, par3, par5);
		else super.setVelocity(par1, par3, par5);
	}	public void superSetVelocity(double par1, double par3, double par5) {
		super.setVelocity(par1, par3, par5);
	}	@Override
	public boolean isBurning() {
		return master != null ? master.isBurning() : super.isBurning();
	}	public boolean superIsBurning() {
		return super.isBurning();
	}	@Override
	public boolean isRiding() {
		return master != null ? master.isRiding() : super.isRiding();
	}	public boolean superIsRiding() {
		return super.isRiding();
	}	@Override
	public void setSneaking(boolean par1) {
		if (master != null) master.setSneaking(par1);
		else super.setSneaking(par1);
	}	public void superSetSneaking(boolean par1) {
		super.setSneaking(par1);
	}	@Override
	public boolean isSprinting() {
		return master != null ? master.isSprinting() : super.isSprinting();
	}	public boolean superIsSprinting() {
		return super.isSprinting();
	}	@Override
	public boolean isInvisible() {
		return master != null ? master.isInvisible() : super.isInvisible();
	}	public boolean superIsInvisible() {
		return super.isInvisible();
	}	@Override
	public void setInvisible(boolean par1) {
		if (master != null) master.setInvisible(par1);
		else super.setInvisible(par1);
	}	public void superSetInvisible(boolean par1) {
		super.setInvisible(par1);
	}	@Override
	public boolean isEating() {
		return master != null ? master.isEating() : super.isEating();
	}	public boolean superIsEating() {
		return super.isEating();
	}	@Override
	public void setEating(boolean par1) {
		if (master != null) master.setEating(par1);
		else super.setEating(par1);
	}	public void superSetEating(boolean par1) {
		super.setEating(par1);
	}	@Override
	protected boolean getFlag(int par1) {
		return master != null ? master.getFlag(par1) : super.getFlag(par1);
	}	public boolean superGetFlag(int par1) {
		return super.getFlag(par1);
	}	@Override
	protected void setFlag(int par1, boolean par2) {
		if (master != null) master.setFlag(par1, par2);
		else super.setFlag(par1, par2);
	}	public void superSetFlag(int par1, boolean par2) {
		super.setFlag(par1, par2);
	}	@Override
	public int getAir() {
		return master != null ? master.getAir() : super.getAir();
	}	public int superGetAir() {
		return super.getAir();
	}	@Override
	public void setAir(int par1) {
		if (master != null) master.setAir(par1);
		else super.setAir(par1);
	}	public void superSetAir(int par1) {
		super.setAir(par1);
	}	@Override
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		if (master != null) master.onStruckByLightning(entityLightningBolt);
		else super.onStruckByLightning(entityLightningBolt);
	}	public void superOnStruckByLightning(Object entityLightningBolt) {
		super.onStruckByLightning((EntityLightningBolt) entityLightningBolt);
	}	@Override
	public Entity[] getParts() {
		return (Entity[]) (master != null ? master.getParts() : super.getParts());
	}	public Entity[] superGetParts() {
		return super.getParts();
	}	@Override
	public boolean isEntityEqual(Entity entity) {
		return master != null ? master.isEntityEqual(entity) : super.isEntityEqual(entity);
	}	public boolean superIsEntityEqual(Object entity) {
		return super.isEntityEqual((Entity) entity);
	}	@Override
	public boolean canAttackWithItem() {
		return master != null ? master.canAttackWithItem() : super.canAttackWithItem();
	}	public boolean superCanAttackWithItem() {
		return super.canAttackWithItem();
	}	@Override
	public boolean hitByEntity(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.hitByEntity(entity);
	}	public boolean superHitByEntity(Object entity) {
		return super.hitByEntity((Entity) entity);
	}	@Override
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}	public String superToString() {
		return super.toString();
	}	@Override
	public boolean isEntityInvulnerable() {
		return master != null ? master.isEntityInvulnerable() : super.isEntityInvulnerable();
	}	public boolean superIsEntityInvulnerable() {
		return super.isEntityInvulnerable();
	}	@Override
	public void copyLocationAndAnglesFrom(Entity entity) {
		if (master != null) master.copyLocationAndAnglesFrom(entity);
		else super.copyLocationAndAnglesFrom(entity);
	}	public void superCopyLocationAndAnglesFrom(Object entity) {
		super.copyLocationAndAnglesFrom((Entity) entity);
	}	@Override
	public void copyDataFrom(Entity entity, boolean par2) {
		if (master != null) master.copyDataFrom(entity, par2);
		else super.copyDataFrom(entity, par2);
	}	public void superCopyDataFrom(Object entity, boolean par2) {
		super.copyDataFrom((Entity) entity, par2);
	}	@Override
	public void travelToDimension(int par1) {
		if (master != null) master.travelToDimension(par1);
		else super.travelToDimension(par1);
	}	public void superTravelToDimension(int par1) {
		super.travelToDimension(par1);
	}	@Override
	public int getMaxSafePointTries() {
		return master != null ? master.getMaxSafePointTries() : super.getMaxSafePointTries();
	}	public int superGetMaxSafePointTries() {
		return super.getMaxSafePointTries();
	}	@Override
	public int getTeleportDirection() {
		return master != null ? master.getTeleportDirection() : super.getTeleportDirection();
	}	public int superGetTeleportDirection() {
		return super.getTeleportDirection();
	}	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return master != null ? master.doesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}	public boolean superDoesEntityNotTriggerPressurePlate() {
		return super.doesEntityNotTriggerPressurePlate();
	}	@Override
	public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
		if (master != null) master.addEntityCrashInfo(crashReportCategory);
		else super.addEntityCrashInfo(crashReportCategory);
	}	public void superAddEntityCrashInfo(Object crashReportCategory) {
		super.addEntityCrashInfo((CrashReportCategory) crashReportCategory);
	}	@Override
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}	public boolean superCanRenderOnFire() {
		return super.canRenderOnFire();
	}	@Override
	public UUID getUniqueID() {
		return master != null ? master.getUniqueID() : super.getUniqueID();
	}	public UUID superGetUniqueID() {
		return super.getUniqueID();
	}	@Override
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (master != null ? master.getEntityData() : super.getEntityData());
	}	public NBTTagCompound superGetEntityData() {
		return super.getEntityData();
	}	@Override
	public boolean shouldRiderSit() {
		return master != null ? master.shouldRiderSit() : super.shouldRiderSit();
	}	public boolean superShouldRiderSit() {
		return super.shouldRiderSit();
	}	@Override
	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return (ItemStack) (master != null ? master.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return super.getPickedResult((MovingObjectPosition) movingObjectPosition);
	}	@Override
	public UUID getPersistentID() {
		return master != null ? master.getPersistentID() : super.getPersistentID();
	}	public UUID superGetPersistentID() {
		return super.getPersistentID();
	}	@Override
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}	public boolean superShouldRenderInPass(int pass) {
		return super.shouldRenderInPass(pass);
	}	@Override
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return master != null ? master.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}	@Override
	public String registerExtendedProperties(String identifier, IExtendedEntityProperties iExtendedEntityProperties) {
		return master != null ? master.registerExtendedProperties(identifier, iExtendedEntityProperties) : super.registerExtendedProperties(identifier, iExtendedEntityProperties);
	}	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return super.registerExtendedProperties(identifier, (IExtendedEntityProperties) iExtendedEntityProperties);
	}	@Override
	public IExtendedEntityProperties getExtendedProperties(String identifier) {
		return (IExtendedEntityProperties) (master != null ? master.getExtendedProperties(identifier) : super.getExtendedProperties(identifier));
	}	public IExtendedEntityProperties superGetExtendedProperties(String identifier) {
		return super.getExtendedProperties(identifier);
	}	@Override
	public boolean canRiderInteract() {
		return master != null ? master.canRiderInteract() : super.canRiderInteract();
	}	public boolean superCanRiderInteract() {
		return super.canRiderInteract();
	}	@Override
	public boolean shouldDismountInWater(Entity entity) {
		return master != null ? master.shouldDismountInWater(entity) : super.shouldDismountInWater(entity);
	}	public boolean superShouldDismountInWater(Object entity) {
		return super.shouldDismountInWater((Entity) entity);
	}
	// 172~
	@Override
	public void closeScreenNoPacket() {
		if (master != null) master.closeScreenNoPacket();
		else super.closeScreenNoPacket();
	}	public void superCloseScreenNoPacket() {
		super.closeScreenNoPacket();
	}	@Override
	public StatFileWriter getStatFileWriter() {
		return (StatFileWriter) (master != null ? master.getStatFileWriter() : super.getStatFileWriter());
	}	public StatFileWriter superGetStatFileWriter() {
		return super.getStatFileWriter();
	}	@Override
	public void func_146100_a(TileEntity tileEntity) {
		if (master != null) master.func_146100_a(tileEntity);
		else super.func_146100_a(tileEntity);
	}	public void superFunc_146100_a(Object tileEntity) {
		super.func_146100_a((TileEntity) tileEntity);
	}	@Override
	public void func_146095_a(CommandBlockLogic commandBlockLogic) {
		if (master != null) master.func_146095_a(commandBlockLogic);
		else super.func_146095_a(commandBlockLogic);
	}	public void superFunc_146095_a(Object commandBlockLogic) {
		super.func_146095_a((CommandBlockLogic) commandBlockLogic);
	}	@Override
	public void func_146093_a(TileEntityHopper tileEntityHopper) {
		if (master != null) master.func_146093_a(tileEntityHopper);
		else super.func_146093_a(tileEntityHopper);
	}	public void superFunc_146093_a(Object tileEntityHopper) {
		super.func_146093_a((TileEntityHopper) tileEntityHopper);
	}	@Override
	public void func_146104_a(TileEntityBeacon tileEntityBeacon) {
		if (master != null) master.func_146104_a(tileEntityBeacon);
		else super.func_146104_a(tileEntityBeacon);
	}	public void superFunc_146104_a(Object tileEntityBeacon) {
		super.func_146104_a((TileEntityBeacon) tileEntityBeacon);
	}	@Override
	public void func_146102_a(TileEntityDispenser tileEntityDispenser) {
		if (master != null) master.func_146102_a(tileEntityDispenser);
		else super.func_146102_a(tileEntityDispenser);
	}	public void superFunc_146102_a(Object tileEntityDispenser) {
		super.func_146102_a((TileEntityDispenser) tileEntityDispenser);
	}	@Override
	public void func_146098_a(TileEntityBrewingStand tileEntityBrewingStand) {
		if (master != null) master.func_146098_a(tileEntityBrewingStand);
		else super.func_146098_a(tileEntityBrewingStand);
	}	public void superFunc_146098_a(Object tileEntityBrewingStand) {
		super.func_146098_a((TileEntityBrewingStand) tileEntityBrewingStand);
	}	@Override
	public void func_146101_a(TileEntityFurnace tileEntityFurnace) {
		if (master != null) master.func_146101_a(tileEntityFurnace);
		else super.func_146101_a(tileEntityFurnace);
	}	public void superFunc_146101_a(Object tileEntityFurnace) {
		super.func_146101_a((TileEntityFurnace) tileEntityFurnace);
	}	@Override
	public void addChatMessage(IChatComponent iChatComponent) {
		if (master != null) master.addChatMessage(iChatComponent);
		else super.addChatMessage(iChatComponent);
	}	public void superAddChatMessage(Object iChatComponent) {
		super.addChatMessage((IChatComponent) iChatComponent);
	}	@Override
	public void addChatComponentMessage(IChatComponent iChatComponent) {
		if (master != null) master.addChatComponentMessage(iChatComponent);
		else super.addChatComponentMessage(iChatComponent);
	}	public void superAddChatComponentMessage(Object iChatComponent) {
		super.addChatComponentMessage((IChatComponent) iChatComponent);
	}	@Override
	protected String getSplashSound() {
		return master != null ? master.getSplashSound() : super.getSplashSound();
	}	public String superGetSplashSound() {
		return super.getSplashSound();
	}	@Override
	protected String getSwimSound() {
		return master != null ? master.getSwimSound() : super.getSwimSound();
	}	public String superGetSwimSound() {
		return super.getSwimSound();
	}	@Override
	public float getBreakSpeed(Block block, boolean p_146096_2_, int meta) {
		return master != null ? master.getBreakSpeed(block, p_146096_2_, meta) : super.getBreakSpeed(block, p_146096_2_, meta);
	}	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta) {
		return super.getBreakSpeed((Block) block, p_146096_2_, meta);
	}	@Override
	public float getBreakSpeed(Block block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return master != null ? master.getBreakSpeed(block, p_146096_2_, meta, x, y, z) : super.getBreakSpeed(block, p_146096_2_, meta, x, y, z);
	}	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return super.getBreakSpeed((Block) block, p_146096_2_, meta, x, y, z);
	}	@Override
	public EntityItem func_146097_a(ItemStack itemStack, boolean p_146097_2_, boolean p_146097_3_) {
		return (EntityItem) (master != null ? master.func_146097_a(itemStack, p_146097_2_, p_146097_3_) : super.func_146097_a(itemStack, p_146097_2_, p_146097_3_));
	}	public EntityItem superFunc_146097_a(Object itemStack, boolean p_146097_2_, boolean p_146097_3_) {
		return super.func_146097_a((ItemStack) itemStack, p_146097_2_, p_146097_3_);
	}	@Override
	public GameProfile getGameProfile() {
		return (GameProfile) (master != null ? master.getGameProfile() : super.getGameProfile());
	}	public GameProfile superGetGameProfile() {
		return super.getGameProfile();
	}	@Override
	protected String func_146067_o(int p_146067_1_) {
		return master != null ? master.func_146067_o(p_146067_1_) : super.func_146067_o(p_146067_1_);
	}	public String superFunc_146067_o(int p_146067_1_) {
		return super.func_146067_o(p_146067_1_);
	}	@Override
	public ItemStack getEquipmentInSlot(int par1) {
		return (ItemStack) (master != null ? master.getEquipmentInSlot(par1) : super.getEquipmentInSlot(par1));
	}	public ItemStack superGetEquipmentInSlot(int par1) {
		return super.getEquipmentInSlot(par1);
	}	@Override
	public IChatComponent func_145748_c_() {
		return (IChatComponent) (master != null ? master.func_145748_c_() : super.func_145748_c_());
	}	public IChatComponent superFunc_145748_c_() {
		return super.func_145748_c_();
	}	@Override
	protected boolean func_146066_aG() {
		return master != null ? master.func_146066_aG() : super.func_146066_aG();
	}	public boolean superFunc_146066_aG() {
		return super.func_146066_aG();
	}	@Override
	public int getEntityId() {
		return master != null ? master.getEntityId() : super.getEntityId();
	}	public int superGetEntityId() {
		return super.getEntityId();
	}	@Override
	public void setEntityId(int p_145769_1_) {
		if (master != null) master.setEntityId(p_145769_1_);
		else super.setEntityId(p_145769_1_);
	}	public void superSetEntityId(int p_145769_1_) {
		super.setEntityId(p_145769_1_);
	}	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block block) {
		if (master != null) master.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, block);
		else super.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, block);
	}	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
		super.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, (Block) block);
	}	@Override
	protected void func_145775_I() {
		if (master != null) master.func_145775_I();
		else super.func_145775_I();
	}	public void superFunc_145775_I() {
		super.func_145775_I();
	}	@Override
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return master != null ? master.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_) : super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}	@Override
	public EntityItem func_145778_a(Item item, int p_145778_2_, float p_145778_3_) {
		return (EntityItem) (master != null ? master.func_145778_a(item, p_145778_2_, p_145778_3_) : super.func_145778_a(item, p_145778_2_, p_145778_3_));
	}	public EntityItem superFunc_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return super.func_145778_a((Item) item, p_145778_2_, p_145778_3_);
	}	@Override
	public EntityItem dropItem(Item item, int p_145779_2_) {
		return (EntityItem) (master != null ? master.dropItem(item, p_145779_2_) : super.dropItem(item, p_145779_2_));
	}	public EntityItem superDropItem(Object item, int p_145779_2_) {
		return super.dropItem((Item) item, p_145779_2_);
	}	@Override
	public float func_145772_a(Explosion explosion, World world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block block) {
		return master != null ? master.func_145772_a(explosion, world, p_145772_3_, p_145772_4_, p_145772_5_, block) : super.func_145772_a(explosion, world, p_145772_3_, p_145772_4_, p_145772_5_, block);
	}	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return super.func_145772_a((Explosion) explosion, (World) world, p_145772_3_, p_145772_4_, p_145772_5_, (Block) block);
	}	@Override
	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return master != null ? master.func_145774_a(explosion, world, p_145774_3_, p_145774_4_, p_145774_5_, block, p_145774_7_) : super.func_145774_a(explosion, world, p_145774_3_, p_145774_4_, p_145774_5_, block, p_145774_7_);
	}	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return super.func_145774_a((Explosion) explosion, (World) world, p_145774_3_, p_145774_4_, p_145774_5_, (Block) block, p_145774_7_);
	}	@Override
	public void func_145781_i(int p_145781_1_) {
		if (master != null) master.func_145781_i(p_145781_1_);
		else super.func_145781_i(p_145781_1_);
	}	public void superFunc_145781_i(int p_145781_1_) {
		super.func_145781_i(p_145781_1_);
	}
	// ~164
	@Override
	public void superFunc_92015_f() {
	}	@Override
	public void superIncrementStat(Object statBase, int par2) {
	}	@Override
	public void superDisplayGUIEditSign(Object tileEntity) {
	}	@Override
	public void superDisplayGUIHopper(Object tileEntityHopper) {
	}	@Override
	public void superDisplayGUIFurnace(Object tileEntityFurnace) {
	}	@Override
	public void superDisplayGUIBrewingStand(Object tileEntityBrewingStand) {
	}	@Override
	public void superDisplayGUIBeacon(Object tileEntityBeacon) {
	}	@Override
	public void superDisplayGUIDispenser(Object tileEntityDispenser) {
	}	@Override
	public void superAddChatMessage(String par1Str) {
	}	@Override
	public void superSendChatToPlayer(Object chatMessageComponent) {
	}	@Override
	public Object superDropPlayerItem(Object itemStack) {
		return null;
	}	@Override
	public float superGetCurrentPlayerStrVsBlock(Object block, boolean par2, int meta) {
		return 0.0F;
	}	@Override
	public String superGetEntityName() {
		return null;
	}	@Override
	public Object superGetCurrentItemOrArmor(int par1) {
		return null;
	}	@Override
	public String superGetTranslatedEntityName() {
		return null;
	}	@Override
	public void superDoBlockCollisions() {
	}	@Override
	public void superPlayStepSound(int par1, int par2, int par3, int par4) {
	}	@Override
	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return false;
	}	@Override
	public Object superDropItem(int par1, int par2) {
		return null;
	}	@Override
	public Object superDropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}	@Override
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}
	// ~179
	protected void setupCustomSkin() {
	}	public void superSetupCustomSkin() {
	}	public ThreadDownloadImageData getTextureSkin() {
		return null;
	}	public ThreadDownloadImageData superGetTextureSkin() {
		return null;
	}	public ThreadDownloadImageData getTextureCape() {
		return null;
	}	public ThreadDownloadImageData superGetTextureCape() {
		return null;
	}
	// 179~
	@Override
	public boolean func_152122_n() {
		return master != null ? master.func_152122_n() : super.func_152122_n();
	}	public boolean superFunc_152122_n() {
		return super.func_152122_n();
	}	@Override
	public boolean func_152123_o() {
		return master != null ? master.func_152123_o() : super.func_152123_o();
	}	public boolean superFunc_152123_o() {
		return super.func_152123_o();
	}	@Override
	public void func_152121_a(Type type, ResourceLocation resourceLocation) {
		if (master != null) master.func_152121_a(type, resourceLocation);
		else super.func_152121_a(type, resourceLocation);
	}	public void superFunc_152121_a(Object type, Object resourceLocation) {
		super.func_152121_a((Type) type, (ResourceLocation) resourceLocation);
	}	@Override
	public void func_152111_bt() {
		if (master != null) master.func_152111_bt();
		else super.func_152111_bt();
	}	public void superFunc_152111_bt() {
		super.func_152111_bt();
	}	@Override
	public void func_152112_bu() {
		if (master != null) master.func_152112_bu();
		else super.func_152112_bu();
	}	public void superFunc_152112_bu() {
		super.func_152112_bu();
	}	@Override
	public void superOnUpdateWalkingPlayer() {
	}	@Override
	public void superFunc_175159_q() {
	}	@Override
	public boolean superIsUser() {
		return false;
	}	@Override
	public void superSendHorseJump() {
	}	@Override
	public void superSendHorseInventory() {
	}	@Override
	public void superSetClientBrand(String brand) {
	}	@Override
	public String superGetClientBrand() {
		return null;
	}	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return false;
	}	@Override
	public Object superGetPosition() {
		return null;
	}	@Override
	public boolean superIsServerWorld() {
		return false;
	}	@Override
	public void superOpenEditSign(Object tileEntitySign) {
	}	@Override
	public void superOpenEditCommandBlock(Object commandBlockLogic) {
	}	@Override
	public void superDisplayGui(Object iInteractionObject) {
	}	@Override
	public void superDisplayVillagerTradeGui(Object iMerchant) {
	}	@Override
	public boolean superIsCurrentViewEntity() {
		return false;
	}	@Override
	public boolean superIsSpectator() {
		return false;
	}	@Override
	public boolean superHasPlayerInfo() {
		return false;
	}	@Override
	public Object superGetPlayerInfo() {
		return null;
	}	@Override
	public boolean superHasSkin() {
		return false;
	}	@Override
	public String superGetSkinType() {
		return null;
	}	@Override
	public float superGetFovModifier() {
		return 0.0F;
	}	@Override
	public Object superDropItem(Object itemStack, boolean dropAround, boolean traceItem) {
		return null;
	}	@Override
	public float superGetToolDigEfficiency(Object block) {
		return 0.0F;
	}	@Override
	public float superGetBreakSpeed(Object iBlockState, Object blockPos) {
		return 0.0F;
	}	@Override
	public Object superTrySleep(Object blockPos) {
		return null;
	}	@Override
	public void superSetSpawnPoint(Object blockPos, boolean forced) {
	}	@Override
	public void superFunc_175145_a(Object statBase) {
	}	@Override
	public void superFall(float distance, float damageMultiplier) {
	}	@Override
	public String superGetFallSoundString(int damageValue) {
		return null;
	}	@Override
	public int superGetXPSeed() {
		return -1;
	}	@Override
	public void superRemoveExperienceLevel(int levels) {
	}	@Override
	public boolean superIsAllowEdit() {
		return false;
	}	@Override
	public boolean superCanPlayerEdit(Object blockPos, Object enumFacing, Object itemStack) {
		return false;
	}	@Override
	public String superGetName() {
		return null;
	}	@Override
	public Object[] superGetInventory() {
		return null;
	}	@Override
	public boolean superCanOpen(Object lockCode) {
		return false;
	}	@Override
	public boolean superFunc_175148_a(Object enumPlayerModelParts) {
		return false;
	}	@Override
	public boolean superSendCommandFeedback() {
		return false;
	}	@Override
	public boolean superReplaceItemInInventory(int p_174820_1_, Object itemStack) {
		return false;
	}	@Override
	public boolean superHasReducedDebug() {
		return false;
	}	@Override
	public void superSetReducedDebug(boolean reducedDebug) {
	}	@Override
	public String superGetDisplayNameString() {
		return null;
	}	@Override
	public void superOnKillCommand() {
	}	@Override
	public void superFunc_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}	@Override
	public int superGetRevengeTimer() {
		return -1;
	}	@Override
	public void superFunc_175135_B() {
	}	@Override
	public void superFunc_175133_bi() {
	}	@Override
	public void superAddRandomArmor() {
	}	@Override
	public Object superGetCombatTracker() {
		return null;
	}	@Override
	public float superFunc_175134_bD() {
		return 0.0F;
	}	@Override
	public void superFunc_180466_bG() {
	}	@Override
	public void superFunc_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
	}	@Override
	public void superFunc_175136_bO() {
	}	@Override
	public void superPlayStepSound(Object blockPos, Object block) {
	}	@Override
	public boolean superIsSilent() {
		return false;
	}	@Override
	public void superSetSilent(boolean isSilent) {
	}	@Override
	public void superSpawnRunningParticles() {
	}	@Override
	public void superCreateRunningParticles() {
	}	@Override
	public boolean superIsInLava() {
		return false;
	}	@Override
	public void superMoveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_) {
	}	@Override
	public double superGetDistanceSq(Object blockPos) {
		return 0.0D;
	}	@Override
	public double superGetDistanceSqToCenter(Object blockPos) {
		return 0.0D;
	}	@Override
	public Object superGetPositionEyes(float p_174824_1_) {
		return null;
	}	@Override
	public Object superDropItemWithOffset(Object item, int size, float p_145778_3_) {
		return null;
	}	@Override
	public boolean superIsEntityInvulnerable(Object damageSource) {
		return false;
	}	@Override
	public void superCopyDataFromOld(Object entity) {
	}	@Override
	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return 0.0F;
	}	@Override
	public boolean superFunc_174816_a(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return false;
	}	@Override
	public int superGetMaxFallHeight() {
		return -1;
	}	@Override
	public void superSetCustomNameTag(String p_96094_1_) {
	}	@Override
	public String superGetCustomNameTag() {
		return null;
	}	@Override
	public boolean superHasCustomName() {
		return false;
	}	@Override
	public void superSetAlwaysRenderNameTag(boolean p_174805_1_) {
	}	@Override
	public boolean superGetAlwaysRenderNameTag() {
		return false;
	}	@Override
	public Object superGetHorizontalFacing() {
		return null;
	}	@Override
	public Object superFunc_174823_aP() {
		return null;
	}	@Override
	public boolean superFunc_174827_a(Object entityPlayerMP) {
		return false;
	}	@Override
	public Object superGetEntityBoundingBox() {
		return null;
	}	@Override
	public void superSetEntityBoundingBox(Object axisAlignedBB) {
	}	@Override
	public boolean superIsOutsideBorder() {
		return false;
	}	@Override
	public void superSetOutsideBorder(boolean p_174821_1_) {
	}	@Override
	public Object superGetPositionVector() {
		return null;
	}	@Override
	public Object superGetCommandSenderEntity() {
		return null;
	}	@Override
	public void superSetCommandStat(Object type, int amount) {
	}	@Override
	public Object superFunc_174807_aT() {
		return null;
	}	@Override
	public void superFunc_174817_o(Object entity) {
	}	@Override
	public Object superFunc_174819_aU() {
		return null;
	}	@Override
	public void superFunc_174834_g(Object nBTTagCompound) {
	}	@Override
	public boolean superFunc_174825_a(Object entityPlayer, Object vec3) {
		return false;
	}	@Override
	public boolean superFunc_180427_aV() {
		return false;
	}	@Override
	public void superFunc_174815_a(Object entityLivingBase, Object entity) {
	}	@Override
	public void superHeal(int par1) {
	}	@Override
	public void superDamageEntity(Object damageSource, int par2) {
	}	@Override
	public boolean superFunc_71066_bF() {
		return false;
	}	@Override
	public void superUpdateCloak() {
	}	@Override
	public void superSendChatToPlayer(String par1Str) {
	}	@Override
	public int superGetMaxHealth() {
		return 0;
	}	@Override
	public boolean superFunc_96122_a(Object entityPlayer) {
		return false;
	}	@Override
	public void superAlertWolves(Object entityLiving, boolean par2) {
	}	@Override
	public void superDamageArmor(int par1) {
	}	@Override
	public float superFunc_82243_bO() {
		return 0;
	}	@Override
	public void superFunc_82162_bC() {
	}	@Override
	public boolean superCanCurrentToolHarvestBlock(int par1, int par2, int par3) {
		return false;
	}	@Override
	public boolean superFunc_94062_bN() {
		return false;
	}	@Override
	public boolean superFunc_94059_bO() {
		return false;
	}	@Override
	public boolean superCanPickUpLoot() {
		return false;
	}	@Override
	public Object superGetTranslator() {
		return null;
	}	@Override
	public String superTranslateString(String par1Str, Object... par2ArrayOfObj) {
		return null;
	}	@Override
	public boolean superFunc_98034_c(Object entityPlayer) {
		return false;
	}	@Override
	public boolean superFunc_96092_aw() {
		return false;
	}	@Override
	public int superFunc_96121_ay() {
		return 0;
	}	@Override
	public Object superGetLookHelper() {
		return null;
	}	@Override
	public Object superGetMoveHelper() {
		return null;
	}	@Override
	public Object superGetJumpHelper() {
		return null;
	}	@Override
	public Object superGetNavigator() {
		return null;
	}	@Override
	public Object superGetEntitySenses() {
		return null;
	}	@Override
	public Object superGetLastAttackingEntity() {
		return null;
	}	@Override
	public void superSetLastAttackingEntity(Object entity) {
	}	@Override
	public Object superGetAttackTarget() {
		return null;
	}	@Override
	public void superSetAttackTarget(Object entityLiving) {
	}	@Override
	public boolean superCanAttackClass(Class par1Class) {
		return false;
	}	@Override
	public void superEatGrassBonus() {
	}	@Override
	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return false;
	}	@Override
	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return false;
	}	@Override
	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
	}	@Override
	public Object superGetHomePosition() {
		return null;
	}	@Override
	public float superGetMaximumHomeDistance() {
		return 0;
	}	@Override
	public void superDetachHome() {
	}	@Override
	public boolean superHasHome() {
		return false;
	}	@Override
	public String superGetTexture() {
		return null;
	}	@Override
	public int superGetTalkInterval() {
		return 0;
	}	@Override
	public void superPlayLivingSound() {
	}	@Override
	public void superSpawnExplosionParticle() {
	}	@Override
	public int superGetHealth() {
		return 0;
	}	@Override
	public void superSetEntityHealth(int par1) {
	}	@Override
	public int superApplyArmorCalculations(Object damageSource, int par2) {
		return 0;
	}	@Override
	public int superApplyPotionDamageCalculations(Object damageSource, int par2) {
		return 0;
	}	@Override
	public String superGetLivingSound() {
		return null;
	}	@Override
	public void superKnockBack(Object entity, int par2, double par3, double par5) {
	}	@Override
	public int superGetDropItemId() {
		return 0;
	}	@Override
	public void superSetMoveForward(float par1) {
	}	@Override
	public void superFunc_85033_bc() {
	}	@Override
	public boolean superCanDespawn() {
		return false;
	}	@Override
	public void superDespawnEntity() {
	}	@Override
	public int superGetVerticalFaceSpeed() {
		return 0;
	}	@Override
	public void superFaceEntity(Object entity, float par2, float par3) {
	}	@Override
	public boolean superGetCanSpawnHere() {
		return false;
	}	@Override
	public float superGetRenderSizeModifier() {
		return 0;
	}	@Override
	public int superGetMaxSpawnedInChunk() {
		return 0;
	}	@Override
	public void superOnChangedPotionEffect(Object potionEffect) {
	}	@Override
	public float superGetSpeedModifier() {
		return 0;
	}	@Override
	public int superFunc_82143_as() {
		return 0;
	}	@Override
	public void superInitCreature() {
	}	@Override
	public boolean superCanBeSteered() {
		return false;
	}	@Override
	public void superFunc_94058_c(String par1Str) {
	}	@Override
	public String superFunc_94057_bL() {
		return null;
	}	@Override
	public boolean superFunc_94056_bM() {
		return false;
	}	@Override
	public void superFunc_94061_f(boolean par1) {
	}	@Override
	public void superFunc_96120_a(int par1, float par2) {
	}	@Override
	public void superSetCanPickUpLoot(boolean par1) {
	}	@Override
	public boolean superFunc_104002_bU() {
		return false;
	}	@Override
	public boolean superAddNotRiddenEntityID(Object nBTTagCompound) {
		return false;
	}	@Override
	public boolean superAddEntityID(Object nBTTagCompound) {
		return false;
	}	@Override
	public boolean superInteract(Object entityPlayer) {
		return false;
	}	@Override
	public void superUnmountEntity(Object entity) {
	}	@Override
	public boolean superFunc_85031_j(Object entity) {
		return false;
	}	@Override
	public void superFunc_82149_j(Object entity) {
	}	@Override
	public float superFunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0;
	}	@Override
	public boolean superFunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}	@Override
	public void superFunc_85029_a(Object crashReportCategory) {
	}}