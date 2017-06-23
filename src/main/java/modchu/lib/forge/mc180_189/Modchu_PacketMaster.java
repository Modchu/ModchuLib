package modchu.lib.forge.mc180_189;

import java.io.EOFException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IPacketMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Packet;
import modchu.lib.Modchu_PacketManager;
import modchu.lib.Modchu_Reflect;
import modchu.lib.forge.mc172_220.Modchu_Message;
import modchu.lib.forge.mc180_220.Modchu_PacketHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.FMLEmbeddedChannel;
import net.minecraftforge.fml.common.network.FMLOutboundHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;
import net.minecraftforge.fml.relauncher.Side;

public class Modchu_PacketMaster implements Modchu_IPacketMaster {
	private ConcurrentHashMap<String, EnumMap<Side, FMLEmbeddedChannel>> channelsMap = new ConcurrentHashMap();
	public ConcurrentHashMap<String, Modchu_PacketHandler> packetHandlerMap = new ConcurrentHashMap();

	public Modchu_PacketMaster(HashMap<String, Object> map) {
	}

	@Override
	public void registerPacket(Object instance, String channelName) {
		if (channelName != null
				&& !channelName.isEmpty()); else {
			Modchu_Debug.mDebug("Modchu_PacketMaster registerPacket channelName == null !!");
			return;
		}
		Object networkRegistryINSTANCE = Modchu_Reflect.getFieldObject("NetworkRegistry", "INSTANCE");
		if (networkRegistryINSTANCE != null); else {
			Modchu_Debug.mDebug("Modchu_PacketMaster registerPacket networkRegistryINSTANCE == null !!");
			return;
		}
		Modchu_PacketHandler packetHandler = new Modchu_PacketHandler(channelName, instance);
		Object o = Modchu_Reflect.invokeMethod(networkRegistryINSTANCE.getClass(), "newChannel", new Class[]{ String.class, ChannelHandler[].class }, networkRegistryINSTANCE, new Object[]{ channelName, new ChannelHandler[] { packetHandler } });
		EnumMap<Side, FMLEmbeddedChannel> channels = o != null ? (EnumMap<Side, FMLEmbeddedChannel>) o : null;
		if (channels != null); else {
			Modchu_Debug.mDebug("Modchu_PacketMaster registerPacket channels == null !!");
			return;
		}
		channelsMap.put(channelName, channels);
		packetHandlerMap.put(channelName, packetHandler);
	}

	@Override
	public void onPacketData(Object... o) {
		Object packet = o[0];
		String channelName = Modchu_CastHelper.String(o[1]);
		Object entityPlayer = o[2];
		Modchu_Debug.mDebug("Modchu_PacketMaster onPacketData channelName="+channelName);
		Modchu_PacketHandler packetHander = getPacketHander(channelName);
		if (packetHander != null); else return;
		Modchu_Reflect.invokeMethod(packetHander.modInstance.getClass(), "onPacketData", new Class[]{ LinkedList.class, Object.class, String.class }, packetHander.modInstance, new Object[]{ Modchu_Packet.receivePacketData(Modchu_Packet.getPacketInputStream(packet)), entityPlayer, channelName });
	}

	@Override
	public void sendToAll(Object[] o, String channelName) {
		sendToAll(o, channelName, null);
		//sendToAll(o, channelName, Modchu_AS.get(Modchu_AS.minecraftServerGetServerWorldServers));
	}

