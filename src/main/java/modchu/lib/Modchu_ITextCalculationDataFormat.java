package modchu.lib;

import java.util.HashMap;
import java.util.List;

public interface Modchu_ITextCalculationDataFormat {
	public void init(Object o, Object o1, byte by, HashMap<String, Object>... map);
	public Object calculationObject(Object o, Object o1, byte by, HashMap<String, Object>... map);
	public String dataToString(Object data, boolean b);
	public List<String> dataToStringList(Object data, boolean b);
	public boolean isOneValue();
	public void debugData(String s, String s1);
	public boolean isFixedValue();
	public void setFixedValue(boolean b);
	public boolean isVariable();
	public void setVariable(boolean b);

}
