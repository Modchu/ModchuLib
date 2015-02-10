package modchu.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_HelperBase;
import modchu.lib.characteristic.Modchu_ITextureEntityBase;
import modchu.lib.characteristic.Modchu_TextureBoxBase;
import modchu.lib.characteristic.Modchu_TextureBoxServer;
import modchu.model.multimodel.base.MultiModelBaseBiped;

public class Modchu_TextureManagerBase {

	/**
	 * 継承クラスで置き換えることを考慮。
	 */
	public static Modchu_TextureManagerBase instance = new Modchu_TextureManagerBase();

	public static String nameTextureIndex = "config/mod_ModchuModel_textureList.cfg";
	public static String defaultModelName = "Orign";

	public static final int tx_oldwild		= 0x10; //16;
	public static final int tx_oldarmor1	= 0x11; //17;
	public static final int tx_oldarmor2	= 0x12; //18;
	public static final int tx_oldeye		= 0x13; //19;
	public static final int tx_gui			= 0x20; //32;
	public static final int tx_wild			= 0x30; //48;
	public static final int tx_armor1		= 0x40; //64;
	public static final int tx_armor2		= 0x50; //80;
	public static final int tx_eye			= 0x60; //96;
	public static final int tx_eyecontract	= 0x60; //96;
	public static final int tx_eyewild		= 0x70; //112;
	public static final int tx_armor1light	= 0x80; //128;
	public static final int tx_armor2light	= 0x90; //144;
	public static String[] armorFilenamePrefix;
	/**
	 * 旧タイプのファイル名
	 */
	public static String defNames[] = {
		"mob_littlemaid0.png", "mob_littlemaid1.png",
		"mob_littlemaid2.png", "mob_littlemaid3.png",
		"mob_littlemaid4.png", "mob_littlemaid5.png",
		"mob_littlemaid6.png", "mob_littlemaid7.png",
		"mob_littlemaid8.png", "mob_littlemaid9.png",
		"mob_littlemaida.png", "mob_littlemaidb.png",
		"mob_littlemaidc.png", "mob_littlemaidd.png",
		"mob_littlemaide.png", "mob_littlemaidf.png",
		"mob_littlemaidw.png",
		"mob_littlemaid_a00.png", "mob_littlemaid_a01.png"
	};

	/**
	 * ローカルで保持しているモデルのリスト
	 */
	public Map<String, MultiModelBaseBiped[]> modelMap = new TreeMap<String, MultiModelBaseBiped[]>();
	/**
	 * ローカルで保持しているテクスチャパック
	 */
	public List<Modchu_TextureBoxBase> textures = new ArrayList<Modchu_TextureBoxBase>();
	/**
	 * サーバー側での管理番号を識別するのに使う、クライアント用。
	 */
	public Map<Modchu_TextureBoxBase, Integer> textureServerIndex = new HashMap<Modchu_TextureBoxBase, Integer>();
	/**
	 * サーバー・クライアント間でテクスチャパックの名称リストの同期を取るのに使う、サーバー用。
	 */
	public List<Modchu_TextureBoxServer> textureServer = new ArrayList<Modchu_TextureBoxServer>();
	/**
	 * Entity毎にデフォルトテクスチャを参照。
	 * 構築方法はEntityListを参照のこと。
	 */
	public Map<Class, Modchu_TextureBoxBase> defaultTextures = new HashMap<Class, Modchu_TextureBoxBase>();

	/**
	 * クライアント側で使う
	 */
	public String[] requestString = new String[] {
		null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null
	};
	public int[] requestStringCounter = new int[] {
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0
	};
	public int[] requestIndex = new int[] {
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1
	};
	public int[] requestIndexCounter = new int[] {
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0
	};
	public Map<Modchu_ITextureEntityBase, int[]> stackGetTexturePack = new HashMap<Modchu_ITextureEntityBase, int[]>();
	public Map<Modchu_ITextureEntityBase, Object[]> stackSetTexturePack = new HashMap<Modchu_ITextureEntityBase, Object[]>();

	public List<Object[]> searchPrefix = new ArrayList();

	private LinkedList<String> searchSettledList = new LinkedList();



	public void init() {
	}

	public String[] getSearch(String pName) {
		for (Object[] lss : searchPrefix) {
			String[] s1 = (String[]) lss[0];
			if (s1[0].equals(pName)) {
				return s1;
			}
		}
		return null;
	}

	/**
	 * 追加対象となる検索対象ファイル群とそれぞれの検索文字列を設定する。
	 */
	public void addSearch(String pName, String pTextureDir, String pClassPrefix) {
		if (searchPrefix != null
				&& !searchPrefix.isEmpty()) {
			for (Object[] lss : searchPrefix) {
				String[] s1 = (String[]) lss[0];
				String[] s2 = (String[]) lss[1];
				String[] s3 = (String[]) lss[2];
				if (s1[0].equals(pName)
						&& s2[0].equals(pTextureDir)
						&& s3[0].equals(pClassPrefix)) {
					return;
				}
			}
		}
		searchPrefix.add(new Object[] { new String[] { pName }, new String[] { pTextureDir }, new String[] { pClassPrefix }});
	}

	public void addSearch(String[] pName, String[] pTextureDir, String[] pClassPrefix) {
		searchPrefix.add(new Object[] { pName, pTextureDir, pClassPrefix });
	}

	/**
	 * テクスチャ名称の一致する物を返す。
	 */
	public Modchu_TextureBoxBase getTextureBox(String pName) {
		//Modchu_Debug.mDebug("Modchu_TextureManagerBase getTextureBox pName="+pName);
		if (pName != null
				&& !pName.isEmpty()); else return null;
		for (Modchu_TextureBoxBase ltb : textures) {
			if (ltb.textureName != null
					&& ltb.textureName.equals(pName)) {
				//Modchu_Debug.mDebug("Modchu_TextureManagerBase getTextureBox ltb ok.");
				return ltb;
			}
		}
		return null;
	}