	@Override
	public void sendToAll(Object[] o, String channelName, Object world) {
		Modchu_Debug.mDebug("Modchu_PacketMaster sendToAll channelName="+channelName);
		if (o != null
				&& channelName != null
				//&& world != null
				); else {
			if (o != null); else Modchu_Debug.mDebug("Modchu_PacketMaster sendToAll o == null !!");
			if (channelName != null); else Modchu_Debug.mDebug("Modchu_PacketMaster sendToAll channelName == null !!");
			//if (world != null); else Modchu_Debug.mDebug("Modchu_PacketMaster sendToAll world == null !!");
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

	private void sendToWorld(Object[] o, String channelName, Object world) {
		for (Object entityplayer : Modchu_AS.getList(Modchu_AS.playerEntities, world)) {
			sendTo(newPacket(o, channelName), (EntityPlayerMP) entityplayer, channelName);
		}
	}

	@Override
	public void sendTo(Object[] o, Object player, String channelName) {
		Modchu_Debug.mDebug("Modchu_PacketMaster sendTo channelName="+channelName);
		sendTo(newPacket(o, channelName), (EntityPlayerMP) player, channelName);
	}

	@Override
	public void sendToAllAround(Object[] o, String channelName, Object networkRegistryTargetPoint) {
		sendToAllAround(newPacket(o, channelName), (TargetPoint) networkRegistryTargetPoint, channelName);
	}

	@Override
	public void sendToDimension(Object[] o, String channelName, int dimensionId) {
		sendToDimension(newPacket(o, channelName), dimensionId, channelName);
	}

	@Override
	public void sendToServer(Object[] o, String channelName) {
		Modchu_Debug.mDebug("Modchu_PacketMaster sendToServer channelName="+channelName);
		sendToServer(newPacket(o, channelName), channelName);
	}

	@Override
	public void sendToAll(Object message, String channelName) {
		boolean debug = false;
		if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster sendToAll");
		if (!channelsMap.containsKey(channelName)) {
			Modchu_Debug.lDebug("Modchu_PacketMaster sendToAll channelName !containsKey return. channelName="+channelName);
			return;
		}
		Modchu_Message modchu_message = message instanceof Modchu_Message ? (Modchu_Message) message : null;
		if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster sendToAll modchu_message="+modchu_message);
		if (modchu_message != null); else return;
		Object[] worlds = Modchu_AS.getObjectArray(Modchu_AS.FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers);
		if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster sendToAll worlds="+worlds);
		if (worlds != null) {
			for (Object world : worlds) {
				List list = Modchu_AS.getList(Modchu_AS.worldPlayerEntities, world);
				if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster sendToAll list="+list);
				if (list != null
						&& !list.isEmpty()) {
					for (Object entityPlayer : list) {
						Modchu_Message modchu_message2 = modchu_message.copy(modchu_message);
						if (debug) Modchu_Debug.lDebug("Modchu_PacketMaster sendToAll sendTo entityPlayer="+entityPlayer);
						sendTo(modchu_message2, entityPlayer, channelName);
					}
				}
			}
		}
/*
		EnumMap<Side, FMLEmbeddedChannel> channels = channelsMap.get(channelName);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
*/
	}

	@Override
	public void sendTo(Object message, Object entityPlayerMP, String channelName) {
		//Modchu_Debug.lDebug("Modchu_PacketMaster sendTo entityPlayerMP="+entityPlayerMP);
		if (!channelsMap.containsKey(channelName)) return;
		EnumMap<Side, FMLEmbeddedChannel> channels = channelsMap.get(channelName);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(entityPlayerMP);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
	}

	@Override
	public void sendToAllAround(Object message, Object networkRegistryTargetPoint, String channelName) {
		if (!channelsMap.containsKey(channelName)) return;
		EnumMap<Side, FMLEmbeddedChannel> channels = channelsMap.get(channelName);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(networkRegistryTargetPoint);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
	}

	@Override
	public void sendToDimension(Object message, int dimensionId, String channelName) {
		if (!channelsMap.containsKey(channelName)) return;
		EnumMap<Side, FMLEmbeddedChannel> channels = channelsMap.get(channelName);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(Integer.valueOf(dimensionId));
		((FMLEmbeddedChannel)channels.get(Side.SERVER)).writeAndFlush(message);
	}

	@Override
	public void sendToServer(Object message, String channelName) {
		if (!channelsMap.containsKey(channelName)) return;
		EnumMap<Side, FMLEmbeddedChannel> channels = channelsMap.get(channelName);
		((FMLEmbeddedChannel)channels.get(Side.CLIENT)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
		((FMLEmbeddedChannel)channels.get(Side.CLIENT)).writeAndFlush(message);
	}

	@Override
	public ByteBuf getBytes(Object[] o) {
		if (o != null
				&& o.length > 0); else return null;
		o = Modchu_Packet.sendStateProcessing(o);
		ByteBuf buf = newPacketBuffer(Unpooled.buffer());
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
					else if ((o1 instanceof Long)) byteBufOutputStream.writeLong(((Long) o1).longValue());
					else if ((o1 instanceof NBTTagCompound)) CompressedStreamTools.write((NBTTagCompound) o1, byteBufOutputStream);
					else if ((o1 instanceof Boolean)) byteBufOutputStream.writeByte((Boolean)o1 ? (byte) 1 : (byte) 0);
				} else {
					byteBufOutputStream.writeUTF("");
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

	@Override
	public Modchu_Message newPacket(Object[] o, String s) {
		return new Modchu_Message(getBytes(o), s);
	}

	@Override
	public Modchu_PacketHandler getPacketHander(String channelName) {
		return packetHandlerMap.get(channelName);
	}

	@Override
	public InputStream getPacketInputStream(Object packet) {
		return new ByteBufInputStream(((FMLProxyPacket) packet).payload());
	}

	@Override
	public Object[] sendStateProcessing(Object... o) {
		boolean debug = false;
		if (o != null
				&& o.length > 0) ;else return null;
		Object[] o2 = new Object[o.length * 2 + 1];
		for (int i = 0; i < o.length; i++) {
			if (debug) Modchu_Debug.mDebug("Modchu_PacketMaster sendStateProcessing o["+i+"]="+o[i]);
			o2[i * 2 + 1] = o[i];
			if (debug) {
				Modchu_Debug.mDebug("Modchu_PacketMaster sendStateProcessing o2["+(i * 2 + 1)+"]="+o2[i * 2 + 1]);
				Modchu_Debug.mDebug("Modchu_PacketMaster sendStateProcessing o["+i+"].getClass()="+(o[i] != null ? o[i].getClass() : null));
			}
			if (o[i] instanceof Integer) o2[i * 2] = Modchu_Packet.packet_Integer;
			else if (o[i] instanceof Float) o2[i * 2] = Modchu_Packet.packet_Float;
			else if (o[i] instanceof Double) o2[i * 2] = Modchu_Packet.packet_Double;
			else if (o[i] instanceof Long) o2[i * 2] = Modchu_Packet.packet_Long;
			else if (o[i] instanceof String) o2[i * 2] = Modchu_Packet.packet_String;
			else if (o[i] instanceof Enum) o2[i * 2] = Modchu_Packet.packet_Enum;
			else if (o[i] instanceof NBTTagCompound) o2[i * 2] = Modchu_Packet.packet_NBTTagCompound;
			else if (o[i] instanceof Boolean) o2[i * 2] = Modchu_Packet.packet_Boolean;
			else if (o[i] instanceof Byte) o2[i * 2] = Modchu_Packet.packet_Byte;
			else {
				if (debug) Modchu_Debug.mDebug("Modchu_PacketMaster sendStateProcessing else packet_String o["+i+"]="+o[i]);
				o2[i * 2] = Modchu_Packet.packet_String;
				if (o2[i * 2 + 1] != null); else o2[i * 2 + 1] = "null";
			}
		}
		o2[o2.length - 1] = Modchu_Packet.packet_end;
		if (debug) Modchu_Debug.mDebug("Modchu_PacketMaster sendStateProcessing o2["+(o2.length - 1)+"]="+o2[o2.length - 1]);
		return o2;
	}

	@Override
	public LinkedList receivePacketData(InputStream input) {
		ByteBufInputStream byteBufInput = (ByteBufInputStream) input;
		LinkedList list = new LinkedList();
		int i = 0;
		boolean breakFlag = false;
		try {
			do {
				byte by = Modchu_PacketManager.readByte(byteBufInput);
				Object o = null;
				if (by == Modchu_Packet.packet_Byte) {
					o = Modchu_PacketManager.readByte(byteBufInput);
				} else if (by == Modchu_Packet.packet_Integer) {
					o = Modchu_PacketManager.readInt(byteBufInput);
				} else if (by == Modchu_Packet.packet_Float) {
					o = Modchu_PacketManager.readFloat(byteBufInput);
				} else if (by == Modchu_Packet.packet_Double) {
					o = Modchu_PacketManager.readDouble(byteBufInput);
				} else if (by == Modchu_Packet.packet_Long) {
					o = Modchu_PacketManager.readLong(byteBufInput);
				} else if (by == Modchu_Packet.packet_String) {
					o = Modchu_PacketManager.readString(byteBufInput);
					if (o.equals("null")) {
						o = "";
					}
				} else if (by == Modchu_Packet.packet_Boolean) {
					byte by1 = Modchu_PacketManager.readByte(byteBufInput);
					o = by1 == 0 ? false : true;
				} else if (by == Modchu_Packet.packet_end) {
					breakFlag = true;
				}
				if (o != null) {
					if (o instanceof Byte
							&& (Byte) o == Modchu_Packet.packet_end) {
						break;
					}
					Modchu_Debug.mDebug("Modchu_PacketMaster receivePacketData i="+i+" o="+o+" o.getClass()="+o.getClass());
					list.add(o);
				}
				if (breakFlag) break;
				i++;
			} while(i < 128);
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

	private ByteBuf newPacketBuffer(ByteBuf byteBuf) {
		int version = Modchu_Main.getMinecraftVersion();
		return version > 179 ? (ByteBuf) Modchu_Reflect.newInstance("net.minecraft.network.PacketBuffer", new Class[]{ ByteBuf.class }, new Object[]{ byteBuf }) : byteBuf;
	}

}
