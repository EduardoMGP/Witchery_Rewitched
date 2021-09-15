package com.hero.witchery_rewitched.init;

import com.hero.witchery_rewitched.block.INamedContainerExtraData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.function.BiFunction;

import net.minecraft.block.AbstractBlock.Properties;

public class ModContainerBlock<T extends TileEntity & INamedContainerExtraData> extends Block {

    private final BiFunction<BlockState, IBlockReader, ? extends T> tileFactory;

    public ModContainerBlock(BiFunction<BlockState, IBlockReader, ? extends T> tileFactory, Properties properties) {
        super(properties);
        this.tileFactory = tileFactory;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return tileFactory.apply(state, world);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity tile = worldIn.getBlockEntity(pos);
            if (tile instanceof IInventory) {
                InventoryHelper.dropContents(worldIn, pos, (IInventory) tile);
                worldIn.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (!worldIn.isClientSide) {
            TileEntity tile = worldIn.getBlockEntity(pos);
            if (tile instanceof INamedContainerExtraData && player instanceof ServerPlayerEntity) {
                INamedContainerExtraData te = (INamedContainerExtraData) tile;
                NetworkHooks.openGui((ServerPlayerEntity) player, te, te::encodeExtraData);
            }
        }
        return ActionResultType.SUCCESS;
    }


}
