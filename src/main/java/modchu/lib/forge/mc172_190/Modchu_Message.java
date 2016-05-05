package modchu.lib.forge.mc172_190;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import modchu.lib.Modchu_Debug;
import modchu.lib.forge.mc172_190.Modchu_AbstractPacket;
import net.minecraft.entity.player.EntityPlayer;

public class Modchu_Message extends Modchu_AbstractPacket {

	public Object byteBuf;
	public Object[] data;
	public String channelName;

	public Modchu_Message(Object[] o) {
		data = o;
	}
 
	public Modchu_Message(Object bytes, String s) {
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
	
	public Modchu_Message copy(Modchu_Message message) {
		return new Modchu_Message(message.byteBuf, message.channelName);
	}
}