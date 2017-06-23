package modchu.lib.forge.mc162;import java.util.EnumSet;import java.util.List;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_EventSystem;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Packet;import modchu.lib.Modchu_Reflect;import modchu.lib.Modchu_Version;import modchu.lib.forge.mc162_164.Modchu_ModContainer;import net.minecraft.network.INetworkManager;import net.minecraft.network.NetLoginHandler;import net.minecraft.network.packet.NetHandler;import net.minecraft.network.packet.Packet1Login;import net.minecraft.network.packet.Packet250CustomPayload;import net.minecraft.server.MinecraftServer;import cpw.mods.fml.common.FMLCommonHandler;import cpw.mods.fml.common.ITickHandler;import cpw.mods.fml.common.Loader;import cpw.mods.fml.common.ModContainer;import cpw.mods.fml.common.TickType;import cpw.mods.fml.common.network.FMLNetworkHandler;import cpw.mods.fml.common.network.IConnectionHandler;import cpw.mods.fml.common.network.IPacketHandler;import cpw.mods.fml.common.network.NetworkMod;import cpw.mods.fml.common.network.NetworkModHandler;import cpw.mods.fml.common.network.NetworkRegistry;import cpw.mods.fml.common.network.Player;import cpw.mods.fml.common.registry.TickRegistry;import cpw.mods.fml.relauncher.Side;@NetworkMod(		clientSideRequired = true,		serverSideRequired = true,		channels = {ModchuPacket.channelName},		packetHandler = ModchuPacket.class,		connectionHandler = ModchuPacket.class		)public class ModchuPacket implements IPacketHandler, IConnectionHandler, ITickHandler {	//164・162共通コードだがビルド関連問題で共通化不可	public static ModchuPacket instance;	public static final String channelName = "Modchu";	public NetworkModHandler networkModHandler;	public Modchu_ModContainer modContainer;	public ModchuPacket() {		if (instance != null); else instance = this;	}	public String getName() {		return "modchupacket";	}	public String getModId() {		return getName();	}	public String getVersion() {		return Modchu_Version.modchulibForForgeVersionString+"-"+getName();	}	public void preInit(Object event) {		if (!Modchu_Main.isServer) {			TickRegistry.registerTickHandler(this, Side.CLIENT);		} else {			TickRegistry.registerTickHandler(this, Side.SERVER);		}		//Modchu_Debug.lDebug("ModchuPacket preInit");		modContainer = new Modchu_ModContainer(instance);		networkModHandler = new NetworkModHandler(modContainer, getClass().getAnnotation(NetworkMod.class));		NetworkRegistry.instance().registerChannel(this, channelName);		if (Modchu_Main.isServer) return;		FMLNetworkHandler.instance().registerNetworkMod(networkModHandler);		Modchu_Debug.lDebug("ModchuPacket preInit end.");	}	public static void modsLoaded() {		if (Modchu_Main.isServer) return;		Modchu_Debug.lDebug("ModchuPacket modsLoaded strat.");		Object modController = Modchu_Reflect.getFieldObject("cpw.mods.fml.common.Loader", "modController", Loader.instance());		List<ModContainer> activeModList = (List<ModContainer>) Modchu_Reflect.getFieldObject(modController.getClass(), "activeModList", modController);		activeModList.add(instance.modContainer);		Modchu_Reflect.setFieldObject(modController.getClass(), "modObjectList", modController, Modchu_Reflect.invokeMethod(modController.getClass(), "buildModObjectList", modController));		ModContainer mc = FMLCommonHandler.instance().findContainerFor(instance);		Modchu_Debug.lDebug("ModchuPacket modsLoaded mc="+mc);		Modchu_Debug.lDebug("ModchuPacket modsLoaded end. findNetworkModHandler="+FMLNetworkHandler.instance().findNetworkModHandler(mc));		Modchu_Main.settingRegisterGlobalEntityIDList();	}	@Override	public void tickStart(EnumSet<TickType> type, Object... tickData) {	}	@Override	public void tickEnd(EnumSet<TickType> type, Object... tickData) {		if (Modchu_Main.isServer) return;		byte by = type.equals(EnumSet.of(TickType.RENDER)) ? (byte)2 : type.equals(EnumSet.of(TickType.PLAYER)) ? (byte)1 : (byte)0;		Modchu_Main.onTickInGame(null, 0.0F, null, by, tickData);	}	@Override	public EnumSet<TickType> ticks() {		return EnumSet.of(TickType.RENDER, TickType.PLAYER, TickType.CLIENT);	}	@Override	public String getLabel() {		return "modchupacket";	}	@Override	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {	}	@Override	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {		return null;	}	@Override	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {	}	@Override	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) {	}	@Override	public void connectionClosed(INetworkManager manager) {	}	@Override	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) {		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(null), Modchu_Main.getEventObjectLoadCheckList(), "clientConnectedToServer", "clientConnectedToServer", new Class[]{ Object.class }, new Object[]{ new Object[]{ clientHandler, manager, login } });	}	@Override	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {		Modchu_Packet.onPacketData(manager, packet,  player);	}}