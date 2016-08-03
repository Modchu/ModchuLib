package modchu.lib.forge.mc152;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
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
import net.minecraftforge.common.IExtendedEntityProperties;
	public Modchu_IEntityPlayerSPMaster master;
	public boolean initFlag;
		super((Minecraft)map.get("Object"), (World)map.get("Object1"), (Session)map.get("Object2"), (NetClientHandler)map.get("Object3"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityPlayerSP init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityPlayerSPMaster ? (Modchu_IEntityPlayerSPMaster) instance : null;
		if (master != null); else Modchu_Debug.lDebug("Modchu_EntityPlayerSP init master == null !!");
	}
	public void init() {
		if (master != null) master.init();
		initFlag = true;
	}
	public void wakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {
		super.wakeUpPlayer(flag, flag1, flag2);
		if (master != null) master.wakeUpPlayer(flag, flag1, flag2);
	}
	public void preparePlayerToSpawn() {
		super.preparePlayerToSpawn();
		if (master != null) master.preparePlayerToSpawn();
	}
	public void setPositionCorrection(double par1, double par3, double par5) {
		if (master != null) master.setPositionCorrection(par1, par3, par5);
	}
	public void onLivingUpdate() {
		if (master != null) master.onLivingUpdate();
		super.onLivingUpdate();
	}
	public void moveEntityWithHeading(float f, float f1) {
		if (master != null) master.moveEntityWithHeading(f, f1);
		super.moveEntityWithHeading(f, f1);
	}
	public String getHurtSound() {
		Modchu_Debug.mDebug("Modchu_EntityPlayerSP getHurtSound");
		if (master != null) return (String) master.getHurtSound();
		return super.getHurtSound();
	}
	public EnumCreatureAttribute getCreatureAttribute() {
		if (master != null) return (EnumCreatureAttribute) master.getCreatureAttribute();
		return super.getCreatureAttribute();
	}
	public EnumCreatureAttribute supergetCreatureAttribute() {
		return super.getCreatureAttribute();
	}
	protected void setSize(float f, float f1) {
		if (master != null) master.setSize(f, f1);
	}
	public void supersetSize(float f, float f1) {
		super.setSize(f, f1);
	}
	public double getMountedYOffset() {
		if (master != null) return master.getMountedYOffset();
		return super.getMountedYOffset();
	}
	protected void resetHeight() {
		if (master != null) master.resetHeight();
	}
	public double getYOffset() {
		if (master != null) return master.getYOffset();
		return super.getYOffset();
	}
	public boolean pushOutOfBlocks(double d, double d1, double d2) {
		if (master != null) return master.pushOutOfBlocks(d, d1, d2);
		return super.pushOutOfBlocks(d, d1, d2);
	}
	public boolean superpushOutOfBlocks(double d, double d1, double d2) {
		return super.pushOutOfBlocks(d, d1, d2);
	}
	public boolean isEntityInsideOpaqueBlock() {
		if (master != null) return master.isEntityInsideOpaqueBlock();
		return super.isEntityInsideOpaqueBlock();
	}
		if (master != null) master.copyPlayer(entityplayer);
	}
		//super.copyPlayer(entityplayer);
	}
		if (master != null) master.copyInventory(inventoryplayer);
	}
	public void publicResetHeight() {
		if (master != null) master.resetHeight();
	}
	public void publicSetSize(float f, float f1) {
		if (master != null) master.setSize(f, f1);
	}
	public void updateRidden() {
		if (master != null) master.updateRidden();
	}
	public void superupdateRidden() {
		super.updateRidden();
	}
		return master != null ? master.attackEntityFrom(var1, par1DamageSource, par2) : false;
	}
		return master != null ? master.attackEntityFrom(par1DamageSource, par2) : false;
	}
		return super.attackEntityFrom(par1DamageSource, par2);
	}
	public void onDeath(DamageSource par1DamageSource) {
		if (master != null) master.onDeath(par1DamageSource);
	}
	public void superonDeath(Object par1DamageSource) {
		super.onDeath((DamageSource) par1DamageSource);
	}
	public void setHealth(int i) {
		if (master != null) master.setHealth(i);
	}
	public void sendMotionUpdates() {
		if (master != null) master.sendMotionUpdates();
	}
	public void supersendMotionUpdates() {
		super.sendMotionUpdates();
	}
	public float getMaxHealth() {
		return master != null ? master.getMaxHealth() : super.getMaxHealth();
	}
