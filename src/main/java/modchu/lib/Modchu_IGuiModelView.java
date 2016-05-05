package modchu.lib;

public interface Modchu_IGuiModelView extends Modchu_IGuiScreen {
	public void drawGuiContainerBackgroundLayer(float f, int i, int j);
	public void drawString(String s, int i, int j, int k);
	public void setTextureArmorPackege();
	public void setTextureArmorPackege(int i);
	public void setTextureValue();
	public void setArmorTextureValue();
	public void selected(String textureName, String textureArmorName, int color, boolean armorMode);
	public int colorCheck(String textureName, int i, boolean colorReverse);
	public String getTextureName();
	public void setTextureName(String s);
	public String getTextureArmorName();
	public void setTextureArmorName(String s);
	public int getColor();
	public void setColor(int i);
	public float getScale();
	public void setScale(float f);
	public void modelChange();
	public int getHandednessMode();
	public void setHandednessMode(int i);
	public void setChangeMode(int i);
	public void reInit();

}
