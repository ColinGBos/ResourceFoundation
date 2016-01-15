package vapourdrive.resourcefoundation.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import vapourdrive.resourcefoundation.config.ConfigOptions;
import vapourdrive.resourcefoundation.proxies.CommonProxy;

public class BlockStorage extends Block
{
	public static final PropertyInteger VARIANT = PropertyInteger.create("variant", 0, 15);

	public BlockStorage()
	{
		super(Material.iron);
		setHardness(3F);
		setResistance(10F);
		setStepSound(soundTypeMetal);
		this.setCreativeTab(CommonProxy.Tab);
		this.setUnlocalizedName("blockStorage");
		setDefaultState(blockState.getBaseState().withProperty(VARIANT, 0));
	}

	@Override
	public BlockState createBlockState()
	{
		return new BlockState(this, VARIANT);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(VARIANT);
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < ConfigOptions.defaultEnabledStorageBlocks.length; ++i)
		{
			if (ConfigOptions.enabledStorageBlocks[i] == true)
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
