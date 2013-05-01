package net.minecraft.src;

import java.lang.reflect.Method;
import java.nio.FloatBuffer;
import java.util.Random;

import net.minecraft.src.ModelBase;
import net.minecraft.src.TextureOffset;
import net.minecraft.move.Reflect;
import net.minecraft.move.render.ModelRotationRenderer;
import net.minecraft.move.render.RendererData;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Modchu_ModelRotationRenderer extends ModelRotationRenderer
{
    private int textureOffsetX;
    private int textureOffsetY;
    private ModelBase baseModel;

    public float preRotationPointX;
    public float preRotationPointY;
    public float preRotationPointZ;
    public float preRotateAngleX;
    public float preRotateAngleY;
    public float preRotateAngleZ;
    public boolean angleFirst;
    public ModelRotationRenderer parentModel;
    private static FloatBuffer buffer = BufferUtils.createFloatBuffer(16);
    private static float array[] = new float[16];
    public RendererData previous;
	public FloatBuffer matrix;
	public boolean isInvertX;
	public ItemStack itemstack;
	public boolean adjust;
    private static Random rnd = new Random();
    private static Method _compileDisplayList = Modchu_Reflect.getMethod(ModelRenderer.class, "compileDisplayList", "d", new Class[] {Float.TYPE});

    public Modchu_ModelRotationRenderer(ModelBase modelbase, int i, int j, ModelRotationRenderer modelrotationrenderer)
    {
    	super(modelbase, i, j, modelrotationrenderer);
    	init(modelbase, i, j, modelrotationrenderer);
    }

    public Modchu_ModelRotationRenderer(ModelBase modelbase) {
    	super(modelbase, 0, 0, null);
    	init(modelbase, 0, 0, null);
    }

    public void init(ModelBase modelbase, int i, int j, ModelRotationRenderer modelrotationrenderer) {
    	preRotationPointX = 0.0F;
    	preRotationPointY = 0.0F;
    	preRotationPointZ = 0.0F;
    	preRotateAngleX = 0.0F;
    	preRotateAngleY = 0.0F;
    	preRotateAngleZ = 0.0F;
    	angleFirst = false;	// 変換を当てる順番
    	//parentModel = null;	// 同じ回転軸になる親
    	textureOffsetX = i;
    	textureOffsetY = j;
    	isInvertX = false;
    	adjust = true;
    	matrix = BufferUtils.createFloatBuffer(16);
    }

	public Modchu_ModelRotationRenderer addPlate(String s, float f, float f1, float f2, int i, int j, int k) {
        s = (new StringBuilder()).append(boxName).append(".").append(s).toString();
        TextureOffset textureoffset = baseModel.getTextureOffset(s);
        setTextureOffset(textureoffset.textureOffsetX, textureoffset.textureOffsetY);
        cubeList.add((new Modchu_ModelPlate(this, textureOffsetX, textureOffsetY, f, f1, f2, i, j, k, 0.0F)).func_40671_a(s));
        return this;
    }

    public Modchu_ModelRotationRenderer addPlate(float f, float f1, float f2, int i, int j, int k) {
        cubeList.add(new Modchu_ModelPlate(this, textureOffsetX, textureOffsetY, f, f1, f2, i, j, k, 0.0F));
        return this;
    }

    public Modchu_ModelRotationRenderer addPlate(float f, float f1, float f2, int i, int j, int k, float f3) {
        cubeList.add(new Modchu_ModelPlate(this, textureOffsetX, textureOffsetY, f, f1, f2, i, j, k, f3));
        return this;
    }
    public void clearCubeList() {
    	cubeList.clear();
    	compiled = false;
    	childModels.clear();
    }

    public Modchu_ModelRotationRenderer setItemStack(ItemStack pItemStack) {
    	itemstack = pItemStack;
    	return this;
    }

    public void renderItems(EntityLiving pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, ItemStack pItemStack, float scale, int addSupport) {
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

    public void renderItems(EntityLiving pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, ItemStack pItemStack) {
    	itemstack = pItemStack;
    	renderItems(pEntityLiving, pRender, pRealBlock, pAction, 1.0F);
    }

    public void renderItems(EntityLiving pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction) {
    	if (itemstack == null) return;
    	renderItems(pEntityLiving, pRender, pRealBlock, pAction, 1.0F);
    }

    public void renderItems(EntityLiving pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, float scale) {
    	if (itemstack == null) return;

    	// アイテムのレンダリング
    	GL11.glPushMatrix();

		Item item = itemstack.getItem();
    	// アイテムの種類による表示位置の補正
    	if (adjust) {
//    		GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

    		if (pRealBlock && (item instanceof ItemBlock)) {
    			Block block = Block.blocksList[itemstack.itemID];
    			float f2 = 0.625F;
    			scale = f2 * scale;
    			GL11.glTranslatef(0F, -scale * 0.495F, 0F);
    			if (block instanceof BlockFlower) GL11.glRotatef(12F, 0F, 1F, 0);
    			else {
/*
    				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
*/
    				GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
    			}
    			GL11.glScalef(scale, -scale, -scale);
    		} else {
    			float sx = scale;
    			float sy = scale;
    			float sz = scale;
    			float var6;
/*
    			if (pRealBlock && item.shiftedIndex == Item.skull.shiftedIndex) {
    				scale = 1.0625F * scale;
    				sx = scale;
    				sy = -scale;
    				sz = -scale;
    			}
    			else
*/
    			 if (itemstack.itemID < 256 && RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType())) {
    				var6 = 0.5F;
//    				GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
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
//    				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
    				GL11.glScalef(var6, var6, var6);
    				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
    				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
    				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
    			}
    			GL11.glScalef(sx, sy, sz);
    		}
    	}
/*
    	if (pRealBlock && item.shiftedIndex == Item.skull.shiftedIndex)
    	{
    		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		String var6 = "";
    		if (itemstack.hasTagCompound() && itemstack.getTagCompound().hasKey("SkullOwner"))
    		{
    			var6 = itemstack.getTagCompound().getString("SkullOwner");
    		}
    		TileEntitySkullRenderer.skullRenderer.func_82393_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack.getItemDamage(), var6);
    	} else
*/
    	 if (pRealBlock && itemstack.getItem() instanceof ItemBlock) {
    		pRender.loadTexture("/terrain.png");
    		GL11.glEnable(GL11.GL_CULL_FACE);
    		pRender.renderBlocks.renderBlockAsItem(Block.blocksList[itemstack.itemID], itemstack.getItemDamage(), 1.0F);
    		GL11.glDisable(GL11.GL_CULL_FACE);
    	} else {
    		if (pRender.renderManager != null
    				&& pRender.renderManager.itemRenderer != null) {
    			// アイテムに色付け
    			String s1 = "/gui/items.png";
    			int renderPasses = itemstack.getItem().requiresMultipleRenderPasses() ? 1 : 0;
    			if (mod_Modchu_ModchuLib.isForge) {
    				if (renderPasses == 1) renderPasses =
    						(Integer) Modchu_Reflect.invokeMethod(Item.class, "getRenderPasses", new Class[]{ int.class },
    								itemstack.getItem(), new Object[]{ itemstack.getItemDamage() }) - 1;
    				s1 = (String) Modchu_Reflect.invokeMethod(Item.class, "getTextureFile", itemstack.getItem());
    				//Modchu_Debug.Debug("isForge pRender.loadTexture s1="+s1+" renderPasses="+renderPasses);
    			} else if (mod_Modchu_ModchuLib.isBTW
    					&& isBTWItem(itemstack.getItem())) {
    				s1 = "/btwmodtex/btwitems01.png";
    			}
    			pRender.loadTexture(s1);
    			for (int j = 0; j <= renderPasses; j++) {
    				if (!mod_Modchu_ModchuLib.isSSP
    						| renderPasses > 0) {
    					int k = itemstack.getItem().getColorFromDamage(itemstack.getItemDamage(), j);
    					float f15 = (float)(k >> 16 & 0xff) / 255F;
    					float f17 = (float)(k >> 8 & 0xff) / 255F;
    					float f19 = (float)(k & 0xff) / 255F;
    					GL11.glColor4f(f15, f17, f19, 1.0F);
    				}
    				pRender.renderManager.itemRenderer.renderItem(pEntityLiving, itemstack, j);
    			}
    		}
    	}

    	GL11.glPopMatrix();
    }

    public boolean renderDecoBlock(EntityLiving pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, float scale, int addSupport) {
    	//DecoBlock, FavBlock用描画
    	Item item = itemstack.getItem();
    	Block block = Block.blocksList[item.shiftedIndex];
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
    		pRender.loadTexture("/terrain.png");
    		GL11.glEnable(GL11.GL_CULL_FACE);
    		if (rotate) GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
    		else GL11.glRotatef(12F, 0.0F, 1.0F, 0.0F);
//-@-b173
/*
    		int k = itemstack.getItem().getColorFromDamage(itemstack.getItemDamage(), 0);
    		float f9 = (float)(k >> 16 & 0xff) / 255F;
    		float f10 = (float)(k >> 8 & 0xff) / 255F;
    		float f12 = (float)(k & 0xff) / 255F;
    		GL11.glColor4f(f9, f10, f12, 1.0F);
*/
//@-@b173
    		if (scale > 1.0F) GL11.glScalef(scale, scale, scale);
    		// b166deleteGL11.glColor4f(f20, f20, f20, 1.0F);
    		if (translatef) GL11.glTranslatef(translatefX, translatefY, translatefZ);
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

    public void preRotateRender(float f) {
    	render(f);
    }

    public void render(float var1)
    {
        if (this.preRender(var1))
        {
            this.preTransform(var1, true, (ModelRotationRenderer)null);
            GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, matrix);
            GL11.glCallList(this.displayList);
            this.postTransform(var1, true, (ModelRotationRenderer)null);
        }
    }

    public boolean preRender(float var1)
    {
        if (this.isHidden)
        {
            return false;
        }
        else if (!this.showModel)
        {
            return false;
        }
        else
        {
            if (!this.compiled)
            {
            	compileDisplayList(var1);
                this.compiled = true;
            }

            return true;
        }
    }

    public void preTransform(float f, boolean flag, ModelRotationRenderer modelrotationrenderer)
    {
        if (base != null && !ignoreBase)
        {
        	base.preTransform(f, flag, this);
        }

        if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F || ignoreSuperRotation)
        {
            if (flag)
            {
                GL11.glPushMatrix();
            }

            GL11.glTranslatef(rotationPointX * f, rotationPointY * f, rotationPointZ * f);

            if (ignoreSuperRotation)
            {
                buffer.rewind();
                GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, buffer);
                buffer.get(array);
                GL11.glLoadIdentity();
                GL11.glTranslatef(array[12] / array[15], array[13] / array[15], array[14] / array[15]);
            }

            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;

            rotate(this.rotationOrder, this.rotateAngleX, this.rotateAngleY, this.rotateAngleZ);
            GL11.glScalef(scaleX, scaleY, scaleZ);
            GL11.glTranslatef(offsetX, offsetY, offsetZ);
        }
        else if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F || scaleX != 1.0F || scaleY != 1.0F || scaleZ != 1.0F || offsetX != 0.0F || offsetY != 0.0F || offsetZ != 0.0F)
        {
            GL11.glTranslatef(rotationPointX * f, rotationPointY * f, rotationPointZ * f);
            GL11.glScalef(scaleX, scaleY, scaleZ);
            GL11.glTranslatef(offsetX, offsetY, offsetZ);
        }
    }

    private static void rotate(int var0, float var1, float var2, float var3)
    {
        if (var0 == ZXY && var2 != 0.0F)
        {
            GL11.glRotatef(var2 * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
        }

        if (var0 == YXZ && var3 != 0.0F)
        {
            GL11.glRotatef(var3 * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
        }

        if ((var0 == YZX || var0 == YXZ || var0 == ZXY || var0 == ZYX) && var1 != 0.0F)
        {
            GL11.glRotatef(var1 * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
        }

        if ((var0 == XZY || var0 == ZYX) && var2 != 0.0F)
        {
            GL11.glRotatef(var2 * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
        }

        if ((var0 == XYZ || var0 == XZY || var0 == YZX || var0 == ZXY || var0 == ZYX) && var3 != 0.0F)
        {
            GL11.glRotatef(var3 * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
        }

        if ((var0 == XYZ || var0 == YXZ || var0 == YZX) && var2 != 0.0F)
        {
            GL11.glRotatef(var2 * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
        }

        if ((var0 == XYZ || var0 == XZY) && var1 != 0.0F)
        {
            GL11.glRotatef(var1 * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
        }
    }

	public void render(float f1, float f, float g, float h) {
		GL11.glPushMatrix();
		GL11.glScalef(f, g, h);
		render(f1);
		GL11.glPopMatrix();
	}

    public void superPostRender(float var1) {
    	super.postRender(var1);
	}

    public void superPostRenderAll(float var1) {
    	if (base != null) ((Modchu_ModelRotationRenderer) base).superPostRender(var1);
    	super.postRender(var1);
	}

    public void setPreRotationPointLM(float f, float f1, float f2) {
    	rotationPointX = f;
    	rotationPointY = f1;
    	rotationPointZ = f2;
    }

    // バージョン変更に依存させないための関数群

    public void addBoxLM(float f, float f1, float f2, int i, int j, int k)
    {
        addBox(f, f1, f2, i, j, k);
    }

    public void addBoxLM(float f, float f1, float f2, int i, int j, int k, float f3)
    {
    	addBox(f, f1, f2, i, j, k, f3);
    }

    public void setRotationPointLM(float f, float f1, float f2)
    {
    	setRotationPoint(f, f1, f2);
    }

    public void renderLM(float f)
    {
    	render(f);
    }

    public void renderWithRotationLM(float f)
    {
    	renderWithRotation(f);
    }

    public void postRenderLM(float f)
    {
    	postRender(f);
    }

    public boolean getMirror() {
    	return mirror;
    }

    public void setMirror(boolean flag) {
    	mirror = flag;
    }

    public boolean getVisible() {
    	return showModel;
    }

    public void setVisible(boolean flag) {
    	showModel = flag;
    }

    public float getRotateAngleX() {
    	return rotateAngleX;
    }

    public float setRotateAngleX(float f)
    {
        rotateAngleX = f;
        return rotateAngleX;
    }

    public float getRotateAngleY() {
    	return rotateAngleY;
    }

    public float setRotateAngleY(float f)
    {
        rotateAngleY = f;
        return rotateAngleY;
    }

    public float getRotateAngleZ() {
    	return rotateAngleZ;
    }

    public float setRotateAngleZ(float f)
    {
        rotateAngleZ = f;
        return rotateAngleZ;
    }

    public void setRotateAngle(float f, float f1, float f2)
    {
        rotateAngleX = f;
        rotateAngleY = f1;
        rotateAngleZ = f2;
    }

    public float getRotationPointX() {
    	return rotationPointX;
    }

    public float setRotationPointX(float f)
    {
        rotationPointX = f;
        return rotationPointX;
    }

    public float getRotationPointY() {
    	return rotationPointY;
    }

    public float setRotationPointY(float f)
    {
        rotationPointY = f;
        return rotationPointY;
    }

    public float getRotationPointZ() {
    	return rotationPointZ;
    }

    public float setRotationPointZ(float f)
    {
        rotationPointZ = f;
        return rotationPointZ;
    }

	public void setBase(Modchu_ModelRotationRenderer modelRotationRendererPlayerFormLittleMaid) {
		base = modelRotationRendererPlayerFormLittleMaid;
	}

	public Modchu_ModelRotationRenderer loadMatrix() {
		GL11.glLoadMatrix(matrix);
		//superPostRenderAll(0.0625F);
		//float f = 0.5F;
		//GL11.glScalef(f, f, f);
		//GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, matrix);
		//GL11.glLoadMatrix(matrix);
    	if (isInvertX) {
    		GL11.glScalef(-1F, 1F, 1F);
    	}
    	return this;
    }

	private void compileDisplayList(float par1)
    {
    	displayList = GLAllocation.generateDisplayLists(1);
    	GL11.glNewList(displayList, GL11.GL_COMPILE);
    	Tessellator tessellator = Tessellator.instance;
    	for (int i = 0; i < cubeList.size(); i++)
    	{
    		((ModelBox)cubeList.get(i)).render(tessellator, par1);
    	}

    	GL11.glEndList();
    	compiled = true;
    }
}
