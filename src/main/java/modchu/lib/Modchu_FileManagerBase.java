package modchu.lib;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.jar.JarFile;

import modchu.lib.characteristic.Modchu_AS;
import modchu.model.ModchuModel_Client;
import modchu.model.replacepoint.ModchuModel_HelperReplacePoint;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.FMLModContainer;

public class Modchu_FileManagerBase {

	public static File minecraftJar;
	public static Map<String, List<File>> fileList = new TreeMap<String, List<File>>();
	public static File minecraftDir;
	public static File versionDir;
	public static File modDir;
	public static File assetsDir;

	public static void init() {
		// 初期化
		if (ModchuModel_HelperReplacePoint.isClient) {
			minecraftDir = Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir);
		} else {
			minecraftDir = MinecraftServer.getServer().getFile("");
		}

		// mincraft.jarを取得
		// 開発中用のJar内に含まれていることの対策
		try {
			ProtectionDomain ls1 = FMLModContainer.class.getProtectionDomain();
			CodeSource ls2 = ls1.getCodeSource();
			URL ls3 = ls2.getLocation();
			URI ls4 = ls3.toURI();
			minecraftJar = new File(ls4);
//			minecraftJar = new File(BaseMod.class.getProtectionDomain().getCodeSource().getLocation().toURI());
//			Modchu_Debug.Debug(String.format("getMincraftFile-file:%s", minecraftJar.getName()));
			Modchu_Debug.Debug("getMinecraftFile-file:%s", minecraftJar.getAbsolutePath());
		} catch (Exception exception) {
			Modchu_Debug.Debug("getMinecraftFile-Exception.");
		}
		if (minecraftJar == null) {
			try {
				ClassLoader lcl1 = FMLModContainer.class.getClassLoader();
				String lcls1 = FMLModContainer.class.getName().concat(".class");
				URL lclu1 = lcl1.getResource(lcls1);
				JarURLConnection lclc1 = (JarURLConnection)lclu1.openConnection();
				JarFile lclj1 = lclc1.getJarFile();
				minecraftJar = new File(lclj1.getName());
				Modchu_Debug.Debug("getMinecraftFile-file:%s", lclj1.getName());
			} catch (Exception exception) {
				Modchu_Debug.Debug("getMinecraftFile-Exception.");
			}
		}
		if (minecraftJar == null) {
			String ls = System.getProperty("java.class.path");
			int li = ls.indexOf(';');
			if (li > -1) {
				ls = ls.substring(0, li);
			}
			minecraftJar = new File(ls);
			Modchu_Debug.Debug("getMinecraftFile-file:%s", ls);
		}
		if (!Modchu_Main.isForge && ModchuModel_HelperReplacePoint.isClient) {
			File lversions = new File(minecraftDir, "versions");
			versionDir = new File(lversions, ModchuModel_Client.getVersionString());
			if (lversions.exists() && lversions.isDirectory() && versionDir.exists() && versionDir.isDirectory()) {
				modDir = new File(versionDir, "/mods/");
			} else {
				modDir = new File(minecraftDir, "mods");
			}
		} else {
			modDir = new File(minecraftDir, "mods");
		}
		Modchu_Debug.Debug("getMods-Directory:%s", modDir.getAbsolutePath());

		if (ModchuModel_HelperReplacePoint.isClient) {
			try {
				assetsDir = (File)Modchu_Reflect.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), 41);
			} catch (Exception e) {
				e.printStackTrace();
				assetsDir = new File(minecraftDir, "assets");
			}
			Modchu_Debug.Debug("getAssets-Directory:%s", assetsDir.getAbsolutePath());
		} else {
			// サーバー側では使われないはず。
		}

	}

	public static List<File> getModFile(String pname, String pprefix) {
		// 検索済みかどうかの判定
		List<File> llist;
		if (fileList.containsKey(pname)) {
			llist = fileList.get(pname);
		} else {
			llist = new ArrayList<File>();
			fileList.put(pname, llist);
		}

		Modchu_Debug.Debug("getModFile:[%s]:%s", pname, modDir.getAbsolutePath());
		// ファイル・ディレクトリを検索
		try {
			if (modDir.isDirectory()) {
				Modchu_Debug.Debug("getModFile-get:%d.", modDir.list().length);
				for (File t : modDir.listFiles()) {
					if (t.getName().indexOf(pprefix) != -1) {
						if (t.getName().endsWith(".zip")) {
							llist.add(t);
							Modchu_Debug.Debug("getModFile-file:%s", t.getName());
						} else if (t.isDirectory()) {
							llist.add(t);
							Modchu_Debug.Debug("getModFile-file:%s", t.getName());
						}
					}
				}
				Modchu_Debug.Debug("getModFile-files:%d", llist.size());
			} else {
				// まずありえない
				Modchu_Debug.Debug("getModFile-fail.");
			}
			return llist;
		}
		catch (Exception exception) {
			Modchu_Debug.Debug("getModFile-Exception.");
			return null;
		}
	}

	public static List<File> getFileList(String pname) {
		return fileList.get(pname);
	}
}
