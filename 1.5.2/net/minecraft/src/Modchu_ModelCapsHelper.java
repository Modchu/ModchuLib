package net.minecraft.src;

/**
 * ModelCapsÇÃï‚èïä÷êîåQ
 */
public class Modchu_ModelCapsHelper {

	public static Object getCapsValue(MMM_IModelCaps pOwner, int pCapsIndex, Object ...pArg) {
		return pOwner == null ? null : pOwner.getCapsValue(pCapsIndex, pArg);
	}

	public static Object getCapsValue(MMM_IModelCaps pOwner, String pCapsName, Object ...pArg) {
		return pOwner == null ? null : pOwner.getCapsValue(pOwner.getModelCaps().get(pCapsName), pArg);
	}

	public static int getCapsValueInt(MultiModelBaseBiped model, int pIndex, Object ...pArg) {
		Object o = model.getCapsValue(pIndex, pArg);
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return b ? 2 : 1;
		}
		return o != null ? (Integer) o : 0;
	}

	public static int getCapsValueInt(MMM_IModelCaps pOwner, int pIndex, Object ...pArg) {
		Object o = pOwner.getCapsValue(pIndex, pArg);
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return b ? 2 : 1;
		}
		return o != null ? (Integer) o : 0;
	}

	public static float getCapsValueFloat(MultiModelBaseBiped model, int pIndex, Object ...pArg) {
		Object o = model.getCapsValue(pIndex, pArg);
		return o != null ? (Float) o : 0.0F;
	}

	public static float getCapsValueFloat(MMM_IModelCaps pOwner, int pIndex, Object ...pArg) {
		Object o = pOwner.getCapsValue(pIndex, pArg);
		return o != null ? (Float) o : 0.0F;
	}

	public static double getCapsValueDouble(MultiModelBaseBiped model, int pIndex, Object ...pArg) {
		Object o = model.getCapsValue(pIndex, pArg);
		return o != null ? (Double) o : 0.0D;
	}

	public static double getCapsValueDouble(MMM_IModelCaps pOwner, int pIndex, Object ...pArg) {
		Object o = pOwner.getCapsValue(pIndex, pArg);
		return o != null ? (Double) o : 0.0D;
	}

	public static boolean getCapsValueBoolean(MultiModelBaseBiped model, int pIndex, Object ...pArg) {
		Object o = model.getCapsValue(pIndex, pArg);
		return o != null ? (Boolean) o : false;
	}

	public static boolean getCapsValueBoolean(MMM_IModelCaps pOwner, int pIndex, Object ...pArg) {
		Object o = pOwner.getCapsValue(pIndex, pArg);
		return o != null ? (Boolean) o : false;
	}

	public static boolean setCapsValue(MultiModelBaseBiped model, String pCapsName, Object... pArg) {
		return model == null ? false : model.setCapsValue(model.getModelCaps().get(pCapsName), pArg);
	}

	public static boolean setCapsValue(MMM_IModelCaps pOwner, String pCapsName, Object... pArg) {
		return pOwner == null ? false : pOwner.setCapsValue(pOwner.getModelCaps().get(pCapsName), pArg);
	}

}
