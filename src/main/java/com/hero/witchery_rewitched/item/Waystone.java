package com.hero.witchery_rewitched.item;

import com.hero.witchery_rewitched.init.ModBlocks;
import com.hero.witchery_rewitched.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraft.item.Item.Properties;

public class Waystone extends Item {
    public Waystone(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        BlockPos pos = entity.blockPosition();
        World worldIn = entity.getCommandSenderWorld();
        if(isGlyph(pos.offset(-1,0,-1), worldIn)
                && isGlyph(pos.offset(0,0,-1), worldIn)
                && isGlyph(pos.offset(-1,0,0), worldIn)
                && isGlyph(pos.offset(1,0,0), worldIn)
                && isGlyph(pos.offset(0,0,1), worldIn)
                && isGlyph(pos.offset(1,0,1),worldIn)
                && isGlyph(pos.offset(-1,0,1), worldIn)
                && isGlyph(pos.offset(1,0,-1), worldIn)){
            int count = stack.getCount();
            if (count > 8) {
                stack.setCount(stack.getCount() - 8);
            } else {
                stack.setCount(0);
            }
            InventoryHelper.dropItemStack(worldIn,pos.getX(), pos.getY(), pos.getZ(), BoundWaystone.updateStackWithPos(new ItemStack(ModItems.BOUND_WAYSTONE.get(), Math.min(count, 8)), pos, entity.getCommandSenderWorld().dimension().location().toString()));
            worldIn.setBlockAndUpdate(pos.offset(-1,0,-1), Blocks.AIR.defaultBlockState());
            worldIn.setBlockAndUpdate(pos.offset(0,0,-1), Blocks.AIR.defaultBlockState());
            worldIn.setBlockAndUpdate(pos.offset(-1,0,0), Blocks.AIR.defaultBlockState());
            worldIn.setBlockAndUpdate(pos.offset(1,0,-1), Blocks.AIR.defaultBlockState());
            worldIn.setBlockAndUpdate(pos.offset(-1,0,1), Blocks.AIR.defaultBlockState());
            worldIn.setBlockAndUpdate(pos.offset(1,0,0), Blocks.AIR.defaultBlockState());
            worldIn.setBlockAndUpdate(pos.offset(0,0,1), Blocks.AIR.defaultBlockState());
            worldIn.setBlockAndUpdate(pos.offset(1,0,1), Blocks.AIR.defaultBlockState());
            worldIn.playSound(null, pos, SoundEvents.GENERIC_EXPLODE, SoundCategory.NEUTRAL, 1, .5f);
            worldIn.addParticle(ParticleTypes.EXPLOSION, pos.getX(), pos.getY(), pos.getZ(), 0, 0, 0);
        }
        return super.onEntityItemUpdate(stack, entity);
    }

    private boolean isGlyph(BlockPos pos, World world){
        return world.getBlockState(pos).getBlock() == ModBlocks.OTHERWHERE_GLYPH.get();
    }
}
