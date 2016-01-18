package vapourdrive.resourcefoundation.blocks;

import net.minecraft.util.IStringSerializable;

public enum OreVariant implements IStringSerializable
{
	COPPER, TIN, ALUMINUM, LEAD, SILVER, NICKEL, PLATINUM;

	@Override
	public String getName()
	{
        return name();
	}

}
