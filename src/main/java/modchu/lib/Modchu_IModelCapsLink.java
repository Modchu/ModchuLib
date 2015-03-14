package modchu.lib;

public interface Modchu_IModelCapsLink extends Modchu_IEntityCapsBase {
	public void renderItems(Object entity, Object render);
	public void showArmorParts(int i);
	public void setEntityCaps(Modchu_IEntityCapsBase pModelCaps);
	public void setArmorRendering(boolean pFlag);

}
