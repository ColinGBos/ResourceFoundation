package vapourdrive.resourcefoundation.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vapourdrive.resourcefoundation.items.Mod_Items;

public class ResourceFoundationTab extends CreativeTabs
{

	public ResourceFoundationTab(int index, String label)
	{
		super(index, label);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack()
	{
		return new ItemStack(Mod_Items.ItemPlate, 1, 3);
	}

	@Override
	public Item getTabIconItem()
	{
		return Mod_Items.ItemPlate;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getTabLabel()
	{
		return "ResourceFoundation";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return StatCollector.translateToLocal("resourcefoundation.creativetab.label");
	}

}
