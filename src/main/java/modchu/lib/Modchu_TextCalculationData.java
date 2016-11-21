package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Modchu_TextCalculationData implements Modchu_ITextCalculationDataFormat {
	private Object data;
	private Object subData;
	private boolean isReflect = false;

	public Modchu_TextCalculationData(Object o) {
		data = o;
	}

	@Override
	public void init() {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (data instanceof String) {
			String s = (String) data;
			Modchu_Debug.mDebug("Modchu_TextCalculationData init s="+s);
			if (s.indexOf("field") > -1
					| s.indexOf("method") > -1) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init field | method s="+s);
				if (s.indexOf(",") > -1) {
					String[] s0 = s.split(",");
					for (int i = 0; i < s0.length; i++) {
						if (s0[i].indexOf("\"") > -1) {
							s0[i] = s0[i].replaceAll("\"", "");
						}
					}
					List list = Modchu_Main.stringArrayToArrayList(s0);
					setSubData(list);
					setData(s0[0]);
					if (debug) {
						Modchu_Debug.mDebug("Modchu_TextCalculationData init list="+list);
					}
				}
				isReflect = true;
			}
		}
	}

	@Override
	public Object calculationObject(Object o, Object o1, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Object o2 = null;
		Modchu_TextCalculationFormula formula = null;
		if (data instanceof List) {
			String ss ="Modchu_TextCalculationData calculationObject data instanceof List error !! data="+data;
			Modchu_Main.setRuntimeException(ss);
			return o;
		}
		else if (data instanceof Modchu_RunCalculationList) {
			Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) data;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof List data="+data);
			o2 = Modchu_TextCalculation.instance.runCalculation(runCalculationList, by, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof List return o2="+o2);
		}
		else if (data instanceof Modchu_TextCalculationFormula) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula data="+data);
			formula = (Modchu_TextCalculationFormula) data;
			boolean flag = formula.isOneValue();
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula flag="+flag);
			if (flag) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula getSubData()="+getSubData());
				o2 = formula.calculationObject(null, getSubData(), by, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula o2="+o2);
			} else {
				return o;
			}
		}
		else if (data instanceof String) {
			String s = (String) data;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String s="+s+" this="+this);
			if (isReflect) {
				List list = (List) getSubData();
				String s1 = (String) list.get(1);
				String s2 = (String) list.get(2);
				// TODO
				Object o3 = list.size() > 3 ? list.get(3) : null;
				Object o4 = list.size() > 4 ? list.get(4) : null;
				Object o5 = list.size() > 5 ? list.get(5) : null;
				Class[] o6 = null;
				Object o7 = null;
				Object[] o8 = null;
				if (o3 instanceof String) o3 = new Modchu_TextCalculationData(o3);
				if (o3 instanceof Modchu_TextCalculationData) {
					Modchu_TextCalculationData data = (Modchu_TextCalculationData) o3;
					//o6 = (Class[]) data.calculationObject(null, data.getSubData(), by, map);
				} else {
					o6 = (Class[]) o3;
				}
				if (o4 instanceof String) o4 = new Modchu_TextCalculationData(o4);
				if (o4 instanceof Modchu_TextCalculationData) {
					Modchu_TextCalculationData data = (Modchu_TextCalculationData) o4;
					o7 = data.calculationObject(null, data.getSubData(), by, map);
				} else {
					o7 = o4;
				}
				if (o5 instanceof String) o5 = new Modchu_TextCalculationData(o5);
				if (o5 instanceof Modchu_TextCalculationData) {
					Modchu_TextCalculationData data = (Modchu_TextCalculationData) o5;
					//o7 = (Object[]) data.calculationObject(null, data.getSubData(), by, map);
				} else {
					o7 = (Object[]) o5;
				}
				//o2 = Modchu_AS.get(s1, s2, o6, o7, o8);
			} else {
				o2 = Modchu_RunCalculationList.getMapsObject(s, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String getMapsObject o2="+o2);
				if (o2 != null); else {
					o2 = Modchu_RunCalculationList.getFieldOrMedhod(s, map);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String getFieldOrMedhod o2="+o2);
					if (o2 != null); else {
						o2 = Modchu_Main.stringToSuitableObject(s);
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject o2="+o2);
						if (o2 instanceof String) {
							o2 = null;
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject o2 instanceof String null.");
						} else {
							data = o2;
						}
					}
				}
				if (o2 != null); else {
					o2 = Modchu_RunCalculationList.getTypeDefaultValue(by);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o2 == null. default "+o2);
				}
			}
		} else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject else data="+data);
			o2 = data;
		}
		if (o2 != null
				&& o != null) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject o2 != null "+o+" + "+o2);
			formula = Modchu_TextCalculationFormula.calculationFormulaMap.get("+");
			o = formula.calculationObject(o, o2, by, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject ="+o);
		} else {
			if (o2 != null) o = o2;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject null o = o2. o="+o);
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
