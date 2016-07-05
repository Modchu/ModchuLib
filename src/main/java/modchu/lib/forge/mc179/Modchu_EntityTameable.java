package modchu.lib.forge.mc179;

import java.util.HashMap;

import modchu.lib.Modchu_IEntityTameable;
import net.minecraft.world.World;

public class Modchu_EntityTameable extends modchu.lib.forge.mc172_179.Modchu_EntityTameable implements Modchu_IEntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public String func_152113_b() {
		return (String) (master != null ? master.getOwnerName() : super.func_152113_b());
	}

	@Override
	public String superGetOwnerName() {
		return super.func_152113_b();
	}

	@Override
	public void func_152115_b(String par1Str) {
		if (master != null) master.setOwner(par1Str);
		else super.func_152115_b(par1Str);
	}

	@Override
	public void superSetOwner(Object par1Str) {
		super.func_152115_b((String) par1Str);
	}

}
