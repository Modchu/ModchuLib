package modchu.lib.characteristic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import modchu.lib.Modchu_Debug;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;

public class Modchu_PacketHandler {
	public FMLEventChannel packetChannel;
	public Object modInstance;
	public String channelName;

	public Modchu_PacketHandler(Object channel, String name, Object instance) {
		packetChannel = (FMLEventChannel) channel;
		channelName = name;
		modInstance = instance;
	}

	@SubscribeEvent
	public void onPacketData(FMLNetworkEvent.ServerCustomPacketEvent event) {
		EntityPlayerMP entityPlayer = ((NetHandlerPlayServer) event.handler).playerEntity;
		Modchu_Packet.onPacketData(event.packet, channelName, entityPlayer);
	}

	public static ByteBuf getBytes(Object[] o) {
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

	public void sendToAll(Object[] o, String s) {
		sendToAll(newFMLProxyPacket(o, s));
	}

	public void sendToAll(FMLProxyPacket pkt) {
		packetChannel.sendToAll(pkt);
	}

	public void sendTo(Object[] o, Object entityPlayerMP, String s) {
		sendTo(newFMLProxyPacket(o, s), entityPlayerMP);
	}

	public void sendTo(FMLProxyPacket pkt, Object entityPlayerMP) {
		if (entityPlayerMP instanceof EntityPlayerMP) {
			packetChannel.sendTo(pkt, (EntityPlayerMP) entityPlayerMP);
			Modchu_Debug.mDebug("Modchu_PacketHandler sendTo ok.");
		} else {
			Modchu_Debug.mDebug("Modchu_PacketHandler sendTo not entityPlayerMP="+entityPlayerMP);
		}
	}

	public void sendToAllAround(Object[] o, String s, Object networkRegistryTargetPoint) {
		sendToAllAround(newFMLProxyPacket(o, s), networkRegistryTargetPoint);
	}

	public void sendToAllAround(FMLProxyPacket pkt, Object networkRegistryTargetPoint) {
		if (networkRegistryTargetPoint instanceof TargetPoint) packetChannel.sendToAllAround(pkt, (TargetPoint) networkRegistryTargetPoint);
	}

	public void sendToDimension(Object[] o, String s, int dimensionId) {
		sendToDimension(newFMLProxyPacket(o, s), dimensionId);
	}

	public void sendToDimension(FMLProxyPacket pkt, int dimensionId) {
		packetChannel.sendToDimension(pkt, dimensionId);
	}

	public void sendToServer(Object[] o, String s) {
		sendToServer(newFMLProxyPacket(o, s));
	}

	public void sendToServer(FMLProxyPacket pkt) {
		packetChannel.sendToServer(pkt);
	}

	public FMLProxyPacket newFMLProxyPacket(Object[] o, String s) {
		return new FMLProxyPacket(getBytes(o), s);
	}
}