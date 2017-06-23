package modchu.lib.forge.mc212_220;

import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;

public abstract class Modchu_EntityOtherPlayerMP extends modchu.lib.forge.mc210_220.Modchu_EntityOtherPlayerMP {

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public EnumActionResult interactOn(Entity entity, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.interactOn(entity, null, enumHand) : super.interactOn(entity, enumHand));
	}

	@Override
	public Object superInteractOn(Object entity, Object itemStack, Object enumHand) {
		return super.interactOn((Entity) entity, (EnumHand) enumHand);
	}

	@Override
	public void sendStatusMessage(ITextComponent iTextComponent, boolean p_146105_2_) {
		if (master != null) master.sendStatusMessage(iTextComponent, p_146105_2_);
		else super.sendStatusMessage(iTextComponent, p_146105_2_);
	}

	@Override
	public void superSendStatusMessage(Object iTextComponent, boolean p_146105_2_) {
		super.sendStatusMessage((ITextComponent) iTextComponent, p_146105_2_);
	}

	@Override
	public void move(MoverType moverType, double x, double y, double z) {
		if (master != null) master.move(moverType, x, y, z);
		else super.move(moverType, x, y, z);
	}

	@Override
	public void superMove(Object moverType, double x, double y, double z) {
		super.move((MoverType) moverType, x, y, z);
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

	@Override
	public void turn(float yaw, float pitch) {
		if (master != null) master.turn(yaw, pitch);
		else super.turn(yaw, pitch);
	}

	@Override
	public void superTurn(float yaw, float pitch) {
		super.turn(yaw, pitch);
	}

}
