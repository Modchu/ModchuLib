package modchu.lib;

import java.util.HashMap;

public interface Modchu_ITextCalculationDataFormat {
	public void init();
	public Object calculationObject(Object o, Object o1, byte by, HashMap<String, Object>... map);
	public String dataToString(Object data, boolean b);
	public boolean isOneValue();

}
