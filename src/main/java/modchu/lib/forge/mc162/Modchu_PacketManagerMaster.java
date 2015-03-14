package modchu.lib.forge.mc162;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import modchu.lib.Modchu_IPacketManager;
import modchu.lib.Modchu_Packet;

public class Modchu_PacketManagerMaster implements Modchu_IPacketManager {

	public Modchu_PacketManagerMaster() {
	}

	@Override
	public void sendToServer(Object[] data, String packetChannelName) {
		Modchu_Packet.sendToServer(data, packetChannelName);
	}

	@Override
	public void sendToClient(Object[] data, Object entityPlayerMP, String channelName) {
		if (data != null
				&& entityPlayerMP != null) Modchu_Packet.sendTo(data, entityPlayerMP, channelName);
	}

	@Override
	public void sendToAll(Object[] data, String channelName) {
		if (data != null) Modchu_Packet.sendToAll(data, channelName);
	}

	@Override
	public void sendToAll(Object[] data, String channelName, Object world) {
		if (data != null) Modchu_Packet.sendToAll(data, channelName, world);
	}

	@Override
	public byte readByte(InputStream input) throws IOException {
		return input instanceof DataInputStream ? ((DataInputStream) input).readByte() : input instanceof ObjectInputStream ? ((ObjectInputStream) input).readByte() : Byte.MIN_VALUE;
	}

	@Override
	public int readInt(InputStream input) throws IOException {
		return input instanceof DataInputStream ? ((DataInputStream) input).readInt() : input instanceof ObjectInputStream ? ((ObjectInputStream) input).readInt() : Integer.MIN_VALUE;
	}

	@Override
	public long readLong(InputStream input) throws IOException {
		return input instanceof DataInputStream ? ((DataInputStream) input).readLong() : input instanceof ObjectInputStream ? ((ObjectInputStream) input).readLong() : Long.MIN_VALUE;
	}

	@Override
	public float readFloat(InputStream input) throws IOException {
		return input instanceof DataInputStream ? ((DataInputStream) input).readFloat() : input instanceof ObjectInputStream ? ((ObjectInputStream) input).readFloat() : Float.MIN_VALUE;
	}

	@Override
	public double readDouble(InputStream input) throws IOException {
		return input instanceof DataInputStream ? ((DataInputStream) input).readDouble() : input instanceof ObjectInputStream ? ((ObjectInputStream) input).readDouble() : Double.MIN_VALUE;
	}

	@Override
	public String readString(InputStream input) throws IOException {
		return input instanceof ObjectInputStream ? ((ObjectInputStream) input).readUTF() : null;
	}

}