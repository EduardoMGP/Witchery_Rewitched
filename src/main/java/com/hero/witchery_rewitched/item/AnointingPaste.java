package com.hero.witchery_rewitched.item;

import com.hero.witchery_rewitched.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;

import net.minecraft.item.Item.Properties;

public class AnointingPaste extends Item {
    public AnointingPaste(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        ItemStack item = context.getItemInHand();
        PlayerEntity player = context.getPlayer();
        if(world.getBlockState(context.getClickedPos()).is(Blocks.CAULDRON)) {
            world.setBlockAndUpdate(context.getClickedPos(), ModBlocks.WITCH_CAULDRON.get().defaultBlockState());
            if(item.getCount() - 1 != 0)
                player.setItemInHand(context.getHand(), new ItemStack(item.getItem(), item.getCount()-1));
            else
                player.setItemInHand(context.getHand(), ItemStack.EMPTY);

            return ActionResultType.PASS;
        }
        return super.useOn(context);
    }
}
