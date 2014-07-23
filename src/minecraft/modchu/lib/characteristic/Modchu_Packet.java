package modchu.lib.characteristic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IPacketConstant;
import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.recompileonly.Modchu_CastHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class Modchu_Packet implements Modchu_IPacketConstant {
	public static ConcurrentHashMap<String, Object> packetModInstanceMap = new ConcurrentHashMap();
	public static String modchuChannelName = "Modchu";

	public static void registerPacket(Object instance, String channelName) {
		if (instance != null
				&& channelName != null) ;else return;
		packetModInstanceMap.put(channelName, instance);
	}

	public static void onPacketData(Object iNetworkManager, Packet250CustomPayload packet, Object player) {
		DataInputStream datainputstream = receivePacket(packet.data);
		String channelName;
		try {
			byte by = datainputstream.readByte();
			channelName = Packet.readString(datainputstream, 16);
			//Modchu_Debug.mDebug("Modchu_Packet onPacketData channelName="+channelName);
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

	public static void sendToAll(Object[] o, String channelName) {
		sendToAll(o, channelName, Modchu_AS.get(Modchu_AS.minecraftTheWorld));
	}

	public static void sendToAll(Object[] o, String channelName, Object world) {
		Modchu_Debug.mDebug("Modchu_Packet sendToAll channelName="+channelName);
		if (o != null
				&& channelName != null
				//&& world != null
				) ;else {
			if (o != null) ;else Modchu_Debug.mDebug("Modchu_Packet sendToAll o == null !!");
			if (channelName != null) ;else Modchu_Debug.mDebug("Modchu_Packet sendToAll channelName == null !!");
			//if (world != null) ;else Modchu_Debug.mDebug("Modchu_Packet sendToAll world == null !!");
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

	private static void sendToWorld(Object[] o, String channelName, Object world) {
		for (Object entityplayer : Modchu_AS.getList(Modchu_AS.playerEntities, world)) {
			sendTo(newPacket(o, channelName), (EntityPlayerMP) entityplayer, channelName);
		}
	}

	public static void sendTo(Object o, Object player, String channelName) {
		Packet packet = o instanceof Packet ? (Packet) o : newPacket((Object[]) o, channelName);
		if (player != null) {
			if (player instanceof Player) PacketDispatcher.sendPacketToPlayer(packet, (Player) player);
			else if (player instanceof EntityPlayerMP) ((EntityPlayerMP) player).playerNetServerHandler.sendPacketToPlayer(packet);
		}
	}

	public static void sendToServer(Object o, String channelName) {
		Packet packet = o instanceof Packet ? (Packet) o : newPacket((Object[]) o, channelName);
		PacketDispatcher.sendPacketToServer(packet);
	}

	public static InputStream getPacketInputStream(Object packet) {
		if (packet instanceof InputStream) return (InputStream) packet;
		byte[] data = Modchu_CastHelper.ByteArray(Modchu_Reflect.getFieldObject(packet.getClass(), "data", packet));
		try {
			return data != null ? new DataInputStream(new ByteArrayInputStream(data)) : null;
		} catch (Exception e) {
		}
		return null;
	}

	public static byte[] getSendStateByteArray(Object... o) {
		if (o != null
				&& o.length > 0) ;else return null;
		ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
		DataOutputStream dataoutputstream = null;
		byte[] by = null;
		try {
			dataoutputstream = new DataOutputStream(byteOutput);
			for (Object o1 : o) {
				if (o1 instanceof Integer) {
					dataoutputstream.writeByte(packet_Integer);
					dataoutputstream.writeInt((Integer) o1);
				}
				else if (o1 instanceof Byte) {
					dataoutputstream.writeByte(packet_Byte);
					dataoutputstream.writeByte((Byte) o1);
				}
				else if (o1 instanceof Float) {
					dataoutputstream.writeByte(packet_Float);
					dataoutputstream.writeFloat((Float) o1);
				}
				else if (o1 instanceof Double) {
					dataoutputstream.writeByte(packet_Double);
					dataoutputstream.writeDouble((Double) o1);
				}
				else if (o1 instanceof Long) {
					dataoutputstream.writeByte(packet_Long);
					dataoutputstream.writeLong((Long) o1);
				}
				else if (o1 instanceof String) {
					dataoutputstream.writeByte(packet_String);
					Packet.writeString((String) o1, dataoutputstream);
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
		return by;
	}

	private static Object[] addChannelName(Object[] o, String channelName) {
		Object[] o2 = new Object[o.length + 1];
		o2[0] = channelName;
		for(int i = 0; i < o.length; i++) {
			o2[i + 1] = o[i];
		}
		return o2;
	}

	private static Packet newPacket(Object[] o, String channelName) {
		return new Packet250CustomPayload(modchuChannelName, getSendStateByteArray(addChannelName(o, channelName)));
	}

	public static DataInputStream receivePacket(byte[] var0) {
		try {
			ByteArrayInputStream byteInput = new ByteArrayInputStream(var0);
			return new DataInputStream(byteInput);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return null;
	}

	public static LinkedList receivePacketData(InputStream input) {
		LinkedList list = new LinkedList();
		int i = 0;
		boolean returnFlag = true;
		try {
			do {
				byte by = Modchu_PacketBasis.readByte(input);
				Object o = null;
				switch(by) {
				case packet_Byte:
					o = Modchu_PacketBasis.readByte(input);
					break;
				case packet_Integer:
					o = Modchu_PacketBasis.readInt(input);
					break;
				case packet_Float:
					o = Modchu_PacketBasis.readFloat(input);
					break;
				case packet_Double:
					o = Modchu_PacketBasis.readDouble(input);
					break;
				case packet_Long:
					o = Modchu_PacketBasis.readLong(input);
					break;
				case packet_String:
					o = Modchu_PacketBasis.readString(input);
					break;
				case packet_end:
					returnFlag = false;
					break;
				default:
					break;
				}
				if (o != null) {
					Modchu_Debug.mDebug("Modchu_Packet receivePacketData i="+i+" o="+o);
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
/*
	public static ConcurrentHashMap<Integer, Object> receivePacketData(InputStream input) {
		ConcurrentHashMap<Integer, Object> map = new ConcurrentHashMap();
		int i = 0;
		try {
			do {
				byte by = Modchu_PacketBasis.readByte(input);
				Object o = null;
				switch(by) {
				case packet_Byte:
					o = Modchu_PacketBasis.readByte(input);
					break;
				case packet_Integer:
					o = Modchu_PacketBasis.readInt(input);
					break;
				case packet_Float:
					o = Modchu_PacketBasis.readFloat(input);
					break;
				case packet_Double:
					o = Modchu_PacketBasis.readDouble(input);
					break;
				case packet_Long:
					o = Modchu_PacketBasis.readLong(input);
					break;
				case packet_String:
					o = Modchu_PacketBasis.readString(input);
					break;
				default:
					break;
				}
				if (o != null) {
					Modchu_Debug.mDebug("Modchu_Packet receivePacketData i="+i+" o="+o);
					map.put(i, o);
				}
				i++;
			} while(true);
		} catch (EOFException e) {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) input.close();
			} catch (Exception e) {
			}
		}
		return map;
	}
*/
}
