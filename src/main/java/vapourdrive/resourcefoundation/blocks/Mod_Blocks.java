package vapourdrive.resourcefoundation.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Mod_Blocks
{
	public static Block BlockStorage;
	public static Block BlockOre;

	public static void preInit()
	{
		BlockStorage = new BlockStorage();
		BlockOre = new BlockOre();
		GameRegistry.registerBlock(BlockOre, ItemBlockOre.class, "blockOre");
		GameRegistry.registerBlock(BlockStorage, ItemBlockStorage.class, "blockStorage");
	}

	public static void clientPreInit()
	{
		registerModel("blockOre", BlockOre, OreVariant.class);
		registerModel("blockStorage", BlockStorage, StorageVariant.class);
	}

	private static <T extends Enum<T> & IStringSerializable> void registerModel(String name, Block block, Class<T> class1)
	{
		Item item = Item.getItemFromBlock(block);
		for (T e : class1.getEnumConstants())
		{
			String baseName = GameData.getBlockRegistry().getNameForObject(block).toString();
			String variantName = "variant=" + e.getName();
			ModelLoader.registerItemVariants(item, new ModelResourceLocation(baseName, variantName));
			ModelLoader.setCustomModelResourceLocation(item, e.ordinal(), new ModelResourceLocation(baseName, variantName));
		}
	}
}
