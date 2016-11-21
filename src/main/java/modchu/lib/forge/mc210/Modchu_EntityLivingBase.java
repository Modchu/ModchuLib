package modchu.lib.forge.mc210;

import java.util.HashMap;

import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Modchu_EntityLivingBase extends modchu.lib.forge.mc202_210.Modchu_EntityLivingBase {

	public Modchu_EntityLivingBase(World world) {
		super(world);
	}

	public Modchu_EntityLivingBase(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void moveEntity(MoverType moverType, double par1, double par3, double par5) {
		if (master != null) master.moveEntity(null, par1, par3, par5);
		else super.moveEntity(moverType, par1, par3, par5);
	}

	@Override
	public void superMoveEntity(Object moverType, double par1, double par3, double par5) {
		super.moveEntity((MoverType) moverType, par1, par3, par5);
	}

	@Override
	public boolean processInitialInteract(EntityPlayer entityPlayer, EnumHand enumHand) {
		return master != null ? master.processInitialInteract(entityPlayer, null, enumHand) : super.processInitialInteract(entityPlayer, enumHand);
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return super.processInitialInteract((EntityPlayer) entityPlayer, (EnumHand) enumHand);
	}

	@Override
	public EnumActionResult applyPlayerInteraction(EntityPlayer entityPlayer, Vec3d vec3d, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.applyPlayerInteraction(entityPlayer, vec3d, null, enumHand) : super.applyPlayerInteraction(entityPlayer, vec3d, enumHand));
	}

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.applyPlayerInteraction((EntityPlayer) entityPlayer, (Vec3d) vec3d, (EnumHand) enumHand);
	}

}