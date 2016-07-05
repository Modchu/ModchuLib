package modchu.lib;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Modchu_TextCalculation {
	public static Modchu_TextCalculation instance = new Modchu_TextCalculation();
	public HashMap<String, Modchu_RunCalculationList> conditionalExpressionMap;
	public HashMap<String, Modchu_RunCalculationList> calculationMap;
	protected final int maxLoop = 64;
	public boolean debugSetting = false;
	public boolean debugRun = false;
	public boolean debugCE = false;
	public boolean debugCERun = false;
	public int debugCount = 0;
	public static boolean tempDebug;

	public Modchu_TextCalculation() {
		//debugSetting = !Modchu_Main.isRelease();
		//debugRun = !Modchu_Main.isRelease();
		//debugCE = !Modchu_Main.isRelease();
		//debugCERun = !Modchu_Main.isRelease();
		for (String s : Modchu_TextCalculationFormula.calculationStringList) {
			Modchu_TextCalculationFormula.calculationFormulaMap.put(s, new Modchu_TextCalculationFormula(s));
		}
		for (String s : Modchu_TextCalculationFormula.calculationTrigonometricFunctionStringList) {
			Modchu_TextCalculationFormula.calculationFormulaMap.put(s, new Modchu_TextCalculationFormula(s));
		}
	}

	public Modchu_RunCalculationList getTextCalculationList(String s) {
		boolean debug = debugSetting;
		tempDebug = debug;
		if (s != null); else return null;
		if (s.indexOf(" ") > -1) s = s.replace(" ", "");
		if (s.indexOf("\t") > -1) s = s.replace("\t", "");
		if (s.startsWith("if")) return getTextConditionalExpressionList(s);
		if (debug) {
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipLog = true;
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	s="+s);
		}
		if (calculationMap != null); else calculationMap = new HashMap();
		if (calculationMap.containsKey(s)) return calculationMap.get(s);
		List list = new LinkedList();
/*
		if (b
				&& !Modchu_Main.calculationCharacterStringCheck(s)) {
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	s="+s+" !calculationCharacterStringCheck return.");
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	------------------- end.");
			}
			return null;
		}
*/
		List<String> tempList = new ArrayList();
		tempList.add(s);
		for (int i = 0; i < maxLoop; i++) {
			settingTextCalculationList_r(list, tempList);
			if (tempList.isEmpty()) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	tempList.isEmpty() break.");
				break;
			}
		}
		Modchu_RunCalculationList runCalculationList = calculationListToTextCalculationData(list);
		calculationMap.put(s, runCalculationList);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	calculationListToString(runCalculationList)="+calculationListToString(runCalculationList));
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	list.size()="+list.size());
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	------------------- end.");
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipboardLog();
		}
		return runCalculationList;
	}

	protected void settingTextCalculationList_r(List list, List<String> list1) {
		boolean debug = debugSetting;
		String s = list1.get(0);
		list1.remove(0);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	------------------ start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	s="+s);
		}
		List list2 = getCalculationDataList(s);
		if (list2 != null
				&& !list2.isEmpty()) {
			list.addAll(list2);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	list.add list2="+Modchu_Main.listToString(list2));
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	"+s+" list.size()="+list.size());
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	------------------ end.");
		}
	}

	protected List getCalculationDataList(String s) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataList	----------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataList	s="+s);
		}
		List list = new LinkedList();
		List tempList = getCalculationDataStringList(s);
		if (tempList != null
				&& !tempList.isEmpty()) {
			for (int i = 0; i < maxLoop; i++) {
				settingCalculationData_r(list, tempList);
				if (tempList.isEmpty()) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataList	tempList.isEmpty() break.");
					break;
				}
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataList	list.size()="+list.size());
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataList	----------------- end.");
		}
		return list;
	}

	protected List getCalculationDataStringList(String s) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataStringList	----------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataStringList	s="+s);
		}
		List tempList = new ArrayList();
		List<String> tempList1 = new ArrayList();
		tempList1.add(s);
		for (int i = 0; i < maxLoop; i++) {
			calculationDataStringList_r(tempList, tempList1);
			if (tempList1.isEmpty()) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataStringList	tempList.isEmpty() break.");
				break;
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataStringList	s="+s+" tempList="+tempList);
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataStringList	----------------- end.");
		}
		return tempList;
	}

	protected void calculationDataStringList_r(List list, List<String> list1) {
		boolean debug = debugSetting;
		String s = list1.get(0);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	---------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	s="+s);
		}
		list1.remove(0);
		List<String> list2 = Modchu_Main.copyList(Modchu_TextCalculationFormula.calculationStringList);
		list2.add(0, "(");
		int i0 = list2.size() - 1;
		Object[] o0 = Modchu_Main.getIndexOf(s, list2);
		int i1 = -1;
		int i = -1;
		String s1 = null;
		if (o0 != null
				&& o0.length > 2) {
			i1 = Modchu_CastHelper.Int(o0[0]);
			i = Modchu_CastHelper.Int(o0[1]);
			s1 = Modchu_CastHelper.String(o0[2]);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	1 i="+i+" i1="+i1+" s1="+s1);
		if (i1 > -1) {
			String s3 = i1 > 0 ? s.substring(0, i1) : null;
			if (s3 != null
					&& !s3.isEmpty()) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list.add s3="+s3);
				list.add(s3);
			}
			String s4 = s.substring(i1, i1 + s1.length());
			String s5 = s.substring(i1 + s1.length());
			boolean flag = i == 0;
			List list3 = null;
			if (flag) {
				list3 = new ArrayList();
				List list4 = new ArrayList();
				Object[] o1 = Modchu_Main.getInsideParenthesesData(s);
				String s6 = Modchu_CastHelper.String(o1[0]);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	s6="+s6);
				if (s6 != null
						&& !s6.isEmpty()) {
					int i2 = Modchu_CastHelper.Int(o1[2]);
					list3.add(s6);
					for (int i3 = 0; i3 < maxLoop; i3++) {
						calculationDataStringList_r(list4, list3);
						if (list3.isEmpty()) {
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list3.isEmpty() break.");
							break;
						}
					}
					list.add(list4);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	flag list.add list4="+Modchu_Main.listToString(list4));
					s5 = s.substring(i2 + 1);
				}
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	!flag s3="+s3+" s4="+s4+" s5="+s5);
				if (s4 != null
						&& !s4.isEmpty()) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	!flag list.add s4="+s4);
					list.add(s4);
				}
			}
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	s5="+s5);
			if (s5 != null
					&& !s5.isEmpty()) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list1.add s5="+s5);
				list1.add(s5);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list1="+Modchu_Main.listToString(list1));
			}
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	s="+s);
				Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	---------------- end. 2");
			}
			return;
		}
		if (s != null
				&& !s.isEmpty()) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list.add s="+s);
			list.add(s);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list="+Modchu_Main.listToString(list));
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	---------------- end. 3");
		return;
	}

	protected void settingCalculationData_r(List list, List list1) {
		boolean debug = debugSetting;
		Object o2 = list1.get(0);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	---------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	o2="+Modchu_Main.objectToString(o2));
		}
		list1.remove(0);
		if (o2 instanceof List) {
			List list2 = (List) o2;
			List list3 = new ArrayList();
			for (int i = 0; i < maxLoop; i++) {
				settingCalculationData_r(list3, list2);
				if (list2.isEmpty()) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	list2.isEmpty() break.");
					break;
				}
			}
			if (!list3.isEmpty()) list.add(list3);
		} else if (o2 instanceof String) {
			String s = (String) o2;
			settingCalculationData_r_s(list, list1, s);
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	o2="+Modchu_Main.objectToString(o2));
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	---------------- end.");
		}
	}

	protected void settingCalculationData_r_s(List list, List list1, String s) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s	--------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s	s="+s);
		}
		if (settingCalculationData_r_s_ListString(list, list1, Modchu_TextCalculationFormula.calculationTrigonometricFunctionStringList, s)) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s	settingCalculationData_r_s_TrigonometricFunction	--------------- end.");
			return;
		}
		if (settingCalculationData_r_s_ListString(list, list1, Modchu_TextCalculationFormula.calculationStringList, s)) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s	settingCalculationData_r_s_calculationString	--------------- end.");
			return;
		}
		Object o1 = Modchu_Main.stringToSuitableObject(s);
		if (o1 != null) list.add(new Modchu_TextCalculationData(o1));
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s	s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s	--------------- end. 3");
		}
	}

	protected void settingCalculationData_r_s_s(List list, List list1, String s, String s2) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	--------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	s2="+s2);
		}
		Object o3 = null;
		if (settingCalculationData_r_s_ListString(list, list1, Modchu_TextCalculationFormula.calculationTrigonometricFunctionStringList, s2)) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	settingCalculationData_r_s_TrigonometricFunction s2="+s2);
			Object o4 = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			o3 = getCalculationData(s, o4);
		} else {
			o3 = getCalculationData(s, s2);
		}
		if (o3 != null) list.add(o3);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	o3="+o3);
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	--------------- end. 3");
		}
	}

	protected boolean settingCalculationData_r_s_ListString(List list, List list1, List<String> list2, String s) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_ListString	--------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_ListString	s="+s);
		}
		for (String tempS : list2) {
			if (s.startsWith(tempS)) {
				Modchu_TextCalculationFormula formula = Modchu_TextCalculationFormula.calculationFormulaMap.get(tempS);
				if (formula != null) {
					list.add(new Modchu_TextCalculationData(formula));
					if (debug) {
						Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_ListString	s="+s);
						Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_ListString	return true	--------------- end.");
					}
					return true;
				}
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_ListString	s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_ListString	return false	--------------- end.");
		}
		return false;
	}

	protected boolean checkTrigonometricFunction(String s) {
		for (String s1 : Modchu_TextCalculationFormula.calculationTrigonometricFunctionStringList) {
			if (s.startsWith(s1)) return true;
		}
		return false;
	}

	protected Modchu_RunCalculationList calculationListToTextCalculationData(List list) {
		boolean debug = debugSetting;
		List<Modchu_TextCalculationData> list1 = new LinkedList();
		for (int i = 0; i < list.size(); i++) {
			Object o = list.get(i);
			Modchu_TextCalculationData data = null;
			if (o instanceof List) {
				List list3 =  (List) o;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationListTrigonometricFunctionCheck o instanceof List list3="+Modchu_Main.listToString(list3));
				Modchu_RunCalculationList runCalculationList = calculationListToTextCalculationData(list3);
				data = new Modchu_TextCalculationData(runCalculationList);
			}
			else if (o instanceof Modchu_TextCalculationData) {
				data =  (Modchu_TextCalculationData) o;
				if (data.isTrigonometricFunction()) {
					i++;
					Object o2 = list.get(i);
					Object o3 = null;
					if (o2 instanceof List) {
						List list3 =  (List) o2;
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationListTrigonometricFunctionCheck o instanceof Modchu_TextCalculationData o2 instanceof List list3="+Modchu_Main.listToString(list3));
						Modchu_RunCalculationList runCalculationList = calculationListToTextCalculationData(list3);
						o3 = runCalculationList;
					}
					else if (o2 instanceof Modchu_TextCalculationData) {
						Modchu_TextCalculationData data1 =  (Modchu_TextCalculationData) o2;
						o3 = data1;
					}
					data.setSubData(o3);
				}
			} else {
				data = new Modchu_TextCalculationData(o);
			}
			if (data != null) list1.add(data);
		}
		Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(list1);
		return runCalculationList;
	}

	protected Object getCalculationData(String s, Object o) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object	s="+s+" o="+Modchu_Main.objectToString(o));
		}
		Object o1 = null;
		for (int i = 0; i < Modchu_TextCalculationFormula.calculationStringList.size(); i++) {
			String s2 = Modchu_TextCalculationFormula.calculationStringList.get(i);
			if (s.equals(s2)) {
				o1 = getCalculationData(s, o, i);
				break;
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object	s="+s+" o="+Modchu_Main.objectToString(o));
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object	------------------- end.");
		}
		return o1;
	}

	protected Object getCalculationData(String s, Object o, int i) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	s="+s+" o="+Modchu_Main.objectToString(o)+" i="+i);
		}
		Object o1 = null;
		if (!(o instanceof List)
				&& !(o instanceof String)) {
			String ss = "Modchu_TextCalculation	getCalculationData String Object int	!(o instanceof List) && !(o instanceof String) error !! o="+Modchu_Main.objectToString(o)+" o.getClass()="+(o != null ? o.getClass() : null);
			if (debug) Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return null;
		}
		if (o instanceof List) {
			List list2 =  (List) o;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	o instanceof List list2="+list2);
			Object o4 = getCalculationData(list2);
			o1 = o4;
		}
		else if (o instanceof String) {
			String s1 = o instanceof String ? (String) o : null;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	o instanceof String s1="+s1);
			Object o2 = Modchu_Main.stringToSuitableObject(s1);
			o1 = o2;
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	s="+s+" o="+Modchu_Main.objectToString(o)+" i="+i+" o1="+Modchu_Main.objectToString(o1));
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	------------------- end. ");
		}
		return o1;
	}

	protected Object getCalculationData(List list) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	list="+list);
		}
		if (list != null
				&& list.size() > 1); else {
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	list.size error !! list.size()="+(list != null ? list.size() : 0));
				Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	------------------- end. error return.");
			}
			return null;
		}
		Object o1 = null;
		List list1 = new ArrayList();
		boolean firstCk = false;
		for (int i1 = 0; i1 < list.size(); i1++) {
			String s = Modchu_CastHelper.String(list.get(i1));
			Object o = i1 + 1 < list.size() ? list.get(i1 + 1) : null;
			boolean flag = false;
			if (s != null
					&& !s.isEmpty()); else continue;
			for (int i = 0; i < Modchu_TextCalculationFormula.calculationStringList.size(); i++) {
				String s2 = Modchu_TextCalculationFormula.calculationStringList.get(i);
				boolean flag1 = s.equals(s2);
				if (flag1) {
					if (!firstCk
							&& s.equals("-")) {
						if (i1 + 1 < list.size()) {
							s = s + Modchu_CastHelper.String(list.get(i1 + 1));
							flag1 = false;
						}
					}
				}
				if (flag1) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	s.equals s2="+s2);
					Object o2 = getCalculationData(s, o, i);
					if (o2 != null) list1.add(o2);
					flag = true;
					firstCk = true;
					i1++;
					break;
				} else {
					if (!firstCk) {
						String s3 = Modchu_CastHelper.String(o);
						if (s3 != null
								&& s3.equals(s2)) {
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	firstCk s3.equals s2="+s2+" s="+s);
							Object o2 = getCalculationData(null, s, -1);
							if (o2 != null) list1.add(o2);
							flag = true;
							firstCk = true;
							break;
						}
					}
				}
				if (flag) break;
			}
		}
		if (!list1.isEmpty()) o1 = list1;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	list="+list);
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	------------------- end.");
		}
		return o1;
	}
