package modchu.lib;

import java.util.HashMap;
import java.util.List;

public class Modchu_GuiContainerMasterBasis implements Modchu_IGuiContainerMaster {
	public Modchu_IGuiContainer base;

	public Modchu_GuiContainerMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IGuiContainer) map.get("base");
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		base.superDrawGuiContainerBackgroundLayer(var1, var2, var3);
	}

	@Override
	public void initGui() {
		base.superInitGui();
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		base.superDrawScreen(par1, par2, par3);
	}

	@Override
	public void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		base.superDrawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
	}

	@Override
	public void mouseClicked(int par1, int par2, int par3) {
		base.superMouseClicked(par1, par2, par3);
	}

	@Override
	public void mouseClickMove(int p_146273_1_, int p_146273_2_, int p_146273_3_, long p_146273_4_) {
		base.superMouseClickMove(p_146273_1_, p_146273_2_, p_146273_3_, p_146273_4_);
	}

	@Override
	public void mouseMovedOrUp(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
		base.superMouseMovedOrUp(p_146286_1_, p_146286_2_, p_146286_3_);
	}

	@Override
	public boolean func_146978_c(int p_146978_1_, int p_146978_2_, int p_146978_3_, int p_146978_4_, int p_146978_5_, int p_146978_6_) {
		return base.superFunc_146978_c(p_146978_1_, p_146978_2_, p_146978_3_, p_146978_4_, p_146978_5_, p_146978_6_);
	}

	@Override
	public void handleMouseClick(Object slot, int p_146984_2_, int p_146984_3_, int p_146984_4_) {
		base.superHandleMouseClick(slot, p_146984_2_, p_146984_3_, p_146984_4_);
	}

	@Override
	public void keyTyped(char par1, int par2) {
		base.superKeyTyped(par1, par2);
	}

	@Override
	public boolean checkHotbarKeys(int p_146983_1_) {
		return base.superCheckHotbarKeys(p_146983_1_);
	}

	@Override
	public void onGuiClosed() {
		base.superOnGuiClosed();
	}

	@Override
	public boolean doesGuiPauseGame() {
		return base.superDoesGuiPauseGame();
	}

	@Override
	public void updateScreen() {
		base.superUpdateScreen();
	}

	@Override
	public void renderToolTip(Object itemStack, int p_146285_2_, int p_146285_3_) {
		base.superRenderToolTip(itemStack, p_146285_2_, p_146285_3_);
	}

	@Override
	public void drawCreativeTabHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_) {
		base.superDrawCreativeTabHoveringText(p_146279_1_, p_146279_2_, p_146279_3_);
	}

	@Override
	public void func_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_) {
		base.superFunc_146283_a(p_146283_1_, p_146283_2_, p_146283_3_);
	}

	@Override
	public void drawHoveringText(List p_146283_1_, int p_146283_2_, int p_146283_3_, Object fontRenderer) {
		base.superDrawHoveringText(p_146283_1_, p_146283_2_, p_146283_3_, fontRenderer);
	}

	@Override
	public void actionPerformed(Object guiButton) {
		base.superActionPerformed(guiButton);
	}

	@Override
	public void setWorldAndResolution(Object minecraft, int p_146280_2_, int p_146280_3_) {
		base.superSetWorldAndResolution(minecraft, p_146280_2_, p_146280_3_);
	}

	@Override
	public void handleInput() {
		base.superHandleInput();
	}

	@Override
	public void handleMouseInput() {
		base.superHandleMouseInput();
	}

	@Override
	public void handleKeyboardInput() {
		base.superHandleKeyboardInput();
	}

	@Override
	public void drawDefaultBackground() {
		base.superDrawDefaultBackground();
	}

	@Override
	public void drawWorldBackground(int p_146270_1_) {
		base.superDrawWorldBackground(p_146270_1_);
	}

	@Override
	public void drawBackground(int p_146278_1_) {
		base.superDrawBackground(p_146278_1_);
	}

	@Override
	public void confirmClicked(boolean par1, int par2) {
		base.superConfirmClicked(par1, par2);
	}

	@Override
	public void drawHorizontalLine(int par1, int par2, int par3, int par4) {
		base.superDrawHorizontalLine(par1, par2, par3, par4);
	}

	@Override
	public void drawVerticalLine(int par1, int par2, int par3, int par4) {
		base.superDrawVerticalLine(par1, par2, par3, par4);
	}

	@Override
	public void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6) {
		base.superDrawGradientRect(par1, par2, par3, par4, par5, par6);
	}

	@Override
	public void drawCenteredString(Object fontRenderer, String par2Str, int par3, int par4, int par5) {
		base.superDrawCenteredString(fontRenderer, par2Str, par3, par4, par5);
	}

	@Override
	public void drawString(Object fontRenderer, String par2Str, int par3, int par4, int par5) {
		base.superDrawString(fontRenderer, par2Str, par3, par4, par5);
	}

	@Override
	public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {
		base.superDrawTexturedModalRect(par1, par2, par3, par4, par5, par6);
	}

	@Override
	public void drawTexturedModelRectFromIcon(int par1, int par2, Object iIcon, int par4, int par5) {
		base.superDrawTexturedModelRectFromIcon(par1, par2, iIcon, par4, par5);
	}
	// ~164
	@Override
	public void drawItemStackTooltip(Object itemStack, int par2, int par3) {
		base.superDrawItemStackTooltip(itemStack, par2, par3);
	}

	@Override
	public void func_102021_a(List par1List, int par2, int par3) {
		base.superFunc_102021_a(par1List, par2, par3);
	}

	@Override
	public void drawSlotInventory(Object slot) {
		base.superDrawSlotInventory(slot);
	}

	@Override
	public boolean isPointInRegion(int par1, int par2, int par3, int par4, int par5, int par6) {
		return base.superIsPointInRegion(par1, par2, par3, par4, par5, par6);
	}

}
