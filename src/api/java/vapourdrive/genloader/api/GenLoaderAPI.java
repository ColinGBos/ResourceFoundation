package vapourdrive.genloader.api;

import java.util.ArrayList;

import net.minecraftforge.common.BiomeDictionary.Type;
import vapourdrive.genloader.api.Generation;

public class GenLoaderAPI
{
	// GeneratorList
	public static ArrayList<Generation> generators = new ArrayList<Generation>();

	/**
	 * @param category will be the name of the json file that gets dumped, use your modID or 
	 * @param genType the type of generation
	 * @param frequency the number of times per chunk the generator will get run
	 * @param minY the minimum y value that the generator can potentially be run at
	 * @param maxY the maximum y value that the generator can potentially be run at
	 * @param size the approximate max size of the generator (number on blocks in a cluster)
	 * @param dimensionNames an arraylist of valid dimension names ("Overworld") - required
	 * @param biomeTypes an arraylist of valid biome types, all biomes will be accepted if left null
	 * @param weightedBlockStates an array of weighted blocks, determines the blocks weight for it's occurrence in the generation
	 *
	 * eg (10 blocka, 20 blockb, 60 blockc) will result in blockb being twice as frequent as a, and c being twice as frequent as the other two
	 * *note - (1 blocka, 2 blockb 6 blockc) is the same as above, the weights are ratios of their sum ***
	 */
	public static void addGeneration(String category, EnumGenerationType genType, int frequency, int minY, int maxY, int size,
			ArrayList<String> dimensionNames, ArrayList<Type> biomeTypes, WeightedBlockState[] weightedBlockStates)
	{
		generators.add(new Generation(category, genType, frequency, minY, maxY, size, dimensionNames, biomeTypes, weightedBlockStates));
	}

}
