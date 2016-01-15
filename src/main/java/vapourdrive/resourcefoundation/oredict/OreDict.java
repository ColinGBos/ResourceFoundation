package vapourdrive.resourcefoundation.oredict;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import vapourdrive.resourcefoundation.blocks.Mod_Blocks;
import vapourdrive.resourcefoundation.config.ConfigOptions;
import vapourdrive.resourcefoundation.items.Mod_Items;

public class OreDict
{

	public static void preInit()
	{
		addItemEntries(Mod_Items.ItemIngot, "ingot", ConfigOptions.ExistingType);
		addItemEntries(Mod_Items.ItemNugget, "nugget", ConfigOptions.ExistingType);
		addItemEntries(Mod_Items.ItemDust, "dust", ConfigOptions.NewType);
		addItemEntries(Mod_Items.ItemGear, "gear", ConfigOptions.NewType);
		addItemEntries(Mod_Items.ItemPlate, "plate", ConfigOptions.NewType);
		addItemEntries(Item.getItemFromBlock(Mod_Blocks.BlockOre), "ore", ConfigOptions.Ores);
		addItemEntries(Item.getItemFromBlock(Mod_Blocks.BlockStorage), "block", ConfigOptions.ExistingType);
	}

	private static void addItemEntries(Item item, String type, String[] strings)
	{
		for(int i = 0; i < strings.length; i++)
		{
			OreDictionary.registerOre(type+strings[i], new ItemStack(item, 1, i));
		}
	}

}
