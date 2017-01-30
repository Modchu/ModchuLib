package modchu.lib.forge.mc190_212;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameable;
import modchu.lib.Modchu_IEntityTameableMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.CommandResultStats.Type;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityBodyHelper;
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
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import scala.collection.mutable.StringBuilder;

public abstract class Modchu_EntityTameable extends EntityTameable implements Modchu_IEntityTameable {
	public Modchu_IEntityTameableMaster master;
	public String entityName;
	public static ConcurrentHashMap<String, UUID> entityUniqueIDMap = new ConcurrentHashMap();
	protected ConcurrentHashMap<String, DataParameter> dataParameterMap = new ConcurrentHashMap();
	protected CombatTracker combatTracker;

	public Modchu_EntityTameable(World world) {
		super(world);
		Modchu_Debug.lDebug("Modchu_EntityTameable init.");
		ignoreFrustumCheck = true;
		CombatTracker combatTracker = getCombatTracker();
		Modchu_Debug.lDebug("Modchu_EntityTameable init combatTracker="+combatTracker);
		//world.onEntityAdded(this);
		//if (world.isRemote) Modchu_Main.setRuntimeException("debug Modchu_EntityTameable");
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		this((World) map.get("Object"));
		try {
			init(map);
		} catch(Exception e) {
			e.printStackTrace();
		} catch(Error e) {
			e.printStackTrace();
		}
	}

	@Override
	public ConcurrentHashMap getDataParameterMap() {
		return dataParameterMap;
	}

	@Override
	public CombatTracker getCombatTracker() {
		return getCombatTracker2();
	}

	public CombatTracker getCombatTracker2() {
		//Modchu_Debug.lDebug("Modchu_EntityTameable getCombatTracker2 combatTracker="+combatTracker);
		if (combatTracker != null); else combatTracker = new CombatTracker(this);
		//Modchu_Debug.Debug("Modchu_EntityTameable getCombatTracker2 combatTracker="+combatTracker+" this="+this);
		return combatTracker;
	}

	@Override
	public void setMovementSpeed(double d) {
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(d);
	}

	@Override
	public void setFollowRange(double d) {
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(d);
	}

	@Override
	public void setKnockbackResistance(double d) {
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(d);
	}

	@Override
	public void setAttackDamage(double d) {
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(d);
	}

	@Override
	public void setMaxHealth(double d) {
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(d);
	}

	public Object getMaster() {
		//Modchu_Debug.mDebug("getmasterEntity masterEntity="+masterEntity);
		if (master != null); else {
			init(entityName);
		}
		return master;
	}

	@Override
	public Object getFreeVariable(String s) {
		return master.getFreeVariable(s);
	}

	@Override
	public Object superGetFreeVariable(String s) {
		return null;
	}

	@Override
	public void setFreeVariable(String s, Object o) {
		master.setFreeVariable(s, o);
	}

	@Override
	public void superSetFreeVariable(String s, Object o) {
	}

	protected void init(String s) {
		if (s != null
				&& !s.isEmpty()); else return;
		Class c = Modchu_Reflect.loadClass(s);
		if (c != null); else return;
		HashMap<String, Object> map = Modchu_Main.getNewModchuCharacteristicMap(c);
		init(map);
	}

	protected void init(HashMap<String, Object> map) {
		World worldObj = (World) Modchu_AS.get(Modchu_AS.entityWorldObj, this);
		if (map != null
				&& !map.isEmpty()); else {
			if (master != null) return;
			Modchu_Debug.mDebug("Modchu_EntityTameable init isRemote="+worldObj.isRemote);
					//setDead();
					//Modchu_Main.setRuntimeException("init debug");
			Class c = Modchu_Main.getSpownEntityClass(worldObj, posX, posY, posZ);
			map = new HashMap();
			map.put("Class", c);
			map.put("Object", worldObj);
		}
		if (map != null
				&& !map.isEmpty()
				&& map.containsKey("Class")); else {
			return;
		}
		Class c = map.containsKey("Class") ? ((Class) map.get("Class")) : null;
		if (c != null); else return;
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IEntityTameableMaster ? (Modchu_IEntityTameableMaster) instance : null;
		entityName = c.getName();
		Modchu_Debug.mDebug("initNBTAfter entityName="+(entityName != null ? entityName : "null !!"));
		if (master != null); else {
			Modchu_Debug.mDebug("Modchu_EntityTameable init 4 master == null !!");
			return;
		}
		master.entityInit();
		String s0 = new StringBuilder(Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, this) ? "1" : "0").append(entityUniqueID).toString();
		if (s0 != null
				&& entityUniqueIDMap.containsKey(s0)) {
			Modchu_Debug.mDebug("initNBTAfter entityUniqueIDMap.containsKey isDead entityUniqueID="+entityUniqueID);
			Modchu_AS.set(Modchu_AS.entityLivingBaseSetHealth, this, 0.0F);
			deathTime = 20;
			setDead();
			return;
		}
		if (s0 != null) entityUniqueIDMap.put(s0, entityUniqueID);
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

	@Override
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

	@Override
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

	@Override
	public void superReadEntityFromNBT(Object nBTTagCompound) {
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected void playTameEffect(boolean par1) {
		if (master != null) master.playTameEffect(par1);
		else super.playTameEffect(par1);
	}

	@Override
	public void superPlayTameEffect(boolean par1) {
		super.playTameEffect(par1);
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

	@Override
	public boolean isTamed() {
		return master != null ? master.isTamed() : super.isTamed();
	}

	@Override
	public boolean superIsTamed() {
		return super.isTamed();
	}

	@Override
	public void setTamed(boolean par1) {
		if (master != null) master.setTamed(par1);
		else super.setTamed(par1);
	}

	@Override
	public void superSetTamed(boolean par1) {
		super.setTamed(par1);
	}

	@Override
	public boolean isSitting() {
		return master != null ? master.isSitting() : super.isSitting();
	}

	@Override
	public boolean superIsSitting() {
		return super.isSitting();
	}

	@Override
	public void setSitting(boolean par1) {
		if (master != null) master.setSitting(par1);
		else super.setSitting(par1);
	}

	@Override
	public void superSetSitting(boolean par1) {
		super.setSitting(par1);
	}

	@Override
	public UUID getOwnerId() {
		return (UUID) (master != null ? master.getOwnerName() : super.getOwnerId());
	}

	@Override
	public Object superGetOwnerName() {
		return super.getOwnerId();
	}

	@Override
	public void setOwnerId(UUID uUID) {
		if (master != null) master.setOwner(uUID);
		else super.setOwnerId(uUID);
	}

	@Override
	public void superSetOwner(Object uUID) {
		super.setOwnerId((UUID) uUID);
	}

	@Override
	public EntityAISit getAISit() {
		return (EntityAISit) (master != null ? master.getAISit() : super.getAISit());
	}

	@Override
	public EntityAISit superGetAISit() {
		return super.getAISit();
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
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}

	@Override
	public Team superGetTeam() {
		return super.getTeam();
	}

	@Override
	public boolean isOnSameTeam(Entity entity) {
		return master != null ? master.isOnSameTeam(entity) : super.isOnSameTeam(entity);
	}

	@Override
	public boolean superIsOnSameTeam(Object entity) {
		return super.isOnSameTeam((Entity) entity);
	}

	@Override
	public void onLivingUpdate() {
		//Modchu_Debug.mDebug("onLivingUpdate master="+master);
		//Modchu_Debug.mDebug("onLivingUpdate entityName="+entityName);
		//Modchu_Debug.mDebug("onLivingUpdate posX="+posX+" posY="+posY+" posZ="+posZ);
		if (master != null
				&& entityName != null); else {
			Modchu_Debug.mDebug("onLivingUpdate this="+this);
			Modchu_Debug.mDebug("onLivingUpdate master="+master);
			Modchu_Debug.mDebug("onLivingUpdate entityName="+entityName);
			init((HashMap)null);
			if (master != null); else {
				setDead();
			}
		}
		if (master != null) master.onLivingUpdate();
		else super.onLivingUpdate();
	}

	@Override
	public void superOnLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float par2) {
		return master != null ? master.attackEntityFrom(damageSource, par2) : super.attackEntityFrom(damageSource, par2);
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, Object par2) {
		return super.attackEntityFrom((DamageSource) damageSource, (Float) par2);
	}

	@Override
	public boolean getCanSpawnHere() {
		return master != null ? master.getCanSpawnHere() : super.getCanSpawnHere();
	}

	@Override
	public boolean superGetCanSpawnHere() {
		return super.getCanSpawnHere();
	}

	@Override
	public int getTalkInterval() {
		return master != null ? master.getTalkInterval() : super.getTalkInterval();
	}

	@Override
	public int superGetTalkInterval() {
		return super.getTalkInterval();
	}

	@Override
	protected boolean canDespawn() {
		return master != null ? master.canDespawn() : super.canDespawn();
	}

	@Override
	public boolean superCanDespawn() {
		return super.canDespawn();
	}

	@Override
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return master != null ? master.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}

