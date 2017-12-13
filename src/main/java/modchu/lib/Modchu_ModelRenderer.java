package modchu.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.Modchu_GlStateManager;
import modchu.lib.Modchu_IEntityCapsBase;
import modchu.lib.Modchu_IModelBox;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_ModelPlateMaster;
import modchu.lib.Modchu_Reflect;
import modchu.model.multimodel.base.MultiModelBaseBiped;

public class Modchu_ModelRenderer extends Modchu_ModelRendererBase {

	public boolean angleFirst;
	protected boolean isVanillaItem;
	protected static Random rnd = new Random();
	public List<Object> boneChildModels = new ArrayList();
	public List<Object> boneSpecialChildModels = new ArrayList();
	protected ConcurrentHashMap<String, Object> freeVariableMap;
	public float initRotateAngleX;
	public float initRotateAngleY;
	public float initRotateAngleZ;
	public float initRotationPointX;
	public float initRotationPointY;
	public float initRotationPointZ;

	//SmartMoving共通
	public static final int XYZ = RotZYX;
	public static final int XZY = RotYZX;
	public static final int YXZ = RotZXY;
	public static final int YZX = RotXZY;
	public static final int ZXY = RotYXZ;
	public static final int ZYX = RotXYZ;
	public boolean ignoreRender;
	public boolean forceRender;
	public boolean ignoreBase;
	public boolean ignoreSuperRotation;
	public boolean fadeEnabled;
	public boolean fadeOffsetX;
	public boolean fadeOffsetY;
	public boolean fadeOffsetZ;
	public boolean fadeRotateAngleX;
	public boolean fadeRotateAngleY;
	public boolean fadeRotateAngleZ;
	public boolean fadeRotationPointX;
	public boolean fadeRotationPointY;
	public boolean fadeRotationPointZ;
	public Object previous;

	// ボツ
	public boolean upsideDownRotation = false;

/*//b181delete
	public List cubeList;
	public List childModels;
	protected TexturedQuad faces[];
*///b181delete
/*//b173delete
	public static float textureWidth;
	public static float textureHeight;
*///b173delete
	public Modchu_ModelRenderer(Object modelBase) {
		this(modelBase, 0, 0, (String)null, 1.0F, 1.0F, 1.0F);
	}

	public Modchu_ModelRenderer(Object modelBase, String s) {
		this(modelBase, 0, 0, s, 1.0F, 1.0F, 1.0F);
	}

	public Modchu_ModelRenderer(Object modelBase, int x, int y) {
		this(modelBase, x, y, (String)null, 1.0F, 1.0F, 1.0F);
	}

	public Modchu_ModelRenderer(Object modelBase, int x, int y, String s) {
		this(modelBase, x, y, s, 1.0F, 1.0F, 1.0F);
	}

	public Modchu_ModelRenderer(Object modelBase, int x, int y, float scaleX, float scaleY, float scaleZ) {
		this(modelBase, x, y, null, scaleX, scaleY, scaleZ);
	}

	public Modchu_ModelRenderer(Object modelBase, int x, int y, String s, float scaleX, float scaleY, float scaleZ) {
		super(modelBase, x, y, s);
		init(modelBase, x, y, s, scaleX, scaleY, scaleZ);
	}

	public void init(Object modelBase, int x, int y, String s, float sX, float sY, float sZ) {
		isRendering = true;
		Object baseModel = getBaseModel();
		List boxList = baseModel != null ? Modchu_AS.getList(Modchu_AS.modelBaseBoxList, baseModel) : null;
		if (boxList != null) boxList.add(this);
		if (baseModel != null) setTextureSize(Modchu_AS.getInt(Modchu_AS.modelBaseTextureWidth, baseModel), Modchu_AS.getInt(Modchu_AS.modelBaseTextureHeight, baseModel));

		rotatePriority = RotXYZ;
		adjust = true;
		matrix = BufferUtils.createFloatBuffer(16);
		isInvertX = false;

		scaleX = sX;
		scaleY = sY;
		scaleZ = sZ;
		rotatePriority = ZYX;
		angleFirst = false; // 変換を当てる順番
		adjust = true;
		matrix = BufferUtils.createFloatBuffer(16);
		isInvertX = false;
		initRotateAngleX = 0.0F;
		initRotateAngleY = 0.0F;
		initRotateAngleZ = 0.0F;
		initRotationPointX = 0.0F;
		initRotationPointY = 0.0F;
		initRotationPointZ = 0.0F;
/*//b181delete
		cubeList = new ArrayList();
*///b181delete
	}

	public Modchu_ModelRendererBase setInitRotationPoint(float pX, float pY, float pZ) {
		initRotationPointX = pX;
		initRotationPointY = pY;
		initRotationPointZ = pZ;
		return this;
	}

	public Modchu_ModelRendererBase setInitRotateAngle(float pX, float pY, float pZ) {
		initRotateAngleX = pX;
		initRotateAngleY = pY;
		initRotateAngleZ = pZ;
		return this;
	}

	@Override
	public Modchu_ModelRendererBase addCubeList(Modchu_IModelBox modchu_IModelBox) {
		if (upsideDownRotation) {
			Modchu_ModelRenderer modchu_ModelRenderer = new Modchu_ModelRenderer(getBaseModel(), getTextureOffsetX(), getTextureOffsetY());
			addChild(modchu_ModelRenderer);
		}
		return super.addCubeList(modchu_IModelBox);
	}

	public Modchu_ModelRenderer addPlate(float f, float f1, float f2, int i, int j, int k) {
		addPlate(f, f1, f2, i, j, k, 0.0F);
		return this;
	}

	public Modchu_ModelRenderer addPlate(float f, float f1, float f2, int i, int j, int k, float f3) {
		return addPlate(f, f1, f2, i, j, k, f3, 1.0F);
	}

	public Modchu_ModelRenderer addPlate(float f, float f1, float f2, int i, int j, int k, float f3, float f4) {
		addParts(Modchu_ModelPlateMaster.class, f, f1, f2, i, j, k, f3, f4);
		return this;
	}

	public Modchu_ModelRenderer addPlateFreeShape(float[][] vertex, float[][] vertexN, int px, int py) {
		float[][] vt = { { (float) textureOffsetX / textureWidth, ((float) textureOffsetY + 1) / textureHeight }, { (float) (textureOffsetX + 1) / textureWidth, (float) (textureOffsetY + 1) / textureHeight }, { (float) (textureOffsetX + 1) / textureWidth, (float) textureOffsetY / textureHeight }, { (float) textureOffsetX / textureWidth, (float) textureOffsetY / textureHeight } };
		addParts(Modchu_ModelPlateFreeShape.class, vertex, vt, vertexN, null, 0.0F);
		return this;
	}

	public Modchu_ModelRenderer addPlateFreeShape(float[][] vertex, float[][] texUV, float[][] vertexN) {
		addParts(Modchu_ModelPlateFreeShape.class, vertex, texUV, vertexN, new float[1], 0.0F);
		return this;
	}

	public Modchu_ModelRenderer addPlateFreeShape(float[][] var1, float[][] var2, float[][] var3, float[] var4) {
		addParts(Modchu_ModelPlateFreeShape.class, var1, var2, var3, var4, 0.0F);
		return this;
	}

	public Modchu_ModelRenderer addBall(float var1, float var2, float var3, float var4, float var5, float var6) {
		return makeBall(var1, var2, var3, var4, var5, var6);
	}

	public void renderItemsHead(String s, Object pModelMulti, Modchu_IEntityCapsBase entityCaps, float scale, int addSupport) {
		Object itemStack = entityCaps.getCapsValue(entityCaps.caps_HeadMount, 9);
		Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);

