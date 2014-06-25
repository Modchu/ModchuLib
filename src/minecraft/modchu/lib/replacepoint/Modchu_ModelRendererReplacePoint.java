package modchu.lib.replacepoint;

import modchu.lib.replace.Modchu_ModelBase;
import modchu.lib.replace.Modchu_ModelRendererBase;

public class Modchu_ModelRendererReplacePoint extends Modchu_ModelRendererBase {

	public Modchu_ModelRendererReplacePoint(Modchu_ModelBase pModelBase, String pName) {
		super(pModelBase, pName);
	}

	public Modchu_ModelRendererReplacePoint(Modchu_ModelBase pModelBase, int px, int py) {
		super(pModelBase, px, py);
	}

	public Modchu_ModelRendererReplacePoint(Modchu_ModelBase pModelBase) {
		super(pModelBase);
	}

	public Modchu_ModelRendererReplacePoint(Modchu_ModelBase pModelBase, int px, int py, float pScaleX, float pScaleY, float pScaleZ) {
		super(pModelBase, px, py, pScaleX, pScaleY, pScaleZ);
	}

	public Modchu_ModelRendererReplacePoint(Modchu_ModelBase pModelBase, float pScaleX, float pScaleY, float pScaleZ) {
		super(pModelBase, pScaleX, pScaleY, pScaleZ);
	}
}
