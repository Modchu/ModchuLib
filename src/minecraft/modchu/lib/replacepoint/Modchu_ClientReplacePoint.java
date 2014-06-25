package modchu.lib.replacepoint;

import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.replace.Modchu_ClientReplacePointBase;

public class Modchu_ClientReplacePoint extends Modchu_ClientReplacePointBase {

	public static void setTexture(String s) {
		Modchu_AS.set(Modchu_AS.renderEngineBindTexture, s);
	}
}
