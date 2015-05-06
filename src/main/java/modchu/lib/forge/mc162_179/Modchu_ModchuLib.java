package modchu.lib.forge.mc162_179;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_EventSystem;import modchu.lib.Modchu_Init;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Reflect;import modchu.lib.Modchu_Version;import modchu.lib.forge.mc152_179.Modchu_ThreadInit;import com.google.common.eventbus.Subscribe;import cpw.mods.fml.common.Mod;import cpw.mods.fml.common.Mod.EventHandler;import cpw.mods.fml.common.event.FMLInitializationEvent;import cpw.mods.fml.common.event.FMLPreInitializationEvent;import cpw.mods.fml.common.event.FMLServerStartingEvent;@Mod(modid=Modchu_Version.modName, name=Modchu_Version.modName, version=Modchu_Version.modchulibVersionString, acceptedMinecraftVersions="")public class Modchu_ModchuLib {	public Modchu_ThreadInit loadCheckThread;	public static Modchu_ModchuLib instance;	static {		Modchu_Init.init();	}	public Modchu_ModchuLib() {		if (instance != null); else instance = this;	}	public String getName() {		return Modchu_Version.modSimpleName;	}	public String getVersion() {		return Modchu_Version.modchulibForForgeVersionString;	}	@Mod.EventHandler	public void load(FMLInitializationEvent event) {		Modchu_Debug.systemLogDebug("mod_Modchu_ModchuLib load()");		if (Modchu_Main.getMinecraftVersion() > 169) {			Object instance = Modchu_Reflect.getFieldObject("cpw.mods.fml.common.FMLCommonHandler", "INSTANCE");			Object bus = Modchu_Reflect.invokeMethod(instance.getClass(), "bus", instance);			Modchu_Reflect.invokeMethod(bus.getClass(), "register", new Class[]{ Object.class }, bus, new Object[]{ Modchu_Reflect.newInstance(Modchu_Main.getModchuCharacteristicClass("Modchu_TickHandler")) });		}		Object EVENT_BUS = Modchu_Reflect.getFieldObject("net.minecraftforge.common.MinecraftForge", "EVENT_BUS");		Modchu_Reflect.invokeMethod(EVENT_BUS.getClass(), "register", new Class[]{ Object.class }, EVENT_BUS, new Object[]{ Modchu_Reflect.newInstance(Modchu_Main.getModchuCharacteristicClass("Modchu_ForgeEVENTHandler")) });		//MinecraftForge.EVENT_BUS.register(Modchu_Reflect.newInstance(Modchu_Main.getModchuCharacteristicClass("Modchu_ForgeEVENTHandler")));		Modchu_Debug.systemLogDebug("mod_Modchu_ModchuLib load() end.");	}	@EventHandler	public void preInit(FMLPreInitializationEvent event) {		Modchu_Debug.systemLogDebug("mod_Modchu_ModchuLib preInit()");		Modchu_Main.load(this);		if (Modchu_Main.getMinecraftVersion() <= 164) {			Object instance = Modchu_Reflect.newInstance(Modchu_Main.getModchuCharacteristicClass("ModchuPacket"));			Modchu_Reflect.invokeMethod(instance.getClass(), "preInit", new Class[]{ Object.class }, instance, new Object[]{ event });		}		Modchu_Debug.systemLogDebug("mod_Modchu_ModchuLib preInit() end.");	}/*	@Mod.EventHandler	public void MissingMappingsEvent(FMLMissingMappingsEvent event){		event.applyModContainer(Loader.instance().activeModContainer());		for(FMLMissingMappingsEvent.MissingMapping mapping : event.get()){			Modchu_Reflect.invokeMethod(mapping.getClass(), "ignore", mapping);		}	}*/	@EventHandler	public void init(FMLInitializationEvent event) {		Modchu_Debug.systemLogDebug("mod_Modchu_ModchuLib init");		if (Modchu_Main.isServer) return;		loadCheckThread = new Modchu_ThreadInit();		loadCheckThread.start();		loadCheckThread.register(Modchu_Reflect.getMethod(getClass(), "initModsLoaded"));		Modchu_Debug.systemLogDebug("mod_Modchu_ModchuLib init end.");	}	@Subscribe	public void serverStarting(FMLServerStartingEvent event) {		String s = "fmlServerStartingEvent";		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ event });	}	public boolean onTickInGame(float f, Object minecraft) {		return Modchu_Main.onTickInGame(null, f, (Object) minecraft, (byte)0);	}	public void modsLoaded() {	}	public static void initModsLoaded() {		Modchu_Main.initModsLoadedStarting = true;		instance.loadCheckThread.yield();		instance.loadCheckThread = null;	}	public void keyboardEvent(Object keybinding) {		Modchu_Main.keyboardEvent(keybinding);	}	public void load() {	}}