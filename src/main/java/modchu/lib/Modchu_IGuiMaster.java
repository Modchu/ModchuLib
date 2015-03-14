package modchu.lib;

public interface Modchu_IGuiMaster {
	public void drawHorizontalLine(int startX, int endX, int y, int color);
	public void drawVerticalLine(int x, int startY, int endY, int color);
	public void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor);
	public void drawCenteredString(Object fontRenderer, String text, int x, int y, int color);
	public void drawString(Object fontRenderer, String text, int x, int y, int color);
	public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height);
	public void drawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV);
	public void drawTexturedModalRect(int xCoord, int yCoord, Object textureAtlasSprite, int p_175175_4_, int p_175175_5_);

}
