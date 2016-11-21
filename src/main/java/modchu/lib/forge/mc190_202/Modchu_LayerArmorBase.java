package modchu.lib.forge.mc190_202;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerArmorBase;
import modchu.lib.Modchu_ILayerArmorBaseMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Modchu_LayerArmorBase extends modchu.lib.forge.mc190_210.Modchu_LayerArmorBase {

	public Modchu_LayerArmorBase(HashMap<String, Object> map) {
		super(map);
	}
	// 210~分離
	@Override
	public ItemStack getItemStackFromSlot(EntityLivingBase entityLivingBase, EntityEquipmentSlot entityEquipmentSlot) {
		return (ItemStack) (master != null ? master.getItemStackFromSlot(entityLivingBase, entityEquipmentSlot) : super.getItemStackFromSlot(entityLivingBase, entityEquipmentSlot));
	}

	@Override
	public ItemStack superGetItemStackFromSlot(Object entityLivingBase, Object entityEquipmentSlot) {
		return super.getItemStackFromSlot((EntityLivingBase) entityLivingBase, (EntityEquipmentSlot) entityEquipmentSlot);
	}

}
