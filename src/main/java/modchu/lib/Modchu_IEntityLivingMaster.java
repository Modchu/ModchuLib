package modchu.lib;

public interface Modchu_IEntityLivingMaster {

	public void init();
	public void preparePlayerToSpawn();
	public boolean onLivingUpdate();
	public float[] moveEntityWithHeading(float f, float f1);
	public String getHurtSound();
	public Object getCreatureAttribute();
	public float[] setSize(float f, float f1);
	public double getMountedYOffset();
	public double getYOffset();
	public boolean pushOutOfBlocks(double d, double d1, double d2);
	public boolean isEntityInsideOpaqueBlock();
	public Object copyPlayer(Object entityplayer);
	public Object copyInventory(Object inventoryplayer);
	public void resetHeight();
	public void updateRidden();
	public boolean attackEntityFrom(Object var1, Object par1DamageSource, int par2);
	public boolean attackEntityFrom(Object par1DamageSource, int par2);
	public void onDeath(Object par1DamageSource);
	public int setHealth(int f);
	public float getHealth();
	public float setHealth(float f);
	public double setMaxHealth(double d);
	public float getShadowSize();
	public Object getHeldItem();
	public Object getEquipmentInSlot(int i);
	public Object getCurrentArmor(int i);
	public void setCurrentItemOrArmor(int i, Object itemStack);
	public Object[] getInventory();
	public int getMaxHealth();

}
