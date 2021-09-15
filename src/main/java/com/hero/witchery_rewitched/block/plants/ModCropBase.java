package com.hero.witchery_rewitched.block.plants;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.fml.RegistryObject;

import java.util.EnumMap;
import java.util.Random;

public class ModCropBase extends BushBlock implements IGrowable{
    private final RegistryObject<Item> SEED;
    private final Block FARMLAND;

    public final static EnumProperty<EnumPlantAge> AGE = EnumProperty.create("age", EnumPlantAge.class);

    public ModCropBase(RegistryObject<Item> seed, Block farmland){
        super(AbstractBlock.Properties.of(Material.PLANT)
                .noOcclusion()
                .noCollission()
                .sound(SoundType.CROP)
                .noCollission()
                .strength(0)
                .randomTicks());

        SEED = seed;
        FARMLAND = farmland;
    }

    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {

    }



    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(AGE);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == FARMLAND;
    }

    private static final EnumMap<EnumPlantAge, VoxelShape> shapes = new EnumMap<>(EnumPlantAge.class);

    static
    {
        EnumPlantAge age = EnumPlantAge.AGE0;
        double div= 1.0/(getMaxAge().ordinal() + 2);
        for(int i = 0; i <= getMaxAge().ordinal(); i++)
        {
            double num = div * (age.ordinal() + 1) + (div *.5);
            shapes.put(age, VoxelShapes.create(
                    new AxisAlignedBB(0, 0, 0, 1, num , 1)
            ));
            age = age.next();
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return shapes.getOrDefault(state.getValue(AGE), VoxelShapes.block());
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        if(isClient)
            return true;
        return canGrow((ServerWorld)worldIn, pos, state);
    }

    public boolean canGrow(ServerWorld worldIn, BlockPos pos, BlockState state) {
        int light = worldIn.getBrightness(LightType.SKY, pos);
        int light2 = worldIn.getBrightness(LightType.BLOCK, pos);
        return light > 11 || light2 > 11 && state.getValue(AGE) != getMaxAge();
    }

    @SuppressWarnings("deprecation")
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (isValidBonemealTarget(worldIn, pos, state, worldIn.isClientSide)) {
            if (!worldIn.isAreaLoaded(pos, 1)) return;
            this.performBonemeal(worldIn, random, pos, state);
        }
    }

    @Override
    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        if(state.getValue(AGE) != getMaxAge())
        {
            EnumPlantAge age = state.getValue(AGE).next();
            worldIn.setBlockAndUpdate(pos, state.setValue(AGE, age));
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
        return new ItemStack(SEED.get());
    }

    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        return world.getBlockState(pos);
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.CROP;
    }

    public static EnumPlantAge getMaxAge(){return EnumPlantAge.AGE2;}
}
