package modchu.lib;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Modchu_RunCalculationList implements Modchu_ITextCalculationDataFormat {
	static final byte type_Object = 0;
	static final byte type_Integer = 1;
	static final byte type_Float = 2;
	static final byte type_Double = 3;
	static final byte type_Long = 4;
	static final byte type_Byte = 5;
	static final byte type_Boolean = 6;
	static final byte type_If = 7;
	public final int maxLoop = 64;
	private String initString;
	private List<Modchu_ITextCalculationDataFormat> list;
	private boolean isIf;
	private boolean initFlag;
	private boolean isMultipleLines;
	private boolean isElse;
	private boolean isOneValue;

	Modchu_RunCalculationList(String s) {
		initString = s;
	}

	Modchu_RunCalculationList(List<Modchu_ITextCalculationDataFormat> list1) {
		list = checkList(list1);
	}

	private List<Modchu_ITextCalculationDataFormat> checkList(List list1) {
		if (list1 != null
				&& !list1.isEmpty())
		for (Object o : list1) {
			if (o instanceof List) {
				list1 = checkList((List) o);
				break;
			}
			else if (!(o instanceof Modchu_ITextCalculationDataFormat)) {
				String ss ="Modchu_RunCalculationList	init	checkList error !! o="+o;
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
			}
		}
		return list1;
	}

	private void init(Map... map) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		//boolean debug1 = true;
		String debugS = "Modchu_TextCalculation_getTextCalculationListDebug"+initString;
		boolean debug1 = !(Modchu_Debug.getFreeVariable(debugS) != null);
		Modchu_Debug.setFreeVariable(debugS, true);
		if (debug) {
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipLog = true;
			Object temp = Modchu_Debug.getFreeVariable("debugGetTextCalculationListInit");
			boolean initDebug = false;
			if (temp != null) {
				initDebug = (Boolean) temp;
			}
			if (!initDebug) {
				Modchu_Debug.registerListString("Calculation");
				Modchu_Debug.setFreeVariable("debugGetTextCalculationListInit", true);
			}
			Modchu_Debug.mDebug("Modchu_RunCalculationList	init	------------------- start.");
			Modchu_Debug.mDebug("Modchu_RunCalculationList	init	initString="+initString);
		}
		if (initFlag) return;
		initFlag = true;
		if (list != null); else list = new LinkedList();
		if (initString != null); else return;
/*
		if (initString.indexOf("(") > -1
				&& initString.indexOf(")") > -1) {
			List list = new LinkedList();
			List<String> tempList = new LinkedList();
			tempList.add(initString);
			for (int i = 0; i < maxLoop; i++) {
				init_brackets(list, tempList);
				if (tempList.isEmpty()) {
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	init	tempList.isEmpty() break.");
					break;
				}
			}
		} else {
*/
			Modchu_TextCalculationData data = new Modchu_TextCalculationData(initString);
			list.add(data);
		//}

		//Modchu_Debug.mDebug("Modchu_RunCalculationList	init	debug="+debug+" debug1="+debug1);
		if (debug
				&& debug1) {
			//Modchu_TextCalculation.instance.debugData("Modchu_RunCalculationList	init	@@@debugData@@@	", "runCalculationList", runCalculationList);
			//Modchu_Debug.mDebug("Modchu_RunCalculationList	init	@@@debugData@@@	end.\n\n\n\n\n\n\n\n\n\n");
			//Modchu_Debug.mDebug("Modchu_RunCalculationList	init	Modchu_Main.isRelease()="+Modchu_Main.isRelease());
			if (!Modchu_Main.isRelease()) Modchu_Debug.setClipboardLog();
		} else {
			//String ss = "Modchu_RunCalculationList	init debug debug="+debug+" debug1="+debug1;
			//Modchu_Debug.mDebug(ss);
			//Modchu_Main.setRuntimeException(ss);
		}
	}

	protected void settingTextCalculationList_r(List list, List<String> list1) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		String s = list1.get(0);
		list1.remove(0);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	------------------ start.");
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	s="+s);
		}
		List list2 = getCalculationDataList(s);
		if (list2 != null
				&& !list2.isEmpty()) {
			list.addAll(list2);
			if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	list.add list2="+Modchu_Main.listToString(list2));
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	"+s+" list.size()="+list.size());
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	------------------ end.");
		}
	}

	protected List getCalculationDataList(String s) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getCalculationDataList	----------------- start.");
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getCalculationDataList	s="+s);
		}
		List list = new LinkedList();
		List tempList = getCalculationDataStringList(s);
		if (tempList != null
				&& !tempList.isEmpty()) {
			for (int i = 0; i < maxLoop; i++) {
				settingCalculationData_r(list, tempList);
				if (tempList.isEmpty()) {
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getCalculationDataList	tempList.isEmpty() break.");
					break;
				}
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getCalculationDataList	list.size()="+list.size());
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getCalculationDataList	----------------- end.");
		}
		return list;
	}

	protected List getCalculationDataStringList(String s) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getCalculationDataStringList	----------------- start.");
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getCalculationDataStringList	s="+s);
		}
		List tempList = new LinkedList();
		List<String> tempList1 = new LinkedList();
		tempList1.add(s);
		for (int i = 0; i < maxLoop; i++) {
			calculationDataStringList_r(tempList, tempList1);
			if (tempList1.isEmpty()) {
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getCalculationDataStringList	tempList.isEmpty() break.");
				break;
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getCalculationDataStringList	s="+s+" tempList="+tempList);
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getCalculationDataStringList	----------------- end.");
		}
		return tempList;
	}

	protected void calculationDataStringList_r(List list, List<String> list1) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		String s = list1.get(0);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	---------------- start.");
			Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	s="+s);
		}
		list1.remove(0);
		boolean commaFlag = s.indexOf(",") < 0
				| s.indexOf("(") > -1;
		if (commaFlag) {
			List<String> list2 = Modchu_Main.copyList(Modchu_TextCalculationFormula.allCalculationStringList);
			list2.add(0, "(");
			list2.add("newClass[]");
			list2.add("newObject[]");
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
			if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	1 i="+i+" i1="+i1+" s1="+s1);
			if (i1 > -1) {
				String s3 = i1 > 0 ? s.substring(0, i1) : null;
				if (s3 != null
						&& !s3.isEmpty()) {
					if (debug) {
						Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r list.add s3="+s3);
					}
					list.add(s3);
				}
				String s5 = s.substring(i1 + s1.length());
				boolean flag = i == 0;
				boolean isClassArrayOrObjectArrayFlag = i >= list2.size() - 2;
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	isClassArrayOrObjectArrayFlag="+isClassArrayOrObjectArrayFlag+" i="+i+" list2.size() - 2="+(list2.size() - 2));
				List list3 = null;
				if (flag
						| isClassArrayOrObjectArrayFlag) {
					if (isClassArrayOrObjectArrayFlag) {
						if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	isClassArrayOrObjectArrayFlag	list.add s1="+s1);
						list.add(s1);
					}
					list3 = new LinkedList();
					List list4 = new LinkedList();
					Object[] o1 = flag ? Modchu_Main.getInsideParenthesesData(s) : Modchu_Main.getInsideParenthesesData(s, "{", "}");
					String s7 = Modchu_CastHelper.String(o1[0]);
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	s7="+s7);
					if (s7 != null
							&& !s7.isEmpty()) {
						int i2 = Modchu_CastHelper.Int(o1[2]);
						list3.add(s7);
						for (int i3 = 0; i3 < maxLoop; i3++) {
							calculationDataStringList_r(list4, list3);
							if (list3.isEmpty()) {
								if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	list3.isEmpty() break.");
								break;
							}
						}
						list.add(list4);
						if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	flag list.add list4="+Modchu_Main.listToString(list4));
						s5 = s.substring(i2 + 1);
					}
				} else {
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	!flag s3="+s3+" s1="+s1+" s5="+s5);
					if (s1 != null
							&& !s1.isEmpty()) {
						if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	!flag list.add s1="+s1);
						list.add(s1);
					}
				}
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	s5="+s5);
				if (s5.startsWith(",")) {
					s5 = s5.substring(1);
				}
				int i3 = s5.lastIndexOf(",");
				if (i3 > -1
						&& i3 == s5.length() - 1) {
					s5 = s5.substring(0, i3);
				}
				if (s5 != null
						&& !s5.isEmpty()) {
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	list1.add s5="+s5+" s5.startsWith(\",\")="+s5.startsWith(",")+" s5.startsWith(\"\\,\")="+s5.startsWith("\\,"));
					list1.add(s5);
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	list1="+Modchu_Main.listToString(list1));
				}
				if (debug) {
					Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	s="+s);
					Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	---------------- end. 2");
				}
				return;
			}
		}
		if (s != null
				&& !s.isEmpty()) {
			if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	list.add s="+s);
			list.add(s);
			if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	list="+Modchu_Main.listToString(list));
		}
		if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationDataStringList_r	---------------- end. 3");
		return;
	}

	protected void settingCalculationData_r(List list, List list1) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		Object o2 = list1.get(0);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	---------------- start.");
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	o2="+Modchu_Main.objectToString(o2));
		}
		list1.remove(0);
		Object o = list.size() > 0 ? list.get(list.size() - 1) : null;
		Modchu_TextCalculationData data = o != null && o instanceof Modchu_TextCalculationData ? (Modchu_TextCalculationData) o : null;
		boolean flag1 = data != null
				&& ((data.getMaxSubDataListSize() > 0
						&& data.getSubData() != null
						&& data.getSubData() instanceof List
						&& data.getSubData().size() < data.getMaxSubDataListSize()));
		if (debug) {
			Modchu_TextCalculation.instance.debugData("Modchu_RunCalculationList	settingCalculationData_r	----- debugData -----	", "list", list);
			Modchu_TextCalculation.instance.debugData("Modchu_RunCalculationList	settingCalculationData_r	----- debugData -----	", "data", data);
		}
		if (o2 instanceof List) {
			List list2 = (List) o2;
			List list3 = new LinkedList();
			for (int i = 0; i < maxLoop; i++) {
				settingCalculationData_r(list3, list2);
				if (list2.isEmpty()) {
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	list2.isEmpty() break.");
					break;
				}
			}
			if (!list3.isEmpty()) {
				if (flag1) {
					if (list.size() < 1) {
						String ss = "Modchu_RunCalculationList	settingCalculationData_r	o2 instanceof List	list.size() < 1 error !!";
						if (debug) Modchu_Debug.mDebug(ss);
						Modchu_Main.setRuntimeException(ss);
						return;
					}
					List list4 = data.getSubData();
					list4.add(list3);
					data.setSubData(list4);
					if (debug) {
						Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	o2 instanceof List	!data.isReflect() list4.add list3="+Modchu_TextCalculation.instance.dataToString(list3, false));
						Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	o2 instanceof List	!data.isReflect() data.setSubData list4="+Modchu_TextCalculation.instance.dataToString(list4, false));
					}
				} else {
					list.add(list3);
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	o2 instanceof List	list.add list3="+list3);
				}
			}
		} else if (o2 instanceof String) {
			String s = (String) o2;
			if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	o2 instanceof String	s="+s);
			boolean flag = false;
			// TODO last
			if (s.indexOf("[]") > -1
					&& s.indexOf("[]") == s.length() - 2) {
				Modchu_TextCalculationData data2 = null;
				data2 = new Modchu_TextCalculationData(s);
				if (debug) {
					Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	o2 instanceof String	\"[]\" s="+s);
					Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	o2 instanceof String	\"[]\" data2="+data2);
				}
				data2.setMaxSubDataListSize(1);
				List list2 = new LinkedList();
				data2.setSubData(list2);
				if (flag1) {
					Object o3 = data.getSubData();
					List list3 = o3 != null ? (List) o3 : new LinkedList();
					list3.add(data2);
					data.setSubData(list3);
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	o2 instanceof String	\"=\"	\"[]\"	data.setSubData list3.add data.getData()="+data.getData()+" data="+data);
				} else {
					list.add(data2);
				}
			}
			else {
				if (!flag) {
					if (flag1) {
						List list3 = new LinkedList();
						settingCalculationData_r_s(list3, list1, s);
						Object o1 = list3 != null
								&& !list3.isEmpty() ? list3.get(0) : null;
						if (debug) Modchu_TextCalculation.instance.debugData("Modchu_RunCalculationList	settingCalculationData_r	o2 instanceof String	isOperatorStringFlag | isReflect	----- debugData -----	", "o1", o1);
						if (o1 != null) {
							Object o3 = data.getSubData();
							List list4 = o3 != null ? (List) o3 : new LinkedList();
							list4.add(o1);
							data.setSubData(list4);
							if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	o2 instanceof String	isOperatorStringFlag | isReflect	data.setSubData list.add data.getData()="+data.getData()+" data="+data);
						}
					} else {
						settingCalculationData_r_s(list, list1, s);
					}
				}
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	o2="+Modchu_Main.objectToString(o2));
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r	---------------- end.");
		}
		return;
	}

	protected void settingCalculationData_r_s(List list, List list1, String s) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s	--------------- start.");
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s	s="+s);
		}
		boolean commaFlag = s.indexOf(",") < 0
				| s.indexOf("(") > -1
				| s.indexOf("{") > -1;
		if (commaFlag) {
			List<String> list2 = new LinkedList();
			list2.addAll(Modchu_TextCalculationFormula.calculationTrigonometricFunctionStringList);
			list2.addAll(Modchu_TextCalculationFormula.calculationStringList);
			list2.addAll(Modchu_TextCalculationFormula.calculationOperatorStringList);
			if (settingCalculationData_r_s_ListString(list, list1, list2, s)) {
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s	true	--------------- end.");
				return;
			}
		}
		Modchu_TextCalculationData data = new Modchu_TextCalculationData(s);
		if (data != null) {
			list.add(data);
			if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s	list.add data="+data+" data="+data.getData());
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s	s="+s);
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s	--------------- end. 3");
		}
	}

	protected boolean settingCalculationData_r_s_ListString(List list, List list1, List<String> list2, String s) {
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s_ListString	--------------- start.");
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s_ListString	s="+s);
		}
		for (String tempS : list2) {
			if (s.startsWith(tempS)) {
				Modchu_TextCalculationFormula formula = Modchu_TextCalculationFormula.calculationFormulaMap.get(tempS);
				if (formula != null) {
					list.add(new Modchu_TextCalculationData(formula));
					if (debug) {
						Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s_ListString	new Modchu_TextCalculationData(formula) list.add s="+s);
						Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s_ListString	return true	--------------- end.");
					}
					return true;
				}
			}
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s_ListString	s="+s);
			Modchu_Debug.mDebug("Modchu_RunCalculationList	settingCalculationData_r_s_ListString	return false	--------------- end.");
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
		boolean debug = Modchu_TextCalculation.instance.tempDebug;
		if (list != null
				&& !list.isEmpty()); else return null;
		List<Modchu_TextCalculationData> list1 = new LinkedList();
		for (Object o : list) {
			Modchu_TextCalculationData data1 = null;
			if (o instanceof List) {
				List list3 =  (List) o;
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationListTrigonometricFunctionCheck o instanceof List list3="+Modchu_Main.listToString(list3));
				Modchu_RunCalculationList runCalculationList1 = calculationListToTextCalculationData(list3);
				data1 = new Modchu_TextCalculationData(runCalculationList1);
			}
			else if (o instanceof Modchu_TextCalculationData) {
				data1 =  (Modchu_TextCalculationData) o;
			} else {
				data1 = new Modchu_TextCalculationData(o);
			}
			if (data1 != null) {
				list1.add(data1);
			}
		}
		if (list.size() > 1)
		for (int i = 0; i < list1.size() - 1; i++) {
			Modchu_TextCalculationData data2 = list1.get(i);
			Modchu_TextCalculationData data3 = list1.get(i + 1);
			data2.setNextData(data3);
			list1.set(i, data2);
		}
		List<Modchu_ITextCalculationDataFormat> list2 = new LinkedList();
		if (list1 != null
				&& !list1.isEmpty()); else return null;
		Modchu_TextCalculationData data = list1.get(0);
		list2.add(data);
		Modchu_RunCalculationList runCalculationList = new Modchu_RunCalculationList(list2);
		if (debug) {
			//Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationListToTextCalculationData	data.getNextData()="+data.getNextData());
			//Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationListToTextCalculationData	data.getNextData().getNextData()="+data.getNextData().getNextData());
			Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationListToTextCalculationData	runCalculationList="+runCalculationList);
			Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationListToTextCalculationData	end.");
		}
		return runCalculationList;
	}

	String calculationListToString(Modchu_RunCalculationList runCalculationList, boolean b) {
		boolean debug = Modchu_TextCalculation.instance.debugSetting
				| Modchu_TextCalculation.instance.debugCE;
		if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationListToString	start.");
		List<Modchu_ITextCalculationDataFormat> list = runCalculationList.getList();
		if (list != null
				&& !list.isEmpty()); else return null;
		StringBuilder sb = new StringBuilder();
		if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationListToString	list="+list);
		for (Modchu_ITextCalculationDataFormat data : list) {
			if (debug) {
				if (data instanceof Modchu_TextCalculationData) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationListToString	data.getData()="+((Modchu_TextCalculationData) data).getData());
			}
			sb.append(data.dataToString(b));
		}
		if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationListToString	end. sb.toString()="+sb.toString());
		return sb.toString();
	}

	@Override
	public Object calculationObject(Map... map) {
		//Modchu_TextCalculation.tempDebug = true;
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationObject	start.");
			Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationObject	dataToString(true)="+dataToString(true));
		}
		init(map);
		List<Modchu_ITextCalculationDataFormat> list = getList();
		if (list != null
				&& !list.isEmpty()); else return null;
		Object o = null;
		try {
/*
			if (debug
					&& isMultipleLines()) {
				Modchu_Debug.mDebug("Modchu_RunCalculationList calculationObject list="+list);
				for (int i5 = 0; i5 < list.size(); i5++) {
					Modchu_TextCalculationData data5 = list.get(i5);
					Object o5 = data5.getData();
					Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o5;
					Modchu_Debug.mDebug("Modchu_RunCalculationList calculationObject list debug runCalculationList="+runCalculationList);
					runCalculationList.debugData("Modchu_RunCalculationList calculationObject list debug", "runCalculationList"+i5);
				}
			}
*/
			boolean skipFlag = false;
			for (int i = 0; i < list.size(); i++) {
				Modchu_ITextCalculationDataFormat data = list.get(i);
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList calculationObject ["+i+" / "+(list.size() - 1)+"] start. data="+data);
				if (isMultipleLines()) {
					Object o1 = ((Modchu_TextCalculationData) data).getData();
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList calculationObject ["+i+" / "+(list.size() - 1)+"] o1="+o1);
					if (o1 instanceof Modchu_RunCalculationList) {
						Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o1;
						if (runCalculationList.isIf()) {
							if (skipFlag) break;
							Object o2 = data.calculationObject(map);
							if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList calculationObject ["+i+" / "+(list.size() - 1)+"] isIf() o2="+o2);
							if (o2 instanceof Boolean) {
								skipFlag = !(Boolean) o2;
								if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList calculationObject ["+i+" / "+(list.size() - 1)+"] isIf() o2 instanceof Boolean skipFlag="+skipFlag);
							} else {
								skipFlag = true;
							}
						} else if (runCalculationList.isElse()) {
							if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList calculationObject ["+i+" / "+(list.size() - 1)+"] isElse() skipFlag="+skipFlag);
							if (skipFlag) {
								skipFlag = false;
							} else {
								break;
							}
						} else if (!skipFlag) {
							if (debug) {
								Modchu_Debug.mDebug("Modchu_RunCalculationList calculationObject ["+i+" / "+(list.size() - 1)+"] !skipFlag data.dataToString="+data.dataToString(false));
								Modchu_Debug.mDebug("Modchu_RunCalculationList calculationObject ["+i+" / "+(list.size() - 1)+"] !skipFlag data.getNextData()="+((Modchu_TextCalculationData) data).getNextData());
							}
							Object o2 = data.calculationObject(map);
						}
					} else {
						String ss ="Modchu_RunCalculationList	calculationObject	isMultipleLines() && o1 !Modchu_RunCalculationList error !! o1="+o1;
						Modchu_Debug.lDebug(ss);
						Modchu_Main.setRuntimeException(ss);
						break;
					}
				} else {
					o = data.calculationObject(map);
				}
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList calculationObject ["+i+" / "+(list.size() - 1)+"] end. o="+o);
			}
		} catch (Error e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		o = Modchu_TextCalculation.instance.getTextCalculationDataTempRawData(o);
		if (debug) {
			Modchu_Debug.writerList("Calculation");
			Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationObject	end. dataToString(true)="+dataToString(true));
			if (o instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data = (Modchu_TextCalculationData) o;
				Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationObject	end. data="+data);
				Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationObject	end. data.getData()="+data.getData());
				Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationObject	end. data.initObject="+data.initObject);
			}
			Modchu_Debug.mDebug("Modchu_RunCalculationList	calculationObject	end. return o="+(o != null
					&& o instanceof Object[] ? Modchu_Main.objectArrayToString((Object[]) o) : o)+"\n");
		}
		return o;
	}

	public static Object getMapsObject(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		boolean flag = false;
		if (s != null
				&& !s.isEmpty()); else return null;
		if (map != null
				&& map.length > 0)
		for (Map map1 : map) {
			if (map1 != null
					&& map1.containsKey(s)) {
				//debug = s.equals("motionY");
				Object o = map1.get(s);
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getMapsObject	get o="+Modchu_Main.objectToString(o));
				if (o != null) {
					if (s.indexOf("debaf") > -1) {
						int i2 = s.length() > 5 ? Modchu_CastHelper.Int(s.substring(5)) : 0;
						//Modchu_Debug.mDebug("Modchu_RunCalculationList	getMapsObject i2="+i2);
						if (i2 < 4) Modchu_Debug.dDebug("debaf1="+Modchu_Debug.debaf1+" debaf2="+Modchu_Debug.debaf2+" debaf3="+Modchu_Debug.debaf3);
						else Modchu_Debug.dDebug("debaf4="+Modchu_Debug.debaf4+" debaf5="+Modchu_Debug.debaf5+" debaf6="+Modchu_Debug.debaf6, 1);
					}
					return o;
				}
			} else {
				//if (debug) Modchu_Debug.mDebug(Modchu_RunCalculationList	getMapsObject	!map1.containsKey s="+s);
			}
		}
		return null;
	}

	public static Object getFieldOrMedhod(String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod s="+s);
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod map[0]="+(map != null && map.length > 0 ? map[0] : null));
		}
		if (s != null
				&& !s.isEmpty()); else return null;
		String fieldOrMedhodName = null;
		String objectName = s;
		if (s.indexOf("{") > -1
				&& s.indexOf("}") > -1) {
			if (s.startsWith("newClass")) {
				Class[] c0 = new Class[1];
				Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod newClass s="+s);
				return c0;
			}
			if (s.startsWith("newObject")) {
				Object[] c0 = new Object[1];
				return c0;
			}
		}
		else if (s.startsWith("[")) {
			int i1 = s.indexOf("]");
			if (i1 > -1) {
				objectName = s.substring(1, i1);
				s = s.length() > i1 + 1 ? s.substring(i1 + 1) : null;
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod objectName="+objectName);
		Object[] o4 = Modchu_Main.getArrayIntAndString(s);
		if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod o4="+Modchu_Main.objectArrayToString(o4));
		int i3 = -1;
		if (o4 != null
				&& o4.length > 1) {
			s = Modchu_CastHelper.String(o4[0]);
			i3 = Modchu_CastHelper.Int(o4[1]);
			if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod ArrayIntAndString s="+s+" i3="+i3);
		}
		int i1 = s.indexOf(".");
		String[] s0 = i1 > -1 ? s.split("\\.") : new String[]{ s };
		if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod s0="+s0);
		Object o = null;
		if (map != null
				&& map.length > 0)
		for (Map map1 : map) {
			if (map1 != null
					&& map1.containsKey(s)) {
				o = map1.get(s);
				break;
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod map1.get o="+o);
		if (o != null
				| (objectName != null
				&& objectName.equals("null"))); else {
			String temp = "ObjectDefault";
			if (map != null
					&& map.length > 0)
			for (Map map1 : map) {
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod ObjectDefault map1="+map1);
				if (map1.containsKey(temp)) {
					o = map1.get(temp);
					break;
				}
			}
			if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod ObjectDefault map1.get o="+o);
		}
		for (String element : s0) {
			String s2 = element;
			//debug = s2.equalsIgnoreCase("rotateAngleX");
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
				Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod getUnownReflection s2="+s2);
				Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod getUnownReflection o="+o);
				Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod getUnownReflection o5="+Modchu_Main.objectArrayToString(o5));
			}
			if (s2 != null
					&& o != null) {
				if (debug) {
					Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod getUnownReflection o.getClass().getName()="+o.getClass().getName());
					if (o instanceof Modchu_ModelBaseMaster) Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod Modchu_ModelBaseMaster o.onGrounds[0]="+((Modchu_ModelBaseMaster) o).onGrounds[0]);
					else Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod !Modchu_ModelBaseMaster o="+o);
				}
				o = Modchu_Reflect.getUnownReflection(o.getClass().getName(), s2, null, o, o5, -2);
			}
			if (i3 > -1
					&& o != null
					&& o.getClass().isArray()) {
				o = Array.get(o, i3);
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod Array.get o="+o);
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod end. o="+o);
		return o;
	}

	public static byte getType(Object o) {
		if (o != null) {
			if (o instanceof Integer) return type_Integer;
			if (o instanceof Float) return type_Float;
			if (o instanceof Double) return type_Double;
			if (o instanceof Long) return type_Long;
			if (o instanceof Byte) return type_Byte;
			if (o instanceof Boolean) return type_Boolean;
			return type_Object;
		}
		return (byte) -1;
	}

	public static Object getTypeDefaultValue(byte by) {
		return by == type_Integer ? 0 :
			by == type_Float ? 0.0F :
				by == type_Double ? 0.0D :
					by == type_Long ? 0L :
						by == type_Byte ? (byte) 0 :
							by == type_Object ? null :
								by == type_If ? null :
							true;
	}

	public List<Modchu_ITextCalculationDataFormat> getList() {
		return list;
	}

	public boolean isIf() {
		return isIf;
	}

	public void setIsIf(boolean b) {
		isIf = b;
	}

	@Override
	public boolean isOneValue() {
		return isOneValue;
	}

	public void setOneValue(boolean b) {
		isOneValue = b;
	}

	@Override
	public String dataToString(boolean b) {
		boolean flag = !isIf()
				&& b;
		StringBuilder sb = new StringBuilder();
		List<String> list = dataToStringList(b, false);
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString();
	}

	@Override
	public List<String> dataToStringList(boolean b, boolean isDebug) {
		List<String> list = new LinkedList();
		boolean flag = !isIf()
				&& b;
		if (flag) list.add("(");
		list.add(calculationListToString(this, flag));
		if (flag) list.add(")");
		return list;
	}

	@Override
	public void debugData(String s, String s1) {
		String s2 = s + " " + s1;
		List<Modchu_ITextCalculationDataFormat> list = getList();
		Modchu_Debug.mDebug(s2+" list="+list);
		if (list != null
				&& !list.isEmpty())
		for (Modchu_ITextCalculationDataFormat data : list) {
			data.debugData(s, s1);
		}
	}

	public boolean isMultipleLines() {
		return isMultipleLines;
	}

	public void setIsMultipleLines(boolean b) {
		isMultipleLines = b;
	}

	@Override
	public boolean isVariable() {
		List<Modchu_ITextCalculationDataFormat> list = getList();
		for (Modchu_ITextCalculationDataFormat data : list) {
			if (!data.isVariable()) return false;
		}
		return true;
	}

	@Override
	public void setVariable(boolean b) {
	}

	public boolean isElse() {
		return isElse;
	}

	public void setIsElse(boolean b) {
		isElse = b;
	}

}
