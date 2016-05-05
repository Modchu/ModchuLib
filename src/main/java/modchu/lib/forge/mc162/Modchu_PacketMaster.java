package modchu.lib.forge.mc162;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IPacketMaster;
import modchu.lib.Modchu_Packet;
import modchu.lib.Modchu_PacketManager;
import modchu.lib.Modchu_Reflect;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class Modchu_PacketMaster implements Modchu_IPacketMaster {
	public ConcurrentHashMap<String, Object> packetModInstanceMap = new ConcurrentHashMap();
	public String modchuChannelName = "Modchu";

	public Modchu_PacketMaster(HashMap<String, Object> map) {
	}

	public void registerPacket(Object instance, String channelName) {
		boolean debug = false;
		if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster registerPacket instance="+instance+" channelName="+channelName);
		if (instance != null
				&& channelName != null) ;else return;
		if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster registerPacket 1");
		packetModInstanceMap.put(channelName, instance);
		if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster registerPacket end.");
	}

	public void onPacketData(Object... o) {
		boolean debug = false;
		if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster onPacketData o="+o);
		Object iNetworkManager = o != null
				&& o.length > 0 ? o[0] : null;
		Packet250CustomPayload packet = o != null
				&& o.length > 1
				&& o[1] instanceof Packet250CustomPayload ? (Packet250CustomPayload) o[1] : null;
		if (debug) {
			Modchu_Debug.lDebug("Modchu_PacketMaster onPacketData iNetworkManager="+iNetworkManager);
			Modchu_Debug.lDebug("Modchu_PacketMaster onPacketData packet="+packet);
		}
		if (packet != null) ;else return;
		Object player = o != null
				&& o.length > 2 ? o[2] : null;
		if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster onPacketData player="+player);
		DataInputStream datainputstream = receivePacket(packet.data);
		String channelName;
		try {
			byte by = datainputstream.readByte();
			channelName = Packet.readString(datainputstream, 16);
			if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster onPacketData channelName="+channelName);
			if (channelName != null
					&& !channelName.isEmpty()) {
				Object modInstance = packetModInstanceMap.get(channelName);
				if (modInstance != null) {
					if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster onPacketData ok. modInstance="+modInstance);
					LinkedList list = receivePacketData(datainputstream);
					if (list != null
							&& !list.isEmpty()) {
						Modchu_Reflect.invokeMethod(modInstance.getClass(), "onPacketData", new Class[]{ LinkedList.class, Object.class, String.class }, modInstance, new Object[]{ list, player, channelName });
						if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster onPacketData ok.");
					} else {
						Modchu_Debug.lDebug("Modchu_PacketMaster onPacketData list == null error !! channelName="+channelName+" modInstance="+modInstance);
					}
				}
			} else {
				Modchu_Debug.lDebug("Modchu_PacketMaster onPacketData channelName == null error !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (datainputstream != null) datainputstream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster onPacketData end.");
	}

	public void sendToAll(Object[] o, String channelName) {
		sendToAll(o, channelName, Modchu_AS.get(Modchu_AS.minecraftTheWorld));
	}

	@Override
	public void sendToAll(Object o, String channelName) {
		sendToAll((Object[]) o, channelName, Modchu_AS.get(Modchu_AS.minecraftTheWorld));
	}

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
		for (Object entityplayer : Modchu_AS.getList(Modchu_AS.playerEntities, world)) {
			sendTo(newPacket(o, channelName), (EntityPlayerMP) entityplayer, channelName);
		}
	}

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
		}
	}

	public void sendToServer(Object o, String channelName) {
		PacketDispatcher.sendPacketToServer((Packet) (o instanceof Packet ? (Packet) o : newPacket((Object[]) o, channelName)));
	}

	@Override
	public void sendToServer(Object[] o, String channelName) {
		PacketDispatcher.sendPacketToServer((Packet) (newPacket(o, channelName)));
	}

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
		boolean debug = false;
		try {
			dataoutputstream = new DataOutputStream(byteOutput);
			for (Object o1 : o) {
				if (o1 instanceof Integer) {
					dataoutputstream.writeInt((Integer) o1);
					if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster getBytes Integer o1="+o1);
				}
				else if (o1 instanceof Byte) {
					dataoutputstream.writeByte((Byte) o1);
					if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster getBytes Byte o1="+o1);
				}
				else if (o1 instanceof Float) {
					dataoutputstream.writeFloat((Float) o1);
					if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster getBytes Float o1="+o1);
				}
				else if (o1 instanceof Double) {
					dataoutputstream.writeDouble((Double) o1);
					if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster getBytes Double o1="+o1);
				}
				else if (o1 instanceof Long) {
					dataoutputstream.writeLong((Long) o1);
					if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster getBytes Long o1="+o1);
				}
				else {
					Packet.writeString(""+o1, dataoutputstream);
					if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster getBytes else String o1="+o1);
				}
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
		if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster getBytes end. by="+by);
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
			else if (o[i] instanceof Byte) {
				o2[i * 2] = Modchu_Packet.packet_Byte;
			} else {
				o2[i * 2] = Modchu_Packet.packet_String;
			}
		}
		o2[o2.length - 1] = Modchu_Packet.packet_end;
		return o2;
	}

	public LinkedList receivePacketData(InputStream input) {
		boolean debug = false;
		LinkedList list = new LinkedList();
		int i = 0;
		boolean returnFlag = true;
		try {
			do {
				byte by = Modchu_PacketManager.readByte(input);
				Object o = null;
				if (by == Modchu_Packet.packet_Byte) {
					o = Modchu_PacketManager.readByte(input);
					if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster receivePacketData packet_Byte o="+o);
				} else if (by == Modchu_Packet.packet_Integer) {
					o = Modchu_PacketManager.readInt(input);
					if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster receivePacketData packet_Integer o="+o);
				} else if (by == Modchu_Packet.packet_Float) {
					o = Modchu_PacketManager.readFloat(input);
				} else if (by == Modchu_Packet.packet_Double) {
					o = Modchu_PacketManager.readDouble(input);
				} else if (by == Modchu_Packet.packet_Long) {
					o = Modchu_PacketManager.readLong(input);
				} else if (by == Modchu_Packet.packet_String) {
					o = Modchu_PacketManager.readString(input);
				} else if (by == Modchu_Packet.packet_end) {
					returnFlag = false;
					if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster receivePacketData packet_end");
				}
				if (o != null) {
					if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster receivePacketData i="+i+" o="+o);
					list.add(o);
				}
				i++;
				if (i > 63) returnFlag = false;
			} while(returnFlag);
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
}
