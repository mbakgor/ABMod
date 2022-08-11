package net.mbkgr.abmod.mixin;

import com.mojang.authlib.GameProfile;
import net.mbkgr.abmod.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class PlayerSpawnMixin extends PlayerEntity {


    public PlayerSpawnMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile, @Nullable PlayerPublicKey publicKey) {
        super(world, pos, yaw, gameProfile, publicKey);
    }

    @Inject(method = "onSpawn", at = @At("HEAD"))
    protected void inject_onSpawnMethod(CallbackInfo ci) {

        ItemStack startingboxitem = new ItemStack(ModItems.startingBox);
        this.giveItemStack(startingboxitem);

    }

}
