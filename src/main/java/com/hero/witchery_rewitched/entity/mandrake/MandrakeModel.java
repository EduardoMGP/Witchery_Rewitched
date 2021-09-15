package com.hero.witchery_rewitched.entity.mandrake;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MandrakeModel extends EntityModel<MandrakeEntity> {
    private final ModelRenderer mandrake;
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer feet;
    private final ModelRenderer leftfoot;
    private final ModelRenderer rightfoot;
    private final ModelRenderer hands;
    private final ModelRenderer lefthand;
    private final ModelRenderer cube_r1;
    private final ModelRenderer righthand;
    private final ModelRenderer cube_r2;
    private final ModelRenderer plant;
    private final ModelRenderer flower2;
    private final ModelRenderer flower;
    private final ModelRenderer leaf2medium4;
    private final ModelRenderer leaf2medium3;
    private final ModelRenderer leaf1medium3;
    private final ModelRenderer leaf1small4;
    private final ModelRenderer leaf1small;
    private final ModelRenderer leaf1small2;
    private final ModelRenderer leaf1small5;
    private final ModelRenderer leaf1small12;
    private final ModelRenderer leaf1small3;
    private final ModelRenderer leaf1small6;
    private final ModelRenderer leaf1small7;
    private final ModelRenderer leaf1small10;
    private final ModelRenderer leaf1small11;
    private final ModelRenderer leaf1small8;
    private final ModelRenderer leaf1small9;
    private final ModelRenderer leaf1medium;
    private final ModelRenderer leaf1medium2;
    private final ModelRenderer leaf1medium4;
    private final ModelRenderer leaf1medium5;
    private final ModelRenderer leaf2medium;
    private final ModelRenderer leaf2medium8;
    private final ModelRenderer leaf2medium7;
    private final ModelRenderer leaf2medium2;
    private final ModelRenderer leaf2medium5;
    private final ModelRenderer leaf2medium6;
    private final ModelRenderer leaf2big;
    private final ModelRenderer leaf2big2;
    private final ModelRenderer leaf2big3;
    private final ModelRenderer leaf2big4;
    private final ModelRenderer leaf2big5;
    private final ModelRenderer leaf2big6;
    private final ModelRenderer flower3;
    private final ModelRenderer flower4;

    public MandrakeModel() {
        texWidth = 64;
        texHeight = 64;

        mandrake = new ModelRenderer(this);
        mandrake.setPos(0.0F, 24.0F, 0.0F);


        body = new ModelRenderer(this);
        body.setPos(0.0F, 0.0F, 0.0F);
        mandrake.addChild(body);
        body.texOffs(0, 5).addBox(-1.5F, -2.75F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
        body.texOffs(0, 0).addBox(-1.5F, -4.25F, -1.5F, 3.0F, 2.0F, 3.0F, -0.25F, false);
        body.texOffs(9, 2).addBox(-1.5F, -1.25F, -1.5F, 3.0F, 1.0F, 3.0F, -0.25F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        mandrake.addChild(head);
        head.texOffs(0, 10).addBox(-1.0F, -5.75F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        feet = new ModelRenderer(this);
        feet.setPos(0.0F, 0.0F, 0.0F);
        mandrake.addChild(feet);


        leftfoot = new ModelRenderer(this);
        leftfoot.setPos(0.0F, -1.5F, 0.0F);
        feet.addChild(leftfoot);
        leftfoot.texOffs(0, 14).addBox(0.2F, -0.25F, -0.5F, 1.0F, 2.0F, 1.0F, -0.25F, false);

        rightfoot = new ModelRenderer(this);
        rightfoot.setPos(0.0F, -1.5F, 0.0F);
        feet.addChild(rightfoot);
        rightfoot.texOffs(14, 14).addBox(-1.2F, -0.25F, -0.5F, 1.0F, 2.0F, 1.0F, -0.25F, false);

        hands = new ModelRenderer(this);
        hands.setPos(0.0F, 0.0F, 0.0F);
        mandrake.addChild(hands);


        lefthand = new ModelRenderer(this);
        lefthand.setPos(0.0F, 0.0F, 0.0F);
        hands.addChild(lefthand);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(-2.5F, 0.75F, -3.5F);
        lefthand.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, -0.5672F);
        cube_r1.texOffs(9, 0).addBox(2.5F, -3.4F, 3.0F, 2.0F, 1.0F, 1.0F, -0.25F, false);

        righthand = new ModelRenderer(this);
        righthand.setPos(0.0F, 0.0F, 0.0F);
        hands.addChild(righthand);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(2.5F, 0.75F, -3.5F);
        righthand.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.48F);
        cube_r2.texOffs(9, 6).addBox(-4.25F, -3.65F, 3.0F, 2.0F, 1.0F, 1.0F, -0.25F, false);

        plant = new ModelRenderer(this);
        plant.setPos(0.0F, 0.0F, 0.0F);
        mandrake.addChild(plant);


        flower2 = new ModelRenderer(this);
        flower2.setPos(6.4F, 1.6F, -1.0F);
        plant.addChild(flower2);
        flower2.texOffs(11, 12).addBox(-7.0F, -8.0F, 0.0F, 1.0F, 2.0F, 1.0F, -0.4F, false);
        flower2.texOffs(17, 36).addBox(-6.8F, -8.2F, 0.0F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower2.texOffs(36, 15).addBox(-7.2F, -8.2F, 0.0F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower2.texOffs(36, 12).addBox(-7.0F, -8.2F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower2.texOffs(36, 10).addBox(-6.8F, -8.4F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower2.texOffs(36, 8).addBox(-7.2F, -8.4F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower2.texOffs(7, 36).addBox(-7.0F, -8.2F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower2.texOffs(36, 6).addBox(-6.8F, -8.4F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower2.texOffs(35, 34).addBox(-7.2F, -8.4F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        flower = new ModelRenderer(this);
        flower.setPos(6.0F, 1.5F, 0.0F);
        plant.addChild(flower);
        flower.texOffs(7, 13).addBox(-7.0F, -8.0F, 0.0F, 1.0F, 2.0F, 1.0F, -0.4F, false);
        flower.texOffs(35, 36).addBox(-6.8F, -8.2F, 0.0F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower.texOffs(4, 37).addBox(-7.2F, -8.2F, 0.0F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower.texOffs(37, 0).addBox(-7.0F, -8.2F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower.texOffs(0, 37).addBox(-6.8F, -8.4F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower.texOffs(29, 36).addBox(-7.2F, -8.4F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower.texOffs(23, 36).addBox(-7.0F, -8.2F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower.texOffs(36, 20).addBox(-6.8F, -8.4F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower.texOffs(36, 18).addBox(-7.2F, -8.4F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf2medium4 = new ModelRenderer(this);
        leaf2medium4.setPos(2.4F, -6.6F, 1.15F);
        plant.addChild(leaf2medium4);
        setRotationAngle(leaf2medium4, -2.8798F, 0.0087F, -0.733F);
        leaf2medium4.texOffs(35, 42).addBox(-2.1494F, -0.8614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium4.texOffs(29, 42).addBox(-2.1494F, -0.6614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium4.texOffs(23, 42).addBox(-1.9494F, -0.6614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium4.texOffs(42, 22).addBox(-1.9494F, -0.4614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium4.texOffs(42, 20).addBox(-1.7494F, -0.4614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium4.texOffs(42, 17).addBox(-2.1494F, -0.4614F, -0.1523F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium4.texOffs(17, 42).addBox(-1.7494F, -0.2614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium4.texOffs(42, 14).addBox(-1.9494F, -0.2614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium4.texOffs(42, 12).addBox(-2.1494F, -0.2614F, -0.1523F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium4.texOffs(42, 10).addBox(-2.1494F, -0.0614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium4.texOffs(42, 8).addBox(-1.9494F, -0.0614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium4.texOffs(7, 42).addBox(-2.1494F, 0.1386F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf2medium3 = new ModelRenderer(this);
        leaf2medium3.setPos(-2.4F, -6.5F, -1.05F);
        plant.addChild(leaf2medium3);
        setRotationAngle(leaf2medium3, 2.81F, 0.1134F, 0.7156F);
        leaf2medium3.texOffs(41, 44).addBox(1.1494F, -0.8614F, -1.3477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium3.texOffs(44, 39).addBox(1.1494F, -0.6614F, -1.1477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium3.texOffs(44, 37).addBox(0.9494F, -0.6614F, -1.3477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium3.texOffs(44, 35).addBox(0.9494F, -0.4614F, -1.1477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium3.texOffs(35, 44).addBox(0.7494F, -0.4614F, -1.3477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium3.texOffs(44, 33).addBox(1.1494F, -0.4614F, -0.9477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium3.texOffs(44, 31).addBox(0.7494F, -0.2614F, -1.3477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium3.texOffs(44, 29).addBox(0.9494F, -0.2614F, -1.1477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium3.texOffs(29, 44).addBox(1.1494F, -0.2614F, -0.9477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium3.texOffs(44, 27).addBox(1.1494F, -0.0614F, -1.1477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium3.texOffs(44, 25).addBox(0.9494F, -0.0614F, -1.3477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium3.texOffs(23, 44).addBox(1.1494F, 0.1386F, -1.3477F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf1medium3 = new ModelRenderer(this);
        leaf1medium3.setPos(10.1F, 1.95F, -4.25F);
        plant.addChild(leaf1medium3);
        setRotationAngle(leaf1medium3, -2.9671F, -1.1345F, 2.2078F);
        leaf1medium3.texOffs(10, 25).addBox(3.5F, -14.0F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium3.texOffs(4, 25).addBox(3.5F, -13.8F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium3.texOffs(0, 25).addBox(3.3F, -13.8F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium3.texOffs(23, 24).addBox(3.3F, -13.6F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium3.texOffs(17, 24).addBox(3.1F, -13.6F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium3.texOffs(24, 16).addBox(3.5F, -13.6F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium3.texOffs(24, 14).addBox(3.1F, -13.4F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium3.texOffs(24, 11).addBox(3.3F, -13.4F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium3.texOffs(7, 24).addBox(3.5F, -13.4F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium3.texOffs(24, 3).addBox(3.3F, -13.2F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium3.texOffs(24, 1).addBox(3.1F, -13.2F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium3.texOffs(23, 22).addBox(3.1F, -13.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf1small4 = new ModelRenderer(this);
        leaf1small4.setPos(2.05F, -1.15F, -5.75F);
        plant.addChild(leaf1small4);
        setRotationAngle(leaf1small4, -0.829F, 0.0F, -0.3927F);
        leaf1small4.texOffs(20, 31).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small4.texOffs(14, 31).addBox(-0.5F, -7.9F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small4.texOffs(10, 31).addBox(-0.4F, -7.9F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small4.texOffs(4, 31).addBox(-0.4F, -7.8F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small4.texOffs(0, 31).addBox(-0.3F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small4.texOffs(29, 30).addBox(-0.5F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small4.texOffs(23, 30).addBox(-0.3F, -7.6F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small4.texOffs(30, 18).addBox(-0.4F, -7.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small4.texOffs(17, 30).addBox(-0.3F, -7.7F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1small = new ModelRenderer(this);
        leaf1small.setPos(1.75F, -1.15F, -6.15F);
        plant.addChild(leaf1small);
        setRotationAngle(leaf1small, -0.829F, 0.0F, -0.3927F);
        leaf1small.texOffs(50, 29).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small.texOffs(29, 50).addBox(-0.5F, -7.9F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small.texOffs(50, 27).addBox(-0.4F, -7.9F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small.texOffs(23, 50).addBox(-0.4F, -7.8F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small.texOffs(17, 50).addBox(-0.3F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small.texOffs(7, 50).addBox(-0.5F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small.texOffs(50, 1).addBox(-0.3F, -7.6F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small.texOffs(44, 49).addBox(-0.4F, -7.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small.texOffs(38, 49).addBox(-0.3F, -7.7F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1small2 = new ModelRenderer(this);
        leaf1small2.setPos(1.05F, -1.15F, -5.95F);
        plant.addChild(leaf1small2);
        setRotationAngle(leaf1small2, -0.829F, 0.0F, -0.3927F);
        leaf1small2.texOffs(33, 9).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small2.texOffs(33, 7).addBox(-0.5F, -7.9F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small2.texOffs(4, 33).addBox(-0.4F, -7.9F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small2.texOffs(33, 0).addBox(-0.4F, -7.8F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small2.texOffs(0, 33).addBox(-0.3F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small2.texOffs(32, 31).addBox(-0.5F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small2.texOffs(32, 29).addBox(-0.3F, -7.6F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small2.texOffs(29, 32).addBox(-0.4F, -7.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small2.texOffs(32, 27).addBox(-0.3F, -7.7F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1small5 = new ModelRenderer(this);
        leaf1small5.setPos(1.95F, -1.15F, -6.05F);
        plant.addChild(leaf1small5);
        setRotationAngle(leaf1small5, -0.829F, 0.0F, -0.3927F);
        leaf1small5.texOffs(30, 16).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small5.texOffs(30, 13).addBox(-0.5F, -7.9F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small5.texOffs(30, 10).addBox(-0.4F, -7.9F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small5.texOffs(30, 8).addBox(-0.4F, -7.8F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small5.texOffs(7, 30).addBox(-0.3F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small5.texOffs(30, 1).addBox(-0.5F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small5.texOffs(29, 28).addBox(-0.3F, -7.6F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small5.texOffs(29, 26).addBox(-0.4F, -7.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small5.texOffs(26, 29).addBox(-0.3F, -7.7F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1small12 = new ModelRenderer(this);
        leaf1small12.setPos(2.05F, -1.15F, -5.95F);
        plant.addChild(leaf1small12);
        setRotationAngle(leaf1small12, -0.829F, 0.0F, -0.3927F);
        leaf1small12.texOffs(4, 17).addBox(-0.5F, -8.0F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small12.texOffs(0, 17).addBox(-0.5F, -7.9F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small12.texOffs(16, 8).addBox(-0.4F, -7.9F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small12.texOffs(7, 16).addBox(-0.4F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small12.texOffs(10, 15).addBox(-0.3F, -7.8F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small12.texOffs(15, 6).addBox(-0.5F, -7.8F, -0.8F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small12.texOffs(4, 15).addBox(-0.3F, -7.6F, -0.8F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small12.texOffs(15, 0).addBox(-0.4F, -7.7F, -0.8F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small12.texOffs(14, 11).addBox(-0.3F, -7.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1small3 = new ModelRenderer(this);
        leaf1small3.setPos(2.65F, -1.25F, -5.75F);
        plant.addChild(leaf1small3);
        setRotationAngle(leaf1small3, -0.829F, 0.0F, -0.3927F);
        leaf1small3.texOffs(32, 25).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small3.texOffs(32, 23).addBox(-0.5F, -7.9F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small3.texOffs(23, 32).addBox(-0.4F, -7.9F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small3.texOffs(32, 21).addBox(-0.4F, -7.8F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small3.texOffs(17, 32).addBox(-0.3F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small3.texOffs(7, 32).addBox(-0.5F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small3.texOffs(32, 5).addBox(-0.3F, -7.6F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small3.texOffs(32, 3).addBox(-0.4F, -7.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small3.texOffs(26, 31).addBox(-0.3F, -7.7F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1small6 = new ModelRenderer(this);
        leaf1small6.setPos(1.25F, -1.15F, -5.85F);
        plant.addChild(leaf1small6);
        setRotationAngle(leaf1small6, -0.829F, 0.0F, -0.3927F);
        leaf1small6.texOffs(29, 24).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small6.texOffs(29, 22).addBox(-0.5F, -7.9F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small6.texOffs(29, 20).addBox(-0.4F, -7.9F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small6.texOffs(20, 29).addBox(-0.4F, -7.8F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small6.texOffs(14, 29).addBox(-0.3F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small6.texOffs(10, 29).addBox(-0.5F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small6.texOffs(29, 6).addBox(-0.3F, -7.6F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small6.texOffs(29, 4).addBox(-0.4F, -7.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small6.texOffs(4, 29).addBox(-0.3F, -7.7F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1small7 = new ModelRenderer(this);
        leaf1small7.setPos(-2.35F, -1.25F, -5.65F);
        plant.addChild(leaf1small7);
        setRotationAngle(leaf1small7, -0.829F, 0.0F, 0.3927F);
        leaf1small7.texOffs(0, 29).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small7.texOffs(23, 28).addBox(-0.5F, -7.9F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small7.texOffs(17, 28).addBox(-0.6F, -7.9F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small7.texOffs(7, 28).addBox(-0.6F, -7.8F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small7.texOffs(26, 27).addBox(-0.7F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small7.texOffs(20, 27).addBox(-0.5F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small7.texOffs(27, 17).addBox(-0.7F, -7.6F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small7.texOffs(27, 15).addBox(-0.6F, -7.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small7.texOffs(14, 27).addBox(-0.7F, -7.7F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1small10 = new ModelRenderer(this);
        leaf1small10.setPos(-2.05F, -1.15F, -5.65F);
        plant.addChild(leaf1small10);
        setRotationAngle(leaf1small10, -0.829F, 0.0F, 0.3927F);
        leaf1small10.texOffs(20, 11).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small10.texOffs(20, 8).addBox(-0.5F, -7.9F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small10.texOffs(7, 20).addBox(-0.6F, -7.9F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small10.texOffs(14, 19).addBox(-0.6F, -7.8F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small10.texOffs(10, 19).addBox(-0.7F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small10.texOffs(19, 6).addBox(-0.5F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small10.texOffs(4, 19).addBox(-0.7F, -7.6F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small10.texOffs(0, 19).addBox(-0.6F, -7.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small10.texOffs(17, 18).addBox(-0.7F, -7.7F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1small11 = new ModelRenderer(this);
        leaf1small11.setPos(-1.95F, -1.25F, -5.35F);
        plant.addChild(leaf1small11);
        setRotationAngle(leaf1small11, -0.829F, 0.0F, 0.3927F);
        leaf1small11.texOffs(18, 14).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small11.texOffs(7, 18).addBox(-0.5F, -7.9F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small11.texOffs(18, 3).addBox(-0.6F, -7.9F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small11.texOffs(18, 1).addBox(-0.6F, -7.8F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small11.texOffs(17, 16).addBox(-0.7F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small11.texOffs(14, 17).addBox(-0.5F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small11.texOffs(17, 12).addBox(-0.7F, -7.6F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small11.texOffs(17, 10).addBox(-0.6F, -7.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small11.texOffs(10, 17).addBox(-0.7F, -7.7F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1small8 = new ModelRenderer(this);
        leaf1small8.setPos(2.35F, -1.25F, -5.45F);
        plant.addChild(leaf1small8);
        setRotationAngle(leaf1small8, -0.829F, 0.0F, -0.3927F);
        leaf1small8.texOffs(27, 12).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small8.texOffs(10, 27).addBox(-0.5F, -7.9F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small8.texOffs(27, 9).addBox(-0.4F, -7.9F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small8.texOffs(4, 27).addBox(-0.4F, -7.8F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small8.texOffs(27, 2).addBox(-0.3F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small8.texOffs(27, 0).addBox(-0.5F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small8.texOffs(0, 27).addBox(-0.3F, -7.6F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small8.texOffs(26, 25).addBox(-0.4F, -7.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small8.texOffs(26, 23).addBox(-0.3F, -7.7F, -0.6F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1small9 = new ModelRenderer(this);
        leaf1small9.setPos(2.55F, -1.15F, 5.55F);
        plant.addChild(leaf1small9);
        setRotationAngle(leaf1small9, 0.829F, 0.0F, -0.3927F);
        leaf1small9.texOffs(23, 26).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small9.texOffs(26, 21).addBox(-0.5F, -7.9F, -0.4F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small9.texOffs(26, 19).addBox(-0.4F, -7.9F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small9.texOffs(17, 26).addBox(-0.4F, -7.8F, -0.4F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small9.texOffs(26, 7).addBox(-0.3F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small9.texOffs(7, 26).addBox(-0.5F, -7.8F, -0.3F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small9.texOffs(26, 5).addBox(-0.3F, -7.6F, -0.3F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small9.texOffs(20, 25).addBox(-0.4F, -7.7F, -0.3F, 1.0F, 1.0F, 1.0F, -0.45F, false);
        leaf1small9.texOffs(14, 25).addBox(-0.3F, -7.7F, -0.4F, 1.0F, 1.0F, 1.0F, -0.45F, false);

        leaf1medium = new ModelRenderer(this);
        leaf1medium.setPos(4.4F, -4.35F, -6.45F);
        plant.addChild(leaf1medium);
        setRotationAngle(leaf1medium, -1.8326F, -0.5585F, 0.829F);
        leaf1medium.texOffs(50, 47).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium.texOffs(47, 50).addBox(-0.5F, -7.8F, -0.7F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium.texOffs(50, 45).addBox(-0.7F, -7.8F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium.texOffs(50, 43).addBox(-0.7F, -7.6F, -0.7F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium.texOffs(50, 41).addBox(-0.9F, -7.6F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium.texOffs(41, 50).addBox(-0.5F, -7.6F, -0.9F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium.texOffs(50, 39).addBox(-0.9F, -7.4F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium.texOffs(50, 37).addBox(-0.7F, -7.4F, -0.7F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium.texOffs(50, 35).addBox(-0.5F, -7.4F, -0.9F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium.texOffs(35, 50).addBox(-0.7F, -7.2F, -0.9F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium.texOffs(50, 33).addBox(-0.9F, -7.2F, -0.7F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium.texOffs(50, 31).addBox(-0.9F, -7.0F, -0.9F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf1medium2 = new ModelRenderer(this);
        leaf1medium2.setPos(9.1F, 1.85F, -4.25F);
        plant.addChild(leaf1medium2);
        setRotationAngle(leaf1medium2, -2.9671F, -1.1345F, 2.2078F);
        leaf1medium2.texOffs(23, 34).addBox(3.5F, -14.0F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium2.texOffs(17, 34).addBox(3.5F, -13.8F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium2.texOffs(7, 34).addBox(3.3F, -13.8F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium2.texOffs(32, 33).addBox(3.3F, -13.6F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium2.texOffs(26, 33).addBox(3.1F, -13.6F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium2.texOffs(20, 33).addBox(3.5F, -13.6F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium2.texOffs(33, 19).addBox(3.1F, -13.4F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium2.texOffs(33, 17).addBox(3.3F, -13.4F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium2.texOffs(33, 14).addBox(3.5F, -13.4F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium2.texOffs(14, 33).addBox(3.3F, -13.2F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium2.texOffs(33, 11).addBox(3.1F, -13.2F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium2.texOffs(10, 33).addBox(3.1F, -13.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf1medium4 = new ModelRenderer(this);
        leaf1medium4.setPos(10.7F, 2.05F, -4.25F);
        plant.addChild(leaf1medium4);
        setRotationAngle(leaf1medium4, -2.9671F, -1.1345F, 2.2078F);
        leaf1medium4.texOffs(23, 20).addBox(3.5F, -14.0F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium4.texOffs(20, 23).addBox(3.5F, -13.8F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium4.texOffs(23, 18).addBox(3.3F, -13.8F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium4.texOffs(14, 23).addBox(3.3F, -13.6F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium4.texOffs(10, 23).addBox(3.1F, -13.6F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium4.texOffs(23, 9).addBox(3.5F, -13.6F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium4.texOffs(23, 6).addBox(3.1F, -13.4F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium4.texOffs(4, 23).addBox(3.3F, -13.4F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium4.texOffs(0, 23).addBox(3.5F, -13.4F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium4.texOffs(17, 22).addBox(3.3F, -13.2F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium4.texOffs(7, 22).addBox(3.1F, -13.2F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium4.texOffs(20, 21).addBox(3.1F, -13.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf1medium5 = new ModelRenderer(this);
        leaf1medium5.setPos(10.0F, 2.05F, -3.85F);
        plant.addChild(leaf1medium5);
        setRotationAngle(leaf1medium5, -2.9671F, -1.1345F, 2.2078F);
        leaf1medium5.texOffs(21, 15).addBox(3.5F, -14.0F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium5.texOffs(14, 21).addBox(3.5F, -13.8F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium5.texOffs(21, 13).addBox(3.3F, -13.8F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium5.texOffs(10, 21).addBox(3.3F, -13.6F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium5.texOffs(21, 4).addBox(3.1F, -13.6F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium5.texOffs(4, 21).addBox(3.5F, -13.6F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium5.texOffs(21, 2).addBox(3.1F, -13.4F, -0.1F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium5.texOffs(21, 0).addBox(3.3F, -13.4F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium5.texOffs(0, 21).addBox(3.5F, -13.4F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium5.texOffs(20, 19).addBox(3.3F, -13.2F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium5.texOffs(20, 17).addBox(3.1F, -13.2F, -0.3F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf1medium5.texOffs(17, 20).addBox(3.1F, -13.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf2medium = new ModelRenderer(this);
        leaf2medium.setPos(-2.6F, -9.8F, 3.55F);
        plant.addChild(leaf2medium);
        setRotationAngle(leaf2medium, 1.2566F, -0.637F, 1.1345F);
        leaf2medium.texOffs(32, 49).addBox(1.1494F, -7.8614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium.texOffs(26, 49).addBox(1.1494F, -7.6614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium.texOffs(20, 49).addBox(0.9494F, -7.6614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium.texOffs(14, 49).addBox(0.9494F, -7.4614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium.texOffs(10, 49).addBox(0.7494F, -7.4614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium.texOffs(4, 49).addBox(1.1494F, -7.4614F, -0.8477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium.texOffs(0, 49).addBox(0.7494F, -7.2614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium.texOffs(47, 48).addBox(0.9494F, -7.2614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium.texOffs(41, 48).addBox(1.1494F, -7.2614F, -0.8477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium.texOffs(35, 48).addBox(1.1494F, -7.0614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium.texOffs(29, 48).addBox(0.9494F, -7.0614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium.texOffs(48, 24).addBox(1.1494F, -6.8614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf2medium8 = new ModelRenderer(this);
        leaf2medium8.setPos(-3.1F, -9.8F, 3.25F);
        plant.addChild(leaf2medium8);
        setRotationAngle(leaf2medium8, 1.2566F, -0.637F, 1.1345F);
        leaf2medium8.texOffs(38, 27).addBox(1.1494F, -7.8614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium8.texOffs(38, 25).addBox(1.1494F, -7.6614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium8.texOffs(38, 23).addBox(0.9494F, -7.6614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium8.texOffs(23, 38).addBox(0.9494F, -7.4614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium8.texOffs(17, 38).addBox(0.7494F, -7.4614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium8.texOffs(7, 38).addBox(1.1494F, -7.4614F, -0.8477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium8.texOffs(38, 3).addBox(0.7494F, -7.2614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium8.texOffs(32, 37).addBox(0.9494F, -7.2614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium8.texOffs(26, 37).addBox(1.1494F, -7.2614F, -0.8477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium8.texOffs(20, 37).addBox(1.1494F, -7.0614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium8.texOffs(14, 37).addBox(0.9494F, -7.0614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium8.texOffs(10, 37).addBox(1.1494F, -6.8614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf2medium7 = new ModelRenderer(this);
        leaf2medium7.setPos(-1.95F, -11.9F, 0.05F);
        plant.addChild(leaf2medium7);
        setRotationAngle(leaf2medium7, 0.9076F, -1.2479F, 1.6581F);
        leaf2medium7.texOffs(39, 9).addBox(1.1494F, -7.8614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium7.texOffs(39, 7).addBox(1.1494F, -7.6614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium7.texOffs(39, 5).addBox(0.9494F, -7.6614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium7.texOffs(4, 39).addBox(0.9494F, -7.4614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium7.texOffs(0, 39).addBox(0.7494F, -7.4614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium7.texOffs(38, 37).addBox(1.1494F, -7.4614F, -0.8477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium7.texOffs(38, 35).addBox(0.7494F, -7.2614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium7.texOffs(35, 38).addBox(0.9494F, -7.2614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium7.texOffs(38, 33).addBox(1.1494F, -7.2614F, -0.8477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium7.texOffs(38, 31).addBox(1.1494F, -7.0614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium7.texOffs(38, 29).addBox(0.9494F, -7.0614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium7.texOffs(29, 38).addBox(1.1494F, -6.8614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf2medium2 = new ModelRenderer(this);
        leaf2medium2.setPos(2.6F, -9.8F, -3.55F);
        plant.addChild(leaf2medium2);
        setRotationAngle(leaf2medium2, -1.2566F, -0.637F, -1.1345F);
        leaf2medium2.texOffs(14, 45).addBox(-2.1494F, -7.8614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium2.texOffs(45, 13).addBox(-2.1494F, -7.6614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium2.texOffs(45, 11).addBox(-1.9494F, -7.6614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium2.texOffs(10, 45).addBox(-1.9494F, -7.4614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium2.texOffs(45, 9).addBox(-1.7494F, -7.4614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium2.texOffs(45, 7).addBox(-2.1494F, -7.4614F, -0.1523F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium2.texOffs(45, 4).addBox(-1.7494F, -7.2614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium2.texOffs(4, 45).addBox(-1.9494F, -7.2614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium2.texOffs(45, 2).addBox(-2.1494F, -7.2614F, -0.1523F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium2.texOffs(0, 45).addBox(-2.1494F, -7.0614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium2.texOffs(44, 43).addBox(-1.9494F, -7.0614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium2.texOffs(44, 41).addBox(-2.1494F, -6.8614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf2medium5 = new ModelRenderer(this);
        leaf2medium5.setPos(2.5F, -9.9F, 3.55F);
        plant.addChild(leaf2medium5);
        setRotationAngle(leaf2medium5, 1.2741F, 0.651F, -1.1519F);
        leaf2medium5.texOffs(17, 44).addBox(-2.1494F, -7.8614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium5.texOffs(7, 44).addBox(-2.1494F, -7.6614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium5.texOffs(38, 43).addBox(-1.9494F, -7.6614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium5.texOffs(32, 43).addBox(-1.9494F, -7.4614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium5.texOffs(26, 43).addBox(-1.7494F, -7.4614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium5.texOffs(20, 43).addBox(-2.1494F, -7.4614F, -0.8477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium5.texOffs(14, 43).addBox(-1.7494F, -7.2614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium5.texOffs(10, 43).addBox(-1.9494F, -7.2614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium5.texOffs(4, 43).addBox(-2.1494F, -7.2614F, -0.8477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium5.texOffs(43, 0).addBox(-2.1494F, -7.0614F, -1.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium5.texOffs(0, 43).addBox(-1.9494F, -7.0614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium5.texOffs(41, 42).addBox(-2.1494F, -6.8614F, -1.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf2medium6 = new ModelRenderer(this);
        leaf2medium6.setPos(-2.5F, -9.7F, -3.55F);
        plant.addChild(leaf2medium6);
        setRotationAngle(leaf2medium6, -1.2566F, 0.637F, 1.1694F);
        leaf2medium6.texOffs(42, 6).addBox(1.1494F, -7.8614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium6.texOffs(42, 3).addBox(1.1494F, -7.6614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium6.texOffs(41, 40).addBox(0.9494F, -7.6614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium6.texOffs(41, 38).addBox(0.9494F, -7.4614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium6.texOffs(38, 41).addBox(0.7494F, -7.4614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium6.texOffs(41, 36).addBox(1.1494F, -7.4614F, -0.1523F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium6.texOffs(41, 34).addBox(0.7494F, -7.2614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium6.texOffs(41, 32).addBox(0.9494F, -7.2614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium6.texOffs(32, 41).addBox(1.1494F, -7.2614F, -0.1523F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium6.texOffs(41, 30).addBox(1.1494F, -7.0614F, 0.0477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium6.texOffs(41, 28).addBox(0.9494F, -7.0614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        leaf2medium6.texOffs(41, 26).addBox(1.1494F, -6.8614F, 0.2477F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        leaf2big = new ModelRenderer(this);
        leaf2big.setPos(-1.1F, -5.4F, -1.05F);
        plant.addChild(leaf2big);
        setRotationAngle(leaf2big, 0.0F, 0.6632F, 0.9425F);
        leaf2big.texOffs(23, 48).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big.texOffs(48, 22).addBox(-1.3F, -0.7F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big.texOffs(48, 19).addBox(-1.0F, -0.7F, -0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big.texOffs(17, 48).addBox(-1.3F, -0.4F, -0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big.texOffs(48, 10).addBox(-1.3F, -0.1F, -0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big.texOffs(48, 16).addBox(-1.0F, -0.4F, -0.6F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big.texOffs(48, 8).addBox(-1.0F, -0.1F, -0.6F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big.texOffs(48, 14).addBox(-1.6F, -0.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big.texOffs(48, 12).addBox(-1.6F, -0.1F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big.texOffs(7, 48).addBox(-1.3F, 0.2F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big.texOffs(48, 5).addBox(-1.0F, 0.2F, -0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big.texOffs(48, 3).addBox(-1.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);

        leaf2big2 = new ModelRenderer(this);
        leaf2big2.setPos(-0.25F, -5.1F, -0.5F);
        plant.addChild(leaf2big2);
        setRotationAngle(leaf2big2, -0.9687F, -0.5672F, 0.4189F);
        leaf2big2.texOffs(47, 46).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big2.texOffs(47, 44).addBox(-1.3F, -0.7F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big2.texOffs(44, 47).addBox(-1.0F, -0.7F, -1.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big2.texOffs(47, 42).addBox(-1.3F, -0.4F, -1.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big2.texOffs(47, 40).addBox(-1.3F, -0.1F, -1.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big2.texOffs(47, 38).addBox(-1.0F, -0.4F, -1.6F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big2.texOffs(38, 47).addBox(-1.0F, -0.1F, -1.6F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big2.texOffs(47, 36).addBox(-1.6F, -0.4F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big2.texOffs(47, 34).addBox(-1.6F, -0.1F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big2.texOffs(47, 32).addBox(-1.3F, 0.2F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big2.texOffs(32, 47).addBox(-1.0F, 0.2F, -1.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big2.texOffs(47, 30).addBox(-1.0F, 0.5F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);

        leaf2big3 = new ModelRenderer(this);
        leaf2big3.setPos(-0.05F, -5.1F, 0.5F);
        plant.addChild(leaf2big3);
        setRotationAngle(leaf2big3, 0.9687F, 0.1309F, -0.4538F);
        leaf2big3.texOffs(47, 28).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big3.texOffs(47, 26).addBox(0.3F, -0.7F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big3.texOffs(26, 47).addBox(0.0F, -0.7F, 0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big3.texOffs(20, 47).addBox(0.3F, -0.4F, 0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big3.texOffs(14, 47).addBox(0.3F, -0.1F, 0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big3.texOffs(10, 47).addBox(0.0F, -0.4F, 0.6F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big3.texOffs(4, 47).addBox(0.0F, -0.1F, 0.6F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big3.texOffs(47, 0).addBox(0.6F, -0.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big3.texOffs(0, 47).addBox(0.6F, -0.1F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big3.texOffs(41, 46).addBox(0.3F, 0.2F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big3.texOffs(35, 46).addBox(0.0F, 0.2F, 0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big3.texOffs(29, 46).addBox(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);

        leaf2big4 = new ModelRenderer(this);
        leaf2big4.setPos(1.1F, -5.4F, 1.05F);
        plant.addChild(leaf2big4);
        setRotationAngle(leaf2big4, -0.1571F, 0.5585F, -0.9425F);
        leaf2big4.texOffs(23, 46).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big4.texOffs(17, 46).addBox(0.3F, -0.7F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big4.texOffs(7, 46).addBox(0.0F, -0.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big4.texOffs(44, 45).addBox(0.3F, -0.4F, -0.7F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big4.texOffs(38, 45).addBox(0.3F, -0.1F, -0.7F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big4.texOffs(32, 45).addBox(0.0F, -0.4F, -0.4F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big4.texOffs(26, 45).addBox(0.0F, -0.1F, -0.4F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big4.texOffs(45, 23).addBox(0.6F, -0.4F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big4.texOffs(45, 21).addBox(0.6F, -0.1F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big4.texOffs(20, 45).addBox(0.3F, 0.2F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big4.texOffs(45, 18).addBox(0.0F, 0.2F, -0.7F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big4.texOffs(45, 15).addBox(0.0F, 0.5F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);

        leaf2big5 = new ModelRenderer(this);
        leaf2big5.setPos(-1.1F, -5.4F, 1.05F);
        plant.addChild(leaf2big5);
        setRotationAngle(leaf2big5, 0.0F, -0.6632F, 0.9425F);
        leaf2big5.texOffs(26, 41).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big5.texOffs(41, 24).addBox(-1.3F, -0.7F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big5.texOffs(20, 41).addBox(-1.0F, -0.7F, -0.7F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big5.texOffs(14, 41).addBox(-1.3F, -0.4F, -0.7F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big5.texOffs(10, 41).addBox(-1.3F, -0.1F, -0.7F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big5.texOffs(4, 41).addBox(-1.0F, -0.4F, -0.4F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big5.texOffs(0, 41).addBox(-1.0F, -0.1F, -0.4F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big5.texOffs(35, 40).addBox(-1.6F, -0.4F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big5.texOffs(29, 40).addBox(-1.6F, -0.1F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big5.texOffs(23, 40).addBox(-1.3F, 0.2F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big5.texOffs(17, 40).addBox(-1.0F, 0.2F, -0.7F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big5.texOffs(7, 40).addBox(-1.0F, 0.5F, -1.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);

        leaf2big6 = new ModelRenderer(this);
        leaf2big6.setPos(-0.25F, -5.0F, 0.5F);
        plant.addChild(leaf2big6);
        setRotationAngle(leaf2big6, 1.0036F, 0.5149F, 0.5061F);
        leaf2big6.texOffs(40, 1).addBox(-1.0F, -1.1F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big6.texOffs(38, 39).addBox(-1.3F, -0.8F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big6.texOffs(32, 39).addBox(-1.0F, -0.8F, 0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big6.texOffs(26, 39).addBox(-1.3F, -0.5F, 0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big6.texOffs(39, 21).addBox(-1.3F, -0.2F, 0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big6.texOffs(20, 39).addBox(-1.0F, -0.5F, 0.6F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big6.texOffs(39, 19).addBox(-1.0F, -0.2F, 0.6F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big6.texOffs(39, 16).addBox(-1.6F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big6.texOffs(14, 39).addBox(-1.6F, -0.2F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big6.texOffs(39, 13).addBox(-1.3F, 0.1F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big6.texOffs(39, 11).addBox(-1.0F, 0.1F, 0.3F, 1.0F, 1.0F, 1.0F, -0.35F, false);
        leaf2big6.texOffs(10, 39).addBox(-1.0F, 0.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.35F, false);

        flower3 = new ModelRenderer(this);
        flower3.setPos(7.2F, 1.6F, -0.5F);
        plant.addChild(flower3);
        flower3.texOffs(12, 8).addBox(-7.0F, -8.0F, 0.0F, 1.0F, 2.0F, 1.0F, -0.4F, false);
        flower3.texOffs(35, 32).addBox(-6.8F, -8.2F, 0.0F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower3.texOffs(32, 35).addBox(-7.2F, -8.2F, 0.0F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower3.texOffs(35, 30).addBox(-7.0F, -8.2F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower3.texOffs(35, 28).addBox(-6.8F, -8.4F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower3.texOffs(35, 26).addBox(-7.2F, -8.4F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower3.texOffs(26, 35).addBox(-7.0F, -8.2F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower3.texOffs(35, 24).addBox(-6.8F, -8.4F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower3.texOffs(35, 22).addBox(-7.2F, -8.4F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);

        flower4 = new ModelRenderer(this);
        flower4.setPos(6.7F, 1.3F, 0.2F);
        plant.addChild(flower4);
        flower4.texOffs(8, 10).addBox(-7.0F, -8.0F, 0.0F, 1.0F, 2.0F, 1.0F, -0.4F, false);
        flower4.texOffs(20, 35).addBox(-6.8F, -8.2F, 0.0F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower4.texOffs(14, 35).addBox(-7.2F, -8.2F, 0.0F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower4.texOffs(10, 35).addBox(-7.0F, -8.2F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower4.texOffs(35, 4).addBox(-6.8F, -8.4F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower4.texOffs(4, 35).addBox(-7.2F, -8.4F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower4.texOffs(35, 2).addBox(-7.0F, -8.2F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower4.texOffs(0, 35).addBox(-6.8F, -8.4F, 0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
        flower4.texOffs(29, 34).addBox(-7.2F, -8.4F, -0.2F, 1.0F, 1.0F, 1.0F, -0.4F, false);
    }

    @Override
    public void setupAnim(MandrakeEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        mandrake.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }
}