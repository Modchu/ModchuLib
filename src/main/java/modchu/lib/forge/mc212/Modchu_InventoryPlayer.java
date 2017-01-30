package modchu.lib.forge.mc212;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;

public class Modchu_InventoryPlayer extends modchu.lib.forge.mc190_212.Modchu_InventoryPlayer {

	public Modchu_InventoryPlayer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isUsableByPlayer(entityPlayer) : super.isUsableByPlayer(entityPlayer);
	}

	@Override
	public boolean superIsUsableByPlayer(Object entityPlayer) {
		return super.isUsableByPlayer((EntityPlayer) entityPlayer);
	}

}
