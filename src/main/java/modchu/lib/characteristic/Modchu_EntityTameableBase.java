package modchu.lib.characteristic;

import java.util.Collection;
import java.util.Random;
import java.util.UUID;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameable;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Modchu_EntityTameableBase extends EntityTameable {

	public Modchu_EntityTameable base;
	public Modchu_IEntityTameable master;
	public String entityName;

	public Modchu_EntityTameableBase(Modchu_EntityTameable modchu_EntityTameable, Class masterClass, Object world) {
		super((World) world);
		if (masterClass != null) ;else {
			Modchu_Debug.Debug("Modchu_EntityTameableBase init error masterClass == null !!");
			return;
		}
		if (modchu_EntityTameable != null) ;else {
			Modchu_Debug.Debug("Modchu_EntityTameableBase init error modchu_EntityTameable == null !!");
			return;
		}
		base = modchu_EntityTameable;
		Object instance = (Modchu_IEntityTameable) Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_EntityTameable.class, Object[].class }, new Object[]{ base, new Object[]{ worldObj } });
		//Modchu_Debug.mDebug("Modchu_EntityTameable instance="+instance);
		master = instance instanceof Modchu_IEntityTameable ? (Modchu_IEntityTameable) instance : null;
	}

	public Object getFreeVariable(String s) {
		return master != null ? master.getFreeVariable(s) : null;
	}

	public void setFreeVariable(String s, Object o) {
		if (master != null) master.setFreeVariable(s, o);
	}

	public boolean isAngry() {
		return master != null ? master.isAngry() : false;
	}

	public void setAngry(boolean flag) {
		if (master != null) master.setAngry(flag);
	}

	public int getTextureColor() {
		return master != null ? master.getTextureColor() : 0;
	}

	public void setTextureColor(int i) {
		if (master != null) master.setTextureColor(i);
	}

	public ResourceLocation getResourceLocation() {
		return master != null ? (ResourceLocation) master.getResourceLocation() : null;
	}

	public void setResourceLocation(ResourceLocation resourceLocation) {
		if (master != null) master.setResourceLocation(resourceLocation);
	}

	@Override
	protected void entityInit() {
		if (master != null) master.entityInit();
		else super.entityInit();
	}

	public void superEntityInit() {
		if (base != null) base.superEntityInit();
		else super.entityInit();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeEntityToNBT(nBTTagCompound);
		else super.writeEntityToNBT(nBTTagCompound);
	}

	public void superWriteEntityToNBT(Object nBTTagCompound) {
		if (base != null) base.superWriteEntityToNBT((NBTTagCompound) nBTTagCompound);
		else super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}

	public void superReadEntityFromNBT(Object nBTTagCompound) {
		if (base != null) base.superReadEntityFromNBT((NBTTagCompound) nBTTagCompound);
		else super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected void playTameEffect(boolean par1) {
		if (master != null) master.playTameEffect(par1);
		else super.playTameEffect(par1);
	}

	public void superPlayTameEffect(boolean par1) {
		if (base != null) base.superPlayTameEffect(par1);
		else super.playTameEffect(par1);
	}

	@Override
	public void handleHealthUpdate(byte par1) {
		if (master != null) master.handleHealthUpdate(par1);
		else super.handleHealthUpdate(par1);
	}

	public void superHandleHealthUpdate(byte par1) {
		if (base != null) base.superHandleHealthUpdate(par1);
		else super.handleHealthUpdate(par1);
	}

	@Override
	public boolean isTamed() {
		return master != null ? master.isTamed() : super.isTamed();
	}

	public boolean superIsTamed() {
		return base != null ? base.superIsTamed() : super.isTamed();
	}

	@Override
	public void setTamed(boolean par1) {
		if (master != null) master.setTamed(par1);
		else super.setTamed(par1);
	}

	public void superSetTamed(boolean par1) {
		if (base != null) base.superSetTamed(par1);
		else super.setTamed(par1);
	}

	@Override
	public boolean isSitting() {
		return master != null ? master.isSitting() : super.isSitting();
	}

	public boolean superIsSitting() {
		return base != null ? base.superIsSitting() : super.isSitting();
	}

	@Override
	public void setSitting(boolean par1) {
		if (master != null) master.setSitting(par1);
		else super.setSitting(par1);
	}

	public void superSetSitting(boolean par1) {
		if (base != null) base.superSetSitting(par1);
		else super.setSitting(par1);
	}

	@Override
	public String getOwnerName() {
		return master != null ? master.getOwnerName() : super.getOwnerName();
	}

	public String superGetOwnerName() {
		return base != null ? base.superGetOwnerName() : super.getOwnerName();
	}

	@Override
	public void setOwner(String par1Str) {
		if (master != null) master.setOwner(par1Str);
		else super.setOwner(par1Str);
	}

	public void superSetOwner(String par1Str) {
		if (base != null) base.superSetOwner(par1Str);
		else super.setOwner(par1Str);
	}

	@Override
	public EntityAISit func_70907_r() {
		return (EntityAISit) (master != null ? master.func_70907_r() : super.func_70907_r());
	}

	public EntityAISit superFunc_70907_r() {
		return base != null ? base.superFunc_70907_r() : super.func_70907_r();
	}

	@Override
	public boolean func_142018_a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
		return master != null ? master.func_142018_a(entityLivingBase, entityLivingBase1) : super.func_142018_a(entityLivingBase, entityLivingBase1);
	}

	public boolean superFunc_142018_a(Object entityLivingBase, Object entityLivingBase1) {
		return base != null ? base.superFunc_142018_a((EntityLivingBase) entityLivingBase, (EntityLivingBase) entityLivingBase1) : super.func_142018_a((EntityLivingBase) entityLivingBase, (EntityLivingBase) entityLivingBase1);
	}

	@Override
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}

	public Team superGetTeam() {
		return base != null ? base.superGetTeam() : super.getTeam();
	}

	@Override
	public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOnSameTeam(entityLivingBase) : super.isOnSameTeam(entityLivingBase);
	}

	public boolean superIsOnSameTeam(Object entityLivingBase) {
		return base != null ? base.superIsOnSameTeam((EntityLivingBase) entityLivingBase) : super.isOnSameTeam((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected void updateAITick() {
		if (master != null) master.updateAITick();
		else super.updateAITick();
	}

	public void superUpdateAITick() {
		if (base != null) base.superUpdateAITick();
		else super.updateAITick();
	}

	@Override
	public void onLivingUpdate() {
		if (master != null) master.onLivingUpdate();
		else super.onLivingUpdate();
	}

	public void superOnLivingUpdate() {
		if (base != null) base.superOnLivingUpdate();
		else super.onLivingUpdate();
	}

	@Override
	protected void attackEntity(Entity entity, float par2) {
		if (master != null) master.attackEntity(entity, par2);
		else super.attackEntity(entity, par2);
	}

	public void superAttackEntity(Object entity, float par2) {
		if (base != null) base.superAttackEntity((Entity) entity, par2);
		else super.attackEntity((Entity) entity, par2);
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float par2) {
		return master != null ? master.attackEntityFrom(damageSource, par2) : super.attackEntityFrom(damageSource, par2);
	}

	public boolean superAttackEntityFrom(Object damageSource, float par2) {
		return base != null ? base.superAttackEntityFrom((DamageSource) damageSource, par2) : super.attackEntityFrom((DamageSource) damageSource, par2);
	}

	@Override
	public float getBlockPathWeight(int par1, int par2, int par3) {
		return master != null ? master.getBlockPathWeight(par1, par2, par3) : super.getBlockPathWeight(par1, par2, par3);
	}

	public float superGetBlockPathWeight(int par1, int par2, int par3) {
		return base != null ? base.superGetBlockPathWeight(par1, par2, par3) : super.getBlockPathWeight(par1, par2, par3);
	}

	@Override
	protected Entity findPlayerToAttack() {
		return (Entity) (master != null ? master.findPlayerToAttack() : super.findPlayerToAttack());
	}

	public Entity superFindPlayerToAttack() {
		return base != null ? base.superFindPlayerToAttack() : super.findPlayerToAttack();
	}

	@Override
	public boolean getCanSpawnHere() {
		return master != null ? master.getCanSpawnHere() : super.getCanSpawnHere();
	}

	public boolean superGetCanSpawnHere() {
		return base != null ? base.superGetCanSpawnHere() : super.getCanSpawnHere();
	}

	@Override
	public int getTalkInterval() {
		return master != null ? master.getTalkInterval() : super.getTalkInterval();
	}

	public int superGetTalkInterval() {
		return base != null ? base.superGetTalkInterval() : super.getTalkInterval();
	}

	@Override
	protected boolean canDespawn() {
		return master != null ? master.canDespawn() : super.canDespawn();
	}

	public boolean superCanDespawn() {
		return base != null ? base.superCanDespawn() : super.canDespawn();
	}

	@Override
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return master != null ? master.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}

	public int superGetExperiencePoints(Object entityPlayer) {
		return base != null ? base.superGetExperiencePoints((EntityPlayer) entityPlayer) : super.getExperiencePoints((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isBreedingItem(ItemStack itemStack) {
		return master != null ? master.isBreedingItem(itemStack) : super.isBreedingItem(itemStack);
	}

	public boolean superIsBreedingItem(Object itemStack) {
		return base != null ? base.superIsBreedingItem((ItemStack) itemStack) : super.isBreedingItem((ItemStack) itemStack);
	}

	@Override
	public boolean interact(EntityPlayer entityPlayer) {
		return master != null ? master.interact(entityPlayer) : super.interact(entityPlayer);
	}

	public boolean superInteract(Object entityPlayer) {
		return base != null ? base.superInteract((EntityPlayer) entityPlayer) : super.interact((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isInLove() {
		return master != null ? master.isInLove() : super.isInLove();
	}

	public boolean superIsInLove() {
		return base != null ? base.superIsInLove() : super.isInLove();
	}

	@Override
	public void resetInLove() {
		if (master != null) master.resetInLove();
		else super.resetInLove();
	}

	public void superResetInLove() {
		if (base != null) base.superResetInLove();
		else super.resetInLove();
	}

	@Override
	public boolean canMateWith(EntityAnimal entityAnimal) {
		return master != null ? master.canMateWith(entityAnimal) : super.canMateWith(entityAnimal);
	}

	public boolean superCanMateWith(Object entityAnimal) {
		return base != null ? base.superCanMateWith((EntityAnimal) entityAnimal) : super.canMateWith((EntityAnimal) entityAnimal);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityAgeable) {
		return (EntityAgeable) (master != null ? master.createChild(entityAgeable) : null);
	}

	public EntityAgeable superCreateChild(Object entityAgeable) {
		return null;
	}

	@Override
	public int getGrowingAge() {
		return master != null ? master.getGrowingAge() : super.getGrowingAge();
	}

	public int superGetGrowingAge() {
		return base != null ? base.superGetGrowingAge() : super.getGrowingAge();
	}

	@Override
	public void addGrowth(int par1) {
		if (master != null) master.addGrowth(par1);
		else super.addGrowth(par1);
	}

	public void superAddGrowth(int par1) {
		if (base != null) base.superAddGrowth(par1);
		else super.addGrowth(par1);
	}

	@Override
	public void setGrowingAge(int par1) {
		if (master != null) master.setGrowingAge(par1);
		else super.setGrowingAge(par1);
	}

	public void superSetGrowingAge(int par1) {
		if (base != null) base.superSetGrowingAge(par1);
		else super.setGrowingAge(par1);
	}

	@Override
	public boolean isChild() {
		return master != null ? master.isChild() : super.isChild();
	}

	public boolean superIsChild() {
		return base != null ? base.superIsChild() : super.isChild();
	}

	@Override
	public void setScaleForAge(boolean par1) {
		if (master != null) master.setScaleForAge(par1);
		else super.setScaleForAge(par1);
	}

	public void superSetScaleForAge(boolean par1) {
		if (base != null) base.superSetScaleForAge(par1);
		else super.setScaleForAge(par1);
	}

	@Override
	protected boolean isMovementCeased() {
		return master != null ? master.isMovementCeased() : super.isMovementCeased();
	}

	public boolean superIsMovementCeased() {
		return base != null ? base.superIsMovementCeased() : super.isMovementCeased();
	}

	@Override
	protected void updateEntityActionState() {
		if (master != null) master.updateEntityActionState();
		else super.updateEntityActionState();
	}

	public void superUpdateEntityActionState() {
		if (base != null) base.superUpdateEntityActionState();
		else super.updateEntityActionState();
	}

	@Override
	protected void updateWanderPath() {
		if (master != null) master.updateWanderPath();
		else super.updateWanderPath();
	}

	public void superUpdateWanderPath() {
		if (base != null) base.superUpdateWanderPath();
		else super.updateWanderPath();
	}

	@Override
	public boolean hasPath() {
		return master != null ? master.hasPath() : super.hasPath();
	}

	public boolean superHasPath() {
		return base != null ? base.superHasPath() : super.hasPath();
	}

	@Override
	public void setPathToEntity(PathEntity pathEntity) {
		if (master != null) master.setPathToEntity(pathEntity);
		else super.setPathToEntity(pathEntity);
	}

	public void superSetPathToEntity(Object pathEntity) {
		if (base != null) base.superSetPathToEntity((PathEntity) pathEntity);
		else super.setPathToEntity((PathEntity) pathEntity);
	}

	@Override
	public Entity getEntityToAttack() {
		return (Entity) (master != null ? master.getEntityToAttack() : super.getEntityToAttack());
	}

	public Entity superGetEntityToAttack() {
		return base != null ? base.superGetEntityToAttack() : super.getEntityToAttack();
	}

	@Override
	public void setTarget(Entity entity) {
		if (master != null) master.setTarget(entity);
		else super.setTarget(entity);
	}

	public void superSetTarget(Object entity) {
		if (base != null) base.superSetTarget((Entity) entity);
		else super.setTarget((Entity) entity);
	}

	@Override
	public void setHomeArea(int par1, int par2, int par3, int par4) {
		if (master != null) master.setHomeArea(par1, par2, par3, par4);
		else super.setHomeArea(par1, par2, par3, par4);
	}

	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
		if (base != null) base.superSetHomeArea(par1, par2, par3, par4);
		else super.setHomeArea(par1, par2, par3, par4);
	}

	@Override
	public ChunkCoordinates getHomePosition() {
		return (ChunkCoordinates) (master != null ? master.getHomePosition() : super.getHomePosition());
	}

	public ChunkCoordinates superGetHomePosition() {
		return base != null ? base.superGetHomePosition() : super.getHomePosition();
	}

	@Override
	public float func_110174_bM() {
		return master != null ? master.func_110174_bM() : super.func_110174_bM();
	}

	public float superFunc_110174_bM() {
		return base != null ? base.superFunc_110174_bM() : super.func_110174_bM();
	}

	@Override
	public void detachHome() {
		if (master != null) master.detachHome();
		else super.detachHome();
	}

	public void superDetachHome() {
		if (base != null) base.superDetachHome();
		else super.detachHome();
	}

	@Override
	public boolean hasHome() {
		return master != null ? master.hasHome() : super.hasHome();
	}

	public boolean superHasHome() {
		return base != null ? base.superHasHome() : super.hasHome();
	}

	@Override
	protected void func_142017_o(float par1) {
		if (master != null) master.func_142017_o(par1);
		else super.func_142017_o(par1);
	}

	public void superFunc_142017_o(float par1) {
		if (base != null) base.superFunc_142017_o(par1);
		else super.func_142017_o(par1);
	}

	@Override
	protected void applyEntityAttributes() {
		if (master != null) master.applyEntityAttributes();
		else super.applyEntityAttributes();
	}

	public void superApplyEntityAttributes() {
		if (base != null) base.superApplyEntityAttributes();
		else super.applyEntityAttributes();
	}

	@Override
	public EntityLookHelper getLookHelper() {
		return (EntityLookHelper) (master != null ? master.getLookHelper() : super.getLookHelper());
	}

	public EntityLookHelper superGetLookHelper() {
		return base != null ? base.superGetLookHelper() : super.getLookHelper();
	}

	@Override
	public EntityMoveHelper getMoveHelper() {
		return (EntityMoveHelper) (master != null ? master.getMoveHelper() : super.getMoveHelper());
	}

	public EntityMoveHelper superGetMoveHelper() {
		return base != null ? base.superGetMoveHelper() : super.getMoveHelper();
	}

	@Override
	public EntityJumpHelper getJumpHelper() {
		return (EntityJumpHelper) (master != null ? master.getJumpHelper() : super.getJumpHelper());
	}

	public EntityJumpHelper superGetJumpHelper() {
		return base != null ? base.superGetJumpHelper() : super.getJumpHelper();
	}

	@Override
	public PathNavigate getNavigator() {
		return (PathNavigate) (master != null ? master.getNavigator() : super.getNavigator());
	}

	public PathNavigate superGetNavigator() {
		return base != null ? base.superGetNavigator() : super.getNavigator();
	}

	@Override
	public EntitySenses getEntitySenses() {
		return (EntitySenses) (master != null ? master.getEntitySenses() : super.getEntitySenses());
	}

	public EntitySenses superGetEntitySenses() {
		return base != null ? base.superGetEntitySenses() : super.getEntitySenses();
	}

	@Override
	public EntityLivingBase getAttackTarget() {
		return (EntityLivingBase) (master != null ? master.getAttackTarget() : super.getAttackTarget());
	}

	public EntityLivingBase superGetAttackTarget() {
		return base != null ? base.superGetAttackTarget() : super.getAttackTarget();
	}

	@Override
	public void setAttackTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setAttackTarget(entityLivingBase);
		else super.setAttackTarget(entityLivingBase);
	}

	public void superSetAttackTarget(Object entityLivingBase) {
		if (base != null) base.superSetAttackTarget((EntityLivingBase) entityLivingBase);
		else super.setAttackTarget((EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean canAttackClass(Class c) {
		return master != null ? master.canAttackClass(c) : super.canAttackClass(c);
	}

	public boolean superCanAttackClass(Object c) {
		return base != null ? base.superCanAttackClass((Class) c) : super.canAttackClass((Class) c);
	}

	@Override
	public void eatGrassBonus() {
		if (master != null) master.eatGrassBonus();
		else super.eatGrassBonus();
	}

	public void superEatGrassBonus() {
		if (base != null) base.superEatGrassBonus();
		else super.eatGrassBonus();
	}

	@Override
	public void playLivingSound() {
		if (master != null) master.playLivingSound();
		else super.playLivingSound();
	}

	public void superPlayLivingSound() {
		if (base != null) base.superPlayLivingSound();
		else super.playLivingSound();
	}

	@Override
	public void onEntityUpdate() {
		if (master != null) master.onEntityUpdate();
		else super.onEntityUpdate();
	}

	public void superOnEntityUpdate() {
		if (base != null) base.superOnEntityUpdate();
		else super.onEntityUpdate();
	}

	@Override
	public void spawnExplosionParticle() {
		if (master != null) master.spawnExplosionParticle();
		else super.spawnExplosionParticle();
	}

	public void superSpawnExplosionParticle() {
		if (base != null) base.superSpawnExplosionParticle();
		else super.spawnExplosionParticle();
	}

	@Override
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	public void superOnUpdate() {
		if (base != null) base.superOnUpdate();
		else super.onUpdate();
	}

	@Override
	protected float func_110146_f(float par1, float par2) {
		return master != null ? master.func_110146_f(par1, par2) : super.func_110146_f(par1, par2);
	}

	public float superFunc_110146_f(float par1, float par2) {
		return base != null ? base.superFunc_110146_f(par1, par2) : super.func_110146_f(par1, par2);
	}

	@Override
	protected String getLivingSound() {
		return master != null ? master.getLivingSound() : super.getLivingSound();
	}

	public String superGetLivingSound() {
		return base != null ? base.superGetLivingSound() : super.getLivingSound();
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		if (master != null) master.dropFewItems(par1, par2);
		else super.dropFewItems(par1, par2);
	}

	public void superDropFewItems(boolean par1, int par2) {
		if (base != null) base.superDropFewItems(par1, par2);
		else super.dropFewItems(par1, par2);
	}

	@Override
	public void setMoveForward(float par1) {
		if (master != null) master.setMoveForward(par1);
		else super.setMoveForward(par1);
	}

	public void superSetMoveForward(float par1) {
		if (base != null) base.superSetMoveForward(par1);
		else super.setMoveForward(par1);
	}

	@Override
	public void setAIMoveSpeed(float par1) {
		if (master != null) master.setAIMoveSpeed(par1);
		else super.setAIMoveSpeed(par1);
	}

	public void superSetAIMoveSpeed(float par1) {
		if (base != null) base.superSetAIMoveSpeed(par1);
		else super.setAIMoveSpeed(par1);
	}

	@Override
	protected boolean isAIEnabled() {
		return master != null ? master.isAIEnabled() : super.isAIEnabled();
	}

	public boolean superIsAIEnabled() {
		return base != null ? base.superIsAIEnabled() : super.isAIEnabled();
	}

	@Override
	protected void despawnEntity() {
		if (master != null) master.despawnEntity();
		else super.despawnEntity();
	}

	public void superDespawnEntity() {
		if (base != null) base.superDespawnEntity();
		else super.despawnEntity();
	}

	@Override
	protected void updateAITasks() {
		if (master != null) master.updateAITasks();
		else super.updateAITasks();
	}

	public void superUpdateAITasks() {
		if (base != null) base.superUpdateAITasks();
		else super.updateAITasks();
	}

	@Override
	public int getVerticalFaceSpeed() {
		return master != null ? master.getVerticalFaceSpeed() : super.getVerticalFaceSpeed();
	}

	public int superGetVerticalFaceSpeed() {
		return base != null ? base.superGetVerticalFaceSpeed() : super.getVerticalFaceSpeed();
	}

	@Override
	public void faceEntity(Entity entity, float par2, float par3) {
		if (master != null) master.faceEntity(entity, par2, par3);
		else super.faceEntity(entity, par2, par3);
	}

	public void superFaceEntity(Object entity, float par2, float par3) {
		if (base != null) base.superFaceEntity((Entity) entity, par2, par3);
		else super.faceEntity((Entity) entity, par2, par3);
	}

	@Override
	public float getRenderSizeModifier() {
		return master != null ? master.getRenderSizeModifier() : super.getRenderSizeModifier();
	}

	public float superGetRenderSizeModifier() {
		return base != null ? base.superGetRenderSizeModifier() : super.getRenderSizeModifier();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return master != null ? master.getMaxSpawnedInChunk() : super.getMaxSpawnedInChunk();
	}

	public int superGetMaxSpawnedInChunk() {
		return base != null ? base.superGetMaxSpawnedInChunk() : super.getMaxSpawnedInChunk();
	}

	@Override
	public int getMaxSafePointTries() {
		return master != null ? master.getMaxSafePointTries() : super.getMaxSafePointTries();
	}

	public int superGetMaxSafePointTries() {
		return base != null ? base.superGetMaxSafePointTries() : super.getMaxSafePointTries();
	}

	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}

	public ItemStack superGetHeldItem() {
		return base != null ? base.superGetHeldItem() : super.getHeldItem();
	}

	@Override
	public ItemStack func_130225_q(int par1) {
		return (ItemStack) (master != null ? master.func_130225_q(par1) : super.func_130225_q(par1));
	}

	public ItemStack superFunc_130225_q(int par1) {
		return base != null ? base.superFunc_130225_q(par1) : super.func_130225_q(par1);
	}

	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack itemStack) {
		if (master != null) master.setCurrentItemOrArmor(par1, itemStack);
		else super.setCurrentItemOrArmor(par1, itemStack);
	}

	public void superSetCurrentItemOrArmor(int par1, Object itemStack) {
		if (base != null) base.superSetCurrentItemOrArmor(par1, (ItemStack) itemStack);
		else super.setCurrentItemOrArmor(par1, (ItemStack) itemStack);
	}

	@Override
	public ItemStack[] getLastActiveItems() {
		return (ItemStack[]) (master != null ? master.getLastActiveItems() : super.getLastActiveItems());
	}

	public ItemStack[] superGetLastActiveItems() {
		return base != null ? base.superGetLastActiveItems() : super.getLastActiveItems();
	}

	@Override
	protected void dropEquipment(boolean par1, int par2) {
		if (master != null) master.dropEquipment(par1, par2);
		else super.dropEquipment(par1, par2);
	}

	public void superDropEquipment(boolean par1, int par2) {
		if (base != null) base.superDropEquipment(par1, par2);
		else super.dropEquipment(par1, par2);
	}

	@Override
	protected void addRandomArmor() {
		if (master != null) master.addRandomArmor();
		else super.addRandomArmor();
	}

	public void superAddRandomArmor() {
		if (base != null) base.superAddRandomArmor();
		else super.addRandomArmor();
	}

	@Override
	protected void enchantEquipment() {
		if (master != null) master.enchantEquipment();
		else super.enchantEquipment();
	}

	public void superEnchantEquipment() {
		if (base != null) base.superEnchantEquipment();
		else super.enchantEquipment();
	}

	@Override
	public boolean canBeSteered() {
		return master != null ? master.canBeSteered() : super.canBeSteered();
	}

	public boolean superCanBeSteered() {
		return base != null ? base.superCanBeSteered() : super.canBeSteered();
	}

	@Override
	public void func_110163_bv() {
		if (master != null) master.func_110163_bv();
		else super.func_110163_bv();
	}

	public void superFunc_110163_bv() {
		if (base != null) base.superFunc_110163_bv();
		else super.func_110163_bv();
	}

	@Override
	public void setCustomNameTag(String par1Str) {
		if (master != null) master.setCustomNameTag(par1Str);
		else super.setCustomNameTag(par1Str);
	}

	public void superSetCustomNameTag(String par1Str) {
		if (base != null) base.superSetCustomNameTag(par1Str);
		else super.setCustomNameTag(par1Str);
	}

	@Override
	public String getCustomNameTag() {
		return master != null ? master.getCustomNameTag() : super.getCustomNameTag();
	}

	public String superGetCustomNameTag() {
		return base != null ? base.superGetCustomNameTag() : super.getCustomNameTag();
	}

	@Override
	public boolean hasCustomNameTag() {
		return master != null ? master.hasCustomNameTag() : super.hasCustomNameTag();
	}

	public boolean superHasCustomNameTag() {
		return base != null ? base.superHasCustomNameTag() : super.hasCustomNameTag();
	}

	@Override
	public void setAlwaysRenderNameTag(boolean par1) {
		if (master != null) master.setAlwaysRenderNameTag(par1);
		else super.setAlwaysRenderNameTag(par1);
	}

	public void superSetAlwaysRenderNameTag(boolean par1) {
		if (base != null) base.superSetAlwaysRenderNameTag(par1);
		else super.setAlwaysRenderNameTag(par1);
	}

	@Override
	public boolean getAlwaysRenderNameTag() {
		return master != null ? master.getAlwaysRenderNameTag() : super.getAlwaysRenderNameTag();
	}

	public boolean superGetAlwaysRenderNameTag() {
		return base != null ? base.superGetAlwaysRenderNameTag() : super.getAlwaysRenderNameTag();
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}

	public boolean superGetAlwaysRenderNameTagForRender() {
		return base != null ? base.superGetAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public void setEquipmentDropChance(int par1, float par2) {
		if (master != null) master.setEquipmentDropChance(par1, par2);
		else super.setEquipmentDropChance(par1, par2);
	}

	public void superSetEquipmentDropChance(int par1, float par2) {
		if (base != null) base.superSetEquipmentDropChance(par1, par2);
		else super.setEquipmentDropChance(par1, par2);
	}

	@Override
	public boolean canPickUpLoot() {
		return master != null ? master.canPickUpLoot() : super.canPickUpLoot();
	}

	public boolean superCanPickUpLoot() {
		return base != null ? base.superCanPickUpLoot() : super.canPickUpLoot();
	}

	@Override
	public void setCanPickUpLoot(boolean par1) {
		if (master != null) master.setCanPickUpLoot(par1);
		else super.setCanPickUpLoot(par1);
	}

	public void superSetCanPickUpLoot(boolean par1) {
		if (base != null) base.superSetCanPickUpLoot(par1);
		else super.setCanPickUpLoot(par1);
	}

	@Override
	public boolean isNoDespawnRequired() {
		return master != null ? master.isNoDespawnRequired() : super.isNoDespawnRequired();
	}

	public boolean superIsNoDespawnRequired() {
		return base != null ? base.superIsNoDespawnRequired() : super.isNoDespawnRequired();
	}

	@Override
	public void clearLeashed(boolean par1, boolean par2) {
		if (master != null) master.clearLeashed(par1, par2);
		else super.clearLeashed(par1, par2);
	}

	public void superClearLeashed(boolean par1, boolean par2) {
		if (base != null) base.superClearLeashed(par1, par2);
		else super.clearLeashed(par1, par2);
	}

	@Override
	public boolean allowLeashing() {
		return master != null ? master.allowLeashing() : super.allowLeashing();
	}

	public boolean superAllowLeashing() {
		return base != null ? base.superAllowLeashing() : super.allowLeashing();
	}

	@Override
	public boolean getLeashed() {
		return master != null ? master.getLeashed() : super.getLeashed();
	}

	public boolean superGetLeashed() {
		return base != null ? base.superGetLeashed() : super.getLeashed();
	}

	@Override
	public Entity getLeashedToEntity() {
		return (Entity) (master != null ? master.getLeashedToEntity() : super.getLeashedToEntity());
	}

	public Entity superGetLeashedToEntity() {
		return base != null ? base.superGetLeashedToEntity() : super.getLeashedToEntity();
	}

	@Override
	public void setLeashedToEntity(Entity entity, boolean par2) {
		if (master != null) master.setLeashedToEntity(entity, par2);
		else super.setLeashedToEntity(entity, par2);
	}

	public void superSetLeashedToEntity(Object entity, boolean par2) {
		if (base != null) base.superSetLeashedToEntity((Entity) entity, par2);
		else super.setLeashedToEntity((Entity) entity, par2);
	}

	@Override
	protected void updateFallState(double par1, boolean par3) {
		if (master != null) master.updateFallState(par1, par3);
		else super.updateFallState(par1, par3);
	}

	public void superUpdateFallState(double par1, boolean par3) {
		if (base != null) base.superUpdateFallState(par1, par3);
		else super.updateFallState(par1, par3);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}

	public boolean superCanBreatheUnderwater() {
		return base != null ? base.superCanBreatheUnderwater() : super.canBreatheUnderwater();
	}

	@Override
	protected void onDeathUpdate() {
		if (master != null) master.onDeathUpdate();
		else super.onDeathUpdate();
	}

	public void superOnDeathUpdate() {
		if (base != null) base.superOnDeathUpdate();
		else super.onDeathUpdate();
	}

	@Override
	protected int decreaseAirSupply(int par1) {
		return master != null ? master.decreaseAirSupply(par1) : super.decreaseAirSupply(par1);
	}

	public int superDecreaseAirSupply(int par1) {
		return base != null ? base.superDecreaseAirSupply(par1) : super.decreaseAirSupply(par1);
	}

	@Override
	protected boolean isPlayer() {
		return master != null ? master.isPlayer() : super.isPlayer();
	}

	public boolean superIsPlayer() {
		return base != null ? base.superIsPlayer() : super.isPlayer();
	}

	@Override
	public Random getRNG() {
		return (Random) (master != null ? master.getRNG() : super.getRNG());
	}

	public Random superGetRNG() {
		return base != null ? base.superGetRNG() : super.getRNG();
	}

	@Override
	public EntityLivingBase getAITarget() {
		return (EntityLivingBase) (master != null ? master.getAITarget() : super.getAITarget());
	}

	public EntityLivingBase superGetAITarget() {
		return base != null ? base.superGetAITarget() : super.getAITarget();
	}

	@Override
	public int func_142015_aE() {
		return master != null ? master.func_142015_aE() : super.func_142015_aE();
	}

	public int superFunc_142015_aE() {
		return base != null ? base.superFunc_142015_aE() : super.func_142015_aE();
	}

	@Override
	public void setRevengeTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setRevengeTarget(entityLivingBase);
		else super.setRevengeTarget(entityLivingBase);
	}

	public void superSetRevengeTarget(Object entityLivingBase) {
		if (base != null) base.superSetRevengeTarget((EntityLivingBase) entityLivingBase);
		else super.setRevengeTarget((EntityLivingBase) entityLivingBase);
	}

	@Override
	public EntityLivingBase getLastAttacker() {
		return (EntityLivingBase) (master != null ? master.getLastAttacker() : super.getLastAttacker());
	}

	public EntityLivingBase superGetLastAttacker() {
		return base != null ? base.superGetLastAttacker() : super.getLastAttacker();
	}

	@Override
	public int getLastAttackerTime() {
		return master != null ? master.getLastAttackerTime() : super.getLastAttackerTime();
	}

	public int superGetLastAttackerTime() {
		return base != null ? base.superGetLastAttackerTime() : super.getLastAttackerTime();
	}

	@Override
	public void setLastAttacker(Entity entity) {
		if (master != null) master.setLastAttacker(entity);
		else super.setLastAttacker(entity);
	}

	public void superSetLastAttacker(Object entity) {
		if (base != null) base.superSetLastAttacker((Entity) entity);
		else super.setLastAttacker((Entity) entity);
	}

	@Override
	public int getAge() {
		return master != null ? master.getAge() : super.getAge();
	}

	public int superGetAge() {
		return base != null ? base.superGetAge() : super.getAge();
	}

	@Override
	protected void updatePotionEffects() {
		if (master != null) master.updatePotionEffects();
		else super.updatePotionEffects();
	}

	public void superUpdatePotionEffects() {
		if (base != null) base.superUpdatePotionEffects();
		else super.updatePotionEffects();
	}

	@Override
	public void clearActivePotions() {
		if (master != null) master.clearActivePotions();
		else super.clearActivePotions();
	}

	public void superClearActivePotions() {
		if (base != null) base.superClearActivePotions();
		else super.clearActivePotions();
	}

	@Override
	public Collection getActivePotionEffects() {
		return (Collection) (master != null ? master.getActivePotionEffects() : super.getActivePotionEffects());
	}

	public Collection superGetActivePotionEffects() {
		return base != null ? base.superGetActivePotionEffects() : super.getActivePotionEffects();
	}

	@Override
	public boolean isPotionActive(int par1) {
		return master != null ? master.isPotionActive(par1) : super.isPotionActive(par1);
	}

	public boolean superIsPotionActive(int par1) {
		return base != null ? base.superIsPotionActive(par1) : super.isPotionActive(par1);
	}

	@Override
	public boolean isPotionActive(Potion potion) {
		return master != null ? master.isPotionActive(potion) : super.isPotionActive(potion);
	}

	public boolean superIsPotionActive(Object potion) {
		return base != null ? base.superIsPotionActive((Potion) potion) : super.isPotionActive((Potion) potion);
	}

	@Override
	public PotionEffect getActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.getActivePotionEffect(potion) : super.getActivePotionEffect(potion));
	}

	public PotionEffect superGetActivePotionEffect(Object potion) {
		return base != null ? base.superGetActivePotionEffect((Potion) potion) : super.getActivePotionEffect((Potion) potion);
	}

	@Override
	public void addPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.addPotionEffect(potionEffect);
		else super.addPotionEffect(potionEffect);
	}

	public void superAddPotionEffect(Object potionEffect) {
		if (base != null) base.superAddPotionEffect((PotionEffect) potionEffect);
		else super.addPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public boolean isPotionApplicable(PotionEffect potionEffect) {
		return master != null ? master.isPotionApplicable(potionEffect) : super.isPotionApplicable(potionEffect);
	}

	public boolean superIsPotionApplicable(Object potionEffect) {
		return base != null ? base.superIsPotionApplicable((PotionEffect) potionEffect) : super.isPotionApplicable((PotionEffect) potionEffect);
	}

	@Override
	public boolean isEntityUndead() {
		return master != null ? master.isEntityUndead() : super.isEntityUndead();
	}

	public boolean superIsEntityUndead() {
		return base != null ? base.superIsEntityUndead() : super.isEntityUndead();
	}

	@Override
	public void removePotionEffectClient(int par1) {
		if (master != null) master.removePotionEffectClient(par1);
		else super.removePotionEffectClient(par1);
	}

	public void superRemovePotionEffectClient(int par1) {
		if (base != null) base.superRemovePotionEffectClient(par1);
		else super.removePotionEffectClient(par1);
	}

	@Override
	public void removePotionEffect(int par1) {
		if (master != null) master.removePotionEffect(par1);
		else super.removePotionEffect(par1);
	}

	public void superRemovePotionEffect(int par1) {
		if (base != null) base.superRemovePotionEffect(par1);
		else super.removePotionEffect(par1);
	}

	@Override
	protected void onNewPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onNewPotionEffect(potionEffect);
		else super.onNewPotionEffect(potionEffect);
	}

	public void superOnNewPotionEffect(Object potionEffect) {
		if (base != null) base.superOnNewPotionEffect((PotionEffect) potionEffect);
		else super.onNewPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	protected void onChangedPotionEffect(PotionEffect potionEffect, boolean par2) {
		if (master != null) master.onChangedPotionEffect(potionEffect, par2);
		else super.onChangedPotionEffect(potionEffect, par2);
	}

	public void superOnChangedPotionEffect(Object potionEffect, boolean par2) {
		if (base != null) base.superOnChangedPotionEffect((PotionEffect) potionEffect, par2);
		else super.onChangedPotionEffect((PotionEffect) potionEffect, par2);
	}

	@Override
	protected void onFinishedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onFinishedPotionEffect(potionEffect);
		else super.onFinishedPotionEffect(potionEffect);
	}

	public void superOnFinishedPotionEffect(Object potionEffect) {
		if (base != null) base.superOnFinishedPotionEffect((PotionEffect) potionEffect);
		else super.onFinishedPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public void heal(float par1) {
		if (master != null) master.heal(par1);
		else super.heal(par1);
	}

	public void superHeal(float par1) {
		if (base != null) base.superHeal(par1);
		else super.heal(par1);
	}

	@Override
	public void setHealth(float par1) {
		if (master != null) master.setHealth(par1);
		else super.setHealth(par1);
	}

	public void superSetHealth(float par1) {
		if (base != null) base.superSetHealth(par1);
		else super.setHealth(par1);
	}

	@Override
	public void renderBrokenItemStack(ItemStack itemStack) {
		if (master != null) master.renderBrokenItemStack(itemStack);
		else super.renderBrokenItemStack(itemStack);
	}

	public void superRenderBrokenItemStack(Object itemStack) {
		if (base != null) base.superRenderBrokenItemStack((ItemStack) itemStack);
		else super.renderBrokenItemStack((ItemStack) itemStack);
	}

	@Override
	public void onDeath(DamageSource damageSource) {
		if (master != null) master.onDeath(damageSource);
		else super.onDeath(damageSource);
	}

	public void superOnDeath(Object damageSource) {
		if (base != null) base.superOnDeath((DamageSource) damageSource);
		else super.onDeath((DamageSource) damageSource);
	}

	@Override
	public void knockBack(Entity entity, float par2, double par3, double par5) {
		if (master != null) master.knockBack(entity, par2, par3, par5);
		else super.knockBack(entity, par2, par3, par5);
	}

	public void superKnockBack(Object entity, float par2, double par3, double par5) {
		if (base != null) base.superKnockBack((Entity) entity, par2, par3, par5);
		else super.knockBack((Entity) entity, par2, par3, par5);
	}

	@Override
	protected String getHurtSound() {
		return master != null ? master.getHurtSound() : super.getHurtSound();
	}

	public String superGetHurtSound() {
		return base != null ? base.superGetHurtSound() : super.getHurtSound();
	}

	@Override
	protected String getDeathSound() {
		return master != null ? master.getDeathSound() : super.getDeathSound();
	}

	public String superGetDeathSound() {
		return base != null ? base.superGetDeathSound() : super.getDeathSound();
	}

	@Override
	protected void dropRareDrop(int par1) {
		if (master != null) master.dropRareDrop(par1);
		else super.dropRareDrop(par1);
	}

	public void superDropRareDrop(int par1) {
		if (base != null) base.superDropRareDrop(par1);
		else super.dropRareDrop(par1);
	}

	@Override
	public boolean isOnLadder() {
		return master != null ? master.isOnLadder() : super.isOnLadder();
	}

	public boolean superIsOnLadder() {
		return base != null ? base.superIsOnLadder() : super.isOnLadder();
	}

	@Override
	public boolean isEntityAlive() {
		return master != null ? master.isEntityAlive() : super.isEntityAlive();
	}

	public boolean superIsEntityAlive() {
		return base != null ? base.superIsEntityAlive() : super.isEntityAlive();
	}

	@Override
	protected void fall(float par1) {
		if (master != null) master.fall(par1);
		else super.fall(par1);
	}

	public void superFall(float par1) {
		if (base != null) base.superFall(par1);
		else super.fall(par1);
	}

	@Override
	public void performHurtAnimation() {
		if (master != null) master.performHurtAnimation();
		else super.performHurtAnimation();
	}

	public void superPerformHurtAnimation() {
		if (base != null) base.superPerformHurtAnimation();
		else super.performHurtAnimation();
	}

	@Override
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}

	public int superGetTotalArmorValue() {
		return base != null ? base.superGetTotalArmorValue() : super.getTotalArmorValue();
	}

	@Override
	protected void damageArmor(float par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}

	public void superDamageArmor(float par1) {
		if (base != null) base.superDamageArmor(par1);
		else super.damageArmor(par1);
	}

	@Override
	protected float applyArmorCalculations(DamageSource damageSource, float par2) {
		return master != null ? master.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2);
	}

	public float superApplyArmorCalculations(Object damageSource, float par2) {
		return base != null ? base.superApplyArmorCalculations((DamageSource) damageSource, par2) : super.applyArmorCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float par2) {
		return master != null ? master.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2);
	}

	public float superApplyPotionDamageCalculations(Object damageSource, float par2) {
		return base != null ? base.superApplyPotionDamageCalculations((DamageSource) damageSource, par2) : super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected void damageEntity(DamageSource damageSource, float par2) {
		if (master != null) master.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
	}

	public void superDamageEntity(Object damageSource, float par2) {
		if (base != null) base.superDamageEntity((DamageSource) damageSource, par2);
		else super.damageEntity((DamageSource) damageSource, par2);
	}

	@Override
	public CombatTracker func_110142_aN() {
		return (CombatTracker) (master != null ? master.func_110142_aN() : super.func_110142_aN());
	}

	public CombatTracker superFunc_110142_aN() {
		return base != null ? base.superFunc_110142_aN() : super.func_110142_aN();
	}

	@Override
	public EntityLivingBase func_94060_bK() {
		return (EntityLivingBase) (master != null ? master.func_94060_bK() : super.func_94060_bK());
	}

	public EntityLivingBase superFunc_94060_bK() {
		return base != null ? base.superFunc_94060_bK() : super.func_94060_bK();
	}

	@Override
	public void swingItem() {
		if (master != null) master.swingItem();
		else super.swingItem();
	}

	public void superSwingItem() {
		if (base != null) base.superSwingItem();
		else super.swingItem();
	}

	@Override
	protected void kill() {
		if (master != null) master.kill();
		else super.kill();
	}

	public void superKill() {
		if (base != null) base.superKill();
		else super.kill();
	}

	@Override
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}

	public void superUpdateArmSwingProgress() {
		if (base != null) base.superUpdateArmSwingProgress();
		else super.updateArmSwingProgress();
	}

	@Override
	public BaseAttributeMap getAttributeMap() {
		return (BaseAttributeMap) (master != null ? master.getAttributeMap() : super.getAttributeMap());
	}

	public BaseAttributeMap superGetAttributeMap() {
		return base != null ? base.superGetAttributeMap() : super.getAttributeMap();
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return (EnumCreatureAttribute) (master != null ? master.getCreatureAttribute() : super.getCreatureAttribute());
	}

	public EnumCreatureAttribute superGetCreatureAttribute() {
		return base != null ? base.superGetCreatureAttribute() : super.getCreatureAttribute();
	}

	@Override
	public void setSprinting(boolean par1) {
		if (master != null) master.setSprinting(par1);
		else super.setSprinting(par1);
	}

	public void superSetSprinting(boolean par1) {
		if (base != null) base.superSetSprinting(par1);
		else super.setSprinting(par1);
	}

	@Override
	protected float getSoundVolume() {
		return master != null ? master.getSoundVolume() : super.getSoundVolume();
	}

	public float superGetSoundVolume() {
		return base != null ? base.superGetSoundVolume() : super.getSoundVolume();
	}

	@Override
	protected float getSoundPitch() {
		return master != null ? master.getSoundPitch() : super.getSoundPitch();
	}

	public float superGetSoundPitch() {
		return base != null ? base.superGetSoundPitch() : super.getSoundPitch();
	}

	@Override
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}

	public boolean superIsMovementBlocked() {
		return base != null ? base.superIsMovementBlocked() : super.isMovementBlocked();
	}

	@Override
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		if (master != null) master.setPositionAndUpdate(par1, par3, par5);
		else super.setPositionAndUpdate(par1, par3, par5);
	}

	public void superSetPositionAndUpdate(double par1, double par3, double par5) {
		if (base != null) base.superSetPositionAndUpdate(par1, par3, par5);
		else super.setPositionAndUpdate(par1, par3, par5);
	}

	@Override
	public void dismountEntity(Entity entity) {
		if (master != null) master.dismountEntity(entity);
		else super.dismountEntity(entity);
	}

	public void superDismountEntity(Object entity) {
		if (base != null) base.superDismountEntity((Entity) entity);
		else super.dismountEntity((Entity) entity);
	}

	@Override
	protected void jump() {
		if (master != null) master.jump();
		else super.jump();
	}

	public void superJump() {
		if (base != null) base.superJump();
		else super.jump();
	}

	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		if (master != null) master.moveEntityWithHeading(par1, par2);
		else super.moveEntityWithHeading(par1, par2);
	}

	public void superMoveEntityWithHeading(float par1, float par2) {
		if (base != null) base.superMoveEntityWithHeading(par1, par2);
		else super.moveEntityWithHeading(par1, par2);
	}

	@Override
	public float getAIMoveSpeed() {
		return master != null ? master.getAIMoveSpeed() : super.getAIMoveSpeed();
	}

	public float superGetAIMoveSpeed() {
		return base != null ? base.superGetAIMoveSpeed() : super.getAIMoveSpeed();
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return master != null ? master.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}

	public boolean superAttackEntityAsMob(Object entity) {
		return base != null ? base.superAttackEntityAsMob((Entity) entity) : super.attackEntityAsMob((Entity) entity);
	}

	@Override
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}

	public boolean superIsPlayerSleeping() {
		return base != null ? base.superIsPlayerSleeping() : super.isPlayerSleeping();
	}

	@Override
	protected void collideWithNearbyEntities() {
		if (master != null) master.collideWithNearbyEntities();
		else super.collideWithNearbyEntities();
	}

	public void superCollideWithNearbyEntities() {
		if (base != null) base.superCollideWithNearbyEntities();
		else super.collideWithNearbyEntities();
	}

	@Override
	protected void collideWithEntity(Entity entity) {
		if (master != null) master.collideWithEntity(entity);
		else super.collideWithEntity(entity);
	}

	public void superCollideWithEntity(Object entity) {
		if (base != null) base.superCollideWithEntity((Entity) entity);
		else super.collideWithEntity((Entity) entity);
	}

	@Override
	public void updateRidden() {
		if (master != null) master.updateRidden();
		else super.updateRidden();
	}

	public void superUpdateRidden() {
		if (base != null) base.superUpdateRidden();
		else super.updateRidden();
	}

	@Override
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		if (master != null) master.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
		else super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}

	public void superSetPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		if (base != null) base.superSetPositionAndRotation2(par1, par3, par5, par7, par8, par9);
		else super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}

	@Override
	public void setJumping(boolean par1) {
		if (master != null) master.setJumping(par1);
		else super.setJumping(par1);
	}

	public void superSetJumping(boolean par1) {
		if (base != null) base.superSetJumping(par1);
		else super.setJumping(par1);
	}

	@Override
	public void onItemPickup(Entity entity, int par2) {
		if (master != null) master.onItemPickup(entity, par2);
		else super.onItemPickup(entity, par2);
	}

	public void superOnItemPickup(Object entity, int par2) {
		if (base != null) base.superOnItemPickup((Entity) entity, par2);
		else super.onItemPickup((Entity) entity, par2);
	}

	@Override
	public boolean canEntityBeSeen(Entity entity) {
		return master != null ? master.canEntityBeSeen(entity) : super.canEntityBeSeen(entity);
	}

	public boolean superCanEntityBeSeen(Object entity) {
		return base != null ? base.superCanEntityBeSeen((Entity) entity) : super.canEntityBeSeen((Entity) entity);
	}

	@Override
	public Vec3 getLookVec() {
		return (Vec3) (master != null ? master.getLookVec() : super.getLookVec());
	}

	public Vec3 superGetLookVec() {
		return base != null ? base.superGetLookVec() : super.getLookVec();
	}

	@Override
	public Vec3 getLook(float par1) {
		return (Vec3) (master != null ? master.getLook(par1) : super.getLook(par1));
	}

	public Vec3 superGetLook(float par1) {
		return base != null ? base.superGetLook(par1) : super.getLook(par1);
	}

	@Override
	public float getSwingProgress(float par1) {
		return master != null ? master.getSwingProgress(par1) : super.getSwingProgress(par1);
	}

	public float superGetSwingProgress(float par1) {
		return base != null ? base.superGetSwingProgress(par1) : super.getSwingProgress(par1);
	}

	@Override
	public Vec3 getPosition(float par1) {
		return (Vec3) (master != null ? master.getPosition(par1) : super.getPosition(par1));
	}

	public Vec3 superGetPosition(float par1) {
		return base != null ? base.superGetPosition(par1) : super.getPosition(par1);
	}

	@Override
	public MovingObjectPosition rayTrace(double par1, float par3) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(par1, par3) : super.rayTrace(par1, par3));
	}

	public MovingObjectPosition superRayTrace(double par1, float par3) {
		return base != null ? base.superRayTrace(par1, par3) : super.rayTrace(par1, par3);
	}

	@Override
	public boolean isClientWorld() {
		return master != null ? master.isClientWorld() : super.isClientWorld();
	}

	public boolean superIsClientWorld() {
		return base != null ? base.superIsClientWorld() : super.isClientWorld();
	}

	@Override
	public boolean canBeCollidedWith() {
		return master != null ? master.canBeCollidedWith() : super.canBeCollidedWith();
	}

	public boolean superCanBeCollidedWith() {
		return base != null ? base.superCanBeCollidedWith() : super.canBeCollidedWith();
	}

	@Override
	public boolean canBePushed() {
		return master != null ? master.canBePushed() : super.canBePushed();
	}

	public boolean superCanBePushed() {
		return base != null ? base.superCanBePushed() : super.canBePushed();
	}

	@Override
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}

	public float superGetEyeHeight() {
		return base != null ? base.superGetEyeHeight() : super.getEyeHeight();
	}

	@Override
	protected void setBeenAttacked() {
		if (master != null) master.setBeenAttacked();
		else super.setBeenAttacked();
	}

	public void superSetBeenAttacked() {
		if (base != null) base.superSetBeenAttacked();
		else super.setBeenAttacked();
	}

	@Override
	public float getRotationYawHead() {
		return master != null ? master.getRotationYawHead() : super.getRotationYawHead();
	}

	public float superGetRotationYawHead() {
		return base != null ? base.superGetRotationYawHead() : super.getRotationYawHead();
	}

	@Override
	public void setRotationYawHead(float par1) {
		if (master != null) master.setRotationYawHead(par1);
		else super.setRotationYawHead(par1);
	}

	public void superSetRotationYawHead(float par1) {
		if (base != null) base.superSetRotationYawHead(par1);
		else super.setRotationYawHead(par1);
	}

	@Override
	public float getAbsorptionAmount() {
		return master != null ? master.getAbsorptionAmount() : super.getAbsorptionAmount();
	}

	public float superGetAbsorptionAmount() {
		return base != null ? base.superGetAbsorptionAmount() : super.getAbsorptionAmount();
	}

	@Override
	public void setAbsorptionAmount(float par1) {
		if (master != null) master.setAbsorptionAmount(par1);
		else super.setAbsorptionAmount(par1);
	}

	public void superSetAbsorptionAmount(float par1) {
		if (base != null) base.superSetAbsorptionAmount(par1);
		else super.setAbsorptionAmount(par1);
	}

	@Override
	public boolean isOnTeam(Team team) {
		return master != null ? master.isOnTeam(team) : super.isOnTeam(team);
	}

	public boolean superIsOnTeam(Object team) {
		return base != null ? base.superIsOnTeam((Team) team) : super.isOnTeam((Team) team);
	}

	@Override
	public void curePotionEffects(ItemStack itemStack) {
		if (master != null) master.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}

	public void superCurePotionEffects(Object itemStack) {
		if (base != null) base.superCurePotionEffects((ItemStack) itemStack);
		else super.curePotionEffects((ItemStack) itemStack);
	}

	@Override
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return master != null ? master.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}

	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return base != null ? base.superShouldRiderFaceForward((EntityPlayer) entityPlayer) : super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}

	@Override
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataWatcher() : super.getDataWatcher());
	}

	public DataWatcher superGetDataWatcher() {
		return base != null ? base.superGetDataWatcher() : super.getDataWatcher();
	}

	@Override
	public boolean equals(Object par1Obj) {
		return master != null ? master.equals(par1Obj) : super.equals(par1Obj);
	}

	public boolean superEquals(Object par1Obj) {
		return base != null ? base.superEquals(par1Obj) : super.equals(par1Obj);
	}

	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}

	public int superHashCode() {
		return base != null ? base.superHashCode() : super.hashCode();
	}

	@Override
	protected void preparePlayerToSpawn() {
		if (master != null) master.preparePlayerToSpawn();
		else super.preparePlayerToSpawn();
	}

	public void superPreparePlayerToSpawn() {
		if (base != null) base.superPreparePlayerToSpawn();
		else super.preparePlayerToSpawn();
	}

	@Override
	public void setDead() {
		if (master != null) master.setDead();
		else super.setDead();
	}

	public void superSetDead() {
		if (base != null) base.superSetDead();
		else super.setDead();
	}

	@Override
	protected void setRotation(float par1, float par2) {
		if (master != null) master.setRotation(par1, par2);
		else super.setRotation(par1, par2);
	}

	public void superSetRotation(float par1, float par2) {
		if (base != null) base.superSetRotation(par1, par2);
		else super.setRotation(par1, par2);
	}

	@Override
	public void setPosition(double par1, double par3, double par5) {
		if (master != null) master.setPosition(par1, par3, par5);
		else super.setPosition(par1, par3, par5);
	}

	public void superSetPosition(double par1, double par3, double par5) {
		if (base != null) base.superSetPosition(par1, par3, par5);
		else super.setPosition(par1, par3, par5);
	}

	@Override
	public void setAngles(float par1, float par2) {
		if (master != null) master.setAngles(par1, par2);
		else super.setAngles(par1, par2);
	}

	public void superSetAngles(float par1, float par2) {
		if (base != null) base.superSetAngles(par1, par2);
		else super.setAngles(par1, par2);
	}

	@Override
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}

	public int superGetMaxInPortalTime() {
		return base != null ? base.superGetMaxInPortalTime() : super.getMaxInPortalTime();
	}

	@Override
	protected void setOnFireFromLava() {
		if (master != null) master.setOnFireFromLava();
		else super.setOnFireFromLava();
	}

	public void superSetOnFireFromLava() {
		if (base != null) base.superSetOnFireFromLava();
		else super.setOnFireFromLava();
	}

	@Override
	public void setFire(int par1) {
		if (master != null) master.setFire(par1);
		else super.setFire(par1);
	}

	public void superSetFire(int par1) {
		if (base != null) base.superSetFire(par1);
		else super.setFire(par1);
	}

	@Override
	public void extinguish() {
		if (master != null) master.extinguish();
		else super.extinguish();
	}

	public void superExtinguish() {
		if (base != null) base.superExtinguish();
		else super.extinguish();
	}

	@Override
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return master != null ? master.isOffsetPositionInLiquid(par1, par3, par5) : super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	public boolean superIsOffsetPositionInLiquid(double par1, double par3, double par5) {
		return base != null ? base.superIsOffsetPositionInLiquid(par1, par3, par5) : super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.moveEntity(par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	public void superMoveEntity(double par1, double par3, double par5) {
		if (base != null) base.superMoveEntity(par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	@Override
	public void playSound(String par1Str, float par2, float par3) {
		if (master != null) master.playSound(par1Str, par2, par3);
		else super.playSound(par1Str, par2, par3);
	}

	public void superPlaySound(String par1Str, float par2, float par3) {
		if (base != null) base.superPlaySound(par1Str, par2, par3);
		else super.playSound(par1Str, par2, par3);
	}

	@Override
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}

	public boolean superCanTriggerWalking() {
		return base != null ? base.superCanTriggerWalking() : super.canTriggerWalking();
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getBoundingBox() : super.getBoundingBox());
	}

	public AxisAlignedBB superGetBoundingBox() {
		return base != null ? base.superGetBoundingBox() : super.getBoundingBox();
	}

	@Override
	protected void dealFireDamage(int par1) {
		if (master != null) master.dealFireDamage(par1);
		else super.dealFireDamage(par1);
	}

	public void superDealFireDamage(int par1) {
		if (base != null) base.superDealFireDamage(par1);
		else super.dealFireDamage(par1);
	}

	@Override
	public boolean isWet() {
		return master != null ? master.isWet() : super.isWet();
	}

	public boolean superIsWet() {
		return base != null ? base.superIsWet() : super.isWet();
	}

	@Override
	public boolean isInWater() {
		return master != null ? master.isInWater() : super.isInWater();
	}

	public boolean superIsInWater() {
		return base != null ? base.superIsInWater() : super.isInWater();
	}

	@Override
	public boolean handleWaterMovement() {
		return master != null ? master.handleWaterMovement() : super.handleWaterMovement();
	}

	public boolean superHandleWaterMovement() {
		return base != null ? base.superHandleWaterMovement() : super.handleWaterMovement();
	}

	@Override
	public boolean isInsideOfMaterial(Material material) {
		return master != null ? master.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}

	public boolean superIsInsideOfMaterial(Object material) {
		return base != null ? base.superIsInsideOfMaterial((Material) material) : super.isInsideOfMaterial((Material) material);
	}

	@Override
	public boolean handleLavaMovement() {
		return master != null ? master.handleLavaMovement() : super.handleLavaMovement();
	}

	public boolean superHandleLavaMovement() {
		return base != null ? base.superHandleLavaMovement() : super.handleLavaMovement();
	}

	@Override
	public void moveFlying(float par1, float par2, float par3) {
		if (master != null) master.moveFlying(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}

	public void superMoveFlying(float par1, float par2, float par3) {
		if (base != null) base.superMoveFlying(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return master != null ? master.getBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}

	public int superGetBrightnessForRender(float par1) {
		return base != null ? base.superGetBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}

	@Override
	public float getBrightness(float par1) {
		return master != null ? master.getBrightness(par1) : super.getBrightness(par1);
	}

	public float superGetBrightness(float par1) {
		return base != null ? base.superGetBrightness(par1) : super.getBrightness(par1);
	}

	@Override
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}

	public void superSetWorld(Object world) {
		if (base != null) base.superSetWorld((World) world);
		else super.setWorld((World) world);
	}

	@Override
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setPositionAndRotation(par1, par3, par5, par7, par8);
		else super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	public void superSetPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		if (base != null) base.superSetPositionAndRotation(par1, par3, par5, par7, par8);
		else super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	@Override
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setLocationAndAngles(par1, par3, par5, par7, par8);
		else super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}

	public void superSetLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		if (base != null) base.superSetLocationAndAngles(par1, par3, par5, par7, par8);
		else super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}

	@Override
	public float getDistanceToEntity(Entity entity) {
		return master != null ? master.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}

	public float superGetDistanceToEntity(Object entity) {
		return base != null ? base.superGetDistanceToEntity((Entity) entity) : super.getDistanceToEntity((Entity) entity);
	}

	@Override
	public double getDistanceSq(double par1, double par3, double par5) {
		return master != null ? master.getDistanceSq(par1, par3, par5) : super.getDistanceSq(par1, par3, par5);
	}

	public double superGetDistanceSq(double par1, double par3, double par5) {
		return base != null ? base.superGetDistanceSq(par1, par3, par5) : super.getDistanceSq(par1, par3, par5);
	}

	@Override
	public double getDistance(double par1, double par3, double par5) {
		return master != null ? master.getDistance(par1, par3, par5) : super.getDistance(par1, par3, par5);
	}

	public double superGetDistance(double par1, double par3, double par5) {
		return base != null ? base.superGetDistance(par1, par3, par5) : super.getDistance(par1, par3, par5);
	}

	@Override
	public double getDistanceSqToEntity(Entity entity) {
		return master != null ? master.getDistanceSqToEntity(entity) : super.getDistanceSqToEntity(entity);
	}

	public double superGetDistanceSqToEntity(Object entity) {
		return base != null ? base.superGetDistanceSqToEntity((Entity) entity) : super.getDistanceSqToEntity((Entity) entity);
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
		if (master != null) master.onCollideWithPlayer(entityPlayer);
		else super.onCollideWithPlayer(entityPlayer);
	}

	public void superOnCollideWithPlayer(Object entityPlayer) {
		if (base != null) base.superOnCollideWithPlayer((EntityPlayer) entityPlayer);
		else super.onCollideWithPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		if (master != null) master.applyEntityCollision(entity);
		else super.applyEntityCollision(entity);
	}

	public void superApplyEntityCollision(Object entity) {
		if (base != null) base.superApplyEntityCollision((Entity) entity);
		else super.applyEntityCollision((Entity) entity);
	}

	@Override
	public void addVelocity(double par1, double par3, double par5) {
		if (master != null) master.addVelocity(par1, par3, par5);
		else super.addVelocity(par1, par3, par5);
	}

	public void superAddVelocity(double par1, double par3, double par5) {
		if (base != null) base.superAddVelocity(par1, par3, par5);
		else super.addVelocity(par1, par3, par5);
	}

	@Override
	public void addToPlayerScore(Entity entity, int par2) {
		if (master != null) master.addToPlayerScore(entity, par2);
		else super.addToPlayerScore(entity, par2);
	}

	public void superAddToPlayerScore(Object entity, int par2) {
		if (base != null) base.superAddToPlayerScore((Entity) entity, par2);
		else super.addToPlayerScore((Entity) entity, par2);
	}

	@Override
	public boolean isInRangeToRenderDist(double par1) {
		return master != null ? master.isInRangeToRenderDist(par1) : super.isInRangeToRenderDist(par1);
	}

	public boolean superIsInRangeToRenderDist(double par1) {
		return base != null ? base.superIsInRangeToRenderDist(par1) : super.isInRangeToRenderDist(par1);
	}

	@Override
	public boolean writeMountToNBT(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeMountToNBT(nBTTagCompound) : super.writeMountToNBT(nBTTagCompound);
	}

	public boolean superWriteMountToNBT(Object nBTTagCompound) {
		return base != null ? base.superWriteMountToNBT((NBTTagCompound) nBTTagCompound) : super.writeMountToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTOptional(nBTTagCompound) : super.writeToNBTOptional(nBTTagCompound);
	}

	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return base != null ? base.superWriteToNBTOptional((NBTTagCompound) nBTTagCompound) : super.writeToNBTOptional((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}

	public void superWriteToNBT(Object nBTTagCompound) {
		if (base != null) base.superWriteToNBT((NBTTagCompound) nBTTagCompound);
		else super.writeToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}

	public void superReadFromNBT(Object nBTTagCompound) {
		if (base != null) base.superReadFromNBT((NBTTagCompound) nBTTagCompound);
		else super.readFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected boolean shouldSetPosAfterLoading() {
		return master != null ? master.shouldSetPosAfterLoading() : super.shouldSetPosAfterLoading();
	}

	public boolean superShouldSetPosAfterLoading() {
		return base != null ? base.superShouldSetPosAfterLoading() : super.shouldSetPosAfterLoading();
	}

	@Override
	public void onChunkLoad() {
		if (master != null) master.onChunkLoad();
		else super.onChunkLoad();
	}

	public void superOnChunkLoad() {
		if (base != null) base.superOnChunkLoad();
		else super.onChunkLoad();
	}

	@Override
	protected NBTTagList newDoubleNBTList(double... par1ArrayOfDouble) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(par1ArrayOfDouble) : super.newDoubleNBTList(par1ArrayOfDouble));
	}

	public NBTTagList superNewDoubleNBTList(double... par1ArrayOfDouble) {
		return base != null ? base.superNewDoubleNBTList(par1ArrayOfDouble) : super.newDoubleNBTList(par1ArrayOfDouble);
	}

	@Override
	protected NBTTagList newFloatNBTList(float... par1ArrayOfFloat) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(par1ArrayOfFloat) : super.newFloatNBTList(par1ArrayOfFloat));
	}

	public NBTTagList superNewFloatNBTList(float... par1ArrayOfFloat) {
		return base != null ? base.superNewFloatNBTList(par1ArrayOfFloat) : super.newFloatNBTList(par1ArrayOfFloat);
	}

	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float par2) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, par2) : super.entityDropItem(itemStack, par2));
	}

	public EntityItem superEntityDropItem(Object itemStack, float par2) {
		return base != null ? base.superEntityDropItem((ItemStack) itemStack, par2) : super.entityDropItem((ItemStack) itemStack, par2);
	}

	@Override
	public float getShadowSize() {
		return master != null ? master.getShadowSize() : super.getShadowSize();
	}

	public float superGetShadowSize() {
		return base != null ? base.superGetShadowSize() : super.getShadowSize();
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return master != null ? master.isEntityInsideOpaqueBlock() : super.isEntityInsideOpaqueBlock();
	}

	public boolean superIsEntityInsideOpaqueBlock() {
		return base != null ? base.superIsEntityInsideOpaqueBlock() : super.isEntityInsideOpaqueBlock();
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBox(entity) : super.getCollisionBox(entity));
	}

	public AxisAlignedBB superGetCollisionBox(Object entity) {
		return base != null ? base.superGetCollisionBox((Entity) entity) : super.getCollisionBox((Entity) entity);
	}

	@Override
	public void updateRiderPosition() {
		if (master != null) master.updateRiderPosition();
		else super.updateRiderPosition();
	}

	public void superUpdateRiderPosition() {
		if (base != null) base.superUpdateRiderPosition();
		else super.updateRiderPosition();
	}

	@Override
	public double getYOffset() {
		return master != null ? master.getYOffset() : super.getYOffset();
	}

	public double superGetYOffset() {
		return base != null ? base.superGetYOffset() : super.getYOffset();
	}

	@Override
	public double getMountedYOffset() {
		return master != null ? master.getMountedYOffset() : super.getMountedYOffset();
	}

	public double superGetMountedYOffset() {
		return base != null ? base.superGetMountedYOffset() : super.getMountedYOffset();
	}

	@Override
	public void mountEntity(Entity entity) {
		if (master != null) master.mountEntity(entity);
		else super.mountEntity(entity);
	}

	public void superMountEntity(Object entity) {
		if (base != null) base.superMountEntity((Entity) entity);
		else super.mountEntity((Entity) entity);
	}

	@Override
	public float getCollisionBorderSize() {
		return master != null ? master.getCollisionBorderSize() : super.getCollisionBorderSize();
	}

	public float superGetCollisionBorderSize() {
		return base != null ? base.superGetCollisionBorderSize() : super.getCollisionBorderSize();
	}

	@Override
	public void setInPortal() {
		if (master != null) master.setInPortal();
		else super.setInPortal();
	}

	public void superSetInPortal() {
		if (base != null) base.superSetInPortal();
		else super.setInPortal();
	}

	@Override
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}

	public int superGetPortalCooldown() {
		return base != null ? base.superGetPortalCooldown() : super.getPortalCooldown();
	}

	@Override
	public void setVelocity(double par1, double par3, double par5) {
		if (master != null) master.setVelocity(par1, par3, par5);
		else super.setVelocity(par1, par3, par5);
	}

	public void superSetVelocity(double par1, double par3, double par5) {
		if (base != null) base.superSetVelocity(par1, par3, par5);
		else super.setVelocity(par1, par3, par5);
	}

	@Override
	public boolean isBurning() {
		return master != null ? master.isBurning() : super.isBurning();
	}

	public boolean superIsBurning() {
		return base != null ? base.superIsBurning() : super.isBurning();
	}

	@Override
	public boolean isRiding() {
		return master != null ? master.isRiding() : super.isRiding();
	}

	public boolean superIsRiding() {
		return base != null ? base.superIsRiding() : super.isRiding();
	}

	@Override
	public boolean isSneaking() {
		return master != null ? master.isSneaking() : super.isSneaking();
	}

	public boolean superIsSneaking() {
		return base != null ? base.superIsSneaking() : super.isSneaking();
	}

	@Override
	public void setSneaking(boolean par1) {
		if (master != null) master.setSneaking(par1);
		else super.setSneaking(par1);
	}

	public void superSetSneaking(boolean par1) {
		if (base != null) base.superSetSneaking(par1);
		else super.setSneaking(par1);
	}

	@Override
	public boolean isSprinting() {
		return master != null ? master.isSprinting() : super.isSprinting();
	}

	public boolean superIsSprinting() {
		return base != null ? base.superIsSprinting() : super.isSprinting();
	}

	@Override
	public boolean isInvisible() {
		return master != null ? master.isInvisible() : super.isInvisible();
	}

	public boolean superIsInvisible() {
		return base != null ? base.superIsInvisible() : super.isInvisible();
	}

	@Override
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}

	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return base != null ? base.superIsInvisibleToPlayer((EntityPlayer) entityPlayer) : super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void setInvisible(boolean par1) {
		if (master != null) master.setInvisible(par1);
		else super.setInvisible(par1);
	}

	public void superSetInvisible(boolean par1) {
		if (base != null) base.superSetInvisible(par1);
		else super.setInvisible(par1);
	}

	@Override
	public boolean isEating() {
		return master != null ? master.isEating() : super.isEating();
	}

	public boolean superIsEating() {
		return base != null ? base.superIsEating() : super.isEating();
	}

	@Override
	public void setEating(boolean par1) {
		if (master != null) master.setEating(par1);
		else super.setEating(par1);
	}

	public void superSetEating(boolean par1) {
		if (base != null) base.superSetEating(par1);
		else super.setEating(par1);
	}

	@Override
	protected boolean getFlag(int par1) {
		return master != null ? master.getFlag(par1) : super.getFlag(par1);
	}

	public boolean superGetFlag(int par1) {
		return base != null ? base.superGetFlag(par1) : super.getFlag(par1);
	}

	@Override
	protected void setFlag(int par1, boolean par2) {
		if (master != null) master.setFlag(par1, par2);
		else super.setFlag(par1, par2);
	}

	public void superSetFlag(int par1, boolean par2) {
		if (base != null) base.superSetFlag(par1, par2);
		else super.setFlag(par1, par2);
	}

	@Override
	public int getAir() {
		return master != null ? master.getAir() : super.getAir();
	}

	public int superGetAir() {
		return base != null ? base.superGetAir() : super.getAir();
	}

	@Override
	public void setAir(int par1) {
		if (master != null) master.setAir(par1);
		else super.setAir(par1);
	}

	public void superSetAir(int par1) {
		if (base != null) base.superSetAir(par1);
		else super.setAir(par1);
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		if (master != null) master.onStruckByLightning(entityLightningBolt);
		else super.onStruckByLightning(entityLightningBolt);
	}

	public void superOnStruckByLightning(Object entityLightningBolt) {
		if (base != null) base.superOnStruckByLightning((EntityLightningBolt) entityLightningBolt);
		else super.onStruckByLightning((EntityLightningBolt) entityLightningBolt);
	}

	@Override
	public void onKillEntity(EntityLivingBase entityLivingBase) {
		if (master != null) master.onKillEntity(entityLivingBase);
		else super.onKillEntity(entityLivingBase);
	}

	public void superOnKillEntity(Object entityLivingBase) {
		if (base != null) base.superOnKillEntity((EntityLivingBase) entityLivingBase);
		else super.onKillEntity((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void setInWeb() {
		if (master != null) master.setInWeb();
		else super.setInWeb();
	}

	public void superSetInWeb() {
		if (base != null) base.superSetInWeb();
		else super.setInWeb();
	}

	@Override
	public Entity[] getParts() {
		return (Entity[]) (master != null ? master.getParts() : super.getParts());
	}

	public Entity[] superGetParts() {
		return base != null ? base.superGetParts() : super.getParts();
	}

	@Override
	public boolean isEntityEqual(Entity entity) {
		return master != null ? master.isEntityEqual(entity) : super.isEntityEqual(entity);
	}

	public boolean superIsEntityEqual(Object entity) {
		return base != null ? base.superIsEntityEqual((Entity) entity) : super.isEntityEqual((Entity) entity);
	}

	@Override
	public boolean canAttackWithItem() {
		return master != null ? master.canAttackWithItem() : super.canAttackWithItem();
	}

	public boolean superCanAttackWithItem() {
		return base != null ? base.superCanAttackWithItem() : super.canAttackWithItem();
	}

	@Override
	public boolean hitByEntity(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.hitByEntity(entity);
	}

	public boolean superHitByEntity(Object entity) {
		return base != null ? base.superHitByEntity((Entity) entity) : super.hitByEntity((Entity) entity);
	}

	@Override
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}

	public String superToString() {
		return base != null ? base.superToString() : super.toString();
	}

	@Override
	public boolean isEntityInvulnerable() {
		return master != null ? master.isEntityInvulnerable() : super.isEntityInvulnerable();
	}

	public boolean superIsEntityInvulnerable() {
		return base != null ? base.superIsEntityInvulnerable() : super.isEntityInvulnerable();
	}

	@Override
	public void copyLocationAndAnglesFrom(Entity entity) {
		if (master != null) master.copyLocationAndAnglesFrom(entity);
		else super.copyLocationAndAnglesFrom(entity);
	}

	public void superCopyLocationAndAnglesFrom(Object entity) {
		if (base != null) base.superCopyLocationAndAnglesFrom((Entity) entity);
		else super.copyLocationAndAnglesFrom((Entity) entity);
	}

	@Override
	public void copyDataFrom(Entity entity, boolean par2) {
		if (master != null) master.copyDataFrom(entity, par2);
		else super.copyDataFrom(entity, par2);
	}

	public void superCopyDataFrom(Object entity, boolean par2) {
		if (base != null) base.superCopyDataFrom((Entity) entity, par2);
		else super.copyDataFrom((Entity) entity, par2);
	}

	@Override
	public void travelToDimension(int par1) {
		if (master != null) master.travelToDimension(par1);
		else super.travelToDimension(par1);
	}

	public void superTravelToDimension(int par1) {
		if (base != null) base.superTravelToDimension(par1);
		else super.travelToDimension(par1);
	}

	@Override
	public int getTeleportDirection() {
		return master != null ? master.getTeleportDirection() : super.getTeleportDirection();
	}

	public int superGetTeleportDirection() {
		return base != null ? base.superGetTeleportDirection() : super.getTeleportDirection();
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return master != null ? master.doesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}

	public boolean superDoesEntityNotTriggerPressurePlate() {
		return base != null ? base.superDoesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}

	@Override
	public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
		if (master != null) master.addEntityCrashInfo(crashReportCategory);
		else super.addEntityCrashInfo(crashReportCategory);
	}

	public void superAddEntityCrashInfo(Object crashReportCategory) {
		if (base != null) base.superAddEntityCrashInfo((CrashReportCategory) crashReportCategory);
		else super.addEntityCrashInfo((CrashReportCategory) crashReportCategory);
	}

	@Override
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}

	public boolean superCanRenderOnFire() {
		return base != null ? base.superCanRenderOnFire() : super.canRenderOnFire();
	}

	@Override
	public UUID getUniqueID() {
		return master != null ? master.getUniqueID() : super.getUniqueID();
	}

	public UUID superGetUniqueID() {
		return base != null ? base.superGetUniqueID() : super.getUniqueID();
	}

	@Override
	public boolean isPushedByWater() {
		return master != null ? master.isPushedByWater() : super.isPushedByWater();
	}

	public boolean superIsPushedByWater() {
		return base != null ? base.superIsPushedByWater() : super.isPushedByWater();
	}

	@Override
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (master != null ? master.getEntityData() : super.getEntityData());
	}

	public NBTTagCompound superGetEntityData() {
		return base != null ? base.superGetEntityData() : super.getEntityData();
	}

	@Override
	public boolean shouldRiderSit() {
		return master != null ? master.shouldRiderSit() : super.shouldRiderSit();
	}

	public boolean superShouldRiderSit() {
		return base != null ? base.superShouldRiderSit() : super.shouldRiderSit();
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return (ItemStack) (master != null ? master.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}

	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return base != null ? base.superGetPickedResult((MovingObjectPosition) movingObjectPosition) : super.getPickedResult((MovingObjectPosition) movingObjectPosition);
	}

	@Override
	public UUID getPersistentID() {
		return master != null ? master.getPersistentID() : super.getPersistentID();
	}

	public UUID superGetPersistentID() {
		return base != null ? base.superGetPersistentID() : super.getPersistentID();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}

	public boolean superShouldRenderInPass(int pass) {
		return base != null ? base.superShouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}

	@Override
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return master != null ? master.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}

	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return base != null ? base.superIsCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount) : super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}

	@Override
	public String registerExtendedProperties(String identifier, IExtendedEntityProperties iExtendedEntityProperties) {
		return master != null ? master.registerExtendedProperties(identifier, iExtendedEntityProperties) : super.registerExtendedProperties(identifier, iExtendedEntityProperties);
	}

	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return base != null ? base.superRegisterExtendedProperties(identifier, (IExtendedEntityProperties) iExtendedEntityProperties) : super.registerExtendedProperties(identifier, (IExtendedEntityProperties) iExtendedEntityProperties);
	}

	@Override
	public IExtendedEntityProperties getExtendedProperties(String identifier) {
		return (IExtendedEntityProperties) (master != null ? master.getExtendedProperties(identifier) : super.getExtendedProperties(identifier));
	}

	public IExtendedEntityProperties superGetExtendedProperties(String identifier) {
		return base != null ? base.superGetExtendedProperties(identifier) : super.getExtendedProperties(identifier);
	}

	@Override
	public boolean canRiderInteract() {
		return master != null ? master.canRiderInteract() : super.canRiderInteract();
	}

	public boolean superCanRiderInteract() {
		return base != null ? base.superCanRiderInteract() : super.canRiderInteract();
	}

	@Override
	public boolean shouldDismountInWater(Entity entity) {
		return master != null ? master.shouldDismountInWater(entity) : super.shouldDismountInWater(entity);
	}

	public boolean superShouldDismountInWater(Object entity) {
		return base != null ? base.superShouldDismountInWater((Entity) entity) : super.shouldDismountInWater((Entity) entity);
	}

	// ~172
	@Override
	public EntityLivingBase getOwner() {
		return (EntityLivingBase) (master != null ? master.getOwner() : super.getOwner());
	}

	public EntityLivingBase superGetOwner() {
		return base != null ? base.superGetOwner() : super.getOwner();
	}

	@Override
	public void func_146082_f(EntityPlayer entityPlayer) {
		if (master != null) master.func_146082_f(entityPlayer);
		else super.func_146082_f(entityPlayer);
	}

	public void superFunc_146082_f(Object entityPlayer) {
		if (base != null) base.superFunc_146082_f((EntityPlayer) entityPlayer);
		else super.func_146082_f((EntityPlayer) entityPlayer);
	}

	@Override
	public EntityPlayer func_146083_cb() {
		return (EntityPlayer) (master != null ? master.func_146083_cb() : super.func_146083_cb());
	}

	public EntityPlayer superFunc_146083_cb() {
		return base != null ? base.superFunc_146083_cb() : super.func_146083_cb();
	}

	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return master != null ? master.isWithinHomeDistanceCurrentPosition() : super.isWithinHomeDistanceCurrentPosition();
	}

	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return base != null ? base.superIsWithinHomeDistanceCurrentPosition() : super.isWithinHomeDistanceCurrentPosition();
	}

	@Override
	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return master != null ? master.isWithinHomeDistance(par1, par2, par3) : super.isWithinHomeDistance(par1, par2, par3);
	}

	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return base != null ? base.superIsWithinHomeDistance(par1, par2, par3) : super.isWithinHomeDistance(par1, par2, par3);
	}

	@Override
	protected void updateLeashedState() {
		if (master != null) master.updateLeashedState();
		else super.updateLeashedState();
	}

	public void superUpdateLeashedState() {
		if (base != null) base.superUpdateLeashedState();
		else super.updateLeashedState();
	}

	@Override
	protected Item getDropItem() {
		return (Item) (master != null ? master.getDropItem() : super.getDropItem());
	}

	public Item superGetDropItem() {
		return base != null ? base.superGetDropItem() : super.getDropItem();
	}

	@Override
	public ItemStack getEquipmentInSlot(int par1) {
		return (ItemStack) (master != null ? master.getEquipmentInSlot(par1) : super.getEquipmentInSlot(par1));
	}

	public ItemStack superGetEquipmentInSlot(int par1) {
		return base != null ? base.superGetEquipmentInSlot(par1) : super.getEquipmentInSlot(par1);
	}

	@Override
	public String getCommandSenderName() {
		return master != null ? master.getCommandSenderName() : super.getCommandSenderName();
	}

	public String superGetCommandSenderName() {
		return base != null ? base.superGetCommandSenderName() : super.getCommandSenderName();
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData iEntityLivingData) {
		return (IEntityLivingData) (master != null ? master.onSpawnWithEgg(iEntityLivingData) : super.onSpawnWithEgg(iEntityLivingData));
	}

	public IEntityLivingData superOnSpawnWithEgg(Object iEntityLivingData) {
		return base != null ? base.superOnSpawnWithEgg((IEntityLivingData) iEntityLivingData) : super.onSpawnWithEgg((IEntityLivingData) iEntityLivingData);
	}

	@Override
	protected boolean func_146066_aG() {
		return master != null ? master.func_146066_aG() : super.func_146066_aG();
	}

	public boolean superFunc_146066_aG() {
		return base != null ? base.superFunc_146066_aG() : super.func_146066_aG();
	}

	@Override
	protected String func_146067_o(int p_146067_1_) {
		return master != null ? master.func_146067_o(p_146067_1_) : super.func_146067_o(p_146067_1_);
	}

	public String superFunc_146067_o(int p_146067_1_) {
		return base != null ? base.superFunc_146067_o(p_146067_1_) : super.func_146067_o(p_146067_1_);
	}

	@Override
	public IAttributeInstance getEntityAttribute(IAttribute iAttribute) {
		return (IAttributeInstance) (master != null ? master.getEntityAttribute(iAttribute) : super.getEntityAttribute(iAttribute));
	}

	public IAttributeInstance superGetEntityAttribute(Object iAttribute) {
		return base != null ? base.superGetEntityAttribute((IAttribute) iAttribute) : super.getEntityAttribute((IAttribute) iAttribute);
	}

	@Override
	public IIcon getItemIcon(ItemStack itemStack, int par2) {
		return (IIcon) (master != null ? master.getItemIcon(itemStack, par2) : super.getItemIcon(itemStack, par2));
	}

	public IIcon superGetItemIcon(Object itemStack, int par2) {
		return base != null ? base.superGetItemIcon((ItemStack) itemStack, par2) : super.getItemIcon((ItemStack) itemStack, par2);
	}

	@Override
	public int getEntityId() {
		return master != null ? master.getEntityId() : super.getEntityId();
	}

	public int superGetEntityId() {
		return base != null ? base.superGetEntityId() : super.getEntityId();
	}

	@Override
	public void setEntityId(int p_145769_1_) {
		if (master != null) master.setEntityId(p_145769_1_);
		else super.setEntityId(p_145769_1_);
	}

	public void superSetEntityId(int p_145769_1_) {
		if (base != null) base.superSetEntityId(p_145769_1_);
		else super.setEntityId(p_145769_1_);
	}

	@Override
	protected String getSwimSound() {
		return master != null ? master.getSwimSound() : super.getSwimSound();
	}

	public String superGetSwimSound() {
		return base != null ? base.superGetSwimSound() : super.getSwimSound();
	}

	@Override
	protected void func_145775_I() {
		if (master != null) master.func_145775_I();
		else super.func_145775_I();
	}

	public void superFunc_145775_I() {
		if (base != null) base.superFunc_145775_I();
		else super.func_145775_I();
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block block) {
		if (master != null) master.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, block);
		else super.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, block);
	}

	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
		if (base != null) base.superFunc_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, (Block) block);
		else super.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, (Block) block);
	}

	@Override
	protected String getSplashSound() {
		return master != null ? master.getSplashSound() : super.getSplashSound();
	}

	public String superGetSplashSound() {
		return base != null ? base.superGetSplashSound() : super.getSplashSound();
	}

	@Override
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return master != null ? master.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_) : super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return base != null ? base.superIsInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_) : super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	@Override
	public EntityItem dropItem(Item item, int p_145779_2_) {
		return (EntityItem) (master != null ? master.dropItem(item, p_145779_2_) : super.dropItem(item, p_145779_2_));
	}

	public EntityItem superDropItem(Object item, int p_145779_2_) {
		return base != null ? base.superDropItem((Item) item, p_145779_2_) : super.dropItem((Item) item, p_145779_2_);
	}

	@Override
	public EntityItem func_145778_a(Item item, int p_145778_2_, float p_145778_3_) {
		return (EntityItem) (master != null ? master.func_145778_a(item, p_145778_2_, p_145778_3_) : super.func_145778_a(item, p_145778_2_, p_145778_3_));
	}

	public EntityItem superFunc_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return base != null ? base.superFunc_145778_a((Item) item, p_145778_2_, p_145778_3_) : super.func_145778_a((Item) item, p_145778_2_, p_145778_3_);
	}

	@Override
	protected boolean func_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return master != null ? master.func_145771_j(p_145771_1_, p_145771_3_, p_145771_5_) : super.func_145771_j(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	public boolean superFunc_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return base != null ? base.superFunc_145771_j(p_145771_1_, p_145771_3_, p_145771_5_) : super.func_145771_j(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	@Override
	public float func_145772_a(Explosion explosion, World world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block block) {
		return master != null ? master.func_145772_a(explosion, world, p_145772_3_, p_145772_4_, p_145772_5_, block) : super.func_145772_a(explosion, world, p_145772_3_, p_145772_4_, p_145772_5_, block);
	}

	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return base != null ? base.superFunc_145772_a((Explosion) explosion, (World) world, p_145772_3_, p_145772_4_, p_145772_5_, (Block) block) : super.func_145772_a((Explosion) explosion, (World) world, p_145772_3_, p_145772_4_, p_145772_5_, (Block) block);
	}

	@Override
	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return master != null ? master.func_145774_a(explosion, world, p_145774_3_, p_145774_4_, p_145774_5_, block, p_145774_7_) : super.func_145774_a(explosion, world, p_145774_3_, p_145774_4_, p_145774_5_, block, p_145774_7_);
	}

	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return base != null ? base.superFunc_145774_a((Explosion) explosion, (World) world, p_145774_3_, p_145774_4_, p_145774_5_, (Block) block, p_145774_7_) : super.func_145774_a((Explosion) explosion, (World) world, p_145774_3_, p_145774_4_, p_145774_5_, (Block) block, p_145774_7_);
	}

	@Override
	public IChatComponent func_145748_c_() {
		return (IChatComponent) (master != null ? master.func_145748_c_() : super.func_145748_c_());
	}

	public IChatComponent superFunc_145748_c_() {
		return base != null ? base.superFunc_145748_c_() : super.func_145748_c_();
	}

	@Override
	public void func_145781_i(int p_145781_1_) {
		if (master != null) master.func_145781_i(p_145781_1_);
		else super.func_145781_i(p_145781_1_);
	}

	public void superFunc_145781_i(int p_145781_1_) {
		if (base != null) base.superFunc_145781_i(p_145781_1_);
		else super.func_145781_i(p_145781_1_);
	}
}