		renderItems(s, entity, true, null, itemStack, scale, addSupport, Modchu_Main.getMinecraftVersion() > 179 ? Modchu_AS.getEnum(Modchu_AS.itemCameraTransformsTransformTypeHEAD) : null);
	}

	public void renderItemsHead(String s, Object pModelMulti, Modchu_IEntityCapsBase entityCaps, Object itemStack, float scale, int addSupport) {
		Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);

		renderItems(s, entity, true, null, itemStack, scale, addSupport, Modchu_Main.getMinecraftVersion() > 179 ? Modchu_AS.getEnum(Modchu_AS.itemCameraTransformsTransformTypeHEAD) : null);
	}

	public boolean renderItems(String s, Object pModelMulti, Modchu_IEntityCapsBase entityCaps, boolean pRealBlock, int pIndex) {
		return renderItems(s, pModelMulti, entityCaps, pRealBlock, 1.0F, pIndex);
	}

	public boolean renderItems(String s, Object pModelMulti, Modchu_IEntityCapsBase entityCaps, boolean pRealBlock, float scale, int pIndex) {
		Object[] itemstacks = Modchu_CastHelper.ObjectArray(Modchu_EntityCapsHelper.getCapsValue(entityCaps, entityCaps.caps_Items));
		if (itemstacks == null) return false;
		Object[] enumActions = Modchu_CastHelper.ObjectArray(Modchu_EntityCapsHelper.getCapsValue(entityCaps, entityCaps.caps_Actions));
		Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);

		//Modchu_Debug.mDebug("Modchu_ModelRenderer renderItems() pIndex="+pIndex);
		//Modchu_Debug.mDebug("Modchu_ModelRenderer renderItems() itemstacks="+itemstacks);
		//Modchu_Debug.mDebug("Modchu_ModelRenderer renderItems() itemstacks["+pIndex+"]="+(itemstacks.length > pIndex ? itemstacks[pIndex] : null));
		Object itemStack = itemstacks != null
				&& itemstacks.length > pIndex ? itemstacks[pIndex] : null;
		renderItems(s, entity, pRealBlock, enumActions != null
				&& enumActions.length > pIndex ? enumActions[pIndex] : null, itemStack, scale, pIndex);
		return true;
	}

	public void renderItems(String s, Object entityLiving, boolean pRealBlock, Object enumAction, Object itemStack1, float scale, int pIndex, int addSupport, Enum type) {
		if (entityLiving != null); else return;
		switch (addSupport) {
		case 0:
		case 1:
		case 2:
			renderDecoBlock(entityLiving, pRealBlock, enumAction, itemStack1, scale, addSupport);
			return;
		}
		renderItems(s, entityLiving, pRealBlock, enumAction, itemStack1, scale, pIndex, type);
	}

	public void renderItems(String s, Object entityLiving, boolean pRealBlock, Object enumAction, Object itemstack, float scale, int pIndex) {
		renderItems(s, entityLiving, pRealBlock, enumAction, itemstack, scale, pIndex, Modchu_Main.getMinecraftVersion() > 179 ? Modchu_AS.getEnum(Modchu_AS.itemCameraTransformsTransformTypeTHIRD_PERSON) : null);
	}

	public void renderItems(String s, Object entityLiving, boolean pRealBlock, Object enumAction, Object itemStack1, float scale, int pIndex, Enum type) {
		String eventName = "Modchu_ModelRendererRenderItems".concat(s);
		boolean isCanceled = false;
		if (Modchu_Main.modchuLibEvent(eventName)) {
			boolean flag = true;
			Object[] o = Modchu_Main.modchuLibEvent(eventName, new Object[]{ this, entityLiving, pRealBlock, itemStack1, scale, pIndex, type });
			if (o != null) {
				if (o.length > 0) isCanceled = Modchu_CastHelper.Boolean(o[0]);
				else if (o.length > 2) entityLiving = o[2];
				else if (o.length > 3) pRealBlock = Modchu_CastHelper.Boolean(o[3]);
				else if (o.length > 4) itemStack1 = o[4];
				else if (o.length > 5) scale = Modchu_CastHelper.Float(o[5]);
				else if (o.length > 6) pIndex = Modchu_CastHelper.Int(o[6]);
				else if (o.length > 7) type = (Enum) o[7];
			}
		}
		//scale = 4.0F;
		//Modchu_Debug.mDebug("Modchu_ModelRenderer renderItems scale="+scale);
		if (isCanceled) return;
		if (itemStack1 != null
				&& entityLiving != null); else {
			//if (itemstack != null); else Modchu_Debug.mDebug("Modchu_ModelRenderer renderItems itemstack == null.");
			//if (entityLiving != null); else Modchu_Debug.mDebug("Modchu_ModelRenderer renderItems entityLiving == null.");
			return;
		}
		//Modchu_Debug.mDebug("Modchu_ModelRenderer renderItems itemStack="+itemStack1);
		int version = Modchu_Main.getMinecraftVersion();
		if ((itemStack != null
				&& !itemStack.equals(itemStack1))
				| itemStack == null) {
			itemStack = itemStack1;
			Object item = Modchu_AS.get(Modchu_AS.itemStackGetItem, itemStack1);
			String s1 = item.getClass().getName();
			//Modchu_Debug.mDebug("Modchu_ModelRenderer renderItems s1="+s1);
			int itemID = version < 170 ? Modchu_AS.getInt(Modchu_AS.itemItemID, item) : -1;
			//Modchu_Debug.mdDebug("itemID="+itemID);
			isVanillaItem = (Modchu_Main.isForge
					&& s1.startsWith("net.minecraft.item"))
					| (!Modchu_Main.isForge
							&& (itemID < 449 | (itemID > 2255 && itemID < 2268)));
		}
		if (version < 180) {
			oldRenderItems_mc179(entityLiving, pRealBlock, enumAction, itemStack1, scale);
			return;
		}
		Enum enum1 = Modchu_AS.getEnum(Modchu_AS.itemCameraTransformsTransformTypeHEAD);
		//Modchu_Debug.mDebug("Modchu_ModelRenderer renderItems type="+type);
		//Modchu_Debug.mDebug("Modchu_ModelRenderer renderItems enum1="+enum1);
		if (version < 190
				| enum1 == type) {
			oldRenderItems_mc189(entityLiving, pRealBlock, enumAction, itemStack1, scale, type);
			return;
		}
		//Modchu_GlStateManager.pushAttrib();
		Modchu_GlStateManager.pushMatrix();
		//Modchu_GlStateManager.translate(0.05F, -0.5F, 0.0F);
		Modchu_GlStateManager.translate(-0.1F, -0.5F, 0.05F);
		Modchu_GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
		Modchu_GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
		renderItemsOption(entityLiving, pRealBlock, enumAction, itemStack1, scale);

		Enum enumactionBlock = Modchu_AS.getEnum(Modchu_AS.enumActionBlock);
		//Modchu_Debug.mDebug("Modchu_ModelRenderer enumactionBlock="+enumactionBlock);
		if (enumAction == enumactionBlock) {

			Modchu_GlStateManager.rotate(4.2F, 1.0F, 0.0F, 0.0F);
			Modchu_GlStateManager.rotate(-12.4F, 0.0F, 1.0F, 0.0F);
			Modchu_GlStateManager.rotate(-18F, 0.0F, 0.0F, 1.0F);

/*
			Modchu_GlStateManager.rotate(Modchu_Debug.debaf1, 1.0F, 0.0F, 0.0F);
			Modchu_GlStateManager.rotate(Modchu_Debug.debaf2, 0.0F, 1.0F, 0.0F);
			Modchu_GlStateManager.rotate(Modchu_Debug.debaf3, 0.0F, 0.0F, 1.0F);
			Modchu_Debug.mdDebug(""+Modchu_Debug.debaf1+" "+Modchu_Debug.debaf2+" "+Modchu_Debug.debaf3+" ");
*/
			Modchu_GlStateManager.translate(-0.15F, 0.0F, 0.08F);
			//Modchu_GlStateManager.translate(Modchu_Debug.debaf1, Modchu_Debug.debaf2, Modchu_Debug.debaf3);
			//Modchu_Debug.mdDebug(""+Modchu_Debug.debaf1+" "+Modchu_Debug.debaf2+" "+Modchu_Debug.debaf3+" ");
		}
		boolean flag = pIndex == 1;
		Modchu_GlStateManager.translate(flag ? -0.0625F : -0.1125F, 0.125F, -0.625F);
		Modchu_GlStateManager.scale(scale, scale, scale);
		type = flag ? Modchu_AS.getEnum("net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType", "THIRD_PERSON_LEFT_HAND") : Modchu_AS.getEnum(Modchu_AS.itemCameraTransformsTransformTypeTHIRD_PERSON);
		//Modchu_Debug.mDebug("type="+type);
		Object itemRenderer = Modchu_AS.get("Minecraft", "getItemRenderer", Modchu_AS.get(Modchu_AS.minecraftGetMinecraft));
		Modchu_AS.set("ItemRenderer", "renderItemSide", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase"), Modchu_Reflect.loadClass("ItemStack"), Modchu_Reflect.loadClass("net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType"), boolean.class }, itemRenderer, new Object[]{ entityLiving, itemStack1, type, flag });

/*
		ItemRenderer itemRenderer = (ItemRenderer) Modchu_AS.get("Minecraft", "getItemRenderer", Modchu_AS.get(Modchu_AS.minecraftGetMinecraft));
		Item item = (Item) Modchu_AS.get(Modchu_AS.itemStackGetItem, itemstack);
		Block block = Block.getBlockFromItem(item);
		GlStateManager.pushMatrix();
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		boolean flag1 = renderItem.shouldRenderItemIn3D((ItemStack) itemstack)
				&& block != null && block.getBlockLayer() == BlockRenderLayer.TRANSLUCENT;

		if (flag1) GlStateManager.depthMask(false);
		IBakedModel ibakedmodel = renderItem.getItemModelWithOverrides((ItemStack) itemstack, ((Entity) entityLiving).worldObj, (EntityLivingBase) entityLiving);

		if (item != null) {
			TextureManager textureManager = (TextureManager) Modchu_AS.get(Modchu_AS.minecraftGetTextureManager);

			textureManager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
			textureManager.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			GlStateManager.enableRescaleNormal();
			GlStateManager.alphaFunc(516, 0.1F);
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

			GlStateManager.pushMatrix();
			// TODO: check if negative scale is a thing
			ibakedmodel = net.minecraftforge.client.ForgeHooksClient.handleCameraTransforms(ibakedmodel, (TransformType) type, flag);
			//Modchu_Debug.mDebug("type="+type);

			renderItem.renderItem((ItemStack) itemstack, ibakedmodel);
			GlStateManager.cullFace(GlStateManager.CullFace.BACK);
			GlStateManager.popMatrix();
			GlStateManager.disableRescaleNormal();
			GlStateManager.disableBlend();

			textureManager.bindTexture(TextureMap.LOCATION_MISSING_TEXTURE);
			textureManager.getTexture(TextureMap.LOCATION_MISSING_TEXTURE).restoreLastBlurMipmap();

		}

		if (flag1) GlStateManager.depthMask(true);

		GlStateManager.popMatrix();
*/
		Modchu_GlStateManager.popMatrix();
		Object textureManager = Modchu_AS.get(Modchu_AS.minecraftGetTextureManager);
		Object LOCATION_MISSING_TEXTURE = Modchu_AS.get("TextureMap", "LOCATION_MISSING_TEXTURE");
		Modchu_AS.set(Modchu_AS.textureManagerBindTexture, textureManager, LOCATION_MISSING_TEXTURE);
		if (LOCATION_MISSING_TEXTURE != null) Modchu_AS.set("ITextureObject", "restoreLastBlurMipmap", Modchu_AS.get(Modchu_AS.textureManagerGetTexture, LOCATION_MISSING_TEXTURE));
		//Modchu_GlStateManager.popAttrib();
		//Modchu_GlStateManager.depthMask(false);
		//Modchu_GlStateManager.depthMask(true);
		//Modchu_GlStateManager.enableRescaleNormal();
		//Modchu_GlStateManager.disableBlend();
		//Modchu_GlStateManager.cullFace(Modchu_GlStateManager.CullFace.BACK);
		//Modchu_GlStateManager.disableDepth();
		//Modchu_GlStateManager.enableDepth();
		//Modchu_GlStateManager.enableCull();
		//Modchu_GlStateManager.enableTexture2D();
		//Object render = Modchu_Main.getRender(entityLiving);
		//loadBlockTexture(render);

	}

	protected void oldRenderItems_mc189(Object entityLiving, boolean pRealBlock, Object enumAction, Object itemstack, float scale, Enum type) {
		// アイテムのレンダリング
		int version = Modchu_Main.getMinecraftVersion();
		Modchu_GlStateManager.pushMatrix();
		Modchu_GlStateManager.enableAlpha();
		Modchu_GlStateManager.enableBlend();
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		int tempTextureStateTextureName = 0;
		if (version > 179) {
			int activeTextureUnit = Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("net.minecraft.client.renderer.GlStateManager", "field_179162_o", "activeTextureUnit"));
			Object[] textureState = Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject("net.minecraft.client.renderer.GlStateManager", "field_179174_p", "textureState"));
			if (textureState != null
					&& activeTextureUnit < textureState.length
					&& textureState[activeTextureUnit] != null) {
				tempTextureStateTextureName = (Integer) Modchu_Reflect.getFieldObject(textureState[activeTextureUnit].getClass(), "field_179059_b", "textureName", textureState[activeTextureUnit]);
				Modchu_GlStateManager.bindTexture(tempTextureStateTextureName + 1);
			}
		}
		Object item = Modchu_AS.get(Modchu_AS.itemStackGetItem, itemstack);
		Object block = Modchu_AS.get(Modchu_AS.getBlockItemStack, itemstack);
		boolean skullFlag = Modchu_AS.getBoolean(Modchu_AS.isSkull, item);
		// アイテムの種類による表示位置の補正
		boolean isChild = Modchu_AS.getBoolean(Modchu_AS.entityLivingBaseIsChild, entityLiving);
		renderItemsOption(entityLiving, pRealBlock, enumAction, itemstack, scale);
		if (type == Modchu_AS.getEnum(Modchu_AS.itemCameraTransformsTransformTypeHEAD)) {
			boolean flag = Modchu_Reflect.loadClass("EntityVillager").isInstance(entityLiving)
					| Modchu_Reflect.loadClass("EntityZombie").isInstance(entityLiving)
					&& Modchu_AS.getBoolean(Modchu_AS.entityZombieIsVillager, entityLiving);
			float f7;
			if (!flag
					&& isChild) {
				f7 = 2.0F;
				float f8 = 1.4F;
				Modchu_GlStateManager.scale(f8 / f7, f8 / f7, f8 / f7);
				if (adjust) Modchu_GlStateManager.translate(0.0F, 16.0F * 0.0625F, 0.0F);
			}
			Modchu_GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

			if (Modchu_Reflect.loadClass("ItemBlock").isInstance(item)) {
				Modchu_GlStateManager.enableCull();
				if (Modchu_AS.getBoolean(Modchu_AS.isCamouflage, block)) Modchu_GlStateManager.disableAlpha();
				//Modchu_AS.set(Modchu_AS.renderManagerItemRendererRenderItem, entityLiving, itemstack, type);
				//Object blockRendererDispatcher = Modchu_AS.get(Modchu_AS.minecraftGetBlockRendererDispatcher);
				Object render = Modchu_Main.getRender(entityLiving);
				if (render != null); else return;
				Modchu_AS.set(Modchu_AS.renderBindTexture, render, Modchu_AS.get(Modchu_AS.textureMapLocationBlocksTexture));
				//Modchu_RenderEngine.instance.bindTexture(Modchu_AS.get(Modchu_AS.textureMapLocationBlocksTexture));
				//Modchu_Debug.mDebug1("renderItems textureMapLocationBlocksTexture="+Modchu_AS.get(Modchu_AS.textureMapLocationBlocksTexture));
				int metadata = Modchu_AS.getInt(Modchu_AS.itemGetMetadata, item, Modchu_AS.getInt(Modchu_AS.itemStackGetMetadata, itemstack));
				//Modchu_Debug.mDebug("renderItems metadata="+metadata);
				//Modchu_Debug.mDebug("renderItems block.getClass()="+block.getClass());

				Object theWorld = Modchu_AS.get(Modchu_AS.minecraftWorld);
				double posX = Modchu_AS.getDouble(Modchu_AS.entityPosX);
				double posY = Modchu_AS.getDouble(Modchu_AS.entityPosY);
				double posZ = Modchu_AS.getDouble(Modchu_AS.entityPosZ);
				int i1 = Modchu_AS.getInt(Modchu_AS.blockColorMultiplier, block, theWorld, Modchu_AS.get(Modchu_AS.newBlockPos, posX, posY, posZ), 0);
				//Modchu_Debug.mDebug("renderItems i1="+i1);
				if (Modchu_AS.getBoolean(Modchu_AS.entityRendererAnaglyphEnable)) i1 = Modchu_AS.getInt(Modchu_AS.textureUtilAnaglyphColor, i1);
				float r = (i1 >> 16 & 255) / 255.0F;
				float g = (i1 >> 8 & 255) / 255.0F;
				float b = (i1 & 255) / 255.0F;
				Modchu_GlStateManager.color(r, g, b, 1.0F);
				//Modchu_Debug.mDebug("renderItems r="+r+" g="+g+" b="+b);
				Class BlockDoublePlant = Modchu_Reflect.loadClass("BlockDoublePlant", -1);
				Class ItemDoublePlant = Modchu_Reflect.loadClass("ItemDoublePlant", -1);
				if ((BlockDoublePlant != null
						&& BlockDoublePlant.isInstance(block))
						| (ItemDoublePlant != null
								&& ItemDoublePlant.isInstance(item))) {
					scale = scale * 1.1875F * 1.3F;
					Modchu_GlStateManager.scale(scale, scale, scale);
					f7 = 0.625F;
					Modchu_GlStateManager.scale(f7, -f7, -f7);
					if (flag) {
						if (adjust) Modchu_GlStateManager.translate(0.0F, 0.1875F, 0.0F);
					}
					if (metadata == 0) {
						try {
							Object iBlockState = Modchu_AS.get(Modchu_AS.iBlockStateWithProperty, block, Modchu_AS.get(Modchu_AS.blockDoublePlantHALF), Modchu_Reflect.getEnum("net.minecraft.block.BlockDoublePlant$EnumBlockHalf", "LOWER"));
							iBlockState = Modchu_AS.get(Modchu_AS.iBlockStateWithProperty, iBlockState, Modchu_AS.get(Modchu_AS.blockDoublePlantVARIANT), Modchu_Reflect.getEnum("net.minecraft.block.BlockDoublePlant$EnumPlantType", "SUNFLOWER"));
							Modchu_GlStateManager.rotate(90F, 0.0F, 1.0F, 0.0F);
							if (adjust) Modchu_GlStateManager.translate(-0.5F, 0.0F, 0.5F);
							blockRender(block, iBlockState, 1.0F, true);
							if (adjust) Modchu_GlStateManager.translate(0.0F, 0.8F, 1.0F);
							//Modchu_GlStateManager.rotate(-180.0F, 0.0F, 1.0F, 0.0F);
							iBlockState = Modchu_AS.get(Modchu_AS.iBlockStateWithProperty, block, Modchu_AS.get(Modchu_AS.blockDoublePlantHALF), Modchu_Reflect.getEnum("net.minecraft.block.BlockDoublePlant$EnumBlockHalf", "UPPER"));
							blockRender(block, iBlockState, 1.0F, true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						Object iBlockState = Modchu_AS.get(Modchu_AS.iBlockStateWithProperty, block, Modchu_AS.get(Modchu_AS.blockDoublePlantHALF), Modchu_Reflect.getEnum("net.minecraft.block.BlockDoublePlant$EnumBlockHalf", "LOWER"));
						iBlockState = Modchu_AS.get(Modchu_AS.iBlockStateWithProperty, iBlockState, Modchu_AS.get(Modchu_AS.blockDoublePlantVARIANT), Modchu_Reflect.getEnum("net.minecraft.block.BlockDoublePlant$EnumPlantType", metadata, 1));
						if (adjust) Modchu_GlStateManager.translate(-0.55F, 0.0F, 0.5F);
						blockRender(block, iBlockState, 1.0F, true);
						//Modchu_GlStateManager.rotate(90F, 0.0F, 1.0F, 0.0F);
						if (adjust) Modchu_GlStateManager.translate(0.0F, 0.8F, 1.0F);
						//Modchu_GlStateManager.rotate(-180.0F, 0.0F, 1.0F, 0.0F);
						blockRender(block, iBlockState, 1.0F, true);
					}
				} else {
					scale = scale * 1.1875F;
					Modchu_GlStateManager.scale(scale, scale, scale);
					if (adjust) {
						if (Modchu_AS.getBoolean(Modchu_AS.isPlanter, block)) {
							Modchu_GlStateManager.translate(-0.26F, 0.0F, 0.4F);
							Modchu_GlStateManager.rotate(12F, 0F, 1F, 0);
						} else {
							Modchu_GlStateManager.translate(-0.32F, 0F, 0.3F);
						}
					}
					Modchu_GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
					f7 = 0.625F;
					Modchu_GlStateManager.scale(f7, -f7, -f7);
					if (flag) {
						if (adjust) Modchu_GlStateManager.translate(0.0F, 0.1875F, 0.0F);
					}

					Object iBlockState = Modchu_AS.get(Modchu_AS.blockGetStateFromMeta, block, metadata);
					if (iBlockState != null); else iBlockState = Modchu_AS.get(Modchu_AS.blockGetDefaultState, block);
					//Modchu_Debug.mDebug("renderItems iBlockState="+iBlockState);
					blockRender(block, iBlockState, 1.0F, true);
				}
			} else if (Modchu_AS.get(Modchu_AS.getItem, "skull").getClass().isInstance(item)) {
				f7 = 1.1875F;
				Modchu_GlStateManager.scale(f7, -f7, -f7);
				if (flag) {
					if (adjust) Modchu_GlStateManager.translate(0.0F, 0.0625F, 0.0F);
				}
				Object gameprofile = null;
				if (Modchu_AS.getBoolean(Modchu_AS.itemStackHasTagCompound, itemstack)) {
					Object nbttagcompound = Modchu_AS.get(Modchu_AS.itemStackGetTagCompound, itemstack);
					if (Modchu_AS.getBoolean(Modchu_AS.nbtTagCompoundHasKey, "SkullOwner", 10)) {
						gameprofile = Modchu_AS.get(Modchu_AS.nbtUtilReadGameProfileFromNBT, Modchu_AS.get(Modchu_AS.nbtTagCompoundGetCompoundTag, nbttagcompound, "SkullOwner"));
					} else if (Modchu_AS.getBoolean(Modchu_AS.nbtTagCompoundHasKey, nbttagcompound, "SkullOwner", 8)) {
						gameprofile = Modchu_AS.get(Modchu_AS.tileEntitySkullUpdateGameprofile, Modchu_Reflect.newInstance("GameProfile", new Class[]{ UUID.class, String.class }, new Object[]{ null, Modchu_AS.get(Modchu_AS.nbtTagCompoundGetString, nbttagcompound, "SkullOwner") }));
						Modchu_AS.set(Modchu_AS.nbtTagCompoundSetTag, nbttagcompound, "SkullOwner", Modchu_AS.get(Modchu_AS.nBTUtilWriteGameProfile, Modchu_Reflect.newInstance("NBTTagCompound"), gameprofile));
					}
				}
				Modchu_GlStateManager.scale(scale, scale, scale);
				float f = 0.0F;
				Modchu_AS.set(Modchu_AS.tileEntitySkullRendererRenderSkull, -0.5F, 0.0F, -0.5F, Modchu_AS.getEnum(Modchu_AS.enumFacingUP), 180.0F, Modchu_AS.get(Modchu_AS.itemStackGetMetadata, itemstack), gameprofile, -1, f);
			}
			renderItemsEndSetting(tempTextureStateTextureName);
			return;
		} else {
			if (adjust) Modchu_GlStateManager.translate(0.075F, -0.5F, 0.2F);
			if (isChild) {
				float f7 = 0.5F;
				if (adjust) Modchu_GlStateManager.translate(0.0F, 0.625F, 0.0F);
				Modchu_GlStateManager.rotate(-20.0F, -1.0F, 0.0F, 0.0F);
				Modchu_GlStateManager.scale(f7, f7, f7);
			}
			if (adjust) Modchu_GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
			if (Modchu_Reflect.loadClass("EntityPlayer").isInstance(entityLiving)
					&& Modchu_AS.get(Modchu_AS.entityPlayerFishEntity, entityLiving) != null) itemstack = Modchu_Reflect.newInstance("ItemStack", new Class[]{ Modchu_Reflect.loadClass("Item"), int.class }, new Object[]{ Modchu_AS.get(Modchu_AS.getItem, "fishing_rod"), 0 });
			float var6 = 1.0F;
			if (Modchu_Reflect.loadClass("ItemBlock").isInstance(item)) {
				int renderType = Modchu_AS.getInt(Modchu_AS.blockGetRenderType, Modchu_AS.get(Modchu_AS.blockGetBlockFromItem, item));
				//Modchu_Debug.mDebug("renderItems renderType="+renderType);
				if (renderType == 2) {
					if (adjust) Modchu_GlStateManager.translate(0.0F, 0.1875F, -0.3125F);
					Modchu_GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
					Modchu_GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
					float f8 = 0.375F;
					Modchu_GlStateManager.scale(-f8, -f8, f8);
				} else {
					if (adjust) Modchu_GlStateManager.translate(0.0F, 0.1F, 0.0F);
				}
			} else if (item == Modchu_AS.get(Modchu_AS.getItem, "bow")) {
				var6 = 0.975F;
				Modchu_GlStateManager.translate(0.0F, 0.0F, -0.2F);

				//Modchu_GlStateManager.rotate(-20.0F, 0.0F, 1.0F, 0.0F);
				Modchu_GlStateManager.scale(var6, var6, var6);
				Modchu_GlStateManager.rotate(0.0F, 1.0F, 0.0F, 0.0F);
				//Modchu_GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
			} else if (Modchu_AS.getBoolean(Modchu_AS.itemIsFull3D, item)) {
				var6 = 0.625F;

				if (Modchu_AS.getBoolean(Modchu_AS.itemShouldRotateAroundWhenRendering, item)) {
					Modchu_GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
					Modchu_GlStateManager.translate(0.0F, -0.125F, 0.0F);
				}

				if (enumAction == Modchu_AS.getEnum(Modchu_AS.enumActionBlock)) {
					//Modchu_GlStateManager.translate(Modchu_Debug.debaf1, Modchu_Debug.debaf2, Modchu_Debug.debaf3);
					Modchu_GlStateManager.translate(-0.2F, 0.0F, -0.2F);
					//Modchu_GlStateManager.rotate(Modchu_Debug.debaf2, 0.0F, 1.0F, 0.0F);
					//Modchu_GlStateManager.rotate(Modchu_Debug.debaf1, 1.0F, 0.0F, 0.0F);
					//Modchu_GlStateManager.rotate(Modchu_Debug.debaf3, 0.0F, 0.0F, 1.0F);
					//Modchu_Debug.mdDebug("x="+Modchu_Debug.debaf1+" y="+Modchu_Debug.debaf2+" z="+Modchu_Debug.debaf3);
					Modchu_GlStateManager.rotate(-25.0F, 0.0F, 1.0F, 0.0F);
					Modchu_GlStateManager.rotate(-25.0F, 1.0F, 0.0F, 0.0F);
					Modchu_GlStateManager.rotate(-60.0F, 0.0F, 0.0F, 1.0F);
				} else {
					Modchu_GlStateManager.translate(0.0F, 0.0F, -0.2F);
				}
				//Modchu_GlStateManager.translate(0.0F, 0.1875F, 0.1F);
				//Modchu_GlStateManager.scale(var6, var6, var6);
				//Modchu_GlStateManager.rotate(-100.0F, 1.0F, 0.0F, 0.0F);
				//Modchu_GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
			} else {
				//Modchu_Debug.mDebug("Modchu_ModelRenderer renderItems else");
				var6 = 0.625F;
				Modchu_GlStateManager.translate(0.0F, 0.1F, 0.0F);
				//Modchu_GlStateManager.translate(Modchu_Debug.debaf1, Modchu_Debug.debaf2, Modchu_Debug.debaf3);
				//Modchu_Debug.dDebug("x="+Modchu_Debug.debaf1+" y="+Modchu_Debug.debaf2+" z="+Modchu_Debug.debaf3);
				Modchu_GlStateManager.scale(var6, var6, var6);
				//Modchu_GlStateManager.rotate(60.0F, 0.0F, 0.0F, 1.0F);
				//Modchu_GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
				//Modchu_GlStateManager.rotate(20.0F, 0.0F, 0.0F, 1.0F);
			}

			if (skullFlag) {
				if (adjust) Modchu_GlStateManager.translate(0.0F, 0.1F, 0.0F);
			}
		}
		//int itemDamage = itemstack != null ? Modchu_AS.getInt(Modchu_AS.itemStackGetItemDamage, itemstack) : -1;
		// アイテムに色付け
		int renderPasses = Modchu_AS.getBoolean(Modchu_AS.itemRequiresMultipleRenderPasses, item) ? 1 : 0;
		type = Modchu_AS.getEnum(Modchu_AS.itemCameraTransformsTransformTypeTHIRD_PERSON);
		Modchu_GlStateManager.scale(scale, scale, scale);
		//if (version > 179) Modchu_GlStateManager.bindTexture(9999);
		for (int j = 0; j <= renderPasses; j++) {
			if (!Modchu_Main.isSSP
					| renderPasses > 0) {
				int k = Modchu_AS.getInt(Modchu_AS.itemGetColorFromItemStack, item, itemstack, j);
				float f15 = (k >> 16 & 0xff) / 255F;
				float f17 = (k >> 8 & 0xff) / 255F;
				float f19 = (k & 0xff) / 255F;
				Modchu_GlStateManager.color(f15, f17, f19, 1.0F);
			}
			Modchu_AS.set(Modchu_AS.renderManagerItemRendererRenderItem, entityLiving, itemstack, version > 179 ? type : j);
			//Modchu_Debug.mDebug("renderManagerItemRendererRenderItem itemstack="+itemstack);
			//render.renderManager.itemRenderer.renderItem(entityLiving, itemstack, j);
		}
		//Modchu_AS.set(Modchu_AS.renderBindTexture, render, Modchu_AS.get(Modchu_AS.textureMapLocationBlocksTexture));
		renderItemsEndSetting(tempTextureStateTextureName);
	}

	protected void oldRenderItems_mc179(Object entityLiving, boolean pRealBlock, Object enumAction, Object itemstack, float scale) {
		Object render = Modchu_Main.getRender(entityLiving);
		if (render != null); else return;
		// アイテムのレンダリング
		Modchu_GlStateManager.pushMatrix();
		int version = Modchu_Main.getMinecraftVersion();
		Object item = Modchu_AS.get(Modchu_AS.itemStackGetItem, itemstack);
		Object block = Modchu_AS.get(Modchu_AS.getBlockItemStack, itemstack);
		boolean skullFlag = Modchu_AS.getBoolean(Modchu_AS.isSkull, item);
		Object renderBlocks = Modchu_AS.get(Modchu_AS.renderRenderBlocks, render);
		// アイテムの種類による表示位置の補正
		if (adjust) {
			float var6;
			renderItemsOption(entityLiving, pRealBlock, enumAction, itemstack, scale);
			float sx = scale;
			float sy = scale;
			float sz = scale;
			if (pRealBlock
					&& block != null) {
				if (skullFlag) {
					scale = 1.0625F * scale;
					sx = scale;
					sy = -scale;
					sz = -scale;
					Modchu_GlStateManager.scale(sx, sy, sz);
				} else {
					float f2 = 0.625F;
					scale = f2 * scale;
					Modchu_GlStateManager.translate(0F, -scale * 0.495F, 0F);
					if (Modchu_AS.getBoolean(Modchu_AS.isPlanter, block)) {
						Modchu_GlStateManager.rotate(12F, 0F, 1F, 0);
					} else {
//-@-125
						Modchu_GlStateManager.rotate(90F, 0.0F, 1.0F, 0.0F);
//@-@125
						// 125deleteModchu_GlStateManager.rotate(180F, 0.0F, 1.0F, 0.0F);
					}
					Modchu_GlStateManager.scale(scale, -scale, -scale);
				}
			} else {
//-@-132
				boolean flag2 = version > 169
						| (version < 170
								&& Modchu_AS.getInt(Modchu_AS.itemStackItemID, itemstack) < 256);
				if (pRealBlock
						&& skullFlag) {
					scale = 1.0625F * scale;
					sx = scale;
					sy = -scale;
					sz = -scale;
				} else
				//@-@132
				if (flag2
						&& block != null
						&& Modchu_AS.getBoolean(Modchu_AS.renderBlocksRenderItemIn3d, renderBlocks, Modchu_AS.getInt(Modchu_AS.blockGetRenderType, block))) {
					var6 = 0.5F;
//					Modchu_GlStateManager.translate(0.0F, 0.1875F, -0.3125F);
					Modchu_GlStateManager.translate(0.0F, 0.1875F, -0.2125F);
					var6 *= 0.75F;
					Modchu_GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
					Modchu_GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
					Modchu_GlStateManager.scale(var6, -var6, var6);
				} else if (item == Modchu_AS.get(Modchu_AS.getItem, "bow")) {
					var6 = 0.625F;
					Modchu_GlStateManager.translate(-0.05F, 0.125F, 0.3125F);
					Modchu_GlStateManager.rotate(-20.0F, 0.0F, 1.0F, 0.0F);
					Modchu_GlStateManager.scale(var6, -var6, var6);
					Modchu_GlStateManager.rotate(-100.0F, 1.0F, 0.0F, 0.0F);
					Modchu_GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
				} else if (Modchu_AS.getBoolean(Modchu_AS.itemIsFull3D, item)) {
					var6 = 0.625F;
					//Modchu_Debug.Debug("Modchu_ModelRenderer oldRenderItems_mc179 itemIsFull3D");

					if (Modchu_AS.getBoolean(Modchu_AS.itemShouldRotateAroundWhenRendering, item)) {
						//Modchu_Debug.Debug("Modchu_ModelRenderer oldRenderItems_mc179 itemIsFull3D itemShouldRotateAroundWhenRendering");
						Modchu_GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
						Modchu_GlStateManager.translate(0.0F, -0.125F, 0.0F);
					}

					if (enumAction == Modchu_AS.getEnum(Modchu_AS.enumActionBlock)) {
						//Modchu_Debug.dDebug("Enum=enumActionBlock");
						Modchu_GlStateManager.translate(0.05F, 0.0F, -0.1F);
						Modchu_GlStateManager.rotate(-50.0F, 0.0F, 1.0F, 0.0F);
						Modchu_GlStateManager.rotate(-10.0F, 1.0F, 0.0F, 0.0F);
						Modchu_GlStateManager.rotate(-60.0F, 0.0F, 0.0F, 1.0F);
					} else {
						if (!isVanillaItem) {
							var6 = var6 * 0.75F;
							renderItemsModOption(entityLiving, pRealBlock, enumAction, itemstack, scale);
						}// else {
							//Modchu_Debug.debugStringClear();
							//Modchu_Debug.dDebug("isVanillaItem");
						//}
					}

					Modchu_GlStateManager.translate(0.0F, 0.1875F, 0.1F);
					Modchu_GlStateManager.scale(var6, -var6, var6);
					Modchu_GlStateManager.rotate(-100.0F, 1.0F, 0.0F, 0.0F);
					Modchu_GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
				} else {
					var6 = 0.375F;
					Modchu_GlStateManager.translate(0.15F, 0.15F, -0.05F);
					//	Modchu_GlStateManager.translate(0.25F, 0.1875F, -0.1875F);
					Modchu_GlStateManager.scale(var6, var6, var6);
					Modchu_GlStateManager.rotate(60.0F, 0.0F, 0.0F, 1.0F);
					Modchu_GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
					Modchu_GlStateManager.rotate(20.0F, 0.0F, 0.0F, 1.0F);
				}
				Modchu_GlStateManager.scale(sx, sy, sz);
			}
		}
//-@-132
		int itemDamage = Modchu_AS.getInt(Modchu_AS.itemStackGetItemDamage, itemstack);
		//Modchu_Debug.mDebug("renderItems pRealBlock="+pRealBlock+" skullFlag="+skullFlag);
		if (pRealBlock
				&& skullFlag) {
			Modchu_GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			Object var6 = null;
			Object tagCompound = Modchu_AS.get(Modchu_AS.itemStackGetTagCompound, itemstack);
			if (version > 172) {
				if (Modchu_AS.getBoolean(Modchu_AS.itemStackHasTagCompound, itemstack)) {
					if (Modchu_AS.getBoolean(Modchu_AS.nbtTagCompoundHasKey, tagCompound, "SkullOwner", 10)) {
						var6 = Modchu_AS.get(Modchu_AS.nbtUtilReadGameProfileFromNBT, Modchu_AS.get(Modchu_AS.nbtTagCompoundGetCompoundTag, "SkullOwner"));
					} else {
						String s1 = Modchu_AS.getString(Modchu_AS.nbtTagCompoundGetString, tagCompound, "SkullOwner");
						if (Modchu_AS.getBoolean(Modchu_AS.nbtTagCompoundHasKey, tagCompound, "SkullOwner", 8)
							&& !Modchu_AS.getBoolean(Modchu_AS.stringUtilsIsNullOrEmpty, s1)) {
							var6 = Modchu_Reflect.newInstance("com.mojang.authlib.GameProfile", new Class[]{ UUID.class, String.class }, new Object[]{ null, s1 });
						}
					}
				}
			} else {
				if (Modchu_AS.getBoolean(Modchu_AS.itemStackHasTagCompound, itemstack)
						&& Modchu_AS.getBoolean(Modchu_AS.nbtTagCompoundHasKey, tagCompound, "SkullOwner")) {
					var6 = Modchu_AS.getString(Modchu_AS.nbtTagCompoundGetString, tagCompound, "SkullOwner");
				}
			}
			Modchu_AS.set(Modchu_AS.tileEntitySkullRendererRenderSkull, -0.5F, 0.0F, -0.5F, 1, 180.0F, itemDamage, var6);
		} else
//@-@132
		if (pRealBlock
				&& block != null) {
// 152deleteString s1 = "/terrain.png";
/*//147delete
			if (Modchu_Main.isForge) {
				s1 = (String) Modchu_Reflect.invokeMethod(Item.class, "getTextureFile", Item.itemsList[itemstack.itemID]);
				//Modchu_Debug.Debug("isForge render.func_110776_a s1="+s1);
			}
*///147delete
			// 152deleterender.func_110776_a(s1);
			loadBlockTexture(render);
			GL11.glEnable(GL11.GL_CULL_FACE);
			Class BlockDoublePlant = Modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.loadClass("net.minecraft.block.BlockDoublePlant", -1) : null;
			if (BlockDoublePlant != null
					&& BlockDoublePlant.isInstance(block)) {
				float f1 = 1.8F;
				Modchu_GlStateManager.scale(f1, f1, f1);
				int x = (int) Modchu_AS.getDouble(Modchu_AS.entityPosX, entityLiving);
				int y = (int) Modchu_AS.getDouble(Modchu_AS.entityPosY, entityLiving);
				int z = (int) Modchu_AS.getDouble(Modchu_AS.entityPosZ, entityLiving);
				renderBlockDoublePlant(renderBlocks, block, itemDamage, 0.0D, x, y, z);
			} else {
				//Modchu_Debug.mDebug("renderItems renderBlocksRenderBlockAsItem block="+block);
				//Modchu_Debug.mDebug("renderItems renderBlocksRenderBlockAsItem itemDamage="+itemDamage);
				Modchu_AS.set(Modchu_AS.renderBlocksRenderBlockAsItem, renderBlocks, block, itemDamage, 1.0F);
			}
			GL11.glDisable(GL11.GL_CULL_FACE);
		} else {
			// アイテムに色付け
			int renderPasses = Modchu_AS.getBoolean(Modchu_AS.itemRequiresMultipleRenderPasses, item) ? 1 : 0;

/*//147delete
			String s1 = "/gui/items.png";
			if (Modchu_Main.isForge) {
				if (renderPasses == 1) renderPasses =
						(Integer) Modchu_Reflect.invokeMethod(Item.class, "getRenderPasses", new Class[]{ int.class },
								item, new Object[]{ itemstack.getItemDamage() }) - 1;
				s1 = (String) Modchu_Reflect.invokeMethod(Item.class, "getTextureFile", item);
				//Modchu_Debug.Debug("isForge render.func_110776_a s1="+s1+" renderPasses="+renderPasses);
			} else if (Modchu_Main.isBTW
					&& isBTWItem(item)) {
				s1 = "/btwmodtex/btwitems01.png";
			}
*///147delete
			// 152deleterender.func_110776_a(s1);
			for (int j = 0; j <= renderPasses; j++) {
				if (!Modchu_Main.isSSP
						| renderPasses > 0) {
					int k = Modchu_AS.getInt(Modchu_AS.itemGetColorFromItemStack, item, itemstack, j);
					float f15 = (k >> 16 & 0xff) / 255F;
					float f17 = (k >> 8 & 0xff) / 255F;
					float f19 = (k & 0xff) / 255F;
					Modchu_GlStateManager.color(f15, f17, f19, 1.0F);
				}
				Modchu_AS.set(Modchu_AS.renderManagerItemRendererRenderItem, entityLiving, itemstack, j);
				//render.renderManager.itemRenderer.renderItem(entityLiving, itemstack, j);
			}
		}
		Modchu_GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		Modchu_GlStateManager.popMatrix();
	}

	protected void renderItemsModOption(Object entityLiving, boolean pRealBlock, Object enumAction, Object itemstack, float scale) {
	}

	protected void renderItemsEndSetting(int i) {
		Modchu_GlStateManager.disableCull();
		Modchu_GlStateManager.enableAlpha();
		Modchu_GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		Modchu_GlStateManager.popMatrix();
		if (Modchu_Main.getMinecraftVersion() > 179) {
			Modchu_GlStateManager.bindTexture(i);
		}
	}

	public void blockRender(Object block, Object iBlockState, float f, boolean b) {
		if (Modchu_Main.getMinecraftVersion() < 180) return;
		Object blockRendererDispatcher = Modchu_AS.get(Modchu_AS.minecraftGetBlockRendererDispatcher);
		int i = Modchu_AS.getInt(Modchu_AS.blockGetRenderType, block);
		if (i == 3) {
			Object iBakedModel = Modchu_AS.get(Modchu_AS.blockRendererDispatcherGetBakedModel, blockRendererDispatcher, iBlockState, null);
			Modchu_AS.set(Modchu_AS.blockModelRendererRenderModelBrightness, Modchu_AS.get(Modchu_AS.blockRendererDispatcherGetBlockModelRenderer, blockRendererDispatcher), iBakedModel, iBlockState, f, b);
		} else {
			Modchu_AS.set(Modchu_AS.blockRendererDispatcherRenderBlockBrightness, blockRendererDispatcher, iBlockState, f);
		}
	}

	protected void renderItemsOption(Object entityLiving, boolean pRealBlock, Object enumAction, Object itemstack, float scale) {
	}

	public boolean renderBlockDoublePlant(Object renderBlocks, Object blockDoublePlant, int i, double d, int x, int y, int z) {
		//RenderBlocks.renderBlockDoublePlant
		if (Modchu_Main.getMinecraftVersion() < 170) return false;
		Object tessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 180) {
			Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator, 7, Modchu_AS.get("DefaultVertexFormats", version > 188 ? "POSITION_TEX" : "field_181707_g"));
		} else {
			Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator);
		}
		Modchu_AS.set(Modchu_AS.tessellatorSetNormal, tessellator, 0.0F, -1.0F, 0.0F);
		Object theWorld = Modchu_AS.get(Modchu_AS.minecraftWorld);
		int brightness = Modchu_AS.getInt(Modchu_AS.blockDoublePlantGetMixedBrightnessForBlock, blockDoublePlant, theWorld, x, y + 2, z);
		//Modchu_Debug.dDebug("brightness="+brightness);
		Modchu_AS.set(Modchu_AS.tessellatorSetBrightness, tessellator, brightness);

		int l = i != 2 && i != 3 ? Modchu_AS.getInt(Modchu_AS.blockDoublePlantColorMultiplier, blockDoublePlant, theWorld, x, y, z) : Modchu_AS.getInt(Modchu_AS.biomeGetBiomeGrassColor, Modchu_AS.get(Modchu_AS.worldGetBiomeGenForCoords, theWorld, x, z), x, y, z);
		//Modchu_Debug.dDebug("l="+l+" x="+x+" y="+y+" z="+z+" i="+i);
		float f = (l >> 16 & 255) / 255.0F;
		float f1 = (l >> 8 & 255) / 255.0F;
		float f2 = (l & 255) / 255.0F;

		if (Modchu_AS.getBoolean(Modchu_AS.entityRendererAnaglyphEnable)) {
			float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
			float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
			float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
			f = f3;
			f1 = f4;
			f2 = f5;
		}
		Modchu_AS.set(Modchu_AS.tessellatorSetColorOpaque_F, tessellator, f, f1, f2);

		boolean flag1 = Modchu_AS.getBoolean(Modchu_AS.blockDoublePlantFunc_149887_c, i == 0 ? 8 : i);
		int k1;

		if (flag1) {
			k1 = 0;
		} else {
			k1 = Modchu_AS.getInt(Modchu_AS.blockDoublePlantFunc_149890_d, i);
		}

		Object iicon = null;
		boolean flag = false;
		for (int i1 = 0; i1 < 3; i1++) {
			flag = i == 0 ? true : i1 > 1;
			iicon = Modchu_AS.get(Modchu_AS.blockDoublePlantFunc_149888_a, blockDoublePlant, flag, i);
			//Modchu_Debug.mDebug("2 iicon="+iicon);
			Modchu_AS.set(Modchu_AS.renderBlocksDrawCrossedSquares, renderBlocks, iicon, -0.5D + (0.001D * i1), -0.25D + (0.5D * i1), -0.5D, 1.0F);
		}
		//Modchu_Debug.mDebug("iicon="+iicon);
		//Modchu_Debug.mDebug("flag1="+flag1+" k1="+k1);
		if (flag1 &&
				k1 == 0) {
			double x2 = -0.5D;
			double y2 = 0.85D;
			double z2 = -0.5D;
			Object iicon1 = Modchu_AS.getObjectArray(Modchu_AS.blockDoublePlantSunflowerIcons, blockDoublePlant)[0];
			double d2 = Math.cos(d * 0.8D) * Math.PI * 0.1D;
			d2 = 1.5D;
			double d3 = Math.cos(d2);
			double d4 = Math.sin(d2);
			double d5 = Modchu_AS.getDouble(Modchu_AS.iIconGetMinU, iicon1);
			double d6 = Modchu_AS.getDouble(Modchu_AS.iIconGetMinV, iicon1);
			double d7 = Modchu_AS.getDouble(Modchu_AS.iIconGetMaxU, iicon1);
			double d8 = Modchu_AS.getDouble(Modchu_AS.iIconGetMaxV, iicon1);
			double d9 = 0.3D;
			double d10 = -0.05D;
			double d11 = 0.5D + 0.3D * d3 - 0.5D * d4;
			double d12 = 0.5D + 0.5D * d3 + 0.3D * d4;
			double d13 = 0.5D + 0.3D * d3 + 0.5D * d4;
			double d14 = 0.5D + -0.5D * d3 + 0.3D * d4;
			double d15 = 0.5D + -0.05D * d3 + 0.5D * d4;
			double d16 = 0.5D + -0.5D * d3 + -0.05D * d4;
			double d17 = 0.5D + -0.05D * d3 - 0.5D * d4;
			double d18 = 0.5D + 0.5D * d3 + -0.05D * d4;
			Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, x2 + d15, y2 + 1.0D, z2 + d16, d5, d8, f, f1, f2, 255);
			Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, x2 + d17, y2 + 1.0D, z2 + d18, d7, d8, f, f1, f2, 255);
			Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, x2 + d11, y2 + 0.0D, z2 + d12, d7, d6, f, f1, f2, 255);
			Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, x2 + d13, y2 + 0.0D, z2 + d14, d5, d6, f, f1, f2, 255);
			Object iicon2 = Modchu_AS.getObjectArray(Modchu_AS.blockDoublePlantSunflowerIcons, blockDoublePlant)[1];
			d5 = Modchu_AS.getDouble(Modchu_AS.iIconGetMinU, iicon2);
			d6 = Modchu_AS.getDouble(Modchu_AS.iIconGetMinV, iicon2);
			d7 = Modchu_AS.getDouble(Modchu_AS.iIconGetMaxU, iicon2);
			d8 = Modchu_AS.getDouble(Modchu_AS.iIconGetMaxV, iicon2);
			Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, x2 + d17, y2 + 1.0D, z2 + d18, d5, d8, f, f1, f2, 255);
			Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, x2 + d15, y2 + 1.0D, z2 + d16, d7, d8, f, f1, f2, 255);
			Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, x2 + d13, y2 + 0.0D, z2 + d14, d7, d6, f, f1, f2, 255);
			Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, x2 + d11, y2 + 0.0D, z2 + d12, d5, d6, f, f1, f2, 255);
		}
		Modchu_AS.set(Modchu_AS.tessellatorDraw, tessellator);

		return true;
	}
