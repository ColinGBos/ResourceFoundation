package vapourdrive.genloader.api;

import java.lang.reflect.Type;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class WeightedBlockState implements JsonDeserializer, JsonSerializer
{
	private final int weight;
	private final IBlockState state;
	Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setPrettyPrinting().create();

	public WeightedBlockState(int Weight, String Block, HashMap<String, String> Properties)
	{
		this.weight = Weight;
		this.state = createState(Block, Properties);
	}
	
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
		return state;
	}

	public IBlockState createState(String block, HashMap<String, String> properties)
	{
		Block foundBlock = GameData.getBlockRegistry().getObject(new ResourceLocation(block));
		ImmutableList<IBlockState> states = foundBlock.getBlockState().getValidStates();
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
		
		return foundBlock.getDefaultState();
	}

	@Override
	public WeightedBlockState deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
	{
		HashMap<String, String> statePropsMap = new HashMap<String, String>();
		
		ImmutableMap<IProperty, Comparable> stateProps = state.getProperties();
		Iterator<Entry<IProperty, Comparable>> propIterater = stateProps.entrySet().iterator();
		while(propIterater.hasNext())
		{
			Entry<IProperty, Comparable> entry = propIterater.next();
			statePropsMap.put(entry.getKey().getName(), state.getValue(entry.getKey()).toString());
		}
		return new WeightedBlockState(weight, GameData.getBlockRegistry().getNameForObject(state.getBlock()).toString(), statePropsMap);
	}

	@Override
	public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context)
	{
		JsonObject output = new JsonObject();
		output.add("Weight", new JsonPrimitive(weight));
		output.add("Block", new JsonPrimitive(GameData.getBlockRegistry().getNameForObject(state.getBlock()).toString()));
		
		HashMap<String, String> statePropsMap = new HashMap<String, String>();
		
		ImmutableMap<IProperty, Comparable> stateProps = state.getProperties();
		Iterator<Entry<IProperty, Comparable>> propIterater = stateProps.entrySet().iterator();
		while(propIterater.hasNext())
		{
			Entry<IProperty, Comparable> entry = propIterater.next();
			statePropsMap.put(entry.getKey().getName(), state.getValue(entry.getKey()).toString());
		}
		
		output.add("Properties", gson.toJsonTree(statePropsMap));
		
		return output;
	}

}
