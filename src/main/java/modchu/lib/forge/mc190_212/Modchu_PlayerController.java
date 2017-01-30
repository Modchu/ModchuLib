package modchu.lib.forge.mc190_212;import java.util.HashMap;import modchu.lib.Modchu_IPlayerController;import modchu.lib.Modchu_IPlayerControllerMaster;import modchu.lib.Modchu_Main;import net.minecraft.client.Minecraft;import net.minecraft.client.entity.EntityPlayerSP;import net.minecraft.client.multiplayer.PlayerControllerMP;import net.minecraft.client.multiplayer.WorldClient;import net.minecraft.client.network.NetHandlerPlayClient;import net.minecraft.entity.Entity;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.item.ItemStack;import net.minecraft.util.EnumActionResult;import net.minecraft.util.EnumFacing;import net.minecraft.util.EnumHand;import net.minecraft.util.math.BlockPos;import net.minecraft.util.math.Vec3d;import net.minecraft.world.World;public abstract class Modchu_PlayerController extends PlayerControllerMP implements Modchu_IPlayerController {	public Modchu_IPlayerControllerMaster master;	public Modchu_PlayerController(HashMap<String, Object> map) {		super((Minecraft) map.get("Object"), (NetHandlerPlayClient) map.get("Object1"));		map.put("base", map);		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);		//Modchu_Debug.mDebug("Modchu_PlayerController instance="+instance);		master = instance instanceof Modchu_IPlayerControllerMaster ? (Modchu_IPlayerControllerMaster) instance : null;	}	@Override	public void setPlayerCapabilities(EntityPlayer entityPlayer) {		if (master != null) master.setPlayerCapabilities(entityPlayer);		else super.setPlayerCapabilities(entityPlayer);	}	@Override	public void superSetPlayerCapabilities(Object entityPlayer) {		super.setPlayerCapabilities((EntityPlayer) entityPlayer);	}	@Override	public boolean isSpectator() {		return master != null ? master.isSpectator() : super.isSpectator();	}	@Override	public boolean superIsSpectator() {		return super.isSpectator();	}	@Override	public void flipPlayer(EntityPlayer entityPlayer) {		if (master != null) master.flipPlayer(entityPlayer);		else super.flipPlayer(entityPlayer);	}	@Override	public void superFlipPlayer(Object entityPlayer) {		super.flipPlayer((EntityPlayer) entityPlayer);	}	@Override	public boolean shouldDrawHUD() {		return master != null ? master.shouldDrawHUD() : super.shouldDrawHUD();	}	@Override	public boolean superShouldDrawHUD() {		return super.shouldDrawHUD();	}	@Override	public boolean clickBlock(BlockPos blockPos, EnumFacing enumFacing) {		return master != null ? master.clickBlock(blockPos, enumFacing) : super.clickBlock(blockPos, enumFacing);	}	@Override	public boolean superClickBlock(Object blockPos, Object enumFacing) {		return super.clickBlock((BlockPos) blockPos, (EnumFacing) enumFacing);	}	@Override	public void resetBlockRemoving() {		if (master != null) master.resetBlockRemoving();		else super.resetBlockRemoving();	}	@Override	public void superResetBlockRemoving() {		super.resetBlockRemoving();	}	@Override	public boolean onPlayerDamageBlock(BlockPos blockPos, EnumFacing enumFacing) {		return master != null ? master.onPlayerDamageBlock(blockPos, enumFacing) : super.onPlayerDamageBlock(blockPos, enumFacing);	}	@Override	public boolean superOnPlayerDamageBlock(Object blockPos, Object enumFacing) {		return super.onPlayerDamageBlock((BlockPos) blockPos, (EnumFacing) enumFacing);	}	@Override	public float getBlockReachDistance() {		return master != null ? master.getBlockReachDistance() : super.getBlockReachDistance();	}	@Override	public float superGetBlockReachDistance() {		return super.getBlockReachDistance();	}	@Override	public void updateController() {		if (master != null) master.updateController();		else super.updateController();	}	@Override	public void superUpdateController() {		super.updateController();	}	@Override	public void attackEntity(EntityPlayer entityPlayer, Entity entity) {		if (master != null) master.attackEntity(entityPlayer, entity);		else super.attackEntity(entityPlayer, entity);	}	@Override	public void superAttackEntity(Object entityPlayer, Object entity) {		super.attackEntity((EntityPlayer) entityPlayer, (Entity) entity);	}	@Override	public void sendEnchantPacket(int par1, int par2) {		if (master != null) master.sendEnchantPacket(par1, par2);		else super.sendEnchantPacket(par1, par2);	}	@Override	public void superSendEnchantPacket(int par1, int par2) {		super.sendEnchantPacket(par1, par2);	}	@Override	public void sendSlotPacket(ItemStack itemStack, int par2) {		if (master != null) master.sendSlotPacket(itemStack, par2);		else super.sendSlotPacket(itemStack, par2);	}	@Override	public void superSendSlotPacket(Object itemStack, int par2) {		super.sendSlotPacket((ItemStack) itemStack, par2);	}	@Override	public void onStoppedUsingItem(EntityPlayer entityPlayer) {		if (master != null) master.onStoppedUsingItem(entityPlayer);		else super.onStoppedUsingItem(entityPlayer);	}	@Override	public void superOnStoppedUsingItem(Object entityPlayer) {		super.onStoppedUsingItem((EntityPlayer) entityPlayer);	}	@Override	public boolean isNotCreative() {		return master != null ? master.isNotCreative() : super.isNotCreative();	}	@Override	public boolean superIsNotCreative() {		return super.isNotCreative();	}	@Override	public boolean isInCreativeMode() {		return master != null ? master.isInCreativeMode() : super.isInCreativeMode();	}	@Override	public boolean superIsInCreativeMode() {		return super.isInCreativeMode();	}	@Override	public boolean extendedReach() {		return master != null ? master.extendedReach() : super.extendedReach();	}	@Override	public boolean superExtendedReach() {		return super.extendedReach();	}	@Override	public boolean isRidingHorse() {		return master != null ? master.isRidingHorse() : super.isRidingHorse();	}	@Override	public boolean superIsRidingHorse() {		return super.isRidingHorse();	}	// ~162	public boolean func_78768_b(EntityPlayer entityPlayer, Entity entity) {		return false;	}	@Override	public boolean superFunc_78768_b(Object entityPlayer, Object entity) {		return false;	}	public void func_78752_a(ItemStack itemStack) {	}	@Override	public void superFunc_78752_a(Object itemStack) {	}	public boolean func_78763_f() {		return false;	}	@Override	public boolean superFunc_78763_f() {		return false;	}	// 172~	@Override	public void sendPacketDropItem(ItemStack itemStack) {		if (master != null) master.sendPacketDropItem(itemStack);		else super.sendPacketDropItem(itemStack);	}	@Override	public void superSendPacketDropItem(Object itemStack) {		super.sendPacketDropItem((ItemStack) itemStack);	}	@Override	public boolean gameIsSurvivalOrAdventure() {		return master != null ? master.gameIsSurvivalOrAdventure() : super.gameIsSurvivalOrAdventure();	}	@Override	public boolean superGameIsSurvivalOrAdventure() {		return super.gameIsSurvivalOrAdventure();	}	// ~179	public boolean onPlayerDestroyBlock(int par1, int par2, int par3, int par4) {		return false;	}	@Override	public boolean superOnPlayerDestroyBlock(int par1, int par2, int par3, int par4) {		return false;	}	public void clickBlock(int par1, int par2, int par3, int par4) {	}	@Override	public void superClickBlock(int par1, int par2, int par3, int par4) {	}	public void onPlayerDamageBlock(int par1, int par2, int par3, int par4) {	}	@Override	public void superOnPlayerDamageBlock(int par1, int par2, int par3, int par4) {	}	public boolean onPlayerRightClick(EntityPlayer entityPlayer, World world, ItemStack itemStack, int par4, int par5, int par6, int par7, Vec3d vec3) {		return false;	}	@Override	public boolean superOnPlayerRightClick(Object entityPlayer, Object world, Object itemStack, int par4, int par5, int par6, int par7, Object vec3) {		return false;	}	// ~189	@Override	public boolean superOnPlayerDestroyBlock(Object blockPos, Object enumFacing) {		return false;	}	@Override	public Object superProcessRightClickBlock(Object entityPlayerSP, Object world, Object itemStack, Object blockPos, Object enumFacing, Object vec3) {		return null;	}	@Override	public Object superWindowClick(int par1, int par2, int par3, int par4, Object entityPlayer) {		return null;	}	@Override	public boolean superInteractWithEntitySendPacket(Object entityPlayer, Object entity) {		return false;	}	@Override	public boolean superProcessRightClick(Object entityPlayer, Object world, Object itemStack) {		return false;	}}