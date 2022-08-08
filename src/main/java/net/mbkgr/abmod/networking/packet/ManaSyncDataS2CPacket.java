package net.mbkgr.abmod.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.mbkgr.abmod.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;


public class ManaSyncDataS2CPacket {

    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        ((IEntityDataSaver) client.player).getPersistentData().putInt("mana", buf.readInt());
    }
}
