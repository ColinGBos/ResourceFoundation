package vapourdrive.resourcefoundation.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Mod_Blocks
{
	public static Block BlockStorage;
	public static Block BlockOre;
	
	public static void preInit()
	{
		BlockStorage = new BlockStorage();
		BlockOre = new BlockOre();
		GameRegistry.registerBlock(BlockOre, ItemBlockOre.class, "blockOre");
		GameRegistry.registerBlock(BlockStorage, ItemBlockStorage.class, "blockStorage");
	}

}
