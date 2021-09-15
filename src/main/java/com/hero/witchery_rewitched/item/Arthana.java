package com.hero.witchery_rewitched.item;

import com.hero.witchery_rewitched.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ActionResultType;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;

import net.minecraft.item.Item.Properties;

public class Arthana extends SwordItem {
    public Arthana(Properties builderIn) {
        super(new IItemTier() {
            @Override
            public int getUses() {
                return 250;
            }

            @Override
            public float getSpeed() {
                return 12;
            }

            @Override
            public float getAttackDamageBonus() {
                return 0;
            }

            @Override
            public int getLevel() {
                return 0;
            }

            @Override
            public int getEnchantmentValue() {
                return 22;
            }

            @Nonnull
            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(Items.GOLD_INGOT);
            }
        }, 3, -2.4F, builderIn);
    }

    @Nonnull
    @Override
    public ActionResultType useOn(ItemUseContext context) {
        if(context.getPlayer().isCrouching() && context.getItemInHand().getDamageValue() == 0){
            Block blockBelow = context.getLevel().getBlockState(context.getClickedPos().offset(0,0,0)).getBlock();
            if(context.getLevel().getBlockState(context.getClickedPos().offset(0,1,0)).getBlock() == Blocks.AIR && (blockBelow == ModBlocks.ALTAR.get())){
                context.getLevel().setBlockAndUpdate(context.getClickedPos().offset(0,1,0), ModBlocks.ARTHANA.get().defaultBlockState());
                context.getPlayer().setItemInHand(context.getHand(), ItemStack.EMPTY);
            }
        }
        return super.useOn(context);
    }
}
