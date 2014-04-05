package modchu.lib;

import java.io.File;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Modchu_ASBase implements Modchu_ASC {

	public abstract Object getB(int pIndex, Object ...pArg);
	public abstract Object getB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract boolean getBooleanB(int pIndex, Object ...pArg);
	public abstract boolean getBooleanB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract float getFloatB(int pIndex, Object ...pArg);
	public abstract float getFloatB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract double getDoubleB(int pIndex, Object ...pArg);
	public abstract double getDoubleB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract int getIntB(int pIndex, Object ...pArg);
	public abstract int getIntB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract long getLongB(int pIndex, Object ...pArg);
	public abstract long getLongB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract byte getByteB(int pIndex, Object ...pArg);
	public abstract byte getByteB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract String getStringB(int pIndex, Object ...pArg);
	public abstract String getStringB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract List getListB(int pIndex, Object ...pArg);
	public abstract List getListB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract ArrayList getArrayListB(int pIndex, Object ...pArg);
	public abstract ArrayList getArrayListB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract LinkedList getLinkedListB(int pIndex, Object ...pArg);
	public abstract LinkedList getLinkedListB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract Enum getEnumB(int pIndex, Object ...pArg);
	public abstract Enum getEnumB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract ConcurrentHashMap getConcurrentHashMapB(int pIndex, Object ...pArg);
	public abstract ConcurrentHashMap getConcurrentHashMapB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract HashMap getHashMapB(int pIndex, Object ...pArg);
	public abstract HashMap getHashMapB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract Map getMapB(int pIndex, Object ...pArg);
	public abstract Map getMapB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract File getFileB(int pIndex, Object ...pArg);
	public abstract File getFileB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract IntBuffer getIntBufferB(int pIndex, Object ...pArg);
	public abstract IntBuffer getIntBufferB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract InputStream getInputStreamB(int pIndex, Object ...pArg);
	public abstract InputStream getInputStreamB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract int[] getIntArrayB(int pIndex, Object ...pArg);
	public abstract int[] getIntArrayB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract float[] getFloatArrayB(int pIndex, Object ...pArg);
	public abstract float[] getFloatArrayB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract double[] getDoubleArrayB(int pIndex, Object ...pArg);
	public abstract double[] getDoubleArrayB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract byte[] getByteArrayB(int pIndex, Object ...pArg);
	public abstract byte[] getByteArrayB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract String[] getStringArrayB(int pIndex, Object ...pArg);
	public abstract String[] getStringArrayB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract Object[] getObjectArrayB(int pIndex, Object ...pArg);
	public abstract Object[] getObjectArrayB(Modchu_ASBase accessSupport, int pIndex, Object ...pArg);
	public abstract boolean setB(int pIndex, Object... pArg);
	public abstract boolean setB(Modchu_ASBase accessSupport, int pIndex, Object... pArg);

}
