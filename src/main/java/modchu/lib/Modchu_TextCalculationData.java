package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Modchu_TextCalculationData implements Modchu_ITextCalculationDataFormat {
	private static List<String> variableTypeStringList;
	private static final byte isRaw = 0;
	private static final byte isFixedValue = 1;
	private static final byte isVariable = 2;
	private static final byte isObjectArray = 3;
	private static final byte isCalculation = 4;
	public final Object initObject;
	private Object data;
	private List subData;
	private Modchu_TextCalculationData nextData;
	private boolean isTempRaw = false;
	boolean initFlag = false;
	private byte type = -1;
	private int maxSubDataListSize = 0;
	private int variableType = 0;
	private String variableString;
	private Object tempRawData;
	private Modchu_ReflectData reflectData;

	static {
		if (variableTypeStringList != null); else {
			variableTypeStringList = new ArrayList();
			variableTypeStringList.addAll(Modchu_Main.stringArrayToArrayList(new String[]{
					"float",
					"double",
					"int",
					"long",
					"byte",
					"short"
			}));
		}
	}

	public Modchu_TextCalculationData(Object o) {
		initObject = o;
		data = o;
	}

	protected void init(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (initFlag) return;
		initFlag = true;
		String s = null;
		s = init_GetDataString();
		if (s != null
				&& !s.isEmpty()); else return;
		if (s.indexOf(" ") > -1) s = replaceAllExceptInDoubleQuotation(s, " ", "");
		if (s.indexOf("\t") > -1) s = replaceAllExceptInDoubleQuotation(s, "\t", "");
		if (s.startsWith(",")) {
			s = s.substring(1);
		}
		setData(s);
		Object data1 = getData();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init initObject="+initObject+" s="+s+" this="+this);
		Object subData = getSubData();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init subData="+subData);
		if (s != null
				&& !s.isEmpty()) {
			if (init_AddCalculationStringBrackets(Modchu_TextCalculationFormula.priorityCalculationStringList, s, map)) return;
			data1 = getData();
			s = init_GetDataString();
			if (init_brackets(s, map)) return;
			if (init_Reflect(s, map)) return;
			if (init_ArrayString(s, map)) return;
			if (init_CalculationString(Modchu_TextCalculationFormula.calculationOperatorStringList, s, map)) return;
			data1 = getData();
			s = init_GetDataString();
			if (init_CalculationTrigonometricFunctionString(s, map)) return;
			if (init_StringPeriod(s, map)) return;
			data1 = getData();
			s = init_GetDataString();
			if (init_StringPeriodAfter(s, map)) return;
			data1 = getData();
			s = init_GetDataString();
			if (init_VariableTypeStringList(s, map)) return;
			if (init_VariableStringList(s, map)) return;
			if (init_VariableStringListAfter(s, true, map)) return;
			data1 = getData();
			s = init_GetDataString();
			if (init_StringComma(s, map)) return;
			if (init_CalculationString(Modchu_TextCalculationFormula.calculationStringList, s, map)) return;
			data1 = getData();
			s = init_GetDataString();
			if (init_bracketsAfter(s, map)) return;
			data1 = getData();
			s = init_GetDataString();
		}
		if (s != null
				&& s.indexOf(",") > -1) {
			String ss = "Modchu_TextCalculationData init 1 s.indexOf(,) > -1 error !! s="+s+" isRaw()="+isRaw()+" getSubData()="+getSubData();
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		if (subData != null
				&& subData instanceof List); else {
			//if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init else return. subData="+subData);
			//return;
			if (subData instanceof Modchu_RunCalculationList) {
				subData = ((Modchu_RunCalculationList) subData).getList();
			} else {
				subData = new LinkedList();
			}
		}
		List list1 = new LinkedList();
		List list2 = (List) subData;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init subData list2="+list2);
		if (list2 != null
				&& !list2.isEmpty()) {
			List list3 = new ArrayList();
			init_List(list3, list2, map);
			if (list3 != null
					&& !list3.isEmpty()) {
				list2 = list3;
				setSubData(list2);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init setSubData list2="+list2);
			} else {
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData init list3="+list3);
					String ss = "Modchu_TextCalculationData init list3 == null !!";
					Modchu_Debug.mDebug(ss);
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
				}
				return;
			}
		}
		if (list1 != null) {
			if (list2 != null) list1.addAll(list2);
			if (!list1.isEmpty()) {
				setSubData(list1);
			}
		}
		//checkRawAndFixedValue(list1);
		data1 = getData();
		if (data1 instanceof String) {
			s = (String) data1;
			s = s.replaceAll("\"", "");
			if (s.indexOf(" ") > -1) s = replaceAllExceptInDoubleQuotation(s, " ", "");
			if (s.indexOf("\t") > -1) s = replaceAllExceptInDoubleQuotation(s, "\t", "");
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init end. data1 instanceof String s="+s);
		} else if (data1 instanceof Modchu_TextCalculationFormula) {
			Modchu_TextCalculationFormula formula = (Modchu_TextCalculationFormula) data1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init end. data1 instanceof Modchu_TextCalculationFormula formula.getDataString()="+formula.getDataString());
			formula.setInitFlag(false);
		}
		if (s == null
				| (s != null
				&& s.isEmpty())) {
			String ss = "Modchu_TextCalculationData init s == null | s.isEmpty() error !! initObject="+initObject;
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
		}
		setData(s);
/*
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData init isRaw()="+isRaw());
			Modchu_TextCalculation.instance.debugData("Modchu_TextCalculationData init end1. ", "data", getData());
			Modchu_TextCalculation.instance.debugData("Modchu_TextCalculationData init end2. ", "subData", getSubData());
		}
*/
	}

	protected boolean init_AddCalculationStringBrackets(List<String> list, String s, Map... map) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets	---------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets	s="+s);
		}
		if (s != null
				&& !s.isEmpty()); else return false;
		s = init_AddCalculationStringBrackets_r(list, s, 0, map);
		setData(s);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets	setData s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets	---------------- end.");
		}
		return false;
	}

	protected String init_AddCalculationStringBrackets_r(List<String> list, String s, int count, Map... map) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	---------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	1 s="+s);
		}
		boolean b = false;
		//String temp = null;
		//String temp1 = null;
		boolean flag1 = false;
		//int tempCount = 0;
		while (true) {
			for (String s2 : list) {
				int i1 = s.indexOf(s2, count);
				int i2 = s.indexOf("=");
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	s="+s+"に"+s2+"はあるのか？ i1="+i1+" count="+count);
				//if (tempCount < i1) tempCount = i1;
				if (i1 > -1
						&& i2 != (i1 + 1)) {
					String s3 = s.substring(0, i1);
					String s4 = s.substring(i1);
					//temp = s.substring(0, i1 + 1);
					//temp1 = s.substring(i1 + 1);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r 2 s3="+s3+" s4="+s4);
					boolean flag = false;
					Object[] oo = ckeckPriorityCalculationSeparator(s3);
					flag = (Boolean) oo[0];
					int i4 = (Integer) oo[1];
					if (flag) {
						String s6 = s3.substring(0, i4);
						String s7 = s3.substring(i4, i4 + 1);
						String s8 = s3.substring(i4 + 1);
						String s9 = s3.length() > (i4 + 2) ? s3.substring(i4 + 1, i4 + 2) : null;
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r 3 s6="+s6+" s7="+s7+" s8="+s8+" s9="+s9);
						if (!s7.equals("(")
								&& !s7.equals("*")
								&& !s7.equals("/")
								&& (s9 != null
								&& !s9.equals("(")
								&& !s9.equals("*")
								&& !s9.equals("/")
								| s9 == null)) {
							boolean flag2 = false;
							String s14 = null;
							for (int i5 = 0; i5 < Modchu_TextCalculationFormula.priorityCalculationSeparatorAfterList.size(); i5++) {
								String s10 = Modchu_TextCalculationFormula.priorityCalculationSeparatorAfterList.get(i5);
								int i6 = s4.indexOf(s10);
								if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	s4="+s4+"に"+s10+"はあるのか？ i6="+i6);
								if (i6 > -1) {
									String s11 = s4.substring(0, i6);
									String s12 = s4.substring(i6, i6 + s10.length());
									String s13 = s4.substring(i6 + s10.length());
									if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r 4 s11="+s11+" s12="+s12+" s13="+s13);
									s14 = s6 + s7 + "(" + s8 + s11 + ")" + s12 + s13;
									flag2 = true;
								}
							}
							if (!flag2) {
								s14 = s6 + s7 + "(" + s8 + s4 + ")";
							}
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r 5 ()追加処理 s14="+s14);
							s = s14;
							b = true;
							break;
						}
					}
				}
			}
			flag1 = false;
			for (String s2 : list) {
				int i1 = s.indexOf(s2, count + 1);
				if (i1 > -1
						&& i1 > (count + 1)) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	count="+count);
					count = i1 + 1;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	から count="+count+" セット");
					flag1 = true;
					break;
				}
			}
			if (!flag1) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	break 1 b="+b+" flag1="+flag1);
				break;
			}
		}
		if (b) {
			s = init_AddCalculationStringBrackets_r(list, s, count, map);
		}
