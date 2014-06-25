package modchu.lib;

import modchu.lib.replacepoint.Modchu_ModelBoxBaseReplacePoint;
import modchu.lib.replacepoint.Modchu_ModelRendererReplacePoint;

public class Modchu_ModelBox extends Modchu_ModelBoxBaseReplacePoint {

	public int boxSizeX;
	public int boxSizeY;
	public int boxSizeZ;

	public Modchu_ModelBox(Modchu_ModelRendererReplacePoint pMRenderer, Object... pArg) {
		super(pMRenderer, pArg);
		boxSizeX = (Integer)pArg[5];
		boxSizeY = (Integer)pArg[6];
		boxSizeZ = (Integer)pArg[5];
	}
}
