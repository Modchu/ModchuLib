package modchu.lib.forge.mc202_220;import java.util.HashMap;import modchu.lib.Modchu_IPlayerController;import net.minecraft.client.entity.EntityPlayerSP;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.inventory.ClickType;import net.minecraft.item.ItemStack;import net.minecraft.stats.StatisticsManager;import net.minecraft.util.math.BlockPos;import net.minecraft.world.GameType;import net.minecraft.world.World;public abstract class Modchu_PlayerController extends modchu.lib.forge.mc190_220.Modchu_PlayerController implements Modchu_IPlayerController {	public Modchu_PlayerController(HashMap<String, Object> map) {		super(map);	}	@Override	public boolean onPlayerDestroyBlock(BlockPos blockPos) {		return master != null ? master.onPlayerDestroyBlock(blockPos) : super.onPlayerDestroyBlock(blockPos);	}	@Override	public boolean superOnPlayerDestroyBlock(Object blockPos) {		return super.onPlayerDestroyBlock((BlockPos) blockPos);	}	@Override	public ItemStack windowClick(int par1, int par2, int par3, ClickType clickType, EntityPlayer entityPlayer) {		return (ItemStack) (master != null ? master.windowClick(par1, par2, par3, clickType, entityPlayer) : super.windowClick(par1, par2, par3, clickType, entityPlayer));	}	@Override	public ItemStack superWindowClick(int par1, int par2, int par3, Object clickType, Object entityPlayer) {		return super.windowClick(par1, par2, par3, (ClickType) clickType, (EntityPlayer) entityPlayer);	}	// 200~分離	@Override	public void setGameType(GameType gameType) {		if (master != null) master.setGameType(gameType);		else super.setGameType(gameType);	}	@Override	public void superSetGameType(Object gameType) {		super.setGameType((GameType) gameType);	}}