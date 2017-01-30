package modchu.lib.forge.mc210;

import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;

public class Modchu_EntityOtherPlayerMP extends modchu.lib.forge.mc210_212.Modchu_EntityOtherPlayerMP {

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super(map);
	}
	// 212~分離
	@Override
	public EnumActionResult func_190775_a(Entity entity, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.interactOn(entity, null, enumHand) : super.func_190775_a(entity, enumHand));
	}

	@Override
	public Object superInteractOn(Object entity, Object itemStack, Object enumHand) {
		return super.func_190775_a((Entity) entity, (EnumHand) enumHand);
	}

	@Override
	public void addChatComponentMessage(ITextComponent iTextComponent, boolean p_146105_2_) {
		if (master != null) master.sendStatusMessage(iTextComponent, p_146105_2_);
		else super.addChatComponentMessage(iTextComponent, p_146105_2_);
	}

	@Override
	public void superSendStatusMessage(Object iTextComponent, boolean p_146105_2_) {
		super.addChatComponentMessage((ITextComponent) iTextComponent, p_146105_2_);
	}

	@Override
	public void moveEntity(MoverType moverType, double x, double y, double z) {
		if (master != null) master.move(moverType, x, y, z);
		else super.moveEntity(moverType, x, y, z);
	}

	@Override
	public void superMove(Object moverType, double x, double y, double z) {
		super.moveEntity((MoverType) moverType, x, y, z);
	}
	// 190~210共通コピペ　↓
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

	public boolean supercanCommandSenderUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public void setAngles(float yaw, float pitch) {
		if (master != null) master.turn(yaw, pitch);
		else super.setAngles(yaw, pitch);
	}

	@Override
	public void superTurn(float yaw, float pitch) {
		super.setAngles(yaw, pitch);
	}

	@Override
	public boolean superCanUseCommand(int p_70003_1_, String p_70003_2_) {
		return super.canCommandSenderUseCommand(p_70003_1_, p_70003_2_);
	}
	// 190~210共通コピペ　↑

}
