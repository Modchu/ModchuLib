package modchu.lib.forge.mc210;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameableMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class Modchu_EntityLivingBase extends modchu.lib.forge.mc202_212.Modchu_EntityLivingBase {

	public Modchu_EntityLivingBase(World world) {
		super(world);
	}

	public Modchu_EntityLivingBase(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void moveEntity(MoverType moverType, double par1, double par3, double par5) {
		if (master != null) master.move(null, par1, par3, par5);
		else super.moveEntity(moverType, par1, par3, par5);
	}

	@Override
	public void superMove(Object moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		super.moveEntity((MoverType) moverType, p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return super.processInitialInteract((EntityPlayer) entityPlayer, (EnumHand) enumHand);
	}

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.applyPlayerInteraction((EntityPlayer) entityPlayer, (Vec3d) vec3d, (EnumHand) enumHand);
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