/*
		if (temp != null
				&& !temp.isEmpty()
				&& temp1 != null
				&& !temp1.isEmpty()) {
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	6 temp="+temp);
				Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	7 temp1="+temp1);
			}
			temp1 = init_AddCalculationStringBrackets_r(list, temp1, count, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	8 s=[  "+temp+"  ]+[  "+temp1+"  ]");
			s = temp + temp1;
		}
*/
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	9 s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_AddCalculationStringBrackets_r	---------------- end.");
		}
		return s;
	}

	protected Object[] ckeckPriorityCalculationSeparator(String s) {
		boolean b = false;
		int i = -1;
		int flagCount = 0;
		for (int i1 = s.length() - 1; i1 > -1; i1--) {
			String s1 = s.substring(i1, i1 + 1);
			if (flagCount > 0
					&& s1.equals("(")) {
				flagCount--;
				continue;
			}
			else if (s1.equals(")")) {
				flagCount++;
				continue;
			}
			if (flagCount > 0) continue;
			for (int i3 = 0; i3 < Modchu_TextCalculationFormula.priorityCalculationSeparatorList.size(); i3++) {
				String s5 = Modchu_TextCalculationFormula.priorityCalculationSeparatorList.get(i3);
				if (s1.equals(s5)) {
					i = i1;
					b = true;
				}
			}
		}
		return new Object[]{ b, i };
	}

	protected boolean init_brackets(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_brackets	---------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_brackets	s="+s);
		}
		if (s != null
				&& !s.isEmpty()); else return false;
		boolean b = false;
		int i1 = s.indexOf("(");
		int i2 = s.indexOf(")");
		if (i1 == 0
				&& i2 > -1); else {
			if ((i1 > -1
					&& i2 < 0)
					| (i1 < 0
							&& i2 > -1)) {
				String ss = "Modchu_TextCalculationData init_brackets error !! s="+s;
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
				return true;
			}
			return false;
		}
		Object[] o1 = Modchu_Main.getInsideParenthesesData(s);
		String s2 = Modchu_CastHelper.String(o1[0]);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_brackets	s2="+s2);
		if (s2 != null
				&& !s2.isEmpty()); else return false;
		int i3 = Modchu_CastHelper.Int(o1[2]);
		String s3 = s.substring(i3 + 1);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_brackets	s3="+s3);
		Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(s2);
		runCalculationList.setOneValue(true);
		setData(runCalculationList);
		b = true;
		if (s3 != null
				&& !s3.isEmpty()) {
			Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s3);
			setNextData(data1);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_brackets	---------------- end.");
		return b;
	}

	protected boolean init_bracketsAfter(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_bracketsAfter	---------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_bracketsAfter	1 s="+s);
		}
		if (s != null
				&& !s.isEmpty()); else return false;
		boolean b = false;
		int i1 = s.indexOf("(");
		int i2 = s.indexOf(")");
		if (i1 > 0
				&& i2 > -1); else {
			if ((i1 > -1
					&& i2 < 0)
					| (i1 < 0
							&& i2 > -1)) {
				String ss = "Modchu_TextCalculationData init_bracketsAfter error !! s="+s;
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
				return true;
			}
			return false;
		}
		Object[] o1 = Modchu_Main.getInsideParenthesesData(s);
		String s2 = Modchu_CastHelper.String(o1[0]);
		int i3 = Modchu_CastHelper.Int(o1[2]);
		String s3 = s.length() > (i3 + 1) ? s.substring(i3 + 1) : null;
		s = s.substring(0, Modchu_CastHelper.Int(o1[1]) - 1);
		setData(s);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_bracketsAfter	2 s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_bracketsAfter	s2="+s2);
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_bracketsAfter	s3="+s3);
		}
		Modchu_TextCalculationData nextData1 = null;
		Modchu_RunCalculationList runCalculationList = null;
		if (s2 != null
				&& !s2.isEmpty()) {
			runCalculationList = new Modchu_RunCalculationList(s2);
			runCalculationList.setOneValue(true);
		}
		nextData1 = new Modchu_TextCalculationData(s2 != null
				&& !s2.isEmpty() ? runCalculationList : "null");
		setNextData(nextData1);
		if (s3 != null
				&& !s3.isEmpty()) {
			Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s3);
			nextData1.setNextData(data1);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_bracketsAfter	---------------- end.");
		return b;
	}

	protected boolean init_ArrayString(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (s != null
				&& !s.isEmpty()); else return false;
		if (s.startsWith("newClass[]")
				| s.startsWith("newObject[]")) {
			String s1 = null;
			int i1 = s.indexOf("{");
			int i2 = s.indexOf("}");
			if (i1 > -1
					&& i2 > -1); else return false;
			int i3 = s.indexOf("newClass[]");
			if (i3 > -1) {
				s1 = "newClass[]";
			} else {
				s1 = "newObject[]";
			}
			setData(s1);
			String s2 = s.substring(i1 + 1, i2);
			List list = new LinkedList();
			if (s2.indexOf(",") > -1) {
				String[] s0 = s2.split("\\,");
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ArrayString s0="+s0+" s0.length="+s0.length);
				for (String s3 : s0) {
					list.add(new Modchu_TextCalculationData(s3));
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ArrayString s3="+s3);
				}
			} else {
				list.add(new Modchu_TextCalculationData(s2));
			}
			//init_ObjectArray(list, map);
			setSubData(list);
			setObjectArray(true);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ArrayString setSubData s2="+s2);
			return true;
		}
		return false;
	}

	protected String init_GetDataString() {
		Object data1 = getData();
		if (data1 instanceof String) {
			return (String) data1;
		}
		return null;
	}

	protected boolean init_VariableStringList(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_VariableStringList	---------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_VariableStringList s="+s);
		}
		if (s != null
				&& !s.isEmpty()); else return false;
		for (String s0 : Modchu_TextCalculationFormula.variableStringList) {
			if (s.startsWith(s0)) {
				setVariable(true);
				setData(Modchu_TextCalculationFormula.calculationFormulaMap.get(s0));
				String s2 = s.substring(s0.length());
				Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(new Modchu_RunCalculationList(s2));
				setNextData(data1);
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData init_VariableStringList Modchu_TextCalculationData s2="+s2);
					Modchu_Debug.mDebug("Modchu_TextCalculationData init_VariableStringList	1 ---------------- end.");
				}
				return true;
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_VariableStringList else s0="+s0);
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_VariableStringList	2 ---------------- end.");
		return false;
	}

	protected boolean init_VariableStringListAfter(String s, boolean isCheck, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (s != null
				&& !s.isEmpty()); else return false;
		for (String s0 : Modchu_TextCalculationFormula.variableStringList) {
			int i2 = s.indexOf(s0);
			if (i2 > -1) {
				String s1 = s.substring(0, i2);
				setData(s1);
				String s2 = s.substring(i2);
				Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s2);
				setNextData(data1);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_VariableStringListAfter setNextData Modchu_TextCalculationData s2="+s2);
				return false;
			}
		}
		return false;
	}

	protected boolean init_VariableTypeStringList(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (s != null
				&& !s.isEmpty()); else return false;
		for (String s0 : variableTypeStringList) {
			if (s.startsWith(s0)) {
				setVariableType(variableTypeStringList.indexOf(s0));
				String s1 = s.substring(s0.length());
				for (String s2 : Modchu_TextCalculationFormula.variableStringList) {
					int i1 = s1.indexOf(s2);
					if (i1 > -1) {
						String s3 = s1.substring(0, i1);
						setVariableString(s3);
						setData(s3);
						String s4 = s1.substring(i1);
						Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s4);
						setNextData(data1);
						if (debug) {
							Modchu_Debug.mDebug("Modchu_TextCalculationData init_VariableTypeStringList s1="+s1);
							Modchu_Debug.mDebug("Modchu_TextCalculationData init_VariableTypeStringList s3="+s3);
							Modchu_Debug.mDebug("Modchu_TextCalculationData init_VariableTypeStringList s4="+s4);
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	protected boolean init_CalculationString(List<String> list, String s, Map... map) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationString ------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationString start s="+s);
		}
		if (s != null
				&& !s.isEmpty()); else return false;
		boolean b = false;
		for (int i = 0; i < list.size(); i++) {
			String s2 = list.get(i);
			if (s.startsWith(s2)) {
				String s3 = s.substring(s2.length());
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationString 1 s2="+s2+" s3="+s3);
				setData(Modchu_TextCalculationFormula.calculationFormulaMap.get(s2));
				Modchu_TextCalculationData nextData1 = getNextData();
				if (s3 != null
						&& !s3.isEmpty()) {
					Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s3);
					if (nextData1 != null) {
						data1.setNextData(nextData1);
					}
					setNextData(data1);
				}
				type = isCalculation;
				b = true;
				break;
			}
		}
		if (!b) {
			int i3 = s.indexOf("(");
			for (int i = 0; i < list.size(); i++) {
				String s2 = list.get(i);
				int i2 = s.indexOf(s2);
				if (i2 > -1
						&& (i3 < 0
								| (i3 > -1
								&& i2 < i3))) {
					String s3 = s.substring(0, i2);
					String s4 = s.substring(i2);
					if (debug) {
						Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationString 2 s3="+s3);
						Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationString 3 s4="+s4);
					}
					setData(s3);
					if (s4 != null
							&& !s4.isEmpty()) {
						Modchu_TextCalculationData nextData1 = getNextData();
						Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s4);
						if (nextData1 != null) {
							data1.setNextData(nextData1);
						}
						setNextData(data1);
					}
					b = true;
					break;
				}
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationString end s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationString return b="+b);
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationString ------------------- end.");
		}
		return b;
	}

	protected boolean init_CalculationTrigonometricFunctionString(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationTrigonometricFunctionString ------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationTrigonometricFunctionString start s="+s);
		}
		if (s != null
				&& !s.isEmpty()); else return false;
		boolean b = false;
		for (int i = 0; i < Modchu_TextCalculationFormula.calculationTrigonometricFunctionStringList.size(); i++) {
			String s2 = Modchu_TextCalculationFormula.calculationTrigonometricFunctionStringList.get(i);
			if (s.startsWith(s2)) {
				boolean flag = s.indexOf("(") > -1
						&& s.indexOf(")") > -1;
				if (!flag) continue;
				init_bracketsAfter(s, map);
				s = init_GetDataString();
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_CalculationTrigonometricFunctionString 1 s="+s);
				Modchu_TextCalculationData data = new Modchu_TextCalculationData(Modchu_TextCalculationFormula.calculationFormulaMap.get(s2));
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationTrigonometricFunctionString 2 s2="+s2);
				setData(data);
				Modchu_TextCalculationData nextData1 = getNextData();
				if (nextData1 != null); else {
					String ss = "Modchu_TextCalculationData	init_CalculationTrigonometricFunctionString 3 nextData1 == null error !! s2="+s2;
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return false;
				}
				Modchu_TextCalculationData nextData2 = nextData1.getNextData();
				nextData1.setNextData(null);
				List list = getSubData();
				if (list != null); else list = new LinkedList();
				list.add(nextData1);
				setSubData(list);
				if (nextData2 != null) setNextData(nextData2);
				b = true;
				break;
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationTrigonometricFunctionString end s="+s);
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationTrigonometricFunctionString end return b="+b);
			Modchu_Debug.mDebug("Modchu_TextCalculationData	init_CalculationTrigonometricFunctionString ------------------- end.");
		}
		return b;
	}

	protected List init_List(List list, List list1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (list1 != null
				&& !list1.isEmpty())
		for (int i = 0; i < list1.size(); i++) {
			Object o = list1.get(i);
			if (o instanceof List) {
				List list2 = (List) o;
				init_List(list, list2, map);
			}
			if (o instanceof Modchu_RunCalculationList) {
				Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o;
				runCalculationList.calculationObject(map);
				list.add(runCalculationList);
			}
			else if (o instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o;
				Object o2 = data1.calculationObject(map);
				initAddData(list, data1, o2);
			}
			else if (o instanceof String) {
				String s2 = (String) o;
				List o1 = init_String(list, s2, map);
			}
		}
		return list;
	}

	protected List init_String(List list, String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s);
		Object o2 = data1.calculationObject(map);
		initAddData(list, data1, o2);
		return list;
	}

	protected boolean init_StringComma(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (s != null
				&& !s.isEmpty()
				&& s.indexOf("(") < 0
				&& s.indexOf(",") > -1); else return false;
		String[] s0 = s.split(",");
		List list = getSubData();
		if (list != null); else list = new LinkedList();
		for (int i = 0; i < s0.length; i++) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringComma 1 s0["+i+"]="+s0[i]);
			if (s0[i] != null
					&& !s0[i].isEmpty()); else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringComma s0["+i+"]="+s0[i]+" continue.");
				continue;
			}
			if (s0[i].equalsIgnoreCase("invokeMethod")
					| s0[i].equalsIgnoreCase("getFieldObject")
					| s0[i].equalsIgnoreCase("setFieldObject")) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringComma invokeMethod | FieldObject continue. s0["+i+"]="+s0[i]);
				continue;
			}
			if (s0[i].indexOf("\"") > -1) {
				s0[i] = s0[i].replaceAll("\"", "");
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringComma Raw String continue. s0["+i+"]="+s0[i]);
				list.add(s0[i]);
				continue;
			}
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringComma 2 s0["+i+"]="+s0[i]);
			Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s0[i]);
			Object o = data1.calculationObject(map);
			initAddData(list, data1, o);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringComma end. @FixedValueRawData getData()="+getData());
		setData("@FixedValueRawData");
		setSubData(list);
		type = isFixedValue;
		return true;
	}

	protected boolean init_StringPeriod(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		debug = true;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod 1 s="+s);
		int i1 = s.indexOf("=");
		String temp = i1 > -1 ? s.substring(0, i1) : s;
		i1 = temp.indexOf("(");
		temp = i1 > -1 ? temp.substring(0, i1) : temp;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod 2 temp="+temp);
		if (temp.indexOf(".") < 0) return false;
		if (temp.indexOf("\"") > -1) return false;
		if (temp.indexOf(".class") > -1) return false;
		if (temp.equals("Math.PI")) return false;
		i1 = temp.lastIndexOf("F");
		int i2 = temp.lastIndexOf("D");
		if (i1 > 0
				| i2 > 0) {
			if (temp.length() > 1) {
				int i3 = i1 > 0 ? i1 : i2;
				if (numbersNextToPeriodCheck(temp)) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod numbersNextToPeriodCheck return.");
					return false;
				}
			}
		}
		i2 = s.length();
		int i3 = 0;
		Modchu_TextCalculationData nextData = null;
		Modchu_TextCalculationData nextData1 = null;
		boolean flag = s.indexOf("(") > -1
				&& s.indexOf(")") > -1;
		if (!flag) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod !flag s="+s);
			return init_VariableStringListAfter(s, false, map);
		}
		init_bracketsAfter(s, map);
		s = init_GetDataString();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod 3 s="+s);
		nextData = getNextData();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod nextData="+nextData+" nextData.initObject="+(nextData != null ? nextData.initObject : null));
		nextData1 = nextData != null ? nextData.getNextData() : null;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod nextData1="+nextData1+" nextData1.initObject="+(nextData1 != null ? nextData1.initObject : null));
		nextData.setNextData(null);
		Object o = nextData != null ? nextData.calculationObject(map) : null;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod nextData o="+o);
		List list1 = null;
		if (o instanceof List) {
			list1 = (List) o;
		} else {
			if (o != null) {
				list1 = new ArrayList();
				list1.add(o);
			}
		}
		Modchu_TextCalculationData data2 = list1 != null ? new Modchu_TextCalculationData("newObject[]") : null;
		if (data2 != null) {
			data2.setObjectArray(true);
			data2.setSubData(list1);
			data2.initFlag = true;
		}
		Object[] oo1 = data2 != null ? (Object[]) data2.calculationObject(map) : null;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod nextData oo1="+Modchu_Main.objectArrayToString(oo1));
		String[] s0 = s.split("\\.");
		// classNameOrClass
		Modchu_TextCalculationData data3 = new Modchu_TextCalculationData(s0[0]);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod classNameOrClass s0[0]="+s0[0]);
		Object o1 = data3.calculationObject(map);
		o1 = Modchu_TextCalculation.instance.runCalculationAther(o1, map);
		if (o1 instanceof Modchu_TextCalculationData) {
			String ss = "Modchu_TextCalculationData init_StringPeriod o1 instanceof Modchu_TextCalculationData error !! data3.getData()="+data3.getData()+" data3.isRaw()="+data3.isRaw();
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return false;
		}
		boolean flag1 = o1 instanceof String;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod classNameOrClass o1="+o1);
		Object classNameOrClass = flag1 ? o1 : o1.getClass();
		//methodOrFieldName
		String methodOrFieldName = s0[1].replace("()", "");
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod methodOrFieldName="+methodOrFieldName);
		//reflectObject
		Object reflectObject = o1;
		if (reflectObject != null); else {
			reflectObject = Modchu_Main.getMapsObject(map, "ObjectDefault");
		}
		//reflectClassArray
		Class[] reflectClassArray = null;
		reflectClassArray = (Class[]) Modchu_Main.getMapsObject(map, s0[1]);
		if (reflectClassArray != null) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod reflectClassArray map1.get reflectClassArray="+Modchu_Main.objectArrayToString(reflectClassArray));
		} else {
			reflectClassArray = list1 != null ? new Class[list1.size()] : null;
			if (list1 != null
					&& !list1.isEmpty())
			for (int i = 0; i < list1.size(); i++) {
				Object o2 = Modchu_TextCalculation.instance.runCalculationAther(list1.get(i), map);
				reflectClassArray[i] = o2 != null ? Modchu_Main.classToPrimitive(o2.getClass()) : null;
			}
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod reflectClassArray getClass reflectClassArray="+Modchu_Main.objectArrayToString(reflectClassArray));
		}
		//reflectObjectArray
		Object[] reflectObjectArray = null;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod reflectObjectArray list1="+list1);
		reflectObjectArray = oo1;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod reflectObjectArray reflectObjectArray="+Modchu_Main.objectArrayToString(reflectObjectArray));
		Modchu_ReflectData reflectData = new Modchu_ReflectData(classNameOrClass, methodOrFieldName, reflectClassArray, reflectObject, reflectObjectArray);
		reflectData.setReflectObjectArrayData(data2);

		Modchu_TextCalculationFormula formula = Modchu_TextCalculationFormula.calculationFormulaMap.get("invokeMethod");
		Modchu_TextCalculationData nextData2 = new Modchu_TextCalculationData(formula);
		formula.setInitFlag(true);
		nextData2.setInitFlag(true);
		setNextData(nextData2);
		nextData2.setReflectData(reflectData);
		setReflectData(reflectData);
		if (nextData1 != null) nextData2.setNextData(nextData1);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod nextData1.getReflectData().dataToString()="+nextData2.getReflectData().dataToString());
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod end.");
		}
		return true;
	}

	protected boolean init_StringPeriodAfter(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		debug = true;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriodAfter s="+s);
		int i1 = s.indexOf("=");
		String temp = i1 > -1 ? s.substring(0, i1) : s;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod 2 temp="+temp);
		if (temp.indexOf(".") < 0) return false;
		if (temp.indexOf("\"") > -1) return false;
		if (temp.indexOf(".class") > -1) return false;
		if (temp.equals("Math.PI")) return false;
		i1 = temp.lastIndexOf("F");
		int i2 = temp.lastIndexOf("D");
		if (i1 > 0
				| i2 > 0) {
			if (temp.length() > 1) {
				int i3 = i1 > 0 ? i1 : i2;
				if (numbersNextToPeriodCheck(temp)) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriodAfter numbersNextToPeriodCheck return.");
					return false;
				}
			}
		}
		String[] s0 = temp.split("\\.");
		// classNameOrClass
		Modchu_TextCalculationData data3 = new Modchu_TextCalculationData(s0[0]);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriodAfter classNameOrClass s0[0]="+s0[0]);
		Object o1 = Modchu_TextCalculation.instance.runCalculationAther(data3, map);
		if (o1 instanceof Modchu_TextCalculationData) {
			String ss = "Modchu_TextCalculationData init_StringPeriodAfter o1 instanceof Modchu_TextCalculationData error !! data3.getData()="+data3.getData()+" data3.isRaw()="+data3.isRaw();
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return false;
		}
		boolean flag = o1 instanceof String;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriodAfter classNameOrClass o1="+o1);
		Object classNameOrClass = flag ? o1 : o1.getClass();
		//methodOrFieldName
		String methodOrFieldName = s0[1];
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriodAfter methodOrFieldName="+methodOrFieldName);
		//reflectObject
		Object reflectObject = o1;
		if (reflectObject != null); else {
			reflectObject = Modchu_Main.getMapsObject(map, "ObjectDefault");
		}
		Modchu_TextCalculationData nextData = getNextData();
		Modchu_TextCalculationFormula formula = Modchu_TextCalculationFormula.calculationFormulaMap.get("getFieldObject");
		Modchu_TextCalculationData nextData1 = new Modchu_TextCalculationData(formula);
		formula.setInitFlag(true);
		nextData1.setInitFlag(true);
		setNextData(nextData1);
		Modchu_ReflectData reflectData = new Modchu_ReflectData(classNameOrClass, methodOrFieldName, null, reflectObject, null);

		nextData1.setReflectData(reflectData);
		if (nextData != null) nextData1.setNextData(nextData);
		setReflectData(reflectData);
		setRaw(true);
		setData(this);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriodAfter nextData1.getReflectData().dataToString()="+nextData1.getReflectData().dataToString());
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriodAfter end.");
		}
		return true;
	}

	public boolean numbersNextToPeriodCheck(String s) {
		if (s != null
				&& !s.isEmpty()); else return false;
		int i1 = s.indexOf(".");
		if (i1 > -1
				&& s.length() > (i1 + 2)); else return false;
		String s1 = s.substring(i1 + 1, i1 + 2);
		if (Modchu_Main.integerCheck(s1)) {
			return true;
		}
		return false;
	}

	protected boolean init_Reflect(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		debug = true;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect s="+s);
		boolean b = false;
		for (int i = 0; i < Modchu_TextCalculationFormula.calculationReflectStringList.size(); i++) {
			String s2 = Modchu_TextCalculationFormula.calculationReflectStringList.get(i);
			if (s.startsWith(s2)) {
				String s3 = s.substring(s2.length());
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData	init_Reflect s2="+s2);
				setData(Modchu_TextCalculationFormula.calculationFormulaMap.get(s2));
				b = true;
				break;
			}
		}
		if (!b) return false;
		int i1 = s.indexOf("(");
		int i2 = s.indexOf(")");
		if (i1 > -1
				&& i2 > -1); else return false;
		String s1 = Modchu_Main.getInsideParentheses(s);
		String[] s0 = Modchu_Main.getOutOfInsideParenthesesSplit(s1, ",");

		//classNameOrClass
		Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s0[0]);
		Object o1 = data1.calculationObject(map);
		o1 = Modchu_TextCalculation.instance.runCalculationAther(o1, map);
		if (o1 instanceof String
				| o1 instanceof Class); else {
			String ss = "Modchu_TextCalculationData init_Reflect classNameOrClass !(o1 instanceof String) && !(o1 instanceof Class) error !! o1="+o1;
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return false;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect classNameOrClass o1="+o1);
		Object classNameOrClass = o1;
		//methodOrFieldName
		Modchu_TextCalculationData data2 = new Modchu_TextCalculationData(s0[1]);
		Object o2 = Modchu_TextCalculation.instance.runCalculationAther(data2, map);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect methodOrFieldName o2="+o2);
		if (o2 instanceof String); else {
			String ss = "Modchu_TextCalculationData init_Reflect methodOrFieldName !(o2 instanceof String) error !! o2="+o2;
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return false;
		}
		String methodOrFieldName = (String) o2;
		//reflectObject
		Modchu_TextCalculationData data3 = new Modchu_TextCalculationData(s0[2]);
		Object o3 = Modchu_TextCalculation.instance.runCalculationAther(data3, map);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect reflectObject o3="+o3);
		Object reflectObject = null;
		Class[] reflectClassArray = null;
		int i3 = 4;
		if (o3 instanceof Class[]) {
			reflectClassArray = (Class[]) o3;
			i3 = 3;
		} else {
			reflectObject = o3;
		}
		//reflectClassArray
		if (reflectClassArray != null); else {
			reflectClassArray = (Class[]) Modchu_Main.getMapsObject(map, s0[2]);
		}
		if (reflectClassArray != null) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect reflectClassArray map1.get reflectClassArray="+Modchu_Main.objectArrayToString(reflectClassArray));
		} else {
			Modchu_TextCalculationData data4 = new Modchu_TextCalculationData(s0[3]);
			Object o4 = Modchu_TextCalculation.instance.runCalculationAther(data4, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect reflectClassArray o4="+o4);
			if (o4 instanceof Class[]); else {
				String ss = "Modchu_TextCalculationData init_Reflect reflectClassArray !(o4 instanceof Class[]) error !! o4="+o4;
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
				return false;
			}
			reflectClassArray = (Class[]) o4;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect reflectClassArray getClass reflectClassArray="+Modchu_Main.objectArrayToString(reflectClassArray));
		}
		//reflectObjectArray
		Object[] reflectObjectArray = null;
		Modchu_TextCalculationData data5 = new Modchu_TextCalculationData(s0[i3]);
		Object o5 = Modchu_TextCalculation.instance.runCalculationAther(data5, map);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect reflectObjectArray o5="+o5);
		if (o5 instanceof Object[]); else {
			String ss = "Modchu_TextCalculationData init_Reflect reflectObjectArray !(o5 instanceof Object[]) error !! o5="+o5;
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return false;
		}
		reflectObjectArray = (Object[]) o5;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect reflectObjectArray reflectObjectArray="+Modchu_Main.objectArrayToString(reflectObjectArray));
		Modchu_ReflectData reflectData = new Modchu_ReflectData(classNameOrClass, methodOrFieldName, reflectClassArray, reflectObject, reflectObjectArray);
		reflectData.setReflectObjectArrayData(data5);
		setReflectData(reflectData);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect reflectData.dataToString()="+reflectData.dataToString());
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_Reflect end.");
		}
		return true;
	}

	protected void initAddData(List list, Modchu_TextCalculationData data1, Object o) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData initAddData data1="+data1+" data1.getClass()="+(data1 != null ? data1.getClass() : null));
			Modchu_Debug.mDebug("Modchu_TextCalculationData initAddData o="+o+" o.getClass()="+(o != null ? o.getClass() : null));
		}
		Object o2 = null;
		if (data1 != null
				&& data1.isRaw()) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData initAddData list.add o="+o+" o.getClass()="+(o != null ? o.getClass() : null));
			o2 = o;
		} else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData initAddData list.add data1="+data1+" data1.getClass()="+(data1 != null ? data1.getClass() : null));
			o2 = data1;
		}
		list.add(o2);
	}

	public boolean isObjectArray() {
		return type == isObjectArray;
	}

	private void setObjectArray(boolean b) {
		if (b) type = isObjectArray;
	}

	@Override
	public Object calculationObject(Map... map) {
		return calculationObject(null, null, map);
	}

	protected Object calculationObject(Object o, Object o1, Map... map) {
		//Modchu_TextCalculation.instance.tempDebug = initObject.equals("3.141593F");
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (o1 instanceof Map[]) {
			String ss ="Modchu_TextCalculationData calculationObject o1 instanceof Map[] error !! o1="+o1;
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return null;
		}
		init(o, o1, map);
		Modchu_TextCalculationFormula formula = null;
		List subData = getSubData();
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject ------------------------------- start.");
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject initObject="+initObject);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data="+data);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject subData="+subData);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject type="+type);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject o="+o);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject o1="+o1);
		}

		Modchu_TextCalculationData nextData1 = getNextData();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject nextData1="+nextData1);
		Object o2 = null;
		Object o3 = null;
		switch(type) {
			case isRaw:
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isLow.");
				o3 = calculationIsRaw(o, o1, map);
				break;
			case isFixedValue:
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String @FixedValueRawData return subData="+subData);
				o3 = calculationIsFixedValue(o, o1, map);
				break;
			case isObjectArray:
				o3 = calculationIsObjectArray(o, o1, map);
				break;
			case isCalculation:
				o3 = calculationIsCalculationTwo(o, o1, map);
				break;
			default:
				o3 = calculationDefault(o, o1, map);
				break;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject 2 o3="+o3);
		if (o3 != null) {
			if (o != null) o2 = o3;
			else o = o3;
		}
		Object[] o5 = calculationObjectAfter(o, o1, o2, map);
		if (o5 != null
				&& o5.length > 2) {
			o = o5[0];
			o2 = o5[1];
			nextData1 = (Modchu_TextCalculationData) o5[2];
		}
		if (nextData1 != null) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject 4 nextData1.getData()="+nextData1.getData()+" o="+o+" o2="+o2);
			if (nextData1.equals(this)) {
				String ss = "Modchu_TextCalculationData calculationObject nextData1.equals(this) error !! nextData1="+nextData1+" nextData1.initObject="+nextData1.initObject;
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
				return null;
			}
			Object data = nextData1.getData();
			if (data == null
					| (data != null
					&& data instanceof String
					&& ((String) data).isEmpty())) {
				String ss = "Modchu_TextCalculationData calculationObject nextData1.getData() == null error !! nextData1="+nextData1+" nextData1.initObject="+nextData1.initObject;
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
				return null;
			}
			o = nextData1.calculationObject(o, o2, map);
		} else {
			boolean flag = false;
			if (o2 instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o2;
				if (data1.isTempRaw()) {
					o2 = data1.getTempRawData();
				} else {
					if (o != null) flag = true;
				}
			}
			if (!flag) {
				o = calculationObjectEndSetting(o, o2, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject 3 o="+o);
				o2 = null;
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject end. isTempRaw()="+isTempRaw());
			if (isTempRaw()) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject end. getTempRawData()="+getTempRawData());
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject end. initObject="+initObject);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject end. return o="+(o instanceof Object[] ? Modchu_Main.objectArrayToString((Object[]) o) : o));
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject ------------------------------- end.");
			//Modchu_TextCalculation.instance.tempDebug = false;
		}
		return o;
	}

	protected Object calculationIsRaw(Object o, Object o1, Map... map) {
		return data;
	}

	protected Object calculationIsFixedValue(Object o, Object o1, Map... map) {
		return subData;
	}

	protected Object calculationIsReflect(Object o, Object o1, Map... map) {
		return this;
	}

	protected Object calculationIsObjectArray(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Object data = getModchu_TextCalculationDataData(getData());
		List list = subData;
		Object[] oo1 = null;
		if (data instanceof Object[]) {
			oo1 = (Object[]) data;
			for (int i = 0; i < list.size(); i++) {
				Object o3 = getListCalculationObject(list, i, map);
				oo1[i] = o3;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isObjectArray() data instanceof Object[] o3="+o3);
			}
			setTempRawData(oo1);
		} else {
			String s = (String) data;
			int i1 = s.indexOf("[]");
			s = s.substring(0, i1);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isObjectArray() data instanceof String s="+s);
			if (list != null) {
				Class c = s.equalsIgnoreCase("newClass") ? Class.class : s.equalsIgnoreCase("newObject") ? Object.class : Modchu_Reflect.loadClass(s);
				oo1 = c != null ? Modchu_Reflect.newInstanceArray(c, list.size()) :  new Object[list.size()];
				for (int i = 0; i < list.size(); i++) {
					Object o3 = getListCalculationObject(list, i, map);
					oo1[i] = o3;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isObjectArray() data instanceof String o3="+o3);
				}
				setTempRawData(oo1);
				setData(oo1);
				if (c == Class.class) setRaw(true);
			} else {
				String ss ="Modchu_TextCalculationData calculationObject isObjectArray() data instanceof String s.indexOf(\"[]\") list == null error !! data="+data;
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
			}
		}
		//isEndSettingSkip = true;
		return oo1;
	}

	protected Object calculationIsCalculationTwo(Object o, Object o1, Map[] map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula data="+data);
		Modchu_TextCalculationFormula formula = (Modchu_TextCalculationFormula) data;
		boolean isOneValue = formula.isOneValue();
		boolean isTrigonometricFunction = formula.isTrigonometricFunction();
		boolean isReflect = formula.isReflect();
		boolean isVariable = formula.isVariable();
		Object o4 = null;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula formula.getDataString()="+formula.getDataString());
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isOneValue="+isOneValue);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isTrigonometricFunction="+isTrigonometricFunction);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isReflect="+isReflect);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isVariable="+isVariable);
		}
		Modchu_TextCalculationData nextData1 = getNextData();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject nextData1="+nextData1);
		if (isReflect) {
			if (nextData1 != null) {
				o4 = formula.calculationObject(null, nextData1, map);
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isReflect nextData1="+nextData1);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isReflect o="+o+" o4="+o4);
				}
				nextData1 = nextData1 != null ? nextData1.getNextData() : null;
			}
		}
		else if (isTrigonometricFunction) {
			Object o3 = subData.get(0);
			if (o3 instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o3;
				o4 = formula.calculationObject(null, o3, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isTrigonometricFunction o="+o+" o4="+o4);
			}
		}
		else if (isOneValue) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isOneValue.");
			if (o1 != null) {
				String ss = "Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isOneValue o1 != null error !! o="+o+" o1="+o1;
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
			}
			o4 = formula.calculationObject(map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula o="+o+" o4="+o4);
		} else {
			o4 = this;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula set this. o="+o+" o4="+o4);
		}
		return o4;
	}

	protected Object calculationDefault(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Modchu_TextCalculationData nextData1 = getNextData();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject nextData1="+nextData1);
		Object data = getModchu_TextCalculationDataData(getData());
		Object o4 = null;
		if (getVariableString() != null
				&& !(data instanceof Modchu_TextCalculationFormula)) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isVariable return this="+this);
			o4 = this;
			if (nextData1 == null) {
				String ss = "Modchu_TextCalculationData calculationObject isVariable() nextData1 == null error !! o="+o+" o1="+o1+" data="+data;
				Modchu_Debug.mDebug(ss);
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
			}
		} else {
			if (data instanceof List) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof List data="+data);
				o4 = data;
			}
			else if (data instanceof Modchu_RunCalculationList) {
				Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) data;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_RunCalculationList data="+data);
				o4 = runCalculationList.calculationObject(map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_RunCalculationList return o="+o+" o4="+o4);
			}
			else if (data instanceof Modchu_TextCalculationFormula) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula data="+data);
				Modchu_TextCalculationFormula formula = (Modchu_TextCalculationFormula) data;
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula formula.getDataString()="+formula.getDataString());
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isOneValue()="+formula.isOneValue());
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isTrigonometricFunction()="+formula.isTrigonometricFunction());
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isReflect()="+formula.isReflect());
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isVariable()="+formula.isVariable());
				}
				if (formula.isReflect()) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isReflect getReflectData()="+getReflectData());
					o4 = formula.calculationObject(null, this, map);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isReflect o="+o+" o4="+o4);
				}
				else if (formula.isTrigonometricFunction()) {
					Object o3 = subData.get(0);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isTrigonometricFunction o3="+o3);
					if (o3 instanceof Modchu_TextCalculationData) {
						Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o3;
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isTrigonometricFunction data1.initObject="+data1.initObject);
						o4 = formula.calculationObject(null, o3, map);
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isTrigonometricFunction o="+o+" o4="+o4);
					}
				}
				else if (formula.isOneValue()) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isOneValue.");
					if (o1 != null) {
						String ss = "Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isOneValue o1 != null error !! o="+o+" o1="+o1;
						Modchu_Debug.mDebug(ss);
						Modchu_Debug.lDebug(ss);
						Modchu_Main.setRuntimeException(ss);
					}
					o4 = formula.calculationObject(map);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula o="+o+" o4="+o4);
				} else {
					o4 = this;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula set this. o="+o+" o4="+o4);
				}
			}
			else if (data instanceof String) {
				String s = (String) data;
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String s="+s+" this="+this);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String initFlag="+initFlag);
				}
				if (s.equals("null")) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String s.equals(\"null\") return null.");
					o4 = null;
				} else {
					if (s.startsWith("\"")) {
						s = s.replaceAll("\"", "");
						setData(s);
						setRaw(true);
						o4 = s;
					} else {
						int i1 = s.indexOf(".class");
						if (i1 > -1) {
							s = s.substring(0, i1);
							Class c = Modchu_Reflect.loadClass(s);
							setData(c);
							setRaw(true);
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String \".class\" c="+c);
							o4 = c;
						} else {
							setTempRawData(null);
							setTempRaw(false);
							Object o3 = Modchu_RunCalculationList.getMapsObject(s, map);
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String getMapsObject o3="+o3);
							if (o3 != null) {
								setTempRaw(true);
								setTempRawData(o3);
								o4 = this;
							} else {
								o3 = Modchu_RunCalculationList.getFieldOrMedhod(s, map);
								if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String getFieldOrMedhod o3="+o3);
								if (o3 != null) {
									setTempRaw(true);
									setTempRawData(o3);
									o4 = this;
								} else {
									o4 = Modchu_Main.stringToSuitableObject(s);
									if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject o4="+o4);
									if (o4 instanceof String) {
										if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject o4 instanceof String null return String o4="+o4);
									} else {
										if (o4 != null) {
											if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject setData(o4). o4.getClass()="+o4.getClass());
											setData(o4);
											setRaw(true);
										}
									}
								}
							}
							if (o4 != null); else {
								if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o4 = null.");
							}
						}
					}
				}
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof else data="+data);
				o4 = data;
			}
		}
		return o4;
	}

	protected Object[] calculationObjectAfter(Object o, Object o1, Object o2, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (o != null
				&& o2 != null) {
			if (o instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data2 = (Modchu_TextCalculationData) o;
				Object o4 = data2.getData();
				if (o4 != null) {
					if (o4 instanceof Modchu_TextCalculationFormula) {
						Modchu_TextCalculationFormula formula1 = (Modchu_TextCalculationFormula) o4;
						boolean isOneValue1 = formula1.isOneValue();
						if (debug) {
							Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o] o4 instanceof Modchu_TextCalculationFormula isOneValue1="+isOneValue1);
							Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o] o4 instanceof Modchu_TextCalculationFormula formula1.getDataString()="+formula1.getDataString());
						}
						if (isOneValue1) {
						} else {
							if (formula1.getDataString().equals("-")) {
								o2 = Modchu_TextCalculation.instance.runCalculationAther(o2, map);
								o = formula1.calculationObject(null, o2, map);
								if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o] o4 instanceof Modchu_TextCalculationFormula o="+o);
								o1 = null;
								o2 = null;
							}
						}
					}
				}
			}
		}
		Modchu_TextCalculationData nextData1 = getNextData();
		if (o1 != null) {
			if (o1 instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data2 = (Modchu_TextCalculationData) o1;
				Object o4 = data2.getData();
				if (o4 != null) {
					if (o4 instanceof Modchu_TextCalculationFormula) {
						Modchu_TextCalculationFormula formula1 = (Modchu_TextCalculationFormula) o4;
						boolean isOneValue1 = formula1.isOneValue();
						if (debug) {
							Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o1] o4 instanceof Modchu_TextCalculationFormula isOneValue1="+isOneValue1);
							Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o1] o4 instanceof Modchu_TextCalculationFormula formula1.isReflect()="+formula1.isReflect());
							Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o1] o4 instanceof Modchu_TextCalculationFormula formula1.getDataString()="+formula1.getDataString());
						}
						if (isOneValue1
								| formula1.isReflect()) {
						} else {
							if (o2 != null) {
								if (o2 instanceof Modchu_TextCalculationData) {
									Modchu_TextCalculationData data3 = (Modchu_TextCalculationData) o2;
									Object o5 = data3.getData();
									if (o5 != null
											&& o5 instanceof Modchu_TextCalculationFormula) {
										Modchu_TextCalculationFormula formula2 = (Modchu_TextCalculationFormula) o5;
										boolean isOneValue2 = formula2.isOneValue();
										if (debug) {
											Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o1] o5 instanceof Modchu_TextCalculationFormula isOneValue2="+isOneValue2);
											Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o1] o5 instanceof Modchu_TextCalculationFormula formula2.getDataString()="+formula2.getDataString());
										}
										if (isOneValue2
												| formula2.isReflect()) {
										} else {
											Modchu_TextCalculationData nextData2 = data3.getNextData();
											if (nextData2 != null) {
												Object o6 = nextData2.calculationObject(map);
												if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o1] o5 instanceof Modchu_TextCalculationFormula o6="+o6);
												o2 = data3.calculationObject(null, o6, map);
												if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o1] o5 instanceof Modchu_TextCalculationFormula o2="+o2);
												nextData1 = nextData2.getNextData();
											}
										}
									}
								}
							}
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o1] o4 instanceof Modchu_TextCalculationFormula 1 o="+o);
							o = formula1.calculationObject(o, o2, map);
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectAfter [o1] o4 instanceof Modchu_TextCalculationFormula 2 o="+o);
							o2 = null;
						}
					}
				}
			}
		}
		return new Object[]{ o, o2, nextData1 };
	}

	protected Object getModchu_TextCalculationDataData(Object data1) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (data1 instanceof Modchu_TextCalculationData) {
			Modchu_TextCalculationData data2 = (Modchu_TextCalculationData) data1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationData data2="+data2);
			data1 = data2.getData();
			if (data1 instanceof Modchu_TextCalculationData) {
				data1 = getModchu_TextCalculationDataData(data1);
			}
		}
		if (data1 instanceof Modchu_TextCalculationData) {
			String ss ="Modchu_TextCalculationData getModchu_TextCalculationDataData data1 instanceof Modchu_TextCalculationData error !! data1="+data1+" data1.getData()="+((Modchu_TextCalculationData) data1).getData();
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
		}
		return data1;
	}

	public Object getTempRawData() {
		return tempRawData;
	}

	public void setTempRawData(Object o) {
		tempRawData = o;
	}

	public boolean isTempRaw() {
		return isTempRaw;
	}

	public void setTempRaw(boolean b) {
		isTempRaw = b;
	}

	protected Object calculationObjectEndSetting(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (o == null
				&& o1 != null) {
			o = o1;
		}
		else if (o1 != null
				&& o != null) {
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectEndSetting o1 != null && o != null "+o+" + "+o1);
				Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectEndSetting o1 != null && o != null o.getClass()="+o.getClass()+" o1.getClass()="+o1.getClass());
			}
			if (o1.getClass().isArray()
					| o.getClass().isArray()) {
				//String ss = "Modchu_TextCalculationData calculationObjectEndSetting isArray() error !!";
				//Modchu_Debug.lDebug(ss);
				//Modchu_Main.setRuntimeException(ss);
			} else {
				Modchu_TextCalculationFormula formula = Modchu_TextCalculationFormula.calculationFormulaMap.get("+");
				o = formula.calculationObject(o, o1, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectEndSetting o1 != null && o != null calculationObject o="+o);
			}
		} else {
			if (o1 != null) o = o1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObjectEndSetting null o = o1. o="+o);
/*
			String ss ="Modchu_TextCalculationData calculationObjectEndSetting null debug ";
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
*/
		}
		return o;
	}

	protected boolean calculationObjectEndSettingFlag(Object o, Object o1, HashMap<String, Object>... map) {
		if (o == null
				&& o1 != null) return true;
		if (o != null
				&& o1 != null); else return false;
		byte by = Modchu_RunCalculationList.getType(o);
		switch(by) {
		case Modchu_RunCalculationList.type_Object:
			return false;
		case Modchu_RunCalculationList.type_Integer:
			return o instanceof Integer
					&& o1 instanceof Integer;
		case Modchu_RunCalculationList.type_Float:
		case Modchu_RunCalculationList.type_Double:
			return (o instanceof Float
					| o instanceof Double)
					&& (o1 instanceof Float
					| o1 instanceof Double);
		case Modchu_RunCalculationList.type_Long:
			return o instanceof Long
					&& o1 instanceof Long;
		case Modchu_RunCalculationList.type_Byte:
			return o instanceof Byte
					&& o1 instanceof Byte;
		case Modchu_RunCalculationList.type_Boolean:
			return o instanceof Boolean
					&& o1 instanceof Boolean;
		case Modchu_RunCalculationList.type_If:
			Class c = o.getClass();
			Class c1 = o1.getClass();
			return (c == boolean.class
					&& c1 == boolean.class)
					| (c == int.class
					&& c1 == int.class)
					| ((c == float.class
					| c == double.class)
					&& (c1 == float.class
					| c1 == double.class))
					| (c == byte.class
					&& c1 == byte.class)
					| (c == long.class
					&& c1 == long.class)
					| (c != boolean.class
					&& c != int.class
					&& c != float.class
					&& c != double.class
					&& c != byte.class
					&& c != long.class
					&& c1 != boolean.class
					&& c1 != int.class
					&& c1 != float.class
					&& c1 != double.class
					&& c1 != byte.class
					&& c1 != long.class);
		}
		return false;
	}

	protected Object getListCalculationObject(List list, int i, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Object o1 = i < list.size() ? list.get(i) : null;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getListCalculationObject o1="+o1);
		if (o1 != null); else return null;
		Object o2 = null;
		if (o1 instanceof List) {
			List list1 = (List) o1;
			for (int i1 = 0; i1 < list1.size(); i1++) {
				o2 = getListCalculationObject(list1, i1, map);
			}
		} else {
			o2 = Modchu_TextCalculation.instance.runCalculationAther(o1, map);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getListCalculationObject return o2="+o2);
		return o2;
	}
/*
	protected Object[] getCalculationObject_s_r(List list, int i, boolean isClass, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		LinkedList list1 = new LinkedList();
		Object o1 = getListCalculationObject(list, i, map);
		if (o1 instanceof String); else return new Object[]{ o1, i };
		i++;
		Object o2 = getListCalculationObject(list, i, map);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getCalculationObject_s_r o2="+o2);
		if (o2 instanceof List); else {
			String ss ="Modchu_TextCalculationData getCalculationObject_s_r !(o2 instanceof List) error !! o2="+o2;
			Modchu_Main.setRuntimeException(ss);
			return null;
		}
		List list2 = (List) o2;
		for (int i3 = 0; i3 < list2.size(); i3++) {
			Object o3 = getListCalculationObject(list2, i3, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getCalculationObject_s_r o3="+o3);
			boolean isString = o3 instanceof String;
			boolean isList = o3 instanceof List;
			if (isString
					| isList) {
				List list3 = isList ? (List) o3 : null;
				if (isString) {
					String s = (String) o3;
					String[] s0 = s != null
							&& s.indexOf(",") > -1 ? s.split(",") : null;
					list3 = Modchu_Main.stringArrayToLinkedList(s0);
				}
				if (list3 != null
						&& !list3.isEmpty())
				for (int i1 = 0; i1 < list3.size(); i1++) {
					Object o5 = getListCalculationObject(list3, i1, map);
					list1.add(o5);
				}
			}
			else if (o3 instanceof Class) list1.add(o3);
			else if (o3 instanceof Class[]) {
				if (isClass) {
					if (list2.size() == 1) return new Object[]{ o3, i };
					list1.add(o3);
				} else {
					String ss ="Modchu_TextCalculationData getCalculationObject_s_r o3 instanceof Class[] && !isClass error !! o3="+o3;
					Modchu_Main.setRuntimeException(ss);
					return null;
				}
			}
			else if (o3 instanceof Object[]) {
				if (!isClass) {
					if (list2.size() == 1) return new Object[]{ o3, i };
					list1.add(o3);
				} else {
					String ss ="Modchu_TextCalculationData getCalculationObject_s_r o3 instanceof Object[] && isClass error !! o3="+o3;
					Modchu_Main.setRuntimeException(ss);
					return null;
				}
			}
		}
		Object[] o3 = isClass ? Modchu_Main.listToObjectArray(list1, Class.class) : Modchu_Main.listToObjectArray(list1);
		return new Object[]{ o3, i };
	}
*/
	@Override
	public String dataToString(boolean b) {
		//boolean debug = Modchu_TextCalculation.tempDebug;
		boolean debug = isReflect();
/*
		Object subData = getSubData();
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData dataToString data="+data);
			Modchu_Debug.mDebug("Modchu_TextCalculationData dataToString data.getClass()="+data.getClass());
		}
*/
		StringBuilder sb = new StringBuilder();
		List<String> list = dataToStringList(b, debug);
		for (String s : list) {
			sb.append(s);
		}
		Modchu_TextCalculationData nextData1 = getNextData();
		if (nextData1 != null) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData dataToString nextData1="+nextData1);
			sb.append(nextData1.dataToString(b));
		}
		return sb.toString();
	}

	public String dataToStringSimple(boolean b) {
		StringBuilder sb = new StringBuilder();
		List<String> list = dataToStringList(b, false);
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString();
	}

	public String otherDataToString(Object data) {
		//Modchu_Debug.mDebug("Modchu_TextCalculationData otherDataToString data="+data);
		return data != null ? data.toString() : null;
	}

	@Override
	public List<String> dataToStringList(boolean b, boolean isDebug) {
		boolean debug = Modchu_TextCalculation.tempDebug;
/*
		if (isDebug) {
			String ss ="Modchu_TextCalculationData dataToStringList isDebug debug";
			Modchu_Main.setRuntimeException(ss);
		}
*/
		Object subData = getSubData();
		List<String> list = new LinkedList();
		Object data = getData();
		if (isReflect()) {
			Modchu_TextCalculationData nextData1 = getNextData();
			if (nextData1 != null
					&& nextData1.getReflectData() != null) {
				if (isDebug) list.add("Modchu_TextCalculationData dataToStringList isVariable() formula.getReflectData().dataToString() start.\n");
				list.add(nextData1.getReflectData().dataToString());
				if (isDebug) list.add("Modchu_TextCalculationData dataToStringList isVariable() formula.getReflectData().dataToString() end.\n");
			} else {
				if (initFlag) {
					if (isDebug) list.add("Modchu_TextCalculationData dataToStringList isVariable() initFlag !!\n");
					//String ss ="Modchu_TextCalculationData dataToStringList isReflect() getReflectData() == null error !! formula="+formula;
					//Modchu_Main.setRuntimeException(ss);
				}
				list.add(otherDataToString(data));
				if (isDebug) list.add("Modchu_TextCalculationData dataToStringList isVariable() subData start.\n");
				list.add("[!initFlag subData]");
				list.add(Modchu_TextCalculation.instance.dataToString(subData, false));
				if (isDebug) list.add("Modchu_TextCalculationData dataToStringList isVariable() subData end.\n");
			}
		}
		else if (isVariable()) {
			if (isDebug) list.add("Modchu_TextCalculationData dataToStringList isVariable() start.\n");
			list.add(variableTypeStringList.get(variableType)+" "+variableString);
			if (isDebug) list.add("Modchu_TextCalculationData dataToStringList isVariable() end.\n");
		}
		else if (data instanceof List) {
			if (isDebug) list.add("Modchu_TextCalculationData dataToStringList data instanceof List start.\n");
			list.add(Modchu_TextCalculation.instance.dataToString((List) data, b));
			if (isDebug) list.add("Modchu_TextCalculationData dataToStringList data instanceof List end.\n");
		}
		else if (data instanceof Modchu_ITextCalculationDataFormat) {
			if (data instanceof Modchu_TextCalculationData
					&& ((Modchu_TextCalculationData) data).getReflectData() != null) {
				if (isDebug) list.add("Modchu_TextCalculationData dataToStringList data instanceof Modchu_ITextCalculationDataFormat isReflect start.\n");
				list.add(((Modchu_TextCalculationData) data).getReflectData().dataToString());
				if (isDebug) list.add("Modchu_TextCalculationData dataToStringList data instanceof Modchu_ITextCalculationDataFormat isReflect end.\n");
			} else {
				if (isDebug) list.add("Modchu_TextCalculationData dataToStringList data instanceof Modchu_ITextCalculationDataFormat start.\n");
				list.add(((Modchu_ITextCalculationDataFormat) data).dataToString(b));
				if (isDebug) list.add("Modchu_TextCalculationData dataToStringList data instanceof Modchu_ITextCalculationDataFormat end.\n");
			}
		} else {
			if (isDebug) list.add("Modchu_TextCalculationData dataToStringList data instanceof otherDataToString start.\n");
			list.add(otherDataToString(data));
			if (isDebug) list.add("Modchu_TextCalculationData dataToStringList data instanceof otherDataToString end.\n");
		}
		if (!isReflect()
				&& subData != null) {
			if (isDebug) list.add("Modchu_TextCalculationData dataToStringList subData data start.\n");
			list.add(Modchu_TextCalculation.instance.dataToString(subData, false));
			if (isDebug) list.add("Modchu_TextCalculationData dataToStringList subData data end.\n");
		}
		return list;
	}

	@Override
	public void debugData(String s, String s1) {
		String s2 = s + " " + s1;
		List<String> list = dataToStringList(false, false);
		for (String s3 : list) {
			Modchu_Debug.mDebug(s3);
		}
		debugDataDetails();
	}

	public void debugDataDetails() {
		debugDataDetails(0);
		Modchu_TextCalculationData nextData1 = getNextData();
		Modchu_Debug.mDebug("Modchu_TextCalculationData debugData nextData1="+nextData1);
		if (nextData1 != null) nextData1.debugDataDetails();
	}

	public void debugDataDetails(int i) {
		Object data1 = getData();
		Object subData = getSubData();
		String s = getDebugDataDetailsString(i);
		Modchu_Debug.mDebug(s+"\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ start.");
		Modchu_Debug.mDebug(s+"this="+this);
		Modchu_Debug.mDebug(s+"data1="+data1);
		Modchu_Debug.mDebug(s+"subData="+subData);
		Modchu_Debug.mDebug(s+"isOneValue()="+isOneValue());
		Modchu_Debug.mDebug(s+"isObjectArray()="+isObjectArray());
		if (isObjectArray()) {
			Modchu_Debug.mDebug(s+"[isObjectArray()] data1="+(data1.getClass().isArray() ? Modchu_Main.objectArrayToString((Object[]) data1) : data1));
		}
		Modchu_Debug.mDebug(s+"isOperatorStringFlag()="+isOperatorStringFlag());
		if (isOperatorStringFlag()) {
			Modchu_TextCalculationFormula formula = (Modchu_TextCalculationFormula) data;
			Modchu_Debug.mDebug(s+"formula.getDataString()="+formula.getDataString());
			Modchu_Debug.mDebug(s+"formula.isCalculation()="+formula.isCalculation());
			Modchu_Debug.mDebug(s+"formula.isOperator()="+formula.isOperator());
			Modchu_Debug.mDebug(s+"formula.isTrigonometricFunction()="+formula.isTrigonometricFunction());
		}
		Modchu_Debug.mDebug(s+"isRaw()="+isRaw());
		Modchu_Debug.mDebug(s+"isReflect()="+isReflect());
		Modchu_Debug.mDebug(s+"isVariable()="+isVariable());
		Modchu_Debug.mDebug(s+"\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ end.");
		debugDataDetails(subData, "subData", i);
	}

	protected String getDebugDataDetailsString(int i) {
		String s = "Modchu_TextCalculationData debugDataDetails ["+i+"]\t";
		if (i > 0)
		for (int i1 = 0; i1 < i; i1++) {
			s = s + "\t";
		}
		return s;
	}

	public void debugDataDetails(Object o, String s) {
		debugDataDetails(o, s, 0);
	}

	public void debugDataDetails(Object o, String s, int i) {
		if (o != null); else return;
		String s1 = getDebugDataDetailsString(i)+" "+s+" ";
		Modchu_Debug.mDebug(s1+"****************************** start.");
		if (o instanceof List) {
			Modchu_Debug.mDebug(s1+"List↓");
			List list = (List) o;
			i = debugDataDetailsList(list, o, s, i);
			Modchu_Debug.mDebug(s1+"List↑");
		} else if (o instanceof Modchu_TextCalculationData) {
			Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o;
			data1.debugDataDetails(i);
		} else if (o instanceof Modchu_RunCalculationList) {
			Modchu_Debug.mDebug(s1+"Modchu_RunCalculationList↓");
			Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o;
			i = debugDataDetailsList(runCalculationList.getList(), o, s, i);
			Modchu_Debug.mDebug(s1+"Modchu_RunCalculationList↑");
		} else {
			Modchu_Debug.mDebug(s1+"else ????????????? o="+o);
		}
		Modchu_Debug.mDebug(s1+"****************************** end.");
	}

	public int debugDataDetailsList(List list, Object o, String s, int i) {
		String s1 = getDebugDataDetailsString(i)+" "+s+" ";
		Modchu_Debug.mDebug(s1+"List ----------------------------- start.");
		if (!list.isEmpty()) {
			int i1 = 0;
			for (Object o1 : list) {
				debugDataDetails(o1, s+"["+i1+"]", i);
				i++;
				i1++;
			}
		}
		Modchu_Debug.mDebug(s1+"List ----------------------------- end.");
		return i;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object o) {
		data = o;
	}

	public List getSubData() {
		return subData;
	}

	public void setSubData(List list) {
		Modchu_Debug.mDebug("Modchu_TextCalculationData setSubData list="+list);
		subData = list;
	}

	public boolean isRaw() {
		return type == isRaw;
	}

	public void setRaw(boolean b) {
/*
		if (b) {
			String ss = "Modchu_TextCalculationData debug setRaw ";
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
		}
*/
		type = isRaw;
	}

	public boolean isOperatorStringFlag() {
		Object data1 = getData();
		return data1 instanceof Modchu_TextCalculationFormula;
	}

	public int getMaxSubDataListSize() {
		return maxSubDataListSize;
	}

	public void setMaxSubDataListSize(int i) {
		maxSubDataListSize = i;
	}

	public boolean isTrigonometricFunction() {
		if (data instanceof Modchu_TextCalculationFormula) {
			Modchu_TextCalculationFormula formula = (Modchu_TextCalculationFormula) data;
			return formula.isTrigonometricFunction();
		}
		return false;
	}

	@Override
	public boolean isOneValue() {
		if (data instanceof Modchu_ITextCalculationDataFormat) {
			return ((Modchu_ITextCalculationDataFormat) data).isOneValue();
		}
		return true;
	}

	@Override
	public boolean isVariable() {
		return type == isVariable;
	}

	@Override
	public void setVariable(boolean b) {
		if (b) type = isVariable;
	}

	public boolean isReflect() {
		Object data = getData();
		if (data instanceof Modchu_TextCalculationFormula) {
			Modchu_TextCalculationFormula formula = (Modchu_TextCalculationFormula) data;
			return formula.isReflect();
		}
		return false;
	}

	public int getVariableType() {
		return variableType;
	}

	public void setVariableType(int i) {
		variableType = i;
	}

	public String getVariableString() {
		return variableString;
	}

	public void setVariableString(String s) {
		variableString = s;
	}

	public Modchu_TextCalculationData getNextData() {
		return nextData;
	}

	public void setNextData(Modchu_TextCalculationData data1) {
		nextData = data1;
	}

	public Modchu_ReflectData getReflectData() {
		return reflectData;
	}

	public void setReflectData(Modchu_ReflectData modchu_ReflectData) {
		reflectData = modchu_ReflectData;
	}

	protected void setInitFlag(boolean b) {
		initFlag = b;
	}

	public static String replaceAllExceptInDoubleQuotation(String s, String s1, String s2) {
		if (s != null
				&& !s.isEmpty()); else return s;
		StringBuilder sb = new StringBuilder();
		boolean b = false;
		for (int i = 0; i < s.length(); i++) {
			String s3 = s.substring(i, i + s1.length());
			if (s3.equalsIgnoreCase("\"")) {
				b = !b;
				sb.append(s3);
			}
			else if (!b
					&& s3.equalsIgnoreCase(s1)) {
				if (s2 != null
						&& !s2.isEmpty()) sb.append(s2);
			} else {
				sb.append(s3);
			}
		}
		return sb.toString();
	}

}
