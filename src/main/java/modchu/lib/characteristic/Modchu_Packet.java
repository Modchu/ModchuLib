package modchu.lib.characteristic;

import io.netty.buffer.ByteBufInputStream;

import java.io.EOFException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IPacketConstant;
import modchu.lib.Modchu_Reflect;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;

public class Modchu_Packet implements Modchu_IPacketConstant {
	public static ConcurrentHashMap<String, Modchu_PacketHandler> packetHandlerMap = new ConcurrentHashMap();

	public static void registerPacket(Object instance, String channelName) {
		Object networkRegistryINSTANCE = Modchu_Reflect.getFieldObject("cpw.mods.fml.common.network.NetworkRegistry", "INSTANCE");
		if (networkRegistryINSTANCE != null) ;else return;
		Object packetChannel = Modchu_Reflect.invokeMethod(networkRegistryINSTANCE.getClass(), "newEventDrivenChannel", new Class[]{ String.class }, networkRegistryINSTANCE, new Object[]{ channelName });
		if (packetChannel != null) ;else return;
		Modchu_PacketHandler packetHandler = new Modchu_PacketHandler(packetChannel, channelName, instance);
		packetHandlerMap.put(channelName, packetHandler);
		Modchu_Reflect.invokeMethod(packetChannel.getClass(), "register", new Class[]{ Object.class }, packetChannel, new Object[]{ packetHandler });
	}

	public static void reFlashPacketChannel() {
		Object networkRegistryINSTANCE = Modchu_Reflect.getFieldObject("cpw.mods.fml.common.network.NetworkRegistry", "INSTANCE");
		if (networkRegistryINSTANCE != null) ;else return;
		for (Entry<String, Modchu_PacketHandler> en : packetHandlerMap.entrySet()) {
			String s = en.getKey();
			Modchu_PacketHandler packetHandler = en.getValue();
			Modchu_Reflect.invokeMethod(packetHandler.packetChannel.getClass(), "unregister", new Class[]{ Object.class }, packetHandler.packetChannel, new Object[]{ packetHandler });
			Object packetChannel = Modchu_Reflect.invokeMethod(networkRegistryINSTANCE.getClass(), "newEventDrivenChannel", new Class[]{ String.class }, networkRegistryINSTANCE, new Object[]{ packetHandler.channelName });
			Modchu_Reflect.invokeMethod(packetChannel.getClass(), "register", new Class[]{ Object.class }, packetChannel, new Object[]{ packetHandler });
		}
	}

	public static void onPacketData(Object packet, String channelName, Object entityPlayer) {
		Modchu_PacketHandler packetHander = getPacketHander(channelName);
		if (packetHander != null) ;else return;
		Modchu_Reflect.invokeMethod(packetHander.modInstance.getClass(), "onPacketData", new Class[]{ Object.class, Object.class, String.class }, packetHander.modInstance, new Object[]{ packet, entityPlayer, channelName });
	}

	public static void sendToAll(Object[] o, String channelName) {
		sendToAll(o, channelName, Modchu_AS.get(Modchu_AS.minecraftTheWorld));
	}

	public static void sendToAll(Object[] o, String channelName, Object world) {
		if (o != null
				&& channelName != null
				&& world != null) ;else {
			if (o != null) ;else Modchu_Debug.mDebug("Modchu_Packet sendToAll o == null !!");
			if (channelName != null) ;else Modchu_Debug.mDebug("Modchu_Packet sendToAll channelName == null !!");
			if (world != null) ;else Modchu_Debug.mDebug("Modchu_Packet sendToAll world == null !!");
			return;
		}
		Modchu_PacketHandler packetHander = getPacketHander(channelName);
		for (Object entityplayer : Modchu_AS.getList(Modchu_AS.playerEntities, world)) {
			packetHander.sendTo(o, entityplayer, channelName);
		}
	}

	public static void sendTo(Object[] o, Object player, String channelName) {
		Modchu_PacketHandler packetHander = getPacketHander(channelName);
		packetHander.sendTo(o, player, channelName);
	}

	public static void sendToAllAround(Object[] o, String channelName, Object networkRegistryTargetPoint) {
		Modchu_PacketHandler packetHander = getPacketHander(channelName);
		packetHander.sendToAllAround(o, channelName, networkRegistryTargetPoint);
	}

	public static void sendToDimension(Object[] o, String channelName, int dimensionId) {
		Modchu_PacketHandler packetHander = getPacketHander(channelName);
		packetHander.sendToDimension(o, channelName, dimensionId);
	}

	public static void sendToServer(Object[] o, String channelName) {
		Modchu_PacketHandler packetHander = getPacketHander(channelName);
		packetHander.sendToServer(o, channelName);
	}

	public static Modchu_PacketHandler getPacketHander(String channelName) {
		return packetHandlerMap.get(channelName);
	}

	public static InputStream getPacketInputStream(Object packet) {
		return new ByteBufInputStream(((FMLProxyPacket) packet).payload());
	}

	public static Object[] sendStateProcessing(Object... o) {
		if (o != null
				&& o.length > 0) ;else return null;
		Object[] o2 = new Object[o.length * 2 + 1];
		for (int i = 0; i < o.length; i++) {
			Modchu_Debug.mDebug("o["+i+"]="+o[i]);
			o2[i * 2 + 1] = o[i];
			if (o[i] instanceof Integer) {
				o2[i * 2] = packet_Integer;
			}
			else if (o[i] instanceof Float) {
				o2[i * 2] = packet_Float;
			}
			else if (o[i] instanceof Double) {
				o2[i * 2] = packet_Double;
			}
			else if (o[i] instanceof Long) {
				o2[i * 2] = packet_Long;
			}
			else if (o[i] instanceof String) {
				o2[i * 2] = packet_String;
			} else {
				o2[i * 2] = packet_Byte;
			}
		}
		o2[o2.length - 1] = packet_end;
		return o2;
	}

	public static ConcurrentHashMap<Integer, Object> receivePacketData(InputStream input) {
		ByteBufInputStream byteBufInput = (ByteBufInputStream) input;
		ConcurrentHashMap<Integer, Object> map = new ConcurrentHashMap();
		int i = 0;
		boolean returnFlag = true;
		try {
			do {
				byte by = Modchu_PacketBasis.readByte(byteBufInput);
				Object o = null;
				switch(by) {
				case packet_Byte:
					o = Modchu_PacketBasis.readByte(byteBufInput);
					break;
				case packet_Integer:
					o = Modchu_PacketBasis.readInt(byteBufInput);
					break;
				case packet_Float:
					o = Modchu_PacketBasis.readFloat(byteBufInput);
					break;
				case packet_Double:
					o = Modchu_PacketBasis.readDouble(byteBufInput);
					break;
				case packet_Long:
					o = Modchu_PacketBasis.readLong(byteBufInput);
					break;
				case packet_String:
					o = Modchu_PacketBasis.readString(byteBufInput);
					break;
				case packet_end:
					returnFlag = false;
					break;
				default:
					break;
				}
				if (o != null) {
					Modchu_Debug.mDebug("Modchu_Packet receivePacketData i="+i+" o="+o);
					map.put(i, o);
				}
				i++;
			} while(returnFlag);
		} catch (EOFException e) {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (byteBufInput != null) byteBufInput.close();
			} catch (Exception e) {
			}
		}
		return map;
	}
}
