package net.mbkgr.abmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.mbkgr.abmod.client.ManaHudOverlay;
import net.mbkgr.abmod.event.KeyInputHandler;
import net.mbkgr.abmod.networking.ModMessages;

public class ABModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModMessages.registerS2CPackets();

        HudRenderCallback.EVENT.register(new ManaHudOverlay());

        KeyInputHandler.register();

    }
}
