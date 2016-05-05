package modchu.lib;

public interface Modchu_IGuiModelViewMaster extends Modchu_IGuiScreenMaster {

	public void drawGuiContainerBackgroundLayer(float f, int i, int j);
	public void setTextureArmorPackege();
	public void setTextureArmorPackege(int i);
	public void setTextureValue();
	public void setArmorTextureValue();
	public void selected(String textureName, String textureArmorName, int color, boolean armorMode);
	public int colorCheck(String textureName, int i, boolean colorReverse);
	public int getHandednessMode();
	public void setHandednessMode(int i);
	public String getTextureName();
	public void setTextureName(String s);
	public String getTextureArmorName();
	public void setTextureArmorName(String s);
	public int getColor();
	public void setColor(int i);
	public float getScale();
	public void setScale(float f);
	public void modelChange();
	public void setChangeMode(int i);

}
