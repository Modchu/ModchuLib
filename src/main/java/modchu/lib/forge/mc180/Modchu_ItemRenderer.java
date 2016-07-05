package modchu.lib.forge.mc180;import java.util.HashMap;import modchu.lib.Modchu_AS;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_IItemRenderer;import modchu.lib.Modchu_IItemRendererMaster;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Reflect;import net.minecraft.client.Minecraft;import net.minecraft.client.entity.AbstractClientPlayer;import net.minecraft.client.entity.EntityPlayerSP;import net.minecraft.client.renderer.GlStateManager;import net.minecraft.client.renderer.ItemRenderer;import net.minecraft.client.renderer.OpenGlHelper;import net.minecraft.client.renderer.RenderHelper;import net.minecraft.client.renderer.Tessellator;import net.minecraft.client.renderer.WorldRenderer;import net.minecraft.client.renderer.block.model.ItemCameraTransforms;import net.minecraft.client.renderer.entity.Render;import net.minecraft.client.renderer.entity.RenderPlayer;import net.minecraft.init.Items;import net.minecraft.item.EnumAction;import net.minecraft.item.ItemStack;import net.minecraft.util.BlockPos;import net.minecraft.util.MathHelper;import net.minecraft.util.ResourceLocation;import net.minecraft.world.storage.MapData;import net.minecraftforge.fml.relauncher.Side;import net.minecraftforge.fml.relauncher.SideOnly;import org.lwjgl.opengl.GL11;public class Modchu_ItemRenderer extends modchu.lib.forge.mc180_189.Modchu_ItemRenderer implements Modchu_IItemRenderer {	public Modchu_ItemRenderer(HashMap<String, Object> map) {		super(map);	}	protected void func_178095_a(AbstractClientPlayer p_178095_1_, float p_178095_2_, float p_178095_3_) {		float f2 = -0.3F * MathHelper.sin(MathHelper.sqrt_float(p_178095_3_) * (float) Math.PI);		float f3 = 0.4F * MathHelper.sin(MathHelper.sqrt_float(p_178095_3_) * (float) Math.PI * 2.0F);		float f4 = -0.4F * MathHelper.sin(p_178095_3_ * (float) Math.PI);		GlStateManager.translate(f2, f3, f4);		GlStateManager.translate(0.64000005F, -0.6F, -0.71999997F);		GlStateManager.translate(0.0F, p_178095_2_ * -0.6F, 0.0F);		GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);		float f5 = MathHelper.sin(p_178095_3_ * p_178095_3_ * (float) Math.PI);		float f6 = MathHelper.sin(MathHelper.sqrt_float(p_178095_3_) * (float) Math.PI);		GlStateManager.rotate(f6 * 70.0F, 0.0F, 1.0F, 0.0F);		GlStateManager.rotate(f5 * -20.0F, 0.0F, 0.0F, 1.0F);		Minecraft.getMinecraft().getTextureManager().bindTexture(p_178095_1_.getLocationSkin());		GlStateManager.translate(-1.0F, 3.6F, 3.5F);		GlStateManager.rotate(120.0F, 0.0F, 0.0F, 1.0F);		GlStateManager.rotate(200.0F, 1.0F, 0.0F, 0.0F);		GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);		GlStateManager.scale(1.0F, 1.0F, 1.0F);		GlStateManager.translate(5.6F, 0.0F, 0.0F);		Render render = Minecraft.getMinecraft().getRenderManager().getEntityRenderObject(Minecraft.getMinecraft().thePlayer);		RenderPlayer renderplayer = (RenderPlayer) render;		renderplayer.func_177138_b(Minecraft.getMinecraft().thePlayer);	}	protected void func_178097_a(AbstractClientPlayer p_178097_1_, float p_178097_2_, float p_178097_3_, float p_178097_4_) {		float f3 = -0.4F * MathHelper.sin(MathHelper.sqrt_float(p_178097_4_) * (float)Math.PI);		float f4 = 0.2F * MathHelper.sin(MathHelper.sqrt_float(p_178097_4_) * (float)Math.PI * 2.0F);		float f5 = -0.2F * MathHelper.sin(p_178097_4_ * (float)Math.PI);		GlStateManager.translate(f3, f4, f5);		float f6 = func_178100_c(p_178097_2_);		GlStateManager.translate(0.0F, 0.04F, -0.72F);		GlStateManager.translate(0.0F, p_178097_3_ * -1.2F, 0.0F);		GlStateManager.translate(0.0F, f6 * -0.5F, 0.0F);		GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);		GlStateManager.rotate(f6 * -85.0F, 0.0F, 0.0F, 1.0F);		GlStateManager.rotate(0.0F, 1.0F, 0.0F, 0.0F);		renderPlayerArms(p_178097_1_);		float f7 = MathHelper.sin(p_178097_4_ * p_178097_4_ * (float)Math.PI);		float f8 = MathHelper.sin(MathHelper.sqrt_float(p_178097_4_) * (float)Math.PI);		GlStateManager.rotate(f7 * -20.0F, 0.0F, 1.0F, 0.0F);		GlStateManager.rotate(f8 * -20.0F, 0.0F, 0.0F, 1.0F);		GlStateManager.rotate(f8 * -80.0F, 1.0F, 0.0F, 0.0F);		GlStateManager.scale(0.38F, 0.38F, 0.38F);		GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);		GlStateManager.rotate(0.0F, 1.0F, 0.0F, 0.0F);		GlStateManager.translate(-1.0F, -1.0F, 0.0F);		GlStateManager.scale(0.015625F, 0.015625F, 0.015625F);		Minecraft.getMinecraft().getTextureManager().bindTexture(RES_MAP_BACKGROUND);		Tessellator tessellator = Tessellator.getInstance();		WorldRenderer worldrenderer = tessellator.getWorldRenderer();		GL11.glNormal3f(0.0F, 0.0F, -1.0F);		worldrenderer.startDrawingQuads();		worldrenderer.addVertexWithUV(-7.0D, 135.0D, 0.0D, 0.0D, 1.0D);		worldrenderer.addVertexWithUV(135.0D, 135.0D, 0.0D, 1.0D, 1.0D);		worldrenderer.addVertexWithUV(135.0D, -7.0D, 0.0D, 1.0D, 0.0D);		worldrenderer.addVertexWithUV(-7.0D, -7.0D, 0.0D, 0.0D, 0.0D);		tessellator.draw();		MapData mapdata = Items.filled_map.getMapData(itemToRender, Minecraft.getMinecraft().theWorld);		if (mapdata != null)		{			Minecraft.getMinecraft().entityRenderer.getMapItemRenderer().func_148250_a(mapdata, false);		}	}	public void renderItemInFirstPersonNomal(float par1) {/*		equippedProgress = 0.0F;		prevEquippedProgress = 0.0F;		try {			equippedProgress = (Float) Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, 5);			prevEquippedProgress = (Float) Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, 6);		} catch (Exception e) {			e.printStackTrace();		}		float f1 = prevEquippedProgress + (equippedProgress - prevEquippedProgress) * par1;		EntityPlayerSP entityplayersp = Minecraft.getMinecraft().thePlayer;		float f2 = entityplayersp.prevRotationPitch + (entityplayersp.rotationPitch - entityplayersp.prevRotationPitch) * par1;		GL11.glPushMatrix();		GL11.glRotatef(f2, 1.0F, 0.0F, 0.0F);		GL11.glRotatef(entityplayersp.prevRotationYaw + (entityplayersp.rotationYaw - entityplayersp.prevRotationYaw) * par1, 0.0F, 1.0F, 0.0F);		RenderHelper.enableStandardItemLighting();		GL11.glPopMatrix();		float f3 = entityplayersp.prevRenderArmPitch + (entityplayersp.renderArmPitch - entityplayersp.prevRenderArmPitch) * par1;		float f4 = entityplayersp.prevRenderArmYaw + (entityplayersp.renderArmYaw - entityplayersp.prevRenderArmYaw) * par1;		GL11.glRotatef((entityplayersp.rotationPitch - f3) * 0.1F, 1.0F, 0.0F, 0.0F);		GL11.glRotatef((entityplayersp.rotationYaw - f4) * 0.1F, 0.0F, 1.0F, 0.0F);		ItemStack itemstack = Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem();		if (itemstack != null && itemstack.getItem() instanceof ItemCloth) {			GL11.glEnable(GL11.GL_BLEND);			OpenGlHelper.glBlendFunc(770, 771, 1, 0);		}		int i = Minecraft.getMinecraft().theWorld.getCombinedLight(new BlockPos(MathHelper.floor_double(entityplayersp.posX), MathHelper.floor_double(entityplayersp.posY), MathHelper.floor_double(entityplayersp.posZ)), 0);		int j = i % 65536;		int k = i / 65536;		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);		float f5;		float f6;		float f7;		if (itemstack != null) {			int l = itemstack.getItem().getColorFromItemStack(itemstack, 0);			f5 = (float) (l >> 16 & 255) / 255.0F;			f6 = (float) (l >> 8 & 255) / 255.0F;			f7 = (float) (l & 255) / 255.0F;			GL11.glColor4f(f5, f6, f7, 1.0F);		} else {			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);		}		float f9;		float f8;		float f10;		float f13;		RenderPlayer renderplayer;		Render render;		if (itemstack != null && itemstack.getItem() instanceof ItemMap) {			GL11.glPushMatrix();			f13 = 0.8F;			f5 = entityplayersp.getSwingProgress(par1);			f6 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f5 * (float) Math.PI);			f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, f5) * (float) Math.PI);			GL11.glTranslatef(-f7 * 0.4F, Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, f5) * (float) Math.PI * 2.0F) * 0.2F, -f6 * 0.2F);			f5 = 1.0F - f2 / 45.0F + 0.1F;			if (f5 < 0.0F) {				f5 = 0.0F;			}			if (f5 > 1.0F) {				f5 = 1.0F;			}			f5 = -Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f5 * (float) Math.PI) * 0.5F + 0.5F;			GL11.glTranslatef(0.0F, 0.0F * f13 - (1.0F - f1) * 1.2F - f5 * 0.5F + 0.04F, -0.9F * f13);			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);			GL11.glRotatef(f5 * -85.0F, 0.0F, 0.0F, 1.0F);			GL11.glEnable(GL12.GL_RESCALE_NORMAL);			Minecraft.getMinecraft().getTextureManager().bindTexture(entityplayersp.getLocationSkin());			for (int i1 = 0; i1 < 2; ++i1) {				int k1 = i1 * 2 - 1;				GL11.glPushMatrix();				GL11.glTranslatef(-0.0F, -0.6F, 1.1F * (float) k1);				GL11.glRotatef((float) (-45 * k1), 1.0F, 0.0F, 0.0F);				GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);				GL11.glRotatef(59.0F, 0.0F, 0.0F, 1.0F);				GL11.glRotatef((float) (-65 * k1), 0.0F, 1.0F, 0.0F);				render = Minecraft.getMinecraft().getRenderManager().getEntityRenderObject(Minecraft.getMinecraft().thePlayer);				renderplayer = (RenderPlayer) render;				f10 = 1.0F;				GL11.glScalef(f10, f10, f10);				renderplayer.func_177138_b(Minecraft.getMinecraft().thePlayer);				GL11.glPopMatrix();			}			f6 = entityplayersp.getSwingProgress(par1);			f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f6 * f6 * (float) Math.PI);			f8 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, f6) * (float) Math.PI);			GL11.glRotatef(-f7 * 20.0F, 0.0F, 1.0F, 0.0F);			GL11.glRotatef(-f8 * 20.0F, 0.0F, 0.0F, 1.0F);			GL11.glRotatef(-f8 * 80.0F, 1.0F, 0.0F, 0.0F);			f9 = 0.38F;			GL11.glScalef(f9, f9, f9);			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);			GL11.glTranslatef(-1.0F, -1.0F, 0.0F);			f10 = 0.015625F;			GL11.glScalef(f10, f10, f10);			Minecraft.getMinecraft().getTextureManager().bindTexture(RES_MAP_BACKGROUND);			Tessellator tessellator = Tessellator.getInstance();			GL11.glNormal3f(0.0F, 0.0F, -1.0F);			tessellator.getWorldRenderer().startDrawingQuads();			byte b0 = 7;			tessellator.getWorldRenderer().addVertexWithUV((double) (0 - b0), (double) (128 + b0), 0.0D, 0.0D, 1.0D);			tessellator.getWorldRenderer().addVertexWithUV((double) (128 + b0), (double) (128 + b0), 0.0D, 1.0D, 1.0D);			tessellator.getWorldRenderer().addVertexWithUV((double) (128 + b0), (double) (0 - b0), 0.0D, 1.0D, 0.0D);			tessellator.getWorldRenderer().addVertexWithUV((double) (0 - b0), (double) (0 - b0), 0.0D, 0.0D, 0.0D);			tessellator.draw();			IItemRenderer custom = MinecraftForgeClient.getItemRenderer(itemstack, FIRST_PERSON_MAP);			MapData mapdata = ((ItemMap) itemstack.getItem()).getMapData(itemstack, Minecraft.getMinecraft().theWorld);			if (custom == null) {				if (mapdata != null) {					Minecraft.getMinecraft().entityRenderer.getMapItemRenderer().func_148250_a(mapdata, false);				}			} else {				custom.renderItem(FIRST_PERSON_MAP, itemstack, Minecraft.getMinecraft().thePlayer, Minecraft.getMinecraft().getTextureManager(), mapdata);			}			GL11.glPopMatrix();		} else if (itemstack != null) {			GL11.glPushMatrix();			f13 = 0.8F;			if (entityplayersp.getItemInUseCount() > 0) {				EnumAction enumaction = itemstack.getItemUseAction();				if (enumaction == EnumAction.EAT || enumaction == EnumAction.DRINK) {					f6 = (float) entityplayersp.getItemInUseCount() - par1 + 1.0F;					f7 = 1.0F - f6 / (float) itemstack.getMaxItemUseDuration();					f8 = 1.0F - f7;					f8 = f8 * f8 * f8;					f8 = f8 * f8 * f8;					f8 = f8 * f8 * f8;					f9 = 1.0F - f8;					GL11.glTranslatef(0.0F, MathHelper.abs(Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f6 / 4.0F * (float) Math.PI) * 0.1F) * (float) ((double) f7 > 0.2D ? 1 : 0), 0.0F);					GL11.glTranslatef(f9 * 0.6F, -f9 * 0.5F, 0.0F);					GL11.glRotatef(f9 * 90.0F, 0.0F, 1.0F, 0.0F);					GL11.glRotatef(f9 * 10.0F, 1.0F, 0.0F, 0.0F);					GL11.glRotatef(f9 * 30.0F, 0.0F, 0.0F, 1.0F);				}			} else {				f5 = entityplayersp.getSwingProgress(par1);				f6 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f5 * (float) Math.PI);				f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, f5) * (float) Math.PI);				GL11.glTranslatef(-f7 * 0.4F, Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, f5) * (float) Math.PI * 2.0F) * 0.2F, -f6 * 0.2F);			}			GL11.glTranslatef(0.7F * f13, -0.65F * f13 - (1.0F - f1) * 0.6F, -0.9F * f13);			GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);			GL11.glEnable(GL12.GL_RESCALE_NORMAL);			f5 = entityplayersp.getSwingProgress(par1);			f6 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f5 * f5 * (float) Math.PI);			f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, f5) * (float) Math.PI);			GL11.glRotatef(-f6 * 20.0F, 0.0F, 1.0F, 0.0F);			GL11.glRotatef(-f7 * 20.0F, 0.0F, 0.0F, 1.0F);			GL11.glRotatef(-f7 * 80.0F, 1.0F, 0.0F, 0.0F);			f8 = 0.4F;			GL11.glScalef(f8, f8, f8);			float f11;			float f12;			if (entityplayersp.getItemInUseCount() > 0) {				EnumAction enumaction1 = itemstack.getItemUseAction();				if (enumaction1 == EnumAction.BLOCK) {					GL11.glTranslatef(-0.5F, 0.2F, 0.0F);					GL11.glRotatef(30.0F, 0.0F, 1.0F, 0.0F);					GL11.glRotatef(-80.0F, 1.0F, 0.0F, 0.0F);					GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);				} else if (enumaction1 == EnumAction.BOW) {					GL11.glRotatef(-18.0F, 0.0F, 0.0F, 1.0F);					GL11.glRotatef(-12.0F, 0.0F, 1.0F, 0.0F);					GL11.glRotatef(-8.0F, 1.0F, 0.0F, 0.0F);					GL11.glTranslatef(-0.9F, 0.2F, 0.0F);					f10 = (float) itemstack.getMaxItemUseDuration() - ((float) entityplayersp.getItemInUseCount() - par1 + 1.0F);					f11 = f10 / 20.0F;					f11 = (f11 * f11 + f11 * 2.0F) / 3.0F;					if (f11 > 1.0F) {						f11 = 1.0F;					}					if (f11 > 0.1F) {						GL11.glTranslatef(0.0F, Modchu_AS.getFloat(Modchu_AS.mathHelperSin, (f10 - 0.1F) * 1.3F) * 0.01F * (f11 - 0.1F), 0.0F);					}					GL11.glTranslatef(0.0F, 0.0F, f11 * 0.1F);					GL11.glRotatef(-335.0F, 0.0F, 0.0F, 1.0F);					GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);					GL11.glTranslatef(0.0F, 0.5F, 0.0F);					f12 = 1.0F + f11 * 0.2F;					GL11.glScalef(1.0F, 1.0F, f12);					GL11.glTranslatef(0.0F, -0.5F, 0.0F);					GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);					GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);				}			}			if (itemstack.getItem().shouldRotateAroundWhenRendering()) {				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);			}			if (itemstack.getItem().requiresMultipleRenderPasses()) {				renderItem(entityplayersp, itemstack, 0);				for (int x = 1; x < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); x++) {					int j1 = itemstack.getItem().getColorFromItemStack(itemstack, x);					f10 = (float) (j1 >> 16 & 255) / 255.0F;					f11 = (float) (j1 >> 8 & 255) / 255.0F;					f12 = (float) (j1 & 255) / 255.0F;					GL11.glColor4f(1.0F * f10, 1.0F * f11, 1.0F * f12, 1.0F);					renderItem(entityplayersp, itemstack, 1);				}			} else {				renderItem(entityplayersp, itemstack, 0);			}			GL11.glPopMatrix();		} else if (!entityplayersp.isInvisible()) {			master.renderItemInFirstPerson(par1, equippedProgress, prevEquippedProgress);		}		if (itemstack != null && itemstack.getItem() instanceof ItemCloth) {			GL11.glDisable(GL11.GL_BLEND);		}		GL11.glDisable(GL12.GL_RESCALE_NORMAL);		RenderHelper.disableStandardItemLighting();*/		float f1 = 1.0F - (prevEquippedProgress + (equippedProgress - prevEquippedProgress) * par1);		EntityPlayerSP entityplayersp = (EntityPlayerSP) Modchu_AS.get(Modchu_AS.minecraftThePlayer);		float f2 = entityplayersp.getSwingProgress(par1);		float f3 = entityplayersp.prevRotationPitch + (entityplayersp.rotationPitch - entityplayersp.prevRotationPitch) * par1;		float f4 = entityplayersp.prevRotationYaw + (entityplayersp.rotationYaw - entityplayersp.prevRotationYaw) * par1;		func_178101_a(f3, f4);		func_178109_a(entityplayersp);		func_178110_a((EntityPlayerSP) entityplayersp, par1);		GlStateManager.enableRescaleNormal();		GlStateManager.pushMatrix();		if (itemToRender != null) {			if (itemToRender.getItem() == Items.filled_map) {				func_178097_a(entityplayersp, f3, f1, f2);			} else if (entityplayersp.getItemInUseCount() > 0) {				EnumAction enumaction = itemToRender.getItemUseAction();				switch (SwitchEnumAction.field_178094_a[enumaction.ordinal()]) {				case 1:					transformFirstPersonItem(f1, 0.0F);					break;				case 2:				case 3:					func_178104_a(entityplayersp, par1);					transformFirstPersonItem(f1, 0.0F);					break;				case 4:					transformFirstPersonItem(f1, 0.0F);					func_178103_d();					break;				case 5:					transformFirstPersonItem(f1, 0.0F);					func_178098_a(par1, entityplayersp);				}			} else {				func_178105_d(f2);				transformFirstPersonItem(f1, f2);			}			renderItem(entityplayersp, itemToRender, ItemCameraTransforms.TransformType.FIRST_PERSON);		} else if (!entityplayersp.isInvisible()) {			//func_178095_a(entityplayersp, f1, f2);			master.renderItemInFirstPerson(par1, equippedProgress, prevEquippedProgress);		}		GlStateManager.popMatrix();		GlStateManager.disableRescaleNormal();		RenderHelper.disableStandardItemLighting();	}	protected void renderRightArm(RenderPlayer p_180534_1_) {		GlStateManager.pushMatrix();		GlStateManager.rotate(54.0F, 0.0F, 1.0F, 0.0F);		GlStateManager.rotate(64.0F, 1.0F, 0.0F, 0.0F);		GlStateManager.rotate(-62.0F, 0.0F, 0.0F, 1.0F);		GlStateManager.translate(0.25F, -0.85F, 0.75F);		p_180534_1_.func_177138_b(Minecraft.getMinecraft().thePlayer);		GlStateManager.popMatrix();	}	protected void func_178106_b(RenderPlayer p_178106_1_) {		GlStateManager.pushMatrix();		GlStateManager.rotate(92.0F, 0.0F, 1.0F, 0.0F);		GlStateManager.rotate(45.0F, 1.0F, 0.0F, 0.0F);		GlStateManager.rotate(41.0F, 0.0F, 0.0F, 1.0F);		GlStateManager.translate(-0.3F, -1.1F, 0.45F);		p_178106_1_.func_177139_c(Minecraft.getMinecraft().thePlayer);		GlStateManager.popMatrix();	}}