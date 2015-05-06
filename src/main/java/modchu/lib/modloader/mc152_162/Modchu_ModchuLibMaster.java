package modchu.lib.modloader.mc152_162;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EventSystem;
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
import net.minecraft.src.ModLoader;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.NetServerHandler;
import net.minecraft.src.Packet23VehicleSpawn;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.World;

public class Modchu_ModchuLibMaster implements Modchu_IBaseModMaster {
	public Object base;
	public Object loadCheckThread;
	public Modchu_ModchuLibMaster instance;

	public Modchu_ModchuLibMaster(HashMap<String, Object> map) {
		instance = this;
		base = map.get("Object");
	}

	@Override
	public String getName() {
		return Modchu_Version.modSimpleName+";for ModLoader";
	}

	@Override
	public String getVersion() {
		return Modchu_Version.modchulibForForgeVersionString+";for ModLoader";
	}

	@Override
	public void load() {
		if (Modchu_Main.isForge) return;
		Modchu_Debug.systemLogDebug("2 - (1 / 2) mod_Modchu_ModchuLib load()");
		Modchu_Main.load(base);
		BaseMod modchuLibTick = (BaseMod) Modchu_Main.newModchuCharacteristicObject("ModchuLibTick");
		ModLoader.setInGameHook(modchuLibTick, true, true);
		ModLoader.setInGUIHook(modchuLibTick, true, false);
		Modchu_Debug.systemLogDebug("2 - (2 / 2) mod_Modchu_ModchuLib load() end.");
	}

	@Override
	public void modsLoaded() {
		if (Modchu_Main.isForge) return;
		Modchu_Main.modsLoaded();
	}

	@Override
	public void addRenderer(Map map) {
		if (Modchu_Main.isForge) return;
		String s = "addRenderer";
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ map });
		Modchu_Main.addRenderer(map);
	}

	@Override
	public void keyboardEvent(Object keybinding) {
		Modchu_Main.keyboardEvent(keybinding);
	}

	@Override
	public int addFuel(int i, int j) {
		if (Modchu_Main.isForge) return 0;
		String s = "addFuel";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return 0;
		Object[] o = Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ i, j } });
		int i1 = 0;
		for (int i2 = 0; i1 == 0
				&& i2 < o.length; i2++) {
			if (o[i2] != null) i1 = Modchu_CastHelper.Int(o[i2]);
		}
		return i1;
	}

	@Override
	public void generateNether(Object world, Random random, int i, int j) {
		if (Modchu_Main.isForge) return;
		String s = "generateNether";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ world, random, i, j } });
	}

	@Override
	public void generateSurface(Object world, Random random, int i, int j) {
		if (Modchu_Main.isForge) return;
		String s = "generateSurface";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ world, random, i, j } });
	}

	@Override
	public String getPriorities() {
		return null;
	}

	@Override
	public void onItemPickup(Object entityplayer, Object itemstack) {
		if (Modchu_Main.isForge) return;
		String s = "onItemPickup";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ entityplayer, itemstack } });
	}

	@Override
	public void clientChat(String s1) {
		if (Modchu_Main.isForge) return;
		String s = "clientChat";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ s1 } });
	}

	@Override
	public void serverChat(Object netserverhandler, String s1) {
		if (Modchu_Main.isForge) return;
		String s = "serverChat";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ netserverhandler, s1 } });
	}

	@Override
	public void clientCustomPayload(Object clientHandler, Object packet250custompayload) {
		if (Modchu_Main.isForge) return;
		String s = "clientCustomPayload";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ clientHandler, packet250custompayload } });
	}

	@Override
	public void serverCustomPayload(Object serverHandler, Object packet250custompayload) {
		if (Modchu_Main.isForge) return;
		String s = "serverCustomPayload";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ serverHandler, packet250custompayload } });
	}

	@Override
	public void renderInvBlock(Object renderblocks, Object block, int i, int j) {
		if (Modchu_Main.isForge) return;
		String s = "renderInvBlock";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ renderblocks, block, i, j } });
	}

	@Override
	public boolean renderWorldBlock(Object renderblocks, Object iblockaccess, int i, int j, int k, Object block, int l) {
		if (Modchu_Main.isForge) return false;
		String s = "renderWorldBlock";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return false;
		Object[] o = Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ renderblocks, iblockaccess, i, j, k, block, l } });
		boolean b = false;
		for (Object o1 : o) {
			b |= o1 != null ? Modchu_CastHelper.Boolean(o1) : false;
		}
		return b;
	}

	@Override
	public void clientConnect(Object netclienthandler) {
		if (Modchu_Main.isForge) return;
		String s = "clientConnect";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ netclienthandler } });
	}

	@Override
	public void clientDisconnect(Object clientHandler) {
		if (Modchu_Main.isForge) return;
		String s = "clientDisconnect";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ clientHandler } });
	}

	@Override
	public void takenFromCrafting(Object entityplayer, Object itemstack, Object iinventory) {
		if (Modchu_Main.isForge) return;
		String s = "takenFromCrafting";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ entityplayer, itemstack, iinventory } });
	}

	@Override
	public void takenFromFurnace(Object entityplayer, Object itemstack) {
		if (Modchu_Main.isForge) return;
		String s = "takenFromFurnace";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ entityplayer, itemstack } });
	}

	@Override
	public GuiContainer getContainerGUI(Object player, int inventoryType, int x, int y, int z) {
		if (Modchu_Main.isForge) return null;
		String s = "getContainerGUI";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return null;
		Object[] o = Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ player, inventoryType, x, y, z } });
		for (Object o1 : o) {
			if (o1 != null) return (GuiContainer) o1;
		}
		return null;
	}

	@Override
	public Entity spawnEntity(int id, Object world, double x, double y, double z) {
		if (Modchu_Main.isForge) return null;
		String s = "spawnEntity";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return null;
		Object[] o = Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ id, world, x, y, z } });
		for (Object o1 : o) {
			if (o1 != null) return (Entity) o1;
		}
		return null;
	}

	@Override
	public Packet23VehicleSpawn getSpawnPacket(Object entity, int id) {
		if (Modchu_Main.isForge) return null;
		String s = "getSpawnPacket";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return null;
		Object[] o = Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ entity, id } });
		for (Object o1 : o) {
			if (o1 != null) return (Packet23VehicleSpawn) o1;
		}
		return null;
	}

	public String getLabel() {
		return "ModchuLib";
	}

}