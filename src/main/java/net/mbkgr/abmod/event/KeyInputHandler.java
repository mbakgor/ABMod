package net.mbkgr.abmod.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.mbkgr.abmod.networking.ModMessages;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {

    public static final String KEY_CATEGORY_TUTORIAL = "key.category.abmod.tutorial";
    public static final String KEY_GET_MANA = "key.abmod.get_mana";

    public static KeyBinding getManaKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(getManaKey.wasPressed()) {
                ClientPlayNetworking.send(ModMessages.GETTING_MANA_ID, PacketByteBufs.create());
            }
        });
    }

    public static void register() {
        getManaKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_GET_MANA,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_0,
                KEY_CATEGORY_TUTORIAL
        ));

        registerKeyInputs();
    }
}
