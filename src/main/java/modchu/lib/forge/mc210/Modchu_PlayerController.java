package modchu.lib.forge.mc210;import java.util.HashMap;import modchu.lib.Modchu_IPlayerController;import net.minecraft.client.entity.EntityPlayerSP;import net.minecraft.client.multiplayer.WorldClient;import net.minecraft.entity.Entity;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.item.ItemStack;import net.minecraft.util.EnumActionResult;import net.minecraft.util.EnumFacing;import net.minecraft.util.EnumHand;import net.minecraft.util.math.BlockPos;import net.minecraft.util.math.Vec3d;import net.minecraft.world.World;public class Modchu_PlayerController extends modchu.lib.forge.mc202_210.Modchu_PlayerController implements Modchu_IPlayerController {	public Modchu_PlayerController(HashMap<String, Object> map) {		super(map);	}	@Override	public EnumActionResult processRightClickBlock(EntityPlayerSP entityPlayerSP, WorldClient worldClient, BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.processRightClickBlock(entityPlayerSP, worldClient, null, blockPos, enumFacing, vec3, enumHand) : super.processRightClickBlock(entityPlayerSP, worldClient, blockPos, enumFacing, vec3, enumHand));	}	@Override	public Object superProcessRightClickBlock(Object entityPlayerSP, Object world, Object itemStack, Object blockPos, Object enumFacing, Object vec3, Object enumHand) {		return super.processRightClickBlock((EntityPlayerSP) entityPlayerSP, (WorldClient) world, (BlockPos) blockPos, (EnumFacing) enumFacing, (Vec3d) vec3, (EnumHand) enumHand);	}	@Override	public EnumActionResult processRightClick(EntityPlayer entityPlayer, World world, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.processRightClick(entityPlayer, world, null, enumHand) : super.processRightClick(entityPlayer, world, enumHand));	}	@Override	public Object superProcessRightClick(Object entityPlayer, Object world, Object itemStack, Object enumHand) {		return super.processRightClick((EntityPlayer) entityPlayer, (World) world, (EnumHand) enumHand);	}	@Override	public Object superSendUseItem(Object entityPlayer, Object world, Object itemStack, Object enumHand) {		return super.processRightClick((EntityPlayer) entityPlayer, (World) world, (EnumHand) enumHand);	}	// 172~202	@Override	public EnumActionResult interactWithEntity(EntityPlayer entityPlayer, Entity entity, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.interactWithEntity(entityPlayer, entity, null, enumHand) : super.interactWithEntity(entityPlayer, entity, enumHand));	}	@Override	public Object superInteractWithEntity(Object entityPlayer, Object entity, Object itemStack, Object enumHand) {		return super.interactWithEntity((EntityPlayer) entityPlayer, (Entity) entity, (EnumHand) enumHand);	}}