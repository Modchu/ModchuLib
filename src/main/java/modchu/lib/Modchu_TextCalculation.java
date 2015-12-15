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

	public Modchu_TextCalculation() {
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
				"cos@",
				"sin@"
		};
		calculationTrigonometricFunctionStringList = new ArrayList();
		for (String s2 : s3) {
			calculationTrigonometricFunctionStringList.add(s2);
		}
	}

	public ArrayList getTextCalculationList(String s) {
		boolean debug = true;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getTextCalculationList ------------------- start. s="+s);
		if (!Modchu_Main.calculationCharacterStringCheck(s)) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getTextCalculationList ------------------- end.  s="+s+" !calculationCharacterStringCheck return.");
			return null;
		}
		ArrayList list = new ArrayList();
		ArrayList<String> tempList = new ArrayList();
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation getTextCalculationList list="+Modchu_Main.listToString(list));
			Modchu_Debug.mDebug("Modchu_TextCalculation getTextCalculationList tempList.hashCode()="+tempList.hashCode()+ "tempList="+tempList);
		}
		tempList.add(s);
		for(int i = 0; i < maxLoop; i++) {
			settingTextCalculationList_r(list, tempList);
			if (tempList.isEmpty()) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getTextCalculationList tempList.isEmpty() break.");
				break;
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation getTextCalculationList calculationListToString(list)="+calculationListToString(list));
			Modchu_Debug.mDebug("Modchu_TextCalculation getTextCalculationList ------------------- end. list.size()="+list.size());
		}
		return list;
	}

	protected void settingTextCalculationList_r(List list, List<String> list1) {
		boolean debug = true;
		String s = list1.get(0);
		list1.remove(0);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r "+s+" ------------------- start.");
		if (Modchu_Main.calculationCharacterStringCheck(s)) {
			LinkedList<Object[]> list2 = getCalculationDataList(s);
			if (list2 != null
					&& !list2.isEmpty()) {
				list.add(list2);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r list.add list2="+list2);
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r "+s+" ------------------- end. list.size()="+list.size());
	}

	protected LinkedList<Object[]> getCalculationDataList(String s) {
		boolean debug = true;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataList "+s+" ------------------- start.");
		LinkedList<Object[]> list = new LinkedList();
		ArrayList<String> tempList = new ArrayList();
		ArrayList<String> tempList1 = new ArrayList();
		tempList1.add(s);
		for(int i = 0; i < maxLoop; i++) {
			settingCalculationParenthesis_r(tempList, tempList1);
			if (tempList1.isEmpty()) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataList tempList1.isEmpty() break.");
				break;
			}
		}
		if (tempList != null
				&& !tempList.isEmpty()) {
			for(int i = 0; i < maxLoop; i++) {
				settingCalculationData_r(list, tempList);
				if (tempList.isEmpty()) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataList tempList.isEmpty() break.");
					break;
				}
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataList ------------------- end. list.size()="+list.size());
		return list;
	}

	protected void settingCalculationData_r(List<Object[]> list, List<String> list1) {
		boolean debug = true;
		Object[] o = null;
		String s0 = null;
		String s = list1.get(0);
		list1.remove(0);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r "+s+" ------------------- start.");
		Object[] o0 = getCalculationDataStringArray(s);
		if (o0 != null
				&& o0.length > 5); else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r "+s+" ------------------- end. o0== null !! return");
			return;
		}
		int i = Modchu_CastHelper.Int(o0[0]);
		int i1 = Modchu_CastHelper.Int(o0[1]);
		int i2 = Modchu_CastHelper.Int(o0[2]);
		int i3 = Modchu_CastHelper.Int(o0[3]);
		String s1 = Modchu_CastHelper.String(o0[4]);
		s0 = s1 != null
				&& !s1.isEmpty() ? s1 : Modchu_CastHelper.String(o0[5]);
		String s2 = Modchu_CastHelper.String(o0[6]);
		String s3 = Modchu_CastHelper.String(o0[7]);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r 1 s0="+s0+" s2="+s2+" s3="+s3+" i1="+i1);
		Object o1 = getCalculationDataTrigonometricFunction(s0);
		if (o1 != null); else o1 = Modchu_Main.stringToSuitableObject(s0);
		int i4 = i == 1 ? 0 : i < 3 ? i1 + 1 : i == 3 ? 100 + (i1 - calculationStringList.size()) : 0;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r 2 i3="+i4+" i1="+i1+" i="+i);
		String s4 = i1 == 0 
				&& i3 < calculationStringList.size() ? s3 + s0 : s0;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r 3 s4="+s4);
		if (o1 != null) {
			o = new Object[]{ i4, o1, s4 };
		} else if (s != null
				&& !s.isEmpty()) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r 4 o1 == null. s="+s);
			o1 = Modchu_Main.stringToSuitableObject(s);
			if (o1 != null) {
				o = new Object[]{ -1, o1, s };
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r 5 o1 == null.");
			}
		}
		if (s2 != null
				&& !s2.isEmpty()) list1.add(s2);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r 6 s2="+s2);
		if (o != null
				&& o.length > 0) {
			list.add(o);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r list.add 5 o[0]="+(o != null && o.length > 0 ? o[0] : null)+" o[1]="+(o != null && o.length > 1 ? o[1] : null)+" o[1].getClass()="+(o != null && o.length > 1 ? o[1].getClass() : null)+" list="+Modchu_Main.listToString(list));
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationData_r "+s+" end. -------------------");
	}

	protected Object[] getCalculationDataStringArray(String s) {
		boolean debug = true;
		List<String> list = Modchu_Main.copyList(calculationStringList);
		list.addAll(calculationTrigonometricFunctionStringList);
		list.add(0, "(");
		Object[] o0 = Modchu_Main.getIndexOf(s, list);
		int i1 = -1;
		int i = -1;
		String s1 = null;
		if (o0 != null
				&& o0.length > 2) {
			i1 = Modchu_CastHelper.Int(o0[0]);
			i = Modchu_CastHelper.Int(o0[1]);
			s1 = Modchu_CastHelper.String(o0[2]);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 1 i="+i+" i1="+i1+" s1="+s1);
		if (i1 < 0) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 2 end. new Object[]{ 0, 0, "+s+", null, null, null}");
			return new Object[]{ 0, 0, -1, -1, s, (String)null, (String)null, (String)null };
		}
		String s2 = null;
		String s3 = null;
		String s4 = null;
		int i2 = -1;
		int i3 = -1;
		if (i != 0) {
			boolean flag = false;
			String s5 = s;
			String s6 = s1;
			if (i < calculationStringList.size()) {
				list.remove(0);
				int i4 = i1 + s1.length();
				String tempS = s.substring(i4);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 3-1 tempS="+tempS+" i="+i+" i1="+i1+" calculationStringList.size()="+calculationStringList.size());
				Object[] o1 = Modchu_Main.getIndexOf(tempS, list);
				String tempS2 = null;
				int i5 = -1;
				if (o1 != null
						&& o1.length > 2) {
					i2 = Modchu_CastHelper.Int(o1[0]);
					i5 = Modchu_CastHelper.Int(o1[1]);
					tempS2 = Modchu_CastHelper.String(o1[2]);
				}
				if (i5 < calculationStringList.size()) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 3-2 i5 < calculationStringList.size() i5="+i5+" s4="+s4);
					if (i2 > 0) {
						s2 = tempS.substring(0, i2);
						s4 = i1 == 0 ? tempS.substring(i2) : s.substring(i1);
						flag = true;
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 3-3 i1="+i1+" i2="+i2+" s2="+s2);
						i3 = 1;
					} else {
						s2 = i1 == 0 ? s.substring(s1.length()) : s.substring(0, i1);
						s4 = i1 == 0 ? i2 > -1 ? tempS.substring(i2) : null : s.substring(i1);
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 3-3 i2 <= 0. i1="+i1+" i2="+i2+" s2="+s2+" s4="+s4);
						i3 = 2;
					}
					flag = true;
				} else {
					s5 = tempS;
					s6 = tempS2;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 3-2 i5 >= calculationStringList.size() s5="+s5+" s6="+s6);
				}
				if (flag) {
					if (i1 > 0) s3 = s.substring(0, i1);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 3-3 s3="+s3);
				}
			}
			if (!flag) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 3-1 TrigonometricFunction i="+i);
				Object[] o2 = Modchu_Main.getInsideParenthesesData(s5, s6, "@");
				if (o2 != null
						&& o2.length > 2); else {
					String ss = "Modchu_TextCalculation getCalculationDataStringArray InsideParentheses o2 == null error !!";
					if (debug) Modchu_Debug.mDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return null;
				}
				s2 = Modchu_CastHelper.String(o2[0]);
				i2 = Modchu_CastHelper.Int(o2[2]);
				if (s2 != null
						&& !s2.isEmpty()); else {
					String ss = "Modchu_TextCalculation getCalculationDataStringArray InsideParentheses s2 == null error !!";
					if (debug) Modchu_Debug.mDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return null;
				}
				s2 = new StringBuilder().append(s6).append(s2).append("@").toString();
				s4 = i2 > 0 ? s5.substring(i2 + 1) : null;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 3-2 TrigonometricFunction s2="+s2+" s4="+s4);
				i3 = 3;
			}
		} else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 3-1 InsideParentheses i="+i);
			Object[] o2 = Modchu_Main.getInsideParenthesesData(s);
			if (o2 != null
					&& o2.length > 2) {
				s2 = Modchu_CastHelper.String(o2[0]);
				int i4 = Modchu_CastHelper.Int(o2[1]);
				int i5 = Modchu_CastHelper.Int(o2[2]);
				if (i4 > 0) s3 = s.substring(0, i4);
				if (i5 > -1) s4 = s.substring(i5 + 1);
			}
			i3 = 4;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 3-2 InsideParentheses s2="+s2+" s4="+s4);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataStringArray 4 end. new Object[]{"+i3+", "+i+", "+s3+", "+s2+", "+s4+", "+s1+"}");
		return new Object[]{ i3, i1, i2, i, s3, s2, s4, s1 };
	}

	protected boolean trigonometricFunctionCheck(String s) {
		boolean debug = true;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationDataTrigonometricFunctionCheck "+s+" ------------------- start.");
		String[] s3 = new String[]{
				"cos@",
				"sin@"
		};
		for (int i = 0; i < s3.length; i++) {
			String s4 = s3[i];
			int i1 = s.indexOf(s4);
			if (i1 > -1) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationDataTrigonometricFunctionCheck "+s+" ------------------- end. return true");
				return true;
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationDataTrigonometricFunctionCheck "+s+" ------------------- end. return false");
		return false;
	}

	protected String[] getTrigonometricFunctionStringArray(String s) {
		boolean debug = true;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getTrigonometricFunctionStringArray "+s+" ------------------- start.");
		if (s != null
				&& !s.isEmpty()); else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getTrigonometricFunctionStringArray "+s+" ------------------- end. 1 return null");
			return null;
		}
		String[] s3 = new String[]{
				"cos@",
				"sin@"
		};
		for (int i = 0; i < s3.length; i++) {
			String s4 = s3[i];
			int i1 = s.indexOf(s4);
			if (i1 > -1) {
				String[] s0 = new String[3];
				if (i1 > 0) s0[0] = s.substring(0, i1);
				int i2 = s.indexOf("@", i1 + s4.length());
				if (i2 > -1) {
					s0[1] = s.substring(i1, i2 + 1);
					if (i2 + 1 < s.length()) s0[2] = s.substring(i2 + 1);
				} else {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getTrigonometricFunctionStringArray i2 == -1 !!");
				}
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getTrigonometricFunctionStringArray "+s+" ------------------- end. s0[0]="+s0[0]+" s0[1]="+s0[1]+" s0[2]="+s0[2]);
				return s0;
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getTrigonometricFunctionStringArray "+s+" ------------------- end. 2 return null");
		return null;
	}

	protected Object[] getCalculationDataTrigonometricFunction(String s) {
		boolean debug = true;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataTrigonometricFunction "+s+" ------------------- start.");
		Object[] o = null;
		String[] s3 = new String[]{
				"cos@",
				"sin@"
		};
		for (int i = 0; i < s3.length; i++) {
			String s4 = s3[i];
			int i1 = s.indexOf(s4);
			if (i1 > -1) {
				String s5 = s4+"\\|";
				int i2 = s.indexOf(s5);
				if (i2 < 0) {
					int i3 = i1 + s4.length();
					int i4 = s.indexOf("@", i3);
					if (i4 > -1) {
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataTrigonometricFunction List i3="+i3+" i4="+i4);
						if (i4 - i3 < 0) {
							String ss = "Modchu_TextCalculation getCalculationDataTrigonometricFunction List index Error i3 - i4 < 0 s="+s+" s4="+s4;
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataTrigonometricFunction List error ss="+ss);
							Modchu_Main.setRuntimeException(ss);
							return null;
						}
						String s6 = s.substring(i3, i4);
						LinkedList<Object[]> list2 = new LinkedList();
						ArrayList<String> tempList2 = new ArrayList();
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataTrigonometricFunction List "+s6+" ------------------- start.");
						tempList2.add(s6);
						for(int i5 = 0; i5 < maxLoop; i5++) {
							settingCalculationData_r(list2, tempList2);
							if (tempList2.isEmpty()) {
								if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataTrigonometricFunction tempList2.isEmpty() break.");
								break;
							}
						}
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataTrigonometricFunction List "+s6+" ------------------- end.");
						int i6 = 100 + i;
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataTrigonometricFunction i6="+i6+" s6="+s6);
						o = new Object[]{ i6, list2, s4.replace("@", "(") + s6 + ")" };
/*
						String s7 = s.length() > i4 + 1 ? s.substring(i4 + 1) : null;
						if (s7 != null
								&& !s7.isEmpty()) {
							String s8 = "Modchu_TextCalculation getCalculationDataTrigonometricFunction error s7="+s7;
							if (debug) Modchu_Debug.mDebug(s8);
							Modchu_Main.setRuntimeException(s8);
						}
*/
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataTrigonometricFunction end.");
					}
				}
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation getCalculationDataTrigonometricFunction "+s+" ------------------- end. o[0]="+(o != null && o.length > 0 ? o[0] : null)+" o[1]="+(o != null && o.length > 1 ? o[1] : null)+" o[1].getClass()="+(o != null && o.length > 1 ? o[1].getClass() : null));
		return o;
	}

	protected void settingCalculationParenthesis_r(List<String> list, List<String> list1) {
		boolean debug = true;
		String s = list1.get(0);
		list1.remove(0);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationParenthesis_r "+s+" ------------------- start.");
		Object[] o = new Object[3];
		String[] s0 = new String[]{
				"cos(",
				"sin("
		};
		for (int i = 0; i < s0.length; i++) {
			String s1 = s0[i];
			int i1 = s.indexOf(s1);
			if (i1 > -1) {
				int i2 = s.indexOf(")");
				if (i2 > -1) {
					s = s.replace(s1, s1.substring(0, s1.length() - 1)+"@");
					s = s.substring(0, i2) + "@" + s.substring(i2 + 1);
					list1.add(s);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationParenthesis_r 1 list1.add s="+s);
					return;
				}
			}
		}
		int i1 = s.lastIndexOf("(");
		if (i1 > -1) {
			int i2 = i1 + 1;
			String s1 = s.substring(i2);
			int i3 = s1.indexOf(")");
			if (i3 > -1) {
				i2 += i3;
				s1 = s1.substring(0, i3);
				list.add(0, s1);
				String s3 = new StringBuilder().append(s.substring(0, i1)).append(s.substring(i2 + 1)).toString();
				list1.add(s3);
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationParenthesis_r 2 list.add s1="+s1);
					Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationParenthesis_r 2 list1.add s3="+s3);
				}
				return;
			}
		}
		list.add(s);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationParenthesis_r 3 list.add s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculation settingCalculationParenthesis_r "+s+" ------------------- end.");
		}
	}

	public Object runCalculation(List list, HashMap<String, Object> map) {
		boolean debug = true;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation runCalculation start.");
		return runCalculation(null, list, map);
	}

	public Object runCalculation(Object o, List list, HashMap<String, Object> map) {
		boolean debug = true;
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
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation runCalculation last end. o="+o);
		return o;
	}

	public Object runCalculation(Object o, Object[] o1, HashMap<String, Object> map) {
		boolean debug = true;
		if (o1 != null
				&& o1.length > 1); else return null;
		int i = Modchu_CastHelper.Int(o1[0]);
		Object o2 = o1[1];
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation runCalculation calculationObjectArrayToString(o1)="+calculationObjectArrayToString(o1));
		Object o3 = null;
		if (o2 instanceof List) {
			List list = (List) o2;
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculation runCalculation o2 instanceof List start.-----------");
				Modchu_Debug.mDebug("Modchu_TextCalculation runCalculation Modchu_Main.listToString(list)="+Modchu_Main.listToString(list));
				Modchu_Debug.mDebug("Modchu_TextCalculation runCalculation calculationListToString(list)="+calculationListToString(list));
			}
			o3 = runCalculation(list, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation runCalculation o2 instanceof List end. ----------- o3="+o3);
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
							&& (Float) o3 > 0.0F) Modchu_Debug.mDebug("Modchu_TextCalculation runCalculation o2 instanceof String. get argument o3="+o3);
				}
			} else {
				Modchu_Main.setRuntimeException("Modchu_TextCalculation runCalculation !map.containsKey("+s+") ERROR !!");
				return null;
			}
		} else {
			o3 = o2;
		}
		byte type = getCalculationObjectType(o != null ? o : o3);
		//if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation runCalculation type="+type);
		o3 = calculationObject(o, o3, type, i);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation runCalculation end. o3="+o3);
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
		boolean debug = true;
		int i3;
		switch(i2) {
		case 1:
			return i * i1;
		case 2:
			return i / i1;
		case 3:
			return i + i1;
		case 4:
			return i - i1;
		case 5:
			return i % i1;
		case 100:
			return i + Modchu_AS.getInt(Modchu_AS.mathHelperCos, i1);
		case 101:
			return i + Modchu_AS.getInt(Modchu_AS.mathHelperSin, i1);
		}
		i3 = i + i1;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationInt end. return i3="+i3+" i="+i+" i1="+i1+" i2="+i2);
		return i3;
	}

	protected float calculationFloat(float f, float f1, int i) {
		boolean debug = true;
		float f2;
		switch(i) {
		case 1:
			f2 = f * f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationFloat "+f+" * "+f1+" = "+f2);
			return f2;
		case 2:
			f2 = f / f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationFloat "+f+" / "+f1+" = "+f2);
			return f2;
		case 3:
			f2 = f + f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationFloat "+f+" + "+f1+" = "+f2);
			return f2;
		case 4:
			f2 = f - f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationFloat "+f+" - "+f1+" = "+f2);
			return f2;
		case 5:
			f2 = f % f1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationFloat "+f+" % "+f1+" = "+f2);
			return f2;
		case 100:
			float f3 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f1);
			f2 = f + f3;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationFloat "+f+" + cos("+f1+") = "+f2);
			return f2;
		case 101:
			float f4 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f1);
			f2 = f + f4;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationFloat "+f+" + sin("+f1+") = "+f2);
			return f2;
		}
		f2 = f + f1;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationFloat end. return f2="+f2+" f="+f+" f1="+f1+" i="+i);
		return f2;
	}

	protected double calculationDouble(double d, double d1, int i) {
		boolean debug = true;
		double d2;
		switch(i) {
		case 1:
			return d * d1;
		case 2:
			return d / d1;
		case 3:
			return d + d1;
		case 4:
			return d - d1;
		case 5:
			return d % d1;
		case 100:
			return d + Modchu_AS.getDouble(Modchu_AS.mathHelperCos, d1);
		case 101:
			return d + Modchu_AS.getDouble(Modchu_AS.mathHelperSin, d1);
		}
		d2 = d + d1;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationDouble end. return d2="+d2+" d="+d+" d1="+d1+" i="+i);
		return d2;
	}

	protected long calculationLong(long l, long l1, int i) {
		boolean debug = true;
		long l2;
		switch(i) {
		case 1:
			return l * l1;
		case 2:
			return l / l1;
		case 3:
			return l + l1;
		case 4:
			return l - l1;
		case 5:
			return l % l1;
		case 100:
			return l + Modchu_AS.getLong(Modchu_AS.mathHelperCos, l1);
		case 101:
			return l + Modchu_AS.getLong(Modchu_AS.mathHelperSin, l1);
		}
		l2 = l + l1;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationLong end. return l2="+l2+" l="+l+" l1="+l1+" i="+i);
		return l2;
	}

	public String calculationListToString(List list) {
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationListToString start.");
		if (list != null
				&& !list.isEmpty()); else return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			Object o = list.get(i);
			if (o instanceof List) {
				List<Object[]> list1 = (List<Object[]>) o;
				for (int i1 = 0; i1 < list1.size(); i1++) {
					Object[] o2 = list1.get(i1);
					sb.append(calculationObjectArrayToString(o2));
				}
			} else if (o instanceof Object[]) {
				Object[] o4= (Object[]) o;
				sb.append(calculationObjectArrayToString(o4));
			}
		}

		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationListToString end. sb.toString()="+sb.toString());
		return sb.toString();
	}

	public String calculationObjectArrayToString(Object[] o) {
		boolean debug = false;
		if (o != null
				&& o.length > 1); else return null;
		int i = Modchu_CastHelper.Int(o[0]);
		Object o2 = o[2];
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationObjectArrayToString i="+i+" o2="+o2);
		String s = null;
		if (o2 instanceof List) {
			List list = (List) o2;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationObjectArrayToString o2 instanceof List ----------- list="+Modchu_Main.listToString(list));
			s = calculationListToString(list);
		}
		else if (o2 instanceof String) {
			s = (String) o2;
			return s;
		} else {
			s = o2.toString();
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculation calculationObjectArrayToString end. s="+s);
		return s;
	}

/*
	public String getVariableMapString(String s) {
		if (s != null
				&& !s.isEmpty()); else return null;
		String[] s0 = new String[]{
				"f",
				"f1",
				"f2",
				"f3",
				"f4",
				"f5"
		};
		String[] s1 = new String[]{
				"Float",
				"Float1",
				"Float2",
				"Float3",
				"Float4",
				"Float5"
		};
		for (int i = 0; i < s0.length; i++) {
			String s2 = s0[i];
			if (s2.equals(s)) return s1[i];
		}
		return s;
	}
*/
}
