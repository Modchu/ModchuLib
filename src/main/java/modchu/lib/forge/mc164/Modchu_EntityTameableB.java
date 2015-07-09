package modchu.lib.forge.mc164;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameableB;
import modchu.lib.Modchu_IEntityTameableMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
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
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Modchu_EntityTameableB extends EntityTameable implements Modchu_IEntityTameableB {
	public Modchu_IEntityTameableMaster master;
	public String entityName;
	public static ConcurrentHashMap<String, UUID> entityUniqueIDMap = new ConcurrentHashMap();
	protected UUID entityUniqueID;
	private boolean onSpawnWithEggFlag = false;
	public static final int maxSpwanCount = 1;
	public int spwanCount = 0;

	public Modchu_EntityTameableB(World world) {
		super(world);
		entityUniqueID = UUID.randomUUID();
		ignoreFrustumCheck = true;
	}

	public Modchu_EntityTameableB(HashMap<String, Object> map) {
		this((World) map.get("Object"));
		init(map);
	}

	public void setMovementSpeed(double d) {
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(d);
	}

	public void setFollowRange(double d) {
		getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(d);
	}

	public void setKnockbackResistance(double d) {
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setAttribute(d);
	}

	public void setAttackDamage(double d) {
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(d);
	}

	public void setMaxHealth(double d) {
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(d);
	}

	@Override
	public Object getMaster() {
		//Modchu_Debug.mDebug("getmasterEntity masterEntity="+masterEntity);
		if (master != null) ;else {
			init(entityName);
		}
		return master;
	}

	@Override
	public Object getFreeVariable(String s) {
		return master.getFreeVariable(s);
	}

	@Override
	public void setFreeVariable(String s, Object o) {
		master.setFreeVariable(s, o);
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
		if (map != null
				&& !map.isEmpty()); else {
			if (worldObj != null); else return;
			Class c = Modchu_Main.getSpownEntityClass(worldObj, posX, posY, posZ);
			map = new HashMap();
			map.put("Class", c);
			map.put("Object", worldObj);
		}
		if (worldObj != null); else {
			worldObj = (World) map.get("Object");
			return;
		}
		Modchu_Debug.mDebug("Modchu_EntityTameableB init 1 this="+this+" isRemote="+worldObj.isRemote);
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IEntityTameableMaster ? (Modchu_IEntityTameableMaster) instance : null;
		Object o = map.containsKey("Class") ? ((Class) map.get("Class")) : null;
		if (o != null); else {
			Modchu_Debug.mDebug("Modchu_EntityTameableB init map.get(\"Class\") == null error !! setDead");
			setDead();
			return;
		}
		entityName = o != null
				&& o instanceof Class ? ((Class) o).getName() : null;
		Modchu_Debug.mDebug("Modchu_EntityTameableB init entityName="+(entityName != null ? entityName : "null !!"));
		String s0 = new StringBuilder(worldObj.isRemote ? "1" : "0").append(entityUniqueID).toString();
		if (s0 != null
				&& entityUniqueIDMap.containsKey(s0)) {
			Modchu_Debug.mDebug("Modchu_EntityTameableB init entityUniqueIDMap.containsKey isDead entityUniqueID="+entityUniqueID);
			Modchu_AS.set(Modchu_AS.entityLivingBaseSetHealth, this, 0.0F);
			deathTime = 20;
			setDead();
			return;
		}
		if (s0 != null) entityUniqueIDMap.put(s0, entityUniqueID);
		Modchu_Debug.mDebug("Modchu_EntityTameableB init entityUniqueID="+entityUniqueID);
		Modchu_Debug.mDebug("Modchu_EntityTameableB init master.getClass()="+(master != null ? master.getClass() : null));
		Modchu_Debug.mDebug("Modchu_EntityTameableB init master="+master);
		if (master != null); else {
			Modchu_Debug.mDebug("Modchu_EntityTameableB init master == null setDead !!");
			setDead();
		}
		if (spwanCount > maxSpwanCount) {
			Modchu_Debug.mDebug("Modchu_EntityTameableB init spwanCount > maxSpwanCount setDead !!");
			setDead();
		}
		Modchu_Debug.mDebug("Modchu_EntityTameableB init onSpawnWithEggFlag="+onSpawnWithEggFlag);
		if (onSpawnWithEggFlag) {
			onSpawnWithEgg(null);
			onSpawnWithEggFlag = false;
		}
		Modchu_Debug.mDebug("Modchu_EntityTameableB init end. this="+this+" isRemote="+worldObj.isRemote);
	}

	public static void worldEventLoad(Object event) {
		if (entityUniqueIDMap != null) entityUniqueIDMap.clear();
	}

	@Override
	public boolean isAngry() {
		return master != null ? master.isAngry() : false;
	}

	@Override
	public void setAngry(boolean flag) {
		if (master != null) master.setAngry(flag);
	}

	@Override
	public int getTextureColor() {
		return master != null ? master.getTextureColor() : 0;
	}

	@Override
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

	@Override
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
	public void handleHealthUpdate(byte par1) {
		if (master != null) master.handleHealthUpdate(par1);
		else super.handleHealthUpdate(par1);
	}

	@Override
	public void superHandleHealthUpdate(byte par1) {
		super.handleHealthUpdate(par1);
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
	public String getOwnerName() {
		return master != null ? master.getOwnerName() : super.getOwnerName();
	}

	@Override
	public String superGetOwnerName() {
		return super.getOwnerName();
	}

	@Override
	public void setOwner(String par1Str) {
		if (master != null) master.setOwner(par1Str);
		else super.setOwner(par1Str);
	}

	@Override
	public void superSetOwner(String par1Str) {
		super.setOwner(par1Str);
	}

	@Override
	public EntityAISit func_70907_r() {
		return (EntityAISit) (master != null ? master.getAISit() : super.func_70907_r());
	}

	@Override
	public EntityAISit superGetAISit() {
		return super.func_70907_r();
	}

	@Override
	public boolean func_142018_a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
		return master != null ? master.func_142018_a(entityLivingBase, entityLivingBase1) : super.func_142018_a(entityLivingBase, entityLivingBase1);
	}

	@Override
	public boolean superFunc_142018_a(Object entityLivingBase, Object entityLivingBase1) {
		return super.func_142018_a((EntityLivingBase) entityLivingBase, (EntityLivingBase) entityLivingBase1);
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
	public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOnSameTeam(entityLivingBase) : super.isOnSameTeam(entityLivingBase);
	}

	@Override
	public boolean superIsOnSameTeam(Object entityLivingBase) {
		return super.isOnSameTeam((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected void updateAITick() {
		if (master != null) master.updateAITick();
		else super.updateAITick();
	}

	@Override
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
			init((HashMap)null);
			if (master != null) ;else {
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
	protected void attackEntity(Entity entity, float par2) {
		if (master != null) master.attackEntity(entity, par2);
		else super.attackEntity(entity, par2);
	}

	public void superAttackEntity(Object entity, float par2) {
		super.attackEntity((Entity) entity, par2);
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float par2) {
		return master != null ? master.attackEntityFrom(damageSource, par2) : super.attackEntityFrom(damageSource, par2);
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, float par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
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
	public boolean interact(EntityPlayer entityPlayer) {
		return master != null ? master.interact(entityPlayer) : super.interact(entityPlayer);
	}

	@Override
	public boolean superInteract(Object entityPlayer) {
		return super.interact((EntityPlayer) entityPlayer);
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

	@Override
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

	@Override
	public float func_110174_bM() {
		return master != null ? master.func_110174_bM() : super.func_110174_bM();
	}

	public float superFunc_110174_bM() {
		return super.func_110174_bM();
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
	protected void func_142017_o(float par1) {
		if (master != null) master.func_142017_o(par1);
		else super.func_142017_o(par1);
	}

	@Override
	public void superFunc_142017_o(float par1) {
		super.func_142017_o(par1);
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
	public boolean superCanAttackClass(Object c) {
		return super.canAttackClass((Class) c);
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
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	@Override
	public void superOnUpdate() {
		super.onUpdate();
	}

	@Override
	protected float func_110146_f(float par1, float par2) {
		return master != null ? master.func_110146_f(par1, par2) : super.func_110146_f(par1, par2);
	}

	@Override
	public float superFunc_110146_f(float par1, float par2) {
		return super.func_110146_f(par1, par2);
	}

	@Override
	protected String getLivingSound() {
		return master != null ? master.getLivingSound() : super.getLivingSound();
	}

	@Override
	public String superGetLivingSound() {
		return super.getLivingSound();
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
	public int getMaxSafePointTries() {
		return master != null ? master.getMaxSafePointTries() : super.getMaxSafePointTries();
	}

	public int superGetMaxSafePointTries() {
		return super.getMaxSafePointTries();
	}

	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}

	@Override
	public ItemStack superGetHeldItem() {
		return super.getHeldItem();
	}

	@Override
	public ItemStack func_130225_q(int par1) {
		return (ItemStack) (master != null ? master.func_130225_q(par1) : super.func_130225_q(par1));
	}

	public ItemStack superFunc_130225_q(int par1) {
		return super.func_130225_q(par1);
	}

	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack itemStack) {
		if (master != null) master.setCurrentItemOrArmor(par1, itemStack);
		else super.setCurrentItemOrArmor(par1, itemStack);
	}

	@Override
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

	@Override
	public void superDropEquipment(boolean par1, int par2) {
		super.dropEquipment(par1, par2);
	}

	@Override
	protected void addRandomArmor() {
		if (master != null) master.addRandomArmor();
		else super.addRandomArmor();
	}

	@Override
	public void superAddRandomArmor() {
		super.addRandomArmor();
	}

	@Override
	protected void enchantEquipment() {
		if (master != null) master.enchantEquipment();
		else super.enchantEquipment();
	}

	public void superEnchantEquipment() {
		super.enchantEquipment();
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
	public void func_110163_bv() {
		if (master != null) master.func_110163_bv();
		else super.func_110163_bv();
	}

	public void superFunc_110163_bv() {
		super.func_110163_bv();
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
	public boolean hasCustomNameTag() {
		return master != null ? master.hasCustomNameTag() : super.hasCustomNameTag();
	}

	public boolean superHasCustomNameTag() {
		return super.hasCustomNameTag();
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
	public void setEquipmentDropChance(int par1, float par2) {
		if (master != null) master.setEquipmentDropChance(par1, par2);
		else super.setEquipmentDropChance(par1, par2);
	}

	@Override
	public void superSetEquipmentDropChance(int par1, float par2) {
		super.setEquipmentDropChance(par1, par2);
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
	public boolean allowLeashing() {
		return master != null ? master.allowLeashing() : super.allowLeashing();
	}

	@Override
	public boolean superAllowLeashing() {
		return super.allowLeashing();
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
	public boolean isPotionActive(int par1) {
		return master != null ? master.isPotionActive(par1) : super.isPotionActive(par1);
	}

	@Override
	public boolean superIsPotionActive(int par1) {
		return super.isPotionActive(par1);
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
	public void removePotionEffectClient(int par1) {
		if (master != null) master.removePotionEffectClient(par1);
		else super.removePotionEffectClient(par1);
	}

	@Override
	public void superRemovePotionEffectClient(int par1) {
		super.removePotionEffectClient(par1);
	}

	@Override
	public void removePotionEffect(int par1) {
		if (master != null) master.removePotionEffect(par1);
		else super.removePotionEffect(par1);
	}

	@Override
	public void superRemovePotionEffect(int par1) {
		super.removePotionEffect(par1);
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
	public void superHeal(float par1) {
		super.heal(par1);
	}

	@Override
	public void setHealth(float par1) {
		if (master != null) master.setHealth(par1);
		else super.setHealth(par1);
	}

	@Override
	public void superSetHealth(float par1) {
		super.setHealth(par1);
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
		if (master != null) master.onDeath(damageSource);
		else super.onDeath(damageSource);
	}

	@Override
	public void superOnDeath(Object damageSource) {
		super.onDeath((DamageSource) damageSource);
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
	protected String getHurtSound() {
		return master != null ? master.getHurtSound() : super.getHurtSound();
	}

	@Override
	public String superGetHurtSound() {
		return super.getHurtSound();
	}

	@Override
	protected String getDeathSound() {
		return master != null ? master.getDeathSound() : super.getDeathSound();
	}

	@Override
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
		return master != null ? master.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2);
	}

	@Override
	public float superApplyArmorCalculations(Object damageSource, float par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float par2) {
		return master != null ? master.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2);
	}

	@Override
	public float superApplyPotionDamageCalculations(Object damageSource, float par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected void damageEntity(DamageSource damageSource, float par2) {
		if (master != null) master.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
	}

	@Override
	public void superDamageEntity(Object damageSource, float par2) {
		super.damageEntity((DamageSource) damageSource, par2);
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

	@Override
	public EntityLivingBase superFunc_94060_bK() {
		return super.func_94060_bK();
	}

	@Override
	public void swingItem() {
		if (master != null) master.swingItem();
		else super.swingItem();
	}

	@Override
	public void superSwingItem() {
		super.swingItem();
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
	public BaseAttributeMap getAttributeMap() {
		return (BaseAttributeMap) (master != null ? master.getAttributeMap() : super.getAttributeMap());
	}

	@Override
	public BaseAttributeMap superGetAttributeMap() {
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
	public Vec3 getLookVec() {
		return (Vec3) (master != null ? master.getLookVec() : super.getLookVec());
	}

	@Override
	public Vec3 superGetLookVec() {
		return super.getLookVec();
	}

	@Override
	public Vec3 getLook(float par1) {
		return (Vec3) (master != null ? master.getLook(par1) : super.getLook(par1));
	}

	@Override
	public Vec3 superGetLook(float par1) {
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
	public boolean isOnTeam(Team team) {
		return master != null ? master.isOnTeam(team) : super.isOnTeam(team);
	}

	@Override
	public boolean superIsOnTeam(Object team) {
		return super.isOnTeam((Team) team);
	}

	@Override
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataWatcher() : super.getDataWatcher());
	}

	@Override
	public DataWatcher superGetDataWatcher() {
		return super.getDataWatcher();
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
	public void setAngles(float par1, float par2) {
		if (master != null) master.setAngles(par1, par2);
		else super.setAngles(par1, par2);
	}

	@Override
	public void superSetAngles(float par1, float par2) {
		super.setAngles(par1, par2);
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
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.moveEntity(par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	@Override
	public void superMoveEntity(double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
	}

	@Override
	public void playSound(String par1Str, float par2, float par3) {
		if (master != null) master.playSound(par1Str, par2, par3);
		else super.playSound(par1Str, par2, par3);
	}

	@Override
	public void superPlaySound(String par1Str, float par2, float par3) {
		super.playSound(par1Str, par2, par3);
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
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getBoundingBox() : super.getBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetBoundingBox() {
		return super.getBoundingBox();
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
	public boolean handleLavaMovement() {
		return master != null ? master.handleLavaMovement() : super.handleLavaMovement();
	}

	@Override
	public boolean superHandleLavaMovement() {
		return super.handleLavaMovement();
	}

	@Override
	public void moveFlying(float par1, float par2, float par3) {
		if (master != null) master.moveFlying(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}

	@Override
	public void superMoveFlying(float par1, float par2, float par3) {
		super.moveFlying(par1, par2, par3);
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
	public boolean writeMountToNBT(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeMountToNBT(nBTTagCompound) : super.writeMountToNBT(nBTTagCompound);
	}

	@Override
	public boolean superWriteMountToNBT(Object nBTTagCompound) {
		return super.writeMountToNBT((NBTTagCompound) nBTTagCompound);
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
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}

	@Override
	public void superWriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
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
	public void onChunkLoad() {
		if (master != null) master.onChunkLoad();
		else super.onChunkLoad();
	}

	@Override
	public void superOnChunkLoad() {
		super.onChunkLoad();
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
	public void updateRiderPosition() {
		if (master != null) master.updateRiderPosition();
		else super.updateRiderPosition();
	}

	@Override
	public void superUpdateRiderPosition() {
		super.updateRiderPosition();
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
	public void mountEntity(Entity entity) {
		if (master != null) master.mountEntity(entity);
		else super.mountEntity(entity);
	}

	@Override
	public void superMountEntity(Object entity) {
		super.mountEntity((Entity) entity);
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
	public void setInPortal() {
		if (master != null) master.setInPortal();
		else super.setInPortal();
	}

	@Override
	public void superSetInPortal() {
		super.setInPortal();
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
	public boolean isEating() {
		return master != null ? master.isEating() : super.isEating();
	}

	@Override
	public boolean superIsEating() {
		return super.isEating();
	}

	@Override
	public void setEating(boolean par1) {
		if (master != null) master.setEating(par1);
		else super.setEating(par1);
	}

	@Override
	public void superSetEating(boolean par1) {
		super.setEating(par1);
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
	public boolean canAttackWithItem() {
		return master != null ? master.canAttackWithItem() : super.canAttackWithItem();
	}

	@Override
	public boolean superCanAttackWithItem() {
		return super.canAttackWithItem();
	}

	@Override
	public boolean hitByEntity(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.hitByEntity(entity);
	}

	@Override
	public boolean superHitByEntity(Object entity) {
		return super.hitByEntity((Entity) entity);
	}
/*
	@Override
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}

	@Override
	public String superToString() {
		return super.toString();
	}
*/
	@Override
	public boolean isEntityInvulnerable() {
		return master != null ? master.isEntityInvulnerable(null) : super.isEntityInvulnerable();
	}

	public boolean superIsEntityInvulnerable() {
		return super.isEntityInvulnerable();
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

	@Override
	public void superTravelToDimension(int par1) {
		super.travelToDimension(par1);
	}

	@Override
	public int getTeleportDirection() {
		return master != null ? master.getTeleportDirection() : super.getTeleportDirection();
	}

	@Override
	public int superGetTeleportDirection() {
		return super.getTeleportDirection();
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
	public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
		if (master != null); else onSpawnWithEggFlag = true;
		return (EntityLivingData) (master != null ? master.onSpawnWithEgg(entityLivingData) : super.onSpawnWithEgg(entityLivingData));
	}

	public EntityLivingData superOnSpawnWithEgg(Object entityLivingData) {
		return super.onSpawnWithEgg((EntityLivingData) entityLivingData);
	}

	@Override
	public AttributeInstance getEntityAttribute(Attribute attribute) {
		return (AttributeInstance) (master != null ? master.getEntityAttribute(attribute) : super.getEntityAttribute(attribute));
	}

	public AttributeInstance superGetEntityAttribute(Object attribute) {
		return super.getEntityAttribute((Attribute) attribute);
	}

	@Override
	public boolean isInRangeToRenderVec3D(Vec3 vec3) {
		return master != null ? master.isInRangeToRenderVec3D(vec3) : super.isInRangeToRenderVec3D(vec3);
	}

	@Override
	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return super.isInRangeToRenderVec3D((Vec3) vec3);
	}

	@Override
	public String getEntityName() {
		return master != null ? master.getEntityName() : super.getEntityName();
	}

	@Override
	public String superGetEntityName() {
		return super.getEntityName();
	}

	@Override
	public EntityLivingBase getOwner() {
		return (EntityLivingBase) (master != null ? master.getOwner() : null);
	}

	public EntityLivingBase superGetOwner() {
		return null;
	}

	@Override
	public Icon getItemIcon(ItemStack itemStack, int par2) {
		return (Icon) (master != null ? master.getItemIcon(itemStack, par2) : super.getItemIcon(itemStack, par2));
	}

	public Icon superGetItemIcon(Object itemStack, int par2) {
		return super.getItemIcon((ItemStack) itemStack, par2);
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
	public String getTranslatedEntityName() {
		return master != null ? master.getTranslatedEntityName() : super.getTranslatedEntityName();
	}

	@Override
	public String superGetTranslatedEntityName() {
		return super.getTranslatedEntityName();
	}
	// ~162
	@Override
	public EntityLivingBase func_130012_q() {
		return null;
	}

	@Override
	public EntityLivingBase superFunc_130012_q() {
		return null;
	}

	@Override
	public void func_110196_bT() {
	}

	@Override
	public void superFunc_110196_bT() {
	}

	@Override
	public boolean func_110173_bK() {
		return false;
	}

	@Override
	public boolean superFunc_110173_bK() {
		return false;
	}

	@Override
	public boolean func_110176_b(int par1, int par2, int par3) {
		return false;
	}

	@Override
	public boolean superFunc_110176_b(int par1, int par2, int par3) {
		return false;
	}

	@Override
	protected void func_110159_bB() {
	}

	@Override
	public void superFunc_110159_bB() {
	}

	@Override
	protected int getDropItemId() {
		return -1;
	}

	@Override
	public int superGetDropItemId() {
		return -1;
	}

	@Override
	public ItemStack getCurrentItemOrArmor(int par1) {
		return null;
	}

	@Override
	public ItemStack superGetCurrentItemOrArmor(int par1) {
		return null;
	}

	@Override
	protected void doBlockCollisions() {
	}

	@Override
	public void superDoBlockCollisions() {
	}

	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4) {
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, int par4) {
	}

	@Override
	public EntityItem dropItem(int par1, int par2) {
		return null;
	}

	@Override
	public EntityItem superDropItem(int par1, int par2) {
		return null;
	}

	@Override
	public EntityItem dropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}

	@Override
	public EntityItem superDropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}

	@Override
	protected boolean pushOutOfBlocks(double par1, double par3, double par5) {
		return false;
	}

	public boolean superPushOutOfBlocks(double par1, double par3, double par5) {
		return false;
	}

	@Override
	public float getBlockExplosionResistance(Explosion explosion, World world, int par3, int par4, int par5, Block block) {
		return 0.0F;
	}

	@Override
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	@Override
	public boolean shouldExplodeBlock(Explosion explosion, World world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

	@Override
	public boolean superHasCustomName() {
		return super.hasCustomNameTag();
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
	public Object superOnSpawnWithEgg(Object difficultyInstance, Object iEntityLivingData) {
		return super.onSpawnWithEgg((EntityLivingData) iEntityLivingData);
	}

	@Override
	public void superFunc_98054_a(boolean par1) {
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
	public float superGetMaximumHomeDistance() {
		return 0.0F;
	}

	@Override
	public String superGetTexture() {
		return null;
	}

	@Override
	public float superGetHealth() {
		return getHealth();
	}

	@Override
	public void superFunc_85033_bc() {
	}

	@Override
	public boolean superIsBlocking() {
		return false;
	}

	@Override
	public int superFunc_82143_as() {
		return -1;
	}

	@Override
	public Object superGetCurrentArmor(int par1) {
		return null;
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
	public void superFunc_94061_f(boolean par1) {
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
	public void superFunc_96120_a(int par1, float par2) {
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
	public void superUnmountEntity(Object entity) {
	}

	@Override
	public void superUpdateCloak() {
	}

	@Override
	public boolean superFunc_98034_c(Object entityPlayer) {
		return false;
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

	@Override
	public boolean superFunc_96092_aw() {
		return false;
	}

	@Override
	public int superGetHealthInt() {
		return (int) superGetHealth();
	}

	@Override
	public float superGetHealthFloat() {
		return super.getHealth();
	}

}
