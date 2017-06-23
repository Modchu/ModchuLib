package modchu.lib;

public interface Modchu_IEntityPlayerDummyMaster {

	public void init();
	public void preparePlayerToSpawn();
	public boolean onLivingUpdate();
	public void moveEntityWithHeading(float f, float f1, float f2);
	public Object getHurtSound(Object damageSource);
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
	public Object getItemStackFromSlot(Object entityEquipmentSlot);
	public void setItemStackToSlot(Object entityEquipmentSlot, Object itemStack);
	public Object[] getInventory();
	public int getMaxHealth();
	public Object getCurrentArmor(int i);
	public void setCurrentItemOrArmor(int i, Object itemStack);

}
