package com.hero.witchery_rewitched.block.plants.water_artichoke;

import com.hero.witchery_rewitched.item.SeedItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.world.World;

import net.minecraft.item.Item.Properties;

public class WaterArtichokeSeed extends SeedItem {
    public WaterArtichokeSeed(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        BlockRayTraceResult blockraytraceresult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
        BlockRayTraceResult blockraytraceresult1 = blockraytraceresult.withPosition(blockraytraceresult.getBlockPos().above());
        ActionResultType actionresulttype = super.useOn(new ItemUseContext(playerIn, handIn, blockraytraceresult1));
        return new ActionResult<>(actionresulttype, playerIn.getItemInHand(handIn));
    }

    @Override
    protected boolean canPlace(BlockItemUseContext p_195944_1_, BlockState p_195944_2_) {
        return super.canPlace(p_195944_1_, p_195944_2_);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        return ActionResultType.SUCCESS;
    }

}
