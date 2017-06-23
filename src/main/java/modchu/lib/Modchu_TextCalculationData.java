package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Modchu_TextCalculationData implements Modchu_ITextCalculationDataFormat {
	public final Object initObject;
	private Object data;
	private Object subData;
	private Modchu_TextCalculationData nextData;
	boolean initFlag = false;
	private boolean isRaw = false;
	private boolean isFixedValue = false;
	private boolean isVariable = false;
	private int maxSubDataListSize = 0;
	private int variableType = 0;
	private List<String> variableTypeStringList;
	private String variableString;
	private Object tempRawData;
	private boolean isTempRaw;
	private Modchu_ReflectData reflectData;

	public Modchu_TextCalculationData(Object o) {
		initObject = o;
		data = o;
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

	private void init(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (initFlag) return;
		initFlag = true;
		String s = null;
		Object data1 = getData();
		if (data1 instanceof String) {
			s = (String) data1;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init initObject="+initObject+" data1="+data1+" this="+this);
		Object subData = getSubData();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init subData="+subData);
		if (s != null
				&& !s.isEmpty()) {
			for (String s0 : variableTypeStringList) {
				if (s.startsWith(s0)
						&& s.indexOf(".") != s0.length()) {
					setVariable(true);
					setVariableType(variableTypeStringList.indexOf(s0));
					setVariableString(s.substring(s0.length()));
					if (debug) {
						Modchu_Debug.mDebug("Modchu_TextCalculationData init isVariable variableType="+variableType);
						Modchu_Debug.mDebug("Modchu_TextCalculationData init isVariable variableString="+variableString);
					}
					return;
				}
			}
		}
		if (subData != null
				&& subData instanceof List); else {
			//if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init else return. subData="+subData);
			//return;
			if (subData instanceof Modchu_RunCalculationList) {
				subData = ((Modchu_RunCalculationList) subData).getList();
			} else {
				subData = new ArrayList();
			}
		}
		List list1 = new ArrayList();
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
		if (isObjectArray()) {
			init_ObjectArray(list2, map);
		}
		if (s != null) {
			if (s.indexOf(".") > -1) {
				init_StringPeriod(list1, s, map);
			}
			if (s.indexOf(",") > -1) {
				init_StringComma(list1, s, map);
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
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init data1 instanceof String s="+s);
		} else if (data1 instanceof Modchu_TextCalculationFormula) {
			Modchu_TextCalculationFormula formula = (Modchu_TextCalculationFormula) data1;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init data1 instanceof Modchu_TextCalculationFormula formula.getDataString()="+formula.getDataString());
			formula.setInitFlag(false);
		}
		if (s != null
				&& s.indexOf(",") > -1) {
			String ss = "Modchu_TextCalculationData init s.indexOf(,) > -1 error !! s="+s+" isRaw()="+isRaw()+" getSubData()="+getSubData();
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData init isRaw()="+isRaw());
			Modchu_TextCalculation.instance.debugData("Modchu_TextCalculationData init end1. ", "data", getData());
			Modchu_TextCalculation.instance.debugData("Modchu_TextCalculationData init end2. ", "subData", getSubData());
		}
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
				runCalculationList.calculationObject(null, map);
				list.add(runCalculationList);
			}
			else if (o instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o;
				Object o2 = data1.calculationObject(null, map);
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
		if (s.indexOf(",") > -1) {
			return init_StringComma(list, s, map);
		} else {
			Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s);
			Object o2 = data1.calculationObject(null, map);
			initAddData(list, data1, o2);
		}
		return list;
	}

	protected List init_StringComma(List list, String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		String[] s0 = s.indexOf(",") > -1 ? s.split(",") : null;
		if (s0 != null); else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringComma s0 == null return.");
			return null;
		}
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
			Object o = data1.calculationObject(null, map);
			initAddData(list, data1, o);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringComma end. @FixedValueRawData getData()="+getData());
		setData("@FixedValueRawData");
		return list;
	}

	protected List init_StringPeriod(List list, String s, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		debug = true;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod s="+s);
		int i1 = s.lastIndexOf("F");
		int i2 = s.lastIndexOf("D");
		if (i1 > 0
				| i2 > 0) {
			if (s.length() > 1) {
				int i3 = i1 > 0 ? i1 : i2;
				String tempS = s.substring(i3 - 1, i3);
				if (Modchu_Main.integerCheck(tempS)) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod integerCheck return.");
					return list;
				}
			}
		}
		if (s.indexOf(".class") > -1) return list;
		if (s.equals("Math.PI")) return list;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod 2 s="+s);
		Modchu_TextCalculationData nextData1 = getNextData();
		Object o = nextData1 != null ? nextData1.getData() : null;
		if (o == null
				| !(o instanceof Modchu_RunCalculationList)) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod !(o instanceof Modchu_RunCalculationList) return. o="+o);
			return list;
		}
		Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o;
		//List<Modchu_TextCalculationData> list1 = new LinkedList();
		//list1.addAll(runCalculationList.getList());
		Modchu_ITextCalculationDataFormat data1 = runCalculationList.getList().get(0);
		String[] s0 = s.split("\\.");
		// classNameOrClass
		Modchu_TextCalculationData data2 = new Modchu_TextCalculationData(s0[0]);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod classNameOrClass s0[0]="+s0[0]);
		Object o1 = data2.calculationObject(null, map);
		o1 = Modchu_TextCalculation.instance.runCalculationAther(o1, map);
		if (o1 instanceof Modchu_TextCalculationData) {
			String ss = "Modchu_TextCalculationData init_StringPeriod o1 instanceof Modchu_TextCalculationData error !! data2.getData()="+data2.getData()+" data2.isRaw()="+data2.isRaw();
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return list;
		}
		boolean flag = o1 instanceof String;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod classNameOrClass o1="+o1);
		Object classNameOrClass = flag ? o1 : o1.getClass();
/*
		Modchu_TextCalculationData data3 = new Modchu_TextCalculationData(flag ? o1 : o1.getClass());
		data3.setRaw(!flag);
		data3.setInitFlag(!flag);
		list1.add(data3);
*/
		//methodOrFieldName
		String methodOrFieldName = s0[1];
/*
		Modchu_TextCalculationData data4 = new Modchu_TextCalculationData(s0[1]);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod methodOrFieldName s0[1]="+s0[1]);
		list1.add(data4);
*/
		//reflectObject
		Object reflectObject = o1;
/*
		Modchu_TextCalculationData data5 = new Modchu_TextCalculationData(o1);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod reflectObject o1="+o1);
		data5.setRaw(!flag);
		data5.setInitFlag(!flag);
		list1.add(data5);
*/
		//reflectClassArray
		Class[] reflectClassArray = null;
		for (Map map1 : map) {
			if (map1.containsKey(s0[1])) reflectClassArray = (Class[]) map1.get(s0[1]);
		}
		data1.calculationObject(null, map);
		List list3 = (List) ((Modchu_TextCalculationData) data1).getSubData();
		if (reflectClassArray != null) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod reflectClassArray map1.get reflectClassArray="+Modchu_Main.objectArrayToString(reflectClassArray));
		} else {
			reflectClassArray = new Class[list3.size()];
			for (int i = 0; i < list3.size(); i++) {
				Object o2 = Modchu_TextCalculation.instance.runCalculationAther(list3.get(i), map);
				reflectClassArray[i] = Modchu_Main.classToPrimitive(o2.getClass());
			}
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod reflectClassArray getClass reflectClassArray="+Modchu_Main.objectArrayToString(reflectClassArray));
		}
