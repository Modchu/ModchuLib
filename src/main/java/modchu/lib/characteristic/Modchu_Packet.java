package modchu.lib.characteristic;

import io.netty.buffer.ByteBufInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_Reflect;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;

public class Modchu_Packet {
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
		Iterator<Entry<String, Modchu_PacketHandler>> iterator = packetHandlerMap.entrySet().iterator();
		Entry<String, Modchu_PacketHandler> entry;
		Modchu_PacketHandler packetHandler;
		String s;
		while(iterator.hasNext()) {
			entry = iterator.next();
			s = entry.getKey();
			packetHandler = entry.getValue();
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
		Modchu_PacketHandler packetHander = getPacketHander(channelName);
		packetHander.sendToAll(o, channelName);
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

	public static ByteBufInputStream getPacketDataByteBufInputStream(Object packet) {
		return new ByteBufInputStream(((FMLProxyPacket) packet).payload());
	}

	public static byte[] getSendStateByteArray(Object... o) {
		ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
		try {
			ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput);
			if (o != null && o.length > 0) {
				for (int i1 = 0; i1 < o.length; i1++) {
					if (o[i1] instanceof Integer) objectOutput.writeInt((Integer) o[i1]);
					else if (o[i1] instanceof Byte) objectOutput.writeByte((Byte) o[i1]);
					else if (o[i1] instanceof Float) objectOutput.writeFloat((Float) o[i1]);
					else if (o[i1] instanceof Long) objectOutput.writeLong((Long) o[i1]);
					else if (o[i1] instanceof Object) objectOutput.writeObject((Object) o[i1]);
				}
			}
			objectOutput.flush();
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
		return byteOutput.toByteArray();
	}
}
