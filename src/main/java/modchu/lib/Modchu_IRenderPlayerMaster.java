package modchu.lib;

public interface Modchu_IRenderPlayerMaster extends Modchu_IRendererLivingEntityMaster {
	public void renderFirstPersonArm(Object entityplayer, int i);
	public void renderFirstPersonLeftArm(Object entityplayer, int i);
	public boolean isActivatedForPlayer(Object entityPlayer);
	public void renderPlayerSleep(Object entityPlayer, double var2, double var4, double var6);
	public void rotatePlayer(Object entityPlayer, float var2, float var3, float var4);
	public void renderPlayerAt(Object entityPlayer, double var2, double var4, double var6);
	public void renderGuiIngame(Object var0);
	public Object func_180594_a(Object abstractClientPlayer);
	public void transformHeldFull3DItemLayer();
	public void renderOffsetLivingLabel(Object abstractClientPlayer, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_);
	public void func_177139_c(Object abstractClientPlayer);
	public void rotateCorpse(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_);

}
