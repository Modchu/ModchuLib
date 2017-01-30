package modchu.lib.forge.mc210;

import java.util.HashMap;

import net.minecraft.entity.MoverType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class Modchu_Entity extends modchu.lib.forge.mc210_212.Modchu_Entity {

	public Modchu_Entity(World world) {
		super(world);
	}

	public Modchu_Entity(HashMap<String, Object> map) {
		super(map);
	}
	// 212~分離
	@Override
	public void moveEntity(MoverType moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		if (master != null) master.move(moverType, p_70091_1_, p_70091_3_, p_70091_5_);
		else super.moveEntity(moverType, p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	public void superMove(Object moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		super.moveEntity((MoverType) moverType, p_70091_1_, p_70091_3_, p_70091_5_);
	}
	// 190~210共通コピペ　↓
	@Override
	public void setAngles(float p_70082_1_, float p_70082_2_) {
		if (master != null) master.turn(p_70082_1_, p_70082_2_);
		else super.setAngles(p_70082_1_, p_70082_2_);
	}

	@Override
	public void superTurn(float p_70082_1_, float p_70082_2_) {
		super.setAngles(p_70082_1_, p_70082_2_);
	}

	@Override
	public void addChatMessage(ITextComponent iTextComponent) {
		if (master != null) master.sendMessage(iTextComponent);
		else super.addChatMessage(iTextComponent);
	}

	@Override
	public void superSendMessage(Object iChatComponent) {
		super.addChatMessage((ITextComponent) iChatComponent);
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
