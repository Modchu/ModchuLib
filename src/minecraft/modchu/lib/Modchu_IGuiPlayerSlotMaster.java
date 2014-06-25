package modchu.lib;

public interface Modchu_IGuiPlayerSlotMaster {

	public int getSize();
	public int getContentHeight();
	public void elementClicked(int i, boolean flag);
	public void openGuiCustomize();
	public boolean isSelected(int i);
	public void drawBackground();
	public boolean drawScreen(int i, int j, float f);
	public void drawSlot(int i, int j, int k, int l, Object tessellator, int m, int n);
	public void deletePlayerLocalData();

}
