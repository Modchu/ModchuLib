package net.minecraft.src;import java.util.Map;import java.util.Random;import modchu.lib.Modchu_CastHelper;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_EventSystem;import modchu.lib.Modchu_IBaseModMaster;import modchu.lib.Modchu_Init;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Version;public class mod_Modchu_ModchuLibForModLoader152 extends BaseMod {	public static Modchu_IBaseModMaster master;	public mod_Modchu_ModchuLibForModLoader152 instance;	public mod_Modchu_ModchuLibForModLoader152() {		Modchu_Init.init();		if (Modchu_Main.getMinecraftVersion() != 152				| Modchu_Main.isForge) return;		instance = this;		master = (Modchu_IBaseModMaster) Modchu_Main.newModchuCharacteristicObject("Modchu_ModchuLibMaster", this);	}	@Override	public String getName() {		return master != null ? master.getName() : "ModchuLibForModLoader152";	}	@Override	public String getVersion() {		return master != null ? master.getVersion() : "none";	}	@Override	public void load() {		if (master != null) master.load();	}	@Override	public void modsLoaded() {		if (master != null) master.modsLoaded();	}	@Override	public void addRenderer(Map map) {		if (master != null) master.addRenderer(map);	}	@Override	public void keyboardEvent(KeyBinding keyBinding) {		if (master != null) master.keyboardEvent(keyBinding);	}	@Override	public int addFuel(int i, int j) {		return master != null ? master.addFuel(i, j) : 0;	}	@Override	public void generateNether(World world, Random random, int i, int j) {		if (master != null) master.generateNether(world, random, i, j);	}	@Override	public void generateSurface(World world, Random random, int i, int j) {		if (master != null) master.generateSurface(world, random, i, j);	}	@Override	public String getPriorities() {		return master != null ? master.getPriorities() : null;	}	@Override	public void onItemPickup(EntityPlayer entityPlayer, ItemStack itemStack) {		if (master != null) master.onItemPickup(entityPlayer, itemStack);	}	@Override	public void clientChat(String s1) {		if (master != null) master.clientChat(s1);	}	@Override	public void serverChat(NetServerHandler netServerHandler, String s1) {		if (master != null) master.serverChat(netServerHandler, s1);	}	@Override	public void clientCustomPayload(NetClientHandler netClientHandler, Packet250CustomPayload packet250CustomPayload) {		if (master != null) master.clientCustomPayload(netClientHandler, packet250CustomPayload);	}	@Override	public void serverCustomPayload(NetServerHandler netServerHandler, Packet250CustomPayload packet250CustomPayload) {		if (master != null) master.serverCustomPayload(netServerHandler, packet250CustomPayload);	}	@Override	public void renderInvBlock(RenderBlocks renderBlocks, Block block, int i, int j) {		if (master != null) master.renderInvBlock(renderBlocks, block, i, j);	}	@Override	public boolean renderWorldBlock(RenderBlocks renderBlocks, IBlockAccess iBlockAccess, int i, int j, int k, Block block, int l) {		return master != null ? master.renderWorldBlock(renderBlocks, iBlockAccess, i, j, k, block, l) : null;	}	@Override	public void clientConnect(NetClientHandler netClientHandler) {		if (master != null) master.clientConnect(netClientHandler);	}	@Override	public void clientDisconnect(NetClientHandler netClientHandler) {		if (master != null) master.clientDisconnect(netClientHandler);	}	@Override	public void takenFromCrafting(EntityPlayer entityPlayer, ItemStack itemStack, IInventory iInventory) {		if (master != null) master.takenFromCrafting(entityPlayer, itemStack, iInventory);	}	@Override	public void takenFromFurnace(EntityPlayer entityPlayer, ItemStack itemStack) {		if (master != null) master.takenFromFurnace(entityPlayer, itemStack);	}	@Override	public GuiContainer getContainerGUI(EntityClientPlayerMP entityClientPlayerMP, int inventoryType, int x, int y, int z) {		return (GuiContainer) (master != null ? master.getContainerGUI(entityClientPlayerMP, inventoryType, x, y, z) : null);	}	@Override	public Entity spawnEntity(int id, World world, double x, double y, double z) {		return (Entity) (master != null ? master.spawnEntity(id, world, x, y, z) : super.spawnEntity(id, world, x, y, z));	}	@Override	public Packet23VehicleSpawn getSpawnPacket(Entity entity, int id) {		return (Packet23VehicleSpawn) (master != null ? master.getSpawnPacket(entity, id) : null);	}	public String getLabel() {		return master != null ? master.getLabel() : "";	}}