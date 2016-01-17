package vapourdrive.resourcefoundation.utils;

import java.util.ArrayList;

import net.minecraftforge.fml.common.registry.GameData;

public class BlockDump
{
	ArrayList<BlockInfo> blocks = new ArrayList<BlockInfo>();
	public static void init()
	{
		GameData.getBlockRegistry();
	}
	
	public class BlockInfo
	{
		
	}
}
