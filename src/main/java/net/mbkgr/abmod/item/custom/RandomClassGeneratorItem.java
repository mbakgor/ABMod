package net.mbkgr.abmod.item.custom;

import net.mbkgr.abmod.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RandomClassGeneratorItem extends Item {

    public RandomClassGeneratorItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack startingBox = new ItemStack(ModItems.startingBox);

        if(!world.isClient() && hand == Hand.MAIN_HAND) {

            user.giveItemStack(startingBox);

        }

        return super.use(world, user, hand);
    }
}
