package vapourdrive.resourcefoundation.events;

import net.minecraftforge.common.MinecraftForge;

public class EventsHandler
{

	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(new ToolTipHandler());
	}

}
