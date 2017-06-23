package modchu.lib;

import java.util.HashMap;
import java.util.List;

public class Modchu_GuiScreenMasterBasis implements Modchu_IGuiScreenMaster {
	public Modchu_IGuiScreen base;

	public Modchu_GuiScreenMasterBasis(HashMap<String, Object> map) {
		base = map.containsKey("base") ? (Modchu_IGuiScreen) map.get("base") : null;
	}

	@Override
	public void drawHorizontalLine(int startX, int endX, int y, int color) {
		base.superDrawHorizontalLine(startX, endX, y, color);
	}

	@Override
	public void drawVerticalLine(int x, int startY, int endY, int color) {
		base.superDrawVerticalLine(x, startY, endY, color);
	}

	@Override
	public void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor) {
		base.superDrawGradientRect(left, top, right, bottom, startColor, endColor);
	}

	@Override
	public void drawCenteredString(Object fontRenderer, String text, int x, int y, int color) {
		base.superDrawCenteredString(fontRenderer, text, x, y, color);
	}

	@Override
	public void drawString(Object fontRenderer, String text, int x, int y, int color) {
		base.superDrawString(fontRenderer, text, x, y, color);
	}

	@Override
	public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
		base.superDrawTexturedModalRect(x, y, textureX, textureY, width, height);
	}

	@Override
	public void initGui() {
	}

	@Override
	public void init(HashMap<String, Object> map) {
	}

	@Override
	public void reInit() {
	}

	@Override
	public Object getFontRenderer() {
		return base.superGetFontRenderer();
	}

	@Override
	public void setFontRenderer(Object fontRenderer) {
		base.superSetFontRenderer(fontRenderer);
	}

	@Override
	public void drawString(String s, int i, int j, int k) {
		base.superDrawString(s, i, j, k);
	}

	@Override
	public void updateScreen() {
		base.superUpdateScreen();
	}

	@Override
	public void drawScreen(int i, int j, float f) {
		base.superDrawScreen(i, j, f);
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
	public void mouseClicked(int x, int y, int i) {
		base.superMouseClicked(x, y, i);
	}

	@Override
	public void actionPerformed(Object guibutton) {
		base.superActionPerformed(guibutton);
	}

	@Override
	public void handleMouseInput() {
		base.superHandleMouseInput();
	}

	@Override
	public void keyTyped(char c, int i) {
		base.superKeyTyped(c, i);
	}

	@Override
	public void mouseClickMove(int mouseX, int mouseY, int clickButton, long time) {
		base.superMouseClickMove(mouseX, mouseY, clickButton, time);
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY, int clickButton) {
		base.superMouseReleased(mouseX, mouseY, clickButton);
	}

	@Override
	public void mouseMovedOrUp(int mouseX, int mouseY, int clickButton) {
		base.superMouseMovedOrUp(mouseX, mouseY, clickButton);
	}

	@Override
	public void setWorldAndResolution(Object minecraft, int par2, int par3) {
		base.superSetWorldAndResolution(minecraft, par2, par3);
	}

	@Override
	public void handleInput() {
		base.superHandleInput();
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
	public void drawWorldBackground(int par1) {
		base.superDrawWorldBackground(par1);
	}

	@Override
	public void drawBackground(int par1) {
		base.superDrawBackground(par1);
	}

	@Override
	public void confirmClicked(boolean par1, int par2) {
		base.superConfirmClicked(par1, par2);
	}

	@Override
	public void drawTexturedModelRectFromIcon(int par1, int par2, Object icon, int par4, int par5) {
		base.superDrawTexturedModelRectFromIcon(par1, par2, icon, par4, par5);
	}

	@Override
	public void renderToolTip(Object itemStack, int p_146285_2_, int p_146285_3_) {
		base.superRenderToolTip(itemStack, p_146285_2_, p_146285_3_);
	}

	@Override
	public void drawHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_) {
		base.superDrawHoveringText(p_146279_1_, p_146279_2_, p_146279_3_);
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
	public void drawHoveringText(List textLines, int x, int y) {
		base.superDrawHoveringText(textLines, x, y);
	}

	@Override
	public void handleComponentHover(Object iChatComponent, int p_175272_2_, int p_175272_3_) {
		base.superHandleComponentHover(iChatComponent, p_175272_2_, p_175272_3_);
	}

	@Override
	public void setText(String newChatText, boolean shouldOverwrite) {
		base.superSetText(newChatText, shouldOverwrite);
	}

	@Override
	public boolean handleComponentClick(Object iChatComponent) {
		return base.superHandleComponentClick(iChatComponent);
	}

	@Override
	public void sendChatMessage(String msg) {
		base.superSendChatMessage(msg);
	}

	@Override
	public void sendChatMessage(String msg, boolean addToChat) {
		base.superSendChatMessage(msg, addToChat);
	}

	@Override
	public void onResize(Object minecraft, int p_175273_2_, int p_175273_3_) {
		base.superOnResize(minecraft, p_175273_2_, p_175273_3_);
	}

	@Override
	public void drawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV) {
		base.superDrawTexturedModalRect(xCoord, yCoord, minU, minV, maxU, maxV);
	}

	@Override
	public void drawTexturedModalRect(int xCoord, int yCoord, Object textureAtlasSprite, int p_175175_4_, int p_175175_5_) {
		base.superDrawTexturedModalRect(xCoord, yCoord, textureAtlasSprite, p_175175_4_, p_175175_5_);
	}

	@Override
	public void setGuiSize(int w, int h) {
		base.superSetGuiSize(w, h);
	}

	@Override
	public Object addButton(Object t) {
		return base.superAddButton(t);
	}

	@Override
	public List getItemToolTip(Object itemStack) {
		return base.superGetItemToolTip(itemStack);
	}

	@Override
	public void setFocused(boolean hasFocusedControlIn) {
		base.superSetFocused(hasFocusedControlIn);
	}

	@Override
	public boolean isFocused() {
		return base.superIsFocused();
	}

}