	/**
	 * 渡されたTextureBoxBaseを判定してTextureBoxを返す。
	 * @param pBoxBase
	 * @return
	 */
	public Modchu_TextureBoxBase getTextureBox(Modchu_TextureBoxBase pBoxBase) {
		if (pBoxBase instanceof Modchu_TextureBoxBase) {
			return (Modchu_TextureBoxBase)pBoxBase;
		} else if (pBoxBase instanceof Modchu_TextureBoxServer) {
			return getTextureBox(pBoxBase.textureName);
		}
		return null;
	}

	public Modchu_TextureBoxServer getTextureBoxServer(String pName) {
		for (Modchu_TextureBoxServer lbox : textureServer) {
			if (lbox.textureName.equals(pName)) {
				return lbox;
			}
		}
		return null;
	}

	public Modchu_TextureBoxServer getTextureBoxServer(int pIndex) {
//		Modchu_Debug.tDebug("getTextureBoxServer: %d / %d", pIndex, textureServer.size());
		if (textureServer.size() > pIndex) {
			return textureServer.get(pIndex);
		}
		return null;
	}

	public void getArmorPrefix() {
		// アーマーファイルのプリフィックスを獲得
		armorFilenamePrefix = Modchu_AS.getStringArray(Modchu_AS.renderBipedBipedArmorFilenamePrefix);
	}

	public boolean loadTextures() {
		Modchu_Debug.tDebug("loadTexturePacks.");
		// アーマーのファイル名を識別するための文字列を獲得する
		if (!Modchu_Main.isServer) {
			getArmorPrefix();
		}

		// ファイルを解析してテクスチャを追加
		// jar内のテクスチャを追加
		Modchu_Debug.tDebug("Modchu_TextureManagerBase loadTextures jar load.");
		if (Modchu_FileManager.minecraftJar == null) {
			Modchu_Debug.tDebug("getTexture-append-jar-file not founded.");
		} else {
			for (Object[] lss : searchPrefix) {
				String[] s1 = (String[]) lss[0];
				String[] s2 = (String[]) lss[1];
				String[] s3 = (String[]) lss[2];
				for (String s4 : s1) {
					for (String s5 : s2) {
						for (String s6 : s3) {
							String[] lst = new String[]{ s4, s5, s6 };
							Modchu_Debug.tDebug("getTexture minecraftJar [%s] [%s] [%s]", s4, s5, s6);
							addTexturesJar(Modchu_FileManager.minecraftJar, lst);
						}
					}
				}
			}
		}
		Modchu_Debug.tDebug("Modchu_TextureManagerBase loadTextures jar load end.");
		// jar内のテクスチャを追加
		if (Modchu_FileManager.minecraftJar == null) Modchu_Debug.tDebug("getTexture-append-jar-file not founded.");
		Modchu_Debug.tDebug("Modchu_TextureManagerBase loadTextures mods load.");
		for (Object[] lss : searchPrefix) {
			String[] s1 = (String[]) lss[0];
			String[] s2 = (String[]) lss[1];
			String[] s3 = (String[]) lss[2];
			// mods
			for (String fileName : s1) {
				for (File lf : Modchu_FileManager.getFileList(fileName)) {
					for (String s4 : s1) {
						for (String s5 : s2) {
							for (String s6 : s3) {
								String[] lst = new String[]{ s4, s5, s6 };
								Modchu_Debug.tDebug("getTexture [%s] [%s] [%s]", s4, s5, s6);
								boolean lflag;
								//Modchu_Debug.mDebug("Modchu_TextureManagerBase loadTextures lf="+lf);
								if (lf.isDirectory()) {
									// ディレクトリ
									lflag = addTexturesDir(lf, lst);
								} else {
									// zip
									//Modchu_Debug.mDebug("Modchu_TextureManagerBase loadTextures zip");
									lflag = addTexturesZip(lf, lst);
								}
								Modchu_Debug.tDebug("getTexture-append-%s-%s.", lf.getName(), lflag ? "done" : "fail");
							}
						}
					}
				}
			}
		}
		Modchu_Debug.tDebug("Modchu_TextureManagerBase loadTextures mods load end.");
		// TODO:実験コード
		buildCrafterTexture();
		setModels();

		setDefaultTexture(Modchu_Reflect.loadClass("EntityLivingBase"), getTextureBox("default_" + defaultModelName));
		Modchu_Debug.tDebug("Modchu_TextureManagerBase loadTextures end.");
		return false;
	}

