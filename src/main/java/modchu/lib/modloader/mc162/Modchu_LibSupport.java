package modchu.lib.modloader.mc162;

import java.util.Map;
import java.util.Random;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IBaseModMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Version;
import net.minecraft.src.BaseMod;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.NetServerHandler;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.World;

public class Modchu_LibSupport {
	private static Modchu_LibSupportSub instance;
	public static boolean initFlag = false;

	public static void init(Object o) {
		Modchu_Debug.lDebug("Modchu_LibSupport init");
		if (instance != null); else instance = new Modchu_LibSupport().new Modchu_LibSupportSub(o);
		initFlag = true;
	}

	public static Modchu_LibSupportSub getInstance() {
		return instance;
	}

	public class Modchu_LibSupportSub extends BaseMod {
		public Modchu_IBaseModMaster master;

		public Modchu_LibSupportSub(Object o) {
			master = !Modchu_Main.isForge ? (Modchu_IBaseModMaster) Modchu_Main.getModchuCharacteristicObjectMaster(o) : null;
		}

		@Override
		public String getVersion() {
			return "Modchu_LibSupportSub v"+Modchu_Version.modchulibVersionString;
		}

		@Override
		public void load() {
			if (master != null) master.load();
		}

		@Override
		public void modsLoaded() {
			if (master != null) master.modsLoaded();
		}

		@Override
		public void addRenderer(Map map) {
			if (master != null) master.addRenderer(map);
		}

		@Override
		public int addFuel(int i, int j) {
			return master != null ? master.addFuel(i, j) : 0;
		}

		@Override
		public String getPriorities() {
			return master != null ? master.getPriorities() : null;
		}

		@Override
		public void clientChat(String s1) {
			if (master != null) master.clientChat(s1);
		}

		public String getLabel() {
			return master != null ? master.getLabel() : "";
		}

		@Override
		public void keyboardEvent(KeyBinding keyBinding) {
			Modchu_Debug.lDebug("Modchu_LibSupportSub keyboardEvent");
			if (master != null) master.keyboardEvent(keyBinding);
		}

		@Override
		public void generateNether(World world, Random random, int i, int j) {
			if (master != null) master.generateNether(world, random, i, j);
		}

		@Override
		public void generateSurface(World world, Random random, int i, int j) {
			if (master != null) master.generateSurface(world, random, i, j);
		}

		@Override
		public void onItemPickup(EntityPlayer entityPlayer, ItemStack itemStack) {
			if (master != null) master.onItemPickup(entityPlayer, itemStack);
		}

		@Override
		public void serverChat(NetServerHandler netServerHandler, String s1) {
			if (master != null) master.serverChat(netServerHandler, s1);
		}

		@Override
		public void clientCustomPayload(NetClientHandler netClientHandler, Packet250CustomPayload packet250CustomPayload) {
			if (master != null) master.clientCustomPayload(netClientHandler, packet250CustomPayload);
		}

		@Override
		public void serverCustomPayload(NetServerHandler netServerHandler, Packet250CustomPayload packet250CustomPayload) {
			if (master != null) master.serverCustomPayload(netServerHandler, packet250CustomPayload);
		}

		@Override
		public void renderInvBlock(RenderBlocks renderBlocks, Block block, int i, int j) {
			if (master != null) master.renderInvBlock(renderBlocks, block, i, j);
		}

		@Override
		public boolean renderWorldBlock(RenderBlocks renderBlocks, IBlockAccess iBlockAccess, int i, int j, int k, Block block, int l) {
			return master != null ? master.renderWorldBlock(renderBlocks, iBlockAccess, i, j, k, block, l) : null;
		}

		@Override
		public void clientConnect(NetClientHandler netClientHandler) {
			if (master != null) master.clientConnect(netClientHandler);
		}

		@Override
		public void clientDisconnect(NetClientHandler netClientHandler) {
			if (master != null) master.clientDisconnect(netClientHandler);
		}

		@Override
		public void takenFromCrafting(EntityPlayer entityPlayer, ItemStack itemStack, IInventory iInventory) {
			if (master != null) master.takenFromCrafting(entityPlayer, itemStack, iInventory);
		}

		@Override
		public void takenFromFurnace(EntityPlayer entityPlayer, ItemStack itemStack) {
			if (master != null) master.takenFromFurnace(entityPlayer, itemStack);
		}

		@Override
		public GuiContainer getContainerGUI(EntityClientPlayerMP entityClientPlayerMP, int inventoryType, int x, int y, int z) {
			return (GuiContainer) (master != null ? master.getContainerGUI(entityClientPlayerMP, inventoryType, x, y, z) : null);
		}

		@Override
		public Entity spawnEntity(int id, World world, double x, double y, double z) {
			return (Entity) (master != null ? master.spawnEntity(id, world, x, y, z) : null);
		}
	}

}