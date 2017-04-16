package modchu.lib;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Modchu_RunCalculationList implements Modchu_ITextCalculationDataFormat {
	public static final byte type_Object = 0;
	public static final byte type_Integer = 1;
	public static final byte type_Float = 2;
	public static final byte type_Double = 3;
	public static final byte type_Long = 4;
	public static final byte type_Byte = 5;
	public static final byte type_Boolean = 6;
	private final List<Modchu_TextCalculationData> list;
	private boolean isIf;
	private boolean initFlag;
	private boolean isMultipleLines;

	public Modchu_RunCalculationList(List<Modchu_TextCalculationData> list1) {
		list = list1;
	}

	@Override
	public void init(Object o, Object o1, byte by, HashMap<String, Object>... map) {
		if (initFlag) return;
		initFlag = true;
	}

	Object runCalculation(Object o, byte by, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	runCalculation	start.");
			Modchu_Debug.mDebug("Modchu_RunCalculationList	runCalculation	s calculationListToString(textCalculationList)="+Modchu_TextCalculation.instance.calculationListToString(this));
		}
		List<Modchu_TextCalculationData> list = getList();
		if (list != null
				&& !list.isEmpty()); else return null;
		init(o, null, by, map);
		Modchu_TextCalculationLocalData localData = new Modchu_TextCalculationLocalData(null);
		Modchu_TextCalculationLocalData localData1 = new Modchu_TextCalculationLocalData(null);
		Modchu_TextCalculationFormula formula = null;
		Modchu_TextCalculationFormula formula1 = null;
		int setCount = 0;
		Object o1 = null;
		try {
			for (int i = 0; i < list.size(); i++) {
				//if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation list="+list);
				Modchu_TextCalculationData data = list.get(i);
				Object o2 = data.getData();
				//if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation o2="+o2);
				Object o3 = list.size() > (i + 1) ? list.get(i + 1) : null;
				//if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation o3="+o3);
				Modchu_TextCalculationData data1 = (Modchu_TextCalculationData) o3;
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation ["+i+" / "+(list.size() - 1)+"] data="+data);

				boolean isOneValue = data.isOneValue();
				if (isOneValue) {
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation isOneValue");
					Object o4 = data.calculationObject(null, data.getSubData(), by, map);
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation isOneValue o4="+o4);
					if (o1 != null); else {
						if (formula != null) {
							if (by == (byte)-1) {
								Object o5 = localData.getData();
								if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation by == -1 getType o5="+o5);
								by = Modchu_RunCalculationList.getType(o5);
								if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation by == -1 getType by="+by);
							}
							if (by != (byte)-1) {
								o1 = Modchu_RunCalculationList.getTypeDefaultValue(by);
								if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation isOneValue o1 = getTypeDefaultValue set.");
							}
						}
					}
					if (o1 != null) {
						if (setCount == 0) {
							localData.setData(o4);
							if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation isOneValue localData.setData");
						}
						else if (setCount == 1) {
							localData1.setData(o4);
							if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation isOneValue localData1.setData");
						}
						setCount++;
						if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation isOneValue setCount="+setCount);
					} else {
						o1 = o4;
						if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation isOneValue o1 = o4 set. o4="+o4);
					}
				} else if (o2 instanceof Modchu_TextCalculationFormula) {
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation data.getData() instanceof Modchu_TextCalculationFormula formula="+formula);
					if (formula != null) {
						formula1 = (Modchu_TextCalculationFormula) o2;
						if (debug) {
							Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation data.getData() instanceof Modchu_TextCalculationFormula formula1 set. formula1.dataToString="+formula1.dataToString(null, false));
						}
					} else {
						formula = (Modchu_TextCalculationFormula) o2;
						if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation data.getData() instanceof Modchu_TextCalculationFormula formula set. formula.dataToString="+formula.dataToString(null, false));
					}
				} else {
					String ss ="Modchu_RunCalculationList	runCalculation	data error !! data="+data;
					if (debug) Modchu_Debug.mDebug(ss);
					Modchu_Main.setRuntimeException(ss);
				}
				if (formula != null) {
					boolean flag = false;
					if (formula1 != null) {
						if (setCount > 0) {
							if (debug) {
								Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation formula1 != null localData.getData()="+localData.getData());
							}
							Object o5 = formula1.calculationObject(null, localData.getData(), by, map);
							if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation formula1 != null o5="+o5);
							o1 = formula.calculationObject(o1, o5, by, map);
							if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation formula1 != null o1="+o1);
							localData1.setData(null);
							formula1 = null;
							flag = true;
						} else {
							if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation formula1 != null setCount="+setCount);
						}
					} else {
						if (setCount > 0) {
							Object o6 = localData.getData();
							o1 = formula.calculationObject(o1, o6, by, map);
							if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation formula1 == null setCount > 0 o1="+o1);
							flag = true;
						} else {
							if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation formula == null setCount="+setCount);
						}
					}
					if (flag) {
						localData.setData(null);
						formula = null;
						setCount = 0;
					} else {
						if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation formula != null !flag.");
					}
				} else {
					if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation formula == null.");
				}
				//i = (Integer) list1.get(1);
				if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList runDataListCalculation ["+i+" / "+(list.size() - 1)+"] end. \n");
			}
		} catch (Error e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (o != null) {
			if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	runCalculation	"+o+" + "+o1);
			formula = Modchu_TextCalculationFormula.calculationFormulaMap.get("+");
			o = formula.calculationObject(o, o1, by, map);
			if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	runCalculation	="+o);
		} else {
			o = o1;
			if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	runCalculation	o = o1 set.");
		}
		if (by == type_Boolean
				&& !(o instanceof Boolean)) {
/*
			String ss ="Modchu_RunCalculationList runDataListCalculation Boolean error !! o="+o+" calculationListToString(runCalculationList)="+Modchu_TextCalculation.instance.calculationListToString(this);
			if (debug) Modchu_Debug.mDebug(ss);
			Modchu_Debug.writerList("Calculation");
			Modchu_Main.setRuntimeException(ss);
			o = false;
*/
		} else {
			Modchu_Debug.clearList("Calculation");
		}
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	runCalculation	e calculationListToString(textCalculationList)="+Modchu_TextCalculation.instance.calculationListToString(this));
			Modchu_Debug.mDebug("Modchu_RunCalculationList	runCalculation	end. return o="+o+"\n");
		}
		return o;
	}

	@Override
	public Object calculationObject(Object o, Object o1, byte type, HashMap<String, Object>... map) {
		Object o2 = runCalculation(o, type, map);
		return o2;
	}

	public static Object getMapsObject(String s, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		boolean flag = false;
		if (s != null
				&& !s.isEmpty()); else return null;
		for (HashMap<String, Object> map1 : map) {
			if (map1.containsKey(s)) {
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

	public static Object getFieldOrMedhod(String s, HashMap<String, Object>... map) {
		boolean debug = Modchu_TextCalculation.tempDebug;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod s="+s);
			Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod map[0]="+(map != null && map.length > 0 ? map[0] : null));
		}
		if (s != null
				&& !s.isEmpty()); else return null;
		String fieldOrMedhodName = null;
		String objectName = null;
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
		for (HashMap<String, Object> map1 : map) {
			if (map1.containsKey(s)) {
				o = map1.get(s);
				break;
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_RunCalculationList	getFieldOrMedhod map1.get o="+o);
		if (o != null
				| (objectName != null
				&& objectName.equals("null"))); else {
			String temp = "ObjectDefault";
			for (HashMap<String, Object> map1 : map) {
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
							true;
	}

	public List<Modchu_TextCalculationData> getList() {
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
		return true;
	}

	@Override
	public String dataToString(Object data, boolean b) {
		boolean flag = !isIf()
				&& b;
		StringBuilder sb = new StringBuilder();
		List<String> list = dataToStringList(data, b);
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString();
	}

	@Override
	public List<String> dataToStringList(Object data, boolean b) {
		List<String> list = new LinkedList();
		boolean flag = !isIf()
				&& b;
		if (flag) list.add("(");
		list.add(Modchu_TextCalculation.instance.calculationListToString(this, flag));
		if (flag) list.add(")");
		return list;
	}

	@Override
	public void debugData(String s, String s1) {
		String s2 = s + " " + s1;
		List<Modchu_TextCalculationData> list = getList();
		Modchu_Debug.mDebug(s2+" list="+list);
		for (Modchu_TextCalculationData data : list) {
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
	public boolean isFixedValue() {
		List<Modchu_TextCalculationData> list = getList();
		for (Modchu_TextCalculationData data : list) {
			if (!data.isFixedValue()) return false;
		}
		return true;
	}

	@Override
	public void setFixedValue(boolean b) {
	}

	@Override
	public boolean isVariable() {
		List<Modchu_TextCalculationData> list = getList();
		for (Modchu_TextCalculationData data : list) {
			if (!data.isVariable()) return false;
		}
		return true;
	}

	@Override
	public void setVariable(boolean b) {
	}

}
