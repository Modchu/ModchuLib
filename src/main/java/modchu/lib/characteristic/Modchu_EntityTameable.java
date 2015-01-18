package modchu.lib.characteristic;

import java.util.Collection;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameableMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
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
import net.minecraft.util.BlockPos;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import scala.collection.mutable.StringBuilder;

public class Modchu_EntityTameable extends EntityTameable {

	public Modchu_IEntityTameableMaster master;
	public String entityName;
	public static ConcurrentHashMap<String, UUID> entityUniqueIDMap = new ConcurrentHashMap();

	public Modchu_EntityTameable(World world) {
		super(world);
		Modchu_Debug.mDebug("Modchu_EntityTameable init");
	}

	public Modchu_EntityTameable(Class masterClass, Object world) {
		super((World) world);
		if (masterClass != null) ;else {
			Modchu_Debug.Debug("Modchu_EntityTameable init error masterClass == null !!");
			return;
		}
		init(masterClass.getName());
	}

	public void setMovementSpeed(double d) {
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(d);
	}

	public void setMaxHealth(double d) {
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(d);
	}

	public Object getMaster() {
		//Modchu_Debug.mDebug("getmasterEntity masterEntity="+masterEntity);
		if (master != null) ;else {
			init(entityName);
		}
		return master;
	}

	public Object getFreeVariable(String s) {
		return master.getFreeVariable(s);
	}

	public void setFreeVariable(String s, Object o) {
		master.setFreeVariable(s, o);
	}

