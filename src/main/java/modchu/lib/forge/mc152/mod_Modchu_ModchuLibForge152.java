package modchu.lib.forge.mc152;import java.util.Map;import modchu.lib.Modchu_IBaseModMaster;import modchu.lib.Modchu_Init;import modchu.lib.Modchu_Main;import net.minecraft.src.BaseMod;public class mod_Modchu_ModchuLibForge152 extends BaseMod {	public static Modchu_IBaseModMaster master;	public static mod_Modchu_ModchuLibForge152 instance;	public mod_Modchu_ModchuLibForge152() {		if (!Modchu_Main.isModEnable) return;		Modchu_Init.init();		if (Modchu_Main.getMinecraftVersion() != 152				| !Modchu_Main.isForge) return;		instance = this;		master = (Modchu_IBaseModMaster) Modchu_Main.newModchuCharacteristicObject("Modchu_ModchuLibMaster", this);	}	@Override	public String getName() {		return master != null ? master.getName() : "mod_Modchu_ModchuLibForge152";	}	@Override	public String getVersion() {		return master != null ? master.getVersion() : "none";	}	@Override	public void load() {		if (master != null) master.load();	}	@Override	public void modsLoaded() {		if (master != null) master.modsLoaded();	}	@Override	public void addRenderer(Map map) {		if (master != null) master.addRenderer(map);	}	@Override	public int addFuel(int i, int j) {		return master != null ? master.addFuel(i, j) : 0;	}	@Override	public String getPriorities() {		return master != null ? master.getPriorities() : null;	}	@Override	public void clientChat(String s1) {		if (master != null) master.clientChat(s1);	}}