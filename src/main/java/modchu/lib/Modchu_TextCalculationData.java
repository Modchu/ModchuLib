package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Modchu_TextCalculationData implements Modchu_ITextCalculationDataFormat {
	private Object data;
	private Object subData;
	private boolean initFlag = false;
	private boolean isReflect = false;
	private boolean isOperatorStringFlag = false;
	private boolean isRaw = false;
	private int maxSubDataListSize = 0;

	public Modchu_TextCalculationData(Object o) {
		data = o;
	}

	@Override
	public void init() {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (initFlag) return;
		initFlag = true;
		if (data instanceof String) {
			String s = (String) data;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init s="+s+" this="+this);
			Object subData = getSubData();
			if (subData != null
					&& subData instanceof List); else {
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init else return. subData="+subData);
				return;
			}
			List list = new ArrayList();
			List list1 = (List) subData;
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init list1="+list1);
			if (list1 != null
					&& !list1.isEmpty()) {
				List list2 = new ArrayList();
				String s1 = init_List(list2, list1);
				if (list2 != null
						&& !list2.isEmpty()) {
					list1 = list2;
					setSubData(list1);
				}
			}
			if (s.indexOf(",") > -1) {
				String s1 = init_String_r(list, s);
				if (s1 != null) {
					list.addAll(list1);
					setSubData(list);
					setData(s1);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init s1="+s1);
				}
			}
			if (debug) Modchu_TextCalculation.instance.debugData("Modchu_TextCalculationData init end. ", "list", list);
		}
	}

	private String init_List(List list, List list1) {
		String s = null;
		if (list1 != null
				&& !list1.isEmpty())
		for (int i = 0; i < list1.size(); i++) {
			Object o = list1.get(i);
			if (o instanceof List) {
				List list2 = (List) o;
				String s1 = init_List(list, list2);
				if (i == 0) s = s1;
			}
			else if (o instanceof Modchu_TextCalculationData) {
				Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o;
				list.add(data1);
				//if (i == 0) s = s3;
			}
			else if (o instanceof String) {
				String s2 = (String) o;
				String s3 = init_String(list, s2);
				if (i == 0) s = s3;
			}
		}
		return s;
	}

	private String init_String(List list, String s) {
		if (s.indexOf(",") > -1) {
			return init_String_r(list, s);
		} else {
			Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s);
			list.add(data1);
		}
		return null;
	}

	private String init_String_r(List list, String s) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		String[] s0 = s.indexOf(",") > -1 ? s.split(",") : null;
		if (s0 != null); else return null;
		for (int i = 1; i < s0.length; i++) {
			if (s0[i] != null
					&& !s0[i].isEmpty()); else continue;
			if (s0[i].indexOf("\"") > -1) {
				s0[i] = s0[i].replaceAll("\"", "");
			}
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData init_String_r s0["+i+"]="+s0[i]);
			Modchu_TextCalculationData data1 = new Modchu_TextCalculationData(s0[i]);
			if (isReflect()
					&& i < 3) data1.setRaw(true);
			list.add(data1);
		}
		return s0[0];
	}

	@Override
	public Object calculationObject(Object o, Object o1, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		Object o2 = null;
		Modchu_TextCalculationFormula formula = null;
		if (isRaw()) {
			if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject isLow return data="+data);
			return data;
		}
		if (data instanceof List) {
			String ss ="Modchu_TextCalculationData calculationObject data instanceof List error !! data="+data;
			Modchu_Main.setRuntimeException(ss);
			return o;
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
			if (s.indexOf(",") > -1) {
				if (debug) {
					String ss = "Modchu_TextCalculationData calculationObject data instanceof String s.indexOf(\",\") > -1 error !! s="+s;
					Modchu_Debug.mDebug(ss);
					Modchu_Main.setRuntimeException(ss);
				}
				return null;
			}
			if (isReflect()) {
				Object temp = getSubData();
				List list = temp != null
						&& temp instanceof List ? (List) temp : null;
				if (list != null
						&& !list.isEmpty()); else {
					String ss ="Modchu_TextCalculationData calculationObject list == null error !! getSubData()="+temp;
					Modchu_Main.setRuntimeException(ss);
					return o;
				}
				int i = 0;
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String list="+list);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String list.get(i)="+list.get(i));
					Modchu_Debug.setClipboardLog();
				}
				String s1 = list.size() > i ? Modchu_CastHelper.String(getListCalculationObject(null, list, i, (byte) -1, map)) : null;
				i++;
				String s2 = list.size() > i ? Modchu_CastHelper.String(getListCalculationObject(null, list, i, (byte) -1, map)) : null;
				i++;
				// TODO last
				Object[] oo1 = getCalculationObject_s_r(list, i, true, map);
				Object o5 = oo1[0];
				i = (Integer) oo1[1];
				Object o6 = list.size() > i ? getListCalculationObject(null, list, i, (byte) -1, map) : null;
				if (o6 != null
						&& o6 instanceof String) {
					o6 = null;
				} else {
					i++;
				}
				Object[] oo2 = getCalculationObject_s_r(list, i, false, map);
				Object o7 = oo2[0];
				i = (Integer) oo2[1];
				Class[] o8 = null;
				Object o9 = null;
				Object[] o10 = null;
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o5="+o5);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o6="+o6);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o7="+o7);
				}
				if (o5 instanceof Class[]) {
					o8 = (Class[]) o5;
				}
				if (o6 instanceof String) o6 = Modchu_TextCalculation.instance.getTextCalculationList((String) o6);
				if (o6 instanceof Modchu_RunCalculationList) {
					Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o6;
					o9 = Modchu_TextCalculation.instance.runCalculation(runCalculationList, (byte) -1, map);
				} else {
					o9 = o6;
				}
				if (o7 instanceof Object[]) {
					o10 = (Object[]) o7;
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o5 instanceof Object[] o10="+o10);
					for (int i1 = 0; i1 < ((Object[]) o7).length; i1++) {
						Object o11 = ((Object[]) o7)[i1];
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o5 instanceof Object[] o11="+o11);
						if (o11 instanceof Modchu_RunCalculationList) {
							Modchu_RunCalculationList runCalculationList = (Modchu_RunCalculationList) o11;
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o5 instanceof Object[] runCalculation ----------------------- start.");
							o10[i1] = Modchu_TextCalculation.instance.runCalculation(runCalculationList, (byte) -1, map);
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o5 instanceof Object[] runCalculation ----------------------- end.");
							if (o10[i1] != null); else {
								if (o8 instanceof Class[]) {
									Class[] c8 = (Class[]) o8;
									if (i1 < c8.length) {
										o10[i1] = c8[i1].isArray() ? Modchu_Reflect.newInstanceArray(c8[i1], 1) : Modchu_Reflect.newInstance(c8[i1]);
										if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o5 instanceof Object[] newInstance o8["+i1+"].getClass()="+o10[i1].getClass());
									}
								}
							}
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o8["+i1+"]="+o10[i1]);
						}
					}
				}
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String Modchu_AS.get s1="+s1);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String Modchu_AS.get s2="+s2);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String Modchu_AS.get o8="+Modchu_Main.objectArrayToString(o8));
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String Modchu_AS.get o9="+o9);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String Modchu_AS.get o10="+Modchu_Main.objectArrayToString(o10));
				}
				o2 = Modchu_AS.get(s1, s2, o8, o9, o10);
				if (debug) {
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String Modchu_AS.get o2="+o2);
					Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String Modchu_AS.get getCapsValueInt="+Modchu_EntityCapsHelper.getCapsValueInt(map[0].get("ObjectDefault"), map[0].get("entityCaps"), 524305, (Object[]) null));
				}
			} else {
				int i1 = s.indexOf(".class");
				if (i1 > -1) {
					s = s.substring(0, i1);
					Class c = Modchu_Reflect.loadClass(s);
					data = c;
					setRaw(true);
					return data;
				}
				i1 = s.indexOf("[]");
				if (i1 > -1) {
					s = s.substring(0, i1);
					List list = (List) getSubData();
					Class c = Modchu_Reflect.loadClass(s);
					Object[] oo1 = c != null ? Modchu_Reflect.newInstanceArray(c, list.size()) :  new Object[list.size()];
					for (int i = 0; i < list.size(); i++) {
						Object o3 = getListCalculationObject(null, list, i, (byte) -1, map);;
						oo1[i] = o3;
					}
					data = oo1;
					setRaw(true);
					return data;
				}
				o2 = Modchu_RunCalculationList.getMapsObject(s, map);
				if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String getMapsObject o2="+o2);
				if (o2 != null); else {
					o2 = Modchu_RunCalculationList.getFieldOrMedhod(s, map);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String getFieldOrMedhod o2="+o2);
					if (o2 != null); else {
						o2 = Modchu_Main.stringToSuitableObject(s);
						if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject o2="+o2);
						if (o2 instanceof String) {
							o2 = null;
							if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String stringToSuitableObject o2 instanceof String null.");
						} else {
							data = o2;
						}
					}
				}
				if (o2 != null); else {
					o2 = Modchu_RunCalculationList.getTypeDefaultValue(by);
					if (debug) Modchu_Debug.mDebug("Modchu_TextCalculationData calculationObject data instanceof String o2 == null. default "+o2);
				}
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
		Object data = getData();
		if (data instanceof List) {
			sb.append(Modchu_TextCalculation.instance.dataToString((List) data, b));
		}
		else if (data instanceof Modchu_ITextCalculationDataFormat) {
			sb.append(Modchu_TextCalculation.instance.dataToString(data, b));
		} else {
			sb.append(otherDataToString(data));
			//Modchu_Debug.mDebug("Modchu_TextCalculationData dataToString end.");
		}
		if (subData != null) {
			if (isReflect()) {
				List list = (List) subData;
				sb.append(Modchu_TextCalculation.instance.dataToString(list, false));
			} else {
				sb.append(Modchu_TextCalculation.instance.dataToString(subData, false));
			}
		}
		return sb.toString();
	}

	public String otherDataToString(Object data) {
		//Modchu_Debug.mDebug("Modchu_TextCalculationData otherDataToString data="+data);
		return data.toString();
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
		subData = o;
	}

	public boolean isRaw() {
		return isRaw;
	}

	public void setRaw(boolean b) {
		isRaw = b;
	}

	public boolean isReflect() {
		return isReflect;
	}

	public void setReflect(boolean b) {
		isReflect = b;
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

}
