package modchu.lib.forge.mc152;import java.util.HashMap;import modchu.lib.Modchu_IGuiModelView;
import modchu.lib.Modchu_IGuiModelViewMaster;public class Modchu_GuiModelView extends Modchu_GuiScreen implements Modchu_IGuiModelView {	public Modchu_GuiModelView(HashMap<String, Object> map) {
		super(map);
	}	public void reInit() {
		((Modchu_IGuiModelViewMaster) master).reInit();
	}	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		if (master instanceof Modchu_IGuiModelViewMaster) ;else return;
		((Modchu_IGuiModelViewMaster) master).drawGuiContainerBackgroundLayer(f, i, j);
	}	public void drawString(String s, int i, int j, int k) {
		if (master instanceof Modchu_IGuiModelViewMaster) ;else return;
		((Modchu_IGuiModelViewMaster) master).drawString(s, i, j, k);
	}	public void setTextureArmorPackege() {
		if (master instanceof Modchu_IGuiModelViewMaster) ;else return;
		((Modchu_IGuiModelViewMaster) master).setTextureArmorPackege();
	}	public void setTextureArmorPackege(int i) {
		if (master instanceof Modchu_IGuiModelViewMaster) ;else return;
		((Modchu_IGuiModelViewMaster) master).setTextureArmorPackege(i);
	}	public void setTextureValue() {
		if (master instanceof Modchu_IGuiModelViewMaster) ;else return;
		((Modchu_IGuiModelViewMaster) master).setTextureValue();
	}	public void setArmorTextureValue() {
		if (master instanceof Modchu_IGuiModelViewMaster) ;else return;
		((Modchu_IGuiModelViewMaster) master).setArmorTextureValue();
	}/*	public void drawMobModel(int i, int j, int x, int y, int x2, int y2, float f, float f1, boolean move) {
		if (master instanceof Modchu_IGuiModelViewMaster) ;else return;
		((Modchu_IGuiModelViewMaster) master).drawMobModel(i, j, x, y, x2, y2, f, f1, move);
	}	public void drawMobModel(int i, int j, int x, int y, int x2, int y2, float f, float f1, boolean move, Object entity) {
		if (master instanceof Modchu_IGuiModelViewMaster) ;else return;
		((Modchu_IGuiModelViewMaster) master).drawMobModel(i, j, x, y, x2, y2, f, f1, move, entity);
	}	public void drawMobModel(int i, int j, int x, int y, int x2, int y2, float f, float f1, float f2, float f3, float f4, float f5, boolean move) {
		if (master instanceof Modchu_IGuiModelViewMaster) ;else return;
		((Modchu_IGuiModelViewMaster) master).drawMobModel(i, j, x, y, x2, y2, f, f1, f2, f3, f4, f5, move);
	}	public void drawMobModel(int i, int j, int x, int y, int x2, int y2, float f, float f1, float f2, float f3, float f4, float f5, boolean move, Object entity) {
		((Modchu_IGuiModelViewMaster) master).drawMobModel(i, j, x, y, x2, y2, f, f1, f2, f3, f4, f5, move, entity);
	}*/	public void selected(String textureName, String textureArmorName, int color, boolean armorMode) {
		if (master instanceof Modchu_IGuiModelViewMaster) ;else return;
		((Modchu_IGuiModelViewMaster) master).selected(textureName, textureArmorName, color, armorMode);
	}	public int colorCheck(String textureName, int i, boolean colorReverse) {
		if (master instanceof Modchu_IGuiModelViewMaster) ;else return -1;
		return ((Modchu_IGuiModelViewMaster) master).colorCheck(textureName, i, colorReverse);
	}	public String getTextureName() {
		return ((Modchu_IGuiModelViewMaster) master).getTextureName();
	}	public void setTextureName(String s) {
		((Modchu_IGuiModelViewMaster) master).setTextureName(s);
	}	public String getTextureArmorName() {
		return ((Modchu_IGuiModelViewMaster) master).getTextureArmorName();
	}	public void setTextureArmorName(String s) {
		((Modchu_IGuiModelViewMaster) master).setTextureArmorName(s);
	}	public int getColor() {
		return ((Modchu_IGuiModelViewMaster) master).getColor();
	}	public void setColor(int i) {
		((Modchu_IGuiModelViewMaster) master).setColor(i);
	}	public float getScale() {
		return ((Modchu_IGuiModelViewMaster) master).getScale();
	}	public void setScale(float f) {
		((Modchu_IGuiModelViewMaster) master).setScale(f);
	}	public void modelChange() {
		((Modchu_IGuiModelViewMaster) master).modelChange();
	}	@Override
	public void updateScreen() {
		((Modchu_IGuiModelViewMaster) master).updateScreen();
	}	@Override
	public void onGuiClosed() {
		((Modchu_IGuiModelViewMaster) master).onGuiClosed();
	}	public int getHandednessMode() {
		return ((Modchu_IGuiModelViewMaster) master).getHandednessMode();
	}	public void setHandednessMode(int i) {
		((Modchu_IGuiModelViewMaster) master).setHandednessMode(i);
	}	public void setChangeMode(int i) {
		((Modchu_IGuiModelViewMaster) master).setChangeMode(i);
	}	public void superMouseReleased(int mouseX, int mouseY, int clickButton) {
		superMouseMovedOrUp(mouseX, mouseY, clickButton);
	}}