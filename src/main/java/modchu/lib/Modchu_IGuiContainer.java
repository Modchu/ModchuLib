package modchu.lib;

import java.util.List;

public interface Modchu_IGuiContainer {
	public void superDrawGuiContainerBackgroundLayer(float var1, int var2, int var3);
	public void superInitGui();
	public void superDrawScreen(int par1, int par2, float par3);
	public void superDrawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_);
	public void superMouseClicked(int par1, int par2, int par3);
	public void superMouseClickMove(int p_146273_1_, int p_146273_2_, int p_146273_3_, long p_146273_4_);
	public void superMouseMovedOrUp(int p_146286_1_, int p_146286_2_, int p_146286_3_);
	public boolean superFunc_146978_c(int p_146978_1_, int p_146978_2_, int p_146978_3_, int p_146978_4_, int p_146978_5_, int p_146978_6_);
	public void superHandleMouseClick(Object slot, int p_146984_2_, int p_146984_3_, int p_146984_4_);
	public void superKeyTyped(char par1, int par2);
	public boolean superCheckHotbarKeys(int p_146983_1_);
	public void superOnGuiClosed();
	public boolean superDoesGuiPauseGame();
	public void superUpdateScreen();
	public void superRenderToolTip(Object itemStack, int p_146285_2_, int p_146285_3_);
	public void superDrawCreativeTabHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_);
	public void superFunc_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_);
	public void superDrawHoveringText(List p_146283_1_, int p_146283_2_, int p_146283_3_, Object fontRenderer);
	public void superActionPerformed(Object guiButton);
	public void superSetWorldAndResolution(Object minecraft, int p_146280_2_, int p_146280_3_);
	public void superHandleInput();
	public void superHandleMouseInput();
	public void superHandleKeyboardInput();
	public void superDrawDefaultBackground();
	public void superDrawWorldBackground(int p_146270_1_);
	public void superDrawBackground(int p_146278_1_);
	public void superConfirmClicked(boolean par1, int par2);
	public void superDrawHorizontalLine(int par1, int par2, int par3, int par4);
	public void superDrawVerticalLine(int par1, int par2, int par3, int par4);
	public void superDrawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void superDrawCenteredString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void superDrawString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void superDrawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void superDrawTexturedModelRectFromIcon(int par1, int par2, Object iIcon, int par4, int par5);
	// ~164
	public void superDrawItemStackTooltip(Object itemStack, int par2, int par3);
	public void superFunc_102021_a(List par1List, int par2, int par3);
	public void superDrawSlotInventory(Object slot);
	public boolean superIsPointInRegion(int par1, int par2, int par3, int par4, int par5, int par6);

}
