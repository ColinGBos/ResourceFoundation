package vapourdrive.resourcefoundation.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import vapourdrive.resourcefoundation.config.ConfigOptions;
import vapourdrive.resourcefoundation.proxies.CommonProxy;

public class BlockStorage extends Block
{
	public BlockStorage()
	{
		super(Material.iron);
		setHardness(3F);
		setResistance(10F);
		setStepSound(soundTypeMetal);
		this.setCreativeTab(CommonProxy.Tab);
		this.setUnlocalizedName("blockStorage");
		setDefaultState(blockState.getBaseState().withProperty(BlockProperties.STORAGE_VARIANT, StorageVariant.COPPER));
	}

	@Override
	public BlockState createBlockState()
	{
		return new BlockState(this, BlockProperties.STORAGE_VARIANT);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		if (meta >= StorageVariant.values().length)
		{
			meta = 0;
		}
		return this.getDefaultState().withProperty(BlockProperties.STORAGE_VARIANT, StorageVariant.values()[meta]);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(BlockProperties.STORAGE_VARIANT).ordinal();
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

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beaconPos)
	{
		return true;
	}

}
