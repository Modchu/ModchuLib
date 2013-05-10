package net.minecraft.src;

public interface Modchu_IGuiSlot {

	public int getGuiSlotSize(int guiNumber);
	public int getGuiSlotContentHeight(int guiNumber);
	public void guiSlotElementClicked(int guiNumber, int i, boolean flag);
	public boolean guiSlotIsSelected(int guiNumber, int i);
	public void guiSlotDrawSlot(int guiNumber, int i, int showSelectionBoxLeft, int showSelectionBoxRight, int k, int l, Tessellator tessellator);
	public int getSlotScrollBarX(int guiNumber);
	public int getSlotScrollBarSizeX(int guiNumber);

}
