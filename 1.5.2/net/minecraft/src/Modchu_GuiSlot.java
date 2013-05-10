package net.minecraft.src;

import java.util.List;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

public class Modchu_GuiSlot extends GuiSlot {

	private float initialClickY = -2.0F;
	private float amountScrolled;
	private float scrollMultiplier;
	private int width;
	private int height;
	private int selectedElement = -1;
	private int right;
	private int left;
	private int field_77242_t;
	private long lastClicked = 0L;
	private boolean showSelectionBox = true;
	private boolean field_77243_s;

	protected Minecraft mc;
	public PFLM_GuiSlotBase parentScreen;
	public List parentScreenList;
	public int guiNumber = 0;
	private int selected;
	private World popWorld;
	private int showSelectionBoxWidth;
	private int slotPosX;
	private int slotPosY;
	private int scrollUpButtonID;
	private int scrollDownButtonID;
	private int scrollBarInBoxY;
	private boolean mouseClick;

	public Modchu_GuiSlot(Minecraft par1Minecraft, int par2, int par3, int par4, int par5, int par6) {
		//この初期化は未使用
		super(par1Minecraft, par2, par3, par4, par5, par6);
		width = par2;
		height = par3;
		parentScreen = null;
		parentScreenList = null;
		selected = 0;
		mc = par1Minecraft;
		popWorld = mc.theWorld;
	}

	public Modchu_GuiSlot(Minecraft par1Minecraft, PFLM_GuiSlotBase gui, int par3, int par4, int par5, int par6, int par7, int par8, int par9) {
		super(par1Minecraft, gui.width, gui.height, par4, par5, par6);
		width = gui.width;
		height = gui.height;
		showSelectionBoxWidth = par3;
		slotPosX = par7;
		slotPosY = par8;
		guiNumber = par9;
		parentScreen = gui;
		selected = 0;
		mc = par1Minecraft;
		popWorld = mc.theWorld;
	}

	@Override
	protected int getSize() {
		return parentScreen.getGuiSlotSize(guiNumber);
	}

	@Override
	protected int getContentHeight() {
		return parentScreen.getGuiSlotContentHeight(guiNumber);
	}

	@Override
	protected void elementClicked(int i, boolean flag) {
		parentScreen.guiSlotElementClicked(guiNumber, i, flag);
	}

	@Override
	protected boolean isSelected(int i) {
		return parentScreen.guiSlotIsSelected(guiNumber, i);
	}

	@Override
	protected void drawBackground() {
	}

