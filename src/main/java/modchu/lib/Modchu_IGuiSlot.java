package modchu.lib;

public interface Modchu_IGuiSlot {
	public int getGuiSlotSize(int guiNumber);
	public int getGuiSlotContentHeight(int guiNumber);
	public void guiSlotElementClicked(int guiNumber, int i, boolean flag);
	public void outOfRangeClick(int guiNumber, int mouse_x, int mouse_y, boolean flag);
	public boolean guiSlotIsSelected(int guiNumber, int i);
	public void guiSlotDrawSlot(int guiNumber, int i, int posX, int slotPosY, int k, int l, Object tessellator);
	public int getSlotScrollBarX(int guiNumber);
	public int getSlotScrollBarSizeX(int guiNumber);
	public int getTop(int guiNumber);
	public int getBottom(int guiNumber);
	public int getLimitSelectedDisplayCount(int guiNumber);
	public void superSetDimensions(int p_148122_1_, int p_148122_2_, int p_148122_3_, int p_148122_4_);
	public void superSetShowSelectionBox(boolean p_148130_1_);
	public void superSetHasListHeader(boolean p_148133_1_, int p_148133_2_);
	public int superGetContentHeight();
	public void superFunc_178040_a(int p_178040_1_, int p_178040_2_, int p_178040_3_);
	public void superDrawListHeader(int p_148129_1_, int p_148129_2_, Object tessellator);
	public void superFunc_148132_a(int p_148132_1_, int p_148132_2_);
	public void superFunc_148142_b(int p_148142_1_, int p_148142_2_);
	public int superGetSlotIndexFromScreenCoords(int p_148124_1_, int p_148124_2_);
	public void superRegisterScrollButtons(int p_148134_1_, int p_148134_2_);
	public void superBindAmountScrolled();
	public int superFunc_148135_f();
	public int superGetAmountScrolled();
	public boolean superIsMouseYWithinSlotBounds(int p_148141_1_);
	public void superScrollBy(int p_148145_1_);
	public void superActionPerformed(Object guiButton);
	public void superDrawScreen(int mouseXIn, int mouseYIn, float p_148128_3_);
	public void superHandleMouseInput();
	public void superSetEnabled(boolean p_148143_1_);
	public boolean superGetEnabled();
	public int superGetListWidth();
	public void superDrawSelectionBox(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_);
	public int superGetScrollBarX();
	public void superOverlayBackground(int p_148136_1_, int p_148136_2_, int p_148136_3_, int p_148136_4_);
	public void superSetSlotXBoundsFromLeft(int p_148140_1_);
	public int superGetSlotHeight();
	public void superDrawContainerBackground(Object tessellator);
	public int superGetGuiSlotSize(int guiNumber);
	public int superGetGuiSlotContentHeight(int guiNumber);
	public void superGuiSlotElementClicked(int guiNumber, int i, boolean flag);
	public void superOutOfRangeClick(int guiNumber, int mouse_x, int mouse_y, boolean flag);
	public boolean superGuiSlotIsSelected(int guiNumber, int i);
	public void superGuiSlotDrawSlot(int guiNumber, int i, int posX, int slotPosY, int k, int l, Object tessellator);
	public int superGetSlotScrollBarX(int guiNumber);
	public int superGetSlotScrollBarSizeX(int guiNumber);
	public int superGetTop(int guiNumber);
	public int superGetBottom(int guiNumber);
	public int superGetLimitSelectedDisplayCount(int guiNumber);
	public int superGetSize();
	public void superElementClicked(int slotIndex, boolean isDoubleClick, int mouseX, int mouseY);
	public boolean superIsSelected(int slotIndex);
	public void superDrawBackground();
	public void superDrawSlot(int entryID, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_, int p_180791_6_);

	// 179
	public void superDrawSlot(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Object tessellator, int p_148126_6_, int p_148126_7_);

	// 164
	public void superFunc_77207_a(int par1, int par2, int par3, int par4);
	public void superFunc_77223_a(boolean par1, int par2);
	public void superElementClicked(int i, boolean flag);
	public void superDrawSlot(int i, int j, int k, int l, Object tessellator);
	public void superFunc_77222_a(int par1, int par2, Object tessellator);
	public void superFunc_77224_a(int par1, int par2);
	public void superFunc_77215_b(int par1, int par2);
	public int superFunc_77210_c(int par1, int par2);
	public int superFunc_77209_d();
	public void superFunc_77208_b(int par1);

}
