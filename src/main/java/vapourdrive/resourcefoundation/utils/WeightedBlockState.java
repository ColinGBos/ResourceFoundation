package vapourdrive.resourcefoundation.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameData;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class WeightedBlockState
{
	private final int weight;
	private final ResourceLocation resourceLocation;
	private final HashMap<String, String> properties;

	public WeightedBlockState(int Weight, String ResourceLocation, HashMap<String, String> Properties)
	{
		this.weight = Weight;
		this.properties = Properties;
		this.resourceLocation = new ResourceLocation(ResourceLocation);
	}

	public int getWeight()
	{
		return weight;
	}

	public IBlockState getState()
	{
		Block block = GameData.getBlockRegistry().getObject(resourceLocation);
		ImmutableList<IBlockState> states = block.getBlockState().getValidStates();
		Iterator<IBlockState> iterator = states.iterator();
		while (iterator.hasNext())
		{
			boolean isCorrectState = true;
			IBlockState state = iterator.next();
			ImmutableMap<IProperty, Comparable> stateProps = state.getProperties();
			Iterator<Entry<IProperty, Comparable>> propIterater = stateProps.entrySet().iterator();
			while(propIterater.hasNext())
			{
				Entry<IProperty, Comparable> entry = propIterater.next();
				IProperty property = entry.getKey();
				if(properties.containsKey(property.getName()))
				{
					if(!state.getValue(property).toString().contentEquals(properties.get(property.getName())))
					{
						isCorrectState = false;
					}
				}
			}
			if(isCorrectState)
			{
				return state;
			}
		}
		
		return block.getDefaultState();
	}

}
