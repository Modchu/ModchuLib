package modchu.lib;

public interface Modchu_IGuiSlotMaster {
	public void setDimensions(int p_148122_1_, int p_148122_2_, int p_148122_3_, int p_148122_4_);
	public void setShowSelectionBox(boolean p_148130_1_);
	public void setHasListHeader(boolean p_148133_1_, int p_148133_2_);
	public int getContentHeight();
	public void updateItemPos(int p_178040_1_, int p_178040_2_, int p_178040_3_);
	public void drawListHeader(int p_148129_1_, int p_148129_2_, Object tessellator);
	public void clickedHeader(int p_148132_1_, int p_148132_2_);
	public void renderDecorations(int p_148142_1_, int p_148142_2_);
	public int getSlotIndexFromScreenCoords(int p_148124_1_, int p_148124_2_);
	public void registerScrollButtons(int p_148134_1_, int p_148134_2_);
	public void bindAmountScrolled();
	public int getMaxScroll();
	public int getAmountScrolled();
	public boolean isMouseYWithinSlotBounds(int p_148141_1_);
	public void scrollBy(int p_148145_1_);
	public void actionPerformed(Object guiButton);
	public void drawScreen(int mouseXIn, int mouseYIn, float p_148128_3_);
	public void handleMouseInput();
	public void setEnabled(boolean p_148143_1_);
	public boolean getEnabled();
	public int getListWidth();
	public void drawSelectionBox(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_);
	public int getScrollBarX();
	public void overlayBackground(int p_148136_1_, int p_148136_2_, int p_148136_3_, int p_148136_4_);
	public void setSlotXBoundsFromLeft(int p_148140_1_);
	public int getSlotHeight();
	public void drawContainerBackground(Object tessellator);
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
	public int getSize();
	public void elementClicked(int slotIndex, boolean isDoubleClick, int mouseX, int mouseY);
	public boolean isSelected(int slotIndex);
	public void drawBackground();
	public void drawSlot(int entryID, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_, int p_180791_6_);

	// 179
	public void drawSlot(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Object tessellator, int p_148126_6_, int p_148126_7_);

	// 164
	public void func_77207_a(int par1, int par2, int par3, int par4);
	public void func_77223_a(boolean par1, int par2);
	public void elementClicked(int i, boolean flag);
	public void drawSlot(int i, int j, int k, int l, Object tessellator);
	public void func_77222_a(int par1, int par2, Object tessellator);
	public void func_77224_a(int par1, int par2);
	public void func_77215_b(int par1, int par2);
	public int func_77210_c(int par1, int par2);
	public int func_77209_d();
	public void func_77208_b(int par1);

}
