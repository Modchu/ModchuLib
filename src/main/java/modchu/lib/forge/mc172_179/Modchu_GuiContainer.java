package modchu.lib.forge.mc172_179;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_IGuiContainer;
import modchu.lib.Modchu_IGuiContainerMaster;
import modchu.lib.Modchu_IRendererLivingEntityMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class Modchu_GuiContainer extends GuiContainer implements Modchu_IGuiContainer {
	public Modchu_IGuiContainerMaster master;

	public Modchu_GuiContainer(HashMap<String, Object> map) {
		super((Container) map.get("Object"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_GuiContainer init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IGuiContainerMaster ? (Modchu_IGuiContainerMaster) instance : null;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		if (master != null) master.drawGuiContainerBackgroundLayer(var1, var2, var3);
	}

	public void superDrawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
	}

	@Override
	public void initGui() {
		if (master != null) master.initGui();
		else super.initGui();
	}

	public void superInitGui() {
		super.initGui();
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		if (master != null) master.drawScreen(par1, par2, par3);
		else super.drawScreen(par1, par2, par3);
	}

	public void superDrawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		if (master != null) master.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
		else super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
	}

	public void superDrawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		if (master != null) master.mouseClicked(par1, par2, par3);
		else super.mouseClicked(par1, par2, par3);
	}

	public void superMouseClicked(int par1, int par2, int par3) {
		super.mouseClicked(par1, par2, par3);
	}

	@Override
	protected void mouseClickMove(int p_146273_1_, int p_146273_2_, int p_146273_3_, long p_146273_4_) {
		if (master != null) master.mouseClickMove(p_146273_1_, p_146273_2_, p_146273_3_, p_146273_4_);
		else super.mouseClickMove(p_146273_1_, p_146273_2_, p_146273_3_, p_146273_4_);
	}

	public void superMouseClickMove(int p_146273_1_, int p_146273_2_, int p_146273_3_, long p_146273_4_) {
		super.mouseClickMove(p_146273_1_, p_146273_2_, p_146273_3_, p_146273_4_);
	}

	@Override
	protected void mouseMovedOrUp(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
		if (master != null) master.mouseMovedOrUp(p_146286_1_, p_146286_2_, p_146286_3_);
		else super.mouseMovedOrUp(p_146286_1_, p_146286_2_, p_146286_3_);
	}

	public void superMouseMovedOrUp(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
		super.mouseMovedOrUp(p_146286_1_, p_146286_2_, p_146286_3_);
	}

	@Override
	protected boolean func_146978_c(int p_146978_1_, int p_146978_2_, int p_146978_3_, int p_146978_4_, int p_146978_5_, int p_146978_6_) {
		return master != null ? master.func_146978_c(p_146978_1_, p_146978_2_, p_146978_3_, p_146978_4_, p_146978_5_, p_146978_6_) : super.func_146978_c(p_146978_1_, p_146978_2_, p_146978_3_, p_146978_4_, p_146978_5_, p_146978_6_);
	}

	public boolean superFunc_146978_c(int p_146978_1_, int p_146978_2_, int p_146978_3_, int p_146978_4_, int p_146978_5_, int p_146978_6_) {
		return super.func_146978_c(p_146978_1_, p_146978_2_, p_146978_3_, p_146978_4_, p_146978_5_, p_146978_6_);
	}

	@Override
	protected void handleMouseClick(Slot slot, int p_146984_2_, int p_146984_3_, int p_146984_4_) {
		if (master != null) master.handleMouseClick(slot, p_146984_2_, p_146984_3_, p_146984_4_);
		else super.handleMouseClick(slot, p_146984_2_, p_146984_3_, p_146984_4_);
	}

	public void superHandleMouseClick(Object slot, int p_146984_2_, int p_146984_3_, int p_146984_4_) {
		super.handleMouseClick((Slot) slot, p_146984_2_, p_146984_3_, p_146984_4_);
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		if (master != null) master.keyTyped(par1, par2);
		else super.keyTyped(par1, par2);
	}

	public void superKeyTyped(char par1, int par2) {
		super.keyTyped(par1, par2);
	}

	@Override
	protected boolean checkHotbarKeys(int p_146983_1_) {
		return master != null ? master.checkHotbarKeys(p_146983_1_) : super.checkHotbarKeys(p_146983_1_);
	}

	public boolean superCheckHotbarKeys(int p_146983_1_) {
		return super.checkHotbarKeys(p_146983_1_);
	}

	@Override
	public void onGuiClosed() {
		if (master != null) master.onGuiClosed();
		else super.onGuiClosed();
	}

	public void superOnGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	public boolean doesGuiPauseGame() {
		return master != null ? master.doesGuiPauseGame() : super.doesGuiPauseGame();
	}

	public boolean superDoesGuiPauseGame() {
		return super.doesGuiPauseGame();
	}

	@Override
	public void updateScreen() {
		if (master != null) master.updateScreen();
		else super.updateScreen();
	}

	public void superUpdateScreen() {
		super.updateScreen();
	}

	@Override
	protected void renderToolTip(ItemStack itemStack, int p_146285_2_, int p_146285_3_) {
		if (master != null) master.renderToolTip(itemStack, p_146285_2_, p_146285_3_);
		else super.renderToolTip(itemStack, p_146285_2_, p_146285_3_);
	}

	public void superRenderToolTip(Object itemStack, int p_146285_2_, int p_146285_3_) {
		super.renderToolTip((ItemStack) itemStack, p_146285_2_, p_146285_3_);
	}

	@Override
	protected void drawCreativeTabHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_) {
		if (master != null) master.drawCreativeTabHoveringText(p_146279_1_, p_146279_2_, p_146279_3_);
		else super.drawCreativeTabHoveringText(p_146279_1_, p_146279_2_, p_146279_3_);
	}

	public void superDrawCreativeTabHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_) {
		super.drawCreativeTabHoveringText(p_146279_1_, p_146279_2_, p_146279_3_);
	}

	@Override
	protected void func_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_) {
		if (master != null) master.func_146283_a(p_146283_1_, p_146283_2_, p_146283_3_);
		else super.func_146283_a(p_146283_1_, p_146283_2_, p_146283_3_);
	}

	public void superFunc_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_) {
		super.func_146283_a(p_146283_1_, p_146283_2_, p_146283_3_);
	}

	@Override
	protected void drawHoveringText(List p_146283_1_, int p_146283_2_, int p_146283_3_, FontRenderer fontRenderer) {
		if (master != null) master.drawHoveringText(p_146283_1_, p_146283_2_, p_146283_3_, fontRenderer);
		else super.drawHoveringText(p_146283_1_, p_146283_2_, p_146283_3_, fontRenderer);
	}

	public void superDrawHoveringText(List p_146283_1_, int p_146283_2_, int p_146283_3_, Object fontRenderer) {
		super.drawHoveringText(p_146283_1_, p_146283_2_, p_146283_3_, (FontRenderer) fontRenderer);
	}

	@Override
	protected void actionPerformed(GuiButton guiButton) {
		if (master != null) master.actionPerformed(guiButton);
		else super.actionPerformed(guiButton);
	}

	public void superActionPerformed(Object guiButton) {
		super.actionPerformed((GuiButton) guiButton);
	}

	@Override
	public void setWorldAndResolution(Minecraft minecraft, int p_146280_2_, int p_146280_3_) {
		if (master != null) master.setWorldAndResolution(minecraft, p_146280_2_, p_146280_3_);
		else super.setWorldAndResolution(minecraft, p_146280_2_, p_146280_3_);
	}

	public void superSetWorldAndResolution(Object minecraft, int p_146280_2_, int p_146280_3_) {
		super.setWorldAndResolution((Minecraft) minecraft, p_146280_2_, p_146280_3_);
	}

	@Override
	public void handleInput() {
		if (master != null) master.handleInput();
		else super.handleInput();
	}

	public void superHandleInput() {
		super.handleInput();
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
	public void handleKeyboardInput() {
		if (master != null) master.handleKeyboardInput();
		else super.handleKeyboardInput();
	}

	public void superHandleKeyboardInput() {
		super.handleKeyboardInput();
	}

	@Override
	public void drawDefaultBackground() {
		if (master != null) master.drawDefaultBackground();
		else super.drawDefaultBackground();
	}

	public void superDrawDefaultBackground() {
		super.drawDefaultBackground();
	}

	@Override
	public void drawWorldBackground(int p_146270_1_) {
		if (master != null) master.drawWorldBackground(p_146270_1_);
		else super.drawWorldBackground(p_146270_1_);
	}

	public void superDrawWorldBackground(int p_146270_1_) {
		super.drawWorldBackground(p_146270_1_);
	}

	@Override
	public void drawBackground(int p_146278_1_) {
		if (master != null) master.drawBackground(p_146278_1_);
		else super.drawBackground(p_146278_1_);
	}

	public void superDrawBackground(int p_146278_1_) {
		super.drawBackground(p_146278_1_);
	}

	@Override
	public void confirmClicked(boolean par1, int par2) {
		if (master != null) master.confirmClicked(par1, par2);
		else super.confirmClicked(par1, par2);
	}

	public void superConfirmClicked(boolean par1, int par2) {
		super.confirmClicked(par1, par2);
	}

	@Override
	protected void drawHorizontalLine(int par1, int par2, int par3, int par4) {
		if (master != null) master.drawHorizontalLine(par1, par2, par3, par4);
		else super.drawHorizontalLine(par1, par2, par3, par4);
	}

	public void superDrawHorizontalLine(int par1, int par2, int par3, int par4) {
		super.drawHorizontalLine(par1, par2, par3, par4);
	}

	@Override
	protected void drawVerticalLine(int par1, int par2, int par3, int par4) {
		if (master != null) master.drawVerticalLine(par1, par2, par3, par4);
		else super.drawVerticalLine(par1, par2, par3, par4);
	}

	public void superDrawVerticalLine(int par1, int par2, int par3, int par4) {
		super.drawVerticalLine(par1, par2, par3, par4);
	}

	@Override
	protected void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6) {
		if (master != null) master.drawGradientRect(par1, par2, par3, par4, par5, par6);
		else super.drawGradientRect(par1, par2, par3, par4, par5, par6);
	}

	public void superDrawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6) {
		super.drawGradientRect(par1, par2, par3, par4, par5, par6);
	}

	@Override
	public void drawCenteredString(FontRenderer fontRenderer, String par2Str, int par3, int par4, int par5) {
		if (master != null) master.drawCenteredString(fontRenderer, par2Str, par3, par4, par5);
		else super.drawCenteredString(fontRenderer, par2Str, par3, par4, par5);
	}

	public void superDrawCenteredString(Object fontRenderer, String par2Str, int par3, int par4, int par5) {
		super.drawCenteredString((FontRenderer) fontRenderer, par2Str, par3, par4, par5);
	}

	@Override
	public void drawString(FontRenderer fontRenderer, String par2Str, int par3, int par4, int par5) {
		if (master != null) master.drawString(fontRenderer, par2Str, par3, par4, par5);
		else super.drawString(fontRenderer, par2Str, par3, par4, par5);
	}

	public void superDrawString(Object fontRenderer, String par2Str, int par3, int par4, int par5) {
		super.drawString((FontRenderer) fontRenderer, par2Str, par3, par4, par5);
	}

	@Override
	public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {
		if (master != null) master.drawTexturedModalRect(par1, par2, par3, par4, par5, par6);
		else super.drawTexturedModalRect(par1, par2, par3, par4, par5, par6);
	}

	public void superDrawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {
		super.drawTexturedModalRect(par1, par2, par3, par4, par5, par6);
	}

	@Override
	public void drawTexturedModelRectFromIcon(int par1, int par2, IIcon iIcon, int par4, int par5) {
		if (master != null) master.drawTexturedModelRectFromIcon(par1, par2, iIcon, par4, par5);
		else super.drawTexturedModelRectFromIcon(par1, par2, iIcon, par4, par5);
	}

	public void superDrawTexturedModelRectFromIcon(int par1, int par2, Object iIcon, int par4, int par5) {
		super.drawTexturedModelRectFromIcon(par1, par2, (IIcon) iIcon, par4, par5);
	}
	// ~164
	@Override
	public void superDrawItemStackTooltip(Object itemStack, int par2, int par3) {
	}

	@Override
	public void superFunc_102021_a(List par1List, int par2, int par3) {
	}

	@Override
	public void superDrawSlotInventory(Object slot) {
	}

	@Override
	public boolean superIsPointInRegion(int par1, int par2, int par3, int par4, int par5, int par6) {
		return false;
	}

}
