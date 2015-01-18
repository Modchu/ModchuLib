package modchu.lib;

public interface Modchu_IItemFood extends Modchu_IItemMaster {
	// 180~
	public boolean updateItemStackNBT(Object nBTTagCompound);
	public Object getModel(Object itemStack, Object entityPlayer, int useRemaining);
	public int getItemEnchantability(Object itemStack);
	public boolean isBeaconPayment(Object itemStack);

	public void onFoodEaten(Object itemStack, Object world, Object entityPlayer);
	public int getHealAmount(Object itemStack);
	public float getSaturationModifier(Object itemStack);
	public boolean isWolfsFavoriteMeat();
	public Object setPotionEffect(int par1, int par2, int par3, float par4);
	public Object setAlwaysEdible();


}
