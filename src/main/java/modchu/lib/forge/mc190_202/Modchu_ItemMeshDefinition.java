package modchu.lib.forge.mc190_202;

import java.util.HashMap;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

public class Modchu_ItemMeshDefinition implements ItemMeshDefinition {
	private String name;
	private String typeString;

	public Modchu_ItemMeshDefinition(HashMap<String, Object> map) {
		name = (String) map.get("String");
		typeString = (String) map.get("String1");
	}

	@Override
	public ModelResourceLocation getModelLocation(ItemStack itemStack) {
		return new ModelResourceLocation(name, typeString);
	}

}
