package net.mbkgr.abmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.mbkgr.abmod.ABMod;
import net.mbkgr.abmod.item.custom.RandomClassGeneratorItem;
import net.mbkgr.abmod.item.custom.StartingBoxItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;




public class ModItems {



        //ARMORS AND WEAPONS
        public static final Item STRING_HELMET = registerItem("string_helmet",new ArmorItem(CustomArmorMaterial.STRING, EquipmentSlot.HEAD ,new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP)));
        public static final Item STRING_CHESTPLATE = registerItem("string_chestplate",new ArmorItem(CustomArmorMaterial.STRING, EquipmentSlot.CHEST ,new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP)));
        public static final Item STRING_LEGGINGS = registerItem("string_leggings",new ArmorItem(CustomArmorMaterial.STRING, EquipmentSlot.LEGS ,new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP)));
        public static final Item STRING_BOOTS = registerItem("string_boots",new ArmorItem(CustomArmorMaterial.STRING, EquipmentSlot.FEET ,new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP)));

        //TOOLS


         //ORES AND INGOTS
         public static final Item chakra_stone = registerItem("chakra_stone", new Item(new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP )));




         //MISC
         public static final Item startingBox = registerItem("starting_box",
                new StartingBoxItem(new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP ).maxCount(1)));

         public static final Item randomClassGenerator = registerItem("random_class_generator_item",
                new RandomClassGeneratorItem(new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP ).maxCount(1)));



        private static Item registerItem(String name, Item item) {
            return Registry.register(Registry.ITEM, new Identifier(ABMod.MOD_ID, name), item);
        }

        public static void registerModItems() {


            ABMod.LOGGER.debug("Registering Mod Items for " + ABMod.MOD_ID);

        }



}
