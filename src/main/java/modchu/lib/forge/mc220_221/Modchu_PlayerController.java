package modchu.lib.forge.mc220_221;import java.util.HashMap;import modchu.lib.Modchu_IPlayerController;import net.minecraft.client.entity.EntityPlayerSP;import net.minecraft.entity.Entity;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.item.ItemStack;import net.minecraft.stats.RecipeBook;import net.minecraft.stats.StatisticsManager;import net.minecraft.util.EnumHand;import net.minecraft.util.math.RayTraceResult;import net.minecraft.world.World;public class Modchu_PlayerController extends modchu.lib.forge.mc210_221.Modchu_PlayerController implements Modchu_IPlayerController {	public Modchu_PlayerController(HashMap<String, Object> map) {		super(map);	}	@Override	public EntityPlayerSP createPlayer(World world, StatisticsManager statisticsManager, RecipeBook recipeBook) {		EntityPlayerSP entityPlayerSP = master != null ? (EntityPlayerSP) master.createPlayer(world, statisticsManager, recipeBook) : null;		if (entityPlayerSP != null) return entityPlayerSP;		return super.createPlayer(world, statisticsManager, recipeBook);	}	@Override	public EntityPlayerSP superCreatePlayer(Object world, Object statisticsManager, Object recipeBook) {		return super.createPlayer((World) world, (StatisticsManager) statisticsManager, (RecipeBook) recipeBook);	}	@Override	public boolean superFunc_178894_a(Object entityPlayer, Object entity, Object movingObjectPosition) {		return false;	}	@Override	public boolean superFunc_181040_m() {		return false;	}	@Override	public Object superInteractWithEntity(Object entityPlayer, Object entity, Object rayTraceResult, Object itemStack, Object enumHand) {		return super.interactWithEntity((EntityPlayer) entityPlayer, (Entity) entity, (RayTraceResult) rayTraceResult, (EnumHand) enumHand);	}}