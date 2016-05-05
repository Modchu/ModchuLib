package modchu.lib.modloader.mc162;import java.util.HashMap;import modchu.lib.Modchu_IGuiModelView;
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
	}	public void selected(String textureName, String textureArmorName, int color, boolean armorMode) {
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