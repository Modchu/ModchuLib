package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Modchu_TextCalculationFormula implements Modchu_ITextCalculationDataFormat {
	public static HashMap<String, Modchu_TextCalculationFormula> calculationFormulaMap = new HashMap();
	public static List<String> calculationStringList;
	public static List<String> calculationTrigonometricFunctionStringList;
	protected final String dataString;
	protected int dataInt;

	static {
		calculationStringList = new ArrayList();
		String[] s1 = new String[]{
				"*",
				"/",
				"+",
				"-",
				"%"
		};
		calculationStringList.addAll(Modchu_Main.stringArrayToArrayList(s1));
		calculationTrigonometricFunctionStringList = new ArrayList();
		String[] s2 = new String[]{
				"cos",
				"sin"
		};
		calculationTrigonometricFunctionStringList.addAll(Modchu_Main.stringArrayToArrayList(s2));
	}

	public Modchu_TextCalculationFormula(String s) {
		dataString = s;
		dataInt = isCalculationString() ? calculationStringList.indexOf(s) :
			isTrigonometricFunction() ? calculationTrigonometricFunctionStringList.indexOf(s) + 100 : 0;
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
		if (o != null) {
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
				return calculationBoolean(Modchu_CastHelper.Boolean(o), Modchu_CastHelper.Boolean(o3));
			}
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

	protected boolean calculationBoolean(boolean b, boolean b1) {
		return b && b1;
	}

	@Override
	public boolean isOneValue() {
		return isTrigonometricFunction();
	}

	@Override
	public String dataToString(Object data, boolean b) {
		StringBuilder sb = new StringBuilder().append(getDataString());
		if (data != null) {
			if (data instanceof Modchu_ITextCalculationDataFormat) {
				sb.append(((Modchu_ITextCalculationDataFormat) data).dataToString(null, b));
			} else {
				sb.append(data.toString());
			}
		}
		return sb.toString();
	}

}
