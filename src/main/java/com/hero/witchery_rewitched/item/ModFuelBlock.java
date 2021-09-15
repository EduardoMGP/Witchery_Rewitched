package com.hero.witchery_rewitched.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

import net.minecraft.item.Item.Properties;

public class ModFuelBlock extends BlockItem {
    private int burnTime;

    public ModFuelBlock(Block p_i48527_1_, Properties p_i48527_2_,int burnTime) {
        super(p_i48527_1_, p_i48527_2_);
        this.burnTime = burnTime;
    }


    @Override
    public int getBurnTime(ItemStack itemStack) {
        return burnTime;
    }
}
