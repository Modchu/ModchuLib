
package net.minecraft.src;

//b181deleteimport java.util.ArrayList;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Modchu_ModelRenderer extends ModelRenderer
{
	public float preRotationPointX;
	public float preRotationPointY;
	public float preRotationPointZ;
	public float preRotateAngleX;
	public float preRotateAngleY;
	public float preRotateAngleZ;
	public boolean angleFirst;
	public ModelRenderer parentModel;
	public String boxName;
    private static Random rnd = new Random();

	//littleMaidMob����
	/**
	 * (180F / (float)Math.PI)
	 */
	public static final float radFactor = 57.295779513082320876798154814105F;
	/**
	 * PI / 180
	 */
	public static final float degFactor = 0.01745329251994329576923690768489F;
	public static final int RotXYZ = 0;
	public static final int RotXZY = 1;
	public static final int RotYXZ = 2;
	public static final int RotYZX = 3;
	public static final int RotZXY = 4;
	public static final int RotZYX = 5;
	public static final int ModeEquip = 0x000;
	public static final int ModeInventory = 0x001;
	public static final int ModeItemStack = 0x002;
	public static final int ModeParts = 0x010;
	private int textureOffsetX;
	private int textureOffsetY;
	private boolean compiled = false;
	private int displayList;
	private ModelBase baseModel;
	public int rotatePriority;
	public ItemStack itemstack;
	public boolean adjust;
	public FloatBuffer matrix;
	public boolean isInvertX;
	public float scaleX;
	public float scaleY;
	public float scaleZ;
	public ModelRenderer pearent;

	//SmartMoving����
	protected ModelRenderer base;
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
	public Modchu_ModelRenderer(ModelBase modelbase, int i, int j)
    {
		super(modelbase, i, j);
    	init(modelbase, i, j, null);
    }
//-@-b181
    public Modchu_ModelRenderer(ModelBase modelbase, int i, int j, String s)
    {
    	super(modelbase, s);
    	init(modelbase, i, j, s);
    }

	public Modchu_ModelRenderer(ModelBase modelbase, int i, int j, ModelRenderer modelRenderer) {
		this(modelbase, i, j);
		base = modelRenderer;
		if (base != null)
		{
			base.addChild(this);
		}
	}

    public Modchu_ModelRenderer(ModelBase modelbase) {
        this(modelbase, 0, 0);
    }

    public Modchu_ModelRenderer(ModelBase modelbase, String s) {
        this(modelbase, 64, 32, s);
    }

    public void init(ModelBase modelbase, int i, int j, String s) {
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
    	angleFirst = false;	// �ϊ��𓖂Ă鏇��
    	parentModel = null;	// ������]���ɂȂ�e
    	textureOffsetX = i;
    	textureOffsetY = j;
    	boxName = s;
    	itemstack = null;
    	adjust = true;
    	matrix = BufferUtils.createFloatBuffer(16);
    	isInvertX = false;
    	baseModel = modelbase;
    	pearent = null;
    	RendererData = mod_Modchu_ModchuLib.RendererData;
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

    public Modchu_ModelRenderer addPlate(String s, float f, float f1, float f2, int i, int j, int k) {
        s = (new StringBuilder()).append(boxName).append(".").append(s).toString();
        TextureOffset textureoffset = baseModel.getTextureOffset(s);
        setTextureOffset(textureoffset.textureOffsetX, textureoffset.textureOffsetY);
        cubeList.add((new MMM_ModelPlate(this, textureOffsetX, textureOffsetY, f, f1, f2, i, j, k, 0.0F)).func_78244_a(s));
        return this;
    }

    public Modchu_ModelRenderer addPlate(float f, float f1, float f2, int i, int j, int k) {
        cubeList.add(new MMM_ModelPlate(this, textureOffsetX, textureOffsetY, f, f1, f2, i, j, k, 0.0F));
        return this;
    }

    public Modchu_ModelRenderer addPlate(float f, float f1, float f2, int i, int j, int k, float f3) {
        cubeList.add(new MMM_ModelPlate(this, textureOffsetX, textureOffsetY, f, f1, f2, i, j, k, f3));
        return this;
    }

	public Modchu_ModelRenderer addPlateFreeShape(float[][] vertex, float[][] vertexN, int px, int py)
	{
		float[][] vt = { { textureOffsetX / textureWidth, (textureOffsetY + 1) / textureHeight }, { (textureOffsetX + 1) / textureWidth, (textureOffsetY + 1) / textureHeight }, { (textureOffsetX + 1) / textureWidth, textureOffsetY / textureHeight }, { textureOffsetX / textureWidth, textureOffsetY / textureHeight } };

		cubeList.add(new Modchu_ModelPlateFreeShape(this, textureOffsetX, textureOffsetY, vertex, vt, vertexN, null, 0.0F));
		return this;
	}

	public Modchu_ModelRenderer addPlateFreeShape(float[][] vertex, float[][] texUV, float[][] vertexN)
	{
		cubeList.add(new Modchu_ModelPlateFreeShape(this, textureOffsetX, textureOffsetY, vertex, texUV, vertexN, null, 0.0F));
		return this;
	}

    public Modchu_ModelRenderer addPlateFreeShape(float[][] var1, float[][] var2, float[][] var3, float[] var4)
    {
        cubeList.add(new Modchu_ModelPlateFreeShape(this, textureOffsetX, textureOffsetY, var1, var2, var3, var4, 0.0F));
        return this;
    }

    public Modchu_ModelRenderer addBall(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        return makeBall(var1, var2, var3, var4, var5, var6);
    }

    /**
     * �`��p�̃{�b�N�X�A�q�����N���A����
     */
    public void clearCubeList() {
    	cubeList.clear();
    	compiled = false;
    	childModels.clear();
    }

    public Modchu_ModelRenderer setItemStack(ItemStack pItemStack) {
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

    	// �A�C�e���̃����_�����O
    	GL11.glPushMatrix();

		Item item = itemstack.getItem();
    	// �A�C�e���̎�ނɂ��\���ʒu�̕␳
    	if (adjust) {
//    		GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

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

    		String s1 = "/terrain.png";
    		if (mod_Modchu_ModchuLib.isForge) {
    			s1 = (String) Modchu_Reflect.invokeMethod(Item.class, "getTextureFile", Item.itemsList[itemstack.itemID]);
    			//Modchu_Debug.Debug("isForge pRender.loadTexture s1="+s1);
    		}
    		pRender.loadTexture(s1);

    		GL11.glEnable(GL11.GL_CULL_FACE);
    		pRender.renderBlocks.renderBlockAsItem(Block.blocksList[itemstack.itemID], itemstack.getItemDamage(), 1.0F);
    		GL11.glDisable(GL11.GL_CULL_FACE);
    	} else {
    		if (pRender.renderManager != null
    				&& pRender.renderManager.itemRenderer != null) {
    			// �A�C�e���ɐF�t��
    			int renderPasses = itemstack.getItem().requiresMultipleRenderPasses() ? 1 : 0;

    			String s1 = "/gui/items.png";
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
    					int k = itemstack.getItem().getColorFromItemStack(itemstack, j);
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
    	//DecoBlock, FavBlock�p�`��
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
    		pRender.loadTexture("/terrain.png");
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

    public void setRotatePriority(int pValue) {
    	// ��]�ϊ����s�������Arot???���w�肷��
    	rotatePriority = pValue;
    }

	protected void setRotation() {
		// �ϊ����ʂ̐ݒ�
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

    public void renderObject(float par1, EntityLiving pEntityLiving) {
    	// �����_�����O�A���Ǝq����
    	if (showModel) {
    		GL11.glScalef(scaleX, scaleY, scaleZ);
    		GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, matrix);
    		if (!(baseModel instanceof MMM_ModelBiped) || ((MMM_ModelBiped)baseModel).isRendering) {
    			GL11.glCallList(displayList);
    		}
    	}
    	if (childModels != null) {
    		for (int i = 0; i < childModels.size(); i++) {
    			ModelRenderer modelRenderer = (ModelRenderer) childModels.get(i);
    			if (modelRenderer != null) {
    				if (modelRenderer instanceof Modchu_ModelRenderer) {
    					((Modchu_ModelRenderer) modelRenderer).render(par1, pEntityLiving);
    				} else{
    					modelRenderer.render(par1);
    				}
    			}
    		}
    	}
    }

    @Override
    public void render(float par1)
    {
    	render(par1, null);
    }

    public void render(float par1, EntityLiving pEntityLiving)
    {
    	if (isHidden) {
    		return;
    	}

    	if (showModel
    			&& !compiled) {
    		compileDisplayList(par1);
    	}

    		GL11.glPushMatrix();
    		if (offsetX != 0.0F | offsetY != 0.0F | offsetZ != 0.0F)
    			GL11.glTranslatef(offsetX, offsetY, offsetZ);

    		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
    			GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

    			setRotation();
    			renderObject(par1, pEntityLiving);

    		}
    		else if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F)
    		{
    			GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
    			renderObject(par1, pEntityLiving);
    			GL11.glTranslatef(-rotationPointX * par1, -rotationPointY * par1, -rotationPointZ * par1);
    		}
    		else
    		{
    			renderObject(par1, pEntityLiving);
    		}
    		if (offsetX != 0.0F | offsetY != 0.0F | offsetZ != 0.0F)
    			GL11.glTranslatef(-offsetX, -offsetY, -offsetZ);
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

    	if (pearent != null) {
    		pearent.postRender(par1);
    	}

    	if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
    		GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

    		setRotation();
    	} else if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
    		GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
    	}
    }

    public void postRenderAll(float par1, EntityLiving pEntityLiving) {
    	if (isHidden) {
    		return;
    	}

    	if (showModel
    			&& !compiled) {
    		compileDisplayList(par1);
    	}

    	if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
    		GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

    		setRotation();
    	} else if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
    		GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
    	}
    	// �|�X�g�����_�����O�A���Ǝq����
    	GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, matrix);

    	if (childModels != null) {
    		for (int i = 0; i < childModels.size(); i++) {
    			((MMM_ModelRenderer)childModels.get(i)).postRenderAll(par1, pEntityLiving);
    		}
    	}
    }

    /**
     * Compiles a GL display list for this model
     */
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

    /**
     * �p�[�c�`�掞�_�̃}�g���N�X��ݒ肷��B
     * ����ȑO�ɐݒ肳�ꂽ�}�g���N�X�͔j�������B
     */
    public Modchu_ModelRenderer loadMatrix() {
    	GL11.glLoadMatrix(matrix);
    	if (isInvertX) {
    		GL11.glScalef(-1F, 1F, 1F);
    	}
    	return this;
    }

    @Override
    public Modchu_ModelRenderer addBox(String par1Str, float par2, float par3, float par4, int par5, int par6, int par7) {
    	super.addBox(par1Str, par2, par3, par4, par5, par6, par7);
    	return this;
    }

    @Override
    public Modchu_ModelRenderer addBox(float par1, float par2, float par3, int par4, int par5, int par6) {
		super.addBox(par1, par2, par3, par4, par5, par6);
		return this;
    }

    @Override
    public void addBox(float par1, float par2, float par3, int par4, int par5, int par6, float par7) {
    	super.addBox(par1, par2, par3, par4, par5, par6, par7);
    }

    public Modchu_ModelRenderer setRotationPointLM(float f, float f1, float f2) {
    	setRotationPoint(f, f1, f2);
    	return this;
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

    public boolean setVisible(boolean flag) {
    	if (showModel != flag) {
    		showModel = flag;
    	}
    	return flag;
    }

    // Deg�t���͊p�x�w�肪�x���@
    public float getRotateAngleX() {
    	return rotateAngleX;
    }

    public float getRotateAngleDegX() {
    	return rotateAngleX * 57.295779513082320876798154814105F;
    }

    public float setRotateAngleX(float value) {
    	return rotateAngleX = value;
    }

    public float setRotateAngleDegX(float value) {
    	return rotateAngleX = value * 0.01745329251994329576923690768489F;
    }

    public float getRotateAngleY() {
    	return rotateAngleY;
    }

    public float getRotateAngleDegY() {
    	return rotateAngleY * 57.295779513082320876798154814105F;
    }

    public float setRotateAngleY(float value) {
    	return rotateAngleY = value;
    }

    public float setRotateAngleDegY(float value) {
    	return rotateAngleY = value * 0.01745329251994329576923690768489F;
    }

    public float getRotateAngleZ() {
    	return rotateAngleZ;
    }

    public float getRotateAngleDegZ() {
    	return rotateAngleZ * 57.295779513082320876798154814105F;
    }

    public float setRotateAngleZ(float value) {
    	return rotateAngleZ = value;
    }

    public float setRotateAngleDegZ(float value) {
    	return rotateAngleZ = value * 0.01745329251994329576923690768489F;
    }

    public Modchu_ModelRenderer setRotateAngle(float x, float y, float z) {
    	rotateAngleX = x;
    	rotateAngleY = y;
    	rotateAngleZ = z;
    	return this;
    }

    public Modchu_ModelRenderer setRotateAngleDeg(float x, float y, float z) {
    	rotateAngleX = x * 0.01745329251994329576923690768489F;
    	rotateAngleY = y * 0.01745329251994329576923690768489F;
    	rotateAngleZ = z * 0.01745329251994329576923690768489F;
    	return this;
    }

    public float getRotationPointX() {
    	return rotationPointX;
    }

    public float setRotationPointX(float value) {
    	rotationPointX = value;
    	return rotationPointX;
    }

    public float getRotationPointY() {
    	return rotationPointY;
    }

    public float setRotationPointY(float value) {
    	rotationPointY = value;
    	return rotationPointY;
    }

    public float getRotationPointZ() {
    	return rotationPointZ;
    }

    public float setRotationPointZ(float value) {
    	rotationPointZ = value;
    	return rotationPointZ;
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
    	// preRotationAngle�̒l���p�x�œ����i90���Ƃ��j
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
    	// �e������Ȃ炻�̊Ԑڏ����R�s�[
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

    // �o�[�W�����ύX�Ɉˑ������Ȃ����߂̊֐��Q

    public void addBoxLM(float f, float f1, float f2, int i, int j, int k) {
        addBox(f, f1, f2, i, j, k);
    }

    public void addBoxLM(float f, float f1, float f2, int i, int j, int k, float f3) {
    	addBox(f, f1, f2, i, j, k, f3);
    }

    public void renderLM(float f) {
    	render(f);
    }

    public void renderWithRotationLM(float f) {
    	renderWithRotation(f);
    }

    public void postRenderLM(float f) {
    	postRender(f);
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
            ModelRenderer var3;

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
                            var3 = (ModelRenderer)var2.next();
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
                            var3 = (ModelRenderer)var2.next();
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
                        var3 = (ModelRenderer)var2.next();
                        if (var3.showModel) var3.render(par1);
                    }
                }

                GL11.glPopMatrix();
            }
            GL11.glPopMatrix();
        }
    }

    public void removeChild(ModelRenderer par1ModelRenderer)
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

    public void setScale(float f, float f1, float f2) {
    	scaleX = f;
    	scaleY = f1;
    	scaleZ = f2;
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

    //SmartMoving�֘A��
    public void reset()
    {
        this.rotatePriority = XYZ;
        this.scaleX = 1.0F;
        this.scaleY = 1.0F;
        this.scaleZ = 1.0F;
        this.rotationPointX = 0.0F;
        this.rotationPointY = 0.0F;
        this.rotationPointZ = 0.0F;
        this.rotateAngleX = 0.0F;
        this.rotateAngleY = 0.0F;
        this.rotateAngleZ = 0.0F;
        this.ignoreBase = false;
        this.ignoreSuperRotation = false;
        this.forceRender = false;
        this.offsetX = 0.0F;
        this.offsetY = 0.0F;
        this.offsetZ = 0.0F;
        this.fadeOffsetX = false;
        this.fadeOffsetY = false;
        this.fadeOffsetZ = false;
        this.fadeRotateAngleX = false;
        this.fadeRotateAngleY = false;
        this.fadeRotateAngleZ = false;
        this.fadeRotationPointX = false;
        this.fadeRotationPointY = false;
        this.fadeRotationPointZ = false;
        this.previous = null;
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
    //SmartMoving�֘A��

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
