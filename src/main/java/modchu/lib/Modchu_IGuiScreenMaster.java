package modchu.lib;

import java.util.HashMap;
import java.util.List;

public interface Modchu_IGuiScreenMaster {
	public void initGui();
	public void init(HashMap<String, Object> map);
	public void reInit();
	public Object getFontRenderer();
	public void setFontRenderer(Object fontRenderer);
	public void drawString(String s, int i, int j, int k);
	public void updateScreen();
	public void drawScreen(int i, int j, float f);
	public void onGuiClosed();
	public boolean doesGuiPauseGame();
	public void mouseClicked(int x, int y, int i);
	public void actionPerformed(Object guibutton);
	public void handleMouseInput();
	public void keyTyped(char c, int i);
	public void mouseClickMove(int mouseX, int mouseY, int clickButton, long time);
	public void mouseReleased(int mouseX, int mouseY, int clickButton);
	public void mouseMovedOrUp(int mouseX, int mouseY, int clickButton);
	public void setWorldAndResolution(Object minecraft, int par2, int par3);
	public void handleInput();
	public void handleKeyboardInput();
	public void drawDefaultBackground();
	public void drawWorldBackground(int par1);
	public void drawBackground(int par1);
	public void confirmClicked(boolean par1, int par2);
	public void drawHorizontalLine(int par1, int par2, int par3, int par4);
	public void drawVerticalLine(int par1, int par2, int par3, int par4);
	public void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void drawCenteredString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void drawString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void drawTexturedModelRectFromIcon(int par1, int par2, Object icon, int par4, int par5);
	public void renderToolTip(Object itemStack, int p_146285_2_, int p_146285_3_);
	public void drawCreativeTabHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_);
	public void func_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_);
	public void drawHoveringText(List p_146283_1_, int p_146283_2_, int p_146283_3_, Object fontRenderer);
	public void drawHoveringText(List textLines, int x, int y);
	public void handleComponentHover(Object iChatComponent, int p_175272_2_, int p_175272_3_);
	public void setText(String newChatText, boolean shouldOverwrite);
	public boolean handleComponentClick(Object iChatComponent);
	public void sendChatMessage(String msg);
	public void sendChatMessage(String msg, boolean addToChat);
	public void onResize(Object minecraft, int p_175273_2_, int p_175273_3_);
	public void drawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV);
	public void drawTexturedModalRect(int xCoord, int yCoord, Object textureAtlasSprite, int p_175175_4_, int p_175175_5_);

}
