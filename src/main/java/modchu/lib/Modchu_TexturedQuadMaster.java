package modchu.lib;

import java.util.HashMap;

public class Modchu_TexturedQuadMaster implements Modchu_ITexturedQuadMaster {
	public Modchu_ITexturedQuad base;
	public boolean invertNormal;
	private Object[] vertexPositions;

	public Modchu_TexturedQuadMaster(HashMap<String, Object> map) {
		base = (Modchu_ITexturedQuad) map.get("base");
		vertexPositions = (Object[]) (map.containsKey("Object[]") ? map.get("Object[]") : null);
		if (!map.containsKey("Integer")) return;
		int texcoordU1 = (Integer) (map.containsKey("Integer") ? map.get("Integer") : 0);
		int texcoordV1 = (Integer) (map.containsKey("Integer1") ? map.get("Integer1") : 0);
		int texcoordU2 = (Integer) (map.containsKey("Integer2") ? map.get("Integer2") : 0);
		int texcoordV2 = (Integer) (map.containsKey("Integer3") ? map.get("Integer3") : 0);
		float textureWidth = (Float) (map.containsKey("Float") ? map.get("Float") : 64.0F);
		float textureHeight = (Float) (map.containsKey("Float1") ? map.get("Float1") : 32.0F);
		//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster textureWidth="+textureWidth+" textureHeight="+textureHeight);
		float f2 = 0.0F / textureWidth;
		float f3 = 0.0F / textureHeight;
		//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster vertexPositions="+vertexPositions);
		if (vertexPositions != null); else return;
		if (vertexPositions.length > 0); else return;
		if (vertexPositions[0] != null) vertexPositions[0] = Modchu_AS.get("PositionTextureVertex", "setTexturePosition", new Class[]{ float.class, float.class }, vertexPositions[0], new Object[]{ (float)texcoordU2 / textureWidth - f2, (float)texcoordV1 / textureHeight + f3 });
		if (vertexPositions.length > 1); else return;
		if (vertexPositions[1] != null) vertexPositions[1] = Modchu_AS.get("PositionTextureVertex", "setTexturePosition", new Class[]{ float.class, float.class }, vertexPositions[1], new Object[]{ (float)texcoordU1 / textureWidth + f2, (float)texcoordV1 / textureHeight + f3 });
		if (vertexPositions.length > 2); else return;
		if (vertexPositions[2] != null) vertexPositions[2] = Modchu_AS.get("PositionTextureVertex", "setTexturePosition", new Class[]{ float.class, float.class }, vertexPositions[2], new Object[]{ (float)texcoordU1 / textureWidth + f2, (float)texcoordV2 / textureHeight - f3 });
		if (vertexPositions.length > 3); else return;
		if (vertexPositions[3] != null) vertexPositions[3] = Modchu_AS.get("PositionTextureVertex", "setTexturePosition", new Class[]{ float.class, float.class }, vertexPositions[3], new Object[]{ (float)texcoordU2 / textureWidth - f2, (float)texcoordV2 / textureHeight - f3 });
	}

	@Override
	public void flipFace() {
		Object[] apositiontexturevertex = Modchu_Reflect.newInstanceArray("PositionTextureVertex", vertexPositions.length);
		for (int i = 0; i < vertexPositions.length; ++i) {
			apositiontexturevertex[i] = vertexPositions[vertexPositions.length - i - 1];
		}
		vertexPositions = apositiontexturevertex;
		//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster flipFace vertexPositions="+vertexPositions);
	}

