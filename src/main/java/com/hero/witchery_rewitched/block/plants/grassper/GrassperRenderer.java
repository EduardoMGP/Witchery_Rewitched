package com.hero.witchery_rewitched.block.plants.grassper;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GrassperRenderer extends TileEntityRenderer<GrassperTileEntity> {
    public GrassperRenderer(TileEntityRendererDispatcher p_i226006_1_) {
        super(p_i226006_1_);
    }

    @Override
    public void render(GrassperTileEntity pBlockEntity, float pPartialTicks, MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pCombinedLight, int pCombinedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = pBlockEntity.items.get(0);
        pMatrixStack.pushPose();
        IBakedModel iBakedModel = itemRenderer.getModel(stack,pBlockEntity.getLevel(), null);
        float worldTicksHeight = (float) Math.sin((pBlockEntity.getLevel().getDayTime() % 60 * Math.PI /60.0));
        pMatrixStack.translate(.5, .55 + .15 * worldTicksHeight, .5);
        pMatrixStack.scale(.8f,.8f,.8f);
        pMatrixStack.mulPose(Vector3f.YP.rotation((float) (pBlockEntity.getLevel().getDayTime() % 120 * 2 * Math.PI / 120.0)));
        itemRenderer.render(stack, ItemCameraTransforms.TransformType.GROUND, true, pMatrixStack, pBuffer, pCombinedLight, pCombinedOverlay, iBakedModel);

        pMatrixStack.popPose();
    }
}