	@Override
	public int superGetExperiencePoints(Object entityPlayer) {
		return super.getExperiencePoints((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isBreedingItem(ItemStack itemStack) {
		return master != null ? master.isBreedingItem(itemStack) : super.isBreedingItem(itemStack);
	}

	@Override
	public boolean superIsBreedingItem(Object itemStack) {
		return super.isBreedingItem((ItemStack) itemStack);
	}

	@Override
	public boolean isInLove() {
		return master != null ? master.isInLove() : super.isInLove();
	}

	@Override
	public boolean superIsInLove() {
		return super.isInLove();
	}

	@Override
	public void resetInLove() {
		if (master != null) master.resetInLove();
		else super.resetInLove();
	}

	@Override
	public void superResetInLove() {
		super.resetInLove();
	}

	@Override
	public boolean canMateWith(EntityAnimal entityAnimal) {
		return master != null ? master.canMateWith(entityAnimal) : super.canMateWith(entityAnimal);
	}

	@Override
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

	@Override
	public int superGetGrowingAge() {
		return super.getGrowingAge();
	}

	@Override
	public void addGrowth(int par1) {
		if (master != null) master.addGrowth(par1);
		else super.addGrowth(par1);
	}

	@Override
	public void superAddGrowth(int par1) {
		super.addGrowth(par1);
	}

	@Override
	public void setGrowingAge(int par1) {
		if (master != null) master.setGrowingAge(par1);
		else super.setGrowingAge(par1);
	}

	@Override
	public void superSetGrowingAge(int par1) {
		super.setGrowingAge(par1);
	}

	@Override
	public boolean isChild() {
		return master != null ? master.isChild() : super.isChild();
	}

	@Override
	public boolean superIsChild() {
		return super.isChild();
	}

	@Override
	public void setScaleForAge(boolean par1) {
		if (master != null) master.setScaleForAge(par1);
		else super.setScaleForAge(par1);
	}

	@Override
	public void superSetScaleForAge(boolean par1) {
		super.setScaleForAge(par1);
	}

	@Override
	public boolean hasPath() {
		return master != null ? master.hasPath() : super.hasPath();
	}

	@Override
	public boolean superHasPath() {
		return super.hasPath();
	}

	@Override
	public void detachHome() {
		if (master != null) master.detachHome();
		else super.detachHome();
	}

	@Override
	public void superDetachHome() {
		super.detachHome();
	}

	@Override
	public boolean hasHome() {
		return master != null ? master.hasHome() : super.hasHome();
	}

	@Override
	public boolean superHasHome() {
		return super.hasHome();
	}

	@Override
	protected void applyEntityAttributes() {
		if (master != null) master.applyEntityAttributes();
		else super.applyEntityAttributes();
	}

	@Override
	public void superApplyEntityAttributes() {
		super.applyEntityAttributes();
	}

	@Override
	public EntityLookHelper getLookHelper() {
		return (EntityLookHelper) (master != null ? master.getLookHelper() : super.getLookHelper());
	}

	@Override
	public EntityLookHelper superGetLookHelper() {
		return super.getLookHelper();
	}

	@Override
	public EntityMoveHelper getMoveHelper() {
		return (EntityMoveHelper) (master != null ? master.getMoveHelper() : super.getMoveHelper());
	}

	@Override
	public EntityMoveHelper superGetMoveHelper() {
		return super.getMoveHelper();
	}

	@Override
	public EntityJumpHelper getJumpHelper() {
		return (EntityJumpHelper) (master != null ? master.getJumpHelper() : super.getJumpHelper());
	}

	@Override
	public EntityJumpHelper superGetJumpHelper() {
		return super.getJumpHelper();
	}

	@Override
	public PathNavigate getNavigator() {
		return (PathNavigate) (master != null ? master.getNavigator() : super.getNavigator());
	}

	@Override
	public PathNavigate superGetNavigator() {
		return super.getNavigator();
	}

	@Override
	public EntitySenses getEntitySenses() {
		return (EntitySenses) (master != null ? master.getEntitySenses() : super.getEntitySenses());
	}

	@Override
	public EntitySenses superGetEntitySenses() {
		return super.getEntitySenses();
	}

	@Override
	public EntityLivingBase getAttackTarget() {
		return (EntityLivingBase) (master != null ? master.getAttackTarget() : super.getAttackTarget());
	}

	@Override
	public EntityLivingBase superGetAttackTarget() {
		return super.getAttackTarget();
	}

	@Override
	public void setAttackTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setAttackTarget(entityLivingBase);
		else super.setAttackTarget(entityLivingBase);
	}

	@Override
	public void superSetAttackTarget(Object entityLivingBase) {
		super.setAttackTarget((EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean canAttackClass(Class c) {
		return master != null ? master.canAttackClass(c) : super.canAttackClass(c);
	}

	@Override
	public boolean superCanAttackClass(Class c) {
		return super.canAttackClass(c);
	}

	@Override
	public void eatGrassBonus() {
		if (master != null) master.eatGrassBonus();
		else super.eatGrassBonus();
	}

	@Override
	public void superEatGrassBonus() {
		super.eatGrassBonus();
	}

	@Override
	public void playLivingSound() {
		if (master != null) master.playLivingSound();
		else super.playLivingSound();
	}

	@Override
	public void superPlayLivingSound() {
		super.playLivingSound();
	}

	@Override
	public void onEntityUpdate() {
		World worldObj = (World) Modchu_AS.get(Modchu_AS.entityWorldObj, this);
		if (worldObj != null); else return;
		if (master != null) master.onEntityUpdate();
		else super.onEntityUpdate();
	}

	@Override
	public void superOnEntityUpdate() {
		super.onEntityUpdate();
	}

	@Override
	public void spawnExplosionParticle() {
		if (master != null) master.spawnExplosionParticle();
		else super.spawnExplosionParticle();
	}

	@Override
	public void superSpawnExplosionParticle() {
		super.spawnExplosionParticle();
	}

	@Override
	public void onUpdate() {
		World worldObj = (World) Modchu_AS.get(Modchu_AS.entityWorldObj, this);
		if (worldObj != null); else return;
		if (!worldObj.isRemote) {
			Object attributeMap = getAttributeMap();
			if (ticksExisted % 20 == 0) {
				CombatTracker combatTracker = getCombatTracker2();
				//Modchu_Debug.lDebug("Modchu_EntityTameable onUpdate combatTracker="+combatTracker);
				combatTracker.reset();
				ticksExisted++;
			}
		}
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	@Override
	public void superOnUpdate() {
		super.onUpdate();
	}

	@Override
	protected float updateDistance(float par1, float par2) {
		return master != null ? master.updateDistance(par1, par2) : super.updateDistance(par1, par2);
	}

	@Override
	public float superUpdateDistance(float par1, float par2) {
		return super.updateDistance(par1, par2);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return (SoundEvent) (master != null ? master.getAmbientSound() : super.getAmbientSound());
	}

	@Override
	public Object superGetAmbientSound() {
		return super.getAmbientSound();
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		if (master != null) master.dropFewItems(par1, par2);
		else super.dropFewItems(par1, par2);
	}

	@Override
	public void superDropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
	}

	@Override
	public void setMoveForward(float par1) {
		if (master != null) master.setMoveForward(par1);
		else super.setMoveForward(par1);
	}

	@Override
	public void superSetMoveForward(float par1) {
		super.setMoveForward(par1);
	}

	@Override
	public void setAIMoveSpeed(float par1) {
		if (master != null) master.setAIMoveSpeed(par1);
		else super.setAIMoveSpeed(par1);
	}

	@Override
	public void superSetAIMoveSpeed(float par1) {
		super.setAIMoveSpeed(par1);
	}

	@Override
	protected void despawnEntity() {
		if (master != null) master.despawnEntity();
		else super.despawnEntity();
	}

	@Override
	public void superDespawnEntity() {
		super.despawnEntity();
	}

	@Override
	protected void updateAITasks() {
		if (master != null) master.updateAITasks();
		else super.updateAITasks();
	}

	@Override
	public void superUpdateAITasks() {
		super.updateAITasks();
	}

	@Override
	public int getVerticalFaceSpeed() {
		return master != null ? master.getVerticalFaceSpeed() : super.getVerticalFaceSpeed();
	}

	@Override
	public int superGetVerticalFaceSpeed() {
		return super.getVerticalFaceSpeed();
	}

	@Override
	public void faceEntity(Entity entity, float par2, float par3) {
		if (master != null) master.faceEntity(entity, par2, par3);
		else super.faceEntity(entity, par2, par3);
	}

	@Override
	public void superFaceEntity(Object entity, float par2, float par3) {
		super.faceEntity((Entity) entity, par2, par3);
	}

	@Override
	public float getRenderSizeModifier() {
		return master != null ? master.getRenderSizeModifier() : super.getRenderSizeModifier();
	}

	@Override
	public float superGetRenderSizeModifier() {
		return super.getRenderSizeModifier();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return master != null ? master.getMaxSpawnedInChunk() : super.getMaxSpawnedInChunk();
	}

	@Override
	public int superGetMaxSpawnedInChunk() {
		return super.getMaxSpawnedInChunk();
	}

	@Override
	public void setItemStackToSlot(EntityEquipmentSlot entityEquipmentSlot, ItemStack itemStack) {
		if (master != null) master.setItemStackToSlot(entityEquipmentSlot, itemStack);
		else super.setItemStackToSlot(entityEquipmentSlot, itemStack);
	}

	@Override
	public void superSetItemStackToSlot(Object entityEquipmentSlot, Object itemStack) {
		super.setItemStackToSlot((EntityEquipmentSlot) entityEquipmentSlot, (ItemStack) itemStack);
	}

	@Override
	protected void dropEquipment(boolean par1, int par2) {
		if (master != null) master.dropEquipment(par1, par2);
		else super.dropEquipment(par1, par2);
	}

	@Override
	public void superDropEquipment(boolean par1, int par2) {
		super.dropEquipment(par1, par2);
	}

	@Override
	protected void dropLoot(boolean p_184610_1_, int p_184610_2_, DamageSource damageSource) {
		if (master != null) master.dropLoot(p_184610_1_, p_184610_2_, damageSource);
		else super.dropLoot(p_184610_1_, p_184610_2_, damageSource);
	}

	@Override
	public void superDropLoot(boolean p_184610_1_, int p_184610_2_, Object damageSource) {
		super.dropLoot(p_184610_1_, p_184610_2_, (DamageSource) damageSource);
	}

	@Override
	public boolean canBeSteered() {
		return master != null ? master.canBeSteered() : super.canBeSteered();
	}

	@Override
	public boolean superCanBeSteered() {
		return super.canBeSteered();
	}

	@Override
	public void setCustomNameTag(String par1Str) {
		if (master != null) master.setCustomNameTag(par1Str);
		else super.setCustomNameTag(par1Str);
	}

	@Override
	public void superSetCustomNameTag(String par1Str) {
		super.setCustomNameTag(par1Str);
	}

	@Override
	public String getCustomNameTag() {
		return master != null ? master.getCustomNameTag() : super.getCustomNameTag();
	}

	@Override
	public String superGetCustomNameTag() {
		return super.getCustomNameTag();
	}

	@Override
	public boolean hasCustomName() {
		return master != null ? master.hasCustomNameTag() : super.hasCustomName();
	}

	@Override
	public boolean superHasCustomName() {
		return super.hasCustomName();
	}

	@Override
	public void setAlwaysRenderNameTag(boolean par1) {
		if (master != null) master.setAlwaysRenderNameTag(par1);
		else super.setAlwaysRenderNameTag(par1);
	}

	@Override
	public void superSetAlwaysRenderNameTag(boolean par1) {
		super.setAlwaysRenderNameTag(par1);
	}

	@Override
	public boolean getAlwaysRenderNameTag() {
		return master != null ? master.getAlwaysRenderNameTag() : super.getAlwaysRenderNameTag();
	}

	@Override
	public boolean superGetAlwaysRenderNameTag() {
		return super.getAlwaysRenderNameTag();
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public boolean superGetAlwaysRenderNameTagForRender() {
		return super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public void setDropChance(EntityEquipmentSlot entityEquipmentSlot, float par2) {
		if (master != null) master.setDropChance(entityEquipmentSlot, par2);
		else super.setDropChance(entityEquipmentSlot, par2);
	}

	@Override
	public void superSetDropChance(Object entityEquipmentSlot, float par2) {
		super.setDropChance((EntityEquipmentSlot) entityEquipmentSlot, par2);
	}

	@Override
	public boolean canPickUpLoot() {
		return master != null ? master.canPickUpLoot() : super.canPickUpLoot();
	}

	@Override
	public boolean superCanPickUpLoot() {
		return super.canPickUpLoot();
	}

	@Override
	public void setCanPickUpLoot(boolean par1) {
		if (master != null) master.setCanPickUpLoot(par1);
		else super.setCanPickUpLoot(par1);
	}

	@Override
	public void superSetCanPickUpLoot(boolean par1) {
		super.setCanPickUpLoot(par1);
	}

	@Override
	public boolean isNoDespawnRequired() {
		return master != null ? master.isNoDespawnRequired() : super.isNoDespawnRequired();
	}

	@Override
	public boolean superIsNoDespawnRequired() {
		return super.isNoDespawnRequired();
	}

	@Override
	public void clearLeashed(boolean par1, boolean par2) {
		if (master != null) master.clearLeashed(par1, par2);
		else super.clearLeashed(par1, par2);
	}

	@Override
	public void superClearLeashed(boolean par1, boolean par2) {
		super.clearLeashed(par1, par2);
	}

	@Override
	public boolean canBeLeashedTo(EntityPlayer entityPlayer) {
		return master != null ? master.canBeLeashedTo() : super.canBeLeashedTo(entityPlayer);
	}

	@Override
	public boolean superCanBeLeashedTo(Object entityPlayer) {
		return super.canBeLeashedTo((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean getLeashed() {
		return master != null ? master.getLeashed() : super.getLeashed();
	}

	@Override
	public boolean superGetLeashed() {
		return super.getLeashed();
	}

	@Override
	public Entity getLeashedToEntity() {
		return (Entity) (master != null ? master.getLeashedToEntity() : super.getLeashedToEntity());
	}

	@Override
	public Entity superGetLeashedToEntity() {
		return super.getLeashedToEntity();
	}

	@Override
	public void setLeashedToEntity(Entity entity, boolean par2) {
		if (master != null) master.setLeashedToEntity(entity, par2);
		else super.setLeashedToEntity(entity, par2);
	}

	@Override
	public void superSetLeashedToEntity(Object entity, boolean par2) {
		super.setLeashedToEntity((Entity) entity, par2);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}

	@Override
	public boolean superCanBreatheUnderwater() {
		return super.canBreatheUnderwater();
	}

	@Override
	protected void onDeathUpdate() {
		if (master != null) master.onDeathUpdate();
		else super.onDeathUpdate();
	}

	@Override
	public void superOnDeathUpdate() {
		super.onDeathUpdate();
	}

	@Override
	protected int decreaseAirSupply(int par1) {
		return master != null ? master.decreaseAirSupply(par1) : super.decreaseAirSupply(par1);
	}

	@Override
	public int superDecreaseAirSupply(int par1) {
		return super.decreaseAirSupply(par1);
	}

	@Override
	protected boolean isPlayer() {
		return master != null ? master.isPlayer() : super.isPlayer();
	}

	@Override
	public boolean superIsPlayer() {
		return super.isPlayer();
	}

	@Override
	public Random getRNG() {
		return master != null ? master.getRNG() : super.getRNG();
	}

	@Override
	public Random superGetRNG() {
		return super.getRNG();
	}

	@Override
	public EntityLivingBase getAITarget() {
		return (EntityLivingBase) (master != null ? master.getAITarget() : super.getAITarget());
	}

	@Override
	public EntityLivingBase superGetAITarget() {
		return super.getAITarget();
	}

	@Override
	public void setRevengeTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setRevengeTarget(entityLivingBase);
		else super.setRevengeTarget(entityLivingBase);
	}

	@Override
	public void superSetRevengeTarget(Object entityLivingBase) {
		super.setRevengeTarget((EntityLivingBase) entityLivingBase);
	}

	@Override
	public EntityLivingBase getLastAttacker() {
		return (EntityLivingBase) (master != null ? master.getLastAttacker() : super.getLastAttacker());
	}

	@Override
	public EntityLivingBase superGetLastAttacker() {
		return super.getLastAttacker();
	}

	@Override
	public int getLastAttackerTime() {
		return master != null ? master.getLastAttackerTime() : super.getLastAttackerTime();
	}

	@Override
	public int superGetLastAttackerTime() {
		return super.getLastAttackerTime();
	}

	@Override
	public void setLastAttacker(Entity entity) {
		if (master != null) master.setLastAttacker(entity);
		else super.setLastAttacker(entity);
	}

	@Override
	public void superSetLastAttacker(Object entity) {
		super.setLastAttacker((Entity) entity);
	}

	@Override
	public int getAge() {
		return master != null ? master.getAge() : super.getAge();
	}

	@Override
	public int superGetAge() {
		return super.getAge();
	}

	@Override
	protected void updatePotionEffects() {
		if (master != null) master.updatePotionEffects();
		else super.updatePotionEffects();
	}

	@Override
	public void superUpdatePotionEffects() {
		super.updatePotionEffects();
	}

	@Override
	public void clearActivePotions() {
		if (master != null) master.clearActivePotions();
		else super.clearActivePotions();
	}

	@Override
	public void superClearActivePotions() {
		super.clearActivePotions();
	}

	@Override
	public Collection getActivePotionEffects() {
		return (Collection) (master != null ? master.getActivePotionEffects() : super.getActivePotionEffects());
	}

	@Override
	public Collection superGetActivePotionEffects() {
		return super.getActivePotionEffects();
	}

	@Override
	public boolean isPotionActive(Potion potion) {
		return master != null ? master.isPotionActive(potion) : super.isPotionActive(potion);
	}

	@Override
	public boolean superIsPotionActive(Object potion) {
		return super.isPotionActive((Potion) potion);
	}

	@Override
	public PotionEffect getActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.getActivePotionEffect(potion) : super.getActivePotionEffect(potion));
	}

	@Override
	public PotionEffect superGetActivePotionEffect(Object potion) {
		return super.getActivePotionEffect((Potion) potion);
	}

	@Override
	public void addPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.addPotionEffect(potionEffect);
		else super.addPotionEffect(potionEffect);
	}

	@Override
	public void superAddPotionEffect(Object potionEffect) {
		super.addPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public boolean isPotionApplicable(PotionEffect potionEffect) {
		return master != null ? master.isPotionApplicable(potionEffect) : super.isPotionApplicable(potionEffect);
	}

	@Override
	public boolean superIsPotionApplicable(Object potionEffect) {
		return super.isPotionApplicable((PotionEffect) potionEffect);
	}

	@Override
	public boolean isEntityUndead() {
		return master != null ? master.isEntityUndead() : super.isEntityUndead();
	}

	@Override
	public boolean superIsEntityUndead() {
		return super.isEntityUndead();
	}

	@Override
	protected void onNewPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onNewPotionEffect(potionEffect);
		else super.onNewPotionEffect(potionEffect);
	}

	@Override
	public void superOnNewPotionEffect(Object potionEffect) {
		super.onNewPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	protected void onChangedPotionEffect(PotionEffect potionEffect, boolean par2) {
		if (master != null) master.onChangedPotionEffect(potionEffect, par2);
		else super.onChangedPotionEffect(potionEffect, par2);
	}

	@Override
	public void superOnChangedPotionEffect(Object potionEffect, boolean par2) {
		super.onChangedPotionEffect((PotionEffect) potionEffect, par2);
	}

	@Override
	protected void onFinishedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onFinishedPotionEffect(potionEffect);
		else super.onFinishedPotionEffect(potionEffect);
	}

	@Override
	public void superOnFinishedPotionEffect(Object potionEffect) {
		super.onFinishedPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public void heal(float par1) {
		if (master != null) master.heal(par1);
		else super.heal(par1);
	}

	@Override
	public void superHeal(Object par1) {
		super.heal((Float) par1);
	}

	@Override
	public void setHealth(float par1) {
		World worldObj = (World) Modchu_AS.get(Modchu_AS.entityWorldObj, this);
		if (worldObj != null); else return;
		if (master != null) master.setHealth(par1);
		else super.setHealth(par1);
	}

	@Override
	public void superSetHealth(Object par1) {
		super.setHealth((Float) par1);
	}

	@Override
	public void renderBrokenItemStack(ItemStack itemStack) {
		if (master != null) master.renderBrokenItemStack(itemStack);
		else super.renderBrokenItemStack(itemStack);
	}

	@Override
	public void superRenderBrokenItemStack(Object itemStack) {
		super.renderBrokenItemStack((ItemStack) itemStack);
	}

	@Override
	public void onDeath(DamageSource damageSource) {
		//CombatTracker combatTracker = getCombatTracker();
		//Modchu_Debug.lDebug("Modchu_EntityTameable onDeath combatTracker="+combatTracker);
		if (master != null) master.onDeath(damageSource);
		else super.onDeath(damageSource);
	}

	@Override
	public void superOnDeath(Object damageSource) {
		World worldObj = (World) Modchu_AS.get(Modchu_AS.entityWorldObj, this);
		if (!worldObj.isRemote && worldObj.getGameRules().getBoolean("showDeathMessages") && hasCustomName() && getOwner() instanceof EntityPlayerMP) {
			int version = Modchu_Main.getMinecraftVersion();
			Modchu_AS.set("EntityPlayerMP", version > 210 ? "sendMessage" : "addChatMessage", new Class[]{ ITextComponent.class }, getOwner(), new Object[]{ getCombatTracker2().getDeathMessage() });
		}

		if (net.minecraftforge.common.ForgeHooks.onLivingDeath(this, (DamageSource) damageSource)) return;
		Entity entity = ((DamageSource) damageSource).getEntity();
		EntityLivingBase entitylivingbase = getAttackingEntity();

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
			if (canDropLoot()
					&& worldObj.getGameRules().getBoolean("doMobLoot")) {
				boolean flag = recentlyHit > 0;
				dropLoot(flag, i, (DamageSource) damageSource);
			}

			captureDrops = false;

			if (!net.minecraftforge.common.ForgeHooks.onLivingDrops(this, (DamageSource) damageSource, capturedDrops, i, recentlyHit > 0)) {
				for (EntityItem item : capturedDrops) {
					Modchu_AS.set(Modchu_AS.worldSpawnEntity, worldObj, item);
				}
			}
		}

		worldObj.setEntityState(this, (byte) 3);
	}

	@Override
	public void knockBack(Entity entity, float par2, double par3, double par5) {
		if (master != null) master.knockBack(entity, par2, par3, par5);
		else super.knockBack(entity, par2, par3, par5);
	}

	@Override
	public void superKnockBack(Object entity, float par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
	}

	@Override
	protected SoundEvent getHurtSound() {
		return (SoundEvent) (master != null ? master.getHurtSound() : super.getHurtSound());
	}

	@Override
	public Object superGetHurtSound() {
		return super.getHurtSound();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return (SoundEvent) (master != null ? master.getDeathSound() : super.getDeathSound());
	}

	@Override
	public Object superGetDeathSound() {
		return super.getDeathSound();
	}

	@Override
	public boolean isOnLadder() {
		return master != null ? master.isOnLadder() : super.isOnLadder();
	}

	@Override
	public boolean superIsOnLadder() {
		return super.isOnLadder();
	}

	@Override
	public boolean isEntityAlive() {
		return master != null ? master.isEntityAlive() : super.isEntityAlive();
	}

	@Override
	public boolean superIsEntityAlive() {
		return super.isEntityAlive();
	}

	@Override
	public void performHurtAnimation() {
		if (master != null) master.performHurtAnimation();
		else super.performHurtAnimation();
	}

	@Override
	public void superPerformHurtAnimation() {
		super.performHurtAnimation();
	}

	@Override
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}

	@Override
	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}

	@Override
	protected void damageArmor(float par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}

	@Override
	public void superDamageArmor(float par1) {
		super.damageArmor(par1);
	}

	@Override
	protected float applyArmorCalculations(DamageSource damageSource, float par2) {
		return (Float) (master != null ? master.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2));
	}

	@Override
	public Object superApplyArmorCalculations(Object damageSource, float par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float par2) {
		return (Float) (master != null ? master.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2));
	}

	@Override
	public Object superApplyPotionDamageCalculations(Object damageSource, float par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected void damageEntity(DamageSource damageSource, float par2) {
		//CombatTracker combatTracker = getCombatTracker();
		//Modchu_Debug.lDebug("Modchu_EntityTameable damageEntity combatTracker="+combatTracker);
		if (master != null) master.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
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
	public EntityLivingBase getAttackingEntity() {
		return (EntityLivingBase) (master != null ? master.getAttackingEntity() : super.getAttackingEntity());
	}

	@Override
	public EntityLivingBase superGetAttackingEntity() {
		return super.getAttackingEntity();
	}

	@Override
	public void swingArm(EnumHand enumHand) {
		if (master != null) master.swingArm(enumHand);
		else super.swingArm(enumHand);
	}

	@Override
	public void superSwingArm(Object enumHand) {
		super.swingArm((EnumHand) enumHand);
	}

	@Override
	protected void kill() {
		if (master != null) master.kill();
		else super.kill();
	}

	@Override
	public void superKill() {
		super.kill();
	}

	@Override
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}

	@Override
	public void superUpdateArmSwingProgress() {
		super.updateArmSwingProgress();
	}

	@Override
	public AbstractAttributeMap getAttributeMap() {
		return (AbstractAttributeMap) (master != null ? master.getAttributeMap() : super.getAttributeMap());
	}

	@Override
	public AbstractAttributeMap superGetAttributeMap() {
		return super.getAttributeMap();
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return (EnumCreatureAttribute) (master != null ? master.getCreatureAttribute() : super.getCreatureAttribute());
	}

	@Override
	public EnumCreatureAttribute superGetCreatureAttribute() {
		return super.getCreatureAttribute();
	}

	@Override
	public void setSprinting(boolean par1) {
		if (master != null) master.setSprinting(par1);
		else super.setSprinting(par1);
	}

	@Override
	public void superSetSprinting(boolean par1) {
		super.setSprinting(par1);
	}

	@Override
	protected float getSoundVolume() {
		return master != null ? master.getSoundVolume() : super.getSoundVolume();
	}

	@Override
	public float superGetSoundVolume() {
		return super.getSoundVolume();
	}

	@Override
	protected float getSoundPitch() {
		return master != null ? master.getSoundPitch() : super.getSoundPitch();
	}

	@Override
	public float superGetSoundPitch() {
		return super.getSoundPitch();
	}

	@Override
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}

	@Override
	public boolean superIsMovementBlocked() {
		return super.isMovementBlocked();
	}

	@Override
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		if (master != null) master.setPositionAndUpdate(par1, par3, par5);
		else super.setPositionAndUpdate(par1, par3, par5);
	}

	@Override
	public void superSetPositionAndUpdate(double par1, double par3, double par5) {
		super.setPositionAndUpdate(par1, par3, par5);
	}

	@Override
	public void dismountEntity(Entity entity) {
		if (master != null) master.dismountEntity(entity);
		else super.dismountEntity(entity);
	}

	@Override
	public void superDismountEntity(Object entity) {
		super.dismountEntity((Entity) entity);
	}

	@Override
	protected void jump() {
		if (master != null) master.jump();
		else super.jump();
	}

	@Override
	public void superJump() {
		super.jump();
	}

	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		if (master != null) master.moveEntityWithHeading(par1, par2);
		else super.moveEntityWithHeading(par1, par2);
	}

