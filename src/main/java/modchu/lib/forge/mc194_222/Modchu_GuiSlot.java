package modchu.lib.forge.mc194_222;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IGuiSlot;
import modchu.lib.Modchu_IGuiSlotMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;

public abstract class Modchu_GuiSlot extends GuiSlot implements Modchu_IGuiSlot {
	public Modchu_IGuiSlotMaster master;

	public Modchu_GuiSlot(HashMap<String, Object> map) {
		super((Minecraft)Modchu_AS.get(Modchu_AS.minecraftGetMinecraft), (Integer)map.get("Integer"), (Integer)map.get("Integer1"), (Integer)map.get("Integer2"), (Integer)map.get("Integer3"), (Integer)map.get("Integer4"));
		Modchu_Debug.lDebug("Modchu_GuiSlot init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.lDebug("Modchu_GuiSlot instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IGuiSlotMaster ? (Modchu_IGuiSlotMaster) instance : null;
	}

	@Override
	public void setDimensions(int p_148122_1_, int p_148122_2_, int p_148122_3_, int p_148122_4_) {
		if (master != null) master.setDimensions(p_148122_1_, p_148122_2_, p_148122_3_, p_148122_4_);
		else super.setDimensions(p_148122_1_, p_148122_2_, p_148122_3_, p_148122_4_);
	}

	public void superSetDimensions(int p_148122_1_, int p_148122_2_, int p_148122_3_, int p_148122_4_) {
		super.setDimensions(p_148122_1_, p_148122_2_, p_148122_3_, p_148122_4_);
	}

	@Override
	protected void setHasListHeader(boolean p_148133_1_, int p_148133_2_) {
		if (master != null) master.setHasListHeader(p_148133_1_, p_148133_2_);
		else super.setHasListHeader(p_148133_1_, p_148133_2_);
	}

	public void superSetHasListHeader(boolean p_148133_1_, int p_148133_2_) {
		super.setHasListHeader(p_148133_1_, p_148133_2_);
	}

	@Override
	protected int getContentHeight() {
		return master != null ? master.getContentHeight() : super.getContentHeight();
	}

	public int superGetContentHeight() {
		return super.getContentHeight();
	}

	@Override
	protected void drawListHeader(int p_148129_1_, int p_148129_2_, Tessellator tessellator) {
		if (master != null) master.drawListHeader(p_148129_1_, p_148129_2_, tessellator);
		else super.drawListHeader(p_148129_1_, p_148129_2_, tessellator);
	}

	public void superDrawListHeader(int p_148129_1_, int p_148129_2_, Object tessellator) {
		super.drawListHeader(p_148129_1_, p_148129_2_, (Tessellator) tessellator);
	}

	@Override
	protected void clickedHeader(int p_148132_1_, int p_148132_2_) {
		if (master != null) master.clickedHeader(p_148132_1_, p_148132_2_);
		else super.clickedHeader(p_148132_1_, p_148132_2_);
	}

	public void superClickedHeader(int p_148132_1_, int p_148132_2_) {
		super.clickedHeader(p_148132_1_, p_148132_2_);
	}

	@Override
	protected void renderDecorations(int p_148142_1_, int p_148142_2_) {
		if (master != null) master.renderDecorations(p_148142_1_, p_148142_2_);
		else super.renderDecorations(p_148142_1_, p_148142_2_);
	}

	public void superRenderDecorations(int p_148142_1_, int p_148142_2_) {
		super.renderDecorations(p_148142_1_, p_148142_2_);
	}

	@Override
	public int getSlotIndexFromScreenCoords(int p_148124_1_, int p_148124_2_) {
		return master != null ? master.getSlotIndexFromScreenCoords(p_148124_1_, p_148124_2_) : super.getSlotIndexFromScreenCoords(p_148124_1_, p_148124_2_);
	}

	public int superGetSlotIndexFromScreenCoords(int p_148124_1_, int p_148124_2_) {
		return super.getSlotIndexFromScreenCoords(p_148124_1_, p_148124_2_);
	}

	@Override
	public void registerScrollButtons(int p_148134_1_, int p_148134_2_) {
		if (master != null) master.registerScrollButtons(null, p_148134_1_, p_148134_2_);
		else super.registerScrollButtons(p_148134_1_, p_148134_2_);
	}

	public void superRegisterScrollButtons(int p_148134_1_, int p_148134_2_) {
		super.registerScrollButtons(p_148134_1_, p_148134_2_);
	}

	@Override
	protected void bindAmountScrolled() {
		if (master != null) master.bindAmountScrolled();
		else super.bindAmountScrolled();
	}

	public void superBindAmountScrolled() {
		super.bindAmountScrolled();
	}

	@Override
	public int getMaxScroll() {
		return master != null ? master.getMaxScroll() : super.getMaxScroll();
	}

	public int superGetMaxScroll() {
		return super.getMaxScroll();
	}

	@Override
	public int getAmountScrolled() {
		return master != null ? master.getAmountScrolled() : super.getAmountScrolled();
	}

	public int superGetAmountScrolled() {
		return super.getAmountScrolled();
	}

	@Override
	public boolean isMouseYWithinSlotBounds(int p_148141_1_) {
		return master != null ? master.isMouseYWithinSlotBounds(p_148141_1_) : super.isMouseYWithinSlotBounds(p_148141_1_);
	}

	public boolean superIsMouseYWithinSlotBounds(int p_148141_1_) {
		return super.isMouseYWithinSlotBounds(p_148141_1_);
	}

	@Override
	public void scrollBy(int p_148145_1_) {
		if (master != null) master.scrollBy(p_148145_1_);
		else super.scrollBy(p_148145_1_);
	}

	public void superScrollBy(int p_148145_1_) {
		super.scrollBy(p_148145_1_);
	}

	@Override
	public void actionPerformed(GuiButton guiButton) {
		if (master != null) master.actionPerformed(guiButton);
		else super.actionPerformed(guiButton);
	}

	public void superActionPerformed(Object guiButton) {
		super.actionPerformed((GuiButton) guiButton);
	}

	@Override
	public void drawScreen(int mouseXIn, int mouseYIn, float p_148128_3_) {
		if (master != null) master.drawScreen(mouseXIn, mouseYIn, p_148128_3_);
		else super.drawScreen(mouseXIn, mouseYIn, p_148128_3_);
	}

	public void superDrawScreen(int mouseXIn, int mouseYIn, float p_148128_3_) {
		super.drawScreen(mouseXIn, mouseYIn, p_148128_3_);
	}

	@Override
	public void handleMouseInput() {
		if (master != null) master.handleMouseInput();
		else super.handleMouseInput();
	}

	public void superHandleMouseInput() {
		super.handleMouseInput();
	}

	@Override
	public void setEnabled(boolean p_148143_1_) {
		if (master != null) master.setEnabled(p_148143_1_);
		else super.setEnabled(p_148143_1_);
	}

	public void superSetEnabled(boolean p_148143_1_) {
		super.setEnabled(p_148143_1_);
	}

	@Override
	public boolean getEnabled() {
		return master != null ? master.getEnabled() : super.getEnabled();
	}

	public boolean superGetEnabled() {
		return super.getEnabled();
	}

	@Override
	public int getListWidth() {
		return master != null ? master.getListWidth() : super.getListWidth();
	}

	public int superGetListWidth() {
		return super.getListWidth();
	}

	@Override
	protected int getScrollBarX() {
		return master != null ? master.getScrollBarX() : super.getScrollBarX();
	}

	public int superGetScrollBarX() {
		return super.getScrollBarX();
	}

	@Override
	protected void overlayBackground(int p_148136_1_, int p_148136_2_, int p_148136_3_, int p_148136_4_) {
		if (master != null) master.overlayBackground(p_148136_1_, p_148136_2_, p_148136_3_, p_148136_4_);
		else super.overlayBackground(p_148136_1_, p_148136_2_, p_148136_3_, p_148136_4_);
	}

	public void superOverlayBackground(int p_148136_1_, int p_148136_2_, int p_148136_3_, int p_148136_4_) {
		super.overlayBackground(p_148136_1_, p_148136_2_, p_148136_3_, p_148136_4_);
	}

	@Override
	public void setSlotXBoundsFromLeft(int p_148140_1_) {
		if (master != null) master.setSlotXBoundsFromLeft(p_148140_1_);
		else super.setSlotXBoundsFromLeft(p_148140_1_);
	}

	public void superSetSlotXBoundsFromLeft(int p_148140_1_) {
		super.setSlotXBoundsFromLeft(p_148140_1_);
	}

	@Override
	public int getSlotHeight() {
		return master != null ? master.getSlotHeight() : super.getSlotHeight();
	}

	public int superGetSlotHeight() {
		return super.getSlotHeight();
	}

	@Override
	protected void drawContainerBackground(Tessellator tessellator) {
		if (master != null) master.drawContainerBackground(tessellator);
		else super.drawContainerBackground(tessellator);
	}

	public void superDrawContainerBackground(Object tessellator) {
		super.drawContainerBackground((Tessellator) tessellator);
	}

	@Override
	public int getGuiSlotSize(int guiNumber) {
		return master != null ? master.getGuiSlotSize(guiNumber) : 0;
	}

	public int superGetGuiSlotSize(int guiNumber) {
		return 0;
	}

	@Override
	public int getGuiSlotContentHeight(int guiNumber) {
		return master != null ? master.getGuiSlotContentHeight(guiNumber) : 0;
	}

	public int superGetGuiSlotContentHeight(int guiNumber) {
		return 0;
	}

	@Override
	public void guiSlotElementClicked(int guiNumber, int i, boolean flag) {
		if (master != null) master.guiSlotElementClicked(guiNumber, i, flag);
	}

	public void superGuiSlotElementClicked(int guiNumber, int i, boolean flag) {
	}

	@Override
	public void outOfRangeClick(int guiNumber, int mouse_x, int mouse_y, boolean flag) {
		if (master != null) master.outOfRangeClick(guiNumber, mouse_x, mouse_y, flag);
	}

	public void superOutOfRangeClick(int guiNumber, int mouse_x, int mouse_y, boolean flag) {
	}

	@Override
	public boolean guiSlotIsSelected(int guiNumber, int i) {
		return master != null ? master.guiSlotIsSelected(guiNumber, i) : false;
	}

	public boolean superGuiSlotIsSelected(int guiNumber, int i) {
		return false;
	}

	@Override
	public void guiSlotDrawSlot(int guiNumber, int i, int posX, int slotPosY, int k, int l, Object tessellator) {
		if (master != null) master.guiSlotDrawSlot(guiNumber, i, posX, slotPosY, k, l, tessellator);
	}

	public void superGuiSlotDrawSlot(int guiNumber, int i, int posX, int slotPosY, int k, int l, Object tessellator) {
	}

	@Override
	public int getSlotScrollBarX(int guiNumber) {
		return master != null ? master.getSlotScrollBarX(guiNumber) : 0;
	}

	public int superGetSlotScrollBarX(int guiNumber) {
		return 0;
	}

	@Override
	public int getSlotScrollBarSizeX(int guiNumber) {
		return master != null ? master.getSlotScrollBarSizeX(guiNumber) : 0;
	}

	public int superGetSlotScrollBarSizeX(int guiNumber) {
		return 0;
	}

	@Override
	public int getTop(int guiNumber) {
		return master != null ? master.getTop(guiNumber) : 0;
	}

	public int superGetTop(int guiNumber) {
		return 0;
	}

	@Override
	public int getBottom(int guiNumber) {
		return master != null ? master.getBottom(guiNumber) : 0;
	}

	public int superGetBottom(int guiNumber) {
		return 0;
	}

	@Override
	public int getLimitSelectedDisplayCount(int guiNumber) {
		return master != null ? master.getLimitSelectedDisplayCount(guiNumber) : 0;
	}

	public int superGetLimitSelectedDisplayCount(int guiNumber) {
		return 0;
	}

	@Override
	protected int getSize() {
		return master != null ? master.getSize() : 0;
	}

	public int superGetSize() {
		return 0;
	}

	@Override
	protected void elementClicked(int slotIndex, boolean isDoubleClick, int mouseX, int mouseY) {
		if (master != null) master.elementClicked(slotIndex, isDoubleClick, mouseX, mouseY);
	}

	public void superElementClicked(int slotIndex, boolean isDoubleClick, int mouseX, int mouseY) {
	}

	@Override
	protected boolean isSelected(int slotIndex) {
		return master != null ? master.isSelected(slotIndex) : false;
	}

	public boolean superIsSelected(int slotIndex) {
		return false;
	}

	@Override
	protected void drawBackground() {
		if (master != null) master.drawBackground();
	}

	public void superDrawBackground() {
	}

	@Override
	public void superDrawSlot(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Object tessellator, int p_148126_6_, int p_148126_7_) {
		superDrawSlot(p_148126_1_, p_148126_2_, p_148126_3_, p_148126_4_, p_148126_6_, p_148126_7_, 0.0F);
	}

	@Override
	public void superFunc_77207_a(int par1, int par2, int par3, int par4) {
	}

	@Override
	public void superFunc_77223_a(boolean par1, int par2) {
	}

	@Override
	public void superElementClicked(int i, boolean flag) {
	}

	@Override
	public void superDrawSlot(int i, int j, int k, int l, Object tessellator) {
	}

	@Override
	public void superFunc_77222_a(int par1, int par2, Object tessellator) {
	}

	@Override
	public void superFunc_77224_a(int par1, int par2) {
	}

	@Override
	public void superFunc_77215_b(int par1, int par2) {
	}

	@Override
	public int superFunc_77210_c(int par1, int par2) {
		return -1;
	}

	@Override
	public int superFunc_77209_d() {
		return -1;
	}

	@Override
	public void superFunc_77208_b(int par1) {
	}

	@Override
	public void setShowSelectionBox(boolean p_148130_1_) {
		if (master != null) master.setShowSelectionBox(p_148130_1_);
		else super.setShowSelectionBox(p_148130_1_);
	}

	@Override
	public void superSetShowSelectionBox(boolean p_148130_1_) {
		super.setShowSelectionBox(p_148130_1_);
	}

	@Override
	public void superDrawSlot(int entryID, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_, int p_180791_6_, float p_192637_7_) {
	}

	@Override
	public void superRegisterScrollButtons(List par1List, int par2, int par3) {
		superRegisterScrollButtons(par2, par3);
	}

}
