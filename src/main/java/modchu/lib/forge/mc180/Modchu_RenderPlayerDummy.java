package modchu.lib.forge.mc180;import java.util.HashMap;import net.minecraft.client.model.ModelBase;import net.minecraft.client.renderer.entity.RenderManager;import net.minecraft.entity.Entity;import net.minecraft.entity.EntityLivingBase;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.util.ResourceLocation;public class Modchu_RenderPlayerDummy extends Modchu_RenderLivingBase {	public Modchu_RenderPlayerDummy(HashMap<String, Object> map) {		super(map);	}	@Override	public int setArmorModel(Object model, Object entityplayer, int i, float f, int i2) {		if (master != null); else return -1;		return master.setArmorModel(model, entityplayer, i, f, i2);	}	@Override	protected void preRenderCallback(EntityLivingBase entityliving, float f) {		if (master != null); else return;		master.preRenderCallback(entityliving, f);	}	@Override	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {		if (master != null); else return;		master.doRender(entity, d, d1, d2, f, f1);	}	@Override	public void passSpecialRender(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6) {	}	protected void renderSpecials(EntityPlayer entityplayer, float f) {	}	@Override	protected void renderModel(EntityLivingBase entityliving, float f, float f1, float f2, float f3, float f4, float f5) {		if (master != null); else return;		master.renderModel(entityliving, f, f1, f2, f3, f4, f5);	}	@Override	public RenderManager getRenderManager() {		return renderManager;	}	@Override	protected ResourceLocation getEntityTexture(Entity entity) {		return master != null ? (ResourceLocation) (master.getEntityTexture(entity)) : null;	}	protected ResourceLocation getEntityTexture(Entity entity, int i) {		return master != null ? (ResourceLocation) (master.getEntityTexture(entity, i)) : null;	}	// ~179	protected int shouldRenderPass(EntityLivingBase entityliving, int i, float f) {		if (master != null); else return -1;		int i2 = master.setArmorModel(entityliving, i, f);		int i3 = master.shouldRenderPass(entityliving, i, f);		i2 = i2 < 0				| i3 < 0 ? -1 : 1;		return i2;	}	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {	}	@Override	public ModelBase getRenderPassModel() {		return (ModelBase) getRenderPassModel(0);	}}