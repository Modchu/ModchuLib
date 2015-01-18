package modchu.lib;

import java.io.InputStream;
import java.util.LinkedList;

public class Modchu_Packet implements Modchu_IPacketConstant {
	public static Modchu_IPacket master;

	public static boolean isPacketEnable() {
		return master != null;
	}

	public static void registerPacket(Object instance, String channelName) {
		boolean debug = false;
		if (debug) Modchu_Debug.lDebug("Modchu_Packet registerPacket");
		if (master != null) ;else {
			Class c = Modchu_Reflect.loadClass("modchu.lib.forgeonly.characteristic.Modchu_PacketMaster");
			if (debug) Modchu_Debug.lDebug("Modchu_Packet registerPacket c="+c);
			if (c != null) ;else return;
			Object o = Modchu_Reflect.newInstance(c);
			if (debug) Modchu_Debug.lDebug("Modchu_Packet registerPacket o="+o);
			master = o != null
					&& o instanceof Modchu_IPacket ? (Modchu_IPacket) o : null;
			if (debug) Modchu_Debug.lDebug("Modchu_Packet registerPacket master="+master);
			Modchu_PacketManager.init();
		}
		if (master != null) master.registerPacket(instance, channelName);
		if (debug) Modchu_Debug.lDebug("Modchu_Packet registerPacket end.");
	}

	public static void onPacketData(Object... o) {
		if (master != null) master.onPacketData(o);
	}

	public static void sendToAll(Object[] o, String channelName) {
		if (master != null) master.sendToAll(o, channelName);
	}

	public static void sendToAll(Object[] o, String channelName, Object world) {
		if (master != null) master.sendToAll(o, channelName, world);
	}

	public static void sendTo(Object[] o, Object player, String channelName) {
		if (master != null) master.sendTo(o, player, channelName);
	}

	public static void sendToAllAround(Object[] o, String channelName, Object networkRegistryTargetPoint) {
		if (master != null) master.sendToAllAround(o, channelName, networkRegistryTargetPoint);
	}

	public static void sendToDimension(Object[] o, String channelName, int dimensionId) {
		if (master != null) master.sendToDimension(o, channelName, dimensionId);
	}

	public static void sendToServer(Object[] o, String channelName) {
		if (master != null) master.sendToServer(o, channelName);
	}

	public static void sendToAll(Object packet, String channelName) {
		if (master != null) master.sendToAll(packet, channelName);
	}

	public static void sendTo(Object packet, Object entityPlayerMP, String channelName) {
		if (master != null) master.sendTo(packet, entityPlayerMP, channelName);
	}

	public static void sendToAllAround(Object packet, Object networkRegistryTargetPoint, String channelName) {
		if (master != null) master.sendToAllAround(packet, networkRegistryTargetPoint, channelName);
	}

	public static void sendToDimension(Object packet, int dimensionId, String channelName) {
		if (master != null) master.sendToDimension(packet, dimensionId, channelName);
	}

	public static void sendToServer(Object packet, String channelName) {
		if (master != null) master.sendToServer(packet, channelName);
	}

	public static Object getBytes(Object[] o) {
		return master != null ? master.getBytes(o) : null;
	}

	public static Object newPacket(Object[] o, String s) {
		return master != null ? master.newPacket(o, s) : null;
	}

	public static Object getPacketHander(String channelName) {
		return master != null ? master.getPacketHander(channelName) : null;
	}

	public static InputStream getPacketInputStream(Object packet) {
		return master != null ? master.getPacketInputStream(packet) : null;
	}

	public static Object[] sendStateProcessing(Object... o) {
		return master != null ? master.sendStateProcessing(o) : null;
	}

	public static LinkedList receivePacketData(InputStream input) {
		return master != null ? master.receivePacketData(input) : null;
	}
}