	private void init(String s) {
		if (s != null
				&& !s.isEmpty()); else {
			Class c = Modchu_Main.getSpownEntityClass(worldObj, posX, posY, posZ);
			if (c != null) {
				s = c.getName();
			}
		}
		master = (modchu.lib.Modchu_IEntityTameableMaster) Modchu_Reflect.newInstance(s, new Class[]{ Modchu_EntityTameable.class, Object[].class }, new Object[]{ this, new Object[]{ worldObj } });
		entityName = s;
		Modchu_Debug.mDebug("initNBTAfter entityName="+(entityName != null ? entityName : "null !!"));
		String s0 = new StringBuilder(Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, this) ? "1" : "0").append(entityUniqueID).toString();
		if (entityUniqueIDMap.containsKey(s0)) {
			Modchu_Debug.mDebug("initNBTAfter entityUniqueIDMap.containsKey isDead entityUniqueID="+entityUniqueID);
			Modchu_AS.set(Modchu_AS.entityLivingBaseSetHealth, this, 0.0F);
			deathTime = 20;
			setDead();
			return;
		}
		entityUniqueIDMap.put(s0, entityUniqueID);
		Modchu_Debug.mDebug("initNBTAfter entityUniqueID="+entityUniqueID);
		Modchu_Debug.mDebug("initNBTAfter masterEntity="+master);
	}

	public static void worldEventLoad(Object event) {
		if (entityUniqueIDMap != null) entityUniqueIDMap.clear();
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
		super.entityInit();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (entityName != null
				&& !entityName.isEmpty()) {
			nBTTagCompound.setString("entityName", entityName);
			if (master != null) master.writeEntityToNBT(nBTTagCompound);
			else super.writeEntityToNBT(nBTTagCompound);
		}
		//Modchu_Debug.mDebug("writeEntityToNBT entityName="+entityName);
	}

	public void superWriteEntityToNBT(Object nBTTagCompound) {
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		//Modchu_Debug.mDebug("readEntityFromNBT entityName="+entityName);
		String s = nBTTagCompound.getString("entityName");
		//Modchu_Debug.mDebug("readEntityFromNBT s="+s);
		init(s);
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}

	public void superReadEntityFromNBT(Object nBTTagCompound) {
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected void playTameEffect(boolean par1) {
		if (master != null) master.playTameEffect(par1);
		else super.playTameEffect(par1);
	}

	public void superPlayTameEffect(boolean par1) {
		super.playTameEffect(par1);
	}

	@Override
	public void handleHealthUpdate(byte par1) {
		if (master != null) master.handleHealthUpdate(par1);
		else super.handleHealthUpdate(par1);
	}

	public void superHandleHealthUpdate(byte par1) {
		super.handleHealthUpdate(par1);
	}

	@Override
	public boolean isTamed() {
		return master != null ? master.isTamed() : super.isTamed();
	}

	public boolean superIsTamed() {
		return super.isTamed();
	}

	@Override
	public void setTamed(boolean par1) {
		if (master != null) master.setTamed(par1);
		else super.setTamed(par1);
	}

	public void superSetTamed(boolean par1) {
		super.setTamed(par1);
	}

	@Override
	public boolean isSitting() {
		return master != null ? master.isSitting() : super.isSitting();
	}

	public boolean superIsSitting() {
		return super.isSitting();
	}

	@Override
	public void setSitting(boolean par1) {
		if (master != null) master.setSitting(par1);
		else super.setSitting(par1);
	}

	public void superSetSitting(boolean par1) {
		super.setSitting(par1);
	}

	@Override
	public String getOwnerId() {
		return master != null ? master.getOwnerName() : super.getOwnerId();
	}

	public String superGetOwnerName() {
		return super.getOwnerId();
	}

	@Override
	public void setOwnerId(String par1Str) {
		if (master != null) master.setOwner(par1Str);
		else super.setOwnerId(par1Str);
	}

	public void superSetOwner(String par1Str) {
		super.setOwnerId(par1Str);
	}

	@Override
	public EntityAISit getAISit() {
		return (EntityAISit) (master != null ? master.getAISit() : super.getAISit());
	}

	public EntityAISit superGetAISit() {
		return super.getAISit();
	}

	@Override
	public boolean func_142018_a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
		return master != null ? master.func_142018_a(entityLivingBase, entityLivingBase1) : super.func_142018_a(entityLivingBase, entityLivingBase1);
	}

	public boolean superFunc_142018_a(Object entityLivingBase, Object entityLivingBase1) {
		return super.func_142018_a((EntityLivingBase) entityLivingBase, (EntityLivingBase) entityLivingBase1);
	}

	@Override
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}

	public Team superGetTeam() {
		return super.getTeam();
	}

	@Override
	public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOnSameTeam(entityLivingBase) : super.isOnSameTeam(entityLivingBase);
	}

	public boolean superIsOnSameTeam(Object entityLivingBase) {
		return super.isOnSameTeam((EntityLivingBase) entityLivingBase);
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
	public void onLivingUpdate() {
		//Modchu_Debug.mDebug("onLivingUpdate masterEntity="+masterEntity);
		//Modchu_Debug.mDebug("onLivingUpdate entityName="+entityName);
		//Modchu_Debug.mDebug("onLivingUpdate posX="+posX+" posY="+posY+" posZ="+posZ);
		if (master != null
				&& entityName != null) ;else {
			init(null);
			if (master != null) ;else {
				setDead();
			}
		}
		if (master != null) master.onLivingUpdate();
		else super.onLivingUpdate();
	}

	public void superOnLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float par2) {
		return master != null ? master.attackEntityFrom(damageSource, par2) : super.attackEntityFrom(damageSource, par2);
	}

	public boolean superAttackEntityFrom(Object damageSource, float par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
	}

	@Override
	public boolean getCanSpawnHere() {
		return master != null ? master.getCanSpawnHere() : super.getCanSpawnHere();
	}

	public boolean superGetCanSpawnHere() {
		return super.getCanSpawnHere();
	}

	@Override
	public int getTalkInterval() {
		return master != null ? master.getTalkInterval() : super.getTalkInterval();
	}

	public int superGetTalkInterval() {
		return super.getTalkInterval();
	}

	@Override
	protected boolean canDespawn() {
		return master != null ? master.canDespawn() : super.canDespawn();
	}

	public boolean superCanDespawn() {
		return super.canDespawn();
	}

	@Override
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return master != null ? master.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}

	public int superGetExperiencePoints(Object entityPlayer) {
		return super.getExperiencePoints((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isBreedingItem(ItemStack itemStack) {
		return master != null ? master.isBreedingItem(itemStack) : super.isBreedingItem(itemStack);
	}

	public boolean superIsBreedingItem(Object itemStack) {
		return super.isBreedingItem((ItemStack) itemStack);
	}

	@Override
	public boolean interact(EntityPlayer entityPlayer) {
		return master != null ? master.interact(entityPlayer) : super.interact(entityPlayer);
	}

	public boolean superInteract(Object entityPlayer) {
		return super.interact((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isInLove() {
		return master != null ? master.isInLove() : super.isInLove();
	}

	public boolean superIsInLove() {
		return super.isInLove();
	}

	@Override
	public void resetInLove() {
		if (master != null) master.resetInLove();
		else super.resetInLove();
	}

	public void superResetInLove() {
		super.resetInLove();
	}

	@Override
	public boolean canMateWith(EntityAnimal entityAnimal) {
		return master != null ? master.canMateWith(entityAnimal) : super.canMateWith(entityAnimal);
	}

	public boolean superCanMateWith(Object entityAnimal) {
		return super.canMateWith((EntityAnimal) entityAnimal);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityAgeable) {
		return (EntityAgeable) (master != null ? master.createChild(entityAgeable) : null);
	}

	@Override
	public int getGrowingAge() {
		return master != null ? master.getGrowingAge() : super.getGrowingAge();
	}

	public int superGetGrowingAge() {
		return super.getGrowingAge();
	}

	@Override
	public void addGrowth(int par1) {
		if (master != null) master.addGrowth(par1);
		else super.addGrowth(par1);
	}

	public void superAddGrowth(int par1) {
		super.addGrowth(par1);
	}

	@Override
	public void setGrowingAge(int par1) {
		if (master != null) master.setGrowingAge(par1);
		else super.setGrowingAge(par1);
	}

	public void superSetGrowingAge(int par1) {
		super.setGrowingAge(par1);
	}

	@Override
	public boolean isChild() {
		return master != null ? master.isChild() : super.isChild();
	}

	public boolean superIsChild() {
		return super.isChild();
	}

	@Override
	public void setScaleForAge(boolean par1) {
		if (master != null) master.setScaleForAge(par1);
		else super.setScaleForAge(par1);
	}

	public void superSetScaleForAge(boolean par1) {
		super.setScaleForAge(par1);
	}

	@Override
	public boolean hasPath() {
		return master != null ? master.hasPath() : super.hasPath();
	}

	public boolean superHasPath() {
		return super.hasPath();
	}

	@Override
	public void detachHome() {
		if (master != null) master.detachHome();
		else super.detachHome();
	}

	public void superDetachHome() {
		super.detachHome();
	}

	@Override
	public boolean hasHome() {
		return master != null ? master.hasHome() : super.hasHome();
	}

	public boolean superHasHome() {
		return super.hasHome();
	}

	@Override
	protected void func_142017_o(float par1) {
		if (master != null) master.func_142017_o(par1);
		else super.func_142017_o(par1);
	}

	public void superFunc_142017_o(float par1) {
		super.func_142017_o(par1);
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
	public EntityLookHelper getLookHelper() {
		return (EntityLookHelper) (master != null ? master.getLookHelper() : super.getLookHelper());
	}

	public EntityLookHelper superGetLookHelper() {
		return super.getLookHelper();
	}

	@Override
	public EntityMoveHelper getMoveHelper() {
		return (EntityMoveHelper) (master != null ? master.getMoveHelper() : super.getMoveHelper());
	}

	public EntityMoveHelper superGetMoveHelper() {
		return super.getMoveHelper();
	}

	@Override
	public EntityJumpHelper getJumpHelper() {
		return (EntityJumpHelper) (master != null ? master.getJumpHelper() : super.getJumpHelper());
	}

	public EntityJumpHelper superGetJumpHelper() {
		return super.getJumpHelper();
	}

	@Override
	public PathNavigate getNavigator() {
		return (PathNavigate) (master != null ? master.getNavigator() : super.getNavigator());
	}

	public PathNavigate superGetNavigator() {
		return super.getNavigator();
	}

	@Override
	public EntitySenses getEntitySenses() {
		return (EntitySenses) (master != null ? master.getEntitySenses() : super.getEntitySenses());
	}

	public EntitySenses superGetEntitySenses() {
		return super.getEntitySenses();
	}

	@Override
	public EntityLivingBase getAttackTarget() {
		return (EntityLivingBase) (master != null ? master.getAttackTarget() : super.getAttackTarget());
	}

	public EntityLivingBase superGetAttackTarget() {
		return super.getAttackTarget();
	}

	@Override
	public void setAttackTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setAttackTarget(entityLivingBase);
		else super.setAttackTarget(entityLivingBase);
	}

	public void superSetAttackTarget(Object entityLivingBase) {
		super.setAttackTarget((EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean canAttackClass(Class c) {
		return master != null ? master.canAttackClass(c) : super.canAttackClass(c);
	}

	public boolean superCanAttackClass(Object c) {
		return super.canAttackClass((Class) c);
	}

	@Override
	public void eatGrassBonus() {
		if (master != null) master.eatGrassBonus();
		else super.eatGrassBonus();
	}

	public void superEatGrassBonus() {
		super.eatGrassBonus();
	}

	@Override
	public void playLivingSound() {
		if (master != null) master.playLivingSound();
		else super.playLivingSound();
	}

	public void superPlayLivingSound() {
		super.playLivingSound();
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
	public void spawnExplosionParticle() {
		if (master != null) master.spawnExplosionParticle();
		else super.spawnExplosionParticle();
	}

	public void superSpawnExplosionParticle() {
		super.spawnExplosionParticle();
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
	protected float func_110146_f(float par1, float par2) {
		return master != null ? master.func_110146_f(par1, par2) : super.func_110146_f(par1, par2);
	}

	public float superFunc_110146_f(float par1, float par2) {
		return super.func_110146_f(par1, par2);
	}

	@Override
	protected String getLivingSound() {
		return master != null ? master.getLivingSound() : super.getLivingSound();
	}

	public String superGetLivingSound() {
		return super.getLivingSound();
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		if (master != null) master.dropFewItems(par1, par2);
		else super.dropFewItems(par1, par2);
	}

	public void superDropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
	}

	@Override
	public void setMoveForward(float par1) {
		if (master != null) master.setMoveForward(par1);
		else super.setMoveForward(par1);
	}

	public void superSetMoveForward(float par1) {
		super.setMoveForward(par1);
	}

	@Override
	public void setAIMoveSpeed(float par1) {
		if (master != null) master.setAIMoveSpeed(par1);
		else super.setAIMoveSpeed(par1);
	}

	public void superSetAIMoveSpeed(float par1) {
		super.setAIMoveSpeed(par1);
	}

	@Override
	protected void despawnEntity() {
		if (master != null) master.despawnEntity();
		else super.despawnEntity();
	}

	public void superDespawnEntity() {
		super.despawnEntity();
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
	public int getVerticalFaceSpeed() {
		return master != null ? master.getVerticalFaceSpeed() : super.getVerticalFaceSpeed();
	}

	public int superGetVerticalFaceSpeed() {
		return super.getVerticalFaceSpeed();
	}

	@Override
	public void faceEntity(Entity entity, float par2, float par3) {
		if (master != null) master.faceEntity(entity, par2, par3);
		else super.faceEntity(entity, par2, par3);
	}

	public void superFaceEntity(Object entity, float par2, float par3) {
		super.faceEntity((Entity) entity, par2, par3);
	}

	@Override
	public float getRenderSizeModifier() {
		return master != null ? master.getRenderSizeModifier() : super.getRenderSizeModifier();
	}

	public float superGetRenderSizeModifier() {
		return super.getRenderSizeModifier();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return master != null ? master.getMaxSpawnedInChunk() : super.getMaxSpawnedInChunk();
	}

	public int superGetMaxSpawnedInChunk() {
		return super.getMaxSpawnedInChunk();
	}

	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}

	public ItemStack superGetHeldItem() {
		return super.getHeldItem();
	}

	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack itemStack) {
		if (master != null) master.setCurrentItemOrArmor(par1, itemStack);
		else super.setCurrentItemOrArmor(par1, itemStack);
	}

	public void superSetCurrentItemOrArmor(int par1, Object itemStack) {
		super.setCurrentItemOrArmor(par1, (ItemStack) itemStack);
	}

	@Override
	protected void dropEquipment(boolean par1, int par2) {
		if (master != null) master.dropEquipment(par1, par2);
		else super.dropEquipment(par1, par2);
	}

	public void superDropEquipment(boolean par1, int par2) {
		super.dropEquipment(par1, par2);
	}

	@Override
	protected void addRandomArmor() {
		if (master != null) master.addRandomArmor();
		else super.addRandomArmor();
	}

	public void superAddRandomArmor() {
		super.addRandomArmor();
	}

	@Override
	public boolean canBeSteered() {
		return master != null ? master.canBeSteered() : super.canBeSteered();
	}

	public boolean superCanBeSteered() {
		return super.canBeSteered();
	}

	@Override
	public void setCustomNameTag(String par1Str) {
		if (master != null) master.setCustomNameTag(par1Str);
		else super.setCustomNameTag(par1Str);
	}

	public void superSetCustomNameTag(String par1Str) {
		super.setCustomNameTag(par1Str);
	}

	@Override
	public String getCustomNameTag() {
		return master != null ? master.getCustomNameTag() : super.getCustomNameTag();
	}

	public String superGetCustomNameTag() {
		return super.getCustomNameTag();
	}

	@Override
	public boolean hasCustomName() {
		return master != null ? master.hasCustomNameTag() : super.hasCustomName();
	}

	public boolean superHasCustomName() {
		return super.hasCustomName();
	}

	@Override
	public void setAlwaysRenderNameTag(boolean par1) {
		if (master != null) master.setAlwaysRenderNameTag(par1);
		else super.setAlwaysRenderNameTag(par1);
	}

	public void superSetAlwaysRenderNameTag(boolean par1) {
		super.setAlwaysRenderNameTag(par1);
	}

	@Override
	public boolean getAlwaysRenderNameTag() {
		return master != null ? master.getAlwaysRenderNameTag() : super.getAlwaysRenderNameTag();
	}

	public boolean superGetAlwaysRenderNameTag() {
		return super.getAlwaysRenderNameTag();
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}

	public boolean superGetAlwaysRenderNameTagForRender() {
		return super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public void setEquipmentDropChance(int par1, float par2) {
		if (master != null) master.setEquipmentDropChance(par1, par2);
		else super.setEquipmentDropChance(par1, par2);
	}

	public void superSetEquipmentDropChance(int par1, float par2) {
		super.setEquipmentDropChance(par1, par2);
	}

	@Override
	public boolean canPickUpLoot() {
		return master != null ? master.canPickUpLoot() : super.canPickUpLoot();
	}

	public boolean superCanPickUpLoot() {
		return super.canPickUpLoot();
	}

	@Override
	public void setCanPickUpLoot(boolean par1) {
		if (master != null) master.setCanPickUpLoot(par1);
		else super.setCanPickUpLoot(par1);
	}

	public void superSetCanPickUpLoot(boolean par1) {
		super.setCanPickUpLoot(par1);
	}

	@Override
	public boolean isNoDespawnRequired() {
		return master != null ? master.isNoDespawnRequired() : super.isNoDespawnRequired();
	}

	public boolean superIsNoDespawnRequired() {
		return super.isNoDespawnRequired();
	}

	@Override
	public void clearLeashed(boolean par1, boolean par2) {
		if (master != null) master.clearLeashed(par1, par2);
		else super.clearLeashed(par1, par2);
	}

	public void superClearLeashed(boolean par1, boolean par2) {
		super.clearLeashed(par1, par2);
	}

	@Override
	public boolean allowLeashing() {
		return master != null ? master.allowLeashing() : super.allowLeashing();
	}

	public boolean superAllowLeashing() {
		return super.allowLeashing();
	}

	@Override
	public boolean getLeashed() {
		return master != null ? master.getLeashed() : super.getLeashed();
	}

	public boolean superGetLeashed() {
		return super.getLeashed();
	}

	@Override
	public Entity getLeashedToEntity() {
		return (Entity) (master != null ? master.getLeashedToEntity() : super.getLeashedToEntity());
	}

	public Entity superGetLeashedToEntity() {
		return super.getLeashedToEntity();
	}

	@Override
	public void setLeashedToEntity(Entity entity, boolean par2) {
		if (master != null) master.setLeashedToEntity(entity, par2);
		else super.setLeashedToEntity(entity, par2);
	}

	public void superSetLeashedToEntity(Object entity, boolean par2) {
		super.setLeashedToEntity((Entity) entity, par2);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}

	public boolean superCanBreatheUnderwater() {
		return super.canBreatheUnderwater();
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
	protected int decreaseAirSupply(int par1) {
		return master != null ? master.decreaseAirSupply(par1) : super.decreaseAirSupply(par1);
	}

	public int superDecreaseAirSupply(int par1) {
		return super.decreaseAirSupply(par1);
	}

	@Override
	protected boolean isPlayer() {
		return master != null ? master.isPlayer() : super.isPlayer();
	}

	public boolean superIsPlayer() {
		return super.isPlayer();
	}

	@Override
	public Random getRNG() {
		return (Random) (master != null ? master.getRNG() : super.getRNG());
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
	public boolean isPotionActive(int par1) {
		return master != null ? master.isPotionActive(par1) : super.isPotionActive(par1);
	}

	public boolean superIsPotionActive(int par1) {
		return super.isPotionActive(par1);
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
	public void removePotionEffectClient(int par1) {
		if (master != null) master.removePotionEffectClient(par1);
		else super.removePotionEffectClient(par1);
	}

	public void superRemovePotionEffectClient(int par1) {
		super.removePotionEffectClient(par1);
	}

	@Override
	public void removePotionEffect(int par1) {
		if (master != null) master.removePotionEffect(par1);
		else super.removePotionEffect(par1);
	}

	public void superRemovePotionEffect(int par1) {
		super.removePotionEffect(par1);
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
	protected void onChangedPotionEffect(PotionEffect potionEffect, boolean par2) {
		if (master != null) master.onChangedPotionEffect(potionEffect, par2);
		else super.onChangedPotionEffect(potionEffect, par2);
	}

	public void superOnChangedPotionEffect(Object potionEffect, boolean par2) {
		super.onChangedPotionEffect((PotionEffect) potionEffect, par2);
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
	public void heal(float par1) {
		if (master != null) master.heal(par1);
		else super.heal(par1);
	}

	public void superHeal(float par1) {
		super.heal(par1);
	}

	@Override
	public void setHealth(float par1) {
		if (master != null) master.setHealth(par1);
		else super.setHealth(par1);
	}

	public void superSetHealth(float par1) {
		super.setHealth(par1);
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
	public void onDeath(DamageSource damageSource) {
		if (master != null) master.onDeath(damageSource);
		else super.onDeath(damageSource);
	}

	public void superOnDeath(Object damageSource) {
		super.onDeath((DamageSource) damageSource);
	}

	@Override
	public void knockBack(Entity entity, float par2, double par3, double par5) {
		if (master != null) master.knockBack(entity, par2, par3, par5);
		else super.knockBack(entity, par2, par3, par5);
	}

	public void superKnockBack(Object entity, float par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
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
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}

	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}

	@Override
	protected void damageArmor(float par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}

	public void superDamageArmor(float par1) {
		super.damageArmor(par1);
	}

	@Override
	protected float applyArmorCalculations(DamageSource damageSource, float par2) {
		return master != null ? master.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2);
	}

	public float superApplyArmorCalculations(Object damageSource, float par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float par2) {
		return master != null ? master.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2);
	}

	public float superApplyPotionDamageCalculations(Object damageSource, float par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected void damageEntity(DamageSource damageSource, float par2) {
		if (master != null) master.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
	}

	public void superDamageEntity(Object damageSource, float par2) {
		super.damageEntity((DamageSource) damageSource, par2);
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
	public void setSprinting(boolean par1) {
		if (master != null) master.setSprinting(par1);
		else super.setSprinting(par1);
	}

	public void superSetSprinting(boolean par1) {
		super.setSprinting(par1);
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
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}

	public boolean superIsMovementBlocked() {
		return super.isMovementBlocked();
	}

	@Override
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		if (master != null) master.setPositionAndUpdate(par1, par3, par5);
		else super.setPositionAndUpdate(par1, par3, par5);
	}

	public void superSetPositionAndUpdate(double par1, double par3, double par5) {
		super.setPositionAndUpdate(par1, par3, par5);
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
	protected void jump() {
		if (master != null) master.jump();
		else super.jump();
	}

	public void superJump() {
		super.jump();
	}

	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		if (master != null) master.moveEntityWithHeading(par1, par2);
		else super.moveEntityWithHeading(par1, par2);
	}

	public void superMoveEntityWithHeading(float par1, float par2) {
		super.moveEntityWithHeading(par1, par2);
	}

	@Override
	public float getAIMoveSpeed() {
		return master != null ? master.getAIMoveSpeed() : super.getAIMoveSpeed();
	}

	public float superGetAIMoveSpeed() {
		return super.getAIMoveSpeed();
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return master != null ? master.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}

	public boolean superAttackEntityAsMob(Object entity) {
		return super.attackEntityAsMob((Entity) entity);
	}

	@Override
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}

	public boolean superIsPlayerSleeping() {
		return super.isPlayerSleeping();
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
	public void updateRidden() {
		if (master != null) master.updateRidden();
		else super.updateRidden();
	}

	public void superUpdateRidden() {
		super.updateRidden();
	}

	@Override
	public void setJumping(boolean par1) {
		if (master != null) master.setJumping(par1);
		else super.setJumping(par1);
	}

	public void superSetJumping(boolean par1) {
		super.setJumping(par1);
	}

	@Override
	public void onItemPickup(Entity entity, int par2) {
		if (master != null) master.onItemPickup(entity, par2);
		else super.onItemPickup(entity, par2);
	}

	public void superOnItemPickup(Object entity, int par2) {
		super.onItemPickup((Entity) entity, par2);
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
	public Vec3 getLook(float par1) {
		return (Vec3) (master != null ? master.getLook(par1) : super.getLook(par1));
	}

	public Vec3 superGetLook(float par1) {
		return super.getLook(par1);
	}

	@Override
	public float getSwingProgress(float par1) {
		return master != null ? master.getSwingProgress(par1) : super.getSwingProgress(par1);
	}

	public float superGetSwingProgress(float par1) {
		return super.getSwingProgress(par1);
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
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}

	public float superGetEyeHeight() {
		return super.getEyeHeight();
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
	public void setRotationYawHead(float par1) {
		if (master != null) master.setRotationYawHead(par1);
		else super.setRotationYawHead(par1);
	}

	public void superSetRotationYawHead(float par1) {
		super.setRotationYawHead(par1);
	}

	@Override
	public float getAbsorptionAmount() {
		return master != null ? master.getAbsorptionAmount() : super.getAbsorptionAmount();
	}

	public float superGetAbsorptionAmount() {
		return super.getAbsorptionAmount();
	}

	@Override
	public void setAbsorptionAmount(float par1) {
		if (master != null) master.setAbsorptionAmount(par1);
		else super.setAbsorptionAmount(par1);
	}

	public void superSetAbsorptionAmount(float par1) {
		super.setAbsorptionAmount(par1);
	}

	@Override
	public boolean isOnTeam(Team team) {
		return master != null ? master.isOnTeam(team) : super.isOnTeam(team);
	}

	public boolean superIsOnTeam(Object team) {
		return super.isOnTeam((Team) team);
	}

	@Override
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataWatcher() : super.getDataWatcher());
	}

	public DataWatcher superGetDataWatcher() {
		return super.getDataWatcher();
	}

	@Override
	public boolean equals(Object par1Obj) {
		return master != null ? master.equals(par1Obj) : super.equals(par1Obj);
	}

	public boolean superEquals(Object par1Obj) {
		return super.equals(par1Obj);
	}

	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}

	public int superHashCode() {
		return super.hashCode();
	}

	@Override
	protected void preparePlayerToSpawn() {
		if (master != null) master.preparePlayerToSpawn();
		else super.preparePlayerToSpawn();
	}

	public void superPreparePlayerToSpawn() {
		super.preparePlayerToSpawn();
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
	protected void setRotation(float par1, float par2) {
		if (master != null) master.setRotation(par1, par2);
		else super.setRotation(par1, par2);
	}

	public void superSetRotation(float par1, float par2) {
		super.setRotation(par1, par2);
	}

	@Override
	public void setPosition(double par1, double par3, double par5) {
		if (master != null) master.setPosition(par1, par3, par5);
		else super.setPosition(par1, par3, par5);
	}

	public void superSetPosition(double par1, double par3, double par5) {
		super.setPosition(par1, par3, par5);
	}

	@Override
	public void setAngles(float par1, float par2) {
		if (master != null) master.setAngles(par1, par2);
		else super.setAngles(par1, par2);
	}

	public void superSetAngles(float par1, float par2) {
		super.setAngles(par1, par2);
	}

	@Override
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}

	public int superGetMaxInPortalTime() {
		return super.getMaxInPortalTime();
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
	public void setFire(int par1) {
		if (master != null) master.setFire(par1);
		else super.setFire(par1);
	}

	public void superSetFire(int par1) {
		super.setFire(par1);
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
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return master != null ? master.isOffsetPositionInLiquid(par1, par3, par5) : super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	public boolean superIsOffsetPositionInLiquid(double par1, double par3, double par5) {
		return super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.moveEntity(par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	public void superMoveEntity(double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
	}

	@Override
	public void playSound(String par1Str, float par2, float par3) {
		if (master != null) master.playSound(par1Str, par2, par3);
		else super.playSound(par1Str, par2, par3);
	}

	public void superPlaySound(String par1Str, float par2, float par3) {
		super.playSound(par1Str, par2, par3);
	}

	@Override
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}

	public boolean superCanTriggerWalking() {
		return super.canTriggerWalking();
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getBoundingBox() : super.getBoundingBox());
	}

	public AxisAlignedBB superGetBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	protected void dealFireDamage(int par1) {
		if (master != null) master.dealFireDamage(par1);
		else super.dealFireDamage(par1);
	}

	public void superDealFireDamage(int par1) {
		super.dealFireDamage(par1);
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
	public void moveFlying(float par1, float par2, float par3) {
		if (master != null) master.moveFlying(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}

	public void superMoveFlying(float par1, float par2, float par3) {
		super.moveFlying(par1, par2, par3);
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return master != null ? master.getBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}

	public int superGetBrightnessForRender(float par1) {
		return super.getBrightnessForRender(par1);
	}

	@Override
	public float getBrightness(float par1) {
		return master != null ? master.getBrightness(par1) : super.getBrightness(par1);
	}

	public float superGetBrightness(float par1) {
		return super.getBrightness(par1);
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
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setPositionAndRotation(par1, par3, par5, par7, par8);
		else super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	public void superSetPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	@Override
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setLocationAndAngles(par1, par3, par5, par7, par8);
		else super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}

	public void superSetLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}

	@Override
	public float getDistanceToEntity(Entity entity) {
		return master != null ? master.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}

	public float superGetDistanceToEntity(Object entity) {
		return super.getDistanceToEntity((Entity) entity);
	}

	@Override
	public double getDistanceSq(double par1, double par3, double par5) {
		return master != null ? master.getDistanceSq(par1, par3, par5) : super.getDistanceSq(par1, par3, par5);
	}

	public double superGetDistanceSq(double par1, double par3, double par5) {
		return super.getDistanceSq(par1, par3, par5);
	}

	@Override
	public double getDistance(double par1, double par3, double par5) {
		return master != null ? master.getDistance(par1, par3, par5) : super.getDistance(par1, par3, par5);
	}

	public double superGetDistance(double par1, double par3, double par5) {
		return super.getDistance(par1, par3, par5);
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
	public void addVelocity(double par1, double par3, double par5) {
		if (master != null) master.addVelocity(par1, par3, par5);
		else super.addVelocity(par1, par3, par5);
	}

	public void superAddVelocity(double par1, double par3, double par5) {
		super.addVelocity(par1, par3, par5);
	}

	@Override
	public void addToPlayerScore(Entity entity, int par2) {
		if (master != null) master.addToPlayerScore(entity, par2);
		else super.addToPlayerScore(entity, par2);
	}

	public void superAddToPlayerScore(Object entity, int par2) {
		super.addToPlayerScore((Entity) entity, par2);
	}

	@Override
	public boolean isInRangeToRenderDist(double par1) {
		return master != null ? master.isInRangeToRenderDist(par1) : super.isInRangeToRenderDist(par1);
	}

	public boolean superIsInRangeToRenderDist(double par1) {
		return super.isInRangeToRenderDist(par1);
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
	protected NBTTagList newDoubleNBTList(double... par1ArrayOfDouble) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(par1ArrayOfDouble) : super.newDoubleNBTList(par1ArrayOfDouble));
	}

	public NBTTagList superNewDoubleNBTList(double... par1ArrayOfDouble) {
		return super.newDoubleNBTList(par1ArrayOfDouble);
	}

	@Override
	protected NBTTagList newFloatNBTList(float... par1ArrayOfFloat) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(par1ArrayOfFloat) : super.newFloatNBTList(par1ArrayOfFloat));
	}

	public NBTTagList superNewFloatNBTList(float... par1ArrayOfFloat) {
		return super.newFloatNBTList(par1ArrayOfFloat);
	}

	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float par2) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, par2) : super.entityDropItem(itemStack, par2));
	}

	public EntityItem superEntityDropItem(Object itemStack, float par2) {
		return super.entityDropItem((ItemStack) itemStack, par2);
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return master != null ? master.isEntityInsideOpaqueBlock() : super.isEntityInsideOpaqueBlock();
	}

	public boolean superIsEntityInsideOpaqueBlock() {
		return super.isEntityInsideOpaqueBlock();
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
	public double getYOffset() {
		return master != null ? master.getYOffset() : super.getYOffset();
	}

	public double superGetYOffset() {
		return super.getYOffset();
	}

	@Override
	public double getMountedYOffset() {
		return master != null ? master.getMountedYOffset() : super.getMountedYOffset();
	}

	public double superGetMountedYOffset() {
		return super.getMountedYOffset();
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
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}

	public int superGetPortalCooldown() {
		return super.getPortalCooldown();
	}

	@Override
	public void setVelocity(double par1, double par3, double par5) {
		if (master != null) master.setVelocity(par1, par3, par5);
		else super.setVelocity(par1, par3, par5);
	}

	public void superSetVelocity(double par1, double par3, double par5) {
		super.setVelocity(par1, par3, par5);
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
	public void setSneaking(boolean par1) {
		if (master != null) master.setSneaking(par1);
		else super.setSneaking(par1);
	}

	public void superSetSneaking(boolean par1) {
		super.setSneaking(par1);
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
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}

	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void setInvisible(boolean par1) {
		if (master != null) master.setInvisible(par1);
		else super.setInvisible(par1);
	}

	public void superSetInvisible(boolean par1) {
		super.setInvisible(par1);
	}

	@Override
	public boolean isEating() {
		return master != null ? master.isEating() : super.isEating();
	}

	public boolean superIsEating() {
		return super.isEating();
	}

	@Override
	public void setEating(boolean par1) {
		if (master != null) master.setEating(par1);
		else super.setEating(par1);
	}

	public void superSetEating(boolean par1) {
		super.setEating(par1);
	}

	@Override
	protected boolean getFlag(int par1) {
		return master != null ? master.getFlag(par1) : super.getFlag(par1);
	}

	public boolean superGetFlag(int par1) {
		return super.getFlag(par1);
	}

	@Override
	protected void setFlag(int par1, boolean par2) {
		if (master != null) master.setFlag(par1, par2);
		else super.setFlag(par1, par2);
	}

	public void superSetFlag(int par1, boolean par2) {
		super.setFlag(par1, par2);
	}

	@Override
	public int getAir() {
		return master != null ? master.getAir() : super.getAir();
	}

	public int superGetAir() {
		return super.getAir();
	}

	@Override
	public void setAir(int par1) {
		if (master != null) master.setAir(par1);
		else super.setAir(par1);
	}

	public void superSetAir(int par1) {
		super.setAir(par1);
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
	public boolean isEntityInvulnerable(DamageSource damageSource) {
		return master != null ? master.isEntityInvulnerable(damageSource) : super.isEntityInvulnerable(damageSource);
	}

	public boolean superIsEntityInvulnerable(DamageSource damageSource) {
		return super.isEntityInvulnerable(damageSource);
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
	public void copyDataFromOld(Entity entity) {
		if (master != null) master.copyDataFrom(entity);
		else super.copyDataFromOld(entity);
	}

	public void superCopyDataFrom(Object entity) {
		super.copyDataFromOld((Entity) entity);
	}

	@Override
	public void travelToDimension(int par1) {
		if (master != null) master.travelToDimension(par1);
		else super.travelToDimension(par1);
	}

	public void superTravelToDimension(int par1) {
		super.travelToDimension(par1);
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
	public boolean isPushedByWater() {
		return master != null ? master.isPushedByWater() : super.isPushedByWater();
	}

	public boolean superIsPushedByWater() {
		return super.isPushedByWater();
	}

	@Override
	public IEntityLivingData func_180482_a(DifficultyInstance difficultyInstance, IEntityLivingData iEntityLivingData) {
		return (IEntityLivingData) (master != null ? master.onSpawnWithEgg(iEntityLivingData) : super.func_180482_a(difficultyInstance, iEntityLivingData));
	}

	public IEntityLivingData superOnSpawnWithEgg(Object difficultyInstance, Object iEntityLivingData) {
		return super.func_180482_a((DifficultyInstance) difficultyInstance, (IEntityLivingData) iEntityLivingData);
	}
	// ~162
	public EntityLivingBase func_130012_q() {
		return null;
	}

	public EntityLivingBase superFunc_130012_q() {
		return null;
	}

	public void func_110196_bT() {
	}

	public void superFunc_110196_bT() {
	}

	public boolean func_110173_bK() {
		return false;
	}

	public boolean superFunc_110173_bK() {
		return false;
	}

	public boolean func_110176_b(int par1, int par2, int par3) {
		return false;
	}

	public boolean superFunc_110176_b(int par1, int par2, int par3) {
		return false;
	}

	protected void func_110159_bB() {
	}

	public void superFunc_110159_bB() {
	}

	public boolean whiteListCheck(EntityLiving entityLiving) {
		return false;
	}

	public boolean superWhiteListCheck(Object entityLiving) {
		return false;
	}

	public boolean ngListCheck(EntityLiving entityLiving) {
		return false;
	}

	public boolean superNgListCheck(Object entityLiving) {
		return false;
	}

	protected int getDropItemId() {
		return -1;
	}

	public int superGetDropItemId() {
		return -1;
	}

	public ItemStack getCurrentItemOrArmor(int par1) {
		return null;
	}

	public ItemStack superGetCurrentItemOrArmor(int par1) {
		return null;
	}

	public String getEntityName() {
		return null;
	}

	public String superGetEntityName() {
		return null;
	}

	protected void doBlockCollisions() {
	}

	public void superDoBlockCollisions() {
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
	}

	public void superPlayStepSound(int par1, int par2, int par3, int par4) {
	}

	public boolean isInRangeToRenderVec3D(Vec3 vec3) {
		return false;
	}

	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return false;
	}

	public EntityItem dropItem(int par1, int par2) {
		return null;
	}

	public EntityItem superDropItem(int par1, int par2) {
		return null;
	}

	public EntityItem dropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}

	public EntityItem superDropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}

	public float getBlockExplosionResistance(Explosion explosion, World world, int par3, int par4, int par5, Block block) {
		return 0.0F;
	}

	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	public boolean shouldExplodeBlock(Explosion explosion, World world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

	public String getTranslatedEntityName() {
		return null;
	}

	public String superGetTranslatedEntityName() {
		return null;
	}
	// 164~
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
		return (UUID) (master != null ? master.getPersistentID() : super.getPersistentID());
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

	// 172~
	@Override
	public Entity getOwner() {
		return (EntityLivingBase) (master != null ? master.getOwner() : super.getOwner());
	}

	public Entity superGetOwner() {
		return super.getOwner();
	}

	@Override
	public EntityPlayer func_146083_cb() {
		return (EntityPlayer) (master != null ? master.func_146083_cb() : super.func_146083_cb());
	}

	public EntityPlayer superFunc_146083_cb() {
		return super.func_146083_cb();
	}

	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return master != null ? master.isWithinHomeDistanceCurrentPosition() : super.isWithinHomeDistanceCurrentPosition();
	}

	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return super.isWithinHomeDistanceCurrentPosition();
	}

	@Override
	protected void updateLeashedState() {
		if (master != null) master.updateLeashedState();
		else super.updateLeashedState();
	}

	public void superUpdateLeashedState() {
		super.updateLeashedState();
	}

	@Override
	protected Item getDropItem() {
		return (Item) (master != null ? master.getDropItem() : super.getDropItem());
	}

	public Item superGetDropItem() {
		return super.getDropItem();
	}

	@Override
	public ItemStack getEquipmentInSlot(int par1) {
		return (ItemStack) (master != null ? master.getEquipmentInSlot(par1) : super.getEquipmentInSlot(par1));
	}

	public ItemStack superGetEquipmentInSlot(int par1) {
		return super.getEquipmentInSlot(par1);
	}

	@Override
	public String getName() {
		return master != null ? master.getName() : super.getName();
	}

	public String superGetName() {
		return super.getName();
	}

	@Override
	protected boolean func_146066_aG() {
		return master != null ? master.func_146066_aG() : super.func_146066_aG();
	}

	public boolean superFunc_146066_aG() {
		return super.func_146066_aG();
	}

	@Override
	protected String getFallSoundString(int p_146067_1_) {
		return master != null ? master.getFallSoundString(p_146067_1_) : super.getFallSoundString(p_146067_1_);
	}

	public String superGetFallSoundString(int p_146067_1_) {
		return super.getFallSoundString(p_146067_1_);
	}

	@Override
	public IAttributeInstance getEntityAttribute(IAttribute iAttribute) {
		return (IAttributeInstance) (master != null ? master.getEntityAttribute(iAttribute) : super.getEntityAttribute(iAttribute));
	}

	public IAttributeInstance superGetEntityAttribute(Object iAttribute) {
		return super.getEntityAttribute((IAttribute) iAttribute);
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
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return master != null ? master.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_) : super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	@Override
	public EntityItem dropItem(Item item, int p_145779_2_) {
		return (EntityItem) (master != null ? master.dropItem(item, p_145779_2_) : super.dropItem(item, p_145779_2_));
	}

	public EntityItem superDropItem(Object item, int p_145779_2_) {
		return super.dropItem((Item) item, p_145779_2_);
	}

	@Override
	public EntityItem dropItemWithOffset(Item item, int p_145778_2_, float p_145778_3_) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(item, p_145778_2_, p_145778_3_) : super.dropItemWithOffset(item, p_145778_2_, p_145778_3_));
	}

	public EntityItem superDropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {
		return super.dropItemWithOffset((Item) item, p_145778_2_, p_145778_3_);
	}

	@Override
	protected boolean pushOutOfBlocks(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return master != null ? master.pushOutOfBlocks(p_145771_1_, p_145771_3_, p_145771_5_) : super.pushOutOfBlocks(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	public boolean superPushOutOfBlocks(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return super.pushOutOfBlocks(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	@Override
	public float getExplosionResistance(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState) {
		return master != null ? master.getExplosionResistance(explosion, world, blockPos, iBlockState) : super.getExplosionResistance(explosion, world, blockPos, iBlockState);
	}

	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return super.getExplosionResistance((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState);
	}

	@Override
	public boolean func_174816_a(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float f) {
		return master != null ? master.func_174816_a(explosion, world, blockPos, iBlockState, f) : super.func_174816_a(explosion, world, blockPos, iBlockState, f);
	}

	public boolean superFunc_174816_a(Object explosion, Object world, Object blockPos, Object iBlockState, float f) {
		return super.func_174816_a((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, f);
	}

	@Override
	public IChatComponent getDisplayName() {
		return (IChatComponent) (master != null ? master.getDisplayName() : super.getDisplayName());
	}

	public IChatComponent superGetDisplayName() {
		return super.getDisplayName();
	}

	@Override
	public void func_145781_i(int p_145781_1_) {
		if (master != null) master.func_145781_i(p_145781_1_);
		else super.func_145781_i(p_145781_1_);
	}

	public void superFunc_145781_i(int p_145781_1_) {
		super.func_145781_i(p_145781_1_);
	}

	// ~179
	protected void attackEntity(Entity entity, float par2) {
	}

	public void superAttackEntity(Object entity, float par2) {
	}

	public float getBlockPathWeight(int par1, int par2, int par3) {
		return 0.0F;
	}

	public float superGetBlockPathWeight(int par1, int par2, int par3) {
		return 0.0F;
	}

	protected Entity findPlayerToAttack() {
		return null;
	}

	public Entity superFindPlayerToAttack() {
		return null;
	}

	protected boolean isMovementCeased() {
		return false;
	}

	public boolean superIsMovementCeased() {
		return false;
	}

	protected void updateWanderPath() {
	}

	public void superUpdateWanderPath() {
	}

	public void setPathToEntity(PathEntity pathEntity) {
	}

	public void superSetPathToEntity(Object pathEntity) {
	}

	public Entity getEntityToAttack() {
		return null;
	}

	public Entity superGetEntityToAttack() {
		return null;
	}

	public void setTarget(Entity entity) {
	}

	public void superSetTarget(Object entity) {
	}

	public void setHomeArea(int par1, int par2, int par3, int par4) {
	}

	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
	}

	public Object getHomePosition() {
		return null;
	}

	public Object superGetHomePosition() {
		return null;
	}

	public float func_110174_bM() {
		return 0.0F;
	}

	public float superFunc_110174_bM() {
		return 0.0F;
	}

	protected boolean isAIEnabled() {
		return true;
	}

	public boolean superIsAIEnabled() {
		return true;
	}

	public int getMaxSafePointTries() {
		return -1;
	}

	public int superGetMaxSafePointTries() {
		return -1;
	}

	public ItemStack func_130225_q(int par1) {
		return null;
	}

	public ItemStack superFunc_130225_q(int par1) {
		return null;
	}

	public ItemStack[] getLastActiveItems() {
		return null;
	}

	public ItemStack[] superGetLastActiveItems() {
		return null;
	}

	public void func_110163_bv() {
	}

	public void superFunc_110163_bv() {
	}

	protected void enchantEquipment() {
	}

	public void superEnchantEquipment() {
	}

	public boolean hasCustomNameTag() {
		return hasCustomName();
	}

	public boolean superHasCustomNameTag() {
		return superHasCustomName();
	}

	protected void updateFallState(double par1, boolean par3) {
	}

	public void superUpdateFallState(double par1, boolean par3) {
	}

	public int func_142015_aE() {
		return -1;
	}

	public int superFunc_142015_aE() {
		return -1;
	}

	protected void fall(float par1) {
	}

	public void superFall(float par1) {
	}

	protected void dropRareDrop(int par1) {
	}

	public void superDropRareDrop(int par1) {
	}

	public CombatTracker func_110142_aN() {
		return null;
	}

	public CombatTracker superFunc_110142_aN() {
		return null;
	}

	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
	}

	public void superSetPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
	}

	public Vec3 getPosition(float par1) {
		return getPositionVector();
	}

	public Vec3 superGetPosition(float par1) {
		return super.getPositionVector();
	}

	public MovingObjectPosition rayTrace(double par1, float par3) {
		return null;
	}

	public MovingObjectPosition superRayTrace(double par1, float par3) {
		return null;
	}

	public boolean isClientWorld() {
		return false;
	}

	public boolean superIsClientWorld() {
		return false;
	}

	public float getShadowSize() {
		return 0.0F;
	}

	public float superGetShadowSize() {
		return 0.0F;
	}

	public boolean isEntityInvulnerable() {
		return false;
	}

	public boolean superIsEntityInvulnerable() {
		return false;
	}

	public void copyDataFrom(Entity entity, boolean par2) {
		copyDataFromOld(entity);
	}

	public void superCopyDataFrom(Object entity, boolean par2) {
		superCopyDataFrom((Entity) entity);
	}

	public IEntityLivingData onSpawnWithEgg(IEntityLivingData iEntityLivingData) {
		return func_180482_a(null, iEntityLivingData);
	}

	public IEntityLivingData superOnSpawnWithEgg(Object iEntityLivingData) {
		return superOnSpawnWithEgg(null, (IEntityLivingData) iEntityLivingData);
	}

	public void func_146082_f(EntityPlayer entityPlayer) {
	}

	public void superFunc_146082_f(Object entityPlayer) {
	}

	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return func_180485_d(new BlockPos(par1, par2, par3));
	}

	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return super.func_180485_d(new BlockPos(par1, par2, par3));
	}

	public String getCommandSenderName() {
		return getName();
	}

	public String superGetCommandSenderName() {
		return super.getName();
	}

	public Object getItemIcon(ItemStack itemStack, int par2) {
		return null;
	}

	public Object superGetItemIcon(Object itemStack, int par2) {
		return null;
	}

	protected void func_145775_I() {
	}

	public void superFunc_145775_I() {
	}

	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block block) {
	}

	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}

	public float getExplosionResistance(Explosion explosion, World world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block block) {
		return 0.0F;
	}

	public float superGetExplosionResistance(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}

	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return false;
	}

	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	public void superUpdateEntityActionState() {
	}

	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}
	// 180~
	@Override
	public float func_180484_a(BlockPos blockPos) {
		return master != null ? master.func_180484_a(blockPos) : super.func_180484_a(blockPos);
	}

	public float superGetBlockPathWeight(Object blockPos) {
		return super.func_180484_a((BlockPos) blockPos);
	}

	@Override
	public boolean func_180485_d(BlockPos blockPos) {
		return master != null ? master.func_180485_d(blockPos) : super.func_180485_d(blockPos);
	}

	public boolean superIsWithinHomeDistance(Object blockPos) {
		return super.func_180485_d((BlockPos) blockPos);
	}

	public String superFunc_152113_b() {
		return null;
	}

	public void superFunc_152115_b(String par1Str) {
	}

	public String superFunc_146067_o(int p_146067_1_) {
		return null;
	}

	public Object superFunc_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

	public float superFunc_180484_a(Object blockPos) {
		return super.func_180484_a((BlockPos) blockPos);
	}

	public boolean superFunc_180485_d(Object blockPos) {
		return super.func_180485_d((BlockPos) blockPos);
	}

}
