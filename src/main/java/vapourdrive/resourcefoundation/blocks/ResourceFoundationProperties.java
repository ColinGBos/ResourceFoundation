package vapourdrive.resourcefoundation.blocks;

import net.minecraft.block.properties.PropertyEnum;

public class ResourceFoundationProperties
{
    // BlockStorage
	public static final PropertyEnum<StorageVariant> STORAGE_VARIANT = PropertyEnum.create("variant", StorageVariant.class);
	public static final PropertyEnum<OreVariant> ORE_VARIANT = PropertyEnum.create("variant", OreVariant.class);

}
