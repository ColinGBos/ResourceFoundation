package vapourdrive.resourcefoundation.world;

import vapourdrive.resourcefoundation.utils.WeightedBlockState;

public class Generation
{
	private final EnumGenerationType type;
	private final int frequency;
	private final int minY;
	private final int maxY;
	private final int size;
	private final int dimension;
	private final WeightedBlockState[] weightedBlocks;
	
	public Generation(EnumGenerationType Type, int Frequency, int MinY, int MaxY, int Size, int Dimension, WeightedBlockState[] WeightedBlocks)
	{
		this.type = Type;
		this.frequency = Frequency;
		this.minY = MinY;
		this.maxY = MaxY;
		this.size = Size;
		this.dimension = Dimension;
		this.weightedBlocks = WeightedBlocks;
	}
	
	public EnumGenerationType getType()
	{
		return this.type;
	}
	
	public int getFrequency()
	{
		return this.frequency;
	}
	
	public int getMinY()
	{
		return this.minY;
	}
	
	public int getMaxY()
	{
		return this.maxY;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public int getDimension()
	{
		return this.dimension;
	}
	
	public WeightedBlockState[] getWeightedBlocks()
	{
		return this.weightedBlocks;
	}
}
