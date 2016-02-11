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
		GenLoaderAPI.addGeneration(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 9, 30, 75, 12, new WeightedBlockState[]{new WeightedBlockState(20, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.COPPER)), new WeightedBlockState(5, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.ZINC))});
		GenLoaderAPI.addGeneration(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 7, 20, 55, 8, new WeightedBlockState[]{new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.TIN))});
		GenLoaderAPI.addGeneration(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 3, 30, 60, 10, new WeightedBlockState[]{new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.ALUMINUM))});
		GenLoaderAPI.addGeneration(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 4, 5, 30, 8, new WeightedBlockState[]{new WeightedBlockState(75, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.SILVER)), new WeightedBlockState(25, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.LEAD))});
		GenLoaderAPI.addGeneration(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 5, 10, 35, 8, new WeightedBlockState[]{new WeightedBlockState(15, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.SILVER)), new WeightedBlockState(85, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.LEAD))});
		GenLoaderAPI.addGeneration(Category, EnumGenerationType.STANDARDVARIABLECLUSTER, 2, 5, 30, 6, new WeightedBlockState[]{new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.PLATINUM)), new WeightedBlockState(60, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.NICKEL))});
		
		GenLoaderAPI.addValuableBlock(Mod_Blocks.BlockOre);
	}
}
