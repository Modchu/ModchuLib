package modchu.lib;

public interface Modchu_IGuiHandlerMaster {
	public Object getServerGuiElement(int ID, Object entityPlayer, Object world, int x, int y, int z);
	public Object getClientGuiElement(int ID, Object entityPlayer, Object world, int x, int y, int z);

}
