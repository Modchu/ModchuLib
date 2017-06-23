package modchu.lib.forge.mc212;

import java.util.HashMap;

import net.minecraft.entity.EntityLiving;

public class Modchu_AllRenderLiving extends modchu.lib.forge.mc212_220.Modchu_AllRenderLiving {

	public Modchu_AllRenderLiving(HashMap<String, Object> map) {
		super(map);
	}
	// 180~212
	@Override
	public void setLightmap(EntityLiving entityLiving, float f) {
		modchu.lib.forge.mc190_220.Modchu_RenderLiving render = renderMapGet(entityLiving);
		if (render != null) render.setLightmap(entityLiving, f);
		else super.setLightmap(entityLiving, f);
	}

}
