package net.mbkgr.abmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.mbkgr.abmod.ABMod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;




public class ModItems {
        // THIS IS HOW YOU REGISTER ITEM TO MINECRAFT.
        // ItemGroup.MISC THAT DEFINES WHICH INVENTORY TAB TO REGISTER.
        // AFTER REGISTER, YOU NEED TO ADD SOME CODE TO en_us.json FILE. THERE IS AN EXAMPLE OVER THERE.
        // THEN YOU NEED TO CREATE A JSON FILE FOR ITEM LIKE example_item.json
        // FOR LAST, ADD ITEM TEXTURE FILE TO /textures/item AT .PNG FORMAT
        public static final Item ANIME_INGOT = registerItem("anime_ingot",new Item(new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP)));
        public static final Item ANIME_NUGGET = registerItem("anime_nugget",new Item(new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP)));
        public static final Item RAW_ANIME = registerItem("raw_anime",new Item(new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP)));

        public static final Item ANIME_HELMET = registerItem("anime_helmet",new ArmorItem(AnimeArmorMaterial.ANIME, EquipmentSlot.HEAD ,new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP)));
        public static final Item ANIME_CHESTPLATE = registerItem("anime_chestplate",new ArmorItem(AnimeArmorMaterial.ANIME, EquipmentSlot.CHEST ,new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP)));
        public static final Item ANIME_LEGGINGS = registerItem("anime_leggings",new ArmorItem(AnimeArmorMaterial.ANIME, EquipmentSlot.LEGS ,new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP)));
        public static final Item ANIME_BOOTS = registerItem("anime_boots",new ArmorItem(AnimeArmorMaterial.ANIME, EquipmentSlot.FEET ,new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP)));

        public static final Item exampleItem = registerItem("example_item",
                new Item(new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP )));
        private static Item registerItem(String name, Item item) {
            return Registry.register(Registry.ITEM, new Identifier(ABMod.MOD_ID, name), item);
        }

        public static void registerModItems() {ABMod.LOGGER.debug("Registering Mod Items for " + ABMod.MOD_ID);}

}
