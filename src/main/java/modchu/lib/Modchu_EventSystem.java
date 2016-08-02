package modchu.lib;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Modchu_EventSystem {
	protected String name;
	protected ArrayList eventObjectList = new ArrayList();
	protected ArrayList<String> eventObjectLoadCheckList = new ArrayList(1024);

	public Modchu_EventSystem(String s) {
		name = s;
	}

	public void register(Object o) {
		///Modchu_Debug.mDebug("Modchu_EventSystem modchuLibEventRegister o="+o);
		if (!getEventObjectList().contains(o)) {
			//Modchu_Debug.mDebug("Modchu_EventSystem modchuLibEventRegister ok.");
			getEventObjectList().add(o);
		}
	}

	public void unRegister(Object o) {
		if (getEventObjectList().contains(o)) getEventObjectList().remove(o);
	}

	public boolean isEvent(String s) {
		return !getEventObjectLoadCheckList().contains(s);
	}

	public Object[] event(String s, Object[] o) {
		boolean debug = false;
		//boolean debug = s.equals("entityCreatureOnDeathUpdate");
		//if (debug) Modchu_Debug.mDebug("modchuLibEvent s="+s);
		Object[] o1 = eventObjectLoad(getEventObjectList(), getEventObjectLoadCheckList(), s, s, new Class[]{ Object[].class }, new Object[]{ o });
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

	public static Object[] eventObjectLoad(ArrayList list, ArrayList list2, String s, String s1, Class[] cla, Object[] oa) {
		boolean debug = false;
		//boolean debug = s.equals("addRenderer");
		if (list != null
				&& !list.isEmpty()); else {
			if (debug) {
				if (list != null) {
					Modchu_Debug.mDebug("eventObjectLoad list="+list);
					Modchu_Debug.mDebug("eventObjectLoad list.isEmpty()="+list.isEmpty());
				} else {
					Modchu_Debug.mDebug("eventObjectLoad list == null !!");
				}
			}
			return null;
		}
		int size = list.size();
		Object[] o = new Object[size];
		boolean b = false;
		if (debug) Modchu_Debug.mDebug("eventObjectLoad s="+s);
		for (int i = 0; i < size ; i++) {
			Object modInstance = list.get(i);
			if (modInstance != null) {
				Method medhod = Modchu_Reflect.getMethod(modInstance.getClass(), s, cla, -1);
				if (medhod != null) {
					try {
						o[i] = Modchu_Reflect.invoke(medhod, modInstance, oa, -1);
					} catch (Exception e) {
						e.printStackTrace();
					}
					b = true;
					if (debug) {
						Modchu_Debug.mDebug("eventObjectLoad true modInstance.getClass()="+modInstance.getClass());
						Modchu_Debug.mDebug("eventObjectLoad true o["+i+"]="+Modchu_Main.objectArrayToString((Object[]) o[i]));
					}
				} else {
					if (debug) Modchu_Debug.mDebug("eventObjectLoad false modInstance.getClass()="+modInstance.getClass());
				}
			}
		}
		if (!b
				&& !list2.contains(s1)) {
			list2.add(s1);
			if (debug) Modchu_Debug.mDebug1("eventObjectLoad eventObjectLoadCheckList.add s="+s+" s1="+s1+" size()="+list2.size());
		}
		return o;
	}

	public ArrayList getEventObjectList() {
		return eventObjectList;
	}

	public void setEventObjectList(ArrayList list) {
		eventObjectList = list;
	}

	public ArrayList<String> getEventObjectLoadCheckList() {
		return eventObjectLoadCheckList;
	}

	public void setEventObjectLoadCheckList(ArrayList<String> list) {
		eventObjectLoadCheckList = list;
	}

}
