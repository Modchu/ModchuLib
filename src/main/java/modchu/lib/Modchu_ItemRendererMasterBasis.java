package modchu.lib;

import java.util.HashMap;

public class Modchu_ItemRendererMasterBasis implements Modchu_IItemRendererMaster {
	public Modchu_IItemRenderer base;

	public Modchu_ItemRendererMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IItemRenderer) map.get("base");
	}

	@Override
	public void renderItemInFirstPerson(float par1, float equippedProgress, float prevEquippedProgress) {
	}

	@Override
	public void drawFirstPersonHand(Object r, int h) {
	}

	@Override
	public boolean getFlipHorizontal() {
		return false;
	}

	@Override
	public void renderItem(Object entityLivingBase, Object itemStack, int par3) {
		base.superRenderItem(entityLivingBase, itemStack, par3);
	}

	@Override
	public void renderItem(Object entityLivingBase, Object itemStack, int par3, Object itemRenderType) {
		base.superRenderItem(entityLivingBase, itemStack, par3, itemRenderType);
	}

	@Override
	public void renderOverlays(float par1) {
		base.superRenderOverlays(par1);
	}

	@Override
	public void updateEquippedItem() {
		base.superUpdateEquippedItem();
	}

	@Override
	public void resetEquippedProgress() {
		base.superResetEquippedProgress();
	}

	@Override
	public void resetEquippedProgress2() {
		base.superResetEquippedProgress2();
	}

	@Override
	public void renderItemInFirstPerson(float f) {
		base.superRenderItemInFirstPerson(f);
	}

	@Override
	public void renderItem(Object entityLivingBase, Object itemStack, Object transformType) {
		base.superRenderItem(entityLivingBase, itemStack, transformType);
	}

}
