package modchu.lib.forge.mc212_221;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_AS;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public abstract class Modchu_Entity extends modchu.lib.forge.mc210_221.Modchu_Entity {

	public Modchu_Entity(World world) {
		super(world);
	}

	public Modchu_Entity(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void move(MoverType moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		if (master != null) master.move(moverType, p_70091_1_, p_70091_3_, p_70091_5_);
		else super.move(moverType, p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	public void superMove(Object moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		super.move((MoverType) moverType, p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	public void turn(float p_70082_1_, float p_70082_2_) {
		if (master != null) master.turn(p_70082_1_, p_70082_2_);
		else super.turn(p_70082_1_, p_70082_2_);
	}

	@Override
	public void superTurn(float p_70082_1_, float p_70082_2_) {
		super.turn(p_70082_1_, p_70082_2_);
	}

	@Override
	public void sendMessage(ITextComponent iTextComponent) {
		if (master != null) master.sendMessage(iTextComponent);
		else super.sendMessage(iTextComponent);
	}

	@Override
	public void superSendMessage(Object iChatComponent) {
		super.sendMessage((ITextComponent) iChatComponent);
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
