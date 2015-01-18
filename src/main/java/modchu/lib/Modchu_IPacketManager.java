package modchu.lib;

import java.io.IOException;
import java.io.InputStream;

public interface Modchu_IPacketManager {

	public void sendToServer(Object[] data, String packetChannelName);
	public void sendToClient(Object[] data, Object entityPlayerMP, String channelName);
	public void sendToAll(Object[] data, String channelName);
	public void sendToAll(Object[] data, String channelName, Object world);
	public byte readByte(InputStream input) throws IOException;
	public int readInt(InputStream input) throws IOException;
	public long readLong(InputStream input) throws IOException;
	public float readFloat(InputStream input) throws IOException;
	public double readDouble(InputStream input) throws IOException;
	public String readString(InputStream input) throws IOException;

}
