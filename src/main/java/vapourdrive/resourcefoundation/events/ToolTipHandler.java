package vapourdrive.resourcefoundation.events;

import vapourdrive.resourcefoundation.config.ConfigOptions;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

public class ToolTipHandler
{
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void itemToolTipAddition(ItemTooltipEvent event)
	{
		ItemStack itemstack = event.itemStack;

		if (ConfigOptions.AddOreDictEntries && itemstack != null)
		{
			if (itemstack.getItem() != null)
			{
				int[] names = OreDictionary.getOreIDs(itemstack);
				for(int i = 0; i < names.length; i++)
				{
					event.toolTip.add(OreDictionary.getOreName(names[i]));
				}
			}
		}
	}
}
