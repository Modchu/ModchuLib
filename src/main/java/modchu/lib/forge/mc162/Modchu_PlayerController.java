package modchu.lib.forge.mc162;import java.util.HashMap;import modchu.lib.Modchu_IPlayerController;import modchu.lib.Modchu_IPlayerControllerMaster;import modchu.lib.Modchu_Main;import net.minecraft.client.Minecraft;import net.minecraft.client.entity.EntityClientPlayerMP;import net.minecraft.client.multiplayer.NetClientHandler;import net.minecraft.client.multiplayer.PlayerControllerMP;import net.minecraft.entity.Entity;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.item.ItemStack;import net.minecraft.util.Vec3;import net.minecraft.world.EnumGameType;import net.minecraft.world.World;public class Modchu_PlayerController extends PlayerControllerMP implements Modchu_IPlayerController {	public Modchu_IPlayerControllerMaster master;	public Modchu_PlayerController(HashMap<String, Object> map) {		super((Minecraft) map.get("Object"), (NetClientHandler) map.get("Object1"));		map.put("base", map);		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);		//Modchu_Debug.mDebug("Modchu_PlayerController instance="+instance);		master = instance instanceof Modchu_IPlayerControllerMaster ? (Modchu_IPlayerControllerMaster) instance : null;	}	@Override	public EntityClientPlayerMP func_78754_a(World world) {		EntityClientPlayerMP entityClientPlayerMP = master != null ? (EntityClientPlayerMP) master.createPlayer(world, null, null) : null;		if (entityClientPlayerMP != null) return entityClientPlayerMP;		return super.func_78754_a(world);	}	@Override	public EntityClientPlayerMP superCreatePlayer(Object world, Object statFileWriter, Object recipeBook) {		return super.func_78754_a((World) world);	}	@Override	public void setPlayerCapabilities(EntityPlayer entityPlayer) {		if (master != null) master.setPlayerCapabilities(entityPlayer);		else super.setPlayerCapabilities(entityPlayer);	}	@Override	public void superSetPlayerCapabilities(Object entityPlayer) {		super.setPlayerCapabilities((EntityPlayer) entityPlayer);	}	@Override	public boolean enableEverythingIsScrewedUpMode() {		return master != null ? master.isSpectator() : super.enableEverythingIsScrewedUpMode();	}	@Override	public boolean superIsSpectator() {		return super.enableEverythingIsScrewedUpMode();	}	@Override	public void setGameType(EnumGameType enumGameType) {		if (master != null) master.setGameType(enumGameType);		else super.setGameType(enumGameType);	}	@Override	public void superSetGameType(Object enumGameType) {		super.setGameType((EnumGameType) enumGameType);	}	@Override	public void flipPlayer(EntityPlayer entityPlayer) {		if (master != null) master.flipPlayer(entityPlayer);		else super.flipPlayer(entityPlayer);	}	@Override	public void superFlipPlayer(Object entityPlayer) {		super.flipPlayer((EntityPlayer) entityPlayer);	}	@Override	public boolean shouldDrawHUD() {		return master != null ? master.shouldDrawHUD() : super.shouldDrawHUD();	}	@Override	public boolean superShouldDrawHUD() {		return super.shouldDrawHUD();	}	@Override	public boolean onPlayerDestroyBlock(int par1, int par2, int par3, int par4) {		return master != null ? master.onPlayerDestroyBlock(par1, par2, par3, par4) : super.onPlayerDestroyBlock(par1, par2, par3, par4);	}	@Override	public boolean superOnPlayerDestroyBlock(int par1, int par2, int par3, int par4) {		return super.onPlayerDestroyBlock(par1, par2, par3, par4);	}	@Override	public void clickBlock(int par1, int par2, int par3, int par4) {		if (master != null) master.clickBlock(par1, par2, par3, par4);		else super.clickBlock(par1, par2, par3, par4);	}	@Override	public void superClickBlock(int par1, int par2, int par3, int par4) {		super.clickBlock(par1, par2, par3, par4);	}	@Override	public void resetBlockRemoving() {		if (master != null) master.resetBlockRemoving();		else super.resetBlockRemoving();	}	@Override	public void superResetBlockRemoving() {		super.resetBlockRemoving();	}	@Override	public void onPlayerDamageBlock(int par1, int par2, int par3, int par4) {		if (master != null) master.onPlayerDamageBlock(par1, par2, par3, par4);		else super.onPlayerDamageBlock(par1, par2, par3, par4);	}	@Override	public void superOnPlayerDamageBlock(int par1, int par2, int par3, int par4) {		super.onPlayerDamageBlock(par1, par2, par3, par4);	}	@Override	public float getBlockReachDistance() {		return master != null ? master.getBlockReachDistance() : super.getBlockReachDistance();	}	@Override	public float superGetBlockReachDistance() {		return super.getBlockReachDistance();	}	@Override	public void updateController() {		if (master != null) master.updateController();		else super.updateController();	}	@Override	public void superUpdateController() {		super.updateController();	}	@Override	public boolean onPlayerRightClick(EntityPlayer entityPlayer, World world, ItemStack itemStack, int par4, int par5, int par6, int par7, Vec3 vec3) {		return master != null ? master.onPlayerRightClick(entityPlayer, world, itemStack, par4, par5, par6, par7, vec3) : super.onPlayerRightClick(entityPlayer, world, itemStack, par4, par5, par6, par7, vec3);	}	@Override	public boolean superOnPlayerRightClick(Object entityPlayer, Object world, Object itemStack, int par4, int par5, int par6, int par7, Object vec3) {		return super.onPlayerRightClick((EntityPlayer) entityPlayer, (World) world, (ItemStack) itemStack, par4, par5, par6, par7, (Vec3) vec3);	}	@Override	public boolean sendUseItem(EntityPlayer entityPlayer, World world, ItemStack itemStack) {		return master != null ? master.processRightClick(entityPlayer, world, itemStack) : super.sendUseItem(entityPlayer, world, itemStack);	}	@Override	public boolean superProcessRightClick(Object entityPlayer, Object world, Object itemStack) {		return super.sendUseItem((EntityPlayer) entityPlayer, (World) world, (ItemStack) itemStack);	}	@Override	public void attackEntity(EntityPlayer entityPlayer, Entity entity) {		if (master != null) master.attackEntity(entityPlayer, entity);		else super.attackEntity(entityPlayer, entity);	}	@Override	public void superAttackEntity(Object entityPlayer, Object entity) {		super.attackEntity((EntityPlayer) entityPlayer, (Entity) entity);	}	@Override	public ItemStack windowClick(int par1, int par2, int par3, int par4, EntityPlayer entityPlayer) {		return (ItemStack) (master != null ? master.windowClick(par1, par2, par3, par4, entityPlayer) : super.windowClick(par1, par2, par3, par4, entityPlayer));	}	@Override	public ItemStack superWindowClick(int par1, int par2, int par3, int par4, Object entityPlayer) {		return super.windowClick(par1, par2, par3, par4, (EntityPlayer) entityPlayer);	}	@Override	public void sendEnchantPacket(int par1, int par2) {		if (master != null) master.sendEnchantPacket(par1, par2);		else super.sendEnchantPacket(par1, par2);	}	@Override	public void superSendEnchantPacket(int par1, int par2) {		super.sendEnchantPacket(par1, par2);	}	@Override	public void sendSlotPacket(ItemStack itemStack, int par2) {		if (master != null) master.sendSlotPacket(itemStack, par2);		else super.sendSlotPacket(itemStack, par2);	}	@Override	public void superSendSlotPacket(Object itemStack, int par2) {		super.sendSlotPacket((ItemStack) itemStack, par2);	}	@Override	public void onStoppedUsingItem(EntityPlayer entityPlayer) {		if (master != null) master.onStoppedUsingItem(entityPlayer);		else super.onStoppedUsingItem(entityPlayer);	}	@Override	public void superOnStoppedUsingItem(Object entityPlayer) {		super.onStoppedUsingItem((EntityPlayer) entityPlayer);	}	@Override	public boolean isNotCreative() {		return master != null ? master.isNotCreative() : super.isNotCreative();	}	@Override	public boolean superIsNotCreative() {		return super.isNotCreative();	}	@Override	public boolean isInCreativeMode() {		return master != null ? master.isInCreativeMode() : super.isInCreativeMode();	}	@Override	public boolean superIsInCreativeMode() {		return super.isInCreativeMode();	}	@Override	public boolean extendedReach() {		return master != null ? master.extendedReach() : super.extendedReach();	}	@Override	public boolean superExtendedReach() {		return super.extendedReach();	}	@Override	public boolean func_110738_j() {		return master != null ? master.isRidingHorse() : super.func_110738_j();	}	public boolean superFunc_110738_j() {		return super.func_110738_j();	}	// ~162	@Override	public boolean func_78768_b(EntityPlayer entityPlayer, Entity entity) {		return false;	}	@Override	public boolean superFunc_78768_b(Object entityPlayer, Object entity) {		return false;	}	@Override	public void func_78752_a(ItemStack itemStack) {	}	@Override	public void superFunc_78752_a(Object itemStack) {	}	@Override	public boolean func_78763_f() {		return false;	}	@Override	public boolean superFunc_78763_f() {		return false;	}	// 172~	public boolean interactWithEntitySendPacket(EntityPlayer entityPlayer, Entity entity) {		return false;	}	@Override	public boolean superInteractWithEntitySendPacket(Object entityPlayer, Object entity) {		return false;	}	public void sendPacketDropItem(ItemStack itemStack) {	}	@Override	public void superSendPacketDropItem(Object itemStack) {	}	public boolean gameIsSurvivalOrAdventure() {		return false;	}	@Override	public boolean superGameIsSurvivalOrAdventure() {		return false;	}	// 180~	@Override	public boolean superIsRidingHorse() {		return superFunc_110738_j();	}	@Override	public boolean superOnPlayerDestroyBlock(Object blockPos, Object enumFacing) {		return false;	}	@Override	public boolean superClickBlock(Object blockPos, Object enumFacing) {		return false;	}	@Override	public boolean superOnPlayerDamageBlock(Object blockPos, Object enumFacing) {		return false;	}	@Override	public Object superProcessRightClickBlock(Object entityPlayerSP, Object world, Object itemStack, Object blockPos, Object enumFacing, Object vec3) {		return false;	}	// 190~	@Override	public boolean superOnPlayerDestroyBlock(Object blockPos) {		return false;	}	@Override	public Object superProcessRightClickBlock(Object entityPlayerSP, Object world, Object itemStack, Object blockPos, Object enumFacing, Object vec3, Object enumHand) {		return null;	}	@Override	public Object superSendUseItem(Object entityPlayer, Object world, Object itemStack, Object enumHand) {		return null;	}	@Override	public Object superWindowClick(int par1, int par2, int par3, Object clickType, Object entityPlayer) {		return null;	}	public Object superInteractWithEntitySendPacket(Object entityPlayer, Object entity, Object itemStack, Object enumHand) {		return null;	}	@Override	public Object superProcessRightClick(Object entityPlayer, Object world, Object itemStack, Object enumHand) {		return null;	}	@Override	public Object superInteractWithEntity(Object entityPlayer, Object entity, Object itemStack, Object enumHand) {		return null;	}	@Override	public boolean superFunc_178894_a(Object entityPlayer, Object entity, Object movingObjectPosition) {		return false;	}	@Override	public boolean superIsSpectatorMode() {		return false;	}	@Override	public Object superGetCurrentGameType() {		return null;	}	@Override	public boolean superFunc_181040_m() {		return false;	}	@Override	public Object superInteractWithEntity(Object entityPlayer, Object entity, Object rayTraceResult, Object itemStack, Object enumHand) {		return null;	}	@Override	public boolean superGetIsHittingBlock() {		return false;	}	@Override	public void superPickItem(int index) {	}}