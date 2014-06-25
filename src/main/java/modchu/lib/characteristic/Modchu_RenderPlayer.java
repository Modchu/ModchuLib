package modchu.lib.characteristic;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_IRenderPlayerMaster;import modchu.lib.Modchu_Reflect;import modchu.lib.characteristic.recompileonly.Modchu_RenderPlayerBase;import modchu.model.multimodel.base.MultiModelBaseBiped;import modchu.pflm.PFLM_ConfigData;import modchu.pflm.PFLM_Main;import modchu.pflm.PFLM_ModelData;import modchu.pflm.PFLM_ModelDataMaster;import net.minecraft.client.Minecraft;import net.minecraft.client.entity.AbstractClientPlayer;import net.minecraft.client.model.ModelBase;import net.minecraft.client.renderer.entity.RenderManager;import net.minecraft.entity.Entity;import net.minecraft.entity.EntityLivingBase;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.util.ResourceLocation;import net.minecraftforge.client.event.RenderPlayerEvent;import net.minecraftforge.common.MinecraftForge;import org.lwjgl.opengl.GL11;public class Modchu_RenderPlayer extends Modchu_RenderPlayerBase {	public Modchu_RenderPlayer(Class c) {		Modchu_Debug.lDebug("Modchu_RenderPlayer init");		master = (Modchu_IRenderPlayerMaster) Modchu_Reflect.newInstance(c, new Class[]{ Object.class }, new Object[]{ this });	}	@Override	protected int shouldRenderPass(AbstractClientPlayer entityplayer, int i, float f) {		if (master != null) ;else return -1;		int i2 = setArmorModel(null, entityplayer, i, f, 0);		int i3 = master.shouldRenderPass(entityplayer, i, f);		i2 = i2 < 0				| i3 < 0 ? -1 : 1;		return i2;	}	protected int setArmorModel(MultiModelBaseBiped model, EntityPlayer entityplayer, int i, float f, int i2) {		if (master != null) return master.setArmorModel(model, entityplayer, i, f, i2);		return -1;	}	@Override	protected int shouldRenderPass(EntityLivingBase entityliving, int i, float f) {		return shouldRenderPass((AbstractClientPlayer) entityliving, i, f);	}	@Override	protected void preRenderCallback(AbstractClientPlayer entityliving, float f) {		float f1 = 0.9375F;		if (master != null) f1 = master.renderScale((Entity) entityliving, f);		if (!PFLM_Main.oldRender) GL11.glScalef(f1, f1, f1);	}	@Override	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {		preRenderCallback((AbstractClientPlayer) par1EntityLiving, par2);	}	public void superPreRenderCallback(Entity par1EntityLiving, float par2) {		super.preRenderCallback((EntityLivingBase) par1EntityLiving, par2);	}	@Override	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {		if (master != null) ;else return;		master.doRender(entity, d, d1, d2, f, f1);	}	@Override	public void superDoRenderLiving(Entity entity, double d, double d1, double d2, float f, float f1) {		PFLM_ModelData modelData = (PFLM_ModelData) PFLM_ModelDataMaster.instance.getPlayerData(entity);		mainModel = modelData.modelMain;		super.doRender((EntityLivingBase) entity, d, d1, d2, f, f1);	}	@Override	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {		renderEquippedItems((AbstractClientPlayer) entityliving, f);	}	@Override	protected void renderEquippedItems(AbstractClientPlayer entityplayer, float f) {		RenderPlayerEvent.Specials.Pre event = new RenderPlayerEvent.Specials.Pre(entityplayer, this, f);		if (MinecraftForge.EVENT_BUS.post(event)) return;		if (master != null) master.renderSpecials(((EntityPlayer) entityplayer), f);		MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Specials.Post(entityplayer, this, f));	}	@Override	protected void passSpecialRender(EntityLivingBase par1EntityLiving, double par2, double par4, double par6) {		if (PFLM_ConfigData.isRenderName) super.passSpecialRender(par1EntityLiving, par2, par4, par6);	}	@Override	public void renderFirstPersonArm(EntityPlayer entityplayer) {		if (master != null) master.renderFirstPersonArm(entityplayer, 2);	}	public void renderFirstPersonArm(EntityPlayer entityplayer, int i) {		//olddays導入時に2以外のint付きで呼ばれる。		if (master != null) master.renderFirstPersonArm(entityplayer, i);	}	public static boolean isActivatedForPlayer(AbstractClientPlayer entityplayer) {		if (master != null) return master.isActivatedForPlayer(((EntityPlayer) entityplayer));		return false;	}	@Override	protected void func_147906_a(Entity entityplayer, String par2Str, double d, double d1, double d2, int i) {		if (master != null) d1 = master.renderLivingLabel((Entity) entityplayer, par2Str, d, d1, d2, i);		super.func_147906_a(entityplayer, par2Str, d, d1, d2, i);	}	protected void renderName(EntityPlayer entityplayer, double d, double d1, double d2) {		if (master != null) master.renderLivingLabel(entityplayer, null, d, d1, d2, -1);	}	@Override	protected void renderModel(EntityLivingBase par1EntityLiving, float par2, float par3, float par4, float par5, float par6, float par7) {		if (master != null) master.renderModel((Entity) par1EntityLiving, par2, par3, par4, par5, par6, par7);	}	@Override	protected ResourceLocation getEntityTexture(Entity entity) {		return (ResourceLocation) PFLM_ModelDataMaster.instance.getResourceLocation(entity);	}	protected ResourceLocation getEntityTexture(Entity entity, int i) {		return (ResourceLocation) PFLM_ModelDataMaster.instance.getResourceLocation(entity, i);	}	protected void renderLivingAt(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6) {		renderLivingAt((AbstractClientPlayer) par1EntityLivingBase, par2, par4, par6);	}	public void superRenderLivingAt(Entity par1EntityLivingBase, double par2, double par4, double par6) {		super.renderLivingAt((EntityLivingBase) par1EntityLivingBase, par2, par4, par6);	}	@Override	protected void renderLivingAt(AbstractClientPlayer var1, double var2, double var4, double var6) {		if (master != null) master.renderPlayerSleep(((EntityPlayer) var1), var2, var4, var6);		//Class AbstractClientPlayer = Modchu_Reflect.loadClass("AbstractClientPlayer");		//Modchu_Reflect.invokeMethod(RenderPlayer.class, "func_77105_b", "renderPlayerSleep", new Class[]{ AbstractClientPlayer, double.class, double.class, double.class }, this, new Object[]{ var1, var2, var4, var6 });		super.renderLivingAt(var1, var2, var4, var6);	}	@Override	public void rotateCorpse(AbstractClientPlayer var1, float var2, float var3, float var4) {		if (master != null				&& !PFLM_Main.oldRender) master.rotatePlayer(((EntityPlayer) var1), var2, var3, var4);		PFLM_ModelData modelData = (PFLM_ModelData) PFLM_ModelDataMaster.instance.getPlayerData(var1);		if (!modelData.getCapsValueBoolean(modelData.caps_isSleeping)) super.rotateCorpse((AbstractClientPlayer) var1, var2, var3, var4);	}	public void superRotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {		super.rotateCorpse(par1EntityLivingBase, par2, par3, par4);	}	@Override	protected int getColorMultiplier(EntityLivingBase par1EntityLivingBase, float par2, float par3) {		return master != null ? master.getColorMultiplier(((Entity) par1EntityLivingBase), par2, par3) : 0;	}	@Override	protected int inheritRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {		return master != null ? master.inheritRenderPass(((Entity) par1EntityLivingBase), par2, par3) : 0;	}	public ModelBase getRenderPassModel() {		return renderPassModel;	}	public RenderManager getRenderManager() {		return renderManager;	}	//smartMoving関連↓	public void renderPlayerAt(AbstractClientPlayer var1, double var2, double var4, double var6) {		if (master != null) master.renderPlayerAt(((EntityPlayer) var1), var2, var4, var6);	}	public static void renderGuiIngame(Minecraft var0) {		if (master != null) master.renderGuiIngame(var0);	}	//smartMoving関連↑	@Override	public Modchu_IRenderPlayerMaster getRenderPlayerMaster() {		return master;	}	@Override	public void superRotateCorpse(Entity par1EntityLivingBase, float par2, float par3, float par4) {		super.rotateCorpse((EntityLivingBase) par1EntityLivingBase, par2, par3, par4);	}}