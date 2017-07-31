package modchu.lib;

public class Modchu_ReflectData {
	private Object classNameOrClass;
	private String methodOrFieldName;
	private Object reflectObject;
	private Class[] reflectClassArray;
	private Object[] reflectObjectArray;
	private Modchu_TextCalculationData reflectObjectArrayData;
	private int debugInt;

	public Modchu_ReflectData() {
		this(null, null, null, null, null, 1);
	}

	public Modchu_ReflectData(Object o, String s) {
		this(o, s, null, null, null, 1);
	}

	public Modchu_ReflectData(Object o, String s, int i) {
		this(o, s, null, null, null, i);
	}

	public Modchu_ReflectData(Object o, String s, Object o1) {
		this(o, s, null, o1, null, 1);
	}

	public Modchu_ReflectData(Object o, String s, Object o1, int i) {
		this(o, s, null, o1, null, i);
	}

	public Modchu_ReflectData(Object o, String s, Class[] c0, Object[] o0) {
		this(o, s, c0, null, o0, 1);
	}

	public Modchu_ReflectData(Object o, String s, Class[] c0, Object[] o0, int i) {
		this(o, s, c0, null, o0, i);
	}

	public Modchu_ReflectData(Object o, String s, Class[] c0, Object o1, Object[] o0) {
		this(o, s, c0, o1, o0, 1);
	}

	public Modchu_ReflectData(Object o, String s, Class[] c0, Object o1, Object[] o0, int i) {
		classNameOrClass = o;
		methodOrFieldName = s;
		reflectObject = o1;
		reflectClassArray = c0;
		reflectObjectArray = o0;
		debugInt = i;
	}

	public Object getClassNameOrClass() {
		return classNameOrClass;
	}

	public void setClassNameOrClass(Object o) {
		classNameOrClass = o;
	}

	public String getMethodOrFieldName() {
		return methodOrFieldName;
	}

	public void setMethodOrFieldName(String s) {
		methodOrFieldName = s;
	}

	public Object getReflectObject() {
		return reflectObject;
	}

	public void setReflectObject(Object o) {
		reflectObject = o;
	}

	public Class[] getReflectClassArray() {
		return reflectClassArray;
	}

	public void setReflectClassArray(Class[] c0) {
		reflectClassArray = c0;
	}

	public Object[] getReflectObjectArray() {
		return reflectObjectArray;
	}

	public void setReflectObjectArray(Object[] o0) {
		reflectObjectArray = o0;
	}

	public Modchu_TextCalculationData getReflectObjectArrayData() {
		return reflectObjectArrayData;
	}

	public void setReflectObjectArrayData(Modchu_TextCalculationData data) {
		reflectObjectArrayData = data;
	}

	public String dataToString() {
		String s = "(" + classNameOrClass + ", " + methodOrFieldName;
		if (reflectClassArray != null) s = s + ", new " + Modchu_Main.objectArrayToString(reflectClassArray);
		if (reflectObject != null) s = s + ", "+reflectObject;
		if (reflectObjectArray != null) s = s + ", new " + Modchu_Main.objectArrayToString(reflectObjectArray);
		s = s + ")";
		Modchu_Debug.mDebug("Modchu_ReflectData dataToString() Modchu_Main.objectArrayToString(reflectObjectArray)="+Modchu_Main.objectArrayToString(reflectObjectArray));
		if (reflectObjectArray != null) Modchu_Debug.mDebug("Modchu_ReflectData dataToString() reflectObjectArray[0]="+reflectObjectArray[0]);
		return s;
	}

}
