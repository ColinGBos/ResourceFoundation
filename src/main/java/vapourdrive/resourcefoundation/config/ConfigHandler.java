package vapourdrive.resourcefoundation.config;

import java.io.File;

public class ConfigHandler
{
	public static void preInit(File configPath)
	{
		ResourceFoundationConfig.preInit(new File(configPath + "/resourcefoundation/" + "ResourceFoundation.cfg"));
	}

}
