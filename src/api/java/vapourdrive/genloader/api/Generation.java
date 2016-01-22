package vapourdrive.genloader.api;

import java.util.ArrayList;

import net.minecraftforge.common.BiomeDictionary.Type;

public class Generation
{
	private final String category;
	private final EnumGenerationType type;
	private final int frequency;
	private final int minY;
	private final int maxY;
	private final int size;
	private final ArrayList<String> dimensions;
	private final ArrayList<Type> biomeTypes;
	private final WeightedBlockState[] weightedBlocks;
	
	public Generation(String Category, EnumGenerationType Type, int Frequency, int MinY, int MaxY, int Size, ArrayList<String> Dimensions, ArrayList<Type> Biomes, WeightedBlockState[] WeightedBlocks)
	{
		this.category = Category;
		this.type = Type;
		this.frequency = Frequency;
		this.minY = MinY;
		this.maxY = MaxY;
		this.size = Size;
		this.dimensions = Dimensions;
		this.weightedBlocks = WeightedBlocks;
		this.biomeTypes = Biomes;
	}
	
	public String getOwner()
	{
		return this.category;
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
	
	public ArrayList<String> getDimensions()
	{
		return this.dimensions;
	}
	
	public ArrayList<Type> getBiomeTypes()
	{
		return this.biomeTypes;
	}
	
	public WeightedBlockState[] getWeightedBlocks()
	{
		return this.weightedBlocks;
	}
}
