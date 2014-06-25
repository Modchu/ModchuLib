package modchu.lib.characteristic.recompileonly;

import modchu.lib.replacepoint.Modchu_IModelCapsReplacePoint;
import modchu.model.ModchuModel_IModelCaps;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.EntityLivingBase;

public interface Modchu_IModelBaseModchuModel extends Modchu_IModelCapsReplacePoint {

	public void renderItems(EntityLivingBase pEntity, Render pRender);
	public void showArmorParts(int pParts);
	public void setEntityCaps(ModchuModel_IModelCaps pModelCaps);
	public void setRender(Render pRender);
	public void setArmorRendering(boolean pFlag);

}
