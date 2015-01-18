package modchu.lib;

import modchu.lib.characteristic.Modchu_ModelBoxBase;

public class Modchu_ModelBox extends Modchu_ModelBoxBase {

	public int boxSizeX;
	public int boxSizeY;
	public int boxSizeZ;

	public Modchu_ModelBox(Modchu_ModelRendererBase pMRenderer, Object... pArg) {
		super(pMRenderer, pArg);
		boxSizeX = (Integer)pArg[5];
		boxSizeY = (Integer)pArg[6];
		boxSizeZ = (Integer)pArg[5];
	}
}
