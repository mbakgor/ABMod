package net.mbkgr.abmod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.mbkgr.abmod.ABMod;
import net.mbkgr.abmod.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ManaHudOverlay implements HudRenderCallback {

    public static final Identifier FILLED_MANA = new Identifier(ABMod.MOD_ID,
            "textures/mana/filled_mana.png");
    public static final Identifier EMPTY_MANA = new Identifier(ABMod.MOD_ID,
            "textures/mana/empty_mana.png");



    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        int x = 0;
        int y = 0;

        MinecraftClient client = MinecraftClient.getInstance();

        if(client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F,1.0F,1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_MANA);
        for(int i = 0; i < 10; i++) {
            DrawableHelper.drawTexture(matrixStack, x - 94 + (i * 9), y - 54, 0, 0, 12, 12,12,12);
        }


        RenderSystem.setShaderTexture(0, FILLED_MANA);
        for(int i = 0; i < 10; i++) {
            if(((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("mana") > i) {
                DrawableHelper.drawTexture(matrixStack,x - 94 + (i * 9), y - 54, 0, 0, 12, 12,12,12);
            } else {
                break;
            }
        }



    }
}