	@Override
	public void superMoveEntityWithHeading(float par1, float par2) {
		super.moveEntityWithHeading(par1, par2);
	}

	@Override
	public float getAIMoveSpeed() {
		return master != null ? master.getAIMoveSpeed() : super.getAIMoveSpeed();
	}

	@Override
	public float superGetAIMoveSpeed() {
		return super.getAIMoveSpeed();
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return master != null ? master.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}

	@Override
	public boolean superAttackEntityAsMob(Object entity) {
		return super.attackEntityAsMob((Entity) entity);
	}

	@Override
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}

	@Override
	public boolean superIsPlayerSleeping() {
		return super.isPlayerSleeping();
	}

	@Override
	protected void collideWithNearbyEntities() {
		if (master != null) master.collideWithNearbyEntities();
		else super.collideWithNearbyEntities();
	}

	@Override
	public void superCollideWithNearbyEntities() {
		super.collideWithNearbyEntities();
	}

	@Override
	protected void collideWithEntity(Entity entity) {
		if (master != null) master.collideWithEntity(entity);
		else super.collideWithEntity(entity);
	}

	@Override
	public void superCollideWithEntity(Object entity) {
		super.collideWithEntity((Entity) entity);
	}

	@Override
	public void updateRidden() {
		if (master != null) master.updateRidden();
		else super.updateRidden();
	}

	@Override
	public void superUpdateRidden() {
		super.updateRidden();
	}

	@Override
	public void setJumping(boolean par1) {
		if (master != null) master.setJumping(par1);
		else super.setJumping(par1);
	}

	@Override
	public void superSetJumping(boolean par1) {
		super.setJumping(par1);
	}

	@Override
	public void onItemPickup(Entity entity, int par2) {
		if (master != null) master.onItemPickup(entity, par2);
		else super.onItemPickup(entity, par2);
	}

	@Override
	public void superOnItemPickup(Object entity, int par2) {
		super.onItemPickup((Entity) entity, par2);
	}

	@Override
	public boolean canEntityBeSeen(Entity entity) {
		return master != null ? master.canEntityBeSeen(entity) : super.canEntityBeSeen(entity);
	}

	@Override
	public boolean superCanEntityBeSeen(Object entity) {
		return super.canEntityBeSeen((Entity) entity);
	}

	@Override
	public Vec3d getLookVec() {
		return (Vec3d) (master != null ? master.getLookVec() : super.getLookVec());
	}

	@Override
	public Object superGetLookVec() {
		return super.getLookVec();
	}

	@Override
	public Vec3d getLook(float par1) {
		return (Vec3d) (master != null ? master.getLook(par1) : super.getLook(par1));
	}

	@Override
	public Object superGetLook(float par1) {
		return super.getLook(par1);
	}

	@Override
	public float getSwingProgress(float par1) {
		return master != null ? master.getSwingProgress(par1) : super.getSwingProgress(par1);
	}

	@Override
	public float superGetSwingProgress(float par1) {
		return super.getSwingProgress(par1);
	}

	@Override
	public boolean canBeCollidedWith() {
		return master != null ? master.canBeCollidedWith() : super.canBeCollidedWith();
	}

	@Override
	public boolean superCanBeCollidedWith() {
		return super.canBeCollidedWith();
	}

	@Override
	public boolean canBePushed() {
		return master != null ? master.canBePushed() : super.canBePushed();
	}

	@Override
	public boolean superCanBePushed() {
		return super.canBePushed();
	}

	@Override
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}

	@Override
	public float superGetEyeHeight() {
		return super.getEyeHeight();
	}

	@Override
	protected void setBeenAttacked() {
		if (master != null) master.setBeenAttacked();
		else super.setBeenAttacked();
	}

	@Override
	public void superSetBeenAttacked() {
		super.setBeenAttacked();
	}

	@Override
	public float getRotationYawHead() {
		return master != null ? master.getRotationYawHead() : super.getRotationYawHead();
	}

	@Override
	public float superGetRotationYawHead() {
		return super.getRotationYawHead();
	}

	@Override
	public void setRotationYawHead(float par1) {
		if (master != null) master.setRotationYawHead(par1);
		else super.setRotationYawHead(par1);
	}

	@Override
	public void superSetRotationYawHead(float par1) {
		super.setRotationYawHead(par1);
	}

	@Override
	public float getAbsorptionAmount() {
		return master != null ? master.getAbsorptionAmount() : super.getAbsorptionAmount();
	}

	@Override
	public float superGetAbsorptionAmount() {
		return super.getAbsorptionAmount();
	}

	@Override
	public void setAbsorptionAmount(float par1) {
		if (master != null) master.setAbsorptionAmount(par1);
		else super.setAbsorptionAmount(par1);
	}

	@Override
	public void superSetAbsorptionAmount(float par1) {
		super.setAbsorptionAmount(par1);
	}

	@Override
	public EntityDataManager getDataManager() {
		return (EntityDataManager) (master != null ? master.getDataManager() : super.getDataManager());
	}

	@Override
	public Object superGetDataManager() {
		return super.getDataManager();
	}
