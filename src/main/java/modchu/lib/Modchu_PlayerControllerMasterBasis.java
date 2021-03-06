package modchu.lib;

import java.util.HashMap;

public class Modchu_PlayerControllerMasterBasis implements Modchu_IPlayerControllerMaster {
	public Modchu_IPlayerController base;

	public Modchu_PlayerControllerMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IPlayerController) map.get("base");
	}

	@Override
	public Object createPlayer(Object world, Object statisticsManager, Object recipeBook) {
		return base.superCreatePlayer(world, statisticsManager, recipeBook);
	}

	@Override
	public void setPlayerCapabilities(Object entityPlayer) {
		base.superSetPlayerCapabilities(entityPlayer);
	}

	@Override
	public boolean isSpectator() {
		return base.superIsSpectator();
	}

	@Override
	public void setGameType(Enum enumGameType) {
		base.superSetGameType(enumGameType);
	}

	@Override
	public void flipPlayer(Object entityPlayer) {
		base.superFlipPlayer(entityPlayer);
	}

	@Override
	public boolean shouldDrawHUD() {
		return base.superShouldDrawHUD();
	}

	@Override
	public boolean onPlayerDestroyBlock(int par1, int par2, int par3, int par4) {
		return base.superOnPlayerDestroyBlock(par1, par2, par3, par4);
	}

	@Override
	public void clickBlock(int par1, int par2, int par3, int par4) {
		base.superClickBlock(par1, par2, par3, par4);
	}

	@Override
	public void resetBlockRemoving() {
		base.superResetBlockRemoving();
	}

	@Override
	public void onPlayerDamageBlock(int par1, int par2, int par3, int par4) {
		base.superOnPlayerDamageBlock(par1, par2, par3, par4);
	}

	@Override
	public float getBlockReachDistance() {
		return base.superGetBlockReachDistance();
	}

	@Override
	public void updateController() {
		base.superUpdateController();
	}

	@Override
	public boolean onPlayerRightClick(Object entityPlayer, Object world, Object itemStack, int par4, int par5, int par6, int par7, Object vec3) {
		return base.superOnPlayerRightClick(entityPlayer, world, itemStack, par4, par5, par6, par7, vec3);
	}

	@Override
	public boolean processRightClick(Object entityPlayer, Object world, Object itemStack) {
		return base.superProcessRightClick(entityPlayer, world, itemStack);
	}

	@Override
	public void attackEntity(Object entityPlayer, Object entity) {
		base.superAttackEntity(entityPlayer, entity);
	}

	@Override
	public boolean func_78768_b(Object entityPlayer, Object entity) {
		return base.superFunc_78768_b(entityPlayer, entity);
	}

	@Override
	public Object windowClick(int par1, int par2, int par3, Object clickTypeOrInt, Object entityPlayer) {
		return base.superWindowClick(par1, par2, par3, clickTypeOrInt, entityPlayer);
	}

	@Override
	public void sendEnchantPacket(int par1, int par2) {
		base.superSendEnchantPacket(par1, par2);
	}

	@Override
	public void sendSlotPacket(Object itemStack, int par2) {
		base.superSendSlotPacket(itemStack, par2);
	}

	@Override
	public void func_78752_a(Object itemStack) {
		base.superFunc_78752_a(itemStack);
	}

	@Override
	public void onStoppedUsingItem(Object entityPlayer) {
		base.superOnStoppedUsingItem(entityPlayer);
	}

	@Override
	public boolean func_78763_f() {
		return base.superFunc_78763_f();
	}

	@Override
	public boolean isNotCreative() {
		return base.superIsNotCreative();
	}

	@Override
	public boolean isInCreativeMode() {
		return base.superIsInCreativeMode();
	}

	@Override
	public boolean extendedReach() {
		return base.superExtendedReach();
	}

	@Override
	public boolean isRidingHorse() {
		return base.superIsRidingHorse();
	}

	@Override
	public boolean interactWithEntitySendPacket(Object entityPlayer, Object entity) {
		return base.superInteractWithEntitySendPacket(entityPlayer, entity);
	}

	@Override
	public void sendPacketDropItem(Object itemStack) {
		base.superSendPacketDropItem(itemStack);

	}

	@Override
	public boolean gameIsSurvivalOrAdventure() {
		return base.superGameIsSurvivalOrAdventure();
	}

	// 180~
	@Override
	public boolean onPlayerDestroyBlock(Object blockPos, Object enumFacing) {
		return base.superOnPlayerDestroyBlock(blockPos, enumFacing);
	}

	@Override
	public boolean clickBlock(Object blockPos, Object enumFacing) {
		return base.superClickBlock(blockPos, enumFacing);
	}

	@Override
	public boolean onPlayerDamageBlock(Object blockPos, Object enumFacing) {
		return base.superOnPlayerDamageBlock(blockPos, enumFacing);
	}

	@Override
	public Object processRightClickBlock(Object entityPlayerSP, Object worldClient, Object itemStack, Object blockPos, Object enumFacing, Object vec3) {
		return base.superProcessRightClickBlock(entityPlayerSP, worldClient, itemStack, blockPos, enumFacing, vec3);
	}

	@Override
	public boolean onPlayerDestroyBlock(Object blockPos) {
		return (boolean) (base.superOnPlayerDestroyBlock(blockPos));
	}

	@Override
	public Object processRightClickBlock(Object entityPlayerSP, Object worldClient, Object itemStack, Object blockPos, Object enumFacing, Object vec3, Object enumHand) {
		return base.superProcessRightClickBlock(entityPlayerSP, worldClient, itemStack, blockPos, enumFacing, vec3, enumHand);
	}

	@Override
	public Object processRightClick(Object entityPlayer, Object world, Object itemStack, Object enumHand) {
		return base.superProcessRightClick(entityPlayer, world, itemStack, enumHand);
	}

	@Override
	public Object interactWithEntity(Object entityPlayer, Object entity, Object itemStack, Object enumHand) {
		return base.superInteractWithEntity(entityPlayer, entity, itemStack, enumHand);
	}

	@Override
	public boolean func_178894_a(Object entityPlayer, Object entity, Object movingObjectPosition) {
		return base.superFunc_178894_a(entityPlayer, entity, movingObjectPosition);
	}

	@Override
	public boolean isSpectatorMode() {
		return base.superIsSpectatorMode();
	}

	@Override
	public Object getCurrentGameType() {
		return base.superGetCurrentGameType();
	}

	@Override
	public boolean func_181040_m() {
		return base.superFunc_181040_m();
	}

	@Override
	public Object interactWithEntity(Object entityPlayer, Object entity, Object rayTraceResult, Object itemStack, Object enumHand) {
		return base.superInteractWithEntity(entityPlayer, entity, rayTraceResult, itemStack, enumHand);
	}

	@Override
	public boolean getIsHittingBlock() {
		return base.superGetIsHittingBlock();
	}

	@Override
	public void pickItem(int index) {
		base.superPickItem(index);
	}

}