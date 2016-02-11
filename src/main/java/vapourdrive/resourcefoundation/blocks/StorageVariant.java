package vapourdrive.resourcefoundation.blocks;

import java.util.Locale;

import net.minecraft.util.IStringSerializable;

public enum StorageVariant implements IStringSerializable
{
	COPPER, TIN, ALUMINUM, BRONZE, LEAD, SILVER, ELECTRUM, NICKEL, INVAR, PLATINUM, STEEL, ZINC, BRASS;

	@Override
	public String getName()
	{
		return name().toLowerCase(Locale.ROOT);
	}
}
