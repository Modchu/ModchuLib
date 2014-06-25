package modchu.lib;

import modchu.lib.characteristic.recompileonly.Modchu_GuiBase;


public interface Modchu_IGuiBaseMaster {

	public void initGui();
	public void init(Modchu_GuiBase guiBase, Object par1GuiScreen, Object world, Object... o);
	public void reInit();
	public Object getFontRenderer();
	public void setFontRenderer(Object fontRenderer);
	public void drawString(String s, int i, int j, int k);
	public void updateScreen();
	public boolean drawScreen(int i, int j, float f);
	public void onGuiClosed();
	public boolean doesGuiPauseGame();
	public boolean mouseClicked(int x, int y, int i);
	public void actionPerformed(Object guibutton);
	public boolean handleMouseInput();
	public boolean keyTyped(char c, int i);
	public void mouseClickMove(int mouseX, int mouseY, int clickButton, long time);
	public void mouseMovedOrUp(int mouseX, int mouseY, int clickButton);

}
