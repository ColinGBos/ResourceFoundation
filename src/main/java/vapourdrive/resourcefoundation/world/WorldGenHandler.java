package vapourdrive.resourcefoundation.world;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import org.apache.logging.log4j.Level;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vapourdrive.resourcefoundation.ResourceFoundation;
import vapourdrive.resourcefoundation.blocks.BlockProperties;
import vapourdrive.resourcefoundation.blocks.OreVariant;
import vapourdrive.resourcefoundation.utils.WeightedBlockState;

public class WorldGenHandler implements IWorldGenerator
{
	public static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().disableHtmlEscaping().create();
	public static ArrayList<Generation> generators = new ArrayList<Generation>();

	public WorldGenHandler(File ConfigPath)
	{
		GameRegistry.registerWorldGenerator(this, 0);
		fillGenerators();
		dumpGenerators(ConfigPath);
	}

	private void dumpGenerators(File configPath)
	{
		try
		{
			File file = new File(configPath, "/resourcefoundation/World/ResourceFoundation.json");
			file.getParentFile().mkdirs();
			if (file.createNewFile())
			{
				ResourceFoundation.log.log(Level.INFO, "Created File");
				String stream = gson.toJson(generators);

				FileWriter writer = new FileWriter(file, true);

				writer.write(stream);
				writer.close();
			}
		}
		catch (IOException error)
		{
		}
	}

	private void fillGenerators()
	{
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 10, 40, 75, 8, new String[]
		{
			"Overworld"
		}, new WeightedBlockState[]
		{
			new WeightedBlockState(10, "resourcefoundation:blockOre", getSingleMap(BlockProperties.ORE_VARIANT.getName(),
					OreVariant.COPPER.toString()))
		}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 8, 20, 55, 8, new String[]
		{
			"Overworld"
		}, new WeightedBlockState[]
		{
			new WeightedBlockState(10, "resourcefoundation:blockOre", getSingleMap(BlockProperties.ORE_VARIANT.getName(),
					OreVariant.TIN.toString()))
		}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 3, 30, 60, 10, new String[]
		{
			"Overworld"
		}, new WeightedBlockState[]
		{
			new WeightedBlockState(10, "resourcefoundation:blockOre", getSingleMap(BlockProperties.ORE_VARIANT.getName(),
					OreVariant.ALUMINUM.toString()))
		}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 6, 5, 30, 8, new String[]
		{
			"Overworld"
		}, new WeightedBlockState[]
		{
				new WeightedBlockState(80, "resourcefoundation:blockOre", getSingleMap(BlockProperties.ORE_VARIANT.getName(),
						OreVariant.SILVER.toString())),
				new WeightedBlockState(20, "resourcefoundation:blockOre", getSingleMap(BlockProperties.ORE_VARIANT.getName(),
						OreVariant.LEAD.toString()))
		}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 8, 10, 35, 8, new String[]
		{
			"Overworld"
		}, new WeightedBlockState[]
		{
				new WeightedBlockState(10, "resourcefoundation:blockOre", getSingleMap(BlockProperties.ORE_VARIANT.getName(),
						OreVariant.SILVER.toString())),
				new WeightedBlockState(90, "resourcefoundation:blockOre", getSingleMap(BlockProperties.ORE_VARIANT.getName(),
						OreVariant.LEAD.toString()))
		}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 3, 5, 20, 4, new String[]
		{
			"Overworld"
		}, new WeightedBlockState[]
		{
			new WeightedBlockState(10, "resourcefoundation:blockOre", getSingleMap(BlockProperties.ORE_VARIANT.getName(),
					OreVariant.NICKEL.toString()))
		}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 1, 5, 30, 3, new String[]
		{
			"Overworld"
		}, new WeightedBlockState[]
		{
				new WeightedBlockState(20, "resourcefoundation:blockOre", getSingleMap(BlockProperties.ORE_VARIANT.getName(),
						OreVariant.PLATINUM.toString())),
				new WeightedBlockState(80, "resourcefoundation:blockOre", getSingleMap(BlockProperties.ORE_VARIANT.getName(),
						OreVariant.NICKEL.toString()))
		}));
	}

	private HashMap<String, String> getSingleMap(String prop, String variant)
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(prop, variant);
		return map;
	}

	private void generateStandardOre(Random rand, int chunkX, int chunkZ, World world, int iterations, WorldGenerator gen, int minY,
			int maxY)
	{
		for (int i = 0; i < iterations; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = rand.nextInt(maxY - minY) + minY;
			int z = chunkZ * 16 + rand.nextInt(16);

			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		Iterator<Generation> iterator = generators.iterator();
		while (iterator.hasNext())
		{
			Generation generation = iterator.next();
			for (int i = 0; i < generation.getDimensions().length; i++)
			{
				if (world.provider.getDimensionName() == generation.getDimensions()[i]
						&& generation.getType() == EnumGenerationType.WEIGHTEDSTANDARDCLUSTER)
				{
					WeightedWorldGenMinable generator = new WeightedWorldGenMinable(generation.getWeightedBlocks(), generation.getSize());
					generateStandardOre(random, chunkX, chunkZ, world, generation.getFrequency(), generator, generation.getMinY(),
							generation.getMaxY());
				}
			}
		}

	}

}
