package modchu.lib;

import java.util.List;

public interface Modchu_IGuiContainerMaster {
	public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3);
	public void initGui();
	public void drawScreen(int par1, int par2, float par3);
	public void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_);
	public void mouseClicked(int par1, int par2, int par3);
	public void mouseClickMove(int p_146273_1_, int p_146273_2_, int p_146273_3_, long p_146273_4_);
	public void mouseMovedOrUp(int p_146286_1_, int p_146286_2_, int p_146286_3_);
	public boolean func_146978_c(int p_146978_1_, int p_146978_2_, int p_146978_3_, int p_146978_4_, int p_146978_5_, int p_146978_6_);
	public void handleMouseClick(Object slot, int p_146984_2_, int p_146984_3_, int p_146984_4_);
	public void keyTyped(char par1, int par2);
	public boolean checkHotbarKeys(int p_146983_1_);
	public void onGuiClosed();
	public boolean doesGuiPauseGame();
	public void updateScreen();
	public void renderToolTip(Object itemStack, int p_146285_2_, int p_146285_3_);
	public void drawCreativeTabHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_);
	public void func_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_);
	public void drawHoveringText(List p_146283_1_, int p_146283_2_, int p_146283_3_, Object fontRenderer);
	public void actionPerformed(Object guiButton);
	public void setWorldAndResolution(Object minecraft, int p_146280_2_, int p_146280_3_);
	public void handleInput();
	public void handleMouseInput();
	public void handleKeyboardInput();
	public void drawDefaultBackground();
	public void drawWorldBackground(int p_146270_1_);
	public void drawBackground(int p_146278_1_);
	public void confirmClicked(boolean par1, int par2);
	public void drawHorizontalLine(int par1, int par2, int par3, int par4);
	public void drawVerticalLine(int par1, int par2, int par3, int par4);
	public void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void drawCenteredString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void drawString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void drawTexturedModelRectFromIcon(int par1, int par2, Object iIcon, int par4, int par5);
	// ~164
	public void drawItemStackTooltip(Object itemStack, int par2, int par3);
	public void func_102021_a(List par1List, int par2, int par3);
	public void drawSlotInventory(Object slot);
	public boolean isPointInRegion(int par1, int par2, int par3, int par4, int par5, int par6);

}
