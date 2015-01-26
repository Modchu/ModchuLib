package modchu.lib;

public interface Modchu_IEntityPlayer {
	public void init();
	public void setPositionCorrection(double par1, double par3, double par5);
	public Object supergetCreatureAttribute();
	public void supersetSize(float f, float f1);
	public boolean superpushOutOfBlocks(double d, double d1, double d2);
	public Object supercopyPlayer(Object entityplayer);
	//public void copyInventory(Object inventoryplayer);
	public void publicResetHeight();
	public void publicSetSize(float f, float f1);
	public void superupdateRidden();
	//public boolean attackEntityFrom(Object entity, Object damageSource, int par2);
	//public boolean attackEntityFrom(Object damageSource, int par2);
	public boolean superattackEntityFrom(Object damageSource, int par2);
	public void superonDeath(Object damageSource);
	public void supersendMotionUpdates();
	//public float getEntityHealth();
	//public void setEntityHealth(float f);
	public void superwakeUpPlayer(boolean flag, boolean flag1, boolean flag2);
	public void superpreparePlayerToSpawn();
	public void supersetPositionCorrection(double par1, double par3, double par5);
	public void superonLivingUpdate();
	public void supermoveEntityWithHeading(float f, float f1);
	public String supergetHurtSound();
	public double supergetMountedYOffset();
	public void superresetHeight();
	public double supergetYOffset();
	public boolean superisEntityInsideOpaqueBlock();
	public Object supercopyInventory(Object inventoryplayer);
	public boolean superattackEntityFrom(Object var1, Object damageSource, int i);
	public float supergetMaxHealth();
	public int supergetMaxHealthInt();
	public float supergetHealth();
	public int supergetHealthInt();
	public void supersetHealth(float f);
	public void supersetHealthInt(int i);

}
