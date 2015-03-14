package modchu.lib;

import java.io.InputStream;
import java.util.LinkedList;

public interface Modchu_IPacketMaster {

	public void registerPacket(Object instance, String channelName);
	public void onPacketData(Object... o);
	public void sendToAll(Object[] o, String channelName);
	public void sendToAll(Object[] o, String channelName, Object world);
	public void sendTo(Object[] o, Object player, String channelName);
	public void sendToAllAround(Object[] o, String channelName, Object networkRegistryTargetPoint);
	public void sendToDimension(Object[] o, String channelName, int dimensionId);
	public void sendToServer(Object[] o, String channelName);
	public void sendToServer(Object packet, String channelName);
	public void sendTo(Object packet, Object entityPlayerMP, String channelName);
	public void sendToAllAround(Object packet, Object networkRegistryTargetPoint, String channelName);
	public void sendToDimension(Object packet, int dimensionId, String channelName);
	public void sendToAll(Object packet, String channelName);
	public Object getBytes(Object[] o);
	public Object newPacket(Object[] o, String s);
	public Object getPacketHander(String channelName);
	public InputStream getPacketInputStream(Object packet);
	public Object[] sendStateProcessing(Object... o);
	public LinkedList receivePacketData(InputStream input);

}
