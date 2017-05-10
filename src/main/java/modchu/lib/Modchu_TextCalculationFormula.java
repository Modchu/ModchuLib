package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
	private Modchu_ReflectData reflectData;

	static {
		variableStringList = new ArrayList();
		variableStringList.addAll(Modchu_Main.stringArrayToArrayList(new String[]{
				"*=",
				"/=",
				"+=",
				"-=",
				"%="
		}));
		calculationStringList = new ArrayList();
		calculationStringList.addAll(Modchu_Main.stringArrayToArrayList(new String[]{
				"=",
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
				"method",
				"field"
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
		dataInt = isVariable() ? variableStringList.indexOf(s) :
			isCalculation() ? calculationStringList.indexOf(s) :
			isTrigonometricFunction() ? calculationTrigonometricFunctionStringList.indexOf(s) :
				isOperator() ? calculationOperatorStringList.indexOf(s) :
				0;
		setReflect(isTrigonometricFunction()
				&& dataInt > 1);
	}

	@Override
	public void init(Object o, Object o1, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (initFlag) return;
		initFlag = true;
		init_Reflect(o, o1, by, map);
	}

	private void init_Reflect(Object o, Object o1, byte by, HashMap<String, Object>... map) {
		if (!isReflect()) return;
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (o1 != null); else {
			String ss = "Modchu_TextCalculationFormula init_Reflect o1 == null error !! getDataString()="+getDataString();
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		if (!(o1 instanceof List)) {
			String ss = "Modchu_TextCalculationFormula init_Reflect !(o1 instanceof List) error !! o1="+o1;
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		List list = (List) o1;
		Object o2 = list.get(0);
		if (!(o2 instanceof Modchu_TextCalculationData)) {
			String ss = "Modchu_TextCalculationFormula init_Reflect !(o2 instanceof Modchu_TextCalculationData) error !! o2="+o2;
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o2;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula init_Reflect data1="+data1);
		Object o3 = data1.getSubData();
		if (!(o3 instanceof List)) {
			String ss = "Modchu_TextCalculationFormula init_Reflect !(o3 instanceof List) error !! o3="+o3;
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}

		List list1 = (List) o3;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect list="+list);
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect list1="+list1);
		}
		int tempCount = 0;
		Object o4 = list1.size() > tempCount ? list1.get(tempCount) : null;
		tempCount++;
		String className = null;
		String methodOrFieldName = null;
		Object reflectObject = null;
		boolean flag = false;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect o4="+o4+" o4.getClass()="+(o4 != null ? o4.getClass() : null));
		if (o4 != null) {
			if (o4 instanceof String) {
				className = (String) o4;
				Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set o4 String className="+className);
				Object o5 = list1.size() > tempCount ? list1.get(tempCount) : null;
				tempCount++;
				methodOrFieldName = (String) o5;
				Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set o5 String methodOrFieldName="+methodOrFieldName);
				Object o6 = list1.size() > tempCount ? list1.get(tempCount) : null;
				tempCount++;
				if (o6 != null) {
					if (o6 instanceof String) {
						String ss = "Modchu_TextCalculationFormula init_Reflect reflectObject o6 instanceof String error !! o6="+o6;
						Modchu_Debug.mDebug(ss);
						Modchu_Debug.lDebug(ss);
						Modchu_Main.setRuntimeException(ss);
						return;
					} else {
						reflectObject = o6;
						Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set o6 reflectObject="+reflectObject);
					}
				}
				flag = true;
			}
			else if (o4 instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data2 = (Modchu_TextCalculationData) o4;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect o4 instanceof Modchu_TextCalculationData data2="+data2);
				Object temp3 = data2.getSubData();
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect temp3="+temp3);
				if (temp3 != null
						&& temp3 instanceof List) {
					List list2 = (List) temp3;
					if (list2.size() < 2) {
						String ss = "Modchu_TextCalculationFormula init_Reflect className in list2.size() < 1 error !! list2="+list2;
						Modchu_Debug.mDebug(ss);
						Modchu_Debug.lDebug(ss);
						Modchu_Main.setRuntimeException(ss);
						return;
					}
					Object temp4 = list2.get(0);
					if (temp4 instanceof Modchu_TextCalculationData) {
						Modchu_TextCalculationData data3 = (Modchu_TextCalculationData) temp4;
						Object temp5 = data3.calculationObject(null, data3.getSubData(), by, map);
						if (temp5 instanceof String) {
							className = (String) temp5;
							Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set temp4 Modchu_TextCalculationData className="+className);
						}
					} else if (temp4 instanceof String) {
						className = (String) temp4;
						Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set temp4 String className="+className);
					}

					Object temp6 = list2.get(1);
					if (temp6 instanceof Modchu_TextCalculationData) {
						Modchu_TextCalculationData data4 = (Modchu_TextCalculationData) temp6;
						Object temp7 = data4.calculationObject(null, data4.getSubData(), by, map);
						if (temp7 instanceof String) {
							methodOrFieldName = (String) temp7;
							Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set temp6 Modchu_TextCalculationData methodOrFieldName="+methodOrFieldName);
							flag = true;
						}
					} else if (temp6 instanceof String) {
						methodOrFieldName = (String) temp6;
						Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set temp6 String methodOrFieldName="+methodOrFieldName);
						flag = true;
					}

					if (list2.size() > 2) {
						Object temp7 = list2.get(2);
						if (temp7 instanceof Modchu_TextCalculationData) {
							Modchu_TextCalculationData data5 = (Modchu_TextCalculationData) temp7;
							Object temp8 = data5.calculationObject(null, data5.getSubData(), by, map);
							if (temp8 instanceof String) {
								String ss = "Modchu_TextCalculationFormula init_Reflect reflectObject temp8 instanceof String error !! temp8="+temp8;
								Modchu_Debug.mDebug(ss);
								Modchu_Debug.lDebug(ss);
								Modchu_Main.setRuntimeException(ss);
								return;
							} else {
								reflectObject = temp8;
								Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set temp8 Modchu_TextCalculationData reflectObject="+reflectObject);
							}
						} else if (temp7 instanceof String) {
							String ss = "Modchu_TextCalculationFormula init_Reflect reflectObject temp7 instanceof String error !! temp7="+temp7;
							Modchu_Debug.mDebug(ss);
							Modchu_Debug.lDebug(ss);
							Modchu_Main.setRuntimeException(ss);
							return;
						}
					}
				}
			}
		}
		if (!flag) {
			String ss = "Modchu_TextCalculationFormula init_Reflect o4 == null error !! o3="+o3;
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}

		tempCount = 1;
		Object temp9 = list.size() > tempCount ? list.get(tempCount) : null;
		tempCount++;
		String s2 = null;
		Class[] reflectClassArray = null;
		flag = false;
		if (temp9 != null) {
			if (temp9 instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data6 = (Modchu_TextCalculationData) temp9;
				Object temp10 = data6.calculationObject(null, data6.getSubData(), by, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect temp10="+temp10);
				if (temp10 != null
						&& temp10 instanceof Class[]) {
					reflectClassArray = (Class[]) temp10;
					flag = true;
					Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set temp10 Class[] reflectClassArray="+Modchu_Main.objectArrayToString(reflectClassArray));
				}
			} else if (temp9 instanceof Class[]) {
				reflectClassArray = (Class[]) temp9;
				flag = true;
				Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set temp9 Class[] reflectClassArray="+Modchu_Main.objectArrayToString(reflectClassArray));
			}
		}
/*
		if (!flag) {
			Object temp6 = list1.size() > tempCount ? list1.get(tempCount) : null;
			tempCount++;
			if (temp6 != null
					&& temp6 instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data4 = (Modchu_TextCalculationData) temp6;
				Object temp7 = data4.calculationObject(null, data4.getSubData(), by, map);
				if (temp7 instanceof Class[]) {
					reflectClassArray = (Class[]) temp7;
					flag = true;
					Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set temp7 Class[] c0="+Modchu_Main.objectArrayToString(reflectClassArray));
				} else {
					String ss = "Modchu_TextCalculationData init_Reflect set !(temp7 instanceof Class[]) error !! data4.getData()="+data4.getData();
					Modchu_Debug.mDebug(ss);
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return;
				}
			}
		}
*/
		Object temp11 = list.size() > tempCount ? list.get(tempCount) : null;
		tempCount++;
		Object[] reflectObjectArray = null;
		if (temp11 != null) {
			if (temp11 instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data7 = (Modchu_TextCalculationData) temp11;
				Object temp12 = data7.calculationObject(null, data7.getSubData(), by, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect temp12="+temp12);
				if (temp12 instanceof Class[]) {
					String ss = "Modchu_TextCalculationData init_Reflect set temp9 instanceof Class[] error !! data7.getData()="+data7.getData();
					Modchu_Debug.mDebug(ss);
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return;
				}
				else if (temp12 instanceof Object[]) {
					reflectObjectArray = (Object[]) temp12;
					Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set temp12 Object[] reflectObjectArray="+Modchu_Main.objectArrayToString(reflectObjectArray));
				} else {
					String ss = "Modchu_TextCalculationData init_Reflect set !(temp9 instanceof Object[]) error !! data7.getData()="+data7.getData();
					Modchu_Debug.mDebug(ss);
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return;
				}
			} else if (temp11 instanceof Object[]) {
				reflectObjectArray = (Object[]) temp11;
				Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect set temp11 Object[] reflectObjectArray="+Modchu_Main.objectArrayToString(reflectObjectArray));
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect className="+className);
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect methodOrFieldName="+methodOrFieldName);
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect reflectClassArray="+reflectClassArray);
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect reflectObject="+reflectObject);
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect reflectObjectArray="+reflectObjectArray);
		}
		reflectData= new Modchu_ReflectData(className, methodOrFieldName, reflectClassArray, reflectObject, reflectObjectArray);
	}

	public String getDataString() {
		return dataString;
	}

	public int getDataInt() {
		return dataInt;
	}

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
		return calculationTrigonometricFunctionStringList.contains(s)
				| calculationStringList.contains(s);
	}

	@Override
	public Object calculationObject(Object o, Object o1, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject start. getDataString()="+getDataString()+" o="+o+" o1="+o1);
		init(o, o1, by, map);
		boolean flag = o != null;
		//boolean flag1 = getDataString().equals("-");
		if (by == (byte)-1) {
			Object o2 = o != null ? o : o1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject by == -1 getType o2="+o2);
			by = Modchu_RunCalculationList.getType(o2);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject by == -1 getType by="+by);
		}
		if (by == (byte)-1) {
			String ss ="Modchu_TextCalculationFormula calculationObject type error !! ="+(o != null ? o : o1);
			if (debug) Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return o;
		}
		Object o3 = null;
		if (isReflect()) {
			if (reflectData != null); else {
				String ss ="Modchu_TextCalculationFormula calculationObject isReflect() reflectData == null error !!";
				Modchu_Main.setRuntimeException(ss);
				return o;
			}
			o3 = Modchu_AS.get(reflectData.getClassName(), reflectData.getMethodOrFieldName(), reflectData.getReflectClassArray(), reflectData.getReflectObject(), reflectData.getReflectObjectArray());
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() Modchu_AS.get o3="+o3);
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject isReflect() Modchu_AS.get getCapsValueInt="+Modchu_EntityCapsHelper.getCapsValueInt(map[0].get("ObjectDefault"), map[0].get("entityCaps"), 524305, (Object[]) null));
			}
			return o3;
		}
		if (o1 != null) {
			if (o1 instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o1;
				Modchu_TextCalculationFormula formula = (Modchu_TextCalculationFormula) data1.getData();
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject o1 instanceof Modchu_TextCalculationFormula formula="+formula);
					Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject o1 instanceof Modchu_TextCalculationFormula formula.getDataString()="+formula.getDataString());
				}
				o3 = formula.calculationObject(o, o1, by, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject o1 instanceof Modchu_TextCalculationFormula o3="+o3);
			}
			else if (o1 instanceof Modchu_RunCalculationList) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationObject o1 instanceof Modchu_RunCalculationList\n");
				o3 = ((Modchu_RunCalculationList) o1).runCalculation(null, by, map);
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
		if (o != null); else o = Modchu_RunCalculationList.getTypeDefaultValue(by);
		if (by == Modchu_RunCalculationList.type_Object) {
			Object o2 = o != null ? o : o1;
			by = Modchu_RunCalculationList.getType(o2);
		}
		switch(by) {
		case Modchu_RunCalculationList.type_Integer:
		case Modchu_RunCalculationList.type_Byte:
			o3 = calculationInt(Modchu_CastHelper.Int(o, 0, false), o3 != null ? Modchu_CastHelper.Int(o3, 0, false) : 0);
			return by == Modchu_RunCalculationList.type_Byte ? (Byte)o3 : o3;
		case Modchu_RunCalculationList.type_Float:
			return calculationFloat(Modchu_CastHelper.Float(o, 0.0F, false), Modchu_CastHelper.Float(o3, 0.0F, false));
		case Modchu_RunCalculationList.type_Double:
			return calculationDouble(Modchu_CastHelper.Double(o, 0.0D, false), Modchu_CastHelper.Double(o3, 0.0D, false));
		case Modchu_RunCalculationList.type_Long:
			return calculationLong(Modchu_CastHelper.Long(o, 0L), Modchu_CastHelper.Long(o3, 0L));
		case Modchu_RunCalculationList.type_Boolean:
			return calculationBoolean(o, o3, by, map);
		}
		return o3;
	}

	protected float calculationTrigonometricFunction(float f1) {
		boolean debug = false;
		if (!isTrigonometricFunction()) return f1;
		switch(dataInt) {
		case 0:
			f1 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f1);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	cos("+f1+") = "+f1);
			}
			break;
		case 1:
			f1 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f1);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	sin("+f1+") = "+f1);
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

	protected boolean calculationBoolean(Object o, Object o1, byte type, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		int dataInt = getDataInt();
		boolean b = false;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean dataInt="+dataInt);
			Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o1="+o1);
		}
		// TODO
		if (o1 instanceof List) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o1 instanceof List");
			List list2 = (List) o1;
			Object o2 = list2.get(0);
			Object o3 = list2.get(1);
			o = o2 instanceof Modchu_RunCalculationList ? ((Modchu_RunCalculationList) o2).runCalculation(null, (byte)-1, map) :
					o2 instanceof Modchu_TextCalculationData ? ((Modchu_TextCalculationData) o2).calculationObject(null, ((Modchu_TextCalculationData) o2).getSubData(), (byte)-1, map) : null;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o="+o);
			o1 = o3 instanceof Modchu_RunCalculationList ? ((Modchu_RunCalculationList) o3).runCalculation(null, (byte)-1, map) :
				o3 instanceof Modchu_TextCalculationData ? ((Modchu_TextCalculationData) o3).calculationObject(null, ((Modchu_TextCalculationData) o3).getSubData(), (byte)-1, map) : null;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o1="+o1);
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
		return isTrigonometricFunction()
				| isOperator();
	}

	@Override
	public String dataToString(Object data, boolean b) {
		StringBuilder sb = new StringBuilder();
		List<String> list = dataToStringList(data, b);
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString();
	}

	@Override
	public List<String> dataToStringList(Object data, boolean b) {
		List<String> list = new LinkedList();
		if (isOperator()) {
			List list2 = (List) data;
			Object o2 = list2.size() > 0 ? list2.get(0) : null;
			Object o3 = list2.size() > 1 ? list2.get(1) : null;
			list.add(o2 instanceof Modchu_RunCalculationList ? ((Modchu_RunCalculationList) o2).dataToString(null, b) :
					o2 instanceof Modchu_TextCalculationData ? ((Modchu_TextCalculationData) o2).dataToString(((Modchu_TextCalculationData) o2).getSubData(), b) : null);
			list.add(getDataString());
			list.add(o3 instanceof Modchu_RunCalculationList ? ((Modchu_RunCalculationList) o3).dataToString(null, b) :
				o3 instanceof Modchu_TextCalculationData ? ((Modchu_TextCalculationData) o3).dataToString(((Modchu_TextCalculationData) o3).getSubData(), b) : null);
		} else {
			list.add(getDataString());
			if (data != null) {
				if (data instanceof Modchu_ITextCalculationDataFormat) {
					list.add(((Modchu_ITextCalculationDataFormat) data).dataToString(null, b));
				} else {
					list.add(data.toString());
				}
			}
		}
		return list;
	}

	@Override
	public void debugData(String s, String s1) {
		String s2 = s + " " + s1;
		Modchu_Debug.mDebug(s2+" Modchu_TextCalculationFormula getDataString()="+getDataString());
	}

	@Override
	public boolean isFixedValue() {
		return false;
	}

	@Override
	public void setFixedValue(boolean b) {
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

}
