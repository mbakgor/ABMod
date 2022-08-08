package net.mbkgr.abmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.mbkgr.abmod.event.PlayerTickHandler;
import net.mbkgr.abmod.item.ModItems;
import net.mbkgr.abmod.networking.ModMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ABMod implements ModInitializer {
	//yarak
	public static final String MOD_ID = "abmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModMessages.registerC2SPackets();

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
	}
}
