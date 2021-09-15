package com.hero.witchery_rewitched.block.witch_cauldron;

import com.hero.witchery_rewitched.block.INamedContainerExtraData;
import com.hero.witchery_rewitched.init.ModContainerBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.BiFunction;

import net.minecraft.block.AbstractBlock.Properties;

public class WitchCauldronBlock extends ModContainerBlock<WitchCauldronTileEntity> {
    public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_CAULDRON;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty HAS_POTION_RECIPE = BooleanProperty.create("has_potion_recipe");
    public static final BooleanProperty HAS_CAULDRON_RECIPE = BooleanProperty.create("has_cauldron_recipe");

    public WitchCauldronBlock(BiFunction<BlockState, IBlockReader, ? extends WitchCauldronTileEntity> tileFactory, Properties properties) {
        super(tileFactory, properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LIT, false)
                .setValue(HAS_CAULDRON_RECIPE, false)
                .setValue(HAS_POTION_RECIPE, false)
                .setValue(LEVEL, 0));
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new WitchCauldronTileEntity();
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isClientSide) {
            return ActionResultType.SUCCESS;
        }

        TileEntity te = worldIn.getBlockEntity(pos);
        if (te instanceof INamedContainerExtraData){
            this.interactWith(worldIn, pos, player, handIn);
        }
        return ActionResultType.CONSUME;

    }

    private void interactWith(World worldIn, BlockPos pos, PlayerEntity player, Hand hand){
        TileEntity tileEntity =  worldIn.getBlockEntity(pos);
        Item held = player.getItemInHand(hand).getItem();

        if(tileEntity instanceof WitchCauldronTileEntity && player instanceof ServerPlayerEntity){
            WitchCauldronTileEntity te = (WitchCauldronTileEntity) tileEntity;
            if( held == Items.GLASS_BOTTLE){
                ItemStack newItem = te.getPotionRecipe();
                if(newItem != null){
                    if(te.takeWater(WitchCauldronTileEntity.POTION_TAKE_AMOUNT, true)){
                        InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY() + 1.5, pos.getZ(), newItem);
                        int count = player.getItemInHand(hand).getCount()-1;
                        if(count != 0)
                            player.setItemInHand(hand, new ItemStack(held, count));
                        else
                            player.setItemInHand(hand, ItemStack.EMPTY);
                        worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    }
                }
            }
            else if(held == Items.WATER_BUCKET)
            {
                if(!te.isFullLiquid() && !worldIn.isClientSide()) {
                    te.fill();
                    if(!player.abilities.instabuild)
                    {
                        player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                    }
                    worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
            }
            else if(player.getItemInHand(hand) == ItemStack.EMPTY)
            {
                te.empty();
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
    }

    public static void setLevel(World worldIn,float level, BlockPos pos, BlockState state){
        worldIn.setBlock(pos, state.setValue(LEVEL, MathHelper.floor(level * 3)) , 2);
    }

    public static void setLit(World worldIn,boolean lit, BlockPos pos, BlockState state){
        worldIn.setBlockAndUpdate(pos, state.setValue(LIT, lit));
    }
    public static void setHasPotionRecipe(World worldIn,boolean hasPotionRecipe, BlockPos pos, BlockState state){
        worldIn.setBlockAndUpdate(pos, state.setValue(HAS_POTION_RECIPE, hasPotionRecipe));
    }
    public static void setHasCauldronRecipe(World worldIn,boolean hasCauldronRecipe, BlockPos pos, BlockState state){
        worldIn.setBlockAndUpdate(pos, state.setValue(HAS_CAULDRON_RECIPE, hasCauldronRecipe));
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if(stateIn.getValue(LIT)){
            double x = (double)pos.getX() + (worldIn.random.nextInt(4) + 6.0)/16.0D;
            double y = (double)pos.getY() + getBubbleLevel(stateIn)/16.0D ;
            double z = (double)pos.getZ() + (worldIn.random.nextInt(4) + 6.0)/16.0D;
            // TODO: I need to create my own particles cause this shit don't work
            worldIn.addParticle(ParticleTypes.BUBBLE, x, y, z, 0.0D, 0.04D, 0.0D);
            // TODO: This should create particles when it is working properly
        }
    }

    public double getBubbleLevel(BlockState state){
        int level = state.getValue(LEVEL);
        switch(level){
            case 1:
                return 7D;
            case 2:
                return 10D;
            case 3:
                return 14D;
        }
        return 0;
    }

    @Override
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        TileEntity tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof WitchCauldronTileEntity) {
            ((WitchCauldronTileEntity)tileentity).onEntityCollision(entityIn);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if(!state.is(newState.getBlock())){
            TileEntity tileEntity = worldIn.getBlockEntity(pos);
            if(tileEntity instanceof IInventory){
                worldIn.updateNeighborsAt(pos, this);
                ((IInventory)tileEntity).setItem(WitchCauldronTileEntity.INVENTORY_SIZE-1, ItemStack.EMPTY);
            }
            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }


    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
        builder.add(LIT);
        builder.add(HAS_CAULDRON_RECIPE);
        builder.add(HAS_POTION_RECIPE);
    }
}
