package modchu.lib.forge.mc162;

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

public class Modchu_GuiSlot extends GuiSlot implements Modchu_IGuiSlot {
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
	public void func_77207_a(int par1, int par2, int par3, int par4) {
		if (master != null) master.func_77207_a(par1, par2, par3, par4);
		else super.func_77207_a(par1, par2, par3, par4);
	}

	@Override
	public void superFunc_77207_a(int par1, int par2, int par3, int par4) {
		super.func_77207_a(par1, par2, par3, par4);
	}

	@Override
	protected void func_77223_a(boolean par1, int par2) {
		if (master != null) master.func_77223_a(par1, par2);
		else super.func_77223_a(par1, par2);
	}

	@Override
	public void superFunc_77223_a(boolean par1, int par2) {
		super.func_77223_a(par1, par2);
	}

	@Override
	protected void elementClicked(int i, boolean flag) {
		if (master != null) master.elementClicked(i, flag);
	}

	@Override
	public void superElementClicked(int i, boolean flag) {
	}

	@Override
	protected void drawSlot(int i, int j, int k, int l, Tessellator tessellator) {
		if (master != null) master.drawSlot(i, j, k, l, tessellator);
	}

	@Override
	public void superDrawSlot(int i, int j, int k, int l, Object tessellator) {
	}

	@Override
	protected void func_77222_a(int par1, int par2, Tessellator tessellator) {
		if (master != null) master.func_77222_a(par1, par2, tessellator);
		else super.func_77222_a(par1, par2, tessellator);
	}

	@Override
	public void superFunc_77222_a(int par1, int par2, Object tessellator) {
		super.func_77222_a(par1, par2, (Tessellator) tessellator);
	}

	@Override
	protected void func_77224_a(int par1, int par2) {
		if (master != null) master.func_77224_a(par1, par2);
		else super.func_77224_a(par1, par2);
	}

	@Override
	public void superFunc_77224_a(int par1, int par2) {
		super.func_77224_a(par1, par2);
	}

	@Override
	protected void func_77215_b(int par1, int par2) {
		if (master != null) master.func_77215_b(par1, par2);
		else super.func_77215_b(par1, par2);
	}

	@Override
	public void superFunc_77215_b(int par1, int par2) {
		super.func_77215_b(par1, par2);
	}

	@Override
	public int func_77210_c(int par1, int par2) {
		return master != null ? master.func_77210_c(par1, par2) : super.func_77210_c(par1, par2);
	}

	@Override
	public int superFunc_77210_c(int par1, int par2) {
		return super.func_77210_c(par1, par2);
	}

	@Override
	public int func_77209_d() {
		return master != null ? master.func_77209_d() : super.func_77209_d();
	}

	@Override
	public int superFunc_77209_d() {
		return super.func_77209_d();
	}

	@Override
	public void func_77208_b(int par1) {
		if (master != null) master.func_77208_b(par1);
		else super.func_77208_b(par1);
	}

	@Override
	public void superFunc_77208_b(int par1) {
		super.func_77208_b(par1);
	}

	@Override
	protected void overlayBackground(int par1, int par2, int par3, int par4) {
		if (master != null) master.overlayBackground(par1, par2, par3, par4);
		else super.overlayBackground(par1, par2, par3, par4);
	}

	@Override
	public void superOverlayBackground(int par1, int par2, int par3, int par4) {
		super.overlayBackground(par1, par2, par3, par4);
	}

	public void superFunc_148122_a(int p_148122_1_, int p_148122_2_, int p_148122_3_, int p_148122_4_) {
	}

	@Override
	public void superDrawSlot(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Object tessellator, int p_148126_6_, int p_148126_7_) {
	}

