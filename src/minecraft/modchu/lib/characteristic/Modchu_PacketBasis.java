package modchu.lib.characteristic;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Modchu_PacketBasis {

	public static void sendToServer(Object[] data, String packetChannelName) {
		Modchu_Packet.sendToServer(data, packetChannelName);
	}

	public static void sendToClient(Object[] data, Object entityPlayerMP, String channelName) {
		if (data != null
				&& entityPlayerMP != null) Modchu_Packet.sendTo(data, entityPlayerMP, channelName);
	}

	public static void sendToAll(Object[] data, String channelName) {
		if (data != null) Modchu_Packet.sendToAll(data, channelName);
	}

	public static void sendToAll(Object[] data, String channelName, Object world) {
		if (data != null) Modchu_Packet.sendToAll(data, channelName, world);
	}

	public static byte readByte(InputStream input) throws IOException {
		return input instanceof DataInputStream ? ((DataInputStream) input).readByte() : input instanceof ObjectInputStream ? ((ObjectInputStream) input).readByte() : Byte.MIN_VALUE;
	}

	public static int readInt(InputStream input) throws IOException {
		return input instanceof DataInputStream ? ((DataInputStream) input).readInt() : input instanceof ObjectInputStream ? ((ObjectInputStream) input).readInt() : Integer.MIN_VALUE;
	}

	public static long readLong(InputStream input) throws IOException {
		return input instanceof DataInputStream ? ((DataInputStream) input).readLong() : input instanceof ObjectInputStream ? ((ObjectInputStream) input).readLong() : Long.MIN_VALUE;
	}

	public static float readFloat(InputStream input) throws IOException {
		return input instanceof DataInputStream ? ((DataInputStream) input).readFloat() : input instanceof ObjectInputStream ? ((ObjectInputStream) input).readFloat() : Float.MIN_VALUE;
	}

	public static double readDouble(InputStream input) throws IOException {
		return input instanceof DataInputStream ? ((DataInputStream) input).readDouble() : input instanceof ObjectInputStream ? ((ObjectInputStream) input).readDouble() : Double.MIN_VALUE;
	}

	public static String readString(InputStream input) throws IOException {
		return input instanceof ObjectInputStream ? ((ObjectInputStream) input).readUTF() : null;
	}

}