package com.hero.witchery_rewitched.block.glyph;

import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class InfernalGlyphBlock extends GlyphBlock{

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double posX = pos.getX() + (rand.nextFloat() -.5 )* .8 + .5;
        double posY = pos.getY() + .2;
        double posZ = pos.getZ() + (rand.nextFloat() -.5 )* .8 + .5;
        if(rand.nextInt(2) < 1)
            worldIn.addParticle(ParticleTypes.FLAME, posX, posY, posZ, 0, 0, 0);
        super.animateTick(stateIn, worldIn, pos, rand);
    }
}