	public void setModels() {
		Modchu_Debug.tDebug("Modchu_TextureManagerBase setModels");
		// テクスチャパッケージにモデルクラスを紐付け
		MultiModelBaseBiped[] ldm = modelMap.get(defaultModelName);
		if (ldm == null && !modelMap.isEmpty()) {
			ldm = (MultiModelBaseBiped[])modelMap.values().toArray()[0];
		}
		if (textures != null
				&& !textures.isEmpty()) {
			for (Modchu_TextureBoxBase ltb : textures) {
				if (ltb.modelName.isEmpty()) {
					ltb.setModels(defaultModelName, null, ldm);
				} else {
					if (modelMap.containsKey(ltb.modelName)) {
						ltb.setModels(ltb.modelName, modelMap.get(ltb.modelName), ldm);
					}
				}
			}
		}
		Modchu_Debug.tDebug("Modchu_TextureManagerBase setModels 1 modelMap.size()="+(modelMap != null ? modelMap.size() : null));
		if (modelMap != null
				&& !modelMap.isEmpty()) {
			for (Entry<String, MultiModelBaseBiped[]> le : modelMap.entrySet()) {
				String key = le.getKey();
				MultiModelBaseBiped[] value = le.getValue();
				String ls = value != null
						&& value.length > 0 ? value[0].getUsingTexture() : null;
				//Modchu_Debug.tDebug("Modchu_TextureManagerBase setModels ls="+ls);
				if (ls != null) {
					if (getTextureBox(ls + "_" + key) == null) {
						Modchu_TextureBoxBase lbox = null;
						if (textures != null
								&& !textures.isEmpty()) {
							for (Modchu_TextureBoxBase ltb : textures) {
								String packegeName = ltb.packegeName;
								if (packegeName != null
										&& ls != null
										&& packegeName.equals(ls)) {
									lbox = ltb;
									break;
								}
							}
						}
						if (lbox != null) {
							lbox = (Modchu_TextureBoxBase) lbox.duplicate();
							lbox.setModels(key, null, value);
							textures.add(lbox);
						}
					}
				}
			}
		}
		Modchu_Debug.tDebug("Loaded Texture Lists.(%d)", textures.size());
		if (textures != null
				&& !textures.isEmpty()) {
			for (Modchu_TextureBoxBase lbox : textures) {
				Modchu_Debug.tDebug("texture: %s(%s) - hasModel:%b", lbox.textureName, lbox.fileName, lbox.models != null);
			}
/*
			for (int li = textures.size() - 1; li >= 0; li--) {
				if (textures.get(li).models == null) {
					textures.remove(li);
				}
			}
			Modchu_Debug.tDebug("Rebuild Texture Lists.(%d)", textures.size());
			for (Modchu_TextureBoxBase lbox : textures) {
				Modchu_Debug.tDebug("texture: %s(%s) - hasModel:%b", lbox.textureName, lbox.fileName, lbox.models != null);
			}
*/
		}
	}

	public void buildCrafterTexture() {
		// TODO:実験コード標準モデルテクスチャで構築
		Modchu_TextureBoxBase lbox = new Modchu_TextureBoxBase("Crafter_Steve", new String[] {"", "", ""});
		lbox.fileName = "";

		lbox.addTexture(0x0c, Modchu_Main.getMinecraftVersion() > 162 ? "textures/entity/steve.png" : "/assets/minecraft/textures/entity/steve.png");
		if (armorFilenamePrefix != null && armorFilenamePrefix.length > 0) {
			for (String ls : armorFilenamePrefix) {
				Map<Integer, Object> lmap = new HashMap();
				lmap.put(tx_armor1, Modchu_Main.newResourceLocation((new StringBuilder()).append("textures/models/armor/").append(ls).append("_layer_2.png").toString()));
				lmap.put(tx_armor2, Modchu_Main.newResourceLocation((new StringBuilder()).append("textures/models/armor/").append(ls).append("_layer_1.png").toString()));
				lbox.armors.put(ls, lmap);
			}
		}

		textures.add(lbox);
	}


