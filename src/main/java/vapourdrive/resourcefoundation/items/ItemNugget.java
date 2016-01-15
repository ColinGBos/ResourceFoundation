package vapourdrive.resourcefoundation.items;

import java.util.List;

import vapourdrive.resourcefoundation.config.ConfigOptions;
import vapourdrive.resourcefoundation.proxies.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNugget extends Item
{
	public ItemNugget()
	{
		this.setCreativeTab(CommonProxy.Tab);
	}
	
	@Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public boolean getHasSubtypes()
    {
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
    	for(int i = 0; i < ConfigOptions.defaultEnabledNuggets.length; i++)
    	{
    		if(ConfigOptions.enabledNuggets[i] == true)
    		{
    			subItems.add(new ItemStack(this, 1, i));
    		}
    	}
    }
    
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return "nugget" + ConfigOptions.ExistingType[stack.getMetadata()];
    }
}
