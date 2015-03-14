package modchu.lib;

import java.util.HashMap;

public class Modchu_GuiMasterBasis implements Modchu_IGuiMaster {
	public Modchu_IGui base;

	public Modchu_GuiMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IGui) map.get("base");
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
	public void drawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV) {
		base.superDrawTexturedModalRect(xCoord, yCoord, minU, minV, maxU, maxV);
	}

	@Override
	public void drawTexturedModalRect(int xCoord, int yCoord, Object textureAtlasSprite, int p_175175_4_, int p_175175_5_) {
		base.superDrawTexturedModalRect(xCoord, yCoord, textureAtlasSprite, p_175175_4_, p_175175_5_);
	}

}
