package com.hero.witchery_rewitched.block.altar;

import com.hero.witchery_rewitched.WitcheryRewitched;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class AltarScreen extends ContainerScreen<AltarContainer> {
    public static  final ResourceLocation TEXTURE = new ResourceLocation(WitcheryRewitched.MODID, "textures/gui/altar.png");

    public AltarScreen(AltarContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
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
        ITextComponent text = new TranslationTextComponent("container.witchery_rewitched.altar");
        font.draw(matrixStack, text.getString(), 50, 50, 0x404040);
        String generatedText = menu.getEnergy() + " / "  + menu.getMaxEnergy() + "   (x" + menu.getRechargeRate()+ ")";
        font.draw(matrixStack, generatedText, 50, 82, 0x404040);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
        if(minecraft == null) return;

        minecraft.getTextureManager().bind(TEXTURE);

        int posX = (this.width - this.imageWidth) /2;
        int posY = (this.height - this.imageHeight) /2;
        blit(matrixStack, posX, posY, 0, 0, this.imageWidth, this.imageHeight);
    }
}
