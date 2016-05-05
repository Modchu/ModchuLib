package modchu.lib.forge.mc152_162;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EventSystem;
import modchu.lib.Modchu_IBaseModMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.lib.Modchu_Version;

public class Modchu_ModchuLibMaster implements Modchu_IBaseModMaster {
	public Object base;
	public Object loadCheckThread;
	public Modchu_ModchuLibMaster instance;

	public Modchu_ModchuLibMaster(HashMap<String, Object> map) {
		instance = this;
		base = map.get("Object");
		Modchu_Debug.systemLogDebug("Modchu_ModchuLibMaster init base="+base);
	}

	@Override
	public String getName() {
		return Modchu_Version.modName+";for old Minecraft & MinecraftForge";
	}

	@Override
	public String getVersion() {
		return Modchu_Version.modchulibForForgeVersionString+";for old Minecraft & MinecraftForge";
	}

	@Override
	public void load() {
		Modchu_Debug.systemLogDebug("Modchu_ModchuLibMaster load()");
		Modchu_Main.load(base);
		if (Modchu_Main.getMinecraftVersion() > 169) {
			Object instance = Modchu_Reflect.getFieldObject("cpw.mods.fml.common.FMLCommonHandler", "INSTANCE");
			Object bus = Modchu_Reflect.invokeMethod(instance.getClass(), "bus", instance);
			Modchu_Reflect.invokeMethod(bus.getClass(), "register", new Class[]{ Object.class }, bus, new Object[]{ Modchu_Reflect.newInstance(Modchu_Main.getModchuCharacteristicClass("Modchu_TickHandler")) });
		}
		Object EVENT_BUS = Modchu_Reflect.getFieldObject("net.minecraftforge.common.MinecraftForge", "EVENT_BUS");
		Modchu_Reflect.invokeMethod(EVENT_BUS.getClass(), "register", new Class[]{ Object.class }, EVENT_BUS, new Object[]{ Modchu_Reflect.newInstance(Modchu_Main.getModchuCharacteristicClass("Modchu_ForgeEVENTHandler")) });
		//MinecraftForge.EVENT_BUS.register(Modchu_Reflect.newInstance(Modchu_Main.getModchuCharacteristicClass("Modchu_ForgeEVENTHandler")));
		Modchu_Debug.systemLogDebug("Modchu_ModchuLibMaster load() end.");
	}

	@Override
	public void modsLoaded() {
		Modchu_Debug.systemLogDebug("Modchu_ModchuLibMaster modsLoaded() base="+base);
		Object instance = Modchu_Reflect.newInstance(Modchu_Main.getModchuCharacteristicClass("ModchuPacket"));
		Modchu_Reflect.invokeMethod(instance.getClass(), "preInit", new Class[]{ Object.class }, instance, new Object[]{ null });
		Modchu_Main.modsLoaded();
		Modchu_Debug.systemLogDebug("Modchu_ModchuLibMaster modsLoaded() end.");
	}

	@Override
	public void addRenderer(Map map) {
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
		String s = "generateNether";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ world, random, i, j } });
	}

	@Override
	public void generateSurface(Object world, Random random, int i, int j) {
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
		String s = "onItemPickup";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ entityplayer, itemstack } });
	}

	@Override
	public void clientChat(String s1) {
		String s = "clientChat";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ s1 } });
	}

	@Override
	public void serverChat(Object netserverhandler, String s1) {
		String s = "serverChat";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ netserverhandler, s1 } });
	}

	@Override
	public void clientCustomPayload(Object clientHandler, Object packet250custompayload) {
		String s = "clientCustomPayload";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ clientHandler, packet250custompayload } });
	}

	@Override
	public void serverCustomPayload(Object serverHandler, Object packet250custompayload) {
		String s = "serverCustomPayload";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ serverHandler, packet250custompayload } });
	}

	@Override
	public void renderInvBlock(Object renderblocks, Object block, int i, int j) {
		String s = "renderInvBlock";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ renderblocks, block, i, j } });
	}

	@Override
	public boolean renderWorldBlock(Object renderblocks, Object iblockaccess, int i, int j, int k, Object block, int l) {
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
		String s = "clientConnect";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ netclienthandler } });
	}

	@Override
	public void clientDisconnect(Object clientHandler) {
		String s = "clientDisconnect";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ clientHandler } });
	}

	@Override
	public void takenFromCrafting(Object entityplayer, Object itemstack, Object iinventory) {
		String s = "takenFromCrafting";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ entityplayer, itemstack, iinventory } });
	}

	@Override
	public void takenFromFurnace(Object entityplayer, Object itemstack) {
		String s = "takenFromFurnace";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ entityplayer, itemstack } });
	}

	@Override
	public Object getContainerGUI(Object player, int inventoryType, int x, int y, int z) {
		String s = "getContainerGUI";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return null;
		Object[] o = Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ player, inventoryType, x, y, z } });
		for (Object o1 : o) {
			if (o1 != null) return o1;
		}
		return null;
	}

	@Override
	public Object spawnEntity(int id, Object world, double x, double y, double z) {
		String s = "spawnEntity";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return null;
		Object[] o = Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ id, world, x, y, z } });
		for (Object o1 : o) {
			if (o1 != null) return o1;
		}
		return null;
	}

	@Override
	public Object getSpawnPacket(Object entity, int id) {
		String s = "getSpawnPacket";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return null;
		Object[] o = Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ entity, id } });
		for (Object o1 : o) {
			if (o1 != null) return o1;
		}
		return null;
	}

	public String getLabel() {
		return "ModchuLib";
	}

}