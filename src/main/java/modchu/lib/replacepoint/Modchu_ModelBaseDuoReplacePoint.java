package modchu.lib.replacepoint;

import modchu.lib.replace.Modchu_ModelBaseDuoBase;
import net.minecraft.client.renderer.entity.RendererLivingEntity;

public class Modchu_ModelBaseDuoReplacePoint extends Modchu_ModelBaseDuoBase {

	public Modchu_ModelBaseDuoReplacePoint(RendererLivingEntity pRender) {
		super(pRender);
	}

	public Modchu_ModelBaseDuoReplacePoint(Object pRender) {
		this((RendererLivingEntity)pRender);
	}
}
