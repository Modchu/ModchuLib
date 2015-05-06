package modchu.lib;

public interface Modchu_IItemRenderer {
	public void superRenderItem(Object entityLivingBase, Object itemStack, int par3);
	public void superRenderItem(Object entityLivingBase, Object itemStack, int par3, Object itemRenderType);
	public void superRenderOverlays(float par1);
	public void superUpdateEquippedItem();
	public void superResetEquippedProgress();
	public void superResetEquippedProgress2();
	public void superRenderItemInFirstPerson(float f);

}
