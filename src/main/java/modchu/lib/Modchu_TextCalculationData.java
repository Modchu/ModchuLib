package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Modchu_TextCalculationData implements Modchu_ITextCalculationDataFormat {
	private Object data;
	private Object subData;
	private boolean initFlag = false;
	private boolean isOperatorStringFlag = false;
	private boolean isRaw = false;
	private boolean isFixedValue = false;
	private boolean isVariable = false;
	private int maxSubDataListSize = 0;
	private int variableType = 0;
	private List<String> variableTypeStringList;
	private String variableString;

	public Modchu_TextCalculationData(Object o) {
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

	@Override
	public void init(Object o, Object o1, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (initFlag) return;
		initFlag = true;
		String s = null;
		Object data1 = getData();
		if (data1 instanceof String) {
			s = (String) data1;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init data1="+data1+" this="+this);
		Object subData = getSubData();
		if (s != null
				&& !s.isEmpty()) {
			for (String s0 : variableTypeStringList) {
				if (s.startsWith(s0)
						&& s.indexOf(".") != s0.length()) {
					setVariable(true);
					variableType = variableTypeStringList.indexOf(s0);
					variableString = s.substring(s0.length());
					if (subData != null); else {
						String ss = "Modchu_TextCalculationData init variable subData == null error !!";
						Modchu_Debug.mDebug(ss);
						Modchu_Debug.lDebug(ss);
						Modchu_Main.setRuntimeException(ss);
						return;
					}
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init variable subData="+subData);
					Modchu_RunCalculationList runCalculationList = null;
					if (subData instanceof Modchu_RunCalculationList) {
						runCalculationList = (Modchu_RunCalculationList) subData;
					}
					else if (subData instanceof List) {
						List list = (List) subData;
						for (Object o3 : list) {
							if (!(o3 instanceof Modchu_TextCalculationData)) {
								String ss = "Modchu_TextCalculationData init variable !(o instanceof Modchu_TextCalculationData) error !! o3="+o3;
								Modchu_Debug.mDebug(ss);
								Modchu_Debug.lDebug(ss);
								Modchu_Main.setRuntimeException(ss);
								return;
							}
						}
						runCalculationList = new Modchu_RunCalculationList(list);
					}
					runCalculationList.calculationObject(null, null, by, map);
					setSubData(runCalculationList);
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
			init_List(list3, list2, by, map);
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
			init_ObjectArray(list2, by, map);
		}
		if (s != null
				&& s.indexOf(",") > -1) {
			init_String_r(list1, s, by, map);
		}
		if (list1 != null) {
			if (list2 != null) list1.addAll(list2);
			if (!list1.isEmpty()) {
				setSubData(list1);
			}
		}
		//checkRawAndFixedValue(list1);
		if (isFixedValue()) {
			if (isRaw()) {
				data1 = getData();
				if (data1 instanceof String
						&& ((String) data1).indexOf(",") > -1) {
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init isFixedValue() and isRaw() data1="+data1);
				}
			} else {
				setRaw(true);
			}
		}
		data1 = getData();
		if (data1 instanceof String) {
			s = (String) data1;
		} else if (data1 instanceof Modchu_TextCalculationFormula) {
			Modchu_TextCalculationFormula formula = (Modchu_TextCalculationFormula) data1;
			Object o2 = formula.calculationObject(null, getSubData(), by, map);
		}
		if (s != null
				&& s.indexOf(",") > -1) {
			String ss = "Modchu_TextCalculationData init s.indexOf(,) > -1 error !! s="+s+" isRaw()="+isRaw()+" isFixedValue()="+isFixedValue()+" getSubData()="+getSubData();
			Modchu_Debug.mDebug(ss);
			Modchu_Debug.lDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData init isRaw()="+isRaw());
			Modchu_Debug.mDebug("Modchu_TextCalculationData init isFixedValue()="+isFixedValue());
			Modchu_TextCalculation.instance.debugData("Modchu_TextCalculationData init end1. ", "data", getData());
			Modchu_TextCalculation.instance.debugData("Modchu_TextCalculationData init end2. ", "subData", getSubData());
		}
	}

	private List init_List(List list, List list1, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (list1 != null
				&& !list1.isEmpty())
		for (int i = 0; i < list1.size(); i++) {
			Object o = list1.get(i);
			if (o instanceof List) {
				List list2 = (List) o;
				init_List(list, list2, by, map);
			}
			else if (o instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o;
				Object o1 = data1.calculationObject(null, data1.getSubData(), by, map);
				initAddData(list, data1, o1);
			}
			else if (o instanceof String) {
				String s2 = (String) o;
				List o1 = init_String(list, s2, by, map);
			}
		}
		return list;
	}

	private List init_String(List list, String s, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (s.indexOf(",") > -1) {
			return init_String_r(list, s, by, map);
		} else {
			Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s);
			Object o = data1.calculationObject(null, data1.getSubData(), by, map);
			initAddData(list, data1, o);
		}
		return list;
	}

	private List init_String_r(List list, String s, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		String[] s0 = s.indexOf(",") > -1 ? s.split(",") : null;
		if (s0 != null); else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_String_r s0 == null return.");
			return null;
		}
		for (int i = 0; i < s0.length; i++) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_String_r 1 s0["+i+"]="+s0[i]);
			if (s0[i] != null
					&& !s0[i].isEmpty()); else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_String_r s0["+i+"]="+s0[i]+" continue.");
				continue;
			}
			if (s0[i].equalsIgnoreCase("method")
					| s0[i].equalsIgnoreCase("field")) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_String_r method | field continue. s0["+i+"]="+s0[i]);
				continue;
			}
			if (s0[i].indexOf("\"") > -1) {
				s0[i] = s0[i].replaceAll("\"", "");
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_String_r Raw String continue. s0["+i+"]="+s0[i]);
				list.add(s0[i]);
				continue;
			}
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_String_r 2 s0["+i+"]="+s0[i]);
			Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s0[i]);
			Object o = data1.calculationObject(null, data1.getSubData(), by, map);
			initAddData(list, data1, o);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_String_r end. @FixedValueRawData getData()="+getData());
		setData("@FixedValueRawData");
		return list;
	}

	private void init_ObjectArray(List list, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Object[] oo1 = init_ObjectArray_r(list, by, map);
		setData(oo1);
		if (oo1 instanceof Class[]) {
			setRaw(true);
			setFixedValue(true);
		} else if (oo1 != null
				&& oo1.length > 0) {
			//checkRawAndFixedValue(oo1);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray end.");
	}

	private void initAddData(List list, Modchu_TextCalculationData data1, Object o) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_TextCalculationData initAddData data1="+data1+" data1.getClass()="+(data1 != null ? data1.getClass() : null));
			Modchu_Debug.mDebug("Modchu_TextCalculationData initAddData o="+o+" o.getClass()="+(o != null ? o.getClass() : null));
		}
		Object o2 = null;
		if (data1 != null
				&& data1.isRaw()
				&& data1.isFixedValue()) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData initAddData list.add o="+o+" o.getClass()="+(o != null ? o.getClass() : null));
			o2 = o;
		} else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData initAddData list.add data1="+data1+" data1.getClass()="+(data1 != null ? data1.getClass() : null));
			o2 = data1;
		}
		list.add(o2);
	}
