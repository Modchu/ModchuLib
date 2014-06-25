package modchu.lib.characteristic;

import io.netty.buffer.ByteBufInputStream;

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

	public static void sendToAll(Object[] data, String channelName, Object world) {
		if (data != null) Modchu_Packet.sendToAll(data, channelName, world);
	}

	public static byte readByte(InputStream input) throws IOException {
		return input instanceof ObjectInputStream ? ((ObjectInputStream) input).readByte() :
				input instanceof ByteBufInputStream ? ((ByteBufInputStream) input).readByte() : Byte.MIN_VALUE;
	}

	public static int readInt(InputStream input) throws IOException {
		return input instanceof ObjectInputStream ? ((ObjectInputStream) input).readInt() :
			input instanceof ByteBufInputStream ? ((ByteBufInputStream) input).readInt() : -1;
	}

	public static long readLong(InputStream input) throws IOException {
		return input instanceof ObjectInputStream ? ((ObjectInputStream) input).readLong() :
			input instanceof ByteBufInputStream ? ((ByteBufInputStream) input).readLong() : Long.MIN_VALUE;
	}

	public static float readFloat(InputStream input) throws IOException {
		return input instanceof ObjectInputStream ? ((ObjectInputStream) input).readFloat() :
			input instanceof ByteBufInputStream ? ((ByteBufInputStream) input).readFloat() : Float.MIN_VALUE;
	}

	public static double readDouble(InputStream input) throws IOException {
		return input instanceof ObjectInputStream ? ((ObjectInputStream) input).readDouble() :
			input instanceof ByteBufInputStream ? ((ByteBufInputStream) input).readDouble() : Double.MIN_VALUE;
	}

	public static String readString(InputStream input) throws IOException {
		return input instanceof ObjectInputStream ? ((ObjectInputStream) input).readUTF() :
			input instanceof ByteBufInputStream ? ((ByteBufInputStream) input).readUTF() : null;
	}

}