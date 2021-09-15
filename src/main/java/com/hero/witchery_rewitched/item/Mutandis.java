package com.hero.witchery_rewitched.item;

import com.hero.witchery_rewitched.init.ModBlocks;
import com.hero.witchery_rewitched.init.ModItems;
import com.hero.witchery_rewitched.init.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.data.TagsProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;

import net.minecraft.item.Item.Properties;

public class Mutandis extends Item {
    private final boolean extremis;
    public Mutandis(Properties properties, boolean extremis) {
        super(properties);
        this.extremis = extremis;
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        if(world.isClientSide)
            return ActionResultType.SUCCESS;
        ItemStack item = context.getItemInHand();
        PlayerEntity player = context.getPlayer();
        if(world.getBlockState(context.getClickedPos()).getBlock().is(ModTags.Blocks.MUTANDIS_PLANTS)){
            BlockState state = ModTags.Blocks.MUTANDIS_PLANTS.getValues().get(world.random.nextInt(ModTags.Blocks.MUTANDIS_PLANTS.getValues().size())).defaultBlockState();
            world.setBlockAndUpdate(context.getClickedPos(), state);
            if(world.getBlockState(context.getClickedPos()).getBlock() == ModBlocks.SPANISH_MOSS.get())
                world.setBlockAndUpdate(context.getClickedPos(), world.getBlockState(context.getClickedPos()).getBlockState().setValue(VineBlock.NORTH, true));
            if(item.getCount() - 1 != 0)
                player.setItemInHand(context.getHand(), new ItemStack(item.getItem(), item.getCount()-1));
            else
                player.setItemInHand(context.getHand(), ItemStack.EMPTY);

        }
        else if(extremis && world.getBlockState(context.getClickedPos()).getBlock().is(ModTags.Blocks.MUTANDIS_EXTREMIS_PLANTS)){
            BlockState state = ModTags.Blocks.MUTANDIS_PLANTS.getValues().get(world.random.nextInt(ModTags.Blocks.MUTANDIS_PLANTS.getValues().size())).defaultBlockState();
            world.setBlockAndUpdate(context.getClickedPos(), state);
            if(item.getCount() - 1 != 0)
                player.setItemInHand(context.getHand(), new ItemStack(item.getItem(), item.getCount()-1));
            else
                player.setItemInHand(context.getHand(), ItemStack.EMPTY);
        }
        else if(extremis && world.getBlockState(context.getClickedPos()).getBlock().is(Blocks.GRASS_BLOCK)){
            world.setBlockAndUpdate(context.getClickedPos(), Blocks.MYCELIUM.defaultBlockState());
            if(item.getCount() - 1 != 0)
                player.setItemInHand(context.getHand(), new ItemStack(item.getItem(), item.getCount()-1));
            else
                player.setItemInHand(context.getHand(), ItemStack.EMPTY);
        }
        else if(world.getBlockState(context.getClickedPos()).getBlock() == Blocks.DIRT){
            for(int x = -1; x < 2; x++){
                for(int y = -1; y < 2; y++){
                    for(int z = -1; z < 2; z++){
                        if((world.getBlockState(context.getClickedPos().offset(x,y,z)).getBlock() == Blocks.DIRT) && (world.getBlockState(context.getClickedPos().offset(x,y+1,z)).getBlock().defaultBlockState() == Blocks.WATER.defaultBlockState()))
                            world.setBlockAndUpdate(context.getClickedPos().offset(x,y,z), Blocks.CLAY.defaultBlockState());
                    }
                }
            }
            if(item.getCount() - 1 != 0)
                player.setItemInHand(context.getHand(), new ItemStack(item.getItem(), item.getCount()-1));
            else
                player.setItemInHand(context.getHand(), ItemStack.EMPTY);
        }
        return ActionResultType.SUCCESS;
    }
}
