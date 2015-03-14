package modchu.lib;

public interface Modchu_IPlayerController {
	public Object superCreatePlayer(Object world, Object statFileWriter);
	public void superSetPlayerCapabilities(Object entityPlayer);
	public boolean superIsSpectator();
	public void superSetGameType(Object gameType);
	public void superFlipPlayer(Object entityPlayer);
	public boolean superShouldDrawHUD();
	public boolean superOnPlayerDestroyBlock(Object blockPos, Object enumFacing);
	public boolean superFunc_180511_b(Object blockPos, Object enumFacing);
	public void superResetBlockRemoving();
	public boolean superFunc_180512_c(Object blockPos, Object enumFacing);
	public float superGetBlockReachDistance();
	public void superUpdateController();
	public boolean superFunc_178890_a(Object entityPlayerSP, Object world, Object itemStack, Object blockPos, Object enumFacing, Object vec3);
	public boolean superSendUseItem(Object entityPlayer, Object world, Object itemStack);
	public void superAttackEntity(Object entityPlayer, Object entity);
	public Object superWindowClick(int par1, int par2, int par3, int par4, Object entityPlayer);
	public void superSendEnchantPacket(int par1, int par2);
	public void superSendSlotPacket(Object itemStack, int par2);
	public void superOnStoppedUsingItem(Object entityPlayer);
	public boolean superIsNotCreative();
	public boolean superIsInCreativeMode();
	public boolean superExtendedReach();
	public boolean superIsRidingHorse();
	public boolean superFunc_78768_b(Object entityPlayer, Object entity);
	public void superFunc_78752_a(Object itemStack);
	public boolean superFunc_78763_f();
	public boolean superInteractWithEntitySendPacket(Object entityPlayer, Object entity);
	public void superSendPacketDropItem(Object itemStack);
	public boolean superGameIsSurvivalOrAdventure();
	public boolean superOnPlayerDestroyBlock(int par1, int par2, int par3, int par4);
	public void superClickBlock(int par1, int par2, int par3, int par4);
	public void superOnPlayerDamageBlock(int par1, int par2, int par3, int par4);
	public boolean superOnPlayerRightClick(Object entityPlayer, Object world, Object itemStack, int par4, int par5, int par6, int par7, Object vec3);

}