/*
	@Override
	public boolean equals(Object par1Obj) {
		return master != null ? master.equals(par1Obj) : super.equals(par1Obj);
	}

	@Override
	public boolean superEquals(Object par1Obj) {
		return super.equals(par1Obj);
	}

	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}

	@Override
	public int superHashCode() {
		return super.hashCode();
	}
*/
	@Override
	protected void preparePlayerToSpawn() {
		if (master != null) master.preparePlayerToSpawn();
		else super.preparePlayerToSpawn();
	}

	@Override
	public void superPreparePlayerToSpawn() {
		super.preparePlayerToSpawn();
	}

	@Override
	public void setDead() {
		if (master != null) master.setDead();
		else super.setDead();
	}

	@Override
	public void superSetDead() {
		super.setDead();
	}

	@Override
	protected void setRotation(float par1, float par2) {
		if (master != null) master.setRotation(par1, par2);
		else super.setRotation(par1, par2);
	}

	@Override
	public void superSetRotation(float par1, float par2) {
		super.setRotation(par1, par2);
	}

	@Override
	public void setPosition(double par1, double par3, double par5) {
		if (master != null) master.setPosition(par1, par3, par5);
		else super.setPosition(par1, par3, par5);
	}

	@Override
	public void superSetPosition(double par1, double par3, double par5) {
		super.setPosition(par1, par3, par5);
	}

	@Override
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}

	@Override
	public int superGetMaxInPortalTime() {
		return super.getMaxInPortalTime();
	}

	@Override
	protected void setOnFireFromLava() {
		if (master != null) master.setOnFireFromLava();
		else super.setOnFireFromLava();
	}

	@Override
	public void superSetOnFireFromLava() {
		super.setOnFireFromLava();
	}

	@Override
	public void setFire(int par1) {
		if (master != null) master.setFire(par1);
		else super.setFire(par1);
	}

	@Override
	public void superSetFire(int par1) {
		super.setFire(par1);
	}

	@Override
	public void extinguish() {
		if (master != null) master.extinguish();
		else super.extinguish();
	}

	@Override
	public void superExtinguish() {
		super.extinguish();
	}

	@Override
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return master != null ? master.isOffsetPositionInLiquid(par1, par3, par5) : super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public boolean superIsOffsetPositionInLiquid(double par1, double par3, double par5) {
		return super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public void playSound(SoundEvent soundEvent, float par2, float par3) {
		if (master != null) master.playSound(soundEvent, par2, par3);
		else super.playSound(soundEvent, par2, par3);
	}

	@Override
	public void superPlaySound(Object soundEvent, float par2, float par3) {
		super.playSound((SoundEvent) soundEvent, par2, par3);
	}

	@Override
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}

	@Override
	public boolean superCanTriggerWalking() {
		return super.canTriggerWalking();
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
	protected void dealFireDamage(int par1) {
		if (master != null) master.dealFireDamage(par1);
		else super.dealFireDamage(par1);
	}

	@Override
	public void superDealFireDamage(int par1) {
		super.dealFireDamage(par1);
	}

	@Override
	public boolean isWet() {
		return master != null ? master.isWet() : super.isWet();
	}

	@Override
	public boolean superIsWet() {
		return super.isWet();
	}

	@Override
	public boolean isInWater() {
		return master != null ? master.isInWater() : super.isInWater();
	}

	@Override
	public boolean superIsInWater() {
		return super.isInWater();
	}

	@Override
	public boolean handleWaterMovement() {
		return master != null ? master.handleWaterMovement() : super.handleWaterMovement();
	}

	@Override
	public boolean superHandleWaterMovement() {
		return super.handleWaterMovement();
	}

	@Override
	public boolean isInsideOfMaterial(Material material) {
		return master != null ? master.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}

	@Override
	public boolean superIsInsideOfMaterial(Object material) {
		return super.isInsideOfMaterial((Material) material);
	}

	@Override
	public boolean isNotColliding() {
		return master != null ? master.isNotColliding() : super.isNotColliding();
	}

	@Override
	public boolean superIsNotColliding() {
		return super.isNotColliding();
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return master != null ? master.getBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}

	@Override
	public int superGetBrightnessForRender(float par1) {
		return super.getBrightnessForRender(par1);
	}

	@Override
	public float getBrightness(float par1) {
		return master != null ? master.getBrightness(par1) : super.getBrightness(par1);
	}

	@Override
	public float superGetBrightness(float par1) {
		return super.getBrightness(par1);
	}

	@Override
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}

	@Override
	public void superSetWorld(Object world) {
		super.setWorld((World) world);
	}

	@Override
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setPositionAndRotation(par1, par3, par5, par7, par8);
		else super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	@Override
	public void superSetPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	@Override
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setLocationAndAngles(par1, par3, par5, par7, par8);
		else super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}

	@Override
	public void superSetLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}

	@Override
	public float getDistanceToEntity(Entity entity) {
		return master != null ? master.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}

	@Override
	public float superGetDistanceToEntity(Object entity) {
		return super.getDistanceToEntity((Entity) entity);
	}

	@Override
	public double getDistanceSq(double par1, double par3, double par5) {
		return master != null ? master.getDistanceSq(par1, par3, par5) : super.getDistanceSq(par1, par3, par5);
	}

	@Override
	public double superGetDistanceSq(double par1, double par3, double par5) {
		return super.getDistanceSq(par1, par3, par5);
	}

	@Override
	public double getDistance(double par1, double par3, double par5) {
		return master != null ? master.getDistance(par1, par3, par5) : super.getDistance(par1, par3, par5);
	}

	@Override
	public double superGetDistance(double par1, double par3, double par5) {
		return super.getDistance(par1, par3, par5);
	}

	@Override
	public double getDistanceSqToEntity(Entity entity) {
		return master != null ? master.getDistanceSqToEntity(entity) : super.getDistanceSqToEntity(entity);
	}

	@Override
	public double superGetDistanceSqToEntity(Object entity) {
		return super.getDistanceSqToEntity((Entity) entity);
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
		if (master != null) master.onCollideWithPlayer(entityPlayer);
		else super.onCollideWithPlayer(entityPlayer);
	}

	@Override
	public void superOnCollideWithPlayer(Object entityPlayer) {
		super.onCollideWithPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		if (master != null) master.applyEntityCollision(entity);
		else super.applyEntityCollision(entity);
	}

	@Override
	public void superApplyEntityCollision(Object entity) {
		super.applyEntityCollision((Entity) entity);
	}

	@Override
	public void addVelocity(double par1, double par3, double par5) {
		if (master != null) master.addVelocity(par1, par3, par5);
		else super.addVelocity(par1, par3, par5);
	}

	@Override
	public void superAddVelocity(double par1, double par3, double par5) {
		super.addVelocity(par1, par3, par5);
	}

	@Override
	public void addToPlayerScore(Entity entity, int par2) {
		if (master != null) master.addToPlayerScore(entity, par2);
		else super.addToPlayerScore(entity, par2);
	}

	@Override
	public void superAddToPlayerScore(Object entity, int par2) {
		super.addToPlayerScore((Entity) entity, par2);
	}

	@Override
	public boolean isInRangeToRenderDist(double par1) {
		return master != null ? master.isInRangeToRenderDist(par1) : super.isInRangeToRenderDist(par1);
	}

	@Override
	public boolean superIsInRangeToRenderDist(double par1) {
		return super.isInRangeToRenderDist(par1);
	}

	@Override
	public boolean writeToNBTAtomically(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTAtomically(nBTTagCompound) : super.writeToNBTAtomically(nBTTagCompound);
	}

	@Override
	public boolean superWriteToNBTAtomically(Object nBTTagCompound) {
		return super.writeToNBTAtomically((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTOptional(nBTTagCompound) : super.writeToNBTOptional(nBTTagCompound);
	}

	@Override
	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return super.writeToNBTOptional((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}

	@Override
	public void superReadFromNBT(Object nBTTagCompound) {
		super.readFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected boolean shouldSetPosAfterLoading() {
		return master != null ? master.shouldSetPosAfterLoading() : super.shouldSetPosAfterLoading();
	}

	@Override
	public boolean superShouldSetPosAfterLoading() {
		return super.shouldSetPosAfterLoading();
	}

	@Override
	protected NBTTagList newDoubleNBTList(double... par1ArrayOfDouble) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(par1ArrayOfDouble) : super.newDoubleNBTList(par1ArrayOfDouble));
	}

	@Override
	public NBTTagList superNewDoubleNBTList(double... par1ArrayOfDouble) {
		return super.newDoubleNBTList(par1ArrayOfDouble);
	}

	@Override
	protected NBTTagList newFloatNBTList(float... par1ArrayOfFloat) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(par1ArrayOfFloat) : super.newFloatNBTList(par1ArrayOfFloat));
	}

	@Override
	public NBTTagList superNewFloatNBTList(float... par1ArrayOfFloat) {
		return super.newFloatNBTList(par1ArrayOfFloat);
	}

	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float par2) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, par2) : super.entityDropItem(itemStack, par2));
	}

	@Override
	public EntityItem superEntityDropItem(Object itemStack, float par2) {
		return super.entityDropItem((ItemStack) itemStack, par2);
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return master != null ? master.isEntityInsideOpaqueBlock() : super.isEntityInsideOpaqueBlock();
	}

	@Override
	public boolean superIsEntityInsideOpaqueBlock() {
		return super.isEntityInsideOpaqueBlock();
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBox(entity) : super.getCollisionBox(entity));
	}

	@Override
	public AxisAlignedBB superGetCollisionBox(Object entity) {
		return super.getCollisionBox((Entity) entity);
	}

	@Override
	public void updatePassenger(Entity entity) {
		if (master != null) master.updatePassenger(entity);
		else super.updatePassenger(entity);
	}

	@Override
	public void superUpdatePassenger(Object entity) {
		super.updatePassenger((Entity) entity);
	}

	@Override
	public double getYOffset() {
		return master != null ? master.getYOffset() : super.getYOffset();
	}

	@Override
	public double superGetYOffset() {
		return super.getYOffset();
	}

	@Override
	public double getMountedYOffset() {
		return master != null ? master.getMountedYOffset() : super.getMountedYOffset();
	}

	@Override
	public double superGetMountedYOffset() {
		return super.getMountedYOffset();
	}

	@Override
	public boolean startRiding(Entity entity) {
		return master != null ? master.startRiding(entity) : super.startRiding(entity);
	}

	@Override
	public boolean superStartRiding(Object entity) {
		return super.startRiding((Entity) entity);
	}

	@Override
	public float getCollisionBorderSize() {
		return master != null ? master.getCollisionBorderSize() : super.getCollisionBorderSize();
	}

	@Override
	public float superGetCollisionBorderSize() {
		return super.getCollisionBorderSize();
	}

	@Override
	public void setPortal(BlockPos bockPos) {
		if (master != null) master.setPortal(bockPos);
		else super.setPortal(bockPos);
	}

	@Override
	public void superSetPortal(Object bockPos) {
		super.setPortal((BlockPos) bockPos);
	}

	@Override
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}

	@Override
	public int superGetPortalCooldown() {
		return super.getPortalCooldown();
	}

	@Override
	public void setVelocity(double par1, double par3, double par5) {
		if (master != null) master.setVelocity(par1, par3, par5);
		else super.setVelocity(par1, par3, par5);
	}

	@Override
	public void superSetVelocity(double par1, double par3, double par5) {
		super.setVelocity(par1, par3, par5);
	}

	@Override
	public boolean isBurning() {
		return master != null ? master.isBurning() : super.isBurning();
	}

	@Override
	public boolean superIsBurning() {
		return super.isBurning();
	}

	@Override
	public boolean isRiding() {
		return master != null ? master.isRiding() : super.isRiding();
	}

	@Override
	public boolean superIsRiding() {
		return super.isRiding();
	}

	@Override
	public boolean isSneaking() {
		return master != null ? master.isSneaking() : super.isSneaking();
	}

	@Override
	public boolean superIsSneaking() {
		return super.isSneaking();
	}

	@Override
	public void setSneaking(boolean par1) {
		if (master != null) master.setSneaking(par1);
		else super.setSneaking(par1);
	}

	@Override
	public void superSetSneaking(boolean par1) {
		super.setSneaking(par1);
	}

	@Override
	public boolean isSprinting() {
		return master != null ? master.isSprinting() : super.isSprinting();
	}

	@Override
	public boolean superIsSprinting() {
		return super.isSprinting();
	}

	@Override
	public boolean isInvisible() {
		return master != null ? master.isInvisible() : super.isInvisible();
	}

	@Override
	public boolean superIsInvisible() {
		return super.isInvisible();
	}

	@Override
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}

	@Override
	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void setInvisible(boolean par1) {
		if (master != null) master.setInvisible(par1);
		else super.setInvisible(par1);
	}

	@Override
	public void superSetInvisible(boolean par1) {
		super.setInvisible(par1);
	}

	@Override
	protected boolean getFlag(int par1) {
		return master != null ? master.getFlag(par1) : super.getFlag(par1);
	}

	@Override
	public boolean superGetFlag(int par1) {
		return super.getFlag(par1);
	}

	@Override
	protected void setFlag(int par1, boolean par2) {
		if (master != null) master.setFlag(par1, par2);
		else super.setFlag(par1, par2);
	}

	@Override
	public void superSetFlag(int par1, boolean par2) {
		super.setFlag(par1, par2);
	}

	@Override
	public int getAir() {
		return master != null ? master.getAir() : super.getAir();
	}

	@Override
	public int superGetAir() {
		return super.getAir();
	}

	@Override
	public void setAir(int par1) {
		if (master != null) master.setAir(par1);
		else super.setAir(par1);
	}

	@Override
	public void superSetAir(int par1) {
		super.setAir(par1);
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		if (master != null) master.onStruckByLightning(entityLightningBolt);
		else super.onStruckByLightning(entityLightningBolt);
	}

	@Override
	public void superOnStruckByLightning(Object entityLightningBolt) {
		super.onStruckByLightning((EntityLightningBolt) entityLightningBolt);
	}

	@Override
	public void onKillEntity(EntityLivingBase entityLivingBase) {
		if (master != null) master.onKillEntity(entityLivingBase);
		else super.onKillEntity(entityLivingBase);
	}

	@Override
	public void superOnKillEntity(Object entityLivingBase) {
		super.onKillEntity((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void setInWeb() {
		if (master != null) master.setInWeb();
		else super.setInWeb();
	}

	@Override
	public void superSetInWeb() {
		super.setInWeb();
	}

	@Override
	public Entity[] getParts() {
		return (Entity[]) (master != null ? master.getParts() : super.getParts());
	}

	@Override
	public Entity[] superGetParts() {
		return super.getParts();
	}

	@Override
	public boolean isEntityEqual(Entity entity) {
		return master != null ? master.isEntityEqual(entity) : super.isEntityEqual(entity);
	}

	@Override
	public boolean superIsEntityEqual(Object entity) {
		return super.isEntityEqual((Entity) entity);
	}

	@Override
	public boolean hitByEntity(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.hitByEntity(entity);
	}

	@Override
	public boolean superHitByEntity(Object entity) {
		return super.hitByEntity((Entity) entity);
	}

	@Override
	public boolean isEntityInvulnerable(DamageSource damageSource) {
		return master != null ? master.isEntityInvulnerable(damageSource) : super.isEntityInvulnerable(damageSource);
	}

	@Override
	public boolean superIsEntityInvulnerable(Object damageSource) {
		return super.isEntityInvulnerable((DamageSource) damageSource);
	}

	@Override
	public void copyLocationAndAnglesFrom(Entity entity) {
		if (master != null) master.copyLocationAndAnglesFrom(entity);
		else super.copyLocationAndAnglesFrom(entity);
	}

	@Override
	public void superCopyLocationAndAnglesFrom(Object entity) {
		super.copyLocationAndAnglesFrom((Entity) entity);
	}

	@Override
	public Entity changeDimension(int par1) {
		return (Entity) (master != null ? master.changeDimension(par1) : super.changeDimension(par1));
	}

	@Override
	public Object superChangeDimension(int par1) {
		return super.changeDimension(par1);
	}

	@Override
	public Vec3d getLastPortalVec() {
		return (Vec3d) (master != null ? master.getLastPortalVec() : super.getLastPortalVec());
	}

	@Override
	public Object superGetLastPortalVec() {
		return super.getLastPortalVec();
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return master != null ? master.doesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}

	@Override
	public boolean superDoesEntityNotTriggerPressurePlate() {
		return super.doesEntityNotTriggerPressurePlate();
	}

	@Override
	public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
		if (master != null) master.addEntityCrashInfo(crashReportCategory);
		else super.addEntityCrashInfo(crashReportCategory);
	}

	@Override
	public void superAddEntityCrashInfo(Object crashReportCategory) {
		super.addEntityCrashInfo((CrashReportCategory) crashReportCategory);
	}

	@Override
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}

	@Override
	public boolean superCanRenderOnFire() {
		return super.canRenderOnFire();
	}

	@Override
	public UUID getUniqueID() {
		return master != null ? master.getUniqueID() : super.getUniqueID();
	}

	@Override
	public UUID superGetUniqueID() {
		return super.getUniqueID();
	}

	@Override
	public boolean isPushedByWater() {
		return master != null ? master.isPushedByWater() : super.isPushedByWater();
	}

	@Override
	public boolean superIsPushedByWater() {
		return super.isPushedByWater();
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficultyInstance, IEntityLivingData iEntityLivingData) {
		return (IEntityLivingData) (master != null ? master.onInitialSpawn(iEntityLivingData) : super.onInitialSpawn(difficultyInstance, iEntityLivingData));
	}

	@Override
	public Object superOnInitialSpawn(Object difficultyInstance, Object iEntityLivingData) {
		return super.onInitialSpawn((DifficultyInstance) difficultyInstance, (IEntityLivingData) iEntityLivingData);
	}

	@Override
	protected void doBlockCollisions() {
		if (master != null) master.doBlockCollisions();
		else super.doBlockCollisions();
	}
	// 190~
	@Override
	protected void setupTamedAI() {
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
	protected void consumeItemFromStack(EntityPlayer entityPlayer, ItemStack itemStack) {
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
	public void notifyDataManagerChange(DataParameter<?> dataParameter) {
		if (master != null) master.notifyDataManagerChange(dataParameter);
		else super.notifyDataManagerChange(dataParameter);
	}

	@Override
	public void superNotifyDataManagerChange(Object dataParameter) {
		super.notifyDataManagerChange((DataParameter) dataParameter);
	}

	@Override
	protected void onGrowingAdult() {
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
	protected void updateLeashedState() {
		if (master != null) master.updateLeashedState();
		else super.updateLeashedState();
	}

	@Override
	public void superUpdateLeashedState() {
		super.updateLeashedState();
	}

	@Override
	protected void initEntityAI() {
		if (master != null) master.initEntityAI();
		else super.initEntityAI();
	}

	@Override
	public void superInitEntityAI() {
		super.initEntityAI();
	}

	@Override
	public float getPathPriority(PathNodeType pathNodeType) {
		return master != null ? master.getPathPriority(pathNodeType) : super.getPathPriority(pathNodeType);
	}

	@Override
	public float superGetPathPriority(Object pathNodeType) {
		return super.getPathPriority((PathNodeType) pathNodeType);
	}

	@Override
	public void setPathPriority(PathNodeType pathNodeType, float p_184644_2_) {
		if (master != null) master.setPathPriority(pathNodeType, p_184644_2_);
		else super.setPathPriority(pathNodeType, p_184644_2_);
	}

	@Override
	public void superSetPathPriority(Object pathNodeType, float p_184644_2_) {
		super.setPathPriority((PathNodeType) pathNodeType, p_184644_2_);
	}

	@Override
	protected EntityBodyHelper createBodyHelper() {
		return (EntityBodyHelper) (master != null ? master.createBodyHelper() : super.createBodyHelper());
	}

	@Override
	public EntityBodyHelper superCreateBodyHelper() {
		return super.createBodyHelper();
	}

	@Override
	protected void playHurtSound(DamageSource damageSource) {
		if (master != null) master.playHurtSound(damageSource);
		else super.playHurtSound(damageSource);
	}

	@Override
	public void superPlayHurtSound(Object damageSource) {
		super.playHurtSound((DamageSource) damageSource);
	}

	@Override
	protected Item getDropItem() {
		return (Item) (master != null ? master.getDropItem() : super.getDropItem());
	}

	@Override
	public Item superGetDropItem() {
		return super.getDropItem();
	}

	@Override
	protected ResourceLocation getLootTable() {
		return (ResourceLocation) (master != null ? master.getLootTable() : super.getLootTable());
	}

	@Override
	public ResourceLocation superGetLootTable() {
		return super.getLootTable();
	}

	@Override
	public void setMoveStrafing(float p_184646_1_) {
		if (master != null) master.setMoveStrafing(p_184646_1_);
		else super.setMoveStrafing(p_184646_1_);
	}

	@Override
	public void superSetMoveStrafing(float p_184646_1_) {
		super.setMoveStrafing(p_184646_1_);
	}

	@Override
	protected void updateEquipmentIfNeeded(EntityItem entityItem) {
		if (master != null) master.updateEquipmentIfNeeded(entityItem);
		else super.updateEquipmentIfNeeded(entityItem);
	}

	@Override
	public void superUpdateEquipmentIfNeeded(Object entityItem) {
		super.updateEquipmentIfNeeded((EntityItem) entityItem);
	}

	@Override
	public int getMaxFallHeight() {
		return master != null ? master.getMaxFallHeight() : super.getMaxFallHeight();
	}

	@Override
	public int superGetMaxFallHeight() {
		return super.getMaxFallHeight();
	}

	@Override
	public Iterable<ItemStack> getHeldEquipment() {
		return (Iterable<ItemStack>) (master != null ? master.getHeldEquipment() : super.getHeldEquipment());
	}

	@Override
	public Iterable<ItemStack> superGetHeldEquipment() {
		return super.getHeldEquipment();
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList() {
		return (Iterable<ItemStack>) (master != null ? master.getArmorInventoryList() : super.getArmorInventoryList());
	}

	@Override
	public Iterable<ItemStack> superGetArmorInventoryList() {
		return super.getArmorInventoryList();
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot entityEquipmentSlot) {
		return (ItemStack) (master != null ? master.getItemStackFromSlot(entityEquipmentSlot) : super.getItemStackFromSlot(entityEquipmentSlot));
	}

	@Override
	public ItemStack superGetItemStackFromSlot(Object entityEquipmentSlot) {
		return super.getItemStackFromSlot((EntityEquipmentSlot) entityEquipmentSlot);
	}

	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficultyInstance) {
		if (master != null) master.setEquipmentBasedOnDifficulty(difficultyInstance);
		else super.setEquipmentBasedOnDifficulty(difficultyInstance);
	}

	@Override
	public void superSetEquipmentBasedOnDifficulty(Object difficultyInstance) {
		super.setEquipmentBasedOnDifficulty((DifficultyInstance) difficultyInstance);
	}

	@Override
	protected void setEnchantmentBasedOnDifficulty(DifficultyInstance difficultyInstance) {
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
	public boolean startRiding(Entity entity, boolean force) {
		return master != null ? master.startRiding(entity, force) : super.startRiding(entity, force);
	}

	@Override
	public boolean superStartRiding(Object entity, boolean force) {
		return super.startRiding((Entity) entity, force);
	}

	@Override
	public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStack) {
		return master != null ? master.replaceItemInInventory(inventorySlot, itemStack) : super.replaceItemInInventory(inventorySlot, itemStack);
	}

	@Override
	public boolean superReplaceItemInInventory(int inventorySlot, Object itemStack) {
		return super.replaceItemInInventory(inventorySlot, (ItemStack) itemStack);
	}

	@Override
	public boolean isServerWorld() {
		return master != null ? master.isServerWorld() : super.isServerWorld();
	}

	@Override
	public boolean superIsServerWorld() {
		return super.isServerWorld();
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
	public void setLeftHanded(boolean p_184641_1_) {
		if (master != null) master.setLeftHanded(p_184641_1_);
		else super.setLeftHanded(p_184641_1_);
	}

	@Override
	public void superSetLeftHanded(boolean p_184641_1_) {
		super.setLeftHanded(p_184641_1_);
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
	public boolean isLeftHanded() {
		return master != null ? master.isLeftHanded() : super.isLeftHanded();
	}

	@Override
	public boolean superIsLeftHanded() {
		return super.isLeftHanded();
	}

	@Override
	public EnumHandSide getPrimaryHand() {
		return (EnumHandSide) (master != null ? master.getPrimaryHand() : super.getPrimaryHand());
	}

	@Override
	public EnumHandSide superGetPrimaryHand() {
		return super.getPrimaryHand();
	}

	@Override
	public void onKillCommand() {
		if (master != null) master.onKillCommand();
		else super.onKillCommand();
	}

	@Override
	public void superOnKillCommand() {
		super.onKillCommand();
	}

	@Override
	protected void updateFallState(double y, boolean onGroundIn, IBlockState iBlockState, BlockPos blockPos) {
		if (master != null) master.updateFallState(y, onGroundIn, iBlockState, blockPos);
		else super.updateFallState(y, onGroundIn, iBlockState, blockPos);
	}

	@Override
	public void superUpdateFallState(double y, boolean onGroundIn, Object iBlockState, Object blockPos) {
		super.updateFallState(y, onGroundIn, (IBlockState) iBlockState, (BlockPos) blockPos);
	}

	@Override
	protected void frostWalk(BlockPos blockPos) {
		if (master != null) master.frostWalk(blockPos);
		else super.frostWalk(blockPos);
	}

	@Override
	public void superFrostWalk(Object blockPos) {
		super.frostWalk((BlockPos) blockPos);
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
	public int getRevengeTimer() {
		return master != null ? master.getRevengeTimer() : super.getRevengeTimer();
	}

	@Override
	public int superGetRevengeTimer() {
		return super.getRevengeTimer();
	}

	@Override
	protected void playEquipSound(ItemStack itemStack) {
		if (master != null) master.playEquipSound(itemStack);
		else super.playEquipSound(itemStack);
	}

	@Override
	public void superPlayEquipSound(Object itemStack) {
		super.playEquipSound((ItemStack) itemStack);
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
	public PotionEffect removeActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.removeActivePotionEffect(potion) : super.removeActivePotionEffect(potion));
	}

	@Override
	public PotionEffect superRemoveActivePotionEffect(Object potion) {
		return super.removeActivePotionEffect((Potion) potion);
	}

	@Override
	public void removePotionEffect(Potion potion) {
		if (master != null) master.removePotionEffect(potion);
		else super.removePotionEffect(potion);
	}

	@Override
	public void superRemovePotionEffect(Object potion) {
		super.removePotionEffect((Potion) potion);
	}

	@Override
	protected SoundEvent getFallSound(int heightIn) {
		return (SoundEvent) (master != null ? master.getFallSound(heightIn) : super.getFallSound(heightIn));
	}

	@Override
	public Object superGetFallSound(int heightIn) {
		return super.getFallSound(heightIn);
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		if (master != null) master.fall(distance, damageMultiplier);
		else super.fall(distance, damageMultiplier);
	}

	@Override
	public void superFall(float distance, float damageMultiplier) {
		super.fall(distance, damageMultiplier);
	}

	@Override
	protected void damageShield(float p_184590_1_) {
		if (master != null) master.damageShield(p_184590_1_);
		else super.damageShield(p_184590_1_);
	}

	@Override
	public void superDamageShield(float p_184590_1_) {
		super.damageShield(p_184590_1_);
	}

	@Override
	public IAttributeInstance getEntityAttribute(IAttribute iAttribute) {
		return (IAttributeInstance) (master != null ? master.getEntityAttribute(iAttribute) : super.getEntityAttribute(iAttribute));
	}

	@Override
	public IAttributeInstance superGetEntityAttribute(Object iAttribute) {
		return super.getEntityAttribute((IAttribute) iAttribute);
	}

	@Override
	public ItemStack getHeldItemMainhand() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getHeldItemMainhand());
	}

	@Override
	public ItemStack superGetHeldItemMainhand() {
		return super.getHeldItemMainhand();
	}

	@Override
	public ItemStack getHeldItemOffhand() {
		return (ItemStack) (master != null ? master.getHeldItemOffhand() : super.getHeldItemOffhand());
	}

	@Override
	public ItemStack superGetHeldItemOffhand() {
		return super.getHeldItemOffhand();
	}

	@Override
	public ItemStack getHeldItem(EnumHand enumHand) {
		return (ItemStack) (master != null ? master.getHeldItem(enumHand) : super.getHeldItem(enumHand));
	}

	@Override
	public ItemStack superGetHeldItem(Object enumHand) {
		return super.getHeldItem((EnumHand) enumHand);
	}

	@Override
	public void setHeldItem(EnumHand enumHand, ItemStack itemStack) {
		if (master != null) master.setHeldItem(enumHand, itemStack);
		else super.setHeldItem(enumHand, itemStack);
	}

	@Override
	public void superSetHeldItem(Object enumHand, Object itemStack) {
		super.setHeldItem((EnumHand) enumHand, (ItemStack) itemStack);
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
	public void superUpdateEntityActionState() {
		super.updateEntityActionState();
	}

	@Override
	public void dismountRidingEntity() {
		if (master != null) master.dismountRidingEntity();
		else super.dismountRidingEntity();
	}

	@Override
	public void superDismountRidingEntity() {
		super.dismountRidingEntity();
	}

	@Override
	public void setRenderYawOffset(float offset) {
		if (master != null) master.setRenderYawOffset(offset);
		else super.setRenderYawOffset(offset);
	}

	@Override
	public void superSetRenderYawOffset(float offset) {
		super.setRenderYawOffset(offset);
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
	public void curePotionEffects(ItemStack itemStack) {
		if (master != null) master.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}

	@Override
	public void superCurePotionEffects(Object itemStack) {
		super.curePotionEffects((ItemStack) itemStack);
	}

	@Override
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return master != null ? master.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}

	@Override
	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isHandActive() {
		return master != null ? master.isHandActive() : super.isHandActive();
	}

	@Override
	public boolean superIsHandActive() {
		return super.isHandActive();
	}

	@Override
	public EnumHand getActiveHand() {
		return (EnumHand) (master != null ? master.getActiveHand() : super.getActiveHand());
	}

	@Override
	public EnumHand superGetActiveHand() {
		return super.getActiveHand();
	}

	@Override
	protected void updateActiveHand() {
		if (master != null) master.updateActiveHand();
		else super.updateActiveHand();
	}

	@Override
	public void superUpdateActiveHand() {
		super.updateActiveHand();
	}

	@Override
	public void setActiveHand(EnumHand enumHand) {
		if (master != null) master.setActiveHand(enumHand);
		else super.setActiveHand(enumHand);
	}

	@Override
	public void superSetActiveHand(Object enumHand) {
		super.setActiveHand((EnumHand) enumHand);
	}

	@Override
	protected void updateItemUse(ItemStack itemStack, int p_184584_2_) {
		if (master != null) master.updateItemUse(itemStack, p_184584_2_);
		else super.updateItemUse(itemStack, p_184584_2_);
	}

	@Override
	public void superUpdateItemUse(Object itemStack, int p_184584_2_) {
		super.updateItemUse((ItemStack) itemStack, p_184584_2_);
	}

	@Override
	protected void onItemUseFinish() {
		if (master != null) master.onItemUseFinish();
		else super.onItemUseFinish();
	}

	@Override
	public void superOnItemUseFinish() {
		super.onItemUseFinish();
	}

	@Override
	public ItemStack getActiveItemStack() {
		return (ItemStack) (master != null ? master.getActiveItemStack() : super.getActiveItemStack());
	}

	@Override
	public ItemStack superGetActiveItemStack() {
		return super.getActiveItemStack();
	}

	@Override
	public int getItemInUseCount() {
		return master != null ? master.getItemInUseCount() : super.getItemInUseCount();
	}

	@Override
	public int superGetItemInUseCount() {
		return super.getItemInUseCount();
	}

	@Override
	public int getItemInUseMaxCount() {
		return master != null ? master.getItemInUseMaxCount() : super.getItemInUseMaxCount();
	}

	@Override
	public int superGetItemInUseMaxCount() {
		return super.getItemInUseMaxCount();
	}

	@Override
	public void stopActiveHand() {
		if (master != null) master.stopActiveHand();
		else super.stopActiveHand();
	}

	@Override
	public void superStopActiveHand() {
		super.stopActiveHand();
	}

	@Override
	public void resetActiveHand() {
		if (master != null) master.resetActiveHand();
		else super.resetActiveHand();
	}

	@Override
	public void superResetActiveHand() {
		super.resetActiveHand();
	}

	@Override
	public boolean isActiveItemStackBlocking() {
		return master != null ? master.isActiveItemStackBlocking() : super.isActiveItemStackBlocking();
	}

	@Override
	public boolean superIsActiveItemStackBlocking() {
		return super.isActiveItemStackBlocking();
	}

	@Override
	public boolean isElytraFlying() {
		return master != null ? master.isElytraFlying() : super.isElytraFlying();
	}

	@Override
	public boolean superIsElytraFlying() {
		return super.isElytraFlying();
	}

	@Override
	public int getTicksElytraFlying() {
		return master != null ? master.getTicksElytraFlying() : super.getTicksElytraFlying();
	}

	@Override
	public int superGetTicksElytraFlying() {
		return super.getTicksElytraFlying();
	}

	@Override
	public boolean canBeHitWithPotion() {
		return master != null ? master.canBeHitWithPotion() : super.canBeHitWithPotion();
	}

	@Override
	public boolean superCanBeHitWithPotion() {
		return super.canBeHitWithPotion();
	}

	@Override
	public int getEntityId() {
		return master != null ? master.getEntityId() : super.getEntityId();
	}

	@Override
	public int superGetEntityId() {
		return super.getEntityId();
	}

	@Override
	public void setEntityId(int id) {
		if (master != null) master.setEntityId(id);
		else super.setEntityId(id);
	}

	@Override
	public void superSetEntityId(int id) {
		super.setEntityId(id);
	}

	@Override
	public Set<String> getTags() {
		return (Set<String>) (master != null ? master.getTags() : super.getTags());
	}

	@Override
	public Set<String> superGetTags() {
		return super.getTags();
	}

	@Override
	public boolean addTag(String tag) {
		return master != null ? master.addTag(tag) : super.addTag(tag);
	}

	@Override
	public boolean superAddTag(String tag) {
		return super.addTag(tag);
	}

	@Override
	public boolean removeTag(String tag) {
		return master != null ? master.removeTag(tag) : super.removeTag(tag);
	}

	@Override
	public boolean superRemoveTag(String tag) {
		return super.removeTag(tag);
	}

	@Override
	public boolean equals(Object p_equals_1_) {
		return master != null ? master.equals(p_equals_1_) : super.equals(p_equals_1_);
	}

	@Override
	public boolean superEquals(Object p_equals_1_) {
		return super.equals(p_equals_1_);
	}

	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}

	@Override
	public int superHashCode() {
		return super.hashCode();
	}

	@Override
	public void setDropItemsWhenDead(boolean p_184174_1_) {
		if (master != null) master.setDropItemsWhenDead(p_184174_1_);
		else super.setDropItemsWhenDead(p_184174_1_);
	}

	@Override
	public void superSetDropItemsWhenDead(boolean p_184174_1_) {
		super.setDropItemsWhenDead(p_184174_1_);
	}

	@Override
	public void superSetSize(float width, float height) {
		super.setSize(width, height);
	}

	@Override
	protected void decrementTimeUntilPortal() {
		if (master != null) master.decrementTimeUntilPortal();
		else super.decrementTimeUntilPortal();
	}

	@Override
	public void superDecrementTimeUntilPortal() {
		super.decrementTimeUntilPortal();
	}

	@Override
	public void resetPositionToBB() {
		if (master != null) master.resetPositionToBB();
		else super.resetPositionToBB();
	}

	@Override
	public void superResetPositionToBB() {
		super.resetPositionToBB();
	}

	@Override
	protected SoundEvent getSwimSound() {
		return (SoundEvent) (master != null ? master.getSwimSound() : super.getSwimSound());
	}

	@Override
	public Object superGetSwimSound() {
		return super.getSwimSound();
	}

	@Override
	protected SoundEvent getSplashSound() {
		return (SoundEvent) (master != null ? master.getSplashSound() : super.getSplashSound());
	}

	@Override
	public SoundEvent superGetSplashSound() {
		return super.getSplashSound();
	}

	@Override
	protected void playStepSound(BlockPos blockPos, Block block) {
		if (master != null) master.playStepSound(blockPos, block);
		else super.playStepSound(blockPos, block);
	}

	@Override
	public void superPlayStepSound(Object blockPos, Object block) {
		super.playStepSound((BlockPos) blockPos, (Block) block);
	}

	@Override
	public boolean isSilent() {
		return master != null ? master.isSilent() : super.isSilent();
	}

	@Override
	public boolean superIsSilent() {
		return super.isSilent();
	}

	@Override
	public void setSilent(boolean isSilent) {
		if (master != null) master.setSilent(isSilent);
		else super.setSilent(isSilent);
	}

	@Override
	public void superSetSilent(boolean isSilent) {
		super.setSilent(isSilent);
	}

	@Override
	protected void resetHeight() {
		if (master != null) master.resetHeight();
		else super.resetHeight();
	}

	@Override
	public void superResetHeight() {
		super.resetHeight();
	}

	@Override
	public void spawnRunningParticles() {
		if (master != null) master.spawnRunningParticles();
		else super.spawnRunningParticles();
	}

	@Override
	public void superSpawnRunningParticles() {
		super.spawnRunningParticles();
	}

	@Override
	protected void createRunningParticles() {
		if (master != null) master.createRunningParticles();
		else super.createRunningParticles();
	}

	@Override
	public void superCreateRunningParticles() {
		super.createRunningParticles();
	}

	@Override
	public boolean isInLava() {
		return master != null ? master.isInLava() : super.isInLava();
	}

	@Override
	public boolean superIsInLava() {
		return super.isInLava();
	}

	@Override
	public void moveToBlockPosAndAngles(BlockPos blockPos, float rotationYawIn, float rotationPitchIn) {
		if (master != null) master.moveToBlockPosAndAngles(blockPos, rotationYawIn, rotationPitchIn);
		else super.moveToBlockPosAndAngles(blockPos, rotationYawIn, rotationPitchIn);
	}

	@Override
	public void superMoveToBlockPosAndAngles(Object blockPos, float rotationYawIn, float rotationPitchIn) {
		super.moveToBlockPosAndAngles((BlockPos) blockPos, rotationYawIn, rotationPitchIn);
	}

	@Override
	public double getDistanceSq(BlockPos blockPos) {
		return master != null ? master.getDistanceSq(blockPos) : super.getDistanceSq(blockPos);
	}

	@Override
	public double superGetDistanceSq(Object blockPos) {
		return super.getDistanceSq((BlockPos) blockPos);
	}

	@Override
	public double getDistanceSqToCenter(BlockPos blockPos) {
		return master != null ? master.getDistanceSqToCenter(blockPos) : super.getDistanceSqToCenter(blockPos);
	}

	@Override
	public double superGetDistanceSqToCenter(Object blockPos) {
		return super.getDistanceSqToCenter((BlockPos) blockPos);
	}

	@Override
	public Vec3d getPositionEyes(float partialTicks) {
		return (Vec3d) (master != null ? master.getPositionEyes(partialTicks) : super.getPositionEyes(partialTicks));
	}

	@Override
	public Vec3d superGetPositionEyes(float partialTicks) {
		return super.getPositionEyes(partialTicks);
	}

	@Override
	public RayTraceResult rayTrace(double blockReachDistance, float partialTicks) {
		return (RayTraceResult) (master != null ? master.rayTrace(blockReachDistance, partialTicks) : super.rayTrace(blockReachDistance, partialTicks));
	}

	@Override
	public RayTraceResult superRayTrace(double blockReachDistance, float partialTicks) {
		return super.rayTrace(blockReachDistance, partialTicks);
	}

	@Override
	public boolean isInRangeToRender3d(double x, double y, double z) {
		return master != null ? master.isInRangeToRender3d(x, y, z) : super.isInRangeToRender3d(x, y, z);
	}

	@Override
	public boolean superIsInRangeToRender3d(double x, double y, double z) {
		return super.isInRangeToRender3d(x, y, z);
	}

	@Override
	public EntityItem dropItem(Item item, int size) {
		return (EntityItem) (master != null ? master.dropItem(item, size) : super.dropItem(item, size));
	}

	@Override
	public EntityItem superDropItem(Object item, int size) {
		return super.dropItem((Item) item, size);
	}

	@Override
	public EntityItem dropItemWithOffset(Item item, int size, float offsetY) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(item, size, offsetY) : super.dropItemWithOffset(item, size, offsetY));
	}

	@Override
	public EntityItem superDropItemWithOffset(Object item, int size, float offsetY) {
		return super.dropItemWithOffset((Item) item, size, offsetY);
	}

	@Override
	public void applyOrientationToEntity(Entity entity) {
		if (master != null) master.applyOrientationToEntity(entity);
		else super.applyOrientationToEntity(entity);
	}

	@Override
	public void superApplyOrientationToEntity(Object entity) {
		super.applyOrientationToEntity((Entity) entity);
	}

	@Override
	protected boolean canBeRidden(Entity entity) {
		return master != null ? master.canBeRidden(entity) : super.canBeRidden(entity);
	}

	@Override
	public boolean superCanBeRidden(Object entity) {
		return super.canBeRidden((Entity) entity);
	}

	@Override
	public void removePassengers() {
		if (master != null) master.removePassengers();
		else super.removePassengers();
	}

	@Override
	public void superRemovePassengers() {
		super.removePassengers();
	}

	@Override
	protected void addPassenger(Entity entity) {
		if (master != null) master.addPassenger(entity);
		else super.addPassenger(entity);
	}

	@Override
	public void superAddPassenger(Object entity) {
		super.addPassenger((Entity) entity);
	}

	@Override
	protected void removePassenger(Entity entity) {
		if (master != null) master.removePassenger(entity);
		else super.removePassenger(entity);
	}

	@Override
	public void superRemovePassenger(Object entity) {
		super.removePassenger((Entity) entity);
	}

	@Override
	protected boolean canFitPassenger(Entity entity) {
		return master != null ? master.canFitPassenger(entity) : super.canFitPassenger(entity);
	}

	@Override
	public boolean superCanFitPassenger(Object entity) {
		return super.canFitPassenger((Entity) entity);
	}

	@Override
	public Iterable<ItemStack> getEquipmentAndArmor() {
		return (Iterable<ItemStack>) (master != null ? master.getEquipmentAndArmor() : super.getEquipmentAndArmor());
	}

	@Override
	public Iterable<ItemStack> superGetEquipmentAndArmor() {
		return super.getEquipmentAndArmor();
	}

	@Override
	public boolean isBeingRidden() {
		return master != null ? master.isBeingRidden() : super.isBeingRidden();
	}

	@Override
	public boolean superIsBeingRidden() {
		return super.isBeingRidden();
	}

	@Override
	public boolean isGlowing() {
		return master != null ? master.isGlowing() : super.isGlowing();
	}

	@Override
	public boolean superIsGlowing() {
		return super.isGlowing();
	}

	@Override
	public void setGlowing(boolean p_184195_1_) {
		if (master != null) master.setGlowing(p_184195_1_);
		else super.setGlowing(p_184195_1_);
	}

	@Override
	public void superSetGlowing(boolean p_184195_1_) {
		super.setGlowing(p_184195_1_);
	}

	@Override
	public boolean isOnScoreboardTeam(Team team) {
		return master != null ? master.isOnScoreboardTeam(team) : super.isOnScoreboardTeam(team);
	}

	@Override
	public boolean superIsOnScoreboardTeam(Object team) {
		return super.isOnScoreboardTeam((Team) team);
	}

	@Override
	protected boolean pushOutOfBlocks(double x, double y, double z) {
		return master != null ? master.pushOutOfBlocks(x, y, z) : super.pushOutOfBlocks(x, y, z);
	}

	@Override
	public boolean superPushOutOfBlocks(double x, double y, double z) {
		return super.pushOutOfBlocks(x, y, z);
	}

	@Override
	public String getName() {
		return master != null ? master.getName() : super.getName();
	}

	@Override
	public String superGetName() {
		return super.getName();
	}

	@Override
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}

	@Override
	public String superToString() {
		return super.toString();
	}

	@Override
	public void setEntityInvulnerable(boolean isInvulnerable) {
		if (master != null) master.setEntityInvulnerable(isInvulnerable);
		else super.setEntityInvulnerable(isInvulnerable);
	}

	@Override
	public void superSetEntityInvulnerable(boolean isInvulnerable) {
		super.setEntityInvulnerable(isInvulnerable);
	}

	@Override
	public boolean isNonBoss() {
		return master != null ? master.isNonBoss() : super.isNonBoss();
	}

	@Override
	public boolean superIsNonBoss() {
		return super.isNonBoss();
	}

	@Override
	public float getExplosionResistance(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState) {
		return master != null ? master.getExplosionResistance(explosion, world, blockPos, iBlockState) : super.getExplosionResistance(explosion, world, blockPos, iBlockState);
	}

	@Override
	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return super.getExplosionResistance((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState);
	}

	@Override
	public boolean verifyExplosion(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float p_174816_5_) {
		return master != null ? master.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_) : super.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return super.verifyExplosion((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, p_174816_5_);
	}

	@Override
	public EnumFacing getTeleportDirection() {
		return (EnumFacing) (master != null ? master.getTeleportDirection() : super.getTeleportDirection());
	}

	@Override
	public Object superGetTeleportDirection() {
		return super.getTeleportDirection();
	}

	@Override
	public void setUniqueId(UUID uniqueIdIn) {
		if (master != null) master.setUniqueId(uniqueIdIn);
		else super.setUniqueId(uniqueIdIn);
	}

	@Override
	public void superSetUniqueId(UUID uniqueIdIn) {
		super.setUniqueId(uniqueIdIn);
	}

	@Override
	public ITextComponent getDisplayName() {
		return (ITextComponent) (master != null ? master.getDisplayName() : super.getDisplayName());
	}

	@Override
	public ITextComponent superGetDisplayName() {
		return super.getDisplayName();
	}

	@Override
	public EnumFacing getHorizontalFacing() {
		return (EnumFacing) (master != null ? master.getHorizontalFacing() : super.getHorizontalFacing());
	}

	@Override
	public EnumFacing superGetHorizontalFacing() {
		return super.getHorizontalFacing();
	}

	@Override
	public EnumFacing getAdjustedHorizontalFacing() {
		return (EnumFacing) (master != null ? master.getAdjustedHorizontalFacing() : super.getAdjustedHorizontalFacing());
	}

	@Override
	public EnumFacing superGetAdjustedHorizontalFacing() {
		return super.getAdjustedHorizontalFacing();
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
	public AxisAlignedBB getEntityBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getEntityBoundingBox() : super.getEntityBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetEntityBoundingBox() {
		return super.getEntityBoundingBox();
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getRenderBoundingBox() : super.getRenderBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetRenderBoundingBox() {
		return super.getRenderBoundingBox();
	}

	@Override
	public void setEntityBoundingBox(AxisAlignedBB axisAlignedBB) {
		if (master != null) master.setEntityBoundingBox(axisAlignedBB);
		else super.setEntityBoundingBox(axisAlignedBB);
	}

	@Override
	public void superSetEntityBoundingBox(Object axisAlignedBB) {
		super.setEntityBoundingBox((AxisAlignedBB) axisAlignedBB);
	}

	@Override
	public boolean isOutsideBorder() {
		return master != null ? master.isOutsideBorder() : super.isOutsideBorder();
	}

	@Override
	public boolean superIsOutsideBorder() {
		return super.isOutsideBorder();
	}

	@Override
	public void setOutsideBorder(boolean outsideBorder) {
		if (master != null) master.setOutsideBorder(outsideBorder);
		else super.setOutsideBorder(outsideBorder);
	}

	@Override
	public void superSetOutsideBorder(boolean outsideBorder) {
		super.setOutsideBorder(outsideBorder);
	}

	@Override
	public BlockPos getPosition() {
		return (BlockPos) (master != null ? master.getPosition() : super.getPosition());
	}

	@Override
	public BlockPos superGetPosition() {
		return super.getPosition();
	}

	@Override
	public Vec3d getPositionVector() {
		return (Vec3d) (master != null ? master.getPositionVector() : super.getPositionVector());
	}

	@Override
	public Vec3d superGetPositionVector() {
		return super.getPositionVector();
	}

	@Override
	public World getEntityWorld() {
		return (World) (master != null ? master.getEntityWorld() : super.getEntityWorld());
	}

	@Override
	public World superGetEntityWorld() {
		return super.getEntityWorld();
	}

	@Override
	public Entity getCommandSenderEntity() {
		return (Entity) (master != null ? master.getCommandSenderEntity() : super.getCommandSenderEntity());
	}

	@Override
	public Entity superGetCommandSenderEntity() {
		return super.getCommandSenderEntity();
	}

	@Override
	public boolean sendCommandFeedback() {
		return master != null ? master.sendCommandFeedback() : super.sendCommandFeedback();
	}

	@Override
	public boolean superSendCommandFeedback() {
		return super.sendCommandFeedback();
	}

	@Override
	public void setCommandStat(Type type, int amount) {
		if (master != null) master.setCommandStat(type, amount);
		else super.setCommandStat(type, amount);
	}

	@Override
	public void superSetCommandStat(Object type, int amount) {
		super.setCommandStat((Type) type, amount);
	}

	@Override
	public MinecraftServer getServer() {
		return (MinecraftServer) (master != null ? master.getServer() : super.getServer());
	}

	@Override
	public MinecraftServer superGetServer() {
		return super.getServer();
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
	public void setCommandStats(Entity entity) {
		if (master != null) master.setCommandStats(entity);
		else super.setCommandStats(entity);
	}

	@Override
	public void superSetCommandStats(Object entity) {
		super.setCommandStats((Entity) entity);
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
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (master != null ? master.getEntityData() : super.getEntityData());
	}

	@Override
	public NBTTagCompound superGetEntityData() {
		return super.getEntityData();
	}

	@Override
	public boolean shouldRiderSit() {
		return master != null ? master.shouldRiderSit() : super.shouldRiderSit();
	}

	@Override
	public boolean superShouldRiderSit() {
		return super.shouldRiderSit();
	}

	@Override
	public ItemStack getPickedResult(RayTraceResult rayTraceResult) {
		return (ItemStack) (master != null ? master.getPickedResult(rayTraceResult) : super.getPickedResult(rayTraceResult));
	}

	@Override
	public ItemStack superGetPickedResult(Object rayTraceResult) {
		return super.getPickedResult((RayTraceResult) rayTraceResult);
	}

	@Override
	public UUID getPersistentID() {
		return master != null ? master.getPersistentID() : super.getPersistentID();
	}

	@Override
	public UUID superGetPersistentID() {
		return super.getPersistentID();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}

	@Override
	public boolean superShouldRenderInPass(int pass) {
		return super.shouldRenderInPass(pass);
	}

	@Override
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return master != null ? master.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}

	@Override
	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}

	@Override
	public boolean canRiderInteract() {
		return master != null ? master.canRiderInteract() : super.canRiderInteract();
	}

	@Override
	public boolean superCanRiderInteract() {
		return super.canRiderInteract();
	}

	@Override
	public boolean shouldDismountInWater(Entity entity) {
		return master != null ? master.shouldDismountInWater(entity) : super.shouldDismountInWater(entity);
	}

	@Override
	public boolean superShouldDismountInWater(Object entity) {
		return super.shouldDismountInWater((Entity) entity);
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
	public float getRotatedYaw(Rotation rotation) {
		return master != null ? master.getRotatedYaw(rotation) : super.getRotatedYaw(rotation);
	}

	@Override
	public float superGetRotatedYaw(Object rotation) {
		return super.getRotatedYaw((Rotation) rotation);
	}

	@Override
	public float getMirroredYaw(Mirror mirror) {
		return master != null ? master.getMirroredYaw(mirror) : super.getMirroredYaw(mirror);
	}

	@Override
	public float superGetMirroredYaw(Object mirror) {
		return super.getMirroredYaw((Mirror) mirror);
	}

	@Override
	public boolean setPositionNonDirty() {
		return master != null ? master.setPositionNonDirty() : super.setPositionNonDirty();
	}

	@Override
	public boolean superSetPositionNonDirty() {
		return super.setPositionNonDirty();
	}

	@Override
	public Entity getControllingPassenger() {
		return (Entity) (master != null ? master.getControllingPassenger() : super.getControllingPassenger());
	}

	@Override
	public Entity superGetControllingPassenger() {
		return super.getControllingPassenger();
	}

	@Override
	public List<Entity> getPassengers() {
		return (List<Entity>) (master != null ? master.getPassengers() : super.getPassengers());
	}

	@Override
	public List<Entity> superGetPassengers() {
		return super.getPassengers();
	}

	@Override
	public boolean isPassenger(Entity entity) {
		return master != null ? master.isPassenger(entity) : super.isPassenger(entity);
	}

	@Override
	public boolean superIsPassenger(Object entity) {
		return super.isPassenger((Entity) entity);
	}

	@Override
	public Collection<Entity> getRecursivePassengers() {
		return (Collection<Entity>) (master != null ? master.getRecursivePassengers() : super.getRecursivePassengers());
	}

	@Override
	public Collection<Entity> superGetRecursivePassengers() {
		return super.getRecursivePassengers();
	}

	@Override
	public <T extends Entity> Collection<T> getRecursivePassengersByType(Class<T> entityClass) {
		return (Collection) (master != null ? master.getRecursivePassengersByType(entityClass) : super.getRecursivePassengersByType(entityClass));
	}

	@Override
	public Object superGetRecursivePassengersByType(Class entityClass) {
		return super.getRecursivePassengersByType(entityClass);
	}

	@Override
	public Entity getLowestRidingEntity() {
		return (Entity) (master != null ? master.getLowestRidingEntity() : super.getLowestRidingEntity());
	}

	@Override
	public Entity superGetLowestRidingEntity() {
		return super.getLowestRidingEntity();
	}

	@Override
	public boolean isRidingSameEntity(Entity entity) {
		return master != null ? master.isRidingSameEntity(entity) : super.isRidingSameEntity(entity);
	}

	@Override
	public boolean superIsRidingSameEntity(Object entity) {
		return super.isRidingSameEntity((Entity) entity);
	}

	@Override
	public boolean isRidingOrBeingRiddenBy(Entity entity) {
		return master != null ? master.isRidingOrBeingRiddenBy(entity) : super.isRidingOrBeingRiddenBy(entity);
	}

	@Override
	public boolean superIsRidingOrBeingRiddenBy(Object entity) {
		return super.isRidingOrBeingRiddenBy((Entity) entity);
	}

	@Override
	public boolean canPassengerSteer() {
		return master != null ? master.canPassengerSteer() : super.canPassengerSteer();
	}

	@Override
	public boolean superCanPassengerSteer() {
		return super.canPassengerSteer();
	}

	@Override
	public Entity getRidingEntity() {
		return (Entity) (master != null ? master.getRidingEntity() : super.getRidingEntity());
	}

	@Override
	public Entity superGetRidingEntity() {
		return super.getRidingEntity();
	}

	@Override
	public EnumPushReaction getPushReaction() {
		return (EnumPushReaction) (master != null ? master.getPushReaction() : super.getPushReaction());
	}

	@Override
	public EnumPushReaction superGetPushReaction() {
		return super.getPushReaction();
	}

	@Override
	public SoundCategory getSoundCategory() {
		return (SoundCategory) (master != null ? master.getSoundCategory() : super.getSoundCategory());
	}

	@Override
	public SoundCategory superGetSoundCategory() {
		return super.getSoundCategory();
	}
	// 188~
	@Override
	public BlockPos getHomePosition() {
		return (BlockPos) (master != null ? master.getHomePosition() : super.getHomePosition());
	}

	@Override
	public Object superGetHomePosition() {
		return super.getHomePosition();
	}

	@Override
	public float superGetSpeedModifier() {
		return 0.0F;
	}

	@Override
	public int superFunc_96121_ay() {
		return -1;
	}

	@Override
	public Object superGetLastAttackingEntity() {
		return null;
	}

	@Override
	public void superSetLastAttackingEntity(Object entity) {
	}

	@Override
	public String superGetTexture() {
		return null;
	}

	@Override
	public boolean superIsBlocking() {
		return false;
	}

	@Override
	public void superFunc_82162_bC() {
	}

	@Override
	public void superInitCreature() {
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
	public boolean superFunc_94062_bN() {
		return false;
	}

	@Override
	public void superFunc_96120_a(int par1, float par2) {
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
	public void superUnmountEntity(Object entity) {
	}

	@Override
	public void superUpdateCloak() {
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
	public int superGetMaxSafePointTries() {
		return -1;
	}

	@Override
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
		return false;
	}

	@Override
	public void superUpdateFallState(double par1, boolean par3) {
	}

	@Override
	public void superSetPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9) {
	}

	@Override
	public void superDropRareDrop(int par1) {
	}

	@Override
	public void superFall(float par1) {
	}

	@Override
	public boolean superIsAIEnabled() {
		return false;
	}

	@Override
	public boolean superIsClientWorld() {
		return false;
	}

	@Override
	public Object superGetPosition(float par1) {
		return null;
	}

	@Override
	public Object superGetItemIcon(Object itemStack, int par2) {
		return null;
	}

	@Override
	public Object[] superGetLastActiveItems() {
		return null;
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, Object par4) {
	}

	@Override
	public float superGetShadowSize() {
		return 0;
	}

	@Override
	public boolean superIsEntityInvulnerable() {
		return false;
	}

	@Override
	public void superCopyDataFrom(Object entity, boolean par2) {
	}

	public void setInPortal() {
	}

	public void superSetInPortal() {
	}
	// ~162
	public EntityLivingBase func_130012_q() {
		return null;
	}

	@Override
	public EntityLivingBase superFunc_130012_q() {
		return null;
	}

	public void func_110196_bT() {
	}

	@Override
	public void superFunc_110196_bT() {
	}

	public boolean func_110176_b(int par1, int par2, int par3) {
		return false;
	}

	@Override
	public boolean superFunc_110176_b(int par1, int par2, int par3) {
		return false;
	}

	public boolean whiteListCheck(EntityLiving entityLiving) {
		return false;
	}

	protected int getDropItemId() {
		return -1;
	}

	@Override
	public int superGetDropItemId() {
		return -1;
	}

	public ItemStack getCurrentItemOrArmor(int par1) {
		return null;
	}

	@Override
	public void superDoBlockCollisions() {
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
	}

	public boolean isInRangeToRenderVec3D(Vec3d vec3) {
		return false;
	}

	@Override
	public boolean superIsInRangeToRender3d(Object vec3) {
		return false;
	}

	public EntityItem dropItem(int par1, int par2) {
		return null;
	}

	public EntityItem dropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}

	public float getBlockExplosionResistance(Explosion explosion, World world, int par3, int par4, int par5, Block block) {
		return 0.0F;
	}

	public boolean shouldExplodeBlock(Explosion explosion, World world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

	public String getTranslatedEntityName() {
		return null;
	}

	@Override
	public String superGetTranslatedEntityName() {
		return null;
	}

	@Override
	public int superGetHealthInt() {
		return (Integer) superGetHealth();
	}

	@Override
	public Object superGetItemStackFromSlot(int par1) {
		return null;
	}

	@Override
	public Object superGetHealth() {
		return super.getHealth();
	}

	@Override
	public float superGetHealthFloat() {
		return super.getHealth();
	}

	@Override
	public void superHeal(int par1) {
		super.heal(par1);
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, int par2) {
		return super.attackEntityFrom((DamageSource) damageSource, (float) par2);
	}

	@Override
	public void superDamageArmor(int par1) {
		super.damageArmor(par1);
	}

	@Override
	public Object superApplyArmorCalculations(Object damageSource, int par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, (float) par2);
	}

	@Override
	public Object superApplyPotionDamageCalculations(Object damageSource, int par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, (float) par2);
	}

	@Override
	public void superDamageEntity(Object damageSource, int par2) {
		super.damageEntity((DamageSource) damageSource, (float) par2);
	}

	@Override
	public void superKnockBack(Object entity, int par2, double par3, double par5) {
		super.knockBack((Entity) entity, (float) par2, par3, par5);
	}

	@Override
	public void superOnChangedPotionEffect(Object potionEffect) {
	}

	@Override
	public void superSetPortal() {
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer) {
		return false;
	}

	@Override
	public Object[] superGetInventory() {
		return null;
	}

	@Override
	public void superCopyDataFromOld(Object entity) {
	}

	@Override
	public Object superGetNBTTagCompound() {
		return null;
	}

	@Override
	public void superClientUpdateEntityNBT(Object nBTTagCompound) {
	}

	@Override
	public boolean superInteractAt(Object entityPlayer, Object vec3) {
		return false;
	}

	@Override
	public void superFunc_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}

	@Override
	public void superAddRandomDrop() {
	}

	@Override
	public void superFunc_145781_i(int p_145781_1_) {
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return false;
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
	public String superGetCommandSenderName() {
		return null;
	}

	public Object superFunc_181012_aH() {
		return null;
	}
	// ~189
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getHeldItemMainhand());
	}

	protected void dropLoot() {
	}

	@Override
	public void superDropLoot() {
	}

	public boolean isPotionActive(int par1) {
		return false;
	}

	@Override
	public boolean superIsPotionActive(int par1) {
		return false;
	}

	public void removePotionEffectClient(int par1) {
	}

	@Override
	public void superRemovePotionEffectClient(int par1) {
	}

	public void removePotionEffect(int par1) {
	}

	@Override
	public void superRemovePotionEffect(int par1) {
	}

	public void swingArm() {
	}

	@Override
	public void superSwingArm() {
		super.swingArm(swingingHand);
	}

	public boolean isOnTeam(Team team) {
		return false;
	}

	@Override
	public boolean superIsOnTeam(Object team) {
		return false;
	}

	public void updatePassenger() {
	}

	public boolean isEating() {
		return false;
	}

	@Override
	public boolean superIsEating() {
		return false;
	}

	public void setEating(boolean p_70019_1_) {
	}

	@Override
	public void superSetEating(boolean p_70019_1_) {
	}

	public void copyDataFromOld(Entity entity) {
	}

	@Override
	public void superCopyDataFrom(Object entity) {
	}
	// ~189
	@Override
	public boolean superInteract(Object entityPlayer) {
		return false;
	}

	@Override
	public void superSetItemStackToSlot(int p_70062_1_, Object itemStack) {
	}

	@Override
	public boolean superCanBeLeashedTo() {
		return false;
	}
	// 172~
	public void onDataWatcherUpdate(int p_145781_1_) {
	}

	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
	}
	// ~179
	protected void attackEntity(Entity entity, float par2) {
	}

	@Override
	public void superAttackEntity(Object entity, float par2) {
	}

	public float getBlockPathWeight(int par1, int par2, int par3) {
		return 0.0F;
	}

	@Override
	public float superGetBlockPathWeight(int par1, int par2, int par3) {
		return 0.0F;
	}

	protected Entity findPlayerToAttack() {
		return null;
	}

	@Override
	public Entity superFindPlayerToAttack() {
		return null;
	}

	protected boolean isMovementCeased() {
		return false;
	}

	@Override
	public boolean superIsMovementCeased() {
		return false;
	}

	protected void updateWanderPath() {
	}

	@Override
	public void superUpdateWanderPath() {
	}

	public void setPathToEntity(Path pathEntity) {
	}

	public Entity getEntityToAttack() {
		return null;
	}

	@Override
	public Entity superGetEntityToAttack() {
		return null;
	}

	public void setTarget(Entity entity) {
	}

	@Override
	public void superSetTarget(Object entity) {
	}

	public void setHomeArea(int par1, int par2, int par3, int par4) {
	}

	@Override
	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
	}

	protected boolean isAIEnabled() {
		return true;
	}

	public int getMaxSafePointTries() {
		return -1;
	}

	public ItemStack func_130225_q(int par1) {
		return null;
	}

	public ItemStack[] getLastActiveItems() {
		return null;
	}

	protected void enchantEquipment() {
	}

	@Override
	public void superEnchantEquipment() {
	}

	public boolean hasCustomNameTag() {
		return hasCustomName();
	}

	@Override
	public boolean superHasCustomNameTag() {
		return superHasCustomName();
	}

	protected void updateFallState(double par1, boolean par3) {
	}

	protected void fall(float par1) {
	}

	protected void dropRareDrop(int par1) {
	}

	@Override
	public CombatTracker superGetCombatTracker() {
		return super.getCombatTracker();
	}

	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
	}

	public Vec3d getPosition(float par1) {
		return getPositionVector();
	}

	public boolean isClientWorld() {
		return false;
	}

	public float getShadowSize() {
		return 0.0F;
	}

	public boolean isEntityInvulnerable() {
		return false;
	}

	public void copyDataFrom(Entity entity, boolean par2) {
		copyDataFromOld(entity);
	}

	public IEntityLivingData onInitialSpawn(IEntityLivingData iEntityLivingData) {
		return onInitialSpawn(null, iEntityLivingData);
	}

	@Override
	public Object superOnInitialSpawn(Object iEntityLivingData) {
		return superOnInitialSpawn(null, iEntityLivingData);
	}

	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return isWithinHomeDistanceFromPosition(new BlockPos(par1, par2, par3));
	}

	@Override
	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return super.isWithinHomeDistanceFromPosition(new BlockPos(par1, par2, par3));
	}

	public Object getItemIcon(ItemStack itemStack, int par2) {
		return null;
	}

	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block block) {
	}

	@Override
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}

	public float getExplosionResistance(Explosion explosion, World world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block block) {
		return 0.0F;
	}

	@Override
	public float superGetExplosionResistance(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}

	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return false;
	}

	@Override
	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	@Override
	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}
	// 180~
	@Override
	public String superFunc_152113_b() {
		return null;
	}

	@Override
	public void superFunc_152115_b(String par1Str) {
	}

	@Override
	public String superFunc_146067_o(int p_146067_1_) {
		return null;
	}
	// ~189
	public String registerExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}

	@Override
	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}

	public Object getExtendedProperties(String identifier) {
		return null;
	}

	@Override
	public Object superGetExtendedProperties(String identifier) {
		return null;
	}

	@Override
	public Object superOnSpawnWithEgg(Object entityLivingData) {
		return null;
	}

	@Override
	public boolean superAllowLeashing() {
		return false;
	}

	@Override
	public Object superGetCurrentItemOrArmor(int par1) {
		return false;
	}

	@Override
	public Object superGetCurrentArmor(int par1) {
		return false;
	}

	@Override
	public void superInit() {
	}

	@Override
	public void superSetMaxHealth(Object floatOrInt) {
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(Modchu_CastHelper.Double(floatOrInt, 0.0D, false));
	}

	@Override
	public void superUpdatePassenger() {
	}

	@Override
	public boolean superInteractFirst(Object entityPlayer) {
		return false;
	}

	@Override
	public void superSetCurrentItemOrArmor(int par1, Object itemStack) {
	}

	@Override
	public boolean superProcessInteract(Object entityPlayer) {
		return false;
	}

	@Override
	public void superAddRandomArmor() {
	}

}
