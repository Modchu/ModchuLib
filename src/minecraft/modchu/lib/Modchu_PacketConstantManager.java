package modchu.lib;

public class Modchu_PacketConstantManager {

	public static String getConstantString(byte b) {
		String s = null;
		switch (b) {
		case 0:
			s = "packet_IDAll";
			break;
		case 1:
			s = "packet_IDSitting";
			break;
		case 2:
			s = "packet_IDSleeping";
			break;
		case 3:
			s = "packet_IDAction";
			break;
		}
		return s;
	}

}