package modchu.lib;

import java.util.Map;
import java.util.Random;

public interface Modchu_IBaseModMaster {
	public String getName();
	public String getVersion();
	public void load();
	public void modsLoaded();
	public void addRenderer(Map map);
	public void keyboardEvent(Object keyBinding);
	public int addFuel(int i, int j);
	public void generateNether(Object world, Random random, int i, int j);
	public void generateSurface(Object world, Random random, int i, int j);
	public String getPriorities();
	public void onItemPickup(Object entityPlayer, Object itemStack);
	public void clientChat(String s1);
	public void serverChat(Object netServerHandler, String s1);
	public void clientCustomPayload(Object netClientHandler, Object packet250CustomPayload);
	public void serverCustomPayload(Object netServerHandler, Object packet250CustomPayload);
	public void renderInvBlock(Object renderBlocks, Object block, int i, int j);
	public boolean renderWorldBlock(Object renderBlocks, Object iBlockAccess, int i, int j, int k, Object block, int l);
	public void clientConnect(Object netClientHandler);
	public void clientDisconnect(Object netClientHandler);
	public void takenFromCrafting(Object entityPlayer, Object itemStack, Object iInventory);
	public void takenFromFurnace(Object entityPlayer, Object itemStack);
	public Object getContainerGUI(Object entityClientPlayerMP, int inventoryType, int x, int y, int z);
	public Object spawnEntity(int id, Object world, double x, double y, double z);
	public Object getSpawnPacket(Object entity, int id);
	public String getLabel();

}
