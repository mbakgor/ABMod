package net.mbkgr.abmod.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.mbkgr.abmod.util.IEntityDataSaver;
import net.mbkgr.abmod.util.ManaData;
import net.minecraft.block.Blocks;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

public class GettingManaC2SPacket {

    private static final String MESSAGE_GETTING_MANA = "message.abmod.getting_mana";
    private static final String MESSAGE_NO_AIR_NEARBY = "message.abmod.no_air";

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        ServerWorld world = player.getWorld();
        if(isAroundAirThem(player, world,1)) {

            player.sendMessage(Text.translatable(MESSAGE_GETTING_MANA)
                    .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)), false);

            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,
                    0.5F,world.random.nextFloat() * 0.1F + 0.9F);

            ManaData.addMana(((IEntityDataSaver) player), 1);

            player.sendMessage(Text.literal("Mana:" + ((IEntityDataSaver) player).getPersistentData().getInt("mana"))
                    .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)),true);
        } else {

            player.sendMessage(Text.translatable(MESSAGE_NO_AIR_NEARBY)
                    .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)), false);

            player.sendMessage(Text.literal("Mana:" + ((IEntityDataSaver) player).getPersistentData().getInt("mana"))
                    .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)),true);

            ManaData.syncMana(((IEntityDataSaver) player).getPersistentData().getInt("mana"), player);

        }
    }

    private static boolean isAroundAirThem(ServerPlayerEntity player, ServerWorld world, int size) {
        return BlockPos.stream(player.getBoundingBox().expand(size))
                .map(world::getBlockState).filter(state -> state.isOf(Blocks.AIR)).toArray().length > 0;
    }

}
