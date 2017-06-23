package modchu.lib.forge.mc194_202;

import java.util.HashMap;
import java.util.Map;

import modchu.lib.Modchu_Debug;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.VertexFormat;
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

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		((Tessellator) tessellator).getBuffer().pos(d, d2, d3).tex(d4, d5).endVertex();
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, float f, float f1, float f2) {
		((Tessellator) tessellator).getBuffer().pos(d, d2, d3).tex(d4, d5).normal(f, f1, f2).endVertex();
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, int i, int i1, int i2, int i3) {
		((Tessellator) tessellator).getBuffer().pos(d, d2, d3).tex(d4, d5).color(i, i1, i2, i3).endVertex();
	}

	@Override
	public void tessellatorStartDrawing(Object tessellator, int i, Object vertexFormat) {
		((Tessellator) tessellator).getBuffer().begin(i, (VertexFormat) vertexFormat);
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		((Tessellator) tessellator).getBuffer().pos(d, d2, d3).endVertex();
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3, int i, int i1, int i2, int i3) {
		((Tessellator) tessellator).getBuffer().pos(d, d2, d3).color(i, i1, i2, i3).endVertex();
	}

	@Override
	public void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		((TexturedQuad) texturedQuad).draw(((Tessellator) tessellator).getBuffer(), f);
	}

}