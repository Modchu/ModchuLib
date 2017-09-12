package modchu.lib.forge.mc212_221;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Reflect;
import net.minecraft.entity.MoverType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public abstract class Modchu_EntityTameable extends modchu.lib.forge.mc210_221.Modchu_EntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
	}

	// 212~分離
	@Override
	public void move(MoverType moverType, double par1, double par3, double par5) {
		if (master != null) master.move(moverType, par1, par3, par5);
		else super.move(moverType, par1, par3, par5);
	}

	@Override
	public void superMove(Object moverType, double par1, double par3, double par5) {
		super.move((MoverType) moverType, par1, par3, par5);
	}
	@Override
	public void turn(float par1, float par2) {
		if (master != null) master.turn(par1, par2);
		else super.turn(par1, par2);
	}

	@Override
	public void superTurn(float par1, float par2) {
		super.turn(par1, par2);
	}

	@Override
	protected PathNavigate createNavigator(World world) {
		return (PathNavigate) (master != null ? master.createNavigator(world) : super.createNavigator(world));
	}

	@Override
	public PathNavigate superCreateNavigator(Object world) {
		return super.createNavigator((World) world);
	}

	@Override
	public void sendMessage(ITextComponent iTextComponent) {
		if (master != null) master.sendMessage(iTextComponent);
		else super.sendMessage(iTextComponent);
	}

	@Override
	public void superSendMessage(Object iTextComponent) {
		super.sendMessage((ITextComponent) iTextComponent);
	}

	@Override
	public boolean canUseCommand(int permLevel, String commandName) {
		return master != null ? master.canUseCommand(permLevel, commandName) : super.canUseCommand(permLevel, commandName);
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return super.canUseCommand(permLevel, commandName);
	}

}
