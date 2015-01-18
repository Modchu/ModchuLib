package modchu.lib;

import java.io.IOException;
import java.io.InputStream;

public class Modchu_PacketManager {
	public static Modchu_IPacketManager master;

	public static void init() {
		boolean debug = false;
		if (debug) Modchu_Debug.lDebug("Modchu_PacketManager init");
		if (master != null) ;else {
			if (debug) Modchu_Debug.lDebug("Modchu_PacketManager init 1");
			Object o = Modchu_Reflect.newInstance("modchu.lib.forgeonly.characteristic.Modchu_PacketManagerMaster");
			if (debug) Modchu_Debug.lDebug("Modchu_PacketManager init o="+o);
			master = o instanceof Modchu_IPacketManager ? (Modchu_IPacketManager) o : null;
			if (debug) Modchu_Debug.lDebug("Modchu_PacketManager init master="+master);
		}
		if (debug) Modchu_Debug.lDebug("Modchu_PacketManager init end.");
	}

	public static void sendToServer(Object[] data, String packetChannelName) {
		if (master != null) master.sendToServer(data, packetChannelName);
	}

	public static void sendToClient(Object[] data, Object entityPlayerMP, String channelName) {
		if (master != null) master.sendToClient(data, entityPlayerMP, channelName);
	}

	public static void sendToAll(Object[] data, String channelName) {
		if (master != null) master.sendToAll(data, channelName);
	}

	public static void sendToAll(Object[] data, String channelName, Object world) {
		if (master != null) master.sendToAll(data, channelName, world);
	}

	public static byte readByte(InputStream input) throws IOException {
		return master != null ? master.readByte(input) : (byte) 0;
	}

	public static int readInt(InputStream input) throws IOException {
		return master != null ? master.readInt(input) : 0;
	}

	public static long readLong(InputStream input) throws IOException {
		return master != null ? master.readLong(input) : 0L;
	}

	public static float readFloat(InputStream input) throws IOException {
		return master != null ? master.readFloat(input) : 0F;
	}

	public static double readDouble(InputStream input) throws IOException {
		return master != null ? master.readDouble(input) : 0D;
	}

	public static String readString(InputStream input) throws IOException {
		return master != null ? master.readString(input) : null;
	}

}