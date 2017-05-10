package modchu.lib;

import java.util.Random;

public interface Modchu_IEntityLivingMaster extends Modchu_IEntityLivingBaseMaster {
	public Object getLookHelper();
	public Object getMoveHelper();
	public Object getJumpHelper();
	public Object getNavigator();
	public Object getEntitySenses();
	public Object getAttackTarget();
	public void setAttackTarget(Object entityLivingBase);
	public boolean canAttackClass(Class par1Class);
	public void eatGrassBonus();
	public int getTalkInterval();
	public void playLivingSound();
	public void spawnExplosionParticle();
	public Object getAmbientSound();
	public int getDropItemId();
	public void setMoveForward(float par1);
	public boolean canDespawn();
	public void despawnEntity();
	public int getVerticalFaceSpeed();
	public void faceEntity(Object entity, float par2, float par3);
	public boolean getCanSpawnHere();
	public float getRenderSizeModifier();
	public int getMaxSpawnedInChunk();
	public Object func_130225_q(int var1);
	public void addRandomArmor();
	public void enchantEquipment();
	public Object onSpawnWithEgg(Object entityLivingData);
	public boolean canBeSteered();
	public void enablePersistence();
	public void setCustomNameTag(String par1Str);
	public String getCustomNameTag();
	public boolean hasCustomNameTag();
	public void setAlwaysRenderNameTag(boolean par1);
	public boolean getAlwaysRenderNameTag();
	public void setDropChance(int par1, float par2);
	public boolean canPickUpLoot();
	public void setCanPickUpLoot(boolean par1);
	public boolean isNoDespawnRequired();
	public boolean interact(Object entityPlayer);
	public void updateLeashedState();
	public void clearLeashed(boolean par1, boolean par2);
	public boolean allowLeashing();
	public boolean getLeashed();
	public Object getLeashedToEntity();
	public void setLeashedToEntity(Object entity, boolean par2);
	public boolean isWithinHomeDistanceCurrentPosition();
	public Object onInitialSpawn(Object difficultyInstance, Object iEntityLivingData);

}
