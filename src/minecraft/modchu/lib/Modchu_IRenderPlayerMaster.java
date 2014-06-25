package modchu.lib;

import modchu.model.multimodel.base.MultiModelBaseBiped;

public interface Modchu_IRenderPlayerMaster {

	public int setArmorModel(Object entityplayer, int i, float f);
	public int setArmorModel(MultiModelBaseBiped model, Object entityplayer, int i, float f, int i2);
	public int shouldRenderPass(Object entity, int i, float f);
	public float renderScale(Object entityliving, float f);
	public void doRender(Object entity, double d, double d1, double d2, float f, float f1);
	public void renderSpecials(Object entityPlayer, float f);
	public void renderFirstPersonArm(Object entityplayer, int i);
	public boolean isActivatedForPlayer(Object entityPlayer);
	public double renderLivingLabel(Object entityplayer, String par2Str, double d, double d1, double d2, int i);
	public void renderModel(Object par1ObjectLiving, float par2, float par3, float par4, float par5, float par6, float par7);
	public void renderPlayerSleep(Object entityPlayer, double var2, double var4, double var6);
	public void rotatePlayer(Object entityPlayer, float var2, float var3, float var4);
	public int getColorMultiplier(Object entity, float par2, float par3);
	public int inheritRenderPass(Object entity, int par2, float par3);
	public void renderPlayerAt(Object entityPlayer, double var2, double var4, double var6);
	public void renderGuiIngame(Object var0);
	public void preRenderCallback(Object entity, float f);
	public void allModelInit(Object entity, boolean debug);

}
