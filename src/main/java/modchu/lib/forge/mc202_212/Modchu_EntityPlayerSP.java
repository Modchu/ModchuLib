package modchu.lib.forge.mc202_212;import java.util.HashMap;import modchu.lib.Modchu_IEntityPlayerSP;import net.minecraft.world.GameType;public abstract class Modchu_EntityPlayerSP extends modchu.lib.forge.mc194_212.Modchu_EntityPlayerSP {
	public Modchu_EntityPlayerSP(HashMap<String, Object> map) {
		super(map);
	}	@Override	public void setGameType(GameType gameType) {		if (master != null) master.setGameType(gameType);		else super.setGameType(gameType);	}	@Override	public void supersetGameType(Object gameType) {		super.setGameType((GameType) gameType);	}	@Override	public void superonChunkLoad() {	}}