/*
	private void checkRawAndFixedValue(Object[] oo1) {
		checkRawAndFixedValue(Modchu_Main.objectArrayToLinkedList(oo1));
	}

	private void checkRawAndFixedValue(List list) {
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
	private Object[] init_ObjectArray_r(List list, byte by, HashMap<String, Object>[] map) {
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
				oo1 = init_ObjectArray_r(list1, by, map);
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
			Object o2 = data1.calculationObject(null, data1.getSubData(), by, map);
			if (o2 != null) {
				if (o2 instanceof List) {
					List list2 = (List) o2;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o2 instanceof List start.");
					oo1 = init_ObjectArray_r(list2, by, map);
					if (debug) {
						Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o2 instanceof List oo1="+Modchu_Main.objectArrayToString(oo1));
						Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o2 instanceof List end.");
					}
					break;
				}
				else if (o2 instanceof Object[]) {
					oo1 = (Object[]) o2;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o2 instanceof Object[] oo1="+Modchu_Main.objectArrayToString(oo1));
					break;
				}
				else if ((c != Object.class
						&& c != Class.class
								&& o2.getClass() != c)
						| (c == Class.class
						&& !(o2.getClass() instanceof Class))) {
					String ss = "Modchu_TextCalculationData init_ObjectArray_r o2.getClass() != c error !! o2.getClass()="+o2.getClass();
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
					return null;
				}
				oo1[i] = o2;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray oo1["+i+"]="+oo1[i]);
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r o2 == null !! @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ data1.getData()="+data1.getData());
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_ObjectArray_r end. oo1="+Modchu_Main.objectArrayToString(oo1));
		return oo1;
	}

	private boolean isObjectArray() {
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
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData isObjectArray return false. data="+data);
		return false;
	}

	@Override
	public Object calculationObject(Object o, Object o1, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		init(o, o1, by, map);
		Object o2 = null;
		Modchu_TextCalculationFormula formula = null;
		Object data = getData();
		if (isRaw()) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isLow return data="+data);
			return data;
		}
		if (isVariable()) {
			Object o3 = null;
			Object o4 = null;
			Modchu_RunCalculationList runCalculationList = null;
			if (o1 instanceof Modchu_RunCalculationList) {
				runCalculationList = (Modchu_RunCalculationList) o1;
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isVariable() runCalculationList="+runCalculationList);
			} else if (o1 instanceof List) {
				List list1 = o1 != null
						&& o1 instanceof List ? (List) o1 : null;
				runCalculationList = new Modchu_RunCalculationList(list1);
				setSubData(runCalculationList);
			} else {
				String ss ="Modchu_TextCalculationData calculationObject isVariable() o1 error !! o1="+o1+" getSubData()="+getSubData();
				Modchu_Debug.mDebug(ss);
				Modchu_Debug.lDebug(ss);
				Modchu_Main.setRuntimeException(ss);
				return null;
			}
			o4 = runCalculationList.calculationObject(null, null, by, map);
			HashMap<String, Object> map1 = null;
			for (HashMap<String, Object> map2 : map) {
				if (map2.containsKey(variableString)) {
					o3 = map2.get(variableString);
					map1 = map2;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isVariable() map2.get variableString="+variableString);
					break;
				}
			}
			if (map1 == null
					&& map != null
					&& map.length > 0
					&& map[0] != null) {
				map1 = map[0];
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isVariable() map1 = map[0] variableString="+variableString);
			}
			map1.put(variableString, o4);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isVariable() map1.put o4="+o4+" variableString="+variableString);
			return o4;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data="+data);
		if (data instanceof List) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof List data="+data);
			return data;
		}
		else if (data instanceof Modchu_RunCalculationList) {
			Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) data;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof List data="+data);
			o2 = Modchu_TextCalculation.instance.runCalculation(runCalculationList, by, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof List return o2="+o2);
		}
		else if (data instanceof Modchu_TextCalculationFormula) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula data="+data);
			formula = (Modchu_TextCalculationFormula) data;
			boolean flag = formula.isOneValue();
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula flag="+flag);
			if (flag) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula getSubData()="+getSubData());
				o2 = formula.calculationObject(null, getSubData(), by, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof Modchu_TextCalculationFormula o2="+o2);
			} else {
				return o;
			}
		}
		else if (data instanceof String) {
			String s = (String) data;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String s="+s+" this="+this);
			if (s.equals("null")) {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String s.equals(\"null\") return null.");
				return null;
			}
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String initFlag="+initFlag);
			if (s.equalsIgnoreCase("@FixedValueRawData")) {
/*
				if (debug) {
					String ss = "Modchu_TextCalculationData calculationObject data instanceof String @FixedValueRawData error !! isRaw()="+isRaw()+" isFixedValue()="+isFixedValue()+" getSubData()="+getSubData();
					Modchu_Debug.mDebug(ss);
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
				}
*/
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String @FixedValueRawData return o1="+o1);
				return o1;
			}
			int i1 = s.indexOf(".class");
			if (i1 > -1) {
				s = s.substring(0, i1);
				Class c = Modchu_Reflect.loadClass(s);
				setData(c);
				setRaw(true);
				setFixedValue(true);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String \".class\" c="+c);
				return c;
			}
			i1 = s.indexOf("[]");
			if (i1 > -1) {
				s = s.substring(0, i1);
				List list = (List) getSubData();
				if (list != null) {
					Class c = s.equalsIgnoreCase("newClass") ? Class.class : s.equalsIgnoreCase("newObject") ? Object.class : Modchu_Reflect.loadClass(s);
					Object[] oo1 = c != null ? Modchu_Reflect.newInstanceArray(c, list.size()) :  new Object[list.size()];
					for (int i = 0; i < list.size(); i++) {
						Object o3 = getListCalculationObject(null, list, i, (byte) -1, map);
						oo1[i] = o3;
					}
					data = oo1;
					setRaw(true);
				} else {
					String ss ="Modchu_TextCalculationData calculationObject s.indexOf(\"[]\") list == null error !! data="+data;
					Modchu_Debug.mDebug(ss);
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
				}
				return data;
			}
			o2 = Modchu_RunCalculationList.getMapsObject(s, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String getMapsObject o2="+o2);
			if (o2 != null) {
				setFixedValue(false);
			} else {
				o2 = Modchu_RunCalculationList.getFieldOrMedhod(s, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String getFieldOrMedhod o2="+o2);
				if (o2 != null) {
					setFixedValue(false);
				} else {
					o2 = Modchu_Main.stringToSuitableObject(s);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject o2="+o2);
					if (o2 instanceof String) {
						o2 = null;
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject o2 instanceof String null.");
					} else {
						setData(o2);
						setRaw(true);
					}
				}
			}
			if (o2 != null); else {
				o2 = Modchu_RunCalculationList.getTypeDefaultValue(by);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o2 == null. default "+o2);
			}
		} else {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject else data="+data);
			o2 = data;
		}
		if (o2 != null
				&& o != null) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject o2 != null "+o+" + "+o2);
			formula = Modchu_TextCalculationFormula.calculationFormulaMap.get("+");
			o = formula.calculationObject(o, o2, by, map);
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject ="+o);
		} else {
			if (o2 != null) o = o2;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject null o = o2. o="+o);
		}
		return o;
	}

	private Object getListCalculationObject(Object o, List list, int i, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Object o1 = i < list.size() ? list.get(i) : null;
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getListCalculationObject o1="+o1);
		if (o1 != null); else return null;
		Object o2 = null;
		if (o1 instanceof List) {
			List list1 = (List) o1;
			for (int i1 = 0; i1 < list1.size(); i1++) {
				o2 = getListCalculationObject(o, list1, i1, by, map);
			}
		}
		else if (o1 instanceof Modchu_TextCalculationData) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getListCalculationObject o1 instanceof Modchu_TextCalculationData start.---------------------------------");
			Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o1;
			o2 = data1.calculationObject(o, data1.getSubData(), by, map);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_TextCalculationData getListCalculationObject o1 instanceof Modchu_TextCalculationData o2="+o2);
				Modchu_Debug.mDebug("Modchu_TextCalculationData getListCalculationObject o1 instanceof Modchu_TextCalculationData end.---------------------------------");
			}
		}
		else if (o1 instanceof Modchu_RunCalculationList) {
			Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o1;
			o2 = runCalculationList.calculationObject(o, null, by, map);
		} else if (o1 instanceof String) {
			Modchu_RunCalculationList runCalculationList = Modchu_TextCalculation.instance.getTextCalculationList((String) o1);
			o2 = runCalculationList.calculationObject(o, null, by, map);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getListCalculationObject return o2="+o2);
		return o2;
	}

	private Object[] getCalculationObject_s_r(List list, int i, boolean isClass, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		LinkedList list1 = new LinkedList();
		Object o1 = getListCalculationObject(null, list, i, (byte) -1, map);
		if (o1 instanceof String); else return new Object[]{ o1, i };
		i++;
		Object o2 = getListCalculationObject(null, list, i, (byte) -1, map);
		if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData getCalculationObject_s_r o2="+o2);
		if (o2 instanceof List); else {
			String ss ="Modchu_TextCalculationData getCalculationObject_s_r !(o2 instanceof List) error !! o2="+o2;
			Modchu_Main.setRuntimeException(ss);
			return null;
		}
		List list2 = (List) o2;
		for (int i3 = 0; i3 < list2.size(); i3++) {
			Object o3 = getListCalculationObject(null, list2, i3, (byte) -1, map);
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
					Object o5 = getListCalculationObject(null, list3, i1, (byte) -1, map);
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

	public String dataToString(boolean b) {
		return dataToString(getSubData(), b);
	}

	@Override
	public String dataToString(Object subData, boolean b) {
		//Modchu_Debug.mDebug("Modchu_TextCalculationData dataToString data="+data);
		//Modchu_Debug.mDebug("Modchu_TextCalculationData dataToString data.getClass()="+data.getClass());
		StringBuilder sb = new StringBuilder();
		List<String> list = dataToStringList(subData, b);
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
	public List<String> dataToStringList(Object subData, boolean b) {
		return dataToStringList(subData, b, false);
	}

	public List<String> dataToStringList(Object subData, boolean b, boolean isDebug) {
		List<String> list = new LinkedList();
		Object data = getData();
		if (data instanceof List) {
			if (isDebug) list.add("data instanceof List start.\n");
			list.add(Modchu_TextCalculation.instance.dataToString((List) data, b));
			if (isDebug) list.add("data instanceof List end.\n");
		}
		else if (data instanceof Modchu_ITextCalculationDataFormat) {
			if (isDebug) list.add("data instanceof Modchu_ITextCalculationDataFormat start.\n");
			list.add(Modchu_TextCalculation.instance.dataToString(data, b));
			if (isDebug) list.add("data instanceof Modchu_ITextCalculationDataFormat end.\n");
		} else {
			if (isDebug) list.add("data instanceof otherDataToString start.\n");
			list.add(otherDataToString(data));
			if (isDebug) list.add("data instanceof otherDataToString end.\n");
		}
		if (subData != null) {
			if (isDebug) list.add("subData data start.\n");
/*
			if (isReflect()) {

				if (!(subData instanceof List)) {
					String ss = "Modchu_TextCalculationData dataToStringList !subData instanceof List !! subData.getClass()="+subData.getClass()+" subData="+subData;
					Modchu_Debug.mDebug(ss);
					Modchu_Main.setRuntimeException(ss);
				}
				else {
					List list1 = (List) subData;

					list.add(Modchu_TextCalculation.instance.dataToString(subData, false));
				//}
			} else {
*/
				list.add(Modchu_TextCalculation.instance.dataToString(subData, false));
			//}
			if (isDebug) list.add("subData data end.\n");
		}
		return list;
	}

	@Override
	public void debugData(String s, String s1) {
		String s2 = s + " " + s1;
		List<String> list = dataToStringList(subData, false, true);
		for (String s3 : list) {
			Modchu_Debug.mlDebug(s3);
		}
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
					!(o instanceof List)) {
				String ss = "Modchu_TextCalculationData setSubData isReflect() !subData instanceof List !! o="+o;
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
		return isOperatorStringFlag;
	}

	public void setOperatorStringFlag(boolean b) {
		isOperatorStringFlag = b;
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
	public boolean isFixedValue() {
		return isFixedValue;
	}

	@Override
	public void setFixedValue(boolean b) {
		isFixedValue = b;
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

}
