package com.hero.witchery_rewitched.entity.mandrake;

import com.hero.witchery_rewitched.WitcheryRewitched;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MandrakeRenderer extends MobRenderer<MandrakeEntity, MandrakeModel> {
    private static final ResourceLocation MANDRAKE_TEXTURE = new ResourceLocation(WitcheryRewitched.MODID,"textures/entity/mandrake.png");

    public MandrakeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MandrakeModel(), .5f);
    }

    @Override
    public ResourceLocation getTextureLocation(MandrakeEntity entity) {
        return MANDRAKE_TEXTURE;
    }
}
