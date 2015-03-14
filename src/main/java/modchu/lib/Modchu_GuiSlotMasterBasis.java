package modchu.lib;

import java.util.HashMap;

public class Modchu_GuiSlotMasterBasis implements Modchu_IGuiSlotMaster {
	public Modchu_IGuiSlot base;

	public Modchu_GuiSlotMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IGuiSlot) map.get("base");
	}

	@Override
	public void setDimensions(int p_148122_1_, int p_148122_2_, int p_148122_3_, int p_148122_4_) {
		base.superSetDimensions(p_148122_1_, p_148122_2_, p_148122_3_, p_148122_4_);
	}

	@Override
	public void setShowSelectionBox(boolean p_148130_1_) {
		base.superSetShowSelectionBox(p_148130_1_);
	}

	@Override
	public void setHasListHeader(boolean p_148133_1_, int p_148133_2_) {
		base.superSetHasListHeader(p_148133_1_, p_148133_2_);
	}

	@Override
	public int getContentHeight() {
		return base.superGetContentHeight();
	}

	@Override
	public void func_178040_a(int p_178040_1_, int p_178040_2_, int p_178040_3_) {
		base.superFunc_178040_a(p_178040_1_, p_178040_2_, p_178040_3_);
	}

	@Override
	public void drawListHeader(int p_148129_1_, int p_148129_2_, Object tessellator) {
		base.superDrawListHeader(p_148129_1_, p_148129_2_, tessellator);
	}

	@Override
	public void func_148132_a(int p_148132_1_, int p_148132_2_) {
		base.superFunc_148132_a(p_148132_1_, p_148132_2_);
	}

	@Override
	public void func_148142_b(int p_148142_1_, int p_148142_2_) {
		base.superFunc_148142_b(p_148142_1_, p_148142_2_);
	}

	@Override
	public int getSlotIndexFromScreenCoords(int p_148124_1_, int p_148124_2_) {
		return base.superGetSlotIndexFromScreenCoords(p_148124_1_, p_148124_2_);
	}

	@Override
	public void registerScrollButtons(int p_148134_1_, int p_148134_2_) {
		base.superRegisterScrollButtons(p_148134_1_, p_148134_2_);
	}

	@Override
	public void bindAmountScrolled() {
		base.superBindAmountScrolled();
	}

	@Override
	public int func_148135_f() {
		return base.superFunc_148135_f();
	}

	@Override
	public int getAmountScrolled() {
		return base.superGetAmountScrolled();
	}

	@Override
	public boolean isMouseYWithinSlotBounds(int p_148141_1_) {
		return base.superIsMouseYWithinSlotBounds(p_148141_1_);
	}

	@Override
	public void scrollBy(int p_148145_1_) {
		base.superScrollBy(p_148145_1_);
	}

	@Override
	public void actionPerformed(Object guiButton) {
		base.superActionPerformed(guiButton);
	}

	@Override
	public void drawScreen(int mouseXIn, int mouseYIn, float p_148128_3_) {
		base.superDrawScreen(mouseXIn, mouseYIn, p_148128_3_);
	}

	@Override
	public void handleMouseInput() {
		base.superHandleMouseInput();
	}

	@Override
	public void setEnabled(boolean p_148143_1_) {
		base.superSetEnabled(p_148143_1_);
	}

	@Override
	public boolean getEnabled() {
		return base.superGetEnabled();
	}

	@Override
	public int getListWidth() {
		return base.superGetListWidth();
	}

	@Override
	public void drawSelectionBox(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_) {
		base.superDrawSelectionBox(p_148120_1_, p_148120_2_, p_148120_3_, p_148120_4_);
	}

	@Override
	public int getScrollBarX() {
		return base.superGetScrollBarX();
	}

	@Override
	public void overlayBackground(int p_148136_1_, int p_148136_2_, int p_148136_3_, int p_148136_4_) {
		base.superOverlayBackground(p_148136_1_, p_148136_2_, p_148136_3_, p_148136_4_);
	}

	@Override
	public void setSlotXBoundsFromLeft(int p_148140_1_) {
		base.superSetSlotXBoundsFromLeft(p_148140_1_);
	}

	@Override
	public int getSlotHeight() {
		return base.superGetSlotHeight();
	}

	@Override
	public void drawContainerBackground(Object tessellator) {
		base.superDrawContainerBackground(tessellator);
	}

	@Override
	public int getGuiSlotSize(int guiNumber) {
		return base.superGetGuiSlotSize(guiNumber);
	}

	@Override
	public int getGuiSlotContentHeight(int guiNumber) {
		return base.superGetGuiSlotContentHeight(guiNumber);
	}

	@Override
	public void guiSlotElementClicked(int guiNumber, int i, boolean flag) {
		base.superGuiSlotElementClicked(guiNumber, i, flag);
	}

	@Override
	public void outOfRangeClick(int guiNumber, int mouse_x, int mouse_y, boolean flag) {
		base.superOutOfRangeClick(guiNumber, mouse_x, mouse_y, flag);
	}

	@Override
	public boolean guiSlotIsSelected(int guiNumber, int i) {
		return base.superGuiSlotIsSelected(guiNumber, i);
	}

	@Override
	public void guiSlotDrawSlot(int guiNumber, int i, int posX, int slotPosY, int k, int l, Object tessellator) {
		base.superGuiSlotDrawSlot(guiNumber, i, posX, slotPosY, k, l, tessellator);
	}

	@Override
	public int getSlotScrollBarX(int guiNumber) {
		return base.superGetSlotScrollBarX(guiNumber);
	}

	@Override
	public int getSlotScrollBarSizeX(int guiNumber) {
		return base.superGetSlotScrollBarSizeX(guiNumber);
	}

	@Override
	public int getTop(int guiNumber) {
		return base.superGetTop(guiNumber);
	}

	@Override
	public int getBottom(int guiNumber) {
		return base.superGetBottom(guiNumber);
	}

	@Override
	public int getLimitSelectedDisplayCount(int guiNumber) {
		return base.superGetLimitSelectedDisplayCount(guiNumber);
	}

	@Override
	public int getSize() {
		return base.superGetSize();
	}

	@Override
	public void elementClicked(int slotIndex, boolean isDoubleClick, int mouseX, int mouseY) {
		base.superElementClicked(slotIndex, isDoubleClick, mouseX, mouseY);
	}

	@Override
	public boolean isSelected(int slotIndex) {
		return base.superIsSelected(slotIndex);
	}

	@Override
	public void drawBackground() {
		base.superDrawBackground();
	}

	@Override
	public void drawSlot(int entryID, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_, int p_180791_6_) {
		base.superDrawSlot(entryID, p_180791_2_, p_180791_3_, p_180791_4_, p_180791_5_, p_180791_6_);
	}

	@Override
	public void drawSlot(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Object tessellator, int p_148126_6_, int p_148126_7_) {
		base.superDrawSlot(p_148126_1_, p_148126_2_, p_148126_3_, p_148126_4_, tessellator, p_148126_6_, p_148126_7_);
	}

	@Override
	public void func_77207_a(int par1, int par2, int par3, int par4) {
		base.superFunc_77207_a(par1, par2, par3, par4);
	}

	@Override
	public void func_77223_a(boolean par1, int par2) {
		base.superFunc_77223_a(par1, par2);
	}

	@Override
	public void elementClicked(int i, boolean flag) {
		base.superElementClicked(i, flag);
	}

	@Override
	public void drawSlot(int i, int j, int k, int l, Object tessellator) {
		base.superDrawSlot(i, j, k, l, tessellator);
	}

	@Override
	public void func_77222_a(int par1, int par2, Object tessellator) {
		base.superFunc_77222_a(par1, par2, tessellator);
	}

	@Override
	public void func_77224_a(int par1, int par2) {
		base.superFunc_77224_a(par1, par2);
	}

	@Override
	public void func_77215_b(int par1, int par2) {
		base.superFunc_77215_b(par1, par2);
	}

	@Override
	public int func_77210_c(int par1, int par2) {
		return base.superFunc_77210_c(par1, par2);
	}

	@Override
	public int func_77209_d() {
		return base.superFunc_77209_d();
	}

	@Override
	public void func_77208_b(int par1) {
		base.superFunc_77208_b(par1);
	}

}
