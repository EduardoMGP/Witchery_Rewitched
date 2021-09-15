package com.hero.witchery_rewitched.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class FumeFunnelBlock extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    private static final VoxelShape WEST_SHAPE = Block.box(8.0D,0.0D,10.0D,13.0D,16.0D,13.0D);

    private static final VoxelShape NORTH_SHAPE = Block.box(3.0D,0.0D,8.0D,8.0D,16.0D,13.0D);

    private static final VoxelShape SOUTH_SHAPE = Block.box(8.0D,0.0D,3.0D,13.0D,16.0D,8.0D);

    private static final VoxelShape EAST_SHAPE = Block.box(3.0D,0.0D,3.0D,8.0D,16.0D,8.0D);
    public FumeFunnelBlock() {
        super(AbstractBlock.Properties.of(Material.METAL));
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch((Direction)state.getValue(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
        }
        return NORTH_SHAPE;
    }

    public VoxelShape getInteractionShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        switch((Direction)state.getValue(FACING)) {
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
            default:
                return NORTH_SHAPE;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
