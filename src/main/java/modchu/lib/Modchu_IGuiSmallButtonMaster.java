package modchu.lib;

public interface Modchu_IGuiSmallButtonMaster {

	public boolean mousePressed(Object par1Minecraft, int par2, int par3);
	public void drawButton(Object par1Minecraft, int par2, int par3);
	public boolean getButtonRange();
	public boolean getButtonClick();
	public void setButtonClick(boolean b);
	public boolean getButtonClickTransmission();
	public void setButtonClickTransmission(boolean b);

}
