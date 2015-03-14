package modchu.lib;

public interface Modchu_IGuiBase {
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

}
