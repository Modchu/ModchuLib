package modchu.lib.forge.mc194_202;

import java.util.HashMap;
import java.util.Map;

import modchu.lib.Modchu_Debug;
import net.minecraft.entity.EntityList;

public abstract class Modchu_ASMaster extends modchu.lib.forge.mc190_202.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public int getVacancyGlobalEntityID() {
		Map map = EntityList.ID_TO_CLASS;
		int ID = -1;
		if (map != null) {
			for(int i = 64; i < 3000; i++) {
				//Modchu_Debug.mDebug("getVacancyGlobalEntityID i"+i+" !map.containsKey(i) = "+(!map.containsKey(i)));
				if (!map.containsKey(i)) {
					ID = i;
					//Modchu_Debug.mDebug("getVacancyGlobalEntityID !map.containsKey ID="+ID);
					break;
				}
			}
		} else {
			Modchu_Debug.lDebug("getVacancyGlobalEntityID IDtoClassMapping map == null !!");
		}
		return ID;
	}

	@Override
	public Map entityListIDtoClassMapping() {
		return EntityList.ID_TO_CLASS;
	}

	@Override
	public Map entityListStringToClassMapping() {
		return EntityList.NAME_TO_CLASS;
	}

	@Override
	public Map entityListClassToStringMapping() {
		return EntityList.CLASS_TO_NAME;
	}

}