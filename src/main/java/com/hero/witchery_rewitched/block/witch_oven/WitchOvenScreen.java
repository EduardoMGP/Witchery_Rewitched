package com.hero.witchery_rewitched.block.witch_oven;

import com.hero.witchery_rewitched.WitcheryRewitched;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class WitchOvenScreen extends ContainerScreen<WitchOvenContainer> {
    public static  final ResourceLocation TEXTURE = new ResourceLocation(WitcheryRewitched.MODID, "textures/gui/witch_oven.png");

    public WitchOvenScreen(WitchOvenContainer container, PlayerInventory inv, ITextComponent titleIn) {
        super(container, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground((matrixStack));
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(MatrixStack matrixStack, int x, int y) {
        ITextComponent text = new TranslationTextComponent("container.witchery_rewitched.witch_oven");
        font.draw(matrixStack, text.getString(), 28, 6, 0x404040);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
        if(minecraft == null) return;

        //noinspection deprecation
        RenderSystem.color4f(1,1,1,1);
        minecraft.getTextureManager().bind(TEXTURE);

        int posX = (this.width - this.imageWidth) /2;
        int posY = (this.height - this.imageHeight) /2;
        blit(matrixStack, posX, posY, 0, 0, this.imageWidth, this.imageHeight);

        blit(matrixStack, posX+71, posY+24, 176, 14, menu.getProgressArrowScale()+1, 16);
        int furnace = menu.getFuelScale();
        blit(matrixStack, posX+48,posY+44+13-furnace, 176, 14-furnace, 14, furnace);
    }
}

