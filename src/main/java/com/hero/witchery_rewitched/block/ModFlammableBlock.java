package com.hero.witchery_rewitched.block;

import com.google.common.collect.ImmutableMap;
import com.hero.witchery_rewitched.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.Map;

public class ModFlammableBlock{

    public static class ModLeaves extends LeavesBlock {
        private final int fireChance;

        public ModLeaves(int flammability) {
            super(AbstractBlock.Properties
                    .of(Material.LEAVES)
                    .strength(.2f)
                    .sound(SoundType.CROP)
                    .harvestLevel(0)
                    .noOcclusion());
            this.fireChance = flammability;
        }




        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return fireChance;
        }

        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }
    }

    public static class ModLog extends RotatedPillarBlock {

        private final int fireChance = 5;

        public ModLog() {
            super(AbstractBlock.Properties
                    .of(Material.WOOD)
                    .harvestTool(ToolType.AXE)
                    .strength(1)
                    .sound(SoundType.WOOD)
                    .harvestLevel(0));
        }

        @Nullable
        @Override
        public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType) {
            Map<RotatedPillarBlock, RotatedPillarBlock> STRIPABLES = (new ImmutableMap.Builder<RotatedPillarBlock, RotatedPillarBlock>()).put(ModBlocks.ALDER_LOG.get(), ModBlocks.STRIPPED_ALDER_LOG.get()).put(ModBlocks.ROWAN_LOG.get(), ModBlocks.STRIPPED_ROWAN_LOG.get()).put(ModBlocks.HAWTHORN_LOG.get(), ModBlocks.STRIPPED_HAWTHORN_LOG.get()).build();
            if(ToolType.AXE == toolType)
            {
                Block block = STRIPABLES.get(state.getBlock());
                return block != null ? block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)) : null;
            }
            return null;
        }

        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return fireChance; }

        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }

    }

    public static class PlankBlock extends Block{
        private final int fireChance;

        public PlankBlock(int flammability) {
            super(AbstractBlock.Properties
                    .of(Material.WOOD)
                    .harvestTool(ToolType.AXE)
                    .strength(1)
                    .sound(SoundType.WOOD)
                    .harvestLevel(0));
            this.fireChance = flammability;
        }

        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return fireChance;
        }


    }

}