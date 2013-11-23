package net.minecraft.src;

public abstract class Modchu_ModelMultiBaseV160 extends MMM_ModelMultiMMMBase {

    /**
     * コンストラクタは全て継承させること
     */
    public Modchu_ModelMultiBaseV160() {
    	this(0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public Modchu_ModelMultiBaseV160(float psize) {
    	this(psize, 0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public Modchu_ModelMultiBaseV160(float psize, float pyoffset) {
    	this(psize, pyoffset, 64, 32);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public Modchu_ModelMultiBaseV160(float psize, float pyoffset, int par3, int par4) {
    	super(psize, pyoffset, par3, par4);
    }

}
