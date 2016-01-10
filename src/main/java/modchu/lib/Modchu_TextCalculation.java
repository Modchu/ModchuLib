package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Modchu_TextCalculation {
	public static Modchu_TextCalculation instance = new Modchu_TextCalculation();
	public List<String> calculationStringList;
	public List<String> calculationTrigonometricFunctionStringList;
	protected final int maxLoop = 64;
	public boolean debugSetting = false;
	public boolean debugRun = false;

	public Modchu_TextCalculation() {
		debugSetting = !Modchu_Main.isRelease();
		debugRun = !Modchu_Main.isRelease();
		String[] s1 = new String[]{
				"*",
				"/",
				"+",
				"-",
				"%"
		};
		calculationStringList = new ArrayList();
		for (String s : s1) {
			calculationStringList.add(s);
		}
		String[] s3 = new String[]{
				"cos",
				"sin"
		};
		calculationTrigonometricFunctionStringList = new ArrayList();
		for (String s2 : s3) {
			calculationTrigonometricFunctionStringList.add(s2);
		}
	}

	public ArrayList getTextCalculationList(String s) {
		boolean debug = debugSetting;
		if (debug) {
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipLog = true;
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	s="+s);
		}
		if (!Modchu_Main.calculationCharacterStringCheck(s)) {
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	s="+s+" !calculationCharacterStringCheck return.");
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	------------------- end.");
			}
			return null;
		}
		ArrayList list = new ArrayList();
		List<String> tempList = new ArrayList();
/*
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	list="+Modchu_Main.listToString(list));
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	tempList.hashCode()="+tempList.hashCode()+ "tempList="+tempList);
		}
*/
		tempList.add(s);
		for (int i = 0; i < maxLoop; i++) {
			settingTextCalculationList_r(list, tempList);
			if (tempList.isEmpty()) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	tempList.isEmpty() break.");
				break;
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	calculationListToString(list)="+calculationListToString(list));
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	list.size()="+list.size());
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	------------------- end.");
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipboardLog();
		}
		return list;
	}

	protected void settingTextCalculationList_r(List list, List<String> list1) {
		boolean debug = debugSetting;
		String s = list1.get(0);
		list1.remove(0);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	------------------ start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	s="+s);
		}
		if (Modchu_Main.calculationCharacterStringCheck(s)) {
			List<Object[]> list2 = getCalculationDataList(s);
			if (list2 != null
					&& !list2.isEmpty()) {
				list.add(list2);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	list.add list2="+Modchu_Main.listToString(list2));
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	"+s+" list.size()="+list.size());
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	------------------ end.");
		}
	}

	protected List<Object[]> getCalculationDataList(String s) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataList	----------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataList	s="+s);
		}
		List<Object[]> list = new LinkedList();
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
		for (String s1 : calculationTrigonometricFunctionStringList) {
			if (s.startsWith(s1)) {
				String s2 = s1 + "(";
				if (s.startsWith(s2)) {
					int i1 = s.indexOf(")");
					if (i1 > -1) {
						Object[] o = Modchu_Main.getInsideParenthesesData(s);
						int i2 = Modchu_CastHelper.Int(o[2]);
						String s3 = Modchu_CastHelper.String(o[0]);
						String s4 = s.substring(0, i2 + 1);
						String s5 = s.substring(i2 + 1);
						List tempList = new ArrayList();
						List<String> tempList1 = new ArrayList();
						tempList1.add(s3);
						if (debug) {
							Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	tempList1.add s3="+s3);
							Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	calculationDataStringList_r call start.");
						}
						for (int i = 0; i < maxLoop; i++) {
							calculationDataStringList_r(tempList, tempList1);
							if (tempList1.isEmpty()) {
								if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	tempList1.isEmpty() break.");
								break;
							}
						}
						Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	calculationDataStringList_r call end.");
						list.add(s1);
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list.add s1="+s1);
						list.add(tempList);
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list.add tempList="+tempList);
						list1.add(s5);
						if (debug) {
							Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list1.add s5="+s5);
							Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	s="+s);
							Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	---------------- end. 1");
						}
						return;
					}
				}
			}
		}
		List<String> list2 = Modchu_Main.copyList(calculationStringList);
		//list2.addAll(calculationTrigonometricFunctionStringList);
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
			String s4 = s.substring(i1, i1 + s1.length());
			String s5 = s.substring(i1 + s1.length());
			boolean flag = i == 0;
			List list3 = null;
			if (flag) {
				list3 = new ArrayList();
				List list4 = new ArrayList();
				Object[] o1 = Modchu_Main.getInsideParenthesesData(s);
				String s6 = Modchu_CastHelper.String(o1[0]);
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
					s5 = s.substring(i2 + 1);
					if (debug) {
						Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	InsideParentheses flag list3.add s6="+s6);
						Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	InsideParentheses flag s5="+s5+" s="+s+" i2="+i2);
					}
				}
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list.add s3="+s3+" s4="+s4+" s5="+s5);
				if (s3 != null
						&& !s3.isEmpty()) list.add(s3);
				if (s4 != null
						&& !s4.isEmpty()) list.add(s4);
			}
			if (s5 != null
					&& !s5.isEmpty()) list1.add(s5);
			if (flag) {
				if (!list1.isEmpty()) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	calculationDataStringList_r call ---- start.");
					calculationDataStringList_r(list3, list1);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	calculationDataStringList_r call ---- end.");
				} else {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list1.isEmpty()");
				}
			}
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	s="+s);
				Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	---------------- end. 2");
			}
			return;
		}
		if (s != null
				&& !s.isEmpty()) list.add(s);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	list.add s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDataStringList_r	---------------- end. 3");
		}
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
		settingCalculationData_r_s_TrigonometricFunction(list, list1, s);
		for (int i = 0; i < calculationStringList.size(); i++) {
			String tempS2 = calculationStringList.get(i);
			if (s.equals(tempS2)) {
				Object o1 = list1.get(0);
				list1.remove(0);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s	2 o1="+Modchu_Main.objectToString(o1));
				if (o1 instanceof String
						| o1 instanceof List); else {
					String ss = "Modchu_TextCalculation	settingCalculationData_r_s	!(o1 instanceof String) !(o1 instanceof List) error !! o1="+Modchu_Main.objectToString(o1)+" o1.getClass()="+(o1 !=null ? o1.getClass() : null);
					if (debug) Modchu_Debug.mDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return;
				}
				if (o1 instanceof List) {
					List tempList = new ArrayList();
					List tempList1 = (List) o1;
					for (int i1 = 0; i1 < maxLoop; i1++) {
						settingCalculationData_r(tempList, tempList1);
						if (tempList1.isEmpty()) {
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s	tempList1.isEmpty() break.");
							break;
						}
					}
					if (!tempList.isEmpty()) list.add(new Object[]{ i, tempList });
				} else {
					String s2 = (String) o1;
					settingCalculationData_r_s_s(list, list1, s, s2);
				}
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s	s="+s);
					Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s	--------------- end. 2");
				}
				return;
			}
		}
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
		Object[] o3 = null;
		if (settingCalculationData_r_s_TrigonometricFunction(list, list1, s2)) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	settingCalculationData_r_s_TrigonometricFunction s2="+s2);
			Object o4 = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			o3 = getCalculationData(s, o4);
		} else {
			if (s2.equals("-")) {
				Object o1 = list1.get(0);
				list1.remove(0);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	2 o1="+Modchu_Main.objectToString(o1));
				if (!(o1 instanceof String)) {
					String ss = "Modchu_TextCalculation	settingCalculationData_r_s List List String String	!(o1 instanceof String) error !!";
					if (debug) Modchu_Debug.mDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return;
				}
				s2 = "-"+(String) o1;
			}
			o3 = getCalculationData(s, s2);
		}
		if (o3 != null) list.add(o3);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	--------------- end. 3");
		}
	}

	protected boolean settingCalculationData_r_s_TrigonometricFunction(List list, List list1, String s) {
		boolean debug = debugSetting;
		for (String tempS : calculationTrigonometricFunctionStringList) {
			if (s.startsWith(tempS)) {
				Object o1 = list1.get(0);
				list1.remove(0);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_TrigonometricFunction	1 o1="+Modchu_Main.objectToString(o1));
				if (!(o1 instanceof List)
						&& !(o1 instanceof String)) {
					String ss = "Modchu_TextCalculation	settingCalculationData_r_s_TrigonometricFunction	!(o1 instanceof List) && !(o1 instanceof String) error !! o1="+Modchu_Main.objectToString(o1)+" o1.getClass()="+(o1 != null ? o1.getClass() : null);
					if (debug) Modchu_Debug.mDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return false;
				}
				Object[] o2 = null;
				if (o1 instanceof List) {
					List list2 =  (List) o1;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_TrigonometricFunction	o1 instanceof List list2="+list2);
					o2 = getCalculationDataTrigonometricFunction(s, list2);
				}
				if (o1 instanceof String) {
					String s1 = o1 instanceof String ? (String) o1 : null;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_TrigonometricFunction	o1 instanceof String error !! s1="+s1);
					//o2 = getCalculationDataTrigonometricFunction(s, s1);
				}
				boolean flag = false;
				if (o2 != null) {
					list.add(o2);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_TrigonometricFunction	list.add o2="+Modchu_Main.objectArrayToString(o2));
					flag = true;
				}
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_TrigonometricFunction	s="+s);
					Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s_TrigonometricFunction	--------------- end. 1");
				}
				return flag;
			}
		}
		return false;
	}

	protected boolean checkTrigonometricFunction(String s) {
		for (String s1 : calculationTrigonometricFunctionStringList) {
			if (s.startsWith(s1)) return true;
		}
		return false;
	}

	protected Object[] getCalculationDataTrigonometricFunction(String s, List list) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataTrigonometricFunction	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataTrigonometricFunction	s="+s);
		}
		Object[] o1 = null;
		for (int i = 0; i < calculationTrigonometricFunctionStringList.size(); i++) {
			String s1 = calculationTrigonometricFunctionStringList.get(i);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataTrigonometricFunction	s1="+s1);
			if (s.equals(s1)) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataTrigonometricFunction	getCalculationData call. "+list+" ------------------- start.");
				Object[] o2 = getCalculationData(list);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataTrigonometricFunction	getCalculationData call. "+list+" ------------------- end.");
				int i3 = 100 + i;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataTrigonometricFunction	i3="+i3);
				o1 = new Object[]{ i3, o2 };
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataTrigonometricFunction	s="+s+" "+Modchu_Main.objectArrayToString("o1", o1));
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationDataTrigonometricFunction	------------------- end.");
		}
		return o1;
	}

	protected Object[] getCalculationData(String s, Object o) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object	s="+s+" o="+Modchu_Main.objectToString(o));
		}
		Object[] o1 = null;
		for (int i = 0; i < calculationStringList.size(); i++) {
			String s2 = calculationStringList.get(i);
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

	protected Object[] getCalculationData(String s, Object o, int i) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	s="+s+" o="+Modchu_Main.objectToString(o)+" i="+i);
		}
		Object[] o1 = null;
		if (!(o instanceof List)
				&& !(o instanceof String)
				&& !(o instanceof Object[])) {
			String ss = "Modchu_TextCalculation	getCalculationData String Object int	!(o instanceof List) && !(o instanceof String) && !(o instanceof Object[]) error !! o="+Modchu_Main.objectToString(o)+" o.getClass()="+(o != null ? o.getClass() : null);
			if (debug) Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return null;
		}
		if (o instanceof List) {
			List list2 =  (List) o;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	o instanceof List list2="+list2);
			Object[] o4 = getCalculationData(list2);
			o1 = new Object[]{ i, o4 };
		}
		else if (o instanceof String) {
			String s1 = o instanceof String ? (String) o : null;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	o instanceof String s1="+s1);
			Object o2 = Modchu_Main.stringToSuitableObject(s1);
			o1 = new Object[]{ i, o2 };
		} else if (o instanceof Object[]) {
			o1 = new Object[]{ i, o };
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	s="+s+" o="+Modchu_Main.objectToString(o)+" i="+i+" "+Modchu_Main.objectArrayToString("o1", o1));
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData String Object int	------------------- end. ");
		}
		return o1;
	}

	protected Object[] getCalculationData(List list) {
		boolean debug = debugSetting;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	list="+list);
		}
		if (list != null
				&& list.size() > 1); else {
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	list.size error !!");
				Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	list="+list+" ------------------- end. error return.");
			}
			return null;
		}
		Object[] o1 = null;
		List list1 = new ArrayList();
		boolean firstCk = false;
		for (int i1 = 0; i1 < list.size(); i1++) {
			String s = Modchu_CastHelper.String(list.get(i1));
			Object o = i1 + 1 < list.size() ? list.get(i1 + 1) : null;
			boolean flag = false;
			if (s != null
					&& !s.isEmpty()); else continue;
			for (int i = 0; i < calculationStringList.size(); i++) {
				String s2 = calculationStringList.get(i);
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
					Object[] o2 = getCalculationData(s, o, i);
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
							Object[] o2 = getCalculationData(null, s, -1);
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
		if (!list1.isEmpty()) o1 = new Object[]{ -1, list1 };
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	list="+list);
			Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	------------------- end.");
		}
		return o1;
	}

	public Object runCalculation(List list, HashMap<String, Object> map) {
		boolean debug = debugRun;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	start.");
		Object o = runCalculation(null, list, map);
		if (debug) debugRun = false;
		return o;
	}

	public Object runCalculation(Object o, List list, HashMap<String, Object> map) {
		boolean debug = debugRun;
		if (list != null
				&& !list.isEmpty()); else return null;
		for (int i = 0; i < list.size(); i++) {
			Object o1 = list.get(i);
			if (o1 instanceof List) {
				List list1 = (List) o1;
				o = runCalculation(o, list1, map);
			} else if (o1 instanceof Object[]) {
				Object[] o2= (Object[]) o1;
				o = runCalculation(o, o2, map);
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	last end. o="+Modchu_Main.objectToString(o));
		return o;
	}

	public Object runCalculation(Object o, Object[] o1, HashMap<String, Object> map) {
		boolean debug = debugRun;
		if (o1 != null
				&& o1.length > 1); else return null;
		int i = Modchu_CastHelper.Int(o1[0]);
		Object o2 = o1[1];
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	calculationObjectArrayToString(o1)="+calculationObjectArrayToString(o1));
		Object o3 = null;
		if (o2 instanceof List) {
			List list = (List) o2;
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	o2 instanceof List start.-----------");
				Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	Modchu_Main.listToString(list)="+Modchu_Main.listToString(list));
				Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	calculationListToString(list)="+calculationListToString(list));
			}
			o3 = runCalculation(list, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	o2 instanceof List end. ----------- o3="+Modchu_Main.objectToString(o3));
		}
		else if (o2 instanceof Object[]) {
			o3 = runCalculation(o, (Object[]) o2, map);
		}
		else if (o2 instanceof String) {
			String s = (String) o2;
			if (map.containsKey(s)) {
				o3 = map.get(s);
				if (debug) {
					if (o3 instanceof Float
							&& (Float) o3 > 0.0F) Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	o2 instanceof String. get argument o3="+Modchu_Main.objectToString(o3));
				}
			} else {
				String ss = "Modchu_TextCalculation	runCalculation	!map.containsKey ERROR !! s="+s;
				Modchu_Debug.mDebug(ss);
				//Modchu_Main.setRuntimeException(ss);
				return null;
			}
		} else {
			o3 = o2;
		}
		byte type = getCalculationObjectType(o != null ? o : o3);
		//if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	type="+type);
		o3 = calculationObject(o, o3, type, i);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	end. o3="+Modchu_Main.objectToString(o3));
		return o3;
	}

	protected byte getCalculationObjectType(Object o) {
		return (byte) (o instanceof Integer ? 0 : o instanceof Float ? 1 : o instanceof Double ? 2 : o instanceof Long ? 3 : -1);
	}

	protected Object calculationObject(Object o, Object o1, int i) {
		return calculationObject(o, o1, getCalculationObjectType(o), i);
	}

	protected Object calculationObject(Object o, Object o1, byte type, int i) {
		switch(type) {
		case 0:
			return calculationInt(Modchu_CastHelper.Int(o, 0, false), o1 != null ? Modchu_CastHelper.Int(o1, 0, false) : 0, i);
		case 1:
			return calculationFloat(Modchu_CastHelper.Float(o, 0.0F, false), Modchu_CastHelper.Float(o1, 0.0F, false), i);
		case 2:
			return calculationDouble(Modchu_CastHelper.Double(o, 0.0D, false), Modchu_CastHelper.Double(o1, 0.0D, false), i);
		case 3:
			return calculationLong(Modchu_CastHelper.Long(o, 0L), Modchu_CastHelper.Long(o1, 0L), i);
		}
		return o;
	}

	protected int calculationInt(int i, int i1, int i2) {
		boolean debug = false;
		int i3;
		switch(i2) {
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
		case 100:
			return i + Modchu_AS.getInt(Modchu_AS.mathHelperCos, i1);
		case 101:
			return i + Modchu_AS.getInt(Modchu_AS.mathHelperSin, i1);
		}
		i3 = i + i1;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	calculationInt	i3="+i3+" i="+i+" i1="+i1+" i2="+i2);
			Modchu_Debug.mDebug("Modchu_TextCalculation	calculationInt	end.");
		}
		return i3;
	}

	protected float calculationFloat(float f, float f1, int i) {
		boolean debug = debugRun;
		float f2;
		switch(i) {
		case 0:
			f2 = f * f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" * "+f1+" = "+f2);
			return f2;
		case 1:
			f2 = f / f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" / "+f1+" = "+f2);
			return f2;
		case 2:
			f2 = f + f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" + "+f1+" = "+f2);
			return f2;
		case 3:
			f2 = f - f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" - "+f1+" = "+f2);
			return f2;
		case 4:
			f2 = f % f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" % "+f1+" = "+f2);
			return f2;
		case 100:
			float f3 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f1);
			f2 = f + f3;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" + cos("+f1+") = "+f2);
			return f2;
		case 101:
			float f4 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f1);
			f2 = f + f4;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" + sin("+f1+") = "+f2);
			return f2;
		}
		f2 = f + f1;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	end. return f2="+f2+" f="+f+" f1="+f1+" i="+i);
		return f2;
	}

	protected double calculationDouble(double d, double d1, int i) {
		boolean debug = false;
		double d2;
		switch(i) {
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
		case 100:
			return d + Modchu_AS.getDouble(Modchu_AS.mathHelperCos, d1);
		case 101:
			return d + Modchu_AS.getDouble(Modchu_AS.mathHelperSin, d1);
		}
		d2 = d + d1;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDouble	d2="+d2+" d="+d+" d1="+d1+" i="+i);
			Modchu_Debug.mDebug("Modchu_TextCalculation	calculationDouble	end.");
		}
		return d2;
	}

	protected long calculationLong(long l, long l1, int i) {
		boolean debug = false;
		long l2;
		switch(i) {
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
		case 100:
			return l + Modchu_AS.getLong(Modchu_AS.mathHelperCos, l1);
		case 101:
			return l + Modchu_AS.getLong(Modchu_AS.mathHelperSin, l1);
		}
		l2 = l + l1;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	calculationLong	l2="+l2+" l="+l+" l1="+l1+" i="+i);
			Modchu_Debug.mDebug("Modchu_TextCalculation	calculationLong	end.");
		}
		return l2;
	}

	public String calculationListToString(List list) {
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationListToString	start.");
		if (list != null
				&& !list.isEmpty()); else return null;
		StringBuilder sb = new StringBuilder();
		for (Object o : list) {
			if (o instanceof List) {
				List list1 = (List) o;
				sb.append(calculationListToString(list1));
			} else if (o instanceof Object[]) {
				Object[] o4= (Object[]) o;
				sb.append(calculationObjectArrayToString(o4));
			}
		}

		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationListToString	end. sb.toString()="+sb.toString());
		return sb.toString();
	}

	public String calculationObjectArrayToString(Object[] o) {
		boolean debug = false;
		if (o != null
				&& o.length > 1); else return null;
		int i = Modchu_CastHelper.Int(o[0]);
		Object o2 = o[1];
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationObjectArrayToString	i="+i+" o2="+Modchu_Main.objectToString(o2));
		String s = null;
		StringBuilder sd = new StringBuilder();
		switch(i) {
		case 0:
			sd.append("*");
			break;
		case 1:
			sd.append("/");
			break;
		case 2:
			sd.append("+");
			break;
		case 3:
			sd.append("-");
			break;
		case 4:
			sd.append("%");
			break;
		case 100:
			sd.append("cos");
			break;
		case 101:
			sd.append("sin");
			break;
		}
		if (o2 instanceof Object[]) {
			sd.append(calculationObjectArrayToString((Object[]) o2));
		}
		else if (o2 instanceof List) {
			List list = (List) o2;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationObjectArrayToString	o2 instanceof List ----------- list="+Modchu_Main.listToString(list));
			sd.append("(").append(calculationListToString(list)).append(")");
		}
		else sd.append(Modchu_Main.objectToString(o2));
		s = sd.toString();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationObjectArrayToString	end. s="+s);
		return s;
	}

}
