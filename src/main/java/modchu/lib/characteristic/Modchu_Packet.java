package modchu.lib.characteristic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;

import java.io.EOFException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IPacketConstant;
import modchu.lib.Modchu_Reflect;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;

public class Modchu_Packet implements Modchu_IPacketConstant {
	private static ConcurrentHashMap<String, EnumMap<Side, FMLEmbeddedChannel>> channelsMap = new ConcurrentHashMap();
	public static ConcurrentHashMap<String, Modchu_PacketHandler> packetHandlerMap = new ConcurrentHashMap();

	public static void registerPacket(Object instance, String channelName) {
		if (channelName != null
				&& !channelName.isEmpty()) ;else {
			Modchu_Debug.mDebug("Modchu_Packet registerPacket channelName == null !!");
			return;
		}
		Object networkRegistryINSTANCE = Modchu_Reflect.getFieldObject("cpw.mods.fml.common.network.NetworkRegistry", "INSTANCE");
		if (networkRegistryINSTANCE != null) ;else {
			Modchu_Debug.mDebug("Modchu_Packet registerPacket networkRegistryINSTANCE == null !!");
			return;
		}
		Modchu_PacketHandler packetHandler = new Modchu_PacketHandler(channelName, instance);
		Object o = Modchu_Reflect.invokeMethod(networkRegistryINSTANCE.getClass(), "newChannel", new Class[]{ String.class, ChannelHandler[].class }, networkRegistryINSTANCE, new Object[]{ channelName, new ChannelHandler[] { packetHandler } });
		EnumMap<Side, FMLEmbeddedChannel> channels = o != null ? (EnumMap<Side, FMLEmbeddedChannel>) o : null;
		if (channels != null) ;else {
			Modchu_Debug.mDebug("Modchu_Packet registerPacket channels == null !!");
			return;
		}
		channelsMap.put(channelName, channels);
		packetHandlerMap.put(channelName, packetHandler);
	}

	public static void onPacketData(Object packet, String channelName, Object entityPlayer) {
		Modchu_Debug.mDebug("Modchu_Packet onPacketData channelName="+channelName);
		Modchu_PacketHandler packetHander = getPacketHander(channelName);
		if (packetHander != null) ;else return;
		Modchu_Reflect.invokeMethod(packetHander.modInstance.getClass(), "onPacketData", new Class[]{ LinkedList.class, Object.class, String.class }, packetHander.modInstance, new Object[]{ Modchu_Packet.receivePacketData(Modchu_Packet.getPacketInputStream(packet)), entityPlayer, channelName });
	}

	public static void sendToAll(Object[] o, String channelName) {
		sendToAll(o, channelName, null);
		//sendToAll(o, channelName, Modchu_AS.get(Modchu_AS.minecraftServerGetServerWorldServers));
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
		sendToAll(newPacket(o, channelName), channelName);
/*
		if (world.getClass().isArray()) {
			for (Object world1 : Modchu_CastHelper.ObjectArray(world)) {
				sendToWorld(o, channelName, world1);
			}
		} else {
			sendToWorld(o, channelName, world);
		}
*/
	}

	private static void sendToWorld(Object[] o, String channelName, Object world) {
		for (Object entityplayer : Modchu_AS.getList(Modchu_AS.playerEntities, world)) {
			sendTo(newPacket(o, channelName), (EntityPlayerMP) entityplayer, channelName);
		}
	}

	public static void sendTo(Object[] o, Object player, String channelName) {
		Modchu_Debug.mDebug("Modchu_Packet sendTo channelName="+channelName);
		sendTo(newPacket(o, channelName), (EntityPlayerMP) player, channelName);
	}

	public static void sendToAllAround(Object[] o, String channelName, Object networkRegistryTargetPoint) {
		sendToAllAround(newPacket(o, channelName), (TargetPoint) networkRegistryTargetPoint, channelName);
	}

	public static void sendToDimension(Object[] o, String channelName, int dimensionId) {
		sendToDimension(newPacket(o, channelName), dimensionId, channelName);
	}

	public static void sendToServer(Object[] o, String channelName) {
		Modchu_Debug.mDebug("Modchu_Packet sendToServer channelName="+channelName);
		sendToServer(newPacket(o, channelName), channelName);
	}

	public static void sendToAll(Modchu_AbstractPacket message, String channelName) {
		if (!channelsMap.containsKey(channelName)) return;
		EnumMap<Side, FMLEmbeddedChannel> channels = channelsMap.get(channelName);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
	}

	public static void sendTo(Modchu_AbstractPacket message, EntityPlayerMP player, String channelName) {
		if (!channelsMap.containsKey(channelName)) return;
		EnumMap<Side, FMLEmbeddedChannel> channels = channelsMap.get(channelName);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
	}

	public static void sendToAllAround(Modchu_AbstractPacket message, NetworkRegistry.TargetPoint point, String channelName) {
		if (!channelsMap.containsKey(channelName)) return;
		EnumMap<Side, FMLEmbeddedChannel> channels = channelsMap.get(channelName);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
	}

	public static void sendToDimension(Modchu_AbstractPacket message, int dimensionId, String channelName) {
		if (!channelsMap.containsKey(channelName)) return;
		EnumMap<Side, FMLEmbeddedChannel> channels = channelsMap.get(channelName);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(Integer.valueOf(dimensionId));
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
	}

