package vapourdrive.resourcefoundation.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.logging.log4j.Level;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.common.registry.GameData;
import vapourdrive.resourcefoundation.ResourceFoundation;

public class BlockDump
{
	public static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().disableHtmlEscaping().create();
	public static HashMap<String, ArrayList<BlockInfo>> ModLists = new HashMap<String, ArrayList<BlockInfo>>();

	public static void init(File configPath)
	{
		for (Block block : GameData.getBlockRegistry().typeSafeIterable())
		{
			String mod = GameData.getBlockRegistry().getNameForObject(block).getResourceDomain().toString();
			String name = GameData.getBlockRegistry().getNameForObject(block).getResourcePath().toString();
			ImmutableList<IBlockState> states = block.getBlockState().getValidStates();
			ArrayList<String> statesStrings = new ArrayList<String>();
			Iterator<IBlockState> iterator = states.iterator();
			while (iterator.hasNext())
			{
				IBlockState tempState = iterator.next();
				statesStrings.add(tempState.toString());
			}
			if (ModLists.containsKey(mod))
			{
				ModLists.get(mod).add(new BlockInfo(mod, name, statesStrings));
			}
			else
			{
				ArrayList<BlockInfo> init = new ArrayList<BlockInfo>();
				init.add(new BlockInfo(mod, name, statesStrings));
				ModLists.put(mod, init);
			}
		}

		Iterator<Entry<String, ArrayList<BlockInfo>>> iterator = ModLists.entrySet().iterator();
		while (iterator.hasNext())
		{
			Entry<String, ArrayList<BlockInfo>> entry = iterator.next();
			try
			{
				File blockDump = new File(configPath, "/resourcefoundation/Dumps/Blocks/" + entry.getKey() + ".json");
				blockDump.getParentFile().mkdirs();
				blockDump.createNewFile();
				ResourceFoundation.log.log(Level.INFO, "Created File");
				String stream = gson.toJson(entry.getValue());

				FileWriter writer = new FileWriter(blockDump, false);

				writer.write(stream);
				writer.close();
			}
			catch (IOException error)
			{
			}
		}
	}

	public static class BlockInfo
	{
		private final String Mod;
		private final String Name;
		private final ArrayList<String> States;

		public BlockInfo(String mod, String name, ArrayList<String> states)
		{
			this.Mod = mod;
			this.Name = name;
			this.States = states;
		}

		public String getIdentifyier()
		{
			return this.Mod + ":" + this.Name;
		}

		public ArrayList<String> getStates()
		{
			return this.States;
		}
	}
}
