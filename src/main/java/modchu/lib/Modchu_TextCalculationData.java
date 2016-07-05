package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Modchu_TextCalculationData implements Modchu_ITextCalculationDataFormat {
	private Object data;
	private Object subData;

	public Modchu_TextCalculationData(Object o) {
		data = o;
	}

	@Override
	public Object calculationObject(Object o, Object o1, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Object o2 = null;
		Modchu_TextCalculationFormula formula = null;
		if (data instanceof List) {
			String ss ="Modchu_TextCalculation getDataToSuitableObject data instanceof List error !! data="+data;
			Modchu_Main.setRuntimeException(ss);
			return o;
		}
		else if (data instanceof Modchu_RunCalculationList) {
			Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) data;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof List data="+data);
			o2 = Modchu_TextCalculation.instance.runCalculation(runCalculationList, by, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof List return o2="+o2);
		}
		else if (data instanceof Modchu_TextCalculationFormula) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof Modchu_TextCalculationFormula data="+data);
			formula = (Modchu_TextCalculationFormula) data;
			boolean flag = formula.isOneValue();
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof Modchu_TextCalculationFormula formula.isTrigonometricFunction()="+flag);
			if (flag) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof Modchu_TextCalculationFormula getSubData()="+getSubData());
				o2 = formula.calculationObject(null, getSubData(), by, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof Modchu_TextCalculationFormula o2="+o2);
			} else {
				return o;
			}
		}
		else if (data instanceof String) {
			String s = (String) data;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof String s="+s);
			o2 = Modchu_RunCalculationList.getMapsObject(s, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof String getMapsObject o2="+o2);
			if (o2 != null); else {
				o2 = Modchu_RunCalculationList.getFieldOrMedhod(s, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof String getFieldOrMedhod o2="+o2);
				if (o2 != null); else {
					o2 = Modchu_Main.stringToSuitableObject(s);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof String stringToSuitableObject o2="+o2);
					if (o2 instanceof String) {
						o2 = null;
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof String stringToSuitableObject o2 instanceof String null.");
					}
				}
			}
			if (o2 != null); else {
				o2 = Modchu_RunCalculationList.getTypeDefaultValue(by);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject data instanceof String o2 == null. default "+o2);
			}
		} else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject else data="+data);
			o2 = data;
		}
		if (o2 != null
				&& o != null) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject o2 != null "+o+" + "+o2);
			formula = Modchu_TextCalculationFormula.calculationFormulaMap.get("+");
			o = formula.calculationObject(o, o2, by, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject ="+o);
		} else {
			if (o2 != null) o = o2;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getDataToSuitableObject null o = o2. o="+o);
		}
		return o;
	}

	public String dataToString(boolean b) {
		return dataToString(getSubData(), b);
	}

	@Override
	public String dataToString(Object subData, boolean b) {
		//Modchu_Debug.mDebug("Modchu_TextCalculationData dataToString data="+data);
		//Modchu_Debug.mDebug("Modchu_TextCalculationData dataToString data.getClass()="+data.getClass());
		StringBuilder sb = new StringBuilder();
		Object data = getData();
		if (data instanceof Modchu_ITextCalculationDataFormat) {
			sb.append(((Modchu_ITextCalculationDataFormat) data).dataToString(subData, b));
		} else {
			sb.append(otherDataToString(data));
			if (subData != null) sb.append(otherDataToString(subData));
			//Modchu_Debug.mDebug("Modchu_TextCalculationData dataToString end.");
		}
		return sb.toString();
	}

	public String otherDataToString(Object data) {
		return data.toString();
	}

	public Object getData() {
		return data;
	}

	public void setData(Object o) {
		data = o;
	}

	public Object getSubData() {
		return subData;
	}

	public void setSubData(Object o) {
		subData = o;
	}

	public boolean isTrigonometricFunction() {
		if (data instanceof Modchu_TextCalculationFormula) {
			Modchu_TextCalculationFormula formula = (Modchu_TextCalculationFormula) data;
			return formula.isTrigonometricFunction();
		}
		return false;
	}

	@Override
	public boolean isOneValue() {
		if (data instanceof Modchu_ITextCalculationDataFormat) {
			return ((Modchu_ITextCalculationDataFormat) data).isOneValue();
		}
		return true;
	}

}
