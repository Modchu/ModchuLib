package modchu.lib.forge.mc210;

import java.util.HashMap;

import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Modchu_Entity extends modchu.lib.forge.mc202_210.Modchu_Entity {

	public Modchu_Entity(World world) {
		super(world);
	}

	public Modchu_Entity(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void moveEntity(MoverType moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		if (master != null) master.moveEntity(moverType, p_70091_1_, p_70091_3_, p_70091_5_);
		else super.moveEntity(moverType, p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	public void superMoveEntity(Object moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		super.moveEntity((MoverType) moverType, p_70091_1_, p_70091_3_, p_70091_5_);
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
	public EnumActionResult superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.applyPlayerInteraction((EntityPlayer) entityPlayer, (Vec3d) vec3d, (EnumHand) enumHand);
	}

}
