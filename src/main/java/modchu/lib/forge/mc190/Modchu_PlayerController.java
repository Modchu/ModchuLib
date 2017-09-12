package modchu.lib.forge.mc190;import java.util.HashMap;import modchu.lib.Modchu_IPlayerController;import net.minecraft.client.entity.EntityPlayerSP;import net.minecraft.client.multiplayer.WorldClient;import net.minecraft.entity.Entity;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.inventory.ClickType;import net.minecraft.item.ItemStack;import net.minecraft.stats.StatFileWriter;import net.minecraft.util.EnumActionResult;import net.minecraft.util.EnumFacing;import net.minecraft.util.EnumHand;import net.minecraft.util.math.BlockPos;import net.minecraft.util.math.Vec3d;import net.minecraft.world.World;import net.minecraft.world.WorldSettings.GameType;public class Modchu_PlayerController extends modchu.lib.forge.mc190_221.Modchu_PlayerController implements Modchu_IPlayerController {	public Modchu_PlayerController(HashMap<String, Object> map) {		super(map);	}	@Override	public EntityPlayerSP createClientPlayer(World world, StatFileWriter statFileWriter) {		EntityPlayerSP entityPlayerSP = master != null ? (EntityPlayerSP) master.createPlayer(world, statFileWriter, null) : null;		if (entityPlayerSP != null) return entityPlayerSP;		return super.createClientPlayer(world, statFileWriter);	}	@Override	public EntityPlayerSP superCreatePlayer(Object world, Object statFileWriter, Object recipeBook) {		return super.createClientPlayer((World) world, (StatFileWriter) statFileWriter);	}	@Override	public boolean func_187103_a(BlockPos blockPos) {		return master != null ? master.onPlayerDestroyBlock(blockPos) : super.func_187103_a(blockPos);	}	@Override	public boolean superOnPlayerDestroyBlock(Object blockPos) {		return super.func_187103_a((BlockPos) blockPos);	}	@Override	public ItemStack func_187098_a(int par1, int par2, int par3, ClickType clickType, EntityPlayer entityPlayer) {		return (ItemStack) (master != null ? master.windowClick(par1, par2, par3, clickType, entityPlayer) : super.func_187098_a(par1, par2, par3, clickType, entityPlayer));	}	@Override	public ItemStack superWindowClick(int par1, int par2, int par3, Object clickType, Object entityPlayer) {		return super.func_187098_a(par1, par2, par3, (ClickType) clickType, (EntityPlayer) entityPlayer);	}	// 172~202	@Override	public EnumActionResult func_187097_a(EntityPlayer entityPlayer, Entity entity, ItemStack itemStack, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.interactWithEntity(entityPlayer, entity, itemStack, enumHand) : super.func_187097_a(entityPlayer, entity, itemStack, enumHand));	}	@Override	public Object superInteractWithEntity(Object entityPlayer, Object entity, Object itemStack, Object enumHand) {		return super.func_187097_a((EntityPlayer) entityPlayer, (Entity) entity, (ItemStack) itemStack, (EnumHand) enumHand);	}	// 200~分離	@Override	public void setGameType(GameType gameType) {		if (master != null) master.setGameType(gameType);		else super.setGameType(gameType);	}	@Override	public void superSetGameType(Object gameType) {		super.setGameType((GameType) gameType);	}	// 210~分離	@Override	public EnumActionResult processRightClickBlock(EntityPlayerSP entityPlayerSP, WorldClient worldClient, ItemStack itemStack, BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.processRightClickBlock(entityPlayerSP, worldClient, itemStack, blockPos, enumFacing, vec3, enumHand) : super.processRightClickBlock(entityPlayerSP, worldClient, itemStack, blockPos, enumFacing, vec3, enumHand));	}	@Override	public Object superProcessRightClickBlock(Object entityPlayerSP, Object world, Object itemStack, Object blockPos, Object enumFacing, Object vec3, Object enumHand) {		return super.processRightClickBlock((EntityPlayerSP) entityPlayerSP, (WorldClient) world, (ItemStack) itemStack, (BlockPos) blockPos, (EnumFacing) enumFacing, (Vec3d) vec3, (EnumHand) enumHand);	}	@Override	public EnumActionResult processRightClick(EntityPlayer entityPlayer, World world, ItemStack itemStack, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.processRightClick(entityPlayer, world, itemStack, enumHand) : super.processRightClick(entityPlayer, world, itemStack, enumHand));	}	@Override	public Object superProcessRightClick(Object entityPlayer, Object world, Object itemStack, Object enumHand) {		return super.processRightClick((EntityPlayer) entityPlayer, (World) world, (ItemStack) itemStack, (EnumHand) enumHand);	}	@Override	public Object superSendUseItem(Object entityPlayer, Object world, Object itemStack, Object enumHand) {		return super.processRightClick((EntityPlayer) entityPlayer, (World) world, (ItemStack) itemStack, (EnumHand) enumHand);	}	@Override	public EnumActionResult superInteractWithEntity(Object entityPlayer, Object entity, Object rayTraceResult, Object itemStack, Object enumHand) {		return null;	}	@Override	public boolean superFunc_178894_a(Object entityPlayer, Object entity, Object movingObjectPosition) {		return false;	}	@Override	public boolean superFunc_181040_m() {		return false;	}	@Override	public GameType getCurrentGameType() {		return (GameType) (master != null ? master.getCurrentGameType() : super.getCurrentGameType());	}}