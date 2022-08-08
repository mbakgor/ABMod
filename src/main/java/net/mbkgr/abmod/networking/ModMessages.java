package net.mbkgr.abmod.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.mbkgr.abmod.ABMod;
import net.mbkgr.abmod.networking.packet.ExampleC2SPacket;
import net.mbkgr.abmod.networking.packet.GettingManaC2SPacket;
import net.mbkgr.abmod.networking.packet.ManaSyncDataS2CPacket;
import net.minecraft.util.Identifier;

public class ModMessages {

    public static final Identifier GETTING_MANA_ID = new Identifier(ABMod.MOD_ID, "gettingmana");
    public static final Identifier MANA_SYNC_ID = new Identifier(ABMod.MOD_ID, "mana_sync");
    public static final Identifier EXAMPLE_ID = new Identifier(ABMod.MOD_ID, "example");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(GETTING_MANA_ID, GettingManaC2SPacket::receive);



    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(MANA_SYNC_ID,ManaSyncDataS2CPacket::receive);


    }


}
