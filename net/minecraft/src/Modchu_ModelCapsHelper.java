package net.minecraft.src;

import java.util.Map;

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

	public static int getCapsValueInt(Object model, MMM_IModelCaps pOwner, int pIndex, Object ...pArg) {
		return getCapsValueInt(model, (Modchu_IModelCaps)pOwner, pIndex, (Object[])pArg);
	}

	public static int getCapsValueInt(Object model, Modchu_IModelCaps pOwner, int pIndex, Object ...pArg) {
		Object o = Modchu_Reflect.invokeMethod(model.getClass(), "getCapsValue", new Class[]{ Modchu_IModelCaps.class, int.class, Object[].class }, model, new Object[]{ pOwner, pIndex, pArg });
		//Object o = model.getCapsValue(pOwner, pIndex, pArg);
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return b ? 2 : 1;
		}
		return o != null ? (Integer) o : 0;
	}

	public static int getCapsValueInt(MMM_ModelMultiBase model, int pIndex, Object ...pArg) {
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

	public static float getCapsValueFloat(Object model, MMM_IModelCaps pOwner, int pIndex, Object ...pArg) {
		return getCapsValueFloat(model, (Modchu_IModelCaps)pOwner, pIndex, (Object[])pArg);
	}

	public static float getCapsValueFloat(Object model, Modchu_IModelCaps pOwner, int pIndex, Object ...pArg) {
		Object o = Modchu_Reflect.invokeMethod(model.getClass(), "getCapsValue", new Class[]{ Modchu_IModelCaps.class, int.class, Object[].class }, model, new Object[]{ pOwner, pIndex, pArg });
		//Object o = model.getCapsValue(pOwner, pIndex, pArg);
		return o != null ? (Float) o : 0.0F;
	}

	public static float getCapsValueFloat(MMM_ModelMultiBase model, int pIndex, Object ...pArg) {
		Object o = model.getCapsValue(pIndex, pArg);
		return o != null ? (Float) o : 0.0F;
	}

	public static float getCapsValueFloat(MMM_IModelCaps pOwner, int pIndex, Object ...pArg) {
		Object o = pOwner.getCapsValue(pIndex, pArg);
		return o != null ? (Float) o : 0.0F;
	}

	public static double getCapsValueDouble(Object model, MMM_IModelCaps pOwner, int pIndex, Object ...pArg) {
		return getCapsValueDouble(model, (Modchu_IModelCaps)pOwner, pIndex, (Object[])pArg);
	}

	public static double getCapsValueDouble(Object model, Modchu_IModelCaps pOwner, int pIndex, Object ...pArg) {
		Object o = Modchu_Reflect.invokeMethod(model.getClass(), "getCapsValue", new Class[]{ Modchu_IModelCaps.class, int.class, Object[].class }, model, new Object[]{ pOwner, pIndex, pArg });
		//Object o = model.getCapsValue(pOwner, pIndex, pArg);
		return o != null ? (Double) o : 0.0D;
	}

	public static double getCapsValueDouble(MMM_ModelMultiBase model, int pIndex, Object ...pArg) {
		Object o = model.getCapsValue(pIndex, pArg);
		return o != null ? (Double) o : 0.0D;
	}

	public static double getCapsValueDouble(MMM_IModelCaps pOwner, int pIndex, Object ...pArg) {
		Object o = pOwner.getCapsValue(pIndex, pArg);
		return o != null ? (Double) o : 0.0D;
	}

	public static boolean getCapsValueBoolean(Object model, MMM_IModelCaps pOwner, int pIndex, Object ...pArg) {
		return getCapsValueBoolean(model, (Modchu_IModelCaps)pOwner, pIndex, (Object[])pArg);
	}

	public static boolean getCapsValueBoolean(Object model, Modchu_IModelCaps pOwner, int pIndex, Object ...pArg) {
		Object o = Modchu_Reflect.invokeMethod(model.getClass(), "getCapsValue", new Class[]{ Modchu_IModelCaps.class, int.class, Object[].class }, model, new Object[]{ pOwner, pIndex, pArg });
		//Object o = model.getCapsValue(pOwner, pIndex, pArg);
		if (o != null) return (Boolean) o;
		if (pOwner != null) o = Modchu_Reflect.invokeMethod(pOwner.getClass(), "getCapsValue", new Class[]{ int.class, Object[].class }, pOwner, new Object[]{ pIndex, pArg });
		return o != null ? (Boolean) o : false;
	}

	public static boolean getCapsValueBoolean(Object model, int pIndex, Object ...pArg) {
		Object o = Modchu_Reflect.invokeMethod(model.getClass(), "getCapsValue", new Class[]{ int.class, Object[].class }, model, new Object[]{ pIndex, pArg });
		//Object o = model.getCapsValue(pIndex, pArg);
		return o != null ? (Boolean) o : false;
	}

	public static boolean getCapsValueBoolean(MMM_IModelCaps pOwner, int pIndex, Object ...pArg) {
		return getCapsValueBoolean((Modchu_IModelCaps)pOwner, pIndex, (Object[])pArg);
	}

	public static boolean getCapsValueBoolean(Modchu_IModelCaps pOwner, int pIndex, Object ...pArg) {
		Object o = pOwner.getCapsValue(pIndex, pArg);
		return o != null ? (Boolean) o : false;
	}

	public static boolean setCapsValue(Object model, MMM_IModelCaps pOwner, String pCapsName, Object... pArg) {
		return setCapsValue(model, (Modchu_IModelCaps)pOwner, pCapsName, (Object[])pArg);
	}

	public static boolean setCapsValue(Object model, Modchu_IModelCaps pOwner, String pCapsName, Object... pArg) {
		return model == null ? false : (Boolean)Modchu_Reflect.invokeMethod(model.getClass(), "getCapsValue", new Class[]{ Modchu_IModelCaps.class, int.class, Object[].class }, model, new Object[]{ pOwner, ((Map) Modchu_Reflect.invokeMethod(MMM_ModelMultiBase.class, "getModelCaps", model)).get(pCapsName), pArg });
		//model.setCapsValue(pOwner, model.getModelCaps().get(pCapsName), pArg);
	}

	public static boolean setCapsValue(MMM_IModelCaps pOwner, String pCapsName, Object... pArg) {
		return setCapsValue((Modchu_IModelCaps)pOwner, pCapsName, (Object[])pArg);
	}

	public static boolean setCapsValue(Modchu_IModelCaps pOwner, String pCapsName, Object... pArg) {
		return pOwner == null ? false : pOwner.setCapsValue(pOwner.getModelCaps().get(pCapsName), pArg);
	}

}
