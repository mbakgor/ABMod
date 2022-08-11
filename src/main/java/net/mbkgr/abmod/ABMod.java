package net.mbkgr.abmod;

import net.fabricmc.api.ModInitializer;
import net.mbkgr.abmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ABMod implements ModInitializer {
	//yarak
	public static final String MOD_ID = "abmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		LOGGER.info("Hello Fabric world!");
	}
}
