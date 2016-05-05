package modchu.lib;

public interface Modchu_IBlockContainer extends Modchu_IBlock {
	public Object superCreateNewTileEntity(Object world);
	public Object superCreateNewTileEntity(Object world, int i);
	// 190~
	public boolean superIsInvalidNeighbor(Object world, Object blockPos, Object enumFacing);
	public boolean superHasInvalidNeighbor(Object world, Object blockPos);

}
