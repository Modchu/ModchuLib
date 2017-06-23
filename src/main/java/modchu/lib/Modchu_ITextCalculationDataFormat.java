package modchu.lib;

import java.util.List;
import java.util.Map;

public interface Modchu_ITextCalculationDataFormat {
	public Object calculationObject(Object o, Map... map);
	public String dataToString(boolean b);
	public List<String> dataToStringList(boolean b, boolean isDebug);
	public boolean isOneValue();
	public void debugData(String s, String s1);
	public boolean isVariable();
	public void setVariable(boolean b);

}
