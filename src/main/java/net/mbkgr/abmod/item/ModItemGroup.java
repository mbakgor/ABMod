package net.mbkgr.abmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.mbkgr.abmod.ABMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup ANIME_BATTLE_GROUP = FabricItemGroupBuilder.build(new Identifier(ABMod.MOD_ID, "anime_battle_group"),
            () -> new ItemStack(ModItems.ANIME_INGOT));


}
