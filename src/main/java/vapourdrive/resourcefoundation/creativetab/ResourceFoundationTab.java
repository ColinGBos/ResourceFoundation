package vapourdrive.resourcefoundation.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ResourceFoundationTab extends CreativeTabs
{

	public ResourceFoundationTab(int index, String label)
	{
		super(index, label);
	}

	@Override
	public Item getTabIconItem()
	{
		return Items.iron_ingot;
	}

}
