package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Modchu_ModelDataBase extends Modchu_EntityCaps implements Modchu_IModelCaps {

	public static int allMultiModelActionMode = 0;
	public static int allMultiModelRunActionNumber = 0;
	public static final int allMultiModelActionModeMax = 2;
	public static final int allMultiModelActionMax = 30;
	public static boolean allMultiModelActionFlag = false;
	private Object subEntityCaps;
	private boolean isSitting = false;
	private boolean shortcutKeysAction = false;
	private boolean shortcutKeysActionInitFlag = true;
	private boolean actionFlag = false;
	private boolean actionReverse = false;
	private boolean motionResetFlag = false;
	private boolean motionSetFlag = false;
	private boolean sleeping = false;
	private boolean allMultiModelActionRunFlag = false;
	private float actionSpeed = 0.0F;
	private int skinMode = 0;
	private int runActionNumber = 0;
	private int actionReleaseNumber = 0;
	private int actionCount = 0;
	private int actionTime = 0;
	private int initFlag = 0;
	private List<String> showPartsHideList = new ArrayList();
	private ConcurrentHashMap<String, String> showPartsRenemeMap = new ConcurrentHashMap();
	private boolean allMultiModelActionRunInitFlag;

	public Modchu_ModelDataBase() {
		super();
	}

	@Override
	public Object getCapsValue(int pIndex, Object ... pArg) {
		return getCapsValue((MultiModelBaseBiped)null, pIndex, (Object[])pArg);
	}

	@Override
	public Object getCapsValue(MultiModelBaseBiped model, Modchu_IModelCaps entityCaps, int pIndex, Object... pArg) {
		return null;
	}

	@Override
	public Object getCapsValue(MultiModelBaseBiped model, int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_subEntityCaps:
			return getSubEntityCaps();
		case caps_isSitting:
			return getIsSitting();
		case caps_isSleeping:
			return getIsSleeping();
		case caps_initFlag:
			return getInitFlag();
		case caps_height:
			return owner.height;
		case caps_width:
			return owner.width;
		case caps_shortcutKeysAction:
			return getShortcutKeysAction();
		case caps_runActionNumber:
			return getRunActionNumber();
		case caps_actionReleaseNumber:
			return getActionReleaseNumber();
		case caps_actionFlag:
			return getActionFlag();
		case caps_actionCount:
			return getActionCount();
		case caps_actionTime:
			return getActionTime();
		case caps_actionSpeed:
			return getActionSpeed();
		case caps_actionReverse:
			return getActionReverse();
		case caps_shortcutKeysActionInitFlag:
			return getShortcutKeysActionInitFlag();
		case caps_skinMode:
			return getSkinMode();
		case caps_motionResetFlag:
			return getMotionResetFlag();
		case caps_motionSetFlag:
			return getMotionSetFlag();
		case caps_showPartsHideList:
			return getShowPartsHideList();
		case caps_showPartsRenemeMap:
			return getShowPartsRenemeMap();
		case caps_allMultiModelActionMode:
			return getAllMultiModelActionMode();
		case caps_allMultiModelActionModeMax:
			return getAllMultiModelActionModeMax();
		case caps_allMultiModelRunActionNumber:
			return getAllMultiModelRunActionNumber();
		case caps_allMultiModelActionFlag:
			return getAllMultiModelActionFlag();
		case caps_allMultiModelActionMax:
			return getAllMultiModelActionMax();
		}
		Object o = null;
		if (model != null) {
			o = model.getCapsValue(pIndex, (Object[]) pArg);
		}
		if (o != null) return o;
		if (subEntityCaps != null) {
			o = Modchu_Reflect.invokeMethod(mod_Modchu_ModchuLib.modchu_Main.MMM_IModelCaps, "getCapsValue", new Class[]{ int.class, Object[].class }, subEntityCaps, new Object[]{ pIndex, pArg });
			return o;
		}
		return super.getCapsValue(pIndex, (Object[]) pArg);
	}

	@Override
	public Object getCapsValue(Modchu_IModelCaps entityCaps, int pIndex, Object... pArg) {
		return null;
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		return setCapsValue((MultiModelBaseBiped)null, pIndex, (Object[])pArg);
	}

	@Override
	public boolean setCapsValue(MultiModelBaseBiped model, Modchu_IModelCaps entityCaps, int pIndex, Object... pArg) {
		return false;
	}

	@Override
	public boolean setCapsValue(MultiModelBaseBiped model, int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_Entity:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setEntity((Entity) pArg[0]);
				return true;
			}
			return false;
		case caps_subEntityCaps:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setSubEntityCaps(pArg[0]);
				return true;
			}
			return false;
		case caps_skinMode:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setSkinMode((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_isSitting:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setIsSitting((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_isSleeping:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setIsSleeping((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_initFlag:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setInitFlag((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_shortcutKeysAction:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setShortcutKeysAction((Boolean) pArg[0]);
				return true;
			}
			return false;
/*
		case caps_actionInit:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (modelMain.model instanceof  MultiModelAction) ((MultiModelAction) modelMain.model).actionInit(this, (Integer) pArg[0]);
				if (modelFATT.modelInner instanceof  MultiModelAction) ((MultiModelAction) modelFATT.modelInner).actionInit(this, (Integer) pArg[0]);;
				if (modelFATT.modelOuter instanceof  MultiModelAction) ((MultiModelAction) modelFATT.modelOuter).actionInit(this, (Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_actionRelease:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (modelMain.model instanceof  MultiModelAction) ((MultiModelAction) modelMain.model).actionRelease(this, (Integer) pArg[0]);
				if (modelFATT.modelInner instanceof  MultiModelAction) ((MultiModelAction) modelFATT.modelInner).actionRelease(this, (Integer) pArg[0]);;
				if (modelFATT.modelOuter instanceof  MultiModelAction) ((MultiModelAction) modelFATT.modelOuter).actionRelease(this, (Integer) pArg[0]);
				return true;
			}
			return false;
*/
		case caps_runActionNumber:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setRunActionNumber((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_actionReleaseNumber:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setActionReleaseNumber((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_actionCount:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setActionCount((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_actionTime:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setActionTime((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_actionFlag:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setActionFlag((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_actionSpeed:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setActionSpeed((Float) pArg[0]);
				return true;
			}
			return false;
		case caps_actionReverse:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setActionReverse((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_motionResetFlag:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setMotionResetFlag((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_shortcutKeysActionInitFlag:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setShortcutKeysActionInitFlag((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_motionSetFlag:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setMotionSetFlag((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_showPartsHideList:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				addShowPartsHideList((String[]) pArg[0]);
				return true;
			}
			return false;
		case caps_showPartsRenemeMap:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				addShowPartsRenemeMap((String[]) pArg[0], (String[]) pArg[1]);
				return true;
			}
			return false;
		case caps_actionInit:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				actionInit((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_actionRelease:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				actionRelease((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_setRotationAnglesBefore:
			if (pArg != null
			&& pArg.length > 6
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null
			&& pArg[6] != null) {
				setRotationAnglesBefore(pArg[0], (Float) pArg[1] ,(Float) pArg[2], (Float) pArg[3], (Float) pArg[4], (Float) pArg[5], (Float) pArg[6]);
				return true;
			}
			return false;
		case caps_setRotationAnglesAfter:
			if (pArg != null
			&& pArg.length > 6
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null
			&& pArg[6] != null) {
				setRotationAnglesAfter(pArg[0], (Float) pArg[1] ,(Float) pArg[2], (Float) pArg[3], (Float) pArg[4], (Float) pArg[5], (Float) pArg[6]);
				return true;
			}
			return false;
		case caps_allMultiModelActionMode:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setAllMultiModelActionMode((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_allMultiModelRunActionNumber:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setAllMultiModelRunActionNumber((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_allMultiModelActionFlag:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setAllMultiModelActionFlag((Boolean) pArg[0]);
				return true;
			}
			return false;
		}
		if (subEntityCaps != null) {
			return (Boolean) (Modchu_Reflect.invokeMethod(mod_Modchu_ModchuLib.modchu_Main.MMM_IModelCaps, "setCapsValue", new Class[]{ int.class, Object[].class }, subEntityCaps, new Object[]{ pIndex, pArg }));
		}
		return super.setCapsValue(pIndex, (Object[]) pArg);
	}

	@Override
	public boolean setCapsValue(Modchu_IModelCaps entityCaps, int pIndex, Object... pArg) {
		return setCapsValue(pIndex, (Object[])pArg);
	}

	/**
	 * setRotationAnglesLM 呼び出し前に呼ばれる。
	 */
	protected void setRotationAnglesBefore(Object model, float f, float f1, float f2, float f3, float f4, float f5) {
	}

	/**
	 * setRotationAnglesLM 呼び出し後に呼ばれる。
	 */
	protected void setRotationAnglesAfter(Object model, float f, float f1, float f2, float f3, float f4, float f5) {
		if (model != null
				&& model instanceof MultiModelAction) ;else {
					Modchu_Debug.mDebug("setRotationAnglesAfter else");
					return;
				}
		if (getAllMultiModelActionFlag()
				&& getAllMultiModelActionModeCheck()) {
			if (getAllMultiModelRunActionNumber() > 0) {
				if (getRunActionNumber() != getAllMultiModelRunActionNumber()) {
					setCapsValue(caps_actionRelease, actionReleaseNumber);
					setRunActionNumber(getAllMultiModelRunActionNumber());
					setCapsValue(caps_actionReleaseNumber, runActionNumber);
					setCapsValue(caps_shortcutKeysActionInitFlag, true);
				}
				if (allMultiModelActionRunInitFlag) {
					setCapsValue(caps_shortcutKeysAction, true);
					allMultiModelActionRunFlag = true;
					allMultiModelActionRunInitFlag = false;
				}
			} else {
				setAllMultiModelActionFlag(false);
				allMultiModelActionRunInitFlag = true;
				setCapsValue(caps_shortcutKeysAction, false);
				allMultiModelActionRunFlag = false;
			}
		} else {
			if (!allMultiModelActionRunInitFlag) allMultiModelActionRunInitFlag = true;
			if (allMultiModelActionRunFlag) {
				setCapsValue(caps_shortcutKeysAction, false);
				allMultiModelActionRunFlag = false;
			}
		}
		//Modchu_Debug.mDebug("setRotationAnglesAfter getShortcutKeysAction()="+getShortcutKeysAction());
		if (getShortcutKeysAction()) {
			Modchu_Debug.mDebug("setRotationAnglesAfter runActionNumber="+runActionNumber);
			float actionSpeed = Modchu_ModelDataMaster.instance.getActionSpeed(this);
			setCapsValue(caps_actionSpeed, actionSpeed);
			Modchu_Debug.mDebug("setRotationAnglesAfter actionSpeed="+actionSpeed);
			setCapsValue(caps_actionFlag, true);
			if (getShortcutKeysActionInitFlag()) {
				setCapsValue(caps_shortcutKeysActionInitFlag, false);
				setCapsValue(caps_actionInit, runActionNumber);
				setCapsValue(caps_actionReleaseNumber, runActionNumber);
			}
		} else {
			if (!getShortcutKeysActionInitFlag()) {
				if (actionReleaseNumber > 0) {
					setCapsValue(caps_actionRelease, actionReleaseNumber);
					setCapsValue(caps_actionReleaseNumber, 0);
				}
				setCapsValue(caps_shortcutKeysActionInitFlag, true);
				setCapsValue(caps_runActionNumber, 0);
			}
		}
		if (getShortcutKeysAction()
				&& !getShortcutKeysActionInitFlag()) {
			Object[] model2 = getTextureDataModel();
			if (model2 != null) {
				for (int i = 0; i < model2.length; i++) {
					if (MultiModelAction.class.isInstance(model2[i])) {
						((MultiModelAction) model2[i]).action(f, f1, f2, f3, f4, f5, getRunActionNumber(), this);
					} else {
						Modchu_Debug.mDebug("setRotationAnglesAfter model2 !MultiModelAction.class.isInstance !!");
					}
				}
			}
			if (getActionFlag()) {
				setActionSpeed(0.0F);
				setActionFlag(false);
			}
		}
	}

	private void actionInit(int i) {
		Object[] model2 = getTextureDataModel();
		if (model2 != null) {
			for (int i1 = 0; i1 < model2.length; i1++) {
				if (MultiModelAction.class.isInstance(model2[i1])) {
					((MultiModelAction) model2[i1]).actionInit(this, i);
				} else {
					Modchu_Debug.mDebug("actionInit model2 !MultiModelAction.class.isInstance !!");
				}
			}
		}
	}

	private void actionRelease(int i) {
		Object[] model2 = getTextureDataModel();
		if (model2 != null) {
			for (int i1 = 0; i1 < model2.length; i1++) {
				if (MultiModelAction.class.isInstance(model2[i1])) {
					((MultiModelAction) model2[i1]).actionRelease(this, i);
				} else {
					Modchu_Debug.mDebug("actionRelease model2 !MultiModelAction.class.isInstance !!");
				}
			}
		}
	}

	protected Object[] getTextureDataModel() {
		Object entity = Modchu_Reflect.invokeMethod(mod_Modchu_ModchuLib.modchu_Main.MMM_IModelCaps, "getCapsValue", new Class[]{ int.class, Object[].class }, subEntityCaps, new Object[]{ caps_Entity, null });
		if (entity != null) {
			Object textureData = Modchu_Reflect.getFieldObject(entity.getClass(), "textureData", entity);
			if (textureData != null) {
				return (Object[]) Modchu_Reflect.getFieldObject(mod_Modchu_ModchuLib.modchu_Main.MMM_TextureData, "textureModel", textureData);
			}
		}
		return null;
	}

	private void setEntity(Entity entity) {
		Modchu_Reflect.setFieldObject(mod_Modchu_ModchuLib.modchu_Main.MMM_EntityCaps, "owner", this, entity);
	}

	private Object getSubEntityCaps() {
		return subEntityCaps;
	}

	protected void setSubEntityCaps(Object entityCaps) {
		subEntityCaps = entityCaps;
	}

	protected boolean getMotionResetFlag() {
		return motionResetFlag;
	}

	protected void setMotionResetFlag(boolean b) {
		motionResetFlag = b;
	}

	protected boolean getIsSitting() {
		return isSitting;
	}

	protected void setIsSitting(boolean b) {
		isSitting = b;
	}

	protected boolean getIsSleeping() {
		return owner instanceof EntityPlayer ? ((EntityPlayer) owner).isPlayerSleeping() | sleeping : sleeping;
	}

	protected void setIsSleeping(boolean b) {
		sleeping = b;
	}

	protected boolean getShortcutKeysAction() {
		return shortcutKeysAction;
	}

	protected void setShortcutKeysAction(boolean b) {
		shortcutKeysAction = b;
	}

	protected int getRunActionNumber() {
		return runActionNumber;
	}

	protected void setRunActionNumber(int i) {
		runActionNumber = i;
	}

	protected int getActionReleaseNumber() {
		return actionReleaseNumber;
	}

	protected void setActionReleaseNumber(int i) {
		actionReleaseNumber = i;
	}

	protected boolean getActionFlag() {
		return actionFlag;
	}

	protected void setActionFlag(boolean b) {
		actionFlag = b;
	}

	protected int getActionCount() {
		return actionCount;
	}

	protected void setActionCount(int i) {
		actionCount = i;
	}

	protected int getActionTime() {
		return actionTime;
	}

	protected void setActionTime(int i) {
		actionTime = i;
	}

	protected float getActionSpeed() {
		return actionSpeed;
	}

	protected void setActionSpeed(float f) {
		actionSpeed = f;
	}

	protected boolean getActionReverse() {
		return actionReverse;
	}

	protected void setActionReverse(boolean b) {
		actionReverse = b;
	}

	protected boolean getMotionSetFlag() {
		return motionSetFlag;
	}

	protected void setMotionSetFlag(boolean b) {
		motionSetFlag = b;
	}

	protected int getSkinMode() {
		return skinMode;
	}

	protected void setSkinMode(int i) {
		skinMode = i;
	}

	private int getInitFlag() {
		return initFlag;
	}

	private void setInitFlag(int i) {
		initFlag = i;
	}

	private boolean getAllMultiModelActionModeCheck() {
		switch(getAllMultiModelActionMode()) {
		case 0:
			return false;
		case 1:
			return true;
		case 2:
			return getCapsValueBoolean(caps_isPlayer) ? false : true;
		}
		return false;
	}

	public static int getAllMultiModelRunActionNumber() {
		return allMultiModelRunActionNumber;
	}

	public static void setAllMultiModelRunActionNumber(int i) {
		allMultiModelRunActionNumber = i;
	}

	public static int getAllMultiModelActionMode() {
		return allMultiModelActionMode;
	}

	public static int getAllMultiModelActionMax() {
		return allMultiModelActionMax;
	}

	public static void setAllMultiModelActionModePlus() {
		allMultiModelActionMode++;
		if (allMultiModelActionMode > allMultiModelActionModeMax) allMultiModelActionMode = 0;
		return;
	}

	public static void setAllMultiModelActionModeMinus() {
		allMultiModelActionMode--;
		if (allMultiModelActionMode < 0) allMultiModelActionMode = allMultiModelActionModeMax;
		return;
	}

	public static void setAllMultiModelActionPlus() {
		allMultiModelRunActionNumber++;
		if (allMultiModelRunActionNumber > allMultiModelActionMax) allMultiModelRunActionNumber = 0;
		return;
	}

	public static void setAllMultiModelActionMinus() {
		allMultiModelRunActionNumber--;
		if (allMultiModelRunActionNumber < 0) allMultiModelRunActionNumber = allMultiModelActionMax;
		return;
	}

	public static void setAllMultiModelActionMode(int i) {
		allMultiModelActionMode = i;
		if (allMultiModelActionMode > allMultiModelActionModeMax
				| allMultiModelActionMode < 0) allMultiModelActionMode = 0;
		return;
	}

	public static int getAllMultiModelActionModeMax() {
		return allMultiModelActionModeMax;
	}

	public static boolean getAllMultiModelActionFlag() {
		return allMultiModelActionFlag;
	}

	public static void setAllMultiModelActionFlag(boolean b) {
		allMultiModelActionFlag = b;
	}

	public static String getAllMultiModelActionModeName(int i) {
		String s = null;
		switch (i) {
		case 0:
			s = "false";
			break;
		case 1:
			s = "All";
			break;
		case 2:
			s = "PlayersOther";
			break;
		}
		return s;
	}

	protected boolean getShortcutKeysActionInitFlag() {
		return shortcutKeysActionInitFlag;
	}

	protected void setShortcutKeysActionInitFlag(boolean b) {
		shortcutKeysActionInitFlag = b;
	}

	protected List<String> getShowPartsHideList() {
		return showPartsHideList;
	}

	/**
	 * GUI パーツ表示・非表示用 ボタン非表示リスト追加
	 */
	protected void addShowPartsHideList(String[] s) {
		//Modchu_Debug.mDebug("addShowPartsHideList s.length="+s.length);
		for(int i = 0; i < s.length; i++) {
			showPartsHideList.add(s[i]);
		}
	}

	protected ConcurrentHashMap<String, String> getShowPartsRenemeMap() {
		return showPartsRenemeMap;
	}

	/**
	 * GUI パーツ表示・非表示用 ボタン表示名リネーム用追加
	 */
	protected void addShowPartsRenemeMap(String[] s1, String[] s2) {
		for(int i = 0; i < s1.length && i < s2.length; i++) {
			showPartsRenemeMap.put(s1[i], s2[i]);
		}
	}

	public int getCapsValueInt(int pIndex, Object ...pArg) {
		Object o = getCapsValue((MultiModelBaseBiped)null, pIndex, pArg);
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return b ? 2 : 1;
		}
		return o != null ? (Integer) o : 0;
	}

	public float getCapsValueFloat(int pIndex, Object ...pArg) {
		Object o = getCapsValue((MultiModelBaseBiped)null, pIndex, pArg);
		return o != null ? (Float) o : 0.0F;
	}

	public double getCapsValueDouble(int pIndex, Object ...pArg) {
		Object o = getCapsValue((MultiModelBaseBiped)null, pIndex, pArg);
		return o != null ? (Double) o : 0.0D;
	}

	public boolean getCapsValueBoolean(int pIndex, Object ...pArg) {
		Object o = getCapsValue((MultiModelBaseBiped)null, pIndex, pArg);
		return o != null ? (Boolean) o : false;
	}
}