package net.minecraft.src;

import java.util.Map;

/**
 * 装備品用のクラス。
 *
 */
public class Modchu_EquippedStabilizer {

	public Modchu_ModelStabilizerBase stabilizer;
	public Modchu_ModelRenderer equipPoint;
	public String equipPointName;
	public Map<String, Object> localValues;

/*
	public MMM_EquippedStabilizer(String pEquipPointName, MMM_ModelStabilizerBase pStabilizer) {
		equipPointName = pEquipPointName;
		stabilizer = pStabilizer;
	}
*/
	public boolean updateEquippedPoint(ModelBase pmodel) {
		// 取り付け位置をアップデート
		for (int li = 0; li < pmodel.boxList.size(); li++) {
    		ModelRenderer lmr = (ModelRenderer)pmodel.boxList.get(li);
    		if (lmr instanceof Modchu_ModelRenderer) {
    			if (lmr.boxName != null && lmr.boxName.equalsIgnoreCase(equipPointName)) {
    				equipPoint = (Modchu_ModelRenderer)lmr;
    				return true;
    			}
			}
		}

		equipPoint = null;
		return false;
	}


}
