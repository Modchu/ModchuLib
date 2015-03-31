package modchu.lib.modloader.mc162;

import java.util.HashMap;

import modchu.lib.Modchu_EventSystem;
import modchu.lib.Modchu_Main;
import net.minecraft.src.BaseMod;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.Minecraft;

public class ModchuLibTick extends BaseMod {
	private ModchuLibTick instance;

	public ModchuLibTick(HashMap<String, Object> map) {
		instance = this;
	}

	@Override
	public String getVersion() {
		return null;
	}

	@Override
	public void load() {
	}

	@Override
	public boolean onTickInGame(float f, Minecraft minecraft) {
		return Modchu_Main.onTickInGame(null, f, minecraft, (byte)0);
	}

	@Override
	public boolean onTickInGUI(float f, Minecraft minecraft, GuiScreen guiscreen) {
		String s = "onTickInGUI";
		if (Modchu_Main.getEventObjectLoadCheckList().contains(s)) return false;
		Modchu_EventSystem.eventObjectLoad(Modchu_Main.getEventObjectList(), Modchu_Main.getEventObjectLoadCheckList(), s, s, new Class[]{ Object.class }, new Object[]{ new Object[]{ f, minecraft, guiscreen } });
		return true;
	}
}