package modchu.lib.forge.mc210;

import java.util.HashMap;

import net.minecraft.entity.MoverType;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class Modchu_EntityTameable extends modchu.lib.forge.mc210_212.Modchu_EntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
	}
	// 212~分離
	@Override
	public void moveEntity(MoverType moverType, double par1, double par3, double par5) {
		if (master != null) master.move(moverType, par1, par3, par5);
		else super.moveEntity(moverType, par1, par3, par5);
	}

	@Override
	public void superMove(Object moverType, double par1, double par3, double par5) {
		super.moveEntity((MoverType) moverType, par1, par3, par5);
	}
	// 190~210共通コピペ　↓
	@Override
	public void setAngles(float par1, float par2) {
		if (master != null) master.turn(par1, par2);
		else super.setAngles(par1, par2);
	}

	@Override
	public void superTurn(float par1, float par2) {
		super.setAngles(par1, par2);
	}

	@Override
	protected PathNavigate getNewNavigator(World world) {
		return (PathNavigate) (master != null ? master.createNavigator(world) : super.getNewNavigator(world));
	}

	@Override
	public PathNavigate superCreateNavigator(Object world) {
		return super.getNewNavigator((World) world);
	}

	@Override
	public void addChatMessage(ITextComponent iTextComponent) {
		if (master != null) master.sendMessage(iTextComponent);
		else super.addChatMessage(iTextComponent);
	}

	@Override
	public void superSendMessage(Object iTextComponent) {
		super.addChatMessage((ITextComponent) iTextComponent);
	}

	@Override
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return master != null ? master.canUseCommand(permLevel, commandName) : super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}
	// 190~210共通コピペ　↑

}
