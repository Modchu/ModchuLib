package modchu.lib.characteristic;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_IPlayerControllerMaster;import modchu.lib.Modchu_Reflect;import modchu.pflm.PFLM_PlayerControllerMaster;import net.minecraft.src.Entity;import net.minecraft.src.EntityClientPlayerMP;import net.minecraft.src.EntityPlayer;import net.minecraft.src.EnumGameType;import net.minecraft.src.ItemStack;import net.minecraft.src.Minecraft;import net.minecraft.src.NetClientHandler;import net.minecraft.src.NetHandler;import net.minecraft.src.PlayerControllerMP;import net.minecraft.src.Vec3;import net.minecraft.src.World;public class Modchu_PlayerController extends PlayerControllerMP {	public static Modchu_IPlayerControllerMaster master;	public Modchu_PlayerController(Class masterClass, Object minecraft, Object par2NetClientHandler) {		super((Minecraft) minecraft, (NetClientHandler) par2NetClientHandler);		if (masterClass != null) ;else {			Modchu_Debug.Debug("Modchu_PlayerController init error masterClass == null !!");			return;		}		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_PlayerController.class, Object[].class }, new Object[]{ this, new Object[]{ minecraft, par2NetClientHandler } });		//Modchu_Debug.mDebug("Modchu_PlayerController instance="+instance);		master = instance instanceof Modchu_IPlayerControllerMaster ? (Modchu_IPlayerControllerMaster) instance : null;	}	@Override	public EntityClientPlayerMP func_78754_a(World world) {		EntityClientPlayerMP entityClientPlayerMP = master != null ? (EntityClientPlayerMP) master.createPlayer(world) : null;		if (entityClientPlayerMP != null) return entityClientPlayerMP;		return super.func_78754_a(world);	}	public EntityClientPlayerMP superCreatePlayer(Object world, Object statFileWriter) {		return super.func_78754_a((World) world);	}	@Override	public void setPlayerCapabilities(EntityPlayer entityPlayer) {		if (master != null) master.setPlayerCapabilities(entityPlayer);		else super.setPlayerCapabilities(entityPlayer);	}	public void superSetPlayerCapabilities(Object entityPlayer) {		super.setPlayerCapabilities((EntityPlayer) entityPlayer);	}	@Override	public boolean enableEverythingIsScrewedUpMode() {		return master != null ? master.isSpectator() : super.enableEverythingIsScrewedUpMode();	}	public boolean superIsSpectator() {		return super.enableEverythingIsScrewedUpMode();	}	@Override	public void setGameType(EnumGameType enumGameType) {		if (master != null) master.setGameType(enumGameType);		else super.setGameType(enumGameType);	}	public void superSetGameType(Object enumGameType) {		super.setGameType((EnumGameType) enumGameType);	}	@Override	public void flipPlayer(EntityPlayer entityPlayer) {		if (master != null) master.flipPlayer(entityPlayer);		else super.flipPlayer(entityPlayer);	}	public void superFlipPlayer(Object entityPlayer) {		super.flipPlayer((EntityPlayer) entityPlayer);	}	@Override	public boolean shouldDrawHUD() {		return master != null ? master.shouldDrawHUD() : super.shouldDrawHUD();	}	public boolean superShouldDrawHUD() {		return super.shouldDrawHUD();	}	@Override	public boolean onPlayerDestroyBlock(int par1, int par2, int par3, int par4) {		return master != null ? master.onPlayerDestroyBlock(par1, par2, par3, par4) : super.onPlayerDestroyBlock(par1, par2, par3, par4);	}	public boolean superOnPlayerDestroyBlock(int par1, int par2, int par3, int par4) {		return super.onPlayerDestroyBlock(par1, par2, par3, par4);	}	@Override	public void clickBlock(int par1, int par2, int par3, int par4) {		if (master != null) master.clickBlock(par1, par2, par3, par4);		else super.clickBlock(par1, par2, par3, par4);	}	public void superClickBlock(int par1, int par2, int par3, int par4) {		super.clickBlock(par1, par2, par3, par4);	}	@Override	public void resetBlockRemoving() {		if (master != null) master.resetBlockRemoving();		else super.resetBlockRemoving();	}	public void superResetBlockRemoving() {		super.resetBlockRemoving();	}	@Override	public void onPlayerDamageBlock(int par1, int par2, int par3, int par4) {		if (master != null) master.onPlayerDamageBlock(par1, par2, par3, par4);		else super.onPlayerDamageBlock(par1, par2, par3, par4);	}	public void superOnPlayerDamageBlock(int par1, int par2, int par3, int par4) {		super.onPlayerDamageBlock(par1, par2, par3, par4);	}	@Override	public float getBlockReachDistance() {		return master != null ? master.getBlockReachDistance() : super.getBlockReachDistance();	}	public float superGetBlockReachDistance() {		return super.getBlockReachDistance();	}	@Override	public void updateController() {		if (master != null) master.updateController();		else super.updateController();	}	public void superUpdateController() {		super.updateController();	}	@Override	public boolean onPlayerRightClick(EntityPlayer entityPlayer, World world, ItemStack itemStack, int par4, int par5, int par6, int par7, Vec3 vec3) {		return master != null ? master.onPlayerRightClick(entityPlayer, world, itemStack, par4, par5, par6, par7, vec3) : super.onPlayerRightClick(entityPlayer, world, itemStack, par4, par5, par6, par7, vec3);	}	public boolean superOnPlayerRightClick(Object entityPlayer, Object world, Object itemStack, int par4, int par5, int par6, int par7, Object vec3) {		return super.onPlayerRightClick((EntityPlayer) entityPlayer, (World) world, (ItemStack) itemStack, par4, par5, par6, par7, (Vec3) vec3);	}	@Override	public boolean sendUseItem(EntityPlayer entityPlayer, World world, ItemStack itemStack) {		return master != null ? master.sendUseItem(entityPlayer, world, itemStack) : super.sendUseItem(entityPlayer, world, itemStack);	}	public boolean superSendUseItem(Object entityPlayer, Object world, Object itemStack) {		return super.sendUseItem((EntityPlayer) entityPlayer, (World) world, (ItemStack) itemStack);	}	@Override	public void attackEntity(EntityPlayer entityPlayer, Entity entity) {		if (master != null) master.attackEntity(entityPlayer, entity);		else super.attackEntity(entityPlayer, entity);	}	public void superAttackEntity(Object entityPlayer, Object entity) {		super.attackEntity((EntityPlayer) entityPlayer, (Entity) entity);	}	@Override	public ItemStack windowClick(int par1, int par2, int par3, int par4, EntityPlayer entityPlayer) {		return (ItemStack) (master != null ? master.windowClick(par1, par2, par3, par4, entityPlayer) : super.windowClick(par1, par2, par3, par4, entityPlayer));	}	public ItemStack superWindowClick(int par1, int par2, int par3, int par4, Object entityPlayer) {		return super.windowClick(par1, par2, par3, par4, (EntityPlayer) entityPlayer);	}	@Override	public void sendEnchantPacket(int par1, int par2) {		if (master != null) master.sendEnchantPacket(par1, par2);		else super.sendEnchantPacket(par1, par2);	}	public void superSendEnchantPacket(int par1, int par2) {		super.sendEnchantPacket(par1, par2);	}	@Override	public void sendSlotPacket(ItemStack itemStack, int par2) {		if (master != null) master.sendSlotPacket(itemStack, par2);		else super.sendSlotPacket(itemStack, par2);	}	public void superSendSlotPacket(Object itemStack, int par2) {		super.sendSlotPacket((ItemStack) itemStack, par2);	}	@Override	public void onStoppedUsingItem(EntityPlayer entityPlayer) {		if (master != null) master.onStoppedUsingItem(entityPlayer);		else super.onStoppedUsingItem(entityPlayer);	}	public void superOnStoppedUsingItem(Object entityPlayer) {		super.onStoppedUsingItem((EntityPlayer) entityPlayer);	}	@Override	public boolean isNotCreative() {		return master != null ? master.isNotCreative() : super.isNotCreative();	}	public boolean superIsNotCreative() {		return super.isNotCreative();	}	@Override	public boolean isInCreativeMode() {		return master != null ? master.isInCreativeMode() : super.isInCreativeMode();	}	public boolean superIsInCreativeMode() {		return super.isInCreativeMode();	}	@Override	public boolean extendedReach() {		return master != null ? master.extendedReach() : super.extendedReach();	}	public boolean superExtendedReach() {		return super.extendedReach();	}	@Override	public boolean func_110738_j() {		return master != null ? master.isRidingHorse() : super.func_110738_j();	}	public boolean superFunc_110738_j() {		return super.func_110738_j();	}	// ~162	@Override	public boolean func_78768_b(EntityPlayer entityPlayer, Entity entity) {		return master != null ? master.func_78768_b(entityPlayer, entity) : super.func_78768_b(entityPlayer, entity);	}	public boolean superFunc_78768_b(Object entityPlayer, Object entity) {		return super.func_78768_b((EntityPlayer) entityPlayer, (Entity) entity);	}	@Override	public void func_78752_a(ItemStack itemStack) {		if (master != null) master.func_78752_a(itemStack);		else super.func_78752_a(itemStack);	}	public void superFunc_78752_a(Object itemStack) {		super.func_78752_a((ItemStack) itemStack);	}	@Override	public boolean func_78763_f() {		return master != null ? master.func_78763_f() : super.func_78763_f();	}	public boolean superFunc_78763_f() {		return super.func_78763_f();	}	// 172~	public boolean interactWithEntitySendPacket(EntityPlayer entityPlayer, Entity entity) {		return false;	}	public boolean superInteractWithEntitySendPacket(Object entityPlayer, Object entity) {		return false;	}	public void sendPacketDropItem(ItemStack itemStack) {	}	public void superSendPacketDropItem(Object itemStack) {	}	public boolean gameIsSurvivalOrAdventure() {		return false;	}	public boolean superGameIsSurvivalOrAdventure() {		return false;	}	// 180~	public boolean superIsRidingHorse() {		return superFunc_110738_j();	}	public boolean superOnPlayerDestroyBlock(Object blockPos, Object enumFacing) {		return false;	}	public boolean superFunc_180511_b(Object blockPos, Object enumFacing) {		return false;	}	public boolean superFunc_180512_c(Object blockPos, Object enumFacing) {		return false;	}	public boolean superFunc_178890_a(Object entityPlayerSP, Object worldClient, Object itemStack, Object blockPos, Object enumFacing, Object vec3) {		return false;	}}