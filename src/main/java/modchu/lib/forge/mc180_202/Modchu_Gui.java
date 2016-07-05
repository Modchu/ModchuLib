package modchu.lib.forge.mc180_202;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IGui;
import modchu.lib.Modchu_IGuiMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class Modchu_Gui extends Gui implements Modchu_IGui {
	public Modchu_IGuiMaster master;

	public Modchu_Gui(HashMap<String, Object> map) {
		super();
		Modchu_Debug.lDebug("Modchu_Gui init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.lDebug("Modchu_Gui instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IGuiMaster ? (Modchu_IGuiMaster) instance : null;
	}

	@Override
	protected void drawHorizontalLine(int startX, int endX, int y, int color) {
		if (master != null) master.drawHorizontalLine(startX, endX, y, color);
		else super.drawHorizontalLine(startX, endX, y, color);
	}

	public void superDrawHorizontalLine(int startX, int endX, int y, int color) {
		super.drawHorizontalLine(startX, endX, y, color);
	}

	@Override
	protected void drawVerticalLine(int x, int startY, int endY, int color) {
		if (master != null) master.drawVerticalLine(x, startY, endY, color);
		else super.drawVerticalLine(x, startY, endY, color);
	}

	public void superDrawVerticalLine(int x, int startY, int endY, int color) {
		super.drawVerticalLine(x, startY, endY, color);
	}

	@Override
	protected void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor) {
		if (master != null) master.drawGradientRect(left, top, right, bottom, startColor, endColor);
		else super.drawGradientRect(left, top, right, bottom, startColor, endColor);
	}

	public void superDrawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor) {
		super.drawGradientRect(left, top, right, bottom, startColor, endColor);
	}

	@Override
	public void drawCenteredString(FontRenderer fontRenderer, String text, int x, int y, int color) {
		if (master != null) master.drawCenteredString(fontRenderer, text, x, y, color);
		else super.drawCenteredString(fontRenderer, text, x, y, color);
	}

	public void superDrawCenteredString(Object fontRenderer, String text, int x, int y, int color) {
		super.drawCenteredString((FontRenderer) fontRenderer, text, x, y, color);
	}

	@Override
	public void drawString(FontRenderer fontRenderer, String text, int x, int y, int color) {
		if (master != null) master.drawString(fontRenderer, text, x, y, color);
		else super.drawString(fontRenderer, text, x, y, color);
	}

	public void superDrawString(Object fontRenderer, String text, int x, int y, int color) {
		super.drawString((FontRenderer) fontRenderer, text, x, y, color);
	}

	@Override
	public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
		if (master != null) master.drawTexturedModalRect(x, y, textureX, textureY, width, height);
		else super.drawTexturedModalRect(x, y, textureX, textureY, width, height);
	}

	public void superDrawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
		super.drawTexturedModalRect(x, y, textureX, textureY, width, height);
	}

	@Override
	public void drawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV) {
		if (master != null) master.drawTexturedModalRect(xCoord, yCoord, minU, minV, maxU, maxV);
		else super.drawTexturedModalRect(xCoord, yCoord, minU, minV, maxU, maxV);
	}

	public void superDrawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV) {
		super.drawTexturedModalRect(xCoord, yCoord, minU, minV, maxU, maxV);
	}

	@Override
	public void drawTexturedModalRect(int xCoord, int yCoord, TextureAtlasSprite textureAtlasSprite, int p_175175_4_, int p_175175_5_) {
		if (master != null) master.drawTexturedModalRect(xCoord, yCoord, textureAtlasSprite, p_175175_4_, p_175175_5_);
		else super.drawTexturedModalRect(xCoord, yCoord, textureAtlasSprite, p_175175_4_, p_175175_5_);
	}

	public void superDrawTexturedModalRect(int xCoord, int yCoord, Object textureAtlasSprite, int p_175175_4_, int p_175175_5_) {
		super.drawTexturedModalRect(xCoord, yCoord, (TextureAtlasSprite) textureAtlasSprite, p_175175_4_, p_175175_5_);
	}

}
