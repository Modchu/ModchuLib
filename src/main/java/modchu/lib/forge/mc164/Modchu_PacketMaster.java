package modchu.lib.forge.mc164;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IPacketMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Packet;
import modchu.lib.Modchu_PacketManager;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class Modchu_PacketMaster implements Modchu_IPacketMaster {
	public ConcurrentHashMap<String, Object> packetModInstanceMap = new ConcurrentHashMap();
	public String modchuChannelName = "Modchu";

	public Modchu_PacketMaster(HashMap<String, Object> map) {
	}

	@Override
	public void registerPacket(Object instance, String channelName) {
		if (instance != null
				&& channelName != null) ;else return;
		packetModInstanceMap.put(channelName, instance);
	}

	@Override
	public void onPacketData(Object... o) {
		Object iNetworkManager = o[0];
		Packet250CustomPayload packet = o[1] instanceof Packet250CustomPayload ? (Packet250CustomPayload) o[1] : null;
		if (packet != null) ;else return;
		Object player = o[2];
		DataInputStream datainputstream = receivePacket(packet.data);
		String channelName;
		try {
			byte by = datainputstream.readByte();
			channelName = Packet.readString(datainputstream, 16);
			//Modchu_Debug.mDebug("Modchu_PacketMaster onPacketData channelName="+channelName);
			if (channelName != null
					&& !channelName.isEmpty()) {
				Object modInstance = packetModInstanceMap.get(channelName);
				if (modInstance != null) Modchu_Reflect.invokeMethod(modInstance.getClass(), "onPacketData", new Class[]{ LinkedList.class, Object.class, String.class }, modInstance, new Object[]{ receivePacketData(datainputstream), player, channelName });
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(datainputstream != null) datainputstream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void sendToAll(Object[] o, String channelName) {
		sendToAll(o, channelName, getWorld());
	}

	@Override
	public void sendToAll(Object o, String channelName) {
		sendToAll((Object[]) o, channelName, getWorld());
	}

	@Override
	public void sendToAll(Object[] o, String channelName, Object world) {
		Modchu_Debug.mDebug("Modchu_PacketMaster sendToAll channelName="+channelName);
		if (o != null
				&& channelName != null
				//&& world != null
				) ;else {
			if (o != null) ;else Modchu_Debug.mDebug("Modchu_PacketMaster sendToAll o == null !!");
			if (channelName != null) ;else Modchu_Debug.mDebug("Modchu_PacketMaster sendToAll channelName == null !!");
			//if (world != null) ;else Modchu_Debug.mDebug("Modchu_PacketMaster sendToAll world == null !!");
			return;
		}
		//sendToAll(newPacket(o, channelName), channelName);
		if (world.getClass().isArray()) {
			for (Object world1 : Modchu_CastHelper.ObjectArray(world)) {
				sendToWorld(o, channelName, world1);
			}
		} else {
			sendToWorld(o, channelName, world);
		}
	}

	private void sendToWorld(Object[] o, String channelName, Object world) {
		Modchu_Debug.mDebug("Modchu_PacketMaster sendToWorld world="+world);
		Modchu_Debug.mDebug("Modchu_PacketMaster sendToWorld playerEntities="+Modchu_AS.getList(Modchu_AS.playerEntities, world));
		for (Object entityplayer : Modchu_AS.getList(Modchu_AS.playerEntities, world)) {
			Modchu_Debug.mDebug("Modchu_PacketMaster sendToWorld entityplayer="+entityplayer);
			sendTo(newPacket(o, channelName), entityplayer, channelName);
		}
	}

	@Override
	public void sendTo(Object o, Object player, String channelName) {
		sendPacketToPlayer((Packet) (o instanceof Packet ? o : newPacket((Object[]) o, channelName)), player);
	}

	@Override
	public void sendTo(Object[] o, Object player, String channelName) {
		sendPacketToPlayer((Packet)newPacket(o, channelName), player);
	}

	private void sendPacketToPlayer(Packet packet, Object player) {
		if (player != null) {
			if (player instanceof Player) PacketDispatcher.sendPacketToPlayer(packet, (Player) player);
			else if (player instanceof EntityPlayerMP) ((EntityPlayerMP) player).playerNetServerHandler.sendPacketToPlayer(packet);
			else if (player instanceof EntityClientPlayerMP) ((EntityClientPlayerMP) player).sendQueue.addToSendQueue(packet);
		}
	}

	@Override
	public void sendToServer(Object o, String channelName) {
		PacketDispatcher.sendPacketToServer((Packet) (o instanceof Packet ? (Packet) o : newPacket((Object[]) o, channelName)));
	}

	@Override
	public void sendToServer(Object[] o, String channelName) {
		PacketDispatcher.sendPacketToServer((Packet) (newPacket(o, channelName)));
	}

	@Override
	public InputStream getPacketInputStream(Object packet) {
		if (packet instanceof InputStream) return (InputStream) packet;
		byte[] data = Modchu_CastHelper.ByteArray(Modchu_Reflect.getFieldObject(packet.getClass(), "data", packet));
		try {
			return data != null ? new DataInputStream(new ByteArrayInputStream(data)) : null;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public Object getBytes(Object[] o) {
		if (o != null
				&& o.length > 0) ;else return null;
		o = Modchu_Packet.sendStateProcessing(o);
		ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
		DataOutputStream dataoutputstream = null;
		byte[] by = null;
		try {
			dataoutputstream = new DataOutputStream(byteOutput);
			for (Object o1 : o) {
				if (o1 instanceof Integer) dataoutputstream.writeInt((Integer) o1);
				else if (o1 instanceof String) Packet.writeString((String) o1, dataoutputstream);
				else if (o1 instanceof Byte) dataoutputstream.writeByte((Byte) o1);
				else if (o1 instanceof Float) dataoutputstream.writeFloat((Float) o1);
				else if (o1 instanceof Double) dataoutputstream.writeDouble((Double) o1);
				else if (o1 instanceof Long) dataoutputstream.writeLong((Long) o1);
				else if (o1 instanceof Boolean) dataoutputstream.writeByte((Boolean)o1 ? (byte) 1 : (byte) 0);
			}
			//dataoutputstream.flush();
			by = byteOutput.toByteArray();
		} catch (Throwable t) {
			throw new RuntimeException(t);
		} finally {
			try {
				if(dataoutputstream != null) dataoutputstream.close();
				if(byteOutput != null) byteOutput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return by;
	}

	private Object[] addChannelName(Object[] o, String channelName) {
		Object[] o2 = new Object[o.length + 1];
		o2[0] = channelName;
		for(int i = 0; i < o.length; i++) {
			o2[i + 1] = o[i];
		}
		return o2;
	}

	@Override
	public Object newPacket(Object[] o, String channelName) {
		return new Packet250CustomPayload(modchuChannelName, (byte[]) getBytes(addChannelName(o, channelName)));
	}

	public DataInputStream receivePacket(byte[] var0) {
		try {
			ByteArrayInputStream byteInput = new ByteArrayInputStream(var0);
			return new DataInputStream(byteInput);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return null;
	}

	@Override
	public Object[] sendStateProcessing(Object... o) {
		if (o != null
				&& o.length > 0) ;else return null;
		Object[] o2 = new Object[o.length * 2 + 1];
		for (int i = 0; i < o.length; i++) {
			Modchu_Debug.mDebug("o["+i+"]="+o[i]);
			o2[i * 2 + 1] = o[i];
			if (o[i] instanceof Integer) {
				o2[i * 2] = Modchu_Packet.packet_Integer;
			}
			else if (o[i] instanceof Float) {
				o2[i * 2] = Modchu_Packet.packet_Float;
			}
			else if (o[i] instanceof Double) {
				o2[i * 2] = Modchu_Packet.packet_Double;
			}
			else if (o[i] instanceof Long) {
				o2[i * 2] = Modchu_Packet.packet_Long;
			}
			else if (o[i] instanceof String) {
				o2[i * 2] = Modchu_Packet.packet_String;
			}
			else if (o[i] instanceof Boolean) {
				o2[i * 2] = Modchu_Packet.packet_Boolean;
			} else {
				o2[i * 2] = Modchu_Packet.packet_Byte;
			}
		}
		o2[o2.length - 1] = Modchu_Packet.packet_end;
		return o2;
	}

	@Override
	public LinkedList receivePacketData(InputStream input) {
		LinkedList list = new LinkedList();
		int i = 0;
		boolean returnFlag = true;
		try {
			do {
				byte by = Modchu_PacketManager.readByte(input);
				Object o = null;
				if (by == Modchu_Packet.packet_Byte) {
					o = Modchu_PacketManager.readByte(input);
				} else if (by == Modchu_Packet.packet_Integer) {
					o = Modchu_PacketManager.readInt(input);
				} else if (by == Modchu_Packet.packet_Float) {
					o = Modchu_PacketManager.readFloat(input);
				} else if (by == Modchu_Packet.packet_Double) {
					o = Modchu_PacketManager.readDouble(input);
				} else if (by == Modchu_Packet.packet_Long) {
					o = Modchu_PacketManager.readLong(input);
				} else if (by == Modchu_Packet.packet_String) {
					//o = Modchu_PacketManager.readString(input);
					o = Packet.readString((DataInput) input, 32767);
				} else if (by == Modchu_Packet.packet_Boolean) {
					byte by1 = Modchu_PacketManager.readByte(input);
					o = by1 == 0 ? false : true;
				} else if (by == Modchu_Packet.packet_end) {
					returnFlag = false;
				}
				if (o != null) {
					Modchu_Debug.mDebug("Modchu_PacketMaster receivePacketData i="+i+" o="+o);
					list.add(o);
				}
				i++;
			} while(returnFlag);
		} catch (EOFException e) {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) input.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

	@Override
	public void sendToAllAround(Object[] o, String channelName, Object networkRegistryTargetPoint) {
		sendToAll(o, channelName);
	}

	@Override
	public void sendToAllAround(Object packet, Object networkRegistryTargetPoint, String channelName) {
		sendToAll(packet, channelName);
	}

	@Override
	public void sendToDimension(Object[] o, String channelName, int dimensionId) {
		sendToAll(o, channelName);
	}

	@Override
	public void sendToDimension(Object packet, int dimensionId, String channelName) {
		sendToAll(packet, channelName);
	}

	@Override
	public Object getPacketHander(String channelName) {
		return null;
	}

	private Object getWorld() {
		return Modchu_Main.isServer ? Modchu_AS.get(Modchu_AS.minecraftServerGetServerWorldServers) : Modchu_AS.get(Modchu_AS.minecraftWorld);
	}

}
