package modchu.lib.characteristic;

import modchu.lib.Modchu_Reflect;
import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.ItemRenderer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Minecraft;
import net.minecraft.src.ResourceLocation;

public class Modchu_ItemRendererBase extends ItemRenderer {

	// プライベート変数を使えるように
	public Minecraft mc;
	public ItemStack itemToRender;
	public float equippedProgress;
	public float prevEquippedProgress;
	protected static ResourceLocation texGlint;


	public Modchu_ItemRendererBase(Minecraft minecraft) {
		super(minecraft);

		mc = minecraft;
		try {
			// きらめきテクスチャの確保
			texGlint = (ResourceLocation)Modchu_Reflect.getPrivateValue(ItemRenderer.class, null, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Minecraft getMC() {
		return mc;
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
	public void renderItem(EntityLivingBase entityliving, ItemStack itemstack, int i) {
/*
		Item litem = itemstack.getItem();
		if (ModchuModel_ItemRenderManager.isEXRender(litem)) {
			// 特殊レンダラ
			ModchuModel_ItemRenderManager lii = ModchuModel_ItemRenderManager.getEXRender(litem);
			ModchuModel_Client.setTexture(lii.getRenderTexture(itemstack));
			GL11.glPushMatrix();
			boolean lflag = lii.renderItem(entityliving, itemstack, i);
			GL11.glPopMatrix();
			if (lflag) {
				if (itemstack != null && itemstack.hasEffect() && i == 0) {
					GL11.glDepthFunc(GL11.GL_EQUAL);
					GL11.glDisable(GL11.GL_LIGHTING);
					ModchuModel_Client.setTexture(texGlint);
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
					float var14 = 0.76F;
					GL11.glColor4f(0.5F * var14, 0.25F * var14, 0.8F * var14, 1.0F);
					float var15 = 0.125F;

					GL11.glPushMatrix();
					GL11.glMatrixMode(GL11.GL_TEXTURE);
					GL11.glLoadIdentity();
					GL11.glScalef(var15, var15, var15);
					float var16 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
					GL11.glTranslatef(var16, 0.0F, 0.0F);
					GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
					GL11.glMatrixMode(GL11.GL_MODELVIEW);
					lii.renderItem(entityliving, itemstack, 0);
//					renderItemIn2D(var6, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
					GL11.glPopMatrix();

					GL11.glPushMatrix();
					GL11.glMatrixMode(GL11.GL_TEXTURE);
					GL11.glLoadIdentity();
					GL11.glScalef(var15, var15, var15);
					var16 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
					GL11.glTranslatef(-var16, 0.0F, 0.0F);
					GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
					GL11.glMatrixMode(GL11.GL_MODELVIEW);
					lii.renderItem(entityliving, itemstack, 0);
//					renderItemIn2D(var6, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
					GL11.glPopMatrix();

					GL11.glMatrixMode(GL11.GL_TEXTURE);
					GL11.glLoadIdentity();
					GL11.glMatrixMode(GL11.GL_MODELVIEW);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_LIGHTING);
					GL11.glDepthFunc(GL11.GL_LEQUAL);
				}
				return;
			}
		}
*/
		super.renderItem(entityliving, itemstack, i);
	}

	@Override
	public void renderItemInFirstPerson(float f) {
		itemToRender = null;
		equippedProgress = 0.0F;
		prevEquippedProgress = 0.0F;

		try {
			// ローカル変数を確保
			itemToRender = (ItemStack)Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, 4);
			equippedProgress = (Float)Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, 5);
			prevEquippedProgress = (Float)Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, 6);
		} catch (Exception e) {
			e.printStackTrace();
		}
/*
		if (itemToRender != null) {
			Item litem = itemToRender.getItem();
			if (ModchuModel_ItemRenderManager.isEXRender(litem)) {
				if (ModchuModel_ItemRenderManager.getEXRender(litem).renderItemInFirstPerson(ModchuModel_Helper.mc.thePlayer, itemToRender, f)) {
					return;
				}
			}
		}
*/
		super.renderItemInFirstPerson(f);
	}


}
