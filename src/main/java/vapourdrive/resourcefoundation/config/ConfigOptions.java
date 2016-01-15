package vapourdrive.resourcefoundation.config;

public class ConfigOptions
{
	public static String[] ExistingType =
	{
			"copper", "tin", "aluminum", "bronze", "lead", "silver", "electrum", "nickel", "invar", "platinum", "steel"
	};
	public static String ExitingTypeString = "copper, tin, aluminum, bronze, lead, silver, electrum, nickel, invar, platinum, steel";
	
	public static String[] NewType =
	{
			"copper", "tin", "aluminum", "iron", "bronze", "lead", "silver", "gold", "electrum", "nickel", "invar", "platinum", "steel"
	};
	public static String NewTypeString = "copper, tin, aluminum, iron, bronze, lead, silver, gold, electrum, nickel, invar, platinum, steel";

	public static String[] Ores =
	{
			"copper", "tin", "aluminum", "lead", "silver", "nickel", "platinum"
	};
	public static String OreString = "copper, tin, aluminum, lead, silver, nickel, platinum";
	
	public static boolean[] enabledOres;
	public static boolean[] defaultEnabledOres = {true, true, true, true, true, true, true};

	public static boolean[] enabledIngots;
	public static boolean[] defaultEnabledIngots = {true, true, true, true, true, true, true, true, true, true, true};
	
	public static boolean[] enabledNuggets;
	public static boolean[] defaultEnabledNuggets = {true, true, true, true, true, true, true, true, true, true, true};

	public static boolean[] enabledStorageBlocks;
	public static boolean[] defaultEnabledStorageBlocks = {true, true, true, true, true, true, true, true, true, true, true};

	public static boolean[] enabledDusts;
	public static boolean[] defaultEnabledDusts = {true, true, true, true, true, true, true, true, true, true, true, true, true};

	public static boolean[] enabledGears;
	public static boolean[] defaultEnabledGears = {true, true, true, true, true, true, true, true, true, true, true, true, true};

	public static boolean[] enabledPlates;
	public static boolean[] defaultEnabledPlates = {true, true, true, true, true, true, true, true, true, true, true, true, true};

}