	public boolean loadTextureServer() {
		// サーバー用テクスチャ名称のインデクッスローダー
		// 先ずは手持ちのテクスチャパックを追加する。
		textureServer.clear();
		for (Modchu_TextureBoxBase lbox : textures) {
			textureServer.add(new Modchu_TextureBoxServer(lbox));
		}
		// ファイルからロード
		//File lfile = MinecraftServer.getServer().getFile(nameTextureIndex);
		File lfile = Modchu_AS.getFile(Modchu_AS.minecraftServerGetFile, nameTextureIndex);
		if (lfile.exists() && lfile.isFile()) {
			try {
				FileReader fr = new FileReader(lfile);
				BufferedReader br = new BufferedReader(fr);
				String ls;

				while ((ls = br.readLine()) != null) {
					String lt[] = ls.split(",");
					if (lt.length >= 7) {
						// ファイルのほうが優先
						Modchu_TextureBoxServer lbox = getTextureBoxServer(lt[6]);
						if (lbox == null) {
							lbox = new Modchu_TextureBoxServer();
							textureServer.add(lbox);
						}
						lbox.contractColor	= Modchu_HelperBase.getHexToInt(lt[0]);
						lbox.wildColor		= Modchu_HelperBase.getHexToInt(lt[1]);
						lbox.setModelSize(
								Float.valueOf(lt[2]),
								Float.valueOf(lt[3]),
								Float.valueOf(lt[4]),
								Float.valueOf(lt[5]));
						lbox.textureName	= lt[6];
					}
				}

				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			Modchu_Debug.tDebug("Loaded ServerBoxList.(%d)", textureServer.size());
			for (int li = 0; li < textureServer.size(); li++) {
				Modchu_TextureBoxServer lbox = textureServer.get(li);
				Modchu_Debug.tDebug("%04d=%s:%04x:%04x", li, lbox.textureName, lbox.contractColor, lbox.wildColor);
			}
			return true;
		} else {
		}

		return false;
	}

	public void saveTextureServer() {
		// サーバー用テクスチャ名称のインデクッスセーバー
		File lfile = Modchu_AS.getFile(Modchu_AS.minecraftServerGetFile, nameTextureIndex);
		try {
			FileWriter fw = new FileWriter(lfile);
			BufferedWriter bw = new BufferedWriter(fw);

			for (Modchu_TextureBoxServer lbox : textureServer) {
				bw.write(String.format(
						"%04x,%04x,%f,%f,%f,%f,%s",
						lbox.getContractColorBits(),
						lbox.getWildColorBits(),
						lbox.getHeight(null),
						lbox.getWidth(null),
						lbox.getYOffset(null),
						lbox.getMountedYOffset(null),
						lbox.textureName));
				bw.newLine();
			}

			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * テクスチャインデックスを構築。
	 */
	public void initTextureList(boolean pFlag) {
		Modchu_Debug.tDebug("Clear TextureBoxServer.");
		textureServerIndex.clear();
		textureServer.clear();
		if (pFlag) {
			int li = 0;
			for (Modchu_TextureBoxBase lbc : textures) {
				Modchu_TextureBoxServer lbs = new Modchu_TextureBoxServer(lbc);
				textureServer.add(lbs);
				textureServerIndex.put(lbc, li++);
			}
			Modchu_Debug.tDebug("Rebuild TextureBoxServer(%d).", textureServer.size());
		}
	}

	public void addModelClass(String fname, String[] pSearch) {
		// モデルを追加
		int lfindprefix = fname.indexOf(pSearch[2]);
		//Modchu_Debug.tDebug("addModelClass 1 pSearch[2]="+pSearch[2]);
		//Modchu_Debug.tDebug("addModelClass 2 fname="+fname+" lfindprefix="+lfindprefix);
		if (lfindprefix > -1
				&& fname.endsWith(".class")) {
			String cn = Modchu_FileManager.classNameProcessing(fname);
			int version = Modchu_Main.getMinecraftVersion();
			String pn = version > 162 ? fname.substring(pSearch[2].length() + lfindprefix) : fname.substring(pSearch[2].length() + lfindprefix).replace(".class", "");
			if (version > 162) pn = pn.substring(0, pn.length() - 6);
			Modchu_Debug.tDebug("addModelClass cn="+cn+" pn="+pn);
			if (modelMap.containsKey(pn)) return;

			Class lclass;
			try {
				lclass = Modchu_Reflect.loadClass(cn);
				if (lclass != null) {
					if (!(MultiModelBaseBiped.class).isAssignableFrom(lclass) || Modifier.isAbstract(lclass.getModifiers())) {
						Modchu_Debug.tDebug("getModelClass-fail.");
						return;
					}
					MultiModelBaseBiped mlm[] = new MultiModelBaseBiped[3];
					Constructor<MultiModelBaseBiped> cm = lclass.getConstructor(float.class);
					mlm[0] = cm.newInstance(0.0F);
					float[] lsize = mlm[0].getArmorModelsSize();
					//Modchu_Debug.mDebug("getModelClass lclass="+lclass+" lsize[0]="+lsize[0]+" lsize[1]="+lsize[1]);
					mlm[1] = cm.newInstance(lsize[0]);
					mlm[2] = cm.newInstance(lsize[1]);
					modelMap.put(pn, mlm);
					Modchu_Debug.tDebug("getModelClass-%s:%s", pn, cn);
				} else {
					Modchu_Debug.tDebug("getModelClass-class == null !!: %s", cn);
				}
			}
			catch (Exception exception) {
				Modchu_Debug.tDebug("getModelClass-Exception: %s", fname);
				exception.printStackTrace();
			}
			catch (Error error) {
				Modchu_Debug.tDebug("getModelClass-Error: %s", fname);
			}
		}
	}

	public void addTextureName(String fname, String[] pSearch) {
		// パッケージにテクスチャを登録
		String s = fname
				+ (pSearch != null 
				&& pSearch.length > 0 ? pSearch[0] : "")
				+ (pSearch != null 
						&& pSearch.length > 1 ? pSearch[1] : "");
		if (getSearchSettledList().contains(s)) {
			//Modchu_Debug.mDebug("Modchu_TextureManagerBase addTextureName getSearchSettledList().contains return.");
			return;
		}
		getSearchSettledList().add(s);
		if (!fname.startsWith("/")) {
			fname = (new StringBuilder()).append("/").append(fname).toString();
		} else {

		}

		if (fname.startsWith(pSearch[1])) {
			//Modchu_Debug.tDebug("Modchu_TextureManagerBase addTextureName fname="+fname);
			int i = fname.lastIndexOf("/");
			if (pSearch[1].length() < i) {
				String pn = fname.substring(pSearch[1].length(), i);
				pn = pn.replace('/', '.');
				String fn = fname.substring(i);
				int lindex = getIndex(fn);
				if (lindex > -1) {
					String an = null;
					if (lindex == tx_oldarmor1) {
						lindex = tx_armor1;
						an = "default";
					}
					if (lindex == tx_oldarmor2) {
						lindex = tx_armor2;
						an = "default";
					}
					if (lindex == tx_oldwild) {
						lindex = tx_wild + 12;
					}
					Modchu_TextureBoxBase lts = getTextureBox(pn);
					if (lts == null) {
						lts = new Modchu_TextureBoxBase(pn, pSearch);
						textures.add(lts);
						Modchu_Debug.tDebug("getTextureName-append-texturePack-%s", pn);
					}
					lts.addTexture(lindex, fname);
				}
			}
		}
	}

	public boolean addTexturesZip(File file, String[] pSearch) {
		//
		if (file == null || file.isDirectory()) {
			return false;
		}
		try {
			FileInputStream fileinputstream = new FileInputStream(file);
			ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
			ZipEntry zipentry;
			do {
				zipentry = zipinputstream.getNextEntry();
				if(zipentry == null)
				{
					break;
				}
				//Modchu_Debug.tDebug("addTextureZip zipentry.getName()="+zipentry.getName());
				if (!zipentry.isDirectory()) {
					if (zipentry.getName().endsWith(".class")) {
						//Modchu_Debug.tDebug("addTextureZip zipentry. addModelClass");
						addModelClass(zipentry.getName(), pSearch);
					} else {
						addTextureName(zipentry.getName(), pSearch);
					}
				}
			} while(true);

			zipinputstream.close();
			fileinputstream.close();

			return true;
		} catch (Exception e) {
			Modchu_Debug.lDebug("addTextureZip-Exception.", 2, e);
			return false;
		}
	}

	public void addTexturesJar(File file, String[] pSearch) {
		if (file.isFile()) {
			Modchu_Debug.tDebug("addTextureJar-zip.");
			if (addTexturesZip(file, pSearch)) {
				Modchu_Debug.tDebug("getTexture-append-jar-done.");
			} else {
				Modchu_Debug.tDebug("getTexture-append-jar-fail.");
			}
		}

		if (file.isDirectory()) {
			Modchu_Debug.tDebug("addTextureJar-file.");
			boolean lflag = false;

			for (File t : file.listFiles()) {
				if (t.isDirectory()) {
					lflag |= addTexturesDir(t, pSearch);
				}
			}
			if (lflag) {
				Modchu_Debug.tDebug("getTexture-append-jar-done.");
			} else {
				Modchu_Debug.tDebug("getTexture-append-jar-fail.");
			}

			if (addTexturesDir(file, pSearch)) {
				Modchu_Debug.tDebug("getTexture-append-jar-done.");
			} else {
				Modchu_Debug.tDebug("getTexture-append-jar-fail.");
			}

		}
	}

	public boolean addTexturesDir(File file, String[] lst) {
		return addTexturesDir(file, lst, false);
	}

	public boolean addTexturesDir(File file, String[] lst, boolean debug) {
		// modsフォルダに突っ込んであるものも検索、再帰で。
		if (file == null) {
			return false;
		}

		try {
			for (File t : file.listFiles()) {
				if (debug) Modchu_Debug.tDebug("Modchu_TextureManagerBase addTexturesDir t="+t);
				if (t.isDirectory()) {
					addTexturesDir(t, lst);
				} else {
					String s = t.getPath().replace('\\', '/');
					if (t.getName().endsWith(".class")) {
						addModelClass(t.getAbsolutePath(), lst);
					} else {
						int i = s.indexOf(lst[1]);
						if (i > -1) {
							// 対象はテクスチャディレクトリ
							addTextureName(s.substring(i), lst);
						}
					}
				}
			}
			return true;
		} catch (Exception e) {
			Modchu_Debug.lDebug("addTextureDebug-Exception.", 2, e);
			return false;
		}
	}

	public int getIndex(String name) {
		// 名前からインデックスを取り出す
		for (int i = 0; i < defNames.length; i++) {
			if (name.endsWith(defNames[i])) {
				return i;
			}
		}

		Pattern p = Pattern.compile("_([0-9a-f]+).png");
		Matcher m = p.matcher(name);
		if (m.find()) {
			return Integer.decode("0x" + m.group(1));
		}

		return -1;
	}

	public Modchu_TextureBoxBase getNextPackege(Modchu_TextureBoxBase pNowBox, int pColor) {
		// 次のテクスチャパッケージの名前を返す
		boolean f = false;
		Modchu_TextureBoxBase lreturn = null;
/*
		for (Modchu_TextureBoxBase ltb : textures) {
			Modchu_Debug.mDebug("Modchu_TextureManagerBase getNextPackege ltb.textureName="+ltb.textureName+" ltb.hasColor(pColor)="+ltb.hasColor(pColor));
		}
*/
		for (Modchu_TextureBoxBase ltb : textures) {
			if (ltb.hasColor(pColor)
					&& ltb.textureName != null
					&& !ltb.textureName.isEmpty()) {
				if (f) {
					return ltb;
				}
				if (lreturn == null) {
					lreturn = ltb;
				}
			}
			if (ltb == pNowBox) {
				f = true;
			}
		}
		//if (lreturn != null) return lreturn;
		return textures != null
				&& !textures.isEmpty() ? textures.get(0) : null;
	}

	public Modchu_TextureBoxBase getPrevPackege(Modchu_TextureBoxBase pNowBox, int pColor) {
		//Modchu_Debug.mDebug("getPrevPackege");
		// 前のテクスチャパッケージの名前を返す
		Modchu_TextureBoxBase lreturn = null;
		for (Modchu_TextureBoxBase ltb : textures) {
			if (ltb == pNowBox) {
				if (lreturn != null) {
					//Modchu_Debug.mDebug("getPrevPackege return lreturn="+lreturn);
					return lreturn;
				}
			}
			if (ltb.hasColor(pColor)
					&& ltb.textureName != null
					&& !ltb.textureName.isEmpty()) {
				//Modchu_Debug.mDebug("getPrevPackege hasColor lreturn="+ltb);
				lreturn = ltb;
			}
		}
		//if (lreturn != null) return lreturn;
		return textures != null
				&& textures.size() > 0 ? textures.get(textures.size() - 1) : null;
	}

	/**
	 * ローカルで読み込まれているテクスチャパックの数。
	 */
	public int getTextureCount() {
		return textures.size();
	}

	public Modchu_TextureBoxBase getNextArmorPackege(Modchu_TextureBoxBase pNowBox) {
		// 次のテクスチャパッケージの名前を返す
		boolean f = false;
		Modchu_TextureBoxBase lreturn = null;
		for (Modchu_TextureBoxBase ltb : textures) {
			if (ltb.hasArmor()) {
				if (f) {
					return ltb;
				}
				if (lreturn == null) {
					lreturn = ltb;
				}
			}
			if (ltb == pNowBox) {
				f = true;
			}
		}
		return lreturn;
	}

	public Modchu_TextureBoxBase getPrevArmorPackege(Modchu_TextureBoxBase pNowBox) {
		// 前のテクスチャパッケージの名前を返す
		Modchu_TextureBoxBase lreturn = null;
		for (Modchu_TextureBoxBase ltb : textures) {
			if (ltb == pNowBox) {
				if (lreturn != null) {
					break;
				}
			}
			if (ltb.hasArmor()) {
				lreturn = ltb;
			}
		}
		return lreturn;
	}

	public String getRandomTextureString(Random pRand) {
		return getRandomTexture(pRand).textureName;
	}

	public Modchu_TextureBoxServer getRandomTexture(Random pRand) {
		if (textureServer.isEmpty()) {
			return null;
		} else {
			// 野生色があるものをリストアップ
			List<Modchu_TextureBoxServer> llist = new ArrayList<Modchu_TextureBoxServer>();
			for (Modchu_TextureBoxServer lbox : textureServer) {
				if (lbox.getWildColorBits() > 0) {
					llist.add(lbox);
				}
			}
			return llist.get(pRand.nextInt(llist.size()));
		}
	}

	/**
	 * テクスチャパック名に対応するインデックスを返す。
	 * 基本サーバー用。
	 * @param pEntity
	 * @param pPackName
	 * @return
	 */
	public int getIndexTextureBoxServer(Modchu_ITextureEntityBase pEntity, String pPackName) {
		for (int li = 0; li < textureServer.size(); li++) {
			if (textureServer.get(li).textureName.equals(pPackName)) {
				return li;
			}
		}
		// 見当たらなかったのでEntityに対応するデフォルトを返す
//		int li = textureServerIndex.get(getDefaultTexture(pEntity));
		Modchu_TextureBoxBase lbox = getDefaultTexture(pEntity);
		if (lbox != null) {
			pPackName = lbox.textureName;
			for (int li = 0; li < textureServer.size(); li++) {
				if (textureServer.get(li).textureName.equals(pPackName)) {
					return li;
				}
			}
		}
		return 0;
	}

	/**
	 * 指定されたテクスチャパックのサーバー側の管理番号を返す。
	 * @param pBox
	 * @return
	 */
	public int getIndexTextureBoxServerIndex(Modchu_TextureBoxBase pBox) {
		return textureServerIndex.get(pBox);
	}

	/**
	 * Entityに対応するデフォルトのテクスチャを設定する。
	 */
	public void setDefaultTexture(Modchu_ITextureEntityBase pEntity, Modchu_TextureBoxBase pBox) {
		setDefaultTexture(pEntity.getClass(), pBox);
	}
	public void setDefaultTexture(Class pEntityClass, Modchu_TextureBoxBase pBox) {
		defaultTextures.put(pEntityClass, pBox);
		Modchu_Debug.tDebug("appendDefaultTexture:%s(%s)",
				pEntityClass.getSimpleName(), pBox == null ? "NULL" : pBox.textureName);
	}

	/**
	 * Entityに対応するデフォルトモデルを返す。
	 */
	public Modchu_TextureBoxBase getDefaultTexture(Modchu_ITextureEntityBase pEntity) {
		return getDefaultTexture(pEntity.getClass());
	}
	public Modchu_TextureBoxBase getDefaultTexture(Class pEntityClass) {
		if (defaultTextures.containsKey(pEntityClass)) {
			return defaultTextures.get(pEntityClass);
		} else {
			Class lsuper = pEntityClass.getSuperclass();
			if (lsuper != null) {
				Modchu_TextureBoxBase lbox = getDefaultTexture(lsuper);
				if (lbox != null) {
					setDefaultTexture(pEntityClass, lbox);
				}
				return lbox;
			}
			return null;
		}
	}



	/*
	 * サーバークライアント間でのテクスチャ管理関数群
	 */

	// ネットワーク越しにテクスチャインデクスを得る際に使う
	public int getRequestStringIndex(String pVal) {
		int lblank = -1;
		for (int li = 0; li < requestString.length; li++) {
			if (requestString[li] == null) {
				lblank = li;
				requestStringCounter[li] = 0;
			} else if (requestString[li].equals(pVal)) {
				// 既に要求中
				return -2;
			}
		}
		if (lblank >= 0) {
			requestString[lblank] = pVal;
		} else {
			Modchu_Debug.tDebug("requestString Overflow!");
		}
		return lblank;
	}

	public String getRequestString(int pIndex) {
		String ls = requestString[pIndex];
		requestString[pIndex] = null;
		return ls;
	}

	public int getRequestIndex(int pTextureServerBoxIndex) {
		int lblank = -1;
		for (int li = 0; li < requestIndex.length; li++) {
			if (requestIndex[li] == -1) {
				lblank = li;
				requestIndexCounter[li] = 0;
			} else if (requestIndex[li] == pTextureServerBoxIndex) {
				// 既に要求中
				return -2;
			}
		}
		if (lblank >= 0) {
			requestIndex[lblank] = pTextureServerBoxIndex;
		} else {
			Modchu_Debug.tDebug("requestIndex Overflow!");
		}
		return lblank;
	}

	public boolean clearRequestIndex(int pTextureServerBoxIndex) {
		for (int li = 0; li < requestIndex.length; li++) {
			if (requestIndex[li] == pTextureServerBoxIndex) {
				// 要求中だったので消す。
				requestIndex[li] = -1;
				return true;
			}
		}
		return false;
	}


	public Modchu_TextureBoxBase getTextureBoxServerIndex(int pIndex) {
		for (Entry<Modchu_TextureBoxBase, Integer> le : textureServerIndex.entrySet()) {
			if (le.getValue() == pIndex) {
				return le.getKey();
			}
		}
		return null;
	}


	/**
	 * テクスチャパックを設定するため、サーバーへ情報を送る。
	 * @param pEntity
	 * @param pBox
	 */
/*
	public void postSetTexturePack(Modchu_ITextureEntityBase pEntity, int pColor, ModchuModel_TextureBoxBase[] pBox) {
		// Client
		if (!(pEntity instanceof Entity)) return;
		// テクスチャパックを設定するため、サーバーへ情報を送る。
		int lindex[] = new int[pBox.length];
		boolean lflag = true;

		// PackeNameからサーバー側のテクスチャインデックスを獲得する。
		for (int li = 0; li < pBox.length; li++) {
			lindex[li] = checkTextureBoxServer((ModchuModel_TextureBox)pBox[li]);
			if (lindex[li] < 0) {
				lflag = false;
			}
		}

		if (lflag) {
			// すべての名称からインデックスを取り出せた場合、サーバーへポストする。
			sendToServerSetTexturePackIndex(pEntity, pColor, lindex);
		} else {
			// ローカルに設定値がない場合、バッファにジョブをスタックし終了。
			Object lo[] = new Object[1 + pBox.length];
			lo[0] = pColor;
			for (int li = 0; li < pBox.length; li++) {
				lo[li + 1] = pBox[li];
			}
			stackSetTexturePack.put(pEntity, lo);
		}
	}
*/
	/**
	 * TextureBoxにサーバー識別番号が付与されているかを確認し、なければ問い合わせを行う。
	 * @param pBox
	 * @return
	 */
/*
	public int checkTextureBoxServer(ModchuModel_TextureBox pBox) {
		// Client
		if (textureServerIndex.containsKey(pBox)) {
			return textureServerIndex.get(pBox);
		} else {
			int ll = getRequestStringIndex(pBox.textureName);
			if (ll > -1) {
				sendToServerGetTextureIndex(ll, pBox);
				return -1;
			} else {
				return ll;
			}
		}
	}

	public void sendToServerSetTexturePackIndex(Modchu_ITextureEntityBase pEntity, int pColor, int[] pIndex) {
		// Client
		// サーバー側へテクスチャパックのインデックスが変更されたことを通知する。
		if (pEntity instanceof Entity) {
			byte ldata[] = new byte[6 + pIndex.length * 2];
			ldata[0] = ModchuModel_Statics.Server_SetTexturePackIndex;
			ModchuModel_Helper.setInt(ldata, 1, ((Entity)pEntity).entityId);
			ldata[5] = (byte)pColor;
			int li = 6;
			for (int ll  : pIndex) {
				ModchuModel_Helper.setShort(ldata, li, ll);
				li += 2;
			}
			ModchuModel_Client.sendToServer(ldata);
		}
	}

	public void reciveFromClientSetTexturePackIndex(Entity pEntity, byte[] pData) {
		// Server
		if (pEntity instanceof Modchu_ITextureEntityBase) {
			// クライアント側からテクスチャパックのインデックスが変更された通知を受け取ったので処理を行う。
			int lcount = (pData.length - 6) / 2;
			if (lcount < 1) return;
			int lindex[] = new int[lcount];

			for (int li = 0; li < lcount; li++) {
				lindex[li] = ModchuModel_Helper.getShort(pData, 6 + li * 2);
			}
			Modchu_Debug.tDebug("reciveFromClientSetTexturePackIndex: %d, %4x", pData[5], lindex[0]);
			((Modchu_ITextureEntityBase)pEntity).setTexturePackIndex(pData[5], lindex);
		}
	}

	public void sendToServerGetTextureIndex(int pBufIndex, ModchuModel_TextureBox pBox) {
		// Client
		// サーバー側へテクスチャパックの管理番号を問い合わせる。
		// 呼び出し側のクライアントへのみ返す。
		// 返すときはNameは不要、BufIndexのみで識別させる
		byte ldata[] = new byte[22 + pBox.textureName.length()];
		ldata[0] = ModchuModel_Statics.Server_GetTextureIndex;
		ldata[1] = (byte)pBufIndex;
		ModchuModel_Helper.setShort(ldata, 2, pBox.getContractColorBits());
		ModchuModel_Helper.setShort(ldata, 4, pBox.getWildColorBits());
		ModchuModel_Helper.setFloat(ldata, 6, pBox.getHeight(null));
		ModchuModel_Helper.setFloat(ldata, 10, pBox.getWidth(null));
		ModchuModel_Helper.setFloat(ldata, 14, pBox.getYOffset(null));
		ModchuModel_Helper.setFloat(ldata, 18, pBox.getMountedYOffset(null));
		ModchuModel_Helper.setStr(ldata, 22, pBox.textureName);
		ModchuModel_Client.sendToServer(ldata);
		Modchu_Debug.tDebug("Server_GetTextureIndex: %s", pBox.textureName);
	}

	public void reciveFromClientGetTexturePackIndex(NetServerHandler pHandler, byte[] pData) {
		// Server
		// クライアント側へテクスチャパックの管理番号を返す。
		String lpackname = ModchuModel_Helper.getStr(pData, 22);
		ModchuModel_TextureBoxServer lboxsrv = getTextureBoxServer(lpackname);
		int li;
		if (lboxsrv == null) {
			li = textureServer.size();
			lboxsrv = new ModchuModel_TextureBoxServer();
			textureServer.add(lboxsrv);
		} else {
			li = textureServer.indexOf(lboxsrv);
		}
		lboxsrv.setValue(pData);

		byte ldata[] = new byte[4];
		ldata[0] = ModchuModel_Statics.Client_SetTextureIndex;
		ldata[1] = pData[1];
		ModchuModel_Helper.setShort(ldata, 2, li);
		Modchu_Debug.tDebug("reciveFromClientGetTexturePackIndex: %s, %04x", lpackname, li);
		Modchu_Debug.sendToClient(pHandler, ldata);
	}

	public void reciveFormServerSetTexturePackIndex(byte[] pData) {
		// Client
		// サーバー側からテクスチャパックのインデックスを受け取ったので値を登録する。
		ModchuModel_TextureBox lbox = getTextureBox(getRequestString(pData[1]));
		textureServerIndex.put(lbox, (int)ModchuModel_Helper.getShort(pData, 2));
		Modchu_Debug.tDebug("reciveFormServerSetTexturePackIndex: %s, %04x", lbox.textureName, (int)ModchuModel_Helper.getShort(pData, 2));

		// スタックされたジョブから処理可能な物があれば実行する。
		Map<Modchu_ITextureEntityBase, Object[]> lmap = new HashMap<Modchu_ITextureEntityBase, Object[]>(stackSetTexturePack);
		stackSetTexturePack.clear();
		for (Entry<Modchu_ITextureEntityBase, Object[]> le : lmap.entrySet()) {
			Object lo[] = le.getValue();
			ModchuModel_TextureBox ls[] = new ModchuModel_TextureBox[le.getValue().length - 1];
			int lc = (Integer)lo[0];
			for (int li = 1; li < lo.length; li++) {
				ls[li - 1] = (ModchuModel_TextureBox)lo[li];
			}
			postSetTexturePack(le.getKey(), lc, ls);
		}
	}
*/


	/**
	 * サーバーから設定されたテクスチャインデックスからテクスチャパックを取得する。
	 * @param pEntity
	 * @param pIndex
	 */
/*
	public void postGetTexturePack(Modchu_ITextureEntityBase pEntity, int[] pIndex) {
		// Client
		// クライアント側で指定されたインデックスに対してテクスチャパックの名称を返し設定させる
		ModchuModel_TextureBox lbox[] = new ModchuModel_TextureBox[pIndex.length];
		boolean lflag = true;

		// ローカルインデックスに名称が登録されていなければサーバーへ問い合わせる。
		for (int li = 0; li < pIndex.length; li++) {
			lbox[li] = getTextureBoxServerIndex(pIndex[li]);
			if (lbox[li] == null) {
				if (getRequestIndex(pIndex[li]) > -1) {
					sendToServerGetTexturePackName(pIndex[li]);
				}
				lflag = false;
			}
		}

		if (lflag) {
			// 全ての値が取れる場合はEntityへ値を設定する。
			pEntity.setTexturePackName(lbox);
		} else {
			// 不明値がある場合は処理をスタックする。
			stackGetTexturePack.put(pEntity, pIndex);
		}
	}

	public void sendToServerGetTexturePackName(int pIndex) {
		// Client
		// サーバー側へテクスチャパックの名称を問い合わせる
		if (pIndex < 0) {
			Modchu_Debug.tDebug("request range out.");
			return;
		}
		byte ldata[] = new byte[3];
		ldata[0] = ModchuModel_Statics.Server_GetTexturePackName;
		ModchuModel_Helper.setShort(ldata, 1, pIndex);
		ModchuModel_Client.sendToServer(ldata);
	}

	public void reciveFromClientGetTexturePackName(NetServerHandler pHandler, byte[] pData) {
		// Server
		// クライアントからテクスチャパックの名称が問い合わせられた。
		int lindex = ModchuModel_Helper.getShort(pData, 1);
		ModchuModel_TextureBoxServer lboxserver = getTextureBoxServer(lindex);

		// Clientへ管理番号に登録されているテクスチャ名称をポストする
		byte ldata[] = new byte[23 + lboxserver.textureName.length()];
		ldata[0] = ModchuModel_Statics.Client_SetTexturePackName;
		ModchuModel_Helper.setShort(ldata, 1, lindex);
		ModchuModel_Helper.setShort(ldata, 3, lboxserver.getContractColorBits());
		ModchuModel_Helper.setShort(ldata, 5, lboxserver.getWildColorBits());
		ModchuModel_Helper.setFloat(ldata, 7, lboxserver.getHeight(null));
		ModchuModel_Helper.setFloat(ldata, 11, lboxserver.getWidth(null));
		ModchuModel_Helper.setFloat(ldata, 15, lboxserver.getYOffset(null));
		ModchuModel_Helper.setFloat(ldata, 19, lboxserver.getMountedYOffset(null));
		ModchuModel_Helper.setStr(ldata, 23, lboxserver.textureName);
		Modchu_Debug.sendToClient(pHandler, ldata);
		Modchu_Debug.tDebug("SetTexturePackName:%04x - %s", lindex, lboxserver.textureName);
	}

	public void reciveFromServerSetTexturePackName(byte[] pData) {
		// Client
		// サーバーからインデックスに対する名称の設定があった。
		String lpackname = ModchuModel_Helper.getStr(pData, 23);
		ModchuModel_TextureBox lbox = getTextureBox(lpackname);
		if (lbox == null) {
			// ローカルには存在しないテクスチャパック
			// TODO:この辺要修正
			lbox = getTextureBox("default_Orign").duplicate();
			lbox.textureName = lpackname;
//			lbox = new ModchuModel_TextureBox(lpackname, null);
			lbox.setModelSize(
					ModchuModel_Helper.getFloat(pData, 7),
					ModchuModel_Helper.getFloat(pData, 11),
					ModchuModel_Helper.getFloat(pData, 15),
					ModchuModel_Helper.getFloat(pData, 19));
			textures.add(lbox);
		}
		int lindex = ModchuModel_Helper.getShort(pData, 1);
		textureServerIndex.put(lbox, lindex);
		clearRequestIndex(lindex);

		// 処理可能な物がスタックされている場合は処理を行う。
		Map<Modchu_ITextureEntityBase, int[]> lmap = new HashMap<Modchu_ITextureEntityBase, int[]>(stackGetTexturePack);
		stackGetTexturePack.clear();
		for (Entry<Modchu_ITextureEntityBase, int[]> le : lmap.entrySet()) {
			postGetTexturePack(le.getKey(), le.getValue());
		}
	}
*/
	/**
	 * Request系の値を一定カウントで消去
	 */
	public void onUpdate() {
		for (int li = 0; li < requestString.length; li++) {
			// 約30秒で解放
			if (requestString[li] != null && requestStringCounter[li]++ > 600) {
				requestString[li] = null;
				requestStringCounter[li] = 0;
			}
			if (requestIndex[li] != -1 && requestIndexCounter[li]++ > 600) {
				requestIndex[li] = -1;
				requestIndexCounter[li] = 0;
			}
		}
	}

	public LinkedList getSearchSettledList() {
		return searchSettledList;
	}

}
