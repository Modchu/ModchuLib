package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Modchu_TextCalculationFormula implements Modchu_ITextCalculationDataFormat {
	public static HashMap<String, Modchu_TextCalculationFormula> calculationFormulaMap = new HashMap();
	public static List<String> allCalculationStringList;
	public static List<String> variableStringList;
	public static List<String> calculationStringList;
	public static List<String> calculationTrigonometricFunctionStringList;
	public static List<String> calculationOperatorStringList;
	public static List<String> calculationReflectStringList;
	public static List<String> priorityCalculationStringList;
	public static List<String> priorityCalculationSeparatorList;
	public static List<String> priorityCalculationSeparatorAfterList;
	public static List<String> calculationReflectPeriodList;
	protected final String dataString;
	protected int dataInt;
	private boolean initFlag = false;

	static {
		variableStringList = new ArrayList();
		variableStringList.addAll(Modchu_Main.stringArrayToArrayList(new String[]{
				"*=",
				"/=",
				"+=",
				"-=",
				"%=",
				"="
		}));
		calculationStringList = new ArrayList();
		calculationStringList.addAll(Modchu_Main.stringArrayToArrayList(new String[]{
				"*",
				"/",
				"+",
				"-",
				"%"
		}));
		calculationTrigonometricFunctionStringList = new ArrayList();
		calculationTrigonometricFunctionStringList.addAll(Modchu_Main.stringArrayToArrayList(new String[]{
				"cos",
				"sin"
		}));
		calculationReflectStringList = new ArrayList();
		calculationReflectStringList.addAll(Modchu_Main.stringArrayToArrayList(new String[]{
				"invokeMethod",
				"getFieldObject",
				"setFieldObject"
		}));
		calculationOperatorStringList = new ArrayList();
		calculationOperatorStringList.addAll(Modchu_Main.stringArrayToArrayList(Modchu_Main.getConditionalExpressionCharacterStringArray()));
		allCalculationStringList = new ArrayList();
		allCalculationStringList.addAll(variableStringList);
		allCalculationStringList.addAll(calculationStringList);
		allCalculationStringList.addAll(calculationTrigonometricFunctionStringList);
		allCalculationStringList.addAll(calculationReflectStringList);
		allCalculationStringList.addAll(calculationOperatorStringList);
		priorityCalculationStringList = new ArrayList();
		priorityCalculationStringList.addAll(Modchu_Main.stringArrayToArrayList(new String[]{
				"*",
				"/"
		}));
		priorityCalculationSeparatorList = new ArrayList();
		priorityCalculationSeparatorList.addAll(calculationStringList);
		priorityCalculationSeparatorList.remove("*");
		priorityCalculationSeparatorList.remove("/");
		priorityCalculationSeparatorAfterList = new ArrayList();
		priorityCalculationSeparatorAfterList.addAll(priorityCalculationSeparatorList);
		priorityCalculationSeparatorAfterList.remove("*");
		priorityCalculationSeparatorAfterList.remove("/");
		calculationReflectPeriodList = new ArrayList();
		calculationReflectPeriodList.addAll(Modchu_Main.stringArrayToArrayList(new String[]{
				"(",
				")"
		}));
		calculationReflectPeriodList.addAll(variableStringList);

	}

	public Modchu_TextCalculationFormula(String s) {
		dataString = s;
		if (calculationFormulaMap.containsKey(s)) {
			String ss = "Modchu_TextCalculationFormula new init calculationFormulaMap.containsKey error !! getDataString()="+getDataString();
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		dataInt = isVariable() ? variableStringList.indexOf(s) :
			isCalculation() ? calculationStringList.indexOf(s) :
				isTrigonometricFunction() ? calculationTrigonometricFunctionStringList.indexOf(s) :
					isReflect() ? calculationReflectStringList.indexOf(s) :
				isOperator() ? calculationOperatorStringList.indexOf(s) :
				0;
	}

	protected void init(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (initFlag) return;
		initFlag = true;
	}

	public String getDataString() {
		return dataString;
	}

	public int getDataInt() {
		return dataInt;
	}

	@Override
	public boolean isVariable() {
		return variableStringList.contains(dataString);
	}

	public boolean isCalculation() {
		return calculationStringList.contains(dataString);
	}

	public boolean isTrigonometricFunction() {
		return calculationTrigonometricFunctionStringList.contains(dataString);
	}

	public boolean isOperator() {
		return calculationOperatorStringList.contains(dataString);
	}

	public static boolean isTrigonometricFunction(String s) {
		return calculationTrigonometricFunctionStringList.contains(s);
	}

	@Override
	public Object calculationObject(Map... map) {
		return calculationObject(null, null, map);
	}

	protected Object calculationObject(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject start. getDataString()="+getDataString()+" o="+o+" o1="+o1);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isVariable()="+isVariable());
		}
/*
		if (getDataString().equalsIgnoreCase("+")) {
			String ss ="Modchu_TextCalculationFormula calculationObject + debug !! o="+o+" o1="+o1+" by="+by;
			if (debug) Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
		}
*/
		init(o, o1, map);
		boolean flag = o != null;
		//boolean flag1 = getDataString().equals("-");
		Object o3 = null;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 2 o="+o+" o1="+o1);
		if (isVariable()) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isVariable()");
			if (getDataInt() != 5) {
				Object o4 = Modchu_TextCalculation.instance.getTextCalculationDataTempRawData(o);
				o3 = Modchu_TextCalculation.instance.getTextCalculationDataTempRawData(o1);
				byte by = Modchu_RunCalculationList.getType(o3);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 3 setVariable o4="+o4+" o3="+o3+" by="+by);
				o1 = calculationObject_r(o4, o3, by, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 4 setVariable o1="+o1);
			}
			o3 = setVariable(o, o1, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 5 setVariable o3="+o3);
		} else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject !isVariable()");
			if (o != null) o = Modchu_TextCalculation.instance.getTextCalculationDataTempRawData(o);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject !isVariable() o="+o);
			if (isReflect()) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject !isVariable() isReflect()");
				o3 = calculationReflect(o, o1, map);
				return o3;
			}
			if (o1 != null) o3 = Modchu_TextCalculation.instance.getTextCalculationDataTempRawData(o1);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 6 o="+o+" o3="+o3+" isTrigonometricFunction()="+isTrigonometricFunction());
			if (isTrigonometricFunction()) {
				o3 = Modchu_TextCalculation.instance.runCalculationAther(o3, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 7 isTrigonometricFunction() o3="+o3);
				o3 = calculationTrigonometricFunction(Modchu_CastHelper.Float(o3, 0.0F, false));
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 8 isTrigonometricFunction() o3="+o3);
			}
			Object o2 = o != null ? o : o1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 9 o2="+o2);
			byte by = isOperator() ? Modchu_RunCalculationList.type_Boolean : Modchu_RunCalculationList.getType(o2);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 10 by="+by);
			if (by == (byte)-1) {
				String ss ="Modchu_TextCalculationFormula calculationObject type error !! o="+o+" o1="+o1;
				if (debug) Modchu_Debug.mDebug(ss);
				Modchu_Main.setRuntimeException(ss);
				return o;
			}
			if (o != null); else {
				if (getDataInt() == 3) {
					o = Modchu_RunCalculationList.getTypeDefaultValue(by);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 11 o == null getTypeDefaultValue o="+o);
				} else {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 12 o == null return o3="+o3);
					return o3;
				}
			}
			if (o1 != null); else {
				o3 = Modchu_RunCalculationList.getTypeDefaultValue(by);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 13 o1 == null getTypeDefaultValue o3="+o3);
			}
			o3 = calculationObject_r(o, o3, by, map);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject 14 return. o3="+o3);
		return o3;
	}

	protected Object calculationObject_r(Object o, Object o1, byte by, Map... map) {
		switch(by) {
		case Modchu_RunCalculationList.type_Integer:
		case Modchu_RunCalculationList.type_Byte:
			o1 = calculationInt(Modchu_CastHelper.Int(o, 0, false), o1 != null ? Modchu_CastHelper.Int(o1, 0, false) : 0);
			o1 = by == Modchu_RunCalculationList.type_Byte ? (Byte)o1 : o1;
			break;
		case Modchu_RunCalculationList.type_Float:
			o1 = calculationFloat(Modchu_CastHelper.Float(o, 0.0F, false), Modchu_CastHelper.Float(o1, 0.0F, false));
			break;
		case Modchu_RunCalculationList.type_Double:
			o1 = calculationDouble(Modchu_CastHelper.Double(o, 0.0D, false), Modchu_CastHelper.Double(o1, 0.0D, false));
			break;
		case Modchu_RunCalculationList.type_Long:
			o1 = calculationLong(Modchu_CastHelper.Long(o, 0L), Modchu_CastHelper.Long(o1, 0L));
			break;
		case Modchu_RunCalculationList.type_Boolean:
		case Modchu_RunCalculationList.type_If:
			o1 = calculationBoolean(o, o1, map);
			break;
		}
		return o1;
	}

	protected Object calculationReflect(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (o1 != null); else {
			String ss ="Modchu_TextCalculationFormula calculationReflect o1 == null error !!";
			Modchu_Main.setRuntimeException(ss);
			return o;
		}
		Modchu_TextCalculationData data = null;
		if (o1 instanceof Modchu_TextCalculationData) {
			data = (Modchu_TextCalculationData) o1;
		} else {
			if (o instanceof Modchu_TextCalculationData) {
				data = (Modchu_TextCalculationData) o;
			} else {
				String ss ="Modchu_TextCalculationFormula calculationReflect !(o1 instanceof Modchu_TextCalculationData) && !(o instanceof Modchu_TextCalculationData) error !! o="+o+" o1="+o1;
				Modchu_Main.setRuntimeException(ss);
				return o;
			}
		}
		Modchu_ReflectData reflectData = data.getReflectData();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationReflect reflectData="+(reflectData != null ? reflectData.dataToString() : null));
		if (reflectData != null); else {
			String ss ="Modchu_TextCalculationFormula calculationReflect reflectData == null error !!";
			Modchu_Main.setRuntimeException(ss);
			return o;
		}
		Object o3 = runReflect(reflectData, getDataInt(), map);
		data.setTempRawData(o3);
		data.setTempRaw(true);
		return data;
	}

	public Object runReflect(Modchu_ReflectData reflectData, int i, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Object o = reflectData.getReflectObject();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect 1 o="+o);
		if (o instanceof Modchu_TextCalculationData) {
			Modchu_TextCalculationData data6 = (Modchu_TextCalculationData) o;
			Object temp = data6.calculationObject(map);
			if (data6.isTempRaw()) {
				o = data6.getTempRawData();
			}
		}
		Object classNameOrClass = reflectData.getClassNameOrClass();
		String methodOrFieldName = reflectData.getMethodOrFieldName();
		Class[] c0 = reflectData.getReflectClassArray();
		Modchu_TextCalculationData data1 = reflectData.getReflectObjectArrayData();
		Object[] o0 = data1 != null ? (Object[]) data1.calculationObject(map) : reflectData.getReflectObjectArray();
		if (c0 != null) {
			if (o0 != null) {
				if (c0.length != o0.length) {
					String ss ="Modchu_TextCalculationFormula runReflect c0.length != o0.length error !! reflectData.dataToString()="+reflectData.dataToString();
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return null;
				}
			} else {
				String ss ="Modchu_TextCalculationFormula runReflect c0 != null && o0 == null error !! reflectData.dataToString()="+reflectData.dataToString();
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
				return null;
			}
		}
		Object o1 = null;
		Class c = classNameOrClass instanceof String ? Modchu_Reflect.loadClass((String) classNameOrClass, -1) : (Class) classNameOrClass;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect 2 classNameOrClass="+classNameOrClass);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect 3 c="+c);
		}
		if (c != null); else {
			o = Modchu_Main.getMapsObject(map, classNameOrClass);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect 4 getMapsObject o="+o);
				if (map != null) {
					if (map[0] != null) Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect map[0]="+map[0]);
					if (map.length > 1) {
						if (map[1] != null) Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect map[1]="+map[1]);
						if (map.length > 2) {
							if (map[2] != null) Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect map[2]="+map[2]);
						}
					}
				}
			}
			if (o != null); else {
				o = Modchu_Main.getMapsObject(map, "ObjectDefault");
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect 5 get ObjectDefault o="+o);
			}
			if (o != null) c = o.getClass();
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect 6 c="+c);
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect reflectData.dataToString()="+reflectData.dataToString());
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect classNameOrClass="+classNameOrClass);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect methodOrFieldName="+methodOrFieldName);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect c="+c);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect c0="+Modchu_Main.objectArrayToString(c0));
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect o="+o);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect o0="+Modchu_Main.objectArrayToString(o0));
		}
		if (c != null) {
			o1 = runReflect_r(i, c, methodOrFieldName, c0, o, o0, map);
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect Modchu_AS.get o1="+o1);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect Modchu_AS.get o0[0].getClass()="+(o0 != null && o0.length > 0 && o0[0] != null ? o0[0].getClass() : null));
			//Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect Modchu_AS.get getCapsValueInt="+Modchu_EntityCapsHelper.getCapsValueInt(map[0].get("ObjectDefault"), map[0].get("entityCaps"), 524305, (Object[]) null));
			//Modchu_Debug.mDebug("Modchu_TextCalculationFormula runReflect Modchu_AS.get invokeMethod ="+Modchu_Reflect.invokeMethod(className, methodOrFieldName, c0, o4, o0));
		}
		return o1;
	}

	protected Object runReflect_r(int i, Class c, String methodOrFieldName, Class[] c0, Object o, Object[] o0, Map... map) {
		Object o1 = null;
		switch(i) {
		case 0:
			o1 = Modchu_Reflect.invokeMethod(c, methodOrFieldName, c0, o, o0);
			break;
		case 1:
			o1 = Modchu_Reflect.getFieldObject(c, methodOrFieldName, o);
			break;
		case 2:
			o1 = Modchu_Reflect.setFieldObject(c, methodOrFieldName, o, o0[0], 1);
			break;
		}
		return o1;
	}

	protected Object setVariable(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Modchu_TextCalculationData data1 = null;
		Modchu_TextCalculationData data2 = null;
		String variableString = null;
		if (o instanceof Modchu_TextCalculationData) {
			data1 = (Modchu_TextCalculationData) o;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable o instanceof Modchu_TextCalculationData data1="+data1);
			variableString = data1.getVariableString();
		}
		else if (o instanceof String) {
			variableString = (String) o;
		} else {
			String ss ="Modchu_TextCalculationFormula setVariable o error !! o="+o+" getDataString()="+getDataString()+" o1="+o1;
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return null;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable o="+o+" getDataString()="+getDataString()+" o1="+o1);
		Object o2 = null;
		Object o3 = null;
		if (o1 instanceof Modchu_TextCalculationData) {
			data2 = (Modchu_TextCalculationData) o1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable o1 instanceof Modchu_TextCalculationData data2="+data2);
			o3 = data2.calculationObject(map);
		} else if (o1 instanceof Modchu_RunCalculationList) {
			Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable o1 instanceof Modchu_RunCalculationList runCalculationList="+runCalculationList);
			o3 = runCalculationList.calculationObject(map);
		} else if (o1 instanceof List) {
			List<Modchu_ITextCalculationDataFormat> list1 = o1 != null
					&& o1 instanceof List ? (List<Modchu_ITextCalculationDataFormat>) o1 : null;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable o1 instanceof List list1="+list1);
			Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(list1);
			o3 = runCalculationList.calculationObject(map);
		} else if (o1 instanceof String) {
			o1 = Modchu_Main.stringToSuitableObject((String) o1);
			o3 = o1;
		} else {
			o3 = o1;
/*
			String ss ="Modchu_TextCalculationFormula setVariable o1 error !! o1="+o1+" getDataString()="+getDataString();
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
*/
		}
		//Modchu_Debug.mdDebug("setVariable o3="+o3, 2);
		if (variableString != null); else {
			Modchu_ReflectData reflectData = data1.getReflectData();
			if (reflectData != null) {
				Object o4 = runReflect(reflectData, 1, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable runReflect 1 o4="+o4);
				reflectData.setReflectObjectArray(new Object[]{ o3 });
				Object o5 = runReflect(reflectData, 2, map);
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable runReflect 2 o3="+o3);
					Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable runReflect 3 o5="+(o5 instanceof Boolean
							&& (Boolean) o5 ? "実行ok" : "失敗"));
					Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable runReflect end.");
				}
				return o3;
			} else {
				Object o5 = data1.getData();
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null o5="+o5);
				if (o5 instanceof String) {
					String s1 = (String) o5;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null s1="+s1);
					int i1 = s1.indexOf(".");
					if (i1 > -1) {
						String[] s0 = s1.split("\\.");
						Object o6 = null;
						for (Map map2 : map) {
							if (map2.containsKey(s0[0])) {
								o6 = map2.get(s0[0]);
								break;
							}
						}
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null o6="+o6);

						boolean b = false;
						if (o6 != null) {
							if (s0.length > 2) {
								for (int i2 = 1; i2 < s0.length; i2++) {
									Object o7 = Modchu_Reflect.getFieldObject(o6.getClass(), s0[i2], o6, -1);
									if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null getFieldObject o7="+o7);
									if (o7 != null) {
										o6 = o7;
									} else {
										String ss ="Modchu_TextCalculationFormula setVariable variableString == null Object o7 == null error !! o6.getClass()="+o6.getClass()+" s0["+i2+"]="+s0[i2]+" o6="+o6;
										Modchu_Debug.lDebug(ss);
										Modchu_Main.setRuntimeException(ss);
										return null;
									}
								}
							}
							b = Modchu_Reflect.setFieldObject(o6.getClass(), s0[1], o6, o3, -1);
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null setFieldObject b="+b);
						}
						return b;
					} else {
						variableString = s1;
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null. set variableString s1="+s1);
					}
				}
			}
		}
		if (variableString != null); else {
			String ss ="Modchu_TextCalculationFormula setVariable variableString == null error !! data1="+data1+" data1.isVariable()="+data1.isVariable()+" data1.getData()="+data1.getData()+" this.equals(data1.getData())="+this.equals(data1.getData());
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return null;
		}
		Map map1 = null;
		if (map != null)
		for (Map map2 : map) {
			if (map2 != null
					&& map2.containsKey(variableString)) {
				o2 = map2.get(variableString);
				map1 = map2;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable map2.get variableString="+variableString);
				break;
			}
		}
		if (map1 == null
				&& map != null
				&& map.length > 0
				&& map[0] != null) {
			map1 = map[0];
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable map1 = map[0] variableString="+variableString);
		}
		if (map1 != null) map1.put(variableString, o3);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable map1.put o3="+o3+" variableString="+variableString);
		return o3;
	}

	protected float calculationTrigonometricFunction(float f1) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (!isTrigonometricFunction()) return f1;
		float f2 = f1;
		switch(dataInt) {
		case 0:
			f1 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f1);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	cos("+f2+") = "+f1);
			}
			break;
		case 1:
			f1 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f1);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	sin("+f2+") = "+f1);
			}
			break;
		}
		return f1;
	}

	protected int calculationInt(int i, int i1) {
		boolean debug = false;
		boolean isCalculation = isCalculation();
		boolean isTrigonometricFunction = isTrigonometricFunction();
		int i3;
		if (isCalculation()
				| isVariable()) {
			switch(dataInt) {
			case 0:
				return i * i1;
			case 1:
				return i / i1;
			case 2:
				return i + i1;
			case 3:
				return i - i1;
			case 4:
				return i % i1;
			}
		} else {
			switch(dataInt) {
			case 0:
			case 1:
				return i + i1;
			}
		}
		i3 = i + i1;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationInt	i3="+i3+" i="+i+" i1="+i1+" dataInt="+dataInt);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationInt	end.");
		}
		return i3;
	}

	protected float calculationFloat(float f, float f1) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		float f2 = 0.0F;
		if (isCalculation()
				| isVariable()) {
			switch(dataInt) {
			case 0:
				f2 = f * f1;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	"+f+" * "+f1+" = "+f2);
				break;
			case 1:
				f2 = f / f1;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	"+f+" / "+f1+" = "+f2);
				break;
			case 2:
				f2 = f + f1;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	"+f+" + "+f1+" = "+f2);
				break;
			case 3:
				f2 = f - f1;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	"+f+" - "+f1+" = "+f2);
				break;
			case 4:
				f2 = f % f1;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	"+f+" % "+f1+" = "+f2);
				break;
			default :
				f2 = f + f1;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	default f2="+f2+" f="+f+" f1="+f1+" dataInt="+dataInt);
				break;
			}
		} else {
			switch(dataInt) {
			case 0:
			case 1:
				f2 = f + f1;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	"+f+" + "+f1+" = "+f2);
				break;
			}
		}
		if (f2 == -0.0F) f2 = 0.0F;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	end. return f2="+f2);
		return f2;
	}

	protected double calculationDouble(double d, double d1) {
		boolean debug = false;
		double d2 = 0.0D;
		if (isCalculation()
				| isVariable()) {
			switch(dataInt) {
			case 0:
				return d * d1;
			case 1:
				return d / d1;
			case 2:
				return d + d1;
			case 3:
				return d - d1;
			case 4:
				return d % d1;
			}
		} else {
			switch(dataInt) {
			case 0:
			case 1:
				return d + d1;
			}
		}
		d2 = d + d1;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationDouble	d2="+d2+" d="+d+" d1="+d1+" dataInt="+dataInt);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationDouble	end.");
		}
		return d2;
	}

	protected long calculationLong(long l, long l1) {
		boolean debug = false;
		long l2 = 0L;
		if (isCalculation()
				| isVariable()) {
			switch(dataInt) {
			case 0:
				return l * l1;
			case 1:
				return l / l1;
			case 2:
				return l + l1;
			case 3:
				return l - l1;
			case 4:
				return l % l1;
			}
		} else {
			switch(dataInt) {
			case 0:
			case 1:
				return l + l1;
			}
		}
		l2 = l + l1;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationLong	l2="+l2+" l="+l+" l1="+l1+" dataInt="+dataInt);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationLong	end.");
		}
		return l2;
	}

	protected boolean calculationBoolean(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		int dataInt = getDataInt();
		boolean b = false;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean dataInt="+dataInt);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o="+o);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o1="+o1);
		}
		// TODO
		if (o1 instanceof List) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o1 instanceof List");
			List list2 = (List) o1;
			Object o2 = list2.get(0);
			Object o3 = list2.get(1);
			o = o2 instanceof Modchu_ITextCalculationDataFormat ? ((Modchu_ITextCalculationDataFormat) o2).calculationObject(map) : null;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o1 instanceof List o="+o);
			o1 = o3 instanceof Modchu_ITextCalculationDataFormat ? ((Modchu_ITextCalculationDataFormat) o3).calculationObject(map) : null;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o1 instanceof List o1="+o1);
		}
		if (o != null
				&& o1 != null
				&& isOperator()); else {
			return b;
		}
		switch (dataInt) {
		case 0:
			//"==",
			if (o instanceof Boolean
					&& o1 instanceof Boolean) {
				b = Modchu_CastHelper.Boolean(o) == Modchu_CastHelper.Boolean(o1);
			}
			else if (o instanceof Integer
					&& o1 instanceof Integer) {
				b = Modchu_CastHelper.Int(o) == Modchu_CastHelper.Int(o1);
			}
			else if (o instanceof Float
					&& o1 instanceof Float) {
				b = Modchu_CastHelper.Float(o) == Modchu_CastHelper.Float(o1);
			}
			else if (o instanceof Double
					&& o1 instanceof Double) {
				b = Modchu_CastHelper.Double(o) == Modchu_CastHelper.Double(o1);
			}
			else if (o instanceof Byte
					&& o1 instanceof Byte) {
				b = Modchu_CastHelper.Byte(o) == Modchu_CastHelper.Byte(o1);
			}
			else if (o instanceof Long
					&& o1 instanceof Long) {
				b = Modchu_CastHelper.Long(o) == Modchu_CastHelper.Long(o1);
			}
			else {
				b = o == o1;
			}
			break;
		case 1:
			//"||",
		case 2:
			//"|",
		case 3:
			//"&&",
			if (o instanceof Boolean
					&& o1 instanceof Boolean) {
				b = dataInt == 1
						| dataInt == 2 ? Modchu_CastHelper.Boolean(o)
						| Modchu_CastHelper.Boolean(o1) :
							Modchu_CastHelper.Boolean(o)
							&& Modchu_CastHelper.Boolean(o1);
				break;
			} else {
				if (debug) {
					if (!(o instanceof Boolean)) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationBoolean !o1 instanceof Boolean");
					if (!(o1 instanceof Boolean)) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationBoolean !o2 instanceof Boolean");
				}
			}
		case 4:
			//"!=",
			if (o instanceof Boolean
					&& o1 instanceof Boolean) {
				b = Modchu_CastHelper.Boolean(o) != Modchu_CastHelper.Boolean(o1);
			}
			else if (o instanceof Integer
					&& o1 instanceof Integer) {
				b = Modchu_CastHelper.Int(o) != Modchu_CastHelper.Int(o1);
			}
			else if (o instanceof Float
					&& o1 instanceof Float) {
				b = Modchu_CastHelper.Float(o) != Modchu_CastHelper.Float(o1);
			}
			else if (o instanceof Double
					&& o1 instanceof Double) {
				b = Modchu_CastHelper.Double(o) != Modchu_CastHelper.Double(o1);
			}
			else if (o instanceof Byte
					&& o1 instanceof Byte) {
				b = Modchu_CastHelper.Byte(o) != Modchu_CastHelper.Byte(o1);
			}
			else if (o instanceof Long
					&& o1 instanceof Long) {
				b = Modchu_CastHelper.Long(o) != Modchu_CastHelper.Long(o1);
			}
			else {
				b = o != o1;
			}
			break;
		case 5:
			//">=",
		case 6:
			//"<=",
		case 7:
			//"<",
		case 8:
			//">",
			if (o instanceof Integer
					&& o1 instanceof Integer) {
				b = dataInt == 5 ? Modchu_CastHelper.Int(o) >= Modchu_CastHelper.Int(o1) :
					dataInt == 6 ? Modchu_CastHelper.Int(o) <= Modchu_CastHelper.Int(o1) :
						dataInt == 7 ? Modchu_CastHelper.Int(o) < Modchu_CastHelper.Int(o1) :
							Modchu_CastHelper.Int(o) > Modchu_CastHelper.Int(o1);
			}
			else if (o instanceof Float
					&& o1 instanceof Float) {
				b = dataInt == 5 ? Modchu_CastHelper.Float(o) >= Modchu_CastHelper.Float(o1) :
					dataInt == 6 ? Modchu_CastHelper.Float(o) <= Modchu_CastHelper.Float(o1) :
						dataInt == 7 ? Modchu_CastHelper.Float(o) < Modchu_CastHelper.Float(o1) :
							Modchu_CastHelper.Float(o) > Modchu_CastHelper.Float(o1);
			}
			else if (o instanceof Double
					&& o1 instanceof Double) {
				b = dataInt == 5 ? Modchu_CastHelper.Double(o) >= Modchu_CastHelper.Double(o1) :
					dataInt == 6 ? Modchu_CastHelper.Double(o) <= Modchu_CastHelper.Double(o1) :
						dataInt == 7 ? Modchu_CastHelper.Double(o) < Modchu_CastHelper.Double(o1) :
							Modchu_CastHelper.Double(o) > Modchu_CastHelper.Double(o1);
			}
			else if (o instanceof Float
					&& o1 instanceof Double) {
				b = dataInt == 5 ? Modchu_CastHelper.Float(o) >= Modchu_CastHelper.Double(o1) :
					dataInt == 6 ? Modchu_CastHelper.Float(o) <= Modchu_CastHelper.Double(o1) :
						dataInt == 7 ? Modchu_CastHelper.Float(o) < Modchu_CastHelper.Double(o1) :
							Modchu_CastHelper.Float(o) > Modchu_CastHelper.Double(o1);
			}
			else if (o instanceof Double
					&& o1 instanceof Float) {
				b = dataInt == 5 ? Modchu_CastHelper.Double(o) >= Modchu_CastHelper.Float(o1) :
					dataInt == 6 ? Modchu_CastHelper.Double(o) <= Modchu_CastHelper.Float(o1) :
						dataInt == 7 ? Modchu_CastHelper.Double(o) < Modchu_CastHelper.Float(o1) :
							Modchu_CastHelper.Double(o) > Modchu_CastHelper.Float(o1);
			}
			else if (o instanceof Byte
					&& o1 instanceof Byte) {
				b = dataInt == 5 ? Modchu_CastHelper.Byte(o) >= Modchu_CastHelper.Byte(o1) :
					dataInt == 6 ? Modchu_CastHelper.Byte(o) <= Modchu_CastHelper.Byte(o1) :
						dataInt == 7 ? Modchu_CastHelper.Byte(o) < Modchu_CastHelper.Byte(o1) :
							Modchu_CastHelper.Byte(o) > Modchu_CastHelper.Byte(o1);
			}
			else if (o instanceof Long
					&& o1 instanceof Long) {
				b = dataInt == 5 ? Modchu_CastHelper.Long(o) >= Modchu_CastHelper.Long(o1) :
					dataInt == 6 ? Modchu_CastHelper.Long(o) <= Modchu_CastHelper.Long(o1) :
						dataInt == 7 ? Modchu_CastHelper.Long(o) < Modchu_CastHelper.Long(o1) :
							Modchu_CastHelper.Long(o) > Modchu_CastHelper.Long(o1);
			}
			else if (o instanceof Short
					&& o1 instanceof Short) {
				b = dataInt == 5 ? Modchu_CastHelper.Short(o) >= Modchu_CastHelper.Short(o1) :
					dataInt == 6 ? Modchu_CastHelper.Short(o) <= Modchu_CastHelper.Short(o1) :
						dataInt == 7 ? Modchu_CastHelper.Short(o) < Modchu_CastHelper.Short(o1) :
							Modchu_CastHelper.Short(o) > Modchu_CastHelper.Short(o1);
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o "+calculationOperatorStringList.get(dataInt)+" o1 b="+b);
		return b;
	}

	@Override
	public boolean isOneValue() {
		return isTrigonometricFunction();
	}

	@Override
	public String dataToString(boolean b) {
		StringBuilder sb = new StringBuilder();
		List<String> list = dataToStringList(b, false);
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString();
	}

	@Override
	public List<String> dataToStringList(boolean b, boolean isDebug) {
		List<String> list = new LinkedList();
		list.add(getDataString());
		return list;
	}

	@Override
	public void debugData(String s, String s1) {
		String s2 = s + " " + s1;
		Modchu_Debug.mDebug(s2+" Modchu_TextCalculationFormula getDataString()="+getDataString());
	}

	@Override
	public void setVariable(boolean b) {
	}

	public boolean isReflect() {
		return calculationReflectStringList.contains(dataString);
	}

	public boolean isInitFlag() {
		return initFlag;
	}

	public void setInitFlag(boolean b) {
		initFlag = b;
	}

}
