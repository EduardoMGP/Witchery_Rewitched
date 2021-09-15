package com.hero.witchery_rewitched.block.distillery;

import com.hero.witchery_rewitched.WitcheryRewitched;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class DistilleryScreen extends ContainerScreen<DistilleryContainer> {
    public static  final ResourceLocation TEXTURE = new ResourceLocation(WitcheryRewitched.MODID, "textures/gui/distillery.png");
    public DistilleryScreen(DistilleryContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground((matrixStack));
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(MatrixStack matrixStack, int x, int y) {
        ITextComponent text = new TranslationTextComponent("container.witchery_rewitched.distillery");
        font.draw(matrixStack, text.getString(), 58, 6, 0x404040);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
        if(minecraft == null) return;

        RenderSystem.color4f(1,1,1,1);
        minecraft.getTextureManager().bind(TEXTURE);

        int posX = (this.width - this.imageWidth)/2;
        int posY = (this.height - this.imageHeight)/2;
        blit(matrixStack, posX, posY, 0, 0, this.imageWidth, this.imageHeight);
        blit(matrixStack, posX+47, posY+19, 176, 0, menu.getProgressArrowScale(), 38);
    }
}
