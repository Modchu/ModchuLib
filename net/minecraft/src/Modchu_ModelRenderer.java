package net.minecraft.src;

//b181deleteimport java.util.ArrayList;
import static net.minecraft.src.MMM_IModelCaps.caps_Entity;
import static net.minecraft.src.MMM_IModelCaps.caps_HeadMount;

import java.lang.reflect.Constructor;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Modchu_ModelRenderer extends MMM_ModelRenderer
{
	public float preRotationPointX;
	public float preRotationPointY;
	public float preRotationPointZ;
	public float preRotateAngleX;
	public float preRotateAngleY;
	public float preRotateAngleZ;
	public boolean angleFirst;
	public MMM_ModelRenderer parentModel;
	public String boxName;
	private static Random rnd = new Random();

	//littleMaidMob共通
	private int textureOffsetX;
	private int textureOffsetY;
	private boolean compiled = false;
	private int displayList;
	private MMM_ModelBase baseModel;
	public Modchu_ModelRenderer pearent;

	//SmartMoving共通
	protected MMM_ModelRenderer base;
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
	public Class RendererData;
	public Object previous;
	public float offsetX = 0.0F;
	public float offsetY = 0.0F;
	public float offsetZ = 0.0F;

/*//b181delete
	public List cubeList;
	public List childModels;
	private TexturedQuad faces[];
*///b181delete
/*//b173delete
	public static float textureWidth;
	public static float textureHeight;
*///b173delete
	public Modchu_ModelRenderer(MMM_ModelBase modelBase, int i, int j)
	{
		super(modelBase, i, j);
		init(modelBase, i, j, null);
	}
//-@-b181
	public Modchu_ModelRenderer(MMM_ModelBase modelBase, int i, int j, String s)
	{
		super(modelBase, s);
		init(modelBase, i, j, s);
	}

	public Modchu_ModelRenderer(MMM_ModelBase modelBase, int i, int j, MMM_ModelRenderer modelRenderer) {
		this(modelBase, i, j);
		base = modelRenderer;
		if (base != null)
		{
			base.addChild(this);
		}
	}

	public Modchu_ModelRenderer(MMM_ModelBase modelBase) {
		this(modelBase, 0, 0);
	}

	public Modchu_ModelRenderer(MMM_ModelBase modelBase, String s) {
		this(modelBase, 64, 32, s);
	}

	public void init(MMM_ModelBase modelBase, int i, int j, String s) {
		preRotationPointX = 0.0F;
		preRotationPointY = 0.0F;
		preRotationPointZ = 0.0F;
		preRotateAngleX = 0.0F;
		preRotateAngleY = 0.0F;
		preRotateAngleZ = 0.0F;
		scaleX = 1.0F;
		scaleY = 1.0F;
		scaleZ = 1.0F;
		rotatePriority = RotXYZ;
		angleFirst = false;	// 変換を当てる順番
		parentModel = null;	// 同じ回転軸になる親
		textureOffsetX = i;
		textureOffsetY = j;
		boxName = s;
		itemstack = null;
		adjust = true;
		matrix = BufferUtils.createFloatBuffer(16);
		isInvertX = false;
		baseModel = modelBase;
		pearent = null;
		RendererData = mod_Modchu_ModchuLib.modchu_Main.RendererData;
/*//b181delete
		cubeList = new ArrayList();
		setTextureSize((int)((MultiModel) modelbase).textureWidth, (int)((MultiModel) modelbase).textureHeight);
		modelbase.boxList.add(this);
*///b181delete
	}

	/*b181//*/@Override
	public Modchu_ModelRenderer setTextureOffset(int i, int j) {
		/*b181//*/super.setTextureOffset(i, j);
		textureOffsetX = i;
		textureOffsetY = j;
		return this;
	}

//-@-151
	public Modchu_ModelRenderer addCubeList(MMM_ModelBoxBase pModelBoxBase) {
		cubeList.add(pModelBoxBase);
		return this;
	}

	public Modchu_ModelRenderer addParts(Class pModelBoxBase, Object ... pArg) {
		addCubeList(getModelBoxBase(pModelBoxBase, getArg((Object[]) pArg)));
		return this;
	}

	public Modchu_ModelRenderer addParts(Class pModelBoxBase, Class constructorClass, Object ... pArg) {
		addCubeList(getModelBoxBase(pModelBoxBase, constructorClass, getArg((Object[]) pArg)));
		return this;
	}
//@-@151
//-@-151
	public Modchu_ModelRenderer addPartsTexture(Class pModelBoxBase, String pName, Object ... pArg) {
		pName = (new StringBuilder()).append(boxName).append(".").append(pName).toString();
		addCubeList(getModelBoxBase(pModelBoxBase, (Object[]) pArg).setBoxName(pName));
		return this;
	}
//@-@151
//-@-151
	public Modchu_ModelRenderer addPartsTexture(Class pModelBoxBase, Object ... pArg) {
		addCubeList(getModelBoxBase(pModelBoxBase, (Object[]) pArg));
		return this;
	}
//@-@151

	public Modchu_ModelRenderer addPlate(float f, float f1, float f2, int i, int j, int k) {
/*//151delete
		cubeList.add(new MMM_ModelPlate(this, textureOffsetX, textureOffsetY, f, f1, f2, i, j, k, 0.0F));
*///151delete
//-@-151
		addParts(MMM_ModelPlate.class, f, f1, f2, i, j, k, 0.0F);
//@-@151
		return this;
	}

	public Modchu_ModelRenderer addPlate(float f, float f1, float f2, int i, int j, int k, float f3) {
/*//151delete
		cubeList.add(new MMM_ModelPlate(this, textureOffsetX, textureOffsetY, f, f1, f2, i, j, k, f3));
*///151delete
//-@-151
		addParts(MMM_ModelPlate.class, f, f1, f2, i, j, k, f3);
//@-@151
		return this;
	}

	public Modchu_ModelRenderer addPlateFreeShape(float[][] vertex, float[][] vertexN, int px, int py)
	{
		float[][] vt = { { textureOffsetX / textureWidth, (textureOffsetY + 1) / textureHeight }, { (textureOffsetX + 1) / textureWidth, (textureOffsetY + 1) / textureHeight }, { (textureOffsetX + 1) / textureWidth, textureOffsetY / textureHeight }, { textureOffsetX / textureWidth, textureOffsetY / textureHeight } };
/*//151delete
		cubeList.add(new Modchu_ModelPlateFreeShape(this, textureOffsetX, textureOffsetY, vertex, vt, vertexN, null, 0.0F));
*///151delete
//-@-151
		addParts(Modchu_ModelPlateFreeShape.class, vertex, vt, vertexN, null, 0.0F);
//@-@151
		return this;
	}

	public Modchu_ModelRenderer addPlateFreeShape(float[][] vertex, float[][] texUV, float[][] vertexN)
	{
/*//151delete
		cubeList.add(new Modchu_ModelPlateFreeShape(this, textureOffsetX, textureOffsetY, vertex, texUV, vertexN, null, 0.0F));
*///151delete
//-@-151
		addParts(Modchu_ModelPlateFreeShape.class, vertex, texUV, vertexN, null, 0.0F);
//@-@151
		return this;
	}

	public Modchu_ModelRenderer addPlateFreeShape(float[][] var1, float[][] var2, float[][] var3, float[] var4)
	{
/*//151delete
		cubeList.add(new Modchu_ModelPlateFreeShape(this, textureOffsetX, textureOffsetY, var1, var2, var3, var4, 0.0F));
*///151delete
//-@-151
		addParts(Modchu_ModelPlateFreeShape.class, var1, var2, var3, var4, 0.0F);
//@-@151
		return this;
	}

	public Modchu_ModelRenderer addBall(float var1, float var2, float var3, float var4, float var5, float var6)
	{
		return makeBall(var1, var2, var3, var4, var5, var6);
	}

	/**
	 * 描画用のボックス、子供をクリアする
	 */
	public void clearCubeList() {
		if (cubeList != null) cubeList.clear();
		compiled = false;
		if (childModels != null) childModels.clear();
	}

	public void renderItemsHead(MMM_ModelMultiBase pModelMulti, MMM_IModelCaps pEntityCaps, float scale, int addSupport) {
		ItemStack lis = (ItemStack)pEntityCaps.getCapsValue(caps_HeadMount);
		Entity lentity = (Entity)pEntityCaps.getCapsValue(caps_Entity);

		renderItems(lentity, pModelMulti.render, true, null, lis, scale, addSupport);
	}

	public void renderItemsHead(MMM_ModelMultiBase pModelMulti, MMM_IModelCaps pEntityCaps, ItemStack lis, float scale, int addSupport) {
		Entity lentity = (Entity)pEntityCaps.getCapsValue(caps_Entity);

		renderItems(lentity, pModelMulti.render, true, null, lis, scale, addSupport);
	}

	public void renderItems(Entity pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, ItemStack pItemStack, float scale, int addSupport) {
		if (pEntityLiving != null) ;else return;
		itemstack = pItemStack;
		switch(addSupport) {
		case 0:
		case 1:
		case 2:
			renderDecoBlock(pEntityLiving, pRender, pRealBlock, pAction, scale, addSupport);
			return;
		}
		renderItems(pEntityLiving, pRender, pRealBlock, pAction, scale);
	}

	public void renderItems(Entity pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, ItemStack pItemStack) {
		if (pEntityLiving != null) ;else return;
		itemstack = pItemStack;
		renderItems(pEntityLiving, pRender, pRealBlock, pAction, 1.0F);
	}

	public void renderItems(Entity pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction) {
		if (itemstack != null
				&& pEntityLiving != null) ;else return;
		renderItems(pEntityLiving, pRender, pRealBlock, pAction, 1.0F);
	}

	public void renderItems(Entity pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, float scale) {
		if (itemstack != null
				&& pEntityLiving != null) ;else return;

		// アイテムのレンダリング
		GL11.glPushMatrix();

		Item item = itemstack.getItem();
		// アイテムの種類による表示位置の補正
		if (adjust) {
//			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

			if (pRealBlock && (item instanceof ItemBlock)) {
				Block block = Block.blocksList[itemstack.itemID];
				float f2 = 0.625F;
				scale = f2 * scale;
				GL11.glTranslatef(0F, -scale * 0.495F, 0F);
				if (block instanceof BlockFlower) GL11.glRotatef(12F, 0F, 1F, 0);
				else {
//-@-125
					GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
//@-@125
					// 125deleteGL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
				}
				GL11.glScalef(scale, -scale, -scale);
			} else {
				float sx = scale;
				float sy = scale;
				float sz = scale;
				float var6;
//-@-132
				if (pRealBlock && item.itemID == Item.skull.itemID) {
					scale = 1.0625F * scale;
					sx = scale;
					sy = -scale;
					sz = -scale;
				}
				else
//@-@132
					if (itemstack.itemID < 256 && RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType())) {
					var6 = 0.5F;
//					GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
					GL11.glTranslatef(0.0F, 0.1875F, -0.2125F);
					var6 *= 0.75F;
					GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
					GL11.glScalef(var6, -var6, var6);
				}
				else if (itemstack.getItem() instanceof ItemBow) {
					var6 = 0.625F;
					GL11.glTranslatef(-0.05F, 0.125F, 0.3125F);
					GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
					GL11.glScalef(var6, -var6, var6);
					GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				}
				else if (Item.itemsList[itemstack.itemID].isFull3D()) {
					var6 = 0.625F;

					if (Item.itemsList[itemstack.itemID].shouldRotateAroundWhenRendering()) {
						GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
						GL11.glTranslatef(0.0F, -0.125F, 0.0F);
					}

					if (pAction == EnumAction.block) {
						GL11.glTranslatef(0.05F, 0.0F, -0.1F);
						GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
						GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
					}

					GL11.glTranslatef(0.0F, 0.1875F, 0.1F);
					GL11.glScalef(var6, -var6, var6);
					GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				} else {
					var6 = 0.375F;
					GL11.glTranslatef(0.15F, 0.15F, -0.05F);
//					GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
					GL11.glScalef(var6, var6, var6);
					GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
					GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
				}
				GL11.glScalef(sx, sy, sz);
			}
		}
//-@-132
		if (pRealBlock && item.itemID == Item.skull.itemID)
		{
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			String var6 = "";
			if (itemstack.hasTagCompound() && itemstack.getTagCompound().hasKey("SkullOwner"))
			{
				var6 = itemstack.getTagCompound().getString("SkullOwner");
			}
			TileEntitySkullRenderer.skullRenderer.func_82393_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack.getItemDamage(), var6);
		} else
