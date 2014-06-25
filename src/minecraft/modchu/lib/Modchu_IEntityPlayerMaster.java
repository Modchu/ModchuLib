package modchu.lib;


public interface Modchu_IEntityPlayerMaster {

	public void init();
	public boolean wakeUpPlayer(boolean flag, boolean flag1, boolean flag2);
	public boolean preparePlayerToSpawn();
	public void setPositionCorrection(double par1, double par3, double par5);
	public boolean onLivingUpdate();
	public float[] moveEntityWithHeading(float f, float f1);
	public String getHurtSound();
	public Object getCreatureAttribute();
	public double getMountedYOffset();
	public void resetHeight();
	public double getYOffset();
	public boolean pushOutOfBlocks(double d, double d1, double d2);
	public boolean isEntityInsideOpaqueBlock();
	public Object copyPlayer(Object entityplayer);
	public Object copyInventory(Object inventoryplayer);
	public float[] setSize(float f, float f1);
	public boolean updateRidden();
	public boolean attackEntityFrom(Object var1, Object damageSource, int i);
	public boolean attackEntityFrom(Object damageSource, int i);
	public boolean onDeath(Object damageSource);
	public boolean sendMotionUpdates();
	public float getMaxHealth();
	public int getMaxHealthInt();
	public float getHealth();
	public int getHealthInt();
	public float setHealth(float f);
	public int setHealthInt(int i);

}
