package modchu.lib;

public interface Modchu_IGui {
	public void superDrawHorizontalLine(int startX, int endX, int y, int color);
	public void superDrawVerticalLine(int x, int startY, int endY, int color);
	public void superDrawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor);
	public void superDrawCenteredString(Object fontRenderer, String text, int x, int y, int color);
	public void superDrawString(Object fontRenderer, String text, int x, int y, int color);
	public void superDrawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height);
	public void superDrawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV);
	public void superDrawTexturedModalRect(int xCoord, int yCoord, Object textureAtlasSprite, int p_175175_4_, int p_175175_5_);

}
