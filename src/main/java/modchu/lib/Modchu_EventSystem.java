package modchu.lib;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Modchu_EventSystem extends Modchu_RegisterSystem {
	protected List<String> eventObjectLoadCheckList = new ArrayList(1024);

	public Modchu_EventSystem(String s) {
		super(s);
	}

	public boolean isEvent(String s) {
		return !getEventObjectLoadCheckList().contains(s);
	}

	public Object[] event(String s, Object[] o) {
		boolean debug = false;
		//boolean debug = s.equals("entityCreatureOnDeathUpdate");
		//if (debug) Modchu_Debug.mDebug("modchuLibEvent s="+s);
		Object[] o1 = eventObjectLoad(getObjectList(), getEventObjectLoadCheckList(), s, s, new Class[]{ Object[].class }, new Object[]{ o });
		if (debug) Modchu_Debug.mDebug("modchuLibEvent o1="+o1);
		if (o1 != null); else return null;
		int temp = 0;
		int i2 = 0;
		boolean flag = false;
		for (int i = 0; i < o1.length; i++) {
			Object o2 = o1[i];
			if (o2 != null
					&& o2 instanceof Object[]); else continue;
			Object o3 = ((Object[]) o2)[0];
			if (o3 instanceof String) {
				int i3 = Modchu_CastHelper.Int(o3);
				if (temp < i3) {
					temp = i3;
					i2 = i;
					flag = true;
				}
			}
			if (!flag) i2 = i;
		}
		//Modchu_Debug.mDebug("modchuLibEvent end. return "+(flag ? objectArrayCatting(Modchu_CastHelper.ObjectArray(o1[i2]), 1) : Modchu_CastHelper.ObjectArray(o1[i2])));
		return flag ? Modchu_Main.objectArrayCatting(Modchu_CastHelper.ObjectArray(o1[i2]), 1) : Modchu_CastHelper.ObjectArray(o1[i2]);
	}

	public static Object[] eventObjectLoad(List list, List list2, String s, String s1, Class[] cla, Object[] oa) {
		boolean debug = false;
		//debug = s.equals("onTickInGame");
		if (list != null
				&& !list.isEmpty()); else {
			if (debug) {
				if (list != null) {
					Modchu_Debug.mDebug("eventObjectLoad 1 list="+list);
					Modchu_Debug.mDebug("eventObjectLoad 2 list.isEmpty()="+list.isEmpty());
				} else {
					Modchu_Debug.mDebug("eventObjectLoad 3 list == null !!");
				}
			}
			return null;
		}
		if (list2.contains(s1)) {
			if (debug) Modchu_Debug.mDebug("eventObjectLoad 4 list2.contains(s1) return null. list2="+list2);
			return null;
		}
		int size = list.size();
		Object[] o = new Object[size];
		boolean b = false;
		if (debug) Modchu_Debug.mDebug("eventObjectLoad 5 s="+s);
		List tempRemoveList = null;
		for (int i = 0; i < size ; i++) {
			Object modInstance = list.get(i);
			if (modInstance != null) {
				Method medhod = Modchu_Reflect.getMethod(modInstance.getClass(), s, cla, -1);
				if (medhod != null) {
					try {
						o[i] = Modchu_Reflect.invoke(medhod, modInstance, oa, -1);
/*
						if (debug) {
							Modchu_Debug.mDebug("eventObjectLoad ck 1="+(o[i] != null));
							Modchu_Debug.mDebug("eventObjectLoad ck 2="+(o[i] instanceof Boolean));
							Modchu_Debug.mDebug("eventObjectLoad ck 3="+(!((Boolean) o[i])));
							Modchu_Debug.mDebug("eventObjectLoad ck 4="+(Modchu_Main.eventObjectListMap.containsKey(s)));
							Modchu_Debug.mDebug("eventObjectLoad ck map="+Modchu_Main.eventObjectListMap);
						}
*/
						if (o[i] != null
								&& o[i] instanceof Boolean
								&& !((Boolean) o[i])
								&& Modchu_Main.eventObjectListMap.containsKey(s)) {
							if (tempRemoveList != null); else tempRemoveList = new ArrayList();
							tempRemoveList.add(modInstance);
							if (debug) Modchu_Debug.mDebug("eventObjectLoad 6 false eventObjectListMap remove modInstance.getClass()="+modInstance.getClass());
						} else {
							b = true;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (debug) {
						Modchu_Debug.mDebug("eventObjectLoad 7 "+b+" modInstance.getClass()="+modInstance.getClass());
						Modchu_Debug.mDebug("eventObjectLoad 8 "+b+" o["+i+"]="+(o[i] instanceof Object[] ? Modchu_Main.objectArrayToString((Object[]) o[i]) : o[i]));
					}
				} else {
					if (debug) Modchu_Debug.mDebug("eventObjectLoad 9 "+b+" modInstance.getClass()="+modInstance.getClass());
				}
			}
		}
		if (!b
				&& !list2.contains(s1)) {
			list2.add(s1);
			if (debug) Modchu_Debug.mDebug1("eventObjectLoad 10 eventObjectLoadCheckList.add s="+s+" s1="+s1+" size()="+list2.size());
		}
		if (tempRemoveList != null
				&& !tempRemoveList.isEmpty()) {
			for (Object modInstance1 : tempRemoveList) {
				Modchu_Main.eventObjectListMap.get(s).remove(modInstance1);
			}
		}
		return o;
	}

	public List<String> getEventObjectLoadCheckList() {
		return eventObjectLoadCheckList;
	}

	public void setEventObjectLoadCheckList(List<String> list) {
		eventObjectLoadCheckList = list;
	}

}
