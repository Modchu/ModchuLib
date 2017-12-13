package modchu.lib.forge.mc152;

import java.util.HashMap;

import modchu.lib.Modchu_IGuiHandlerMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class Modchu_IGuiHandler implements IGuiHandler {
	public Modchu_IGuiHandlerMaster master;

	public Modchu_IGuiHandler(HashMap<String, Object> map) {
		map.put("base", this);
		Object instance = map.containsKey("instance") ? map.get("instance") : Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_IGuiHandler init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IGuiHandlerMaster ? (Modchu_IGuiHandlerMaster) instance : null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer entityPlayer, World world, int x, int y, int z) {
		return master != null ? master.getServerGuiElement(ID, entityPlayer, world, x, y, z) : null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer entityPlayer, World world, int x, int y, int z) {
		return master != null ? master.getClientGuiElement(ID, entityPlayer, world, x, y, z) : null;
	}

}
