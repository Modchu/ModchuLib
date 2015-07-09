package modchu.lib.modloader.mc162;import java.util.HashMap;import net.minecraft.src.Entity;import net.minecraft.src.EntityLiving;import net.minecraft.src.EntityLivingBase;import net.minecraft.src.EntityPlayer;import net.minecraft.src.ModelBase;import net.minecraft.src.RenderManager;import net.minecraft.src.ResourceLocation;public class Modchu_RenderPlayerDummy extends Modchu_RendererLivingEntity {	public Modchu_RenderPlayerDummy(HashMap<String, Object> map) {		super(map);	}	@Override	protected void preRenderCallback(EntityLivingBase entityliving, float f) {		if (master != null) ;else return;		master.preRenderCallback(entityliving, f);	}	@Override	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {		if (master != null) ;else return;		master.doRender(entity, d, d1, d2, f, f1);	}	@Override	public void superDoRenderLiving(Object entity, double d, double d1, double d2, float f, float f1) {		super.superDoRenderLiving((EntityLiving) entity, d, d1, d2, f, f1);	}	@Override	public void passSpecialRender(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6) {	}	protected void renderSpecials(EntityPlayer entityplayer, float f) {	}	public void superRotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {		super.rotateCorpse(par1EntityLivingBase, par2, par3, par4);	}	public void superRenderLivingAt(Entity par1EntityLivingBase, double par2, double par4, double par6) {		super.renderLivingAt((EntityLivingBase) par1EntityLivingBase, par2, par4, par6);	}	@Override	protected void renderModel(EntityLivingBase entityliving, float f, float f1, float f2, float f3, float f4, float f5) {		if (master != null) ;else return;		master.renderModel(entityliving, f, f1, f2, f3, f4, f5);	}	@Override	public RenderManager getRenderManager() {		return renderManager;	}	@Override	protected ResourceLocation getEntityTexture(Entity entity) {		return master != null ? (ResourceLocation) (master.getEntityTexture(entity)) : null;	}	protected ResourceLocation getEntityTexture(Entity entity, int i) {		return master != null ? (ResourceLocation) (master.getEntityTexture(entity, i)) : null;	}	@Override	public void superPreRenderCallback(Object entityLivingBase, float par2) {		//super.preRenderCallback((EntityLivingBase) entityLivingBase, par2);	}	@Override	public void superPassSpecialRender(Object entityLiving, double d, double d1, double d2) {		super.passSpecialRender((EntityLivingBase) entityLiving, d, d1, d2);	}	// ~179	@Override	protected int shouldRenderPass(EntityLivingBase entityliving, int i, float f) {		if (master != null) ;else return -1;		int i2 = master.setArmorModel(entityliving, i, f);		int i3 = master.shouldRenderPass(entityliving, i, f);		i2 = i2 < 0				| i3 < 0 ? -1 : 1;		return i2;	}	@Override	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {	}	@Override	public ModelBase getRenderPassModel() {		return renderPassModel;	}	// 180~/*	@Override	public Object getRenderPassModel(int i) {		return renderPassModel;	}	@Override	public void setRenderPassModel(Object model, Object model2) {	}	@Override	public int setArmorModel(Object model, Object entityplayer, int i, float f, int i2) {		if (master != null) ;else return -1;		return master.setArmorModel(model, entityplayer, i, f, i2);	}	@Override	public Object getLayerArmorBase() {		return null;	}	@Override	public void setLayerArmorBase(Object layerBipedArmor) {	}	@Override	public Object getLayerHeldItem() {		return null;	}	@Override	public void setLayerHeldItem(Object layerHeldItem) {	}	@Override	public Object getLayerCustomHead() {		return null;	}	@Override	public void setLayerCustomHead(Object layerCustomHead) {	}	@Override	public List getLayerList() {		return null;	}	@Override	public Object superGetEntityTexture(Object entity) {		return null;	}	@Override	public Object superGetEntityTexture(Object entity, int i) {		return null;	}	@Override	public boolean superBindEntityTexture(Object entity) {		return false;	}	@Override	public void superBindTexture(Object resourceLocation) {	}	@Override	public void superDoRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {	}	@Override	public Object superGetFontRendererFromRenderManager() {		return null;	}	@Override	public Object superFunc_177068_d() {		return null;	}	@Override	public int superSetArmorModel(Object object, Object entity, int i, float f, int j) {		return -1;	}	@Override	public void superRenderEquippedItems(Object entityliving, float f) {	}	@Override	public int superShouldRenderPass(Object entityliving, int i, float f) {		return -1;	}	@Override	public int superInheritRenderPass(Object entity, int par2, float par3) {		return -1;	}	@Override	public void superRenderModel(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {	}	@Override	public int superGetColorMultiplier(Object entity, float par2, float par3) {		return -1;	}	@Override	public void superRenderLivingLabel(Object entityplayer, String par2Str, double d, double d1, double d2, int i) {	}	@Override	public Object superGetMainModel() {		return mainModel;	}	@Override	public boolean superAddLayer(Object layerRenderer) {		return false;	}	@Override	public boolean superRemoveLayer(Object layerRenderer) {		return false;	}	@Override	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {		return -1;	}	@Override	public boolean superFunc_177088_c(Object entityLivingBase) {		return false;	}	@Override	public void superFunc_180565_e() {	}	@Override	public boolean superFunc_177090_c(Object entityLivingBase, float p_177090_2_) {		return false;	}	@Override	public boolean superFunc_177092_a(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {		return false;	}	@Override	public void superFunc_177091_f() {	}	@Override	public float superGetSwingProgress(Object entityLivingBase, float p_77040_2_) {		return 0.0F;	}	@Override	public float superHandleRotationFloat(Object entityLivingBase, float p_77044_2_) {		return 0.0F;	}	@Override	public void superFunc_177093_a(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {	}	@Override	public float superGetDeathMaxRotation(Object entityLivingBase) {		return 0.0F;	}	@Override	public boolean superCanRenderName(Object entityLivingBase) {		return false;	}	@Override	public void superSetRenderOutlines(boolean p_177086_1_) {	}	@Override	public void superRenderName(Object entity, double x, double y, double z) {	}	@Override	public boolean superShouldRender(Object entity, Object iCamera, double camX, double camY, double camZ) {		return false;	}	@Override	public void superFunc_82422_c() {	}	@Override	public void superRenderLivingAt(Object entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_) {	}	@Override	public void superRotateCorpse(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {	}	@Override	public void superFunc_177069_a(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {	}*/}