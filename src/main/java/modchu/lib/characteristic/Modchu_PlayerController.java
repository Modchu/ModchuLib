package modchu.lib.characteristic;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_IPlayerControllerMaster;import modchu.lib.Modchu_Reflect;import net.minecraft.client.Minecraft;import net.minecraft.client.entity.EntityPlayerSP;import net.minecraft.client.multiplayer.PlayerControllerMP;import net.minecraft.client.multiplayer.WorldClient;import net.minecraft.client.network.NetHandlerPlayClient;import net.minecraft.entity.Entity;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.item.ItemStack;import net.minecraft.stats.StatFileWriter;import net.minecraft.util.BlockPos;import net.minecraft.util.EnumFacing;import net.minecraft.util.Vec3;import net.minecraft.world.World;import net.minecraft.world.WorldSettings.GameType;public class Modchu_PlayerController extends PlayerControllerMP {	public static Modchu_IPlayerControllerMaster master;	public Modchu_PlayerController(Class masterClass, Object minecraft, Object par2NetClientHandler) {		super((Minecraft) minecraft, (NetHandlerPlayClient) par2NetClientHandler);		if (masterClass != null) ;else {			Modchu_Debug.Debug("Modchu_PlayerController init error masterClass == null !!");			return;		}		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_PlayerController.class, Object[].class }, new Object[]{ this, new Object[]{ minecraft, par2NetClientHandler } });		//Modchu_Debug.mDebug("Modchu_PlayerController instance="+instance);		master = instance instanceof Modchu_IPlayerControllerMaster ? (Modchu_IPlayerControllerMaster) instance : null;	}	@Override	public EntityPlayerSP func_178892_a(World world, StatFileWriter statFileWriter) {		EntityPlayerSP entityPlayerSP = master != null ? (EntityPlayerSP) master.createPlayer(world) : null;		if (entityPlayerSP != null) return entityPlayerSP;		return super.func_178892_a(world, statFileWriter);	}	public EntityPlayerSP superCreatePlayer(Object world, Object statFileWriter) {		return super.func_178892_a((World) world, (StatFileWriter) statFileWriter);	}	@Override	public void setPlayerCapabilities(EntityPlayer entityPlayer) {		if (master != null) master.setPlayerCapabilities(entityPlayer);		else super.setPlayerCapabilities(entityPlayer);	}	public void superSetPlayerCapabilities(Object entityPlayer) {		super.setPlayerCapabilities((EntityPlayer) entityPlayer);	}	@Override	public boolean isSpectator() {		return master != null ? master.isSpectator() : super.isSpectator();	}	public boolean superIsSpectator() {		return super.isSpectator();	}	@Override	public void setGameType(GameType gameType) {		if (master != null) master.setGameType(gameType);		else super.setGameType(gameType);	}	public void superSetGameType(Object gameType) {		super.setGameType((GameType) gameType);	}	@Override	public void flipPlayer(EntityPlayer entityPlayer) {		if (master != null) master.flipPlayer(entityPlayer);		else super.flipPlayer(entityPlayer);	}	public void superFlipPlayer(Object entityPlayer) {		super.flipPlayer((EntityPlayer) entityPlayer);	}	@Override	public boolean shouldDrawHUD() {		return master != null ? master.shouldDrawHUD() : super.shouldDrawHUD();	}	public boolean superShouldDrawHUD() {		return super.shouldDrawHUD();	}	@Override	public boolean onPlayerDestroyBlock(BlockPos blockPos, EnumFacing enumFacing) {		return master != null ? master.onPlayerDestroyBlock(blockPos, enumFacing) : super.onPlayerDestroyBlock(blockPos, enumFacing);	}	public boolean superOnPlayerDestroyBlock(Object blockPos, Object enumFacing) {		return super.onPlayerDestroyBlock((BlockPos) blockPos, (EnumFacing) enumFacing);	}	@Override	public boolean func_180511_b(BlockPos blockPos, EnumFacing enumFacing) {		return master != null ? master.func_180511_b(blockPos, enumFacing) : super.func_180511_b(blockPos, enumFacing);	}	public boolean superFunc_180511_b(Object blockPos, Object enumFacing) {		return super.func_180511_b((BlockPos) blockPos, (EnumFacing) enumFacing);	}	@Override	public void resetBlockRemoving() {		if (master != null) master.resetBlockRemoving();		else super.resetBlockRemoving();	}	public void superResetBlockRemoving() {		super.resetBlockRemoving();	}	@Override	public boolean func_180512_c(BlockPos blockPos, EnumFacing enumFacing) {		return master != null ? master.func_180512_c(blockPos, enumFacing) : super.func_180512_c(blockPos, enumFacing);	}	public boolean superFunc_180512_c(Object blockPos, Object enumFacing) {		return super.func_180512_c((BlockPos) blockPos, (EnumFacing) enumFacing);	}	@Override	public float getBlockReachDistance() {		return master != null ? master.getBlockReachDistance() : super.getBlockReachDistance();	}	public float superGetBlockReachDistance() {		return super.getBlockReachDistance();	}	@Override	public void updateController() {		if (master != null) master.updateController();		else super.updateController();	}	public void superUpdateController() {		super.updateController();	}	@Override	public boolean func_178890_a(EntityPlayerSP entityPlayerSP, WorldClient worldClient, ItemStack itemStack, BlockPos blockPos, EnumFacing enumFacing, Vec3 vec3) {		return master != null ? master.func_178890_a(entityPlayerSP, worldClient, itemStack, blockPos, enumFacing, vec3) : super.func_178890_a(entityPlayerSP, worldClient, itemStack, blockPos, enumFacing, vec3);	}	public boolean superFunc_178890_a(Object entityPlayerSP, Object world, Object itemStack, Object blockPos, Object enumFacing, Object vec3) {		return super.func_178890_a((EntityPlayerSP) entityPlayerSP, (WorldClient) world, (ItemStack) itemStack, (BlockPos) blockPos, (EnumFacing) enumFacing, (Vec3) vec3);	}	@Override	public boolean sendUseItem(EntityPlayer entityPlayer, World world, ItemStack itemStack) {		return master != null ? master.sendUseItem(entityPlayer, world, itemStack) : super.sendUseItem(entityPlayer, world, itemStack);	}	public boolean superSendUseItem(Object entityPlayer, Object world, Object itemStack) {		return super.sendUseItem((EntityPlayer) entityPlayer, (World) world, (ItemStack) itemStack);	}	@Override	public void attackEntity(EntityPlayer entityPlayer, Entity entity) {		if (master != null) master.attackEntity(entityPlayer, entity);		else super.attackEntity(entityPlayer, entity);	}	public void superAttackEntity(Object entityPlayer, Object entity) {		super.attackEntity((EntityPlayer) entityPlayer, (Entity) entity);	}	@Override	public ItemStack windowClick(int par1, int par2, int par3, int par4, EntityPlayer entityPlayer) {		return (ItemStack) (master != null ? master.windowClick(par1, par2, par3, par4, entityPlayer) : super.windowClick(par1, par2, par3, par4, entityPlayer));	}	public ItemStack superWindowClick(int par1, int par2, int par3, int par4, Object entityPlayer) {		return super.windowClick(par1, par2, par3, par4, (EntityPlayer) entityPlayer);	}	@Override	public void sendEnchantPacket(int par1, int par2) {		if (master != null) master.sendEnchantPacket(par1, par2);		else super.sendEnchantPacket(par1, par2);	}	public void superSendEnchantPacket(int par1, int par2) {		super.sendEnchantPacket(par1, par2);	}	@Override	public void sendSlotPacket(ItemStack itemStack, int par2) {		if (master != null) master.sendSlotPacket(itemStack, par2);		else super.sendSlotPacket(itemStack, par2);	}	public void superSendSlotPacket(Object itemStack, int par2) {		super.sendSlotPacket((ItemStack) itemStack, par2);	}	@Override	public void onStoppedUsingItem(EntityPlayer entityPlayer) {		if (master != null) master.onStoppedUsingItem(entityPlayer);		else super.onStoppedUsingItem(entityPlayer);	}	public void superOnStoppedUsingItem(Object entityPlayer) {		super.onStoppedUsingItem((EntityPlayer) entityPlayer);	}	@Override	public boolean isNotCreative() {		return master != null ? master.isNotCreative() : super.isNotCreative();	}	public boolean superIsNotCreative() {		return super.isNotCreative();	}	@Override	public boolean isInCreativeMode() {		return master != null ? master.isInCreativeMode() : super.isInCreativeMode();	}	public boolean superIsInCreativeMode() {		return super.isInCreativeMode();	}	@Override	public boolean extendedReach() {		return master != null ? master.extendedReach() : super.extendedReach();	}	public boolean superExtendedReach() {		return super.extendedReach();	}	@Override	public boolean isRidingHorse() {		return master != null ? master.isRidingHorse() : super.isRidingHorse();	}	public boolean superIsRidingHorse() {		return super.isRidingHorse();	}	// ~162	public boolean func_78768_b(EntityPlayer entityPlayer, Entity entity) {		return false;	}	public boolean superFunc_78768_b(Object entityPlayer, Object entity) {		return false;	}	public void func_78752_a(ItemStack itemStack) {	}	public void superFunc_78752_a(Object itemStack) {	}	public boolean func_78763_f() {		return false;	}	public boolean superFunc_78763_f() {		return false;	}	// 172~	@Override	public boolean interactWithEntitySendPacket(EntityPlayer entityPlayer, Entity entity) {		return master != null ? master.interactWithEntitySendPacket(entityPlayer, entity) : super.interactWithEntitySendPacket(entityPlayer, entity);	}	public boolean superInteractWithEntitySendPacket(Object entityPlayer, Object entity) {		return super.interactWithEntitySendPacket((EntityPlayer) entityPlayer, (Entity) entity);	}	@Override	public void sendPacketDropItem(ItemStack itemStack) {		if (master != null) master.sendPacketDropItem(itemStack);		else super.sendPacketDropItem(itemStack);	}	public void superSendPacketDropItem(Object itemStack) {		super.sendPacketDropItem((ItemStack) itemStack);	}	@Override	public boolean gameIsSurvivalOrAdventure() {		return master != null ? master.gameIsSurvivalOrAdventure() : super.gameIsSurvivalOrAdventure();	}	public boolean superGameIsSurvivalOrAdventure() {		return super.gameIsSurvivalOrAdventure();	}	// ~179	public boolean onPlayerDestroyBlock(int par1, int par2, int par3, int par4) {		return false;	}	public boolean superOnPlayerDestroyBlock(int par1, int par2, int par3, int par4) {		return false;	}	public void clickBlock(int par1, int par2, int par3, int par4) {	}	public void superClickBlock(int par1, int par2, int par3, int par4) {	}	public void onPlayerDamageBlock(int par1, int par2, int par3, int par4) {	}	public void superOnPlayerDamageBlock(int par1, int par2, int par3, int par4) {	}	public boolean onPlayerRightClick(EntityPlayer entityPlayer, World world, ItemStack itemStack, int par4, int par5, int par6, int par7, Vec3 vec3) {		return false;	}	public boolean superOnPlayerRightClick(Object entityPlayer, Object world, Object itemStack, int par4, int par5, int par6, int par7, Object vec3) {		return false;	}}