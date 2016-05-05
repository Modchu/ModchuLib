package modchu.lib;

import java.util.List;

public interface Modchu_IItemFood extends Modchu_IItem {
	public String superGetArmorTexture(Object itemStack, Object entity, int slot, int layer);
	public boolean superIsValidArmor(Object itemStack, int armorType, Object entity);
	public String superGetArmorTexture(Object itemStack, Object entity, int slot, String type);
	public void superOnFoodEaten(Object itemStack, Object world, Object entityPlayer);
	public boolean superIsWolfsFavoriteMeat();
	public Object superSetPotionEffect(int par1, int par2, int par3, float par4);
	public Object superSetAlwaysEdible();
	public Object superGetModel(Object itemStack, Object entityPlayer, int useRemaining);
	public int superGetHealAmount(Object itemStack);
	public float superGetSaturationModifier(Object itemStack);
	// 190~
	public Object superSetPotionEffect(Object potionEffect, float p_185070_2_);
	public Object superGetPropertyGetter(Object resourceLocation);
	public boolean superHasCustomProperties();
	public String superGetHighlightTip(Object itemStack, String displayName);
	public boolean superShouldCauseReequipAnimation(Object itemStack, Object itemStack1, boolean slotChanged);
	public Object superInitCapabilities(Object itemStack, Object nBTTagCompound);

}
