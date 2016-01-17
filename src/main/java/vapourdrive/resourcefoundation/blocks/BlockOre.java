package vapourdrive.resourcefoundation.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import vapourdrive.resourcefoundation.config.ConfigOptions;
import vapourdrive.resourcefoundation.proxies.CommonProxy;

public class BlockOre extends Block
{
	public BlockOre()
	{
		super(Material.rock);
		this.setCreativeTab(CommonProxy.Tab);
		this.setUnlocalizedName("blockOre");
		setDefaultState(blockState.getBaseState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.COPPER));
	}
	
	@Override
	public BlockState createBlockState()
	{
		return new BlockState(this, BlockProperties.ORE_VARIANT);
	}
	
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
    	if (meta >= OreVariant.values().length) {
			meta = 0;
		}
		return getDefaultState().withProperty(BlockProperties.ORE_VARIANT, OreVariant.values()[meta]);
    }
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(BlockProperties.ORE_VARIANT).ordinal();
    }

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List<ItemStack> list)
	{
		for (int i = 0; i < ConfigOptions.defaultEnabledOres.length; ++i)
		{
			if (ConfigOptions.enabledOres[i] == true)
			{
				list.add(new ItemStack(block, 1, i));
			}
		}
	}
	
	@Override
    public int damageDropped(IBlockState state)
    {
        return this.getMetaFromState(state);
    }
}
