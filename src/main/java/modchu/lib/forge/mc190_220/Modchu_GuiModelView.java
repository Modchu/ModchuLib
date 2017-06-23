package modchu.lib.forge.mc190_220;import java.util.HashMap;import modchu.lib.Modchu_IGuiModelView;import modchu.lib.Modchu_IGuiModelViewMaster;public abstract class Modchu_GuiModelView extends Modchu_GuiScreen implements Modchu_IGuiModelView {	public Modchu_GuiModelView(HashMap<String, Object> map) {
		super(map);
	}	@Override	public void reInit() {
		((Modchu_IGuiModelViewMaster) master).reInit();
	}	@Override	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		if (master instanceof Modchu_IGuiModelViewMaster); else return;
		((Modchu_IGuiModelViewMaster) master).drawGuiContainerBackgroundLayer(f, i, j);
	}	@Override	public void drawString(String s, int i, int j, int k) {
		if (master instanceof Modchu_IGuiModelViewMaster); else return;
		((Modchu_IGuiModelViewMaster) master).drawString(s, i, j, k);
	}	@Override	public void setTextureArmorPackege() {
		if (master instanceof Modchu_IGuiModelViewMaster); else return;
		((Modchu_IGuiModelViewMaster) master).setTextureArmorPackege();
	}	@Override	public void setTextureArmorPackege(int i) {
		if (master instanceof Modchu_IGuiModelViewMaster); else return;
		((Modchu_IGuiModelViewMaster) master).setTextureArmorPackege(i);
	}	@Override	public void setTextureValue() {
		if (master instanceof Modchu_IGuiModelViewMaster); else return;
		((Modchu_IGuiModelViewMaster) master).setTextureValue();
	}	@Override	public void setArmorTextureValue() {
		if (master instanceof Modchu_IGuiModelViewMaster); else return;
		((Modchu_IGuiModelViewMaster) master).setArmorTextureValue();
	}	@Override	public void selected(String textureName, String textureArmorName, int color, boolean armorMode) {
		if (master instanceof Modchu_IGuiModelViewMaster); else return;
		((Modchu_IGuiModelViewMaster) master).selected(textureName, textureArmorName, color, armorMode);
	}	@Override	public int colorCheck(String textureName, int i, boolean colorReverse) {
		if (master instanceof Modchu_IGuiModelViewMaster); else return -1;
		return ((Modchu_IGuiModelViewMaster) master).colorCheck(textureName, i, colorReverse);
	}	@Override	public String getTextureName() {
		return ((Modchu_IGuiModelViewMaster) master).getTextureName();
	}	@Override	public void setTextureName(String s) {
		((Modchu_IGuiModelViewMaster) master).setTextureName(s);
	}	@Override	public String getTextureArmorName() {
		return ((Modchu_IGuiModelViewMaster) master).getTextureArmorName();
	}	@Override	public void setTextureArmorName(String s) {
		((Modchu_IGuiModelViewMaster) master).setTextureArmorName(s);
	}	@Override	public int getColor() {
		return ((Modchu_IGuiModelViewMaster) master).getColor();
	}	@Override	public void setColor(int i) {
		((Modchu_IGuiModelViewMaster) master).setColor(i);
	}	@Override	public float getScale() {
		return ((Modchu_IGuiModelViewMaster) master).getScale();
	}	@Override	public void setScale(float f) {
		((Modchu_IGuiModelViewMaster) master).setScale(f);
	}	@Override	public void modelChange() {
		((Modchu_IGuiModelViewMaster) master).modelChange();
	}	@Override
	public void updateScreen() {
		((Modchu_IGuiModelViewMaster) master).updateScreen();
	}	@Override
	public void onGuiClosed() {
		((Modchu_IGuiModelViewMaster) master).onGuiClosed();
	}	@Override	public int getHandednessMode() {
		return ((Modchu_IGuiModelViewMaster) master).getHandednessMode();
	}	@Override	public void setHandednessMode(int i) {
		((Modchu_IGuiModelViewMaster) master).setHandednessMode(i);
	}	@Override	public void setChangeMode(int i) {
		((Modchu_IGuiModelViewMaster) master).setChangeMode(i);
	}	@Override	public void superSetGuiSize(int w, int h) {		((Modchu_IGuiModelViewMaster) master).setGuiSize(w, h);	}	@Override	public void superDrawHoveringText(String tabName, int mouseX, int mouseY) {		((Modchu_IGuiModelViewMaster) master).drawHoveringText(tabName, mouseX, mouseY);	}	@Override	public Object superGetFontRenderer() {		return ((Modchu_IGuiModelViewMaster) master).getFontRenderer();	}	@Override	public void superSetFontRenderer(Object o) {		((Modchu_IGuiModelViewMaster) master).setFontRenderer(o);	}}