/*
	public boolean renderBlockDoublePlant(Object renderBlocks, Object blockDoublePlant, int i, double d, int x, int y, int z) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		World theWorld = ((World) Modchu_AS.get(Modchu_AS.minecraftTheWorld));
		int brightness = ((BlockDoublePlant) blockDoublePlant).getMixedBrightnessForBlock(theWorld, x, y + 2, z);
		//Modchu_Debug.dDebug("brightness="+brightness);
		tessellator.setBrightness(brightness);

		int l = i != 2 && i != 3 ? ((BlockDoublePlant) blockDoublePlant).colorMultiplier(theWorld, x, y, z) : theWorld.getBiomeGenForCoords(x, z).getBiomeGrassColor(x, y, z);
		//Modchu_Debug.dDebug("l="+l+" x="+x+" y="+y+" z="+z+" i="+i);
		float f = (l >> 16 & 255) / 255.0F;
		float f1 = (l >> 8 & 255) / 255.0F;
		float f2 = (l & 255) / 255.0F;

		if (EntityRenderer.anaglyphEnable) {
			float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
			float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
			float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
			f = f3;
			f1 = f4;
			f2 = f5;
		}
		tessellator.setColorOpaque_F(f, f1, f2);

		boolean flag1 = BlockDoublePlant.func_149887_c(i == 0 ? 8 : i);
		int k1;

		if (flag1) {
			k1 = 0;
		} else {
			k1 = BlockDoublePlant.func_149890_d(i);
		}

		IIcon iicon;
		boolean flag = false;
		for (int i1 = 0; i1 < 3; i1++) {
			flag = i == 0 ? true : i1 > 1;
			iicon = ((BlockDoublePlant) blockDoublePlant).func_149888_a(flag, i);
			((RenderBlocks) renderBlocks).drawCrossedSquares(iicon, -0.5D + (0.001D * i1), -0.25D + (0.5D * i1), -0.5D, 1.0F);
		}
		//Modchu_Debug.mDebug("iicon="+iicon);
		//Modchu_Debug.mDebug("flag1="+flag1+" k1="+k1);
		if (flag1 && k1 == 0) {
			double x2 = -0.5D;
			double y2 = 0.85D;
			double z2 = -0.5D;
			IIcon iicon1 = ((BlockDoublePlant) blockDoublePlant).sunflowerIcons[0];
			double d2 = Math.cos(d * 0.8D) * Math.PI * 0.1D;
			d2 = 1.5D;
			double d3 = Math.cos(d2);
			double d4 = Math.sin(d2);
			double d5 = iicon1.getMinU();
			double d6 = iicon1.getMinV();
			double d7 = iicon1.getMaxU();
			double d8 = iicon1.getMaxV();
			double d9 = 0.3D;
			double d10 = -0.05D;
			double d11 = 0.5D + 0.3D * d3 - 0.5D * d4;
			double d12 = 0.5D + 0.5D * d3 + 0.3D * d4;
			double d13 = 0.5D + 0.3D * d3 + 0.5D * d4;
			double d14 = 0.5D + -0.5D * d3 + 0.3D * d4;
			double d15 = 0.5D + -0.05D * d3 + 0.5D * d4;
			double d16 = 0.5D + -0.5D * d3 + -0.05D * d4;
			double d17 = 0.5D + -0.05D * d3 - 0.5D * d4;
			double d18 = 0.5D + 0.5D * d3 + -0.05D * d4;
			tessellator.addVertexWithUV(x2 + d15, y2 + 1.0D, z2 + d16, d5, d8);
			tessellator.addVertexWithUV(x2 + d17, y2 + 1.0D, z2 + d18, d7, d8);
			tessellator.addVertexWithUV(x2 + d11, y2 + 0.0D, z2 + d12, d7, d6);
			tessellator.addVertexWithUV(x2 + d13, y2 + 0.0D, z2 + d14, d5, d6);
			IIcon iicon2 = ((BlockDoublePlant) blockDoublePlant).sunflowerIcons[1];
			d5 = iicon2.getMinU();
			d6 = iicon2.getMinV();
			d7 = iicon2.getMaxU();
			d8 = iicon2.getMaxV();
			tessellator.addVertexWithUV(x2 + d17, y2 + 1.0D, z2 + d18, d5, d8);
			tessellator.addVertexWithUV(x2 + d15, y2 + 1.0D, z2 + d16, d7, d8);
			tessellator.addVertexWithUV(x2 + d13, y2 + 0.0D, z2 + d14, d7, d6);
			tessellator.addVertexWithUV(x2 + d11, y2 + 0.0D, z2 + d12, d5, d6);
		}
		tessellator.draw();
		return true;
	}
*/
	public boolean renderDecoBlock(Object entityLiving, boolean pRealBlock, Object enumAction, Object itemStack, float scale, int addSupport) {
		//DecoBlock, FavBlock用描画
		Object render = Modchu_Main.getRender(getBaseModel());
		if (render != null); else return false;
		Object block = Modchu_AS.get(Modchu_AS.getBlockItemStack, itemStack);
		boolean flag = false;
		boolean rotate = false;
		boolean translatef = false;
		boolean particle = false;
		int particleFrequency = 98;
		String particleString = null;
		float translatefX = 0.0F;
		float translatefY = 0.5F;
		float translatefZ = 0.0F;
		//addSupport = 0 DecoBlock
		//addSupport = 1 DecoBlockBase
		if (addSupport < 2) {
			translatef = true;
			if (addSupport == 0) {
				flag = rotate = true;
				particle = true;
				particleString = "heart";
			} else if (addSupport == 1) {
				flag = rotate = true;
			}
		}
		//addSupport = 2 FavBlock
		if (addSupport == 2) {
			flag = rotate = true;
			translatef = true;
			translatefX = 0.0F;
			translatefY = 0.4F;
			translatefZ = 0.0F;
			particle = true;
			particleString = "instantSpell";
			particleFrequency = 80;
		}
		Modchu_GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);

		if (flag) {
			// 152deleterender.func_110776_a("/terrain.png");
			GL11.glEnable(GL11.GL_CULL_FACE);
			if (rotate) Modchu_GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
			else Modchu_GlStateManager.rotate(12F, 0.0F, 1.0F, 0.0F);
//-@-b173
/*
			int k = itemstack.getItem().getColorFromItemStack(itemstack, 0);
			float f9 = (float)(k >> 16 & 0xff) / 255F;
			float f10 = (float)(k >> 8 & 0xff) / 255F;
			float f12 = (float)(k & 0xff) / 255F;
			Modchu_GlStateManager.color(f9, f10, f12, 1.0F);
*/
//@-@b173
			if (scale > 1.0F) Modchu_GlStateManager.scale(scale, scale, scale);
			Modchu_GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			if (translatef) Modchu_GlStateManager.translate(translatefX, translatefY, translatefZ);
			loadBlockTexture(render);
			Object renderBlocks = Modchu_AS.get(Modchu_AS.renderRenderBlocks, render);
			int itemDamage = Modchu_AS.getInt(Modchu_AS.itemStackGetItemDamage, itemStack);
			Modchu_AS.get(Modchu_AS.renderBlocksRenderBlockAsItem, renderBlocks, block, itemDamage, 1.0F);
			particleFrequency -= (int) ((scale - 1.0F) * 10F);
			//Modchu_Debug.mDebug("particleFrequency ="+particleFrequency+" (int)(scale - 1.0F * 10F)="+((int)((scale - 1.0F) * 10F))+" scale="+scale);
			if (particle && rnd.nextInt(100) > particleFrequency) {
				double d = rnd.nextGaussian() * 0.02D;
				double d1 = rnd.nextGaussian() * 0.02D;
				double d2 = rnd.nextGaussian() * 0.02D;
				double posX = Modchu_AS.getDouble(Modchu_AS.entityPosX, entityLiving);
				double posY = Modchu_AS.getDouble(Modchu_AS.entityPosY, entityLiving);
				double posZ = Modchu_AS.getDouble(Modchu_AS.entityPosZ, entityLiving);
				float width = Modchu_AS.getFloat(Modchu_AS.entityWidth, entityLiving);
				float height = Modchu_AS.getFloat(Modchu_AS.entityHeight, entityLiving);
				Modchu_AS.set(Modchu_AS.worldSpawnParticle, entityLiving, particleString, (posX + (rnd.nextFloat() * width * 2.0F)) - width, posY - 0.5D + (rnd.nextFloat() * height), (posZ + (rnd.nextFloat() * width * 2.0F)) - width, d, d1, d2);
			}
			GL11.glDisable(GL11.GL_CULL_FACE);
			/*b173//*/Modchu_GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		}
		return flag;
	}

	protected void loadBlockTexture(Object render) {
		if (Modchu_Main.getMinecraftVersion() < 160) {
			Modchu_AS.set(Modchu_AS.renderBindTexture, render, "/terrain.png");
			return;
		}
		//Modchu_Debug.mDebug("loadBlockTexture GetResourceLocation="+(Modchu_AS.get(Modchu_AS.textureManagerGetResourceLocation, 0)));
		Modchu_AS.set(Modchu_AS.textureManagerBindTexture, Modchu_AS.get(Modchu_AS.textureManagerGetResourceLocation, 0));
		//TextureManager var4 = Minecraft.getMinecraft().getTextureManager();
		//var4.bindTexture(var4.getResourceLocation(0));
	}

	protected boolean isBTWItem(Object item) {
		Class c = Modchu_Reflect.loadClass("net.minecraft.src.forge.ITextureProvider", -1);
		if (c != null) ;else Modchu_Reflect.loadClass("forge.ITextureProvider", -1);
		if (c != null) {
			Class[] var3 = item.getClass().getInterfaces();
			for (int var4 = 0; var4 < var3.length; ++var4) {
				if (var3[var4] == c) return true;
			}
		} else {
			c = Modchu_Reflect.loadClass("net.minecraft.src.FCItemMattock", -1);
			if (c != null && c.isInstance(item)) return true;
			c = Modchu_Reflect.loadClass("FCItemMattock", -1);
			if (c != null && c.isInstance(item)) return true;
		}
		return false;
	}

	@Override
	public void render(float par1, boolean b) {
		if (isHidden) return;
		//Modchu_Debug.mDebug1("render boxName="+boxName);
		//Modchu_Debug.mDebug1("render 1 boxName="+boxName+" showModel="+showModel);

		if (showModel && !compiled) {
			compileDisplayList(par1);
		}

		Modchu_GlStateManager.pushMatrix();
		if (upsideDownRotation) upsideDownMove();
		Modchu_GlStateManager.translate(offsetX, offsetY, offsetZ);

		if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
			//Modchu_Debug.mDebug("render rotationPointX="+rotationPointX+" rotationPointY="+rotationPointY+" rotationPointZ="+rotationPointZ);
			Modchu_GlStateManager.translate(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		}
		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
			setRotation();
		}
		renderObject(par1, b);
		Modchu_GlStateManager.popMatrix();
	}

	protected void upsideDownMove() {
		Modchu_ModelRenderer child = (Modchu_ModelRenderer) childModels.get(0);
		Modchu_IModelBox box = child.cubeList.get(0);
		Modchu_GlStateManager.translate(-box.getBoxSizeX(), -box.getBoxSizeY(), -box.getBoxSizeZ());
	}

	public void postRenderAll(float par1, boolean b) {
		if (isHidden) {
			return;
		}

		if (b && !compiled) {
			compileDisplayList(par1);
		}

		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
			Modchu_GlStateManager.translate(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

			setRotation();
		} else if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
			Modchu_GlStateManager.translate(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		}
		// ポストレンダリング、あと子供も
		Modchu_GlStateManager.getFloat(GL11.GL_MODELVIEW_MATRIX, matrix);

		if (childModels != null) {
			for (int i = 0; i < childModels.size(); i++) {
				((Modchu_ModelRenderer) childModels.get(i)).postRenderAll(par1, b);
			}
		}
	}

	public void allChildModelsRender(float par1) {
		if (childModels != null) {
			for (Modchu_ModelRendererBase modchu_ModelRenderer : childModels) {
				if (modchu_ModelRenderer.showModel) modchu_ModelRenderer.render(par1);
			}
		}
	}

	public List<Object> getBoneChildModels() {
		return boneChildModels;
	}

	public void addBoneChild(Modchu_ModelRenderer par1ModelRenderer) {
		if (boneChildModels != null) ;
		else boneChildModels = new ArrayList();
		if (!boneChildModels.contains(par1ModelRenderer)) boneChildModels.add(par1ModelRenderer);
	}

	public List<Object> getBoneSpecialChildModels() {
		return boneSpecialChildModels;
	}

	public void addBoneSpecialChild(Modchu_ModelRenderer par1ModelRenderer) {
		if (boneSpecialChildModels != null) ;
		else boneSpecialChildModels = new ArrayList();
		if (!boneSpecialChildModels.contains(par1ModelRenderer)) boneSpecialChildModels.add(par1ModelRenderer);
	}

	public void removeChild(Modchu_ModelRenderer par1ModelRenderer) {
		if (childModels != null) ;
		else return;
		if (childModels.contains(par1ModelRenderer)) childModels.remove(par1ModelRenderer);
	}

	public void removeBoneChild(Modchu_ModelRenderer par1ModelRenderer) {
		if (boneChildModels != null) ;
		else return;
		if (boneChildModels.contains(par1ModelRenderer)) boneChildModels.remove(par1ModelRenderer);
	}

	public void removeBoneSpecialChild(Modchu_ModelRenderer par1ModelRenderer) {
		if (boneSpecialChildModels != null) ;
		else return;
		if (boneSpecialChildModels.contains(par1ModelRenderer)) boneSpecialChildModels.remove(par1ModelRenderer);
	}

	public void clearBoneChildModels() {
		if (boneChildModels != null) boneChildModels.clear();
	}

	public void clearBoneSpecialChildModels() {
		if (boneSpecialChildModels != null) boneSpecialChildModels.clear();
	}

	protected Modchu_ModelRenderer makeBall(float var1, float var2, float var3, float var4, float var5, float var6) {
		float[][] var7 = new float[][]{ { 0.0F, 4.9745197F, -0.0F },
			{ 0.0F, 3.5175202F, 3.5175202F },
			{ 2.4997F, 3.5175202F, 2.4872599F },
			{ 3.5351F, 3.5175202F, -0.0F },
			{ 2.4997F, 3.5175202F, -2.4872599F },
			{ 0.0F, 3.5175202F, -3.5175202F },
			{ -2.4997F, 3.5175202F, -2.4872599F },
			{ -3.5351F, 3.5175202F, -0.0F },
			{ -2.4997F, 3.5175202F, 2.4872599F },
			{ 0.0F, 0.0F, 4.9745197F },
			{ 3.5351F, 0.0F, 3.5175202F },
			{ 4.99939F, 0.0F, 0.0F },
			{ 3.5351F, -0.0F, -3.5175202F },
			{ 0.0F, -0.0F, -4.9745197F },
			{ -3.5351F, -0.0F, -3.5175202F },
			{ -4.99939F, 0.0F, 0.0F },
			{ -3.5351F, 0.0F, 3.5175202F },
			{ 0.0F, -3.5175202F, 3.5175202F },
			{ 2.4997F, -3.5175202F, 2.4872599F },
			{ 3.5351F, -3.5175202F, 0.0F },
			{ 2.4997F, -3.5175202F, -2.4872599F },
			{ 0.0F, -3.5175202F, -3.5175202F },
			{ -2.4997F, -3.5175202F, -2.4872599F },
			{ -3.5351F, -3.5175202F, 0.0F },
			{ -2.4997F, -3.5175202F, 2.4872599F },
			{ 0.0F, -4.9745197F, 0.0F } };
		float[][] var8 = new float[][]{ { (float) textureOffsetX / textureWidth,
			(float) (textureOffsetY + 1) / textureHeight },
			{ (float) (textureOffsetX + 1) / textureWidth,
				(float) (textureOffsetY + 1) / textureHeight },
			{ (float) (textureOffsetX + 1) / textureWidth,
					(float) textureOffsetY / textureHeight },
			{ (float) textureOffsetX / textureWidth,
						(float) textureOffsetY / textureHeight } };
		float[][] var9 = new float[][]{ { 0.0F, 1.0F, 0.0F },
			{ 0.0F, 0.663167F, 0.748436F },
			{ 0.527909F, 0.663594F, 0.529984F },
			{ 0.747673F, 0.664052F, 0.0F },
			{ 0.527909F, 0.663594F, -0.529984F },
			{ 0.0F, 0.663167F, -0.748436F },
			{ -0.527909F, 0.663594F, -0.529984F },
			{ -0.747673F, 0.664052F, 0.0F },
			{ -0.527909F, 0.663594F, 0.529984F },
			{ 0.0F, 0.0F, 0.999969F },
			{ 0.706076F, 0.0F, 0.70809F },
			{ 1.0F, 0.0F, 0.0F },
			{ 0.706107F, 0.0F, -0.70809F },
			{ 0.0F, 0.0F, -0.999969F },
			{ -0.706076F, 0.0F, -0.70809F },
			{ -1.0F, 0.0F, 0.0F },
			{ -0.706107F, 0.0F, 0.70809F },
			{ 0.0F, -0.663167F, 0.748436F },
			{ 0.527909F, -0.663594F, 0.529984F },
			{ 0.747673F, -0.664052F, 0.0F },
			{ 0.527909F, -0.663594F, -0.529984F },
			{ 0.0F, -0.663167F, -0.748436F },
			{ -0.527909F, -0.663594F, -0.529984F },
			{ -0.747673F, -0.664052F, 0.0F },
			{ -0.527909F, -0.663594F, 0.529984F },
			{ 0.0F, -1.0F, 0.0F } };
		int[][][] var10 = new int[][][]{ { { 1 },
			{ 0, 1, 2 },
			{ 0, 1, 2 },
			{ 0, 1, 2 } },
			{ { 1 },
				{ 0, 2, 3 },
				{ 0, 1, 2 },
				{ 0, 2, 3 } },
			{ { 1 },
					{ 0, 3, 4 },
					{ 0, 1, 2 },
					{ 0, 3, 4 } },
			{ { 1 },
						{ 0, 4, 5 },
						{ 0, 1, 2 },
						{ 0, 4, 5 } },
			{ { 1 },
							{ 0, 5, 6 },
							{ 0, 1, 2 },
							{ 0, 5, 6 } },
			{ { 1 },
								{ 0, 6, 7 },
								{ 0, 1, 2 },
								{ 0, 6, 7 } },
			{ { 1 },
									{ 0, 7, 8 },
									{ 0, 1, 2 },
									{ 0, 7, 8 } },
			{ { 1 },
										{ 0, 8, 1 },
										{ 0, 1, 2 },
										{ 0, 8, 1 } },
			{ { 1 },
											{ 1, 9, 10, 2 },
											{ 0, 1, 2, 3 },
											{ 1, 9, 10, 2 } },
			{ { 1 },
												{ 2, 10, 11, 3 },
												{ 0, 1, 2, 3 },
												{ 2, 10, 11, 3 } },
			{ { 1 },
													{ 3, 11, 12, 4 },
													{ 0, 1, 2, 3 },
													{ 3, 11, 12, 4 } },
			{ { 1 },
														{ 4, 12, 13, 5 },
														{ 0, 1, 2, 3 },
														{ 4, 12, 13, 5 } },
			{ { 1 },
															{ 5, 13, 14, 6 },
															{ 0, 1, 2, 3 },
															{ 5, 13, 14, 6 } },
			{ { 1 },
																{ 6, 14, 15, 7 },
																{ 0, 1, 2, 3 },
																{ 6, 14, 15, 7 } },
			{ { 1 },
																	{ 7, 15, 16, 8 },
																	{ 0, 1, 2, 3 },
																	{ 7, 15, 16, 8 } },
			{ { 1 },
																		{ 8, 16, 9, 1 },
																		{ 0, 1, 2, 3 },
																		{ 8, 16, 9, 1 } },
			{ { 1 },
																			{ 9, 17, 18, 10 },
																			{ 0, 1, 2, 3 },
																			{ 9, 17, 18, 10 } },
			{ { 1 },
																				{ 10, 18, 19, 11 },

																				{ 0, 1, 2, 3 },
																				{ 10, 18, 19, 11 } },
			{ { 1 },
																					{ 11, 19, 20, 12 },
																					{ 0, 1, 2, 3 },
																					{ 11, 19, 20, 12 } },
			{ { 1 },
																						{ 12, 20, 21, 13 },
																						{ 0, 1, 2, 3 },
																						{ 12, 20, 21, 13 } },
			{ { 1 },
																							{ 13, 21, 22, 14 },
																							{ 0, 1, 2, 3 },
																							{ 13, 21, 22, 14 } },
			{ { 1 },
																								{ 14, 22, 23, 15 },
																								{ 0, 1, 2, 3 },
																								{ 14, 22, 23, 15 } },
			{ { 1 },
																									{ 15, 23, 24, 16 },
																									{ 0, 1, 2, 3 },
																									{ 15, 23, 24, 16 } },
			{ { 1 },
																										{ 16, 24, 17, 9 },
																										{ 0, 1, 2, 3 },
																										{ 16, 24, 17, 9 } },
			{ { 1 },
																											{ 17, 25, 18 },
																											{ 0, 1, 2 },
																											{ 17, 25, 18 } },
			{ { 1 },
																												{ 18, 25, 19 },
																												{ 0, 1, 2 },
																												{ 18, 25, 19 } },
			{ { 1 },
																													{ 19, 25, 20 },
																													{ 0, 1, 2 },
																													{ 19, 25, 20 } },
			{ { 1 },
																														{ 20, 25, 21 },
																														{ 0, 1, 2 },
																														{ 20, 25, 21 } },
			{ { 1 },
																															{ 21, 25, 22 },
																															{ 0, 1, 2 },
																															{ 21, 25, 22 } },
			{ { 1 },
																																{ 22, 25, 23 },
																																{ 0, 1, 2 },
																																{ 22, 25, 23 } },
			{ { 1 },
																																	{ 23, 25, 24 },
																																	{ 0, 1, 2 },
																																	{ 23, 25, 24 } },
			{ { 1 },
																																		{ 24, 25, 17 },
																																		{ 0, 1, 2 },
																																		{ 24, 25, 17 } } };
		int var11;

		for (var11 = 0; var11 < var7.length; ++var11) {
			var7[var11][0] *= var4 / 8.0F;
			var7[var11][1] *= var5 / 8.0F;
			var7[var11][2] *= var6 / 8.0F;
			var7[var11][0] += var1;
			var7[var11][1] += var2;
			var7[var11][2] += var3;
		}

		for (var11 = 0; var11 < var10.length; ++var11) {
			int var12 = var10[var11][1].length;
			float[][] var13 = new float[var12][3];
			float[][] var14 = new float[var12][2];
			float[][] var15 = new float[var12][3];

			if (var10[var11][0][0] == 1) {
				for (int var16 = 0; var16 < var12; ++var16) {
					var13[var16] = var7[var10[var11][1][var16]];
					var14[var16] = var8[var10[var11][2][var16]];
					var15[var16] = var9[var10[var11][3][var16]];
				}

				addPlateFreeShape(var13, var14, var15, (float[]) null);
			}
		}

		return this;
	}

	public Object getFreeVariable(String s) {
		return freeVariableMap != null
				&& !freeVariableMap.isEmpty() ? freeVariableMap.get(s) : null;
	}

	public void setFreeVariable(String s, Object o) {
		if (freeVariableMap != null); else freeVariableMap = new ConcurrentHashMap();
		if (o != null) freeVariableMap.put(s, o);
		else removeFreeVariable(s);
	}

	public void removeFreeVariable(String s) {
		if (freeVariableMap != null); else return;
		if (freeVariableMap.containsKey(s)) freeVariableMap.remove(s);
	}

	public boolean freeVariableContainsKey(String s) {
		if (freeVariableMap != null); else return false;
		 return freeVariableMap.containsKey(s);
	}

	public void setDefaultRotationPoint() {
		setRotationPoint(initRotationPointX, initRotationPointY, initRotationPointZ);
	}

	public void setDefaultRotateAngle() {
		setRotateAngle(initRotateAngleX, initRotateAngleY, initRotateAngleZ);
	}

	//SmartMoving関連↓
	public void reset() {
		rotatePriority = XYZ;
		scaleX = 1.0F;
		scaleY = 1.0F;
		scaleZ = 1.0F;
		rotationPointX = 0.0F;
		rotationPointY = 0.0F;
		rotationPointZ = 0.0F;
		rotateAngleX = 0.0F;
		rotateAngleY = 0.0F;
		rotateAngleZ = 0.0F;
		ignoreBase = false;
		ignoreSuperRotation = false;
		forceRender = false;
		offsetX = 0.0F;
		offsetY = 0.0F;
		offsetZ = 0.0F;
		fadeOffsetX = false;
		fadeOffsetY = false;
		fadeOffsetZ = false;
		fadeRotateAngleX = false;
		fadeRotateAngleY = false;
		fadeRotateAngleZ = false;
		fadeRotationPointX = false;
		fadeRotationPointY = false;
		fadeRotationPointZ = false;
		previous = null;
	}

	public void fadeStore(float var1) {
		if (previous != null) {
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "offsetX", previous, offsetX);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "offsetY", previous, offsetY);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "offsetZ", previous, offsetZ);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotateAngleX", previous, rotateAngleX);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotateAngleY", previous, rotateAngleY);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotateAngleZ", previous, rotateAngleZ);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotationPointX", previous, rotationPointX);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotationPointY", previous, rotationPointY);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotationPointZ", previous, rotationPointZ);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "totalTime", previous, var1);
		}
	}

	public void fadeIntermediate(float var1) {
		if (previous != null) {
			float totalTime = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "totalTime", previous);
			if (var1 - totalTime <= 2.0F) {
				float previousOffsetX = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "offsetX", previous);
				float previousOffsetY = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "offsetY", previous);
				float previousOffsetZ = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "offsetZ", previous);
				float previousRotateAngleX = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotateAngleX", previous);
				float previousRotateAngleY = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotateAngleY", previous);
				float previousRotateAngleZ = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotateAngleZ", previous);
				float previousRotationPointX = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotationPointX", previous);
				float previousRotationPointY = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotationPointY", previous);
				float previousRotationPointZ = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotationPointZ", previous);
				offsetX = GetIntermediatePosition(previousOffsetX, offsetX, fadeOffsetX, totalTime, var1);
				offsetY = GetIntermediatePosition(previousOffsetY, offsetY, fadeOffsetY, totalTime, var1);
				offsetZ = GetIntermediatePosition(previousOffsetZ, offsetZ, fadeOffsetZ, totalTime, var1);
				rotateAngleX = GetIntermediateAngle(previousRotateAngleX, rotateAngleX, fadeRotateAngleX, totalTime, var1);
				rotateAngleY = GetIntermediateAngle(previousRotateAngleY, rotateAngleY, fadeRotateAngleY, totalTime, var1);
				rotateAngleZ = GetIntermediateAngle(previousRotateAngleZ, rotateAngleZ, fadeRotateAngleZ, totalTime, var1);
				rotationPointX = GetIntermediatePosition(previousRotationPointX, rotationPointX, fadeRotationPointX, totalTime, var1);
				rotationPointY = GetIntermediatePosition(previousRotationPointY, rotationPointY, fadeRotationPointY, totalTime, var1);
				rotationPointZ = GetIntermediatePosition(previousRotationPointZ, rotationPointZ, fadeRotationPointZ, totalTime, var1);
			}
		}
	}

	protected float GetIntermediatePosition(float var1, float var2, boolean var3, float var4, float var5) {
		return var3 && var2 != var1 ? var1 + (var2 - var1) * (var5 - var4) * 0.2F : var2;
	}

	protected float GetIntermediateAngle(float var1, float var2, boolean var3, float var4, float var5) {
		if (var3 && var2 != var1) {
			while (var1 >= ((float) Math.PI * 2F)) {
				var1 -= ((float) Math.PI * 2F);
			}

			while (var1 < 0.0F) {
				var1 += ((float) Math.PI * 2F);
			}

			while (var2 >= ((float) Math.PI * 2F)) {
				var2 -= ((float) Math.PI * 2F);
			}

			while (var2 < 0.0F) {
				var2 += ((float) Math.PI * 2F);
			}

			if (var2 > var1 && var2 - var1 > (float) Math.PI) {
				var1 += ((float) Math.PI * 2F);
			}

			if (var2 < var1 && var1 - var2 > (float) Math.PI) {
				var2 += ((float) Math.PI * 2F);
			}

			return var1 + (var2 - var1) * (var5 - var4) * 0.2F;
		} else {
			return var2;
		}
	}
	//SmartMoving関連↑

}