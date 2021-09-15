package com.hero.witchery_rewitched.entity.ent;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.hero.witchery_rewitched.entity.ent.EntEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class EntModel extends EntityModel<EntEntity> {
    private final ModelRenderer trent;
    private final ModelRenderer leaves;
    private final ModelRenderer trunk;
    private final ModelRenderer rightarm;
    private final ModelRenderer rightarm_r1;
    private final ModelRenderer leftarm;
    private final ModelRenderer leftarm_r1;
    private final ModelRenderer roots;
    private final ModelRenderer rightfrontroots;
    private final ModelRenderer rightfrontend_r1;
    private final ModelRenderer rightfrontmiddle_r1;
    private final ModelRenderer rightfrontbase_r1;
    private final ModelRenderer rightbackroots;
    private final ModelRenderer rightbackend_r1;
    private final ModelRenderer rightbackmiddle_r1;
    private final ModelRenderer rightbackbase_r1;
    private final ModelRenderer leftfrontroots;
    private final ModelRenderer leftfrontend_r1;
    private final ModelRenderer leftfrontmiddle_r1;
    private final ModelRenderer leftfrontbase_r1;
    private final ModelRenderer leftbackroots;
    private final ModelRenderer leftbackend_r1;
    private final ModelRenderer leftbackmiddle_r1;
    private final ModelRenderer leftbackbase_r1;

    public EntModel() {
        texWidth = 512;
        texHeight = 512;

        trent = new ModelRenderer(this);
        trent.setPos(0.0F, 24.0F, 0.0F);


        leaves = new ModelRenderer(this);
        leaves.setPos(0.0F, 0.0F, 0.0F);
        trent.addChild(leaves);
        leaves.texOffs(192, 224).addBox(-40.0F, -64.0F, -40.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(0, 224).addBox(-8.0F, -64.0F, -40.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(144, 208).addBox(8.0F, -64.0F, -40.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(48, 208).addBox(24.0F, -64.0F, -40.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(96, 224).addBox(-24.0F, -64.0F, -40.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(192, 192).addBox(-40.0F, -64.0F, -24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(192, 128).addBox(8.0F, -64.0F, -24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(192, 160).addBox(-8.0F, -64.0F, -24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(192, 96).addBox(24.0F, -64.0F, -24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(96, 192).addBox(-24.0F, -64.0F, -24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(192, 64).addBox(-40.0F, -64.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(192, 32).addBox(-8.0F, -64.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(192, 0).addBox(8.0F, -64.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(0, 192).addBox(24.0F, -64.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(144, 176).addBox(-24.0F, -64.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(48, 176).addBox(-40.0F, -64.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(96, 160).addBox(8.0F, -64.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(144, 80).addBox(8.0F, -64.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(0, 128).addBox(8.0F, -80.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(48, 112).addBox(-8.0F, -80.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(96, 96).addBox(-24.0F, -80.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(96, 64).addBox(-24.0F, -80.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(96, 32).addBox(-24.0F, -80.0F, -24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(96, 0).addBox(-8.0F, -80.0F, -24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(0, 96).addBox(-8.0F, -80.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(48, 80).addBox(8.0F, -80.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(0, 64).addBox(8.0F, -80.0F, -24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(0, 160).addBox(-8.0F, -64.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(0, 0).addBox(-24.0F, -64.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(144, 144).addBox(24.0F, -64.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(144, 112).addBox(-24.0F, -64.0F, 24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(48, 144).addBox(-8.0F, -64.0F, 24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(144, 16).addBox(8.0F, -64.0F, 24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(96, 128).addBox(24.0F, -64.0F, 24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        leaves.texOffs(144, 48).addBox(-40.0F, -64.0F, 24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

        trunk = new ModelRenderer(this);
        trunk.setPos(0.0F, 0.0F, 0.0F);
        trent.addChild(trunk);
        trunk.texOffs(48, 48).addBox(-8.0F, -48.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        trunk.texOffs(48, 16).addBox(-8.0F, -32.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        trunk.texOffs(0, 32).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setPos(0.0F, 8.0F, 0.0F);
        trent.addChild(rightarm);


        rightarm_r1 = new ModelRenderer(this);
        rightarm_r1.setPos(0.0F, 0.0F, 0.0F);
        rightarm.addChild(rightarm_r1);
        setRotationAngle(rightarm_r1, 0.0F, 0.0F, -0.48F);
        rightarm_r1.texOffs(240, 32).addBox(5.0F, -66.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        rightarm_r1.texOffs(64, 240).addBox(5.0F, -58.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        rightarm_r1.texOffs(240, 64).addBox(5.0F, -50.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        rightarm_r1.texOffs(240, 96).addBox(5.0F, -42.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        rightarm_r1.texOffs(240, 128).addBox(5.0F, -34.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setPos(0.0F, 8.0F, 0.0F);
        trent.addChild(leftarm);


        leftarm_r1 = new ModelRenderer(this);
        leftarm_r1.setPos(0.0F, 0.0F, 0.0F);
        leftarm.addChild(leftarm_r1);
        setRotationAngle(leftarm_r1, 0.0F, 0.0F, 0.48F);
        leftarm_r1.texOffs(48, 0).addBox(-13.0F, -66.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        leftarm_r1.texOffs(80, 0).addBox(-13.0F, -58.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        leftarm_r1.texOffs(144, 0).addBox(-13.0F, -50.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        leftarm_r1.texOffs(176, 0).addBox(-13.0F, -42.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        leftarm_r1.texOffs(240, 0).addBox(-13.0F, -34.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        roots = new ModelRenderer(this);
        roots.setPos(0.0F, 0.0F, 0.0F);
        trent.addChild(roots);


        rightfrontroots = new ModelRenderer(this);
        rightfrontroots.setPos(0.0F, 8.0F, 0.0F);
        roots.addChild(rightfrontroots);


        rightfrontend_r1 = new ModelRenderer(this);
        rightfrontend_r1.setPos(0.0F, -8.0F, 0.0F);
        rightfrontroots.addChild(rightfrontend_r1);
        setRotationAngle(rightfrontend_r1, 0.1745F, -0.5672F, -0.3054F);
        rightfrontend_r1.texOffs(0, 44).addBox(-16.0F, -6.25F, -3.25F, 3.0F, 2.0F, 2.0F, 0.0F, false);

        rightfrontmiddle_r1 = new ModelRenderer(this);
        rightfrontmiddle_r1.setPos(0.0F, -8.0F, 0.0F);
        rightfrontroots.addChild(rightfrontmiddle_r1);
        setRotationAngle(rightfrontmiddle_r1, 0.1309F, -0.6109F, -0.2182F);
        rightfrontmiddle_r1.texOffs(0, 38).addBox(-14.25F, -5.75F, -3.25F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        rightfrontbase_r1 = new ModelRenderer(this);
        rightfrontbase_r1.setPos(0.0F, 0.0F, 0.0F);
        rightfrontroots.addChild(rightfrontbase_r1);
        setRotationAngle(rightfrontbase_r1, 0.0436F, -0.6545F, -0.0873F);
        rightfrontbase_r1.texOffs(240, 168).addBox(-12.0F, -13.0F, -3.5F, 6.0F, 4.0F, 4.0F, 0.0F, false);

        rightbackroots = new ModelRenderer(this);
        rightbackroots.setPos(0.0F, 0.0F, 0.0F);
        roots.addChild(rightbackroots);


        rightbackend_r1 = new ModelRenderer(this);
        rightbackend_r1.setPos(0.0F, 0.0F, 0.0F);
        rightbackroots.addChild(rightbackend_r1);
        setRotationAngle(rightbackend_r1, -0.1745F, 0.5672F, -0.3054F);
        rightbackend_r1.texOffs(0, 70).addBox(-16.0F, -6.25F, 1.25F, 3.0F, 2.0F, 2.0F, 0.0F, false);

        rightbackmiddle_r1 = new ModelRenderer(this);
        rightbackmiddle_r1.setPos(0.0F, 0.0F, 0.0F);
        rightbackroots.addChild(rightbackmiddle_r1);
        setRotationAngle(rightbackmiddle_r1, -0.1309F, 0.6109F, -0.2182F);
        rightbackmiddle_r1.texOffs(0, 32).addBox(-14.25F, -5.75F, 0.25F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        rightbackbase_r1 = new ModelRenderer(this);
        rightbackbase_r1.setPos(0.0F, 8.0F, 0.0F);
        rightbackroots.addChild(rightbackbase_r1);
        setRotationAngle(rightbackbase_r1, -0.0436F, 0.6545F, -0.0873F);
        rightbackbase_r1.texOffs(0, 0).addBox(-12.0F, -13.0F, -0.5F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        leftfrontroots = new ModelRenderer(this);
        leftfrontroots.setPos(0.0F, 0.0F, 0.0F);
        roots.addChild(leftfrontroots);


        leftfrontend_r1 = new ModelRenderer(this);
        leftfrontend_r1.setPos(0.0F, 0.0F, 0.0F);
        leftfrontroots.addChild(leftfrontend_r1);
        setRotationAngle(leftfrontend_r1, 0.1745F, 0.5672F, 0.3054F);
        leftfrontend_r1.texOffs(72, 4).addBox(13.0F, -6.25F, -3.25F, 3.0F, 2.0F, 2.0F, 0.0F, false);

        leftfrontmiddle_r1 = new ModelRenderer(this);
        leftfrontmiddle_r1.setPos(0.0F, 0.0F, 0.0F);
        leftfrontroots.addChild(leftfrontmiddle_r1);
        setRotationAngle(leftfrontmiddle_r1, 0.1309F, 0.6109F, 0.2182F);
        leftfrontmiddle_r1.texOffs(0, 64).addBox(11.25F, -5.75F, -3.25F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        leftfrontbase_r1 = new ModelRenderer(this);
        leftfrontbase_r1.setPos(0.0F, 8.0F, 0.0F);
        leftfrontroots.addChild(leftfrontbase_r1);
        setRotationAngle(leftfrontbase_r1, 0.0436F, 0.6545F, 0.0873F);
        leftfrontbase_r1.texOffs(160, 240).addBox(6.0F, -13.0F, -3.5F, 6.0F, 4.0F, 4.0F, 0.0F, false);

        leftbackroots = new ModelRenderer(this);
        leftbackroots.setPos(0.0F, 0.0F, 0.0F);
        roots.addChild(leftbackroots);


        leftbackend_r1 = new ModelRenderer(this);
        leftbackend_r1.setPos(0.0F, 0.0F, 0.0F);
        leftbackroots.addChild(leftbackend_r1);
        setRotationAngle(leftbackend_r1, -0.1745F, -0.5672F, 0.3054F);
        leftbackend_r1.texOffs(72, 0).addBox(13.0F, -6.25F, 1.25F, 3.0F, 2.0F, 2.0F, 0.0F, false);

        leftbackmiddle_r1 = new ModelRenderer(this);
        leftbackmiddle_r1.setPos(0.0F, 0.0F, 0.0F);
        leftbackroots.addChild(leftbackmiddle_r1);
        setRotationAngle(leftbackmiddle_r1, -0.1309F, -0.6109F, 0.2182F);
        leftbackmiddle_r1.texOffs(0, 8).addBox(11.25F, -5.75F, 0.25F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        leftbackbase_r1 = new ModelRenderer(this);
        leftbackbase_r1.setPos(0.0F, 8.0F, 0.0F);
        leftbackroots.addChild(leftbackbase_r1);
        setRotationAngle(leftbackbase_r1, -0.0436F, -0.6545F, 0.0873F);
        leftbackbase_r1.texOffs(240, 160).addBox(6.0F, -13.0F, -0.5F, 6.0F, 4.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(EntEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        trent.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}