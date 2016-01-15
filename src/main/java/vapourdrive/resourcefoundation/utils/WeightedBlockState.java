package vapourdrive.resourcefoundation.utils;

import net.minecraft.block.state.IBlockState;

public class WeightedBlockState
{
	private final int weight;
	private final IBlockState state;
	
	public WeightedBlockState(int Weight, IBlockState State)
	{
		this.weight = Weight;
		this.state = State;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public IBlockState getState()
	{
		return this.state;
	}
	
}
