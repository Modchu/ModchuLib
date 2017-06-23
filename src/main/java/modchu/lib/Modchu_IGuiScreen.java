package modchu.lib;

import java.util.List;

public interface Modchu_IGuiScreen {

	public void initGui();
	public Object getFontRenderer();
	public void setFontRenderer(Object fontRenderer);
	public void superDrawScreen(int i, int j, float f);
	public void superOnGuiClosed();
	public void superHandleMouseInput();
	public void superKeyTyped(char c, int i);
	public void superMouseClicked(int x, int y, int i);
	public void superMouseClickMove(int mouseX, int mouseY, int clickButton, long time);
	public void superMouseReleased(int mouseX, int mouseY, int clickButton);
	public boolean superDoesGuiPauseGame();
	public void superDrawDefaultBackground();
	public void superMouseMovedOrUp(int mouseX, int mouseY, int clickButton);
	public void superSetWorldAndResolution(Object minecraft, int par2, int par3);
	public void superHandleInput();
	public void superHandleKeyboardInput();
	public void superDrawWorldBackground(int par1);
	public void superDrawBackground(int par1);
	public void superConfirmClicked(boolean par1, int par2);
	public void superDrawHorizontalLine(int par1, int par2, int par3, int par4);
	public void superDrawVerticalLine(int par1, int par2, int par3, int par4);
	public void superDrawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void superDrawCenteredString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void superDrawString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void superDrawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void superDrawTexturedModelRectFromIcon(int par1, int par2, Object icon, int par4, int par5);
	public Object superGetFontRenderer();
	public void superSetFontRenderer(Object fontRenderer);
	public void superDrawString(String s, int i, int j, int k);
	public void superUpdateScreen();
	public void superActionPerformed(Object guibutton);
	public void superRenderToolTip(Object itemStack, int p_146285_2_, int p_146285_3_);
	public void superDrawHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_);
	public void superFunc_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_);
	public void superDrawHoveringText(List p_146283_1_, int p_146283_2_, int p_146283_3_, Object fontRenderer);
	public void superDrawHoveringText(List textLines, int x, int y);
	public void superHandleComponentHover(Object iChatComponent, int p_175272_2_, int p_175272_3_);
	public void superSetText(String newChatText, boolean shouldOverwrite);
	public boolean superHandleComponentClick(Object iChatComponent);
	public void superSendChatMessage(String msg);
	public void superSendChatMessage(String msg, boolean addToChat);
	public void superOnResize(Object minecraft, int p_175273_2_, int p_175273_3_);
	public void superDrawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV);
	public void superDrawTexturedModalRect(int xCoord, int yCoord, Object textureAtlasSprite, int p_175175_4_, int p_175175_5_);
	public void superSetGuiSize(int w, int h);
	public Object superAddButton(Object buttonIn);
	public List<String> superGetItemToolTip(Object itemStack);
	public void superSetFocused(boolean hasFocusedControlIn);
	public boolean superIsFocused();

}
