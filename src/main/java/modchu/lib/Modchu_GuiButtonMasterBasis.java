package modchu.lib;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Modchu_GuiButtonMasterBasis implements Modchu_IGuiButtonMaster {
	public Modchu_IGuiButton base;

	public Modchu_GuiButtonMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IGuiButton) map.get("base");
	}

	@Override
	public int getHoverState(boolean par1) {
		return base.superGetHoverState(par1);
	}

	@Override
	public void drawButton(Object minecraft, int par2, int par3) {
		base.superDrawButton(minecraft, par2, par3);
	}

	@Override
	public void mouseDragged(Object minecraft, int par2, int par3) {
		base.superMouseDragged(minecraft, par2, par3);
	}

	@Override
	public void mouseReleased(int par1, int par2) {
		base.superMouseReleased(par1, par2);
	}

	@Override
	public boolean mousePressed(Object minecraft, int par2, int par3) {
		return base.superMousePressed(minecraft, par2, par3);
	}

	@Override
	public boolean isMouseOver() {
		return base.superIsMouseOver();
	}

	@Override
	public void drawButtonForegroundLayer(int par1, int par2) {
		base.superDrawButtonForegroundLayer(par1, par2);
	}

	@Override
	public void drawHorizontalLine(int par1, int par2, int par3, int par4) {
		base.superDrawHorizontalLine(par1, par2, par3, par4);
	}

	@Override
	public void drawVerticalLine(int par1, int par2, int par3, int par4) {
		base.superDrawVerticalLine(par1, par2, par3, par4);
	}

	@Override
	public void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6) {
		base.superDrawGradientRect(par1, par2, par3, par4, par5, par6);
	}

	@Override
	public void drawCenteredString(Object fontRenderer, String par2Str, int par3, int par4, int par5) {
		base.superDrawCenteredString(fontRenderer, par2Str, par3, par4, par5);
	}

	@Override
	public void drawString(Object fontRenderer, String par2Str, int par3, int par4, int par5) {
		base.superDrawString(fontRenderer, par2Str, par3, par4, par5);
	}

	@Override
	public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {
		base.superDrawTexturedModalRect(par1, par2, par3, par4, par5, par6);
	}

	@Override
	public void drawTexturedModelRectFromIcon(int par1, int par2, Object icon, int par4, int par5) {
		base.superDrawTexturedModelRectFromIcon(par1, par2, icon, par4, par5);
	}

	@Override
	public void drawButton(Object par1Minecraft, int par2, int par3, float f) {
		base.superDrawButton(par1Minecraft, par2, par3, f);
	}

}