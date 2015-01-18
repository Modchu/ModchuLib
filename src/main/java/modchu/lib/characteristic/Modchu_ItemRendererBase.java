package modchu.lib.characteristic;

import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Modchu_ItemRendererBase extends ItemRenderer {
	public ItemStack itemToRender;
	public float equippedProgress;
	public float prevEquippedProgress;

	public Modchu_ItemRendererBase(Minecraft minecraft) {
		super(minecraft);
	}

	public ItemStack getItemToRender() {
		return itemToRender;
	}

	public float getEquippedProgress() {
		return equippedProgress;
	}

	public float getPrevEquippedProgress() {
		return prevEquippedProgress;
	}

	@Override
	public void renderItemInFirstPerson(float f) {
		itemToRender = null;
		equippedProgress = 0.0F;
		prevEquippedProgress = 0.0F;
		boolean flag = Modchu_Main.getMinecraftVersion() > 179;
		int i = flag ? 3 : 4;
		try {
			// ローカル変数を確保
			itemToRender = (ItemStack)Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, i);
			i++;
			equippedProgress = (Float)Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, i);
			i++;
			prevEquippedProgress = (Float)Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.renderItemInFirstPerson(f);
	}


}
