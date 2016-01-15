package vapourdrive.resourcefoundation.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vapourdrive.resourcefoundation.blocks.BlockProperties;
import vapourdrive.resourcefoundation.blocks.Mod_Blocks;
import vapourdrive.resourcefoundation.blocks.OreVariant;
import vapourdrive.resourcefoundation.utils.WeightedBlockState;

public class WorldGenHandler implements IWorldGenerator
{
	public static ArrayList<Generation> generators = new ArrayList<Generation>();

	public WorldGenHandler()
	{
		GameRegistry.registerWorldGenerator(this, 0);
		fillGenerators();
	}

	private void fillGenerators()
	{
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 8, 75, 96, 8, 0, new WeightedBlockState[]
		{
			new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.COPPER))
		}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 10, 40, 75, 8, 0, new WeightedBlockState[]
		{
			new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.COPPER))
		}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 8, 20, 55, 8, 0, new WeightedBlockState[]
		{
			new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.TIN))
		}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 3, 30, 60, 10, 0, new WeightedBlockState[]
				{
					new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.ALUMINUM))
				}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 6, 5, 30, 8, 0,
				new WeightedBlockState[]
				{
						new WeightedBlockState(80, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT,
								OreVariant.SILVER)),
						new WeightedBlockState(20, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT,
								OreVariant.LEAD))
				}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 8, 10, 35, 8, 0,
				new WeightedBlockState[]
				{
						new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT,
								OreVariant.SILVER)),
						new WeightedBlockState(90, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT,
								OreVariant.LEAD))
				}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 3, 5, 20, 4, 0, new WeightedBlockState[]
		{
			new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.NICKEL))
		}));
		generators.add(new Generation(EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 1, 5, 30, 3, 0, new WeightedBlockState[]
		{
				new WeightedBlockState(20, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT,
						OreVariant.PLATINUM)),
				new WeightedBlockState(80, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT,
						OreVariant.NICKEL))
		}));
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
		Iterator iterator = generators.iterator();
		while (iterator.hasNext())
		{
			Generation generation = (Generation) iterator.next();
			if (world.provider.getDimensionId() == generation.getDimension()
					&& generation.getType() == EnumGenerationType.WEIGHTEDSTANDARDCLUSTER)
			{
				WeightedWorldGenMinable generator = new WeightedWorldGenMinable(generation.getWeightedBlocks(), generation.getSize());
				generateStandardOre(random, chunkX, chunkZ, world, generation.getFrequency(), generator, generation.getMinY(),
						generation.getMaxY());
			}
		}

	}

}
