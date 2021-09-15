package com.hero.witchery_rewitched.block.witch_oven;

import com.hero.witchery_rewitched.init.ModContainerBlock;
import com.hero.witchery_rewitched.block.INamedContainerExtraData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.function.BiFunction;

import net.minecraft.block.AbstractBlock.Properties;

public class WitchOvenBlock extends ModContainerBlock<WitchOvenTileEntity> {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    private static final VoxelShape BOTTOM_SHAPE = Block.box(1.0D,0.0D,1.0D, 15.0D, 3.0D, 15.0D);
    private static final VoxelShape MIDDLE_SHAPE= Block.box(2.0D,3.0D,2.0D, 14.0D, 10.0D, 14.0D);
    private static final VoxelShape BODY_SHAPE = VoxelShapes.or(MIDDLE_SHAPE, BOTTOM_SHAPE);

    private static final VoxelShape WEST_SHAPE = VoxelShapes.or(Block.box(9.0D,0.0D,9.0D,13.0D,16.0D,13.0D), BODY_SHAPE);
    private static final VoxelShape WEST_RAYTRACE_SHAPE = VoxelShapes.or(Block.box(9.0D,0.0D,9.0D,13.0D,16.0D,13.0D), BODY_SHAPE);
    private static final VoxelShape NORTH_SHAPE = VoxelShapes.or(Block.box(3.0D,0.0D,9.0D,7.0D,16.0D,13.0D), BODY_SHAPE);
    private static final VoxelShape NORTH_RAYTRACE_SHAPE = VoxelShapes.or(Block.box(3.0D,0.0D,9.0D,7.0D,16.0D,13.0D), BODY_SHAPE);
    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.or(Block.box(9.0D,0.0D,3.0D,13.0D,16.0D,7.0D), BODY_SHAPE);
    private static final VoxelShape SOUTH_RAYTRACE_SHAPE = VoxelShapes.or(Block.box(9.0D,0.0D,3.0D,13.0D,16.0D,7.0D), BODY_SHAPE);
    private static final VoxelShape EAST_SHAPE = VoxelShapes.or(Block.box(3.0D,0.0D,3.0D,7.0D,16.0D,7.0D), BODY_SHAPE);
    private static final VoxelShape EAST_RAYTRACE_SHAPE = VoxelShapes.or(Block.box(3.0D,0.0D,3.0D,7.0D,16.0D,7.0D), BODY_SHAPE);

    public WitchOvenBlock(BiFunction<BlockState, IBlockReader, ? extends WitchOvenTileEntity> tileFactory, Properties properties) {
        super(tileFactory, properties);
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
            case NORTH:
                return NORTH_RAYTRACE_SHAPE;
            case SOUTH:
                return SOUTH_RAYTRACE_SHAPE;
            case WEST:
                return WEST_RAYTRACE_SHAPE;
            case EAST:
                return EAST_RAYTRACE_SHAPE;
            default:
                return BODY_SHAPE;
        }
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new WitchOvenTileEntity();
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        super.use(state, worldIn, pos, player, handIn, hit);
        if (worldIn.isClientSide) {
            return ActionResultType.SUCCESS;
        }

        TileEntity te = worldIn.getBlockEntity(pos);
        if (te instanceof INamedContainerExtraData){
            this.interactWith(worldIn, pos, player);
        }
        return ActionResultType.CONSUME;

    }

    private void interactWith(World worldIn, BlockPos pos, PlayerEntity player){
        TileEntity tileEntity = worldIn.getBlockEntity(pos);

        if(tileEntity instanceof WitchOvenTileEntity && player instanceof ServerPlayerEntity){
            WitchOvenTileEntity wo = (WitchOvenTileEntity) tileEntity;
            NetworkHooks.openGui((ServerPlayerEntity) player, wo, wo::encodeExtraData);
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }


    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if(!state.is(newState.getBlock())){
            TileEntity tileEntity = worldIn.getBlockEntity(pos);
            if(tileEntity instanceof IInventory){
                InventoryHelper.dropContents(worldIn, pos, (IInventory)tileEntity);
                worldIn.updateNeighborsAt(pos, this);
            }
            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
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
