package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Modchu_TextFormatData {
	private HashMap<Integer, List<String>> stringListMap = new HashMap();
	private List insideList = new ArrayList();

	public List<String> getStringList(int i) {
		return stringListMap.containsKey(i) ? stringListMap.get(i) : null;
	}

	public void putStringList(int i, List<String> list) {
		stringListMap.put(i, list);
	}

	public List<String> getInsideList() {
		return insideList;
	}

	public void setInsideList(List list) {
		insideList = list;
	}
}
