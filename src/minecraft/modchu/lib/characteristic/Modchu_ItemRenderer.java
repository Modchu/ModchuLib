package modchu.lib.characteristic;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_IItemRendererMaster;import modchu.lib.Modchu_Reflect;import net.minecraft.client.Minecraft;import net.minecraft.client.entity.EntityPlayerSP;import net.minecraft.client.gui.MapItemRenderer;import net.minecraft.client.renderer.ItemRenderer;import net.minecraft.client.renderer.OpenGlHelper;import net.minecraft.client.renderer.RenderHelper;import net.minecraft.client.renderer.Tessellator;import net.minecraft.client.renderer.entity.Render;import net.minecraft.client.renderer.entity.RenderManager;import net.minecraft.client.renderer.entity.RenderPlayer;import net.minecraft.client.renderer.texture.TextureManager;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.item.EnumAction;import net.minecraft.item.Item;import net.minecraft.item.ItemStack;import net.minecraft.util.MathHelper;import net.minecraft.util.ResourceLocation;import net.minecraft.world.World;import net.minecraft.world.storage.MapData;import org.lwjgl.opengl.GL11;import org.lwjgl.opengl.GL12;public class Modchu_ItemRenderer extends Modchu_ItemRendererBase {	public Modchu_IItemRendererMaster master;	public static ResourceLocation RES_MAP_BACKGROUND;	public Modchu_ItemRenderer(Class masterClass) {		super(Minecraft.getMinecraft());		Modchu_Debug.lDebug("Modchu_ItemRenderer init");		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Object.class }, new Object[]{ this });		Modchu_Debug.lDebug("Modchu_ItemRenderer init instance="+instance);		master = instance instanceof Modchu_IItemRendererMaster ? (Modchu_IItemRendererMaster) instance : null;	}	public void renderItemInFirstPerson(float f) {		if (RES_MAP_BACKGROUND != null) ;else RES_MAP_BACKGROUND = (ResourceLocation) Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, 1);		ItemStack var7 = Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem();		try {			// ローカル変数を確保			itemToRender = (ItemStack)Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, 4);			equippedProgress = (Float)Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, 5);			prevEquippedProgress = (Float)Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, 6);		} catch (Exception e) {		}		if (var7 != null) {			if (Modchu_Reflect.loadClass("ItemMap").isInstance(var7.getItem())) {				super.renderItemInFirstPerson(f);				return;			}			if (master.getFlipHorizontal()) {				//GL11.glPushMatrix();				GL11.glScalef(-1.0F, 1.0F, 1.0F);				//GL11.glPopMatrix();			}		} else {			renderItemInFirstPersonNomal(f);			return;		}		//Modchu_Debug.mDebug("renderItemInFirstPerson");		super.renderItemInFirstPerson(f);	}	public void renderItemInFirstPersonNomal(float par1) {    	float var2 = prevEquippedProgress + (equippedProgress - prevEquippedProgress) * par1;    	EntityPlayerSP thePlayer = (EntityPlayerSP) Modchu_AS.get(Modchu_AS.minecraftThePlayer);    	float var4 = thePlayer.prevRotationPitch + (thePlayer.rotationPitch - thePlayer.prevRotationPitch) * par1;        GL11.glPushMatrix();        GL11.glRotatef(var4, 1.0F, 0.0F, 0.0F);        GL11.glRotatef(thePlayer.prevRotationYaw + (thePlayer.rotationYaw - thePlayer.prevRotationYaw) * par1, 0.0F, 1.0F, 0.0F);        RenderHelper.enableStandardItemLighting();        GL11.glPopMatrix();        float var6 = thePlayer.prevRenderArmPitch + (thePlayer.renderArmPitch - thePlayer.prevRenderArmPitch) * par1;        float var7 = thePlayer.prevRenderArmYaw + (thePlayer.renderArmYaw - thePlayer.prevRenderArmYaw) * par1;        GL11.glRotatef((thePlayer.rotationPitch - var6) * 0.1F, 1.0F, 0.0F, 0.0F);        GL11.glRotatef((thePlayer.rotationYaw - var7) * 0.1F, 0.0F, 1.0F, 0.0F);        ItemStack var8 = itemToRender;        World theWorld = (World) Modchu_AS.get(Modchu_AS.minecraftTheWorld);        float var9 = theWorld.getLightBrightness(MathHelper.floor_double(thePlayer.posX), MathHelper.floor_double(thePlayer.posY), MathHelper.floor_double(thePlayer.posZ));        var9 = 1.0F;        int var10 = theWorld.getLightBrightnessForSkyBlocks(MathHelper.floor_double(thePlayer.posX), MathHelper.floor_double(thePlayer.posY), MathHelper.floor_double(thePlayer.posZ), 0);        int var11 = var10 % 65536;        int var12 = var10 / 65536;        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)var11 / 1.0F, (float)var12 / 1.0F);        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);        float var13;        float var20;        float var22;        if (var8 != null)        {            var10 = Item.itemsList[var8.itemID].getColorFromItemStack(var8, 0);            var20 = (float)(var10 >> 16 & 255) / 255.0F;            var22 = (float)(var10 >> 8 & 255) / 255.0F;            var13 = (float)(var10 & 255) / 255.0F;            GL11.glColor4f(var9 * var20, var9 * var22, var9 * var13, 1.0F);        }        else        {            GL11.glColor4f(var9, var9, var9, 1.0F);        }        float var14;        float var15;        float var16;        float var21;        Render var27;        RenderPlayer var26;        Object textureManager = Modchu_AS.get(Modchu_AS.minecraftTextureManager);        if (var8 != null && var8.itemID == Item.map.itemID)        {            GL11.glPushMatrix();            var21 = 0.8F;            var20 = thePlayer.getSwingProgress(par1);            var22 = MathHelper.sin(var20 * (float)Math.PI);            var13 = MathHelper.sin(MathHelper.sqrt_float(var20) * (float)Math.PI);            GL11.glTranslatef(-var13 * 0.4F, MathHelper.sin(MathHelper.sqrt_float(var20) * (float)Math.PI * 2.0F) * 0.2F, -var22 * 0.2F);            var20 = 1.0F - var4 / 45.0F + 0.1F;            if (var20 < 0.0F)            {                var20 = 0.0F;            }            if (var20 > 1.0F)            {                var20 = 1.0F;            }            var20 = -MathHelper.cos(var20 * (float)Math.PI) * 0.5F + 0.5F;            GL11.glTranslatef(0.0F, 0.0F * var21 - (1.0F - var2) * 1.2F - var20 * 0.5F + 0.04F, -0.9F * var21);            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);            GL11.glRotatef(var20 * -85.0F, 0.0F, 0.0F, 1.0F);            GL11.glEnable(GL12.GL_RESCALE_NORMAL);            Modchu_Reflect.invokeMethod("TextureManager", "func_110577_a", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, textureManager, new Object[]{ Modchu_Reflect.invokeMethod("AbstractClientPlayer", "func_110306_p", thePlayer) });            //mc.func_110434_K().func_110577_a(var3.func_110306_p());            for (var12 = 0; var12 < 2; ++var12)            {                int var24 = var12 * 2 - 1;                GL11.glPushMatrix();                GL11.glTranslatef(-0.0F, -0.6F, 1.1F * (float)var24);                GL11.glRotatef((float)(-45 * var24), 1.0F, 0.0F, 0.0F);                GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);                GL11.glRotatef(59.0F, 0.0F, 0.0F, 1.0F);                GL11.glRotatef((float)(-65 * var24), 0.0F, 1.0F, 0.0F);                var27 = RenderManager.instance.getEntityRenderObject(thePlayer);                var26 = (RenderPlayer)var27;                var16 = 1.0F;                GL11.glScalef(var16, var16, var16);                var26.renderFirstPersonArm(thePlayer);                GL11.glPopMatrix();            }            var22 = thePlayer.getSwingProgress(par1);            var13 = MathHelper.sin(var22 * var22 * (float)Math.PI);            var14 = MathHelper.sin(MathHelper.sqrt_float(var22) * (float)Math.PI);            GL11.glRotatef(-var13 * 20.0F, 0.0F, 1.0F, 0.0F);            GL11.glRotatef(-var14 * 20.0F, 0.0F, 0.0F, 1.0F);            GL11.glRotatef(-var14 * 80.0F, 1.0F, 0.0F, 0.0F);            var15 = 0.38F;            GL11.glScalef(var15, var15, var15);            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);            GL11.glTranslatef(-1.0F, -1.0F, 0.0F);            var16 = 0.015625F;            GL11.glScalef(var16, var16, var16);            Modchu_Reflect.invokeMethod("TextureManager", "func_110577_a", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, textureManager, new Object[]{ Modchu_Reflect.getPrivateValue(ItemRenderer.class, this, 1) });            //mc.func_110434_K().func_110577_a(field_110931_c);            Tessellator var30 = Tessellator.instance;            GL11.glNormal3f(0.0F, 0.0F, -1.0F);            var30.startDrawingQuads();            byte var29 = 7;            var30.addVertexWithUV((double)(0 - var29), (double)(128 + var29), 0.0D, 0.0D, 1.0D);            var30.addVertexWithUV((double)(128 + var29), (double)(128 + var29), 0.0D, 1.0D, 1.0D);            var30.addVertexWithUV((double)(128 + var29), (double)(0 - var29), 0.0D, 1.0D, 0.0D);            var30.addVertexWithUV((double)(0 - var29), (double)(0 - var29), 0.0D, 0.0D, 0.0D);            var30.draw();            MapData var19 = Item.map.getMapData(var8, theWorld);            if (var19 != null)            {            	Modchu_Reflect.invokeMethod(MapItemRenderer.class, "renderMap", new Class[]{ EntityPlayer.class, TextureManager.class, MapData.class }, mapItemRenderer, new Object[]{ thePlayer, textureManager, var19 });            	//mapItemRenderer.renderMap(var3, textureManager, var19);            }            GL11.glPopMatrix();        }        else if (var8 != null)        {            GL11.glPushMatrix();            var21 = 0.8F;            if (thePlayer.getItemInUseCount() > 0)            {                EnumAction var23 = var8.getItemUseAction();                if (var23 == EnumAction.eat || var23 == EnumAction.drink)                {                    var22 = (float)thePlayer.getItemInUseCount() - par1 + 1.0F;                    var13 = 1.0F - var22 / (float)var8.getMaxItemUseDuration();                    var14 = 1.0F - var13;                    var14 = var14 * var14 * var14;                    var14 = var14 * var14 * var14;                    var14 = var14 * var14 * var14;                    var15 = 1.0F - var14;                    GL11.glTranslatef(0.0F, MathHelper.abs(MathHelper.cos(var22 / 4.0F * (float)Math.PI) * 0.1F) * (float)((double)var13 > 0.2D ? 1 : 0), 0.0F);                    GL11.glTranslatef(var15 * 0.6F, -var15 * 0.5F, 0.0F);                    GL11.glRotatef(var15 * 90.0F, 0.0F, 1.0F, 0.0F);                    GL11.glRotatef(var15 * 10.0F, 1.0F, 0.0F, 0.0F);                    GL11.glRotatef(var15 * 30.0F, 0.0F, 0.0F, 1.0F);                }            }            else            {                var20 = thePlayer.getSwingProgress(par1);                var22 = MathHelper.sin(var20 * (float)Math.PI);                var13 = MathHelper.sin(MathHelper.sqrt_float(var20) * (float)Math.PI);                GL11.glTranslatef(-var13 * 0.4F, MathHelper.sin(MathHelper.sqrt_float(var20) * (float)Math.PI * 2.0F) * 0.2F, -var22 * 0.2F);            }            GL11.glTranslatef(0.7F * var21, -0.65F * var21 - (1.0F - var2) * 0.6F, -0.9F * var21);            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);            GL11.glEnable(GL12.GL_RESCALE_NORMAL);            var20 = thePlayer.getSwingProgress(par1);            var22 = MathHelper.sin(var20 * var20 * (float)Math.PI);            var13 = MathHelper.sin(MathHelper.sqrt_float(var20) * (float)Math.PI);            GL11.glRotatef(-var22 * 20.0F, 0.0F, 1.0F, 0.0F);            GL11.glRotatef(-var13 * 20.0F, 0.0F, 0.0F, 1.0F);            GL11.glRotatef(-var13 * 80.0F, 1.0F, 0.0F, 0.0F);            var14 = 0.4F;            GL11.glScalef(var14, var14, var14);            float var17;            float var18;            if (thePlayer.getItemInUseCount() > 0)            {                EnumAction var25 = var8.getItemUseAction();                if (var25 == EnumAction.block)                {                    GL11.glTranslatef(-0.5F, 0.2F, 0.0F);                    GL11.glRotatef(30.0F, 0.0F, 1.0F, 0.0F);                    GL11.glRotatef(-80.0F, 1.0F, 0.0F, 0.0F);                    GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);                }                else if (var25 == EnumAction.bow)                {                    GL11.glRotatef(-18.0F, 0.0F, 0.0F, 1.0F);                    GL11.glRotatef(-12.0F, 0.0F, 1.0F, 0.0F);                    GL11.glRotatef(-8.0F, 1.0F, 0.0F, 0.0F);                    GL11.glTranslatef(-0.9F, 0.2F, 0.0F);                    var16 = (float)var8.getMaxItemUseDuration() - ((float)thePlayer.getItemInUseCount() - par1 + 1.0F);                    var17 = var16 / 20.0F;                    var17 = (var17 * var17 + var17 * 2.0F) / 3.0F;                    if (var17 > 1.0F)                    {                        var17 = 1.0F;                    }                    if (var17 > 0.1F)                    {                        GL11.glTranslatef(0.0F, MathHelper.sin((var16 - 0.1F) * 1.3F) * 0.01F * (var17 - 0.1F), 0.0F);                    }                    GL11.glTranslatef(0.0F, 0.0F, var17 * 0.1F);                    GL11.glRotatef(-335.0F, 0.0F, 0.0F, 1.0F);                    GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);                    GL11.glTranslatef(0.0F, 0.5F, 0.0F);                    var18 = 1.0F + var17 * 0.2F;                    GL11.glScalef(1.0F, 1.0F, var18);                    GL11.glTranslatef(0.0F, -0.5F, 0.0F);                    GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);                    GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);                }            }            if (var8.getItem().shouldRotateAroundWhenRendering())            {                GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);            }            if (var8.getItem().requiresMultipleRenderPasses())            {            	RenderManager.instance.itemRenderer.renderItem(thePlayer, var8, 0);                int var28 = Item.itemsList[var8.itemID].getColorFromItemStack(var8, 1);                var16 = (float)(var28 >> 16 & 255) / 255.0F;                var17 = (float)(var28 >> 8 & 255) / 255.0F;                var18 = (float)(var28 & 255) / 255.0F;                GL11.glColor4f(var9 * var16, var9 * var17, var9 * var18, 1.0F);                RenderManager.instance.itemRenderer.renderItem(thePlayer, var8, 1);            }            else            {            	RenderManager.instance.itemRenderer.renderItem(thePlayer, var8, 0);            }            GL11.glPopMatrix();        }//-@-132        else if (!thePlayer.isInvisible())        {//@-@132    		master.renderItemInFirstPerson(par1, equippedProgress, prevEquippedProgress);//-@-132        }//@-@132        GL11.glDisable(GL12.GL_RESCALE_NORMAL);        RenderHelper.disableStandardItemLighting();    }	public void drawFirstPersonHand(Render r, int h) {		master.drawFirstPersonHand(r, h);	}}