//@-@132
		if (pRealBlock && itemstack.getItem() instanceof ItemBlock) {
			// 152deleteString s1 = "/terrain.png";
/*//147delete
			if (mod_Modchu_ModchuLib.modchu_Main.isForge) {
				s1 = (String) Modchu_Reflect.invokeMethod(Item.class, "getTextureFile", Item.itemsList[itemstack.itemID]);
				//Modchu_Debug.Debug("isForge pRender.func_110776_a s1="+s1);
			}
*///147delete
			// 152deletepRender.func_110776_a(s1);
			loadBlockTexture();
			GL11.glEnable(GL11.GL_CULL_FACE);
			pRender.renderBlocks.renderBlockAsItem(Block.blocksList[itemstack.itemID], itemstack.getItemDamage(), 1.0F);
			GL11.glDisable(GL11.GL_CULL_FACE);
		} else {
			if (pRender.renderManager != null
					&& pRender.renderManager.itemRenderer != null) {
				// アイテムに色付け
				int renderPasses = itemstack.getItem().requiresMultipleRenderPasses() ? 1 : 0;

/*//147delete
				String s1 = "/gui/items.png";
				if (mod_Modchu_ModchuLib.modchu_Main.isForge) {
					if (renderPasses == 1) renderPasses =
							(Integer) Modchu_Reflect.invokeMethod(Item.class, "getRenderPasses", new Class[]{ int.class },
									itemstack.getItem(), new Object[]{ itemstack.getItemDamage() }) - 1;
					s1 = (String) Modchu_Reflect.invokeMethod(Item.class, "getTextureFile", itemstack.getItem());
					//Modchu_Debug.Debug("isForge pRender.func_110776_a s1="+s1+" renderPasses="+renderPasses);
				} else if (mod_Modchu_ModchuLib.modchu_Main.isBTW
						&& isBTWItem(itemstack.getItem())) {
					s1 = "/btwmodtex/btwitems01.png";
				}
*///147delete
				// 152deletepRender.func_110776_a(s1);
				for (int j = 0; j <= renderPasses; j++) {
					if (!mod_Modchu_ModchuLib.modchu_Main.isSSP
							| renderPasses > 0) {
						int k = itemstack.getItem().getColorFromItemStack(itemstack, j);
						float f15 = (float)(k >> 16 & 0xff) / 255F;
						float f17 = (float)(k >> 8 & 0xff) / 255F;
						float f19 = (float)(k & 0xff) / 255F;
						GL11.glColor4f(f15, f17, f19, 1.0F);
					}
					//Modchu_Debug.mDebug("itemRenderer.renderItem");
					Modchu_Reflect.invokeMethod(ItemRenderer.class, "renderItem", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase"), ItemStack.class, int.class }, pRender.renderManager.itemRenderer, new Object[]{ pEntityLiving, itemstack, j });
					//pRender.renderManager.itemRenderer.renderItem(pEntityLiving, itemstack, j);
				}
			}
		}

		GL11.glPopMatrix();
	}

	public boolean renderDecoBlock(Entity pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, float scale, int addSupport) {
		//DecoBlock, FavBlock用描画
		Item item = itemstack.getItem();
		Block block = Block.blocksList[item.itemID];
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
			} else
			if (addSupport == 1) {
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
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);

		if (flag) {
			// 152deletepRender.func_110776_a("/terrain.png");
			GL11.glEnable(GL11.GL_CULL_FACE);
			if (rotate) GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
			else GL11.glRotatef(12F, 0.0F, 1.0F, 0.0F);
//-@-b173
/*
			int k = itemstack.getItem().getColorFromItemStack(itemstack, 0);
			float f9 = (float)(k >> 16 & 0xff) / 255F;
			float f10 = (float)(k >> 8 & 0xff) / 255F;
			float f12 = (float)(k & 0xff) / 255F;
			GL11.glColor4f(f9, f10, f12, 1.0F);
*/
//@-@b173
			if (scale > 1.0F) GL11.glScalef(scale, scale, scale);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			if (translatef) GL11.glTranslatef(translatefX, translatefY, translatefZ);
			loadBlockTexture();
			pRender.renderBlocks.renderBlockAsItem(block, itemstack.getItemDamage(), 1.0F);
			particleFrequency -= (int)((scale - 1.0F) * 10F);
			//Modchu_Debug.mDebug("particleFrequency ="+particleFrequency+" (int)(scale - 1.0F * 10F)="+((int)((scale - 1.0F) * 10F))+" scale="+scale);
			if (particle
					&& rnd.nextInt(100) > particleFrequency) {
				double d = rnd.nextGaussian() * 0.02D;
				double d1 = rnd.nextGaussian() * 0.02D;
				double d2 = rnd.nextGaussian() * 0.02D;
				pEntityLiving.worldObj.spawnParticle(particleString, (pEntityLiving.posX + (double)(rnd.nextFloat() * pEntityLiving.width * 2.0F)) - (double)pEntityLiving.width, pEntityLiving.posY - 0.5D + (double)(rnd.nextFloat() * pEntityLiving.height), (pEntityLiving.posZ + (double)(rnd.nextFloat() * pEntityLiving.width * 2.0F)) - (double)pEntityLiving.width, d, d1, d2);
			}
			GL11.glDisable(GL11.GL_CULL_FACE);
			/*b173//*/GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
		return flag;
	}

	private void loadBlockTexture() {
		if (mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion() < 160) return;
		Object var4 = Modchu_Reflect.invokeMethod("Minecraft", "func_110434_K", mod_Modchu_ModchuLib.modchu_Main.getMinecraft());
		Modchu_Reflect.invokeMethod("TextureManager", "func_110577_a", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, var4, new Object[]{ Modchu_Reflect.invokeMethod("TextureManager", "func_130087_a", new Class[]{ int.class }, var4, new Object[]{ 0 }) });
		//TextureManager var4 = Minecraft.getMinecraft().func_110434_K();
		//var4.func_110577_a(var4.func_130087_a(0));
	}

	private boolean isBTWItem(Item var1) {
		Class c = Modchu_Reflect.loadClass("net.minecraft.src.forge.ITextureProvider");
		if (c != null) ;else Modchu_Reflect.loadClass("forge.ITextureProvider");
		if (c != null) {
			Class[] var3 = var1.getClass().getInterfaces();
			for (int var4 = 0; var4 < var3.length; ++var4) {
				if (var3[var4] == c) return true;
			}
		} else {
			c = Modchu_Reflect.loadClass("net.minecraft.src.FCItemMattock");
			if (c!= null
					&& c.isInstance(var1)) return true;
			c = Modchu_Reflect.loadClass("FCItemMattock");
			if (c!= null
					&& c.isInstance(var1)) return true;
		}
		return false;
	}

	public void setRotatePriority(int pValue) {
		// 回転変換を行う順序、rot???を指定する
		rotatePriority = pValue;
	}

	protected void setRotation() {
		// 変換順位の設定
		switch (rotatePriority) {
		case RotXYZ:
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			break;
		case RotXZY:
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			break;
		case RotYXZ:
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			break;
		case RotYZX:
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			break;
		case RotZXY:
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			break;
		case RotZYX:
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			break;
		}
	}

	public void renderObject(float par1, boolean b) {
		// レンダリング、あと子供も
		if (showModel) {
			GL11.glScalef(scaleX, scaleY, scaleZ);
			GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, matrix);
			if (b) GL11.glCallList(displayList);
		}
		if (childModels != null) {
			MMM_ModelRenderer modelRenderer;
			for (int i = 0; i < childModels.size(); i++) {
				modelRenderer = childModels.get(i);
				if (modelRenderer != null) modelRenderer.render(par1, b);
			}
		}
	}

	@Override
	public void render(float par1)
	{
		render(par1, showModel);
	}

	public void render(float par1, boolean b)
	{
		if (isHidden) return;

		if (showModel
				&& !compiled) {
			compileDisplayList(par1);
		}

		GL11.glPushMatrix();
		GL11.glTranslatef(offsetX, offsetY, offsetZ);

		if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
			GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		}
		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
			setRotation();
		}
		renderObject(par1, b);
		GL11.glPopMatrix();
	}

	@Override
	public void renderWithRotation(float par1) {
		if (isHidden) {
			return;
		}

		if (showModel
				&& !compiled) {
			compileDisplayList(par1);
		}

		GL11.glPushMatrix();
		GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

		setRotation();

		GL11.glCallList(displayList);
		GL11.glPopMatrix();
	}

	@Override
	public void postRender(float par1)
	{
		if (showModel
				&& !compiled)
		{
			compileDisplayList(par1);
		}

		GL11.glPushMatrix();
		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
			GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

			setRotation();
		} else if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
			GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		}

		if (pearent != null) {
			pearent.postRender(par1);
		}
		GL11.glPopMatrix();
	}

	public void postRenderAll(float par1, boolean b) {
		if (isHidden) {
			return;
		}

		if (b
				&& !compiled) {
			compileDisplayList(par1);
		}

		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
			GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

			setRotation();
		} else if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
			GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		}
		// ポストレンダリング、あと子供も
		GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, matrix);

		if (childModels != null) {
			for (int i = 0; i < childModels.size(); i++) {
				((Modchu_ModelRenderer) childModels.get(i)).postRenderAll(par1, b);
			}
		}
	}

	/**
	* Compiles a GL display list for this model
	*/
	public void compileDisplayList(float par1)
	{
		displayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		Tessellator tessellator = Tessellator.instance;
		for (int i = 0; i < cubeList.size(); i++)
		{
			cubeList.get(i).render(tessellator, par1);
		}

		GL11.glEndList();
		compiled = true;
	}

	public void preRotateRender(float f) {
		//
		if(setParentsRotate() && !parentModel.showModel) {
			return;
		}
		if(isHidden) {
			return;
		}
		if(!showModel) {
			return;
		}
		float f1 = rotationPointX;
		float f2 = rotationPointY;
		float f3 = rotationPointZ;
		float f4 = rotateAngleX;
		float f5 = rotateAngleY;
		float f6 = rotateAngleZ;
		GL11.glPushMatrix();
		postRender(f);
		rotationPointX = 0.0F;
		rotationPointY = 0.0F;
		rotationPointZ = 0.0F;
		rotateAngleX = 0.0F;
		rotateAngleY = 0.0F;
		rotateAngleZ = 0.0F;

		if(!angleFirst) {
			GL11.glTranslatef(preRotationPointX * f, preRotationPointY * f, preRotationPointZ * f);
		}
		if(preRotateAngleZ != 0.0F) {
			GL11.glRotatef(preRotateAngleZ * 57.29578F, 0.0F, 0.0F, 1.0F);
		}
		if(preRotateAngleY != 0.0F) {
			GL11.glRotatef(preRotateAngleY * 57.29578F, 0.0F, 1.0F, 0.0F);
		}
		if(preRotateAngleX != 0.0F) {
			GL11.glRotatef(preRotateAngleX * 57.29578F, 1.0F, 0.0F, 0.0F);
		}
		if(angleFirst) {
			GL11.glTranslatef(preRotationPointX * f, preRotationPointY * f, preRotationPointZ * f);
		}
		render(f);

		GL11.glPopMatrix();

		rotationPointX = f1;
		rotationPointY = f2;
		rotationPointZ = f3;
		rotateAngleX = f4;
		rotateAngleY = f5;
		rotateAngleZ = f6;
	}

	public void preRotateRenderDeg(float f) {
		// preRotationAngleの値を角度で入れる（90°とか）
		if(setParentsRotate() && !parentModel.showModel) {
			return;
		}
		if(isHidden) {
			return;
		}
		if(!showModel) {
			return;
		}
		float f1 = rotationPointX;
		float f2 = rotationPointY;
		float f3 = rotationPointZ;
		float f4 = rotateAngleX;
		float f5 = rotateAngleY;
		float f6 = rotateAngleZ;
		GL11.glPushMatrix();
		postRender(f);
		rotationPointX = 0.0F;
		rotationPointY = 0.0F;
		rotationPointZ = 0.0F;
		rotateAngleX = 0.0F;
		rotateAngleY = 0.0F;
		rotateAngleZ = 0.0F;
		if(!angleFirst) {
			GL11.glTranslatef(preRotationPointX * f, preRotationPointY * f, preRotationPointZ * f);
		}
		if(preRotateAngleZ != 0.0F) {
			GL11.glRotatef(preRotateAngleZ, 0.0F, 0.0F, 1.0F);
		}
		if(preRotateAngleY != 0.0F) {
			GL11.glRotatef(preRotateAngleY, 0.0F, 1.0F, 0.0F);
		}
		if(preRotateAngleX != 0.0F) {
			GL11.glRotatef(preRotateAngleX, 1.0F, 0.0F, 0.0F);
		}
		if(angleFirst) {
			GL11.glTranslatef(preRotationPointX * f, preRotationPointY * f, preRotationPointZ * f);
		}
		render(f);
		GL11.glPopMatrix();
		rotationPointX = f1;
		rotationPointY = f2;
		rotationPointZ = f3;
		rotateAngleX = f4;
		rotateAngleY = f5;
		rotateAngleZ = f6;
	}

	protected boolean setParentsRotate() {
		// 親があるならその間接情報をコピー
		if(parentModel != null) {
			rotationPointX = parentModel.rotationPointX;
			rotationPointY = parentModel.rotationPointY;
			rotationPointZ = parentModel.rotationPointZ;
			rotateAngleX = parentModel.rotateAngleX;
			rotateAngleY = parentModel.rotateAngleY;
			rotateAngleZ = parentModel.rotateAngleZ;
			return true;
		} else {
			return false;
		}
	}

	public void setPreRotationPointLM(float f, float f1, float f2) {
		preRotationPointX = f;
		preRotationPointY = f1;
		preRotationPointZ = f2;
	}

	public void individuallyHidePreRotateRender(float par1) {
		if (!isHidden)
		{
			GL11.glPushMatrix();
			preRotateRender(par1);
			if (showModel
					&& !compiled)
			{
				compileDisplayList(par1);
			}

			Iterator var2;
			MMM_ModelRenderer var3;

			if (preRotateAngleX == 0.0F && preRotateAngleY == 0.0F && preRotateAngleZ == 0.0F)
			{
				if (rotationPointX == 0.0F && rotationPointY == 0.0F && rotationPointZ == 0.0F)
				{
					GL11.glCallList(displayList);

					if (childModels != null)
					{
						var2 = childModels.iterator();

						while (var2.hasNext())
						{
							var3 = (MMM_ModelRenderer)var2.next();
							if (var3.showModel) var3.render(par1);
						}
					}
				}
				else
				{
					GL11.glPushMatrix();
					GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
					GL11.glCallList(displayList);

					if (childModels != null)
					{
						var2 = childModels.iterator();

						while (var2.hasNext())
						{
							var3 = (MMM_ModelRenderer)var2.next();
							if (var3.showModel) var3.render(par1);
						}
					}

					GL11.glPopMatrix();
				}
			}
			else
			{
				GL11.glPushMatrix();
				GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

				if (preRotateAngleZ != 0.0F)
				{
					GL11.glRotatef(preRotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
				}

				if (preRotateAngleY != 0.0F)
				{
					GL11.glRotatef(preRotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
				}

				if (preRotateAngleX != 0.0F)
				{
					GL11.glRotatef(preRotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
				}

				GL11.glCallList(displayList);

				if (childModels != null)
				{
					var2 = childModels.iterator();

					while (var2.hasNext())
					{
						var3 = (MMM_ModelRenderer)var2.next();
						if (var3.showModel) var3.render(par1);
					}
				}

				GL11.glPopMatrix();
			}
			GL11.glPopMatrix();
		}
	}

	public void removeChild(MMM_ModelRenderer par1ModelRenderer)
	{
		if (childModels == null)
		{
			childModels = new ArrayList();
			return;
		}

		childModels.remove(par1ModelRenderer);
	}

	public void clearChildModels() {
		childModels.clear();
	}

	private Modchu_ModelRenderer makeBall(float var1, float var2, float var3,
			float var4, float var5, float var6) {
		float[][] var7 = new float[][] { { 0.0F, 4.9745197F, -0.0F },
				{ 0.0F, 3.5175202F, 3.5175202F },
				{ 2.4997F, 3.5175202F, 2.4872599F },
				{ 3.5351F, 3.5175202F, -0.0F },
				{ 2.4997F, 3.5175202F, -2.4872599F },
				{ 0.0F, 3.5175202F, -3.5175202F },
				{ -2.4997F, 3.5175202F, -2.4872599F },
				{ -3.5351F, 3.5175202F, -0.0F },
				{ -2.4997F, 3.5175202F, 2.4872599F },
				{ 0.0F, 0.0F, 4.9745197F }, { 3.5351F, 0.0F, 3.5175202F },
				{ 4.99939F, 0.0F, 0.0F }, { 3.5351F, -0.0F, -3.5175202F },
				{ 0.0F, -0.0F, -4.9745197F }, { -3.5351F, -0.0F, -3.5175202F },
				{ -4.99939F, 0.0F, 0.0F }, { -3.5351F, 0.0F, 3.5175202F },
				{ 0.0F, -3.5175202F, 3.5175202F },
				{ 2.4997F, -3.5175202F, 2.4872599F },
				{ 3.5351F, -3.5175202F, 0.0F },
				{ 2.4997F, -3.5175202F, -2.4872599F },
				{ 0.0F, -3.5175202F, -3.5175202F },
				{ -2.4997F, -3.5175202F, -2.4872599F },
				{ -3.5351F, -3.5175202F, 0.0F },
				{ -2.4997F, -3.5175202F, 2.4872599F },
				{ 0.0F, -4.9745197F, 0.0F } };
		float[][] var8 = new float[][] {
				{ (float) textureOffsetX / textureWidth,
						(float) (textureOffsetY + 1) / textureHeight },
				{ (float) (textureOffsetX + 1) / textureWidth,
						(float) (textureOffsetY + 1) / textureHeight },
				{ (float) (textureOffsetX + 1) / textureWidth,
						(float) textureOffsetY / textureHeight },
				{ (float) textureOffsetX / textureWidth,
						(float) textureOffsetY / textureHeight } };
		float[][] var9 = new float[][] { { 0.0F, 1.0F, 0.0F },
				{ 0.0F, 0.663167F, 0.748436F },
				{ 0.527909F, 0.663594F, 0.529984F },
				{ 0.747673F, 0.664052F, 0.0F },
				{ 0.527909F, 0.663594F, -0.529984F },
				{ 0.0F, 0.663167F, -0.748436F },
				{ -0.527909F, 0.663594F, -0.529984F },
				{ -0.747673F, 0.664052F, 0.0F },
				{ -0.527909F, 0.663594F, 0.529984F },
				{ 0.0F, 0.0F, 0.999969F }, { 0.706076F, 0.0F, 0.70809F },
				{ 1.0F, 0.0F, 0.0F }, { 0.706107F, 0.0F, -0.70809F },
				{ 0.0F, 0.0F, -0.999969F }, { -0.706076F, 0.0F, -0.70809F },
				{ -1.0F, 0.0F, 0.0F }, { -0.706107F, 0.0F, 0.70809F },
				{ 0.0F, -0.663167F, 0.748436F },
				{ 0.527909F, -0.663594F, 0.529984F },
				{ 0.747673F, -0.664052F, 0.0F },
				{ 0.527909F, -0.663594F, -0.529984F },
				{ 0.0F, -0.663167F, -0.748436F },
				{ -0.527909F, -0.663594F, -0.529984F },
				{ -0.747673F, -0.664052F, 0.0F },
				{ -0.527909F, -0.663594F, 0.529984F }, { 0.0F, -1.0F, 0.0F } };
		int[][][] var10 = new int[][][] {
				{ { 1 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 } },
				{ { 1 }, { 0, 2, 3 }, { 0, 1, 2 }, { 0, 2, 3 } },
				{ { 1 }, { 0, 3, 4 }, { 0, 1, 2 }, { 0, 3, 4 } },
				{ { 1 }, { 0, 4, 5 }, { 0, 1, 2 }, { 0, 4, 5 } },
				{ { 1 }, { 0, 5, 6 }, { 0, 1, 2 }, { 0, 5, 6 } },
				{ { 1 }, { 0, 6, 7 }, { 0, 1, 2 }, { 0, 6, 7 } },
				{ { 1 }, { 0, 7, 8 }, { 0, 1, 2 }, { 0, 7, 8 } },
				{ { 1 }, { 0, 8, 1 }, { 0, 1, 2 }, { 0, 8, 1 } },
				{ { 1 }, { 1, 9, 10, 2 }, { 0, 1, 2, 3 }, { 1, 9, 10, 2 } },
				{ { 1 }, { 2, 10, 11, 3 }, { 0, 1, 2, 3 }, { 2, 10, 11, 3 } },
				{ { 1 }, { 3, 11, 12, 4 }, { 0, 1, 2, 3 }, { 3, 11, 12, 4 } },
				{ { 1 }, { 4, 12, 13, 5 }, { 0, 1, 2, 3 }, { 4, 12, 13, 5 } },
				{ { 1 }, { 5, 13, 14, 6 }, { 0, 1, 2, 3 }, { 5, 13, 14, 6 } },
				{ { 1 }, { 6, 14, 15, 7 }, { 0, 1, 2, 3 }, { 6, 14, 15, 7 } },
				{ { 1 }, { 7, 15, 16, 8 }, { 0, 1, 2, 3 }, { 7, 15, 16, 8 } },
				{ { 1 }, { 8, 16, 9, 1 }, { 0, 1, 2, 3 }, { 8, 16, 9, 1 } },
				{ { 1 }, { 9, 17, 18, 10 }, { 0, 1, 2, 3 }, { 9, 17, 18, 10 } },
				{ { 1 }, { 10, 18, 19, 11 }, { 0, 1, 2, 3 }, { 10, 18, 19, 11 } },
				{ { 1 }, { 11, 19, 20, 12 }, { 0, 1, 2, 3 }, { 11, 19, 20, 12 } },
				{ { 1 }, { 12, 20, 21, 13 }, { 0, 1, 2, 3 }, { 12, 20, 21, 13 } },
				{ { 1 }, { 13, 21, 22, 14 }, { 0, 1, 2, 3 }, { 13, 21, 22, 14 } },
				{ { 1 }, { 14, 22, 23, 15 }, { 0, 1, 2, 3 }, { 14, 22, 23, 15 } },
				{ { 1 }, { 15, 23, 24, 16 }, { 0, 1, 2, 3 }, { 15, 23, 24, 16 } },
				{ { 1 }, { 16, 24, 17, 9 }, { 0, 1, 2, 3 }, { 16, 24, 17, 9 } },
				{ { 1 }, { 17, 25, 18 }, { 0, 1, 2 }, { 17, 25, 18 } },
				{ { 1 }, { 18, 25, 19 }, { 0, 1, 2 }, { 18, 25, 19 } },
				{ { 1 }, { 19, 25, 20 }, { 0, 1, 2 }, { 19, 25, 20 } },
				{ { 1 }, { 20, 25, 21 }, { 0, 1, 2 }, { 20, 25, 21 } },
				{ { 1 }, { 21, 25, 22 }, { 0, 1, 2 }, { 21, 25, 22 } },
				{ { 1 }, { 22, 25, 23 }, { 0, 1, 2 }, { 22, 25, 23 } },
				{ { 1 }, { 23, 25, 24 }, { 0, 1, 2 }, { 23, 25, 24 } },
				{ { 1 }, { 24, 25, 17 }, { 0, 1, 2 }, { 24, 25, 17 } } };
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

	public void setCompiled(boolean b) {
		compiled = b;
	}

	//SmartMoving関連↓
	public void reset()
	{
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

	public void fadeStore(float var1)
	{
		if (previous != null)
		{
			Modchu_Reflect.setFieldObject(RendererData, "offsetX", previous, offsetX);
			Modchu_Reflect.setFieldObject(RendererData, "offsetY", previous, offsetY);
			Modchu_Reflect.setFieldObject(RendererData, "offsetZ", previous, offsetZ);
			Modchu_Reflect.setFieldObject(RendererData, "rotateAngleX", previous, rotateAngleX);
			Modchu_Reflect.setFieldObject(RendererData, "rotateAngleY", previous, rotateAngleY);
			Modchu_Reflect.setFieldObject(RendererData, "rotateAngleZ", previous, rotateAngleZ);
			Modchu_Reflect.setFieldObject(RendererData, "rotationPointX", previous, rotationPointX);
			Modchu_Reflect.setFieldObject(RendererData, "rotationPointY", previous, rotationPointY);
			Modchu_Reflect.setFieldObject(RendererData, "rotationPointZ", previous, rotationPointZ);
			Modchu_Reflect.setFieldObject(RendererData, "totalTime", previous, var1);
		}
	}

	public void fadeIntermediate(float var1)
	{
		if (previous != null) {
			float totalTime = (Float)Modchu_Reflect.getFieldObject(RendererData, "totalTime", previous);
			if (var1 - totalTime <= 2.0F) {
				float previousOffsetX = (Float)Modchu_Reflect.getFieldObject(RendererData, "offsetX", previous);
				float previousOffsetY = (Float)Modchu_Reflect.getFieldObject(RendererData, "offsetY", previous);
				float previousOffsetZ = (Float)Modchu_Reflect.getFieldObject(RendererData, "offsetZ", previous);
				float previousRotateAngleX = (Float)Modchu_Reflect.getFieldObject(RendererData, "rotateAngleX", previous);
				float previousRotateAngleY = (Float)Modchu_Reflect.getFieldObject(RendererData, "rotateAngleY", previous);
				float previousRotateAngleZ = (Float)Modchu_Reflect.getFieldObject(RendererData, "rotateAngleZ", previous);
				float previousRotationPointX = (Float)Modchu_Reflect.getFieldObject(RendererData, "rotationPointX", previous);
				float previousRotationPointY = (Float)Modchu_Reflect.getFieldObject(RendererData, "rotationPointY", previous);
				float previousRotationPointZ = (Float)Modchu_Reflect.getFieldObject(RendererData, "rotationPointZ", previous);
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

	private float GetIntermediatePosition(float var1, float var2, boolean var3, float var4, float var5)
	{
		return var3 && var2 != var1 ? var1 + (var2 - var1) * (var5 - var4) * 0.2F : var2;
	}

	private float GetIntermediateAngle(float var1, float var2, boolean var3, float var4, float var5)
	{
		if (var3 && var2 != var1)
		{
			while (var1 >= ((float)Math.PI * 2F))
			{
				var1 -= ((float)Math.PI * 2F);
			}

			while (var1 < 0.0F)
			{
				var1 += ((float)Math.PI * 2F);
			}

			while (var2 >= ((float)Math.PI * 2F))
			{
				var2 -= ((float)Math.PI * 2F);
			}

			while (var2 < 0.0F)
			{
				var2 += ((float)Math.PI * 2F);
			}

			if (var2 > var1 && var2 - var1 > (float)Math.PI)
			{
				var1 += ((float)Math.PI * 2F);
			}

			if (var2 < var1 && var1 - var2 > (float)Math.PI)
			{
				var2 += ((float)Math.PI * 2F);
			}

			return var1 + (var2 - var1) * (var5 - var4) * 0.2F;
		}
		else
		{
			return var2;
		}
	}
	//SmartMoving関連↑

/*//b181delete
	private void compileDisplayList(float par1)
	{
        displayList = GLAllocation.generateDisplayLists(1);
        GL11.glNewList(displayList, GL11.GL_COMPILE);
        Tessellator var2 = Tessellator.instance;
        Iterator var3 = cubeList.iterator();

        while (var3.hasNext())
    	{
            ModelBoxPlayerFormLittleMaid var4 = (ModelBoxPlayerFormLittleMaid)var3.next();
            var4.render(var2, par1);
    	}

        GL11.glEndList();
        compiled = true;
	}

	public ModelRenderer addBox(String par1Str, float par2, float par3, float par4, int par5, int par6, int par7)
	{
    	par1Str = boxName + "." + par1Str;
        TextureOffsetPlayerFormLittleMaid var8 = baseModel.getTextureOffset(par1Str);
        setTextureOffset(var8.textureOffsetX, var8.textureOffsetY);
        cubeList.add((new ModelBoxPlayerFormLittleMaid(this, textureOffsetX, textureOffsetY, par2, par3, par4, par5, par6, par7, 0.0F)).func_40671_a(par1Str));
        return this;
	}

	@Override
	public void addBox(float par1, float par2, float par3, int par4, int par5, int par6)
	{
        cubeList.add(new ModelBoxPlayerFormLittleMaid(this, textureOffsetX, textureOffsetY, par1, par2, par3, par4, par5, par6, 0.0F));
    	//return this;
	}

	@Override
	public void addBox(float par1, float par2, float par3, int par4, int par5, int par6, float par7)
	{
        cubeList.add(new ModelBoxPlayerFormLittleMaid(this, textureOffsetX, textureOffsetY, par1, par2, par3, par4, par5, par6, par7));
	}

	public void render(float par1)
	{
        if (!isHidden)
    	{
            if (showModel)
        	{
                if (!compiled)
            	{
                    compileDisplayList(par1);
            	}

                GL11.glTranslatef(field_82906_o, field_82908_p, field_82907_q);
                Iterator var2;
                Modchu_ModelRenderer var3;

                if (rotateAngleX == 0.0F && rotateAngleY == 0.0F && rotateAngleZ == 0.0F)
            	{
                    if (rotationPointX == 0.0F && rotationPointY == 0.0F && rotationPointZ == 0.0F)
                	{
                        GL11.glCallList(displayList);

                        if (childModels != null)
                    	{
                            var2 = childModels.iterator();

                            while (var2.hasNext())
                        	{
                                var3 = (Modchu_ModelRenderer)var2.next();
                                ((Modchu_ModelRenderer) var3).render(par1);
                        	}
                    	}
                	}
                    else
                	{
                        GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
                        GL11.glCallList(displayList);

                        if (childModels != null)
                    	{
                            var2 = childModels.iterator();

                            while (var2.hasNext())
                        	{
                                var3 = (Modchu_ModelRenderer)var2.next();
                                ((Modchu_ModelRenderer) var3).render(par1);
                        	}
                    	}

                        GL11.glTranslatef(-rotationPointX * par1, -rotationPointY * par1, -rotationPointZ * par1);
                	}
            	}
                else
            	{
                    GL11.glPushMatrix();
                    GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

                    if (rotateAngleZ != 0.0F)
                	{
                        GL11.glRotatef(rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                	}

                    if (rotateAngleY != 0.0F)
                	{
                        GL11.glRotatef(rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                	}

                    if (rotateAngleX != 0.0F)
                	{
                        GL11.glRotatef(rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                	}

                    GL11.glCallList(displayList);

                    if (childModels != null)
                	{
                        var2 = childModels.iterator();

                        while (var2.hasNext())
                    	{
                            var3 = (Modchu_ModelRenderer)var2.next();
                            ((Modchu_ModelRenderer) var3).render(par1);
                    	}
                	}

                    GL11.glPopMatrix();
            	}

                GL11.glTranslatef(-field_82906_o, -field_82908_p, -field_82907_q);
        	}
    	}
	}

	public void renderWithRotation(float par1)
	{
        if (!isHidden)
    	{
            if (showModel)
        	{
                if (!compiled)
            	{
                    compileDisplayList(par1);
            	}

                GL11.glPushMatrix();
                GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

                if (rotateAngleY != 0.0F)
            	{
                    GL11.glRotatef(rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
            	}

                if (rotateAngleX != 0.0F)
            	{
                    GL11.glRotatef(rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
            	}

                if (rotateAngleZ != 0.0F)
            	{
                    GL11.glRotatef(rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
            	}

                GL11.glCallList(displayList);
                GL11.glPopMatrix();
        	}
    	}
	}

	public void postRender(float par1)
	{
        if (!isHidden)
    	{
            if (showModel)
        	{
                if (!compiled)
            	{
                    compileDisplayList(par1);
            	}

                if (rotateAngleX == 0.0F && rotateAngleY == 0.0F && rotateAngleZ == 0.0F)
            	{
                    if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F)
                	{
                        GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
                	}
            	}
                else
            	{
                    GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

                    if (rotateAngleZ != 0.0F)
                	{
                        GL11.glRotatef(rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                	}

                    if (rotateAngleY != 0.0F)
                	{
                        GL11.glRotatef(rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                	}

                    if (rotateAngleX != 0.0F)
                	{
                        GL11.glRotatef(rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                	}
            	}
        	}
    	}
	}

	public void addChild(ModelRenderer modelrenderer)
	{
        if(childModels == null)
    	{
            childModels = new ArrayList();
    	}
        childModels.add(modelrenderer);
	}
*///b181delete
/*//b173delete
	public ModelRenderer setTextureSize(int i, int j)
	{
        textureWidth = i;
        textureHeight = j;
        return this;
	}
*///b173delete
}
