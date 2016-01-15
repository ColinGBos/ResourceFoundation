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
	public static String Random = "Random";
	
	public static void preInit(File file)
	{
		config = new Configuration(file);
		config.load();
		
		ConfigOptions.enabledOres = config.get("Resources."+CatOres, "Enabled Ores", ConfigOptions.defaultEnabledOres, "Enabled Ores: " + ConfigOptions.OreString, true, ConfigOptions.Ores.length).getBooleanList();
		ConfigOptions.enabledStorageBlocks = config.get("Resources."+CatStorageBlocks, "Enabled StorageBlocks", ConfigOptions.defaultEnabledStorageBlocks, "Enabled StorageBlocks: " + ConfigOptions.ExitingTypeString, true, ConfigOptions.ExistingType.length).getBooleanList();
		ConfigOptions.enabledIngots = config.get("Resources."+CatIngots, "Enabled Ingots", ConfigOptions.defaultEnabledIngots, "Enabled Ingots: " + ConfigOptions.ExitingTypeString, true, ConfigOptions.ExistingType.length).getBooleanList();
		ConfigOptions.enabledNuggets = config.get("Resources."+CatNuggets, "Enabled Nuggets", ConfigOptions.defaultEnabledNuggets, "Enabled Nuggets: " + ConfigOptions.ExitingTypeString, true, ConfigOptions.ExistingType.length).getBooleanList();
		ConfigOptions.enabledDusts = config.get("Resources."+CatDusts, "Enabled Dusts", ConfigOptions.defaultEnabledDusts, "Enabled Dusts: " + ConfigOptions.NewTypeString, true, ConfigOptions.NewType.length).getBooleanList();
		ConfigOptions.enabledGears = config.get("Resources."+CatGears, "Enabled Gears", ConfigOptions.defaultEnabledGears, "Enabled Gears: " + ConfigOptions.NewTypeString, true, ConfigOptions.NewType.length).getBooleanList();
		ConfigOptions.enabledPlates = config.get("Resources."+CatPlates, "Enabled Plates", ConfigOptions.defaultEnabledPlates, "Enabled Plates: " + ConfigOptions.NewTypeString, true, ConfigOptions.NewType.length).getBooleanList();
		ConfigOptions.AddOreDictEntries = config.getBoolean("Enable OreDictionary Additions", Random, false, "Will add all Ore-Dictionary entries for an itemstack");
		
		config.save();
	}

}
