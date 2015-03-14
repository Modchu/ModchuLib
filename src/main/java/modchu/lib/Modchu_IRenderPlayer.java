package modchu.lib;public interface Modchu_IRenderPlayer extends Modchu_IRendererLivingEntity {	public Modchu_IRenderPlayerMaster getRenderPlayerMaster();	public void superRenderLivingAt(Object entityLivingBase, double d, double d1, double d2);	public void superRotateCorpse(Object entityLivingBase, float f, float f1, float f2);	public void superRotatePlayer(Object abstractClientPlayer, float var2, float var3, float var4);	public void superRenderFirstPersonArm(Object entityplayer, int i);	public boolean superIsActivatedForPlayer(Object entityPlayer);	public void superRenderPlayerSleep(Object entityPlayer, double var2, double var4, double var6);	public void superRenderPlayerAt(Object entityPlayer, double var2, double var4, double var6);	public void superRenderGuiIngame(Object var0);	public Object superFunc_180594_a(Object abstractClientPlayer);	public void superFunc_82422_c();	public void superRenderOffsetLivingLabel(Object abstractClientPlayer, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_);	public void superFunc_177139_c(Object abstractClientPlayer);	public void superFunc_177069_a(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_);	public int superSetArmorModel(Object object, Object entity, int i, float f, int j);	public void superRenderEquippedItems(Object entityliving, float f);	public int superShouldRenderPass(Object entityliving, int i, float f);	public int superInheritRenderPass(Object entity, int par2, float par3);	public void superRenderModel(Object entity, float par2, float par3, float par4, float par5, float par6, float par7);	public int superGetColorMultiplier(Object entity, float par2, float par3);	public void superRenderLivingLabel(Object entityplayer, String par2Str, double d, double d1, double d2, int i);	public Object superGetMainModel();	public boolean superAddLayer(Object layerRenderer);	public boolean superRemoveLayer(Object layerRenderer);	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_);	public boolean superFunc_177088_c(Object entityLivingBase);	public void superFunc_180565_e();	public boolean superFunc_177090_c(Object entityLivingBase, float p_177090_2_);	public boolean superFunc_177092_a(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_);	public void superFunc_177091_f();	public float superGetSwingProgress(Object entityLivingBase, float p_77040_2_);	public float superHandleRotationFloat(Object entityLivingBase, float p_77044_2_);	public void superFunc_177093_a(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_);	public float superGetDeathMaxRotation(Object entityLivingBase);	public boolean superCanRenderName(Object entityLivingBase);	public void superSetRenderOutlines(boolean p_177086_1_);	public void superRenderName(Object entity, double x, double y, double z);	public boolean superShouldRender(Object entity, Object iCamera, double camX, double camY, double camZ);	public Object superGetEntityTexture(Object entity);	public Object superGetEntityTexture(Object entity, int i);	public boolean superBindEntityTexture(Object entity);	public void superBindTexture(Object resourceLocation);	public void superDoRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_);	public Object superGetFontRendererFromRenderManager();	public Object superFunc_177068_d();}