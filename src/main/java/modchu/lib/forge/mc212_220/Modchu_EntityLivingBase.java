package modchu.lib.forge.mc212_220;

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

public abstract class Modchu_EntityLivingBase extends modchu.lib.forge.mc202_220.Modchu_EntityLivingBase {

	public Modchu_EntityLivingBase(World world) {
		super(world);
	}

	public Modchu_EntityLivingBase(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void move(MoverType moverType, double par1, double par3, double par5) {
		if (master != null) master.move(null, par1, par3, par5);
		else super.move(moverType, par1, par3, par5);
	}

	@Override
	public void superMove(Object moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		super.move((MoverType) moverType, p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return super.processInitialInteract((EntityPlayer) entityPlayer, (EnumHand) enumHand);
	}

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.applyPlayerInteraction((EntityPlayer) entityPlayer, (Vec3d) vec3d, (EnumHand) enumHand);
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