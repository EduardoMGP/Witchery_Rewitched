package com.hero.witchery_rewitched.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;


import net.minecraft.item.Item.Properties;

public class SeedItem extends BlockItem implements IPlantable {
    public SeedItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items)
    {
        if(this.allowdedIn(group))
            items.add(new ItemStack(this));
    }

    @Override
    public String getDescriptionId()
    {
        return this.getOrCreateDescriptionId();
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos)
    {
        return ((IPlantable)this.getBlock()).getPlantType(world, pos);
    }

    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos)
    {
        return this.getBlock().defaultBlockState();
    }
}
