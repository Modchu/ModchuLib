package modchu.lib.modloader.mc152;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_ASAlmighty;
import modchu.lib.Modchu_ASBase;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameableB;
import modchu.lib.Modchu_IEntityTameableMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.CombatTracker;
import net.minecraft.src.CrashReportCategory;
import net.minecraft.src.DamageSource;
import net.minecraft.src.DataWatcher;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAISit;
import net.minecraft.src.EntityAgeable;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityJumpHelper;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityLookHelper;
import net.minecraft.src.EntityMoveHelper;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySenses;
import net.minecraft.src.EntityTameable;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.Explosion;
import net.minecraft.src.Icon;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.PathEntity;
import net.minecraft.src.PathNavigate;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public class Modchu_EntityTameableB extends EntityTameable implements Modchu_IEntityTameableB {
	public Modchu_IEntityTameableMaster master;
	public String entityName;
	public static ConcurrentHashMap<String, UUID> entityUniqueIDMap = new ConcurrentHashMap();
	protected UUID entityUniqueID;
	protected int maxHealth;
	private boolean initFlag;

	public Modchu_EntityTameableB(World world) {
		super(world);
		entityUniqueID = UUID.randomUUID();
		ignoreFrustumCheck = true;
		initFlag = false;
		setEntityHealth(1);
		init((HashMap)null);
	}

	public Modchu_EntityTameableB(HashMap<String, Object> map) {
		this((World) map.get("Object"));
		initFlag = false;
		setEntityHealth(1);
		init(map);
	}

	public void setMovementSpeed(double d) {
		moveSpeed = (float) d;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(double d) {
		maxHealth = (int) d;
	}

	public Object getMaster() {
		//Modchu_Debug.mDebug("Modchu_EntityTameableB getMaster master="+master);
		if (master != null) ;else {
			init(entityName);
		}
		//Modchu_Debug.mDebug("Modchu_EntityTameableB getMaster return master="+master);
		return master;
	}

	public Object getFreeVariable(String s) {
		return master.getFreeVariable(s);
	}

	public void setFreeVariable(String s, Object o) {
		master.setFreeVariable(s, o);
	}

	protected void init(String s) {
		Class c = Modchu_Reflect.loadClass(s);
		if (c != null); else return;
		HashMap<String, Object> map = Modchu_Main.getNewModchuCharacteristicMap(c);
		init(map);
	}

	protected void init(HashMap<String, Object> map) {
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, this);
		Modchu_Debug.mDebug("Modchu_EntityTameableB init isRemote="+isRemote+" map="+map);
		if (posX == 0
				&& posY== 0
				&& posZ == 0) {
			Modchu_Debug.mDebug("Modchu_EntityTameableB init isRemote="+isRemote+" initFlag="+initFlag+" pos0 return");
			return;
		}
		Modchu_Debug.mDebug("Modchu_EntityTameableB init isRemote="+isRemote+" initFlag");
		if (map != null
				&& !map.isEmpty()); else {
			Modchu_Debug.mDebug("Modchu_EntityTameableB init isRemote="+isRemote+" map == null.");
			Class c = Modchu_Main.getSpownEntityClass(worldObj, posX, posY, posZ);
			map = new HashMap();
			map.put("Class", c);
			map.put("Object", worldObj);
			Modchu_Debug.mDebug("Modchu_EntityTameableB isRemote="+isRemote+" init c="+c+" worldObj="+worldObj);
		}
		if (map != null
				&& !map.isEmpty()); else {
			Modchu_Debug.mDebug("Modchu_EntityTameableB init 2 isRemote="+isRemote+" map == null !!");
			return;
		}
		Modchu_Debug.mDebug("Modchu_EntityTameableB init 3 isRemote="+isRemote);
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IEntityTameableMaster ? (Modchu_IEntityTameableMaster) instance : null;
		entityName = ((Class) map.get("Class")).getName();
		Modchu_Debug.mDebug("init isRemote="+isRemote+" entityName="+(entityName != null ? entityName : "null !!"));
		String s0 = new StringBuilder(Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, this) ? "1" : "0").append(entityUniqueID).toString();
		if (s0 != null
				&& entityUniqueIDMap.containsKey(s0)) {
			Modchu_Debug.mDebug("Modchu_EntityTameableB init isRemote="+isRemote+" entityUniqueIDMap.containsKey isDead s0="+s0);
			Modchu_AS.set(Modchu_AS.entityLivingBaseSetHealth, this, 0.0F);
			deathTime = 20;
			setDead();
			return;
		}
		if (s0 != null) entityUniqueIDMap.put(s0, entityUniqueID);
		initFlag = true;
		Modchu_Debug.mDebug("Modchu_EntityTameableB init isRemote="+isRemote+" entityUniqueID="+entityUniqueID);
		Modchu_Debug.mDebug("Modchu_EntityTameableB init masterEntity="+master);
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

	public String getResourceLocation() {
		return master != null ? (String) master.getResourceLocation() : null;
	}

	public void setResourceLocation(String resourceLocation) {
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
			try {
				nBTTagCompound.setString("entityName", entityName);
				nBTTagCompound.setLong("UUIDMost", getUniqueID().getMostSignificantBits());
				nBTTagCompound.setLong("UUIDLeast", getUniqueID().getLeastSignificantBits());
				if (master != null) master.writeEntityToNBT(nBTTagCompound);
				else super.writeEntityToNBT(nBTTagCompound);
			} catch (Throwable throwable) {
			}
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
		if (nBTTagCompound.hasKey("UUIDMost")
				&& nBTTagCompound.hasKey("UUIDLeast")) {
			entityUniqueID = new UUID(nBTTagCompound.getLong("UUIDMost"), nBTTagCompound.getLong("UUIDLeast"));
		}
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
	public String getOwnerName() {
		return master != null ? master.getOwnerName() : super.getOwnerName();
	}

	public String superGetOwnerName() {
		return super.getOwnerName();
	}

	@Override
	public void setOwner(String par1Str) {
		if (master != null) master.setOwner(par1Str);
		else super.setOwner(par1Str);
	}

	public void superSetOwner(String par1Str) {
		super.setOwner(par1Str);
	}

	@Override
	public EntityAISit func_70907_r() {
		return (EntityAISit) (master != null ? master.getAISit() : super.func_70907_r());
	}

	public EntityAISit superGetAISit() {
		return super.func_70907_r();
	}

	public boolean superFunc_142018_a(Object entityLivingBase, Object entityLivingBase1) {
		return false;
	}

	public Object superGetTeam() {
		return null;
	}

	public boolean superIsOnSameTeam(Object entityLivingBase) {
		return false;
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
		//Modchu_Debug.mDebug("onLivingUpdate master="+master);
		//Modchu_Debug.mDebug("onLivingUpdate entityName="+entityName);
		//Modchu_Debug.mDebug("onLivingUpdate posX="+posX+" posY="+posY+" posZ="+posZ);
		if (master != null
				&& entityName != null) ;else {
			init((HashMap)null);
			if (master != null) ;else {
				Modchu_Debug.mDebug("onLivingUpdate master="+master+" setDead() !!");
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
	protected void attackEntity(Entity entity, float par2) {
		if (master != null) master.attackEntity(entity, par2);
		else super.attackEntity(entity, par2);
	}

	public void superAttackEntity(Object entity, float par2) {
		super.attackEntity((Entity) entity, par2);
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, int par2) {
		return master != null ? master.attackEntityFrom(damageSource, par2) : super.attackEntityFrom(damageSource, par2);
	}

	public boolean superAttackEntityFrom(Object damageSource, float par2) {
		return super.attackEntityFrom((DamageSource) damageSource, (int)par2);
	}

	@Override
	public float getBlockPathWeight(int par1, int par2, int par3) {
		return master != null ? master.getBlockPathWeight(par1, par2, par3) : super.getBlockPathWeight(par1, par2, par3);
	}

	public float superGetBlockPathWeight(int par1, int par2, int par3) {
		return super.getBlockPathWeight(par1, par2, par3);
	}

	@Override
	protected Entity findPlayerToAttack() {
		return (Entity) (master != null ? master.findPlayerToAttack() : super.findPlayerToAttack());
	}

	public Entity superFindPlayerToAttack() {
		return super.findPlayerToAttack();
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

	public void superAddGrowth(int par1) {
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

	public void superSetScaleForAge(boolean par1) {
	}

	@Override
	protected boolean isMovementCeased() {
		return master != null ? master.isMovementCeased() : super.isMovementCeased();
	}

	public boolean superIsMovementCeased() {
		return super.isMovementCeased();
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
	protected void updateWanderPath() {
		if (master != null) master.updateWanderPath();
		else super.updateWanderPath();
	}

	public void superUpdateWanderPath() {
		super.updateWanderPath();
	}

	@Override
	public boolean hasPath() {
		return master != null ? master.hasPath() : super.hasPath();
	}

	public boolean superHasPath() {
		return super.hasPath();
	}

	@Override
	public void setPathToEntity(PathEntity pathEntity) {
		if (master != null) master.setPathToEntity(pathEntity);
		else super.setPathToEntity(pathEntity);
	}

	public void superSetPathToEntity(Object pathEntity) {
		super.setPathToEntity((PathEntity) pathEntity);
	}

	@Override
	public Entity getEntityToAttack() {
		return (Entity) (master != null ? master.getEntityToAttack() : super.getEntityToAttack());
	}

	public Entity superGetEntityToAttack() {
		return super.getEntityToAttack();
	}

	@Override
	public void setTarget(Entity entity) {
		if (master != null) master.setTarget(entity);
		else super.setTarget(entity);
	}

	public void superSetTarget(Object entity) {
		super.setTarget((Entity) entity);
	}

	@Override
	public void setHomeArea(int par1, int par2, int par3, int par4) {
		if (master != null) master.setHomeArea(par1, par2, par3, par4);
		else super.setHomeArea(par1, par2, par3, par4);
	}

	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
		super.setHomeArea(par1, par2, par3, par4);
	}

	@Override
	public ChunkCoordinates getHomePosition() {
		return (ChunkCoordinates) (master != null ? master.getHomePosition() : super.getHomePosition());
	}

	public ChunkCoordinates superGetHomePosition() {
		return super.getHomePosition();
	}

	public float superFunc_110174_bM() {
		return 0.0F;
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

	public void superFunc_142017_o(float par1) {
	}

	public void superApplyEntityAttributes() {
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
	public EntityLiving getAttackTarget() {
		return (EntityLiving) (master != null ? master.getAttackTarget() : super.getAttackTarget());
	}

	public EntityLiving superGetAttackTarget() {
		return super.getAttackTarget();
	}

	@Override
	public void setAttackTarget(EntityLiving entityLivingBase) {
		if (master != null) master.setAttackTarget(entityLivingBase);
		else super.setAttackTarget(entityLivingBase);
	}

	public void superSetAttackTarget(Object entityLivingBase) {
		super.setAttackTarget((EntityLiving) entityLivingBase);
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
		if (!initFlag) init((HashMap)null);
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, this);
		//if (isRemote) 
			Modchu_Debug.mDebug("Modchu_EntityTameableB onUpdate isRemote="+isRemote+" initFlag="+initFlag);
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	public void superOnUpdate() {
		super.onUpdate();
	}

	public float superFunc_110146_f(float par1, float par2) {
		return 0.0F;
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
	protected boolean isAIEnabled() {
		return master != null ? master.isAIEnabled() : super.isAIEnabled();
	}

	public boolean superIsAIEnabled() {
		return super.isAIEnabled();
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

	public int superGetMaxSafePointTries() {
		return -1;
	}

	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}

	public ItemStack superGetHeldItem() {
		return super.getHeldItem();
	}

	public ItemStack superFunc_130225_q(int par1) {
		return null;
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
	public ItemStack[] getLastActiveItems() {
		return (ItemStack[]) (master != null ? master.getLastActiveItems() : super.getLastActiveItems());
	}

	public ItemStack[] superGetLastActiveItems() {
		return super.getLastActiveItems();
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

	public void superEnchantEquipment() {
	}

	@Override
	public boolean canBeSteered() {
		return master != null ? master.canBeSteered() : super.canBeSteered();
	}

	public boolean superCanBeSteered() {
		return super.canBeSteered();
	}

	public void superFunc_110163_bv() {
	}

	public void superSetCustomNameTag(String par1Str) {
	}

	public String superGetCustomNameTag() {
		return null;
	}

	public boolean superHasCustomNameTag() {
		return false;
	}

	public void superSetAlwaysRenderNameTag(boolean par1) {
	}

	public boolean superGetAlwaysRenderNameTag() {
		return false;
	}

	public boolean superGetAlwaysRenderNameTagForRender() {
		return false;
	}

	public void superSetEquipmentDropChance(int par1, float par2) {
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

	public boolean superIsNoDespawnRequired() {
		return false;
	}

	public void superClearLeashed(boolean par1, boolean par2) {
	}

	public boolean superAllowLeashing() {
		return false;
	}

	public boolean superGetLeashed() {
		return false;
	}

	public Entity superGetLeashedToEntity() {
		return null;
	}

	public void superSetLeashedToEntity(Object entity, boolean par2) {
	}

	@Override
	protected void updateFallState(double par1, boolean par3) {
		if (master != null) master.updateFallState(par1, par3);
		else super.updateFallState(par1, par3);
	}

	public void superUpdateFallState(double par1, boolean par3) {
		super.updateFallState(par1, par3);
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
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, this);
		Modchu_Debug.mDebug("Modchu_EntityTameableB onDeathUpdate isRemote="+isRemote+" initFlag="+initFlag);
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
		return master != null ? master.getRNG() : super.getRNG();
	}

	public Random superGetRNG() {
		return super.getRNG();
	}

	@Override
	public EntityLiving getAITarget() {
		return (EntityLiving) (master != null ? master.getAITarget() : super.getAITarget());
	}

	public EntityLiving superGetAITarget() {
		return super.getAITarget();
	}

	public int superFunc_142015_aE() {
		return -1;
	}

	@Override
	public void setRevengeTarget(EntityLiving entityLivingBase) {
		if (master != null) master.setRevengeTarget(entityLivingBase);
		else super.setRevengeTarget(entityLivingBase);
	}

	public void superSetRevengeTarget(Object entityLivingBase) {
		super.setRevengeTarget((EntityLiving) entityLivingBase);
	}

	public EntityLiving superGetLastAttacker() {
		return null;
	}

	public int superGetLastAttackerTime() {
		return -1;
	}

	public void superSetLastAttacker(Object entity) {
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

	public void superOnChangedPotionEffect(Object potionEffect, boolean par2) {
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
	public void heal(int par1) {
		if (master != null) master.heal(par1);
		else super.heal(par1);
	}

	public void superHeal(float par1) {
		super.heal((int) par1);
	}

	@Override
	public void setEntityHealth(int par1) {
		if (master != null) master.setHealth(par1);
		else super.setEntityHealth(par1);
	}

	public void superSetHealth(float par1) {
		super.setEntityHealth((int) par1);
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

	public void superKnockBack(Object entity, float par2, double par3, double par5) {
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
	protected void dropRareDrop(int par1) {
		if (master != null) master.dropRareDrop(par1);
		else super.dropRareDrop(par1);
	}

	public void superDropRareDrop(int par1) {
		super.dropRareDrop(par1);
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
	protected void fall(float par1) {
		if (master != null) master.fall(par1);
		else super.fall(par1);
	}

	public void superFall(float par1) {
		super.fall(par1);
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

	public void superDamageArmor(float par1) {
	}

	public float superApplyArmorCalculations(Object damageSource, float par2) {
		return 0.0F;
	}

	public float superApplyPotionDamageCalculations(Object damageSource, float par2) {
		return 0.0F;
	}

	@Override
	protected void damageEntity(DamageSource damageSource, int par2) {
		if (master != null) master.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
	}

	public void superDamageEntity(Object damageSource, float par2) {
		super.damageEntity((DamageSource) damageSource, (int) par2);
	}

	public CombatTracker superFunc_110142_aN() {
		return null;
	}

	@Override
	public EntityLiving func_94060_bK() {
		return (EntityLiving) (master != null ? master.func_94060_bK() : super.func_94060_bK());
	}

	public EntityLiving superFunc_94060_bK() {
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

	public Object superGetAttributeMap() {
		return null;
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

	public void superDismountEntity(Object entity) {
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

	public void superCollideWithNearbyEntities() {
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
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		if (master != null) master.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
		else super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}

	public void superSetPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
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
	public Vec3 getPosition(float par1) {
		return (Vec3) (master != null ? master.getPosition(par1) : super.getPosition(par1));
	}

	public Vec3 superGetPosition(float par1) {
		return super.getPosition(par1);
	}

	@Override
	public MovingObjectPosition rayTrace(double par1, float par3) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(par1, par3) : super.rayTrace(par1, par3));
	}

	public MovingObjectPosition superRayTrace(double par1, float par3) {
		return super.rayTrace(par1, par3);
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

	public float superGetAbsorptionAmount() {
		return 0.0F;
	}

	public void superSetAbsorptionAmount(float par1) {
	}

	public boolean superIsOnTeam(Object team) {
		return false;
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

	public boolean superWriteMountToNBT(Object nBTTagCompound) {
		return false;
	}

	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return false;
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

	public boolean superShouldSetPosAfterLoading() {
		return false;
	}

	public void superOnChunkLoad() {
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
	public float getShadowSize() {
		return master != null ? master.getShadowSize() : super.getShadowSize();
	}

	public float superGetShadowSize() {
		return super.getShadowSize();
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

	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return false;
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
	public void onKillEntity(EntityLiving entityLivingBase) {
		if (master != null) master.onKillEntity(entityLivingBase);
		else super.onKillEntity(entityLivingBase);
	}

	public void superOnKillEntity(Object entityLivingBase) {
		super.onKillEntity((EntityLiving) entityLivingBase);
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

	public boolean superHitByEntity(Object entity) {
		return false;
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
		return master != null ? master.isEntityInvulnerable(null) : super.isEntityInvulnerable();
	}

	public boolean superIsEntityInvulnerable() {
		return super.isEntityInvulnerable();
	}

	public void superCopyLocationAndAnglesFrom(Object entity) {
	}

	@Override
	public void copyDataFrom(Entity entity, boolean par2) {
		if (master != null) master.copyDataFrom(entity, par2);
		else super.copyDataFrom(entity, par2);
	}

	public void superCopyDataFrom(Object entity, boolean par2) {
		super.copyDataFrom((Entity) entity, par2);
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

	public void superAddEntityCrashInfo(Object crashReportCategory) {
	}

	@Override
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}

	public boolean superCanRenderOnFire() {
		return super.canRenderOnFire();
	}

	public UUID getUniqueID() {
		return master != null ? master.getUniqueID() : null;
	}

	public UUID superGetUniqueID() {
		return null;
	}

	public boolean superIsPushedByWater() {
		return false;
	}

	public Object superOnSpawnWithEgg(Object entityLivingData) {
		return false;
	}

	public Object superGetEntityAttribute(Object attribute) {
		return null;
	}

	public Icon superGetItemIcon(Object itemStack, int par2) {
		return super.getItemIcon((ItemStack) itemStack, par2);
	}
	// 162
	public EntityLiving superFunc_130012_q() {
		return null;
	}

	public void superFunc_110196_bT() {
	}

	public boolean superFunc_110173_bK() {
		return false;
	}

	public boolean superFunc_110176_b(int par1, int par2, int par3) {
		return false;
	}

	public void superFunc_110159_bB() {
	}
	// ~162
	@Override
	protected int getDropItemId() {
		return master != null ? master.getDropItemId() : super.getDropItemId();
	}

	public int superGetDropItemId() {
		return super.getDropItemId();
	}

	@Override
	public ItemStack getCurrentItemOrArmor(int par1) {
		return (ItemStack) (master != null ? master.getCurrentItemOrArmor(par1) : super.getCurrentItemOrArmor(par1));
	}

	public ItemStack superGetCurrentItemOrArmor(int par1) {
		return super.getCurrentItemOrArmor(par1);
	}

	@Override
	public String getEntityName() {
		return master != null ? master.getEntityName() : super.getEntityName();
	}

	public String superGetEntityName() {
		return super.getEntityName();
	}

	@Override
	public Icon getItemIcon(ItemStack itemStack, int par2) {
		return (Icon) (master != null ? master.getItemIcon(itemStack, par2) : super.getItemIcon(itemStack, par2));
	}

	@Override
	protected void doBlockCollisions() {
		if (master != null) master.doBlockCollisions();
		else super.doBlockCollisions();
	}

	public void superDoBlockCollisions() {
		super.doBlockCollisions();
	}

	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		if (master != null) master.playStepSound(par1, par2, par3, par4);
		else super.playStepSound(par1, par2, par3, par4);
	}

	public void superPlayStepSound(int par1, int par2, int par3, int par4) {
		super.playStepSound(par1, par2, par3, par4);
	}

	@Override
	public boolean isInRangeToRenderVec3D(Vec3 vec3) {
		return master != null ? master.isInRangeToRenderVec3D(vec3) : super.isInRangeToRenderVec3D(vec3);
	}

	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return super.isInRangeToRenderVec3D((Vec3) vec3);
	}

	@Override
	public EntityItem dropItem(int par1, int par2) {
		return (EntityItem) (master != null ? master.dropItem(par1, par2) : super.dropItem(par1, par2));
	}

	public EntityItem superDropItem(int par1, int par2) {
		return super.dropItem(par1, par2);
	}

	@Override
	public EntityItem dropItemWithOffset(int par1, int par2, float par3) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(par1, par2, par3) : super.dropItemWithOffset(par1, par2, par3));
	}

	public EntityItem superDropItemWithOffset(int par1, int par2, float par3) {
		return super.dropItemWithOffset(par1, par2, par3);
	}

	@Override
	protected boolean pushOutOfBlocks(double par1, double par3, double par5) {
		return master != null ? master.pushOutOfBlocks(par1, par3, par5) : super.pushOutOfBlocks(par1, par3, par5);
	}

	public boolean superPushOutOfBlocks(double par1, double par3, double par5) {
		return super.pushOutOfBlocks(par1, par3, par5);
	}

	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

	@Override
	public String getTranslatedEntityName() {
		return master != null ? master.getTranslatedEntityName() : super.getTranslatedEntityName();
	}

	public String superGetTranslatedEntityName() {
		return super.getTranslatedEntityName();
	}

	@Override
	public boolean superHasCustomName() {
		return false;
	}

	@Override
	public boolean superIsEntityInvulnerable(Object damageSource) {
		return super.isEntityInvulnerable();
	}

	@Override
	public void superCopyDataFrom(Object entity) {
		super.copyDataFrom((Entity) entity, true);
	}

	@Override
	public Object superOnSpawnWithEgg(Object difficultyInstance, Object entityLivingData) {
		return null;
	}
	// ~152
	@Override
	public EntityLiving getOwner() {
		return (EntityLiving) (master != null ? master.getOwner() : super.getOwner());
	}

	public EntityLiving superGetOwner() {
		return super.getOwner();
	}

	@Override
	public void func_98054_a(boolean par1) {
		if (master != null) master.func_98054_a(par1);
		else super.func_98054_a(par1);
	}

	public void superFunc_98054_a(boolean par1) {
		super.func_98054_a(par1);
	}

	@Override
	public float getSpeedModifier() {
		return master != null ? master.getSpeedModifier() : super.getSpeedModifier();
	}

	public float superGetSpeedModifier() {
		return super.getSpeedModifier();
	}

	@Override
	protected int func_96121_ay() {
		return master != null ? master.func_96121_ay() : super.func_96121_ay();
	}

	public int superFunc_96121_ay() {
		return super.func_96121_ay();
	}

	@Override
	public EntityLiving getLastAttackingEntity() {
		return (EntityLiving) (master != null ? master.getLastAttackingEntity() : super.getLastAttackingEntity());
	}

	public EntityLiving superGetLastAttackingEntity() {
		return super.getLastAttackingEntity();
	}

	@Override
	public void setLastAttackingEntity(Entity entity) {
		if (master != null) master.setLastAttackingEntity(entity);
		else super.setLastAttackingEntity(entity);
	}

	public void superSetLastAttackingEntity(Object entity) {
		super.setLastAttackingEntity((Entity) entity);
	}

	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return master != null ? master.isWithinHomeDistanceCurrentPosition() : super.isWithinHomeDistanceCurrentPosition();
	}

	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return super.isWithinHomeDistanceCurrentPosition();
	}

	@Override
	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return master != null ? master.isWithinHomeDistance(par1, par2, par3) : super.isWithinHomeDistance(par1, par2, par3);
	}

	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return super.isWithinHomeDistance(par1, par2, par3);
	}

	@Override
	public float getMaximumHomeDistance() {
		return master != null ? master.getMaximumHomeDistance() : super.getMaximumHomeDistance();
	}

	public float superGetMaximumHomeDistance() {
		return super.getMaximumHomeDistance();
	}

	@Override
	public String getTexture() {
		return master != null ? master.getTexture() : super.getTexture();
	}

	public String superGetTexture() {
		return super.getTexture();
	}

	@Override
	public int getHealth() {
		return master != null ? master.getHealth() : super.getHealth();
	}

	public int superGetHealth() {
		return super.getHealth();
	}

	@Override
	protected void damageArmor(int par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}

	public void superDamageArmor(int par1) {
		super.damageArmor(par1);
	}

	@Override
	protected int applyArmorCalculations(DamageSource damageSource, int par2) {
		return (int) (master != null ? master.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2));
	}

	public int superApplyArmorCalculations(Object damageSource, int par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected int applyPotionDamageCalculations(DamageSource damageSource, int par2) {
		return (int) (master != null ? master.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2));
	}

	public int superApplyPotionDamageCalculations(Object damageSource, int par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}

	@Override
	public void knockBack(Entity entity, int par2, double par3, double par5) {
		if (master != null) master.knockBack(entity, par2, par3, par5);
		else super.knockBack(entity, par2, par3, par5);
	}

	public void superKnockBack(Object entity, int par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
	}

	@Override
	protected void func_85033_bc() {
		if (master != null) master.func_85033_bc();
		else super.func_85033_bc();
	}

	public void superFunc_85033_bc() {
		super.func_85033_bc();
	}

	@Override
	public boolean isBlocking() {
		return master != null ? master.isBlocking() : super.isBlocking();
	}

	public boolean superIsBlocking() {
		return super.isBlocking();
	}

	@Override
	protected void onChangedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onChangedPotionEffect(potionEffect, false);
		else super.onChangedPotionEffect(potionEffect);
	}

	public void superOnChangedPotionEffect(Object potionEffect) {
		super.onChangedPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public int func_82143_as() {
		return master != null ? master.func_82143_as() : super.func_82143_as();
	}

	public int superFunc_82143_as() {
		return super.func_82143_as();
	}

	@Override
	public ItemStack getCurrentArmor(int par1) {
		return (ItemStack) (master != null ? master.getCurrentArmor(par1) : super.getCurrentArmor(par1));
	}

	public ItemStack superGetCurrentArmor(int par1) {
		return super.getCurrentArmor(par1);
	}

	@Override
	protected void func_82162_bC() {
		if (master != null) master.func_82162_bC();
		else super.func_82162_bC();
	}

	public void superFunc_82162_bC() {
		super.func_82162_bC();
	}

	@Override
	public void initCreature() {
		if (master != null) master.initCreature();
		else super.initCreature();
	}

	public void superInitCreature() {
		super.initCreature();
	}

	@Override
	public void func_94058_c(String par1Str) {
		if (master != null) master.func_94058_c(par1Str);
		else super.func_94058_c(par1Str);
	}

	public void superFunc_94058_c(String par1Str) {
		super.func_94058_c(par1Str);
	}

	@Override
	public String func_94057_bL() {
		return master != null ? master.func_94057_bL() : super.func_94057_bL();
	}

	public String superFunc_94057_bL() {
		return super.func_94057_bL();
	}

	@Override
	public boolean func_94056_bM() {
		return master != null ? master.func_94056_bM() : super.func_94056_bM();
	}

	public boolean superFunc_94056_bM() {
		return super.func_94056_bM();
	}

	@Override
	public void func_94061_f(boolean par1) {
		if (master != null) master.func_94061_f(par1);
		else super.func_94061_f(par1);
	}

	public void superFunc_94061_f(boolean par1) {
		super.func_94061_f(par1);
	}

	@Override
	public boolean func_94062_bN() {
		return master != null ? master.func_94062_bN() : super.func_94062_bN();
	}

	public boolean superFunc_94062_bN() {
		return super.func_94062_bN();
	}

	@Override
	public boolean func_94059_bO() {
		return master != null ? master.func_94059_bO() : super.func_94059_bO();
	}

	public boolean superFunc_94059_bO() {
		return super.func_94059_bO();
	}

	@Override
	public void func_96120_a(int par1, float par2) {
		if (master != null) master.func_96120_a(par1, par2);
		else super.func_96120_a(par1, par2);
	}

	public void superFunc_96120_a(int par1, float par2) {
		super.func_96120_a(par1, par2);
	}

	@Override
	public boolean func_104002_bU() {
		return master != null ? master.func_104002_bU() : super.func_104002_bU();
	}

	public boolean superFunc_104002_bU() {
		return super.func_104002_bU();
	}

	@Override
	public boolean addNotRiddenEntityID(NBTTagCompound nBTTagCompound) {
		return master != null ? master.addNotRiddenEntityID(nBTTagCompound) : super.addNotRiddenEntityID(nBTTagCompound);
	}

	public boolean superAddNotRiddenEntityID(Object nBTTagCompound) {
		return super.addNotRiddenEntityID((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean addEntityID(NBTTagCompound nBTTagCompound) {
		return master != null ? master.addEntityID(nBTTagCompound) : super.addEntityID(nBTTagCompound);
	}

	public boolean superAddEntityID(Object nBTTagCompound) {
		return super.addEntityID((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void unmountEntity(Entity entity) {
		if (master != null) master.unmountEntity(entity);
		else super.unmountEntity(entity);
	}

	public void superUnmountEntity(Object entity) {
		super.unmountEntity((Entity) entity);
	}

	@Override
	public void updateCloak() {
		if (master != null) master.updateCloak();
		else super.updateCloak();
	}

	public void superUpdateCloak() {
		super.updateCloak();
	}

	@Override
	public boolean func_98034_c(EntityPlayer entityPlayer) {
		return master != null ? master.func_98034_c(entityPlayer) : super.func_98034_c(entityPlayer);
	}

	public boolean superFunc_98034_c(Object entityPlayer) {
		return super.func_98034_c((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean func_85031_j(Entity entity) {
		return master != null ? master.func_85031_j(entity) : super.func_85031_j(entity);
	}

	public boolean superFunc_85031_j(Object entity) {
		return super.func_85031_j((Entity) entity);
	}

	@Override
	public void func_82149_j(Entity entity) {
		if (master != null) master.func_82149_j(entity);
		else super.func_82149_j(entity);
	}

	public void superFunc_82149_j(Object entity) {
		super.func_82149_j((Entity) entity);
	}

	@Override
	public float func_82146_a(Explosion explosion, World world, int par3, int par4, int par5, Block block) {
		return master != null ? master.func_82146_a(explosion, world, par3, par4, par5, block) : super.func_82146_a(explosion, world, par3, par4, par5, block);
	}

	public float superFunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return super.func_82146_a((Explosion) explosion, (World) world, par3, par4, par5, (Block) block);
	}

	@Override
	public boolean func_96091_a(Explosion explosion, World world, int par3, int par4, int par5, int par6, float par7) {
		return master != null ? master.func_96091_a(explosion, world, par3, par4, par5, par6, par7) : super.func_96091_a(explosion, world, par3, par4, par5, par6, par7);
	}

	public boolean superFunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return super.func_96091_a((Explosion) explosion, (World) world, par3, par4, par5, par6, par7);
	}

	@Override
	public void func_85029_a(CrashReportCategory crashReportCategory) {
		if (master != null) master.func_85029_a(crashReportCategory);
		else super.func_85029_a(crashReportCategory);
	}

	public void superFunc_85029_a(Object crashReportCategory) {
		super.func_85029_a((CrashReportCategory) crashReportCategory);
	}

	@Override
	public boolean func_96092_aw() {
		return master != null ? master.func_96092_aw() : super.func_96092_aw();
	}

	public boolean superFunc_96092_aw() {
		return super.func_96092_aw();
	}

}