package modchu.lib;

public interface Modchu_IItemFoodMaster extends Modchu_IItemMaster {
	public void onFoodEaten(Object itemStack, Object world, Object entityPlayer);
	public int getHealAmount(Object itemStack);
	public float getSaturationModifier(Object itemStack);
	public boolean isWolfsFavoriteMeat();
	public Object setPotionEffect(int par1, int par2, int par3, float par4);
	public Object setAlwaysEdible();
	// 180~
	public boolean updateItemStackNBT(Object nBTTagCompound);
	public Object getModel(Object itemStack, Object entityPlayer, int useRemaining);
	public int getItemEnchantability(Object itemStack);
	public boolean isBeaconPayment(Object itemStack);
	// 190~
	public Object setPotionEffect(Object potionEffect, float p_185070_2_);
	public Object getPropertyGetter(Object resourceLocation);
	public boolean hasCustomProperties();
	public String getHighlightTip(Object itemStack, String displayName);
	public boolean shouldCauseReequipAnimation(Object itemStack, Object itemStack1, boolean slotChanged);
	public Object initCapabilities(Object itemStack, Object nBTTagCompound);

}
