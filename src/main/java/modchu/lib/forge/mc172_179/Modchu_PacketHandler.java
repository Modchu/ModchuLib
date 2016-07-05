package modchu.lib.forge.mc172_179;

import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Packet;
import modchu.lib.forge.mc172_202.Modchu_AbstractPacket;
import modchu.lib.forge.mc172_202.Modchu_Message;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;

@ChannelHandler.Sharable
public class Modchu_PacketHandler extends MessageToMessageCodec<FMLProxyPacket, Modchu_AbstractPacket> {
	public Object modInstance;
	public String channelName;

	public Modchu_PacketHandler(String name, Object instance) {
		Modchu_Debug.lDebug1("public Modchu_PacketHandler name="+name);
		channelName = name;
		modInstance = instance;
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, Modchu_AbstractPacket msg, List<Object> out) throws Exception {
		Modchu_Debug.mDebug("Modchu_PacketHandler encode channelName="+channelName);
		FMLProxyPacket proxyPacket = new FMLProxyPacket((ByteBuf) ((Modchu_Message) msg).byteBuf, (String)ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
		out.add(proxyPacket);
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg, List<Object> out) throws Exception {
		Modchu_Debug.mDebug("Modchu_PacketHandler decode channelName="+channelName);

		EntityPlayer player = null;
		switch (FMLCommonHandler.instance().getSide().ordinal()) {
		case 1:
			player = (EntityPlayer) Modchu_AS.get(Modchu_AS.minecraftThePlayer);
			break;
		case 2:
			INetHandler netHandler = (INetHandler)ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
			player = ((NetHandlerPlayServer)netHandler).playerEntity;
			break;
		}

		Modchu_Packet.onPacketData(msg, channelName, player);
	}

}