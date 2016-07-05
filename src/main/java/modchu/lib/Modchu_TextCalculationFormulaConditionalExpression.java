package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Modchu_TextCalculationFormulaConditionalExpression extends Modchu_TextCalculationFormula {
	public static List<String> conditionalExpressionStringList;

	static {
		conditionalExpressionStringList = new ArrayList();
		conditionalExpressionStringList.addAll(Modchu_Main.stringArrayToArrayList(Modchu_Main.getConditionalExpressionCharacterStringArray()));
	}

	public Modchu_TextCalculationFormulaConditionalExpression(String s) {
		super(s);
		dataInt = conditionalExpressionStringList.indexOf(s);
	}

	public int getExpressionCharacterInt(String s) {
		if (s != null
				&& !s.isEmpty()); else return -1; 
		return conditionalExpressionStringList.indexOf(s);
	}

	@Override
	public Object calculationObject(Object o, Object o1, byte type, HashMap<String, Object>... map) {
		return calculationBoolean(o, o1, type, map);
	}

	protected boolean calculationBoolean(Object o, Object o1, byte type, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		int dataInt = getDataInt();
		boolean b = false;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormulaConditionalExpression calculationBoolean o1="+o1);
		// TODO
		if (o1 instanceof List) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormulaConditionalExpression calculationBoolean o1 instanceof List\n");
			List list2 = (List) o1;
			o = ((Modchu_RunCalculationList) list2.get(0)).runCalculation(null, (byte)-1, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormulaConditionalExpression calculationBoolean o="+o+"\n");
			o1 = ((Modchu_RunCalculationList) list2.get(1)).runCalculation(null, (byte)-1, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormulaConditionalExpression calculationBoolean o1="+o1);
		}
		if (o != null
				&& o1 != null); else {
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
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormulaConditionalExpression calculationBoolean o "+conditionalExpressionStringList.get(dataInt)+" o1 b="+b);
		return b;
	}

	@Override
	public boolean isOneValue() {
		return true;
	}

	@Override
	public String dataToString(Object data, boolean b) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		String s = getDataString();
		List list = (List) data;
		Object o = list.get(0);
		Object o1 = list.get(1);
		String s1 = ((Modchu_RunCalculationList) o).dataToString(null, false);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationFormulaConditionalExpression	dataToString	s1="+s1);
		String s2 = ((Modchu_RunCalculationList) o1).dataToString(null, false);
		StringBuilder sb = new StringBuilder().append(s1).append(s).append(s2);
		return sb.toString();
	}

}
