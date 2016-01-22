package vapourdrive.resourcefoundation.world;

import java.util.ArrayList;

import net.minecraftforge.common.BiomeDictionary.Type;
import vapourdrive.genloader.api.EnumGenerationType;
import vapourdrive.genloader.api.GenLoaderAPI;
import vapourdrive.genloader.api.WeightedBlockState;
import vapourdrive.resourcefoundation.ModInfo;
import vapourdrive.resourcefoundation.blocks.BlockProperties;
import vapourdrive.resourcefoundation.blocks.Mod_Blocks;
import vapourdrive.resourcefoundation.blocks.OreVariant;

public class GenLoaderCompat
{

	public static void init()
	{
		addGenerator(ModInfo.ModID, EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 10, 40, 75, 8, new String[]{"Overworld"}, null, new WeightedBlockState[]{new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.COPPER))});
		addGenerator(ModInfo.ModID, EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 8, 20, 55, 8, new String[]{"Overworld"}, null, new WeightedBlockState[]{new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.TIN))});
		addGenerator(ModInfo.ModID, EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 3, 30, 60, 10, new String[]{"Overworld"}, null, new WeightedBlockState[]{new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.ALUMINUM))});
		addGenerator(ModInfo.ModID, EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 6, 5, 30, 8, new String[]{"Overworld"}, null, new WeightedBlockState[]{new WeightedBlockState(75, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.SILVER)), new WeightedBlockState(25, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.LEAD))});
		addGenerator(ModInfo.ModID, EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 8, 10, 35, 8, new String[]{"Overworld"}, null, new WeightedBlockState[]{new WeightedBlockState(15, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.SILVER)), new WeightedBlockState(85, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.LEAD))});
		addGenerator(ModInfo.ModID, EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 3, 5, 20, 4, new String[]{"Overworld"}, null, new WeightedBlockState[]{new WeightedBlockState(10, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.NICKEL))});
		addGenerator(ModInfo.ModID, EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, 1, 5, 30, 4, new String[]{"Overworld"}, null, new WeightedBlockState[]{new WeightedBlockState(20, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.PLATINUM)), new WeightedBlockState(80, Mod_Blocks.BlockOre.getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.NICKEL))});
	}

	private static void addGenerator(String category, EnumGenerationType generation, int frequency, int minY, int maxY, int size,
			String[] dimensionNames, Type[] biomeTypes, WeightedBlockState[] weightedBlockStates)
	{
		ArrayList<String> dimensions = new ArrayList<String>();
		for (String dimension : dimensionNames)
		{
			dimensions.add(dimension);
		}
		ArrayList<Type> biomes = new ArrayList<Type>();
		if (biomeTypes != null)
		{
			for (Type type : biomeTypes)
			{
				biomes.add(type);
			}
		}
		GenLoaderAPI.addGeneration(ModInfo.ModID,EnumGenerationType.WEIGHTEDSTANDARDCLUSTER, frequency, minY, maxY, size, dimensions, biomes, weightedBlockStates);

	}
}
