package modchu.lib.forge.mc210;

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

public class Modchu_EntityOtherPlayerMP extends modchu.lib.forge.mc202_210.Modchu_EntityOtherPlayerMP {

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void openGuiHorseInventory(AbstractHorse entityHorse, IInventory iInventory) {
		if (master != null) master.openGuiHorseInventory(entityHorse, iInventory);
		else super.openGuiHorseInventory(entityHorse, iInventory);
	}

	@Override
	public EnumActionResult func_190775_a(Entity entity, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.interact(entity, null, enumHand) : super.func_190775_a(entity, enumHand));
	}

	@Override
	public Object superInteract(Object entity, Object itemStack, Object enumHand) {
		return super.func_190775_a((Entity) entity, (EnumHand) enumHand);
	}

	@Override
	public void addChatComponentMessage(ITextComponent iTextComponent, boolean p_146105_2_) {
		if (master != null) master.addChatComponentMessage(iTextComponent, p_146105_2_);
		else super.addChatComponentMessage(iTextComponent, p_146105_2_);
	}

	@Override
	public void superAddChatComponentMessage(Object iTextComponent, boolean p_146105_2_) {
		super.addChatComponentMessage((ITextComponent) iTextComponent, p_146105_2_);
	}

	@Override
	public void moveEntity(MoverType moverType, double x, double y, double z) {
		if (master != null) master.moveEntity(moverType, x, y, z);
		else super.moveEntity(moverType, x, y, z);
	}

	@Override
	public void superMoveEntity(Object moverType, double x, double y, double z) {
		super.moveEntity((MoverType) moverType, x, y, z);
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
