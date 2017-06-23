package modchu.lib;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Modchu_TextCalculation {
	public static Modchu_TextCalculation instance = new Modchu_TextCalculation();
	public HashMap<String, Modchu_RunCalculationList> conditionalExpressionMap;
	public HashMap<String, Modchu_RunCalculationList> calculationMap;
	public boolean debugSetting = false;
	public boolean debugRun = false;
	public boolean debugCE = false;
	public boolean debugCERun = false;
	public int debugCount = 0;
	public static boolean tempDebug = false;

	public Modchu_TextCalculation() {
		//debugSetting = !Modchu_Main.isRelease();
		//debugRun = !Modchu_Main.isRelease();
		//debugCE = !Modchu_Main.isRelease();
		//debugCERun = !Modchu_Main.isRelease();
		for (String s : Modchu_TextCalculationFormula.allCalculationStringList) {
			Modchu_TextCalculationFormula formula = new Modchu_TextCalculationFormula(s);
			Modchu_TextCalculationFormula.calculationFormulaMap.put(s, formula);
		}
	}

	public Modchu_RunCalculationList getTextCalculationList(String s) {
		if (s != null); else return null;
		if (s.indexOf(" ") > -1) s = Modchu_RunCalculationList.replace(s, " ", "");
		if (s.indexOf("\t") > -1) s = Modchu_RunCalculationList.replace(s, "\t", "");
		if (s.startsWith("if")) return getTextConditionalExpressionList(s);
		if (calculationMap != null); else calculationMap = new HashMap();
		if (calculationMap.containsKey(s)) return calculationMap.get(s);
		Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(s);
		//Modchu_RunCalculationList runCalculationList = calculationListToTextCalculationData(list);
		calculationMap.put(s, runCalculationList);
		return runCalculationList;
	}

	protected Modchu_RunCalculationList getTextConditionalExpressionList(String s) {
		boolean debug = debugCE;
		//tempDebug = debug;
		if (debug) {
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipLog = true;
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	s="+s);
		}
		if (s != null); else {
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	s == null.");
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	------------------- 1 end.");
			}
			return null;
		}
		if (!s.startsWith("if")) {
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	!s.startsWith(if)");
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	------------------- 2 end.");
			}
			return null;
		}
		if (conditionalExpressionMap != null); else conditionalExpressionMap = new HashMap();
		if (conditionalExpressionMap.containsKey(s)) return conditionalExpressionMap.get(s);
		String s1 = s;
		List list = new LinkedList();
		List<String> list1 = new LinkedList();
		boolean isMultipleLines = false;
		int i1 = s1.indexOf("\n");
		if (i1 > -1) {
			String[] s0 = s1.split("\n");
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	\\n s0="+Modchu_Main.objectArrayToString(s0));
			list1.addAll(Modchu_Main.stringArrayToLinkedList(s0));
			isMultipleLines = true;
		} else {
			i1 = s1.indexOf(":");
			if (i1 > -1) {
				String[] s0 = s1.split(":");
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	: s0="+Modchu_Main.objectArrayToString(s0));
				list1.addAll(Modchu_Main.stringArrayToLinkedList(s0));
				isMultipleLines = true;
			} else {
				list1.add(s1);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	!\\n && !: list1.add s1="+s1);
			}
		}
		for (String s2 : list1) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	s2="+s2);
			Modchu_RunCalculationList runCalculationList1 = getTextConditionalExpressionList_r(s2);
			if (runCalculationList1 != null) list.add(new Modchu_TextCalculationData(runCalculationList1));
		}

		Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(list);
		runCalculationList.setIsIf(true);
		runCalculationList.setIsMultipleLines(isMultipleLines);
		conditionalExpressionMap.put(s, runCalculationList);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	runCalculationList="+runCalculationList);
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	------------------- 3 end.");
		}
		return runCalculationList;
	}

	protected Modchu_RunCalculationList getTextConditionalExpressionList_r(String s) {
		boolean debug = tempDebug;
		if (s.equalsIgnoreCase("{")
				| s.equalsIgnoreCase("}")
				| s.startsWith("//")) return null;
		int i1 = s.indexOf("/*");
		int i2 = s.indexOf("*/");
		if (i1 > -1
				&& i2 > -1) {
			String tempS1 = null;
			String tempS2 = null;
			if (i1 > 0) tempS1 = s.substring(0, i1);
			if (i2 > 0) tempS2 = s.substring(i2 + 2);
			StringBuilder sb = new StringBuilder();
			if (tempS1 != null
					&& !tempS1.isEmpty()) {
				sb.append(tempS1);
			}
			if (tempS2 != null
					&& !tempS2.isEmpty()) {
				sb.append(tempS2);
			}
			s = sb.toString();
			if (s != null
					&& !s.isEmpty()); else return null;
		}
		i1 = s.indexOf("else");
		i2 = s.indexOf("if");
		int i3 = s.indexOf("\"");
		boolean elseFlag = i1 > -1
				&& (i3 < 0
						| i3 > i1 + 4);
		boolean ifFlag = i2 > -1
				&& (i3 < 0
						| i3 > i2 + 4);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList_r	s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList_r	elseFlag="+elseFlag);
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList_r	ifFlag="+ifFlag);
		}
		if (elseFlag) {
			s = s.substring(i1 + 4);
			if (i2 < 0) {
				Modchu_RunCalculationList runCalculationList1 = new Modchu_RunCalculationList((List) null);
				runCalculationList1.setIsElse(true);
				return runCalculationList1;
			}
			if (i2 != 0) {
				s = s.substring(i1);
			}
		}
		List list1 = null;
		if (ifFlag) {
			Modchu_TextFormatData data = Modchu_TextFormatManager.getTextFormatManagerData(s);
			List<String> stringList = data.getStringList(2);
			List insideList = data.getStringList(3);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList_r	stringList="+Modchu_Main.listToString(stringList));
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList_r	insideList="+Modchu_Main.listToString(insideList));
			}
			if (insideList != null
					&& !insideList.isEmpty()) {
				Object o = insideList != null
						&& !insideList.isEmpty() ? insideList.get(0) : null;
				list1 = o != null
						&& o instanceof List ? (List) o : null;
			}
			s = (String) list1.get(0);
		}

		Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(s);
		if (ifFlag) runCalculationList.setIsIf(true);
		return runCalculationList;
	}

	public Object runCalculation(Modchu_RunCalculationList runCalculationList, HashMap... map) {
		return runCalculation(null, runCalculationList, map);
	}

	public Object runCalculation(Object o, Modchu_RunCalculationList runCalculationList, HashMap... map) {
		boolean debug = (debugRun && !runCalculationList.isIf())
				| (debugCERun && runCalculationList.isIf());
		//Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation runCalculationList.isIf()="+runCalculationList.isIf()+" debug="+debug);
		Object temp = Modchu_Debug.getFreeVariable("debugRunCalculationInit");
		boolean initDebug = false;
		if (temp != null) {
			initDebug = (Boolean) temp;
		}
		if (!initDebug) {
			Modchu_Debug.registerListString("Calculation");
			Modchu_Debug.setFreeVariable("debugRunCalculationInit", true);
		}
		if (debug) {
			//Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation ObjectDefault map[0]="+map[0]);
/*
			if (!Modchu_Main.isRelease()) {
				if (!Modchu_CastHelper.Boolean(Modchu_Debug.getFreeVariable("debugRunCalculationInit"))) {
					Modchu_Debug.setFreeVariable("debugRunCalculationInit", true);
					Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	Modchu_Debug.setClipLog = true.");
				}
			}
*/

			Object o1 = Modchu_Debug.getFreeVariable("debugRunCalculationDebugList");
			List debugList = o1 != null ? (LinkedList) o1 : new LinkedList();
			if (debugList != null
					&& !debugList.isEmpty()
					&& debugList.contains(runCalculationList)) {
				//debug = false;
				//Modchu_Debug.setClipLog = false;
			}
			else {
				debugList.add(runCalculationList);
				Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	debugList.add runCalculationList="+runCalculationList);
				Modchu_Debug.setFreeVariable("debugRunCalculationDebugList", debugList);
				Modchu_Debug.setClipLog = true;
			}

		}
		//tempDebug = debug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	calculationListToString(runCalculationList)="+runCalculationList.dataToString(true));
			debugCount = 1;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation map[0]="+(map != null && map.length > 0 ? map[0] : null)+"\n");
		Object o2 = runCalculationList.calculationObject(o, map);
		if (debug) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation 	runCalculation	end. o2="+o2);
			if (!Modchu_Main.isRelease()) {
				Modchu_Debug.setClipboardLog();
			}
			//Modchu_TextCalculation.instance.debugRun = false;
		}
		return o2;
	}

	public void debugData(String s, Object o) {
		debugData(null, s, o);
	}

	public void debugData(String s, String s1, Object o) {
		if (s != null); else s = "Modchu_TextCalculation	[ @@@debugData@@@ ]	";
		String s2 = s + " " + s1;
		Modchu_Debug.mDebug(s2+"="+o);
		if (o instanceof Modchu_RunCalculationList) {
			Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o;
			runCalculationList.debugData(s, s1);
		}
		//Modchu_Debug.mDebug(s+" dataToString("+s1+", false)="+dataToString(o, false));
		//if (o instanceof Modchu_TextCalculationData) Modchu_Debug.mDebug(s2+".getSubData()="+((Modchu_TextCalculationData) o).getSubData());
	}

	public String dataToString(List list, boolean b) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			Object o = list.get(i);
			sb.append(dataToString(o, b));
			if (i != list.size() - 1) sb.append(", ");
		}
		return sb.toString();
	}

	public String dataToString(Object o, boolean b) {
		if (o != null); else return null;
		StringBuilder sb = new StringBuilder();
		if (o instanceof List) {
			sb.append(dataToString((List) o, b));
		} else if (o instanceof Modchu_ITextCalculationDataFormat) {
			sb.append(((Modchu_ITextCalculationDataFormat) o).dataToString(b));
		} else {
			sb.append(o.toString());
			//Modchu_Debug.mDebug("Modchu_TextCalculation	dataToString	o="+o);
		}
		return sb.toString();
	}

	public Object runCalculationAther(Object o, HashMap<String, Object>... map) {
		return runCalculationAther(o, null, map);
	}

	public Object runCalculationAther(Object o, Object o1, HashMap<String, Object>... map) {
		if (o instanceof Modchu_ITextCalculationDataFormat) {
			Modchu_ITextCalculationDataFormat iTextCalculationDataFormat = (Modchu_ITextCalculationDataFormat) o;
			o = iTextCalculationDataFormat.calculationObject(o1, map);
			if (o instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data = (Modchu_TextCalculationData) o;
				if (data.isTempRaw()) {
					o = data.getTempRawData();
				}
			}
		}
		return o;
	}

}
