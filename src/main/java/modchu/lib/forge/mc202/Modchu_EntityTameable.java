package modchu.lib.forge.mc202;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Modchu_EntityTameable extends modchu.lib.forge.mc202_210.Modchu_EntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
	}
	// 210~分離
	@Override
	public boolean processInteract(EntityPlayer entityPlayer, EnumHand enumHand, ItemStack itemStack) {
		return master != null ? master.processInteract(entityPlayer, enumHand, itemStack) : super.processInteract(entityPlayer, enumHand, itemStack);
	}

	@Override
	public boolean superProcessInteract(Object entityPlayer, Object enumHand, Object itemStack) {
		return super.processInteract((EntityPlayer) entityPlayer, (EnumHand) enumHand, (ItemStack) itemStack);
	}

	@Override
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.moveEntity(null, par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	@Override
	public void superMoveEntity(Object moverType, double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return super.processInitialInteract((EntityPlayer) entityPlayer, (ItemStack) itemStack, (EnumHand) enumHand);
	}

	@Override
	public EnumActionResult applyPlayerInteraction(EntityPlayer entityPlayer, Vec3d vec3d, ItemStack itemStack, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.applyPlayerInteraction(entityPlayer, vec3d, itemStack, enumHand) : super.applyPlayerInteraction(entityPlayer, vec3d, itemStack, enumHand));
	}

	@Override
	public EnumActionResult superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.applyPlayerInteraction((EntityPlayer) entityPlayer, (Vec3d) vec3d, (ItemStack) itemStack, (EnumHand) enumHand);
	}

}
