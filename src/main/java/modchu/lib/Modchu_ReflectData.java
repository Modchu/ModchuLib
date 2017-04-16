package modchu.lib;

public class Modchu_ReflectData {
	private String className;
	private String methodOrFieldName;
	private Object reflectObject;
	private Class[] reflectClassArray;
	private Object[] reflectObjectArray;
	private int debugInt;

	public Modchu_ReflectData() {
		this(null, null, null, null, null, 1);
	}

	public Modchu_ReflectData(String s, String s1) {
		this(s, s1, null, null, null, 1);
	}

	public Modchu_ReflectData(String s, String s1, int i) {
		this(s, s1, null, null, null, i);
	}

	public Modchu_ReflectData(String s, String s1, Object o) {
		this(s, s1, null, o, null, 1);
	}

	public Modchu_ReflectData(String s, String s1, Object o, int i) {
		this(s, s1, null, o, null, i);
	}

	public Modchu_ReflectData(String s, String s1, Class[] c0, Object[] o0) {
		this(s, s1, c0, null, o0, 1);
	}

	public Modchu_ReflectData(String s, String s1, Class[] c0, Object[] o0, int i) {
		this(s, s1, c0, null, o0, i);
	}

	public Modchu_ReflectData(String s, String s1, Class[] c0, Object o, Object[] o0) {
		this(s, s1, c0, o, o0, 1);
	}

	public Modchu_ReflectData(String s, String s1, Class[] c0, Object o, Object[] o0, int i) {
		className = s;
		methodOrFieldName = s1;
		reflectObject = o;
		reflectClassArray = c0;
		reflectObjectArray = o0;
		debugInt = i;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String s) {
		className = s;
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

}
