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
import vapourdrive.resourcefoundation.items.EnumExist;
import vapourdrive.resourcefoundation.items.EnumNew;
import vapourdrive.resourcefoundation.items.EnumOre;
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
		AddDustAlloyRecipe();
	}

	private static void AddDustAlloyRecipe()
	{
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Mod_Items.ItemDust, 2, EnumNew.ELECTRUM.ordinal()), "dustSilver", "dustGold"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Mod_Items.ItemDust, 4, EnumNew.BRONZE.ordinal()), "dustTin", "dustCopper", "dustCopper", "dustCopper"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Mod_Items.ItemDust, 3, EnumNew.INVAR.ordinal()), "dustIron", "dustNickel", "dustNickel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Mod_Items.ItemDust, 4, EnumNew.BRASS.ordinal()), "dustCopper", "dustCopper", "dustCopper", "dustZinc"));

	}

	private static void AddOreSmeltingRecipe(Block blockOre, Item itemIngot)
	{
		tryRegisterSmelting(new ItemStack(blockOre, 1, EnumOre.ALUMINUM.ordinal()), new ItemStack(itemIngot, 1, EnumExist.ALUMINUM.ordinal()), 0.3f, ConfigOptions.enabledOres, EnumOre.ALUMINUM.ordinal(), ConfigOptions.enabledIngots, EnumExist.ALUMINUM.ordinal());
		tryRegisterSmelting(new ItemStack(blockOre, 1, EnumOre.COPPER.ordinal()), new ItemStack(itemIngot, 1, EnumExist.COPPER.ordinal()), 0.3f, ConfigOptions.enabledOres, EnumOre.COPPER.ordinal(), ConfigOptions.enabledIngots, EnumExist.COPPER.ordinal());
		tryRegisterSmelting(new ItemStack(blockOre, 1, EnumOre.TIN.ordinal()), new ItemStack(itemIngot, 1, EnumExist.TIN.ordinal()), 0.3f, ConfigOptions.enabledOres, EnumOre.TIN.ordinal(), ConfigOptions.enabledIngots, EnumExist.TIN.ordinal());
		tryRegisterSmelting(new ItemStack(blockOre, 1, EnumOre.SILVER.ordinal()), new ItemStack(itemIngot, 1, EnumExist.SILVER.ordinal()), 0.3f, ConfigOptions.enabledOres, EnumOre.SILVER.ordinal(), ConfigOptions.enabledIngots, EnumExist.SILVER.ordinal());
		tryRegisterSmelting(new ItemStack(blockOre, 1, EnumOre.LEAD.ordinal()), new ItemStack(itemIngot, 1, EnumExist.LEAD.ordinal()), 0.3f, ConfigOptions.enabledOres, EnumOre.LEAD.ordinal(), ConfigOptions.enabledIngots, EnumExist.LEAD.ordinal());
		tryRegisterSmelting(new ItemStack(blockOre, 1, EnumOre.NICKEL.ordinal()), new ItemStack(itemIngot, 1, EnumExist.NICKEL.ordinal()), 0.3f, ConfigOptions.enabledOres, EnumOre.NICKEL.ordinal(), ConfigOptions.enabledIngots, EnumExist.NICKEL.ordinal());
		tryRegisterSmelting(new ItemStack(blockOre, 1, EnumOre.PLATINUM.ordinal()), new ItemStack(itemIngot, 1, EnumExist.PLATINUM.ordinal()), 0.3f, ConfigOptions.enabledOres, EnumOre.PLATINUM.ordinal(), ConfigOptions.enabledIngots, EnumExist.PLATINUM.ordinal());
		tryRegisterSmelting(new ItemStack(blockOre, 1, EnumOre.ZINC.ordinal()), new ItemStack(itemIngot, 1, EnumExist.ZINC.ordinal()), 0.3f, ConfigOptions.enabledOres, EnumOre.ZINC.ordinal(), ConfigOptions.enabledIngots, EnumExist.ZINC.ordinal());

	}

	private static void AddDustSmeltRecipe(Item itemDust, Item itemIngot)
	{
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.COPPER.ordinal()), new ItemStack(itemIngot, 1, EnumExist.COPPER.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.COPPER.ordinal(), ConfigOptions.enabledIngots, EnumExist.COPPER.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.TIN.ordinal()), new ItemStack(itemIngot, 1, EnumExist.TIN.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.TIN.ordinal(), ConfigOptions.enabledIngots, EnumExist.TIN.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.ALUMINUM.ordinal()), new ItemStack(itemIngot, 1, EnumExist.ALUMINUM.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.ALUMINUM.ordinal(), ConfigOptions.enabledIngots, EnumExist.ALUMINUM.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.IRON.ordinal()), new ItemStack(Items.iron_ingot), 0.3f, ConfigOptions.enabledDusts, EnumNew.IRON.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.BRONZE.ordinal()), new ItemStack(itemIngot, 1, EnumExist.BRONZE.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.BRONZE.ordinal(), ConfigOptions.enabledIngots, EnumExist.BRONZE.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.LEAD.ordinal()), new ItemStack(itemIngot, 1, EnumExist.LEAD.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.LEAD.ordinal(), ConfigOptions.enabledIngots, EnumExist.LEAD.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.SILVER.ordinal()), new ItemStack(itemIngot, 1, EnumExist.SILVER.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.SILVER.ordinal(), ConfigOptions.enabledIngots, EnumExist.SILVER.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.GOLD.ordinal()), new ItemStack(Items.gold_ingot), 0.3f, ConfigOptions.enabledDusts, EnumNew.GOLD.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.ELECTRUM.ordinal()), new ItemStack(itemIngot, 1, EnumExist.ELECTRUM.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.ELECTRUM.ordinal(), ConfigOptions.enabledIngots, EnumExist.ELECTRUM.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.NICKEL.ordinal()), new ItemStack(itemIngot, 1, EnumExist.NICKEL.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.NICKEL.ordinal(), ConfigOptions.enabledIngots, EnumExist.NICKEL.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.INVAR.ordinal()), new ItemStack(itemIngot, 1, EnumExist.INVAR.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.INVAR.ordinal(), ConfigOptions.enabledIngots, EnumExist.INVAR.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.PLATINUM.ordinal()), new ItemStack(itemIngot, 1, EnumExist.PLATINUM.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.PLATINUM.ordinal(), ConfigOptions.enabledIngots, EnumExist.PLATINUM.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.STEEL.ordinal()), new ItemStack(itemIngot, 1, EnumExist.STEEL.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.STEEL.ordinal(), ConfigOptions.enabledIngots, EnumExist.STEEL.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.ZINC.ordinal()), new ItemStack(itemIngot, 1, EnumExist.ZINC.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.ZINC.ordinal(), ConfigOptions.enabledIngots, EnumExist.ZINC.ordinal());
		tryRegisterSmelting(new ItemStack(itemDust, 1, EnumNew.BRASS.ordinal()), new ItemStack(itemIngot, 1, EnumExist.BRASS.ordinal()), 0.3f, ConfigOptions.enabledDusts, EnumNew.BRASS.ordinal(), ConfigOptions.enabledIngots, EnumExist.BRASS.ordinal());

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