	@Override
	public void drawScreen(int mouse_x, int mouse_y, float par3)
	{
		mouseX = mouse_x;
		mouseY = mouse_y;
		//drawBackground();
		int slotSize = getSize();
		int scrollBarX = getScrollBarX();
		int scrollBarSizeX = getScrollBarSizeX();
		int showSelectionBoxLeft = slotPosX;
		int showSelectionBoxRight = slotPosX + showSelectionBoxWidth;
		int sizeY = bottom - (slotPosY > -1 ? slotPosY : -slotPosY);
		int selected;
		int showSelectionBoxSizeY = slotHeight - 4;
		int showSelectionBoxPosTop;
		int scrollBarDisplaySizeY = height - (top + bottom - height);
		//Modchu_Debug.mDebug("scrollBarDisplaySizeY="+scrollBarDisplaySizeY);
		if (scrollBarDisplaySizeY < 1) scrollBarDisplaySizeY = 1;
		int scrollBarSizeY = getContentHeight();
		//Modchu_Debug.mDebug("scrollBarSizeY="+scrollBarSizeY);

		int selectedDisplayCount = scrollBarDisplaySizeY / slotHeight - 2;
		int scrollBarInBoxSizeY = 0;
		boolean isScrollBar = scrollBarDisplaySizeY < scrollBarSizeY;
		if (isScrollBar) {
			float f = (float) slotSize / (float) selectedDisplayCount;
			//Modchu_Debug.mDebug("slotSize="+slotSize+" selectedDisplayCount="+selectedDisplayCount+" f="+f);
			scrollBarInBoxSizeY = (int) (scrollBarDisplaySizeY / f);
		}
		if (Mouse.isButtonDown(0)) {
			//if (initialClickY == -1.0F) {
				boolean var7 = true;

				if (mouse_y >= slotPosY && mouse_y <= slotPosY + sizeY + slotHeight) {
					int clickY = mouse_y + ((int)amountScrolled * slotHeight);
					if (amountScrolled == 0.0F) clickY -= slotHeight;
					selected = (clickY - slotPosY + (showSelectionBoxSizeY)) / slotHeight;
					//Modchu_Debug.mDebug("selected="+selected);
					//Modchu_Debug.mDebug("showSelectionBoxSizeY="+showSelectionBoxSizeY);
					//Modchu_Debug.mDebug("amountScrolled="+amountScrolled);
					//Modchu_Debug.mDebug("clickY="+clickY+" mouse_y="+mouse_y);

					if (mouse_x >= showSelectionBoxLeft && mouse_x <= showSelectionBoxRight && selected >= 0 && clickY >= 0 && selected < slotSize) {
						boolean var12 = selected == selectedElement && Minecraft.getSystemTime() - lastClicked < 250L;
						elementClicked(selected, var12);
						selectedElement = selected;
						lastClicked = Minecraft.getSystemTime();
					} else if (mouse_x >= showSelectionBoxLeft && mouse_x <= showSelectionBoxRight && clickY < 0) {
						func_77224_a(mouse_x - showSelectionBoxLeft, mouse_y + (int)amountScrolled - 4 - slotPosY);
						var7 = false;
					}
				} else {
					//initialClickY = -2.0F;
				}

				//Modchu_Debug.mDebug("mouse_x="+mouse_x+" scrollBarX="+scrollBarX);
				if (isScrollBar
						&& mouse_x >= scrollBarX && mouse_x <= scrollBarX + scrollBarSizeX
						&& mouse_y >= top && mouse_y <= bottom) {
					if (mouse_y < scrollBarInBoxY) {
						scrollMultiplier = -scrollBarSizeX;
					} else {
						if (!mouseClick
								| (mouseClick
								&& mouse_y > scrollBarInBoxY + scrollBarInBoxSizeY)) scrollMultiplier = scrollBarSizeX;
					}
					//initialClickY = (float)mouse_y;
					amountScrolled += scrollMultiplier;
					scrollMultiplier = 0.0F;
					//Modchu_Debug.mDebug("scrollBar click scrollMultiplier="+scrollMultiplier+" initialClickY="+initialClickY);
				} else {
					//scrollMultiplier = 1.0F;
				}

				if (var7) {
				} else {
					//initialClickY = -2.0F;
				}
			//}// else if (initialClickY >= 0.0F) {
				//Modchu_Debug.mDebug("amountScrolled="+amountScrolled);
			//}
			mouseClick = true;
		} else {
			if (isScrollBar
					&& (mouse_x >= scrollBarX && mouse_x <= scrollBarX + scrollBarSizeX
					| mouse_x >= showSelectionBoxLeft && mouse_x <= showSelectionBoxRight)
					&& mouse_y >= top && mouse_y <= bottom) {
				while (!mc.gameSettings.touchscreen && Mouse.next()) {
					int var16 = Mouse.getEventDWheel();
					if (var16 != 0) {
						if (var16 > 0) {
							var16 = -1;
						} else if (var16 < 0) {
							var16 = 1;
						}
						amountScrolled += (float)(var16 * (height / 50 < 2 ? 1 : height / 50));
						//Modchu_Debug.mDebug("touchscreen && Mouse.next() amountScrolled="+amountScrolled);
					}
				}
			}
			//initialClickY = -1.0F;
			mouseClick = false;
		}

		bindAmountScrolled();
		if (amountScrolled < 0.0F) amountScrolled = 0.0F;
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_FOG);
		Tessellator tessellator = Tessellator.instance;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*
		if (field_77243_s)
		{
			func_77222_a(showSelectionBoxRight, slotPosY, tessellator);
		}
*/
		int startSelected = (int) amountScrolled > 0 ? (int) amountScrolled : 0;
		if (slotSize - startSelected < selectedDisplayCount) {
			//Modchu_Debug.mDebug("スクロール位置調整");
			startSelected = slotSize - selectedDisplayCount;
			if (startSelected < -1) startSelected = 0;
			amountScrolled = (float) startSelected;
		}
		if (startSelected < 0) startSelected = 0;
		//Modchu_Debug.mDebug("スクロール位置="+(slotSize - startSelected));
		//Modchu_Debug.mDebug("表示数="+selectedDisplayCount);
		//Modchu_Debug.mDebug("startSelected="+startSelected);
		//Modchu_Debug.mDebug("guiNumber"+guiNumber+" startSelected="+startSelected);
		for (selected = startSelected; selected < slotSize; ++selected) {
			//Modchu_Debug.mDebug("guiNumber"+guiNumber+" slotPosY="+slotPosY);

			showSelectionBoxPosTop = slotPosY + (selected * slotHeight) - ((int) amountScrolled * slotHeight) - ((int) amountScrolled > 0 ? slotHeight : 0);
			showSelectionBoxSizeY = slotHeight - 4;
			//Modchu_Debug.mDebug("guiNumber"+guiNumber+" showSelectionBoxPosTop="+showSelectionBoxPosTop);
			//Modchu_Debug.mDebug("guiNumber"+guiNumber+" slotPosY="+slotPosY);
			//Modchu_Debug.mDebug("guiNumber"+guiNumber+" slotHeight="+slotHeight);
			//Modchu_Debug.mDebug("guiNumber"+guiNumber+" amountScrolled="+amountScrolled);

			if (showSelectionBoxPosTop <= slotPosY + sizeY && showSelectionBoxPosTop + showSelectionBoxSizeY >= slotPosY)
			{
				if (showSelectionBox && isSelected(selected))
				{
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glDisable(GL11.GL_TEXTURE_2D);
					tessellator.startDrawingQuads();
					tessellator.setColorOpaque_I(8421504);
					tessellator.addVertexWithUV((double)showSelectionBoxLeft, (double)(showSelectionBoxPosTop + showSelectionBoxSizeY + 2), 0.0D, 0.0D, 1.0D);
					tessellator.addVertexWithUV((double)showSelectionBoxRight, (double)(showSelectionBoxPosTop + showSelectionBoxSizeY + 2), 0.0D, 1.0D, 1.0D);
					tessellator.addVertexWithUV((double)showSelectionBoxRight, (double)(showSelectionBoxPosTop - 2), 0.0D, 1.0D, 0.0D);
					tessellator.addVertexWithUV((double)showSelectionBoxLeft, (double)(showSelectionBoxPosTop - 2), 0.0D, 0.0D, 0.0D);
					tessellator.setColorOpaque_I(0);
					tessellator.addVertexWithUV((double)(showSelectionBoxLeft + 1), (double)(showSelectionBoxPosTop + showSelectionBoxSizeY + 1), 0.0D, 0.0D, 1.0D);
					tessellator.addVertexWithUV((double)(showSelectionBoxRight - 1), (double)(showSelectionBoxPosTop + showSelectionBoxSizeY + 1), 0.0D, 1.0D, 1.0D);
					tessellator.addVertexWithUV((double)(showSelectionBoxRight - 1), (double)(showSelectionBoxPosTop - 1), 0.0D, 1.0D, 0.0D);
					tessellator.addVertexWithUV((double)(showSelectionBoxLeft + 1), (double)(showSelectionBoxPosTop - 1), 0.0D, 0.0D, 0.0D);
					tessellator.draw();
					GL11.glEnable(GL11.GL_TEXTURE_2D);
				}

				drawSlot(selected, showSelectionBoxLeft, showSelectionBoxRight, showSelectionBoxPosTop, showSelectionBoxSizeY, tessellator);
			}
		}

		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		//int var19 = func_77209_d();
		//Modchu_Debug.mDebug("var19="+var19);
		//if (var19 < 1) var19 = 1;
		if (isScrollBar) {
			if (scrollBarInBoxSizeY < 32) scrollBarInBoxSizeY = 32;
			if (scrollBarInBoxSizeY > scrollBarDisplaySizeY) scrollBarInBoxSizeY = scrollBarDisplaySizeY;
			//Modchu_Debug.mDebug("scrollBarDisplaySizeY="+scrollBarDisplaySizeY+" scrollBarInBoxSizeY="+scrollBarInBoxSizeY+" f="+f);

			float f1 = (float) (amountScrolled > 0 ? (slotSize - selectedDisplayCount) / amountScrolled : 0);
			if (f1 < 0.0F) f1 = 0.0F;
			//Modchu_Debug.mDebug("f1="+f1);
			//int scrollBarInBoxY = top + (int) (scrollBarDisplaySizeY / f1) - (height - bottom);
			scrollBarInBoxY = top + (int) ((scrollBarDisplaySizeY - scrollBarInBoxSizeY) / f1);
			if (scrollBarInBoxY < top) scrollBarInBoxY = top;
			if (scrollBarInBoxY + scrollBarInBoxSizeY > bottom) scrollBarInBoxY = bottom - scrollBarInBoxSizeY;
			//Modchu_Debug.mDebug("scrollBarInBoxY="+scrollBarInBoxY);
			//Modchu_Debug.mDebug("amountScrolled="+amountScrolled);

			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_I(0, 255);
			tessellator.addVertexWithUV((double)scrollBarX, (double)bottom, 0.0D, 0.0D, 1.0D);
			tessellator.addVertexWithUV((double)scrollBarX + scrollBarSizeX, (double)bottom, 0.0D, 1.0D, 1.0D);
			tessellator.addVertexWithUV((double)scrollBarX + scrollBarSizeX, (double)top, 0.0D, 1.0D, 0.0D);
			tessellator.addVertexWithUV((double)scrollBarX, (double)top, 0.0D, 0.0D, 0.0D);
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_I(8421504, 255);
			tessellator.addVertexWithUV((double)scrollBarX, (double)(scrollBarInBoxY + scrollBarInBoxSizeY), 0.0D, 0.0D, 1.0D);
			tessellator.addVertexWithUV((double)scrollBarX + scrollBarSizeX, (double)(scrollBarInBoxY + scrollBarInBoxSizeY), 0.0D, 1.0D, 1.0D);
			tessellator.addVertexWithUV((double)scrollBarX + scrollBarSizeX, (double)scrollBarInBoxY, 0.0D, 1.0D, 0.0D);
			tessellator.addVertexWithUV((double)scrollBarX, (double)scrollBarInBoxY, 0.0D, 0.0D, 0.0D);
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_I(12632256, 255);
			tessellator.addVertexWithUV((double)scrollBarX, (double)(scrollBarInBoxY + scrollBarInBoxSizeY - 1), 0.0D, 0.0D, 1.0D);
			tessellator.addVertexWithUV((double)(scrollBarSizeX - 1), (double)(scrollBarInBoxY + scrollBarInBoxSizeY - 1), 0.0D, 1.0D, 1.0D);
			tessellator.addVertexWithUV((double)(scrollBarSizeX - 1), (double)scrollBarInBoxY, 0.0D, 1.0D, 0.0D);
			tessellator.addVertexWithUV((double)scrollBarX, (double)scrollBarInBoxY, 0.0D, 0.0D, 0.0D);
			tessellator.draw();
		}
		func_77215_b(mouse_x, mouse_y);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);
	}

	@Override
	protected void drawSlot(int i, int j, int k, int l, Tessellator tessellator) {
	}

	protected void drawSlot(int i, int posX, int slotPosY, int k, int l, Tessellator tessellator) {
		parentScreen.guiSlotDrawSlot(guiNumber, i, posX, slotPosY, k, l, tessellator);
	}

	@Override
	protected int getScrollBarX() {
		return parentScreen.getSlotScrollBarX(guiNumber);
	}

	protected int getScrollBarSizeX() {
		return parentScreen.getSlotScrollBarSizeX(guiNumber);
	}

	private void bindAmountScrolled() {
		int var1 = func_77209_d();
		//if (amountScrolled < 0.0F) amountScrolled = 0.0F;
		if (amountScrolled > (float)var1) amountScrolled = (float)var1;
	}

	public int func_77209_d() {
		//最大スクロール位置
		return getSize() - ((height - (top + bottom - height)) / slotHeight - 2);
	}

	@Override
	public void registerScrollButtons(List par1List, int par2, int par3) {
		scrollUpButtonID = par2;
		scrollDownButtonID = par3;
	}

	public void actionPerformed(int i) {
/*
		if (i == scrollUpButtonID) {
			amountScrolled -= (float)(slotHeight * 2 / 3);
			//initialClickY = -2.0F;
			bindAmountScrolled();
		} else if (i == scrollDownButtonID) {
			amountScrolled += (float)(slotHeight * 2 / 3);
			//initialClickY = -2.0F;
			bindAmountScrolled();
		}
*/
	}

	private void overlayBackground(int par1, int par2, int par3, int par4) {
		Tessellator var5 = Tessellator.instance;
		mc.renderEngine.bindTexture("/gui/background.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		float var6 = 32.0F;
		var5.startDrawingQuads();
		var5.setColorRGBA_I(4210752, par4);
		var5.addVertexWithUV(0.0D, (double)par2, 0.0D, 0.0D, (double)((float)par2 / var6));
		var5.addVertexWithUV((double)width, (double)par2, 0.0D, (double)((float)width / var6), (double)((float)par2 / var6));
		var5.setColorRGBA_I(4210752, par3);
		var5.addVertexWithUV((double)width, (double)par1, 0.0D, (double)((float)width / var6), (double)((float)par1 / var6));
		var5.addVertexWithUV(0.0D, (double)par1, 0.0D, 0.0D, (double)((float)par1 / var6));
		var5.draw();
	}
}
