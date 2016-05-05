package modchu.lib.forge.mc172_190;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public abstract class Modchu_AbstractPacket {

	public abstract void encodeInto(ChannelHandlerContext channelHandlerContext, ByteBuf buf);
	public abstract void decodeInto(ChannelHandlerContext channelHandlerContext, ByteBuf buf);
	public abstract void handleClientSide(EntityPlayer entityPlayer);
	public abstract void handleServerSide(EntityPlayer entityPlayer);

}
