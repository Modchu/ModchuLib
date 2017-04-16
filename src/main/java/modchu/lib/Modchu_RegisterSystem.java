package modchu.lib;

import java.util.ArrayList;
import java.util.List;

public class Modchu_RegisterSystem {
	protected String name;
	protected List objectList = new ArrayList();

	public Modchu_RegisterSystem(String s) {
		name = s;
	}

	public void register(Object o) {
		///Modchu_Debug.mDebug("Modchu_RegisterSystem register o="+o);
		if (!contains(o)) {
			//Modchu_Debug.mDebug("Modchu_RegisterSystem register ok.");
			getObjectList().add(o);
		}
	}

	public void unRegister(Object o) {
		if (contains(o)) getObjectList().remove(o);
	}

	public List getObjectList() {
		return objectList;
	}

	public void setObjectList(List list) {
		objectList = list;
	}

	public boolean contains(Object o) {
		return getObjectList().contains(o);
	}

}
