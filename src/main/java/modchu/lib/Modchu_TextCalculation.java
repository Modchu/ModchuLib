package modchu.lib;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Modchu_TextCalculation {
	public static Modchu_TextCalculation instance = new Modchu_TextCalculation();
	public HashMap<String, List> conditionalExpressionMap;
	public HashMap<String, List> calculationMap;
	public List<String> calculationStringList;
	public List<String> calculationTrigonometricFunctionStringList;
	protected final int maxLoop = 64;
	public boolean debugSetting = false;
	public boolean debugRun = false;
	public boolean debugCE = false;
	public boolean debugCERun = false;
	public int debugCount = 0;

	public Modchu_TextCalculation() {
		//debugSetting = !Modchu_Main.isRelease();
		debugRun = !Modchu_Main.isRelease();
		//debugCE = !Modchu_Main.isRelease();
		//debugCERun = !Modchu_Main.isRelease();
		//debugCERun = false;
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

	public List getTextCalculationList(String s) {
		return getTextCalculationList(s, true);
	}

	public List getTextCalculationList(String s, boolean b) {
		boolean debug = debugSetting;
		if (debug) {
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipLog = true;
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	s="+s);
			//if (s.equals("upperBody.rotateAngleX-")) {
				//Modchu_Main.setRuntimeException("upperBody.rotateAngleX-");
				//return null;
			//}
		}
		if (calculationMap != null); else calculationMap = new HashMap();
		if (calculationMap.containsKey(s)) return calculationMap.get(s);
		List list = new LinkedList();
		if (b
				&& !Modchu_Main.calculationCharacterStringCheck(s)) {
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	s="+s+" !calculationCharacterStringCheck return.");
				Modchu_Debug.mDebug("Modchu_TextCalculation	getTextCalculationList	------------------- end.");
			}
			return null;
		}
		List<String> tempList = new ArrayList();
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
		calculationMap.put(s, list);
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
		List<Object[]> list2 = getCalculationDataList(s);
		if (list2 != null
				&& !list2.isEmpty()) {
			list.add(list2);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r	list.add list2="+Modchu_Main.listToString(list2));
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
		boolean flag = settingCalculationData_r_s_TrigonometricFunction(list, list1, s);
		for (int i = 0; i < calculationStringList.size(); i++) {
			String tempS2 = calculationStringList.get(i);
			if (s.equals(tempS2)
					&& !list1.isEmpty()) {
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
		if (!flag) {
			Object o1 = Modchu_Main.stringToSuitableObject(s);
			if (o1 != null) list.add(new Object[]{ -1, o1 });
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
				if (o1 instanceof String) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	3 o1 instanceof String");
					s2 = "-"+(String) o1;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	4 o1 instanceof String s="+s+" s2="+s2);
					o3 = getCalculationData(s, s2);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	5 o1 instanceof String o3="+calculationObjectArrayToString(o3));
				}
				else if (o1 instanceof List) {
					// TODO
					ArrayList list2 = new ArrayList();
					ArrayList list3 = new ArrayList();
					list2.add("+");
					list3.add(o1);
					list3.add("*-1");
					list2.add(list3);
					o3 = getCalculationData(s, list2);

				} else {
					String ss = "Modchu_TextCalculation	settingCalculationData_r_s List List String String	!instanceof error !! o1="+o1+" o1="+(o1 != null ? o1.getClass() : null);
					if (debug) Modchu_Debug.mDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return;
				}
			} else {
				o3 = getCalculationData(s, s2);
			}
		}
		if (o3 != null) list.add(o3);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	settingCalculationData_r_s List List String String	o3="+o3);
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
				Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	list.size error !! list.size()="+(list != null ? list.size() : 0));
				Modchu_Debug.mDebug("Modchu_TextCalculation	getCalculationData List	------------------- end. error return.");
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

	public Object runCalculation(List list, HashMap<String, Object>... map) {
		boolean debug = debugRun;
		if (debug) {
/*
			if (!Modchu_Main.isRelease()) {
				if (!Modchu_CastHelper.Boolean(Modchu_Debug.getFreeVariable("debugRunCalculationInit"))) {
					Modchu_Debug.setFreeVariable("debugRunCalculationInit", true);
					//Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	Modchu_Debug.setClipLog = true.");
				}
			}
*/
			Object o = Modchu_Debug.getFreeVariable("debugRunCalculationDebugList");
			List debugList = o != null ? (LinkedList) o : new LinkedList();
			if (debugList != null
					&& !debugList.isEmpty()
					&& debugList.contains(list)) {
				debug = false;
				Modchu_Debug.setClipLog = false;
			}
			else {
				debugList.add(list);
				//Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	debugList.add list="+list);
				Modchu_Debug.setFreeVariable("debugRunCalculationDebugList", debugList);
				Modchu_Debug.setClipLog = true;
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	calculationListToString(list)="+calculationListToString(list));
			debugCount = 1;
		}
		Object o = runCalculation(null, list, map);
		if (debug) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runCalculation	last end. o="+Modchu_Main.objectToString(o));
			if (!Modchu_Main.isRelease()) {
				Modchu_Debug.setClipboardLog();
			}
			//debugRun = false;
		}
		return o;
	}

	public Object runCalculation(Object o, List list, HashMap<String, Object>... map) {
		boolean debug = debugRun;
		if (list != null
				&& !list.isEmpty()); else return null;
		for (int i = 0; i < list.size(); i++) {
			Object o1 = list.get(i);
			if (o1 instanceof List) {
				List list1 = (List) o1;
				if (debug) debugCount++;
				o = runCalculation(o, new Object[]{ -1, runCalculation(null, list1, map) }, map);
				if (debug) debugCount--;
			} else if (o1 instanceof Object[]) {
				Object[] o2= (Object[]) o1;
				o = runCalculation(o, o2, map);
			}
		}
		return o;
	}

	public Object runCalculation(Object o, Object[] o1, HashMap<String, Object>... map) {
		boolean debug = debugRun;
		if (o1 != null
				&& o1.length > 1); else return null;
		int i = Modchu_CastHelper.Int(o1[0]);
		Object o2 = o1[1];
		String debugString = null;
		if (debug) {
			StringBuilder sb = new StringBuilder().append("Modchu_TextCalculation	runCalculation	");
			for (int i1 = 0; i1 < debugCount; i1++) {
				sb.append("	");
			}
			debugString = sb.toString();
			Modchu_Debug.mDebug(debugString+"calculationObjectArrayToString(o1)="+calculationObjectArrayToString(o1));
		}
		Object o3 = null;
		if (o2 instanceof List) {
			List list = (List) o2;
			if (debug) {
				Modchu_Debug.mDebug(debugString+"o2 instanceof List start.-----------");
				Modchu_Debug.mDebug(debugString+"Modchu_Main.listToString(list)="+Modchu_Main.listToString(list));
				Modchu_Debug.mDebug(debugString+"calculationListToString(list)="+calculationListToString(list));
				debugCount++;
			}
			if (debug) Modchu_Debug.mDebug(debugString+"o2 instanceof List call. -----------");
			o3 = runCalculation(o, list, map);
			//Object o4 = runCalculation(null, list, map);
			if (debug) {
				//Modchu_Debug.mDebug(debugString+"o2 instanceof List o4="+Modchu_Main.objectToString(o4));
				Modchu_Debug.mDebug(debugString+"o2 instanceof List call end. -----------");
				debugCount--;
			}
			//o3 = runCalculation(o, new Object[]{ i, o4 }, map);
			if (debug) {
				Modchu_Debug.mDebug(debugString+"o2 instanceof List o3="+Modchu_Main.objectToString(o3));
				//Modchu_Debug.mDebug(debugString+"o2 instanceof List end. -----------");
			}
		}
		else if (o2 instanceof Object[]) {
			o3 = runCalculation(o, (Object[]) o2, map);
		}
		else if (o2 instanceof String) {
			String s = (String) o2;
			Object o4 = getMapsObject(s, map);
			if (o4 != null) {
				o3 = runCalculation(o, new Object[]{ i, o4 }, map);
				if (debug) {
					Modchu_Debug.mDebug(debugString+"o2 instanceof String. get o3="+Modchu_Main.objectToString(o3));
					Modchu_Debug.mDebug(debugString+"end. 1 o3="+Modchu_Main.objectToString(o3));
				}
				return o3;
			} else {
				o3 = getFieldOrMedhod(s, map);
			}
		} else {
			o3 = o2;
		}
		byte type = getCalculationObjectType(o != null ? o : o3);
		//if (debug) Modchu_Debug.mDebug(debugString+"type="+type);
		o3 = calculationObject(o, o3, type, i);
		if (debug) Modchu_Debug.mDebug(debugString+"end. 2 o3="+Modchu_Main.objectToString(o3));
		return o3;
	}

	private Object getMapsObject(String s, HashMap<String, Object>... map) {
		boolean flag = false;
		if (s != null
				&& !s.isEmpty()); else return null;
		boolean debug = debugRun;
		for (HashMap<String, Object> map1 : map) {
			if (map1.containsKey(s)) {
				Object o = map1.get(s);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	getMapsObject	get o="+Modchu_Main.objectToString(o));
				return o;
			} else {
				//if (debug) Modchu_Debug.mDebug(Modchu_TextCalculation	getMapsObject	!map1.containsKey s="+s);
			}
		}
		return null;
	}

	public Object getFieldOrMedhod(String s, HashMap<String, Object>... map) {
		boolean debug = debugRun;
		if (debug) Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod s="+s);
		String fieldOrMedhodName = null;
		String objectName = null;
		if (s.startsWith("[")) {
			int i1 = s.indexOf("]");
			if (i1 > -1) {
				objectName = s.substring(1, i1);
				s = s.length() > i1 + 1 ? s.substring(i1 + 1) : null;
			}
		}
		if (debug) Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod objectName="+objectName);
		Object[] o4 = Modchu_Main.getArrayIntAndString(s);
		if (debug) Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod o4="+Modchu_Main.objectArrayToString(o4));
		int i3 = -1;
		if (o4 != null
				&& o4.length > 1) {
			s = Modchu_CastHelper.String(o4[0]);
			i3 = Modchu_CastHelper.Int(o4[1]);
			if (debug) Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod ArrayIntAndString s="+s+" i3="+i3);
		}
		int i1 = s.indexOf(".");
		String[] s0 = i1 > -1 ? s.split("\\.") : new String[]{ s };
		if (debug) Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod s0="+s0);
		Object o = null;
		for (HashMap<String, Object> map1 : map) {
			if (map1.containsKey(s)) {
				o = map1.get(s);
			}
		}
		if (debug) Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod map1.get o="+o);
		if (o != null
				| (objectName != null
				&& objectName.equals("null"))); else {
			String temp = "ObjectDefault";
			for (HashMap<String, Object> map1 : map) {
				if (map1.containsKey(temp)) {
					o = map1.get(temp);
				}
			}
			if (debug) Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod ObjectDefault map1.get o="+o);
		}
		for (int i2 = 0; i2 < s0.length; i2++) {
			String s2 = s0[i2];
			//String s3 = (i2 + 1) < s0.length ? s0[i2 + 1] : null;
			int i4 = s2 != null ? s2.indexOf("(") : -1;
			int i5 = s2 != null ? s2.indexOf(")") : -1;
			Object[] o5 = null;
			if (i4 > -1
					&& i5 > -1) {
				String s5 = Modchu_Main.getInsideParentheses(s);
				s2 = s2.substring(0, i4);
				int i6 = s5.indexOf(",");
				if (i6 > -1) {
					String[] s6 = s5.split(",");
					o5 = new Object[s6.length];
					for (int i7 = 0; i7 < s6.length; i7++) {
						String s7 = s6[i7];
						o5[i7] = Modchu_Main.stringToSuitableObject(s7);
					}
				}
			}
			if (debug) {
				Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod getUnownReflection s2="+s2);
				Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod getUnownReflection o="+o);
				Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod getUnownReflection o5="+Modchu_Main.objectArrayToString(o5));
			}
			if (s2 != null
					&& o != null) {
				if (debug) Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod getUnownReflection o.getClass().getName()="+o.getClass().getName());
				o = Modchu_Reflect.getUnownReflection(o.getClass().getName(), s2, null, o, o5, -2);
			}
			if (i3 > -1
					&& o != null
					&& o.getClass().isArray()) {
				o = Array.get(o, i3);
				if (debug) Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod Array.get o="+o);
			}
		}
		if (debug) Modchu_Debug.mDebug("ModchuModel_CustomModel	getFieldOrMedhod end. o="+o);
		return o;
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
			break;
		case 1:
			f2 = f / f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" / "+f1+" = "+f2);
			break;
		case 2:
			f2 = f + f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" + "+f1+" = "+f2);
			break;
		case 3:
			f2 = f - f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" - "+f1+" = "+f2);
			break;
		case 4:
			f2 = f % f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" % "+f1+" = "+f2);
			break;
		case 100:
			float f3 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f1);
			f2 = f + f3;
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	cos("+f1+") = "+f3);
				Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" + cos("+f1+") = "+f2);
			}
			break;
		case 101:
			float f4 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f1);
			f2 = f + f4;
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	sin("+f1+") = "+f4);
				Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	"+f+" + sin("+f1+") = "+f2);
			}
			break;
		default :
			f2 = f + f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	default f2="+f2+" f="+f+" f1="+f1+" i="+i);
			break;
		}
		if (f2 == -0.0F) f2 = 0.0F;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	calculationFloat	end. return f2="+f2);
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
			return d + Modchu_AS.getFloat(Modchu_AS.mathHelperCos, (float)d1);
		case 101:
			return d + Modchu_AS.getFloat(Modchu_AS.mathHelperSin, (float)d1);
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

	public List getTextConditionalExpressionList(String s) {
		boolean debug = debugCE;
		if (debug) {
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipLog = true;
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	getTextConditionalExpressionList	s="+s);
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
		list.add(s);
		if (insideList != null
				&& !insideList.isEmpty()) {
			setTextConditionalExpressionList_r(list, insideList);
		}
		if (debug) if (!Modchu_Main.isRelease()) Modchu_Debug.setClipboardLog();
		conditionalExpressionMap.put(s, list);
		return list;
	}

	private void setTextConditionalExpressionList_r(List list, List list1) {
		int count = 0;
		for (Object o : list1) {
			if (o instanceof List) {
				List list2 = new LinkedList();
				setTextConditionalExpressionList_r(list2, (List) o);
				if (count == 0) {
					list.add(list2);
				} else {
					Object[] o1 = (Object[]) list.get(list.size() -1);
					o1[count] = list2;
					count++;
					if (count > 2) count = 0;
				}
			}
			else if (o instanceof String) {
				String s = (String) o;
				Object[] o1 = null;
				if (count == 0) {
					o1 = new Object[3];
				} else {
					o1 = (Object[]) list.get(list.size() -1);
				}
				if (count == 1) o = getExpressionCharacterInt(s);
				else o = Modchu_Main.stringToSuitableObject(s);
				o1[count] = o;
				if (count == 0) {
					list.add(o1);
				}
				count++;
				if (count > 2) count = 0;
			}
		}
	}

	private int getExpressionCharacterInt(String s) {
		int i = -1;
		if (s != null
				&& !s.isEmpty()); else return i; 
		String[] s0 = Modchu_Main.getConditionalExpressionCharacterStringArray();
		for (int i1 = 0; i1 < s0.length; i1++) {
			String s1 = s0[i1];
			if (s.equals(s1)) return i1;
		}
		return i;
	}

	public boolean runConditionalExpression(List list, HashMap<String, Object>... map) {
		boolean debug = debugCERun;
		if (debug) {
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipLog = true;
			Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression	start.");
			Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression	listToString(list)="+Modchu_Main.listToString(list));
		}
		boolean b = false;
		for (Object o : list) {
			if (o instanceof List) {
				b = runConditionalExpression((List) o, map);
			}
			else if (o instanceof Object[]) {
				b = runConditionalExpression((Object[]) o, map);
			}
			if (o instanceof String) continue;
			if (!b) break;
		}
		if (debug) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression	last end. b="+b);
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipLog = false;
			//debugRun = false;
		}
		return b;
	}

	public boolean runConditionalExpression(Object[] o, HashMap<String, Object>... map) {
		boolean debug = debugCERun;
		boolean b = false;
		Object o1 = o[0];
		int i = Modchu_CastHelper.Int(o[1]);
		Object o2 = o[2];
		for (int i1 = 0; i1 < 2; i1++) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression "+i1+" / 1");
			Object o3 = o[i1 == 0 ? 0 : 2];
			String s = o3 instanceof String ? (String) o3 : null;
			Object o4 = s != null
					&& !s.isEmpty() ? getMapsObject(s, map) : o3;
			if (o4 != null) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression o4="+Modchu_Main.objectToString(o4));
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression get stringToSuitableObject call ---------- start.");
				if (s != null
						&& !s.isEmpty()) {
					o4 = Modchu_Main.stringToSuitableObject(s);
					if (debug) {
						Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression get stringToSuitableObject call ---------- end.");
						Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression get stringToSuitableObject o4="+o4);
						Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression get stringToSuitableObject Modchu_Main.objectToString(o4)="+Modchu_Main.objectToString(o4));
					}
					if (o4 != null
							&& o4 instanceof String) {
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression get getFieldOrMedhod call ---------- start.");
						o4 = getFieldOrMedhod((String) o4, map);
						if (debug) {
							Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression get getFieldOrMedhod call ---------- end.");
							Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression get getFieldOrMedhod o4="+Modchu_Main.objectToString(o4));
						}
					}
				}
			}
			if (o4 != null) {
				if (i1 == 0) o1 = o4;
				if (i1 == 1) o2 = o4;
			}
		}
		if (i > -1
				&& o1 != null
				&& o2 != null); else {
			if (debug) {
				if (i < 0) Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression i < 0");
				if (o1 != null); else Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression o1 == null !!");
				if (o2 != null); else Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression o2 == null !!");
				Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression error return.");
			}
			return false;
		}
		switch (i) {
		case 0:
			// TODO
			//"==",
			return o1 == o2;
		case 1:
			//"||",
		case 2:
			//"|",
		case 3:
			//"&&",
			if (o1 instanceof Boolean
					&& o2 instanceof Boolean) {
				return i == 1
						| i == 2 ? (Boolean) o1
						| (Boolean) o2 :
							(Boolean) o1
							&& (Boolean) o2;
			} else {
				if (debug) {
					if (!(o1 instanceof Boolean)) Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression !o1 instanceof Boolean");
					if (!(o2 instanceof Boolean)) Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression !o2 instanceof Boolean");
				}
			}
		case 4:
			//"!=",
			return o1 != o2;
		case 5:
			//">=",
		case 6:
			//"<=",
		case 7:
			//"<",
		case 8:
			//">",
			if (o1 instanceof Integer
					&& o2 instanceof Integer) {
				return i == 5 ? (Integer) o1 >= (Integer) o2 :
					i == 6 ? (Integer) o1 <= (Integer) o2 :
						i == 7 ? (Integer) o1 < (Integer) o2 :
							(Integer) o1 > (Integer) o2;
			}
			else if (o1 instanceof Float
					&& o2 instanceof Float) {
				return i == 5 ? (Float) o1 >= (Float) o2 :
					i == 6 ? (Float) o1 <= (Float) o2 :
						i == 7 ? (Float) o1 < (Float) o2 :
							(Float) o1 > (Float) o2;
			}
			else if (o1 instanceof Double
					&& o2 instanceof Double) {
				return i == 5 ? (Double) o1 >= (Double) o2 :
					i == 6 ? (Double) o1 <= (Double) o2 :
						i == 7 ? (Double) o1 < (Double) o2 :
							(Double) o1 > (Double) o2;
			}
			else if (o1 instanceof Byte
					&& o2 instanceof Byte) {
				return i == 5 ? (Byte) o1 >= (Byte) o2 :
					i == 6 ? (Byte) o1 <= (Byte) o2 :
						i == 7 ? (Byte) o1 < (Byte) o2 :
							(Byte) o1 > (Byte) o2;
			}
			else if (o1 instanceof Long
					&& o2 instanceof Long) {
				return i == 5 ? (Long) o1 >= (Long) o2 :
					i == 6 ? (Long) o1 <= (Long) o2 :
						i == 7 ? (Long) o1 < (Long) o2 :
							(Long) o1 > (Long) o2;
			}
			else if (o1 instanceof Short
					&& o2 instanceof Short) {
				return i == 5 ? (Short) o1 >= (Short) o2 :
					i == 6 ? (Short) o1 <= (Short) o2 :
						i == 7 ? (Short) o1 < (Short) o2 :
							(Short) o1 > (Short) o2;
			}
			else if (o1 instanceof Float
					&& o2 instanceof Double) {
				return i == 5 ? (Float) o1 >= (Double) o2 :
					i == 6 ? (Float) o1 <= (Double) o2 :
						i == 7 ? (Float) o1 < (Double) o2 :
							(Float) o1 > (Double) o2;
			}
			else if (o1 instanceof Double
					&& o2 instanceof Float) {
				return i == 5 ? (Double) o1 >= (Float) o2 :
					i == 6 ? (Double) o1 <= (Float) o2 :
						i == 7 ? (Double) o1 < (Float) o2 :
							(Double) o1 > (Float) o2;
			}
			else if (o1 instanceof Integer
					&& o2 instanceof Float) {
				return i == 5 ? (Integer) o1 >= (Float) o2 :
					i == 6 ? (Integer) o1 <= (Float) o2 :
						i == 7 ? (Integer) o1 < (Float) o2 :
							(Integer) o1 > (Float) o2;
			}
			else if (o1 instanceof Float
					&& o2 instanceof Integer) {
				return i == 5 ? (Float) o1 >= (Integer) o2 :
					i == 6 ? (Float) o1 <= (Integer) o2 :
						i == 7 ? (Float) o1 < (Integer) o2 :
							(Float) o1 > (Integer) o2;
			}
			else if (o1 instanceof Double
					&& o2 instanceof Integer) {
				return i == 5 ? (Double) o1 >= (Integer) o2 :
					i == 6 ? (Double) o1 <= (Integer) o2 :
						i == 7 ? (Double) o1 < (Integer) o2 :
							(Double) o1 > (Integer) o2;
			}
			else if (o1 instanceof Integer
					&& o2 instanceof Double) {
				return i == 5 ? (Integer) o1 >= (Double) o2 :
					i == 6 ? (Integer) o1 <= (Double) o2 :
						i == 7 ? (Integer) o1 < (Double) o2 :
							(Integer) o1 > (Double) o2;
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation	runConditionalExpression else error return false !!");
		return b;
	}


}