/*
	public Object runCalculation(Modchu_RunCalculationList runCalculationList, HashMap<String, Object>... map) {
		return runCalculation(runCalculationList, (byte) -1, map);
	}

	public Object runCalculation(Modchu_RunCalculationList runCalculationList, byte type, HashMap<String, Object>... map) {
		boolean debug = debugRun;
		if (debug) {
			//Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation ObjectDefault map[0]="+map[0]);

			//if (!Modchu_Main.isRelease()) {
				//if (!Modchu_CastHelper.Boolean(Modchu_Debug.getFreeVariable("debugRunCalculationInit"))) {
					//Modchu_Debug.setFreeVariable("debugRunCalculationInit", true);
					//Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	Modchu_Debug.setClipLog = true.");
				//}
			//}

			Object o = Modchu_Debug.getFreeVariable("debugRunCalculationDebugList");
			List debugList = o != null ? (LinkedList) o : new LinkedList();
			if (debugList != null
					&& !debugList.isEmpty()
					&& debugList.contains(runCalculationList)) {
				debug = false;
				Modchu_Debug.setClipLog = false;
			}
			else {
				debugList.add(runCalculationList);
				//Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	debugList.add list="+list);
				Modchu_Debug.setFreeVariable("debugRunCalculationDebugList", debugList);
				Modchu_Debug.setClipLog = true;
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	calculationListToString(list)="+calculationListToString(runCalculationList.getList()));
			debugCount = 1;
		}
		Modchu_RunTextCalculationData runData = new Modchu_RunTextCalculationData();
		runData.runCalculation(runCalculationList, type, map);
		if (debug) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	last end. runData.getData()="+Modchu_Main.objectToString(runData.getData()));
			if (!Modchu_Main.isRelease()) {
				Modchu_Debug.setClipboardLog();
			}
			//debugRun = false;
		}
		return runData.getData();
	}
*/
	public String calculationListToString(Modchu_RunCalculationList runCalculationList) {
		StringBuilder sb = new StringBuilder();
		boolean b = !runCalculationList.isIf();
		if (!b) sb.append("if(");
		sb.append(calculationListToString(runCalculationList, b));
		if (!b) sb.append(")").append(runCalculationList.isMultipleLines() ? "}" : ";");
		return sb.toString();
	}

	String calculationListToString(Modchu_RunCalculationList runCalculationList, boolean b) {
		boolean debug = debugSetting
				| debugCE;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationListToString	start.");
		List<Modchu_TextCalculationData> list = runCalculationList.getList();
		if (list != null
				&& !list.isEmpty()); else return null;
		StringBuilder sb = new StringBuilder();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationListToString	list="+list);
		for (Modchu_TextCalculationData data : list) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationListToString	data.getData()="+data.getData());
			sb.append(data.dataToString(b));
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationListToString	end. sb.toString()="+sb.toString());
		return sb.toString();
	}

	protected Modchu_RunCalculationList getTextConditionalExpressionList(String s) {
		boolean debug = debugCE;
		tempDebug = debug;
		if (debug) {
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipLog = true;
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	s="+s);
		}
		if (s != null); else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	s == null.");
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	------------------- 1 end.");
			return null;
		}
		if (!s.startsWith("if")) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	!s.startsWith(if)");
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	------------------- 2 end.");
			return null;
		}
		Modchu_TextFormatData data = Modchu_TextFormatManager.getTextFormatManagerData(s);
		List<String> stringList = data.getStringList(2);
		List<String> insideList = data.getStringList(3);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	stringList="+Modchu_Main.listToString(stringList));
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	insideList="+Modchu_Main.listToString(insideList));
		}
		if (conditionalExpressionMap != null); else conditionalExpressionMap = new HashMap();
		if (conditionalExpressionMap.containsKey(s)) return conditionalExpressionMap.get(s);
		List list = new LinkedList();
		Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(list);
		runCalculationList.setIsIf(true);
		runCalculationList.setIsMultipleLines(s.indexOf("{") > -1);
		if (insideList != null
				&& !insideList.isEmpty()) {
			setTextConditionalExpressionList_r(list, insideList);
		}
		if (debug) if (!Modchu_Main.isRelease()) Modchu_Debug.setClipboardLog();
		conditionalExpressionMap.put(s, runCalculationList);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	runCalculationList="+runCalculationList);
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	------------------- 3 end.");
		}
		return runCalculationList;
	}

	private void setTextConditionalExpressionList_r(List list, List list1) {
		boolean debug = debugCE;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r	------------------- start.");
		for (Object o : list1) {
			Modchu_TextCalculationData data = null;
			List list2 = new ArrayList();
			if (o instanceof List) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r	o instanceof List");
				setTextConditionalExpressionList_r_d(list2, (List) o);
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r	o instanceof List list2="+list2);
					Object o1 = list2.get(0);
					Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r	o instanceof List list2.get(0)="+o1);
					Object o2 = ((Modchu_TextCalculationData) o1).getData();
					Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r	o instanceof List list2.get(0).getData()="+o2);
					if (o2 instanceof Modchu_RunCalculationList) {
						List list3 = ((Modchu_RunCalculationList) o2).getList();
						Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r	o instanceof List list2.get(0).getData().getList()="+list3);
						Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) list3.get(0);
						Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r	o instanceof List list2.get(0).getData().getList().getData()="+data1.getData());
					}
					else if (o2 instanceof Modchu_TextCalculationData) {
						Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o2;
						Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r	o instanceof List list2.get(0).getData().getData()="+data1.getData());
					}
				}
				Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(list2);
				runCalculationList.setIsIf(true);
				data = new Modchu_TextCalculationData(runCalculationList);
				list.add(data);
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r	------------------- end.");
	}

	private void setTextConditionalExpressionList_r_d(List list, List list1) {
		boolean debug = debugCE;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	------------------- start.");
		int count = 0;
		Modchu_TextCalculationData tempData = null;
		Modchu_TextCalculationData tempData1 = null;
		List tempList = null;
		for (Object o : list1) {
			Modchu_TextCalculationData data = null;
			List list2 = new ArrayList();
			if (o instanceof List) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	o instanceof List");
				setTextConditionalExpressionList_r_d(list2, (List) o);
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	o instanceof List list2="+list2);
					Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	o instanceof List list2.get(0)="+list2.get(0));
					Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	o instanceof List list2.get(0).getData()="+((Modchu_TextCalculationData) list2.get(0)).getData());
				}
				if (count == 0) {
					Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(list2);
					runCalculationList.setIsIf(true);
					data = new Modchu_TextCalculationData(runCalculationList);
				}
			}
			else if (o instanceof String) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	o instanceof String");
				String s = (String) o;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	o instanceof String s="+s);
				switch(count) {
				case 0:
					tempData = new Modchu_TextCalculationData(Modchu_TextCalculation.instance.getTextCalculationList(s));
					break;
				case 1:
					tempData1 = new Modchu_TextCalculationData(new Modchu_TextCalculationFormulaConditionalExpression(s));
					break;
				case 2:
					data = tempData1;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	tempData1="+tempData1);
					List tempList1 = new ArrayList();
					tempList1.add(tempData);
					Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(tempList1);
					Modchu_RunCalculationList runCalculationList1 = Modchu_TextCalculation.instance.getTextCalculationList(s);
					tempList = new ArrayList();
					tempList.add(runCalculationList);
					tempList.add(runCalculationList1);
					if (debug) {
						Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	tempList1="+tempList1);
						Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	tempData.getData()="+tempData.getData());
						Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	runCalculationList.get(0).getData()="+runCalculationList.getList().get(0).getData());
					}
					data.setSubData(tempList);
					break;
				}
			}
			if (data != null) list.add(data);
			count++;
			if (count > 2) count = 0;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	setTextConditionalExpressionList_r_d	------------------- end.");
	}

	public Object runCalculation(Modchu_RunCalculationList runCalculationList, byte by, HashMap<String, Object>... map) {
		return runCalculation(null, runCalculationList, by, map);
	}

	public Object runCalculation(Object o, Modchu_RunCalculationList runCalculationList, byte by, HashMap<String, Object>... map) {
		boolean debug = (debugRun && !runCalculationList.isIf())
				| (debugCERun && runCalculationList.isIf());
		Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation runCalculationList.isIf()="+runCalculationList.isIf());
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
				debug = false;
				Modchu_Debug.setClipLog = false;
			}
			else {
				debugList.add(runCalculationList);
				//Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	debugList.add runCalculationList="+runCalculationList);
				Modchu_Debug.setFreeVariable("debugRunCalculationDebugList", debugList);
				Modchu_Debug.setClipLog = true;
			}
		}
		tempDebug = debug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	calculationListToString(runCalculationList)="+calculationListToString(runCalculationList));
			debugCount = 1;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation map[0]="+(map != null && map.length > 0 ? map[0] : null)+"\n");
		Object o2 = runCalculationList.runCalculation(o, by, map);
		if (debug) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation 	runCalculation	end. o2="+o2);
			if (!Modchu_Main.isRelease()) {
				Modchu_Debug.setClipboardLog();
			}
			//Modchu_TextCalculation.instance.debugRun = false;
		}
		return o2;
	}

}
