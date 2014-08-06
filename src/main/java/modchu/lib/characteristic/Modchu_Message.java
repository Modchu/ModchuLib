package modchu.lib.characteristic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import modchu.lib.Modchu_Debug;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class Modchu_Message extends Modchu_AbstractPacket {

	public ByteBuf byteBuf;
	public Object[] data;
	public String channelName;

	public Modchu_Message(Object[] o) {
		data = o;
	}
 
	public Modchu_Message(ByteBuf bytes, String s) {
		byteBuf = bytes;
		channelName = s;
		Modchu_Debug.mDebug("public Modchu_Message channelName="+channelName);
	}

	@Override
	public void encodeInto(ChannelHandlerContext channelHandlerContext, ByteBuf buf) {
		Modchu_Debug.mDebug("Modchu_Message encodeInto");
	}

	@Override
	public void decodeInto(ChannelHandlerContext channelHandlerContext, ByteBuf buf) {
		Modchu_Debug.mDebug("Modchu_Message decodeInto");
	}

	@Override
	public void handleClientSide(EntityPlayer entityPlayer) {
		Modchu_Debug.mDebug("Modchu_Message handleClientSide");
	}

	@Override
	public void handleServerSide(EntityPlayer entityPlayer) {
		Modchu_Debug.mDebug("Modchu_Message handleServerSide");
	}
}