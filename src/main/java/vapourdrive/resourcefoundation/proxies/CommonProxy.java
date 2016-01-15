package vapourdrive.resourcefoundation.proxies;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.Level;

import vapourdrive.resourcefoundation.ResourceFoundation;
import vapourdrive.resourcefoundation.blocks.Mod_Blocks;
import vapourdrive.resourcefoundation.config.ConfigHandler;
import vapourdrive.resourcefoundation.creativetab.ResourceFoundationTab;
import vapourdrive.resourcefoundation.items.Mod_Items;

public class CommonProxy
{
	public static File ConfigPath;
	public static CreativeTabs Tab;

	public void preInit(FMLPreInitializationEvent event)
	{
		ResourceFoundation.log.log(Level.INFO, "Starting PreInit");
		ConfigPath = event.getModConfigurationDirectory();
		Tab = new ResourceFoundationTab(CreativeTabs.getNextID(), "RF_CreativeTab");
		
		ConfigHandler.preInit(ConfigPath);
		Mod_Items.preInit();
		Mod_Blocks.preInit();
		
	}

	public void Init(FMLInitializationEvent event)
	{
		ResourceFoundation.log.log(Level.INFO, "Starting Init");
		
	}

}
