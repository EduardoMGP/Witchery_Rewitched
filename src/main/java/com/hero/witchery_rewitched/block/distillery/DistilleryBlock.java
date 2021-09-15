package com.hero.witchery_rewitched.block.distillery;

import com.hero.witchery_rewitched.block.INamedContainerExtraData;
import com.hero.witchery_rewitched.block.witch_oven.WitchOvenTileEntity;
import com.hero.witchery_rewitched.init.ModContainerBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.client.audio.BiomeSoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.function.BiFunction;

import net.minecraft.block.AbstractBlock.Properties;

public class DistilleryBlock extends ModContainerBlock<DistilleryTileEntity> {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public DistilleryBlock(BiFunction<BlockState, IBlockReader, ? extends DistilleryTileEntity> tileFactory, Properties properties) {
        super(tileFactory, properties.noOcclusion().sound(SoundType.METAL).strength(4, 20).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(2));
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new DistilleryTileEntity();
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        super.use(state, worldIn, pos, player, hand, hit);
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
