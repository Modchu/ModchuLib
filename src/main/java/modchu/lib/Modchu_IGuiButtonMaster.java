package modchu.lib;

public interface Modchu_IGuiButtonMaster {
	public int getHoverState(boolean par1);
	public void drawButton(Object minecraft, int par2, int par3);
	public void drawButton(Object par1Minecraft, int par2, int par3, float f);
	public void mouseDragged(Object minecraft, int par2, int par3);
	public void mouseReleased(int par1, int par2);
	public boolean mousePressed(Object minecraft, int par2, int par3);
	public boolean isMouseOver();
	public void drawButtonForegroundLayer(int par1, int par2);
	public void drawHorizontalLine(int par1, int par2, int par3, int par4);
	public void drawVerticalLine(int par1, int par2, int par3, int par4);
	public void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void drawCenteredString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void drawString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void drawTexturedModelRectFromIcon(int par1, int par2, Object icon, int par4, int par5);

}
