package modchu.lib.forge.mc172_179;import java.util.HashMap;import modchu.lib.Modchu_IPlayerController;import modchu.lib.Modchu_IPlayerControllerMaster;import modchu.lib.Modchu_Main;import net.minecraft.client.Minecraft;import net.minecraft.client.entity.EntityClientPlayerMP;import net.minecraft.client.multiplayer.PlayerControllerMP;import net.minecraft.client.network.NetHandlerPlayClient;import net.minecraft.entity.Entity;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.item.ItemStack;import net.minecraft.stats.StatFileWriter;import net.minecraft.util.Vec3;import net.minecraft.world.World;import net.minecraft.world.WorldSettings.GameType;public class Modchu_PlayerController extends PlayerControllerMP implements Modchu_IPlayerController {	public static Modchu_IPlayerControllerMaster master;	public Modchu_PlayerController(HashMap<String, Object> map) {		super((Minecraft) map.get("Object"), (NetHandlerPlayClient) map.get("Object1"));		map.put("base", map);		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);		//Modchu_Debug.mDebug("Modchu_PlayerController instance="+instance);		master = instance instanceof Modchu_IPlayerControllerMaster ? (Modchu_IPlayerControllerMaster) instance : null;	}	@Override	public EntityClientPlayerMP func_147493_a(World world, StatFileWriter statFileWriter) {		EntityClientPlayerMP entityClientPlayerMP = master != null ? (EntityClientPlayerMP) master.createPlayer(world) : null;		if (entityClientPlayerMP != null) return entityClientPlayerMP;		return super.func_147493_a(world, statFileWriter);	}	public EntityClientPlayerMP superCreatePlayer(Object world, Object statFileWriter) {		return super.func_147493_a((World) world, (StatFileWriter) statFileWriter);	}	@Override	public void setPlayerCapabilities(EntityPlayer entityPlayer) {		if (master != null) master.setPlayerCapabilities(entityPlayer);		else super.setPlayerCapabilities(entityPlayer);	}	public void superSetPlayerCapabilities(Object entityPlayer) {		super.setPlayerCapabilities((EntityPlayer) entityPlayer);	}	@Override	public boolean enableEverythingIsScrewedUpMode() {		return master != null ? master.isSpectator() : super.enableEverythingIsScrewedUpMode();	}	public boolean superIsSpectator() {		return super.enableEverythingIsScrewedUpMode();	}	@Override	public void setGameType(GameType gameType) {		if (master != null) master.setGameType(gameType);		else super.setGameType(gameType);	}	public void superSetGameType(Object gameType) {		super.setGameType((GameType) gameType);	}	@Override	public void flipPlayer(EntityPlayer entityPlayer) {		if (master != null) master.flipPlayer(entityPlayer);		else super.flipPlayer(entityPlayer);	}	public void superFlipPlayer(Object entityPlayer) {		super.flipPlayer((EntityPlayer) entityPlayer);	}	@Override	public boolean shouldDrawHUD() {		return master != null ? master.shouldDrawHUD() : super.shouldDrawHUD();	}	public boolean superShouldDrawHUD() {		return super.shouldDrawHUD();	}	@Override	public boolean onPlayerDestroyBlock(int par1, int par2, int par3, int par4) {		return master != null ? master.onPlayerDestroyBlock(par1, par2, par3, par4) : super.onPlayerDestroyBlock(par1, par2, par3, par4);	}	public boolean superOnPlayerDestroyBlock(int par1, int par2, int par3, int par4) {		return super.onPlayerDestroyBlock(par1, par2, par3, par4);	}	@Override	public void clickBlock(int par1, int par2, int par3, int par4) {		if (master != null) master.clickBlock(par1, par2, par3, par4);		else super.clickBlock(par1, par2, par3, par4);	}	public void superClickBlock(int par1, int par2, int par3, int par4) {		super.clickBlock(par1, par2, par3, par4);	}	@Override	public void resetBlockRemoving() {		if (master != null) master.resetBlockRemoving();		else super.resetBlockRemoving();	}	public void superResetBlockRemoving() {		super.resetBlockRemoving();	}	@Override	public void onPlayerDamageBlock(int par1, int par2, int par3, int par4) {		if (master != null) master.onPlayerDamageBlock(par1, par2, par3, par4);		else super.onPlayerDamageBlock(par1, par2, par3, par4);	}	public void superOnPlayerDamageBlock(int par1, int par2, int par3, int par4) {		super.onPlayerDamageBlock(par1, par2, par3, par4);	}	@Override	public float getBlockReachDistance() {		return master != null ? master.getBlockReachDistance() : super.getBlockReachDistance();	}	public float superGetBlockReachDistance() {		return super.getBlockReachDistance();	}	@Override	public void updateController() {		if (master != null) master.updateController();		else super.updateController();	}	public void superUpdateController() {		super.updateController();	}	@Override	public boolean onPlayerRightClick(EntityPlayer entityPlayer, World world, ItemStack itemStack, int par4, int par5, int par6, int par7, Vec3 vec3) {		return master != null ? master.onPlayerRightClick(entityPlayer, world, itemStack, par4, par5, par6, par7, vec3) : super.onPlayerRightClick(entityPlayer, world, itemStack, par4, par5, par6, par7, vec3);	}	public boolean superOnPlayerRightClick(Object entityPlayer, Object world, Object itemStack, int par4, int par5, int par6, int par7, Object vec3) {		return super.onPlayerRightClick((EntityPlayer) entityPlayer, (World) world, (ItemStack) itemStack, par4, par5, par6, par7, (Vec3) vec3);	}	@Override	public boolean sendUseItem(EntityPlayer entityPlayer, World world, ItemStack itemStack) {		return master != null ? master.sendUseItem(entityPlayer, world, itemStack) : super.sendUseItem(entityPlayer, world, itemStack);	}	public boolean superSendUseItem(Object entityPlayer, Object world, Object itemStack) {		return super.sendUseItem((EntityPlayer) entityPlayer, (World) world, (ItemStack) itemStack);	}	@Override	public void attackEntity(EntityPlayer entityPlayer, Entity entity) {		if (master != null) master.attackEntity(entityPlayer, entity);		else super.attackEntity(entityPlayer, entity);	}	public void superAttackEntity(Object entityPlayer, Object entity) {		super.attackEntity((EntityPlayer) entityPlayer, (Entity) entity);	}	@Override	public ItemStack windowClick(int par1, int par2, int par3, int par4, EntityPlayer entityPlayer) {		return (ItemStack) (master != null ? master.windowClick(par1, par2, par3, par4, entityPlayer) : super.windowClick(par1, par2, par3, par4, entityPlayer));	}	public ItemStack superWindowClick(int par1, int par2, int par3, int par4, Object entityPlayer) {		return super.windowClick(par1, par2, par3, par4, (EntityPlayer) entityPlayer);	}	@Override	public void sendEnchantPacket(int par1, int par2) {		if (master != null) master.sendEnchantPacket(par1, par2);		else super.sendEnchantPacket(par1, par2);	}	public void superSendEnchantPacket(int par1, int par2) {		super.sendEnchantPacket(par1, par2);	}	@Override	public void sendSlotPacket(ItemStack itemStack, int par2) {		if (master != null) master.sendSlotPacket(itemStack, par2);		else super.sendSlotPacket(itemStack, par2);	}	public void superSendSlotPacket(Object itemStack, int par2) {		super.sendSlotPacket((ItemStack) itemStack, par2);	}	@Override	public void onStoppedUsingItem(EntityPlayer entityPlayer) {		if (master != null) master.onStoppedUsingItem(entityPlayer);		else super.onStoppedUsingItem(entityPlayer);	}	public void superOnStoppedUsingItem(Object entityPlayer) {		super.onStoppedUsingItem((EntityPlayer) entityPlayer);	}	@Override	public boolean isNotCreative() {		return master != null ? master.isNotCreative() : super.isNotCreative();	}	public boolean superIsNotCreative() {		return super.isNotCreative();	}	@Override	public boolean isInCreativeMode() {		return master != null ? master.isInCreativeMode() : super.isInCreativeMode();	}	public boolean superIsInCreativeMode() {		return super.isInCreativeMode();	}	@Override	public boolean extendedReach() {		return master != null ? master.extendedReach() : super.extendedReach();	}	public boolean superExtendedReach() {		return super.extendedReach();	}	@Override	public boolean func_110738_j() {		return master != null ? master.isRidingHorse() : super.func_110738_j();	}	public boolean superFunc_110738_j() {		return super.func_110738_j();	}	// ~162	public boolean func_78768_b(EntityPlayer entityPlayer, Entity entity) {		return false;	}	public boolean superFunc_78768_b(Object entityPlayer, Object entity) {		return false;	}	public void func_78752_a(ItemStack itemStack) {	}	public void superFunc_78752_a(Object itemStack) {	}	public boolean func_78763_f() {		return false;	}	public boolean superFunc_78763_f() {		return false;	}	// 172~	@Override	public boolean interactWithEntitySendPacket(EntityPlayer entityPlayer, Entity entity) {		return master != null ? master.interactWithEntitySendPacket(entityPlayer, entity) : super.interactWithEntitySendPacket(entityPlayer, entity);	}	public boolean superInteractWithEntitySendPacket(Object entityPlayer, Object entity) {		return super.interactWithEntitySendPacket((EntityPlayer) entityPlayer, (Entity) entity);	}	@Override	public void sendPacketDropItem(ItemStack itemStack) {		if (master != null) master.sendPacketDropItem(itemStack);		else super.sendPacketDropItem(itemStack);	}	public void superSendPacketDropItem(Object itemStack) {		super.sendPacketDropItem((ItemStack) itemStack);	}	@Override	public boolean gameIsSurvivalOrAdventure() {		return master != null ? master.gameIsSurvivalOrAdventure() : super.gameIsSurvivalOrAdventure();	}	public boolean superGameIsSurvivalOrAdventure() {		return super.gameIsSurvivalOrAdventure();	}	// 180~	public boolean superOnPlayerDestroyBlock(Object blockPos, Object enumFacing) {		return false;	}	public boolean superFunc_180511_b(Object blockPos, Object enumFacing) {		return false;	}	public boolean superFunc_180512_c(Object blockPos, Object enumFacing) {		return false;	}	public boolean superFunc_178890_a(Object entityPlayerSP, Object worldClient, Object itemStack, Object blockPos, Object enumFacing, Object vec3) {		return false;	}	public boolean superIsRidingHorse() {		return false;	}}