/*
		if (reflectClassArray != null) {
			Modchu_TextCalculationData data6 = new Modchu_TextCalculationData(reflectClassArray);
			data6.setRaw(true);
			data6.setInitFlag(true);
			list1.add(data6);
		}
*/
		//reflectObjectArray
		Object[] reflectObjectArray = null;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod reflectObjectArray list3="+list3);
		reflectObjectArray = Modchu_Main.listToObjectArray(list3);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod reflectObjectArray reflectObjectArray="+Modchu_Main.objectArrayToString(reflectObjectArray));
		//list1.add(data1);
		//runCalculationList.getList().addAll(list1);
		nextData1.setReflectData(new Modchu_ReflectData(classNameOrClass, methodOrFieldName, reflectClassArray, reflectObject, reflectObjectArray));
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod nextData1.getReflectData().dataToString()="+nextData1.getReflectData().dataToString());
		Modchu_TextCalculationFormula formula = Modchu_TextCalculationFormula.calculationFormulaMap.get("invokeMethod");
		formula.setInitFlag(true);
		//formula.calculationObject(null, this, map);
		setData(formula);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_StringPeriod end.");
		return list;
	}

	protected void init_ObjectArray(List list, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Object[] oo1 = init_ObjectArray_r(list, map);
		setData(oo1);
		if (oo1 instanceof Class[]) {
			setRaw(true);
		} else if (oo1 != null
				&& oo1.length > 0) {
			//checkRawAndFixedValue(oo1);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray end.");
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
/*
	protected void checkRawAndFixedValue(Object[] oo1) {
		checkRawAndFixedValue(Modchu_Main.objectArrayToLinkedList(oo1));
	}

	protected void checkRawAndFixedValue(List list) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		boolean flag = true;
		boolean flag1 = true;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData checkRawAndFixedValue start.");
			Modchu_Debug.mDebug("Modchu_TextCalculationData checkRawAndFixedValue data="+data+" data.getClass()="+(data != null ? data.getClass() : null));
		}
		if (list != null
				&& !list.isEmpty()) {
			for (Object o : list) {
				if (o instanceof Modchu_TextCalculationData) {
					Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData checkRawAndFixedValue data1="+data1+" data1.isRaw()="+data1.isRaw()+" data1.isFixedValue()="+data1.isFixedValue());
					if (!data1.isRaw()) flag = false;
					if (!data1.isFixedValue()) flag1 = false;
				} else if (o instanceof String) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData checkRawAndFixedValue o instanceof String o="+o);
				} else {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData checkRawAndFixedValue !(o instanceof Modchu_TextCalculationData) o="+o);
					flag = false;
					flag1 = false;
				}
			}
		} else {
			flag = false;
			flag1 = false;
		}
		setRaw(flag);
		setFixedValue(flag1);
	}
*/
	protected Object[] init_ObjectArray_r(List list, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (list != null
				&& !list.isEmpty()); else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r list == null !!");
			return null;
		}
		String s = data instanceof String ? (String) data : null;
		if (s != null
				&& !s.isEmpty()); else {
			String ss = "Modchu_TextCalculationData init_ObjectArray_r s == null error !! data="+data;
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return null;
		}
		if (s.toLowerCase().startsWith("new")) s = s.substring(3);
		Class c = Modchu_Reflect.loadClass(s.substring(0, s.length() - 2));
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r c="+c);
		if (c != null); else {
			String ss = "Modchu_TextCalculationData init_ObjectArray_r c == null error !! s="+s;
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return null;
		}
		Object[] oo1 = Modchu_Reflect.newInstanceArray(c, list.size());
		if (oo1 != null); else {
			String ss = "Modchu_TextCalculationData init_ObjectArray_r oo1 == null error !! c="+c+" list.size()="+list.size();
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return null;
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r oo1="+oo1);
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r list="+list);
			Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r list.size()="+list.size());
		}
		for (int i = 0; i < list.size(); i++) {
			Object o1 = list.get(i);
			if (o1 instanceof List) {
				List list1 = (List) o1;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o1 instanceof List start.");
				oo1 = init_ObjectArray_r(list1, map);
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o1 instanceof List oo1="+Modchu_Main.objectArrayToString(oo1));
					Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o1 instanceof List end.");
				}
				break;
			}
			Modchu_TextCalculationData data1 = o1 instanceof Modchu_TextCalculationData ? (Modchu_TextCalculationData) o1 : null;
			if (data1 != null); else {
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray set continue. getData()="+getData()+" getData().getClass()="+(getData() != null ? getData().getClass() : null));
					Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray set continue. o1="+o1+" o1.getClass()="+(o1 != null ? o1.getClass() : null));
					Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray set continue. c="+c);
				}
				if ((c != Object.class
						&& c != Class.class
								&& o1.getClass() != c)
						| (c == Class.class
						&& !(o1.getClass() instanceof Class))) {
					String ss = "Modchu_TextCalculationData init_ObjectArray_r o1.getClass() != c error !! o1.getClass()="+o1.getClass();
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return null;
				}
				oo1[i] = o1;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray set continue. oo1["+i+"]="+oo1[i]);
				continue;
			}
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r data1.getData()="+data1.getData());
			Object o3 = data1.calculationObject(null, map);
			if (o3 != null) {
				if (o3 instanceof List) {
					List list2 = (List) o3;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o3 instanceof List start.");
					oo1 = init_ObjectArray_r(list2, map);
					if (debug) {
						Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o3 instanceof List oo1="+Modchu_Main.objectArrayToString(oo1));
						Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o3 instanceof List end.");
					}
					break;
				}
				else if (o3 instanceof Object[]) {
					oo1 = (Object[]) o3;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o3 instanceof Object[] oo1="+Modchu_Main.objectArrayToString(oo1));
					break;
				}
				else if ((c != Object.class
						&& c != Class.class
								&& o3.getClass() != c)
						| (c == Class.class
						&& !(o3.getClass() instanceof Class))) {
					String ss = "Modchu_TextCalculationData init_ObjectArray_r o2.getClass() != c error !! o3.getClass()="+o3.getClass();
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return null;
				}
				oo1[i] = o3;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray oo1["+i+"]="+oo1[i]);
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o3 == null !! @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ data1.getData()="+data1.getData());
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r end. oo1="+Modchu_Main.objectArrayToString(oo1));
		return oo1;
	}

	protected boolean isObjectArray() {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Object data = getData();
		if (data instanceof String) {
			String s1 = (String) data;
			int i1 = s1.lastIndexOf("[]");
			if (i1 > -1
					&& i1 == s1.length() - 2) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData isObjectArray return true. data="+data);
				return true;
			}
		} else {
			if (data.getClass().isArray()) return true;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData isObjectArray return false. data="+data);
		return false;
	}

	@Override
	public Object calculationObject(Object o, Map... map) {
		return calculationObject(o, null, map);
	}

	protected Object calculationObject(Object o, Object o1, Map... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		init(o, o1, map);
		Object o2 = null;
		Modchu_TextCalculationFormula formula = null;
		Object data = getData();
		Object subData = getSubData();
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject initObject="+initObject);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data="+data);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject subData="+subData);
		}
		Modchu_TextCalculationData nextData1 = getNextData();
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject nextData1="+nextData1);
		boolean isSettingVariable = false;
		boolean isEndSettingSkip = false;
		if (isRaw()) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isLow data="+data);
			o2 = data;
		}
		else if (isVariable()) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isVariable return this="+this);
			isEndSettingSkip = true;
			o2 = this;
			if (nextData1 == null) {
				String ss = "Modchu_TextCalculationData calculationObject isVariable() nextData1 == null error !! o="+o+" o1="+o1+" data="+data;
				Modchu_Debug.mDebug(ss);
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
			}
		} else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject o1="+o1);
			Modchu_TextCalculationData data2 = null;
			Modchu_TextCalculationData data3 = null;
			if (o != null) {
				if (o instanceof Modchu_TextCalculationData) {
					data2 = (Modchu_TextCalculationData) o;
				}
			}
			if (o1 != null) {
				if (o1 instanceof Modchu_TextCalculationData) {
					data3 = (Modchu_TextCalculationData) o1;
				}
			}
			if (data instanceof List) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof List data="+data);
				o2 = data;
			}
			else if (data instanceof Modchu_RunCalculationList) {
				Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) data;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_RunCalculationList data="+data);
				o2 = runCalculationList.calculationObject(null, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_RunCalculationList return o2="+o2);
			}
			else if (data instanceof Modchu_TextCalculationFormula) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula data="+data);
				formula = (Modchu_TextCalculationFormula) data;
				boolean isOneValue = formula.isOneValue();
				boolean isTrigonometricFunction = formula.isTrigonometricFunction();
				boolean isReflect = formula.isReflect();
				boolean isVariable = formula.isVariable();
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula formula.getDataString()="+formula.getDataString());
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isOneValue="+isOneValue);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isTrigonometricFunction="+isTrigonometricFunction);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isReflect="+isReflect);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isVariable="+isVariable);
				}
				if (isVariable) {
					if (nextData1 != null) {
						o2 = formula.calculationObject(data3 != null ? data3 : data2, nextData1, map);
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isVariable o2="+o2);
						nextData1 = nextData1.getNextData();
						if (nextData1 != null) nextData1 = nextData1.getNextData();
						o1 = null;
						if (debug) {
							Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isVariable o="+o);
							Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isVariable nextData1="+nextData1);
						}
						isEndSettingSkip = true;
					}
				}
				else if (isReflect) {
					if (nextData1 != null) {
						o2 = formula.calculationObject(null, nextData1, map);
						if (debug) {
							Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isReflect nextData1="+nextData1);
							Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isReflect o2="+o2);
						}
						nextData1 = nextData1.getNextData();
					}
				}
				else if (isTrigonometricFunction) {
					if (nextData1 != null) {
						Object o3 = nextData1.getData();
						if (o3 instanceof Modchu_RunCalculationList) {
							Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o3;
							Object o5 = runCalculationList.calculationObject(null, map);
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isTrigonometricFunction o5="+o5);
							o2 = formula.calculationObject(null, o5, map);
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isTrigonometricFunction o2="+o2);
							nextData1 = nextData1.getNextData();
						} else {
							String ss = "Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isTrigonometricFunction !(o3 instanceof Modchu_RunCalculationList) error !! o3="+o3;
							Modchu_Debug.lDebug(ss);
							Modchu_Main.setRuntimeException(ss);
						}
					}
				}
				else if (isOneValue) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isOneValue.");
					if (o1 != null) {
						String ss = "Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula isOneValue o1 != null error !! o="+o+" o1="+o1;
						Modchu_Debug.mDebug(ss);
						Modchu_Debug.lDebug(ss);
						Modchu_Main.setRuntimeException(ss);
					}
					o2 = formula.calculationObject(null, map);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula o2="+o2);
				} else {
					o2 = this;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula o2 set this. o2="+o2);
					isEndSettingSkip = true;
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
					o2 = null;
				} else if (s.equalsIgnoreCase("@FixedValueRawData")) {
/*
					if (debug) {
						String ss = "Modchu_TextCalculationData calculationObject data instanceof String @FixedValueRawData error !! isRaw()="+isRaw()+" isFixedValue()="+isFixedValue()+" getSubData()="+getSubData();
						Modchu_Debug.mDebug(ss);
						Modchu_Debug.lDebug(ss);
						Modchu_Main.setRuntimeException(ss);
					}
*/
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String @FixedValueRawData return subData="+subData);
					o2 = subData;
				} else {
					if (s.startsWith("\"")) {
						s = s.replaceAll("\"", "");
						setData(s);
						setRaw(true);
						o2 = s;
					} else {
						int i1 = s.indexOf(".class");
						if (i1 > -1) {
							s = s.substring(0, i1);
							Class c = Modchu_Reflect.loadClass(s);
							setData(c);
							setRaw(true);
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String \".class\" c="+c);
							o2 = c;
						} else {
							i1 = s.indexOf("[]");
							if (i1 > -1) {
								s = s.substring(0, i1);
								List list = (List) subData;
								if (list != null) {
									Class c = s.equalsIgnoreCase("newClass") ? Class.class : s.equalsIgnoreCase("newObject") ? Object.class : Modchu_Reflect.loadClass(s);
									Object[] oo1 = c != null ? Modchu_Reflect.newInstanceArray(c, list.size()) :  new Object[list.size()];
									for (int i = 0; i < list.size(); i++) {
										Object o3 = getListCalculationObject(list, i, map);
										oo1[i] = o3;
									}
									data = oo1;
									setRaw(true);
								} else {
									String ss ="Modchu_TextCalculationData calculationObject s.indexOf(\"[]\") list == null error !! data="+data;
									Modchu_Debug.lDebug(ss);
									Modchu_Main.setRuntimeException(ss);
								}
								o2 = data;
								//isEndSettingSkip = true;
							} else {
								setTempRawData(null);
								setTempRaw(false);
								Object o3 = Modchu_RunCalculationList.getMapsObject(s, map);
								if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String getMapsObject o3="+o3);
								if (o3 != null) {
									setRaw(false);
									setTempRaw(true);
									setTempRawData(o3);
									o2 = this;
								} else {
									o3 = Modchu_RunCalculationList.getFieldOrMedhod(s, map);
									if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String getFieldOrMedhod o3="+o3);
									if (o3 != null) {
										setRaw(false);
										setTempRaw(true);
										setTempRawData(o3);
										o2 = this;
									} else {
										o2 = Modchu_Main.stringToSuitableObject(s);
										if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject o2="+o2);
										if (o2 instanceof String) {
											if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject o2 instanceof String null return String o2="+o2);
										} else {
											if (o2 != null) {
												if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject setData(o2). o2.getClass()="+o2.getClass());
												setData(o2);
												setRaw(true);
											}
										}
									}
								}
								if (o2 != null); else {
									o2 = null;
									if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o3 = null.");
								}
							}
						}
					}
				}
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject else data="+data);
				o2 = data;
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject 2 o1="+o1);
		if (o1 != null) {
			if (o1 instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data2 = (Modchu_TextCalculationData) o1;
				Object o3 = data2.getData();
				if (o3 != null
						&& o3 instanceof Modchu_TextCalculationFormula) {
					Modchu_TextCalculationFormula formula1 = (Modchu_TextCalculationFormula) o3;
					boolean isOneValue1 = formula1.isOneValue();
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject o3 instanceof Modchu_TextCalculationFormula isOneValue1="+isOneValue1);
					if (isOneValue1) {
					} else {
						if (o2 != null) {
							if (o2 instanceof Modchu_TextCalculationData) {
								Modchu_TextCalculationData data3 = (Modchu_TextCalculationData) o2;
								Object o4 = data3.getData();
								if (o4 != null
										&& o4 instanceof Modchu_TextCalculationFormula) {
									Modchu_TextCalculationFormula formula2 = (Modchu_TextCalculationFormula) o4;
									boolean isOneValue2 = formula2.isOneValue();
									if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject o4 instanceof Modchu_TextCalculationFormula isOneValue2="+isOneValue2);
									if (isOneValue2) {
									} else {
										Modchu_TextCalculationData nextData2 = data3.getNextData();
										if (nextData2 != null) {
											Object o5 = nextData2.calculationObject(null, map);
											if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject o4 instanceof Modchu_TextCalculationFormula o5="+o5);
											o2 = data3.calculationObject(null, o5, map);
											if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject o4 instanceof Modchu_TextCalculationFormula o2="+o2);
											nextData1 = nextData2.getNextData();
										}
									}
								}
							}
						}
						o = formula1.calculationObject(o, o2, map);
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject o3 instanceof Modchu_TextCalculationFormula o="+o);
						o2 = null;
						isEndSettingSkip = true;
					}
				}
			}
		}
		if (!isEndSettingSkip) {
			o = calculationObjectEndSetting(o, o2, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject 3 o="+o);
			o2 = null;
		}
		if (nextData1 != null) {
/*
			if (data instanceof Modchu_RunCalculationList
					&& nextData1.getData() != null
					&& nextData1.getData() instanceof String) {
				String ss ="Modchu_TextCalculationData calculationObject nextData1 debug data.dataToString="+((Modchu_RunCalculationList) data).dataToString(false)+" nextData1.getData()="+nextData1.getData();
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
			}
*/
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject 4 nextData1.getData()="+nextData1.getData());
			o = nextData1.calculationObject(o, o2, map);
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject end. o="+o);
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject end. isTempRaw()="+isTempRaw());
			if (isTempRaw()) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject end. getTempRawData()="+getTempRawData());
			Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject end. return");
		}
		return o;
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
		}
		else if (o1 instanceof Modchu_TextCalculationData) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getListCalculationObject o1 instanceof Modchu_TextCalculationData start.---------------------------------");
			Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o1;
			o2 = data1.calculationObject(null, map);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationData getListCalculationObject o1 instanceof Modchu_TextCalculationData o2="+o2);
				Modchu_Debug.mDebug("Modchu_TextCalculationData getListCalculationObject o1 instanceof Modchu_TextCalculationData end.---------------------------------");
			}
		}
		else if (o1 instanceof Modchu_RunCalculationList) {
			Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o1;
			o2 = runCalculationList.calculationObject(null, map);
		} else if (o1 instanceof String) {
			Modchu_RunCalculationList runCalculationList = Modchu_TextCalculation.instance.getTextCalculationList((String) o1);
			o2 = runCalculationList.calculationObject(null, map);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getListCalculationObject return o2="+o2);
		return o2;
	}

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
			if (isDebug) list.add("Modchu_TextCalculationData dataToStringList data instanceof Modchu_ITextCalculationDataFormat start.\n");
			list.add(((Modchu_ITextCalculationDataFormat) data).dataToString(b));
			if (isDebug) list.add("Modchu_TextCalculationData dataToStringList data instanceof Modchu_ITextCalculationDataFormat end.\n");
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

	public Object getSubData() {
		return subData;
	}

	public void setSubData(Object o) {
		Modchu_Debug.mDebug("Modchu_TextCalculationData setSubData o="+o);
		if (o != null) {
/*
			if (//isReflect()
					//	&&
					(o instanceof List)) {
				String ss = "Modchu_TextCalculationData setSubData subData instanceof List !! o="+o;
				Modchu_Debug.mDebug(ss);
				Modchu_Main.setRuntimeException(ss);
			}
*/
			if (subData != null
				&& o.getClass() != subData.getClass()) {
				String ss = "Modchu_TextCalculationData setSubData isReflect() o.getClass() != subData.getClass() !! o="+o+" subData="+subData;
				Modchu_Debug.mDebug(ss);
				//Modchu_Main.setRuntimeException(ss);
			}
		}
		subData = o;
	}

	public boolean isRaw() {
		return isRaw;
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
		isRaw = b;
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
		return isVariable;
	}

	@Override
	public void setVariable(boolean b) {
		isVariable = b;
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

}
