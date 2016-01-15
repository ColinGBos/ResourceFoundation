package vapourdrive.resourcefoundation.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ResourceFoundationConfig
{
	public static Configuration config;
	public static String CatIngots = "Ingots";
	public static String CatNuggets = "Nuggets";
	public static String CatOres = "Ores";
	public static String CatStorageBlocks = "Storage Blocks";
	public static String CatDusts = "Dusts";
	public static String CatGears = "Gears";
	public static String CatPlates = "Plates";
	
	public static void preInit(File file)
	{
		config = new Configuration(file);
		config.load();
		
		ConfigOptions.enabledOres = config.get(CatOres, "Enabled Ores", ConfigOptions.defaultEnabledOres, "Enabled Ores: " + ConfigOptions.OreString, true, ConfigOptions.Ores.length).getBooleanList();
		ConfigOptions.enabledStorageBlocks = config.get(CatStorageBlocks, "Enabled StorageBlocks", ConfigOptions.defaultEnabledStorageBlocks, "Enabled StorageBlocks: " + ConfigOptions.ExitingTypeString, true, ConfigOptions.ExistingType.length).getBooleanList();
		ConfigOptions.enabledIngots = config.get(CatIngots, "Enabled Ingots", ConfigOptions.defaultEnabledIngots, "Enabled Ingots: " + ConfigOptions.ExitingTypeString, true, ConfigOptions.ExistingType.length).getBooleanList();
		ConfigOptions.enabledNuggets = config.get(CatNuggets, "Enabled Nuggets", ConfigOptions.defaultEnabledNuggets, "Enabled Nuggets: " + ConfigOptions.ExitingTypeString, true, ConfigOptions.ExistingType.length).getBooleanList();
		ConfigOptions.enabledDusts = config.get(CatDusts, "Enabled Dusts", ConfigOptions.defaultEnabledDusts, "Enabled Dusts: " + ConfigOptions.NewTypeString, true, ConfigOptions.NewType.length).getBooleanList();
		ConfigOptions.enabledGears = config.get(CatGears, "Enabled Gears", ConfigOptions.defaultEnabledGears, "Enabled Gears: " + ConfigOptions.NewTypeString, true, ConfigOptions.NewType.length).getBooleanList();
		ConfigOptions.enabledPlates = config.get(CatPlates, "Enabled Plates", ConfigOptions.defaultEnabledPlates, "Enabled Plates: " + ConfigOptions.NewTypeString, true, ConfigOptions.NewType.length).getBooleanList();
		
		config.save();
	}

}
