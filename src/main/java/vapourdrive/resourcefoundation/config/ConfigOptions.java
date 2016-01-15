package vapourdrive.resourcefoundation.config;

public class ConfigOptions
{
	public static String[] ExistingType =
	{
			"Copper", "Tin", "Aluminum", "Bronze", "Lead", "Silver", "Electrum", "Nickel", "Invar", "Platinum", "Steel"
	};
	public static String ExitingTypeString = "Copper, Tin, Aluminum, Bronze, Lead, Silver, Electrum, Nickel, Invar, Platinum, Steel";
	
	public static String[] NewType =
	{
			"Copper", "Tin", "Aluminum", "Iron", "Bronze", "Lead", "Silver", "Gold", "Electrum", "Nickel", "Invar", "Platinum", "Steel"
	};
	public static String NewTypeString = "Copper, Tin, aluminum, Iron, Bronze, Lead, Silver, Gold, Electrum, Nickel, Invar, Platinum, Steel";

	public static String[] Ores =
	{
			"Copper", "Tin", "Aluminum", "Lead", "Silver", "Nickel", "Platinum"
	};
	public static String OreString = "Copper, Tin, Aluminum, Lead, Silver, Nickel, Platinum";
	
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
	public static boolean AddOreDictEntries;

}
