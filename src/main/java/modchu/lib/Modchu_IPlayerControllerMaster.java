package modchu.lib;

public interface Modchu_IPlayerControllerMaster {

	// 180~
	public boolean onPlayerDestroyBlock(Object blockPos, Object enumFacing);
	public boolean func_180511_b(Object blockPos, Object enumFacing);
	public boolean func_180512_c(Object blockPos, Object enumFacing);
	public boolean func_178890_a(Object entityPlayerSP, Object worldClient, Object itemStack, Object blockPos, Object enumFacing, Object vec3);

	public Object createPlayer(Object world);
	public void setPlayerCapabilities(Object entityPlayer);
	public boolean isSpectator();
	public void setGameType(Enum enumGameType);
	public void flipPlayer(Object entityPlayer);
	public boolean shouldDrawHUD();
	public boolean onPlayerDestroyBlock(int par1, int par2, int par3, int par4);
	public void clickBlock(int par1, int par2, int par3, int par4);
	public void resetBlockRemoving();
	public void onPlayerDamageBlock(int par1, int par2, int par3, int par4);
	public float getBlockReachDistance();
	public void updateController();
	public boolean onPlayerRightClick(Object entityPlayer, Object world, Object itemStack, int par4, int par5, int par6, int par7, Object vec3);
	public boolean sendUseItem(Object entityPlayer, Object world, Object itemStack);
	public void attackEntity(Object entityPlayer, Object entity);
	public boolean func_78768_b(Object entityPlayer, Object entity);
	public Object windowClick(int par1, int par2, int par3, int par4, Object entityPlayer);
	public void sendEnchantPacket(int par1, int par2);
	public void sendSlotPacket(Object itemStack, int par2);
	public void func_78752_a(Object itemStack);
	public void onStoppedUsingItem(Object entityPlayer);
	public boolean func_78763_f();
	public boolean isNotCreative();
	public boolean isInCreativeMode();
	public boolean extendedReach();
	public boolean isRidingHorse();
	public boolean interactWithEntitySendPacket(Object entityPlayer, Object entity);
	public void sendPacketDropItem(Object itemStack);
	public boolean gameIsSurvivalOrAdventure();

}
