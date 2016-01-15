package vapourdrive.resourcefoundation.proxies;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import vapourdrive.resourcefoundation.blocks.Mod_Blocks;
import vapourdrive.resourcefoundation.items.Mod_Items;

public class ClientProxy extends CommonProxy
{
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		Mod_Blocks.clientPreInit();
		Mod_Items.clientPreInit();
	}
}