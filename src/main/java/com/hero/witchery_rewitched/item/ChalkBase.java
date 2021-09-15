package com.hero.witchery_rewitched.item;

import com.hero.witchery_rewitched.block.glyph.GlyphBlock;
import com.hero.witchery_rewitched.block.glyph.GoldGlyphBlock;
import com.hero.witchery_rewitched.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

import javax.swing.*;

import net.minecraft.item.Item.Properties;

public class ChalkBase extends Item {
    final RegistryObject<Block> block;
    public ChalkBase(Properties properties, RegistryObject<Block> block) {
        super(properties.stacksTo(1).durability(50));
        this.block = block;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return super.getDurabilityForDisplay(stack);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        if(world.isClientSide)
            return ActionResultType.SUCCESS;
        BlockPos pos = context.getClickedPos();
        ItemStack stack = context.getPlayer() != null ? context.getPlayer().getItemInHand(context.getHand()).getStack() : null;
        Direction[] dirs = {Direction.NORTH, Direction.EAST, Direction.WEST, Direction.SOUTH};
        if(world.getBlockState(pos) == Blocks.AIR.defaultBlockState() || world.getBlockState(pos).getBlock() instanceof GlyphBlock) {
            if(block.get() != ModBlocks.GOLD_GLYPH.get())
                world.setBlockAndUpdate(pos, block.get().defaultBlockState().setValue(GlyphBlock.VARIANT, world.random.nextInt(9)).setValue(GlyphBlock.DIRECTION, dirs[world.random.nextInt(4)]));
            else
                world.setBlockAndUpdate(pos, block.get().defaultBlockState().setValue(GlyphBlock.DIRECTION, dirs[world.random.nextInt(4)]));
            if(stack != null)
                stack.hurtAndBreak(1, context.getPlayer(), (entity) -> {
                    entity.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                });
        }
        else if(world.getBlockState(pos.offset(0,1,0)).getBlock() == Blocks.AIR && world.getBlockState(pos).canOcclude()) {
            if(block.get() != ModBlocks.GOLD_GLYPH.get())
                world.setBlockAndUpdate(pos.offset(0, 1, 0), block.get().defaultBlockState().setValue(GlyphBlock.VARIANT, world.random.nextInt(9)).setValue(GlyphBlock.DIRECTION, dirs[world.random.nextInt(4)]));
            else
                world.setBlockAndUpdate(pos.offset(0, 1, 0), block.get().defaultBlockState().setValue(GlyphBlock.DIRECTION, dirs[world.random.nextInt(4)]));
            if(stack != null)
                stack.hurtAndBreak(1, context.getPlayer(), (entity) -> {
                    entity.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                });
        }
        return super.useOn(context);
    }
}
