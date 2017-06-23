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
	protected final String dataString;
	protected int dataInt;
	private boolean initFlag = false;
	private boolean isReflect = false;

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
				"sin",
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
		allCalculationStringList.addAll(calculationOperatorStringList);
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
				isOperator() ? calculationOperatorStringList.indexOf(s) :
				0;
		setReflect(isTrigonometricFunction()
				&& dataInt > 1);
	}

	private void init(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (initFlag) return;
		initFlag = true;
		init_Reflect(o, o1, map);
	}

	private void init_Reflect(Object o, Object o1, Map... map) {
		if (!isReflect()) return;
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (o1 != null); else {
			String ss = "Modchu_TextCalculationFormula init_Reflect o1 == null error !! getDataString()="+getDataString();
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		if (!(o1 instanceof Modchu_TextCalculationData)) {
			String ss = "Modchu_TextCalculationFormula init_Reflect !(o1 instanceof Modchu_TextCalculationData) error !! o1="+o1;
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o1;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect data1="+data1);
		if (data1.getReflectData() != null) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect data1.getReflectData() != null return.");
			return;
		}
		data1.calculationObject(o, o1, map);
		Object o3 = data1.getData();
		if (!(o3 instanceof Modchu_RunCalculationList)) {
			String ss = "Modchu_TextCalculationFormula init_Reflect !(o3 instanceof Modchu_RunCalculationList) error !! o3="+o3;
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}

		List<Modchu_ITextCalculationDataFormat> list1 = ((Modchu_RunCalculationList) o3).getList();
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect list1="+list1);
		}
		int tempCount = 0;
		Modchu_TextCalculationData data2 = (Modchu_TextCalculationData) (list1.size() > tempCount ? list1.get(tempCount) : null);
		tempCount++;
		Object classNameOrClass = null;
		String methodOrFieldName = null;
		Object reflectObject = null;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect data2="+data2);
		if (data2 != null) {
			Object temp3 = data2.calculationObject(null, map);
			//Object tempSubData = data2.getSubData();
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect temp3="+temp3);
				//Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect tempSubData="+tempSubData);
			}
			if (temp3 != null) {
				if (temp3 instanceof String) {
					String ss = "Modchu_TextCalculationFormula init_Reflect set temp3 String error !! temp3="+temp3;
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return;
				}
				else if (temp3 instanceof List) {
					List list3 = (List) temp3;
					Object o4 = list3.get(0);
					Object o5 = Modchu_TextCalculation.instance.runCalculationAther(o4, map);
					if (o5 instanceof String
							| o5 instanceof Class) {
						classNameOrClass = o5;
						Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect set temp3 List classNameOrClass="+classNameOrClass);
						Object o6 = list3.get(1);
						Object o7 = Modchu_TextCalculation.instance.runCalculationAther(o6, map);
						if (o7 instanceof String) {
							methodOrFieldName = (String) o7;
							Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect set temp3 List methodOrFieldName="+methodOrFieldName);
							if (list3.size() > 2) {
								Object o8 = list3.get(2);
								Object o9 = Modchu_TextCalculation.instance.runCalculationAther(o8, map);
								if (o9 instanceof String) {
									String s1 = (String) o9;
									Modchu_TextCalculationData data5 = new Modchu_TextCalculationData(s1);
									Object temp8 = data5.calculationObject(null, map);
									if (temp8 instanceof String) {
										String ss = "Modchu_TextCalculationFormula init_Reflect reflectObject temp8 instanceof List error !! temp8="+temp8;
										Modchu_Debug.mDebug(ss);
										Modchu_Debug.lDebug(ss);
										Modchu_Main.setRuntimeException(ss);
										return;
									} else {
										reflectObject = temp8;
										Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect reflectObject temp8 instanceof List reflectObject="+reflectObject);
									}
								} else {
									String ss = "Modchu_TextCalculationFormula init_Reflect reflectObject temp8 instanceof List !(o9 instanceof String) error !! o9="+o9;
									Modchu_Debug.lDebug(ss);
									Modchu_Main.setRuntimeException(ss);
									return;
								}
							}
						} else {
							String ss = "Modchu_TextCalculationFormula init_Reflect reflectObject temp8 instanceof List !(o7 instanceof String) error !! o7="+o7;
							Modchu_Debug.lDebug(ss);
							Modchu_Main.setRuntimeException(ss);
							return;
						}
					} else {
						String ss = "Modchu_TextCalculationFormula init_Reflect reflectObject temp8 instanceof List !(o5 instanceof String) && !(o5 instanceof Class) error !! o5="+o5;
						Modchu_Debug.lDebug(ss);
						Modchu_Main.setRuntimeException(ss);
						return;
					}
				}
			}
		} else {
			String ss = "Modchu_TextCalculationFormula init_Reflect data2 == null error !! list1="+list1;
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}

		Modchu_TextCalculationData data3 = data2.getNextData();
		String s2 = null;
		Class[] reflectClassArray = null;
		Object[] reflectObjectArray = null;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect data3="+data3);
		if (data3 != null) {
			Object temp10 = data3.calculationObject(null, map);
			temp10 = data3.getData();
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect temp10="+temp10);
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect data3.calculationObject(null, map)="+data3.calculationObject(null, map));
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect data3.isRaw()="+data3.isRaw());
			}
			if (temp10 != null) {
				if (temp10 instanceof Class[]) {
					reflectClassArray = (Class[]) temp10;
					Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect set temp10 Class[] reflectClassArray="+Modchu_Main.objectArrayToString(reflectClassArray));
				} else if (temp10 instanceof Object[]) {
					String ss = "Modchu_TextCalculationFormula init_Reflect set temp10 instanceof Object[] error !! temp10="+Modchu_Main.objectArrayToString((Object[]) temp10);
					Modchu_Debug.mDebug(ss);
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return;
				}
			}

			Modchu_TextCalculationData data4 = data3.getNextData();
			if (data4 != null) {
				Object temp12 = data4.calculationObject(null, map);
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect temp12="+temp12);
					Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect data7.initFlag="+data4.initFlag);
				}
				if (temp12 instanceof Class[]) {
					String ss = "Modchu_TextCalculationFormula init_Reflect set temp9 instanceof Class[] error !! data4.getData()="+data4.getData();
					Modchu_Debug.mDebug(ss);
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return;
				}
				else if (temp12 instanceof Object[]) {
					reflectObjectArray = (Object[]) temp12;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect set temp12 Object[] reflectObjectArray="+Modchu_Main.objectArrayToString(reflectObjectArray));
				} else {
					String ss = "Modchu_TextCalculationFormula init_Reflect set !(temp12 instanceof Object[]) error !! temp12="+temp12+" data4.getData()="+data4.getData();
					Modchu_Debug.mDebug(ss);
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return;
				}
			} else {
				String ss = "Modchu_TextCalculationFormula init_Reflect data3 == null error !!";
				Modchu_Debug.mDebug(ss);
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
				return;
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect className="+classNameOrClass);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect methodOrFieldName="+methodOrFieldName);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect reflectClassArray="+Modchu_Main.objectArrayToString(reflectClassArray));
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect reflectObject="+reflectObject);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect reflectObjectArray="+Modchu_Main.objectArrayToString(reflectObjectArray));
		}
		data1.setReflectData(new Modchu_ReflectData(classNameOrClass, methodOrFieldName, reflectClassArray, reflectObject, reflectObjectArray));
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
	public Object calculationObject(Object o, Map... map) {
		return calculationObject(o, null, map);
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
		if (!isVariable()
				&& o instanceof Modchu_TextCalculationData) {
			Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o;
			if (data1.isTempRaw()) {
				o = data1.getTempRawData();
			}
		}
		Modchu_TextCalculationData data2 = null;
		if (o1 instanceof Modchu_TextCalculationData) {
			data2 = (Modchu_TextCalculationData) o1;
			if (data2.isTempRaw()) {
				o1 = data2.getTempRawData();
			}
		}
		init(o, o1, map);
		boolean flag = o != null;
		//boolean flag1 = getDataString().equals("-");
		Object o2 = o != null ? o : o1;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject by == -1 getType o2="+o2);
		byte by = Modchu_RunCalculationList.getType(o2);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject by == -1 getType by="+by);
		if (by == (byte)-1) {
			String ss ="Modchu_TextCalculationFormula calculationObject type error !! o="+o+" o1="+o1;
			if (debug) Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return o;
		}
		Object o3 = null;
		if (isReflect()) {
			Modchu_ReflectData reflectData = data2.getReflectData();
			if (reflectData != null); else {
				String ss ="Modchu_TextCalculationFormula calculationObject isReflect() reflectData == null error !!";
				Modchu_Main.setRuntimeException(ss);
				return o;
			}
			Object o4 = reflectData.getReflectObject();
			if (o4 instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data6 = (Modchu_TextCalculationData) o4;
				Object temp = data6.calculationObject(null, map);
				if (data6.isTempRaw()) {
					o4 = data6.getTempRawData();
				}
			}
			Object classNameOrClass = reflectData.getClassNameOrClass();
			String methodOrFieldName = reflectData.getMethodOrFieldName();
			Class[] c0 = reflectData.getReflectClassArray();
			Object[] o0 = reflectData.getReflectObjectArray();
			if (c0 != null) {
				if (o0 != null) {
					if (c0.length != o0.length) {
						String ss ="Modchu_TextCalculationFormula calculationObject isReflect() c0.length != o0.length error !! reflectData.dataToString()="+reflectData.dataToString();
						Modchu_Debug.lDebug(ss);
						Modchu_Main.setRuntimeException(ss);
						return null;
					}
				} else {
					String ss ="Modchu_TextCalculationFormula calculationObject isReflect() c0 != null && o0 == null error !! reflectData.dataToString()="+reflectData.dataToString();
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return null;
				}
			}
			int i = getDataInt();
			switch(i) {
			case 2:
				if (classNameOrClass instanceof String) {
					o3 = Modchu_Reflect.invokeMethod((String) classNameOrClass, methodOrFieldName, c0, o4, o0);
				} else if (classNameOrClass instanceof Class) {
					o3 = Modchu_Reflect.invokeMethod((Class) classNameOrClass, methodOrFieldName, c0, o4, o0);
				}
				break;
			case 3:
				if (classNameOrClass instanceof String) {
					o3 = Modchu_Reflect.getFieldObject((String) classNameOrClass, methodOrFieldName, o4);
				} else if (classNameOrClass instanceof Class) {
					o3 = Modchu_Reflect.getFieldObject((Class) classNameOrClass, methodOrFieldName, o4);
				}
				break;
			case 4:
				if (classNameOrClass instanceof String) {
					o3 = Modchu_Reflect.setFieldObject((String) classNameOrClass, methodOrFieldName, o4, o0[0], 1);
				} else if (classNameOrClass instanceof Class) {
					o3 = Modchu_Reflect.setFieldObject((Class) classNameOrClass, methodOrFieldName, o4, o0[0], 1);
				}
				break;
			}
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() reflectData.dataToString()="+reflectData.dataToString());
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() Modchu_AS.get o3="+o3);

				Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() Modchu_AS.get classNameOrClass="+classNameOrClass);
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() Modchu_AS.get methodOrFieldName="+methodOrFieldName);
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() Modchu_AS.get c0="+Modchu_Main.objectArrayToString(c0));
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() Modchu_AS.get o4="+o4);
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() Modchu_AS.get o0="+Modchu_Main.objectArrayToString(o0));

				Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() Modchu_AS.get o0[0].getClass()="+(o0 != null && o0.length > 0 ? o0[0].getClass() : null));
				//Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() Modchu_AS.get getCapsValueInt="+Modchu_EntityCapsHelper.getCapsValueInt(map[0].get("ObjectDefault"), map[0].get("entityCaps"), 524305, (Object[]) null));
				//Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() Modchu_AS.get invokeMethod ="+Modchu_Reflect.invokeMethod(className, methodOrFieldName, c0, o4, o0));
			}
			return o3;
		}
		if (isVariable()) {
			setVariable(o, o1, map);
			return null;
		}
		if (o1 != null) {
			if (o1 instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o1;
				while (true) {
					o3 = data1.calculationObject(o3, map);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject o1 instanceof Modchu_TextCalculationData o3="+o3);
					if (data1.getNextData() != null); else break;
					data1 = data1.getNextData();
				}
			}
			else if (o1 instanceof Modchu_RunCalculationList) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject o1 instanceof Modchu_RunCalculationList\n");
				o3 = ((Modchu_RunCalculationList) o1).calculationObject(null, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject o1 instanceof Modchu_RunCalculationList o3="+o3);
			} else {
				o3 = o1;
			}
		} else {
			o3 = Modchu_RunCalculationList.getTypeDefaultValue(by);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject o3="+o3);
/*
		if (by == Modchu_RunCalculationList.type_Float
				&& Modchu_CastHelper.Float(o, 0.0F, false) == 0.0F
				&& Modchu_CastHelper.Float(o3, 0.0F, false) == 0.0F) {
			String ss ="Modchu_TextCalculationFormula calculationObject 0.0F && 0.0F debug.";
			if (debug) Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
		}
*/
		if (isTrigonometricFunction()) {
			o3 = calculationTrigonometricFunction(Modchu_CastHelper.Float(o3, 0.0F, false));
		}
		if (o != null); else {
			if (getDataInt() == 3) {
				o = Modchu_RunCalculationList.getTypeDefaultValue(by);
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject o == null return o3="+o3);
				return o3;
			}
		}
		if (isOperator()) {
			by = Modchu_RunCalculationList.type_Boolean;
		}
		switch(by) {
		case Modchu_RunCalculationList.type_Integer:
		case Modchu_RunCalculationList.type_Byte:
			o3 = calculationInt(Modchu_CastHelper.Int(o, 0, false), o3 != null ? Modchu_CastHelper.Int(o3, 0, false) : 0);
			o3 = by == Modchu_RunCalculationList.type_Byte ? (Byte)o3 : o3;
			break;
		case Modchu_RunCalculationList.type_Float:
			o3 = calculationFloat(Modchu_CastHelper.Float(o, 0.0F, false), Modchu_CastHelper.Float(o3, 0.0F, false));
			break;
		case Modchu_RunCalculationList.type_Double:
			o3 = calculationDouble(Modchu_CastHelper.Double(o, 0.0D, false), Modchu_CastHelper.Double(o3, 0.0D, false));
			break;
		case Modchu_RunCalculationList.type_Long:
			o3 = calculationLong(Modchu_CastHelper.Long(o, 0L), Modchu_CastHelper.Long(o3, 0L));
			break;
		case Modchu_RunCalculationList.type_Boolean:
		case Modchu_RunCalculationList.type_If:
			o3 = calculationBoolean(o, o3, map);
			break;
		}
		return o3;
	}

	protected void setVariable(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Modchu_TextCalculationData data1 = null;
		Modchu_TextCalculationData data2 = null;
		if (o instanceof Modchu_TextCalculationData) {
			data1 = (Modchu_TextCalculationData) o;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable o instanceof Modchu_TextCalculationData data1="+data1);
		} else {
			String ss ="Modchu_TextCalculationFormula setVariable !(o instanceof Modchu_TextCalculationData) error !! o="+o+" getDataString()="+getDataString();
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}

		Object o2 = null;
		Object o3 = null;
		if (o1 instanceof Modchu_TextCalculationData) {
			data2 = (Modchu_TextCalculationData) o1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable o1 instanceof Modchu_TextCalculationData data2="+data2);
			o3 = data2.calculationObject(null, map);
		} else if (o1 instanceof Modchu_RunCalculationList) {
			Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable o1 instanceof Modchu_RunCalculationList runCalculationList="+runCalculationList);
			o3 = runCalculationList.calculationObject(null, map);
		} else if (o1 instanceof List) {
			List<Modchu_ITextCalculationDataFormat> list1 = o1 != null
					&& o1 instanceof List ? (List<Modchu_ITextCalculationDataFormat>) o1 : null;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable o1 instanceof List list1="+list1);
			Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(list1);
			o3 = runCalculationList.calculationObject(null, map);
		} else {
			String ss ="Modchu_TextCalculationFormula setVariable o1 error !! o1="+o1+" getDataString()="+getDataString();
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		//Modchu_Debug.mdDebug("setVariable o3="+o3, 2);
		String variableString = data1.getVariableString();
		if (variableString != null); else {
			Object o4 = data1.getData();
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null o4="+o4);
			if (o4 instanceof String) {
				String s1 = (String) o4;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null s1="+s1);
				int i1 = s1.indexOf(".");
				if (i1 > -1) {
					String[] s0 = s1.split("\\.");
					Object o5 = null;
					for (Map map2 : map) {
						if (map2.containsKey(s0[0])) {
							o5 = map2.get(s0[0]);
							break;
						}
					}
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null o5="+o5);

					if (o5 != null) {
						if (s0.length > 2) {
							for (int i2 = 1; i2 < s0.length; i2++) {
								Object o6 = Modchu_Reflect.getFieldObject(o5.getClass(), s0[i2], o5, -1);
								if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null getFieldObject o6="+o6);
								if (o6 != null) {
									o5 = o6;
								} else {
									String ss ="Modchu_TextCalculationFormula setVariable variableString == null Object o6 == null error !! o5.getClass()="+o5.getClass()+" s0["+i2+"]="+s0[i2]+" o5="+o5;
									Modchu_Debug.lDebug(ss);
									Modchu_Main.setRuntimeException(ss);
									return;
								}
							}
						}
						boolean b = Modchu_Reflect.setFieldObject(o5.getClass(), s0[1], o5, o3, -1);
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null setFieldObject b="+b);
					}
					return;
				} else {
					variableString = s1;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula setVariable variableString == null. set variableString s1="+s1);
				}
			}
		}
		if (variableString != null); else {
			String ss ="Modchu_TextCalculationFormula setVariable variableString == null error !! data1="+data1+" data1.isVariable()="+data1.isVariable()+" data1.getData()="+data1.getData()+" this.equals(data1.getData())="+this.equals(data1.getData());
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		Map map1 = null;
		for (Map map2 : map) {
			if (map2.containsKey(variableString)) {
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
		if (!isCalculation
				&& !isTrigonometricFunction) return i + i1;
		int i3;
		if (isCalculation) {
			switch(dataInt) {
			case 0:
			case 1:
				return i + i1;
			}
		} else {
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
		}
		i3 = i + i1;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationInt	i3="+i3+" i="+i+" i1="+i1+" dataInt="+dataInt);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationInt	end.");
		}
		return i3;
	}

	protected float calculationFloat(float f, float f1) {
		boolean debug = Modchu_TextCalculation.instance.debugRun;
		boolean isCalculation = isCalculation();
		boolean isTrigonometricFunction = isTrigonometricFunction();
		if (!isCalculation
				&& !isTrigonometricFunction) return 0.0F;
		float f2 = 0.0F;
		if (isCalculation) {
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
		boolean isCalculation = isCalculation();
		boolean isTrigonometricFunction = isTrigonometricFunction();
		if (!isCalculation
				&& !isTrigonometricFunction) return 0.0D;
		double d2 = 0.0D;
		if (isCalculation) {
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
		boolean isCalculation = isCalculation();
		boolean isTrigonometricFunction = isTrigonometricFunction();
		if (!isCalculation
				&& !isTrigonometricFunction) return 0L;
		long l2 = 0L;
		if (isCalculation) {
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
			o = o2 instanceof Modchu_ITextCalculationDataFormat ? ((Modchu_ITextCalculationDataFormat) o2).calculationObject(null, map) : null;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o1 instanceof List o="+o);
			o1 = o3 instanceof Modchu_ITextCalculationDataFormat ? ((Modchu_ITextCalculationDataFormat) o3).calculationObject(null, map) : null;
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
			b = o == o1;
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
						| dataInt == 2 ? (Boolean) o
						| (Boolean) o1 :
							(Boolean) o
							&& (Boolean) o1;
				break;
			} else {
				if (debug) {
					if (!(o instanceof Boolean)) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationBoolean !o1 instanceof Boolean");
					if (!(o1 instanceof Boolean)) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationBoolean !o2 instanceof Boolean");
				}
			}
		case 4:
			//"!=",
			b = o != o1;
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
				b = dataInt == 5 ? (Integer) o >= (Integer) o1 :
					dataInt == 6 ? (Integer) o <= (Integer) o1 :
						dataInt == 7 ? (Integer) o < (Integer) o1 :
							(Integer) o > (Integer) o1;
				break;
			}
			else if (o instanceof Float
					&& o1 instanceof Float) {
				b = dataInt == 5 ? (Float) o >= (Float) o1 :
					dataInt == 6 ? (Float) o <= (Float) o1 :
						dataInt == 7 ? (Float) o < (Float) o1 :
							(Float) o > (Float) o1;
				break;
			}
			else if (o instanceof Double
					&& o1 instanceof Double) {
				b = dataInt == 5 ? (Double) o >= (Double) o1 :
					dataInt == 6 ? (Double) o <= (Double) o1 :
						dataInt == 7 ? (Double) o < (Double) o1 :
							(Double) o > (Double) o1;
				break;
			}
			else if (o instanceof Byte
					&& o1 instanceof Byte) {
				b = dataInt == 5 ? (Byte) o >= (Byte) o1 :
					dataInt == 6 ? (Byte) o <= (Byte) o1 :
						dataInt == 7 ? (Byte) o < (Byte) o1 :
							(Byte) o > (Byte) o1;
				break;
			}
			else if (o instanceof Long
					&& o1 instanceof Long) {
				b = dataInt == 5 ? (Long) o >= (Long) o1 :
					dataInt == 6 ? (Long) o <= (Long) o1 :
						dataInt == 7 ? (Long) o < (Long) o1 :
							(Long) o > (Long) o1;
				break;
			}
			else if (o instanceof Short
					&& o1 instanceof Short) {
				b = dataInt == 5 ? (Short) o >= (Short) o1 :
					dataInt == 6 ? (Short) o <= (Short) o1 :
						dataInt == 7 ? (Short) o < (Short) o1 :
							(Short) o > (Short) o1;
				break;
			}
			else if (o instanceof Float
					&& o1 instanceof Double) {
				b = dataInt == 5 ? (Float) o >= (Double) o1 :
					dataInt == 6 ? (Float) o <= (Double) o1 :
						dataInt == 7 ? (Float) o < (Double) o1 :
							(Float) o > (Double) o1;
				break;
			}
			else if (o instanceof Double
					&& o1 instanceof Float) {
				b = dataInt == 5 ? (Double) o >= (Float) o1 :
					dataInt == 6 ? (Double) o <= (Float) o1 :
						dataInt == 7 ? (Double) o < (Float) o1 :
							(Double) o > (Float) o1;
				break;
			}
			else if (o instanceof Integer
					&& o1 instanceof Float) {
				b = dataInt == 5 ? (Integer) o >= (Float) o1 :
					dataInt == 6 ? (Integer) o <= (Float) o1 :
						dataInt == 7 ? (Integer) o < (Float) o1 :
							(Integer) o > (Float) o1;
				break;
			}
			else if (o instanceof Float
					&& o1 instanceof Integer) {
				b = dataInt == 5 ? (Float) o >= (Integer) o1 :
					dataInt == 6 ? (Float) o <= (Integer) o1 :
						dataInt == 7 ? (Float) o < (Integer) o1 :
							(Float) o > (Integer) o1;
				break;
			}
			else if (o instanceof Double
					&& o1 instanceof Integer) {
				b = dataInt == 5 ? (Double) o >= (Integer) o1 :
					dataInt == 6 ? (Double) o <= (Integer) o1 :
						dataInt == 7 ? (Double) o < (Integer) o1 :
							(Double) o > (Integer) o1;
				break;
			}
			else if (o instanceof Integer
					&& o1 instanceof Double) {
				b = dataInt == 5 ? (Integer) o >= (Double) o1 :
					dataInt == 6 ? (Integer) o <= (Double) o1 :
						dataInt == 7 ? (Integer) o < (Double) o1 :
							(Integer) o > (Double) o1;
				break;
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
		return isReflect;
	}

	public void setReflect(boolean b) {
		isReflect = b;
	}

	public boolean isInitFlag() {
		return initFlag;
	}

	public void setInitFlag(boolean b) {
		initFlag = b;
	}

}
