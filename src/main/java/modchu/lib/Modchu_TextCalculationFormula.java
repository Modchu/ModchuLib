package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Modchu_TextCalculationFormula implements Modchu_ITextCalculationDataFormat {
	public static HashMap<String, Modchu_TextCalculationFormula> calculationFormulaMap = new HashMap();
	public static List<String> allCalculationStringList;
	public static List<String> calculationStringList;
	public static List<String> calculationTrigonometricFunctionStringList;
	public static List<String> calculationOperatorStringList;
	protected final String dataString;
	protected int dataInt;

	static {
		allCalculationStringList = new ArrayList();
		calculationStringList = new ArrayList();
		String[] s1 = new String[]{
				"*",
				"/",
				"+",
				"-",
				"%"
		};
		calculationStringList.addAll(Modchu_Main.stringArrayToArrayList(s1));
		allCalculationStringList.addAll(calculationStringList);
		calculationTrigonometricFunctionStringList = new ArrayList();
		String[] s2 = new String[]{
				"cos",
				"sin"
		};
		calculationTrigonometricFunctionStringList.addAll(Modchu_Main.stringArrayToArrayList(s2));
		allCalculationStringList.addAll(calculationTrigonometricFunctionStringList);
		calculationOperatorStringList = new ArrayList();
		calculationOperatorStringList.addAll(Modchu_Main.stringArrayToArrayList(Modchu_Main.getConditionalExpressionCharacterStringArray()));
		allCalculationStringList.addAll(calculationOperatorStringList);
	}

	public Modchu_TextCalculationFormula(String s) {
		dataString = s;
		dataInt = isCalculationString() ? calculationStringList.indexOf(s) :
			isTrigonometricFunction() ? calculationTrigonometricFunctionStringList.indexOf(s) + 100 :
				isOperator() ? calculationOperatorStringList.indexOf(s) + 1000 :
				0;
	}

	@Override
	public void init() {
	}

	public String getDataString() {
		return dataString;
	}

	public int getDataInt() {
		return dataInt;
	}

	public boolean isCalculationString() {
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
		//if (o != null); else o = Modchu_RunCalculationList.getTypeDefaultValue(by);
		Object o3 = null;
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
		switch(dataInt) {
		case 100:
			f1 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f1);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	cos("+f1+") = "+f1);
			}
			break;
		case 101:
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
		int i3;
		switch(dataInt) {
		case 0:
			return i * i1;
		case 1:
			return i / i1;
		case 2:
		case 100:
		case 101:
			return i + i1;
		case 3:
			return i - i1;
		case 4:
			return i % i1;
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
		float f2;
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
		case 100:
		case 101:
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
		if (f2 == -0.0F) f2 = 0.0F;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula	calculationFloat	end. return f2="+f2);
		return f2;
	}

	protected double calculationDouble(double d, double d1) {
		boolean debug = false;
		double d2;
		switch(dataInt) {
		case 0:
			return d * d1;
		case 1:
			return d / d1;
		case 2:
		case 100:
		case 101:
			return d + d1;
		case 3:
			return d - d1;
		case 4:
			return d % d1;
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
		long l2;
		switch(dataInt) {
		case 0:
			return l * l1;
		case 1:
			return l / l1;
		case 2:
		case 100:
		case 101:
			return l + l1;
		case 3:
			return l - l1;
		case 4:
			return l % l1;
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
				&& o1 != null); else {
			return b;
		}
		switch (dataInt) {
		case 1000:
			//"==",
			b = o == o1;
			break;
		case 1001:
			//"||",
		case 1002:
			//"|",
		case 1003:
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
		case 1004:
			//"!=",
			b = o != o1;
			break;
		case 1005:
			//">=",
		case 1006:
			//"<=",
		case 1007:
			//"<",
		case 1008:
			//">",
			if (o instanceof Integer
					&& o1 instanceof Integer) {
				b = dataInt == 1005 ? (Integer) o >= (Integer) o1 :
					dataInt == 1006 ? (Integer) o <= (Integer) o1 :
						dataInt == 1007 ? (Integer) o < (Integer) o1 :
							(Integer) o > (Integer) o1;
				break;
			}
			else if (o instanceof Float
					&& o1 instanceof Float) {
				b = dataInt == 1005 ? (Float) o >= (Float) o1 :
					dataInt == 1006 ? (Float) o <= (Float) o1 :
						dataInt == 1007 ? (Float) o < (Float) o1 :
							(Float) o > (Float) o1;
				break;
			}
			else if (o instanceof Double
					&& o1 instanceof Double) {
				b = dataInt == 1005 ? (Double) o >= (Double) o1 :
					dataInt == 1006 ? (Double) o <= (Double) o1 :
						dataInt == 1007 ? (Double) o < (Double) o1 :
							(Double) o > (Double) o1;
				break;
			}
			else if (o instanceof Byte
					&& o1 instanceof Byte) {
				b = dataInt == 1005 ? (Byte) o >= (Byte) o1 :
					dataInt == 1006 ? (Byte) o <= (Byte) o1 :
						dataInt == 1007 ? (Byte) o < (Byte) o1 :
							(Byte) o > (Byte) o1;
				break;
			}
			else if (o instanceof Long
					&& o1 instanceof Long) {
				b = dataInt == 1005 ? (Long) o >= (Long) o1 :
					dataInt == 1006 ? (Long) o <= (Long) o1 :
						dataInt == 1007 ? (Long) o < (Long) o1 :
							(Long) o > (Long) o1;
				break;
			}
			else if (o instanceof Short
					&& o1 instanceof Short) {
				b = dataInt == 1005 ? (Short) o >= (Short) o1 :
					dataInt == 1006 ? (Short) o <= (Short) o1 :
						dataInt == 1007 ? (Short) o < (Short) o1 :
							(Short) o > (Short) o1;
				break;
			}
			else if (o instanceof Float
					&& o1 instanceof Double) {
				b = dataInt == 1005 ? (Float) o >= (Double) o1 :
					dataInt == 1006 ? (Float) o <= (Double) o1 :
						dataInt == 1007 ? (Float) o < (Double) o1 :
							(Float) o > (Double) o1;
				break;
			}
			else if (o instanceof Double
					&& o1 instanceof Float) {
				b = dataInt == 1005 ? (Double) o >= (Float) o1 :
					dataInt == 1006 ? (Double) o <= (Float) o1 :
						dataInt == 1007 ? (Double) o < (Float) o1 :
							(Double) o > (Float) o1;
				break;
			}
			else if (o instanceof Integer
					&& o1 instanceof Float) {
				b = dataInt == 1005 ? (Integer) o >= (Float) o1 :
					dataInt == 1006 ? (Integer) o <= (Float) o1 :
						dataInt == 1007 ? (Integer) o < (Float) o1 :
							(Integer) o > (Float) o1;
				break;
			}
			else if (o instanceof Float
					&& o1 instanceof Integer) {
				b = dataInt == 1005 ? (Float) o >= (Integer) o1 :
					dataInt == 1006 ? (Float) o <= (Integer) o1 :
						dataInt == 1007 ? (Float) o < (Integer) o1 :
							(Float) o > (Integer) o1;
				break;
			}
			else if (o instanceof Double
					&& o1 instanceof Integer) {
				b = dataInt == 1005 ? (Double) o >= (Integer) o1 :
					dataInt == 1006 ? (Double) o <= (Integer) o1 :
						dataInt == 1007 ? (Double) o < (Integer) o1 :
							(Double) o > (Integer) o1;
				break;
			}
			else if (o instanceof Integer
					&& o1 instanceof Double) {
				b = dataInt == 1005 ? (Integer) o >= (Double) o1 :
					dataInt == 1006 ? (Integer) o <= (Double) o1 :
						dataInt == 1007 ? (Integer) o < (Double) o1 :
							(Integer) o > (Double) o1;
				break;
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormula calculationBoolean o "+calculationOperatorStringList.get(dataInt - 1000)+" o1 b="+b);
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
		if (isOperator()) {
			List list2 = (List) data;
			Object o2 = list2.size() > 0 ? list2.get(0) : null;
			Object o3 = list2.size() > 1 ? list2.get(1) : null;
			sb.append(o2 instanceof Modchu_RunCalculationList ? ((Modchu_RunCalculationList) o2).dataToString(null, b) :
					o2 instanceof Modchu_TextCalculationData ? ((Modchu_TextCalculationData) o2).dataToString(((Modchu_TextCalculationData) o2).getSubData(), b) : null);
			sb.append(getDataString());
			sb.append(o3 instanceof Modchu_RunCalculationList ? ((Modchu_RunCalculationList) o3).dataToString(null, b) :
				o3 instanceof Modchu_TextCalculationData ? ((Modchu_TextCalculationData) o3).dataToString(((Modchu_TextCalculationData) o3).getSubData(), b) : null);
		} else {
			sb.append(getDataString());
			if (data != null) {
				if (data instanceof Modchu_ITextCalculationDataFormat) {
					sb.append(((Modchu_ITextCalculationDataFormat) data).dataToString(null, b));
				} else {
					sb.append(data.toString());
				}
			}
		}
		return sb.toString();
	}

}
