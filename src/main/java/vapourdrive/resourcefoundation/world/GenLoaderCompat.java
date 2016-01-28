package vapourdrive.resourcefoundation.world;

import vapourdrive.genloader.api.GenLoaderAPI;
import vapourdrive.genloader.api.generation.EnumGenerationType;
import vapourdrive.genloader.api.generation.GenerationCategory;
import vapourdrive.genloader.api.serializeable.WeightedBlockState;
import vapourdrive.resourcefoundation.ModInfo;
import vapourdrive.resourcefoundation.blocks.BlockProperties;
import vapourdrive.resourcefoundation.blocks.Mod_Blocks;
import vapourdrive.resourcefoundation.blocks.OreVariant;

public class GenLoaderCompat
{
	public static void init()
	{
		GenerationCategory Category = new GenerationCategory(ModInfo.ModID);
		addGenerator(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 10, 40, 75, 8, new WeightedBlockState[]{new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.COPPER))});
		addGenerator(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 8, 20, 55, 8, new WeightedBlockState[]{new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.TIN))});
		addGenerator(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 3, 30, 60, 10, new WeightedBlockState[]{new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.ALUMINUM))});
		addGenerator(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 6, 5, 30, 8, new WeightedBlockState[]{new WeightedBlockState(75, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.SILVER)), new WeightedBlockState(25, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.LEAD))});
		addGenerator(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 8, 10, 35, 8, new WeightedBlockState[]{new WeightedBlockState(15, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.SILVER)), new WeightedBlockState(85, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.LEAD))});
		addGenerator(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 2, 5, 30, 6, new WeightedBlockState[]{new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.PLATINUM)), new WeightedBlockState(60, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.NICKEL))});
		
		GenLoaderAPI.addValuableBlock(Mod_Blocks.BlockOre);
	}

	private static void addGenerator(GenerationCategory Category, EnumGenerationType generation, int frequency, int minY, int maxY, int size, WeightedBlockState[] weightedBlockStates)
	{
		GenLoaderAPI.addGeneration(Category, generation, frequency, minY, maxY, size, weightedBlockStates);
	}
}
