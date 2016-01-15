package vapourdrive.resourcefoundation.recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import vapourdrive.resourcefoundation.blocks.Mod_Blocks;
import vapourdrive.resourcefoundation.config.ConfigOptions;
import vapourdrive.resourcefoundation.items.Mod_Items;

public class Recipes
{

	public static void init()
	{
		AddFromStorageRecipes("ingot", Mod_Items.ItemNugget);
		AddFromStorageRecipes("block", Mod_Items.ItemIngot);
		AddToStoragerecipes("nugget", Mod_Items.ItemIngot);
		AddToStoragerecipes("ingot", Item.getItemFromBlock(Mod_Blocks.BlockStorage));
		AddToPlateRecipe("ingot", Mod_Items.ItemPlate);
		AddToGearRecipe("ingot", Mod_Items.ItemGear);
		AddDustSmeltRecipe(Mod_Items.ItemDust, Mod_Items.ItemIngot);
		AddOreSmeltingRecipe(Mod_Blocks.BlockOre, Mod_Items.ItemIngot);
	}

	private static void AddOreSmeltingRecipe(Block blockOre, Item itemIngot)
	{
		tryRegisterSmelting(new ItemStack(blockOre, 1, 0), new ItemStack(itemIngot, 1, 0), 0.3f, ConfigOptions.enabledOres, 0, ConfigOptions.enabledIngots, 0);
		tryRegisterSmelting(new ItemStack(blockOre, 1, 1), new ItemStack(itemIngot, 1, 1), 0.3f, ConfigOptions.enabledOres, 1, ConfigOptions.enabledIngots, 1);
		tryRegisterSmelting(new ItemStack(blockOre, 1, 2), new ItemStack(itemIngot, 1, 2), 0.3f, ConfigOptions.enabledOres, 2, ConfigOptions.enabledIngots, 2);
		tryRegisterSmelting(new ItemStack(blockOre, 1, 3), new ItemStack(itemIngot, 1, 4), 0.3f, ConfigOptions.enabledOres, 3, ConfigOptions.enabledIngots, 4);
		tryRegisterSmelting(new ItemStack(blockOre, 1, 4), new ItemStack(itemIngot, 1, 5), 0.3f, ConfigOptions.enabledOres, 4, ConfigOptions.enabledIngots, 5);
		tryRegisterSmelting(new ItemStack(blockOre, 1, 5), new ItemStack(itemIngot, 1, 7), 0.3f, ConfigOptions.enabledOres, 5, ConfigOptions.enabledIngots, 7);
		tryRegisterSmelting(new ItemStack(blockOre, 1, 6), new ItemStack(itemIngot, 1, 9), 0.3f, ConfigOptions.enabledOres, 6, ConfigOptions.enabledIngots, 9);
	}

	private static void AddDustSmeltRecipe(Item itemDust, Item itemIngot)
	{
		tryRegisterSmelting(new ItemStack(itemDust, 1, 0), new ItemStack(itemIngot, 1, 0), 0.3f, ConfigOptions.enabledDusts, 0, ConfigOptions.enabledIngots, 0);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 1), new ItemStack(itemIngot, 1, 1), 0.3f, ConfigOptions.enabledDusts, 1, ConfigOptions.enabledIngots, 1);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 2), new ItemStack(itemIngot, 1, 2), 0.3f, ConfigOptions.enabledDusts, 2, ConfigOptions.enabledIngots, 2);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 3), new ItemStack(Items.iron_ingot), 0.3f, ConfigOptions.enabledDusts, 3);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 4), new ItemStack(itemIngot, 1, 3), 0.3f, ConfigOptions.enabledDusts, 4, ConfigOptions.enabledIngots, 3);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 5), new ItemStack(itemIngot, 1, 4), 0.3f, ConfigOptions.enabledDusts, 5, ConfigOptions.enabledIngots, 4);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 6), new ItemStack(itemIngot, 1, 5), 0.3f, ConfigOptions.enabledDusts, 6, ConfigOptions.enabledIngots, 5);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 7), new ItemStack(Items.gold_ingot), 0.3f, ConfigOptions.enabledDusts, 7);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 8), new ItemStack(itemIngot, 1, 6), 0.3f, ConfigOptions.enabledDusts, 8, ConfigOptions.enabledIngots, 6);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 9), new ItemStack(itemIngot, 1, 7), 0.3f, ConfigOptions.enabledDusts, 9, ConfigOptions.enabledIngots, 7);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 10), new ItemStack(itemIngot, 1, 8), 0.3f, ConfigOptions.enabledDusts, 10, ConfigOptions.enabledIngots, 8);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 11), new ItemStack(itemIngot, 1, 9), 0.3f, ConfigOptions.enabledDusts, 11, ConfigOptions.enabledIngots, 9);
		tryRegisterSmelting(new ItemStack(itemDust, 1, 12), new ItemStack(itemIngot, 1, 10), 0.3f, ConfigOptions.enabledDusts, 12, ConfigOptions.enabledIngots, 10);
	}
	
	private static void tryRegisterSmelting(ItemStack itemStack, ItemStack itemStack2, float f, boolean[] enabledItems, int i)
	{
		if (enabledItems[i])
		{
			GameRegistry.addSmelting(itemStack, itemStack2, f);
		}
	}

	private static void tryRegisterSmelting(ItemStack itemStack, ItemStack itemStack2, float f, boolean[] enabledItems1, int j, boolean[] enabledItems, int i)
	{
		if (enabledItems[i] && enabledItems1[j])
		{
			GameRegistry.addSmelting(itemStack, itemStack2, f);
		}
	}

	private static void AddToGearRecipe(String string, Item item)
	{
		for (int i = 0; i < ConfigOptions.NewType.length; i++)
		{
			if (ConfigOptions.enabledGears[i])
			{
				IRecipe recipe = new ShapedOreRecipe(new ItemStack(item, 1, i), new Object[]
				{
						" i ", "iIi", " i ", 'i', string + ConfigOptions.NewType[i], 'I', "ingotIron"
				});

				GameRegistry.addRecipe(recipe);
			}
		}
	}

	private static void AddToPlateRecipe(String string, Item item)
	{
		for (int i = 0; i < ConfigOptions.NewType.length; i++)
		{
			if (ConfigOptions.enabledPlates[i])
			{
				IRecipe recipe = new ShapedOreRecipe(new ItemStack(item, 2, i), new Object[]
				{
						"iii", 'i', string + ConfigOptions.NewType[i]
				});
				GameRegistry.addRecipe(recipe);
			}
		}
	}

	private static void AddToStoragerecipes(String string, Item item)
	{
		for (int i = 0; i < ConfigOptions.ExistingType.length; i++)
		{
			if (ConfigOptions.enabledStorageBlocks[i] && ConfigOptions.enabledIngots[i])
			{
				IRecipe recipe = new ShapedOreRecipe(new ItemStack(item, 1, i), new Object[]
				{
						"iii", "iii", "iii", 'i', string + ConfigOptions.ExistingType[i]
				});
				GameRegistry.addRecipe(recipe);
			}
		}
	}

	private static void AddFromStorageRecipes(String string, Item item)
	{
		for (int i = 0; i < ConfigOptions.ExistingType.length; i++)
		{
			if (ConfigOptions.enabledIngots[i] && ConfigOptions.enabledStorageBlocks[i])
			{
				IRecipe recipe = new ShapelessOreRecipe(new ItemStack(item, 9, i), new Object[]
				{
					string + ConfigOptions.ExistingType[i]
				});
				GameRegistry.addRecipe(recipe);
			}
		}

	}
}
