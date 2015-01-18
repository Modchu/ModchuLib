package modchu.lib.characteristic;

import java.util.Random;

import modchu.lib.Modchu_ModelRendererBase;
import modchu.lib.Modchu_Reflect;
import modchu.model.ModchuModel_ModelBaseMaster;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class Modchu_ClientBase {

	//public static ModchuModel_ItemRenderer itemRenderer;

	/**
	 * 初期化時実行コード
	 */
	public static void init() {
/*
		try {
			// TODO: バージョンアップ時には確認すること
			List lresourcePacks = (List)ModLoader.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), 63);
			lresourcePacks.add(new ModchuModel_ModOldResourcePack(mod_ModchuModel_ModchuModelLib.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
	}

	public static void setItemRenderer() {
/*
		if (itemRenderer == null) {
			itemRenderer = new ModchuModel_ItemRenderer(ModchuModel_Helper.mc);
		}
		if (!(ModchuModel_Helper.mc.entityRenderer.itemRenderer instanceof ModchuModel_ItemRenderer)) {
			mod_ModchuModel_ModchuModelLib.Debug("replace entityRenderer.itemRenderer.");
			ModchuModel_Helper.mc.entityRenderer.itemRenderer = itemRenderer;
		}
		if (!(RenderManager.instance.itemRenderer instanceof ModchuModel_ItemRenderer)) {
			mod_ModchuModel_ModchuModelLib.Debug("replace RenderManager.itemRenderer.");
			RenderManager.instance.itemRenderer = itemRenderer;
		}
*/
		// GUIの表示を変えるには常時監視が必要？
	}
/*
	public static void clientCustomPayload(NetClientHandler var1, Packet250CustomPayload var2) {
		// クライアント側の特殊パケット受信動作
		byte lmode = var2.data[0];
		int leid = 0;
		Entity lentity = null;
		if ((lmode & 0x80) != 0) {
			leid = ModchuModel_Helper.getInt(var2.data, 1);
			lentity = ModchuModel_Helper.getEntity(var2.data, 1, ModchuModel_Helper.mc.theWorld);
			if (lentity == null) return;
		}
		Debug("ModchuModel|Upd Clt Call[%2x:%d].", lmode, leid);

		switch (lmode) {
		case ModchuModel_Statics.Client_SetTextureIndex:
			// 問い合わせたテクスチャパックの管理番号を受け取る
			ModchuModel_TextureManager.instance.reciveFormServerSetTexturePackIndex(var2.data);
			break;
		case ModchuModel_Statics.Client_SetTexturePackName:
			// 管理番号に登録されているテクスチャパックの情報を受け取る
			ModchuModel_TextureManager.instance.reciveFromServerSetTexturePackName(var2.data);
			break;
		}
	}
*/
	public static void clientConnect(Object var1) {
		if (isIntegratedServerRunning()) {
			//Debug("Localmode: InitTextureList.");
			Modchu_TextureManagerBase.instance.initTextureList(true);
		} else {
			//Debug("Remortmode: ClearTextureList.");
			Modchu_TextureManagerBase.instance.initTextureList(false);
		}
	}
/*
	public static void clientDisconnect(NetClientHandler var1) {
		super.clientDisconnect(var1);
		Debug("Localmode: InitTextureList.");
		ModchuModel_TextureManager.initTextureList(true);
	}
*/
	public static void sendToServer(byte[] pData) {
/*
		ModLoader.clientSendPacket(new Packet250CustomPayload("ModchuModel|Upd", pData));
		Debug("ModchuModel|Upd:%2x:NOEntity", pData[0]);
*/
	}

	public static boolean isIntegratedServerRunning() {
		Object mc = Modchu_AS.get(Modchu_AS.minecraftGetMinecraft);
		return (Boolean) Modchu_Reflect.invokeMethod("Minecraft", "func_71387_A", "isIntegratedServerRunning", mc, -1);
	}

	/**
	 * Duoを使う時は必ずRender側のこの関数を置き換えること。
	 * @param par1EntityLiving
	 * @param par2
	 */
	public static void renderArrowsStuckInEntity(EntityLivingBase par1EntityLiving, float par2,
			Render pRender, ModchuModel_ModelBaseMaster pModel) {
		int lacount = par1EntityLiving.getArrowCountInEntity();

		if (lacount > 0) {
			EntityArrow larrow = new EntityArrow(par1EntityLiving.worldObj, par1EntityLiving.posX, par1EntityLiving.posY, par1EntityLiving.posZ);
			Random lrand = new Random(Modchu_AS.getInt(Modchu_AS.entityEntityID, par1EntityLiving));
			RenderHelper.disableStandardItemLighting();

			for (int var6 = 0; var6 < lacount; ++var6) {
				GL11.glPushMatrix();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				Modchu_ModelRendererBase var7 = pModel.getRandomModelBox(lrand);
				Modchu_ModelBoxBase var8 = (Modchu_ModelBoxBase) var7.cubeList.get(lrand.nextInt(var7.cubeList.size()));
				var7.postRender(0.0625F);
				float var9 = lrand.nextFloat();
				float var10 = lrand.nextFloat();
				float var11 = lrand.nextFloat();
				float var12 = (var8.posX1 + (var8.posX2 - var8.posX1) * var9) / 16.0F;
				float var13 = (var8.posY1 + (var8.posY2 - var8.posY1) * var10) / 16.0F;
				float var14 = (var8.posZ1 + (var8.posZ2 - var8.posZ1) * var11) / 16.0F;
				GL11.glTranslatef(var12, var13, var14);
				var9 = var9 * 2.0F - 1.0F;
				var10 = var10 * 2.0F - 1.0F;
				var11 = var11 * 2.0F - 1.0F;
				var9 *= -1.0F;
				var10 *= -1.0F;
				var11 *= -1.0F;
				float var15 = Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, var9 * var9 + var11 * var11);
				larrow.prevRotationYaw = larrow.rotationYaw = (float)(Math.atan2((double)var9, (double)var11) * 180.0D / Math.PI);
				larrow.prevRotationPitch = larrow.rotationPitch = (float)(Math.atan2((double)var10, (double)var15) * 180.0D / Math.PI);
				double var16 = 0.0D;
				double var18 = 0.0D;
				double var20 = 0.0D;
				float var22 = 0.0F;
				RenderManager renderManager = (RenderManager) Modchu_Reflect.getFieldObject(Render.class, "field_76990_c", "renderManager", pRender);
				renderManager.renderEntityWithPosYaw(larrow, var16, var18, var20, var22, par2);
				GL11.glPopMatrix();
			}

			RenderHelper.enableStandardItemLighting();
		}
	}
/*
	public static World getMCtheWorld() {
		if (ModchuModel_Helper.mc !=  null) {
			return ModchuModel_Helper.mc.theWorld;
		}
		return null;
	}
*/
	public static void setLightmapTextureCoords(int pValue) {
//		int ls = pValue % 65536;
//		int lt = pValue / 65536;
		int ls = pValue & 0xffff;
		int lt = pValue >>> 16;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,
				(float) ls / 1.0F, (float) lt / 1.0F);
	}

	public static void setTexture(ResourceLocation pRLocation) {
		if (pRLocation != null) {
			Object mc = Modchu_AS.get(Modchu_AS.minecraftGetMinecraft);
			TextureManager textureManager = (TextureManager) Modchu_Reflect.invokeMethod("Minecraft", "func_110434_K", "getTextureManager", mc, -1);
			textureManager.bindTexture(pRLocation);
		}
	}

	public static String getVersionString() {
		return Modchu_Version.getMinecraftVersionString();
	}

	public static void setTexture(Object o) {
		Modchu_AS.set(Modchu_AS.renderEngineBindTexture, o);
	}

}
