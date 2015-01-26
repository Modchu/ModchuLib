package modchu.lib;


public interface Modchu_IEntityPlayerMaster {

	public void init();
	public void wakeUpPlayer(boolean flag, boolean flag1, boolean flag2);
	public void preparePlayerToSpawn();
	public void setPositionCorrection(double par1, double par3, double par5);
	public void onLivingUpdate();
	public void moveEntityWithHeading(float f, float f1);
	public String getHurtSound();
	public Object getCreatureAttribute();
	public double getMountedYOffset();
	public void resetHeight();
	public double getYOffset();
	public boolean pushOutOfBlocks(double d, double d1, double d2);
	public boolean isEntityInsideOpaqueBlock();
	public Object copyPlayer(Object entityplayer);
	public Object copyInventory(Object inventoryplayer);
	public void setSize(float f, float f1);
	public void updateRidden();
	public boolean attackEntityFrom(Object var1, Object damageSource, int i);
	public boolean attackEntityFrom(Object damageSource, int i);
	public void onDeath(Object damageSource);
	public void sendMotionUpdates();
	public float getMaxHealth();
	public int getMaxHealthInt();
	public float getHealth();
	public int getHealthInt();
	public void setHealth(float f);
	public void setHealthInt(int i);

}
