package modchu.lib.forge.mc172_179;import java.util.HashMap;import modchu.lib.forge.mc172_179.Modchu_RendererLivingEntity;import net.minecraft.client.model.ModelBase;import net.minecraft.client.renderer.entity.RenderManager;import net.minecraft.entity.Entity;import net.minecraft.entity.EntityLiving;import net.minecraft.entity.EntityLivingBase;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.util.ResourceLocation;public class Modchu_RenderPlayerDummy extends Modchu_RendererLivingEntity {	public Modchu_RenderPlayerDummy(HashMap<String, Object> map) {		super(map);	}	@Override	protected void preRenderCallback(EntityLivingBase entityliving, float f) {		if (master != null) ;else return;		master.preRenderCallback(entityliving, f);	}	@Override	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {		if (master != null) ;else return;		master.doRender(entity, d, d1, d2, f, f1);	}	@Override	public void superDoRenderLiving(Object entity, double d, double d1, double d2, float f, float f1) {		super.superDoRenderLiving((EntityLiving) entity, d, d1, d2, f, f1);	}	@Override	public void passSpecialRender(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6) {	}	protected void renderSpecials(EntityPlayer entityplayer, float f) {	}	public void superRotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {		super.rotateCorpse(par1EntityLivingBase, par2, par3, par4);	}	public void superRenderLivingAt(Entity par1EntityLivingBase, double par2, double par4, double par6) {		super.renderLivingAt((EntityLivingBase) par1EntityLivingBase, par2, par4, par6);	}	@Override	protected void renderModel(EntityLivingBase entityliving, float f, float f1, float f2, float f3, float f4, float f5) {		if (master != null) ;else return;		master.renderModel(entityliving, f, f1, f2, f3, f4, f5);	}	@Override	public RenderManager getRenderManager() {		return renderManager;	}	@Override	protected ResourceLocation getEntityTexture(Entity entity) {		return master != null ? (ResourceLocation) (master.getEntityTexture(entity)) : null;	}	protected ResourceLocation getEntityTexture(Entity entity, int i) {		return master != null ? (ResourceLocation) (master.getEntityTexture(entity, i)) : null;	}	public void allModelInit(Object entity, boolean debug) {		if (master != null) ;else return;		master.allModelInit(entity, debug);	}	public void modelArmorInit(Object entity, boolean debug) {		if (master != null) ;else return;		master.modelArmorInit(entity, debug);	}	@Override	public void superPreRenderCallback(Object entityLivingBase, float par2) {		//super.preRenderCallback((EntityLivingBase) entityLivingBase, par2);	}	@Override	public void superPassSpecialRender(Object entityLiving, double d, double d1, double d2) {		super.passSpecialRender((EntityLivingBase) entityLiving, d, d1, d2);	}	// ~179	@Override	protected int shouldRenderPass(EntityLivingBase entityliving, int i, float f) {		if (master != null) ;else return -1;		int i2 = master.setArmorModel(entityliving, i, f);		int i3 = master.shouldRenderPass(entityliving, i, f);		i2 = i2 < 0				| i3 < 0 ? -1 : 1;		return i2;	}	@Override	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {	}	@Override	public ModelBase getRenderPassModel() {		return renderPassModel;	}}