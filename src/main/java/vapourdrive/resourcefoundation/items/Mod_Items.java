package vapourdrive.resourcefoundation.items;

import vapourdrive.resourcefoundation.ModInfo;
import vapourdrive.resourcefoundation.config.ConfigOptions;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Mod_Items
{
	public static Item ItemIngot;
	public static Item ItemNugget;
	public static Item ItemDust;
	public static Item ItemPlate;
	public static Item ItemGear;
	
	public static void preInit()
	{
		ItemIngot = new ItemIngot();
		ItemNugget = new ItemNugget();
		ItemDust = new ItemDust();
		ItemPlate = new ItemPlate();
		ItemGear = new ItemGear();
		
		GameRegistry.registerItem(ItemIngot, "itemIngot");
		GameRegistry.registerItem(ItemNugget, "itemNugget");
		GameRegistry.registerItem(ItemDust, "itemDust");
		GameRegistry.registerItem(ItemPlate, "itemPlate");
		GameRegistry.registerItem(ItemGear, "itemGear");
	}

	public static void clientPreInit()
	{
		registerModel("ingot", ItemIngot, ConfigOptions.ExistingType);
		registerModel("nugget", ItemNugget, ConfigOptions.ExistingType);
		registerModel("dust", ItemDust, ConfigOptions.NewType);
		registerModel("plate", ItemPlate, ConfigOptions.NewType);
		registerModel("gear", ItemGear, ConfigOptions.NewType);
	}
	
	public static void registerModel(String name, Item item, String[] variations)
	{
		ResourceLocation[] resourceVariants = new ResourceLocation[variations.length];
		for (int i = 0; i < variations.length; i++)
		{
			ResourceLocation location = new ModelResourceLocation(ModInfo.ResourcePath + name + variations[i]);
			resourceVariants[i] = location;
		}
		ModelBakery.registerItemVariants(item, resourceVariants);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition()
		{
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack)
			{
				return new ModelResourceLocation(ModInfo.ResourcePath + stack.getUnlocalizedName());
			}

		});
	}

}
