package modchu.lib.forge.mc194;import java.util.HashMap;import modchu.lib.Modchu_IPlayerController;import net.minecraft.client.entity.EntityPlayerSP;import net.minecraft.client.multiplayer.WorldClient;import net.minecraft.entity.Entity;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.inventory.ClickType;import net.minecraft.item.ItemStack;import net.minecraft.stats.StatisticsManager;import net.minecraft.util.EnumActionResult;import net.minecraft.util.EnumFacing;import net.minecraft.util.EnumHand;import net.minecraft.util.math.BlockPos;import net.minecraft.util.math.RayTraceResult;import net.minecraft.util.math.Vec3d;import net.minecraft.world.World;import net.minecraft.world.WorldSettings.GameType;public class Modchu_PlayerController extends modchu.lib.forge.mc190_220.Modchu_PlayerController {	public Modchu_PlayerController(HashMap<String, Object> map) {		super(map);	}	@Override	public EntityPlayerSP createClientPlayer(World world, StatisticsManager statisticsManager) {		EntityPlayerSP entityPlayerSP = master != null ? (EntityPlayerSP) master.createPlayer(world, statisticsManager, null) : null;		if (entityPlayerSP != null) return entityPlayerSP;		return super.createClientPlayer(world, statisticsManager);	}	@Override	public EntityPlayerSP superCreatePlayer(Object world, Object statisticsManager, Object recipeBook) {		return super.createClientPlayer((World) world, (StatisticsManager) statisticsManager);	}	@Override	public boolean onPlayerDestroyBlock(BlockPos blockPos) {		return master != null ? master.onPlayerDestroyBlock(blockPos) : super.onPlayerDestroyBlock(blockPos);	}	@Override	public boolean superOnPlayerDestroyBlock(Object blockPos) {		return super.onPlayerDestroyBlock((BlockPos) blockPos);	}	@Override	public ItemStack windowClick(int par1, int par2, int par3, ClickType clickType, EntityPlayer entityPlayer) {		return (ItemStack) (master != null ? master.windowClick(par1, par2, par3, clickType, entityPlayer) : super.windowClick(par1, par2, par3, clickType, entityPlayer));	}	@Override	public ItemStack superWindowClick(int par1, int par2, int par3, Object clickType, Object entityPlayer) {		return super.windowClick(par1, par2, par3, (ClickType) clickType, (EntityPlayer) entityPlayer);	}	// 172~202	@Override	public EnumActionResult interactWithEntity(EntityPlayer entityPlayer, Entity entity, ItemStack itemStack, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.interactWithEntity(entityPlayer, entity, itemStack, enumHand) : super.interactWithEntity(entityPlayer, entity, itemStack, enumHand));	}	@Override	public Object superInteractWithEntity(Object entityPlayer, Object entity, Object itemStack, Object enumHand) {		return super.interactWithEntity((EntityPlayer) entityPlayer, (Entity) entity, (ItemStack) itemStack, (EnumHand) enumHand);	}	// 200~分離	@Override	public void setGameType(GameType gameType) {		if (master != null) master.setGameType(gameType);		else super.setGameType(gameType);	}	@Override	public void superSetGameType(Object gameType) {		super.setGameType((GameType) gameType);	}	// 210~分離	@Override	public EnumActionResult processRightClickBlock(EntityPlayerSP entityPlayerSP, WorldClient worldClient, ItemStack itemStack, BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.processRightClickBlock(entityPlayerSP, worldClient, itemStack, blockPos, enumFacing, vec3, enumHand) : super.processRightClickBlock(entityPlayerSP, worldClient, itemStack, blockPos, enumFacing, vec3, enumHand));	}	@Override	public Object superProcessRightClickBlock(Object entityPlayerSP, Object world, Object itemStack, Object blockPos, Object enumFacing, Object vec3, Object enumHand) {		return super.processRightClickBlock((EntityPlayerSP) entityPlayerSP, (WorldClient) world, (ItemStack) itemStack, (BlockPos) blockPos, (EnumFacing) enumFacing, (Vec3d) vec3, (EnumHand) enumHand);	}	@Override	public EnumActionResult processRightClick(EntityPlayer entityPlayer, World world, ItemStack itemStack, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.processRightClick(entityPlayer, world, itemStack, enumHand) : super.processRightClick(entityPlayer, world, itemStack, enumHand));	}	@Override	public Object superProcessRightClick(Object entityPlayer, Object world, Object itemStack, Object enumHand) {		return super.processRightClick((EntityPlayer) entityPlayer, (World) world, (ItemStack) itemStack, (EnumHand) enumHand);	}	@Override	public Object superSendUseItem(Object entityPlayer, Object world, Object itemStack, Object enumHand) {		return super.processRightClick((EntityPlayer) entityPlayer, (World) world, (ItemStack) itemStack, (EnumHand) enumHand);	}	@Override	public boolean superFunc_178894_a(Object entityPlayer, Object entity, Object movingObjectPosition) {		return false;	}	@Override	public boolean superIsSpectatorMode() {		return super.isSpectatorMode();	}	@Override	public Object superGetCurrentGameType() {		return super.getCurrentGameType();	}	@Override	public boolean superFunc_181040_m() {		return super.getIsHittingBlock();	}	@Override	public EnumActionResult interactWithEntity(EntityPlayer entityPlayer, Entity entity, RayTraceResult rayTraceResult, ItemStack itemStack, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.interactWithEntity(entityPlayer, entity, rayTraceResult, itemStack, enumHand) : super.interactWithEntity(entityPlayer, entity, rayTraceResult, itemStack, enumHand));	}	@Override	public EnumActionResult superInteractWithEntity(Object entityPlayer, Object entity, Object rayTraceResult, Object itemStack, Object enumHand) {		return super.interactWithEntity((EntityPlayer) entityPlayer, (Entity) entity, (RayTraceResult) rayTraceResult, (ItemStack) itemStack, (EnumHand) enumHand);	}	@Override	public GameType getCurrentGameType() {		return (GameType) (master != null ? master.getCurrentGameType() : super.getCurrentGameType());	}}