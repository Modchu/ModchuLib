package modchu.lib;

import java.io.File;

public class Modchu_SearchFileManager {
	private static Modchu_SearchFileManager instance;

	public static void init() {
		instance = new Modchu_SearchFileManager();
	}

	public Modchu_SearchFileManager() {
	}

	public static Modchu_SearchFileManager getInstance() {
		return instance;
	}

}
