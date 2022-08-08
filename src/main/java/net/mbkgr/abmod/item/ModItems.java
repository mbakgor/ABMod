package net.mbkgr.abmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.mbkgr.abmod.ABMod;
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
        public static final Item exampleItem = registerItem("example_item",
                new Item(new FabricItemSettings().group(ModItemGroup.ANIME_BATTLE_GROUP )));


        private static Item registerItem(String name, Item item) {
            return Registry.register(Registry.ITEM, new Identifier(ABMod.MOD_ID, name), item);
        }

        public static void registerModItems() {


            ABMod.LOGGER.debug("Registering Mod Items for " + ABMod.MOD_ID);

        }



}
