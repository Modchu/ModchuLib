package modchu.lib.replacepoint;import modchu.lib.replace.Modchu_ModelMultiModchuBase;public abstract class Modchu_ModelMultiReplacePoint extends Modchu_ModelMultiModchuBase {    /**     * コンストラクタは全て継承させること     */    public Modchu_ModelMultiReplacePoint() {    	this(0.0F);    }    /**     * コンストラクタは全て継承させること     */    public Modchu_ModelMultiReplacePoint(float psize) {    	this(psize, 0.0F);    }    /**     * コンストラクタは全て継承させること     */    public Modchu_ModelMultiReplacePoint(float psize, float pyoffset) {    	this(psize, pyoffset, 64, 32);    }    /**     * コンストラクタは全て継承させること     */    public Modchu_ModelMultiReplacePoint(float psize, float pyoffset, int par3, int par4) {    	super(psize, pyoffset, par3, par4);    }}