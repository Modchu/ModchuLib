package modchu.lib;

public interface Modchu_IItemRendererMaster {
	public void renderItemInFirstPerson(float f);
	public void renderItemInFirstPerson(float par1, float equippedProgress, float prevEquippedProgress);
	public void drawFirstPersonHand(Object r, int h);
	public boolean getFlipHorizontal();
	public void renderItem(Object entityLivingBase, Object itemStack, int par3);
	public void renderItem(Object entityLivingBase, Object itemStack, int par3, Object itemRenderType);
	public void renderOverlays(float par1);
	public void updateEquippedItem();
	public void resetEquippedProgress();
	public void resetEquippedProgress2();

}
