package modchu.lib;

public interface Modchu_IGuiButton {
	public int superGetHoverState(boolean par1);
	public void superDrawButton(Object minecraft, int par2, int par3);
	public void superDrawButton(Object minecraft, int par2, int par3, float f);
	public void superMouseDragged(Object minecraft, int par2, int par3);
	public void superMouseReleased(int par1, int par2);
	public boolean superMousePressed(Object minecraft, int par2, int par3);
	public boolean superIsMouseOver();
	public void superDrawButtonForegroundLayer(int par1, int par2);
	public void superDrawHorizontalLine(int par1, int par2, int par3, int par4);
	public void superDrawVerticalLine(int par1, int par2, int par3, int par4);
	public void superDrawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void superDrawCenteredString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void superDrawString(Object fontRenderer, String par2Str, int par3, int par4, int par5);
	public void superDrawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6);
	public void superDrawTexturedModelRectFromIcon(int par1, int par2, Object icon, int par4, int par5);

}
