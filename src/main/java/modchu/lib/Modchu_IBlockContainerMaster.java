package modchu.lib;

public interface Modchu_IBlockContainerMaster extends Modchu_IBlockMaster {
	public Object createNewTileEntity(Object world);
	public Object createNewTileEntity(Object world, int i);
	// 190~
	public boolean isInvalidNeighbor(Object world, Object blockPos, Object enumFacing);
	public boolean hasInvalidNeighbor(Object world, Object blockPos);

}
