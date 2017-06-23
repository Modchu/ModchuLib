package modchu.lib.forge.mc189;

import java.util.HashMap;
import java.util.Map;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_IEntityTameable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandResultStats;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.event.HoverEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

public class Modchu_EntityTameable extends modchu.lib.forge.mc180_189.Modchu_EntityTameable implements Modchu_IEntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean shouldAttackEntity(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
		return master != null ? master.shouldAttackEntity(entityLivingBase, entityLivingBase1) : super.shouldAttackEntity(entityLivingBase, entityLivingBase1);
	}

	@Override
	public boolean superShouldAttackEntity(Object entityLivingBase, Object entityLivingBase1) {
		return super.shouldAttackEntity((EntityLivingBase) entityLivingBase, (EntityLivingBase) entityLivingBase1);
	}

	@Override
	public void superOnDeath(Object damageSource) {
		sendDeathMessage(damageSource);

		if (net.minecraftforge.common.ForgeHooks.onLivingDeath(this, (DamageSource) damageSource)) return;
		Entity entity = ((DamageSource) damageSource).getEntity();
		EntityLivingBase entitylivingbase = func_94060_bK();

		if (scoreValue >= 0 && entitylivingbase != null) {
			entitylivingbase.addToPlayerScore(this, scoreValue);
		}

		if (entity != null) {
			entity.onKillEntity(this);
		}

		dead = true;
		getCombatTracker2().reset();

		if (!worldObj.isRemote) {
			int i = 0;

			if (entity instanceof EntityPlayer) {
				i = EnchantmentHelper.getLootingModifier((EntityLivingBase) entity);
			}

			captureDrops = true;
			capturedDrops.clear();

			if (canDropLoot() && worldObj.getGameRules().getBoolean("doMobLoot")) {
				dropFewItems(recentlyHit > 0, i);
				dropEquipment(recentlyHit > 0, i);

				if (recentlyHit > 0 && rand.nextFloat() < 0.025F + i * 0.01F) {
					addRandomDrop();
				}
			}

			captureDrops = false;

			if (!net.minecraftforge.common.ForgeHooks.onLivingDrops(this, (DamageSource) damageSource, capturedDrops, i, recentlyHit > 0)) {
				for (EntityItem item : capturedDrops) {
					worldObj.spawnEntityInWorld(item);
				}
			}
		}

		worldObj.setEntityState(this, (byte) 3);
	}

	@Override
	public void superDamageEntity(Object damageSource, Object par2) {
		if (!isEntityInvulnerable((DamageSource) damageSource)) {
			par2 = net.minecraftforge.common.ForgeHooks.onLivingHurt(this, (DamageSource) damageSource, (Float) par2);
			if ((Float) par2 <= 0) return;
			par2 = applyArmorCalculations((DamageSource) damageSource, (Float) par2);
			par2 = applyPotionDamageCalculations((DamageSource) damageSource, (Float) par2);
			float f1 = (Float) par2;
			par2 = Math.max((Float) par2 - getAbsorptionAmount(), 0.0F);
			setAbsorptionAmount(getAbsorptionAmount() - (f1 - (Float) par2));

			if ((Float) par2 != 0.0F) {
				float f2 = getHealth();
				setHealth(f2 - (Float) par2);
				getCombatTracker2().trackDamage((DamageSource) damageSource, f2, (Float) par2);
				setAbsorptionAmount(getAbsorptionAmount() - (Float) par2);
			}
		}
	}

	@Override
	public boolean isNotColliding() {
		return master != null ? master.isNotColliding() : super.isNotColliding();
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficultyInstance, IEntityLivingData iEntityLivingData) {
		return (IEntityLivingData) (master != null ? master.onInitialSpawn(null, iEntityLivingData) : super.onInitialSpawn(difficultyInstance, iEntityLivingData));
	}

	@Override
	public IEntityLivingData superOnInitialSpawn(Object difficultyInstance, Object iEntityLivingData) {
		return super.onInitialSpawn((DifficultyInstance) difficultyInstance, (IEntityLivingData) iEntityLivingData);
	}
	// 188~
	@Override
	public BlockPos getHomePosition() {
		return (BlockPos) (master != null ? master.getHomePosition() : super.getHomePosition());
	}
	// ~162
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		if (master != null) master.setPositionAndRotationDirect(par1, par3, par5, par7, par8, par9);
		else super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9, true);
	}

	@Override
	public void superSetPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9) {
		super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9, true);
	}

	@Override
	public Object superCreateNavigator(Object world) {
		return super.getNewNavigator((World) world);
	}

	@Override
	public float superGetBlockPathWeight(int par1, int par2, int par3) {
		return super.getBlockPathWeight((BlockPos) Modchu_AS.get(Modchu_AS.newBlockPos, par1, par2, par3));
	}

	@Override
	public Object superGetHomePosition() {
		return super.getHomePosition();
	}

	@Override
	public void superSetPortal() {
		super.setPortal((BlockPos) Modchu_AS.get(Modchu_AS.newBlockPos, posX, posY, posZ));
	}

	@Override
	public void superSetPortal(Object blockPos) {
		super.setPortal((BlockPos) blockPos);
	}

	@Override
	public boolean superIsNotColliding() {
		return super.isNotColliding();
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getCollisionBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBox() {
		return super.getCollisionBoundingBox();
	}

	@Override
	protected void updateFallState(double p_180433_1_, boolean p_180433_3_, Block block, BlockPos blockPos) {
		if (master != null) master.updateFallState(p_180433_1_, p_180433_3_, block, blockPos);
		else super.updateFallState(p_180433_1_, p_180433_3_, block, blockPos);
	}

	@Override
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
		super.updateFallState(p_180433_1_, p_180433_3_, (Block) block, (BlockPos) blockPos);
	}

	@Override
	public void setPositionAndRotation2(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
		else super.setPositionAndRotation2(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		super.setPositionAndRotation2(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.interactAt((EntityPlayer) entityPlayer, (Vec3) vec3d);
	}

	@Override
	public void superSetRenderYawOffset(float offset) {
		super.func_181013_g(offset);
	}
	@Override
	protected boolean canDropLoot() {
		return master != null ? master.canDropLoot() : super.canDropLoot();
	}

	@Override
	public boolean superCanDropLoot() {
		return super.canDropLoot();
	}

	@Override
	protected void updatePotionMetadata() {
		if (master != null) master.updatePotionMetadata();
		else super.updatePotionMetadata();
	}

	@Override
	public void superUpdatePotionMetadata() {
		super.updatePotionMetadata();
	}

	@Override
	protected void resetPotionEffectMetadata() {
		if (master != null) master.resetPotionEffectMetadata();
		else super.resetPotionEffectMetadata();
	}

	@Override
	public void superResetPotionEffectMetadata() {
		super.resetPotionEffectMetadata();
	}

	@Override
	protected void addRandomDrop() {
		if (master != null) master.dropLoot();
		else super.addRandomDrop();
	}

	@Override
	public void superDropLoot() {
		super.addRandomDrop();
	}

	@Override
	protected float getJumpUpwardsMotion() {
		return master != null ? master.getJumpUpwardsMotion() : super.getJumpUpwardsMotion();
	}

	@Override
	public float superGetJumpUpwardsMotion() {
		return super.getJumpUpwardsMotion();
	}

	@Override
	protected void handleJumpLava() {
		if (master != null) master.handleJumpLava();
		else super.handleJumpLava();
	}

	@Override
	public void superHandleJumpLava() {
		super.handleJumpLava();
	}

	@Override
	public void func_181013_g(float p_181013_1_) {
		if (master != null) master.setRenderYawOffset(p_181013_1_);
		else super.func_181013_g(p_181013_1_);
	}

	@Override
	public void sendEnterCombat() {
		if (master != null) master.sendEnterCombat();
		else super.sendEnterCombat();
	}

	@Override
	public void superSendEnterCombat() {
		super.sendEnterCombat();
	}

	@Override
	public void sendEndCombat() {
		if (master != null) master.sendEndCombat();
		else super.sendEndCombat();
	}

	@Override
	public void superSendEndCombat() {
		super.sendEndCombat();
	}

	@Override
	protected void markPotionsDirty() {
		if (master != null) master.markPotionsDirty();
		else super.markPotionsDirty();
	}

	@Override
	public void superMarkPotionsDirty() {
		super.markPotionsDirty();
	}

	@Override
	public boolean verifyExplosion(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float p_174816_5_) {
		return master != null ? master.canExplosionDestroyBlock(explosion, world, blockPos, iBlockState, p_174816_5_) : super.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return super.verifyExplosion((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, p_174816_5_);
	}

	@Override
	public EnumFacing func_181012_aH() {
		return (EnumFacing) (master != null ? master.getLastPortalVec() : super.func_181012_aH());
	}

	@Override
	public EnumFacing superGetLastPortalVec() {
		return super.func_181012_aH();
	}

	@Override
	public void onDataWatcherUpdate(int dataID) {
		if (master != null) master.onDataWatcherUpdate(dataID);
		else super.onDataWatcherUpdate(dataID);
	}

	@Override
	public void superOnDataWatcherUpdate(int dataID) {
		super.onDataWatcherUpdate(dataID);
	}

	@Override
	protected HoverEvent getHoverEvent() {
		return (HoverEvent) (master != null ? master.getHoverEvent() : super.getHoverEvent());
	}

	@Override
	public HoverEvent superGetHoverEvent() {
		return super.getHoverEvent();
	}

	@Override
	public boolean isSpectatedByPlayer(EntityPlayerMP entityPlayerMP) {
		return master != null ? master.isSpectatedByPlayer(entityPlayerMP) : super.isSpectatedByPlayer(entityPlayerMP);
	}

	@Override
	public boolean superIsSpectatedByPlayer(Object entityPlayerMP) {
		return super.isSpectatedByPlayer((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return master != null ? master.canUseCommand(permLevel, commandName) : super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public CommandResultStats getCommandStats() {
		return (CommandResultStats) (master != null ? master.getCommandStats() : super.getCommandStats());
	}

	@Override
	public CommandResultStats superGetCommandStats() {
		return super.getCommandStats();
	}

	@Override
	public NBTTagCompound getNBTTagCompound() {
		return (NBTTagCompound) (master != null ? master.getNBTTagCompound() : super.getNBTTagCompound());
	}

	@Override
	public NBTTagCompound superGetNBTTagCompound() {
		return super.getNBTTagCompound();
	}

	@Override
	public void clientUpdateEntityNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.clientUpdateEntityNBT(nBTTagCompound);
		else super.clientUpdateEntityNBT(nBTTagCompound);
	}

	@Override
	public void superClientUpdateEntityNBT(Object nBTTagCompound) {
		super.clientUpdateEntityNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean interactAt(EntityPlayer entityPlayer, Vec3 vec3) {
		return master != null ? master.interactAt(entityPlayer, vec3) : super.interactAt(entityPlayer, vec3);
	}

	@Override
	public boolean superInteractAt(Object entityPlayer, Object vec3) {
		return super.interactAt((EntityPlayer) entityPlayer, (Vec3) vec3);
	}

	@Override
	public boolean isImmuneToExplosions() {
		return master != null ? master.isImmuneToExplosions() : super.isImmuneToExplosions();
	}

	@Override
	public boolean superIsImmuneToExplosions() {
		return super.isImmuneToExplosions();
	}

	@Override
	protected void applyEnchantments(EntityLivingBase entityLivingBase, Entity entity) {
		if (master != null) master.applyEnchantments(entityLivingBase, entity);
		else super.applyEnchantments(entityLivingBase, entity);
	}

	@Override
	public void superApplyEnchantments(Object entityLivingBase, Object entity) {
		super.applyEnchantments((EntityLivingBase) entityLivingBase, (Entity) entity);
	}

	@Override
	public void setPortal(BlockPos bockPos) {
		if (master != null) master.setPortal(bockPos);
		else super.setPortal(bockPos);
	}

	public void superSetInPortal(Object bockPos) {
		super.setPortal((BlockPos) bockPos);
	}

	@Override
	public void handleStatusUpdate(byte par1) {
		if (master != null) master.handleStatusUpdate(par1);
		else super.handleStatusUpdate(par1);
	}

	@Override
	public void superHandleStatusUpdate(byte par1) {
		super.handleStatusUpdate(par1);
	}

	// 188~
	@Override
	public void superAddRandomDrop() {
		super.addRandomDrop();
	}

	@Override
	public int superGetBrightnessForRender() {
		return -1;
	}

	@Override
	public float superGetBrightness() {
		return 0.0F;
	}

	@Override
	public void superAddToPlayerScore(Object entity, int p_70084_2_, Object damageSource) {
		superAddToPlayerScore(entity, p_70084_2_);
	}

	@Override
	public Object superFunc_110172_bL() {
		return superGetHomePosition();
	}

	@Override
	public boolean superFunc_152114_e(Object entityLivingBase) {
		return superIsOwner(entityLivingBase);
	}

	@Override
	public Object superFunc_146083_cb() {
		return superGetPlayerInLove();
	}

	@Override
	public Object superFunc_110142_aN() {
		return superGetCombatTracker();
	}

	@Override
	public void superFunc_181013_g(float p_181013_1_) {
		superSetRenderYawOffset(p_181013_1_);
	}

	@Override
	public Object superFunc_181012_aH() {
		return null;
	}

	@Override
	public Vec3 func_181014_aG() {
		return (Vec3) (master != null ? master.getLastPortalVec() : super.func_181014_aG());
	}

	@Override
	public Vec3 superFunc_181014_aG() {
		return super.func_181014_aG();
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing enumFacing) {
		return master != null ? master.hasCapability(capability, enumFacing) : super.hasCapability(capability, enumFacing);
	}

	@Override
	public boolean superHasCapability(Object capability, Object enumFacing) {
		return super.hasCapability((Capability) capability, (EnumFacing) enumFacing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing enumFacing) {
		return (T) (master != null ? master.getCapability(capability, enumFacing) : super.getCapability(capability, enumFacing));
	}

	@Override
	public Object superGetCapability(Object capability, Object enumFacing) {
		return super.getCapability((Capability) capability, (EnumFacing) enumFacing);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.deserializeNBT(nBTTagCompound);
		else super.deserializeNBT(nBTTagCompound);
	}

	@Override
	public void superDeserializeNBT(Object nBTTagCompound) {
		super.deserializeNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public NBTTagCompound serializeNBT() {
		return (NBTTagCompound) (master != null ? master.serializeNBT() : super.serializeNBT());
	}

	@Override
	public NBTTagCompound superSerializeNBT() {
		return super.serializeNBT();
	}

	@Override
	public void setupTamedAI() {
		if (master != null) master.setupTamedAI();
		else super.setupTamedAI();
	}

	@Override
	public void superSetupTamedAI() {
		super.setupTamedAI();
	}

	@Override
	public EntityLivingBase getOwner() {
		return (EntityLivingBase) (master != null ? master.getOwner() : super.getOwner());
	}

	@Override
	public EntityLivingBase superGetOwner() {
		return super.getOwner();
	}

	@Override
	public boolean isOwner(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOwner(entityLivingBase) : super.isOwner(entityLivingBase);
	}

	@Override
	public boolean superIsOwner(Object entityLivingBase) {
		return super.isOwner((EntityLivingBase) entityLivingBase);
	}

	@Override
	public float getBlockPathWeight(BlockPos blockPos) {
		return master != null ? master.getBlockPathWeight(blockPos) : super.getBlockPathWeight(blockPos);
	}

	@Override
	public float superGetBlockPathWeight(Object blockPos) {
		return super.getBlockPathWeight((BlockPos) blockPos);
	}

	@Override
	public void consumeItemFromStack(EntityPlayer entityPlayer, ItemStack itemStack) {
		if (master != null) master.consumeItemFromStack(entityPlayer, itemStack);
		else super.consumeItemFromStack(entityPlayer, itemStack);
	}

	@Override
	public void superConsumeItemFromStack(Object entityPlayer, Object itemStack) {
		super.consumeItemFromStack((EntityPlayer) entityPlayer, (ItemStack) itemStack);
	}

	@Override
	public void setInLove(EntityPlayer entityPlayer) {
		if (master != null) master.setInLove(entityPlayer);
		else super.setInLove(entityPlayer);
	}

	@Override
	public void superSetInLove(Object entityPlayer) {
		super.setInLove((EntityPlayer) entityPlayer);
	}

	@Override
	public EntityPlayer getPlayerInLove() {
		return (EntityPlayer) (master != null ? master.getPlayerInLove() : super.getPlayerInLove());
	}

	@Override
	public EntityPlayer superGetPlayerInLove() {
		return super.getPlayerInLove();
	}

	@Override
	public void func_175501_a(int p_175501_1_, boolean p_175501_2_) {
		if (master != null) master.ageUp(p_175501_1_, p_175501_2_);
		else super.func_175501_a(p_175501_1_, p_175501_2_);
	}

	@Override
	public void superFunc_175501_a(int p_175501_1_, boolean p_175501_2_) {
		super.func_175501_a(p_175501_1_, p_175501_2_);
	}

	@Override
	public void onGrowingAdult() {
		if (master != null) master.onGrowingAdult();
		else super.onGrowingAdult();
	}

	@Override
	public void superOnGrowingAdult() {
		super.onGrowingAdult();
	}

	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return master != null ? master.isWithinHomeDistanceCurrentPosition() : super.isWithinHomeDistanceCurrentPosition();
	}

	@Override
	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return super.isWithinHomeDistanceCurrentPosition();
	}

	@Override
	public boolean isWithinHomeDistanceFromPosition(BlockPos blockPos) {
		return master != null ? master.isWithinHomeDistanceFromPosition(blockPos) : super.isWithinHomeDistanceFromPosition(blockPos);
	}

	@Override
	public boolean superIsWithinHomeDistanceFromPosition(Object blockPos) {
		return super.isWithinHomeDistanceFromPosition((BlockPos) blockPos);
	}

	@Override
	public void setHomePosAndDistance(BlockPos blockPos, int distance) {
		if (master != null) master.setHomePosAndDistance(blockPos, distance);
		else super.setHomePosAndDistance(blockPos, distance);
	}

	@Override
	public void superSetHomePosAndDistance(Object blockPos, int distance) {
		super.setHomePosAndDistance((BlockPos) blockPos, distance);
	}

	@Override
	public float getMaximumHomeDistance() {
		return master != null ? master.getMaximumHomeDistance() : super.getMaximumHomeDistance();
	}

	@Override
	public float superGetMaximumHomeDistance() {
		return super.getMaximumHomeDistance();
	}

	@Override
	public void updateLeashedState() {
		if (master != null) master.updateLeashedState();
		else super.updateLeashedState();
	}

	@Override
	public void superUpdateLeashedState() {
		super.updateLeashedState();
	}

	@Override
	public PathNavigate getNewNavigator(World world) {
		return (PathNavigate) (master != null ? master.getNewNavigator(world) : super.getNewNavigator(world));
	}

	@Override
	public PathNavigate superGetNewNavigator(Object world) {
		return super.getNewNavigator((World) world);
	}

	@Override
	public Item getDropItem() {
		return (Item) (master != null ? master.getDropItem() : super.getDropItem());
	}

	@Override
	public Item superGetDropItem() {
		return super.getDropItem();
	}

	@Override
	public void updateEquipmentIfNeeded(EntityItem entityItem) {
		if (master != null) master.updateEquipmentIfNeeded(entityItem);
		else super.updateEquipmentIfNeeded(entityItem);
	}

	@Override
	public void superUpdateEquipmentIfNeeded(Object entityItem) {
		super.updateEquipmentIfNeeded((EntityItem) entityItem);
	}

	@Override
	public boolean func_175448_a(ItemStack itemStack) {
		return master != null ? master.canEquipItem(itemStack) : super.func_175448_a(itemStack);
	}

	@Override
	public boolean superFunc_175448_a(Object itemStack) {
		return super.func_175448_a((ItemStack) itemStack);
	}

	@Override
	public void setEquipmentBasedOnDifficulty(DifficultyInstance difficultyInstance) {
		if (master != null) master.setEquipmentBasedOnDifficulty(difficultyInstance);
		else super.setEquipmentBasedOnDifficulty(difficultyInstance);
	}

	@Override
	public void superSetEquipmentBasedOnDifficulty(Object difficultyInstance) {
		super.setEquipmentBasedOnDifficulty((DifficultyInstance) difficultyInstance);
	}

	@Override
	public void setEnchantmentBasedOnDifficulty(DifficultyInstance difficultyInstance) {
		if (master != null) master.setEnchantmentBasedOnDifficulty(difficultyInstance);
		else super.setEnchantmentBasedOnDifficulty(difficultyInstance);
	}

	@Override
	public void superSetEnchantmentBasedOnDifficulty(Object difficultyInstance) {
		super.setEnchantmentBasedOnDifficulty((DifficultyInstance) difficultyInstance);
	}

	@Override
	public void enablePersistence() {
		if (master != null) master.enablePersistence();
		else super.enablePersistence();
	}

	@Override
	public void superEnablePersistence() {
		super.enablePersistence();
	}

	@Override
	public void setNoAI(boolean disable) {
		if (master != null) master.setNoAI(disable);
		else super.setNoAI(disable);
	}

	@Override
	public void superSetNoAI(boolean disable) {
		super.setNoAI(disable);
	}

	@Override
	public boolean isAIDisabled() {
		return master != null ? master.isAIDisabled() : super.isAIDisabled();
	}

	@Override
	public boolean superIsAIDisabled() {
		return super.isAIDisabled();
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
	public void superSetTamedBy(Object entityPlayer) {
	}

	@Override
	public boolean superHoldingSpawnEggOfClass(Object itemStack, Class p_190669_2_) {
		return false;
	}

	@Override
	public double superFollowLeashSpeed() {
		return 0.0D;
	}

	@Override
	public void superFunc_191989_p(float p_191989_1_) {
	}

	@Override
	public void superFunc_191986_a(float p_191986_1_, float p_191986_2_, float p_191986_3_) {
	}

}
