package com.hero.witchery_rewitched.entity.ent;

import com.hero.witchery_rewitched.WitcheryRewitched;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EntRenderer extends MobRenderer<EntEntity, EntModel> {
    private static final ResourceLocation ENT_TEXTURE_R = new ResourceLocation(WitcheryRewitched.MODID, "textures/entity/trentmap_rowan.png");
    public EntRenderer(EntityRendererManager rendererManagerIn){super(rendererManagerIn, new EntModel(), 1.2f);}

    @Override
    public ResourceLocation getTextureLocation(EntEntity pEntity) {
        return ENT_TEXTURE_R;
    }
}
