package modchu.lib;

public interface Modchu_IPlayerControllerMaster {

	// 180~
	public boolean onPlayerDestroyBlock(Object blockPos, Object enumFacing);
	public boolean clickBlock(Object blockPos, Object enumFacing);
	public boolean onPlayerDamageBlock(Object blockPos, Object enumFacing);
	public Object processRightClickBlock(Object entityPlayerSP, Object worldClient, Object itemStack, Object blockPos, Object enumFacing, Object vec3);

	public Object createClientPlayer(Object world);
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
	public boolean processRightClick(Object entityPlayer, Object world, Object itemStack);
	public void attackEntity(Object entityPlayer, Object entity);
	public boolean func_78768_b(Object entityPlayer, Object entity);
	public Object windowClick(int par1, int par2, int par3, Object clickTypeOrInt, Object entityPlayer);
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
	// 190~
	public boolean onPlayerDestroyBlock(Object blockPos);
	public Object processRightClickBlock(Object entityPlayerSP, Object worldClient, Object itemStack, Object blockPos, Object enumFacing, Object vec3, Object enumHand);
	public Object processRightClick(Object entityPlayer, Object world, Object itemStack, Object enumHand);
	public Object interactWithEntitySendPacket(Object entityPlayer, Object entity, Object itemStack, Object enumHand);

}
