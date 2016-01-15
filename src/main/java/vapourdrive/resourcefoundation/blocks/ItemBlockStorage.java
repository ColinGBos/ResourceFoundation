package vapourdrive.resourcefoundation.blocks;

import vapourdrive.resourcefoundation.config.ConfigOptions;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockStorage extends ItemBlock
{

	public ItemBlockStorage(Block block)
	{
		super(block);
	}
	
	public String getUnlocalizedName(ItemStack stack)
    {
        return this.block.getUnlocalizedName() + "." + ConfigOptions.ExistingType[stack.getMetadata()];
    }

}