	public static void sendToServer(Modchu_AbstractPacket message, String channelName) {
		if (!channelsMap.containsKey(channelName)) return;
		EnumMap<Side, FMLEmbeddedChannel> channels = channelsMap.get(channelName);
		((FMLEmbeddedChannel)channels.get(Side.CLIENT)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
		((FMLEmbeddedChannel)channels.get(Side.CLIENT)).writeAndFlush(message);
	}

	public static ByteBuf getBytes(Object[] o) {
		o = Modchu_Packet.sendStateProcessing(o);
		ByteBuf buf = Unpooled.buffer();
		ByteBufOutputStream byteBufOutputStream = new ByteBufOutputStream(buf);
		try {
			for (Object o1 : o) {
				if (o1 != null) {
					if ((o1 instanceof Enum)) byteBufOutputStream.writeInt(((Enum) o1).ordinal());
					else if ((o1 instanceof Integer)) byteBufOutputStream.writeInt(((Integer) o1).intValue());
					else if ((o1 instanceof String)) byteBufOutputStream.writeUTF((String) o1);
					else if ((o1 instanceof Byte)) byteBufOutputStream.writeByte(((Byte) o1).byteValue());
					else if ((o1 instanceof Float)) byteBufOutputStream.writeFloat(((Float) o1).floatValue());
					else if ((o1 instanceof Double)) byteBufOutputStream.writeDouble(((Double) o1).doubleValue());
					else if ((o1 instanceof NBTTagCompound)) CompressedStreamTools.write((NBTTagCompound) o1, byteBufOutputStream);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (byteBufOutputStream != null) byteBufOutputStream.close();
			} catch (Exception e) {
			}
		}
		return buf;
	}

	public static Modchu_Message newPacket(Object[] o, String s) {
		return new Modchu_Message(getBytes(o), s);
	}

	public static Modchu_PacketHandler getPacketHander(String channelName) {
		return packetHandlerMap.get(channelName);
	}

	public static InputStream getPacketInputStream(Object packet) {
		return new ByteBufInputStream(((FMLProxyPacket) packet).payload());
	}

	public static Object[] sendStateProcessing(Object... o) {
		if (o != null
				&& o.length > 0) ;else return null;
		Object[] o2 = new Object[o.length * 2 + 1];
		for (int i = 0; i < o.length; i++) {
			Modchu_Debug.mDebug("o["+i+"]="+o[i]);
			o2[i * 2 + 1] = o[i];
			if (o[i] instanceof Integer) {
				o2[i * 2] = packet_Integer;
			}
			else if (o[i] instanceof Float) {
				o2[i * 2] = packet_Float;
			}
			else if (o[i] instanceof Double) {
				o2[i * 2] = packet_Double;
			}
			else if (o[i] instanceof Long) {
				o2[i * 2] = packet_Long;
			}
			else if (o[i] instanceof String) {
				o2[i * 2] = packet_String;
			} else {
				o2[i * 2] = packet_Byte;
			}
		}
		o2[o2.length - 1] = packet_end;
		return o2;
	}

	public static LinkedList receivePacketData(InputStream input) {
		ByteBufInputStream byteBufInput = (ByteBufInputStream) input;
		LinkedList list = new LinkedList();
		int i = 0;
		boolean returnFlag = true;
		try {
			do {
				byte by = Modchu_PacketBasis.readByte(byteBufInput);
				Object o = null;
				switch(by) {
				case packet_Byte:
					o = Modchu_PacketBasis.readByte(byteBufInput);
					break;
				case packet_Integer:
					o = Modchu_PacketBasis.readInt(byteBufInput);
					break;
				case packet_Float:
					o = Modchu_PacketBasis.readFloat(byteBufInput);
					break;
				case packet_Double:
					o = Modchu_PacketBasis.readDouble(byteBufInput);
					break;
				case packet_Long:
					o = Modchu_PacketBasis.readLong(byteBufInput);
					break;
				case packet_String:
					o = Modchu_PacketBasis.readString(byteBufInput);
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
				if (byteBufInput != null) byteBufInput.close();
			} catch (Exception e) {
			}
			try {
				if (input != null) input.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
/*
	public static ConcurrentHashMap<Integer, Object> receivePacketData(InputStream input) {
		ByteBufInputStream byteBufInput = (ByteBufInputStream) input;
		ConcurrentHashMap<Integer, Object> map = new ConcurrentHashMap();
		int i = 0;
		boolean returnFlag = true;
		try {
			do {
				byte by = Modchu_PacketBasis.readByte(byteBufInput);
				Object o = null;
				switch(by) {
				case packet_Byte:
					o = Modchu_PacketBasis.readByte(byteBufInput);
					break;
				case packet_Integer:
					o = Modchu_PacketBasis.readInt(byteBufInput);
					break;
				case packet_Float:
					o = Modchu_PacketBasis.readFloat(byteBufInput);
					break;
				case packet_Double:
					o = Modchu_PacketBasis.readDouble(byteBufInput);
					break;
				case packet_Long:
					o = Modchu_PacketBasis.readLong(byteBufInput);
					break;
				case packet_String:
					o = Modchu_PacketBasis.readString(byteBufInput);
					break;
				case packet_end:
					returnFlag = false;
					break;
				default:
					break;
				}
				if (o != null) {
					Modchu_Debug.mDebug("Modchu_Packet receivePacketData i="+i+" o="+o);
					map.put(i, o);
				}
				i++;
			} while(returnFlag);
		} catch (EOFException e) {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (byteBufInput != null) byteBufInput.close();
			} catch (Exception e) {
			}
		}
		return map;
	}
*/
}
