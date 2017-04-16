package modchu.lib.forge.mc152;import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityPlayerSP;
import modchu.lib.Modchu_IEntityPlayerSPMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Session;
import net.minecraft.util.StringTranslate;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;public class Modchu_EntityPlayerSP extends EntityClientPlayerMP implements Modchu_IEntityPlayerSP {
	public Modchu_IEntityPlayerSPMaster master;
	public boolean initFlag;	public Modchu_EntityPlayerSP(HashMap<String, Object> map) {
		super((Minecraft)map.get("Object"), (World)map.get("Object1"), (Session)map.get("Object2"), (NetClientHandler)map.get("Object3"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityPlayerSP init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityPlayerSPMaster ? (Modchu_IEntityPlayerSPMaster) instance : null;
		if (master != null); else Modchu_Debug.lDebug("Modchu_EntityPlayerSP init master == null !!");
	}	@Override	public Object getRidingEntity2() {		return superGetRidingEntity();	}	@Override	public Object superGetRidingEntity2() {		return superGetRidingEntity();	}	@Override	public boolean isRiding2() {		return isRiding();	}	@Override	public boolean superIsRiding2() {		return superIsRiding();	}	@Override	public void dismountRidingEntity2() {		superDismountRidingEntity();	}	@Override	public void superDismountRidingEntity2() {		superDismountRidingEntity();	}	@Override
	public void init() {
		if (master != null) master.init();
		initFlag = true;
	}	@Override	public Object getFreeVariable(String s) {		return master.getFreeVariable(s);	}	@Override	public Object superGetFreeVariable(String s) {		return null;	}	@Override	public void setFreeVariable(String s, Object o) {		master.setFreeVariable(s, o);	}	@Override	public void superSetFreeVariable(String s, Object o) {	}	@Override
	public void wakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {
		super.wakeUpPlayer(flag, flag1, flag2);
		if (master != null) master.wakeUpPlayer(flag, flag1, flag2);
	}	@Override
	public void preparePlayerToSpawn() {
		super.preparePlayerToSpawn();
		if (master != null) master.preparePlayerToSpawn();
	}	@Override
	public void setPositionCorrection(double par1, double par3, double par5) {
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
		Modchu_Debug.mDebug("Modchu_EntityPlayerSP getHurtSound");
		if (master != null) return (String) master.getHurtSound();
		return super.getHurtSound();
	}	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		if (master != null) return (EnumCreatureAttribute) master.getCreatureAttribute();
		return super.getCreatureAttribute();
	}	@Override
	public EnumCreatureAttribute supergetCreatureAttribute() {
		return super.getCreatureAttribute();
	}	@Override
	protected void setSize(float f, float f1) {
		if (master != null) master.setSize(f, f1);
	}	@Override
	public void supersetSize(float f, float f1) {
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
	public boolean pushOutOfBlocks(double d, double d1, double d2) {
		if (master != null) return master.pushOutOfBlocks(d, d1, d2);
		return super.pushOutOfBlocks(d, d1, d2);
	}	@Override
	public boolean superpushOutOfBlocks(double d, double d1, double d2) {
		return super.pushOutOfBlocks(d, d1, d2);
	}	@Override
	public boolean isEntityInsideOpaqueBlock() {
		if (master != null) return master.isEntityInsideOpaqueBlock();
		return super.isEntityInsideOpaqueBlock();
	}	public void copyPlayer(EntityPlayer entityplayer) {
		if (master != null) master.copyPlayer(entityplayer);
	}	public void supercopyPlayer(EntityPlayer entityplayer) {
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
	}	@Override	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
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
	public void setHealth(int i) {
		if (master != null) master.setHealth(i);
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
		return (Float) (master != null ? master.getHealth() : super.getHealth());
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
		return super.getMaxHealth();
	}	@Override
	public float supergetHealth() {
		return super.getHealth();
	}	@Override
	public int supergetHealthInt() {
		return super.getHealth();
	}	@Override
	public void supersetHealth(float f) {
		super.setHealth((int) f);
	}	@Override
	public void supersetHealthInt(int i) {
		super.setHealth(i);
	}	@Override
	public void heal(int par1) {
		if (master != null) master.heal(par1);
		else super.heal(par1);
	}	@Override	public void superHeal(int par1) {
		super.heal(par1);
	}	@Override
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}	@Override	public void superOnUpdate() {
		super.onUpdate();
	}	@Override
	public EntityItem dropOneItem(boolean par1) {
		return (EntityItem) (master != null ? master.dropItem(par1) : super.dropOneItem(par1));
	}	@Override	public EntityItem superDropItem(boolean par1) {
		return super.dropOneItem(par1);
	}	@Override
	public void joinEntityItemWithWorld(EntityItem entityItem) {
		if (master != null) master.dropItemAndGetStack(entityItem);
		else super.joinEntityItemWithWorld(entityItem);
	}	@Override	public Object superDropItemAndGetStack(Object entityItem) {
		super.joinEntityItemWithWorld((EntityItem) entityItem);		return ((EntityItem) entityItem).getEntityItem();
	}	@Override
	public void sendChatMessage(String par1Str) {
		if (master != null) master.sendChatMessage(par1Str);
		else super.sendChatMessage(par1Str);
	}	@Override	public void superSendChatMessage(String par1Str) {
		super.sendChatMessage(par1Str);
	}	@Override
	public void swingItem() {
		if (master != null) master.swingArm();
		else super.swingItem();
	}	@Override	public void superSwingArm() {
		super.swingItem();
	}	@Override
	public void respawnPlayer() {
		if (master != null) master.respawnPlayer();
		else super.respawnPlayer();
	}	@Override	public void superRespawnPlayer() {
		super.respawnPlayer();
	}	@Override
	protected void damageEntity(DamageSource damageSource, int par2) {
		if (master != null) master.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
	}	@Override	public void superDamageEntity(Object damageSource, int par2) {
		super.damageEntity((DamageSource) damageSource, par2);
	}	@Override
	public void closeScreen() {
		if (master != null) master.closeScreen();
		else super.closeScreen();
	}	@Override	public void superCloseScreen() {
		super.closeScreen();
	}	@Override
	public void func_92015_f() {
		if (master != null) master.func_92015_f();
		else super.func_92015_f();
	}	@Override	public void superFunc_92015_f() {
		super.func_92015_f();
	}	@Override
	public void addStat(StatBase statBase, int par2) {
		if (master != null) master.addStat(statBase, par2);
		else super.addStat(statBase, par2);
	}	@Override	public void superAddStat(Object statBase, int par2) {
		super.addStat((StatBase) statBase, par2);
	}	@Override
	public void incrementStat(StatBase statBase, int par2) {
		if (master != null) master.incrementStat(statBase, par2);
		else super.incrementStat(statBase, par2);
	}	@Override	public void superIncrementStat(Object statBase, int par2) {
		super.incrementStat((StatBase) statBase, par2);
	}	@Override
	public void sendPlayerAbilities() {
		if (master != null) master.sendPlayerAbilities();
		else super.sendPlayerAbilities();
	}	@Override	public void superSendPlayerAbilities() {
		super.sendPlayerAbilities();
	}	@Override
	public boolean func_71066_bF() {
		return master != null ? master.func_71066_bF() : super.func_71066_bF();
	}	@Override	public boolean superFunc_71066_bF() {
		return super.func_71066_bF();
	}	@Override	public void moveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_) {		if (master != null) master.move(null, p_70091_1_, p_70091_3_, p_70091_5_);		else super.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);	}	@Override	public void superMove(Object moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {		super.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);	}	@Override
	public void updateEntityActionState() {
		if (master != null) master.updateEntityActionState();
		else super.updateEntityActionState();
	}	@Override	public void superUpdateEntityActionState() {
		super.updateEntityActionState();
	}	@Override
	protected boolean isClientWorld() {
		return master != null ? master.isClientWorld() : super.isClientWorld();
	}	@Override	public boolean superIsClientWorld() {
		return super.isClientWorld();
	}	@Override
	public float getFOVMultiplier() {
		return master != null ? master.getFOVMultiplier() : super.getFOVMultiplier();
	}	@Override	public float superGetFOVMultiplier() {
		return super.getFOVMultiplier();
	}	@Override
	public void updateCloak() {
		if (master != null) master.updateCloak();
		else super.updateCloak();
	}	@Override	public void superUpdateCloak() {
		super.updateCloak();
	}	@Override
	public void displayGUIEditSign(TileEntity tileEntity) {
		if (master != null) master.displayGUIEditSign(tileEntity);
		else super.displayGUIEditSign(tileEntity);
	}	@Override	public void superDisplayGUIEditSign(Object tileEntity) {
		super.displayGUIEditSign((TileEntity) tileEntity);
	}	@Override
	public void displayGUIBook(ItemStack itemStack) {
		if (master != null) master.openBook(itemStack);
		else super.displayGUIBook(itemStack);
	}	@Override	public void superOpenBook(Object itemStack) {
		super.displayGUIBook((ItemStack) itemStack);
	}	@Override
	public void displayGUIChest(IInventory iInventory) {
		if (master != null) master.displayGUIChest(iInventory);
		else super.displayGUIChest(iInventory);
	}	@Override	public void superDisplayGUIChest(Object iInventory) {
		super.displayGUIChest((IInventory) iInventory);
	}	@Override
	public void displayGUIHopper(TileEntityHopper tileEntityHopper) {
		if (master != null) master.displayGUIHopper(tileEntityHopper);
		else super.displayGUIHopper(tileEntityHopper);
	}	@Override	public void superDisplayGUIHopper(Object tileEntityHopper) {
		super.displayGUIHopper((TileEntityHopper) tileEntityHopper);
	}	@Override
	public void displayGUIHopperMinecart(EntityMinecartHopper entityMinecartHopper) {
		if (master != null) master.displayGUIHopperMinecart(entityMinecartHopper);
		else super.displayGUIHopperMinecart(entityMinecartHopper);
	}	@Override	public void superDisplayGUIHopperMinecart(Object entityMinecartHopper) {
		super.displayGUIHopperMinecart((EntityMinecartHopper) entityMinecartHopper);
	}	@Override
	public void displayGUIWorkbench(int par1, int par2, int par3) {
		if (master != null) master.displayGUIWorkbench(par1, par2, par3);
		else super.displayGUIWorkbench(par1, par2, par3);
	}	@Override	public void superDisplayGUIWorkbench(int par1, int par2, int par3) {
		super.displayGUIWorkbench(par1, par2, par3);
	}	@Override
	public void displayGUIEnchantment(int par1, int par2, int par3, String par4Str) {
		if (master != null) master.displayGUIEnchantment(par1, par2, par3, par4Str);
		else super.displayGUIEnchantment(par1, par2, par3, par4Str);
	}	@Override	public void superDisplayGUIEnchantment(int par1, int par2, int par3, String par4Str) {
		super.displayGUIEnchantment(par1, par2, par3, par4Str);
	}	@Override
	public void displayGUIAnvil(int par1, int par2, int par3) {
		if (master != null) master.displayGUIAnvil(par1, par2, par3);
		else super.displayGUIAnvil(par1, par2, par3);
	}	@Override	public void superDisplayGUIAnvil(int par1, int par2, int par3) {
		super.displayGUIAnvil(par1, par2, par3);
	}	@Override
	public void displayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
		if (master != null) master.displayGUIFurnace(tileEntityFurnace);
		else super.displayGUIFurnace(tileEntityFurnace);
	}	@Override	public void superDisplayGUIFurnace(Object tileEntityFurnace) {
		super.displayGUIFurnace((TileEntityFurnace) tileEntityFurnace);
	}	@Override
	public void displayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
		if (master != null) master.displayGUIBrewingStand(tileEntityBrewingStand);
		else super.displayGUIBrewingStand(tileEntityBrewingStand);
	}	@Override	public void superDisplayGUIBrewingStand(Object tileEntityBrewingStand) {
		super.displayGUIBrewingStand((TileEntityBrewingStand) tileEntityBrewingStand);
	}	@Override
	public void displayGUIBeacon(TileEntityBeacon tileEntityBeacon) {
		if (master != null) master.displayGUIBeacon(tileEntityBeacon);
		else super.displayGUIBeacon(tileEntityBeacon);
	}	@Override	public void superDisplayGUIBeacon(Object tileEntityBeacon) {
		super.displayGUIBeacon((TileEntityBeacon) tileEntityBeacon);
	}	@Override
	public void displayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
		if (master != null) master.displayGUIDispenser(tileEntityDispenser);
		else super.displayGUIDispenser(tileEntityDispenser);
	}	@Override	public void superDisplayGUIDispenser(Object tileEntityDispenser) {
		super.displayGUIDispenser((TileEntityDispenser) tileEntityDispenser);
	}	@Override
	public void displayGUIMerchant(IMerchant iMerchant, String par2Str) {
		if (master != null) master.displayGUIMerchant(iMerchant, par2Str);
		else super.displayGUIMerchant(iMerchant, par2Str);
	}	@Override	public void superDisplayGUIMerchant(Object iMerchant, String par2Str) {
		super.displayGUIMerchant((IMerchant) iMerchant, par2Str);
	}	@Override
	public void onCriticalHit(Entity entity) {
		if (master != null) master.onCriticalHit(entity);
		else super.onCriticalHit(entity);
	}	@Override	public void superOnCriticalHit(Object entity) {
		super.onCriticalHit((Entity) entity);
	}	@Override
	public void onEnchantmentCritical(Entity entity) {
		if (master != null) master.onEnchantmentCritical(entity);
		else super.onEnchantmentCritical(entity);
	}	@Override	public void superOnEnchantmentCritical(Object entity) {
		super.onEnchantmentCritical((Entity) entity);
	}	@Override
	public void onItemPickup(Entity entity, int par2) {
		if (master != null) master.onItemPickup(entity, par2);
		else super.onItemPickup(entity, par2);
	}	@Override	public void superOnItemPickup(Object entity, int par2) {
		super.onItemPickup((Entity) entity, par2);
	}	@Override
	public boolean isSneaking() {
		return master != null ? master.isSneaking() : super.isSneaking();
	}	@Override	public boolean superIsSneaking() {
		return super.isSneaking();
	}	@Override
	public void addChatMessage(String par1Str) {
		if (master != null) master.sendMessage(par1Str);
		else super.addChatMessage(par1Str);
	}	@Override	public void superSendMessage(String par1Str) {
		super.addChatMessage(par1Str);
	}	@Override
	public void setSprinting(boolean par1) {
		if (master != null) master.setSprinting(par1);
		else super.setSprinting(par1);
	}	@Override	public void superSetSprinting(boolean par1) {
		super.setSprinting(par1);
	}	@Override
	public void setXPStats(float par1, int par2, int par3) {
		if (master != null) master.setXPStats(par1, par2, par3);
		else super.setXPStats(par1, par2, par3);
	}	@Override	public void superSetXPStats(float par1, int par2, int par3) {
		super.setXPStats(par1, par2, par3);
	}	@Override
	public void sendChatToPlayer(String par1Str) {
		if (master != null) master.sendChatToPlayer(par1Str);
		else super.sendChatToPlayer(par1Str);
	}	@Override	public void superSendChatToPlayer(String par1Str) {
		super.sendChatToPlayer(par1Str);
	}	@Override
	public boolean canCommandSenderUseCommand(int par1, String par2Str) {
		return master != null ? master.canUseCommand(par1, par2Str) : super.canCommandSenderUseCommand(par1, par2Str);
	}	@Override	public boolean superCanUseCommand(int par1, String par2Str) {
		return super.canCommandSenderUseCommand(par1, par2Str);
	}	@Override
	public ChunkCoordinates getPlayerCoordinates() {
		return (ChunkCoordinates) (master != null ? master.getPlayerCoordinates() : super.getPlayerCoordinates());
	}	@Override	public ChunkCoordinates superGetPlayerCoordinates() {
		return super.getPlayerCoordinates();
	}	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}	@Override	public ItemStack superGetHeldItem() {
		return super.getHeldItem();
	}	@Override
	public void playSound(String par1Str, float par2, float par3) {
		if (master != null) master.playSound(par1Str, par2, par3);
		else super.playSound(par1Str, par2, par3);
	}	@Override	public void superPlaySound(Object par1Str, float par2, float par3) {
		super.playSound((String) par1Str, par2, par3);
	}	@Override
	public int getMaxHealth() {
		return (int) (master != null ? master.getMaxHealth() : super.getMaxHealth());
	}	@Override	public int superGetMaxHealth() {
		return super.getMaxHealth();
	}	@Override
	protected void entityInit() {
		if (master != null) master.entityInit();
		else super.entityInit();
	}	@Override	public void superEntityInit() {
		super.entityInit();
	}	@Override
	public ItemStack getItemInUse() {
		return (ItemStack) (master != null ? master.getItemInUse() : super.getItemInUse());
	}	@Override	public ItemStack superGetItemInUse() {
		return super.getItemInUse();
	}	@Override
	public int getItemInUseCount() {
		return master != null ? master.getItemInUseCount() : super.getItemInUseCount();
	}	@Override	public int superGetItemInUseCount() {
		return super.getItemInUseCount();
	}	@Override
	public boolean isUsingItem() {
		return master != null ? master.isHandActive() : super.isUsingItem();
	}	@Override	public boolean superIsHandActive() {
		return super.isUsingItem();
	}	@Override
	public int getItemInUseDuration() {
		return master != null ? master.getItemInUseDuration() : super.getItemInUseDuration();
	}	@Override	public int superGetItemInUseDuration() {
		return super.getItemInUseDuration();
	}	@Override
	public void stopUsingItem() {
		if (master != null) master.stopUsingItem();
		else super.stopUsingItem();
	}	@Override	public void superStopUsingItem() {
		super.stopUsingItem();
	}	@Override
	public void clearItemInUse() {
		if (master != null) master.clearItemInUse();
		else super.clearItemInUse();
	}	@Override	public void superClearItemInUse() {
		super.clearItemInUse();
	}	@Override
	public boolean isBlocking() {
		return master != null ? master.isBlocking() : super.isBlocking();
	}	@Override	public boolean superIsBlocking() {
		return super.isBlocking();
	}	@Override
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}	@Override	public int superGetMaxInPortalTime() {
		return super.getMaxInPortalTime();
	}	@Override
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}	@Override	public int superGetPortalCooldown() {
		return super.getPortalCooldown();
	}	@Override
	protected void updateItemUse(ItemStack itemStack, int par2) {
		if (master != null) master.updateItemUse(itemStack, par2);
		else super.updateItemUse(itemStack, par2);
	}	@Override	public void superUpdateItemUse(Object itemStack, int par2) {
		super.updateItemUse((ItemStack) itemStack, par2);
	}	@Override
	protected void onItemUseFinish() {
		if (master != null) master.onItemUseFinish();
		else super.onItemUseFinish();
	}	@Override	public void superOnItemUseFinish() {
		super.onItemUseFinish();
	}	@Override
	public void handleHealthUpdate(byte par1) {
		if (master != null) master.handleStatusUpdate(par1);
		else super.handleHealthUpdate(par1);
	}	@Override	public void superHandleStatusUpdate(byte par1) {
		super.handleHealthUpdate(par1);
	}	@Override
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}	@Override	public boolean superIsMovementBlocked() {
		return super.isMovementBlocked();
	}	@Override
	public void mountEntity(Entity entity) {
		if (master != null) master.startRiding(entity);
		else super.mountEntity(entity);
	}	@Override	public boolean superStartRiding(Object entity) {
		super.mountEntity((Entity) entity);		return true;
	}	@Override
	public int getScore() {
		return master != null ? master.getScore() : super.getScore();
	}	@Override	public int superGetScore() {
		return super.getScore();
	}	@Override
	public void setScore(int par1) {
		if (master != null) master.setScore(par1);
		else super.setScore(par1);
	}	@Override	public void superSetScore(int par1) {
		super.setScore(par1);
	}	@Override
	public void addScore(int par1) {
		if (master != null) master.addScore(par1);
		else super.addScore(par1);
	}	@Override	public void superAddScore(int par1) {
		super.addScore(par1);
	}	@Override
	public void addToPlayerScore(Entity entity, int par2) {
		if (master != null) master.addToPlayerScore(entity, par2);
		else super.addToPlayerScore(entity, par2);
	}	@Override	public void superAddToPlayerScore(Object entity, int par2) {
		super.addToPlayerScore((Entity) entity, par2);
	}	@Override
	public EntityItem dropPlayerItem(ItemStack itemStack) {
		return (EntityItem) (master != null ? master.dropPlayerItem(itemStack) : super.dropPlayerItem(itemStack));
	}	@Override	public EntityItem superDropPlayerItem(Object itemStack) {
		return super.dropPlayerItem((ItemStack) itemStack);
	}	@Override
	public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean par2) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, par2) : super.dropPlayerItemWithRandomChoice(itemStack, par2));
	}	@Override	public EntityItem superDropItem(Object itemStack, boolean par2) {
		return super.dropPlayerItemWithRandomChoice((ItemStack) itemStack, par2);
	}	@Override
	public float getCurrentPlayerStrVsBlock(Block block, boolean par2) {
		return master != null ? master.getCurrentPlayerStrVsBlock(block, par2) : super.getCurrentPlayerStrVsBlock(block, par2);
	}	@Override	public float superGetCurrentPlayerStrVsBlock(Object block, boolean par2) {
		return super.getCurrentPlayerStrVsBlock((Block) block, par2);
	}	@Override
	public float getCurrentPlayerStrVsBlock(Block block, boolean par2, int meta) {
		return master != null ? master.getCurrentPlayerStrVsBlock(block, par2, meta) : super.getCurrentPlayerStrVsBlock(block, par2, meta);
	}	@Override	public float superGetCurrentPlayerStrVsBlock(Object block, boolean par2, int meta) {
		return super.getCurrentPlayerStrVsBlock((Block) block, par2, meta);
	}	@Override
	public boolean canHarvestBlock(Block block) {
		return master != null ? master.canHarvestBlock(block) : super.canHarvestBlock(block);
	}	@Override	public boolean superCanHarvestBlock(Object block) {
		return super.canHarvestBlock((Block) block);
	}	@Override
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}	@Override	public void superReadEntityFromNBT(Object nBTTagCompound) {
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}	@Override
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeEntityToNBT(nBTTagCompound);
		else super.writeEntityToNBT(nBTTagCompound);
	}	@Override	public void superWriteEntityToNBT(Object nBTTagCompound) {
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
	}	@Override
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}	@Override	public float superGetEyeHeight() {
		return super.getEyeHeight();
	}	@Override
	public boolean func_96122_a(EntityPlayer entityPlayer) {
		return master != null ? master.canAttackPlayer(entityPlayer) : super.func_96122_a(entityPlayer);
	}	@Override	public boolean superCanAttackPlayer(Object entityPlayer) {
		return super.func_96122_a((EntityPlayer) entityPlayer);
	}	@Override
	protected void alertWolves(EntityLiving entityLiving, boolean par2) {
		if (master != null) master.alertWolves(entityLiving, par2);
		else super.alertWolves(entityLiving, par2);
	}	@Override	public void superAlertWolves(Object entityLiving, boolean par2) {
		super.alertWolves((EntityLiving) entityLiving, par2);
	}	@Override
	protected void damageArmor(int par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}	@Override	public void superDamageArmor(int par1) {
		super.damageArmor(par1);
	}	@Override
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}	@Override	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}	@Override
	public float func_82243_bO() {
		return master != null ? master.getArmorVisibility() : super.func_82243_bO();
	}	@Override	public float superGetArmorVisibility() {
		return super.func_82243_bO();
	}	@Override
	public boolean interactWith(Entity entity) {
		return master != null ? master.interactWith(entity) : super.interactWith(entity);
	}	@Override	public boolean superInteractWith(Object entity) {
		return super.interactWith((Entity) entity);
	}	@Override
	public ItemStack getCurrentEquippedItem() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getCurrentEquippedItem());
	}	@Override	public ItemStack superGetHeldItemMainhand() {
		return super.getCurrentEquippedItem();
	}	@Override
	public void destroyCurrentEquippedItem() {
		if (master != null) master.destroyCurrentEquippedItem();
		else super.destroyCurrentEquippedItem();
	}	@Override	public void superDestroyCurrentEquippedItem() {
		super.destroyCurrentEquippedItem();
	}	@Override
	public void attackTargetEntityWithCurrentItem(Entity entity) {
		if (master != null) master.attackTargetEntityWithCurrentItem(entity);
		else super.attackTargetEntityWithCurrentItem(entity);
	}	@Override	public void superAttackTargetEntityWithCurrentItem(Object entity) {
		super.attackTargetEntityWithCurrentItem((Entity) entity);
	}	@Override
	public void setDead() {
		if (master != null) master.setDead();
		else super.setDead();
	}	@Override	public void superSetDead() {
		super.setDead();
	}	@Override
	public EnumStatus sleepInBedAt(int par1, int par2, int par3) {
		return (EnumStatus) (master != null ? master.sleepInBedAt(par1, par2, par3) : super.sleepInBedAt(par1, par2, par3));
	}	@Override	public EnumStatus superSleepInBedAt(int par1, int par2, int par3) {
		return super.sleepInBedAt(par1, par2, par3);
	}	@Override
	public float getBedOrientationInDegrees() {
		return master != null ? master.getBedOrientationInDegrees() : super.getBedOrientationInDegrees();
	}	@Override	public float superGetBedOrientationInDegrees() {
		return super.getBedOrientationInDegrees();
	}	@Override
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}	@Override	public boolean superIsPlayerSleeping() {
		return super.isPlayerSleeping();
	}	@Override
	public boolean isPlayerFullyAsleep() {
		return master != null ? master.isPlayerFullyAsleep() : super.isPlayerFullyAsleep();
	}	@Override	public boolean superIsPlayerFullyAsleep() {
		return super.isPlayerFullyAsleep();
	}	@Override
	public int getSleepTimer() {
		return master != null ? master.getSleepTimer() : super.getSleepTimer();
	}	@Override	public int superGetSleepTimer() {
		return super.getSleepTimer();
	}	@Override
	protected boolean getHideCape(int par1) {
		return master != null ? master.getHideCape(par1) : super.getHideCape(par1);
	}	@Override	public boolean superGetHideCape(int par1) {
		return super.getHideCape(par1);
	}	@Override
	protected void setHideCape(int par1, boolean par2) {
		if (master != null) master.setHideCape(par1, par2);
		else super.setHideCape(par1, par2);
	}	@Override	public void superSetHideCape(int par1, boolean par2) {
		super.setHideCape(par1, par2);
	}	@Override
	public ChunkCoordinates getBedLocation() {
		return (ChunkCoordinates) (master != null ? master.getBedLocation() : super.getBedLocation());
	}	@Override	public ChunkCoordinates superGetBedLocation() {
		return super.getBedLocation();
	}	@Override
	public boolean isSpawnForced() {
		return master != null ? master.isSpawnForced() : super.isSpawnForced();
	}	@Override	public boolean superIsSpawnForced() {
		return super.isSpawnForced();
	}	@Override
	public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean par2) {
		if (master != null) master.setSpawnChunk(chunkCoordinates, par2);
		else super.setSpawnChunk(chunkCoordinates, par2);
	}	@Override	public void superSetSpawnChunk(Object chunkCoordinates, boolean par2) {
		super.setSpawnChunk((ChunkCoordinates) chunkCoordinates, par2);
	}	@Override
	public void triggerAchievement(StatBase statBase) {
		if (master != null) master.addStat(statBase);
		else super.triggerAchievement(statBase);
	}	@Override	public void superAddStat(Object statBase) {
		super.triggerAchievement((StatBase) statBase);
	}	@Override
	protected void jump() {
		if (master != null) master.jump();
		else super.jump();
	}	@Override	public void superJump() {
		super.jump();
	}	@Override
	public void addMovementStat(double par1, double par3, double par5) {
		if (master != null) master.addMovementStat(par1, par3, par5);
		else super.addMovementStat(par1, par3, par5);
	}	@Override	public void superAddMovementStat(double par1, double par3, double par5) {
		super.addMovementStat(par1, par3, par5);
	}	@Override
	protected void fall(float par1) {
		if (master != null) master.fall(par1);
		else super.fall(par1);
	}	@Override	public void superFall(float par1) {
		super.fall(par1);
	}	@Override
	public void onKillEntity(EntityLiving entityLiving) {
		if (master != null) master.onKillEntity(entityLiving);
		else super.onKillEntity(entityLiving);
	}	@Override	public void superOnKillEntity(Object entityLiving) {
		super.onKillEntity((EntityLiving) entityLiving);
	}	@Override
	public void setInWeb() {
		if (master != null) master.setInWeb();
		else super.setInWeb();
	}	@Override	public void superSetInWeb() {
		super.setInWeb();
	}	@Override
	public Icon getItemIcon(ItemStack itemStack, int par2) {
		return (Icon) (master != null ? master.getItemIcon(itemStack, par2) : super.getItemIcon(itemStack, par2));
	}	@Override	public Icon superGetItemIcon(Object itemStack, int par2) {
		return super.getItemIcon((ItemStack) itemStack, par2);
	}	@Override
	public ItemStack getCurrentArmor(int par1) {
		return (ItemStack) (master != null ? master.getCurrentArmor(par1) : super.getCurrentArmor(par1));
	}	@Override	public ItemStack superGetCurrentArmor(int par1) {
		return super.getCurrentArmor(par1);
	}	@Override
	protected void addRandomArmor() {
		if (master != null) master.dropLoot();
		else super.addRandomArmor();
	}	@Override	public void superDropLoot() {
		super.addRandomArmor();
	}	@Override
	protected void func_82162_bC() {
		if (master != null) master.func_82162_bC();
		else super.func_82162_bC();
	}	@Override	public void superFunc_82162_bC() {
		super.func_82162_bC();
	}	@Override
	public void addExperience(int par1) {
		if (master != null) master.addExperience(par1);
		else super.addExperience(par1);
	}	@Override	public void superAddExperience(int par1) {
		super.addExperience(par1);
	}	@Override
	public void addExperienceLevel(int par1) {
		if (master != null) master.addExperienceLevel(par1);
		else super.addExperienceLevel(par1);
	}	@Override	public void superAddExperienceLevel(int par1) {
		super.addExperienceLevel(par1);
	}	@Override
	public int xpBarCap() {
		return master != null ? master.xpBarCap() : super.xpBarCap();
	}	@Override	public int superXpBarCap() {
		return super.xpBarCap();
	}	@Override
	public void addExhaustion(float par1) {
		if (master != null) master.addExhaustion(par1);
		else super.addExhaustion(par1);
	}	@Override	public void superAddExhaustion(float par1) {
		super.addExhaustion(par1);
	}	@Override
	public FoodStats getFoodStats() {
		return (FoodStats) (master != null ? master.getFoodStats() : super.getFoodStats());
	}	@Override	public FoodStats superGetFoodStats() {
		return super.getFoodStats();
	}	@Override
	public boolean canEat(boolean par1) {
		return master != null ? master.canEat(par1) : super.canEat(par1);
	}	@Override	public boolean superCanEat(boolean par1) {
		return super.canEat(par1);
	}	@Override
	public boolean shouldHeal() {
		return master != null ? master.shouldHeal() : super.shouldHeal();
	}	@Override	public boolean superShouldHeal() {
		return super.shouldHeal();
	}	@Override
	public void setItemInUse(ItemStack itemStack, int par2) {
		if (master != null) master.setItemInUse(itemStack, par2);
		else super.setItemInUse(itemStack, par2);
	}	@Override	public void superSetItemInUse(Object itemStack, int par2) {
		super.setItemInUse((ItemStack) itemStack, par2);
	}	@Override
	public boolean canCurrentToolHarvestBlock(int par1, int par2, int par3) {
		return master != null ? master.canCurrentToolHarvestBlock(par1, par2, par3) : super.canCurrentToolHarvestBlock(par1, par2, par3);
	}	@Override	public boolean superCanCurrentToolHarvestBlock(int par1, int par2, int par3) {
		return super.canCurrentToolHarvestBlock(par1, par2, par3);
	}	@Override
	public boolean canPlayerEdit(int par1, int par2, int par3, int par4, ItemStack itemStack) {
		return master != null ? master.canPlayerEdit(par1, par2, par3, par4, itemStack) : super.canPlayerEdit(par1, par2, par3, par4, itemStack);
	}	@Override	public boolean superCanPlayerEdit(int par1, int par2, int par3, int par4, Object itemStack) {
		return super.canPlayerEdit(par1, par2, par3, par4, (ItemStack) itemStack);
	}	@Override
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return master != null ? master.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}	@Override	public int superGetExperiencePoints(Object entityPlayer) {
		return super.getExperiencePoints((EntityPlayer) entityPlayer);
	}	@Override
	protected boolean isPlayer() {
		return master != null ? master.isPlayer() : super.isPlayer();
	}	@Override	public boolean superIsPlayer() {
		return super.isPlayer();
	}	@Override
	public String getEntityName() {
		return master != null ? master.getEntityName() : super.getEntityName();
	}	@Override	public String superGetEntityName() {
		return super.getEntityName();
	}	@Override
	public boolean func_94062_bN() {
		return master != null ? master.func_94062_bN() : super.func_94062_bN();
	}	@Override	public boolean superFunc_94062_bN() {
		return super.func_94062_bN();
	}	@Override
	public boolean func_94059_bO() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.func_94059_bO();
	}	@Override	public boolean superGetAlwaysRenderNameTagForRender() {
		return super.func_94059_bO();
	}	@Override
	public boolean canPickUpLoot() {
		return master != null ? master.canPickUpLoot() : super.canPickUpLoot();
	}	@Override	public boolean superCanPickUpLoot() {
		return super.canPickUpLoot();
	}	@Override
	public void clonePlayer(EntityPlayer entityPlayer, boolean par2) {
		if (master != null) master.clonePlayer(entityPlayer, par2);
		else super.clonePlayer(entityPlayer, par2);
	}	@Override	public void superClonePlayer(Object entityPlayer, boolean par2) {
		super.clonePlayer((EntityPlayer) entityPlayer, par2);
	}	@Override
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}	@Override	public boolean superCanTriggerWalking() {
		return super.canTriggerWalking();
	}	@Override
	public void setGameType(EnumGameType enumGameType) {
		if (master != null) master.setGameType(enumGameType);
		else super.setGameType(enumGameType);
	}	@Override	public void superSetGameType(Object enumGameType) {
		super.setGameType((EnumGameType) enumGameType);
	}	@Override
	public String getCommandSenderName() {
		return master != null ? master.getName() : super.getCommandSenderName();
	}	@Override	public String superGetName() {
		return super.getCommandSenderName();
	}	@Override
	public StringTranslate getTranslator() {
		return (StringTranslate) (master != null ? master.getTranslator() : super.getTranslator());
	}	@Override	public StringTranslate superGetTranslator() {
		return super.getTranslator();
	}	@Override
	public String translateString(String par1Str, Object... par2ArrayOfObj) {
		return master != null ? master.translateString(par1Str, par2ArrayOfObj) : super.translateString(par1Str, par2ArrayOfObj);
	}	@Override	public String superTranslateString(String par1Str, Object... par2ArrayOfObj) {
		return super.translateString(par1Str, par2ArrayOfObj);
	}	@Override
	public InventoryEnderChest getInventoryEnderChest() {
		return (InventoryEnderChest) (master != null ? master.getInventoryEnderChest() : super.getInventoryEnderChest());
	}	@Override	public InventoryEnderChest superGetInventoryEnderChest() {
		return super.getInventoryEnderChest();
	}	@Override
	public ItemStack getCurrentItemOrArmor(int par1) {
		return (ItemStack) (master != null ? master.getCurrentItemOrArmor(par1) : super.getCurrentItemOrArmor(par1));
	}	@Override	public ItemStack superGetCurrentItemOrArmor(int par1) {
		return super.getCurrentItemOrArmor(par1);
	}	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack itemStack) {
		if (master != null) master.setCurrentItemOrArmor(par1, itemStack);
		else super.setCurrentItemOrArmor(par1, itemStack);
	}	@Override	public void superSetCurrentItemOrArmor(int par1, Object itemStack) {
		super.setCurrentItemOrArmor(par1, (ItemStack) itemStack);
	}	@Override
	public boolean func_98034_c(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.func_98034_c(entityPlayer);
	}	@Override	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return super.func_98034_c((EntityPlayer) entityPlayer);
	}	@Override
	public ItemStack[] getLastActiveItems() {
		return (ItemStack[]) (master != null ? master.getLastActiveItems() : super.getLastActiveItems());
	}	@Override	public ItemStack[] superGetLastActiveItems() {
		return super.getLastActiveItems();
	}	@Override
	public boolean getHideCape() {
		return master != null ? master.getHideCape() : super.getHideCape();
	}	@Override	public boolean superGetHideCape() {
		return super.getHideCape();
	}	@Override
	public boolean func_96092_aw() {
		return master != null ? master.isPushedByWater() : super.func_96092_aw();
	}	@Override	public boolean superIsPushedByWater() {
		return super.func_96092_aw();
	}	@Override
	public Scoreboard getWorldScoreboard() {
		return (Scoreboard) (master != null ? master.getWorldScoreboard() : super.getWorldScoreboard());
	}	@Override	public Scoreboard superGetWorldScoreboard() {
		return super.getWorldScoreboard();
	}	@Override
	public ScorePlayerTeam getTeam() {
		return (ScorePlayerTeam) (master != null ? master.getTeam() : super.getTeam());
	}	@Override	public ScorePlayerTeam superGetTeam() {
		return super.getTeam();
	}	@Override
	public String getTranslatedEntityName() {
		return master != null ? master.getTranslatedEntityName() : super.getTranslatedEntityName();
	}	@Override	public String superGetTranslatedEntityName() {
		return super.getTranslatedEntityName();
	}	@Override
	public void openGui(Object mod, int modGuiId, World world, int x, int y, int z) {
		if (master != null) master.openGui(mod, modGuiId, world, x, y, z);
		else super.openGui(mod, modGuiId, world, x, y, z);
	}	@Override	public void superOpenGui(Object mod, int modGuiId, Object world, int x, int y, int z) {
		super.openGui(mod, modGuiId, (World) world, x, y, z);
	}	@Override
	protected int func_96121_ay() {
		return master != null ? master.func_96121_ay() : super.func_96121_ay();
	}	@Override	public int superFunc_96121_ay() {
		return super.func_96121_ay();
	}	@Override
	public EntityLookHelper getLookHelper() {
		return (EntityLookHelper) (master != null ? master.getLookHelper() : super.getLookHelper());
	}	@Override	public EntityLookHelper superGetLookHelper() {
		return super.getLookHelper();
	}	@Override
	public EntityMoveHelper getMoveHelper() {
		return (EntityMoveHelper) (master != null ? master.getMoveHelper() : super.getMoveHelper());
	}	@Override	public EntityMoveHelper superGetMoveHelper() {
		return super.getMoveHelper();
	}	@Override
	public EntityJumpHelper getJumpHelper() {
		return (EntityJumpHelper) (master != null ? master.getJumpHelper() : super.getJumpHelper());
	}	@Override	public EntityJumpHelper superGetJumpHelper() {
		return super.getJumpHelper();
	}	@Override
	public PathNavigate getNavigator() {
		return (PathNavigate) (master != null ? master.getNavigator() : super.getNavigator());
	}	@Override	public PathNavigate superGetNavigator() {
		return super.getNavigator();
	}	@Override
	public EntitySenses getEntitySenses() {
		return (EntitySenses) (master != null ? master.getEntitySenses() : super.getEntitySenses());
	}	@Override	public EntitySenses superGetEntitySenses() {
		return super.getEntitySenses();
	}	@Override
	public Random getRNG() {
		return master != null ? master.getRNG() : super.getRNG();
	}	@Override	public Random superGetRNG() {
		return super.getRNG();
	}	@Override
	public EntityLiving getAITarget() {
		return (EntityLiving) (master != null ? master.getAITarget() : super.getAITarget());
	}	@Override	public EntityLiving superGetAITarget() {
		return super.getAITarget();
	}	@Override
	public EntityLiving getLastAttackingEntity() {
		return (EntityLiving) (master != null ? master.getLastAttackingEntity() : super.getLastAttackingEntity());
	}	@Override	public EntityLiving superGetLastAttackingEntity() {
		return super.getLastAttackingEntity();
	}	@Override
	public void setLastAttackingEntity(Entity entity) {
		if (master != null) master.setLastAttackingEntity(entity);
		else super.setLastAttackingEntity(entity);
	}	@Override	public void superSetLastAttackingEntity(Object entity) {
		super.setLastAttackingEntity((Entity) entity);
	}	@Override
	public int getAge() {
		return master != null ? master.getAge() : super.getAge();
	}	@Override	public int superGetAge() {
		return super.getAge();
	}	@Override
	public float getRotationYawHead() {
		return master != null ? master.getRotationYawHead() : super.getRotationYawHead();
	}	@Override	public float superGetRotationYawHead() {
		return super.getRotationYawHead();
	}	@Override
	public void setRotationYawHead(float par1) {
		if (master != null) master.setRotationYawHead(par1);
		else super.setRotationYawHead(par1);
	}	@Override	public void superSetRotationYawHead(float par1) {
		super.setRotationYawHead(par1);
	}	@Override
	public float getAIMoveSpeed() {
		return master != null ? master.getAIMoveSpeed() : super.getAIMoveSpeed();
	}	@Override	public float superGetAIMoveSpeed() {
		return super.getAIMoveSpeed();
	}	@Override
	public void setAIMoveSpeed(float par1) {
		if (master != null) master.setAIMoveSpeed(par1);
		else super.setAIMoveSpeed(par1);
	}	@Override	public void superSetAIMoveSpeed(float par1) {
		super.setAIMoveSpeed(par1);
	}	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return master != null ? master.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}	@Override	public boolean superAttackEntityAsMob(Object entity) {
		return super.attackEntityAsMob((Entity) entity);
	}	@Override
	public EntityLiving getAttackTarget() {
		return (EntityLiving) (master != null ? master.getAttackTarget() : super.getAttackTarget());
	}	@Override	public EntityLiving superGetAttackTarget() {
		return super.getAttackTarget();
	}	@Override
	public void setAttackTarget(EntityLiving entityLiving) {
		if (master != null) master.setAttackTarget(entityLiving);
		else super.setAttackTarget(entityLiving);
	}	@Override	public void superSetAttackTarget(Object entityLiving) {
		super.setAttackTarget((EntityLiving) entityLiving);
	}	@Override
	public boolean canAttackClass(Class par1Class) {
		return master != null ? master.canAttackClass(par1Class) : super.canAttackClass(par1Class);
	}	@Override	public boolean superCanAttackClass(Class par1Class) {
		return super.canAttackClass(par1Class);
	}	@Override
	public void eatGrassBonus() {
		if (master != null) master.eatGrassBonus();
		else super.eatGrassBonus();
	}	@Override	public void superEatGrassBonus() {
		super.eatGrassBonus();
	}	@Override
	protected void updateFallState(double par1, boolean par3) {
		if (master != null) master.updateFallState(par1, par3);
		else super.updateFallState(par1, par3);
	}	@Override	public void superUpdateFallState(double par1, boolean par3) {
		super.updateFallState(par1, par3);
	}	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return master != null ? master.isWithinHomeDistanceCurrentPosition() : super.isWithinHomeDistanceCurrentPosition();
	}	@Override	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return super.isWithinHomeDistanceCurrentPosition();
	}	@Override
	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return master != null ? master.isWithinHomeDistance(par1, par2, par3) : super.isWithinHomeDistance(par1, par2, par3);
	}	@Override	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return super.isWithinHomeDistance(par1, par2, par3);
	}	@Override
	public void setHomeArea(int par1, int par2, int par3, int par4) {
		if (master != null) master.setHomeArea(par1, par2, par3, par4);
		else super.setHomeArea(par1, par2, par3, par4);
	}	@Override	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
		super.setHomeArea(par1, par2, par3, par4);
	}	@Override
	public ChunkCoordinates getHomePosition() {
		return (ChunkCoordinates) (master != null ? master.getHomePosition() : super.getHomePosition());
	}	@Override	public ChunkCoordinates superGetHomePosition() {
		return super.getHomePosition();
	}	@Override
	public float getMaximumHomeDistance() {
		return master != null ? master.getMaximumHomeDistance() : super.getMaximumHomeDistance();
	}	@Override	public float superGetMaximumHomeDistance() {
		return super.getMaximumHomeDistance();
	}	@Override
	public void detachHome() {
		if (master != null) master.detachHome();
		else super.detachHome();
	}	@Override	public void superDetachHome() {
		super.detachHome();
	}	@Override
	public boolean hasHome() {
		return master != null ? master.hasHome() : super.hasHome();
	}	@Override	public boolean superHasHome() {
		return super.hasHome();
	}	@Override
	public void setRevengeTarget(EntityLiving entityLiving) {
		if (master != null) master.setRevengeTarget(entityLiving);
		else super.setRevengeTarget(entityLiving);
	}	@Override	public void superSetRevengeTarget(Object entityLiving) {
		super.setRevengeTarget((EntityLiving) entityLiving);
	}	@Override
	public boolean canEntityBeSeen(Entity entity) {
		return master != null ? master.canEntityBeSeen(entity) : super.canEntityBeSeen(entity);
	}	@Override	public boolean superCanEntityBeSeen(Object entity) {
		return super.canEntityBeSeen((Entity) entity);
	}	@Override
	public String getTexture() {
		return master != null ? master.getTexture() : super.getTexture();
	}	@Override	public String superGetTexture() {
		return super.getTexture();
	}	@Override
	public boolean canBeCollidedWith() {
		return master != null ? master.canBeCollidedWith() : super.canBeCollidedWith();
	}	@Override	public boolean superCanBeCollidedWith() {
		return super.canBeCollidedWith();
	}	@Override
	public boolean canBePushed() {
		return master != null ? master.canBePushed() : super.canBePushed();
	}	@Override	public boolean superCanBePushed() {
		return super.canBePushed();
	}	@Override
	public int getTalkInterval() {
		return master != null ? master.getTalkInterval() : super.getTalkInterval();
	}	@Override	public int superGetTalkInterval() {
		return super.getTalkInterval();
	}	@Override
	public void playLivingSound() {
		if (master != null) master.playLivingSound();
		else super.playLivingSound();
	}	@Override	public void superPlayLivingSound() {
		super.playLivingSound();
	}	@Override
	public void onEntityUpdate() {
		if (master != null) master.onEntityUpdate();
		else super.onEntityUpdate();
	}	@Override	public void superOnEntityUpdate() {
		super.onEntityUpdate();
	}	@Override
	protected void onDeathUpdate() {
		if (master != null) master.onDeathUpdate();
		else super.onDeathUpdate();
	}	@Override	public void superOnDeathUpdate() {
		super.onDeathUpdate();
	}	@Override
	protected int decreaseAirSupply(int par1) {
		return master != null ? master.decreaseAirSupply(par1) : super.decreaseAirSupply(par1);
	}	@Override	public int superDecreaseAirSupply(int par1) {
		return super.decreaseAirSupply(par1);
	}	@Override
	public void spawnExplosionParticle() {
		if (master != null) master.spawnExplosionParticle();
		else super.spawnExplosionParticle();
	}	@Override	public void superSpawnExplosionParticle() {
		super.spawnExplosionParticle();
	}	@Override
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		if (master != null) master.setPositionAndRotationDirect(par1, par3, par5, par7, par8, par9);
		else super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}	@Override	public void superSetPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9) {
		super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}	@Override
	public int getHealth() {
		return (Integer) (master != null ? master.getHealth() : super.getHealth());
	}	@Override	public int superGetHealth() {
		return super.getHealth();
	}	@Override
	public void setEntityHealth(int par1) {
		if (master != null) master.setEntityHealth(par1);
		else super.setEntityHealth(par1);
	}	@Override	public void superSetEntityHealth(int par1) {
		super.setEntityHealth(par1);
	}	@Override
	protected float getSoundPitch() {
		return master != null ? master.getSoundPitch() : super.getSoundPitch();
	}	@Override	public float superGetSoundPitch() {
		return super.getSoundPitch();
	}	@Override
	public void performHurtAnimation() {
		if (master != null) master.performHurtAnimation();
		else super.performHurtAnimation();
	}	@Override	public void superPerformHurtAnimation() {
		super.performHurtAnimation();
	}	@Override
	protected int applyArmorCalculations(DamageSource damageSource, int par2) {
		return (Integer) (master != null ? master.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2));
	}	@Override	public Object superApplyArmorCalculations(Object damageSource, int par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}	@Override
	protected int applyPotionDamageCalculations(DamageSource damageSource, int par2) {
		return (Integer) (master != null ? master.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2));
	}	@Override	public Object superApplyPotionDamageCalculations(Object damageSource, int par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}	@Override
	protected float getSoundVolume() {
		return master != null ? master.getSoundVolume() : super.getSoundVolume();
	}	@Override	public float superGetSoundVolume() {
		return super.getSoundVolume();
	}	@Override
	protected String getLivingSound() {
		return (String) (master != null ? master.getAmbientSound() : super.getLivingSound());
	}	@Override	public String superGetLivingSound() {
		return super.getLivingSound();
	}	@Override
	protected String getDeathSound() {
		return (String) (master != null ? master.getDeathSound() : super.getDeathSound());
	}	@Override	public String superGetDeathSound() {
		return super.getDeathSound();
	}	@Override
	public void knockBack(Entity entity, int par2, double par3, double par5) {
		if (master != null) master.knockBack(entity, par2, par3, par5);
		else super.knockBack(entity, par2, par3, par5);
	}	@Override	public void superKnockBack(Object entity, int par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
	}	@Override
	protected void dropRareDrop(int par1) {
		if (master != null) master.dropRareDrop(par1);
		else super.dropRareDrop(par1);
	}	@Override	public void superDropRareDrop(int par1) {
		super.dropRareDrop(par1);
	}	@Override
	protected void dropFewItems(boolean par1, int par2) {
		if (master != null) master.dropFewItems(par1, par2);
		else super.dropFewItems(par1, par2);
	}	@Override	public void superDropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
	}	@Override
	protected int getDropItemId() {
		return master != null ? master.getDropItemId() : super.getDropItemId();
	}	@Override	public int superGetDropItemId() {
		return super.getDropItemId();
	}	@Override
	public boolean isOnLadder() {
		return master != null ? master.isOnLadder() : super.isOnLadder();
	}	@Override	public boolean superIsOnLadder() {
		return super.isOnLadder();
	}	@Override
	public boolean isEntityAlive() {
		return master != null ? master.isEntityAlive() : super.isEntityAlive();
	}	@Override	public boolean superIsEntityAlive() {
		return super.isEntityAlive();
	}	@Override
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}	@Override	public boolean superCanBreatheUnderwater() {
		return super.canBreatheUnderwater();
	}	@Override
	public void setMoveForward(float par1) {
		if (master != null) master.setMoveForward(par1);
		else super.setMoveForward(par1);
	}	@Override	public void superSetMoveForward(float par1) {
		super.setMoveForward(par1);
	}	@Override
	public void setJumping(boolean par1) {
		if (master != null) master.setJumping(par1);
		else super.setJumping(par1);
	}	@Override	public void superSetJumping(boolean par1) {
		super.setJumping(par1);
	}	@Override
	protected void func_85033_bc() {
		if (master != null) master.collideWithNearbyEntities();
		else super.func_85033_bc();
	}	@Override	public void superCollideWithNearbyEntities() {
		super.func_85033_bc();
	}	@Override
	protected void collideWithEntity(Entity entity) {
		if (master != null) master.collideWithEntity(entity);
		else super.collideWithEntity(entity);
	}	@Override	public void superCollideWithEntity(Object entity) {
		super.collideWithEntity((Entity) entity);
	}	@Override
	protected boolean isAIEnabled() {
		return master != null ? master.isAIEnabled() : super.isAIEnabled();
	}	@Override	public boolean superIsAIEnabled() {
		return super.isAIEnabled();
	}	@Override
	protected boolean canDespawn() {
		return master != null ? master.canDespawn() : super.canDespawn();
	}	@Override	public boolean superCanDespawn() {
		return super.canDespawn();
	}	@Override
	protected void despawnEntity() {
		if (master != null) master.despawnEntity();
		else super.despawnEntity();
	}	@Override	public void superDespawnEntity() {
		super.despawnEntity();
	}	@Override
	protected void updateAITasks() {
		if (master != null) master.updateAITasks();
		else super.updateAITasks();
	}	@Override	public void superUpdateAITasks() {
		super.updateAITasks();
	}	@Override
	protected void updateAITick() {
		if (master != null) master.handleJumpWater();
		else super.updateAITick();
	}	@Override	public void superHandleJumpWater() {
		super.updateAITick();
	}	@Override
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}	@Override	public void superUpdateArmSwingProgress() {
		super.updateArmSwingProgress();
	}	@Override
	public int getVerticalFaceSpeed() {
		return master != null ? master.getVerticalFaceSpeed() : super.getVerticalFaceSpeed();
	}	@Override	public int superGetVerticalFaceSpeed() {
		return super.getVerticalFaceSpeed();
	}	@Override
	public void faceEntity(Entity entity, float par2, float par3) {
		if (master != null) master.faceEntity(entity, par2, par3);
		else super.faceEntity(entity, par2, par3);
	}	@Override	public void superFaceEntity(Object entity, float par2, float par3) {
		super.faceEntity((Entity) entity, par2, par3);
	}	@Override
	public boolean getCanSpawnHere() {
		return master != null ? master.getCanSpawnHere() : super.getCanSpawnHere();
	}	@Override	public boolean superGetCanSpawnHere() {
		return super.getCanSpawnHere();
	}	@Override
	protected void kill() {
		if (master != null) master.kill();
		else super.kill();
	}	@Override	public void superKill() {
		super.kill();
	}	@Override
	public float getSwingProgress(float par1) {
		return master != null ? master.getSwingProgress(par1) : super.getSwingProgress(par1);
	}	@Override	public float superGetSwingProgress(float par1) {
		return super.getSwingProgress(par1);
	}	@Override
	public Vec3 getPosition(float par1) {
		return (Vec3) (master != null ? master.getPosition(par1) : super.getPosition(par1));
	}	@Override	public Vec3 superGetPosition(float par1) {
		return super.getPosition(par1);
	}	@Override
	public Vec3 getLookVec() {
		return (Vec3) (master != null ? master.getLookVec() : super.getLookVec());
	}	@Override	public Vec3 superGetLookVec() {
		return super.getLookVec();
	}	@Override
	public Vec3 getLook(float par1) {
		return (Vec3) (master != null ? master.getLook(par1) : super.getLook(par1));
	}	@Override	public Vec3 superGetLook(float par1) {
		return super.getLook(par1);
	}	@Override
	public float getRenderSizeModifier() {
		return master != null ? master.getRenderSizeModifier() : super.getRenderSizeModifier();
	}	@Override	public float superGetRenderSizeModifier() {
		return super.getRenderSizeModifier();
	}	@Override
	public MovingObjectPosition rayTrace(double par1, float par3) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(par1, par3) : super.rayTrace(par1, par3));
	}	@Override	public MovingObjectPosition superRayTrace(double par1, float par3) {
		return super.rayTrace(par1, par3);
	}	@Override
	public int getMaxSpawnedInChunk() {
		return master != null ? master.getMaxSpawnedInChunk() : super.getMaxSpawnedInChunk();
	}	@Override	public int superGetMaxSpawnedInChunk() {
		return super.getMaxSpawnedInChunk();
	}	@Override
	protected void updatePotionEffects() {
		if (master != null) master.updatePotionEffects();
		else super.updatePotionEffects();
	}	@Override	public void superUpdatePotionEffects() {
		super.updatePotionEffects();
	}	@Override
	public void clearActivePotions() {
		if (master != null) master.clearActivePotions();
		else super.clearActivePotions();
	}	@Override	public void superClearActivePotions() {
		super.clearActivePotions();
	}	@Override
	public Collection getActivePotionEffects() {
		return (Collection) (master != null ? master.getActivePotionEffects() : super.getActivePotionEffects());
	}	@Override	public Collection superGetActivePotionEffects() {
		return super.getActivePotionEffects();
	}	@Override
	public boolean isPotionActive(int par1) {
		return master != null ? master.isPotionActive(par1) : super.isPotionActive(par1);
	}	@Override	public boolean superIsPotionActive(int par1) {
		return super.isPotionActive(par1);
	}	@Override
	public boolean isPotionActive(Potion potion) {
		return master != null ? master.isPotionActive(potion) : super.isPotionActive(potion);
	}	@Override	public boolean superIsPotionActive(Object potion) {
		return super.isPotionActive((Potion) potion);
	}	@Override
	public PotionEffect getActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.getActivePotionEffect(potion) : super.getActivePotionEffect(potion));
	}	@Override	public PotionEffect superGetActivePotionEffect(Object potion) {
		return super.getActivePotionEffect((Potion) potion);
	}	@Override
	public void addPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.addPotionEffect(potionEffect);
		else super.addPotionEffect(potionEffect);
	}	@Override	public void superAddPotionEffect(Object potionEffect) {
		super.addPotionEffect((PotionEffect) potionEffect);
	}	@Override
	public boolean isPotionApplicable(PotionEffect potionEffect) {
		return master != null ? master.isPotionApplicable(potionEffect) : super.isPotionApplicable(potionEffect);
	}	@Override	public boolean superIsPotionApplicable(Object potionEffect) {
		return super.isPotionApplicable((PotionEffect) potionEffect);
	}	@Override
	public boolean isEntityUndead() {
		return master != null ? master.isEntityUndead() : super.isEntityUndead();
	}	@Override	public boolean superIsEntityUndead() {
		return super.isEntityUndead();
	}	@Override
	public void removePotionEffectClient(int par1) {
		if (master != null) master.removePotionEffectClient(par1);
		else super.removePotionEffectClient(par1);
	}	@Override	public void superRemovePotionEffectClient(int par1) {
		super.removePotionEffectClient(par1);
	}	@Override
	public void removePotionEffect(int par1) {
		if (master != null) master.removePotionEffect(par1);
		else super.removePotionEffect(par1);
	}	@Override	public void superRemovePotionEffect(int par1) {
		super.removePotionEffect(par1);
	}	@Override
	protected void onNewPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onNewPotionEffect(potionEffect);
		else super.onNewPotionEffect(potionEffect);
	}	@Override	public void superOnNewPotionEffect(Object potionEffect) {
		super.onNewPotionEffect((PotionEffect) potionEffect);
	}	@Override
	protected void onChangedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onChangedPotionEffect(potionEffect);
		else super.onChangedPotionEffect(potionEffect);
	}	@Override	public void superOnChangedPotionEffect(Object potionEffect) {
		super.onChangedPotionEffect((PotionEffect) potionEffect);
	}	@Override
	protected void onFinishedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onFinishedPotionEffect(potionEffect);
		else super.onFinishedPotionEffect(potionEffect);
	}	@Override	public void superOnFinishedPotionEffect(Object potionEffect) {
		super.onFinishedPotionEffect((PotionEffect) potionEffect);
	}	@Override
	public float getSpeedModifier() {
		return master != null ? master.getSpeedModifier() : super.getSpeedModifier();
	}	@Override	public float superGetSpeedModifier() {
		return super.getSpeedModifier();
	}	@Override
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		if (master != null) master.setPositionAndUpdate(par1, par3, par5);
		else super.setPositionAndUpdate(par1, par3, par5);
	}	@Override	public void superSetPositionAndUpdate(double par1, double par3, double par5) {
		super.setPositionAndUpdate(par1, par3, par5);
	}	@Override
	public boolean isChild() {
		return master != null ? master.isChild() : super.isChild();
	}	@Override	public boolean superIsChild() {
		return super.isChild();
	}	@Override
	public void renderBrokenItemStack(ItemStack itemStack) {
		if (master != null) master.renderBrokenItemStack(itemStack);
		else super.renderBrokenItemStack(itemStack);
	}	@Override	public void superRenderBrokenItemStack(Object itemStack) {
		super.renderBrokenItemStack((ItemStack) itemStack);
	}	@Override
	public int func_82143_as() {
		return master != null ? master.getMaxFallHeight() : super.func_82143_as();
	}	@Override	public int superGetMaxFallHeight() {
		return super.func_82143_as();
	}	@Override
	protected void dropEquipment(boolean par1, int par2) {
		if (master != null) master.dropEquipment(par1, par2);
		else super.dropEquipment(par1, par2);
	}	@Override	public void superDropEquipment(boolean par1, int par2) {
		super.dropEquipment(par1, par2);
	}	@Override
	public void initCreature() {
		if (master != null) master.initCreature();
		else super.initCreature();
	}	@Override	public void superInitCreature() {
		super.initCreature();
	}	@Override
	public boolean canBeSteered() {
		return master != null ? master.canBeSteered() : super.canBeSteered();
	}	@Override	public boolean superCanBeSteered() {
		return super.canBeSteered();
	}	@Override
	public EntityLiving func_94060_bK() {
		return (EntityLiving) (master != null ? master.getAttackingEntity() : super.func_94060_bK());
	}	@Override	public EntityLiving superGetAttackingEntity() {
		return super.func_94060_bK();
	}	@Override
	public void func_94058_c(String par1Str) {
		if (master != null) master.func_94058_c(par1Str);
		else super.func_94058_c(par1Str);
	}	@Override	public void superFunc_94058_c(String par1Str) {
		super.func_94058_c(par1Str);
	}	@Override
	public String func_94057_bL() {
		return master != null ? master.func_94057_bL() : super.func_94057_bL();
	}	@Override	public String superFunc_94057_bL() {
		return super.func_94057_bL();
	}	@Override
	public boolean func_94056_bM() {
		return master != null ? master.func_94056_bM() : super.func_94056_bM();
	}	@Override	public boolean superFunc_94056_bM() {
		return super.func_94056_bM();
	}	@Override
	public void func_94061_f(boolean par1) {
		if (master != null) master.setNoAI(par1);
		else super.func_94061_f(par1);
	}	@Override	public void superSetNoAI(boolean par1) {
		super.func_94061_f(par1);
	}	@Override
	public void func_96120_a(int par1, float par2) {
		if (master != null) master.func_96120_a(par1, par2);
		else super.func_96120_a(par1, par2);
	}	@Override	public void superFunc_96120_a(int par1, float par2) {
		super.func_96120_a(par1, par2);
	}	@Override
	public void setCanPickUpLoot(boolean par1) {
		if (master != null) master.setCanPickUpLoot(par1);
		else super.setCanPickUpLoot(par1);
	}	@Override	public void superSetCanPickUpLoot(boolean par1) {
		super.setCanPickUpLoot(par1);
	}	@Override
	public boolean func_104002_bU() {
		return master != null ? master.isNoDespawnRequired() : super.func_104002_bU();
	}	@Override	public boolean superIsNoDespawnRequired() {
		return super.func_104002_bU();
	}	@Override
	public void curePotionEffects(ItemStack itemStack) {
		if (master != null) master.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}	@Override	public void superCurePotionEffects(Object itemStack) {
		super.curePotionEffects((ItemStack) itemStack);
	}	@Override
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return master != null ? master.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}	@Override	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}	@Override
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataManager() : super.getDataWatcher());
	}	@Override	public DataWatcher superGetDataManager() {
		return super.getDataWatcher();
	}	@Override
	protected void setRotation(float par1, float par2) {
		if (master != null) master.setRotation(par1, par2);
		else super.setRotation(par1, par2);
	}	@Override	public void superSetRotation(float par1, float par2) {
		super.setRotation(par1, par2);
	}	@Override
	public void setPosition(double par1, double par3, double par5) {
		if (master != null) master.setPosition(par1, par3, par5);
		else super.setPosition(par1, par3, par5);
	}	@Override	public void superSetPosition(double par1, double par3, double par5) {
		super.setPosition(par1, par3, par5);
	}	@Override
	public void setAngles(float par1, float par2) {
		if (master != null) master.turn(par1, par2);
		else super.setAngles(par1, par2);
	}	@Override	public void superTurn(float par1, float par2) {
		super.setAngles(par1, par2);
	}	@Override
	protected void setOnFireFromLava() {
		if (master != null) master.setOnFireFromLava();
		else super.setOnFireFromLava();
	}	@Override	public void superSetOnFireFromLava() {
		super.setOnFireFromLava();
	}	@Override
	public void setFire(int par1) {
		if (master != null) master.setFire(par1);
		else super.setFire(par1);
	}	@Override	public void superSetFire(int par1) {
		super.setFire(par1);
	}	@Override
	public void extinguish() {
		if (master != null) master.extinguish();
		else super.extinguish();
	}	@Override	public void superExtinguish() {
		super.extinguish();
	}	@Override
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return master != null ? master.isOffsetPositionInLiquid(par1, par3, par5) : super.isOffsetPositionInLiquid(par1, par3, par5);
	}	@Override	public boolean superIsOffsetPositionInLiquid(double par1, double par3, double par5) {
		return super.isOffsetPositionInLiquid(par1, par3, par5);
	}	@Override
	protected void doBlockCollisions() {
		if (master != null) master.doBlockCollisions();
		else super.doBlockCollisions();
	}	@Override	public void superDoBlockCollisions() {
		super.doBlockCollisions();
	}	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		if (master != null) master.playStepSound(par1, par2, par3, par4);
		else super.playStepSound(par1, par2, par3, par4);
	}	@Override	public void superPlayStepSound(int par1, int par2, int par3, int par4) {
		super.playStepSound(par1, par2, par3, par4);
	}	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getBoundingBox());
	}	@Override	public AxisAlignedBB superGetCollisionBoundingBox() {
		return super.getBoundingBox();
	}	@Override
	protected void dealFireDamage(int par1) {
		if (master != null) master.dealFireDamage(par1);
		else super.dealFireDamage(par1);
	}	@Override	public void superDealFireDamage(int par1) {
		super.dealFireDamage(par1);
	}	@Override
	public boolean isWet() {
		return master != null ? master.isWet() : super.isWet();
	}	@Override	public boolean superIsWet() {
		return super.isWet();
	}	@Override
	public boolean isInWater() {
		return master != null ? master.isInWater() : super.isInWater();
	}	@Override	public boolean superIsInWater() {
		return super.isInWater();
	}	@Override
	public boolean handleWaterMovement() {
		return master != null ? master.handleWaterMovement() : super.handleWaterMovement();
	}	@Override	public boolean superHandleWaterMovement() {
		return super.handleWaterMovement();
	}	@Override
	public boolean isInsideOfMaterial(Material material) {
		return master != null ? master.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}	@Override	public boolean superIsInsideOfMaterial(Object material) {
		return super.isInsideOfMaterial((Material) material);
	}	@Override
	public boolean handleLavaMovement() {
		return master != null ? master.handleLavaMovement() : super.handleLavaMovement();
	}	@Override	public boolean superHandleLavaMovement() {
		return super.handleLavaMovement();
	}	@Override
	public void moveFlying(float par1, float par2, float par3) {
		if (master != null) master.moveRelative(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}	@Override	public void superMoveRelative(float par1, float par2, float par3) {
		super.moveFlying(par1, par2, par3);
	}	@Override
	public int getBrightnessForRender(float par1) {
		return master != null ? master.getBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}	@Override	public int superGetBrightnessForRender(float par1) {
		return super.getBrightnessForRender(par1);
	}	@Override
	public float getBrightness(float par1) {
		return master != null ? master.getBrightness(par1) : super.getBrightness(par1);
	}	@Override	public float superGetBrightness(float par1) {
		return super.getBrightness(par1);
	}	@Override
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}	@Override	public void superSetWorld(Object world) {
		super.setWorld((World) world);
	}	@Override
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setPositionAndRotation(par1, par3, par5, par7, par8);
		else super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}	@Override	public void superSetPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}	@Override
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setLocationAndAngles(par1, par3, par5, par7, par8);
		else super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}	@Override	public void superSetLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}	@Override
	public float getDistanceToEntity(Entity entity) {
		return master != null ? master.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}	@Override	public float superGetDistanceToEntity(Object entity) {
		return super.getDistanceToEntity((Entity) entity);
	}	@Override
	public double getDistanceSq(double par1, double par3, double par5) {
		return master != null ? master.getDistanceSq(par1, par3, par5) : super.getDistanceSq(par1, par3, par5);
	}	@Override	public double superGetDistanceSq(double par1, double par3, double par5) {
		return super.getDistanceSq(par1, par3, par5);
	}	@Override
	public double getDistance(double par1, double par3, double par5) {
		return master != null ? master.getDistance(par1, par3, par5) : super.getDistance(par1, par3, par5);
	}	@Override	public double superGetDistance(double par1, double par3, double par5) {
		return super.getDistance(par1, par3, par5);
	}	@Override
	public double getDistanceSqToEntity(Entity entity) {
		return master != null ? master.getDistanceSqToEntity(entity) : super.getDistanceSqToEntity(entity);
	}	@Override	public double superGetDistanceSqToEntity(Object entity) {
		return super.getDistanceSqToEntity((Entity) entity);
	}	@Override
	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
		if (master != null) master.onCollideWithPlayer(entityPlayer);
		else super.onCollideWithPlayer(entityPlayer);
	}	@Override	public void superOnCollideWithPlayer(Object entityPlayer) {
		super.onCollideWithPlayer((EntityPlayer) entityPlayer);
	}	@Override
	public void applyEntityCollision(Entity entity) {
		if (master != null) master.applyEntityCollision(entity);
		else super.applyEntityCollision(entity);
	}	@Override	public void superApplyEntityCollision(Object entity) {
		super.applyEntityCollision((Entity) entity);
	}	@Override
	public void addVelocity(double par1, double par3, double par5) {
		if (master != null) master.addVelocity(par1, par3, par5);
		else super.addVelocity(par1, par3, par5);
	}	@Override	public void superAddVelocity(double par1, double par3, double par5) {
		super.addVelocity(par1, par3, par5);
	}	@Override
	protected void setBeenAttacked() {
		if (master != null) master.setBeenAttacked();
		else super.setBeenAttacked();
	}	@Override	public void superSetBeenAttacked() {
		super.setBeenAttacked();
	}	@Override
	public boolean addNotRiddenEntityID(NBTTagCompound nBTTagCompound) {
		return master != null ? master.addNotRiddenEntityID(nBTTagCompound) : super.addNotRiddenEntityID(nBTTagCompound);
	}	@Override	public boolean superAddNotRiddenEntityID(Object nBTTagCompound) {
		return super.addNotRiddenEntityID((NBTTagCompound) nBTTagCompound);
	}	@Override
	public boolean isInRangeToRenderVec3D(Vec3 vec3) {
		return master != null ? master.isInRangeToRenderVec3D(vec3) : super.isInRangeToRenderVec3D(vec3);
	}	@Override	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return super.isInRangeToRenderVec3D((Vec3) vec3);
	}	@Override
	public boolean isInRangeToRenderDist(double par1) {
		return master != null ? master.isInRangeToRenderDist(par1) : super.isInRangeToRenderDist(par1);
	}	@Override	public boolean superIsInRangeToRenderDist(double par1) {
		return super.isInRangeToRenderDist(par1);
	}	@Override
	public boolean addEntityID(NBTTagCompound nBTTagCompound) {
		return master != null ? master.addEntityID(nBTTagCompound) : super.addEntityID(nBTTagCompound);
	}	@Override	public boolean superAddEntityID(Object nBTTagCompound) {
		return super.addEntityID((NBTTagCompound) nBTTagCompound);
	}	@Override
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}	@Override	public Object superWriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);		return nBTTagCompound;
	}	@Override
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}	@Override	public void superReadFromNBT(Object nBTTagCompound) {
		super.readFromNBT((NBTTagCompound) nBTTagCompound);
	}	@Override
	protected NBTTagList newDoubleNBTList(double... par1ArrayOfDouble) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(par1ArrayOfDouble) : super.newDoubleNBTList(par1ArrayOfDouble));
	}	@Override	public NBTTagList superNewDoubleNBTList(double... par1ArrayOfDouble) {
		return super.newDoubleNBTList(par1ArrayOfDouble);
	}	@Override
	protected NBTTagList newFloatNBTList(float... par1ArrayOfFloat) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(par1ArrayOfFloat) : super.newFloatNBTList(par1ArrayOfFloat));
	}	@Override	public NBTTagList superNewFloatNBTList(float... par1ArrayOfFloat) {
		return super.newFloatNBTList(par1ArrayOfFloat);
	}	@Override
	public float getShadowSize() {
		return master != null ? master.getShadowSize() : super.getShadowSize();
	}	@Override	public float superGetShadowSize() {
		return super.getShadowSize();
	}	@Override
	public EntityItem dropItem(int par1, int par2) {
		return (EntityItem) (master != null ? master.dropItem(par1, par2) : super.dropItem(par1, par2));
	}	@Override	public EntityItem superDropItem(int par1, int par2) {
		return super.dropItem(par1, par2);
	}	@Override
	public EntityItem dropItemWithOffset(int par1, int par2, float par3) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(par1, par2, par3) : super.dropItemWithOffset(par1, par2, par3));
	}	@Override	public EntityItem superDropItemWithOffset(int par1, int par2, float par3) {
		return super.dropItemWithOffset(par1, par2, par3);
	}	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float par2) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, par2) : super.entityDropItem(itemStack, par2));
	}	@Override	public EntityItem superEntityDropItem(Object itemStack, float par2) {
		return super.entityDropItem((ItemStack) itemStack, par2);
	}	@Override
	public boolean interact(EntityPlayer entityPlayer) {
		return master != null ? master.interact(entityPlayer) : super.interact(entityPlayer);
	}	@Override	public boolean superInteract(Object entityPlayer) {
		return super.interact((EntityPlayer) entityPlayer);
	}	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBox(entity) : super.getCollisionBox(entity));
	}	@Override	public AxisAlignedBB superGetCollisionBox(Object entity) {
		return super.getCollisionBox((Entity) entity);
	}	@Override
	public void updateRiderPosition() {
		if (master != null) master.updatePassenger();
		else super.updateRiderPosition();
	}	@Override	public void superUpdatePassenger() {
		super.updateRiderPosition();
	}	@Override
	public void unmountEntity(Entity entity) {
		if (master != null) master.unmountEntity(entity);
		else super.unmountEntity(entity);
	}	@Override	public void superUnmountEntity(Object entity) {
		super.unmountEntity((Entity) entity);
	}	@Override
	public float getCollisionBorderSize() {
		return master != null ? master.getCollisionBorderSize() : super.getCollisionBorderSize();
	}	@Override	public float superGetCollisionBorderSize() {
		return super.getCollisionBorderSize();
	}	@Override
	public void setInPortal() {
		if (master != null) master.setPortal(null);
		else super.setInPortal();
	}	@Override	public void superSetPortal(Object bockPos) {
		super.setInPortal();
	}	@Override
	public void setVelocity(double par1, double par3, double par5) {
		if (master != null) master.setVelocity(par1, par3, par5);
		else super.setVelocity(par1, par3, par5);
	}	@Override	public void superSetVelocity(double par1, double par3, double par5) {
		super.setVelocity(par1, par3, par5);
	}	@Override
	public boolean isBurning() {
		return master != null ? master.isBurning() : super.isBurning();
	}	@Override	public boolean superIsBurning() {
		return super.isBurning();
	}	@Override
	public boolean isRiding() {
		return master != null ? master.isRiding() : super.isRiding();
	}	@Override	public boolean superIsRiding() {
		return super.isRiding();
	}	@Override
	public void setSneaking(boolean par1) {
		if (master != null) master.setSneaking(par1);
		else super.setSneaking(par1);
	}	@Override	public void superSetSneaking(boolean par1) {
		super.setSneaking(par1);
	}	@Override
	public boolean isSprinting() {
		return master != null ? master.isSprinting() : super.isSprinting();
	}	@Override	public boolean superIsSprinting() {
		return super.isSprinting();
	}	@Override
	public boolean isInvisible() {
		return master != null ? master.isInvisible() : super.isInvisible();
	}	@Override	public boolean superIsInvisible() {
		return super.isInvisible();
	}	@Override
	public void setInvisible(boolean par1) {
		if (master != null) master.setInvisible(par1);
		else super.setInvisible(par1);
	}	@Override	public void superSetInvisible(boolean par1) {
		super.setInvisible(par1);
	}	@Override
	public boolean isEating() {
		return master != null ? master.isEating() : super.isEating();
	}	@Override	public boolean superIsEating() {
		return super.isEating();
	}	@Override
	public void setEating(boolean par1) {
		if (master != null) master.setEating(par1);
		else super.setEating(par1);
	}	@Override	public void superSetEating(boolean par1) {
		super.setEating(par1);
	}	@Override
	protected boolean getFlag(int par1) {
		return master != null ? master.getFlag(par1) : super.getFlag(par1);
	}	@Override	public boolean superGetFlag(int par1) {
		return super.getFlag(par1);
	}	@Override
	protected void setFlag(int par1, boolean par2) {
		if (master != null) master.setFlag(par1, par2);
		else super.setFlag(par1, par2);
	}	@Override	public void superSetFlag(int par1, boolean par2) {
		super.setFlag(par1, par2);
	}	@Override
	public int getAir() {
		return master != null ? master.getAir() : super.getAir();
	}	@Override	public int superGetAir() {
		return super.getAir();
	}	@Override
	public void setAir(int par1) {
		if (master != null) master.setAir(par1);
		else super.setAir(par1);
	}	@Override	public void superSetAir(int par1) {
		super.setAir(par1);
	}	@Override
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		if (master != null) master.onStruckByLightning(entityLightningBolt);
		else super.onStruckByLightning(entityLightningBolt);
	}	@Override	public void superOnStruckByLightning(Object entityLightningBolt) {
		super.onStruckByLightning((EntityLightningBolt) entityLightningBolt);
	}	@Override
	public Entity[] getParts() {
		return (Entity[]) (master != null ? master.getParts() : super.getParts());
	}	@Override	public Entity[] superGetParts() {
		return super.getParts();
	}	@Override
	public boolean isEntityEqual(Entity entity) {
		return master != null ? master.isEntityEqual(entity) : super.isEntityEqual(entity);
	}	@Override	public boolean superIsEntityEqual(Object entity) {
		return super.isEntityEqual((Entity) entity);
	}	@Override
	public boolean canAttackWithItem() {
		return master != null ? master.canBeAttackedWithItem() : super.canAttackWithItem();
	}	@Override	public boolean superCanBeAttackedWithItem() {
		return super.canAttackWithItem();
	}	@Override
	public boolean func_85031_j(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.func_85031_j(entity);
	}	@Override	public boolean superHitByEntity(Object entity) {
		return super.func_85031_j((Entity) entity);
	}	@Override
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}	@Override	public String superToString() {
		return super.toString();
	}	@Override
	public boolean isEntityInvulnerable() {
		return master != null ? master.isEntityInvulnerable() : super.isEntityInvulnerable();
	}	@Override	public boolean superIsEntityInvulnerable() {
		return super.isEntityInvulnerable();
	}	@Override
	public void func_82149_j(Entity entity) {
		if (master != null) master.copyLocationAndAnglesFrom(entity);
		else super.func_82149_j(entity);
	}	@Override	public void superCopyLocationAndAnglesFrom(Object entity) {
		super.func_82149_j((Entity) entity);
	}	@Override
	public void copyDataFrom(Entity entity, boolean par2) {
		if (master != null) master.copyDataFrom(entity, par2);
		else super.copyDataFrom(entity, par2);
	}	@Override	public void superCopyDataFrom(Object entity, boolean par2) {
		super.copyDataFrom((Entity) entity, par2);
	}	@Override
	public void travelToDimension(int par1) {
		if (master != null) master.changeDimension(par1);
		else super.travelToDimension(par1);
	}	@Override	public Object superChangeDimension(int par1) {
		super.travelToDimension(par1);		return this;
	}	@Override
	public float func_82146_a(Explosion explosion, World world, int par3, int par4, int par5, Block block) {
		return master != null ? master.func_82146_a(explosion, world, par3, par4, par5, block) : super.func_82146_a(explosion, world, par3, par4, par5, block);
	}	@Override	public float superFunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return super.func_82146_a((Explosion) explosion, (World) world, par3, par4, par5, (Block) block);
	}	@Override
	public boolean func_96091_a(Explosion explosion, World world, int par3, int par4, int par5, int par6, float par7) {
		return master != null ? master.func_96091_a(explosion, world, par3, par4, par5, par6, par7) : super.func_96091_a(explosion, world, par3, par4, par5, par6, par7);
	}	@Override	public boolean superFunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return super.func_96091_a((Explosion) explosion, (World) world, par3, par4, par5, par6, par7);
	}	@Override
	public int getTeleportDirection() {
		return (Integer) (master != null ? master.getLastPortalVec() : super.getTeleportDirection());
	}	@Override	public Object superGetLastPortalVec() {
		return super.getTeleportDirection();
	}	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return master != null ? master.doesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}	@Override	public boolean superDoesEntityNotTriggerPressurePlate() {
		return super.doesEntityNotTriggerPressurePlate();
	}	@Override
	public void func_85029_a(CrashReportCategory crashReportCategory) {
		if (master != null) master.addEntityCrashInfo(crashReportCategory);
		else super.func_85029_a(crashReportCategory);
	}	@Override	public void superAddEntityCrashInfo(Object crashReportCategory) {
		super.func_85029_a((CrashReportCategory) crashReportCategory);
	}	@Override
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}	@Override	public boolean superCanRenderOnFire() {
		return super.canRenderOnFire();
	}	@Override
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (master != null ? master.getEntityData() : super.getEntityData());
	}	@Override	public NBTTagCompound superGetEntityData() {
		return super.getEntityData();
	}	@Override
	public boolean shouldRiderSit() {
		return master != null ? master.shouldRiderSit() : super.shouldRiderSit();
	}	@Override	public boolean superShouldRiderSit() {
		return super.shouldRiderSit();
	}	@Override
	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return (ItemStack) (master != null ? master.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}	@Override	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return super.getPickedResult((MovingObjectPosition) movingObjectPosition);
	}	@Override
	public UUID getPersistentID() {
		return master != null ? master.getPersistentID() : super.getPersistentID();
	}	@Override	public UUID superGetPersistentID() {
		return super.getPersistentID();
	}	@Override
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}	@Override	public boolean superShouldRenderInPass(int pass) {
		return super.shouldRenderInPass(pass);
	}	@Override
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return master != null ? master.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}	@Override	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}	@Override
	public String registerExtendedProperties(String identifier, IExtendedEntityProperties iExtendedEntityProperties) {
		return master != null ? master.registerExtendedProperties(identifier, iExtendedEntityProperties) : super.registerExtendedProperties(identifier, iExtendedEntityProperties);
	}	@Override	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return super.registerExtendedProperties(identifier, (IExtendedEntityProperties) iExtendedEntityProperties);
	}	@Override
	public IExtendedEntityProperties getExtendedProperties(String identifier) {
		return (IExtendedEntityProperties) (master != null ? master.getExtendedProperties(identifier) : super.getExtendedProperties(identifier));
	}	@Override	public IExtendedEntityProperties superGetExtendedProperties(String identifier) {
		return super.getExtendedProperties(identifier);
	}	@Override
	public boolean superAttackEntityFrom(Object damageSource, float par2) {
		return super.attackEntityFrom((DamageSource) damageSource, (int)par2);
	}	@Override
	public void superHeal(float par1) {
		super.heal((int) par1);
	}	@Override
	public void superDamageEntity(Object damageSource, float par2) {
		super.damageEntity((DamageSource) damageSource, (int)par2);
	}	@Override
	public void superSetPlayerSPHealth(float par1) {
	}	@Override
	public void superFunc_110322_i() {
	}	@Override
	public void superFunc_142020_c(String par1Str) {
	}	@Override
	public void superSendChatToPlayer(Object chatMessageComponent) {
	}	@Override
	public boolean superIsRidingHorse() {
		return false;
	}	@Override
	public float superGetHorseJumpPower() {
		return 0;
	}	@Override
	public void superSetupCustomSkin() {
	}	@Override
	public Object superGetTextureSkin() {
		return null;
	}	@Override
	public Object superGetTextureCape() {
		return null;
	}	@Override
	public Object superGetLocationSkin() {
		return null;
	}	@Override
	public Object superGetLocationCape() {
		return null;
	}	@Override
	public void superApplyEntityAttributes() {
	}	@Override
	public void superDamageArmor(float par1) {
	}	@Override
	public Object superGetBedLocation(int dimension) {
		return null;
	}	@Override
	public boolean superIsSpawnForced(int dimension) {
		return false;
	}	@Override
	public void superSetSpawnChunk(Object chunkCoordinates, boolean forced, int dimension) {
	}	@Override
	public boolean superIsCurrentToolAdventureModeExempt(int par1, int par2, int par3) {
		return false;
	}	@Override
	public Object superGetEntityWorld() {
		return null;
	}	@Override
	public void superSetAbsorptionAmount(float par1) {
	}	@Override
	public float superGetAbsorptionAmount() {
		return 0;
	}	@Override
	public float superGetDefaultEyeHeight() {
		return 0;
	}	@Override
	public Object superGetDisplayName() {
		return null;
	}	@Override
	public void superRefreshDisplayName() {
	}	@Override
	public int superFunc_142015_aE() {
		return 0;
	}	@Override
	public Object superGetLastAttacker() {
		return null;
	}	@Override
	public int superGetLastAttackerTime() {
		return 0;
	}	@Override
	public void superSetLastAttacker(Object entity) {
	}	@Override
	public void superOnChangedPotionEffect(Object potionEffect, boolean par2) {
	}	@Override
	public void superKnockBack(Object entity, float par2, double par3, double par5) {
	}	@Override
	public Object superApplyArmorCalculations(Object damageSource, float par2) {
		return 0F;
	}	@Override
	public Object superApplyPotionDamageCalculations(Object damageSource, float par2) {
		return 0F;
	}	@Override
	public Object superFunc_110142_aN() {
		return null;
	}	@Override
	public Object superGetEntityAttribute(Object attribute) {
		return null;
	}	@Override
	public Object superGetAttributeMap() {
		return null;
	}	@Override
	public void superDismountEntity(Object entity) {
	}	@Override
	public boolean superIsOnSameTeam(Object entityLivingBase) {
		return false;
	}	@Override
	public boolean superIsOnTeam(Object team) {
		return false;
	}	@Override
	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return false;
	}	@Override
	public boolean superShouldSetPosAfterLoading() {
		return false;
	}	@Override
	public void superOnChunkLoad() {
	}	@Override
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0;
	}	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}	@Override
	public int superGetMaxSafePointTries() {
		return 0;
	}	@Override
	public UUID superGetUniqueID() {
		return null;
	}	@Override
	public boolean superCanRiderInteract() {
		return false;
	}	@Override
	public boolean superShouldDismountInWater(Object entity) {
		return false;
	}	@Override
	public void superCloseScreenNoPacket() {
	}	@Override
	public Object superGetStatFileWriter() {
		return null;
	}	@Override
	public void superFunc_146100_a(Object tileEntity) {
	}	@Override
	public void superFunc_146095_a(Object commandBlockLogic) {
	}	@Override
	public void superFunc_146093_a(Object tileEntityHopper) {
	}	@Override
	public void superFunc_146104_a(Object tileEntityBeacon) {
	}	@Override
	public void superFunc_146102_a(Object tileEntityDispenser) {
	}	@Override
	public void superFunc_146098_a(Object tileEntityBrewingStand) {
	}	@Override
	public void superFunc_146101_a(Object tileEntityFurnace) {
	}	@Override
	public void superSendMessage(Object iChatComponent) {
	}	@Override
	public void superSendStatusMessage(Object iChatComponent, boolean p_146105_2_) {	}	@Override
	public String superGetSplashSound() {
		return null;
	}	@Override
	public String superGetSwimSound() {
		return null;
	}	@Override
	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta) {
		return 0;
	}	@Override
	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return 0;
	}	@Override
	public Object superGetGameProfile() {
		return null;
	}	@Override
	public String superFunc_146067_o(int p_146067_1_) {
		return null;
	}	@Override
	public boolean superCanDropLoot() {
		return false;
	}	@Override
	public int superGetEntityId() {
		return entityId;
	}	@Override
	public void superSetEntityId(int p_145769_1_) {
		entityId = p_145769_1_;
	}	@Override
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}	@Override
	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}	@Override
	public Object superDropItem(Object item, int p_145779_2_) {
		return null;
	}	@Override
	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0;
	}	@Override
	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
	}	@Override
	public void superFunc_152121_a(Object type, Object resourceLocation) {
	}	@Override
	public void superSendEnterCombat() {
	}	@Override
	public void superSendEndCombat() {
	}	@Override
	public void superOnUpdateWalkingPlayer() {
	}	@Override
	public void superCloseScreenAndDropStack() {
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
	public Object superGetPosition() {
		return null;
	}	@Override
	public boolean superIsServerWorld() {
		return false;
	}	@Override
	public void superOpenEditSign(Object tileEntitySign) {
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
		return 0;
	}	@Override
	public Object superDropItem(Object itemStack, boolean dropAround, boolean traceItem) {
		return null;
	}	@Override
	public float superGetToolDigEfficiency(Object block) {
		return 0;
	}	@Override
	public float superGetDigSpeed(Object iBlockState, Object blockPos) {
		return 0;
	}	@Override
	public Object superTrySleep(Object blockPos) {
		return null;
	}	@Override
	public void superSetSpawnPoint(Object blockPos, boolean forced) {
	}	@Override
	public void superFall(float distance, float damageMultiplier) {
	}	@Override
	public int superGetXPSeed() {
		return 0;
	}	@Override
	public void superRemoveExperienceLevel(int levels) {
	}	@Override
	public boolean superIsAllowEdit() {
		return false;
	}	@Override
	public boolean superCanPlayerEdit(Object blockPos, Object enumFacing, Object itemStack) {
		return false;
	}	@Override
	public Object[] superGetInventory() {
		return null;
	}	@Override
	public boolean superCanOpen(Object lockCode) {
		return false;
	}	@Override
	public boolean superIsWearing(Object enumPlayerModelParts) {
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
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}	@Override
	public int superGetRevengeTimer() {
		return 0;
	}	@Override
	public void superUpdatePotionMetadata() {
	}	@Override
	public void superResetPotionEffectMetadata() {
	}	@Override
	public Object superGetCombatTracker() {
		return null;
	}	@Override
	public float superGetJumpUpwardsMotion() {
		return 0;
	}	@Override
	public void superHandleJumpLava() {
	}	@Override
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
	}	@Override
	public void superMarkPotionsDirty() {
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
		return 0;
	}	@Override
	public double superGetDistanceSqToCenter(Object blockPos) {
		return 0;
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
		return 0;
	}	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return false;
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
	public Object superGetHoverEvent() {
		return null;
	}	@Override
	public boolean superIsSpectatedByPlayer(Object entityPlayerMP) {
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
	public Object superGetCommandStats() {
		return null;
	}	@Override
	public Object superGetNBTTagCompound() {
		return null;
	}	@Override
	public void superClientUpdateEntityNBT(Object nBTTagCompound) {
	}	@Override
	public boolean superInteractAt(Object entityPlayer, Object vec3) {
		return false;
	}	@Override
	public boolean superIsImmuneToExplosions() {
		return false;
	}	@Override
	public void superApplyEnchantments(Object entityLivingBase, Object entity) {
	}	@Override	public void superSetInPortal() {		super.setInPortal();	}	@Override	public boolean superEquals(Object p_equals_1_) {		return super.equals(p_equals_1_);	}	@Override	public int superHashCode() {		return super.hashCode();	}	@Override	public boolean superattackEntityFrom(Object damageSource, Object p_70097_2_) {		return super.attackEntityFrom((DamageSource) damageSource, (Integer) p_70097_2_);	}	// 190~	@Override	public void superOpenGuiHorseInventory(Object entityHorse, Object iInventory) {	}	@Override	public Object superGetItemStackFromSlot(Object par1) {		return null;	}	@Override	public void superSetItemStackToSlot(Object entityEquipmentSlot, Object itemStack) {	}	@Override	public float superUpdateDistance(float par1, float par2) {		return 0.0F;	}	@Override	public boolean superWriteToNBTAtomically(Object nBTTagCompound) {		return false;	}	@Override	public boolean superProcessInitialInteract(Object entityPlayer) {		return false;	}	@Override	public Object superGetItemStackFromSlot(int par1) {		return null;	}	@Override	public Object superFropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {		return null;	}	@Override	public void superDisplayGuiEditCommandCart(Object commandBlockLogic) {	}	@Override	public void superTakeStat(Object statBase) {	}	@Override	public Object superGetFallSound(int damageValue) {		return null;	}	@Override	public void superSetCommandStats(Object entity) {	}	@Override	public void superSwingArm(Object enumHand) {	}	@Override	public void superOpenBook(Object itemStack, Object enumHand) {	}	@Override	public Object superInteract(Object entity, Object itemStack, Object enumHand) {		return null;	}	@Override	public void superUpdatePassenger(Object entity) {	}	@Override	public boolean superProcessInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {		return false;	}	@Override	public void superSetRenderYawOffset(float p_181013_1_) {	}	@Override	public void superDropLoot(boolean p_184610_1_, int p_184610_2_, Object damageSource) {	}	@Override	public void superFrostWalk(Object blockPos) {	}	@Override	public void superPlayEquipSound(Object itemStack) {	}	@Override	public Object superRemoveActivePotionEffect(Object potion) {		return null;	}	@Override	public void superRemovePotionEffect(Object potion) {	}	@Override	public void superPlayHurtSound(Object damageSource) {	}	@Override	public void superDamageShield(float p_184590_1_) {	}	@Override	public Object superGetHeldItemOffhand() {		return null;	}	@Override	public Object superGetHeldItem(Object enumHand) {		return null;	}	@Override	public void superSetHeldItem(Object enumHand, Object itemStack) {	}	@Override	public Object superGetActiveHand() {		return null;	}	@Override	public void superUpdateActiveHand() {	}	@Override	public void superSetActiveHand(Object enumHand) {	}	@Override	public Object superGetActiveItemStack() {		return null;	}	@Override	public int superGetItemInUseMaxCount() {		return -1;	}	@Override	public void superStopActiveHand() {	}	@Override	public void superResetActiveHand() {	}	@Override	public boolean superIsActiveItemStackBlocking() {		return false;	}	@Override	public boolean superIsElytraFlying() {		return false;	}	@Override	public int superGetTicksElytraFlying() {		return -1;	}	@Override	public boolean superAttemptTeleport(double x, double y, double z) {		return false;	}	@Override	public boolean superCanBeHitWithPotion() {		return false;	}	@Override	public void superPlayStepSound(int par1, int par2, int par3, Object par4) {	}	@Override	public boolean superIsInRangeToRender3d(Object vec3) {		return false;	}	@Override	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {		return false;	}	@Override	public Object superGetTags() {		return null;	}	@Override	public boolean superAddTag(String tag) {		return false;	}	@Override	public boolean superRemoveTag(String tag) {		return false;	}	@Override	public void superSetDropItemsWhenDead(boolean p_184174_1_) {	}	@Override	public void superDecrementTimeUntilPortal() {	}	@Override	public void superResetPositionToBB() {	}	@Override	public void superApplyOrientationToEntity(Object entity) {	}	@Override	public boolean superStartRiding(Object entity, boolean force) {		return false;	}	@Override	public boolean superCanBeRidden(Object entity) {		return false;	}	@Override	public void superRemovePassengers() {	}	@Override	public void superDismountRidingEntity() {	}	@Override	public void superAddPassenger(Object entity) {	}	@Override	public void superRemovePassenger(Object entity) {	}	@Override	public boolean superCanFitPassenger(Object entity) {		return false;	}	@Override	public Object superGetHeldEquipment() {		return null;	}	@Override	public Object superGetArmorInventoryList() {		return null;	}	@Override	public Object superGetEquipmentAndArmor() {		return null;	}	@Override	public boolean superIsBeingRidden() {		return false;	}	@Override	public boolean superIsGlowing() {		return false;	}	@Override	public void superSetGlowing(boolean p_184195_1_) {	}	@Override	public boolean superIsOnScoreboardTeam(Object team) {		return false;	}	@Override	public void superSetEntityInvulnerable(boolean isInvulnerable) {	}	@Override	public boolean superIsNonBoss() {		return false;	}	@Override	public void superSetUniqueId(UUID uniqueIdIn) {	}	@Override	public void superNotifyDataManagerChange(Object dataParameter) {	}	@Override	public Object superGetAdjustedHorizontalFacing() {		return null;	}	@Override	public Object superGetRenderBoundingBox() {		return null;	}	@Override	public Object superGetServer() {		return null;	}	@Override	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {		return null;	}	@Override	public boolean superHasCapability(Object capability, Object enumFacing) {		return false;	}	@Override	public void superDeserializeNBT(Object nBTTagCompound) {	}	@Override	public Object superSerializeNBT() {		return null;	}	@Override	public void superAddTrackingPlayer(Object entityPlayerMP) {	}	@Override	public void superRemoveTrackingPlayer(Object entityPlayerMP) {	}	@Override	public float superGetRotatedYaw(Object rotation) {		return 0.0F;	}	@Override	public float superGetMirroredYaw(Object mirror) {		return 0.0F;	}	@Override	public boolean superSetPositionNonDirty() {		return false;	}	@Override	public Object superGetControllingPassenger() {		return null;	}	@Override	public Object superGetPassengers() {		return null;	}	@Override	public boolean superIsPassenger(Object entity) {		return false;	}	@Override	public Object superGetRecursivePassengers() {		return null;	}	@Override	public Object superGetLowestRidingEntity() {		return null;	}	@Override	public boolean superIsRidingSameEntity(Object entity) {		return false;	}	@Override	public boolean superIsRidingOrBeingRiddenBy(Object entity) {		return false;	}	@Override	public boolean superCanPassengerSteer() {		return false;	}	@Override	public Object superGetRidingEntity() {		return null;	}	@Override	public Object superGetPushReaction() {		return null;	}	@Override	public Object superGetSoundCategory() {		return null;	}	@Override	public Object superGetCapability(Object capability, Object enumFacing) {		return null;	}	@Override	public Object superGetRecursivePassengersByType(Class entityClass) {		return null;	}	@Override	public void superSetServerBrand(String brand) {	}	@Override	public String superGetServerBrand() {		return null;	}	@Override	public int superGetPermissionLevel() {		return -1;	}	@Override	public void superSetPermissionLevel(int p_184839_1_) {	}	@Override	public void superDisplayGuiCommandBlock(Object tileEntityCommandBlock) {	}	@Override	public boolean superIsRowingBoat() {		return false;	}	@Override	public boolean superIsCreative() {		return false;	}	@Override	public boolean superIsPlayerInfoSet() {		return false;	}	@Override	public Object superGetLocationElytra() {		return null;	}	@Override	public Object superCreateCooldownTracker() {		return null;	}	@Override	public void superUpdateSize() {	}	@Override	public void superSpawnSweepParticles() {	}	@Override	public boolean superHasAchievement(Object achievement) {		return false;	}	@Override	public Object superGetPrimaryHand() {		return null;	}	@Override	public void superSetPrimaryHand(Object enumHandSide) {	}	@Override	public float superGetCooldownPeriod() {		return 0.0F;	}	@Override	public float superGetCooledAttackStrength(float adjustTicks) {		return 0.0F;	}	@Override	public void superResetCooldown() {	}	@Override	public Object superGetCooldownTracker() {		return null;	}	@Override	public float superGetLuck() {		return 0.0F;	}	@Override	public void superAddPrefix(Object iTextComponent) {	}	@Override	public void superAddSuffix(Object iTextComponent) {	}	@Override	public Object superGetPrefixes() {		return null;	}	@Override	public Object superGetSuffixes() {		return null;	}	@Override	public boolean superIgnoreItemEntityData() {		return false;	}	@Override	public void superSetItemStackToSlot(int p_70062_1_, Object itemStack) {	}	@Override	public boolean superIsEntityInsideOpaqueBlock() {		return false;	}	@Override	public void superUpdateRidden() {	}	@Override	public boolean superIsNotColliding() {		return false;	}	@Override	public void superSetMaxHealth(Object floatOrInt) {		maxHealth = (Integer) floatOrInt;	}	@Override	public String superGetCachedUniqueIdString() {		return null;	}}