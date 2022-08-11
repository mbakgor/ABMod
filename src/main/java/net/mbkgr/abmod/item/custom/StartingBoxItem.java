package net.mbkgr.abmod.item.custom;

import net.mbkgr.abmod.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class StartingBoxItem extends Item {


    public StartingBoxItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {



        if(!world.isClient() && hand == Hand.MAIN_HAND) {

           user.giveItemStack(new ItemStack(ModItems.randomClassGenerator));
           user.giveItemStack(new ItemStack(ModItems.STRING_LEGGINGS));
           user.giveItemStack(new ItemStack(ModItems.STRING_CHESTPLATE));
           user.giveItemStack(new ItemStack(ModItems.STRING_BOOTS));
           user.giveItemStack(new ItemStack(ModItems.STRING_HELMET));

           user.getInventory().removeStack(user.getInventory().selectedSlot);


        }

        return super.use(world, user, hand);
    }
}
