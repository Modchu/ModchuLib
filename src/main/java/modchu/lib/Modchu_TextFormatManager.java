package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Modchu_TextFormatManager {
	private static HashMap<String, Modchu_TextFormatData> dataMap = new HashMap();
	private static ArrayList<String> checkSimpleList;
	private static ArrayList<String> checkNormalList;
	private static ArrayList<String> checkList;

	public static Modchu_TextFormatData getTextFormatManagerData(String s) {
		if (s != null
				&& !s.isEmpty()); else return null;
		if (dataMap.containsKey(s)) return dataMap.get(s);
		Modchu_TextFormatData data = new Modchu_TextFormatData();
		settingSimpleStringList(s, data);
		settingNormalStringList(s, data);
		settingStringList(s, data);
		settingInsideList(s, data);
		dataMap.put(s, data);
		return data;
	}

	private static void settingSimpleStringList(String s, Modchu_TextFormatData data) {
		boolean debug = true;
		if (checkSimpleList != null); else {
			checkSimpleList = new ArrayList();
			String[] s1 = new String[]{
					"=",
					",",
			};
			for (String s2 : s1) {
				checkSimpleList.add(s2);
			}
		}
		List<String> simpleStringList = new ArrayList();
		settingList(checkSimpleList, simpleStringList, s, data);
		data.putStringList(0, simpleStringList);
	}

	private static void settingNormalStringList(String s, Modchu_TextFormatData data) {
		boolean debug = true;
		if (checkNormalList != null); else {
			checkNormalList = new ArrayList();
			String[] s1 = new String[]{
					"(",
					")",
					"=",
					",",
					":",
					";",
			};
			for (String s2 : s1) {
				checkNormalList.add(s2);
			}
		}
		List<String> normalStringList = new ArrayList();
		settingList(checkNormalList, normalStringList, s, data);
		data.putStringList(1, normalStringList);
	}

	private static void settingStringList(String s, Modchu_TextFormatData data) {
		if (checkList != null); else {
			checkList = Modchu_Main.stringArrayToArrayList(Modchu_Main.getCalculationCharacterStringArray());
			checkList.add(0, ")");
			checkList.add(0, "(");
			checkList.addAll(Modchu_Main.stringArrayToArrayList(Modchu_Main.getConditionalExpressionCharacterStringArray()));
		}
		List<String> stringList = new ArrayList();
		settingList(checkList, stringList, s, data);
		data.putStringList(2, stringList);
	}

	private static void settingInsideList(String s, Modchu_TextFormatData data) {
		boolean debug = true;
		List<String> stringList = data.getStringList(2);
		if (stringList != null
				&& !stringList.isEmpty()); else return;
		List<String> insideList = new ArrayList();
		settingInsideList_r(insideList, stringList);
		data.putStringList(3, insideList);
	}

	private static void settingInsideList_r(List list, List<String> list1) {
		settingInsideList_r(list, list1, 0);
	}

	private static void settingInsideList_r(List list, List<String> list1, int index) {
		List tempList = null;
		for (int i1 = index; i1 < list1.size(); i1++) {
			String s = list1.get(i1);
			index++;
			if (s.equals("(")) {
				tempList = new ArrayList();
				continue;
			}
			if (s.equals(")")
					| s.indexOf("&") > -1
					| s.indexOf("|") > -1) {
				list.add(new ArrayList(tempList));
				tempList.clear();
				continue;
			}
			if (s != null
					&& !s.isEmpty()) {
				if (tempList != null) tempList.add(s);
			}
		}
	}

	private static void settingList(List<String> list, List<String> list1, String s, Modchu_TextFormatData data) {
		int tempListIndex = 0;
		int tempCount = 0;
		while (tempCount < s.length()) {
			String s3 = s.substring(tempCount);
			boolean flag = false;
			for (String s2 : list) {
				if (s3.startsWith(s2)) {
					list1.add(s2);
					tempListIndex += 2;
					tempCount += s2.length();
					flag = true;
					break;
				}
			}
			if (flag) continue; 
			String s4 = list1.size() > tempListIndex ? list1.get(tempListIndex) : null;
			String s5 = s3.substring(0, 1);
			s4 = s4 != null
					&& !s4.isEmpty() ? s4 + s5 : s5;
			if (list1.size() > tempListIndex) list1.set(tempListIndex, s4);
			else list1.add(s4);
			tempCount++;
		}
	}

}
