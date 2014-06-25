package modchu.lib;

public interface Modchu_IGuiModelViewMaster extends Modchu_IGuiBaseMaster {

	public void drawGuiContainerBackgroundLayer(float f, int i, int j);
	public void setTextureArmorPackege();
	public void setTextureArmorPackege(int i);
	public void setTextureValue();
	public void setArmorTextureValue();
	public void drawMobModel(int i, int j, int x, int y, int x2, int y2, float f, float f1, boolean move);
	public void drawMobModel(int i, int j, int x, int y, int x2, int y2, float f, float f1, boolean move, Object entity);
	public void drawMobModel(int i, int j, int x, int y, int x2, int y2, float f, float f1, float f2, float f3, float f4, float f5, boolean move);
	public void drawMobModel(int i, int j, int x, int y, int x2, int y2, float f, float f1, float f2, float f3, float f4, float f5, boolean move, Object entity);
	public void drawMobModel(Object guiScreen, int i, int j, int x, int y, int x2, int y2, float f, float f1, float f2, float f3, float f4, float f5, boolean move, Object entity);
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
