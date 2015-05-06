package modchu.lib.lmm.forge.mc152;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import modchu.lib.forge.mc152.Modchu_ItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.src.MMM_ItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

public class ModchuMMM_ItemRenderer extends MMM_ItemRenderer {
	public Modchu_ItemRenderer master;

	public ModchuMMM_ItemRenderer(HashMap<String, Object> map) {
		super(Minecraft.getMinecraft());
		Modchu_Debug.lDebug("ModchuMMM_ItemRenderer init");
		Object instance = map.containsKey("Object") ? map.get("Object") : null;
		//Modchu_Debug.lDebug("ModchuMMM_ItemRenderer init instance="+instance);
		master = instance instanceof Modchu_ItemRenderer ? (Modchu_ItemRenderer) instance : null;
		Modchu_Debug.lDebug("ModchuMMM_ItemRenderer init master="+master);
	}

	@Override
	public Minecraft getMC() {
		return super.getMC();
	}

	public Minecraft superGetMC() {
		return super.getMC();
	}

	@Override
	public ItemStack getItemToRender() {
		return super.getItemToRender();
	}

	public ItemStack superGetItemToRender() {
		return super.getItemToRender();
	}

	@Override
	public float getEquippedProgress() {
		return super.getEquippedProgress();
	}

	public float superGetEquippedProgress() {
		return super.getEquippedProgress();
	}

	@Override
	public float getPrevEquippedProgress() {
		return super.getPrevEquippedProgress();
	}

	public float superGetPrevEquippedProgress() {
		return super.getPrevEquippedProgress();
	}

	@Override
	public void renderItem(EntityLiving entityLiving, ItemStack itemStack, int i) {
		if (master != null) master.renderItem(entityLiving, itemStack, i);
		else super.renderItem(entityLiving, itemStack, i);
	}

	public void superRenderItem(Object entityLiving, Object itemStack, int i) {
		super.renderItem((EntityLiving) entityLiving, (ItemStack) itemStack, i);
	}

	@Override
	public void renderItemInFirstPerson(float f) {
		if (master != null) master.renderItemInFirstPerson(f);
		else super.renderItemInFirstPerson(f);
	}

	public void superRenderItemInFirstPerson(float f) {
		super.renderItemInFirstPerson(f);
	}

	@Override
	public void renderItem(EntityLiving entityLiving, ItemStack itemStack, int par3, ItemRenderType itemRenderType) {
		if (master != null) master.renderItem(entityLiving, itemStack, par3, itemRenderType);
		else super.renderItem(entityLiving, itemStack, par3, itemRenderType);
	}

	public void superRenderItem(Object entityLiving, Object itemStack, int par3, Object itemRenderType) {
		super.renderItem((EntityLiving) entityLiving, (ItemStack) itemStack, par3, (ItemRenderType) itemRenderType);
	}

	@Override
	public void renderOverlays(float par1) {
		if (master != null) master.renderOverlays(par1);
		else super.renderOverlays(par1);
	}

	public void superRenderOverlays(float par1) {
		super.renderOverlays(par1);
	}

	@Override
	public void updateEquippedItem() {
		if (master != null) master.updateEquippedItem();
		else super.updateEquippedItem();
	}

	public void superUpdateEquippedItem() {
		super.updateEquippedItem();
	}

	@Override
	public void resetEquippedProgress() {
		if (master != null) master.resetEquippedProgress();
		else super.resetEquippedProgress();
	}

	public void superResetEquippedProgress() {
		super.resetEquippedProgress();
	}

	@Override
	public void resetEquippedProgress2() {
		if (master != null) master.resetEquippedProgress2();
		else super.resetEquippedProgress2();
	}

	public void superResetEquippedProgress2() {
		super.resetEquippedProgress2();
	}

}
