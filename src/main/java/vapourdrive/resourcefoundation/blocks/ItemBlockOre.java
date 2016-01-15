package vapourdrive.resourcefoundation.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import vapourdrive.resourcefoundation.config.ConfigOptions;

public class ItemBlockOre extends ItemBlock
{

	public ItemBlockOre(Block block)
	{
		super(block);
	}
    
	@Override
	public String getUnlocalizedName(ItemStack stack)
    {
        return this.block.getUnlocalizedName() + "." + ConfigOptions.Ores[stack.getMetadata()].toLowerCase();
    }
	
	@Override
	public int getMetadata(int damage)
	{
		return damage;
	}

}