	@Override
	public void superSetDimensions(int p_148122_1_, int p_148122_2_, int p_148122_3_, int p_148122_4_) {
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
	public void superSetHasListHeader(boolean p_148133_1_, int p_148133_2_) {
	}

	@Override
	protected int getContentHeight() {
		return master != null ? master.getContentHeight() : super.getContentHeight();
	}

	@Override
	public int superGetContentHeight() {
		return super.getContentHeight();
	}

	@Override
	public void superUpdateItemPos(int p_178040_1_, int p_178040_2_, int p_178040_3_, float f) {
	}

	@Override
	public void superDrawListHeader(int p_148129_1_, int p_148129_2_, Object tessellator) {
	}

	@Override
	public void superClickedHeader(int p_148132_1_, int p_148132_2_) {
	}

	@Override
	public void superRenderDecorations(int p_148142_1_, int p_148142_2_) {
	}

	@Override
	public int superGetSlotIndexFromScreenCoords(int p_148124_1_, int p_148124_2_) {
		return -1;
	}

	@Override
	public void registerScrollButtons(int p_148134_1_, int p_148134_2_) {
		if (master != null) master.registerScrollButtons(null, p_148134_1_, p_148134_2_);
		else super.registerScrollButtons(p_148134_1_, p_148134_2_);
	}

	@Override
	public void superRegisterScrollButtons(int p_148134_1_, int p_148134_2_) {
		super.registerScrollButtons(p_148134_1_, p_148134_2_);
	}

	@Override
	public void superBindAmountScrolled() {
	}

	@Override
	public int superGetMaxScroll() {
		return -1;
	}

	@Override
	public int superGetAmountScrolled() {
		return -1;
	}

	@Override
	public boolean superIsMouseYWithinSlotBounds(int p_148141_1_) {
		return false;
	}

	@Override
	public void superScrollBy(int p_148145_1_) {
	}

	@Override
	public void actionPerformed(GuiButton guiButton) {
		if (master != null) master.actionPerformed(guiButton);
		else super.actionPerformed(guiButton);
	}

	@Override
	public void superActionPerformed(Object guiButton) {
		super.actionPerformed((GuiButton) guiButton);
	}

	@Override
	public void drawScreen(int mouseXIn, int mouseYIn, float p_148128_3_) {
		if (master != null) master.drawScreen(mouseXIn, mouseYIn, p_148128_3_);
		else super.drawScreen(mouseXIn, mouseYIn, p_148128_3_);
	}

	@Override
	public void superDrawScreen(int mouseXIn, int mouseYIn, float p_148128_3_) {
		super.drawScreen(mouseXIn, mouseYIn, p_148128_3_);
	}

	@Override
	public void superHandleMouseInput() {
	}

	@Override
	public void superSetEnabled(boolean p_148143_1_) {
	}

	@Override
	public boolean superGetEnabled() {
		return false;
	}

	@Override
	public int superGetListWidth() {
		return -1;
	}

	@Override
	public void superDrawSelectionBox(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_, float f) {
	}

	@Override
	protected int getScrollBarX() {
		return master != null ? master.getScrollBarX() : super.getScrollBarX();
	}

	@Override
	public int superGetScrollBarX() {
		return super.getScrollBarX();
	}

	@Override
	public void superSetSlotXBoundsFromLeft(int p_148140_1_) {
	}

	@Override
	public int superGetSlotHeight() {
		return -1;
	}

	@Override
	protected void drawContainerBackground(Tessellator tessellator) {
		if (master != null) master.drawContainerBackground(tessellator);
		else super.drawContainerBackground(tessellator);
	}

	@Override
	public void superDrawContainerBackground(Object tessellator) {
		super.drawContainerBackground((Tessellator) tessellator);
	}

	@Override
	public int getGuiSlotSize(int guiNumber) {
		return master != null ? master.getGuiSlotSize(guiNumber) : 0;
	}

	@Override
	public int superGetGuiSlotSize(int guiNumber) {
		return 0;
	}

	@Override
	public int getGuiSlotContentHeight(int guiNumber) {
		return master != null ? master.getGuiSlotContentHeight(guiNumber) : 0;
	}

	@Override
	public int superGetGuiSlotContentHeight(int guiNumber) {
		return 0;
	}

	@Override
	public void guiSlotElementClicked(int guiNumber, int i, boolean flag) {
		if (master != null) master.guiSlotElementClicked(guiNumber, i, flag);
	}

	@Override
	public void superGuiSlotElementClicked(int guiNumber, int i, boolean flag) {
	}

	@Override
	public void outOfRangeClick(int guiNumber, int mouse_x, int mouse_y, boolean flag) {
		if (master != null) master.outOfRangeClick(guiNumber, mouse_x, mouse_y, flag);
	}

	@Override
	public void superOutOfRangeClick(int guiNumber, int mouse_x, int mouse_y, boolean flag) {
	}

	@Override
	public boolean guiSlotIsSelected(int guiNumber, int i) {
		return master != null ? master.guiSlotIsSelected(guiNumber, i) : false;
	}

	@Override
	public boolean superGuiSlotIsSelected(int guiNumber, int i) {
		return false;
	}

	@Override
	public void guiSlotDrawSlot(int guiNumber, int i, int posX, int slotPosY, int k, int l, Object tessellator) {
		if (master != null) master.guiSlotDrawSlot(guiNumber, i, posX, slotPosY, k, l, tessellator);
	}

	@Override
	public void superGuiSlotDrawSlot(int guiNumber, int i, int posX, int slotPosY, int k, int l, Object tessellator) {
	}

	@Override
	public int getSlotScrollBarX(int guiNumber) {
		return master != null ? master.getSlotScrollBarX(guiNumber) : 0;
	}

	@Override
	public int superGetSlotScrollBarX(int guiNumber) {
		return 0;
	}

	@Override
	public int getSlotScrollBarSizeX(int guiNumber) {
		return master != null ? master.getSlotScrollBarSizeX(guiNumber) : 0;
	}

	@Override
	public int superGetSlotScrollBarSizeX(int guiNumber) {
		return 0;
	}

	@Override
	public int getTop(int guiNumber) {
		return master != null ? master.getTop(guiNumber) : 0;
	}

	@Override
	public int superGetTop(int guiNumber) {
		return 0;
	}

	@Override
	public int getBottom(int guiNumber) {
		return master != null ? master.getBottom(guiNumber) : 0;
	}

	@Override
	public int superGetBottom(int guiNumber) {
		return 0;
	}

	@Override
	public int getLimitSelectedDisplayCount(int guiNumber) {
		return master != null ? master.getLimitSelectedDisplayCount(guiNumber) : 0;
	}

	@Override
	public int superGetLimitSelectedDisplayCount(int guiNumber) {
		return 0;
	}

	@Override
	protected int getSize() {
		return master != null ? master.getSize() : 0;
	}

	@Override
	public int superGetSize() {
		return 0;
	}

	@Override
	public void superElementClicked(int slotIndex, boolean isDoubleClick, int mouseX, int mouseY) {
	}

	@Override
	protected boolean isSelected(int slotIndex) {
		return master != null ? master.isSelected(slotIndex) : false;
	}

	@Override
	public boolean superIsSelected(int slotIndex) {
		return false;
	}

	@Override
	protected void drawBackground() {
		if (master != null) master.drawBackground();
	}

	@Override
	public void superDrawBackground() {
	}

	@Override
	public void superDrawSlot(int entryID, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_, int p_180791_6_, float f) {
	}

	@Override
	public void superRegisterScrollButtons(List par1List, int par2, int par3) {
		superRegisterScrollButtons(par2, par3);
	}

}
