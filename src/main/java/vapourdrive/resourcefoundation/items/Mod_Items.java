package vapourdrive.resourcefoundation.items;

import net.minecraft.item.Item;
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

}
