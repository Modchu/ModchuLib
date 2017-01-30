package modchu.lib.forge.mc180;

import java.util.HashMap;

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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Modchu_EntityTameable extends modchu.lib.forge.mc180_189.Modchu_EntityTameable implements Modchu_IEntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void setInPortal() {
		if (master != null) master.setInPortal();
		else super.setInPortal();
	}

	public void setPortal(BlockPos bockPos) {
		if (master != null) master.setPortal(bockPos);
		else super.setInPortal();
	}

	@Override
	public boolean func_142018_a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
		return master != null ? master.shouldAttackEntity(entityLivingBase, entityLivingBase1) : super.func_142018_a(entityLivingBase, entityLivingBase1);
	}

	@Override
	public boolean superShouldAttackEntity(Object entityLivingBase, Object entityLivingBase1) {
		return super.func_142018_a((EntityLivingBase) entityLivingBase, (EntityLivingBase) entityLivingBase1);
	}

	@Override
	public void onUpdate() {
		if (worldObj != null); else return;
		if (!worldObj.isRemote) {
			Object attributeMap = getAttributeMap();
			if (ticksExisted % 20 == 0) {
				CombatTracker combatTracker = getCombatTracker2();
				//Modchu_Debug.lDebug("Modchu_EntityTameable onUpdate combatTracker="+combatTracker);
				combatTracker.func_94549_h();
				ticksExisted++;
			}
		}
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	@Override
	public void superOnDeath(Object damageSource) {
		if (!worldObj.isRemote && worldObj.getGameRules().getGameRuleBooleanValue("showDeathMessages") && hasCustomName() && getOwnerEntity() instanceof EntityPlayerMP) {
			((EntityPlayerMP) getOwnerEntity()).addChatMessage(getCombatTracker2().getDeathMessage());
		}

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
		getCombatTracker2().func_94549_h();

		if (!worldObj.isRemote) {
			int i = 0;

			if (entity instanceof EntityPlayer) {
				i = EnchantmentHelper.getLootingModifier((EntityLivingBase) entity);
			}

			captureDrops = true;
			capturedDrops.clear();

			if (func_146066_aG() && worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
				dropFewItems(recentlyHit > 0, i);
				dropEquipment(recentlyHit > 0, i);

				if (recentlyHit > 0 && rand.nextFloat() < 0.025F + i * 0.01F) {
					addRandomArmor();
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
				getCombatTracker2().func_94547_a((DamageSource) damageSource, f2, (Float) par2);
				setAbsorptionAmount(getAbsorptionAmount() - (Float) par2);
			}
		}
	}

	@Override
	public boolean handleLavaMovement() {
		return master != null ? master.isNotColliding() : super.handleLavaMovement();
	}

	@Override
	public IEntityLivingData func_180482_a(DifficultyInstance difficultyInstance, IEntityLivingData iEntityLivingData) {
		return (IEntityLivingData) (master != null ? master.onInitialSpawn(iEntityLivingData) : super.func_180482_a(difficultyInstance, iEntityLivingData));
	}

	@Override
	public IEntityLivingData superOnInitialSpawn(Object difficultyInstance, Object iEntityLivingData) {
		return super.func_180482_a((DifficultyInstance) difficultyInstance, (IEntityLivingData) iEntityLivingData);
	}
	// 188~
	public BlockPos getHomePosition() {
		return null;
	}
	// ~162
	@Override
	public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
		else super.func_180426_a(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		super.func_180426_a(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
		super.func_180426_a(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_, true);
	}

	@Override
	public float func_180484_a(BlockPos blockPos) {
		return master != null ? master.getBlockPathWeight(blockPos) : super.func_180484_a(blockPos);
	}

	@Override
	public float superGetBlockPathWeight(Object blockPos) {
		return super.func_180484_a((BlockPos) blockPos);
	}

	@Override
	public Object superGetPlayerInLove() {
		return null;
	}

	@Override
	public void superOnGrowingAdult() {
	}

	@Override
	public boolean superIsWithinHomeDistanceFromPosition(Object blockPos) {
		return false;
	}

	@Override
	public void superSetHomePosAndDistance(Object blockPos, int distance) {
	}

	@Override
	public Object superCreateNavigator(Object world) {
		return null;
	}

	@Override
	public void superUpdateEquipmentIfNeeded(Object entityItem) {
	}

	@Override
	public void superSetEquipmentBasedOnDifficulty(Object difficultyInstance) {
	}

	@Override
	public void superSetEnchantmentBasedOnDifficulty(Object difficultyInstance) {
	}

	@Override
	public boolean superIsAIDisabled() {
		return false;
	}

	@Override
	public float superGetBlockPathWeight(int par1, int par2, int par3) {
		return 0.0F;
	}

	@Override
	public Object superGetHomePosition() {
		return null;
	}

	@Override
	public void superSetPortal() {
	}

	@Override
	public void superSetPortal(Object blockPos) {
		super.setInPortal();
	}

	@Override
	public boolean superIsNotColliding() {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	public int getTeleportDirection() {
		return (Integer) (master != null ? master.getLastPortalVec() : super.getTeleportDirection());
	}

	@Override
	protected void func_180433_a(double p_180433_1_, boolean p_180433_3_, Block block, BlockPos blockPos) {
		if (master != null) master.updateFallState(p_180433_1_, p_180433_3_, block, blockPos);
		else super.func_180433_a(p_180433_1_, p_180433_3_, block, blockPos);
	}

	@Override
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
		super.func_180433_a(p_180433_1_, p_180433_3_, (Block) block, (BlockPos) blockPos);
	}

	@Override
	public boolean superInteractAt(Object entityPlayer, Object vec3) {
		return super.func_174825_a((EntityPlayer) entityPlayer, (Vec3) vec3);
	}

	@Override
	public void superSetRenderYawOffset(float offset) {
	}

	@Override
	protected boolean func_146066_aG() {
		return master != null ? master.canDropLoot() : super.func_146066_aG();
	}

	@Override
	public boolean superCanDropLoot() {
		return super.func_146066_aG();
	}

	@Override
	protected void func_175135_B() {
		if (master != null) master.updatePotionMetadata();
		else super.func_175135_B();
	}

	@Override
	public void superUpdatePotionMetadata() {
		super.func_175135_B();
	}

	@Override
	protected void func_175133_bi() {
		if (master != null) master.resetPotionEffectMetadata();
		else super.func_175133_bi();
	}

	@Override
	public void superResetPotionEffectMetadata() {
		super.func_175133_bi();
	}

	@Override
	protected void addRandomArmor() {
		if (master != null) master.addRandomArmor();
		else super.addRandomArmor();
	}

	@Override
	protected float func_175134_bD() {
		return master != null ? master.getJumpUpwardsMotion() : super.func_175134_bD();
	}

	@Override
	public float superGetJumpUpwardsMotion() {
		return super.func_175134_bD();
	}

	@Override
	protected void func_180466_bG() {
		if (master != null) master.handleJumpLava();
		else super.func_180466_bG();
	}

	@Override
	public void superHandleJumpLava() {
		super.func_180466_bG();
	}

	public void func_181013_g(float p_181013_1_) {
		if (master != null) master.setRenderYawOffset(p_181013_1_);
	}

	@Override
	public void func_152111_bt() {
		if (master != null) master.sendEnterCombat();
		else super.func_152111_bt();
	}

	@Override
	public void superSendEnterCombat() {
		super.func_152111_bt();
	}

	@Override
	public void func_152112_bu() {
		if (master != null) master.sendEndCombat();
		else super.func_152112_bu();
	}

	@Override
	public void superSendEndCombat() {
		super.func_152112_bu();
	}

	@Override
	protected void func_175136_bO() {
		if (master != null) master.markPotionsDirty();
		else super.func_175136_bO();
	}

	@Override
	public void superMarkPotionsDirty() {
		super.func_175136_bO();
	}

	@Override
	public boolean func_174816_a(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float p_174816_5_) {
		return master != null ? master.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_) : super.func_174816_a(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return super.func_174816_a((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, p_174816_5_);
	}

	@Override
	public Object superGetLastPortalVec() {
		return super.getTeleportDirection();
	}

	@Override
	public void func_145781_i(int dataID) {
		if (master != null) master.onDataWatcherUpdate(dataID);
		else super.func_145781_i(dataID);
	}

	@Override
	public void superOnDataWatcherUpdate(int dataID) {
		super.func_145781_i(dataID);
	}

	@Override
	protected HoverEvent func_174823_aP() {
		return (HoverEvent) (master != null ? master.getHoverEvent() : super.func_174823_aP());
	}

	@Override
	public HoverEvent superGetHoverEvent() {
		return super.func_174823_aP();
	}

	@Override
	public boolean func_174827_a(EntityPlayerMP entityPlayerMP) {
		return master != null ? master.isSpectatedByPlayer(entityPlayerMP) : super.func_174827_a(entityPlayerMP);
	}

	@Override
	public boolean superIsSpectatedByPlayer(Object entityPlayerMP) {
		return super.func_174827_a((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public boolean canUseCommand(int permLevel, String commandName) {
		return master != null ? master.canUseCommand(permLevel, commandName) : super.canUseCommand(permLevel, commandName);
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return super.canUseCommand(permLevel, commandName);
	}

	@Override
	public CommandResultStats func_174807_aT() {
		return (CommandResultStats) (master != null ? master.getCommandStats() : super.func_174807_aT());
	}

	@Override
	public CommandResultStats superGetCommandStats() {
		return super.func_174807_aT();
	}

	@Override
	public NBTTagCompound func_174819_aU() {
		return (NBTTagCompound) (master != null ? master.getNBTTagCompound() : super.func_174819_aU());
	}

	@Override
	public NBTTagCompound superGetNBTTagCompound() {
		return super.func_174819_aU();
	}

	@Override
	public void func_174834_g(NBTTagCompound nBTTagCompound) {
		if (master != null) master.clientUpdateEntityNBT(nBTTagCompound);
		else super.func_174834_g(nBTTagCompound);
	}

	@Override
	public void superClientUpdateEntityNBT(Object nBTTagCompound) {
		super.func_174834_g((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean func_174825_a(EntityPlayer entityPlayer, Vec3 vec3) {
		return master != null ? master.interactAt(entityPlayer, vec3) : super.func_174825_a(entityPlayer, vec3);
	}

	@Override
	public boolean func_180427_aV() {
		return master != null ? master.isImmuneToExplosions() : super.func_180427_aV();
	}

	@Override
	public boolean superIsImmuneToExplosions() {
		return super.func_180427_aV();
	}

	@Override
	protected void func_174815_a(EntityLivingBase entityLivingBase, Entity entity) {
		if (master != null) master.applyEnchantments(entityLivingBase, entity);
		else super.func_174815_a(entityLivingBase, entity);
	}

	@Override
	public void superApplyEnchantments(Object entityLivingBase, Object entity) {
		super.func_174815_a((EntityLivingBase) entityLivingBase, (Entity) entity);
	}

	@Override
	public void handleHealthUpdate(byte par1) {
		if (master != null) master.handleStatusUpdate(par1);
		else super.handleHealthUpdate(par1);
	}

	@Override
	public void superHandleStatusUpdate(byte par1) {
		super.handleHealthUpdate(par1);
	}

	public EntityItem dropItem(int par1, int par2) {
		return null;
	}

	@Override
	public void superAgeUp(int p_175501_1_, boolean p_175501_2_) {
		super.func_175501_a(p_175501_1_, p_175501_2_);
	}

	@Override
	public boolean superCanEquipItem(Object itemStack) {
		return super.func_175448_a((ItemStack) itemStack);
	}

	@Override
	public void superFunc_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
		super.func_180433_a(p_180433_1_, p_180433_3_, (Block) block, (BlockPos) blockPos);
	}

	@Override
	public void superAddRandomArmor() {
		super.addRandomArmor();
	}

	@Override
	public void superFunc_145781_i(int p_145781_1_) {
		super.func_145781_i(p_145781_1_);
	}

	@Override
	public Object superFunc_174819_aU() {
		return super.func_174819_aU();
	}

	@Override
	public void superFunc_174834_g(Object nBTTagCompound) {
		super.func_174834_g((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean superFunc_174825_a(Object entityPlayer, Object vec3) {
		return super.func_174825_a((EntityPlayer) entityPlayer, (Vec3) vec3);
	}

	@Override
	public void superSetNoAI(boolean par1) {
		super.setNoAI(par1);
	}

	@Override
	public boolean superIsInRangeToRender3d(Object vec3) {
		return true;
	}

	@Override
	public boolean superIsEntityInvulnerable() {
		return superIsEntityInvulnerable(DamageSource.fall);
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, int par2) {
		return superAttackEntityFrom((DamageSource) damageSource, par2);
	}

	@Override
	public void superDropLoot() {
	}

	@Override
	public Object superGetTeleportDirection() {
		return super.getTeleportDirection();
	}

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.func_174825_a((EntityPlayer) entityPlayer, (Vec3) vec3d);
	}

	@Override
	public void superConsumeItemFromStack(Object entityPlayer, Object itemStack) {
	}
	// 188~
	@Override
	public void superAddRandomDrop() {
	}

}
