package net.mbkgr.abmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.mbkgr.abmod.ABMod;
import net.mbkgr.abmod.item.custom.RandomClassGeneratorItem;
import net.mbkgr.abmod.item.custom.StartingBoxItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;



public class ModItems {
        // THIS IS HOW YOU REGISTER ITEM TO MINECRAFT.
        // ItemGroup.MISC THAT DEFINES WHICH INVENTORY TAB TO REGISTER.
        // AFTER REGISTER, YOU NEED TO ADD SOME CODE TO en_us.json FILE. THERE IS AN EXAMPLE OVER THERE.
        // THEN YOU NEED TO CREATE A JSON FILE FOR ITEM LIKE chakra_stone.json
        // FOR LAST, ADD ITEM TEXTURE FILE TO /textures/item AT .PNG FORMAT
         public static final Item chakra_stone = registerItem("chakra_stone",
                new Item(new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP )));

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
