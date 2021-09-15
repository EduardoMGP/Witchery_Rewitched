package com.hero.witchery_rewitched.block.glyph;

import com.hero.witchery_rewitched.init.ModBlocks;
import com.hero.witchery_rewitched.init.ModItems;
import com.hero.witchery_rewitched.item.BoundWaystone;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class OtherewhereGlyphBlock extends  GlyphBlock{
    public OtherewhereGlyphBlock(){
        super();
    }
    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double posX = pos.getX() + (rand.nextFloat() -.5 )* .8 + .5;
        double posY = pos.getY() + .2;
        double posZ = pos.getZ() + (rand.nextFloat() -.5 )* .8 + .5;
        if(rand.nextInt(2) < 1)
            worldIn.addParticle(ParticleTypes.REVERSE_PORTAL, posX, posY, posZ, 0, .01, 0);
        super.animateTick(stateIn, worldIn, pos, rand);
    }

}