*/
	public float getEntityHealth() {
		return (Float) (master != null ? master.getHealth() : super.getHealth());
	}
		if (master != null) master.setHealth(f);
	}
	public Object supercopyPlayer(Object entityplayer) {
		return null;
	}
	public boolean superattackEntityFrom(Object damageSource, int par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
	}
	public void superwakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {
		super.wakeUpPlayer(flag, flag1, flag2);
	}
	public void superpreparePlayerToSpawn() {
		super.preparePlayerToSpawn();
	}
	public void supersetPositionCorrection(double par1, double par3, double par5) {
	}
	public void superonLivingUpdate() {
		super.onLivingUpdate();
	}
	public void supermoveEntityWithHeading(float f, float f1) {
		super.moveEntityWithHeading(f, f1);
	}
	public String supergetHurtSound() {
		return super.getHurtSound();
	}
	public double supergetMountedYOffset() {
		return super.getMountedYOffset();
	}
	public void superresetHeight() {
		super.resetHeight();
	}
	public double supergetYOffset() {
		return super.getYOffset();
	}
	public boolean superisEntityInsideOpaqueBlock() {
		return super.isEntityInsideOpaqueBlock();
	}
	public Object supercopyInventory(Object inventoryplayer) {
		return null;
	}
	public boolean superattackEntityFrom(Object entity, Object damageSource, int i) {
		return super.attackEntityFrom((DamageSource) damageSource, i);
	}
	public float supergetMaxHealth() {
		return super.getMaxHealth();
	}
	public int supergetMaxHealthInt() {
		return super.getMaxHealth();
	}
	public float supergetHealth() {
		return super.getHealth();
	}
	public int supergetHealthInt() {
		return super.getHealth();
	}
	public void supersetHealth(float f) {
		super.setHealth((int) f);
	}
	public void supersetHealthInt(int i) {
		super.setHealth(i);
	}
	public void heal(int par1) {
		if (master != null) master.heal(par1);
		else super.heal(par1);
	}
		super.heal(par1);
	}
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}
		super.onUpdate();
	}
	public EntityItem dropOneItem(boolean par1) {
		return (EntityItem) (master != null ? master.dropItem(par1) : super.dropOneItem(par1));
	}
		return super.dropOneItem(par1);
	}
	public void joinEntityItemWithWorld(EntityItem entityItem) {
		if (master != null) master.dropItemAndGetStack(entityItem);
		else super.joinEntityItemWithWorld(entityItem);
	}
		super.joinEntityItemWithWorld((EntityItem) entityItem);
	}
	public void sendChatMessage(String par1Str) {
		if (master != null) master.sendChatMessage(par1Str);
		else super.sendChatMessage(par1Str);
	}
		super.sendChatMessage(par1Str);
	}
	public void swingItem() {
		if (master != null) master.swingArm();
		else super.swingItem();
	}
		super.swingItem();
	}
	public void respawnPlayer() {
		if (master != null) master.respawnPlayer();
		else super.respawnPlayer();
	}
		super.respawnPlayer();
	}
	protected void damageEntity(DamageSource damageSource, int par2) {
		if (master != null) master.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
	}
		super.damageEntity((DamageSource) damageSource, par2);
	}
	public void closeScreen() {
		if (master != null) master.closeScreen();
		else super.closeScreen();
	}
		super.closeScreen();
	}
	public void func_92015_f() {
		if (master != null) master.func_92015_f();
		else super.func_92015_f();
	}
		super.func_92015_f();
	}
	public void addStat(StatBase statBase, int par2) {
		if (master != null) master.addStat(statBase, par2);
		else super.addStat(statBase, par2);
	}
		super.addStat((StatBase) statBase, par2);
	}
	public void incrementStat(StatBase statBase, int par2) {
		if (master != null) master.incrementStat(statBase, par2);
		else super.incrementStat(statBase, par2);
	}
		super.incrementStat((StatBase) statBase, par2);
	}
	public void sendPlayerAbilities() {
		if (master != null) master.sendPlayerAbilities();
		else super.sendPlayerAbilities();
	}
		super.sendPlayerAbilities();
	}
	public boolean func_71066_bF() {
		return master != null ? master.func_71066_bF() : super.func_71066_bF();
	}
		return super.func_71066_bF();
	}
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.moveEntity(par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}
		super.moveEntity(par1, par3, par5);
	}
	public void updateEntityActionState() {
		if (master != null) master.updateEntityActionState();
		else super.updateEntityActionState();
	}
		super.updateEntityActionState();
	}
	protected boolean isClientWorld() {
		return master != null ? master.isClientWorld() : super.isClientWorld();
	}
		return super.isClientWorld();
	}
	public float getFOVMultiplier() {
		return master != null ? master.getFOVMultiplier() : super.getFOVMultiplier();
	}
		return super.getFOVMultiplier();
	}
	public void updateCloak() {
		if (master != null) master.updateCloak();
		else super.updateCloak();
	}
		super.updateCloak();
	}
	public void displayGUIEditSign(TileEntity tileEntity) {
		if (master != null) master.displayGUIEditSign(tileEntity);
		else super.displayGUIEditSign(tileEntity);
	}
		super.displayGUIEditSign((TileEntity) tileEntity);
	}
	public void displayGUIBook(ItemStack itemStack) {
		if (master != null) master.openBook(itemStack);
		else super.displayGUIBook(itemStack);
	}
		super.displayGUIBook((ItemStack) itemStack);
	}
	public void displayGUIChest(IInventory iInventory) {
		if (master != null) master.displayGUIChest(iInventory);
		else super.displayGUIChest(iInventory);
	}
		super.displayGUIChest((IInventory) iInventory);
	}
	public void displayGUIHopper(TileEntityHopper tileEntityHopper) {
		if (master != null) master.displayGUIHopper(tileEntityHopper);
		else super.displayGUIHopper(tileEntityHopper);
	}
		super.displayGUIHopper((TileEntityHopper) tileEntityHopper);
	}
	public void displayGUIHopperMinecart(EntityMinecartHopper entityMinecartHopper) {
		if (master != null) master.displayGUIHopperMinecart(entityMinecartHopper);
		else super.displayGUIHopperMinecart(entityMinecartHopper);
	}
		super.displayGUIHopperMinecart((EntityMinecartHopper) entityMinecartHopper);
	}
	public void displayGUIWorkbench(int par1, int par2, int par3) {
		if (master != null) master.displayGUIWorkbench(par1, par2, par3);
		else super.displayGUIWorkbench(par1, par2, par3);
	}
		super.displayGUIWorkbench(par1, par2, par3);
	}
	public void displayGUIEnchantment(int par1, int par2, int par3, String par4Str) {
		if (master != null) master.displayGUIEnchantment(par1, par2, par3, par4Str);
		else super.displayGUIEnchantment(par1, par2, par3, par4Str);
	}
		super.displayGUIEnchantment(par1, par2, par3, par4Str);
	}
	public void displayGUIAnvil(int par1, int par2, int par3) {
		if (master != null) master.displayGUIAnvil(par1, par2, par3);
		else super.displayGUIAnvil(par1, par2, par3);
	}
		super.displayGUIAnvil(par1, par2, par3);
	}
	public void displayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
		if (master != null) master.displayGUIFurnace(tileEntityFurnace);
		else super.displayGUIFurnace(tileEntityFurnace);
	}
		super.displayGUIFurnace((TileEntityFurnace) tileEntityFurnace);
	}
	public void displayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
		if (master != null) master.displayGUIBrewingStand(tileEntityBrewingStand);
		else super.displayGUIBrewingStand(tileEntityBrewingStand);
	}
		super.displayGUIBrewingStand((TileEntityBrewingStand) tileEntityBrewingStand);
	}
	public void displayGUIBeacon(TileEntityBeacon tileEntityBeacon) {
		if (master != null) master.displayGUIBeacon(tileEntityBeacon);
		else super.displayGUIBeacon(tileEntityBeacon);
	}
		super.displayGUIBeacon((TileEntityBeacon) tileEntityBeacon);
	}
	public void displayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
		if (master != null) master.displayGUIDispenser(tileEntityDispenser);
		else super.displayGUIDispenser(tileEntityDispenser);
	}
		super.displayGUIDispenser((TileEntityDispenser) tileEntityDispenser);
	}
	public void displayGUIMerchant(IMerchant iMerchant, String par2Str) {
		if (master != null) master.displayGUIMerchant(iMerchant, par2Str);
		else super.displayGUIMerchant(iMerchant, par2Str);
	}
		super.displayGUIMerchant((IMerchant) iMerchant, par2Str);
	}
	public void onCriticalHit(Entity entity) {
		if (master != null) master.onCriticalHit(entity);
		else super.onCriticalHit(entity);
	}
		super.onCriticalHit((Entity) entity);
	}
	public void onEnchantmentCritical(Entity entity) {
		if (master != null) master.onEnchantmentCritical(entity);
		else super.onEnchantmentCritical(entity);
	}
		super.onEnchantmentCritical((Entity) entity);
	}
	public void onItemPickup(Entity entity, int par2) {
		if (master != null) master.onItemPickup(entity, par2);
		else super.onItemPickup(entity, par2);
	}
		super.onItemPickup((Entity) entity, par2);
	}
	public boolean isSneaking() {
		return master != null ? master.isSneaking() : super.isSneaking();
	}
		return super.isSneaking();
	}
	public void addChatMessage(String par1Str) {
		if (master != null) master.addChatMessage(par1Str);
		else super.addChatMessage(par1Str);
	}
		super.addChatMessage(par1Str);
	}
	public void setSprinting(boolean par1) {
		if (master != null) master.setSprinting(par1);
		else super.setSprinting(par1);
	}
		super.setSprinting(par1);
	}
	public void setXPStats(float par1, int par2, int par3) {
		if (master != null) master.setXPStats(par1, par2, par3);
		else super.setXPStats(par1, par2, par3);
	}
		super.setXPStats(par1, par2, par3);
	}
	public void sendChatToPlayer(String par1Str) {
		if (master != null) master.sendChatToPlayer(par1Str);
		else super.sendChatToPlayer(par1Str);
	}
		super.sendChatToPlayer(par1Str);
	}
	public boolean canCommandSenderUseCommand(int par1, String par2Str) {
		return master != null ? master.canCommandSenderUseCommand(par1, par2Str) : super.canCommandSenderUseCommand(par1, par2Str);
	}
		return super.canCommandSenderUseCommand(par1, par2Str);
	}
	public ChunkCoordinates getPlayerCoordinates() {
		return (ChunkCoordinates) (master != null ? master.getPlayerCoordinates() : super.getPlayerCoordinates());
	}
		return super.getPlayerCoordinates();
	}
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}
		return super.getHeldItem();
	}
	public void playSound(String par1Str, float par2, float par3) {
		if (master != null) master.playSound(par1Str, par2, par3);
		else super.playSound(par1Str, par2, par3);
	}
		super.playSound((String) par1Str, par2, par3);
	}
	public int getMaxHealth() {
		return (int) (master != null ? master.getMaxHealth() : super.getMaxHealth());
	}
		return super.getMaxHealth();
	}
	protected void entityInit() {
		if (master != null) master.entityInit();
		else super.entityInit();
	}
		super.entityInit();
	}
	public ItemStack getItemInUse() {
		return (ItemStack) (master != null ? master.getItemInUse() : super.getItemInUse());
	}
		return super.getItemInUse();
	}
	public int getItemInUseCount() {
		return master != null ? master.getItemInUseCount() : super.getItemInUseCount();
	}
		return super.getItemInUseCount();
	}
	public boolean isUsingItem() {
		return master != null ? master.isHandActive() : super.isUsingItem();
	}
		return super.isUsingItem();
	}
	public int getItemInUseDuration() {
		return master != null ? master.getItemInUseDuration() : super.getItemInUseDuration();
	}
		return super.getItemInUseDuration();
	}
	public void stopUsingItem() {
		if (master != null) master.stopUsingItem();
		else super.stopUsingItem();
	}
		super.stopUsingItem();
	}
	public void clearItemInUse() {
		if (master != null) master.clearItemInUse();
		else super.clearItemInUse();
	}
		super.clearItemInUse();
	}
	public boolean isBlocking() {
		return master != null ? master.isBlocking() : super.isBlocking();
	}
		return super.isBlocking();
	}
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}
		return super.getMaxInPortalTime();
	}
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}
		return super.getPortalCooldown();
	}
	protected void updateItemUse(ItemStack itemStack, int par2) {
		if (master != null) master.updateItemUse(itemStack, par2);
		else super.updateItemUse(itemStack, par2);
	}
		super.updateItemUse((ItemStack) itemStack, par2);
	}
	protected void onItemUseFinish() {
		if (master != null) master.onItemUseFinish();
		else super.onItemUseFinish();
	}
		super.onItemUseFinish();
	}
	public void handleHealthUpdate(byte par1) {
		if (master != null) master.handleStatusUpdate(par1);
		else super.handleHealthUpdate(par1);
	}
		super.handleHealthUpdate(par1);
	}
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}
		return super.isMovementBlocked();
	}
	public void mountEntity(Entity entity) {
		if (master != null) master.startRiding(entity);
		else super.mountEntity(entity);
	}
		super.mountEntity((Entity) entity);
	}
	public int getScore() {
		return master != null ? master.getScore() : super.getScore();
	}
		return super.getScore();
	}
	public void setScore(int par1) {
		if (master != null) master.setScore(par1);
		else super.setScore(par1);
	}
		super.setScore(par1);
	}
	public void addScore(int par1) {
		if (master != null) master.addScore(par1);
		else super.addScore(par1);
	}
		super.addScore(par1);
	}
	public void addToPlayerScore(Entity entity, int par2) {
		if (master != null) master.addToPlayerScore(entity, par2);
		else super.addToPlayerScore(entity, par2);
	}
		super.addToPlayerScore((Entity) entity, par2);
	}
	public EntityItem dropPlayerItem(ItemStack itemStack) {
		return (EntityItem) (master != null ? master.dropPlayerItem(itemStack) : super.dropPlayerItem(itemStack));
	}
		return super.dropPlayerItem((ItemStack) itemStack);
	}
	public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean par2) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, par2) : super.dropPlayerItemWithRandomChoice(itemStack, par2));
	}
		return super.dropPlayerItemWithRandomChoice((ItemStack) itemStack, par2);
	}
	public float getCurrentPlayerStrVsBlock(Block block, boolean par2) {
		return master != null ? master.getCurrentPlayerStrVsBlock(block, par2) : super.getCurrentPlayerStrVsBlock(block, par2);
	}
		return super.getCurrentPlayerStrVsBlock((Block) block, par2);
	}
	public float getCurrentPlayerStrVsBlock(Block block, boolean par2, int meta) {
		return master != null ? master.getCurrentPlayerStrVsBlock(block, par2, meta) : super.getCurrentPlayerStrVsBlock(block, par2, meta);
	}
		return super.getCurrentPlayerStrVsBlock((Block) block, par2, meta);
	}
	public boolean canHarvestBlock(Block block) {
		return master != null ? master.canHarvestBlock(block) : super.canHarvestBlock(block);
	}
		return super.canHarvestBlock((Block) block);
	}
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeEntityToNBT(nBTTagCompound);
		else super.writeEntityToNBT(nBTTagCompound);
	}
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
	}
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}
		return super.getEyeHeight();
	}
	public boolean func_96122_a(EntityPlayer entityPlayer) {
		return master != null ? master.canAttackPlayer(entityPlayer) : super.func_96122_a(entityPlayer);
	}
		return super.func_96122_a((EntityPlayer) entityPlayer);
	}
	protected void alertWolves(EntityLiving entityLiving, boolean par2) {
		if (master != null) master.alertWolves(entityLiving, par2);
		else super.alertWolves(entityLiving, par2);
	}
		super.alertWolves((EntityLiving) entityLiving, par2);
	}
	protected void damageArmor(int par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}
		super.damageArmor(par1);
	}
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}
		return super.getTotalArmorValue();
	}
	public float func_82243_bO() {
		return master != null ? master.getArmorVisibility() : super.func_82243_bO();
	}
		return super.func_82243_bO();
	}
	public boolean interactWith(Entity entity) {
		return master != null ? master.interactWith(entity) : super.interactWith(entity);
	}
		return super.interactWith((Entity) entity);
	}
	public ItemStack getCurrentEquippedItem() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getCurrentEquippedItem());
	}
		return super.getCurrentEquippedItem();
	}
	public void destroyCurrentEquippedItem() {
		if (master != null) master.destroyCurrentEquippedItem();
		else super.destroyCurrentEquippedItem();
	}
		super.destroyCurrentEquippedItem();
	}
	public void attackTargetEntityWithCurrentItem(Entity entity) {
		if (master != null) master.attackTargetEntityWithCurrentItem(entity);
		else super.attackTargetEntityWithCurrentItem(entity);
	}
		super.attackTargetEntityWithCurrentItem((Entity) entity);
	}
	public void setDead() {
		if (master != null) master.setDead();
		else super.setDead();
	}
		super.setDead();
	}
	public EnumStatus sleepInBedAt(int par1, int par2, int par3) {
		return (EnumStatus) (master != null ? master.sleepInBedAt(par1, par2, par3) : super.sleepInBedAt(par1, par2, par3));
	}
		return super.sleepInBedAt(par1, par2, par3);
	}
	public float getBedOrientationInDegrees() {
		return master != null ? master.getBedOrientationInDegrees() : super.getBedOrientationInDegrees();
	}
		return super.getBedOrientationInDegrees();
	}
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}
		return super.isPlayerSleeping();
	}
	public boolean isPlayerFullyAsleep() {
		return master != null ? master.isPlayerFullyAsleep() : super.isPlayerFullyAsleep();
	}
		return super.isPlayerFullyAsleep();
	}
	public int getSleepTimer() {
		return master != null ? master.getSleepTimer() : super.getSleepTimer();
	}
		return super.getSleepTimer();
	}
	protected boolean getHideCape(int par1) {
		return master != null ? master.getHideCape(par1) : super.getHideCape(par1);
	}
		return super.getHideCape(par1);
	}
	protected void setHideCape(int par1, boolean par2) {
		if (master != null) master.setHideCape(par1, par2);
		else super.setHideCape(par1, par2);
	}
		super.setHideCape(par1, par2);
	}
	public ChunkCoordinates getBedLocation() {
		return (ChunkCoordinates) (master != null ? master.getBedLocation() : super.getBedLocation());
	}
		return super.getBedLocation();
	}
	public boolean isSpawnForced() {
		return master != null ? master.isSpawnForced() : super.isSpawnForced();
	}
		return super.isSpawnForced();
	}
	public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean par2) {
		if (master != null) master.setSpawnChunk(chunkCoordinates, par2);
		else super.setSpawnChunk(chunkCoordinates, par2);
	}
		super.setSpawnChunk((ChunkCoordinates) chunkCoordinates, par2);
	}
	public void triggerAchievement(StatBase statBase) {
		if (master != null) master.addStat(statBase);
		else super.triggerAchievement(statBase);
	}
		super.triggerAchievement((StatBase) statBase);
	}
	protected void jump() {
		if (master != null) master.jump();
		else super.jump();
	}
		super.jump();
	}
	public void addMovementStat(double par1, double par3, double par5) {
		if (master != null) master.addMovementStat(par1, par3, par5);
		else super.addMovementStat(par1, par3, par5);
	}
		super.addMovementStat(par1, par3, par5);
	}
	protected void fall(float par1) {
		if (master != null) master.fall(par1);
		else super.fall(par1);
	}
		super.fall(par1);
	}
	public void onKillEntity(EntityLiving entityLiving) {
		if (master != null) master.onKillEntity(entityLiving);
		else super.onKillEntity(entityLiving);
	}
		super.onKillEntity((EntityLiving) entityLiving);
	}
	public void setInWeb() {
		if (master != null) master.setInWeb();
		else super.setInWeb();
	}
		super.setInWeb();
	}
	public Icon getItemIcon(ItemStack itemStack, int par2) {
		return (Icon) (master != null ? master.getItemIcon(itemStack, par2) : super.getItemIcon(itemStack, par2));
	}
		return super.getItemIcon((ItemStack) itemStack, par2);
	}
	public ItemStack getCurrentArmor(int par1) {
		return (ItemStack) (master != null ? master.getCurrentArmor(par1) : super.getCurrentArmor(par1));
	}
		return super.getCurrentArmor(par1);
	}
	protected void addRandomArmor() {
		if (master != null) master.dropLoot();
		else super.addRandomArmor();
	}
		super.addRandomArmor();
	}
	protected void func_82162_bC() {
		if (master != null) master.func_82162_bC();
		else super.func_82162_bC();
	}
		super.func_82162_bC();
	}
	public void addExperience(int par1) {
		if (master != null) master.addExperience(par1);
		else super.addExperience(par1);
	}
		super.addExperience(par1);
	}
	public void addExperienceLevel(int par1) {
		if (master != null) master.addExperienceLevel(par1);
		else super.addExperienceLevel(par1);
	}
		super.addExperienceLevel(par1);
	}
	public int xpBarCap() {
		return master != null ? master.xpBarCap() : super.xpBarCap();
	}
		return super.xpBarCap();
	}
	public void addExhaustion(float par1) {
		if (master != null) master.addExhaustion(par1);
		else super.addExhaustion(par1);
	}
		super.addExhaustion(par1);
	}
	public FoodStats getFoodStats() {
		return (FoodStats) (master != null ? master.getFoodStats() : super.getFoodStats());
	}
		return super.getFoodStats();
	}
	public boolean canEat(boolean par1) {
		return master != null ? master.canEat(par1) : super.canEat(par1);
	}
		return super.canEat(par1);
	}
	public boolean shouldHeal() {
		return master != null ? master.shouldHeal() : super.shouldHeal();
	}
		return super.shouldHeal();
	}
	public void setItemInUse(ItemStack itemStack, int par2) {
		if (master != null) master.setItemInUse(itemStack, par2);
		else super.setItemInUse(itemStack, par2);
	}
		super.setItemInUse((ItemStack) itemStack, par2);
	}
	public boolean canCurrentToolHarvestBlock(int par1, int par2, int par3) {
		return master != null ? master.canCurrentToolHarvestBlock(par1, par2, par3) : super.canCurrentToolHarvestBlock(par1, par2, par3);
	}
		return super.canCurrentToolHarvestBlock(par1, par2, par3);
	}
	public boolean canPlayerEdit(int par1, int par2, int par3, int par4, ItemStack itemStack) {
		return master != null ? master.canPlayerEdit(par1, par2, par3, par4, itemStack) : super.canPlayerEdit(par1, par2, par3, par4, itemStack);
	}
		return super.canPlayerEdit(par1, par2, par3, par4, (ItemStack) itemStack);
	}
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return master != null ? master.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}
		return super.getExperiencePoints((EntityPlayer) entityPlayer);
	}
	protected boolean isPlayer() {
		return master != null ? master.isPlayer() : super.isPlayer();
	}
		return super.isPlayer();
	}
	public String getEntityName() {
		return master != null ? master.getEntityName() : super.getEntityName();
	}
		return super.getEntityName();
	}
	public boolean func_94062_bN() {
		return master != null ? master.func_94062_bN() : super.func_94062_bN();
	}
		return super.func_94062_bN();
	}
	public boolean func_94059_bO() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.func_94059_bO();
	}
		return super.func_94059_bO();
	}
	public boolean canPickUpLoot() {
		return master != null ? master.canPickUpLoot() : super.canPickUpLoot();
	}
		return super.canPickUpLoot();
	}
	public void clonePlayer(EntityPlayer entityPlayer, boolean par2) {
		if (master != null) master.clonePlayer(entityPlayer, par2);
		else super.clonePlayer(entityPlayer, par2);
	}
		super.clonePlayer((EntityPlayer) entityPlayer, par2);
	}
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}
		return super.canTriggerWalking();
	}
	public void setGameType(EnumGameType enumGameType) {
		if (master != null) master.setGameType(enumGameType);
		else super.setGameType(enumGameType);
	}
		super.setGameType((EnumGameType) enumGameType);
	}
	public String getCommandSenderName() {
		return master != null ? master.getName() : super.getCommandSenderName();
	}
		return super.getCommandSenderName();
	}
	public StringTranslate getTranslator() {
		return (StringTranslate) (master != null ? master.getTranslator() : super.getTranslator());
	}
		return super.getTranslator();
	}
	public String translateString(String par1Str, Object... par2ArrayOfObj) {
		return master != null ? master.translateString(par1Str, par2ArrayOfObj) : super.translateString(par1Str, par2ArrayOfObj);
	}
		return super.translateString(par1Str, par2ArrayOfObj);
	}
	public InventoryEnderChest getInventoryEnderChest() {
		return (InventoryEnderChest) (master != null ? master.getInventoryEnderChest() : super.getInventoryEnderChest());
	}
		return super.getInventoryEnderChest();
	}
	public ItemStack getCurrentItemOrArmor(int par1) {
		return (ItemStack) (master != null ? master.getCurrentItemOrArmor(par1) : super.getCurrentItemOrArmor(par1));
	}
		return super.getCurrentItemOrArmor(par1);
	}
	public void setCurrentItemOrArmor(int par1, ItemStack itemStack) {
		if (master != null) master.setCurrentItemOrArmor(par1, itemStack);
		else super.setCurrentItemOrArmor(par1, itemStack);
	}
		super.setCurrentItemOrArmor(par1, (ItemStack) itemStack);
	}
	public boolean func_98034_c(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.func_98034_c(entityPlayer);
	}
		return super.func_98034_c((EntityPlayer) entityPlayer);
	}
	public ItemStack[] getLastActiveItems() {
		return (ItemStack[]) (master != null ? master.getLastActiveItems() : super.getLastActiveItems());
	}
		return super.getLastActiveItems();
	}
	public boolean getHideCape() {
		return master != null ? master.getHideCape() : super.getHideCape();
	}
		return super.getHideCape();
	}
	public boolean func_96092_aw() {
		return master != null ? master.isPushedByWater() : super.func_96092_aw();
	}
		return super.func_96092_aw();
	}
	public Scoreboard getWorldScoreboard() {
		return (Scoreboard) (master != null ? master.getWorldScoreboard() : super.getWorldScoreboard());
	}
		return super.getWorldScoreboard();
	}
	public ScorePlayerTeam getTeam() {
		return (ScorePlayerTeam) (master != null ? master.getTeam() : super.getTeam());
	}
		return super.getTeam();
	}
	public String getTranslatedEntityName() {
		return master != null ? master.getTranslatedEntityName() : super.getTranslatedEntityName();
	}
		return super.getTranslatedEntityName();
	}
	public void openGui(Object mod, int modGuiId, World world, int x, int y, int z) {
		if (master != null) master.openGui(mod, modGuiId, world, x, y, z);
		else super.openGui(mod, modGuiId, world, x, y, z);
	}
		super.openGui(mod, modGuiId, (World) world, x, y, z);
	}
	protected int func_96121_ay() {
		return master != null ? master.func_96121_ay() : super.func_96121_ay();
	}
		return super.func_96121_ay();
	}
	public EntityLookHelper getLookHelper() {
		return (EntityLookHelper) (master != null ? master.getLookHelper() : super.getLookHelper());
	}
		return super.getLookHelper();
	}
	public EntityMoveHelper getMoveHelper() {
		return (EntityMoveHelper) (master != null ? master.getMoveHelper() : super.getMoveHelper());
	}
		return super.getMoveHelper();
	}
	public EntityJumpHelper getJumpHelper() {
		return (EntityJumpHelper) (master != null ? master.getJumpHelper() : super.getJumpHelper());
	}
		return super.getJumpHelper();
	}
	public PathNavigate getNavigator() {
		return (PathNavigate) (master != null ? master.getNavigator() : super.getNavigator());
	}
		return super.getNavigator();
	}
	public EntitySenses getEntitySenses() {
		return (EntitySenses) (master != null ? master.getEntitySenses() : super.getEntitySenses());
	}
		return super.getEntitySenses();
	}
	public Random getRNG() {
		return master != null ? master.getRNG() : super.getRNG();
	}
		return super.getRNG();
	}
	public EntityLiving getAITarget() {
		return (EntityLiving) (master != null ? master.getAITarget() : super.getAITarget());
	}
		return super.getAITarget();
	}
	public EntityLiving getLastAttackingEntity() {
		return (EntityLiving) (master != null ? master.getLastAttackingEntity() : super.getLastAttackingEntity());
	}
		return super.getLastAttackingEntity();
	}
	public void setLastAttackingEntity(Entity entity) {
		if (master != null) master.setLastAttackingEntity(entity);
		else super.setLastAttackingEntity(entity);
	}
		super.setLastAttackingEntity((Entity) entity);
	}
	public int getAge() {
		return master != null ? master.getAge() : super.getAge();
	}
		return super.getAge();
	}
	public float getRotationYawHead() {
		return master != null ? master.getRotationYawHead() : super.getRotationYawHead();
	}
		return super.getRotationYawHead();
	}
	public void setRotationYawHead(float par1) {
		if (master != null) master.setRotationYawHead(par1);
		else super.setRotationYawHead(par1);
	}
		super.setRotationYawHead(par1);
	}
	public float getAIMoveSpeed() {
		return master != null ? master.getAIMoveSpeed() : super.getAIMoveSpeed();
	}
		return super.getAIMoveSpeed();
	}
	public void setAIMoveSpeed(float par1) {
		if (master != null) master.setAIMoveSpeed(par1);
		else super.setAIMoveSpeed(par1);
	}
		super.setAIMoveSpeed(par1);
	}
	public boolean attackEntityAsMob(Entity entity) {
		return master != null ? master.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}
		return super.attackEntityAsMob((Entity) entity);
	}
	public EntityLiving getAttackTarget() {
		return (EntityLiving) (master != null ? master.getAttackTarget() : super.getAttackTarget());
	}
		return super.getAttackTarget();
	}
	public void setAttackTarget(EntityLiving entityLiving) {
		if (master != null) master.setAttackTarget(entityLiving);
		else super.setAttackTarget(entityLiving);
	}
		super.setAttackTarget((EntityLiving) entityLiving);
	}
	public boolean canAttackClass(Class par1Class) {
		return master != null ? master.canAttackClass(par1Class) : super.canAttackClass(par1Class);
	}
		return super.canAttackClass(par1Class);
	}
	public void eatGrassBonus() {
		if (master != null) master.eatGrassBonus();
		else super.eatGrassBonus();
	}
		super.eatGrassBonus();
	}
	protected void updateFallState(double par1, boolean par3) {
		if (master != null) master.updateFallState(par1, par3);
		else super.updateFallState(par1, par3);
	}
		super.updateFallState(par1, par3);
	}
	public boolean isWithinHomeDistanceCurrentPosition() {
		return master != null ? master.isWithinHomeDistanceCurrentPosition() : super.isWithinHomeDistanceCurrentPosition();
	}
		return super.isWithinHomeDistanceCurrentPosition();
	}
	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return master != null ? master.isWithinHomeDistance(par1, par2, par3) : super.isWithinHomeDistance(par1, par2, par3);
	}
		return super.isWithinHomeDistance(par1, par2, par3);
	}
	public void setHomeArea(int par1, int par2, int par3, int par4) {
		if (master != null) master.setHomeArea(par1, par2, par3, par4);
		else super.setHomeArea(par1, par2, par3, par4);
	}
		super.setHomeArea(par1, par2, par3, par4);
	}
	public ChunkCoordinates getHomePosition() {
		return (ChunkCoordinates) (master != null ? master.getHomePosition() : super.getHomePosition());
	}
		return super.getHomePosition();
	}
	public float getMaximumHomeDistance() {
		return master != null ? master.getMaximumHomeDistance() : super.getMaximumHomeDistance();
	}
		return super.getMaximumHomeDistance();
	}
	public void detachHome() {
		if (master != null) master.detachHome();
		else super.detachHome();
	}
		super.detachHome();
	}
	public boolean hasHome() {
		return master != null ? master.hasHome() : super.hasHome();
	}
		return super.hasHome();
	}
	public void setRevengeTarget(EntityLiving entityLiving) {
		if (master != null) master.setRevengeTarget(entityLiving);
		else super.setRevengeTarget(entityLiving);
	}
		super.setRevengeTarget((EntityLiving) entityLiving);
	}
	public boolean canEntityBeSeen(Entity entity) {
		return master != null ? master.canEntityBeSeen(entity) : super.canEntityBeSeen(entity);
	}
		return super.canEntityBeSeen((Entity) entity);
	}
	public String getTexture() {
		return master != null ? master.getTexture() : super.getTexture();
	}
		return super.getTexture();
	}
	public boolean canBeCollidedWith() {
		return master != null ? master.canBeCollidedWith() : super.canBeCollidedWith();
	}
		return super.canBeCollidedWith();
	}
	public boolean canBePushed() {
		return master != null ? master.canBePushed() : super.canBePushed();
	}
		return super.canBePushed();
	}
	public int getTalkInterval() {
		return master != null ? master.getTalkInterval() : super.getTalkInterval();
	}
		return super.getTalkInterval();
	}
	public void playLivingSound() {
		if (master != null) master.playLivingSound();
		else super.playLivingSound();
	}
		super.playLivingSound();
	}
	public void onEntityUpdate() {
		if (master != null) master.onEntityUpdate();
		else super.onEntityUpdate();
	}
		super.onEntityUpdate();
	}
	protected void onDeathUpdate() {
		if (master != null) master.onDeathUpdate();
		else super.onDeathUpdate();
	}
		super.onDeathUpdate();
	}
	protected int decreaseAirSupply(int par1) {
		return master != null ? master.decreaseAirSupply(par1) : super.decreaseAirSupply(par1);
	}
		return super.decreaseAirSupply(par1);
	}
	public void spawnExplosionParticle() {
		if (master != null) master.spawnExplosionParticle();
		else super.spawnExplosionParticle();
	}
		super.spawnExplosionParticle();
	}
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		if (master != null) master.setPositionAndRotationDirect(par1, par3, par5, par7, par8, par9);
		else super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}
		super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}
	public int getHealth() {
		return (Integer) (master != null ? master.getHealth() : super.getHealth());
	}
		return super.getHealth();
	}
	public void setEntityHealth(int par1) {
		if (master != null) master.setEntityHealth(par1);
		else super.setEntityHealth(par1);
	}
		super.setEntityHealth(par1);
	}
	protected float getSoundPitch() {
		return master != null ? master.getSoundPitch() : super.getSoundPitch();
	}
		return super.getSoundPitch();
	}
	public void performHurtAnimation() {
		if (master != null) master.performHurtAnimation();
		else super.performHurtAnimation();
	}
		super.performHurtAnimation();
	}
	protected int applyArmorCalculations(DamageSource damageSource, int par2) {
		return (Integer) (master != null ? master.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2));
	}
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}
	protected int applyPotionDamageCalculations(DamageSource damageSource, int par2) {
		return (Integer) (master != null ? master.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2));
	}
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}
	protected float getSoundVolume() {
		return master != null ? master.getSoundVolume() : super.getSoundVolume();
	}
		return super.getSoundVolume();
	}
	protected String getLivingSound() {
		return (String) (master != null ? master.getAmbientSound() : super.getLivingSound());
	}
		return super.getLivingSound();
	}
	protected String getDeathSound() {
		return (String) (master != null ? master.getDeathSound() : super.getDeathSound());
	}
		return super.getDeathSound();
	}
	public void knockBack(Entity entity, int par2, double par3, double par5) {
		if (master != null) master.knockBack(entity, par2, par3, par5);
		else super.knockBack(entity, par2, par3, par5);
	}
		super.knockBack((Entity) entity, par2, par3, par5);
	}
	protected void dropRareDrop(int par1) {
		if (master != null) master.dropRareDrop(par1);
		else super.dropRareDrop(par1);
	}
		super.dropRareDrop(par1);
	}
	protected void dropFewItems(boolean par1, int par2) {
		if (master != null) master.dropFewItems(par1, par2);
		else super.dropFewItems(par1, par2);
	}
		super.dropFewItems(par1, par2);
	}
	protected int getDropItemId() {
		return master != null ? master.getDropItemId() : super.getDropItemId();
	}
		return super.getDropItemId();
	}
	public boolean isOnLadder() {
		return master != null ? master.isOnLadder() : super.isOnLadder();
	}
		return super.isOnLadder();
	}
	public boolean isEntityAlive() {
		return master != null ? master.isEntityAlive() : super.isEntityAlive();
	}
		return super.isEntityAlive();
	}
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}
		return super.canBreatheUnderwater();
	}
	public void setMoveForward(float par1) {
		if (master != null) master.setMoveForward(par1);
		else super.setMoveForward(par1);
	}
		super.setMoveForward(par1);
	}
	public void setJumping(boolean par1) {
		if (master != null) master.setJumping(par1);
		else super.setJumping(par1);
	}
		super.setJumping(par1);
	}
	protected void func_85033_bc() {
		if (master != null) master.collideWithNearbyEntities();
		else super.func_85033_bc();
	}
		super.func_85033_bc();
	}
	protected void collideWithEntity(Entity entity) {
		if (master != null) master.collideWithEntity(entity);
		else super.collideWithEntity(entity);
	}
		super.collideWithEntity((Entity) entity);
	}
	protected boolean isAIEnabled() {
		return master != null ? master.isAIEnabled() : super.isAIEnabled();
	}
		return super.isAIEnabled();
	}
	protected boolean canDespawn() {
		return master != null ? master.canDespawn() : super.canDespawn();
	}
		return super.canDespawn();
	}
	protected void despawnEntity() {
		if (master != null) master.despawnEntity();
		else super.despawnEntity();
	}
		super.despawnEntity();
	}
	protected void updateAITasks() {
		if (master != null) master.updateAITasks();
		else super.updateAITasks();
	}
		super.updateAITasks();
	}
	protected void updateAITick() {
		if (master != null) master.handleJumpWater();
		else super.updateAITick();
	}
		super.updateAITick();
	}
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}
		super.updateArmSwingProgress();
	}
	public int getVerticalFaceSpeed() {
		return master != null ? master.getVerticalFaceSpeed() : super.getVerticalFaceSpeed();
	}
		return super.getVerticalFaceSpeed();
	}
	public void faceEntity(Entity entity, float par2, float par3) {
		if (master != null) master.faceEntity(entity, par2, par3);
		else super.faceEntity(entity, par2, par3);
	}
		super.faceEntity((Entity) entity, par2, par3);
	}
	public boolean getCanSpawnHere() {
		return master != null ? master.getCanSpawnHere() : super.getCanSpawnHere();
	}
		return super.getCanSpawnHere();
	}
	protected void kill() {
		if (master != null) master.kill();
		else super.kill();
	}
		super.kill();
	}
	public float getSwingProgress(float par1) {
		return master != null ? master.getSwingProgress(par1) : super.getSwingProgress(par1);
	}
		return super.getSwingProgress(par1);
	}
	public Vec3 getPosition(float par1) {
		return (Vec3) (master != null ? master.getPosition(par1) : super.getPosition(par1));
	}
		return super.getPosition(par1);
	}
	public Vec3 getLookVec() {
		return (Vec3) (master != null ? master.getLookVec() : super.getLookVec());
	}
		return super.getLookVec();
	}
	public Vec3 getLook(float par1) {
		return (Vec3) (master != null ? master.getLook(par1) : super.getLook(par1));
	}
		return super.getLook(par1);
	}
	public float getRenderSizeModifier() {
		return master != null ? master.getRenderSizeModifier() : super.getRenderSizeModifier();
	}
		return super.getRenderSizeModifier();
	}
	public MovingObjectPosition rayTrace(double par1, float par3) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(par1, par3) : super.rayTrace(par1, par3));
	}
		return super.rayTrace(par1, par3);
	}
	public int getMaxSpawnedInChunk() {
		return master != null ? master.getMaxSpawnedInChunk() : super.getMaxSpawnedInChunk();
	}
		return super.getMaxSpawnedInChunk();
	}
	protected void updatePotionEffects() {
		if (master != null) master.updatePotionEffects();
		else super.updatePotionEffects();
	}
		super.updatePotionEffects();
	}
	public void clearActivePotions() {
		if (master != null) master.clearActivePotions();
		else super.clearActivePotions();
	}
		super.clearActivePotions();
	}
	public Collection getActivePotionEffects() {
		return (Collection) (master != null ? master.getActivePotionEffects() : super.getActivePotionEffects());
	}
		return super.getActivePotionEffects();
	}
	public boolean isPotionActive(int par1) {
		return master != null ? master.isPotionActive(par1) : super.isPotionActive(par1);
	}
		return super.isPotionActive(par1);
	}
	public boolean isPotionActive(Potion potion) {
		return master != null ? master.isPotionActive(potion) : super.isPotionActive(potion);
	}
		return super.isPotionActive((Potion) potion);
	}
	public PotionEffect getActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.getActivePotionEffect(potion) : super.getActivePotionEffect(potion));
	}
		return super.getActivePotionEffect((Potion) potion);
	}
	public void addPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.addPotionEffect(potionEffect);
		else super.addPotionEffect(potionEffect);
	}
		super.addPotionEffect((PotionEffect) potionEffect);
	}
	public boolean isPotionApplicable(PotionEffect potionEffect) {
		return master != null ? master.isPotionApplicable(potionEffect) : super.isPotionApplicable(potionEffect);
	}
		return super.isPotionApplicable((PotionEffect) potionEffect);
	}
	public boolean isEntityUndead() {
		return master != null ? master.isEntityUndead() : super.isEntityUndead();
	}
		return super.isEntityUndead();
	}
	public void removePotionEffectClient(int par1) {
		if (master != null) master.removePotionEffectClient(par1);
		else super.removePotionEffectClient(par1);
	}
		super.removePotionEffectClient(par1);
	}
	public void removePotionEffect(int par1) {
		if (master != null) master.removePotionEffect(par1);
		else super.removePotionEffect(par1);
	}
		super.removePotionEffect(par1);
	}
	protected void onNewPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onNewPotionEffect(potionEffect);
		else super.onNewPotionEffect(potionEffect);
	}
		super.onNewPotionEffect((PotionEffect) potionEffect);
	}
	protected void onChangedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onChangedPotionEffect(potionEffect);
		else super.onChangedPotionEffect(potionEffect);
	}
		super.onChangedPotionEffect((PotionEffect) potionEffect);
	}
	protected void onFinishedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onFinishedPotionEffect(potionEffect);
		else super.onFinishedPotionEffect(potionEffect);
	}
		super.onFinishedPotionEffect((PotionEffect) potionEffect);
	}
	public float getSpeedModifier() {
		return master != null ? master.getSpeedModifier() : super.getSpeedModifier();
	}
		return super.getSpeedModifier();
	}
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		if (master != null) master.setPositionAndUpdate(par1, par3, par5);
		else super.setPositionAndUpdate(par1, par3, par5);
	}
		super.setPositionAndUpdate(par1, par3, par5);
	}
	public boolean isChild() {
		return master != null ? master.isChild() : super.isChild();
	}
		return super.isChild();
	}
	public void renderBrokenItemStack(ItemStack itemStack) {
		if (master != null) master.renderBrokenItemStack(itemStack);
		else super.renderBrokenItemStack(itemStack);
	}
		super.renderBrokenItemStack((ItemStack) itemStack);
	}
	public int func_82143_as() {
		return master != null ? master.getMaxFallHeight() : super.func_82143_as();
	}
		return super.func_82143_as();
	}
	protected void dropEquipment(boolean par1, int par2) {
		if (master != null) master.dropEquipment(par1, par2);
		else super.dropEquipment(par1, par2);
	}
		super.dropEquipment(par1, par2);
	}
	public void initCreature() {
		if (master != null) master.initCreature();
		else super.initCreature();
	}
		super.initCreature();
	}
	public boolean canBeSteered() {
		return master != null ? master.canBeSteered() : super.canBeSteered();
	}
		return super.canBeSteered();
	}
	public EntityLiving func_94060_bK() {
		return (EntityLiving) (master != null ? master.getAttackingEntity() : super.func_94060_bK());
	}
		return super.func_94060_bK();
	}
	public void func_94058_c(String par1Str) {
		if (master != null) master.func_94058_c(par1Str);
		else super.func_94058_c(par1Str);
	}
		super.func_94058_c(par1Str);
	}
	public String func_94057_bL() {
		return master != null ? master.func_94057_bL() : super.func_94057_bL();
	}
		return super.func_94057_bL();
	}
	public boolean func_94056_bM() {
		return master != null ? master.func_94056_bM() : super.func_94056_bM();
	}
		return super.func_94056_bM();
	}
	public void func_94061_f(boolean par1) {
		if (master != null) master.setNoAI(par1);
		else super.func_94061_f(par1);
	}
		super.func_94061_f(par1);
	}
	public void func_96120_a(int par1, float par2) {
		if (master != null) master.func_96120_a(par1, par2);
		else super.func_96120_a(par1, par2);
	}
		super.func_96120_a(par1, par2);
	}
	public void setCanPickUpLoot(boolean par1) {
		if (master != null) master.setCanPickUpLoot(par1);
		else super.setCanPickUpLoot(par1);
	}
		super.setCanPickUpLoot(par1);
	}
	public boolean func_104002_bU() {
		return master != null ? master.isNoDespawnRequired() : super.func_104002_bU();
	}
		return super.func_104002_bU();
	}
	public void curePotionEffects(ItemStack itemStack) {
		if (master != null) master.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}
		super.curePotionEffects((ItemStack) itemStack);
	}
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return master != null ? master.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}
		return super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataManager() : super.getDataWatcher());
	}
		return super.getDataWatcher();
	}
	protected void setRotation(float par1, float par2) {
		if (master != null) master.setRotation(par1, par2);
		else super.setRotation(par1, par2);
	}
		super.setRotation(par1, par2);
	}
	public void setPosition(double par1, double par3, double par5) {
		if (master != null) master.setPosition(par1, par3, par5);
		else super.setPosition(par1, par3, par5);
	}
		super.setPosition(par1, par3, par5);
	}
	public void setAngles(float par1, float par2) {
		if (master != null) master.setAngles(par1, par2);
		else super.setAngles(par1, par2);
	}
		super.setAngles(par1, par2);
	}
	protected void setOnFireFromLava() {
		if (master != null) master.setOnFireFromLava();
		else super.setOnFireFromLava();
	}
		super.setOnFireFromLava();
	}
	public void setFire(int par1) {
		if (master != null) master.setFire(par1);
		else super.setFire(par1);
	}
		super.setFire(par1);
	}
	public void extinguish() {
		if (master != null) master.extinguish();
		else super.extinguish();
	}
		super.extinguish();
	}
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return master != null ? master.isOffsetPositionInLiquid(par1, par3, par5) : super.isOffsetPositionInLiquid(par1, par3, par5);
	}
		return super.isOffsetPositionInLiquid(par1, par3, par5);
	}
	protected void doBlockCollisions() {
		if (master != null) master.doBlockCollisions();
		else super.doBlockCollisions();
	}
		super.doBlockCollisions();
	}
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		if (master != null) master.playStepSound(par1, par2, par3, par4);
		else super.playStepSound(par1, par2, par3, par4);
	}
		super.playStepSound(par1, par2, par3, par4);
	}
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getBoundingBox());
	}
		return super.getBoundingBox();
	}
	protected void dealFireDamage(int par1) {
		if (master != null) master.dealFireDamage(par1);
		else super.dealFireDamage(par1);
	}
		super.dealFireDamage(par1);
	}
	public boolean isWet() {
		return master != null ? master.isWet() : super.isWet();
	}
		return super.isWet();
	}
	public boolean isInWater() {
		return master != null ? master.isInWater() : super.isInWater();
	}
		return super.isInWater();
	}
	public boolean handleWaterMovement() {
		return master != null ? master.handleWaterMovement() : super.handleWaterMovement();
	}
		return super.handleWaterMovement();
	}
	public boolean isInsideOfMaterial(Material material) {
		return master != null ? master.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}
		return super.isInsideOfMaterial((Material) material);
	}
	public boolean handleLavaMovement() {
		return master != null ? master.handleLavaMovement() : super.handleLavaMovement();
	}
		return super.handleLavaMovement();
	}
	public void moveFlying(float par1, float par2, float par3) {
		if (master != null) master.moveRelative(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}
		super.moveFlying(par1, par2, par3);
	}
	public int getBrightnessForRender(float par1) {
		return master != null ? master.getBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}
		return super.getBrightnessForRender(par1);
	}
	public float getBrightness(float par1) {
		return master != null ? master.getBrightness(par1) : super.getBrightness(par1);
	}
		return super.getBrightness(par1);
	}
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}
		super.setWorld((World) world);
	}
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setPositionAndRotation(par1, par3, par5, par7, par8);
		else super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}
		super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setLocationAndAngles(par1, par3, par5, par7, par8);
		else super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}
		super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}
	public float getDistanceToEntity(Entity entity) {
		return master != null ? master.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}
		return super.getDistanceToEntity((Entity) entity);
	}
	public double getDistanceSq(double par1, double par3, double par5) {
		return master != null ? master.getDistanceSq(par1, par3, par5) : super.getDistanceSq(par1, par3, par5);
	}
		return super.getDistanceSq(par1, par3, par5);
	}
	public double getDistance(double par1, double par3, double par5) {
		return master != null ? master.getDistance(par1, par3, par5) : super.getDistance(par1, par3, par5);
	}
		return super.getDistance(par1, par3, par5);
	}
	public double getDistanceSqToEntity(Entity entity) {
		return master != null ? master.getDistanceSqToEntity(entity) : super.getDistanceSqToEntity(entity);
	}
		return super.getDistanceSqToEntity((Entity) entity);
	}
	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
		if (master != null) master.onCollideWithPlayer(entityPlayer);
		else super.onCollideWithPlayer(entityPlayer);
	}
		super.onCollideWithPlayer((EntityPlayer) entityPlayer);
	}
	public void applyEntityCollision(Entity entity) {
		if (master != null) master.applyEntityCollision(entity);
		else super.applyEntityCollision(entity);
	}
		super.applyEntityCollision((Entity) entity);
	}
	public void addVelocity(double par1, double par3, double par5) {
		if (master != null) master.addVelocity(par1, par3, par5);
		else super.addVelocity(par1, par3, par5);
	}
		super.addVelocity(par1, par3, par5);
	}
	protected void setBeenAttacked() {
		if (master != null) master.setBeenAttacked();
		else super.setBeenAttacked();
	}
		super.setBeenAttacked();
	}
	public boolean addNotRiddenEntityID(NBTTagCompound nBTTagCompound) {
		return master != null ? master.addNotRiddenEntityID(nBTTagCompound) : super.addNotRiddenEntityID(nBTTagCompound);
	}
		return super.addNotRiddenEntityID((NBTTagCompound) nBTTagCompound);
	}
	public boolean isInRangeToRenderVec3D(Vec3 vec3) {
		return master != null ? master.isInRangeToRenderVec3D(vec3) : super.isInRangeToRenderVec3D(vec3);
	}
		return super.isInRangeToRenderVec3D((Vec3) vec3);
	}
	public boolean isInRangeToRenderDist(double par1) {
		return master != null ? master.isInRangeToRenderDist(par1) : super.isInRangeToRenderDist(par1);
	}
		return super.isInRangeToRenderDist(par1);
	}
	public boolean addEntityID(NBTTagCompound nBTTagCompound) {
		return master != null ? master.addEntityID(nBTTagCompound) : super.addEntityID(nBTTagCompound);
	}
		return super.addEntityID((NBTTagCompound) nBTTagCompound);
	}
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
	}
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}
		super.readFromNBT((NBTTagCompound) nBTTagCompound);
	}
	protected NBTTagList newDoubleNBTList(double... par1ArrayOfDouble) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(par1ArrayOfDouble) : super.newDoubleNBTList(par1ArrayOfDouble));
	}
		return super.newDoubleNBTList(par1ArrayOfDouble);
	}
	protected NBTTagList newFloatNBTList(float... par1ArrayOfFloat) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(par1ArrayOfFloat) : super.newFloatNBTList(par1ArrayOfFloat));
	}
		return super.newFloatNBTList(par1ArrayOfFloat);
	}
	public float getShadowSize() {
		return master != null ? master.getShadowSize() : super.getShadowSize();
	}
		return super.getShadowSize();
	}
	public EntityItem dropItem(int par1, int par2) {
		return (EntityItem) (master != null ? master.dropItem(par1, par2) : super.dropItem(par1, par2));
	}
		return super.dropItem(par1, par2);
	}
	public EntityItem dropItemWithOffset(int par1, int par2, float par3) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(par1, par2, par3) : super.dropItemWithOffset(par1, par2, par3));
	}
		return super.dropItemWithOffset(par1, par2, par3);
	}
	public EntityItem entityDropItem(ItemStack itemStack, float par2) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, par2) : super.entityDropItem(itemStack, par2));
	}
		return super.entityDropItem((ItemStack) itemStack, par2);
	}
	public boolean interact(EntityPlayer entityPlayer) {
		return master != null ? master.interact(entityPlayer) : super.interact(entityPlayer);
	}
		return super.interact((EntityPlayer) entityPlayer);
	}
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBox(entity) : super.getCollisionBox(entity));
	}
		return super.getCollisionBox((Entity) entity);
	}
	public void updateRiderPosition() {
		if (master != null) master.updatePassenger();
		else super.updateRiderPosition();
	}
		super.updateRiderPosition();
	}
	public void unmountEntity(Entity entity) {
		if (master != null) master.unmountEntity(entity);
		else super.unmountEntity(entity);
	}
		super.unmountEntity((Entity) entity);
	}
	public float getCollisionBorderSize() {
		return master != null ? master.getCollisionBorderSize() : super.getCollisionBorderSize();
	}
		return super.getCollisionBorderSize();
	}
	public void setInPortal() {
		if (master != null) master.setPortal(null);
		else super.setInPortal();
	}
		super.setInPortal();
	}
	public void setVelocity(double par1, double par3, double par5) {
		if (master != null) master.setVelocity(par1, par3, par5);
		else super.setVelocity(par1, par3, par5);
	}
		super.setVelocity(par1, par3, par5);
	}
	public boolean isBurning() {
		return master != null ? master.isBurning() : super.isBurning();
	}
		return super.isBurning();
	}
	public boolean isRiding() {
		return master != null ? master.isRiding() : super.isRiding();
	}
		return super.isRiding();
	}
	public void setSneaking(boolean par1) {
		if (master != null) master.setSneaking(par1);
		else super.setSneaking(par1);
	}
		super.setSneaking(par1);
	}
	public boolean isSprinting() {
		return master != null ? master.isSprinting() : super.isSprinting();
	}
		return super.isSprinting();
	}
	public boolean isInvisible() {
		return master != null ? master.isInvisible() : super.isInvisible();
	}
		return super.isInvisible();
	}
	public void setInvisible(boolean par1) {
		if (master != null) master.setInvisible(par1);
		else super.setInvisible(par1);
	}
		super.setInvisible(par1);
	}
	public boolean isEating() {
		return master != null ? master.isEating() : super.isEating();
	}
		return super.isEating();
	}
	public void setEating(boolean par1) {
		if (master != null) master.setEating(par1);
		else super.setEating(par1);
	}
		super.setEating(par1);
	}
	protected boolean getFlag(int par1) {
		return master != null ? master.getFlag(par1) : super.getFlag(par1);
	}
		return super.getFlag(par1);
	}
	protected void setFlag(int par1, boolean par2) {
		if (master != null) master.setFlag(par1, par2);
		else super.setFlag(par1, par2);
	}
		super.setFlag(par1, par2);
	}
	public int getAir() {
		return master != null ? master.getAir() : super.getAir();
	}
		return super.getAir();
	}
	public void setAir(int par1) {
		if (master != null) master.setAir(par1);
		else super.setAir(par1);
	}
		super.setAir(par1);
	}
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		if (master != null) master.onStruckByLightning(entityLightningBolt);
		else super.onStruckByLightning(entityLightningBolt);
	}
		super.onStruckByLightning((EntityLightningBolt) entityLightningBolt);
	}
	public Entity[] getParts() {
		return (Entity[]) (master != null ? master.getParts() : super.getParts());
	}
		return super.getParts();
	}
	public boolean isEntityEqual(Entity entity) {
		return master != null ? master.isEntityEqual(entity) : super.isEntityEqual(entity);
	}
		return super.isEntityEqual((Entity) entity);
	}
	public boolean canAttackWithItem() {
		return master != null ? master.canBeAttackedWithItem() : super.canAttackWithItem();
	}
		return super.canAttackWithItem();
	}
	public boolean func_85031_j(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.func_85031_j(entity);
	}
		return super.func_85031_j((Entity) entity);
	}
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}
		return super.toString();
	}
	public boolean isEntityInvulnerable() {
		return master != null ? master.isEntityInvulnerable() : super.isEntityInvulnerable();
	}
		return super.isEntityInvulnerable();
	}
	public void func_82149_j(Entity entity) {
		if (master != null) master.copyLocationAndAnglesFrom(entity);
		else super.func_82149_j(entity);
	}
		super.func_82149_j((Entity) entity);
	}
	public void copyDataFrom(Entity entity, boolean par2) {
		if (master != null) master.copyDataFrom(entity, par2);
		else super.copyDataFrom(entity, par2);
	}
		super.copyDataFrom((Entity) entity, par2);
	}
	public void travelToDimension(int par1) {
		if (master != null) master.changeDimension(par1);
		else super.travelToDimension(par1);
	}
		super.travelToDimension(par1);
	}
	public float func_82146_a(Explosion explosion, World world, int par3, int par4, int par5, Block block) {
		return master != null ? master.func_82146_a(explosion, world, par3, par4, par5, block) : super.func_82146_a(explosion, world, par3, par4, par5, block);
	}
		return super.func_82146_a((Explosion) explosion, (World) world, par3, par4, par5, (Block) block);
	}
	public boolean func_96091_a(Explosion explosion, World world, int par3, int par4, int par5, int par6, float par7) {
		return master != null ? master.func_96091_a(explosion, world, par3, par4, par5, par6, par7) : super.func_96091_a(explosion, world, par3, par4, par5, par6, par7);
	}
		return super.func_96091_a((Explosion) explosion, (World) world, par3, par4, par5, par6, par7);
	}
	public int getTeleportDirection() {
		return (Integer) (master != null ? master.getLastPortalVec() : super.getTeleportDirection());
	}
		return super.getTeleportDirection();
	}
	public boolean doesEntityNotTriggerPressurePlate() {
		return master != null ? master.doesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}
		return super.doesEntityNotTriggerPressurePlate();
	}
	public void func_85029_a(CrashReportCategory crashReportCategory) {
		if (master != null) master.addEntityCrashInfo(crashReportCategory);
		else super.func_85029_a(crashReportCategory);
	}
		super.func_85029_a((CrashReportCategory) crashReportCategory);
	}
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}
		return super.canRenderOnFire();
	}
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (master != null ? master.getEntityData() : super.getEntityData());
	}
		return super.getEntityData();
	}
	public boolean shouldRiderSit() {
		return master != null ? master.shouldRiderSit() : super.shouldRiderSit();
	}
		return super.shouldRiderSit();
	}
	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return (ItemStack) (master != null ? master.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}
		return super.getPickedResult((MovingObjectPosition) movingObjectPosition);
	}
	public UUID getPersistentID() {
		return master != null ? master.getPersistentID() : super.getPersistentID();
	}
		return super.getPersistentID();
	}
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}
		return super.shouldRenderInPass(pass);
	}
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return master != null ? master.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}
		return super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}
	public String registerExtendedProperties(String identifier, IExtendedEntityProperties iExtendedEntityProperties) {
		return master != null ? master.registerExtendedProperties(identifier, iExtendedEntityProperties) : super.registerExtendedProperties(identifier, iExtendedEntityProperties);
	}
		return super.registerExtendedProperties(identifier, (IExtendedEntityProperties) iExtendedEntityProperties);
	}
	public IExtendedEntityProperties getExtendedProperties(String identifier) {
		return (IExtendedEntityProperties) (master != null ? master.getExtendedProperties(identifier) : super.getExtendedProperties(identifier));
	}
		return super.getExtendedProperties(identifier);
	}
	public boolean superAttackEntityFrom(Object damageSource, float par2) {
		return super.attackEntityFrom((DamageSource) damageSource, (int)par2);
	}
	public void superHeal(float par1) {
		super.heal((int) par1);
	}
	public void superDamageEntity(Object damageSource, float par2) {
		super.damageEntity((DamageSource) damageSource, (int)par2);
	}
	public void superSetPlayerSPHealth(float par1) {
	}
	public void superFunc_110322_i() {
	}
	public void superFunc_142020_c(String par1Str) {
	}
	public void superSendChatToPlayer(Object chatMessageComponent) {
	}
	public boolean superIsRidingHorse() {
		return false;
	}
	public float superGetHorseJumpPower() {
		return 0;
	}
	public void superSetupCustomSkin() {
	}
	public Object superGetTextureSkin() {
		return null;
	}
	public Object superGetTextureCape() {
		return null;
	}
	public Object superGetLocationSkin() {
		return null;
	}
	public Object superGetLocationCape() {
		return null;
	}
	public void superApplyEntityAttributes() {
	}
	public void superDamageArmor(float par1) {
	}
	public Object superGetBedLocation(int dimension) {
		return null;
	}
	public boolean superIsSpawnForced(int dimension) {
		return false;
	}
	public void superSetSpawnChunk(Object chunkCoordinates, boolean forced, int dimension) {
	}
	public boolean superIsCurrentToolAdventureModeExempt(int par1, int par2, int par3) {
		return false;
	}
	public Object superGetEntityWorld() {
		return null;
	}
	public void superSetAbsorptionAmount(float par1) {
	}
	public float superGetAbsorptionAmount() {
		return 0;
	}
	public float superGetDefaultEyeHeight() {
		return 0;
	}
	public Object superGetDisplayName() {
		return null;
	}
	public void superRefreshDisplayName() {
	}
	public int superFunc_142015_aE() {
		return 0;
	}
	public Object superGetLastAttacker() {
		return null;
	}
	public int superGetLastAttackerTime() {
		return 0;
	}
	public void superSetLastAttacker(Object entity) {
	}
	public void superOnChangedPotionEffect(Object potionEffect, boolean par2) {
	}
	public void superKnockBack(Object entity, float par2, double par3, double par5) {
	}
	public Object superApplyArmorCalculations(Object damageSource, float par2) {
		return 0F;
	}
	public Object superApplyPotionDamageCalculations(Object damageSource, float par2) {
		return 0F;
	}
	public Object superFunc_110142_aN() {
		return null;
	}
	public Object superGetEntityAttribute(Object attribute) {
		return null;
	}
	public Object superGetAttributeMap() {
		return null;
	}
	public void superDismountEntity(Object entity) {
	}
	public boolean superIsOnSameTeam(Object entityLivingBase) {
		return false;
	}
	public boolean superIsOnTeam(Object team) {
		return false;
	}
	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return false;
	}
	public boolean superShouldSetPosAfterLoading() {
		return false;
	}
	public void superOnChunkLoad() {
	}
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0;
	}
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}
	public int superGetMaxSafePointTries() {
		return 0;
	}
	public UUID superGetUniqueID() {
		return null;
	}
	public boolean superCanRiderInteract() {
		return false;
	}
	public boolean superShouldDismountInWater(Object entity) {
		return false;
	}
	public void superCloseScreenNoPacket() {
	}
	public Object superGetStatFileWriter() {
		return null;
	}
	public void superFunc_146100_a(Object tileEntity) {
	}
	public void superFunc_146095_a(Object commandBlockLogic) {
	}
	public void superFunc_146093_a(Object tileEntityHopper) {
	}
	public void superFunc_146104_a(Object tileEntityBeacon) {
	}
	public void superFunc_146102_a(Object tileEntityDispenser) {
	}
	public void superFunc_146098_a(Object tileEntityBrewingStand) {
	}
	public void superFunc_146101_a(Object tileEntityFurnace) {
	}
	public void superAddChatMessage(Object iChatComponent) {
	}
	public void superAddChatComponentMessage(Object iChatComponent) {
	}
	public String superGetSplashSound() {
		return null;
	}
	public String superGetSwimSound() {
		return null;
	}
	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta) {
		return 0;
	}
	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return 0;
	}
	public Object superGetGameProfile() {
		return null;
	}
	public String superFunc_146067_o(int p_146067_1_) {
		return null;
	}
	public boolean superCanDropLoot() {
		return false;
	}
	public int superGetEntityId() {
		return entityId;
	}
	public void superSetEntityId(int p_145769_1_) {
		entityId = p_145769_1_;
	}
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}
	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}
	public Object superDropItem(Object item, int p_145779_2_) {
		return null;
	}
	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0;
	}
	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}
	public void superOnDataWatcherUpdate(int p_145781_1_) {
	}
	public void superFunc_152121_a(Object type, Object resourceLocation) {
	}
	public void superSendEnterCombat() {
	}
	public void superSendEndCombat() {
	}
	public void superOnUpdateWalkingPlayer() {
	}
	public void superCloseScreenAndDropStack() {
	}
	public boolean superIsUser() {
		return false;
	}
	public void superSendHorseJump() {
	}
	public void superSendHorseInventory() {
	}
	public void superSetClientBrand(String brand) {
	}
	public String superGetClientBrand() {
		return null;
	}
	public Object superGetPosition() {
		return null;
	}
	public boolean superIsServerWorld() {
		return false;
	}
	public void superOpenEditSign(Object tileEntitySign) {
	}
	public void superDisplayGui(Object iInteractionObject) {
	}
	public void superDisplayVillagerTradeGui(Object iMerchant) {
	}
	public boolean superIsCurrentViewEntity() {
		return false;
	}
	public boolean superIsSpectator() {
		return false;
	}
	public boolean superHasPlayerInfo() {
		return false;
	}
	public Object superGetPlayerInfo() {
		return null;
	}
	public boolean superHasSkin() {
		return false;
	}
	public String superGetSkinType() {
		return null;
	}
	public float superGetFovModifier() {
		return 0;
	}
	public Object superDropItem(Object itemStack, boolean dropAround, boolean traceItem) {
		return null;
	}
	public float superGetToolDigEfficiency(Object block) {
		return 0;
	}
	public float superGetDigSpeed(Object iBlockState, Object blockPos) {
		return 0;
	}
	public Object superTrySleep(Object blockPos) {
		return null;
	}
	public void superSetSpawnPoint(Object blockPos, boolean forced) {
	}
	public void superFall(float distance, float damageMultiplier) {
	}
	public int superGetXPSeed() {
		return 0;
	}
	public void superRemoveExperienceLevel(int levels) {
	}
	public boolean superIsAllowEdit() {
		return false;
	}
	public boolean superCanPlayerEdit(Object blockPos, Object enumFacing, Object itemStack) {
		return false;
	}
	public Object[] superGetInventory() {
		return null;
	}
	public boolean superCanOpen(Object lockCode) {
		return false;
	}
	public boolean superIsWearing(Object enumPlayerModelParts) {
		return false;
	}
	public boolean superSendCommandFeedback() {
		return false;
	}
	public boolean superReplaceItemInInventory(int p_174820_1_, Object itemStack) {
		return false;
	}
	public boolean superHasReducedDebug() {
		return false;
	}
	public void superSetReducedDebug(boolean reducedDebug) {
	}
	public String superGetDisplayNameString() {
		return null;
	}
	public void superOnKillCommand() {
	}
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}
	public int superGetRevengeTimer() {
		return 0;
	}
	public void superUpdatePotionMetadata() {
	}
	public void superResetPotionEffectMetadata() {
	}
	public Object superGetCombatTracker() {
		return null;
	}
	public float superGetJumpUpwardsMotion() {
		return 0;
	}
	public void superHandleJumpLava() {
	}
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
	}
	public void superMarkPotionsDirty() {
	}
	public void superPlayStepSound(Object blockPos, Object block) {
	}
	public boolean superIsSilent() {
		return false;
	}
	public void superSetSilent(boolean isSilent) {
	}
	public void superSpawnRunningParticles() {
	}
	public void superCreateRunningParticles() {
	}
	public boolean superIsInLava() {
		return false;
	}
	public void superMoveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_) {
	}
	public double superGetDistanceSq(Object blockPos) {
		return 0;
	}
	public double superGetDistanceSqToCenter(Object blockPos) {
		return 0;
	}
	public Object superGetPositionEyes(float p_174824_1_) {
		return null;
	}
	public Object superDropItemWithOffset(Object item, int size, float p_145778_3_) {
		return null;
	}
	public boolean superIsEntityInvulnerable(Object damageSource) {
		return false;
	}
	public void superCopyDataFromOld(Object entity) {
	}
	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return 0;
	}
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return false;
	}
	public void superSetCustomNameTag(String p_96094_1_) {
	}
	public String superGetCustomNameTag() {
		return null;
	}
	public boolean superHasCustomName() {
		return false;
	}
	public void superSetAlwaysRenderNameTag(boolean p_174805_1_) {
	}
	public boolean superGetAlwaysRenderNameTag() {
		return false;
	}
	public Object superGetHorizontalFacing() {
		return null;
	}
	public Object superGetHoverEvent() {
		return null;
	}
	public boolean superIsSpectatedByPlayer(Object entityPlayerMP) {
		return false;
	}
	public Object superGetEntityBoundingBox() {
		return null;
	}
	public void superSetEntityBoundingBox(Object axisAlignedBB) {
	}
	public boolean superIsOutsideBorder() {
		return false;
	}
	public void superSetOutsideBorder(boolean p_174821_1_) {
	}
	public Object superGetPositionVector() {
		return null;
	}
	public Object superGetCommandSenderEntity() {
		return null;
	}
	public void superSetCommandStat(Object type, int amount) {
	}
	public Object superGetCommandStats() {
		return null;
	}
	public Object superGetNBTTagCompound() {
		return null;
	}
	public void superClientUpdateEntityNBT(Object nBTTagCompound) {
	}
	public boolean superInteractAt(Object entityPlayer, Object vec3) {
		return false;
	}
	public boolean superIsImmuneToExplosions() {
		return false;
	}
	public void superApplyEnchantments(Object entityLivingBase, Object entity) {
	}