	@Override
	public void draw(float f) {
		//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster draw f="+f);
		Object worldRendererOrTessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);
		if (vertexPositions != null
				&& vertexPositions.length > 0);
		else {
			//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster vertexPositions="+vertexPositions);
			String ss = "Modchu_TexturedQuadMaster draw vertexPositions == null error !!";
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		Object vec3_1 = vertexPositions[1] != null ? Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[1]) : null;
		if (vec3_1 != null); else {
			String ss = "Modchu_TexturedQuadMaster draw vec3_1 == null error !!";
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		//Modchu_Debug.lDebug("Modchu_TexturedQuadMaster draw vec3_1="+vec3_1);
		//Modchu_Debug.lDebug("Modchu_TexturedQuadMaster draw vertexPositions[1]="+vertexPositions[1]);
		//Modchu_Debug.lDebug("Modchu_TexturedQuadMaster draw positionTextureVertexVector3D="+Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[1]));
		Object vec3_0 = vec3_1 != null ? Modchu_AS.get(Modchu_AS.vec3Subtract, vec3_1, Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[0])) : null;
		//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster draw vec3_0="+vec3_0);
		if (vec3_0 != null); else {
			String ss = "Modchu_TexturedQuadMaster draw vec3_0 == null error !!";
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		Object vec3_2 = vec3_1 != null
				&& vertexPositions[2] != null ? Modchu_AS.get(Modchu_AS.vec3Subtract, vec3_1, Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[2])) : null;
		//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster draw vec3_2="+vec3_2);
		if (vec3_2 != null); else {
			String ss = "Modchu_TexturedQuadMaster draw vec3_2 == null error !!";
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		Object vec3_3 = vec3_2 != null
				&& vec3_0 != null ? Modchu_AS.get(Modchu_AS.vec3Normalize, Modchu_AS.get(Modchu_AS.vec3CrossProduct, vec3_2, vec3_0)) : null;
		//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster draw vec3_3="+vec3_3);
		if (vec3_3 != null); else {
			String ss = "Modchu_TexturedQuadMaster draw vec3_3 == null error !!";
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 180) {
			Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, worldRendererOrTessellator, 7, Modchu_AS.get("DefaultVertexFormats", version > 188 ? "OLDMODEL_POSITION_TEX_NORMAL" : "field_181703_c"));
		} else {
			Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, worldRendererOrTessellator);
		}

		float fx = (float) Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vec3_3);
		float fy = (float) Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vec3_3);
		float fz = (float) Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vec3_3);
		if (vec3_3 != null) {
			if (invertNormal) {
				fx = -fx;
				fy = -fy;
				fz = -fz;
			}
			Modchu_AS.set(Modchu_AS.tessellatorSetNormal, worldRendererOrTessellator, fx, fy, fz);
		}

		for (Object vertexPosition : vertexPositions) {
			if (vertexPosition != null); else continue;
			Object vertexPositionVec3 = Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPosition);
			//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster vertexPositionVec3="+vertexPositionVec3);
			//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster f="+f);
			double vec3XCoord = Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vertexPositionVec3);
			double vec3YCoord = Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vertexPositionVec3);
			double vec3ZCoord = Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vertexPositionVec3);
			float texturePositionX = Modchu_AS.getFloat(Modchu_AS.positionTextureVertexTexturePositionX, vertexPosition);
			float texturePositionY = Modchu_AS.getFloat(Modchu_AS.positionTextureVertexTexturePositionY, vertexPosition);
/*
			Modchu_Debug.mDebug("Modchu_TexturedQuadMaster vec3XCoord="+vec3XCoord);
			Modchu_Debug.mDebug("Modchu_TexturedQuadMaster vec3YCoord="+vec3YCoord);
			Modchu_Debug.mDebug("Modchu_TexturedQuadMaster vec3ZCoord="+vec3ZCoord);
			Modchu_Debug.mDebug("Modchu_TexturedQuadMaster texturePositionX="+texturePositionX);
			Modchu_Debug.mDebug("Modchu_TexturedQuadMaster texturePositionY="+texturePositionY);
*/
			boolean b = Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, worldRendererOrTessellator,
					(double) ((float) vec3XCoord * f),
					(double) ((float) vec3YCoord * f),
					(double) ((float) vec3ZCoord * f),
					(double) texturePositionX,
					(double) texturePositionY,
					fx, fy, fz);
			//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster b="+b);
		}
		Modchu_AS.set(Modchu_AS.tessellatorDraw, worldRendererOrTessellator);
		//Modchu_Debug.mDebug("Modchu_TexturedQuadMaster end");
	}

	@Override
	public void setInvertNormal(boolean b) {
		invertNormal = b;
	}

}