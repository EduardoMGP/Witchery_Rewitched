package com.hero.witchery_rewitched.block.poppet_shelf;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.CampfireBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PoppetShelfTileEntityRenderer extends TileEntityRenderer<PoppetShelfTileEntity> {
    public PoppetShelfTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(PoppetShelfTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        NonNullList<ItemStack> nonnulllist = tileEntityIn.getInventory();

        for(int i = 0; i < nonnulllist.size(); ++i) {
            ItemStack itemstack = nonnulllist.get(i);
            if (itemstack != ItemStack.EMPTY) {
                ActiveRenderInfo activeRenderInfo = this.renderer.camera;
                matrixStackIn.pushPose();
                RenderSystem.enableBlend();
                double posX = (i % 2 + 1) * .33;
                double posY = .90;
                double posZ = (i / 2 + 1) * .33;
                matrixStackIn.translate(posX, posY, posZ);
                matrixStackIn.mulPose(new Quaternion(0, 180-activeRenderInfo.getYRot(), 0, true));
                float scale = 0.35f;
                matrixStackIn.scale(scale, scale, scale);

                ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
                itemRenderer.renderStatic(itemstack, ItemCameraTransforms.TransformType.NONE, combinedLightIn + 50, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn);
                matrixStackIn.popPose();
            }
        }
    }
}
