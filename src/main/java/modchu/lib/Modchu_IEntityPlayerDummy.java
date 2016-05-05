package modchu.lib;

public interface Modchu_IEntityPlayerDummy {
	public void supersetMaxHealth(double d);
	public void supersetMaxHealth(float f);
	public void supersetMaxHealth(int i);
	public Object supergetCreatureAttribute();
	public void supersetSize(float f, float f1);
	public boolean superpushOutOfBlocks(double d, double d1, double d2);
	public void supercopyPlayer(Object entityPlayer);
	public void superupdateRidden();
	public boolean superattackEntityFrom(Object damageSource, int par2);
	public void superonDeath(Object damageSource);
	public Object superGetHeldItem();
	public Object superGetItemStackFromSlot(int i);
	public void superSetCurrentItemOrArmor(int i, Object itemStack);
	public Object[] superGetInventory();
	public Object superFunc_130225_q(int i);
	public void superMoveEntityWithHeading(float f, float f1);

}
